package com.obric.cae.location.cell;

import android.content.Context;
import android.database.Cursor;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.appcompat.app.r;
import com.obric.cae.libs.location.CoordinateTransformUtils;
import com.obric.cae.location.StarLocationManager;
import com.obric.cae.location.database.StarCellDbManager;
import com.obric.cae.location.geosdk.bytedance.BdLocationManager;
import com.obric.cae.location.geosdk.poi.StarAoiBoardManager;
import com.obric.cae.location.geosdk.poi.StarPoiManager;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class StarCellManager {
    public static final Set<String> INTERESTED_NEW_TYPE_CODE_L1 = null;
    public static final Set<String> INTERESTED_NEW_TYPE_CODE_L2 = null;
    public static final Set<String> INTERESTED_NEW_TYPE_CODE_L3 = null;
    private static final long INVALID_LONG_VALUE = Long.MAX_VALUE;
    private static final int INVALID_VALUE = Integer.MAX_VALUE;
    public static final Set<String> MALL_NEW_TYPE_CODE_L3 = null;
    private static final double NEAR_CELL_REFRESH_DISTANCE_THRESHOLD_METERS = 500.0d;
    private static final long REQUEST_CELL_INFO_UPDATE_DELAY_MS = 30000;
    private static final String TAG = "StarLocation-cell";
    private static volatile StarCellManager sInstance;
    private final Context mAppContext;
    private final StarCellDbManager mCellDbManager;
    private final Object mCellLock;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private final InnerAwareInfoCallback mInnerAwareInfoCallback;
    private boolean mIsCellAreaQueried;
    private boolean mIsListening;
    private Location mLastNearCellRefreshLocation;
    private final Set<CellCallback> mNeighborCellCallbacks;
    private List<StarCellInfo> mNeighborCellInfos;
    private StarCellInfo mPendingCellAreaQueryInfo;
    private Runnable mRequestCellInfoUpdateRunnable;
    private final Set<CellCallback> mServingCellCallbacks;
    private StarCellInfo mServingCellInfo;
    private CellInfoTelephonyCallback mTelephonyCallback;
    private final TelephonyManager mTelephonyManager;
    private final WwanSensorService mWwanSensorService;

    public interface CellCallback {
        void onCellInfoChanged(List<StarCellInfo> r8);
    }

    public final class CellInfoTelephonyCallback extends TelephonyCallback implements TelephonyCallback.CellInfoListener {
        final /* synthetic */ StarCellManager this$0;

        private CellInfoTelephonyCallback(StarCellManager r8) {
            this.this$0 = r8;
        }

        @Override // android.telephony.TelephonyCallback.CellInfoListener
        public void onCellInfoChanged(List<CellInfo> r8) {
            StarCellManager.access$300(this.this$0, r8);
        }

        public /* synthetic */ CellInfoTelephonyCallback(StarCellManager r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public static final class StarCellInfo {
        public static final String TYPE_CDMA = "cdma";
        public static final String TYPE_GSM = "gsm";
        public static final String TYPE_LTE = "lte";
        public static final String TYPE_NR = "nr";
        public static final String TYPE_TDSCDMA = "tdscdma";
        public static final String TYPE_WCDMA = "wcdma";
        private final long mCid;
        private final int mDbm;
        private final long mLac;
        private final double mLatitude;
        private final double mLongitude;
        private final String mMcc;
        private final String mMnc;
        private final double mRadius;
        private final boolean mRegistered;
        private final long mTimestampMillis;
        private final String mType;

        private StarCellInfo(String r19, String r20, String r21, long r22, long r24, int r26, boolean r27, long r28) {
            this(r19, r20, r21, r22, r24, r26, r27, r28, -1.0d, -1.0d, -1.0d);
        }

        public static /* synthetic */ StarCellInfo access$400(CellInfo r8) {
            return fromCellInfo(r8);
        }

        public static /* synthetic */ boolean access$500(StarCellInfo r8) {
            return r8.isValidIdentity();
        }

        public static /* synthetic */ boolean access$600(StarCellInfo r8) {
            return r8.hasValidLocation();
        }

        public static /* synthetic */ StarLocationManager.LocationSource access$700(StarCellInfo r8) {
            return r8.toLocationSource();
        }

        private static StarCellInfo fromCellInfo(CellInfo r15) {
            if (r15 != null) goto L6;
            return null;
        L6:
            if ((r15 instanceof CellInfoGsm) == false) goto L10;
            CellInfoGsm r8 = (CellInfoGsm) r15;
            CellIdentityGsm r10 = r8.getCellIdentity();
            return new StarCellInfo("gsm", r10.getMccString(), r10.getMncString(), r10.getLac(), r10.getCid(), getDbm(r8.getCellSignalStrength()), r15.isRegistered(), getTimestampMillis(r15));
        L10:
            if ((r15 instanceof CellInfoWcdma) == false) goto L14;
            CellInfoWcdma r11 = (CellInfoWcdma) r15;
            CellIdentityWcdma r12 = r11.getCellIdentity();
            return new StarCellInfo("wcdma", r12.getMccString(), r12.getMncString(), r12.getLac(), r12.getCid(), getDbm(r11.getCellSignalStrength()), r15.isRegistered(), getTimestampMillis(r15));
        L14:
            if ((r15 instanceof CellInfoTdscdma) == false) goto L18;
            CellInfoTdscdma r13 = (CellInfoTdscdma) r15;
            CellIdentityTdscdma r14 = r13.getCellIdentity();
            return new StarCellInfo(TYPE_TDSCDMA, r14.getMccString(), r14.getMncString(), r14.getLac(), r14.getCid(), getDbm(r13.getCellSignalStrength()), r15.isRegistered(), getTimestampMillis(r15));
        L18:
            if ((r15 instanceof CellInfoLte) == false) goto L22;
            CellInfoLte r16 = (CellInfoLte) r15;
            CellIdentityLte r17 = r16.getCellIdentity();
            return new StarCellInfo("lte", r17.getMccString(), r17.getMncString(), r17.getTac(), r17.getCi(), getDbm(r16.getCellSignalStrength()), r15.isRegistered(), getTimestampMillis(r15));
        L22:
            if ((r15 instanceof CellInfoNr) == false) goto L26;
            CellInfoNr r18 = (CellInfoNr) r15;
            CellIdentityNr r19 = (CellIdentityNr) r18.getCellIdentity();
            return new StarCellInfo("nr", r19.getMccString(), r19.getMncString(), r19.getTac(), r19.getNci(), getDbm(r18.getCellSignalStrength()), r15.isRegistered(), getTimestampMillis(r15));
        L26:
            if ((r15 instanceof CellInfoCdma) == false) goto L29;
            CellInfoCdma r20 = (CellInfoCdma) r15;
            CellIdentityCdma r21 = r20.getCellIdentity();
            return new StarCellInfo("cdma", "-1", String.valueOf(normalizeInt(r21.getSystemId())), r21.getNetworkId(), r21.getBasestationId(), getDbm(r20.getCellSignalStrength()), r15.isRegistered(), getTimestampMillis(r15));
        L29:
            return null;
        }

        private boolean hasValidLocation() {
            double r8 = this.mRadius;
            if (r8 > 0.0d) goto L5;
        L9:
            return false;
        L5:
            if (r8 > 3.4028234663852886E38d) goto L9;
            if (LocationUtil.getInstance().isValidCoordinate(this.mLatitude, this.mLongitude) == false) goto L9;
            return true;
        }

        private boolean isValidIdentity() {
            if (TextUtils.isEmpty(this.mType) == false) goto L5;
        L19:
            return false;
        L5:
            if (TextUtils.equals("-1", this.mType) == true) goto L19;
            if (TextUtils.isEmpty(this.mMcc) == true) goto L19;
            if (TextUtils.equals("-1", this.mMcc) == true) goto L19;
            if (TextUtils.isEmpty(this.mMnc) == true) goto L19;
            if (TextUtils.equals("-1", this.mMnc) == true) goto L19;
            if (this.mLac == (-1)) goto L19;
            if (this.mCid == (-1)) goto L19;
            return true;
        }

        private static double normalizeDouble(double r8) {
            if (Double.isNaN(r8) == false) goto L5;
        L6:
            return -1.0d;
        L5:
            if (Double.isInfinite(r8) == true) goto L6;
            return r8;
        }

        private static int normalizeInt(int r8) {
            if (r8 != Integer.MAX_VALUE) goto L6;
            return -1;
        L6:
            return r8;
        }

        private static long normalizeLong(long r8) {
            if (r8 != 2147483647L) goto L5;
        L6:
            return -1;
        L5:
            if (r8 == StarCellManager.INVALID_LONG_VALUE) goto L6;
            return r8;
        }

        private static String normalizeMnc(String r8) {
            String r10 = normalizeString(r8);
            if (TextUtils.equals("-1", r10) == false) goto L8;
            return r10;
        L8:
            return String.valueOf(Integer.parseInt(r10));
        L10:
            return r10;
        }

        private static String normalizeString(String r8) {
            if (TextUtils.isEmpty(r8) == false) goto L6;
            return "-1";
        L6:
            return r8;
        }

        private StarLocationManager.LocationSource toLocationSource() {
            long r8 = System.currentTimeMillis();
            LocationUtil r10 = LocationUtil.getInstance();
            Bundle r11 = new Bundle();
            r11.putString("cellId", toCellString());
            return new StarLocationManager.LocationSource().setSource(6).setProvider("cell").setUpdateTs(r8).setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos()).setLocationTime(r8).setLatitude(this.mLatitude).setLongitude(this.mLongitude).setRadius((float) this.mRadius).setCoordSys(CoordinateTransformUtils.CoordinateSystem.WGS84).setConfidence(4).setSimReady(r10.isSimReady()).setWifiConnected(r10.isWifiConnected()).setExtra(r11).setUserId(0);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof StarCellInfo) == true) goto L8;
            return false;
        L8:
            StarCellInfo r10 = (StarCellInfo) r8;
            if (this.mLac != r10.mLac) goto L20;
            if (this.mCid != r10.mCid) goto L20;
            if (TextUtils.equals(this.mType, r10.mType) == false) goto L20;
            if (TextUtils.equals(this.mMcc, r10.mMcc) == false) goto L20;
            if (TextUtils.equals(this.mMnc, r10.mMnc) == false) goto L20;
            return true;
        L20:
            return false;
        }

        public long getCid() {
            return this.mCid;
        }

        public int getDbm() {
            return this.mDbm;
        }

        public long getLac() {
            return this.mLac;
        }

        public double getLatitude() {
            return this.mLatitude;
        }

        public double getLongitude() {
            return this.mLongitude;
        }

        public String getMcc() {
            return this.mMcc;
        }

        public String getMnc() {
            return this.mMnc;
        }

        public double getRadius() {
            return this.mRadius;
        }

        public long getTimestampMillis() {
            return this.mTimestampMillis;
        }

        public String getType() {
            return this.mType;
        }

        public int hashCode() {
            int r8 = this.mType.hashCode() * 31;
            int r10 = defpackage.a.b(this.mMcc, r8, 31);
            int r11 = defpackage.a.b(this.mMnc, r10, 31);
            long r12 = this.mLac;
            int r13 = (r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31;
            long r14 = this.mCid;
            return r13 + ((int) (r14 ^ (r14 >>> 32)));
        }

        public boolean isRegistered() {
            return this.mRegistered;
        }

        public String toCellString() {
            return this.mType + BdimCategoryConstants.SEPARATOR_COLON + this.mMcc + BdimCategoryConstants.SEPARATOR_COLON + this.mMnc + BdimCategoryConstants.SEPARATOR_COLON + this.mLac + BdimCategoryConstants.SEPARATOR_COLON + this.mCid;
        }

        public String toString() {
            return "StarCellInfo[cell=" + toCellString() + ", dbm=" + this.mDbm + ", registered=" + this.mRegistered + ", timestampMillis=" + this.mTimestampMillis + ", latitude=" + this.mLatitude + ", longitude=" + this.mLongitude + ", radius=" + this.mRadius + ']';
        }

        public StarCellInfo withLocation(double r21, double r23, double r25) {
            return new StarCellInfo(this.mType, this.mMcc, this.mMnc, this.mLac, this.mCid, this.mDbm, this.mRegistered, this.mTimestampMillis, r21, r23, r25);
        }

        private StarCellInfo(String r8, String r10, String r11, long r12, long r13, int r14, boolean r15, long r16, double r17, double r18, double r19) {
            this.mType = r8;
            this.mMcc = normalizeString(r10);
            this.mMnc = normalizeMnc(r11);
            this.mLac = normalizeLong(r12);
            this.mCid = normalizeLong(r13);
            this.mDbm = normalizeInt(r14);
            this.mRegistered = r15;
            this.mTimestampMillis = r16;
            this.mLatitude = normalizeDouble(r17);
            this.mLongitude = normalizeDouble(r18);
            this.mRadius = normalizeDouble(r19);
        }

        private static int getDbm(CellSignalStrength r8) {
            if (r8 != null) goto L5;
            return -1;
        L5:
            return normalizeInt(r8.getDbm());
        }

        private static long getTimestampMillis(CellInfo r8) {
            if (r8.getTimestampMillis() > 0) goto L6;
            return 0;
        L6:
            return r8.getTimestampMillis();
        }
    }

    static {
        INTERESTED_NEW_TYPE_CODE_L1 = ConcurrentHashMap.newKeySet();
        INTERESTED_NEW_TYPE_CODE_L2 = ConcurrentHashMap.newKeySet();
        ConcurrentHashMap.KeySetView r8 = ConcurrentHashMap.newKeySet();
        INTERESTED_NEW_TYPE_CODE_L3 = r8;
        ConcurrentHashMap.KeySetView r10 = ConcurrentHashMap.newKeySet();
        MALL_NEW_TYPE_CODE_L3 = r10;
        r10.add("011901");
        r10.add("052201");
        r10.add("052202");
        r8.addAll(r10);
    }

    private StarCellManager(Context r8) {
        this.mCellLock = new Object();
        this.mServingCellCallbacks = new CopyOnWriteArraySet();
        this.mNeighborCellCallbacks = new CopyOnWriteArraySet();
        this.mInnerAwareInfoCallback = new AnonymousClass1(this);
        this.mNeighborCellInfos = Collections.emptyList();
        this.mIsCellAreaQueried = true;
        CommSenseLog.iWithMethodName(TAG, "StarCellManager constructor");
        Context r10 = r8.getApplicationContext();
        this.mAppContext = r10;
        this.mTelephonyManager = (TelephonyManager) r10.getSystemService("phone");
        StarCellDbManager r11 = StarCellDbManager.getInstance(r10);
        this.mCellDbManager = r11;
        r11.initRfsDb();
        this.mWwanSensorService = new WwanSensorService(new d(this));
    }

    public static /* synthetic */ void a(StarCellManager r8, int r10, int r11, int r12, int r13, long r14, int r15) {
        r8.onWwanCellPoiStatusChange(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ void access$000(StarCellManager r8) {
        r8.retryPendingCellAreaQuery();
    }

    public static /* synthetic */ void access$100(StarCellManager r8, Location r10) {
        r8.maybeRefreshNearCellDbOnLocationChanged(r10);
    }

    public static /* synthetic */ void access$300(StarCellManager r8, List r10) {
        r8.updateCellInfo(r10);
    }

    public static /* synthetic */ void b(StarCellManager r8, Executor r10) {
        r8.lambda$scheduleRequestCellInfoUpdate$1(r10);
    }

    public static /* synthetic */ void c(StarCellManager r8, Runnable r10) {
        r8.lambda$startListen$0(r10);
    }

    private void cancelRequestCellInfoUpdate() {
        Handler r8 = this.mHandler;
        if (r8 == null) goto L7;
        Runnable r10 = this.mRequestCellInfoUpdateRunnable;
        if (r10 == null) goto L7;
        r8.removeCallbacks(r10);
    L7:
        this.mRequestCellInfoUpdateRunnable = null;
    }

    private void clearRegisteredCallbacks() {
        cancelRequestCellInfoUpdate();     // Catch: Throwable -> L9
        UserAwareManager.getInstance().unregisterInnerCallback(this.mInnerAwareInfoCallback);     // Catch: Throwable -> L9
        TelephonyManager r8 = this.mTelephonyManager;     // Catch: Throwable -> L9
        if (r8 == null) goto L17;
        CellInfoTelephonyCallback r10 = this.mTelephonyCallback;     // Catch: Throwable -> L9
        if (r10 == null) goto L17;
        r8.unregisterTelephonyCallback(r10);     // Catch: Throwable -> L9
    L17:
        this.mWwanSensorService.stop();     // Catch: Throwable -> L13
    L15:
        this.mTelephonyCallback = null;
        this.mIsListening = false;
        return;
    L13:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "stop wwan sensor service failed", th);
    L9:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "clear registered callbacks failed", th);
        goto L17
    }

    private void dumpCellInfoToPoiLog(StarCellInfo r8) {
        StarAoiBoardManager.getInstance(this.mAppContext, 0).dumpPoiLog(r8.toString());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "dump cell info to poi log failed: " + r8.toCellString(), th);
    }

    private void ensureHandlerLocked() {
        if (this.mHandlerThread != null) goto L5;
    L7:
        HandlerThread r8 = new HandlerThread("StarCellManager");
        this.mHandlerThread = r8;
        r8.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        return;
    L5:
        if (this.mHandler == null) goto L7;
    }

    private String formatCellInfoList(List<StarCellInfo> r8) {
        if (r8.isEmpty() == false) goto L6;
        return "[]";
    L6:
        StringBuilder r10 = new StringBuilder("[");
        int r11 = 0;
    L8:
        if (r11 >= r8.size()) goto L12;
        if (r11 <= 0) goto L11;
        r10.append(", ");
    L11:
        r10.append(r8.get(r11).toCellString());
        r11 = r11 + 1;
        goto L8
    L12:
        r10.append(']');
        return r10.toString();
    }

    private List<StarCellInfo> getAddedCellInfos(List<StarCellInfo> r8, List<StarCellInfo> r10) {
        if (r10.isEmpty() == true) goto L5;
        ArrayList r11 = new ArrayList();
        Iterator<StarCellInfo> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        StarCellInfo r13 = r12.next();
        if (r8.contains(r13) == true) goto L8;
        r11.add(r13);
        goto L8
    L12:
        return r11;
    L5:
        return Collections.emptyList();
    }

    private double getDistanceFromLastNearCellRefreshLocation(Location r10) {
        Object r8 = this.mCellLock;
        monitor-enter(r8);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mLastNearCellRefreshLocation != null) goto L7;
        Location r11 = null;
    L8:
        monitor-exit(r8);     // Catch: Throwable -> L14
        if (r11 != null) goto L13;
        return -1.0d;
    L13:
        return LocationUtil.getInstance().calculateDistance(r11.getLatitude(), r11.getLongitude(), r10.getLatitude(), r10.getLongitude());
    L7:
        r11 = new Location(this.mLastNearCellRefreshLocation);     // Catch: Throwable -> L14
        goto L8
    }

    private double getDoubleFromCursor(Cursor r8, String r10) {
        int r11 = r8.getColumnIndex(r10);
        if (r11 >= 0) goto L5;
        return -1.0d;
    L5:
        if (r8.isNull(r11) == false) goto L8;
        return -1.0d;
    L8:
        return r8.getDouble(r11);
    }

    public static synchronized StarCellManager getInstance(Context r8) {
        monitor-enter(StarCellManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new StarCellManager(r8);     // Catch: Throwable -> L10
    L7:
        StarCellManager r10 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(StarCellManager.class);
        return r10;
    }

    private void insertCellInfo(StarCellInfo r10) {
        StarCellDbManager.InnerCellInfoEntry r8 = new StarCellDbManager.InnerCellInfoEntry(r10.getType(), r10.getMcc(), r10.getMnc(), r10.getLac(), r10.getCid());
        StringBuilder r11 = android.aimedia.a.l("insert cell info, inserted=", this.mCellDbManager.insertOrReplaceCellInfo(r8), ", cell=");
        r11.append(r10.toCellString());
        CommSenseLog.dWithMethodName(TAG, r11.toString());
    }

    private boolean isCellInfoExists(StarCellInfo r10) {
        Cursor r11 = this.mCellDbManager.queryCellInfo(r10.getType(), r10.getMcc(), r10.getMnc(), r10.getLac(), r10.getCid());     // Catch: Throwable -> L18
        if (r11 != null) goto L21;
    L14:
        boolean r8 = false;
    L15:
        if (r11 == null) goto L17;
        r11.close();     // Catch: Throwable -> L18
    L17:
        return r8;
    L21:
        if (r11.moveToFirst() == false) goto L14;
        r8 = true;
        goto L15
    L8:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: Throwable -> L18
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "query cell info failed: " + r10.toCellString(), th);
        return false;
    }

    public static boolean isInterestedNewTypeCode(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return false;
    L5:
        String r10 = r8.trim();
        if (INTERESTED_NEW_TYPE_CODE_L3.contains(r10) == false) goto L9;
        return true;
    L9:
        if (r10.length() >= 6) goto L11;
        return false;
    L11:
        String r11 = r10.substring(0, 2) + "0000";
        String r12 = r10.substring(0, 4) + "00";
        if (INTERESTED_NEW_TYPE_CODE_L1.contains(r11) == true) goto L16;
        if (INTERESTED_NEW_TYPE_CODE_L2.contains(r12) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public static boolean isMallNewTypeCodeL3(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L7;
        return false;
    L7:
        return MALL_NEW_TYPE_CODE_L3.contains(r8.trim());
    }

    private /* synthetic */ void lambda$scheduleRequestCellInfoUpdate$1(Executor r8) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsListening == true) goto L6;
    L11:
        CommSenseLog.dWithMethodName(TAG, "skip requestCellInfoUpdate, listener stopped");     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L6:
        if (this.mTelephonyCallback == null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L14
        requestCellInfoUpdate(r8);
    }

    private /* synthetic */ void lambda$startListen$0(Runnable r8) {
        this.mHandler.post(r8);
    }

    private void markCellAreaQueryFinished(StarCellInfo r8) {
        Object r10 = this.mCellLock;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r8.equals(this.mPendingCellAreaQueryInfo) == false) goto L7;
        this.mPendingCellAreaQueryInfo = null;     // Catch: Throwable -> L10
    L7:
        this.mIsCellAreaQueried = true;     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
    }

    private void markCellAreaQueryPending(StarCellInfo r8) {
        Object r10 = this.mCellLock;
        monitor-enter(r10);
        this.mPendingCellAreaQueryInfo = r8;     // Catch: Throwable -> L7
        this.mIsCellAreaQueried = false;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void maybeRefreshNearCellDbOnLocationChanged(Location r8) {
        if (r8 != null) goto L4;
    L25:
        String r10 = TAG;
        String r11 = "skip near cell db refresh for invalid location=" + r8;
    L12:
        CommSenseLog.dWithMethodName(r10, r11);
        return;
    L4:
        if (LocationUtil.getInstance().isValidCoordinate(r8.getLatitude(), r8.getLongitude()) == false) goto L25;
        double r12 = getDistanceFromLastNearCellRefreshLocation(r8);
        if (r12 >= 0.0d) goto L9;
    L14:
        boolean r13 = this.mCellDbManager.refreshNearCellDb(r8);
        if (r13 == false) goto L24;
        Object r14 = this.mCellLock;
        monitor-enter(r14);
        this.mLastNearCellRefreshLocation = new Location(r8);     // Catch: Throwable -> L21
        monitor-exit(r14);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L24:
        r10 = TAG;
        StringBuilder r15 = new StringBuilder("refresh near cell db after location changed, distanceMeters=");
        r15.append(r12);
        r15.append(", thresholdMeters=500.0, refreshed=");
        r15.append(r13);
    L11:
        r11 = r15.toString();
        goto L12
    L9:
        if (r12 > NEAR_CELL_REFRESH_DISTANCE_THRESHOLD_METERS) goto L14;
        r10 = TAG;
        r15 = new StringBuilder("skip near cell db refresh, distanceMeters=");
        r15.append(r12);
        r15.append(", thresholdMeters=500.0");
        goto L11
    }

    private void notifyCellCallback(CellCallback r8, List<StarCellInfo> r10) {
        r8.onCellInfoChanged(r10);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "notify cell callback failed", th);
    }

    private void notifyNeighborCellChanged(List<StarCellInfo> r8) {
        List<StarCellInfo> r10 = Collections.unmodifiableList(new ArrayList(r8));
        Iterator<CellCallback> r11 = this.mNeighborCellCallbacks.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        notifyCellCallback(r11.next(), r10);
        goto L4
    }

    private void notifyServingCellChanged(StarCellInfo r8) {
        List<StarCellInfo> r10 = Collections.singletonList(r8);
        Iterator<CellCallback> r11 = this.mServingCellCallbacks.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        notifyCellCallback(r11.next(), r10);
        goto L4
    }

    private void onWwanCellPoiStatusChange(int r8, int r10, int r11, int r12, long r13, int r14) {
        StringBuilder r15 = defpackage.a.g("CellPoiStatusChange[clientId=", r8, ", cellPoiType=", r10, ", rat=");
        defpackage.b.q(r15, r11, ", tac=", r12, ", cellid=");
        r15.append(r13);
        r15.append(", pci=");
        r15.append(r14);
        r15.append(']');
        String r16 = r15.toString();
        CommSenseLog.iWithMethodName(TAG, r16);
        StarAoiBoardManager.getInstance(this.mAppContext, 0).dumpPoiLog(r16);     // Catch: Throwable -> L5
        StarPoiManager.getInstance().handleCellPoiStatusChange(r10, r13);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "dump cell poi status to poi log failed", th);
    }

    private StarCellInfo queryCellsArea(StarCellInfo r8) {
        StarCellInfo r10 = null;
        if (LocationUtil.getInstance().isNetworkValid() == true) goto L5;
        markCellAreaQueryPending(r8);
        StringBuilder r11 = new StringBuilder("network invalid, pending cell area query: ");
    L16:
        r11.append(r8.toCellString());
        CommSenseLog.dWithMethodName(TAG, r11.toString());
        return r10;
    L5:
        boolean r12 = BdLocationManager.getInstance().queryCellsArea(Collections.singletonList(r8));
        if (r12 == false) goto L8;
        r10 = readCellInfoFromDb(r8);
    L8:
        if (r10 == null) goto L10;
        markCellAreaQueryFinished(r8);
    L11:
        r11 = android.aimedia.a.l("query cell area, success=", r12, ", hasValidLocation=");
        if (r10 == null) goto L14;
        boolean r13 = true;
    L15:
        r11.append(r13);
        r11.append(", cell=");
        goto L16
    L14:
        r13 = false;
        goto L15
    L10:
        markCellAreaQueryPending(r8);
        goto L11
    }

    private StarCellInfo readCellInfoFromDb(StarCellInfo r13) {
        Cursor r8 = this.mCellDbManager.queryCellInfo(r13.getType(), r13.getMcc(), r13.getMnc(), r13.getLac(), r13.getCid());     // Catch: Throwable -> L24
        if (r8 != null) goto L27;
    L21:
        if (r8 == null) goto L23;
        r8.close();     // Catch: Throwable -> L24
    L23:
        return null;
    L27:
    L15:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: Throwable -> L24
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L24
        goto L20
    L6:
        if (r8.moveToFirst() == false) goto L21;
        StarCellInfo r12 = r13.withLocation(getDoubleFromCursor(r8, "latitude"), getDoubleFromCursor(r8, StarCellDbManager.CellInfoEntry.LONGITUDE), getDoubleFromCursor(r8, "radius"));     // Catch: Throwable -> L15
        if (StarCellInfo.access$600(r12) == true) goto L13;
        CommSenseLog.dWithMethodName(TAG, "skip cell info from db without valid location, cell=" + r13.toCellString());     // Catch: Throwable -> L15
        r8.close();     // Catch: Throwable -> L24
        return null;
    L13:
        r8.close();     // Catch: Throwable -> L24
        return r12;
    L24:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "read cell info from db failed: " + r13.toCellString(), th);
        return null;
    }

    private void requestCellInfoUpdate(Executor r8) {
        this.mTelephonyManager.requestCellInfoUpdate(r8, new AnonymousClass2(this));     // Catch: Throwable -> L5 SecurityException -> L7
        CommSenseLog.dWithMethodName(TAG, "requestCellInfoUpdate success");     // Catch: Throwable -> L5 SecurityException -> L7
    L13:
        return;
    L7:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "requestCellInfoUpdate failed: " + e.getMessage());
        return;
    L5:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "requestCellInfoUpdate failed", th);
    }

    private void retryPendingCellAreaQuery() {
        if (LocationUtil.getInstance().isNetworkValid() == true) goto L5;
        return;
    L5:
        Object r8 = this.mCellLock;
        monitor-enter(r8);
    L23:
        th = move-exception;
        throw th;
    L8:
        if (this.mIsCellAreaQueried == true) goto L21;
        StarCellInfo r10 = this.mPendingCellAreaQueryInfo;     // Catch: Throwable -> L23
        if (r10 == null) goto L21;
        monitor-exit(r8);     // Catch: Throwable -> L23
        CommSenseLog.dWithMethodName(TAG, "network valid, retry pending cell area query: " + r10.toCellString());
        StarCellInfo r11 = readCellInfoFromDb(r10);
        if (r11 == null) goto L17;
        dumpCellInfoToPoiLog(r11);
        updateLatestCellLocationSource(r11);
        markCellAreaQueryFinished(r10);
        return;
    L17:
        StarCellInfo r12 = queryCellsArea(r10);
        if (r12 == null) goto L27;
        updateLatestCellLocationSource(r12);
        return;
    L27:
        return;
    L21:
        monitor-exit(r8);     // Catch: Throwable -> L23
    }

    private void scheduleRequestCellInfoUpdate(Executor r8) {
        cancelRequestCellInfoUpdate();
        r r10 = new r(13, this, r8);
        this.mRequestCellInfoUpdateRunnable = r10;
        this.mHandler.postDelayed(r10, 30000);
        CommSenseLog.dWithMethodName(TAG, "schedule requestCellInfoUpdate delayMs=30000");
    }

    private void updateCellInfo(List<CellInfo> r8) {
        if (r8 != null) goto L5;
    L27:
        CommSenseLog.vWithMethodName(TAG, "cellInfos is null or empty");
        return;
    L5:
        if (r8.isEmpty() == true) goto L27;
        ArrayList r10 = new ArrayList();
        Iterator<CellInfo> r11 = r8.iterator();
        StarCellInfo r12 = null;
    L9:
        if (r11.hasNext() == false) goto L23;
        CellInfo r13 = r11.next();
        StarCellInfo r14 = StarCellInfo.access$400(r13);
        if (r14 == null) goto L12;
        if (StarCellInfo.access$500(r14) == false) goto L15;
        if (r13.isRegistered() == true) goto L18;
        CommSenseLog.vWithMethodName(TAG, "neighbor cell, cell=" + r14.toCellString());
        r10.add(r14);
        goto L9
    L18:
        CommSenseLog.vWithMethodName(TAG, "registered cell, cell=" + r14.toCellString());
        if (r12 != null) goto L9;
        r12 = r14;
        goto L9
    L15:
        CommSenseLog.dWithMethodName(TAG, "skip invalid cell identity: " + r14.toCellString());
        goto L9
    L12:
        CommSenseLog.vWithMethodName(TAG, "skip unknown cell type, class=".concat(r13.getClass().getSimpleName()));
        goto L9
    L23:
        if (updateServingCellInfo(r12) == true) goto L25;
        return;
    L25:
        updateNeighborCellInfos(r10);
    }

    private boolean updateLatestCellLocationSource(StarCellInfo r8) {
        if (StarCellInfo.access$600(r8) == true) goto L6;
        CommSenseLog.dWithMethodName(TAG, "skip cell location source without valid location, cell=" + r8.toCellString());
        return false;
    L6:
        StringBuilder r10 = android.aimedia.a.l("update cell location source, updated=", StarLocationManager.getInstance().updateLatest(StarCellInfo.access$700(r8)), ", cell=");
        r10.append(r8.toCellString());
        CommSenseLog.dWithMethodName(TAG, r10.toString());
        return true;
    }

    private void updateNeighborCellInfos(List<StarCellInfo> r8) {
        if (r8 != null) goto L5;
        CommSenseLog.vWithMethodName(TAG, "neighbor cellInfos is null");
        return;
    L5:
        Object r10 = this.mCellLock;
        monitor-enter(r10);
    L22:
        th = move-exception;
        throw th;
    L8:
        if (r8.equals(this.mNeighborCellInfos) == false) goto L12;
        CommSenseLog.vWithMethodName(TAG, "neighbor cells not changed");     // Catch: Throwable -> L22
        monitor-exit(r10);     // Catch: Throwable -> L22
        return;
    L12:
        List<StarCellInfo> r11 = getAddedCellInfos(this.mNeighborCellInfos, r8);     // Catch: Throwable -> L22
        this.mNeighborCellInfos = Collections.unmodifiableList(new ArrayList(r8));     // Catch: Throwable -> L22
        monitor-exit(r10);     // Catch: Throwable -> L22
        CommSenseLog.dWithMethodName(TAG, "neighbor cells changed: " + formatCellInfoList(r8));
        Iterator<StarCellInfo> r12 = r11.iterator();
    L16:
        if (r12.hasNext() == false) goto L20;
        StarCellInfo r13 = r12.next();
        if (isCellInfoExists(r13) == true) goto L16;
        insertCellInfo(r13);
        goto L16
    L20:
        notifyNeighborCellChanged(r8);
    }

    private boolean updateServingCellInfo(StarCellInfo r8) {
        if (r8 != null) goto L6;
        CommSenseLog.vWithMethodName(TAG, "serving cell is null");
        return false;
    L6:
        Object r10 = this.mCellLock;
        monitor-enter(r10);
    L34:
        th = move-exception;
        throw th;
    L9:
        if (r8.equals(this.mServingCellInfo) == true) goto L11;
        this.mServingCellInfo = r8;     // Catch: Throwable -> L34
        boolean r11 = false;
    L19:
        monitor-exit(r10);     // Catch: Throwable -> L34
        if (r11 == false) goto L23;
        CommSenseLog.dWithMethodName(TAG, "serving cell not changed, retry pending cell area query: " + r8.toCellString());
        retryPendingCellAreaQuery();
        return false;
    L23:
        CommSenseLog.dWithMethodName(TAG, "serving cell changed: " + r8.toCellString());
        StarCellInfo r12 = readCellInfoFromDb(r8);
        if (r12 == null) goto L29;
        CommSenseLog.dWithMethodName(TAG, "serving cell exists in db, skip query: " + r8.toCellString());
        dumpCellInfoToPoiLog(r12);
        if (updateLatestCellLocationSource(r12) == false) goto L28;
        markCellAreaQueryFinished(r8);
    L28:
        return true;
    L29:
        StarCellInfo r13 = queryCellsArea(r8);
        if (r13 == null) goto L32;
        updateLatestCellLocationSource(r13);
    L32:
        notifyServingCellChanged(r8);
        return true;
    L11:
        if (this.mIsCellAreaQueried == false) goto L13;
    L15:
        CommSenseLog.vWithMethodName(TAG, "serving cell not changed: " + r8.toCellString());     // Catch: Throwable -> L34
        monitor-exit(r10);     // Catch: Throwable -> L34
        return false;
    L13:
        if (r8.equals(this.mPendingCellAreaQueryInfo) == false) goto L15;
        r11 = true;
        goto L19
    }

    public synchronized void destroy() {
        monitor-enter(this);
        stopListen();     // Catch: Throwable -> L21
        Object r8 = this.mCellLock;     // Catch: Throwable -> L21
        monitor-enter(r8);     // Catch: Throwable -> L21
        this.mServingCellInfo = null;     // Catch: Throwable -> L18
        this.mPendingCellAreaQueryInfo = null;     // Catch: Throwable -> L18
        this.mNeighborCellInfos = Collections.emptyList();     // Catch: Throwable -> L18
        this.mIsCellAreaQueried = true;     // Catch: Throwable -> L18
        monitor-exit(r8);     // Catch: Throwable -> L18
        this.mServingCellCallbacks.clear();     // Catch: Throwable -> L21
        this.mNeighborCellCallbacks.clear();     // Catch: Throwable -> L21
        this.mWwanSensorService.destroy();     // Catch: Throwable -> L11
    L13:
        HandlerThread r10 = this.mHandlerThread;     // Catch: Throwable -> L21
        if (r10 == null) goto L16;
        r10.quitSafely();     // Catch: Throwable -> L21
        this.mHandlerThread = null;     // Catch: Throwable -> L21
        this.mHandler = null;     // Catch: Throwable -> L21
    L16:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "destroy wwan sensor service failed", th);     // Catch: Throwable -> L21
        goto L13
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public List<StarCellInfo> getNeighborCellInfos() {
        Object r8 = this.mCellLock;
        monitor-enter(r8);
        ArrayList r10 = new ArrayList(this.mNeighborCellInfos);     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public StarCellInfo getServingCellInfo() {
        Object r8 = this.mCellLock;
        monitor-enter(r8);
        StarCellInfo r10 = this.mServingCellInfo;     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void startListen() {
        monitor-enter(this);
        CommSenseLog.iWithMethodName(TAG, "called, mIsListening=" + this.mIsListening);     // Catch: Throwable -> L24
        if (this.mIsListening == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (this.mTelephonyManager != null) goto L13;
        CommSenseLog.eWithMethodName(TAG, "failed: TelephonyManager is null");     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L13:
        ensureHandlerLocked();     // Catch: Throwable -> L24
        this.mWwanSensorService.start();     // Catch: Throwable -> L24
        Executor r8 = new c(this);     // Catch: Throwable -> L24
        this.mTelephonyCallback = new CellInfoTelephonyCallback(this, null);     // Catch: Throwable -> L24
        UserAwareManager.getInstance().registerInnerCallback(this.mInnerAwareInfoCallback);     // Catch: Throwable -> L16 SecurityException -> L19
        this.mTelephonyManager.registerTelephonyCallback(r8, this.mTelephonyCallback);     // Catch: Throwable -> L16 SecurityException -> L19
        this.mIsListening = true;     // Catch: Throwable -> L16 SecurityException -> L19
        CommSenseLog.iWithMethodName(TAG, "success");     // Catch: Throwable -> L16 SecurityException -> L19
        updateCellInfo(this.mTelephonyManager.getAllCellInfo());     // Catch: Throwable -> L16 SecurityException -> L19
        scheduleRequestCellInfoUpdate(r8);     // Catch: Throwable -> L16 SecurityException -> L19
    L22:
        monitor-exit(this);
        return;
    L19:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "listen cell info failed: " + e.getMessage());     // Catch: Throwable -> L24
    L18:
        clearRegisteredCallbacks();     // Catch: Throwable -> L24
    L16:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "listen cell info failed", th);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public synchronized void stopListen() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsListening == true) goto L29;
        monitor-exit(this);
        return;
    L29:
        cancelRequestCellInfoUpdate();     // Catch: Throwable -> L13
        UserAwareManager.getInstance().unregisterInnerCallback(this.mInnerAwareInfoCallback);     // Catch: Throwable -> L13
        TelephonyManager r8 = this.mTelephonyManager;     // Catch: Throwable -> L13
        if (r8 == null) goto L25;
        CellInfoTelephonyCallback r10 = this.mTelephonyCallback;     // Catch: Throwable -> L13
        if (r10 == null) goto L25;
        r8.unregisterTelephonyCallback(r10);     // Catch: Throwable -> L13
    L25:
        this.mWwanSensorService.stop();     // Catch: Throwable -> L17
    L19:
        this.mTelephonyCallback = null;     // Catch: Throwable -> L22
        this.mIsListening = false;     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "stop wwan sensor service failed", th);     // Catch: Throwable -> L22
    L13:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "stop listen cell info failed", th);     // Catch: Throwable -> L22
        goto L25
    }
}
