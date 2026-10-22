package com.obric.cae.userAware;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.obric.cae.libs.cloud.a;
import com.obric.cae.libs.cloud.b;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class UserAwareCloudBinderClient {
    private static final int BIND_RETRY_INTERVAL_MS = 2000;
    private static final int CAE_CONFIG_MODULE_USER_AWARE = 6;
    private static final String TAG = "UserAwareCloudBinderClient";
    private static a sService;
    private CaeCloudEventCallbackWrapper mCallbackWrapper;
    private final ServiceConnection mConnection;
    private final Context mContext;
    private final ServiceDeathRecipient mDeathRecipient;
    private final Handler mHandler;
    private final ReentrantReadWriteLock mServiceLock;

    public class CaeCloudEventCallbackWrapper extends b.a {
        final /* synthetic */ UserAwareCloudBinderClient this$0;

        private CaeCloudEventCallbackWrapper(UserAwareCloudBinderClient r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ CaeCloudEventCallbackWrapper(UserAwareCloudBinderClient r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void addRegistration() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (UserAwareCloudBinderClient.access$300() != null) goto L15;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L15:
            UserAwareCloudBinderClient.access$300().a(6, this);     // Catch: RemoteException -> L8 Throwable -> L12
        L8:
            e = move-exception;
            com.obric.cae.log.a.i(UserAwareCloudBinderClient.access$100(), "" + e);     // Catch: Throwable -> L12
            goto L10
        }

        @Override // com.obric.cae.libs.cloud.b
        public void onCloudDataChange(String r4) {
            com.obric.cae.log.a.c(UserAwareCloudBinderClient.access$100(), "onCloudDataChange: " + r4);
            UserAwareCloudBinderClient.access$700(this.this$0, r4);
        }

        @Override // com.obric.cae.libs.cloud.b
        public void onPostStateChange(int r1, String r2, String r3) {
        }

        public void removeRegistration() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (UserAwareCloudBinderClient.access$300() != null) goto L15;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L15:
            UserAwareCloudBinderClient.access$300().b(this);     // Catch: RemoteException -> L8 Throwable -> L12
        L8:
            e = move-exception;
            com.obric.cae.log.a.i(UserAwareCloudBinderClient.access$100(), "" + e);     // Catch: Throwable -> L12
            goto L10
        }
    }

    public class ServiceDeathRecipient implements IBinder.DeathRecipient {
        final /* synthetic */ UserAwareCloudBinderClient this$0;

        private ServiceDeathRecipient(UserAwareCloudBinderClient r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ ServiceDeathRecipient(UserAwareCloudBinderClient r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ void lambda$binderDied$0(UserAwareCloudBinderClient r0) {
            UserAwareCloudBinderClient.access$900(r0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            com.obric.cae.log.a.i(UserAwareCloudBinderClient.access$100(), "cae cloud service is dead !!!");
            UserAwareCloudBinderClient.access$200(this.this$0).writeLock().lock();
            UserAwareCloudBinderClient.access$302(null);
            Handler r0 = UserAwareCloudBinderClient.access$800(this.this$0);
            final UserAwareCloudBinderClient r1 = this.this$0;
            r0.postDelayed(new $$Lambda$UserAwareCloudBinderClient$ServiceDeathRecipient$TN5xrKIw2FCZb5Cp58mL1mBKRU(r1), 2000);
            UserAwareCloudBinderClient.access$200(this.this$0).writeLock().unlock();
        }
    }

    public UserAwareCloudBinderClient(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mServiceLock = new ReentrantReadWriteLock();
        this.mConnection = new AnonymousClass1(this);
        this.mContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mDeathRecipient = new ServiceDeathRecipient(this, null);
        doBind();
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ ReentrantReadWriteLock access$200(UserAwareCloudBinderClient r0) {
        return r0.mServiceLock;
    }

    public static /* synthetic */ a access$300() {
        return sService;
    }

    public static /* synthetic */ a access$302(a r2) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
        sService = r3;
        return r3;
    }

    public static /* synthetic */ ServiceDeathRecipient access$400(UserAwareCloudBinderClient r0) {
        return r0.mDeathRecipient;
    }

    public static /* synthetic */ CaeCloudEventCallbackWrapper access$500(UserAwareCloudBinderClient r0) {
        return r0.mCallbackWrapper;
    }

    public static /* synthetic */ CaeCloudEventCallbackWrapper access$502(UserAwareCloudBinderClient r0, CaeCloudEventCallbackWrapper r1) {
        r0.mCallbackWrapper = r1;
        return r1;
    }

    public static /* synthetic */ void access$700(UserAwareCloudBinderClient r0, String r1) {
        r0.handleDataChange(r1);
    }

    public static /* synthetic */ Handler access$800(UserAwareCloudBinderClient r0) {
        return r0.mHandler;
    }

    public static /* synthetic */ void access$900(UserAwareCloudBinderClient r0) {
        r0.attemptDeadServiceRecovery();
    }

    private void attemptDeadServiceRecovery() {
        com.obric.cae.log.a.c(TAG, "Attempting to recover dead cloud service...");
        doBind();
    }

    public static String buildScanSpecRawForPersistence(JSONObject r2) {
        JSONObject r0 = new JSONObject();
        copyIfPresent(r2, r0, "version");
        copyIfPresent(r2, r0, "global");
        copyIfPresent(r2, r0, "scenes");
        return r0.toString();
    }

    public static boolean containsScanSpecSections(JSONObject r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.has("global") == false) goto L6;
    L7:
        return true;
    L6:
        if (r1.has("scenes") == false) goto L8;
        goto L7
    }

    private static void copyIfPresent(JSONObject r1, JSONObject r2, String r3) {
        if (r1.has(r3) == false) goto L6;
        r2.put(r3, r1.opt(r3));
        return;
    }

    private void doBind() {
        ServiceConnection r1 = this.mConnection;
        monitor-enter(r1);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (sService != null) goto L15;
        String r2 = TAG;     // Catch: Throwable -> L17
        com.obric.cae.log.a.c(r2, "Binding cae cloud service...");     // Catch: Throwable -> L17
        Intent r3 = new Intent(a.class.getName());     // Catch: Throwable -> L17
        ResolveInfo r4 = this.mContext.getPackageManager().resolveService(r3, 0);     // Catch: Throwable -> L17
        if (r4 == null) goto L9;
        ServiceInfo r5 = r4.serviceInfo;     // Catch: Throwable -> L17
        ComponentName r6 = new ComponentName(r5.packageName, r5.name);     // Catch: Throwable -> L17
    L10:
        r3.setComponent(r6);     // Catch: Throwable -> L17
        if (r6 != null) goto L13;
    L14:
        com.obric.cae.log.a.i(r2, "Fail to bind to: " + r3);     // Catch: Throwable -> L17
        goto L15
    L13:
        if (ZeusTransformUtils.bindService(this.mContext, r3, this.mConnection, 65, "com.obric.memorydata.plugin") == true) goto L15;
    L9:
        r6 = null;
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L17
    }

    private void doUnbind() {
        ServiceConnection r0 = this.mConnection;
        monitor-enter(r0);
        com.obric.cae.log.a.c(TAG, "Unbinding cae cloud service...");     // Catch: Throwable -> L13
        if (sService == null) goto L7;
        ZeusTransformUtils.unbindService(this.mContext, this.mConnection, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
    L7:
        CaeCloudEventCallbackWrapper r1 = this.mCallbackWrapper;     // Catch: Throwable -> L13
        if (r1 == null) goto L10;
        r1.removeRegistration();     // Catch: Throwable -> L13
        this.mCallbackWrapper = null;     // Catch: Throwable -> L13
    L10:
        this.mServiceLock.writeLock().lock();     // Catch: Throwable -> L13
        this.mServiceLock.writeLock().unlock();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private String getJsonConfigString(JSONObject r3, String r4) {
        JSONObject r2 = r3.optJSONObject(r4);
        if (r2 != null) goto L5;
        String r5 = r3.optString(r4, "");
        if (TextUtils.isEmpty(r5) == false) goto L13;
        return "";
    L13:
        return new JSONObject(r5).toString();
    L11:
        com.obric.cae.log.a.i(TAG, "Invalid json config for " + r4);
        return "";
    L5:
        return r2.toString();
    }

    private void handleDataChange(String r41) {
        JSONObject r13 = new JSONObject(r41);     // Catch: JSONException -> L115
        if (r13.has(AwareStateListener.SETTINGS_GLOBAL_USER_PERIODIC_UPLOAD_MODE) == false) goto L10;
        String r38 = AwareStateListener.SETTINGS_GLOBAL_ENABLE_POI_DETECT_FUNCTION;
        int r14 = r13.optInt(AwareStateListener.SETTINGS_GLOBAL_USER_PERIODIC_UPLOAD_MODE, -1);     // Catch: JSONException -> L115
        String r39 = "Persist wifi scan function to Settings.Global: value=";
        com.obric.cae.log.a.c(TAG, "debugMode: " + r14);     // Catch: JSONException -> L115
        if (r14 != 0) goto L8;
    L9:
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_USER_PERIODIC_UPLOAD_MODE, r14);     // Catch: JSONException -> L115
    L12:
        if (r13.has(AwareStateListener.SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH) == false) goto L21;
        String r4 = r13.optString(AwareStateListener.SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH);     // Catch: JSONException -> L115
        if (TextUtils.isEmpty(r4) == true) goto L21;
        com.obric.cae.log.a.c(TAG, "feedbackSwitch: " + r4);     // Catch: JSONException -> L115
        if (r4.equals("1") == false) goto L18;
    L19:
        Settings.Global.putString(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH, r4);     // Catch: JSONException -> L115
        goto L21
    L18:
        if (r4.equals("0") == true) goto L19;
    L21:
        if (containsScanSpecSections(r13) == false) goto L29;
        String r0 = buildScanSpecRawForPersistence(r13);     // Catch: JSONException -> L26
        String r5 = TAG;     // Catch: JSONException -> L26
        com.obric.cae.log.a.c(r5, "Persisting normalized scan-spec via WifiScanConfigProvider (rawLength=" + r0.length() + ", cloudLength=" + r41.length() + ")");     // Catch: JSONException -> L26
        if (WifiScanConfigProvider.getInstance(this.mContext).saveSpecConfigJson(r0) == true) goto L29;
        com.obric.cae.log.a.g(r5, "Scan-spec raw envelope failed to persist. SP kept previous value.");     // Catch: JSONException -> L26
    L26:
        e = move-exception;
        com.obric.cae.log.a.i(TAG, "Normalize scan-spec raw failed: " + e);     // Catch: JSONException -> L115
    L29:
        if (r13.has("cae_user_aware_scan_tuning_enable") == false) goto L34;
        int r1 = r13.optInt("cae_user_aware_scan_tuning_enable", -1);     // Catch: JSONException -> L115
        com.obric.cae.log.a.c(TAG, "cae_user_aware_scan_tuning_enable : " + r1);     // Catch: JSONException -> L115
        if (CommSenseScanTuningConfig.isValidScanTuningEnable(r1) == false) goto L34;
        CommSenseScanTuningConfig.saveScanTuningEnable(this.mContext, r1);     // Catch: JSONException -> L115
    L34:
        if (r13.has("cae_user_aware_scan_tuning_profile") == false) goto L39;
        String r2 = getJsonConfigString(r13, "cae_user_aware_scan_tuning_profile");     // Catch: JSONException -> L115
        if (TextUtils.isEmpty(r2) == true) goto L39;
        com.obric.cae.log.a.c(TAG, "Saving scan_tuning_profile to SharedPreferences");     // Catch: JSONException -> L115
        CommSenseScanTuningConfig.saveScanTuningProfile(this.mContext, r2);     // Catch: JSONException -> L115
    L39:
        if (r13.has(AwareStateListener.SETTINGS_GLOBAL_ENABLE_WIFI_SCAN_FUNCTION) == false) goto L44;
        int r3 = r13.optInt(AwareStateListener.SETTINGS_GLOBAL_ENABLE_WIFI_SCAN_FUNCTION);     // Catch: JSONException -> L115
        String r6 = TAG;     // Catch: JSONException -> L115
        com.obric.cae.log.a.c(r6, "cae_user_aware_enable_wifi_scan_function : " + r3);     // Catch: JSONException -> L115
        if (r3 == 1) goto L43;
        if (r3 != 0) goto L44;
    L43:
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_WIFI_SCAN_FUNCTION, r3);     // Catch: JSONException -> L115
        com.obric.cae.log.a.e(r6, r39 + r3);     // Catch: JSONException -> L115
    L44:
        String r7 = r38;
        if (r13.has(r7) == false) goto L51;
        int r8 = r13.optInt(r7);     // Catch: JSONException -> L115
        com.obric.cae.log.a.c(TAG, "cae_user_aware_enable_poi_detect_function : " + r8);     // Catch: JSONException -> L115
        if (r8 == 1) goto L49;
        if (r8 != 0) goto L51;
    L49:
        Settings.Global.putInt(this.mContext.getContentResolver(), r7, r8);     // Catch: JSONException -> L115
    L51:
        if (r13.has(AwareStateListener.SETTINGS_GLOBAL_POI_TRIGGER_MODE) == false) goto L58;
        int r9 = r13.optInt(AwareStateListener.SETTINGS_GLOBAL_POI_TRIGGER_MODE, 0);     // Catch: JSONException -> L115
        if (r9 < 0) goto L58;
        if (r9 > 2) goto L58;
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_POI_TRIGGER_MODE, r9);     // Catch: JSONException -> L115
    L58:
        if (r13.has(AwareStateListener.SETTINGS_GLOBAL_POI_CONFIDENCE_THRESHOLD) == false) goto L70;
        Object r10 = r13.opt(AwareStateListener.SETTINGS_GLOBAL_POI_CONFIDENCE_THRESHOLD);     // Catch: JSONException -> L115
        if (ZeusTransformUtils.instanceOf(r10, Number.class) == false) goto L68;
        double r11 = ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).doubleValue();     // Catch: JSONException -> L115
        String r12 = TAG;     // Catch: JSONException -> L115
        com.obric.cae.log.a.c(r12, "cae_user_aware_poi_confidence_threshold : " + r11);     // Catch: JSONException -> L115
        if (r11 >= 0.0d) goto L64;
    L66:
        String r15 = "ignore invalid poi confidence threshold=" + r11;     // Catch: JSONException -> L115
    L67:
        com.obric.cae.log.a.g(r12, r15);     // Catch: JSONException -> L115
        goto L70
    L64:
        if (r11 > 1.0d) goto L66;
        Settings.Global.putFloat(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_POI_CONFIDENCE_THRESHOLD, (float) r11);     // Catch: JSONException -> L115
        goto L70
    L68:
        r12 = TAG;     // Catch: JSONException -> L115
        r15 = "ignore non-number poi confidence threshold";
    L70:
        if (r13.has(AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_DELAY_SECONDS) == false) goto L75;
        int r16 = r13.optInt(AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_DELAY_SECONDS, 20);     // Catch: JSONException -> L115
        com.obric.cae.log.a.c(TAG, "cae_user_aware_poi_stationary_delay_seconds : " + r16);     // Catch: JSONException -> L115
        if (r16 <= 0) goto L75;
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_DELAY_SECONDS, r16);     // Catch: JSONException -> L115
    L75:
        if (r13.has(AwareStateListener.SETTINGS_GLOBAL_POI_WALK_STEP_THRESHOLD) == false) goto L80;
        int r17 = r13.optInt(AwareStateListener.SETTINGS_GLOBAL_POI_WALK_STEP_THRESHOLD, AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD);     // Catch: JSONException -> L115
        com.obric.cae.log.a.c(TAG, "cae_user_aware_poi_walk_step_threshold : " + r17);     // Catch: JSONException -> L115
        if (r17 <= 0) goto L80;
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_POI_WALK_STEP_THRESHOLD, r17);     // Catch: JSONException -> L115
    L80:
        if (r13.has(AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_DELTA_THRESHOLD) == false) goto L85;
        int r18 = r13.optInt(AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_DELTA_THRESHOLD, 10);     // Catch: JSONException -> L115
        com.obric.cae.log.a.c(TAG, "cae_user_aware_poi_stationary_step_delta_threshold : " + r18);     // Catch: JSONException -> L115
        if (r18 <= 0) goto L85;
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_DELTA_THRESHOLD, r18);     // Catch: JSONException -> L115
    L85:
        if (r13.has(AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_CHECK_INTERVAL_MS) == false) goto L90;
        long r19 = r13.optLong(AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_CHECK_INTERVAL_MS, 60000);     // Catch: JSONException -> L115
        com.obric.cae.log.a.c(TAG, "cae_user_aware_poi_stationary_step_check_interval_ms : " + r19);     // Catch: JSONException -> L115
        if (r19 <= 0) goto L90;
        Settings.Global.putLong(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_CHECK_INTERVAL_MS, r19);     // Catch: JSONException -> L115
    L90:
        if (r13.has(AwareStateListener.SETTINGS_GLOBAL_WIFI_SCAN_DAILY_CAP) == false) goto L95;
        int r20 = r13.optInt(AwareStateListener.SETTINGS_GLOBAL_WIFI_SCAN_DAILY_CAP, 300);     // Catch: JSONException -> L115
        com.obric.cae.log.a.c(TAG, "cae_user_aware_wifi_scan_daily_cap : " + r20);     // Catch: JSONException -> L115
        if (r20 < 0) goto L95;
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_WIFI_SCAN_DAILY_CAP, r20);     // Catch: JSONException -> L115
    L95:
        if (r13.has(AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR) == false) goto L102;
        int r21 = r13.optInt(AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR);     // Catch: JSONException -> L115
        com.obric.cae.log.a.c(TAG, "cae_user_aware_enable_har : " + r21);     // Catch: JSONException -> L115
        if (r21 != 0) goto L99;
    L100:
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR, r21);     // Catch: JSONException -> L115
        goto L102
    L99:
        if (r21 == 1) goto L100;
    L102:
        if (r13.has(AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR_NOTIFICATION) == false) goto L109;
        int r22 = r13.optInt(AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR_NOTIFICATION);     // Catch: JSONException -> L115
        com.obric.cae.log.a.c(TAG, "cae_user_har_collect_local : " + r22);     // Catch: JSONException -> L115
        if (r22 < 0) goto L106;
    L107:
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR_NOTIFICATION, r22);     // Catch: JSONException -> L115
        goto L109
    L106:
        if (r22 == 1) goto L107;
    L109:
        if (r13.has(AwareStateListener.SETTINGS_GLOBAL_HAR_RAW_DATA_REPORT) == false) goto L122;
        int r23 = r13.optInt(AwareStateListener.SETTINGS_GLOBAL_HAR_RAW_DATA_REPORT);     // Catch: JSONException -> L115
        com.obric.cae.log.a.c(TAG, "cae_user_har_get_wakelock_time : " + r23);     // Catch: JSONException -> L115
        if (r23 == 1) goto L113;
        if (r23 == 0) goto L113;
        return;
    L113:
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_HAR_RAW_DATA_REPORT, r23);     // Catch: JSONException -> L115
        return;
    L122:
        return;
    L8:
        if (r14 != 1) goto L12;
    L10:
        r39 = "Persist wifi scan function to Settings.Global: value=";
        r38 = AwareStateListener.SETTINGS_GLOBAL_ENABLE_POI_DETECT_FUNCTION;
    L115:
        e = move-exception;
        com.obric.cae.log.a.i(TAG, "handleDataChange: " + e);
    }

    public void close() {
        com.obric.cae.log.a.c(TAG, IslandSession.REOPEN_VALUE_CLOSE);
        CaeCloudEventCallbackWrapper r0 = this.mCallbackWrapper;
        if (r0 == null) goto L5;
        r0.removeRegistration();
        this.mCallbackWrapper = null;
    L5:
        doUnbind();
    }
}
