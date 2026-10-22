package com.ss.ttvideoengine.strategrycenter;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.vcloud.strategy.IAppService;
import com.bytedance.vcloud.strategy.ILogCallback;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.LibraryLoaderProxy;
import com.ss.ttvideoengine.TTNetWorkListener;
import com.ss.ttvideoengine.TTNetworkStateCallback;
import com.ss.ttvideoengine.dasp.DaspSignal;
import com.ss.ttvideoengine.database.IKVStorage;
import com.ss.ttvideoengine.database.IKVStorageProvider;
import com.ss.ttvideoengine.database.KVDBManager;
import com.ss.ttvideoengine.log.VideoEventManager;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import com.ss.ttvideoengine.preload.PreloadScene;
import com.ss.ttvideoengine.selector.strategy.GearStrategyContext;
import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class StrategyHelper {
    public static final String LOG_KEY_PRECISE_CACHE_CONTROL = "st_play_task_op";
    static final String TAG = "VCStrategy";
    private int mAppID;
    private com.bytedance.vcloud.strategy.StrategyCenter mCenter;
    private boolean mCheckPlayerVer;
    private Context mContext;
    private DBHelper mDBHelper;
    private boolean mDidSetAppInfo;
    private int mEnableSpeedInfoUpdate;
    private IStrategyEventListener mEventListener;
    private long mIOManager;
    private long mIOManagerVersion;
    private StrategyEvent mInnerEvent;
    private Map<Integer, String> mJsonStringMap;
    private float mLastBandwidth;
    private final ReentrantLock mLock;
    private int mLogLevel;
    private Map<Integer, Integer> mModuleSwitchMap;
    private TTNetworkStateCallback mNetWorkChangeCb;
    private WeakReference<TTNetworkStateCallback> mNetWorkChangeCbr;
    private boolean mPlayerIsMatch;
    private IPortraitService mPortraitService;
    private Map<Integer, Integer> mSettingMap;
    private boolean mSpeedInfoUpdate;
    private ReentrantLock mSpeedLock;
    private IKVStorageProvider mStorageProvider;
    private IStrategyStateSupplier mSupplier;

    public final class DBHelper {
        private static final String dataBaseName = "TTVideoEngine_vod_strategy_database_v01";
        private static final String dataIndex = "data_index";
        Context mContext;
        private final ArrayList<String> mIndexArray;
        IKVStorage mKVStorage;
        final int mMaxCacheNum;
        WeakReference<StrategyHelper> mSHelper;
        final /* synthetic */ StrategyHelper this$0;

        private boolean _create() {
            if (this.mKVStorage != null) goto L10;
            if (StrategyHelper.access$1000(this.this$0) == null) goto L7;
            this.mKVStorage = StrategyHelper.access$1000(this.this$0).getKVStorage(dataBaseName);
            TTVideoEngineLog.d(StrategyHelper.TAG, "use kv storage provider");
            goto L10
        L7:
            this.mKVStorage = new KVDBManager(this.mContext, dataBaseName);
            TTVideoEngineLog.d(StrategyHelper.TAG, "use KVDBManager");
            return this.mKVStorage.isCreateDBSuccess();
        L10:
            if (this.mKVStorage == null) goto L12;
            return true;
        L12:
            return false;
        }

        private void _loadData() {
            StrategyHelper r0 = this.mSHelper.get();
            if (r0 != null) goto L5;
            return;
        L5:
            ArrayList<String> r1 = stringToStringArray(this.mKVStorage.getString(dataIndex));
            if (r1 != null) goto L8;
            return;
        L8:
            if (r1.isEmpty() == true) goto L23;
            this.mIndexArray.addAll(r1);
            Iterator<String> r2 = r1.iterator();
        L12:
            if (r2.hasNext() == false) goto L24;
            String r3 = r2.next();
            String r4 = this.mKVStorage.getString(r3);
            if (TextUtils.isEmpty(r4) == true) goto L12;
            r0.getCenter().h(31210, r4);
            goto L12
        L24:
            return;
        }

        private void _saveDataIndexes() {
            String r0 = indexToString(this.mIndexArray);
            this.mKVStorage.putString(dataIndex, r0);
        }

        public void clear() {
            this.mKVStorage.clear();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            TTVideoEngineLog.e(StrategyHelper.TAG, "clear fail. " + th.toString());
        }

        public void loadDB() {
        L8:
            th = move-exception;
            TTVideoEngineLog.d(th);
            return;
        L3:
            if (_create() == true) goto L6;
            TTVideoEngineLog.e(StrategyHelper.TAG, "create db fail.");     // Catch: Throwable -> L8
            return;
        L6:
            _loadData();     // Catch: Throwable -> L8
        }

        private String indexToString(ArrayList<String> r4) {
            if (r4 == null) goto L12;
            StringBuilder r0 = new StringBuilder(r4.size());
            int r1 = 0;
        L5:
            if (r1 >= r4.size()) goto L11;
            r0.append((String) ListProtector.get(r4, r1));
            if (r1 >= (r4.size() - 1)) goto L9;
            r0.append(",");
        L9:
            r1 = r1 + 1;
            goto L5
        L11:
            return r0.toString();
        L12:
            return null;
        }

        private ArrayList<String> stringToStringArray(String r6) {
            ArrayList<String> r1 = null;
            if (TextUtils.isEmpty(r6) == false) goto L24;
            return null;
        L24:
            String[] r7 = r6.split(",");     // Catch: Throwable -> L19
            if (r7 != null) goto L8;
            return null;
        L8:
            if (r7.length <= 0) goto L30;
            ArrayList<String> r0 = new ArrayList();     // Catch: Throwable -> L19
            int r2 = r7.length;     // Catch: Throwable -> L17
            int r3 = 0;
        L11:
            if (r3 >= r2) goto L31;
            String r4 = r7[r3];     // Catch: Throwable -> L17
            if (TextUtils.isEmpty(r4) == true) goto L15;
            r0.add(r4);     // Catch: Throwable -> L17
        L15:
            r3 = r3 + 1;
            goto L11
        L31:
            return r0;
        L17:
            th = th;
            r1 = r0;
        L20:
            TTVideoEngineLog.d(th);
            return r1;
        L30:
            return null;
        L19:
            th = th;
            goto L20
        }

        public void loadKeyValue(String r4) {
        L12:
            th = move-exception;
            TTVideoEngineLog.e(StrategyHelper.TAG, "load key value fail. " + th.toString());
            return;
        L4:
            if (_create() == true) goto L7;
            TTVideoEngineLog.e(StrategyHelper.TAG, "create db fail.");     // Catch: Throwable -> L12
            return;
        L7:
            StrategyHelper r1 = this.mSHelper.get();     // Catch: Throwable -> L12
            if (r1 != null) goto L10;
            return;
        L10:
            r1.getCenter().h(31212, this.mKVStorage.getString(r4));     // Catch: Throwable -> L12
        }

        public void removeData(String r3) {
            this.mIndexArray.remove(r3);     // Catch: Throwable -> L4
            this.mKVStorage.removeString(r3);     // Catch: Throwable -> L4
            _saveDataIndexes();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            TTVideoEngineLog.e(StrategyHelper.TAG, "remove data fail. " + th.toString());
        }

        public void saveData(String r3, String r4) {
            this.mIndexArray.add(r3);     // Catch: Throwable -> L7
            if (this.mIndexArray.size() <= 2000) goto L5;
            this.mKVStorage.removeString((String) ListProtector.remove(this.mIndexArray, 0));     // Catch: Throwable -> L7
        L5:
            _saveDataIndexes();     // Catch: Throwable -> L7
            this.mKVStorage.putString(r3, r4);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            TTVideoEngineLog.e(StrategyHelper.TAG, "save data fail. " + th.toString());
        }

        public void saveKeyValue(String r2, String r3) {
            this.mKVStorage.putString(r2, r3);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            TTVideoEngineLog.e(StrategyHelper.TAG, "save key value fail. " + th.toString());
        }

        public DBHelper(StrategyHelper r1, Context r2, StrategyHelper r3) {
            this.this$0 = r1;
            this.mIndexArray = new ArrayList();
            this.mKVStorage = null;
            this.mSHelper = null;
            this.mMaxCacheNum = 2000;
            this.mContext = r2;
            this.mSHelper = new WeakReference(r3);
        }

        public void event(int r1, String r2, String r3) {
            switch(r1) {
                case 1: goto L9;
                case 2: goto L8;
                case 3: goto L7;
                case 4: goto L6;
                case 5: goto L5;
                case 6: goto L4;
                default: goto L16;
            };
        L4:
            clear();
            return;
        L5:
            loadKeyValue(r2);
            return;
        L6:
            saveKeyValue(r2, r3);
            return;
        L7:
            removeData(r2);
            return;
        L8:
            saveData(r2, r3);
            return;
        L9:
            loadDB();
            return;
        }
    }

    public static class MyALogCallBak implements ILogCallback {
        public MyALogCallBak() {
        }

        public void log(String r2) {
            TTVideoEngineLog.i(StrategyHelper.TAG, r2);
        }
    }

    public class MyAppServer implements IAppService {
        private WeakReference<StrategyHelper> mHelper;
        final /* synthetic */ StrategyHelper this$0;

        public MyAppServer(StrategyHelper r1, StrategyHelper r2) {
            this.this$0 = r1;
            this.mHelper = null;
            this.mHelper = new WeakReference(r2);
        }

        public String getPortrait(String r5, String r6) {
            StrategyHelper r0 = this.mHelper.get();
            if (r0 != null) goto L5;
            return null;
        L5:
            if (StrategyHelper.access$900(r0) == null) goto L18;
            HashMap r1 = new HashMap();
            r1.put(IPortraitService.TYPE, IPortraitService.TYPE_ONE_PORTRAIT);
            r1.put("from", r5);
            r1.put(IPortraitService.NAME, r6);
            Map<String, String> r7 = StrategyHelper.access$900(r0).getPortraits(r1);
            if (r7 != null) goto L10;
            return BuildConfig.FLAVOR;
        L10:
            if (r7.containsKey(r6) == true) goto L12;
            return BuildConfig.FLAVOR;
        L12:
            return r7.get(r6);
        L18:
            return null;
        }

        public String getPortraits(String r6, String r7) {
            StrategyHelper r0 = this.mHelper.get();
            if (r0 != null) goto L5;
        L11:
            return null;
        L5:
            if (StrategyHelper.access$900(r0) == null) goto L11;
            HashMap r2 = new HashMap();
            r2.put(IPortraitService.TYPE, "group");
            r2.put(IPortraitService.NAME, r7);
            r2.put("from", r6);
            Map<String, String> r8 = StrategyHelper.access$900(r0).getPortraits(r2);
            if (r8 == null) goto L11;
            return new JSONObject(r8).toString();
        }

        public void addGroupConfig(String r5, String r6, String r7) {
            StrategyHelper r0 = this.mHelper.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (StrategyHelper.access$900(r0) == null) goto L20;
            ArrayList r1 = new ArrayList();
            JSONArray r2 = new JSONArray(r7);     // Catch: Throwable -> L15
            int r8 = 0;
        L10:
            if (r8 >= r2.length()) goto L13;
            r1.add(JSONArrayProtectorUtils.getString(r2, r8));     // Catch: Throwable -> L15
            r8 = r8 + 1;
        L13:
            HashMap r9 = new HashMap();
            r9.put("from", r5);
            r9.put(IPortraitService.NAME, r6);
            StrategyHelper.access$900(r0).addGroupConfig(r9, r1);
            return;
        }

        public String getMediaPortrait(String r6, String r7, String r8) {
            StrategyHelper r0 = this.mHelper.get();
            if (r0 != null) goto L5;
        L11:
            return null;
        L5:
            if (StrategyHelper.access$900(r0) == null) goto L11;
            HashMap r2 = new HashMap();
            r2.put(IPortraitService.TYPE, IPortraitService.TYPE_ONE_PORTRAIT);
            r2.put(IPortraitService.NAME, r8);
            r2.put(IPortraitService.VIDEO_ID, r7);
            r2.put("from", r6);
            Map<String, String> r9 = StrategyHelper.access$900(r0).getPortraits(r2);
            if (r9 == null) goto L11;
            return new JSONObject(r9).toString();
        }

        public String getMediaPortraits(String r6, String r7, String r8) {
            StrategyHelper r0 = this.mHelper.get();
            if (r0 != null) goto L5;
        L11:
            return null;
        L5:
            if (StrategyHelper.access$900(r0) == null) goto L11;
            HashMap r2 = new HashMap();
            r2.put(IPortraitService.TYPE, "group");
            r2.put(IPortraitService.NAME, r8);
            r2.put(IPortraitService.VIDEO_ID, r7);
            r2.put("from", r6);
            Map<String, String> r9 = StrategyHelper.access$900(r0).getPortraits(r2);
            if (r9 == null) goto L11;
            return new JSONObject(r9).toString();
        }
    }

    public class MyIStrategyEventListener implements com.bytedance.vcloud.strategy.IStrategyEventListener {
        private WeakReference<StrategyHelper> mHelper;
        final /* synthetic */ StrategyHelper this$0;

        public /* bridge */ /* synthetic */ void strategyConfigGlobalOption(int r1, int r2, Object r3) {
            com.bytedance.vcloud.strategy.IStrategyEventListener.-CC.$default$strategyConfigGlobalOption(this, r1, r2, r3);
        }

        public MyIStrategyEventListener(StrategyHelper r1, StrategyHelper r2) {
            this.this$0 = r1;
            this.mHelper = null;
            this.mHelper = new WeakReference(r2);
        }

        public void onEventLog(String r3, String r4) {
            TTVideoEngineLog.d(StrategyHelper.TAG, "eventName: " + r3 + ", logInfo: " + r4);
            if (TextUtils.isEmpty(r4) == true) goto L11;
            VideoEventManager.instance.addEventV2(true, new JSONObject(r4), r3);     // Catch: JSONException -> L6
            return;
        L6:
            e = move-exception;
            TTVideoEngineLog.d(e);
            return;
        }

        public void onEvent(String r3, int r4, int r5, String r6) {
            TTVideoEngineLog.i(StrategyHelper.TAG, "on event, videoID = " + r3 + ", key = " + r4 + ", value = " + r5 + ", info = " + r6);
            if (r4 != 2019) goto L10;
            StrategyHelper r7 = this.mHelper.get();
            if (r7 != null) goto L7;
            return;
        L7:
            if (StrategyHelper.access$500(r7) == null) goto L20;
            StrategyHelper.access$500(r7).event(r5, r3, r6);
            return;
        L20:
            return;
        L10:
            StrategyHelper.access$600(this.this$0).event(r3, r4, r5, r6);
            StrategyHelper.access$700(this.this$0).lock();
            if (StrategyHelper.access$800(this.this$0) == null) goto L17;
            StrategyHelper.access$700(this.this$0).unlock();
            if (r4 != 2012) goto L15;
        L16:
            StrategyHelper.access$800(this.this$0).onEvent(r3, r4, r5, r6);
            return;
        L15:
            if (r4 >= 2500) goto L16;
            return;
        L17:
            StrategyHelper.access$700(this.this$0).unlock();
        }
    }

    public static class StrategyHelperHolder {
        private static final StrategyHelper Instance = null;

        private StrategyHelperHolder() {
        }

        static {
            Instance = new StrategyHelper();
        }

        public static /* synthetic */ StrategyHelper access$000() {
            return Instance;
        }
    }

    private static final int _netState(int r2) {
        if (r2 != (-1)) goto L5;
        return 0;
    L5:
        if (r2 != 0) goto L8;
        return 20;
    L8:
        if (r2 != 2) goto L10;
    L15:
        return 10;
    L10:
        if (r2 == 3) goto L15;
        if (r2 == 1) goto L15;
        if (r2 == 4) goto L15;
        return -1;
    }

    private void _configParams() {
        this.mDBHelper = new DBHelper(this, this.mContext, this);
        getCenter().F(10000, this.mLogLevel);
        getCenter().F(801, StrategyKeys.mInteractionBlockDurationPreloaded);
        getCenter().F(802, StrategyKeys.mInteractionBlockDurationNonPreloaded);
        Iterator<Map.Entry<Integer, String>> r0 = this.mJsonStringMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<Integer, String> r1 = r0.next();
        getCenter().B(r1.getKey().intValue(), r1.getValue());
        goto L4
    L6:
        Iterator<Map.Entry<Integer, Integer>> r2 = this.mSettingMap.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        Map.Entry<Integer, Integer> r3 = r2.next();
        getCenter().F(r3.getKey().intValue(), r3.getValue().intValue());
        goto L8
    }

    private void _netStateListener() {
        if (this.mNetWorkChangeCb == null) goto L5;
        return;
    L5:
        this.mNetWorkChangeCb = new AnonymousClass3(this);
        if (TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 16) == true) goto L9;
        this.mNetWorkChangeCbr = new WeakReference(this.mNetWorkChangeCb);
        TTNetWorkListener.getInstance().startListen(this.mNetWorkChangeCbr);
        return;
    }

    public com.bytedance.vcloud.strategy.StrategyCenter getCenter() {
        if (this.mCenter != null) goto L13;
        this.mLock.lock();
    L9:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    L6:
        if (this.mCenter != null) goto L8;
        this.mCenter = new com.bytedance.vcloud.strategy.StrategyCenter(new MyIStrategyEventListener(this, this));     // Catch: Throwable -> L9
    L8:
        this.mLock.unlock();
    L13:
        return this.mCenter;
    }

    public float getNetworkSpeed() {
        if (this.mEnableSpeedInfoUpdate == 0) goto L5;
        this.mSpeedLock.lock();
    L21:
        th = move-exception;
        this.mSpeedLock.unlock();
        throw th;
    L9:
        if (this.mSpeedInfoUpdate == false) goto L11;
    L15:
        float r1 = helper().getCenter().n();     // Catch: Throwable -> L21
        if (r1 <= 0.0f) goto L18;
        TTVideoEngineLog.d(TAG, "speed update success, result: " + r1);     // Catch: Throwable -> L21
        this.mLastBandwidth = r1;     // Catch: Throwable -> L21
        this.mSpeedInfoUpdate = false;     // Catch: Throwable -> L21
    L18:
        float r0 = this.mLastBandwidth;     // Catch: Throwable -> L21
        this.mSpeedLock.unlock();
        return r0;
    L11:
        if (this.mLastBandwidth <= 0.0f) goto L15;
        TTVideoEngineLog.d(TAG, "speed doesnt need to be updated, update: " + this.mSpeedInfoUpdate + ", last: " + this.mLastBandwidth);     // Catch: Throwable -> L21
        float r2 = this.mLastBandwidth;     // Catch: Throwable -> L21
        this.mSpeedLock.unlock();
        return r2;
    L5:
        return helper().getCenter().n();
    }

    public boolean needCheckPlayerVersion() {
        return !this.mCheckPlayerVer;
    }

    public void speedInfoUpdate() {
        this.mSpeedLock.lock();
        TTVideoEngineLog.d(TAG, "speed info update");     // Catch: Throwable -> L6
        this.mSpeedInfoUpdate = true;     // Catch: Throwable -> L6
        this.mSpeedLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mSpeedLock.unlock();
        throw th;
    }

    public StrategyHelper() {
        this.mCenter = null;
        this.mSupplier = null;
        this.mPortraitService = null;
        this.mDidSetAppInfo = false;
        this.mIOManager = 0;
        this.mIOManagerVersion = 0;
        this.mContext = null;
        this.mLogLevel = 5;
        this.mAppID = 0;
        this.mCheckPlayerVer = false;
        this.mPlayerIsMatch = false;
        this.mNetWorkChangeCb = null;
        this.mNetWorkChangeCbr = null;
        this.mLock = new ReentrantLock();
        this.mDBHelper = null;
        this.mModuleSwitchMap = new ConcurrentHashMap(5);
        this.mInnerEvent = new StrategyEvent();
        this.mSettingMap = new ConcurrentHashMap();
        this.mJsonStringMap = new ConcurrentHashMap();
        this.mStorageProvider = null;
        this.mEnableSpeedInfoUpdate = 0;
        this.mSpeedInfoUpdate = true;
        this.mLastBandwidth = -1.0f;
        this.mSpeedLock = new ReentrantLock();
    }

    public static StrategyHelper helper() {
        return StrategyHelperHolder.access$000();
    }

    public boolean isRunning() {
        return getCenter().b;
    }

    public int getLogLevel() {
        return this.mLogLevel;
    }

    public IStrategyStateSupplier getSupplier() {
        return this.mSupplier;
    }

    public boolean playerIsMatch() {
        return this.mPlayerIsMatch;
    }

    private String _mapToString(Map<String, String> r6) {
        if (r6 != null) goto L17;
        return null;
    L17:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L16
        Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();     // Catch: Exception -> L16
    L7:
        if (r7.hasNext() == false) goto L14;
        Map.Entry<String, String> r2 = r7.next();     // Catch: Exception -> L16
        String r3 = r2.getKey();     // Catch: Exception -> L16
        String r4 = r2.getValue();     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r3) == true) goto L7;
        if (TextUtils.isEmpty(r4) == true) goto L7;
        r1.put(r3, r4);     // Catch: Exception -> L16
        goto L7
    L14:
        return r1.toString();
    L16:
        return null;
    }

    private String _objectMapToString(Map<String, Object> r6) {
        if (r6 != null) goto L16;
        return null;
    L16:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L15
        Iterator<Map.Entry<String, Object>> r7 = r6.entrySet().iterator();     // Catch: Exception -> L15
    L7:
        if (r7.hasNext() == false) goto L13;
        Map.Entry<String, Object> r2 = r7.next();     // Catch: Exception -> L15
        String r3 = r2.getKey();     // Catch: Exception -> L15
        Object r4 = r2.getValue();     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r3) == true) goto L7;
        if (r4 == null) goto L7;
        r1.put(r3, r4);     // Catch: Exception -> L15
        goto L7
    L13:
        return r1.toString();
    L15:
        return null;
    }

    private Map<String, Integer> _stringToIntValueMap(String r8) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.length() < 2) goto L26;
        HashMap r0 = new HashMap();
        String[] r9 = r8.split(",");
        int r3 = 0;
    L20:
    L14:
        e = move-exception;
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L19
        goto L16
    L8:
        if (r3 >= r9.length) goto L13;
        String[] r4 = r9[r3].split(":");     // Catch: NumberFormatException -> L14 Throwable -> L19
        if (r4.length != 2) goto L12;
        r0.put(r4[0], Integer.valueOf(Integer.parseInt(r4[1])));     // Catch: NumberFormatException -> L14 Throwable -> L19
    L12:
        r3 = r3 + 1;
        goto L20
    L13:
        return r0;
    L16:
        return r0;
    L26:
        return null;
    }

    public static /* synthetic */ IStrategyStateSupplier access$100(StrategyHelper r0) {
        return r0.mSupplier;
    }

    public static /* synthetic */ IKVStorageProvider access$1000(StrategyHelper r0) {
        return r0.mStorageProvider;
    }

    public static /* synthetic */ int access$200(int r0) {
        return _netState(r0);
    }

    public static /* synthetic */ DBHelper access$500(StrategyHelper r0) {
        return r0.mDBHelper;
    }

    public static /* synthetic */ StrategyEvent access$600(StrategyHelper r0) {
        return r0.mInnerEvent;
    }

    public static /* synthetic */ ReentrantLock access$700(StrategyHelper r0) {
        return r0.mLock;
    }

    public static /* synthetic */ IStrategyEventListener access$800(StrategyHelper r0) {
        return r0.mEventListener;
    }

    public static /* synthetic */ IPortraitService access$900(StrategyHelper r0) {
        return r0.mPortraitService;
    }

    private void internalStart(boolean r7) {
        TTVideoEngineLog.i(TAG, "internalStart needLoadLibrary=" + r7);
        getCenter().i(r7);
        if (getCenter().s() == true) goto L6;
        TTVideoEngineLog.i(TAG, "internalStart isLoadLibrarySucceed false");
        return;
    L6:
        _configParams();
        _netStateListener();
        if (this.mJsonStringMap.get(31001) == null) goto L9;
    L13:
        getCenter().E(this.mIOManager, this.mIOManagerVersion);
        if (getCenter().r() == true) goto L17;
        TTVideoEngineLog.i(TAG, "io manager interface not match, start fail.");
        return;
    L17:
        getCenter().G(new MyALogCallBak());
        if (this.mPortraitService == null) goto L20;
        getCenter().D(new MyAppServer(this, this));
    L20:
        JSONObject r0 = SettingsHelper.helper().getJsonObject(SettingsHelper.MODULE_VOD);
        if (r0 == null) goto L23;
        getCenter().I(SettingsHelper.MODULE_VOD, r0.toString());
    L23:
        PreloadScene r1 = new PreloadScene("engine_default");
        r1.mSceneId = "engine_default";
        r1.mBriefSceneId = "engine_brief_default";
        r1.mAutoPlay = 1;
        r1.mMute = 0;
        r1.mMaxVisibleCardCnt = 1;
        r1.setAlgorithmName("engine_default");
        helper().getCenter().k(r1.toJsonString());
        getCenter().J(new AnonymousClass1(this));
        getCenter().L(r7);
        helper().getCenter().M("engine_default");
        Map r8 = PortraitEngine.getInstance().getAllLabels();
        if (r8 != null) goto L29;
    L26:
        PortraitEngine.getInstance().addPortraitListener(new AnonymousClass2(this));
        return;
    L29:
        getCenter().h(31214, new JSONObject(r8).toString());     // Catch: Exception -> L28
        goto L26
    L9:
        if (this.mAppID != 32) goto L11;
        String r2 = "{\"strategy_center_v1\":{\"feed\":{\"preload_strategy\":{\"name\":\"adaptive\",\"low_buf\":5,\"high_buf\":20,\"tasks\":[{\"count\":5,\"size\":800,\"offset\":0}]}},\"fullscreen_immersive\":{\"preload_strategy\":{\"name\":\"adaptive\",\"low_buf\":5,\"high_buf\":20,\"tasks\":[{\"count\":5,\"size\":800,\"offset\":0}]}},\"story\":{\"preload_strategy\":{\"name\":\"adaptive\",\"low_buf\":5,\"high_buf\":20,\"tasks\":[{\"count\":5,\"size\":800,\"offset\":0}]}}}}";
    L12:
        setAlgorithmJson(31001, r2);
        goto L13
    L11:
        r2 = "{\"strategy_center_v1\":{\"engine_default\":{\"preload_strategy\":{\"name\":\"default\",\"tasks\":[{\"download_progress\":100,\"count\":5,\"offset\":0,\"size\":800}]}},\"video_range_request\":{\"enable_concurrent_download\":0,\"allowed_segment_download\":0,\"fixed_size\":3000,\"fixed_duration\":10}}}";
        goto L12
    }

    public boolean checkPlayerVersion(int r3) {
        if (r3 == (-1)) goto L12;
        if (getCenter().s() == false) goto L12;
        boolean r0 = true;
        this.mCheckPlayerVer = true;
        if (getCenter().q() == r3) goto L10;
        r0 = false;
    L10:
        this.mPlayerIsMatch = r0;
    L12:
        return this.mPlayerIsMatch;
    }

    public void enableSpeedInfoUpdate(int r1) {
        this.mEnableSpeedInfoUpdate = r1;
    }

    public Map<String, Object> getLogData(String r2) {
        return this.mInnerEvent.getLogData(r2);
    }

    public boolean loadPluginLibrary(LibraryLoaderProxy r2) {
        this.mLock.lock();
        boolean r3 = r2.loadLibrary(ChameleonOpenTracker.Stage.PRELOAD);     // Catch: Throwable -> L5
        this.mLock.unlock();
        return r3;
    L5:
        th = move-exception;
        TTVideoEngineLog.i(TAG, th.toString());     // Catch: Throwable -> L9
        this.mLock.unlock();
        return false;
    L9:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public int moduleSwitch(int r5) {
        if (r5 >= 803) goto L5;
    L6:
        TTVideoEngineLog.i(TAG, "get module switch key is wrong" + r5);
    L8:
        if (this.mModuleSwitchMap.containsKey(Integer.valueOf(r5)) == true) goto L14;
        if (getCenter().b == false) goto L12;
        this.mModuleSwitchMap.put(Integer.valueOf(r5), Integer.valueOf(getCenter().o(r5)));
        goto L14
    L12:
        return 0;
    L14:
        return ((Integer) TTHelper.nonNullElse(this.mModuleSwitchMap.get(Integer.valueOf(r5)), 0)).intValue();
    L5:
        if (r5 <= 807) goto L8;
        goto L6
    }

    public Map<String, Object> popOneEventLog(String r3) {
        return this.mInnerEvent.popLogData(1, r3);
    }

    public Map<String, Object> popOnePlayLog(String r3) {
        return this.mInnerEvent.popLogData(0, r3);
    }

    public void removeLogData(String r2) {
        this.mInnerEvent.removeLogData(r2);
    }

    public void setContext(Context r1) {
        this.mContext = r1;
    }

    public void setEventListener(IStrategyEventListener r2) {
        this.mLock.lock();
        this.mEventListener = r2;     // Catch: Throwable -> L6
        this.mLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public void setKVStorageProvider(IKVStorageProvider r1) {
        this.mStorageProvider = r1;
    }

    public void setLogLevel(int r3) {
        getCenter().F(10000, r3);
        this.mLogLevel = r3;
    }

    public void setPortraitService(IPortraitService r3) {
        this.mLock.lock();
    L10:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    L4:
        if (this.mPortraitService != null) goto L7;
        if (r3 == null) goto L7;
        getCenter().D(new MyAppServer(this, this));     // Catch: Throwable -> L10
    L7:
        this.mPortraitService = r3;     // Catch: Throwable -> L10
        this.mLock.unlock();
    }

    public void setSupplier(IStrategyStateSupplier r1) {
        this.mSupplier = r1;
    }

    public void start(boolean r2) {
        getCenter();
        this.mLock.lock();
        internalStart(r2);     // Catch: Throwable -> L5
    L4:
        this.mLock.unlock();
        return;
    L5:
        th = move-exception;
        TTVideoEngineLog.i(TAG, th.toString());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    private Map<String, String> _stringToMap(String r5, Map<String, String> r6) {
        if (TextUtils.isEmpty(r5) == true) goto L18;
        if (r6 == null) goto L32;
        JSONObject r0 = new JSONObject(r5);     // Catch: Exception -> L20
        Iterator<String> r7 = r0.keys();     // Catch: Exception -> L20
    L8:
        if (r7.hasNext() == false) goto L17;
        String r1 = r7.next();     // Catch: Exception -> L20
        String r2 = JSONObjectProtectorUtils.getString(r0, r1);     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r1) == true) goto L8;
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r6.put(r1, r2);     // Catch: Exception -> L20
    L17:
        return r6;
    L32:
        return null;
    L18:
        return null;
    }

    public static /* synthetic */ String access$400(StrategyHelper r0, Map r1) {
        return r0._mapToString(r1);
    }

    public void configAppInfo(String r2, Map r3) {
        if (this.mDidSetAppInfo == false) goto L5;
    L7:
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.containsKey("appid") == false) goto L13;
        this.mAppID = TTHelper.parseInt(r3.get("appid"));
        return;
    L13:
        return;
    L5:
        if (getCenter().s() == false) goto L7;
        getCenter().C(r2);
        this.mDidSetAppInfo = true;
        goto L7
    }

    public Map<String, Object> getLogData(String r2, String r3) {
        return this.mInnerEvent.getLogData(r2, r3);
    }

    public void setAlgorithmJson(int r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L7;
        TTVideoEngineLog.i(TAG, "[preload] Algorithm json " + r3);
        return;
    L7:
        if (getCenter().s() == false) goto L9;
        getCenter().B(r2, r3);
        return;
    L9:
        this.mJsonStringMap.put(Integer.valueOf(r2), r3);
    }

    public void setDaspNonPlaySignal(int r2, List<DaspSignal> r3) {
        _setDaspSignal(r2, r3, null);
    }

    public void setDaspPlaySignal(String r2, List<DaspSignal> r3) {
        _setDaspSignal(31224, r3, r2);
    }

    public void setIOManager(long r2, long r4) {
        this.mLock.lock();
        this.mIOManager = r2;     // Catch: Throwable -> L6
        this.mIOManagerVersion = r4;     // Catch: Throwable -> L6
        this.mLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public void setIntValue(int r2, int r3) {
        if (r2 > 50000) goto L5;
        return;
    L5:
        if (r2 < 60000) goto L8;
        return;
    L8:
        if (r2 < 58000) goto L15;
        if (r2 > 58999) goto L15;
        if (r2 != 58001) goto L15;
        enableSpeedInfoUpdate(r3);
    L15:
        if (getCenter().s() == false) goto L17;
        getCenter().F(r2, r3);
        return;
    L17:
        this.mSettingMap.put(Integer.valueOf(r2), Integer.valueOf(r3));
    }

    public void setStringValue(int r2, String r3) {
        if (r2 > 50000) goto L5;
        return;
    L5:
        if (r2 < 60000) goto L8;
        return;
    L8:
        if (getCenter().s() == false) goto L10;
        getCenter().K(r2, r3);
        return;
    L10:
        this.mJsonStringMap.put(Integer.valueOf(r2), r3);
    }

    private void _setDaspSignal(int r7, List<DaspSignal> r8, String r9) {
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L21
        Iterator<DaspSignal> r10 = r8.iterator();     // Catch: JSONException -> L21
    L5:
        if (r10.hasNext() == false) goto L17;
        DaspSignal r2 = r10.next();     // Catch: JSONException -> L21
        if (r2 == null) goto L5;
        if (r2.name == null) goto L5;
        if (r2.value == null) goto L5;
        TTVideoEngineLog.d("DaspSignal", "name: " + r2.name + ", value: " + r2.value);     // Catch: JSONException -> L21
        JSONObject r3 = new JSONObject();     // Catch: JSONException -> L21
        r3.put("value", r2.value);     // Catch: JSONException -> L21
        if (r9 == null) goto L16;
        r3.put("traceId", r9);     // Catch: JSONException -> L21
    L16:
        r1.put(r2.name, r3);     // Catch: JSONException -> L21
        goto L5
    L17:
        String r11 = r1.toString();     // Catch: JSONException -> L21
        if (TextUtils.isEmpty(r11) == true) goto L36;
        TTVideoEngineLog.d("DaspSignal", "key: " + r7 + ", traceId: " + r9 + ", signalJson: " + r11);     // Catch: JSONException -> L21
        getCenter().h(r7, r11);     // Catch: JSONException -> L21
        return;
    L36:
        return;
    L21:
        e = move-exception;
        TTVideoEngineLog.e("DaspSignal", "Failed to create Dasp signal JSON: " + e);
    }

    public static /* synthetic */ Map access$300(StrategyHelper r0, String r1, Map r2) {
        return r0._stringToMap(r1, r2);
    }

    public static void buildMaskInfo(Map r5, String r6, String r7) {
    L12:
        th = move-exception;
        TTVideoEngineLog.e(TAG, th.toString());
        return;
    L4:
        if (r5.containsKey("infos") == false) goto L6;
        List r1 = (List) r5.get("infos");     // Catch: Throwable -> L12
    L7:
        HashMap r2 = new HashMap();     // Catch: Throwable -> L12
        r2.put("file_hash", r7);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r6) == true) goto L10;
        r2.put("urls", new String[]{r6});     // Catch: Throwable -> L12
    L10:
        r2.put("media_type", "mask");     // Catch: Throwable -> L12
        r1.add(r2);     // Catch: Throwable -> L12
        r5.put("infos", r1);     // Catch: Throwable -> L12
        return;
    L6:
        r1 = new ArrayList();     // Catch: Throwable -> L12
        goto L7
    }

    public Map<String, String> selectResolutionStringMapV2(IVideoModel r4, int r5, Map<String, Object> r6) {
        TTVideoEngineLog.i(TAG, "[GearStrategy]GearStrategy called");
        String r7 = getCenter().A(r4.getMediaInfo(), r5, _objectMapToString(r6), null);
        if (TextUtils.isEmpty(r7) == false) goto L6;
        TTVideoEngineLog.d(TAG, "[GearStrategy]StrategyHelper.selectResolution result invalid retString=" + r7);
        return null;
    L6:
        HashMap r8 = new HashMap();
        _stringToMap(r7, r8);
        return r8;
    }

    public static void buildMediaInfo(Map r4, String r5, String r6, String[] r7) {
    L12:
        th = move-exception;
        TTVideoEngineLog.e(TAG, th.toString());
        return;
    L4:
        if (r4.containsKey("infos") == false) goto L6;
        List r1 = (List) r4.get("infos");     // Catch: Throwable -> L12
    L7:
        HashMap r2 = new HashMap();     // Catch: Throwable -> L12
        r2.put("urls", r7);     // Catch: Throwable -> L12
        r2.put("file_hash", r6);     // Catch: Throwable -> L12
        r1.add(r2);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r5) == false) goto L10;
        r5 = r6;
    L10:
        r4.put("vid", r5);     // Catch: Throwable -> L12
        r4.put("infos", r1);     // Catch: Throwable -> L12
        return;
    L6:
        r1 = new ArrayList();     // Catch: Throwable -> L12
        goto L7
    }

    public Map<String, Integer> selectResolution(IVideoModel r2, int r3, Map<String, String> r4, GearStrategyContext r5) {
        String r6 = getCenter().y(r2.toMediaInfoJsonString(), r3, _mapToString(r4), r5);
        if (TextUtils.isEmpty(r6) == false) goto L7;
        TTVideoEngineLog.d(TAG, "[GearStrategy]StrategyHelper.selectResolution result invalid retString=" + r6);
        return null;
    L7:
        return _stringToIntValueMap(r6);
    }

    public Map<String, Integer> selectResolutionStringMap(IVideoModel r4, int r5, Map<String, String> r6, GearStrategyContext r7) {
        TTVideoEngineLog.i(TAG, "[GearStrategy]GearStrategy called");
        if (EngineGlobalConfig.getInstance().getEnableSelectUseObject() != 1) goto L5;
        String r8 = getCenter().A(r4.getMediaInfo(), r5, _mapToString(r6), r7);
    L7:
        if (TextUtils.isEmpty(r8) == false) goto L10;
        TTVideoEngineLog.d(TAG, "[GearStrategy]StrategyHelper.selectResolution result invalid retString=" + r8);
        return null;
    L10:
        HashMap r9 = new HashMap();
        _stringToMap(r8, r9);
        if (r6 == null) goto L13;
        r6.putAll(r9);
    L13:
        HashMap r10 = new HashMap();
        if (r9.containsKey("video") == false) goto L19;
        String r11 = (String) r9.get("video");
        if (r11 == null) goto L19;
        r10.put("video", Integer.valueOf(CastIntegerProtector.parseInt(r11)));
    L19:
        if (r9.containsKey("audio") == false) goto L23;
        String r12 = (String) r9.get("audio");
        if (r12 == null) goto L23;
        r10.put("audio", Integer.valueOf(CastIntegerProtector.parseInt(r12)));
    L23:
        return r10;
    L5:
        r8 = getCenter().z(r4.toMediaInfoJsonString(), r5, _mapToString(r6), r7);
        goto L7
    }
}
