package com.obric.cae.location.city;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.location.database.StarLocationDbManager;
import com.obric.cae.location.geosdk.bytedance.BdLocationManager;
import com.obric.cae.location.geosdk.poi.StarAoiBoardManager;
import com.obric.cae.location.report.StarLocationTeaReporter;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.location.util.PoiDslBuilder;
import com.obric.cae.log.CommSenseLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class MallGeoManager {
    private static final String KEY_MALL_AOI_BOARD = "mall_aoi_board";
    private static final String KEY_MALL_SEARCH_CITY = "mall_aoi_board_city";
    private static final String KEY_MALL_SEARCH_TYPE_LEGACY = "mall_aoi_board_type";
    private static final int MALL_AOI_BOARD_STATE_NO_RESULT = 2;
    private static final int MALL_AOI_BOARD_STATE_PENDING = 0;
    private static final int MALL_AOI_BOARD_STATE_SUCCESS = 1;
    private static final String MALL_PREF_NAME = "star_location_sp";
    private static final long MALL_RETRY_DELAY_MS = 5000;
    private static final String MALL_SEARCH_KEYWORD = "商场";
    private static final int MALL_SEARCH_MAX_REQUEST_COUNT = 50;
    private static final int MALL_SEARCH_PAGE_SIZE = 20;
    private static final String MALL_SEARCH_PEDESTRIAN_STREET_TYPE_CODE = "052202";
    private static final String MALL_SEARCH_TYPE_CODE = "052201";
    private static final String TAG = "StarLocation-mallGeo";
    private static volatile MallGeoManager sInstance;
    private final AtomicReference<String> mActiveMallCity;
    private final Context mAppContext;
    private final Handler mMainHandler;
    private ExecutorService mMallExecutor;
    private final CityAoiSyncRunner mMallSyncRunner;

    public static final class MallAoiQueryResult {
        final List<AoiBoard> aoiBoards;
        final Map<String, String> newTypeCodeL3ByPoiId;
        final boolean success;

        public MallAoiQueryResult(boolean r8, List<AoiBoard> r10, Map<String, String> r11) {
            this.success = r8;
            this.aoiBoards = r10;
            this.newTypeCodeL3ByPoiId = r11;
        }
    }

    public static final class MallPoiSearchResult {
        final List<BdLocationManager.MapPoiInfo> candidates;
        final Integer code;
        final String msg;
        final boolean success;

        public MallPoiSearchResult(boolean r8, List<BdLocationManager.MapPoiInfo> r10, Integer r11, String r12) {
            this.success = r8;
            this.candidates = r10;
            this.code = r11;
            this.msg = r12;
        }
    }

    private MallGeoManager(Context r11) {
        this.mActiveMallCity = new AtomicReference(null);
        Handler r8 = new Handler(Looper.getMainLooper());
        this.mMainHandler = r8;
        this.mAppContext = r11.getApplicationContext();
        this.mMallSyncRunner = new CityAoiSyncRunner(TAG, "mall", r8, 5000, new b(this), new c(this));
    }

    public static /* synthetic */ void a(MallGeoManager r8, String r10) {
        r8.tryLoadMallAoiBoardsIfNeeded(r10);
    }

    private StarAoiBoardManager aoiBoardManager() {
        return StarAoiBoardManager.getInstance(this.mAppContext, 0);
    }

    private void applyMallAoiBoardSearchState(String r8, int r10) {
        mallPrefs().edit().putString(KEY_MALL_SEARCH_CITY, r8).putInt(KEY_MALL_AOI_BOARD, r10).remove(KEY_MALL_SEARCH_TYPE_LEGACY).apply();
    }

    public static /* synthetic */ ExecutorService b(MallGeoManager r8) {
        return r8.mallExecutor();
    }

    private AoiBoard buildMallAoiBoard(BdLocationManager.MapPoiInfo r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        if (r8.poiId.isEmpty() == true) goto L14;
        String r10 = r8.aoiBoard;
        if (r10.isEmpty() == false) goto L12;
        CommSenseLog.vWithMethodName(TAG, "mall candidate missing geo_json, name=" + r8.name + ", poiId=" + r8.poiId);
        StarLocationTeaReporter.reportAoiMissing(r8.poiId, r8.name);
        return null;
    L12:
        return StarAoiBoardManager.buildAoiBoard(r8.poiId, r8.name, r10, AoiBoard.Type.MALL);
    L14:
        return null;
    }

    private Map<String, String> buildMallNewTypeCodeL3ByPoiId(List<BdLocationManager.MapPoiInfo> r8, Map<String, AoiBoard> r10) {
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator<BdLocationManager.MapPoiInfo> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L16;
        BdLocationManager.MapPoiInfo r13 = r12.next();
        if (r13 == null) goto L4;
        if (r13.poiId.isEmpty() == true) goto L4;
        if (r13.typeCode.isEmpty() == true) goto L4;
        if (r10.containsKey(r13.poiId) == false) goto L4;
        r11.put(r13.poiId, r13.typeCode);
        goto L4
    L16:
        return r11;
    }

    private static String buildMallSearchDsl(String r8) {
        return new PoiDslBuilder().addTerm("type_code", r8).build();
    }

    private void clearLegacyMallSearchTypeIfNeeded() {
        if (mallPrefs().contains(KEY_MALL_SEARCH_TYPE_LEGACY) == true) goto L5;
        return;
    L5:
        mallPrefs().edit().remove(KEY_MALL_SEARCH_TYPE_LEGACY).apply();
    }

    private void collectMallAoiBoards(Map<String, AoiBoard> r8, List<BdLocationManager.MapPoiInfo> r10) {
        Iterator<BdLocationManager.MapPoiInfo> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        AoiBoard r12 = buildMallAoiBoard(r11.next());
        if (r12 == null) goto L4;
        r8.put(r12.getPoiId(), r12);
        goto L4
    }

    private StarLocationDbManager dbManager() {
        return StarLocationDbManager.getInstance(this.mAppContext, 0);
    }

    private void ensureMallSearchStateForCity(String r8) {
        String r10 = mallPrefs().getString(KEY_MALL_SEARCH_CITY, "");
        if (r8.equals(r10) == false) goto L6;
        clearLegacyMallSearchTypeIfNeeded();
        return;
    L6:
        mallPrefs().edit().putString(KEY_MALL_SEARCH_CITY, r8).putInt(KEY_MALL_AOI_BOARD, 0).remove(KEY_MALL_SEARCH_TYPE_LEGACY).apply();
        CommSenseLog.iWithMethodName(TAG, "reset mall aoi search state, previousCity=" + r10 + ", currentCity=" + r8);
    }

    public static MallGeoManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(MallGeoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new MallGeoManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(MallGeoManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private int getMallAoiBoardSearchState() {
        return mallPrefs().getInt(KEY_MALL_AOI_BOARD, 0);
    }

    private boolean hasPreparedMallAoiBoards(String r8) {
        if (r8.equals(mallPrefs().getString(KEY_MALL_SEARCH_CITY, "")) == true) goto L5;
        return false;
    L5:
        int r10 = getMallAoiBoardSearchState();
        if (r10 != 0) goto L9;
        return false;
    L9:
        if (r10 != 2) goto L11;
        return true;
    L11:
        if (r10 == 1) goto L13;
        return false;
    L13:
        if (listMallAoiBoards().isEmpty() == false) goto L15;
        return false;
    L15:
        return true;
    }

    private List<AoiBoard> listMallAoiBoards() {
        return aoiBoardManager().queryAoiBoardsByType(AoiBoard.Type.MALL);
    }

    private synchronized ExecutorService mallExecutor() {
        monitor-enter(this);
        ExecutorService r8 = this.mMallExecutor;     // Catch: Throwable -> L13
        if (r8 != null) goto L6;
    L9:
        this.mMallExecutor = Executors.newSingleThreadExecutor();     // Catch: Throwable -> L13
    L10:
        ExecutorService r10 = this.mMallExecutor;     // Catch: Throwable -> L13
        monitor-exit(this);
        return r10;
    L6:
        if (r8.isShutdown() == true) goto L9;
        if (this.mMallExecutor.isTerminated() == false) goto L10;
    L13:
        th = move-exception;
        throw th;
    }

    private SharedPreferences mallPrefs() {
        return this.mAppContext.getSharedPreferences(MALL_PREF_NAME, 0);
    }

    private MallAoiQueryResult queryMallAoiBoards(String r8) {
        MallPoiSearchResult r10 = searchMallPoiCandidates(r8);
        if (r10.success == true) goto L7;
        return new MallAoiQueryResult(false, new ArrayList(), Collections.emptyMap());
    L7:
        if (r10.candidates.isEmpty() == true) goto L9;
        LinkedHashMap r11 = new LinkedHashMap();
        collectMallAoiBoards(r11, r10.candidates);
        if (r11.isEmpty() == false) goto L15;
        CommSenseLog.wWithMethodName(TAG, "mall search returned candidates but no valid aoi boards, city=" + r8);
        return new MallAoiQueryResult(true, new ArrayList(), Collections.emptyMap());
    L15:
        return new MallAoiQueryResult(true, new ArrayList(r11.values()), buildMallNewTypeCodeL3ByPoiId(r10.candidates, r11));
    L9:
        return new MallAoiQueryResult(true, new ArrayList(), Collections.emptyMap());
    }

    private boolean reloadMallDataForCity(String r8) {
        if (LocationUtil.getInstance().isNetworkValid() == true) goto L6;
        CommSenseLog.wWithMethodName(TAG, "skip reloadMallDataForCity: network invalid, city=" + r8);
        return false;
    L6:
        MallAoiQueryResult r10 = queryMallAoiBoards(r8);
        if (r10.success == true) goto L10;
        scheduleRetryLoadMallAoiBoards();
        return false;
    L10:
        boolean r11 = aoiBoardManager().replaceAoiBoardsByTypes(Collections.singleton(AoiBoard.Type.MALL), r10.aoiBoards);
        StringBuilder r12 = defpackage.b.h("reloadMallDataForCity city=", r8, ", mallAoiBoardCount=");
        r12.append(r10.aoiBoards.size());
        r12.append(", saved=");
        r12.append(r11);
        CommSenseLog.dWithMethodName(TAG, r12.toString());
        if (r11 == false) goto L17;
        StringBuilder r13 = defpackage.b.f("mall new_type_code_l3 saved count=", dbManager().updateAoiBoardNewTypeCodeL3s(r10.newTypeCodeL3ByPoiId), ", parsed count=");
        r13.append(r10.newTypeCodeL3ByPoiId.size());
        CommSenseLog.iWithMethodName(TAG, r13.toString());
        if (r10.aoiBoards.isEmpty() == false) goto L15;
        int r14 = 2;
    L16:
        applyMallAoiBoardSearchState(r8, r14);
        this.mActiveMallCity.set(r8);
        goto L17
    L15:
        r14 = 1;
    L17:
        return r11;
    }

    private String resolveCityFromAddress(Address r8) {
        String r10 = r8.getSubAdminArea();
        if (r10 != null) goto L5;
    L7:
        String r11 = r8.getLocality();
        if (r11 != null) goto L10;
    L12:
        String r12 = r8.getSubLocality();
        if (r12 == null) goto L18;
        if (r12.isEmpty() == true) goto L18;
        return r12;
    L18:
        return r8.getAdminArea();
    L10:
        if (r11.isEmpty() == true) goto L12;
        return r11;
    L5:
        if (r10.isEmpty() == true) goto L7;
        return r10;
    }

    private String resolveTargetCity(String r8) {
        if (r8 != null) goto L4;
    L6:
        StarLocationDbManager.CityInfo r10 = dbManager().getCityInfo();
        if (r10 != null) goto L10;
        return null;
    L10:
        String r11 = r10.subAdminArea;
        if (r11 != null) goto L13;
    L16:
        String r12 = r10.locality;
        if (r12 != null) goto L19;
    L22:
        String r13 = r10.subLocality;
        if (r13 == null) goto L29;
        if (r13.isEmpty() == true) goto L29;
        return r10.subLocality;
    L29:
        return r10.adminArea;
    L19:
        if (r12.isEmpty() == true) goto L22;
        return r10.locality;
    L13:
        if (r11.isEmpty() == true) goto L16;
        return r10.subAdminArea;
    L4:
        if (r8.isEmpty() == true) goto L6;
        return r8;
    }

    private void scheduleRetryLoadMallAoiBoards() {
        this.mMallSyncRunner.scheduleRetry();
    }

    private MallPoiSearchResult searchMallPoiCandidates(String r8) {
        LinkedHashMap<String, BdLocationManager.MapPoiInfo> r10 = new LinkedHashMap();
        MallPoiSearchResult r11 = searchMallPoiCandidatesByTypeCode(r8, MALL_SEARCH_TYPE_CODE, r10);
        if (r11.success == true) goto L5;
        return r11;
    L5:
        MallPoiSearchResult r12 = searchMallPoiCandidatesByTypeCode(r8, MALL_SEARCH_PEDESTRIAN_STREET_TYPE_CODE, r10);
        if (r12.success == true) goto L9;
        return r12;
    L9:
        return new MallPoiSearchResult(true, new ArrayList(r10.values()), r12.code, r12.msg);
    }

    private MallPoiSearchResult searchMallPoiCandidatesByTypeCode(String r17, String r18, LinkedHashMap<String, BdLocationManager.MapPoiInfo> r19) {
        String r10 = buildMallSearchDsl(r18);
        int r11 = r19.size();
        Integer r8 = null;
        int r12 = 1;
        String r13 = null;
    L4:
        if (r12 > 50) goto L36;
        StringBuilder r14 = defpackage.b.i("mall request: keyword=商场, typeCode=", r18, ", city=", r17, ", pageNum=");
        r14.append(r12);
        r14.append(", pageSize=20");
        CommSenseLog.dWithMethodName(TAG, r14.toString());
        BdLocationManager.MapPoiTextSearchResult r15 = BdLocationManager.getInstance().searchMapPoiTextResult(MALL_SEARCH_KEYWORD, r12, 20, r17, r10);
        Integer r16 = r15.code;
        String r20 = r15.msg;
        if (r15.success == false) goto L7;
        int r21 = r15.items.size();
        if (r21 <= 0) goto L11;
        Iterator<BdLocationManager.MapPoiInfo> r22 = r15.items.iterator();
        int r110 = 0;
    L14:
        if (r22.hasNext() == false) goto L24;
        BdLocationManager.MapPoiInfo r111 = r22.next();
        Iterator<BdLocationManager.MapPoiInfo> r112 = r22;
        if (r111 == null) goto L23;
        if (r111.poiId.isEmpty() == true) goto L23;
        if (r19.containsKey(r111.poiId) == true) goto L23;
        r19.put(r111.poiId, r111);
        r110 = r110 + 1;
    L23:
        r22 = r112;
        goto L14
    L24:
        StringBuilder r23 = new StringBuilder("mall page result size=");
        r23.append(r21);
        r23.append(", typeCode=");
        r23.append(r18);
        r23.append(", pageNum=");
        Integer r113 = r16;
        defpackage.b.q(r23, r12, ", addedCount=", r110, ", typeCount=");
        r23.append(r19.size() - r11);
        r23.append(", totalCount=");
        r23.append(r19.size());
        CommSenseLog.dWithMethodName(TAG, r23.toString());
        if (r21 < 20) goto L26;
        if (r110 <= 0) goto L28;
        if (r12 != 50) goto L34;
        CommSenseLog.wWithMethodName(TAG, "mall search reaches max page count, city=" + r17 + ", typeCode=" + r18 + ", maxPageCount=50");
    L34:
        r12 = r12 + 1;
        r8 = r113;
        r13 = r20;
        goto L4
    L28:
        StringBuilder r24 = new StringBuilder("mall page has no new candidate for city=");
    L29:
        r24.append(r17);
        r24.append(", typeCode=");
        r24.append(r18);
        r24.append(", pageNum=");
        r24.append(r12);
        r24.append(", stop paging");
    L30:
        CommSenseLog.dWithMethodName(TAG, r24.toString());
        r8 = r113;
        r13 = r20;
        goto L36
    L26:
        r24 = new StringBuilder("mall partial page for city=");
        goto L29
    L11:
        r24 = defpackage.b.i("mall result size=0 for city=", r17, ", typeCode=", r18, ", pageNum=");
        r24.append(r12);
        r24.append(", stop paging, typeCount=");
        r24.append(r19.size() - r11);
        r24.append(", totalCount=");
        r24.append(r19.size());
        r113 = r16;
        goto L30
    L7:
        StringBuilder r25 = defpackage.b.i("mall search failed, city=", r17, ", typeCode=", r18, ", pageNum=");
        r25.append(r12);
        r25.append(", code=");
        r25.append(r15.code);
        r25.append(", msg=");
        r25.append(r15.msg);
        CommSenseLog.wWithMethodName(TAG, r25.toString());
        return new MallPoiSearchResult(false, new ArrayList(), r16, r20);
    L36:
        return new MallPoiSearchResult(true, new ArrayList(r19.values()), r8, r13);
    }

    private void tryLoadMallAoiBoardsIfNeeded(String r8) {
    L30:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, WsConstants.KEY_CONNECTION_ERROR, th);     // Catch: Throwable -> L35
        if (0 == 0) goto L46;
    L33:
        this.mMallSyncRunner.finishWork();
        return;
    L46:
        return;
    L35:
        th = move-exception;
        if (0 == 0) goto L38;
        this.mMallSyncRunner.finishWork();
    L38:
        throw th;
    L4:
        if (aoiBoardManager().isRecoveryFinished() == true) goto L7;
        CommSenseLog.dWithMethodName(TAG, "skip: aoi board recovery not finished");     // Catch: Throwable -> L30
        scheduleRetryLoadMallAoiBoards();     // Catch: Throwable -> L30
        return;
    L7:
        boolean r10 = this.mMallSyncRunner.beginWork();     // Catch: Throwable -> L30
        if (r10 == true) goto L12;
        if (r10 == false) goto L42;
        this.mMallSyncRunner.finishWork();
        return;
    L42:
        return;
    L12:
        String r11 = resolveTargetCity(r8);     // Catch: Throwable -> L30
        if (r11 != null) goto L15;
    L26:
        CommSenseLog.dWithMethodName(TAG, "skip: target city empty");     // Catch: Throwable -> L30
        if (r10 == false) goto L44;
        this.mMallSyncRunner.finishWork();
        return;
    L44:
        return;
    L15:
        if (r11.isEmpty() == true) goto L26;
        ensureMallSearchStateForCity(r11);     // Catch: Throwable -> L30
        if (hasPreparedMallAoiBoards(r11) == false) goto L23;
        this.mActiveMallCity.set(r11);     // Catch: Throwable -> L30
        if (r10 == false) goto L43;
        this.mMallSyncRunner.finishWork();
        return;
    L43:
        return;
    L23:
        reloadMallDataForCity(r11);     // Catch: Throwable -> L30
        if (r10 == true) goto L33;
    }

    public void checkAndLoadMallAoiBoards() {
        checkAndLoadMallAoiBoards(null);
    }

    public void destroy() {
        this.mMallSyncRunner.destroy();
        monitor-enter(this);
        ExecutorService r8 = this.mMallExecutor;     // Catch: Throwable -> L11
        if (r8 != null) goto L17;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L17:
        r8.shutdownNow();     // Catch: Throwable -> L14
    L8:
        this.mMallExecutor = null;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void onAddressResolved(Address r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        String r10 = resolveCityFromAddress(r8);
        if (r10 != null) goto L7;
    L11:
        CommSenseLog.dWithMethodName(TAG, "skip: city is empty");
        return;
    L7:
        if (r10.isEmpty() == true) goto L11;
        checkAndLoadMallAoiBoards(r10);
    }

    public void onCityStorageChanged(String r8, boolean r10) {
        if (r8.isEmpty() == false) goto L6;
        return;
    L6:
        if (r10 == true) goto L8;
    L10:
        boolean r11 = false;
    L11:
        if (r11 == false) goto L13;
        applyMallAoiBoardSearchState(r8, 1);
        this.mActiveMallCity.set(r8);
    L14:
        CommSenseLog.dWithMethodName(TAG, "city=" + r8 + ", restoredFromArchive=" + r10 + ", hasRestoredMallAoiBoards=" + r11);
        return;
    L13:
        mallPrefs().edit().putString(KEY_MALL_SEARCH_CITY, r8).putInt(KEY_MALL_AOI_BOARD, 0).remove(KEY_MALL_SEARCH_TYPE_LEGACY).apply();
        this.mActiveMallCity.set(null);
        goto L14
    L8:
        if (listMallAoiBoards().isEmpty() == true) goto L10;
        r11 = true;
        goto L11
    }

    public void onServiceStarted() {
        String r8 = resolveTargetCity(null);
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.isEmpty() == true) goto L10;
        checkAndLoadMallAoiBoards(r8);
        return;
    }

    private void checkAndLoadMallAoiBoards(String r8) {
        this.mMallSyncRunner.request(r8);
    }
}
