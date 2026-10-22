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
import com.obric.cae.libs.cloud.ICloud;
import com.obric.cae.libs.cloud.ICloudEventCallback;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UserAwareCloudBinderClient {
    private static final int BIND_RETRY_INTERVAL_MS = 2000;
    private static final int CAE_CONFIG_MODULE_USER_AWARE = 6;
    private static final String TAG = "UserAwareCloudBinderClient";
    private static ICloud sService;
    private CaeCloudEventCallbackWrapper mCallbackWrapper;
    private final ServiceConnection mConnection;
    private final Context mContext;
    private final ServiceDeathRecipient mDeathRecipient;
    private final Handler mHandler;
    private final ReentrantReadWriteLock mServiceLock;

    public class CaeCloudEventCallbackWrapper extends ICloudEventCallback.Stub {
        final /* synthetic */ UserAwareCloudBinderClient this$0;

        private CaeCloudEventCallbackWrapper(UserAwareCloudBinderClient r8) {
            this.this$0 = r8;
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
            UserAwareCloudBinderClient.access$300().registerCallbackWithType(6, this);     // Catch: RemoteException -> L8 Throwable -> L12
        L8:
            e = move-exception;
            CommSenseLog.e(UserAwareCloudBinderClient.access$100(), "" + e);     // Catch: Throwable -> L12
            goto L10
        }

        @Override // com.obric.cae.libs.cloud.ICloudEventCallback
        public void onCloudDataChange(String r8) {
            CommSenseLog.d(UserAwareCloudBinderClient.access$100(), "onCloudDataChange: " + r8);
            UserAwareCloudBinderClient.access$700(this.this$0, r8);
        }

        @Override // com.obric.cae.libs.cloud.ICloudEventCallback
        public void onPostStateChange(int r8, String r10, String r11) {
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
            UserAwareCloudBinderClient.access$300().unregisterCallback(this);     // Catch: RemoteException -> L8 Throwable -> L12
        L8:
            e = move-exception;
            CommSenseLog.e(UserAwareCloudBinderClient.access$100(), "" + e);     // Catch: Throwable -> L12
            goto L10
        }

        public /* synthetic */ CaeCloudEventCallbackWrapper(UserAwareCloudBinderClient r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class ServiceDeathRecipient implements IBinder.DeathRecipient {
        final /* synthetic */ UserAwareCloudBinderClient this$0;

        private ServiceDeathRecipient(UserAwareCloudBinderClient r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(UserAwareCloudBinderClient r8) {
            lambda$binderDied$0(r8);
        }

        private static /* synthetic */ void lambda$binderDied$0(UserAwareCloudBinderClient r8) {
            UserAwareCloudBinderClient.access$900(r8);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            CommSenseLog.e(UserAwareCloudBinderClient.access$100(), "cae cloud service is dead !!!");
            UserAwareCloudBinderClient.access$200(this.this$0).writeLock().lock();
            UserAwareCloudBinderClient.access$302(null);
            UserAwareCloudBinderClient.access$800(this.this$0).postDelayed(new g(this.this$0, 1), 2000);
            UserAwareCloudBinderClient.access$200(this.this$0).writeLock().unlock();
        }

        public /* synthetic */ ServiceDeathRecipient(UserAwareCloudBinderClient r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public UserAwareCloudBinderClient(Context r8) {
        this.mServiceLock = new ReentrantReadWriteLock();
        this.mConnection = new AnonymousClass1(this);
        this.mContext = r8;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mDeathRecipient = new ServiceDeathRecipient(this, null);
        doBind();
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ ReentrantReadWriteLock access$200(UserAwareCloudBinderClient r8) {
        return r8.mServiceLock;
    }

    public static /* synthetic */ ICloud access$300() {
        return sService;
    }

    public static /* synthetic */ ICloud access$302(ICloud r8) {
        sService = r8;
        return r8;
    }

    public static /* synthetic */ ServiceDeathRecipient access$400(UserAwareCloudBinderClient r8) {
        return r8.mDeathRecipient;
    }

    public static /* synthetic */ CaeCloudEventCallbackWrapper access$500(UserAwareCloudBinderClient r8) {
        return r8.mCallbackWrapper;
    }

    public static /* synthetic */ CaeCloudEventCallbackWrapper access$502(UserAwareCloudBinderClient r8, CaeCloudEventCallbackWrapper r10) {
        r8.mCallbackWrapper = r10;
        return r10;
    }

    public static /* synthetic */ void access$700(UserAwareCloudBinderClient r8, String r10) {
        r8.handleDataChange(r10);
    }

    public static /* synthetic */ Handler access$800(UserAwareCloudBinderClient r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ void access$900(UserAwareCloudBinderClient r8) {
        r8.attemptDeadServiceRecovery();
    }

    private void attemptDeadServiceRecovery() {
        CommSenseLog.d(TAG, "Attempting to recover dead cloud service...");
        doBind();
    }

    private void doBind() {
        ServiceConnection r8 = this.mConnection;
        monitor-enter(r8);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (sService != null) goto L15;
        String r10 = TAG;     // Catch: Throwable -> L17
        CommSenseLog.d(r10, "Binding cae cloud service...");     // Catch: Throwable -> L17
        Intent r11 = new Intent(ICloud.class.getName());     // Catch: Throwable -> L17
        ResolveInfo r12 = this.mContext.getPackageManager().resolveService(r11, 0);     // Catch: Throwable -> L17
        if (r12 == null) goto L9;
        ServiceInfo r13 = r12.serviceInfo;     // Catch: Throwable -> L17
        ComponentName r14 = new ComponentName(r13.packageName, r13.name);     // Catch: Throwable -> L17
    L10:
        r11.setComponent(r14);     // Catch: Throwable -> L17
        if (r14 != null) goto L13;
    L14:
        CommSenseLog.e(r10, "Fail to bind to: " + r11);     // Catch: Throwable -> L17
        goto L15
    L13:
        if (this.mContext.bindService(r11, this.mConnection, 65) == true) goto L15;
    L9:
        r14 = null;
    L15:
        monitor-exit(r8);     // Catch: Throwable -> L17
    }

    private void doUnbind() {
        ServiceConnection r8 = this.mConnection;
        monitor-enter(r8);
        CommSenseLog.d(TAG, "Unbinding cae cloud service...");     // Catch: Throwable -> L13
        if (sService == null) goto L7;
        this.mContext.unbindService(this.mConnection);     // Catch: Throwable -> L13
    L7:
        CaeCloudEventCallbackWrapper r10 = this.mCallbackWrapper;     // Catch: Throwable -> L13
        if (r10 == null) goto L10;
        r10.removeRegistration();     // Catch: Throwable -> L13
        this.mCallbackWrapper = null;     // Catch: Throwable -> L13
    L10:
        this.mServiceLock.writeLock().lock();     // Catch: Throwable -> L13
        this.mServiceLock.writeLock().unlock();     // Catch: Throwable -> L13
        monitor-exit(r8);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private void handleDataChange(String r39) {
        JSONObject r10 = new JSONObject(r39);     // Catch: JSONException -> L104
        if (r10.has(AwareStateListener.SETTINGS_GLOBAL_USER_PERIODIC_UPLOAD_MODE) == false) goto L10;
        int r8 = r10.optInt(AwareStateListener.SETTINGS_GLOBAL_USER_PERIODIC_UPLOAD_MODE, -1);     // Catch: JSONException -> L104
        String r37 = "cae_user_aware_enable_wifi_scan_function : ";
        CommSenseLog.d(TAG, "debugMode: " + r8);     // Catch: JSONException -> L104
        if (r8 != 0) goto L8;
    L9:
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_USER_PERIODIC_UPLOAD_MODE, r8);     // Catch: JSONException -> L104
    L12:
        if (r10.has(AwareStateListener.SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH) == false) goto L21;
        String r11 = r10.optString(AwareStateListener.SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH);     // Catch: JSONException -> L104
        if (TextUtils.isEmpty(r11) == true) goto L21;
        CommSenseLog.d(TAG, "feedbackSwitch: " + r11);     // Catch: JSONException -> L104
        if (r11.equals("1") == false) goto L18;
    L19:
        Settings.Global.putString(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH, r11);     // Catch: JSONException -> L104
        goto L21
    L18:
        if (r11.equals("0") == true) goto L19;
    L21:
        if (r10.has(AwareStateListener.SETTINGS_GLOBAL_NORMAL_SCAN_PARAMS) == false) goto L26;
        JSONObject r12 = r10.optJSONObject(AwareStateListener.SETTINGS_GLOBAL_NORMAL_SCAN_PARAMS);     // Catch: JSONException -> L104
        if (r12 == null) goto L26;
        CommSenseLog.d(TAG, "Saving normal_scan_params to Settings.Global: " + r12.toString());     // Catch: JSONException -> L104
        Settings.Global.putString(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_NORMAL_SCAN_PARAMS, r12.toString());     // Catch: JSONException -> L104
    L26:
        if (r10.has(AwareStateListener.SETTINGS_GLOBAL_TRAINING_SCAN_PARAMS) == false) goto L31;
        JSONObject r13 = r10.optJSONObject(AwareStateListener.SETTINGS_GLOBAL_TRAINING_SCAN_PARAMS);     // Catch: JSONException -> L104
        if (r13 == null) goto L31;
        CommSenseLog.d(TAG, "Saving training_scan_params to Settings.Global: " + r13.toString());     // Catch: JSONException -> L104
        Settings.Global.putString(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_TRAINING_SCAN_PARAMS, r13.toString());     // Catch: JSONException -> L104
    L31:
        if (r10.has(AwareStateListener.SETTINGS_GLOBAL_NORMAL_RSSI_DROP_LIST) == false) goto L36;
        JSONArray r14 = r10.optJSONArray(AwareStateListener.SETTINGS_GLOBAL_NORMAL_RSSI_DROP_LIST);     // Catch: JSONException -> L104
        if (r14 == null) goto L36;
        CommSenseLog.d(TAG, "Saving normal_rssi_drop_thresholds to Settings.Global: " + r14.toString());     // Catch: JSONException -> L104
        Settings.Global.putString(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_NORMAL_RSSI_DROP_LIST, r14.toString());     // Catch: JSONException -> L104
    L36:
        if (r10.has(AwareStateListener.SETTINGS_GLOBAL_ENABLE_WIFI_SCAN_FUNCTION) == false) goto L42;
        int r15 = r10.optInt(AwareStateListener.SETTINGS_GLOBAL_ENABLE_WIFI_SCAN_FUNCTION);     // Catch: JSONException -> L104
        CommSenseLog.d(TAG, r37 + r15);     // Catch: JSONException -> L104
        if (r15 == 1) goto L40;
        if (r15 != 0) goto L42;
    L40:
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_WIFI_SCAN_FUNCTION, r15);     // Catch: JSONException -> L104
    L42:
        if (r10.has(AwareStateListener.SETTINGS_GLOBAL_ENABLE_POI_DETECT_FUNCTION) == false) goto L48;
        int r16 = r10.optInt(AwareStateListener.SETTINGS_GLOBAL_ENABLE_POI_DETECT_FUNCTION);     // Catch: JSONException -> L104
        CommSenseLog.d(TAG, "cae_user_aware_enable_poi_detect_function : " + r16);     // Catch: JSONException -> L104
        if (r16 == 1) goto L46;
        if (r16 != 0) goto L48;
    L46:
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_POI_DETECT_FUNCTION, r16);     // Catch: JSONException -> L104
    L48:
        if (r10.has(AwareStateListener.SETTINGS_GLOBAL_POI_CONFIDENCE_THRESHOLD) == false) goto L59;
        Object r17 = r10.opt(AwareStateListener.SETTINGS_GLOBAL_POI_CONFIDENCE_THRESHOLD);     // Catch: JSONException -> L104
        if ((r17 instanceof Number) == false) goto L57;
        double r18 = ((Number) r17).doubleValue();     // Catch: JSONException -> L104
        String r19 = TAG;     // Catch: JSONException -> L104
        CommSenseLog.d(r19, "cae_user_aware_poi_confidence_threshold : " + r18);     // Catch: JSONException -> L104
        if (r18 >= 0.0d) goto L54;
    L56:
        CommSenseLog.w(r19, "ignore invalid poi confidence threshold=" + r18);     // Catch: JSONException -> L104
        goto L59
    L54:
        if (r18 > 1.0d) goto L56;
        Settings.Global.putFloat(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_POI_CONFIDENCE_THRESHOLD, (float) r18);     // Catch: JSONException -> L104
        goto L59
    L57:
        CommSenseLog.w(TAG, "ignore non-number poi confidence threshold");     // Catch: JSONException -> L104
    L59:
        if (r10.has(AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_DELAY_SECONDS) == false) goto L64;
        int r20 = r10.optInt(AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_DELAY_SECONDS, 20);     // Catch: JSONException -> L104
        CommSenseLog.d(TAG, "cae_user_aware_poi_stationary_delay_seconds : " + r20);     // Catch: JSONException -> L104
        if (r20 <= 0) goto L64;
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_DELAY_SECONDS, r20);     // Catch: JSONException -> L104
    L64:
        if (r10.has(AwareStateListener.SETTINGS_GLOBAL_POI_WALK_STEP_THRESHOLD) == false) goto L69;
        int r21 = r10.optInt(AwareStateListener.SETTINGS_GLOBAL_POI_WALK_STEP_THRESHOLD, AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD);     // Catch: JSONException -> L104
        CommSenseLog.d(TAG, "cae_user_aware_poi_walk_step_threshold : " + r21);     // Catch: JSONException -> L104
        if (r21 <= 0) goto L69;
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_POI_WALK_STEP_THRESHOLD, r21);     // Catch: JSONException -> L104
    L69:
        if (r10.has(AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_DELTA_THRESHOLD) == false) goto L74;
        int r22 = r10.optInt(AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_DELTA_THRESHOLD, 10);     // Catch: JSONException -> L104
        CommSenseLog.d(TAG, "cae_user_aware_poi_stationary_step_delta_threshold : " + r22);     // Catch: JSONException -> L104
        if (r22 <= 0) goto L74;
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_DELTA_THRESHOLD, r22);     // Catch: JSONException -> L104
    L74:
        if (r10.has(AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_CHECK_INTERVAL_MS) == false) goto L79;
        long r23 = r10.optLong(AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_CHECK_INTERVAL_MS, 60000);     // Catch: JSONException -> L104
        CommSenseLog.d(TAG, "cae_user_aware_poi_stationary_step_check_interval_ms : " + r23);     // Catch: JSONException -> L104
        if (r23 <= 0) goto L79;
        Settings.Global.putLong(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_CHECK_INTERVAL_MS, r23);     // Catch: JSONException -> L104
    L79:
        if (r10.has(AwareStateListener.SETTINGS_GLOBAL_WIFI_SCAN_DAILY_CAP) == false) goto L84;
        int r24 = r10.optInt(AwareStateListener.SETTINGS_GLOBAL_WIFI_SCAN_DAILY_CAP, 500);     // Catch: JSONException -> L104
        CommSenseLog.d(TAG, "cae_user_aware_wifi_scan_daily_cap : " + r24);     // Catch: JSONException -> L104
        if (r24 < 0) goto L84;
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_WIFI_SCAN_DAILY_CAP, r24);     // Catch: JSONException -> L104
    L84:
        if (r10.has(AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR) == false) goto L91;
        int r25 = r10.optInt(AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR);     // Catch: JSONException -> L104
        CommSenseLog.d(TAG, "cae_user_aware_enable_har : " + r25);     // Catch: JSONException -> L104
        if (r25 != 0) goto L88;
    L89:
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR, r25);     // Catch: JSONException -> L104
        goto L91
    L88:
        if (r25 == 1) goto L89;
    L91:
        if (r10.has(AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR_NOTIFICATION) == false) goto L98;
        int r26 = r10.optInt(AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR_NOTIFICATION);     // Catch: JSONException -> L104
        CommSenseLog.d(TAG, "cae_user_har_collect_local : " + r26);     // Catch: JSONException -> L104
        if (r26 < 0) goto L95;
    L96:
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR_NOTIFICATION, r26);     // Catch: JSONException -> L104
        goto L98
    L95:
        if (r26 == 1) goto L96;
    L98:
        if (r10.has(AwareStateListener.SETTINGS_GLOBAL_HAR_RAW_DATA_REPORT) == false) goto L109;
        int r27 = r10.optInt(AwareStateListener.SETTINGS_GLOBAL_HAR_RAW_DATA_REPORT);     // Catch: JSONException -> L104
        CommSenseLog.d(TAG, "cae_user_har_get_wakelock_time : " + r27);     // Catch: JSONException -> L104
        if (r27 == 1) goto L102;
        if (r27 == 0) goto L102;
        return;
    L102:
        Settings.Global.putInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_HAR_RAW_DATA_REPORT, r27);     // Catch: JSONException -> L104
        return;
    L109:
        return;
    L8:
        if (r8 != 1) goto L12;
    L10:
        r37 = "cae_user_aware_enable_wifi_scan_function : ";
    L104:
        e = move-exception;
        CommSenseLog.e(TAG, "handleDataChange: " + e);
    }

    public void close() {
        CommSenseLog.d(TAG, "close");
        CaeCloudEventCallbackWrapper r8 = this.mCallbackWrapper;
        if (r8 == null) goto L5;
        r8.removeRegistration();
        this.mCallbackWrapper = null;
    L5:
        doUnbind();
    }
}
