package com.obric.cae.userAware;

import android.app.Service;
import android.content.BroadcastReceiver;
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
import com.obric.cae.commonsense.R;
import com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.useraware.CellAwareInfo;
import com.obric.cae.libs.useraware.HarEventData;
import com.obric.cae.libs.useraware.HarLevel2DataReq;
import com.obric.cae.libs.useraware.HarLevel2DataResp;
import com.obric.cae.libs.useraware.HarMonitorParams;
import com.obric.cae.libs.useraware.ICaeUserAware;
import com.obric.cae.libs.useraware.ICaeUserAwareCallback;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.location.city.LabFeatureChecker;
import com.obric.cae.location.database.StarLocationDbManager;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.runtime.CaeRuntime;
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
import com.obric.cae.wifi.WiFiDBHelper;
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
import s1.x;

/* JADX INFO: loaded from: classes2.dex */
public class UserAwareService extends Service {
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
    private StarLocationDbManager mStarLocationDbManager;
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

        public UserAwareHandler(UserAwareService r8) {
            this.this$0 = r8;
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            int r10 = r8.what;
            if (r10 != 1) goto L5;
            Bundle r11 = r8.getData();
            UserAwareService.access$400(this.this$0).updateWifiConnectInfo(r11);
            return;
        L5:
            if (r10 != 2) goto L7;
            UserAwareService.access$1700(this.this$0, r8.arg1);
            return;
        L7:
            if (r10 != 3) goto L9;
            UserAwareService.access$1800(this.this$0, r8.arg1);
            return;
        L9:
            if (r10 == 100) goto L23;
            switch(r10) {
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L20;
                case 8: goto L19;
                case 9: goto L18;
                case 10: goto L16;
                case 11: goto L15;
                case 12: goto L14;
                case 13: goto L13;
                case 14: goto L12;
                default: goto L17;
            };
        L12:
            UserAwareService.access$2700(this.this$0, r8.arg1);
            return;
        L13:
            UserAwareService.access$2600(this.this$0, r8.arg1);
            return;
        L14:
            UserAwareService.access$2500(this.this$0, r8.arg1);
            return;
        L15:
            UserAwareService.access$2400(this.this$0, r8.arg1);
            return;
        L16:
            UserAwareService.access$2800(this.this$0);
            goto L17
        L18:
            UserAwareService.access$2300(this.this$0);
            return;
        L19:
            UserAwareService.access$2200(this.this$0);
            return;
        L20:
            UserAwareService.access$2100(this.this$0);
            return;
        L21:
            UserAwareService.access$2000(this.this$0);
            return;
        L22:
            UserAwareService.access$1900(this.this$0, r8.obj.toString());
            return;
        L17:
            super.handleMessage(r8);
            return;
        L23:
            UserAwareService.access$800(this.this$0);
            sendEmptyMessageDelayed(100, 1000);
        }
    }

    public class UserAwareServiceBinder extends ICaeUserAware.Stub {
        private UserAwareService mService;
        final /* synthetic */ UserAwareService this$0;

        public UserAwareServiceBinder(UserAwareService r8, UserAwareService r10) {
            this.this$0 = r8;
            this.mService = r10;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void addBssidsToAvoidRomingScan(List<String> r8) {
            if (UserAwareService.access$400(this.this$0) != null) goto L5;
            return;
        L5:
            UserAwareService.access$400(this.this$0).addBssidsToAvoidRomingScan(r8);
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void addHomeWifiBssids(List<String> r8) {
            if (r8 == null) goto L7;
            Iterator<String> r10 = r8.iterator();
        L5:
            if (r10.hasNext() == false) goto L9;
            String r11 = r10.next();
            UserAwareService.access$400(this.this$0).getWifiFenceMonitor().addHomeWifiBssid(r11);
            goto L5
        L9:
            return;
        }

        public void cleanup() {
            this.mService = null;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void clearHomeWifiBssids() {
            UserAwareService.access$400(this.this$0).getWifiFenceMonitor().clearHomeWifiBssids();
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public HarMonitorParams getHarMonitorParams() {
            UserAwareService r8 = getService();
            if (r8 != null) goto L7;
            return null;
        L7:
            return UserAwareService.access$1500(r8);
        }

        public UserAwareService getService() {
            return this.mService;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyGeofenceChanged(int r8) {
            UserAwareService.access$400(this.this$0).notifyGeofenceChanged(r8);
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyHarEvent(HarEventData r8) {
            if (r8 != null) goto L5;
            CommSenseLog.w(UserAwareService.access$200(), "notifyHarEvent: value is null");
            return;
        L5:
            UserAwareService.access$1600(this.this$0).notifyHarEvent(r8);
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyLearningSuccess(boolean r8) {
            int r10 = Binder.getCallingUid();     // Catch: Throwable -> L15
            int r11 = Binder.getCallingPid();     // Catch: Throwable -> L15
            if (UserAwareService.access$1200(this.this$0) != null) goto L6;
        L8:
            String[] r12 = null;
        L9:
            String r13 = UserAwareService.access$200();     // Catch: Throwable -> L15
            StringBuilder r14 = new StringBuilder("notifyLearningSuccess(AIDL): success=");     // Catch: Throwable -> L15
            r14.append(r8);     // Catch: Throwable -> L15
            r14.append(", uid=");     // Catch: Throwable -> L15
            r14.append(r10);     // Catch: Throwable -> L15
            r14.append(", pid=");     // Catch: Throwable -> L15
            r14.append(r11);     // Catch: Throwable -> L15
            r14.append(", pkgs=");     // Catch: Throwable -> L15
            if (r12 != null) goto L12;
            String r15 = "null";
        L13:
            r14.append(r15);     // Catch: Throwable -> L15
            CommSenseLog.i(r13, r14.toString());     // Catch: Throwable -> L15
        L17:
            UserAwareService.access$400(this.this$0);
            return;
        L12:
            r15 = Arrays.toString(r12);     // Catch: Throwable -> L15
            goto L13
        L6:
            if (UserAwareService.access$1200(this.this$0).getPackageManager() == null) goto L8;
            r12 = UserAwareService.access$1200(this.this$0).getPackageManager().getPackagesForUid(r10);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            CommSenseLog.w(UserAwareService.access$200(), "notifyLearningSuccess(AIDL): log caller failed: " + th.getMessage());
            goto L17
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyRoomChangedPredicted(int r8) {
            UserAwareService.access$400(this.this$0).notifyRoomChangedPredicted(r8);
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void registerCallback(ICaeUserAwareCallback r8) {
            if (getService() != null) goto L5;
            return;
        L5:
            if (UserAwareService.access$600(this.this$0) == null) goto L9;
            UserAwareService.access$600(this.this$0).registerCallback(r8);
            return;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r8) {
            BtAwareInfoManager.getInstance(UserAwareService.access$1200(this.this$0)).registerSmartBluetoothEventCallback(r8);
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setHarMonitorParams(HarMonitorParams r8) {
            UserAwareService r10 = getService();
            if (r10 != null) goto L7;
            String r11 = UserAwareService.access$200();
            String r12 = "setHarMonitorParams: service is null";
        L5:
            CommSenseLog.w(r11, r12);
            return;
        L7:
            if (r8 != null) goto L9;
            r11 = UserAwareService.access$200();
            r12 = "setHarMonitorParams: params is null";
            goto L5
        L9:
            UserAwareService.access$1502(r10, r8);
            if (UserAwareService.access$1600(r10) == null) goto L12;
            UserAwareService.access$1600(r10).configureHarMonitorParams(r8);
            return;
        L12:
            CommSenseLog.w(UserAwareService.access$200(), "setHarMonitorParams: mQshHarManager is null");
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setHarState(int r8, long r10, int r11) {
            UserAwareManager.getInstance().notifyInnerCallbacks(new o5.o(15), Integer.valueOf(r8), Long.valueOf(r10));
            if (UserAwareService.access$1300(this.this$0) == null) goto L5;
            UserAwareService.access$1300(this.this$0).handleHarStateUpdate(r8, r10);
        L6:
            CaeUserAwareReportBase r12 = CaeUserAwareReportFactory.getReportInstance();
            if (r12 == null) goto L12;
            if (UserAwareService.access$1400(this.this$0).get() == false) goto L12;
            r12.reportHARStateInfo(new HARStateInfo(r8, r10, r11));
        L12:
            if (r8 == (-1)) goto L14;
        L16:
            AtomicBoolean r13 = this.this$0.mIsMemDHarEnabled;
            boolean r14 = true;
        L17:
            r13.set(r14);
            CommSenseLog.d(UserAwareService.access$200(), "setHarState: status: " + r8 + ", timestampMs: " + r10 + ", modelNumber: " + r11 + ", isMemDHarEnabled: " + this.this$0.mIsMemDHarEnabled.get());
            return;
        L14:
            if (this.this$0.mIsMemDHarEnabled.get() == false) goto L16;
            r13 = this.this$0.mIsMemDHarEnabled;
            r14 = false;
            goto L17
        L5:
            CommSenseLog.i(UserAwareService.access$200(), "mOemHarInfoManager is null");
            goto L6
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setLevel2DataCollection(List<HarLevel2DataReq> r8, int r10, HarLevel2DataResp r11) {
            if (r11 != null) goto L5;
            return;
        L5:
            if (UserAwareService.access$600(this.this$0) != null) goto L7;
            return;
        L7:
            UserAwareService.access$600(this.this$0).setLevel2DataCollection(this.this$0.getApplicationContext(), r8, r10, r11);
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setWifiRssiTriggerThresholds(int r8, int r10, int r11, int r12, int r13) {
            if (UserAwareService.access$400(this.this$0) != null) goto L5;
            return;
        L5:
            String r14 = UserAwareService.access$200();
            StringBuilder r15 = defpackage.a.g("setWifiRssiTriggerThresholds(AIDL): jumpDb=", r8, ", homeWindowMs=", r10, ", homeDropDb=");
            defpackage.b.q(r15, r11, ", companyWindowMs=", r12, ", companyDropDb=");
            r15.append(r13);
            CommSenseLog.i(r14, r15.toString());
            UserAwareService.access$400(this.this$0).setWifiRssiTriggerThresholds(r8, r10, r11, r12, r13);
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void unregisterCallback(ICaeUserAwareCallback r8) {
            if (getService() != null) goto L5;
            return;
        L5:
            if (UserAwareService.access$600(this.this$0) == null) goto L10;
            UserAwareService.access$600(this.this$0).unregisterCallback(r8);
            return;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r8) {
            BtAwareInfoManager.getInstance(UserAwareService.access$1200(this.this$0)).unregisterSmartBluetoothEventCallback(r8);
        }
    }

    public class WifiSignalReceiver extends BroadcastReceiver {
        final /* synthetic */ UserAwareService this$0;

        private WifiSignalReceiver(UserAwareService r8) {
            this.this$0 = r8;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            String r11 = r10.getAction();
            if ("android.net.wifi.RSSI_CHANGED".equals(r11) == false) goto L6;
            CommSenseLog.d(UserAwareService.access$200(), "RSSI Changed Broadcast Received");
            UserAwareService.access$800(this.this$0);
            return;
        L6:
            if ("android.net.wifi.STATE_CHANGE".equals(r11) == false) goto L23;
            NetworkInfo r12 = (NetworkInfo) r10.getParcelableExtra("networkInfo");
            if (r12 != null) goto L10;
            return;
        L10:
            if (r12.getState() != NetworkInfo.State.CONNECTED) goto L12;
        L14:
            boolean r13 = r12.isConnected();
            long r14 = SystemClock.elapsedRealtime();
            if (r13 == UserAwareService.access$900(this.this$0)) goto L17;
        L20:
            UserAwareService.access$902(this.this$0, r13 ? 1 : 0);
            UserAwareService.access$1002(this.this$0, r14);
            Message r15 = UserAwareService.access$1100(this.this$0).obtainMessage(3);
            r15.arg1 = r13 ? 1 : 0;
            UserAwareService.access$1100(this.this$0).sendMessage(r15);
            return;
        L17:
            if ((r14 - UserAwareService.access$1000(this.this$0)) >= 1000) goto L20;
            String r16 = UserAwareService.access$200();
            StringBuilder r17 = defpackage.b.f("Ignore duplicate wifi conn state broadcast: state=", r13 ? 1 : 0, ", delta=");
            r17.append(r14 - UserAwareService.access$1000(this.this$0));
            r17.append("ms");
            CommSenseLog.d(r16, r17.toString());
            return;
        L12:
            if (r12.getState() == NetworkInfo.State.DISCONNECTED) goto L14;
            return;
        }

        public /* synthetic */ WifiSignalReceiver(UserAwareService r8, AnonymousClass1 r10) {
            this(r8);
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
        final Handler r8 = new Handler(Looper.getMainLooper());
        this.mProactiveAgentObserver = new AnonymousClass2(this, r8);
        this.mWifiAwareInfoMonitor = new AnonymousClass3(this);
        this.mSensorCollectMonitor = new AnonymousClass4(this);
    }

    public static /* synthetic */ String a(String r8, boolean r10) {
        return lambda$dump$0(r10, r8);
    }

    public static /* synthetic */ void access$000(UserAwareService r8, CellAwareInfo r10) {
        r8.notifyCellInfoChanged(r10);
    }

    public static /* synthetic */ void access$100(UserAwareService r8, List r10) {
        r8.notifyCellNeighbourInfoChanged(r10);
    }

    public static /* synthetic */ long access$1000(UserAwareService r8) {
        return r8.mLastWifiConnStateFromBroadcastElapsedMs;
    }

    public static /* synthetic */ long access$1002(UserAwareService r8, long r10) {
        r8.mLastWifiConnStateFromBroadcastElapsedMs = r10;
        return r10;
    }

    public static /* synthetic */ UserAwareHandler access$1100(UserAwareService r8) {
        return r8.mUserAwareHandler;
    }

    public static /* synthetic */ Context access$1200(UserAwareService r8) {
        return r8.mContext;
    }

    public static /* synthetic */ OemHarInfoManager access$1300(UserAwareService r8) {
        return r8.mOemHarInfoManager;
    }

    public static /* synthetic */ AtomicBoolean access$1400(UserAwareService r8) {
        return r8.mIsRawDaraReport;
    }

    public static /* synthetic */ HarMonitorParams access$1500(UserAwareService r8) {
        return r8.mHarMonitorParams;
    }

    public static /* synthetic */ HarMonitorParams access$1502(UserAwareService r8, HarMonitorParams r10) {
        r8.mHarMonitorParams = r10;
        return r10;
    }

    public static /* synthetic */ QshHarManager access$1600(UserAwareService r8) {
        return r8.mQshHarManager;
    }

    public static /* synthetic */ void access$1700(UserAwareService r8, int r10) {
        r8.handlePeriodicUploadModeChange(r10);
    }

    public static /* synthetic */ void access$1800(UserAwareService r8, int r10) {
        r8.handleWifiConnectionStateChange(r10);
    }

    public static /* synthetic */ void access$1900(UserAwareService r8, String r10) {
        r8.handleLocationStateChangeValue(r10);
    }

    public static /* synthetic */ String access$200() {
        return TAG;
    }

    public static /* synthetic */ void access$2000(UserAwareService r8) {
        r8.handleHarNotificationEnableChange();
    }

    public static /* synthetic */ void access$2100(UserAwareService r8) {
        r8.handleHarEnableChange();
    }

    public static /* synthetic */ void access$2200(UserAwareService r8) {
        r8.handleHarRawDataReportChange();
    }

    public static /* synthetic */ void access$2300(UserAwareService r8) {
        r8.checkProvisionAndNotify();
    }

    public static /* synthetic */ void access$2400(UserAwareService r8, int r10) {
        r8.handleUserFeedbackPredictSwitchChange(r10);
    }

    public static /* synthetic */ void access$2500(UserAwareService r8, int r10) {
        r8.handleSubwayTestToolEnableChange(r10);
    }

    public static /* synthetic */ void access$2600(UserAwareService r8, int r10) {
        r8.handleSubwayFeedbackSwitchChange(r10);
    }

    public static /* synthetic */ void access$2700(UserAwareService r8, int r10) {
        r8.handleHarEventTestToolEnableChange(r10);
    }

    public static /* synthetic */ void access$2800(UserAwareService r8) {
        r8.handleMemDGPSSwithChange();
    }

    public static /* synthetic */ void access$300(UserAwareService r8) {
        r8.initSubWayAware();
    }

    public static /* synthetic */ WifiAwareInfoManager access$400(UserAwareService r8) {
        return r8.mWifiAwareInfoManager;
    }

    public static /* synthetic */ void access$500(UserAwareService r8) {
        r8.updateWifiScanCountIfTodayChanged();
    }

    public static /* synthetic */ UserAwareManager access$600(UserAwareService r8) {
        return r8.mUserAwareManager;
    }

    public static /* synthetic */ void access$800(UserAwareService r8) {
        r8.processWifiInfoAndSend();
    }

    public static /* synthetic */ int access$900(UserAwareService r8) {
        return r8.mLastWifiConnStateFromBroadcast;
    }

    public static /* synthetic */ int access$902(UserAwareService r8, int r10) {
        r8.mLastWifiConnStateFromBroadcast = r10;
        return r10;
    }

    public static /* synthetic */ void b(UserAwareService r8, boolean r10) {
        r8.lambda$initSubWayAware$1(r10);
    }

    public static /* synthetic */ void c(UserAwareService r8, HandlerThread r10) {
        r8.lambda$initSubWayAware$2(r10);
    }

    private void checkProvisionAndNotify() {
        int r8 = Settings.Global.getInt(getContentResolver(), "device_provisioned", 0);
        CommSenseLog.d(TAG, "checkProvisionAndNotify enable=" + r8);
        this.mUserAwareManager.notifyInnerCallbacks(new r1.s(7), Integer.valueOf(r8));
    }

    public static synchronized void clearAwareService(UserAwareService r8) {
        monitor-enter(UserAwareService.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sService != r8) goto L7;
        sService = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(UserAwareService.class);
    }

    public static synchronized UserAwareService getService() {
        monitor-enter(UserAwareService.class);
        UserAwareService r8 = sService;     // Catch: Throwable -> L7
        monitor-exit(UserAwareService.class);
        return r8;
    L7:
        th = move-exception;
        throw th;
    }

    private void handleHarEnableChange() {
        boolean r8 = false;
        int r10 = Settings.Global.getInt(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR, 0);
        CommSenseLog.d(TAG, "har enable change: " + r10);
        if (r10 != 0) goto L7;
        OemHarInfoManager r11 = this.mOemHarInfoManager;
        if (r11 == null) goto L12;
        r11.clear();
        this.mOemHarInfoManager = null;
    L12:
        if (this.mUserAwareManager == null) goto L15;
        UserAwareManager.getInstance().notifyInnerCallbacks(new com.obric.cae.location.geofence.a(7), Integer.valueOf(r10));
        return;
    L15:
        return;
    L7:
        this.mOemHarInfoManager = OemHarInfoManager.getInstance(getApplicationContext());
        int r12 = Settings.Global.getInt(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR_NOTIFICATION, 0);
        OemHarInfoManager r13 = this.mOemHarInfoManager;
        if (r12 == 0) goto L10;
        r8 = true;
    L10:
        r13.setHarEnableNotification(r8);
        goto L12
    }

    private void handleHarEventTestToolEnableChange(int r8) {
        CommSenseLog.i(TAG, "Received HAR event test tool enable change: " + r8);
        boolean r10 = true;
        if (r8 == 1) goto L6;
        r10 = false;
    L6:
        if (r10 == true) goto L8;
    L10:
        if (r10 == false) goto L12;
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

    private void handleHarNotificationEnableChange() {
        boolean r8 = false;
        int r10 = Settings.Global.getInt(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR_NOTIFICATION, 0);
        OemHarInfoManager r11 = this.mOemHarInfoManager;
        if (r11 == null) goto L8;
        if (r10 == 0) goto L6;
        r8 = true;
    L6:
        r11.setHarEnableNotification(r8);
        return;
    }

    private void handleHarRawDataReportChange() {
        int r8 = Settings.Global.getInt(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_HAR_RAW_DATA_REPORT, 0);
        String r10 = TAG;
        CommSenseLog.d(r10, "har wakelock time change: " + r8);
        AtomicBoolean r11 = this.mIsRawDaraReport;
        if (r8 == 0) goto L5;
        r11.set(true);
        return;
    L5:
        r11.set(false);
        CommSenseLog.w(r10, "har raw data report is closed");
    }

    private void handleLocationStateChangeValue(String r8) {
        String r10 = UserAwareUtil.getStateChangeString(getApplication(), r8);
        if (r10.isEmpty() == false) goto L6;
        CommSenseLog.e(TAG, "Received useless location state value");
        return;
    L6:
        notifyLocationStateValueChange(r8);
        String r11 = TAG;
        CommSenseLog.dumpI(r11, "Received location state value: ".concat(r10), this.mUserAwareEventsFile);
        if (r10.equals(UserAwareUtil.getStringValueFromXML(this, R.string.user_aware_aware_local_state_learning)) == false) goto L10;
        CommSenseLog.e(r11, r10);
        return;
    }

    private void handleMemDGPSSwithChange() {
        int r8 = Settings.Global.getInt(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_WIFI_SCAN_FUNCTION, 0);
        CommSenseLog.d(TAG, "handleMemDGPSSwithChange: enable -- " + r8);
        if (r8 != 1) goto L5;
        this.mWifiAwareInfoManager.setEnableWifiScanFunction(true);
        initSubWayAware();
        return;
    L5:
        this.mWifiAwareInfoManager.setEnableWifiScanFunction(false);
        SubwayFusionAware.getInstance(this).release();
    }

    private void handlePeriodicUploadModeChange(int r8) {
        int r10 = Settings.Global.getInt(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_USER_PERIODIC_UPLOAD_MODE, -1);
        CommSenseLog.i(TAG, "Updated mPeriodicUploadMode to " + r10);
        UserAwareManager r11 = this.mUserAwareManager;
        if (r11 == null) goto L6;
        r11.notifyInnerCallbacks(new o5.o(13), Integer.valueOf(r10));
        return;
    }

    private void handleSubwayFeedbackSwitchChange(int r8) {
        CommSenseLog.i(TAG, "Received subway feedback switch change: " + r8);
        if (this.mUserAwareManager == null) goto L6;
        UserAwareManager.getInstance().notifyInnerCallbacks(new o5.o(14), Integer.valueOf(r8));
        return;
    }

    private void handleSubwayTestToolEnableChange(int r8) {
        CommSenseLog.i(TAG, "Received subway test tool enable change: " + r8);
        boolean r10 = true;
        if (r8 == 1) goto L6;
        r10 = false;
    L6:
        if (r10 == true) goto L8;
    L10:
        if (r10 == false) goto L12;
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

    private void handleUserFeedbackPredictSwitchChange(int r8) {
        CommSenseLog.i(TAG, "Received user feedback predict switch change: " + r8);
        if (this.mUserAwareManager == null) goto L6;
        UserAwareManager.getInstance().notifyInnerCallbacks(new o5.o(9), Integer.valueOf(r8));
        return;
    }

    private void handleWifiConnectionStateChange(int r8) {
        CommSenseLog.i(TAG, "Received wifi connection state change: " + r8);
        this.mWifiAwareInfoManager.handleWifiConnectionStateChanged(r8);
    }

    private void init() {
        initUserAwareFile();
        CellAwareInfoManger r8 = CellAwareInfoManger.getInstance(this);
        if (r8 == null) goto L5;
        r8.registerMonitor(this.mCellAwareInfoMonitor);
    L5:
        BtAwareInfoManager r10 = BtAwareInfoManager.getInstance(this);
        LocationAwareInfoManager r11 = LocationAwareInfoManager.getInstance(this);
        this.mStarLocationDbManager = StarLocationDbManager.getInstance(this, UserHandle.getUserId(Process.myUid()));
        SensorCollectManager r12 = SensorCollectManager.getInstance(this);
        r12.registerSensorCollectMonitor(this.mSensorCollectMonitor);
        r12.registerStepsCounter();
        WifiAwareInfoManager r13 = WifiAwareInfoManager.getInstance(this);
        this.mWifiAwareInfoManager = r13;
        r13.registerWifiAwareInfoMonitor(this.mWifiAwareInfoMonitor);
        if (this.mLearningProgressSettingsObserver != null) goto L9;
        LearningProgressSettingsObserver r14 = new LearningProgressSettingsObserver(this, this.mWifiAwareInfoManager);
        this.mLearningProgressSettingsObserver = r14;
        r14.register();
    L9:
        if (Settings.Global.getInt(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_HAR, 0) != 1) goto L11;
        this.mOemHarInfoManager = OemHarInfoManager.getInstance(this);
    L11:
        this.mUserAwareHandler = new UserAwareHandler(this);
        Messenger r15 = new Messenger(this.mUserAwareHandler);
        Intent r16 = new Intent();
        r16.setComponent(new ComponentName("com.obric.cae", "com.obric.cae.smartNetwork.SmartNetworkService"));
        r16.putExtra(INTENT_EXTRA_OBJECT_MESSENGER, r15);
        startService(r16);     // Catch: Exception -> L14
    L16:
        AwareStateListener r17 = AwareStateListener.getInstance();
        this.mAwareStateListener = r17;
        r17.initOnce(this, r15);
        this.mAwareStateListener.setWifiScanStateMachine(this.mWifiAwareInfoManager);
        this.mAwareStateListener.loadSaveWifiScanParams();
        if (UserAwareUtil.isFirstPartyDevice() == false) goto L19;
        this.mUserAwareCloudBinderClient = new UserAwareCloudBinderClient(this);
    L20:
        AudioAwareInfoManger r18 = AudioAwareInfoManger.getInstance(this);
        CaeUserAwareReportFactory.createReportInstance(CaeUserAwareReportJson.getInstance(this.mContext));
        this.mQshHarManager = new QshHarManager();
        UserAwareManager r19 = UserAwareManager.getInstance();
        this.mUserAwareManager = r19;
        r19.initManager(this.mWifiAwareInfoManager, r10, r11, r8, r18, r12, this.mOemHarInfoManager);
        initMatrixTeaManager();
        checkProvisionAndNotify();
        NearElevator r20 = NearElevator.getInstance(this);
        if (r20 == null) goto L23;
        r20.setWifiAwareInfoManager(this.mWifiAwareInfoManager);
    L23:
        initSubWayAware();
        LabFeatureChecker.registerProactiveAgentObserver(this, this.mProactiveAgentObserver);
        if (UserAwareUtil.isHarEventTestToolEnabled(this) == false) goto L26;
        initHarEventTestTool();
    L26:
        handleHarRawDataReportChange();
        if (Objects.equals(getPackageName(), "com.obric.cae") == true) goto L35;
        this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        if (this.mWifiSignalReceiver != null) goto L31;
        this.mWifiSignalReceiver = new WifiSignalReceiver(this, null);
        IntentFilter r21 = defpackage.a.c("android.net.wifi.RSSI_CHANGED", "android.net.wifi.STATE_CHANGE");
        registerReceiver(this.mWifiSignalReceiver, r21);
    L31:
        this.mUserAwareHandler.sendEmptyMessage(100);
        return;
    L35:
        return;
    L19:
        CommSenseLog.d(TAG, "Not initializing cloud binder client for non-first-party device");
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    private void initHarEventTestTool() {
        if (this.mHarEventTestTool == null) goto L5;
        return;
    L5:
        HarEventTestTool r8 = new HarEventTestTool(this);
        r8.register();
        this.mHarEventTestTool = r8;
        CommSenseLog.i(TAG, "HarEventTestTool registered");
    }

    private void initMatrixTeaManager() {
        MatrixDidUtils.init(this.mContext);
    }

    private void initSubWayAware() {
        HandlerThread r8 = new HandlerThread("UserAwareBackground-" + System.currentTimeMillis());
        r8.start();
        new Handler(r8.getLooper()).post(new x(7, this, r8));
    }

    private void initSubwayTestTool(SubwayFusionAware r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (this.mSubwayFusionAwareTestTool != null) goto L9;
        SubwayFusionAwareTestTool r10 = new SubwayFusionAwareTestTool(this, r8);
        r10.register();
        this.mSubwayFusionAwareTestTool = r10;
        CommSenseLog.i(TAG, "SubwayFusionAwareTestTool registered");
        return;
    }

    private void initUserAwareFile() {
        File r8 = new File(UserAwareUtil.getLocalDir(this.mContext, "user_aware"), "user_aware_events.txt");
        r8.delete();
        r8.createNewFile();     // Catch: IOException -> L5
    L6:
        this.mUserAwareEventsFile = r8;
        CommSenseLog.d(TAG, "initUserAwareFile, file: " + this.mUserAwareEventsFile);
        CommSenseLog.recordFileWithKey("user_aware", this.mUserAwareEventsFile);
        return;
    L5:
        CommSenseLog.e(TAG, "IO error occurred!");
        goto L6
    }

    private static boolean isAppDebuggable(Context r8) {
        if ((r8.getApplicationInfo().flags & 2) == 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    private static /* synthetic */ String lambda$dump$0(boolean r8, String r10) {
        if (r8 == true) goto L4;
        return r10;
    L4:
        return CommSenseLog.decryptCaeLog(r10);
    }

    private /* synthetic */ void lambda$initSubWayAware$1(boolean r8) {
        if (r8 == false) goto L4;
    L5:
        SubwayFusionAware r10 = SubwayFusionAware.getInstance(this);
        this.mSubwayFusionAware = r10;
        if (r10 == null) goto L9;
        r10.init();
        CommSenseLog.i(TAG, "SubwayFusionAware initialized");
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
    private /* synthetic */ void lambda$initSubWayAware$2(HandlerThread r8) {
        String r10 = TAG;     // Catch: Throwable -> L5 Exception -> L7
        CommSenseLog.d(r10, "initSubWayAware running on thread: " + Thread.currentThread().getName());     // Catch: Throwable -> L5 Exception -> L7
        boolean r11 = LabFeatureChecker.isProactiveAgentEnabled(this);     // Catch: Throwable -> L5 Exception -> L7
        CommSenseLog.d(r10, "initSubWayAware: isLabFeatureOpen -- " + r11);     // Catch: Throwable -> L5 Exception -> L7
        this.mUserAwareHandler.post(new o5.u(this, 1, r11));     // Catch: Throwable -> L5 Exception -> L7
        r8.quitSafely();
        StringBuilder r12 = new StringBuilder("Background thread quit: ");
        String r13 = r8.getName();
        r12.append(r13);
        CommSenseLog.d(r10, r12.toString());
        r8 = r13;
    L13:
        return;
    L5:
        th = move-exception;
        r8.quitSafely();
        CommSenseLog.d(TAG, "Background thread quit: " + r8.getName());
        throw th;
    L7:
        e = move-exception;
        String r14 = TAG;     // Catch: Throwable -> L5
        CommSenseLog.e(r14, "initSubWayAware failed", e);     // Catch: Throwable -> L5
        r8.quitSafely();
        StringBuilder r15 = new StringBuilder("Background thread quit: ");
        String r16 = r8.getName();
        r15.append(r16);
        CommSenseLog.d(r14, r15.toString());
        r8 = r16;
        goto L13
    }

    private void notifyCellInfoChanged(CellAwareInfo r8) {
        UserAwareManager r10 = this.mUserAwareManager;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.notifyCallbacks(new o5.o(12), r8);
        this.mUserAwareManager.notifyInnerCallbacks(new r1.s(11), r8);
    }

    private void notifyCellNeighbourInfoChanged(List<CellAwareInfo> r8) {
        UserAwareManager r10 = this.mUserAwareManager;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.notifyCallbacks(new r1.s(8), r8);
        this.mUserAwareManager.notifyInnerCallbacks(new com.obric.cae.location.geofence.a(5), r8);
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
        WifiManager r8 = this.mWifiManager;
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.mUserAwareHandler == null) goto L29;
        WifiInfo r10 = r8.getConnectionInfo();
        if (r10 == null) goto L28;
        int r11 = -1;
        if (r10.getNetworkId() != (-1)) goto L13;
        return;
    L13:
        if (r10.equals(this.mLastWifiInfo) == false) goto L16;
        CommSenseLog.d(TAG, "No WifiInfo update");
        return;
    L16:
        Bundle r12 = new Bundle();
        r12.putString(WiFiDBHelper.COL_BSSID, r10.getBSSID());
        r12.putString("ssid", r10.getSSID());
        r12.putInt(WiFiDBHelper.COL_RSSI, r10.getRssi());
        r12.putInt("frequency", r10.getFrequency());
        r12.putLong("timestamp", System.currentTimeMillis());
        r12.putInt("apStandard", r10.getWifiStandard());
        Iterator<WifiConfiguration> r13 = this.mWifiManager.getConfiguredNetworks().iterator();
    L18:
        if (r13.hasNext() == false) goto L22;
        WifiConfiguration r14 = r13.next();
        if (r14.SSID.equals(r10.getSSID()) == false) goto L18;
        r11 = WifiConfiguration.isMetered(r14, r10);
    L22:
        r12.putInt("apType", r11);
        Message r15 = this.mUserAwareHandler.obtainMessage(1);
        r15.setData(r12);
        this.mUserAwareHandler.sendMessage(r15);
        this.mLastWifiInfo = r10;
        return;
    L28:
        return;
    }

    private void releaseHarEventTestTool() {
        HarEventTestTool r8 = this.mHarEventTestTool;
        if (r8 != null) goto L10;
        return;
    L10:
        r8.unregister();     // Catch: Exception -> L7
        this.mHarEventTestTool = null;     // Catch: Exception -> L7
        CommSenseLog.i(TAG, "HarEventTestTool unregistered");     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to unregister HarEventTestTool", e);
    }

    private void releaseSubwayTestTool() {
        Object r8 = this.mSubwayFusionAwareTestTool;
        if (r8 != null) goto L10;
        return;
    L10:
        ((SubwayFusionAwareTestTool) r8).unregister();     // Catch: Exception -> L7
        this.mSubwayFusionAwareTestTool = null;     // Catch: Exception -> L7
        CommSenseLog.i(TAG, "SubwayFusionAwareTestTool unregistered");     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to unregister test tool", e);
    }

    public static synchronized void setUserAwareService(UserAwareService r8) {
        monitor-enter(UserAwareService.class);
        if (r8 != null) goto L13;
        monitor-exit(UserAwareService.class);
        return;
    L13:
        sService = r8;     // Catch: Throwable -> L10
        monitor-exit(UserAwareService.class);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void updateWifiScanCountIfTodayChanged() {
        long r8 = System.currentTimeMillis();
        WifiAwareInfoManager r10 = this.mWifiAwareInfoManager;
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L10;
        int r12 = 2;
    L11:
        WifiAwareInfoManager r13 = this.mWifiAwareInfoManager;
        if (r13 == null) goto L14;
        Integer r14 = Integer.valueOf(r13.getLastScanSceneType());
    L15:
        this.mWifiScanCount.setTimeStamp(r8);
        if (r14 == null) goto L18;
        this.mWifiScanCount.setSceneType(r14.intValue());
    L19:
        this.mWifiScanCount.setScanType(r12);
        this.mWifiScanCount.setDateScanDropCount(UserAwareUtil.getUserAwareWifiScanDropCountToday(this));
        String r15 = this.mDateFormat.format(Long.valueOf(r8));
        if (r15.equals(this.mLastDailyDate) == true) goto L22;
        this.mWifiScanCount.setDateScanCount(0);
        this.mLastDailyDate = r15;
    L22:
        WifiScanCount r16 = this.mWifiScanCount;
        r16.setDateScanCount(r16.getDateScanCount() + 1);
        CaeUserAwareReportBase r17 = CaeUserAwareReportFactory.getReportInstance();
        if (r17 == null) goto L26;
        r17.reportScanCount(this.mWifiScanCount);
        return;
    L26:
        return;
    L18:
        this.mWifiScanCount.setSceneType(-1);
        goto L19
    L14:
        r14 = null;
        goto L15
    L10:
        r12 = 0;
        goto L11
    L5:
        if (r10.isTrainingMode() == false) goto L7;
        r11 = true;
        goto L8
    }

    @Override // android.app.Service
    public void dump(FileDescriptor r8, PrintWriter r10, String[] r11) {
        int r12 = 1;
        boolean r13 = false;
        if (r11.length > 0) goto L5;
    L7:
        r10.println("UserAware Log:");
        CommSenseLog.dumpFileContent(this.mUserAwareEventsFile, r10, new com.obric.cae.location.geosdk.poi.b(r13, r12));
        return;
    L5:
        if ("--NeedDecrypt".equalsIgnoreCase(r11[0]) == false) goto L7;
        r13 = true;
        goto L7
    }

    public StarGeofence getGeofenceStatusByGeoType(byte r8) {
        Iterator<StarGeofence> r10 = this.mStarLocationDbManager.queryAllGeofences().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        StarGeofence r11 = r10.next();
        if (r11.getGeoType() != StarGeofence.GeoType.values()[r8]) goto L4;
        CommSenseLog.d(TAG, "getGeofenceStatusByGeoType: " + r11);
        return r11;
    L9:
        return null;
    }

    public String getLearningProgressValue() {
        AwareStateListener r8 = this.mAwareStateListener;
        if (r8 == null) goto L7;
        return r8.getLearningProgressValue();
    L7:
        return getResources().getString(R.string.user_aware_aware_local_state_learning);
    }

    public String getLocationStateValueDesc() {
        AwareStateListener r8 = this.mAwareStateListener;
        if (r8 != null) goto L5;
        return "";
    L5:
        return r8.getLocationStateValueDesc();
    }

    public WifiStandardData getWifiConnectInfo() {
        WifiAwareInfoManager r8 = this.mWifiAwareInfoManager;
        if (r8 != null) goto L5;
        return null;
    L5:
        return r8.getWifiConnectInfo();
    }

    public List<WifiStandardData> getWifiScanNeighborAp() {
        WifiAwareInfoManager r8 = this.mWifiAwareInfoManager;
        if (r8 != null) goto L5;
        return null;
    L5:
        return r8.getWifiScanNeighborAp();
    }

    public void notifyLocationStateValueChange(String r8) {
        UserAwareManager r10 = this.mUserAwareManager;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.notifyInnerCallbacks(new r1.s(12), r8);
    }

    public void notifySensorDataChange(SensorEvent r8) {
        UserAwareManager r10 = this.mUserAwareManager;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.notifyInnerCallbacks(new com.obric.cae.location.geofence.a(8), r8);
    }

    public void notifyWifiConnectInfoChanged(WifiStandardData r8) {
        UserAwareManager r10 = this.mUserAwareManager;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.notifyInnerCallbacks(new com.obric.cae.location.geofence.a(6), r8);
        this.mUserAwareManager.notifyCallbacks(new o5.o(11), r8);
    }

    public void notifyWifiNetworkAvailable(boolean r8) {
        UserAwareManager r10 = this.mUserAwareManager;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.notifyCallbacks(new o5.o(10), Boolean.valueOf(r8));
        this.mUserAwareManager.notifyInnerCallbacks(new r1.s(9), Boolean.valueOf(r8));
    }

    public void notifyWifiScanInfoChanged(List<WifiStandardData> r8) {
        UserAwareManager r10 = this.mUserAwareManager;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.notifyCallbacks(new r1.s(13), r8);
    }

    public void notifyWifiScanNeighborApChanged(List<WifiStandardData> r8) {
        this.mUserAwareManager.notifyInnerCallbacks(new r1.s(10), r8);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r8) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        CommSenseLog.d(TAG, "onCreate");
        this.mContext = getApplicationContext();
        this.mBinder = new UserAwareServiceBinder(this, this);
        setUserAwareService(this);
        init();
        CaeRuntime.notifyServiceReady(this.mContext, UserAwareService.class, this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        CommSenseLog.d(TAG, "onDestroy");
        WifiSignalReceiver r8 = this.mWifiSignalReceiver;     // Catch: Throwable -> L39 Exception -> L41
        if (r8 == null) goto L6;
        unregisterReceiver(r8);     // Catch: Throwable -> L39 Exception -> L41
    L6:
        UserAwareServiceBinder r10 = this.mBinder;     // Catch: Throwable -> L39 Exception -> L41
        if (r10 == null) goto L9;
        r10.cleanup();     // Catch: Throwable -> L39 Exception -> L41
    L9:
        AwareStateListener r11 = this.mAwareStateListener;     // Catch: Throwable -> L39 Exception -> L41
        if (r11 == null) goto L12;
        r11.unregisterSettingsObserver();     // Catch: Throwable -> L39 Exception -> L41
    L12:
        LearningProgressSettingsObserver r12 = this.mLearningProgressSettingsObserver;     // Catch: Throwable -> L39 Exception -> L41
        if (r12 == null) goto L15;
        r12.unregister();     // Catch: Throwable -> L39 Exception -> L41
        this.mLearningProgressSettingsObserver = null;     // Catch: Throwable -> L39 Exception -> L41
    L15:
        UserAwareCloudBinderClient r13 = this.mUserAwareCloudBinderClient;     // Catch: Throwable -> L39 Exception -> L41
        if (r13 == null) goto L18;
        r13.close();     // Catch: Throwable -> L39 Exception -> L41
        this.mUserAwareCloudBinderClient = null;     // Catch: Throwable -> L39 Exception -> L41
    L18:
        UserAwareManager r14 = this.mUserAwareManager;     // Catch: Throwable -> L39 Exception -> L41
        if (r14 == null) goto L21;
        r14.clearInnerCallbacks();     // Catch: Throwable -> L39 Exception -> L41
    L21:
        UserAwareHandler r15 = this.mUserAwareHandler;     // Catch: Throwable -> L39 Exception -> L41
        if (r15 == null) goto L24;
        r15.removeCallbacksAndMessages(null);     // Catch: Throwable -> L39 Exception -> L41
    L24:
        releaseSubwayTestTool();     // Catch: Throwable -> L39 Exception -> L41
        SubwayFusionAware r16 = SubwayFusionAware.getInstance(this);     // Catch: Throwable -> L39 Exception -> L41
        if (r16 == null) goto L27;
        r16.release();     // Catch: Throwable -> L39 Exception -> L41
    L27:
        CaeUserAwareReportBase r17 = CaeUserAwareReportFactory.getReportInstance();     // Catch: Throwable -> L39 Exception -> L41
        if (r17 == null) goto L30;
        CaeUserAwareReportFactory.releaseReportInstance();     // Catch: Throwable -> L39 Exception -> L41
        r17.cleanup();     // Catch: Throwable -> L39 Exception -> L41
    L30:
        clearAwareService(this);     // Catch: Throwable -> L39 Exception -> L41
        OemHarInfoManager r18 = this.mOemHarInfoManager;     // Catch: Throwable -> L39 Exception -> L41
        if (r18 == null) goto L47;
        r18.clear();     // Catch: Throwable -> L39 Exception -> L41
    L47:
        LabFeatureChecker.unregisterProactiveAgentObserver(this, this.mProactiveAgentObserver);     // Catch: Throwable -> L35
    L37:
        SubwayFusionAware.getInstance(this).release();     // Catch: Throwable -> L39 Exception -> L41
    L43:
        CaeRuntime.unregisterService(UserAwareService.class, this);
        return;
    L35:
        th = move-exception;
        CommSenseLog.e(TAG, "destroy unregister observer failed", th);     // Catch: Throwable -> L39 Exception -> L41
    L41:
        e = move-exception;
        CommSenseLog.e(TAG, "Cleanup failed", e);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CaeRuntime.unregisterService(UserAwareService.class, this);
        throw th;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r8, int r10, int r11) {
        return super.onStartCommand(r8, r10, r11);
    }

    public void updateWifiScanCountForPnoChanged(boolean r8) {
        long r10 = System.currentTimeMillis();
        UserAwareUtil.PnoStateSnapshot r11 = UserAwareUtil.onUserAwarePnoStateChanged(this, r8);
        CaeUserAwareReportBase.PnoStats r12 = new CaeUserAwareReportBase.PnoStats();
        r12.setTimeStamp(r10);
        if (r8 == false) goto L5;
        int r13 = 1;
    L6:
        r12.setEvent(r13);
        r12.setStartWallClockMs(r11.startWallClockMs);
        r12.setStopWallClockMs(r11.stopWallClockMs);
        r12.setDurationMs(r11.durationMs);
        r12.setPeriodMs(r11.periodMs);
        r12.setEstimatedRounds(r11.estimatedRounds);
        r12.setTotalDurationTodayMs(r11.totalDurationTodayMs);
        r12.setSessionCountToday(r11.sessionCountToday);
        r12.setEstimatedRoundsToday(r11.estimatedRoundsToday);
        CaeUserAwareReportBase r14 = CaeUserAwareReportFactory.getReportInstance();
        if (r14 == null) goto L10;
        r14.reportWifiPnoStats(r12);
        return;
    L10:
        return;
    L5:
        r13 = 2;
        goto L6
    }
}
