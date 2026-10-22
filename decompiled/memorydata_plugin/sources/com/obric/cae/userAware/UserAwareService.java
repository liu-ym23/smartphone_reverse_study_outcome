package com.obric.cae.userAware;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.hardware.SensorEvent;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.statemachine.e;
import com.obric.cae.libs.useraware.CellAwareInfo;
import com.obric.cae.libs.useraware.HarEventData;
import com.obric.cae.libs.useraware.HarLevel2DataReq;
import com.obric.cae.libs.useraware.HarMonitorParams;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.libs.useraware.d;
import com.obric.cae.location.b;
import com.obric.cae.location.cell.g;
import com.obric.cae.location.database.c;
import com.obric.cae.log.a;
import com.obric.cae.userAware.Garage.GarageOwnerManager;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.obric.cae.userAware.SubwayFusionAware.SubwayFusionAware;
import com.obric.cae.userAware.SubwayFusionAware.SubwayFusionAwareTestTool;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.userAware.datacollection.HARStateInfo;
import com.obric.cae.userAware.datacollection.WifiScanCount;
import com.obric.cae.userAware.mediaaware.AudioAwareInfoManger;
import com.obric.cae.userAware.report.CaeUserAwareReportBase;
import com.obric.cae.userAware.report.CaeUserAwareReportFactory;
import com.obric.cae.userAware.report.CaeUserAwareReportJson;
import com.obric.cae.userAware.utils.LearningProgressSettingsObserver;
import com.obric.cae.userAware.utils.MatrixDidUtils;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class UserAwareService extends PluginService {
    public static final String INTENT_EXTRA_OBJECT_MESSENGER = "MESSENGER";
    private static final String KEY_FILE_USER_AWARE_EVENTS = "user_aware";
    private static final int MEMD_HAR_DISABLE = -1;
    public static final int MSG_DEVICE_PROVISIONED_CHANGE = 9;
    public static final int MSG_HAR_ENABLE_CHANGE = 7;
    public static final int MSG_HAR_EVENT_TEST_TOOL_ENABLE_CHANGE = 14;
    public static final int MSG_HAR_NOTIFICATION_ENABLE_CHANGE = 6;
    public static final int MSG_HAR_RAW_DATA_REPORT_CHANGE = 8;
    public static final int MSG_MEMD_GPS_SWITCH_CHANGE = 10;
    public static final int MSG_PERIODIC_UPLOAD_MODE_CHANGE = 2;
    private static final int MSG_POLL_WIFI_INFO = 100;
    public static final int MSG_SUBWAY_FEEDBACK_SWITCH_CHANGE = 13;
    public static final int MSG_SUBWAY_TEST_TOOL_ENABLE_CHANGE = 12;
    public static final int MSG_UPDATE_LOCATION_STATE_CHANGE_VALUE = 5;
    public static final int MSG_UPDATE_REPORT_SWITCH_CHANGE = 4;
    public static final int MSG_UPDATE_WIFI_CONNECTION_INFO = 1;
    public static final int MSG_UPDATE_WIFI_CONNECTION_STATE_CHANGE = 3;
    public static final int MSG_USER_FEEDBACK_PREDICT_SWITCH_CHANGE = 11;
    private static final String PACKAGE_NAME_CAE = "com.obric.cae";
    private static final String TAG = "UserAwareService";
    private static final long WIFI_CONN_STATE_DEDUP_WINDOW_MS = 1000;
    private static final int WIFI_POLL_INTERVAL_MS = 1000;
    private static UserAwareService sService;
    private AwareStateListener mAwareStateListener;
    private UserAwareServiceBinder mBinder;
    private final CellAwareInfoMonitor mCellAwareInfoMonitor;
    private Context mContext;
    private final SimpleDateFormat mDateFormat;
    private GarageOwnerManager mGarageOwnerManager;
    private HarEventTestTool mHarEventTestTool;
    private HarMonitorParams mHarMonitorParams;
    public final AtomicBoolean mIsMemDHarEnabled;
    private final AtomicBoolean mIsRawDaraReport;
    private String mLastDailyDate;
    private int mLastWifiConnStateFromBroadcast;
    private long mLastWifiConnStateFromBroadcastElapsedMs;
    private WifiInfo mLastWifiInfo;
    private LearningProgressSettingsObserver mLearningProgressSettingsObserver;
    private OemHarInfoManager mOemHarInfoManager;
    private final ContentObserver mProactiveAgentObserver;
    private QshHarManager mQshHarManager;
    private final SensorCollectMonitor mSensorCollectMonitor;
    private c mStarLocationDbManager;
    private SubwayFusionAware mSubwayFusionAware;
    private Object mSubwayFusionAwareTestTool;
    private UserAwareCloudBinderClient mUserAwareCloudBinderClient;
    private File mUserAwareEventsFile;
    private UserAwareHandler mUserAwareHandler;
    private UserAwareManager mUserAwareManager;
    private WifiAwareInfoManager mWifiAwareInfoManager;
    private final WifiAwareInfoMonitor mWifiAwareInfoMonitor;
    private WifiManager mWifiManager;
    private final WifiScanCount mWifiScanCount;
    private WifiSignalReceiver mWifiSignalReceiver;

    public class UserAwareHandler extends Handler {
        final /* synthetic */ UserAwareService this$0;

        public UserAwareHandler(UserAwareService r3) {
            this.this$0 = (UserAwareService) ZeusTransformUtils.wrapperContextForParams(r3, UserAwareService.class, "com.obric.memorydata.plugin");
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message r5) {
            int r0 = r5.what;
            if (r0 != 1) goto L5;
            Bundle r6 = r5.getData();
            UserAwareService.access$400(this.this$0).updateWifiConnectInfo(r6);
            return;
        L5:
            if (r0 != 2) goto L7;
            UserAwareService.access$1700(this.this$0, r5.arg1);
            return;
        L7:
            if (r0 != 3) goto L9;
            UserAwareService.access$1800(this.this$0, r5.arg1);
            return;
        L9:
            if (r0 == 100) goto L23;
            switch(r0) {
                case 5: goto L21;
                case 6: goto L20;
                case 7: goto L19;
                case 8: goto L18;
                case 9: goto L17;
                case 10: goto L16;
                case 11: goto L15;
                case 12: goto L14;
                case 13: goto L13;
                case 14: goto L12;
                default: goto L22;
            };
        L12:
            UserAwareService.access$2700(this.this$0, r5.arg1);
            return;
        L13:
            UserAwareService.access$2600(this.this$0, r5.arg1);
            return;
        L14:
            UserAwareService.access$2500(this.this$0, r5.arg1);
            return;
        L15:
            UserAwareService.access$2400(this.this$0, r5.arg1);
            return;
        L16:
            UserAwareService.access$2800(this.this$0);
            goto L22
        L17:
            UserAwareService.access$2300(this.this$0);
            return;
        L18:
            UserAwareService.access$2200(this.this$0);
            return;
        L19:
            UserAwareService.access$2100(this.this$0);
            return;
        L20:
            UserAwareService.access$2000(this.this$0);
            return;
        L21:
            UserAwareService.access$1900(this.this$0, r5.obj.toString());
            return;
        L22:
            super.handleMessage(r5);
            return;
        L23:
            UserAwareService.access$800(this.this$0);
            sendEmptyMessageDelayed(100, 1000);
        }
    }

    public class UserAwareServiceBinder extends com.obric.cae.libs.useraware.c.a {
        private UserAwareService mService;
        final /* synthetic */ UserAwareService this$0;

        public UserAwareServiceBinder(UserAwareService r3, UserAwareService r4) {
            UserAwareService r5 = (UserAwareService) ZeusTransformUtils.wrapperContextForParams(r3, UserAwareService.class, "com.obric.memorydata.plugin");
            UserAwareService r6 = (UserAwareService) ZeusTransformUtils.wrapperContextForParams(r4, UserAwareService.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            this.mService = r6;
        }

        @Override // com.obric.cae.libs.useraware.c
        public void addBssidsToAvoidRomingScan(List<String> r3) {
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            if (UserAwareService.access$400(this.this$0) != null) goto L5;
            return;
        L5:
            UserAwareService.access$400(this.this$0).addBssidsToAvoidRomingScan(r4);
        }

        @Override // com.obric.cae.libs.useraware.c
        public void addHomeWifiBssids(List<String> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L8;
            Iterator r6 = r5.iterator();
        L6:
            if (r6.hasNext() == false) goto L10;
            String r0 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
            UserAwareService.access$400(this.this$0).getWifiFenceMonitor().addHomeWifiBssid(r0);
            goto L6
        L10:
            return;
        }

        public void cleanup() {
            this.mService = null;
        }

        @Override // com.obric.cae.libs.useraware.c
        public void clearHomeWifiBssids() {
            UserAwareService.access$400(this.this$0).getWifiFenceMonitor().clearHomeWifiBssids();
        }

        @Override // com.obric.cae.libs.useraware.c
        public HarMonitorParams getHarMonitorParams() {
            UserAwareService r2 = (UserAwareService) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getService(), "com.obric.memorydata.plugin"), UserAwareService.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L7;
            return null;
        L7:
            return UserAwareService.access$1500(r2);
        }

        public UserAwareService getService() {
            return this.mService;
        }

        @Override // com.obric.cae.libs.useraware.c
        public void notifyGeofenceChanged(int r1) {
            UserAwareService.access$400(this.this$0).notifyGeofenceChanged(r1);
        }

        @Override // com.obric.cae.libs.useraware.c
        public void notifyHarEvent(HarEventData r1) {
            if (r1 != null) goto L5;
            a.g(UserAwareService.access$200(), "notifyHarEvent: value is null");
            return;
        L5:
            UserAwareService.access$1600(this.this$0).notifyHarEvent(r1);
        }

        @Override // com.obric.cae.libs.useraware.c
        public void notifyLearningSuccess(boolean r7) {
            int r2 = Binder.getCallingUid();     // Catch: Throwable -> L15
            int r3 = Binder.getCallingPid();     // Catch: Throwable -> L15
            if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(UserAwareService.access$1200(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) != null) goto L6;
        L8:
            String[] r0 = null;
        L9:
            String r4 = UserAwareService.access$200();     // Catch: Throwable -> L15
            StringBuilder r8 = new StringBuilder("notifyLearningSuccess(AIDL): success=").append(r7).append(", uid=").append(r2).append(", pid=").append(r3).append(", pkgs=");     // Catch: Throwable -> L15
            if (r0 != null) goto L12;
            String r1 = "null";
        L13:
            a.e(r4, r8.append(r1).toString());     // Catch: Throwable -> L15
        L17:
            UserAwareService.access$400(this.this$0);
            return;
        L12:
            r1 = Arrays.toString(r0);     // Catch: Throwable -> L15
            goto L13
        L6:
            if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(UserAwareService.access$1200(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager() == null) goto L8;
            r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(UserAwareService.access$1200(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackagesForUid(r2);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            a.g(UserAwareService.access$200(), "notifyLearningSuccess(AIDL): log caller failed: " + th.getMessage());
            goto L17
        }

        @Override // com.obric.cae.libs.useraware.c
        public void notifyRoomChangedPredicted(int r1) {
            UserAwareService.access$400(this.this$0).notifyRoomChangedPredicted(r1);
        }

        @Override // com.obric.cae.libs.useraware.c
        public void registerCallback(d r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
            if (((UserAwareService) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getService(), "com.obric.memorydata.plugin"), UserAwareService.class, "com.obric.memorydata.plugin")) != null) goto L5;
            return;
        L5:
            if (UserAwareService.access$600(this.this$0) == null) goto L9;
            UserAwareService.access$600(this.this$0).registerCallback(r5);
            return;
        }

        @Override // com.obric.cae.libs.useraware.c
        public void registerSmartBluetoothEvent(com.obric.cae.libs.bluetooth.a r3) {
            com.obric.cae.libs.bluetooth.a r4 = (com.obric.cae.libs.bluetooth.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.cae.libs.bluetooth.a.class, "com.obric.memorydata.plugin");
            BtAwareInfoManager.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(UserAwareService.access$1200(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).registerSmartBluetoothEventCallback(r4);
        }

        @Override // com.obric.cae.libs.useraware.c
        public void setHarMonitorParams(HarMonitorParams r3) {
            UserAwareService r2 = (UserAwareService) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getService(), "com.obric.memorydata.plugin"), UserAwareService.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L7;
            String r4 = UserAwareService.access$200();
            String r5 = "setHarMonitorParams: service is null";
        L5:
            a.g(r4, r5);
            return;
        L7:
            if (r3 != null) goto L9;
            r4 = UserAwareService.access$200();
            r5 = "setHarMonitorParams: params is null";
            goto L5
        L9:
            UserAwareService.access$1502(r2, r3);
            if (UserAwareService.access$1600(r2) == null) goto L12;
            UserAwareService.access$1600(r2).configureHarMonitorParams(r3);
            return;
        L12:
            a.g(UserAwareService.access$200(), "setHarMonitorParams: mQshHarManager is null");
        }

        @Override // com.obric.cae.libs.useraware.c
        public void setHarState(int r5, long r6, int r8) {
            UserAwareManager.getInstance().notifyInnerCallbacks($$Lambda$0faNABYCk_oj7ofDaj7cUpQlXVI.INSTANCE, Integer.valueOf(r5), Long.valueOf(r6));
            if (UserAwareService.access$1300(this.this$0) == null) goto L5;
            UserAwareService.access$1300(this.this$0).handleHarStateUpdate(r5, r6);
        L6:
            CaeUserAwareReportBase r0 = CaeUserAwareReportFactory.getReportInstance();
            if (r0 == null) goto L12;
            if (UserAwareService.access$1400(this.this$0).get() == false) goto L12;
            r0.reportHARStateInfo(new HARStateInfo(r5, r6, r8));
        L12:
            if (r5 == (-1)) goto L14;
        L16:
            AtomicBoolean r1 = this.this$0.mIsMemDHarEnabled;
            boolean r2 = true;
        L17:
            r1.set(r2);
            a.c(UserAwareService.access$200(), "setHarState: status: " + r5 + ", timestampMs: " + r6 + ", modelNumber: " + r8 + ", isMemDHarEnabled: " + this.this$0.mIsMemDHarEnabled.get());
            return;
        L14:
            if (this.this$0.mIsMemDHarEnabled.get() == false) goto L16;
            r1 = this.this$0.mIsMemDHarEnabled;
            r2 = false;
            goto L17
        L5:
            a.e(UserAwareService.access$200(), "mOemHarInfoManager is null");
            goto L6
        }

        @Override // com.obric.cae.libs.useraware.c
        public void setLevel2DataCollection(List<HarLevel2DataReq> r4, int r5, com.obric.cae.libs.useraware.a r6) {
            List<HarLevel2DataReq> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            com.obric.cae.libs.useraware.a r8 = (com.obric.cae.libs.useraware.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.cae.libs.useraware.a.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L6;
            return;
        L6:
            if (UserAwareService.access$600(this.this$0) != null) goto L8;
            return;
        L8:
            UserAwareService.access$600(this.this$0).setLevel2DataCollection((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.this$0.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r7, r5, r8);
        }

        @Override // com.obric.cae.libs.useraware.c
        public void setWifiRssiTriggerThresholds(int r7, int r8, int r9, int r10, int r11) {
            if (UserAwareService.access$400(this.this$0) != null) goto L5;
            return;
        L5:
            String r0 = UserAwareService.access$200();
            g.a(e.a(b.a("setWifiRssiTriggerThresholds(AIDL): jumpDb=", r7, ", homeWindowMs=", r8, ", homeDropDb="), r9, ", companyWindowMs=", r10, ", companyDropDb="), r11, r0);
            UserAwareService.access$400(this.this$0).setWifiRssiTriggerThresholds(r7, r8, r9, r10, r11);
        }

        @Override // com.obric.cae.libs.useraware.c
        public void unregisterCallback(d r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
            if (((UserAwareService) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getService(), "com.obric.memorydata.plugin"), UserAwareService.class, "com.obric.memorydata.plugin")) != null) goto L5;
            return;
        L5:
            if (UserAwareService.access$600(this.this$0) == null) goto L10;
            UserAwareService.access$600(this.this$0).unregisterCallback(r5);
            return;
        }

        @Override // com.obric.cae.libs.useraware.c
        public void unregisterSmartBluetoothEvent(com.obric.cae.libs.bluetooth.a r3) {
            com.obric.cae.libs.bluetooth.a r4 = (com.obric.cae.libs.bluetooth.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.cae.libs.bluetooth.a.class, "com.obric.memorydata.plugin");
            BtAwareInfoManager.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(UserAwareService.access$1200(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).unregisterSmartBluetoothEventCallback(r4);
        }
    }

    public class WifiSignalReceiver extends PluginBroadcastReceiver {
        final /* synthetic */ UserAwareService this$0;

        private WifiSignalReceiver(UserAwareService r3) {
            this.this$0 = (UserAwareService) ZeusTransformUtils.wrapperContextForParams(r3, UserAwareService.class, "com.obric.memorydata.plugin");
        }

        public /* synthetic */ WifiSignalReceiver(UserAwareService r2, AnonymousClass1 r3) {
            this((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin"));
        }

        public void onReceive(Context r7, Intent r8) {
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
            String r10 = r8.getAction();
            if ("android.net.wifi.RSSI_CHANGED".equals(r10) == false) goto L6;
            a.c(UserAwareService.access$200(), "RSSI Changed Broadcast Received");
            UserAwareService.access$800(this.this$0);
            return;
        L6:
            if ("android.net.wifi.STATE_CHANGE".equals(r10) == false) goto L23;
            NetworkInfo r11 = (NetworkInfo) ZeusTransformUtils.preCheckCast(r8.getParcelableExtra("networkInfo"), NetworkInfo.class, "com.obric.memorydata.plugin");
            if (r11 != null) goto L10;
            return;
        L10:
            if (r11.getState() != NetworkInfo.State.CONNECTED) goto L12;
        L14:
            boolean r12 = r11.isConnected();
            long r0 = SystemClock.elapsedRealtime();
            if (r12 == UserAwareService.access$900(this.this$0)) goto L17;
        L20:
            UserAwareService.access$902(this.this$0, r12 ? 1 : 0);
            UserAwareService.access$1002(this.this$0, r0);
            Message r13 = UserAwareService.access$1100(this.this$0).obtainMessage(3);
            r13.arg1 = r12 ? 1 : 0;
            UserAwareService.access$1100(this.this$0).sendMessage(r13);
            return;
        L17:
            if ((r0 - UserAwareService.access$1000(this.this$0)) >= 1000) goto L20;
            a.c(UserAwareService.access$200(), com.obric.cae.libs.statemachine.d.a("Ignore duplicate wifi conn state broadcast: state=", r12 ? 1 : 0, ", delta=").append(r0 - UserAwareService.access$1000(this.this$0)).append("ms").toString());
            return;
        L12:
            if (r11.getState() == NetworkInfo.State.DISCONNECTED) goto L14;
            return;
        }
    }

    public UserAwareService() {
        this.mIsRawDaraReport = new AtomicBoolean(false);
        this.mIsMemDHarEnabled = new AtomicBoolean(false);
        this.mLastWifiConnStateFromBroadcast = Integer.MIN_VALUE;
        this.mLastWifiConnStateFromBroadcastElapsedMs = 0;
        this.mWifiScanCount = new WifiScanCount();
        this.mDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        this.mHarMonitorParams = new HarMonitorParams();
        this.mLastDailyDate = "";
        this.mCellAwareInfoMonitor = new AnonymousClass1(this);
        final Handler r1 = new Handler(Looper.getMainLooper());
        this.mProactiveAgentObserver = new AnonymousClass2(this, r1);
        this.mWifiAwareInfoMonitor = new AnonymousClass3(this);
        this.mSensorCollectMonitor = new AnonymousClass4(this);
    }

    public static /* synthetic */ void access$000(UserAwareService r2, CellAwareInfo r3) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).notifyCellInfoChanged(r3);
    }

    public static /* synthetic */ void access$100(UserAwareService r2, List r3) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).notifyCellNeighbourInfoChanged((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ long access$1000(UserAwareService r2) {
        return ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).mLastWifiConnStateFromBroadcastElapsedMs;
    }

    public static /* synthetic */ long access$1002(UserAwareService r2, long r3) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).mLastWifiConnStateFromBroadcastElapsedMs = r3;
        return r3;
    }

    public static /* synthetic */ UserAwareHandler access$1100(UserAwareService r2) {
        return ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).mUserAwareHandler;
    }

    public static /* synthetic */ Context access$1200(UserAwareService r2) {
        return ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).mContext;
    }

    public static /* synthetic */ OemHarInfoManager access$1300(UserAwareService r2) {
        return ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).mOemHarInfoManager;
    }

    public static /* synthetic */ AtomicBoolean access$1400(UserAwareService r2) {
        return ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).mIsRawDaraReport;
    }

    public static /* synthetic */ HarMonitorParams access$1500(UserAwareService r2) {
        return ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).mHarMonitorParams;
    }

    public static /* synthetic */ HarMonitorParams access$1502(UserAwareService r2, HarMonitorParams r3) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).mHarMonitorParams = r3;
        return r3;
    }

    public static /* synthetic */ QshHarManager access$1600(UserAwareService r2) {
        return ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).mQshHarManager;
    }

    public static /* synthetic */ void access$1700(UserAwareService r2, int r3) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).handlePeriodicUploadModeChange(r3);
    }

    public static /* synthetic */ void access$1800(UserAwareService r2, int r3) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).handleWifiConnectionStateChange(r3);
    }

    public static /* synthetic */ void access$1900(UserAwareService r2, String r3) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).handleLocationStateChangeValue(r3);
    }

    public static /* synthetic */ String access$200() {
        return TAG;
    }

    public static /* synthetic */ void access$2000(UserAwareService r2) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).handleHarNotificationEnableChange();
    }

    public static /* synthetic */ void access$2100(UserAwareService r2) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).handleHarEnableChange();
    }

    public static /* synthetic */ void access$2200(UserAwareService r2) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).handleHarRawDataReportChange();
    }

    public static /* synthetic */ void access$2300(UserAwareService r2) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).checkProvisionAndNotify();
    }

    public static /* synthetic */ void access$2400(UserAwareService r2, int r3) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).handleUserFeedbackPredictSwitchChange(r3);
    }

    public static /* synthetic */ void access$2500(UserAwareService r2, int r3) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).handleSubwayTestToolEnableChange(r3);
    }

    public static /* synthetic */ void access$2600(UserAwareService r2, int r3) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).handleSubwayFeedbackSwitchChange(r3);
    }

    public static /* synthetic */ void access$2700(UserAwareService r2, int r3) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).handleHarEventTestToolEnableChange(r3);
    }

    public static /* synthetic */ void access$2800(UserAwareService r2) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).handleMemDGPSSwithChange();
    }

    public static /* synthetic */ void access$300(UserAwareService r2) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).initSubWayAware();
    }

    public static /* synthetic */ WifiAwareInfoManager access$400(UserAwareService r2) {
        return ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).mWifiAwareInfoManager;
    }

    public static /* synthetic */ void access$500(UserAwareService r2, int r3) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).updateHomeCompanyWifiScanCountIfTodayChanged(r3);
    }

    public static /* synthetic */ UserAwareManager access$600(UserAwareService r2) {
        return ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).mUserAwareManager;
    }

    public static /* synthetic */ void access$800(UserAwareService r2) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).processWifiInfoAndSend();
    }

    public static /* synthetic */ int access$900(UserAwareService r2) {
        return ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).mLastWifiConnStateFromBroadcast;
    }

    public static /* synthetic */ int access$902(UserAwareService r2, int r3) {
        ((UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin")).mLastWifiConnStateFromBroadcast = r3;
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void checkProvisionAndNotify() {
        int r0 = Settings.Global.getInt(getContentResolver(), "device_provisioned", 0);
        a.c(TAG, "checkProvisionAndNotify enable=" + r0);
        this.mUserAwareManager.notifyInnerCallbacks($$Lambda$zr5sDlTdPIeOzTNr5DH_b5_oJw.INSTANCE, Integer.valueOf(r0));
    }

    public static synchronized void clearAwareService(UserAwareService r2) {
        monitor-enter(UserAwareService.class);
        UserAwareService r3 = (UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (sService != r3) goto L7;
        sService = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(UserAwareService.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static synchronized UserAwareService getService() {
        monitor-enter(UserAwareService.class);
        UserAwareService r1 = sService;     // Catch: Throwable -> L7
        monitor-exit(UserAwareService.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleHarEnableChange() {
        boolean r2 = false;
        int r0 = Settings.Global.getInt(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR, 0);
        a.c(TAG, "har enable change: " + r0);
        if (r0 != 0) goto L7;
        OemHarInfoManager r1 = this.mOemHarInfoManager;
        if (r1 == null) goto L12;
        r1.clear();
        this.mOemHarInfoManager = null;
    L12:
        if (this.mUserAwareManager == null) goto L15;
        UserAwareManager.getInstance().notifyInnerCallbacks($$Lambda$6Iji_JY7u5jaJGx0XudWRgv5ZNY.INSTANCE, Integer.valueOf(r0));
        return;
    L15:
        return;
    L7:
        this.mOemHarInfoManager = OemHarInfoManager.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        int r3 = Settings.Global.getInt(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR_NOTIFICATION, 0);
        OemHarInfoManager r4 = this.mOemHarInfoManager;
        if (r3 == 0) goto L10;
        r2 = true;
    L10:
        r4.setHarEnableNotification(r2);
        goto L12
    }

    private void handleHarEventTestToolEnableChange(int r4) {
        a.e(TAG, "Received HAR event test tool enable change: " + r4);
        boolean r0 = true;
        if (r4 == 1) goto L6;
        r0 = false;
    L6:
        if (r0 == true) goto L8;
    L10:
        if (r0 == false) goto L12;
        return;
    L12:
        if (this.mHarEventTestTool == null) goto L17;
        releaseHarEventTestTool();
        return;
    L17:
        return;
    L8:
        if (this.mHarEventTestTool != null) goto L10;
        initHarEventTestTool();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleHarNotificationEnableChange() {
        boolean r2 = false;
        int r0 = Settings.Global.getInt(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR_NOTIFICATION, 0);
        OemHarInfoManager r3 = this.mOemHarInfoManager;
        if (r3 == null) goto L8;
        if (r0 == 0) goto L6;
        r2 = true;
    L6:
        r3.setHarEnableNotification(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleHarRawDataReportChange() {
        int r0 = Settings.Global.getInt(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_HAR_RAW_DATA_REPORT, 0);
        String r1 = TAG;
        a.c(r1, "har wakelock time change: " + r0);
        AtomicBoolean r5 = this.mIsRawDaraReport;
        if (r0 == 0) goto L5;
        r5.set(true);
        return;
    L5:
        r5.set(false);
        a.g(r1, "har raw data report is closed");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleLocationStateChangeValue(String r5) {
        String r0 = UserAwareUtil.getStateChangeString((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), r5);
        if (r0.isEmpty() == false) goto L6;
        a.i(TAG, "Received useless location state value");
        return;
    L6:
        notifyLocationStateValueChange(r5);
        String r6 = TAG;
        a.c(r6, "Received location state value: ".concat(r0), this.mUserAwareEventsFile);
        if (r0.equals(UserAwareUtil.getStringValueFromXML(this, ZeusTransformUtils.mapRes(R.string.user_aware_aware_local_state_learning, TypedValues.Custom.S_STRING, "user_aware_aware_local_state_learning"))) == false) goto L10;
        a.i(r6, r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleMemDGPSSwithChange() {
        int r0 = AwareStateListener.getEnableWifiScanFunction(this, getContentResolver());
        a.c(TAG, "handleMemDGPSSwithChange: enable -- " + r0);
        if (r0 != 1) goto L5;
        this.mWifiAwareInfoManager.setEnableWifiScanFunction(true);
        initSubWayAware();
        return;
    L5:
        this.mWifiAwareInfoManager.setEnableWifiScanFunction(false);
        SubwayFusionAware.getInstance(this).release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handlePeriodicUploadModeChange(int r4) {
        int r5 = Settings.Global.getInt(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_USER_PERIODIC_UPLOAD_MODE, -1);
        a.e(TAG, "Updated mPeriodicUploadMode to " + r5);
        UserAwareManager r3 = this.mUserAwareManager;
        if (r3 == null) goto L6;
        r3.notifyInnerCallbacks($$Lambda$tyZQHplInzUhOPSfvZHVZNtfK_4.INSTANCE, Integer.valueOf(r5));
        return;
    }

    private void handleSubwayFeedbackSwitchChange(int r4) {
        a.e(TAG, "Received subway feedback switch change: " + r4);
        if (this.mUserAwareManager == null) goto L6;
        UserAwareManager.getInstance().notifyInnerCallbacks($$Lambda$2aY1b4Ce69zy2iThUwnFY6FCEYc.INSTANCE, Integer.valueOf(r4));
        return;
    }

    private void handleSubwayTestToolEnableChange(int r4) {
        a.e(TAG, "Received subway test tool enable change: " + r4);
        boolean r0 = true;
        if (r4 == 1) goto L6;
        r0 = false;
    L6:
        if (r0 == true) goto L8;
    L10:
        if (r0 == false) goto L12;
        return;
    L12:
        if (this.mSubwayFusionAwareTestTool == null) goto L17;
        releaseSubwayTestTool();
        return;
    L17:
        return;
    L8:
        if (this.mSubwayFusionAwareTestTool != null) goto L10;
        initSubwayTestTool(this.mSubwayFusionAware);
    }

    private void handleUserFeedbackPredictSwitchChange(int r4) {
        a.e(TAG, "Received user feedback predict switch change: " + r4);
        if (this.mUserAwareManager == null) goto L6;
        UserAwareManager.getInstance().notifyInnerCallbacks($$Lambda$iOp860buVog7GYXiiBShxtQss8g.INSTANCE, Integer.valueOf(r4));
        return;
    }

    private void handleWifiConnectionStateChange(int r4) {
        a.e(TAG, "Received wifi connection state change: " + r4);
        this.mWifiAwareInfoManager.handleWifiConnectionStateChanged(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init() {
        initUserAwareFile();
        CellAwareInfoManger r5 = CellAwareInfoManger.getInstance(this);
        if (r5 == null) goto L5;
        r5.registerMonitor(this.mCellAwareInfoMonitor);
    L5:
        BtAwareInfoManager r3 = BtAwareInfoManager.getInstance(this);
        LocationAwareInfoManager r4 = LocationAwareInfoManager.getInstance(this);
        this.mStarLocationDbManager = c.a(this, UserHandle.getUserId(Process.myUid()));
        SensorCollectManager r7 = SensorCollectManager.getInstance(this);
        r7.registerSensorCollectMonitor(this.mSensorCollectMonitor);
        r7.registerStepsCounter();
        WifiAwareInfoManager r1 = WifiAwareInfoManager.getInstance(this);
        this.mWifiAwareInfoManager = r1;
        r1.registerWifiAwareInfoMonitor(this.mWifiAwareInfoMonitor);
        if (this.mLearningProgressSettingsObserver != null) goto L9;
        LearningProgressSettingsObserver r2 = new LearningProgressSettingsObserver(this, this.mWifiAwareInfoManager);
        this.mLearningProgressSettingsObserver = r2;
        r2.register();
    L9:
        if (Settings.Global.getInt(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR, 0) != 1) goto L11;
        this.mOemHarInfoManager = OemHarInfoManager.getInstance(this);
    L11:
        this.mUserAwareHandler = new UserAwareHandler(this);
        Messenger r6 = new Messenger(this.mUserAwareHandler);
        Intent r8 = new Intent();
        r8.setComponent(new ComponentName("com.obric.cae", "com.obric.cae.smartNetwork.SmartNetworkService"));
        r8.putExtra(INTENT_EXTRA_OBJECT_MESSENGER, r6);
        ZeusTransformUtils.startService(this, r8, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
    L16:
        AwareStateListener r9 = AwareStateListener.getInstance();
        this.mAwareStateListener = r9;
        r9.initOnce(this, r6);
        this.mAwareStateListener.setWifiScanStateMachine(this.mWifiAwareInfoManager);
        this.mAwareStateListener.loadSaveWifiScanParams();
        if (UserAwareUtil.isFirstPartyDevice() == false) goto L19;
        this.mUserAwareCloudBinderClient = new UserAwareCloudBinderClient(this);
    L20:
        AudioAwareInfoManger r10 = AudioAwareInfoManger.getInstance(this);
        CaeUserAwareReportFactory.createReportInstance(CaeUserAwareReportJson.getInstance(this.mContext));
        this.mQshHarManager = new QshHarManager();
        GarageOwnerManager r11 = new GarageOwnerManager(this);
        this.mGarageOwnerManager = r11;
        r11.start();
        UserAwareManager r12 = UserAwareManager.getInstance();
        this.mUserAwareManager = r12;
        r12.initManager(this.mWifiAwareInfoManager, r3, r4, r5, r10, r7, this.mOemHarInfoManager);
        initMatrixTeaManager();
        checkProvisionAndNotify();
        NearElevator r13 = NearElevator.getInstance(this);
        if (r13 == null) goto L23;
        r13.setWifiAwareInfoManager(this.mWifiAwareInfoManager);
    L23:
        initSubWayAware();
        com.obric.cae.location.city.a.a(this, this.mProactiveAgentObserver);
        if (UserAwareUtil.isHarEventTestToolEnabled(this) == false) goto L26;
        initHarEventTestTool();
    L26:
        handleHarRawDataReportChange();
        if (Objects.equals(getPackageName(), "com.obric.cae") == true) goto L35;
        this.mWifiManager = (WifiManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");
        if (this.mWifiSignalReceiver != null) goto L31;
        this.mWifiSignalReceiver = new WifiSignalReceiver(this, null);
        IntentFilter r14 = new IntentFilter();
        r14.addAction("android.net.wifi.RSSI_CHANGED");
        r14.addAction("android.net.wifi.STATE_CHANGE");
        ZeusTransformUtils.registerReceiver(this, this.mWifiSignalReceiver, r14, "com.obric.memorydata.plugin");
    L31:
        this.mUserAwareHandler.sendEmptyMessage(100);
        return;
    L35:
        return;
    L19:
        a.c(TAG, "Not initializing cloud binder client for non-first-party device");
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initHarEventTestTool() {
        if (this.mHarEventTestTool == null) goto L5;
        return;
    L5:
        HarEventTestTool r0 = new HarEventTestTool(this);
        r0.register();
        this.mHarEventTestTool = r0;
        a.e(TAG, "HarEventTestTool registered");
    }

    private void initMatrixTeaManager() {
        MatrixDidUtils.init(this.mContext);
    }

    private void initSubWayAware() {
        final HandlerThread r0 = new HandlerThread("UserAwareBackground-" + System.currentTimeMillis());
        r0.start();
        new Handler(r0.getLooper()).post(new $$Lambda$UserAwareService$JkUwhUpApquP5HlOaIvBrn261cI(this, r0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initSubwayTestTool(SubwayFusionAware r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.mSubwayFusionAwareTestTool != null) goto L9;
        SubwayFusionAwareTestTool r0 = new SubwayFusionAwareTestTool(this, r2);
        r0.register();
        this.mSubwayFusionAwareTestTool = r0;
        a.e(TAG, "SubwayFusionAwareTestTool registered");
        return;
    }

    private void initUserAwareFile() {
        File r0 = new File(UserAwareUtil.getLocalDir(this.mContext, KEY_FILE_USER_AWARE_EVENTS), "user_aware_events.txt");
        r0.delete();
        r0.createNewFile();     // Catch: IOException -> L5
    L6:
        this.mUserAwareEventsFile = r0;
        a.c(TAG, "initUserAwareFile, file: " + this.mUserAwareEventsFile);
        a.a(KEY_FILE_USER_AWARE_EVENTS, this.mUserAwareEventsFile);
        return;
    L5:
        a.i(TAG, "IO error occurred!");
        goto L6
    }

    private static boolean isAppDebuggable(Context r2) {
        if ((((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getApplicationInfo().flags & 2) == 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    static /* synthetic */ String lambda$dump$0(boolean r0, String r1) {
        if (r0 == true) goto L4;
        return r1;
    L4:
        return a.d(r1);
    }

    private void notifyCellInfoChanged(CellAwareInfo r3) {
        UserAwareManager r0 = this.mUserAwareManager;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.notifyCallbacks($$Lambda$zxWDuONP3I1S858wkmBfzYFJONQ.INSTANCE, r3);
        this.mUserAwareManager.notifyInnerCallbacks($$Lambda$6HwTsNtDEpuMC7UcxlHBwMA4J3k.INSTANCE, r3);
    }

    private void notifyCellNeighbourInfoChanged(List<CellAwareInfo> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        UserAwareManager r0 = this.mUserAwareManager;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.notifyCallbacks($$Lambda$20CrJmuR1inZzBmPDxGkNS4aSmc.INSTANCE, r4);
        this.mUserAwareManager.notifyInnerCallbacks($$Lambda$Ahc9Td0JciKgowOzyuzENDZ95hA.INSTANCE, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void processWifiInfoAndSend() {
        WifiManager r0 = this.mWifiManager;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mUserAwareHandler == null) goto L29;
        WifiInfo r1 = r0.getConnectionInfo();
        if (r1 == null) goto L28;
        int r2 = -1;
        if (r1.getNetworkId() != (-1)) goto L13;
        return;
    L13:
        if (r1.equals(this.mLastWifiInfo) == false) goto L16;
        a.c(TAG, "No WifiInfo update");
        return;
    L16:
        Bundle r3 = new Bundle();
        r3.putString("bssid", r1.getBSSID());
        r3.putString(Api.KEY_SSID, r1.getSSID());
        r3.putInt("rssi", r1.getRssi());
        r3.putInt("frequency", r1.getFrequency());
        r3.putLong("timestamp", System.currentTimeMillis());
        r3.putInt("apStandard", r1.getWifiStandard());
        Iterator<WifiConfiguration> r4 = this.mWifiManager.getConfiguredNetworks().iterator();
    L18:
        if (r4.hasNext() == false) goto L22;
        WifiConfiguration r5 = (WifiConfiguration) ZeusTransformUtils.preCheckCast(r4.next(), WifiConfiguration.class, "com.obric.memorydata.plugin");
        if (r5.SSID.equals(r1.getSSID()) == false) goto L18;
        r2 = WifiConfiguration.isMetered(r5, r1);
    L22:
        r3.putInt("apType", r2);
        Message r6 = this.mUserAwareHandler.obtainMessage(1);
        r6.setData(r3);
        this.mUserAwareHandler.sendMessage(r6);
        this.mLastWifiInfo = r1;
        return;
    L28:
        return;
    }

    private void releaseHarEventTestTool() {
        HarEventTestTool r0 = this.mHarEventTestTool;
        if (r0 != null) goto L10;
        return;
    L10:
        r0.unregister();     // Catch: Exception -> L7
        this.mHarEventTestTool = null;     // Catch: Exception -> L7
        a.e(TAG, "HarEventTestTool unregistered");     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        a.a(TAG, "Failed to unregister HarEventTestTool", e);
    }

    private void releaseSubwayTestTool() {
        Object r0 = this.mSubwayFusionAwareTestTool;
        if (r0 != null) goto L10;
        return;
    L10:
        ((SubwayFusionAwareTestTool) ZeusTransformUtils.preCheckCast(r0, SubwayFusionAwareTestTool.class, "com.obric.memorydata.plugin")).unregister();     // Catch: Exception -> L7
        this.mSubwayFusionAwareTestTool = null;     // Catch: Exception -> L7
        a.e(TAG, "SubwayFusionAwareTestTool unregistered");     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        a.a(TAG, "Failed to unregister test tool", e);
    }

    public static synchronized void setUserAwareService(UserAwareService r2) {
        monitor-enter(UserAwareService.class);
        UserAwareService r3 = (UserAwareService) ZeusTransformUtils.wrapperContextForParams(r2, UserAwareService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r3 != null) goto L8;
        monitor-exit(UserAwareService.class);
        return;
    L8:
        sService = r3;     // Catch: Throwable -> L11
        monitor-exit(UserAwareService.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateHomeCompanyWifiScanCountIfTodayChanged(int r7) {
        long r0 = System.currentTimeMillis();
        WifiAwareInfoManager r2 = this.mWifiAwareInfoManager;
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        int r4 = 2;
    L11:
        this.mWifiScanCount.setTimeStamp(r0);
        this.mWifiScanCount.setSceneType(r7);
        this.mWifiScanCount.setScanType(r4);
        this.mWifiScanCount.setDateScanDropCount(UserAwareUtil.getUserAwareWifiScanDropCountToday(this));
        String r8 = this.mDateFormat.format(Long.valueOf(r0));
        if (r8.equals(this.mLastDailyDate) == true) goto L14;
        this.mWifiScanCount.setDateScanCount(0);
        this.mLastDailyDate = r8;
    L14:
        WifiScanCount r9 = this.mWifiScanCount;
        r9.setDateScanCount(r9.getDateScanCount() + 1);
        CaeUserAwareReportBase r10 = CaeUserAwareReportFactory.getReportInstance();
        if (r10 == null) goto L18;
        r10.reportScanCount(this.mWifiScanCount);
        return;
    L18:
        return;
    L10:
        r4 = 0;
        goto L11
    L5:
        if (r2.isTrainingMode() == false) goto L7;
        r3 = true;
        goto L8
    }

    public void dump(FileDescriptor r2, PrintWriter r3, String[] r4) {
        final boolean r0 = false;
        if (r4.length > 0) goto L5;
    L7:
        r3.println("UserAware Log:");
        a.a(this.mUserAwareEventsFile, r3, new $$Lambda$UserAwareService$60AD2OwmH1oE1OU6mluGm9ndpS4(r0));
        return;
    L5:
        if ("--NeedDecrypt".equalsIgnoreCase(r4[0]) == false) goto L7;
        r0 = true;
        goto L7
    }

    public StarGeofence getGeofenceStatusByGeoType(byte r4) {
        Iterator<StarGeofence> r3 = this.mStarLocationDbManager.a().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        StarGeofence r0 = (StarGeofence) ZeusTransformUtils.preCheckCast(r3.next(), StarGeofence.class, "com.obric.memorydata.plugin");
        if (r0.getGeoType() != StarGeofence.GeoType.values()[r4]) goto L4;
        a.c(TAG, "getGeofenceStatusByGeoType: " + r0);
        return r0;
    L9:
        return null;
    }

    public String getLearningProgressValue() {
        AwareStateListener r0 = this.mAwareStateListener;
        if (r0 == null) goto L7;
        return r0.getLearningProgressValue();
    L7:
        return ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.user_aware_aware_local_state_learning, TypedValues.Custom.S_STRING, "user_aware_aware_local_state_learning"));
    }

    public String getLocationStateValueDesc() {
        AwareStateListener r0 = this.mAwareStateListener;
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.getLocationStateValueDesc();
    }

    public WifiStandardData getWifiConnectInfo() {
        WifiAwareInfoManager r0 = this.mWifiAwareInfoManager;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getWifiConnectInfo();
    }

    public List<WifiStandardData> getWifiScanNeighborAp() {
        WifiAwareInfoManager r0 = this.mWifiAwareInfoManager;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getWifiScanNeighborAp();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initSubWayAware$1$UserAwareService(boolean r2) {
        if (r2 == false) goto L4;
    L5:
        SubwayFusionAware r3 = SubwayFusionAware.getInstance(this);
        this.mSubwayFusionAware = r3;
        if (r3 == null) goto L9;
        r3.init();
        a.e(TAG, "SubwayFusionAware initialized");
    L9:
        if (UserAwareUtil.isSubwayTestToolEnabled(this) == false) goto L13;
        initSubwayTestTool(this.mSubwayFusionAware);
        return;
    L13:
        return;
    L4:
        if (UserAwareUtil.isSubwayTestToolEnabled(this) == true) goto L5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initSubWayAware$2$UserAwareService(HandlerThread r6) {
        String r3 = TAG;     // Catch: Throwable -> L5 Exception -> L7
        a.c(r3, "initSubWayAware running on thread: " + Thread.currentThread().getName());     // Catch: Throwable -> L5 Exception -> L7
        final boolean r2 = com.obric.cae.location.city.a.a(this);     // Catch: Throwable -> L5 Exception -> L7
        a.c(r3, "initSubWayAware: isLabFeatureOpen -- " + r2);     // Catch: Throwable -> L5 Exception -> L7
        this.mUserAwareHandler.post(new $$Lambda$UserAwareService$FRyriWdbgEAN0hoo15IojRTcLwY(this, r2));     // Catch: Throwable -> L5 Exception -> L7
        r6.quitSafely();
        StringBuilder r5 = new StringBuilder("Background thread quit: ");
        String r7 = r6.getName();
        a.c(r3, r5.append(r7).toString());
        r6 = r7;
    L13:
        return;
    L5:
        th = move-exception;
        r6.quitSafely();
        a.c(TAG, "Background thread quit: " + r6.getName());
        throw th;
    L7:
        e = move-exception;
        String r1 = TAG;     // Catch: Throwable -> L5
        a.a(r1, "initSubWayAware failed", e);     // Catch: Throwable -> L5
        r6.quitSafely();
        StringBuilder r8 = new StringBuilder("Background thread quit: ");
        String r9 = r6.getName();
        a.c(r1, r8.append(r9).toString());
        r6 = r9;
        goto L13
    }

    public void notifyLocationStateValueChange(String r2) {
        UserAwareManager r1 = this.mUserAwareManager;
        if (r1 != null) goto L5;
        return;
    L5:
        r1.notifyInnerCallbacks($$Lambda$m7xXcAaOh2Rrq33UYlUiL0fYKE.INSTANCE, r2);
    }

    public void notifySensorDataChange(SensorEvent r2) {
        UserAwareManager r1 = this.mUserAwareManager;
        if (r1 != null) goto L5;
        return;
    L5:
        r1.notifyInnerCallbacks($$Lambda$XrFokPpBO8nOaGbVAFtHUrNMRo4.INSTANCE, r2);
    }

    public void notifyWifiConnectInfoChanged(WifiStandardData r3) {
        UserAwareManager r0 = this.mUserAwareManager;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.notifyInnerCallbacks($$Lambda$OBHHOpTGnH3ikWaFNSuKM6HYzm4.INSTANCE, r3);
        this.mUserAwareManager.notifyCallbacks($$Lambda$NwPgWL2gy42HEamjIXvDElq7NAI.INSTANCE, r3);
    }

    public void notifyWifiNetworkAvailable(boolean r4) {
        UserAwareManager r0 = this.mUserAwareManager;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.notifyCallbacks($$Lambda$NcSLTSJk5a8YrfMLKqZayaiLnDA.INSTANCE, Boolean.valueOf(r4));
        this.mUserAwareManager.notifyInnerCallbacks($$Lambda$NDDEmVn88J6tV8Vo0SDIUHJvp00.INSTANCE, Boolean.valueOf(r4));
    }

    public void notifyWifiScanInfoChanged(List<WifiStandardData> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        UserAwareManager r2 = this.mUserAwareManager;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.notifyCallbacks($$Lambda$yJ339x7P1J1wkEHFcvWb7zkpZl0.INSTANCE, r4);
    }

    public void notifyWifiScanNeighborApChanged(List<WifiStandardData> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.mUserAwareManager.notifyInnerCallbacks($$Lambda$lE1tpnHWoKjsvmSGtMgHjL2bwvY.INSTANCE, r4);
    }

    public IBinder onBind(Intent r1) {
        return this.mBinder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        a.c(TAG, "onCreate");
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mBinder = new UserAwareServiceBinder(this, this);
        setUserAwareService(this);
        init();
        com.obric.cae.runtime.a.a(this.mContext, UserAwareService.class, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        a.c(TAG, "onDestroy");
        WifiSignalReceiver r3 = this.mWifiSignalReceiver;     // Catch: Throwable -> L51 Exception -> L53
        if (r3 == null) goto L6;
        ZeusTransformUtils.unregisterReceiver(this, r3, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51 Exception -> L53
    L6:
        UserAwareServiceBinder r4 = this.mBinder;     // Catch: Throwable -> L51 Exception -> L53
        if (r4 == null) goto L9;
        r4.cleanup();     // Catch: Throwable -> L51 Exception -> L53
    L9:
        AwareStateListener r5 = this.mAwareStateListener;     // Catch: Throwable -> L51 Exception -> L53
        if (r5 == null) goto L12;
        r5.unregisterSettingsObserver();     // Catch: Throwable -> L51 Exception -> L53
    L12:
        LearningProgressSettingsObserver r6 = this.mLearningProgressSettingsObserver;     // Catch: Throwable -> L51 Exception -> L53
        if (r6 == null) goto L15;
        r6.unregister();     // Catch: Throwable -> L51 Exception -> L53
        this.mLearningProgressSettingsObserver = null;     // Catch: Throwable -> L51 Exception -> L53
    L15:
        UserAwareCloudBinderClient r7 = this.mUserAwareCloudBinderClient;     // Catch: Throwable -> L51 Exception -> L53
        if (r7 == null) goto L18;
        r7.close();     // Catch: Throwable -> L51 Exception -> L53
        this.mUserAwareCloudBinderClient = null;     // Catch: Throwable -> L51 Exception -> L53
    L18:
        UserAwareManager r8 = this.mUserAwareManager;     // Catch: Throwable -> L51 Exception -> L53
        if (r8 == null) goto L21;
        r8.clearInnerCallbacks();     // Catch: Throwable -> L51 Exception -> L53
    L21:
        WifiAwareInfoManager r9 = this.mWifiAwareInfoManager;     // Catch: Throwable -> L51 Exception -> L53
        if (r9 == null) goto L24;
        r9.cleanup();     // Catch: Throwable -> L51 Exception -> L53
    L24:
        UserAwareHandler r10 = this.mUserAwareHandler;     // Catch: Throwable -> L51 Exception -> L53
        if (r10 == null) goto L27;
        r10.removeCallbacksAndMessages(null);     // Catch: Throwable -> L51 Exception -> L53
    L27:
        releaseSubwayTestTool();     // Catch: Throwable -> L51 Exception -> L53
        SubwayFusionAware r11 = SubwayFusionAware.getInstance(this);     // Catch: Throwable -> L51 Exception -> L53
        if (r11 == null) goto L30;
        r11.release();     // Catch: Throwable -> L51 Exception -> L53
    L30:
        CaeUserAwareReportBase r12 = CaeUserAwareReportFactory.getReportInstance();     // Catch: Throwable -> L51 Exception -> L53
        if (r12 == null) goto L33;
        CaeUserAwareReportFactory.releaseReportInstance();     // Catch: Throwable -> L51 Exception -> L53
        r12.cleanup();     // Catch: Throwable -> L51 Exception -> L53
    L33:
        clearAwareService(this);     // Catch: Throwable -> L51 Exception -> L53
        OemHarInfoManager r13 = this.mOemHarInfoManager;     // Catch: Throwable -> L51 Exception -> L53
        if (r13 == null) goto L81;
        r13.clear();     // Catch: Throwable -> L51 Exception -> L53
    L81:
        com.obric.cae.location.city.a.b(this, this.mProactiveAgentObserver);     // Catch: Throwable -> L38
    L40:
        SubwayFusionAware.getInstance(this).release();     // Catch: Throwable -> L51 Exception -> L53
    L92:
        GarageOwnerManager r14 = this.mGarageOwnerManager;     // Catch: Throwable -> L45
        if (r14 == null) goto L61;
        r14.stop();     // Catch: Throwable -> L45
    L61:
        this.mGarageOwnerManager = null;
        com.obric.cae.runtime.a.a(UserAwareService.class, this);
        return;
    L45:
        th = move-exception;
        a.a(TAG, "Garage cleanup failed", th);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        this.mGarageOwnerManager = null;
        com.obric.cae.runtime.a.a(UserAwareService.class, this);
        throw th;
    L38:
        th = move-exception;
        a.a(TAG, "destroy unregister observer failed", th);     // Catch: Throwable -> L51 Exception -> L53
    L53:
        e = move-exception;
        a.a(TAG, "Cleanup failed", e);     // Catch: Throwable -> L51
        GarageOwnerManager r15 = this.mGarageOwnerManager;     // Catch: Throwable -> L59
        if (r15 == null) goto L61;
        r15.stop();     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        a.a(TAG, "Garage cleanup failed", th);     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        this.mGarageOwnerManager = null;
        com.obric.cae.runtime.a.a(UserAwareService.class, this);
        throw th;
    L51:
        th = move-exception;
        GarageOwnerManager r16 = this.mGarageOwnerManager;     // Catch: Throwable -> L70
        if (r16 == null) goto L72;
        r16.stop();     // Catch: Throwable -> L70
    L72:
        this.mGarageOwnerManager = null;
        com.obric.cae.runtime.a.a(UserAwareService.class, this);
        throw th;
    L70:
        th = move-exception;
        a.a(TAG, "Garage cleanup failed", th);     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        this.mGarageOwnerManager = null;
        com.obric.cae.runtime.a.a(UserAwareService.class, this);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int onStartCommand(Intent r1, int r2, int r3) {
        return super/*android.app.Service*/.onStartCommand(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateWifiScanCountForPnoChanged(boolean r4) {
        long r0 = System.currentTimeMillis();
        UserAwareUtil.PnoStateSnapshot r3 = UserAwareUtil.onUserAwarePnoStateChanged(this, r4);
        CaeUserAwareReportBase.PnoStats r2 = new CaeUserAwareReportBase.PnoStats();
        r2.setTimeStamp(r0);
        if (r4 == false) goto L5;
        int r5 = 1;
    L6:
        r2.setEvent(r5);
        r2.setStartWallClockMs(r3.startWallClockMs);
        r2.setStopWallClockMs(r3.stopWallClockMs);
        r2.setDurationMs(r3.durationMs);
        r2.setPeriodMs(r3.periodMs);
        r2.setEstimatedRounds(r3.estimatedRounds);
        r2.setTotalDurationTodayMs(r3.totalDurationTodayMs);
        r2.setSessionCountToday(r3.sessionCountToday);
        r2.setEstimatedRoundsToday(r3.estimatedRoundsToday);
        CaeUserAwareReportBase r6 = CaeUserAwareReportFactory.getReportInstance();
        if (r6 == null) goto L10;
        r6.reportWifiPnoStats(r2);
        return;
    L10:
        return;
    L5:
        r5 = 2;
        goto L6
    }
}
