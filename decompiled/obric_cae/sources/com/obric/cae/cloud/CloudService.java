package com.obric.cae.cloud;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.text.TextUtils;
import android.util.Pair;
import androidx.activity.j;
import com.obric.cae.cloud.applog.ByteIOUtils;
import com.obric.cae.cloud.ttnet.CaeTtnetManager;
import com.obric.cae.cloud.ttnet.InitTTNetHelper;
import com.obric.cae.libs.cloud.ICloud;
import com.obric.cae.libs.cloud.ICloudEventCallback;
import com.obric.cae.log.CaeLog;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s1.x;

/* JADX INFO: loaded from: classes.dex */
public class CloudService extends Service {
    private static final int MSG_CLOUD_SERVICE_EVENT_POST_CLOUD_DATA = 3;
    private static final int MSG_CLOUD_SERVICE_EVENT_SETTING_INIT = 1;
    private static final int MSG_CLOUD_SERVICE_EVENT_UPDATE_CLOUD_DATA = 2;
    private static final String TAG = "CloudService";
    private final Object cloudDataLock;
    ed.b configObserver;
    private LinkedList<String> mBtCaeQueue;
    private RemoteCallbackList<ICloudEventCallback> mBtCallbacks;
    private boolean mCleaningUp;
    private LinkedList<Pair<String, Integer>> mCloudData;
    private CloudServiceBinder mCloudServiceBinder;
    private Context mContext;
    private LinkedList<String> mGpsCaeQueue;
    private RemoteCallbackList<ICloudEventCallback> mGpsCallbacks;
    private LinkedList<String> mNfcCaeQueue;
    private RemoteCallbackList<ICloudEventCallback> mNfcCallbacks;
    private LinkedList<String> mUserAwareCaeQueue;
    private RemoteCallbackList<ICloudEventCallback> mUserAwareCallbacks;
    private LinkedList<String> mWifiCaeQueue;
    private RemoteCallbackList<ICloudEventCallback> mWifiCallbacks;
    private ServiceHandler serviceHandler;
    private Looper serviceLooper;

    public class CloudServiceBinder extends ICloud.Stub {
        private CloudService mService;
        final /* synthetic */ CloudService this$0;

        public CloudServiceBinder(CloudService r8, CloudService r10) {
            this.this$0 = r8;
            this.mService = r10;
        }

        private void regitsterCallback(int r8, ICloudEventCallback r10) {
            defpackage.a.i("regitsterCallback module ", r8, CloudService.access$100());
            int r11 = 1;
            if (r8 == 1) goto L26;
            r11 = 3;
            if (r8 == 3) goto L23;
            r11 = 4;
            if (r8 == 4) goto L20;
            r11 = 5;
            if (r8 == 5) goto L17;
            r11 = 6;
            if (r8 == 6) goto L14;
            android.aimedia.a.p("not valid module ", r8, CloudService.access$100());
            return;
        L14:
            if (CloudService.access$500(this.this$0) == null) goto L31;
            RemoteCallbackList r12 = CloudService.access$500(this.mService);
        L28:
            r12.register(r10);
            CloudService.access$300(this.this$0, 2, r11);
            return;
        L31:
            return;
        L17:
            if (CloudService.access$700(this.this$0) == null) goto L32;
            r12 = CloudService.access$700(this.mService);
            goto L28
        L32:
            return;
        L20:
            if (CloudService.access$600(this.this$0) == null) goto L33;
            r12 = CloudService.access$600(this.mService);
            goto L28
        L33:
            return;
        L23:
            if (CloudService.access$400(this.this$0) == null) goto L34;
            r12 = CloudService.access$400(this.mService);
            goto L28
        L34:
            return;
        L26:
            if (CloudService.access$200(this.this$0) == null) goto L35;
            r12 = CloudService.access$200(this.mService);
            goto L28
        }

        public void cleanup() {
            this.mService = null;
        }

        public CloudService getService() {
            CloudService r8 = this.mService;
            if (r8 != null) goto L5;
            return null;
        L5:
            if (CloudService.access$000(r8) == true) goto L7;
            return null;
        L7:
            return this.mService;
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void postToCloud(String r8) {
            CloudService.access$800(this.this$0, r8);
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void registerCallback(ICloudEventCallback r8) {
        L8:
            e = move-exception;
            CaeLog.d(CloudService.access$100(), "registerCallback() - Callback # failed (" + e + ")");
            return;
        L3:
            if (this.mService != null) goto L6;
            CaeLog.d(CloudService.access$100(), "registerCallback() - Callback # failed  null");     // Catch: RuntimeException -> L8
            return;
        L6:
            regitsterCallback(-1, r8);     // Catch: RuntimeException -> L8
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void registerCallbackWithType(int r8, ICloudEventCallback r10) {
        L8:
            e = move-exception;
            CaeLog.d(CloudService.access$100(), "registerCallback() - Callback # failed (" + e + ")");
            return;
        L3:
            if (this.mService != null) goto L6;
            CaeLog.e(CloudService.access$100(), "registerCallback() - Callback # failed  null");     // Catch: RuntimeException -> L8
            return;
        L6:
            regitsterCallback(r8, r10);     // Catch: RuntimeException -> L8
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void unregisterCallback(ICloudEventCallback r8) {
            CloudService r10 = this.mService;     // Catch: RuntimeException -> L19
            if (r10 != null) goto L7;
            CaeLog.d(CloudService.access$100(), "unregisterCallback() - Callback # failed  null");     // Catch: RuntimeException -> L19
            return;
        L7:
            if (CloudService.access$200(r10) == null) goto L10;
            CloudService.access$200(this.mService).unregister(r8);     // Catch: RuntimeException -> L19
        L10:
            if (CloudService.access$400(this.mService) == null) goto L13;
            CloudService.access$400(this.mService).unregister(r8);     // Catch: RuntimeException -> L19
        L13:
            if (CloudService.access$600(this.mService) == null) goto L16;
            CloudService.access$600(this.mService).unregister(r8);     // Catch: RuntimeException -> L19
        L16:
            if (CloudService.access$700(this.mService) == null) goto L23;
            CloudService.access$700(this.mService).unregister(r8);     // Catch: RuntimeException -> L19
            return;
        L23:
            return;
        L19:
            e = move-exception;
            CaeLog.d(CloudService.access$100(), "unregisterCallback() - Callback # failed (" + e + ")");
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void updateUserConfigData(int r8, String r10) {
            CloudService.access$900(this.this$0, r8, r10);
        }
    }

    public final class ServiceHandler extends Handler {
        final /* synthetic */ CloudService this$0;

        public ServiceHandler(CloudService r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            String r10 = CloudService.access$100();
            defpackage.a.j(new StringBuilder("event handler: "), r8.what, r10);
            int r11 = r8.what;
            if (r11 != 1) goto L5;
            CloudService.access$1100(this.this$0);
            return;
        L5:
            if (r11 != 2) goto L7;
            CloudService.access$1200(this.this$0, r8.arg1);
            return;
        L7:
            if (r11 != 3) goto L27;
            Object r12 = CloudService.access$1300(this.this$0);
            monitor-enter(r12);
            String r13 = CloudService.access$1400(this.this$0, (String) r8.obj);     // Catch: Throwable -> L17
            if (r13.isEmpty() == true) goto L14;
            CloudService.access$1500(this.this$0).addLast(new Pair(r13, 1));     // Catch: Throwable -> L17
        L14:
            CloudService.access$1600(this.this$0);     // Catch: Throwable -> L17
            monitor-exit(r12);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        }
    }

    public CloudService() {
        this.mCleaningUp = false;
        this.cloudDataLock = new Object();
        this.configObserver = new AnonymousClass2(this);
    }

    public static /* synthetic */ void a(Context r8, Application r10) {
        lambda$initByteIO$1(r8, r10);
    }

    public static /* synthetic */ boolean access$000(CloudService r8) {
        return r8.isAvailable();
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ void access$1000(CloudService r8, String r10, int r11) {
        r8.handleCloudResponseUpdate(r10, r11);
    }

    public static /* synthetic */ void access$1100(CloudService r8) {
        r8.performCloudServiceTask();
    }

    public static /* synthetic */ void access$1200(CloudService r8, int r10) {
        r8.updateCloudDataToUser(r10);
    }

    public static /* synthetic */ Object access$1300(CloudService r8) {
        return r8.cloudDataLock;
    }

    public static /* synthetic */ String access$1400(CloudService r8, String r10) {
        return r8.fillHeaderMsg(r10);
    }

    public static /* synthetic */ LinkedList access$1500(CloudService r8) {
        return r8.mCloudData;
    }

    public static /* synthetic */ void access$1600(CloudService r8) {
        r8.httpPostCloud();
    }

    public static /* synthetic */ void access$1700(CloudService r8, int r10, String r11) {
        r8.handleSettingsUpdate(r10, r11);
    }

    public static /* synthetic */ RemoteCallbackList access$200(CloudService r8) {
        return r8.mBtCallbacks;
    }

    public static /* synthetic */ void access$300(CloudService r8, int r10, int r11) {
        r8.sendCloudServiceMsg(r10, r11);
    }

    public static /* synthetic */ RemoteCallbackList access$400(CloudService r8) {
        return r8.mWifiCallbacks;
    }

    public static /* synthetic */ RemoteCallbackList access$500(CloudService r8) {
        return r8.mUserAwareCallbacks;
    }

    public static /* synthetic */ RemoteCallbackList access$600(CloudService r8) {
        return r8.mNfcCallbacks;
    }

    public static /* synthetic */ RemoteCallbackList access$700(CloudService r8) {
        return r8.mGpsCallbacks;
    }

    public static /* synthetic */ void access$800(CloudService r8, String r10) {
        r8.doPost(r10);
    }

    public static /* synthetic */ void access$900(CloudService r8, int r10, String r11) {
        r8.updateUserProfileWithVersion(r10, r11);
    }

    private void addCloudDataToQueue(LinkedList<String> r8, String r10) {
        if (r8 == null) goto L5;
        r8.offer(r10);
        return;
    }

    public static /* synthetic */ void b(CloudService r8) {
        r8.lambda$onCreate$0();
    }

    private boolean cloudDataQueueIsEmpty(LinkedList<String> r8) {
        if (r8 != null) goto L6;
        return true;
    L6:
        return r8.isEmpty();
    }

    private void doPost(String r8) {
        postCloudData(r8);
    }

    private String fillHeaderMsg(String r8) {
        JSONObject r10 = new JSONObject(r8);     // Catch: JSONException -> L8
        if (r10.has(CloudServiceConstants.OCloud.HEADER) == false) goto L6;
        r10.put("device_id", CaeDeviceInfoHelper.getDeviceId());     // Catch: JSONException -> L8
        r10.put(CloudServiceConstants.OCloud.HEADER_OS_VERSION, CaeDeviceInfoHelper.getDeviceOSVersion());     // Catch: JSONException -> L8
        r10.put("app_version", CaeDeviceInfoHelper.getAppVersion());     // Catch: JSONException -> L8
        return r10.toString();
    L6:
        CaeLog.e(TAG, "Error:no valid header");     // Catch: JSONException -> L8
        return r8;
    L8:
        e = move-exception;
        CaeLog.e(TAG, "fillHeaderMsg " + e.getMessage());
        return null;
    }

    private String getArrayErrorMsg(JSONObject r8) {
        String r10 = "";
        JSONArray r11 = r8.getJSONArray(CloudServiceConstants.OCloud.ERROR_LIST);     // Catch: JSONException -> L8
        int r12 = 0;
    L5:
        if (r12 >= r11.length()) goto L10;
        r10 = r11.getJSONObject(r12).getString("error_message");     // Catch: JSONException -> L8
        r12 = r12 + 1;
    L10:
        return r10;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    private String getErrorMsg(JSONObject r8) {
        return r8.getJSONObject(CloudServiceConstants.OCloud.ERROR_LIST).getString("error_message");
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    private int getModule(JSONObject r8) {
        int r10 = 0;
        JSONArray r11 = r8.getJSONArray(CloudServiceConstants.OCloud.ERROR_LIST);     // Catch: JSONException -> L11
        int r12 = 0;
    L15:
    L9:
        JSONException e10 = e;
    L13:
        e10.printStackTrace();
    L14:
        return r12;
    L6:
        if (r10 >= r11.length()) goto L14;
        r12 = r11.getJSONObject(r10).getInt("module");     // Catch: JSONException -> L9
        r10 = r10 + 1;
    L11:
        e = move-exception;
        r12 = 0;
        e10 = e;
        goto L13
    }

    private String getRemoteMac(JSONObject r8) {
        return r8.getJSONObject(CloudServiceConstants.OCloud.REMOTE_DEVICE_INFO).getString(CloudServiceConstants.OCloud.REMOTE_MAC);
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    private void handleCloudResponseUpdate(String r10, int r11) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        CaeLog.e(TAG, "updateAdapterStat cloudData null or moduleValue unvalid");
        return;
    L6:
        Object r8 = this.cloudDataLock;
        monitor-enter(r8);
        if (r11 == 200) goto L19;
        int r12 = ((Integer) this.mCloudData.getFirst().second).intValue();     // Catch: Throwable -> L45
        if (r12 > 3) goto L20;
        int r13 = r12 + 1;     // Catch: Throwable -> L45
        Pair<String, Integer> r14 = new Pair(r10, Integer.valueOf(r13));     // Catch: Throwable -> L45
        if (this.mCloudData.isEmpty() == true) goto L15;
        this.mCloudData.set(0, r14);     // Catch: Throwable -> L45
    L16:
        httpPostCloud();     // Catch: Throwable -> L45
        CaeLog.d(TAG, "post failed, retry " + r13);     // Catch: Throwable -> L45
        monitor-exit(r8);     // Catch: Throwable -> L45
        return;
    L15:
        this.mCloudData.addFirst(r14);     // Catch: Throwable -> L45
    L20:
        monitor-exit(r8);     // Catch: Throwable -> L45
        JSONObject r15 = new JSONObject(r10);     // Catch: JSONException -> L42
        String r16 = TAG;     // Catch: JSONException -> L42
        CaeLog.i(r16, "cloud data value: " + r10);     // Catch: JSONException -> L42
        if (r15.has(CloudServiceConstants.OCloud.ERROR_LIST) == false) goto L39;
        int r17 = getModule(r15);     // Catch: JSONException -> L42
        String r18 = getRemoteMac(r15);     // Catch: JSONException -> L42
        String r19 = getArrayErrorMsg(r15);     // Catch: JSONException -> L42
        CaeLog.e(r16, "handleCloudResponseUpdate " + r17 + " " + r18 + " " + r19);     // Catch: JSONException -> L42
        if (isModuleValueValid(r17) == false) goto L38;
        if (r17 == 1) goto L35;
        if (r17 != 3) goto L28;
        return;
    L28:
        if (r17 != 4) goto L30;
        return;
    L30:
        if (r17 == 5) goto L32;
        String r20 = "module " + r17 + " is not supported";     // Catch: JSONException -> L42
    L40:
        CaeLog.e(r16, r20);     // Catch: JSONException -> L42
        return;
    L32:
        RemoteCallbackList<ICloudEventCallback> r21 = this.mGpsCallbacks;     // Catch: JSONException -> L42
        if (r21 != null) goto L37;
        return;
    L37:
        notifyCloudResponseCallback(r21, r11, r18, r19);     // Catch: JSONException -> L42
        return;
    L35:
        r21 = this.mBtCallbacks;     // Catch: JSONException -> L42
        if (r21 != null) goto L37;
        return;
    L38:
        r20 = "updateAdapterStat cloudData null or moduleValue unvalid";
        goto L40
    L39:
        r20 = "Error:no valid data error list";
    L42:
        e = move-exception;
        String r110 = TAG;
        StringBuilder r111 = defpackage.b.h("onSettingsUpdate ", r10, " ");
        r111.append(e.getMessage());
        CaeLog.e(r110, r111.toString());
        return;
    L19:
        this.mCloudData.removeFirst();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    private void handleSettingsUpdate(int r8, String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L7;
        CaeLog.e(TAG, "updateAdapterStat cloudData null");
        return;
    L7:
        if (r8 != 1) goto L9;
        addCloudDataToQueue(this.mBtCaeQueue, r10);
        RemoteCallbackList<ICloudEventCallback> r11 = this.mBtCallbacks;
        if (r11 == null) goto L38;
    L31:
        notifyBroadcastCallback(r11, r10);
        return;
    L38:
        return;
    L9:
        if (r8 != 3) goto L11;
        addCloudDataToQueue(this.mWifiCaeQueue, r10);
        r11 = this.mWifiCallbacks;
        if (r11 != null) goto L31;
        return;
    L11:
        if (r8 != 4) goto L13;
        addCloudDataToQueue(this.mNfcCaeQueue, r10);
        r11 = this.mNfcCallbacks;
        if (r11 != null) goto L31;
        return;
    L13:
        if (r8 != 5) goto L15;
        addCloudDataToQueue(this.mGpsCaeQueue, r10);
        r11 = this.mGpsCallbacks;
        if (r11 != null) goto L31;
        return;
    L15:
        if (r8 == 6) goto L17;
        CaeLog.e(TAG, "module value " + r8 + " is not supported");
        return;
    L17:
        addCloudDataToQueue(this.mUserAwareCaeQueue, r10);
        r11 = this.mUserAwareCallbacks;
        if (r11 != null) goto L31;
    }

    private void httpPostCloud() {
        final String r8 = (String) this.mCloudData.getFirst().first;
        InitTTNetHelper.httpPostCloud(r8, new AnonymousClass1(this, r8));
    }

    private void initByteIO() {
        Context r8 = getApplicationContext();
        Application r10 = getApplication();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new x(3, r8, r10));
    }

    private void initCloudDataQueue() {
        this.mBtCallbacks = new RemoteCallbackList();
        this.mWifiCallbacks = new RemoteCallbackList();
        this.mUserAwareCallbacks = new RemoteCallbackList();
        this.mNfcCallbacks = new RemoteCallbackList();
        this.mGpsCallbacks = new RemoteCallbackList();
        this.mBtCaeQueue = new LinkedList();
        this.mWifiCaeQueue = new LinkedList();
        this.mCloudData = new LinkedList();
        this.mUserAwareCaeQueue = new LinkedList();
        this.mNfcCaeQueue = new LinkedList();
        this.mGpsCaeQueue = new LinkedList();
        this.mCloudData = new LinkedList();
    }

    private void initHandlerThread() {
        HandlerThread r8 = new HandlerThread("cloudservice");     // Catch: Exception -> L4
        r8.start();     // Catch: Exception -> L4
        this.serviceLooper = r8.getLooper();     // Catch: Exception -> L4
        this.serviceHandler = new ServiceHandler(this, this.serviceLooper);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        CaeLog.e(TAG, "initHandlerThread error.");
        e.printStackTrace();
    }

    private void initOSettings() {
        sendCloudServiceMsg(1);
    }

    private boolean isAvailable() {
        return !this.mCleaningUp;
    }

    private boolean isModuleValueValid(int r8) {
        if (r8 > (-1)) goto L5;
        return false;
    L5:
        if (r8 > 5) goto L10;
        return true;
    L10:
        return false;
    }

    private static /* synthetic */ void lambda$initByteIO$1(Context r8, Application r10) {
        CaeLog.d(TAG, "Initializing ByteIO in RecordNearbyManager...");     // Catch: Exception -> L4
        ByteIOUtils.init(r8, r10, false);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        CaeLog.e(TAG, "Failed to initialize ByteIO: " + e.getMessage(), e);
    }

    private /* synthetic */ void lambda$onCreate$0() {
        CaeTtnetManager.init(this.mContext, getApplication());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        CaeLog.e(TAG, "Failed to initialize TTNet: " + e.getMessage(), e);
    }

    private void notifyBroadcastCallback(RemoteCallbackList<ICloudEventCallback> r8, String r10) {
        monitor-enter(this);
        int r11 = r8.beginBroadcast();     // Catch: Throwable -> L18
        CaeLog.i(TAG, "notifyBroadcast to " + r11 + " receivers.");     // Catch: Throwable -> L18
        int r12 = 0;
        boolean r13 = false;
    L6:
        if (r12 >= r11) goto L12;
        ((ICloudEventCallback) r8.getBroadcastItem(r12)).onCloudDataChange(r10);     // Catch: Exception -> L9 Throwable -> L18
    L11:
        r12 = r12 + 1;     // Catch: Throwable -> L18
    L9:
        e = move-exception;
        CaeLog.e(TAG, "Broadcast " + r12 + " failed (" + e + ")");     // Catch: Throwable -> L18
        r13 = true;
        goto L11
    L12:
        r8.finishBroadcast();     // Catch: Throwable -> L18
        if (r11 == 0) goto L16;
        if (r13 == true) goto L16;
        removeCloudDataFromQueue(r8);     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private void notifyCloudResponseCallback(RemoteCallbackList<ICloudEventCallback> r8, int r10, String r11, String r12) {
        monitor-enter(this);
        int r13 = r8.beginBroadcast();     // Catch: Throwable -> L14 Exception -> L16
        CaeLog.i(TAG, "notifyCloud Broadcast to " + r13 + " receivers.");     // Catch: Throwable -> L14 Exception -> L16
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L12;
        ((ICloudEventCallback) r8.getBroadcastItem(r14)).onPostStateChange(r10, r11, r12);     // Catch: Exception -> L9 Throwable -> L14
    L11:
        r14 = r14 + 1;
    L9:
        e = move-exception;
        CaeLog.e(TAG, "Broadcast " + r14 + " failed (" + e + ")");     // Catch: Throwable -> L14 Exception -> L16
    L12:
        r8.finishBroadcast();     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L14:
        th = move-exception;
        r8.finishBroadcast();     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L16:
        e = move-exception;
        CaeLog.e(TAG, "beginBroadcast  failed (" + e + ")");     // Catch: Throwable -> L14
        goto L12
    }

    private String peekCloudDataFromQueue(LinkedList<String> r8) {
        if (r8 != null) goto L6;
        return "";
    L6:
        return r8.peek();
    }

    private void performCloudServiceTask() {
        CaeLog.i(TAG, "initOSettings performCloudServiceTask.");
        Context r8 = this.mContext;
        ed.a.f7229a = this.configObserver;
        IntentFilter r10 = new IntentFilter(CloudServiceConstants.OSlardars.CAE_ACTION);
        int r11 = Build.VERSION.SDK_INT;
        ed.a.C0068a r12 = ed.a.f7230b;
        if (r11 < 34) goto L5;
        r8.registerReceiver(r12, r10, "slardaros.intent.permission", null, 2);
        return;
    L5:
        r8.registerReceiver(r12, r10, "slardaros.intent.permission", null);
    }

    private void postCloudData(String r8) {
        sendMessageWithObj(3, r8);
    }

    private void removeCloudDataFromQueue(RemoteCallbackList<ICloudEventCallback> r8) {
        if (r8 != this.mBtCallbacks) goto L6;
        removeCloudDataFromQueue(this.mBtCaeQueue);
        CaeLog.e(TAG, "removeCloudDataFromQueue mBtCaeQueue");
        return;
    L6:
        if (r8 != this.mWifiCallbacks) goto L10;
        LinkedList<String> r10 = this.mWifiCaeQueue;
    L8:
        removeCloudDataFromQueue(r10);
        return;
    L10:
        if (r8 != this.mUserAwareCallbacks) goto L13;
        r10 = this.mUserAwareCaeQueue;
        goto L8
    L13:
        if (r8 != this.mNfcCallbacks) goto L16;
        r10 = this.mNfcCaeQueue;
        goto L8
    L16:
        if (r8 != this.mGpsCallbacks) goto L20;
        r10 = this.mGpsCaeQueue;
        goto L8
    }

    private void sendCloudServiceMsg(int r8) {
        Message r10 = this.serviceHandler.obtainMessage(r8);
        this.serviceHandler.sendMessage(r10);
    }

    private void updateCloudDataToUser(int r8) {
        monitor-enter(this);
        String r10 = TAG;     // Catch: Throwable -> L52
        CaeLog.i(r10, "updateCloudDataToUser " + r8);     // Catch: Throwable -> L52
        if (r8 == 1) goto L44;
        if (r8 == 3) goto L37;
        if (r8 == 4) goto L30;
        if (r8 == 5) goto L23;
        if (r8 == 6) goto L16;
        CaeLog.e(r10, "module value " + r8 + " is not supported");     // Catch: Throwable -> L52
    L50:
        monitor-exit(this);     // Catch: Throwable -> L52
        return;
    L16:
        if (this.mUserAwareCallbacks == null) goto L50;
    L18:
        if (cloudDataQueueIsEmpty(this.mUserAwareCaeQueue) == true) goto L50;
        String r11 = peekCloudDataFromQueue(this.mUserAwareCaeQueue);     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r11) == true) goto L18;
        notifyBroadcastCallback(this.mUserAwareCallbacks, r11);     // Catch: Throwable -> L52
        goto L18
    L23:
        if (this.mGpsCallbacks == null) goto L50;
    L25:
        if (cloudDataQueueIsEmpty(this.mGpsCaeQueue) == true) goto L50;
        String r12 = peekCloudDataFromQueue(this.mGpsCaeQueue);     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r12) == true) goto L25;
        notifyBroadcastCallback(this.mGpsCallbacks, r12);     // Catch: Throwable -> L52
        goto L25
    L30:
        if (this.mNfcCallbacks == null) goto L50;
    L32:
        if (cloudDataQueueIsEmpty(this.mNfcCaeQueue) == true) goto L50;
        String r13 = peekCloudDataFromQueue(this.mNfcCaeQueue);     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r13) == true) goto L32;
        notifyBroadcastCallback(this.mNfcCallbacks, r13);     // Catch: Throwable -> L52
        goto L32
    L37:
        if (this.mWifiCallbacks == null) goto L50;
    L39:
        if (cloudDataQueueIsEmpty(this.mWifiCaeQueue) == true) goto L50;
        String r14 = peekCloudDataFromQueue(this.mWifiCaeQueue);     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r14) == true) goto L39;
        notifyBroadcastCallback(this.mWifiCallbacks, r14);     // Catch: Throwable -> L52
        goto L39
    L44:
        if (this.mBtCallbacks == null) goto L50;
    L46:
        if (cloudDataQueueIsEmpty(this.mBtCaeQueue) == true) goto L50;
        String r15 = peekCloudDataFromQueue(this.mBtCaeQueue);     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r15) == true) goto L46;
        notifyBroadcastCallback(this.mBtCallbacks, r15);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        throw th;
    }

    private void updateUserProfileFromCloud() {
        ed.a.a(this.mContext, "0");
    }

    private void updateUserProfileWithVersion(int r8, String r10) {
        Context r11 = this.mContext;
        if (r8 != 1) goto L5;
        ed.a.a(r11, r10);
        return;
    L5:
        ed.a.a(r11, "0");
    }

    public void cleanup() {
        if (this.mCleaningUp == false) goto L6;
        CaeLog.d(TAG, "Service already starting to cleanup, ignoring request.");
        return;
    L6:
        this.mCleaningUp = true;
        RemoteCallbackList<ICloudEventCallback> r8 = this.mBtCallbacks;
        if (r8 == null) goto L9;
        r8.kill();
    L9:
        RemoteCallbackList<ICloudEventCallback> r10 = this.mWifiCallbacks;
        if (r10 == null) goto L12;
        r10.kill();
    L12:
        RemoteCallbackList<ICloudEventCallback> r11 = this.mNfcCallbacks;
        if (r11 == null) goto L15;
        r11.kill();
    L15:
        RemoteCallbackList<ICloudEventCallback> r12 = this.mGpsCallbacks;
        if (r12 == null) goto L18;
        r12.kill();
    L18:
        RemoteCallbackList<ICloudEventCallback> r13 = this.mUserAwareCallbacks;
        if (r13 == null) goto L21;
        r13.kill();
    L21:
        CloudServiceBinder r14 = this.mCloudServiceBinder;
        if (r14 == null) goto L25;
        r14.cleanup();
        this.mCloudServiceBinder = null;
        return;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r8) {
        CaeLog.i(TAG, "onBind");
        CloudServiceBinder r10 = this.mCloudServiceBinder;
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.app.Service
    public void onCreate() {
        CaeLog.d(TAG, "onCreate");
        this.mContext = this;
        initByteIO();
        initHandlerThread();
        initCloudDataQueue();
        this.mCloudServiceBinder = new CloudServiceBinder(this, this);
        initOSettings();
        this.serviceHandler.post(new j(this, 17));
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        CaeLog.i(TAG, "onDestroy");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r8, int r10, int r11) {
        return super.onStartCommand(r8, r10, r11);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r8) {
        cleanup();
        return super.onUnbind(r8);
    }

    public void sendMessageWithObj(int r8, Object r10) {
        Message r11 = Message.obtain(this.serviceHandler, r8, r10);
        this.serviceHandler.sendMessage(r11);
    }

    private void removeCloudDataFromQueue(LinkedList<String> r8) {
        if (r8 == null) goto L5;
        r8.poll();
        return;
    }

    private void sendCloudServiceMsg(int r8, int r10) {
        Message r11 = this.serviceHandler.obtainMessage(r8);
        r11.arg1 = r10;
        this.serviceHandler.sendMessage(r11);
    }
}
