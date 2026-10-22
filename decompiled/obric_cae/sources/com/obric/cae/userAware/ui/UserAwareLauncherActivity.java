package com.obric.cae.userAware.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.SensorEvent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.obric.cae.R;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.cloud.applog.ByteIOUtils;
import com.obric.cae.libs.useraware.BtAwareInfo;
import com.obric.cae.libs.useraware.GnssSvAwareInfo;
import com.obric.cae.libs.useraware.LocationAwareInfo;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.userAware.UserAwareService;
import com.obric.cae.userAware.datacollection.FileController;
import com.obric.cae.userAware.datacollection.UploadWorker;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.obric.cae.utils.CaeUtil;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.forms.OInputView;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.lisitem.OListItemSwitch;
import com.obric.oui.titlebar.OCTitleBar;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class UserAwareLauncherActivity extends Activity implements TextWatcher {
    private static final int DEFAULT_COLLECT_DATA_PERIOD_MS = 120000;
    static final int DEFAULT_COLLECT_MASK = 61423;
    private static final String KEY_COLLECTION_STATE = "collection_state";
    private static final double LOCATION_SPAN_INITIAL_DEG = 0.5d;
    private static final int LOCATION_TRACE_MAX_POINTS_PER_SERIES = 2000;
    private static final String TAG = "UserAwareLauncherActivity";
    private static final int TIME_STAMP = 100;
    private static final String ZPP_LOCATION_WORK_NAME = "ZppLocationWork";
    private static List<Float> ax = null;
    private static List<Float> ay = null;
    private static List<Float> az = null;
    private static List<Float> gx = null;
    private static List<Float> gy = null;
    private static List<Float> gz = null;
    private static List<Float> lx = null;
    private static List<Float> ly = null;
    private static List<Float> lz = null;
    private static List<Float> mx = null;
    private static List<Float> my = null;
    private static List<Float> mz = null;
    private static boolean sDevtoolsInitialized = false;
    private static List<Long> timestamps;
    private long lastBackPressedTime;
    private final HashMap<String, Integer> mBtCounts;
    private final Object mBtStatsLock;
    private final Handler mChartHandler;
    private OCheckBox mCheckBoxBicycle;
    private OCheckBox mCheckBoxCarPassenger;
    private OCheckBox mCheckBoxDriveCar;
    private OCheckBox mCheckBoxElevator;
    private OCheckBox mCheckBoxFullDay;
    private OCheckBox mCheckBoxMall;
    private OCheckBox mCheckBoxMotor;
    private OCheckBox mCheckBoxRailway;
    private OCheckBox mCheckBoxRunInside;
    private OCheckBox mCheckBoxRunOutside;
    private OCheckBox mCheckBoxStand;
    private OCheckBox mCheckBoxSubway;
    private OCheckBox mCheckBoxWalk;
    private OCheckBox mCheckBoxZppCollect;
    private final ArrayList<OCheckBox> mCheckBoxesList;
    private Button mCollectButton;
    private dc.e mCollectConfirmDialog;
    private dc.k mCollectConfirmDialogBuilder;
    private OListItemSwitch mCollectSwitch;
    private TextView mContentView;
    private boolean mHasLocationOrigin;
    private OInputView mInputView;
    private boolean mIsCollecting;
    private LauncherCallback mLauncherCallback;
    private String mLearningProgressValue;
    private LineChart mLineChartAcc;
    private LineChart mLineChartBtCounts;
    private LineChart mLineChartGnssCn0;
    private LineChart mLineChartGyro;
    private LineChart mLineChartLocation2d;
    private LineChart mLineChartWifiCounts;
    private final ArrayList<Float> mLocSeriesXGps;
    private final ArrayList<Float> mLocSeriesXNetwork;
    private final ArrayList<Float> mLocSeriesXOther;
    private final ArrayList<Float> mLocSeriesYGps;
    private final ArrayList<Float> mLocSeriesYNetwork;
    private final ArrayList<Float> mLocSeriesYOther;
    private double mLocationSpanDeg;
    private String mLocationStateValue;
    private double mOriginLatDeg;
    private double mOriginLonDeg;
    private int mRecordMask;
    private int mRecordTime;
    private int mSelectedCheckBoxId;
    private final Object mSensorListLock;
    private UserAwareService mService;
    private final Runnable mStatsTicker;
    private boolean mStatsTickerRunning;
    private OCTitleBar mTitle;
    private String mUserInputScene;
    private final HashMap<String, Integer> mWifiCounts;
    private final Object mWifiStatsLock;
    private androidx.work.v mWorkManager;
    private Button mZppAutoCollectLocationButton;
    private Button mZppGetLocationButton;
    private ProgressBar pbUploadCurrentFileDialog;
    private ProgressBar pbUploadOverallDialog;
    private dc.e progressDialog;
    private TextView tvProgressCurrentFileDialog;
    private TextView tvProgressOverallDialog;
    private TextView tvProgressTitleDialog;
    private UUID uploadWorkerId;
    private LiveData<androidx.work.u> workInfoLiveData;
    private androidx.lifecycle.u<androidx.work.u> workInfoObserver;

    public class LauncherCallback extends InnerAwareInfoCallback {
        final /* synthetic */ UserAwareLauncherActivity this$0;

        private LauncherCallback(UserAwareLauncherActivity r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(LauncherCallback r8, GnssSvAwareInfo r10) {
            r8.lambda$onGnssSvInfoChanged$3(r10);
        }

        public static /* synthetic */ void b(LauncherCallback r8, LocationAwareInfo r10) {
            r8.lambda$onLocationAwareInfoChanged$2(r10);
        }

        public static /* synthetic */ void c(LauncherCallback r8, boolean r10) {
            r8.lambda$onRecordNearbyStatus$0(r10);
        }

        public static /* synthetic */ void d(LauncherCallback r8, String r10) {
            r8.lambda$onLocationStateValueChange$1(r10);
        }

        private /* synthetic */ void lambda$onGnssSvInfoChanged$3(GnssSvAwareInfo r8) {
            UserAwareLauncherActivity.access$2400(this.this$0, r8);
        }

        private /* synthetic */ void lambda$onLocationAwareInfoChanged$2(LocationAwareInfo r8) {
            UserAwareLauncherActivity.access$2500(this.this$0, r8);
        }

        private /* synthetic */ void lambda$onLocationStateValueChange$1(String r8) {
            UserAwareLauncherActivity.access$2602(this.this$0, r8);
        }

        private void lambda$onRecordNearbyStatus$0(boolean r8) {
            if (r8 == UserAwareLauncherActivity.access$500(this.this$0).L.isChecked()) goto L6;
            UserAwareLauncherActivity.access$500(this.this$0).setChecked(r8);
            return;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onBtInfoChanged(BtAwareInfo r8) {
            UserAwareLauncherActivity.access$2200(this.this$0, r8);
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onGnssSvInfoChanged(GnssSvAwareInfo r8) {
            this.this$0.runOnUiThread(new p0(3, this, r8));
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onHARStatusChanged(int r8, long r10) {
            CaeLog.d(UserAwareLauncherActivity.TAG, "onHARStatusChanged: status=" + r8 + ", timestamp=" + r10);
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onInSubWayChange(int r8, String r10) {
            CaeLog.d(UserAwareLauncherActivity.TAG, "onInSubWayChange: isInSubWay=" + r8 + ", stationName=" + r10);
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onLocationAwareInfoChanged(LocationAwareInfo r8) {
            this.this$0.runOnUiThread(new f1(1, this, r8));
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onLocationStateValueChange(String r8) {
            defpackage.b.o("onLocationStateValueChange: ", r8, UserAwareLauncherActivity.TAG);
            this.this$0.runOnUiThread(new p0(2, this, r8));
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onRecordNearbyStatus(final boolean r8) {
            CaeLog.d(UserAwareLauncherActivity.TAG, "onRecordNearbyStatus: " + r8);
            if (UserAwareLauncherActivity.access$500(this.this$0) == null) goto L6;
            UserAwareLauncherActivity.access$500(this.this$0).post(new p1(this, r8));
            return;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onSensorDataChange(SensorEvent r8) {
            if (UserAwareLauncherActivity.access$600(this.this$0) == true) goto L5;
            return;
        L5:
            Object r10 = UserAwareLauncherActivity.access$700(this.this$0);
            monitor-enter(r10);
            int r11 = r8.sensor.getType();     // Catch: Throwable -> L22
            UserAwareLauncherActivity.access$800().add(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L22
            if (r11 != 1) goto L12;
            UserAwareLauncherActivity.access$900().add(Float.valueOf(r8.values[0]));     // Catch: Throwable -> L22
            UserAwareLauncherActivity.access$1000().add(Float.valueOf(r8.values[1]));     // Catch: Throwable -> L22
            List r12 = UserAwareLauncherActivity.access$1100();     // Catch: Throwable -> L22
            Float r13 = Float.valueOf(r8.values[2]);     // Catch: Throwable -> L22
        L10:
            r12.add(r13);     // Catch: Throwable -> L22
        L19:
            UserAwareLauncherActivity.access$2100(this.this$0);     // Catch: Throwable -> L22
            monitor-exit(r10);     // Catch: Throwable -> L22
            return;
        L12:
            if (r11 != 4) goto L15;
            UserAwareLauncherActivity.access$1200().add(Float.valueOf(r8.values[0]));     // Catch: Throwable -> L22
            UserAwareLauncherActivity.access$1300().add(Float.valueOf(r8.values[1]));     // Catch: Throwable -> L22
            r12 = UserAwareLauncherActivity.access$1400();     // Catch: Throwable -> L22
            r13 = Float.valueOf(r8.values[2]);     // Catch: Throwable -> L22
            goto L10
        L15:
            if (r11 != 10) goto L17;
            UserAwareLauncherActivity.access$1500().add(Float.valueOf(r8.values[0]));     // Catch: Throwable -> L22
            UserAwareLauncherActivity.access$1600().add(Float.valueOf(r8.values[1]));     // Catch: Throwable -> L22
            r12 = UserAwareLauncherActivity.access$1700();     // Catch: Throwable -> L22
            r13 = Float.valueOf(r8.values[2]);     // Catch: Throwable -> L22
            goto L10
        L17:
            if (r11 != 2) goto L19;
            UserAwareLauncherActivity.access$1800().add(Float.valueOf(r8.values[0]));     // Catch: Throwable -> L22
            UserAwareLauncherActivity.access$1900().add(Float.valueOf(r8.values[1]));     // Catch: Throwable -> L22
            r12 = UserAwareLauncherActivity.access$2000();     // Catch: Throwable -> L22
            r13 = Float.valueOf(r8.values[2]);     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onWifiConnectInfoChanged(WifiStandardData r8) {
            UserAwareLauncherActivity.access$2300(this.this$0, r8);
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onWifiScanInfoChanged(List<WifiStandardData> r8) {
            if (r8 != null) goto L4;
            return;
        L4:
            if (r8.isEmpty() == true) goto L12;
            Iterator<WifiStandardData> r10 = r8.iterator();
        L8:
            if (r10.hasNext() == false) goto L13;
            WifiStandardData r11 = r10.next();
            UserAwareLauncherActivity.access$2300(this.this$0, r11);
            goto L8
        L13:
            return;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onWifiScanNeighborApChanged(List<WifiStandardData> r8) {
            if (r8 != null) goto L4;
            return;
        L4:
            if (r8.isEmpty() == true) goto L12;
            Iterator<WifiStandardData> r10 = r8.iterator();
        L8:
            if (r10.hasNext() == false) goto L13;
            WifiStandardData r11 = r10.next();
            UserAwareLauncherActivity.access$2300(this.this$0, r11);
            goto L8
        L13:
            return;
        }

        public /* synthetic */ LauncherCallback(UserAwareLauncherActivity r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public static class ZppLocationWork extends Worker {
        public ZppLocationWork(Context r8, WorkerParameters r10) {
            super(r8, r10);
        }

        @Override // androidx.work.Worker
        public androidx.work.l.a doWork() {
            CaeLog.d(UserAwareLauncherActivity.TAG, "doWork, collect location");
            UserAwareManager.getInstance().zppCollectLocation(10);
            androidx.work.o r8 = new androidx.work.o.a(ZppLocationWork.class).d(3, TimeUnit.MINUTES).a();
            j1.b0 r10 = j1.b0.f(getApplicationContext());
            androidx.work.g r11 = androidx.work.g.f2827a;
            r10.getClass();
            r10.b(UserAwareLauncherActivity.ZPP_LOCATION_WORK_NAME, Collections.singletonList(r8));
            return new androidx.work.l.a.c();
        }
    }

    public UserAwareLauncherActivity() {
        this.mCheckBoxesList = new ArrayList();
        this.mIsCollecting = false;
        this.lastBackPressedTime = 0;
        this.mSensorListLock = new Object();
        this.mRecordTime = 120000;
        this.mRecordMask = DEFAULT_COLLECT_MASK;
        this.mBtStatsLock = new Object();
        this.mBtCounts = new HashMap();
        this.mWifiStatsLock = new Object();
        this.mWifiCounts = new HashMap();
        this.mChartHandler = new Handler(Looper.getMainLooper());
        this.mStatsTickerRunning = false;
        this.mHasLocationOrigin = false;
        this.mOriginLatDeg = 0.0d;
        this.mOriginLonDeg = 0.0d;
        this.mLocationSpanDeg = LOCATION_SPAN_INITIAL_DEG;
        this.mLocSeriesXOther = new ArrayList();
        this.mLocSeriesYOther = new ArrayList();
        this.mLocSeriesXNetwork = new ArrayList();
        this.mLocSeriesYNetwork = new ArrayList();
        this.mLocSeriesXGps = new ArrayList();
        this.mLocSeriesYGps = new ArrayList();
        this.mStatsTicker = new AnonymousClass1(this);
    }

    public static /* synthetic */ void a(UserAwareLauncherActivity r8, DialogInterface r10, int r11) {
        r8.lambda$showProgressDialog$10(r10, r11);
    }

    public static /* synthetic */ boolean access$000(UserAwareLauncherActivity r8) {
        return r8.mStatsTickerRunning;
    }

    public static /* synthetic */ void access$100(UserAwareLauncherActivity r8) {
        r8.drainAndDrawBt();
    }

    public static /* synthetic */ List access$1000() {
        return ay;
    }

    public static /* synthetic */ List access$1100() {
        return az;
    }

    public static /* synthetic */ List access$1200() {
        return gx;
    }

    public static /* synthetic */ List access$1300() {
        return gy;
    }

    public static /* synthetic */ List access$1400() {
        return gz;
    }

    public static /* synthetic */ List access$1500() {
        return lx;
    }

    public static /* synthetic */ List access$1600() {
        return ly;
    }

    public static /* synthetic */ List access$1700() {
        return lz;
    }

    public static /* synthetic */ List access$1800() {
        return mx;
    }

    public static /* synthetic */ List access$1900() {
        return my;
    }

    public static /* synthetic */ void access$200(UserAwareLauncherActivity r8) {
        r8.drainAndDrawWifi();
    }

    public static /* synthetic */ List access$2000() {
        return mz;
    }

    public static /* synthetic */ void access$2100(UserAwareLauncherActivity r8) {
        r8.recordData();
    }

    public static /* synthetic */ void access$2200(UserAwareLauncherActivity r8, BtAwareInfo r10) {
        r8.onBtAwareInfo(r10);
    }

    public static /* synthetic */ void access$2300(UserAwareLauncherActivity r8, WifiStandardData r10) {
        r8.onWifiStandardData(r10);
    }

    public static /* synthetic */ void access$2400(UserAwareLauncherActivity r8, GnssSvAwareInfo r10) {
        r8.updateGnssCn0Chart(r10);
    }

    public static /* synthetic */ void access$2500(UserAwareLauncherActivity r8, LocationAwareInfo r10) {
        r8.updateLocation2dChart(r10);
    }

    public static /* synthetic */ String access$2602(UserAwareLauncherActivity r8, String r10) {
        r8.mLocationStateValue = r10;
        return r10;
    }

    public static /* synthetic */ Handler access$300(UserAwareLauncherActivity r8) {
        return r8.mChartHandler;
    }

    public static /* synthetic */ OListItemSwitch access$500(UserAwareLauncherActivity r8) {
        return r8.mCollectSwitch;
    }

    public static /* synthetic */ boolean access$600(UserAwareLauncherActivity r8) {
        return r8.mIsCollecting;
    }

    public static /* synthetic */ Object access$700(UserAwareLauncherActivity r8) {
        return r8.mSensorListLock;
    }

    public static /* synthetic */ List access$800() {
        return timestamps;
    }

    public static /* synthetic */ List access$900() {
        return ax;
    }

    private void appendLocationPoint(ArrayList<Float> r8, ArrayList<Float> r10, float r11, float r12) {
        if (r8.size() < 2000) goto L5;
    L6:
        r8.remove(0);
        r10.remove(0);
    L7:
        r8.add(Float.valueOf(r11));
        r10.add(Float.valueOf(r12));
        return;
    L5:
        if (r10.size() < 2000) goto L7;
        goto L6
    }

    public static /* synthetic */ void b(DialogInterface r8, int r10) {
        lambda$showCollectConfirmDialog$6(r8, r10);
    }

    public static /* synthetic */ void c(UserAwareLauncherActivity r8, View r10) {
        r8.onZppAutoCollectLocationClicked(r10);
    }

    private static double clampLatitude(double r8) {
        if (r8 >= (-90.0d)) goto L6;
        return -90.0d;
    L6:
        if (r8 <= 90.0d) goto L8;
        return 90.0d;
    L8:
        return r8;
    }

    private View createView() {
        View r8 = getLayoutInflater().inflate(R.layout.confirm_dialog, null);
        this.mContentView = (TextView) r8.findViewById(R.id.content);
        String r10 = getString(R.string.user_aware_aware_collection_prompt);
        this.mContentView.setText(r10);
        return r8;
    }

    public static /* synthetic */ void d(UserAwareLauncherActivity r8) {
        r8.dismissProgressDialog();
    }

    private static double deltaLongitudeDeg(double r8, double r10) {
        double r11 = r8 - r10;
    L4:
        if (r11 > (-180.0d)) goto L7;
        r11 = r11 + 360.0d;
    L7:
        if (r11 <= 180.0d) goto L10;
        r11 = r11 - 360.0d;
        goto L7
    L10:
        if (r11 == (-180.0d)) goto L12;
        return r11;
    L12:
        return 180.0d;
    }

    private void dismissProgressDialog() {
        dc.e r8 = this.progressDialog;
        if (r8 != null) goto L5;
    L7:
        this.progressDialog = null;
        this.tvProgressTitleDialog = null;
        this.tvProgressOverallDialog = null;
        this.pbUploadOverallDialog = null;
        this.tvProgressCurrentFileDialog = null;
        this.pbUploadCurrentFileDialog = null;
        return;
    L5:
        if (r8.isShowing() == false) goto L7;
        this.progressDialog.dismiss();
        goto L7
    }

    private void drainAndDrawBt() {
        if (this.mLineChartBtCounts != null) goto L5;
        return;
    L5:
        Object r8 = this.mBtStatsLock;
        monitor-enter(r8);
        int r10 = this.mBtCounts.size();     // Catch: Throwable -> L11
        this.mBtCounts.clear();     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        this.mLineChartBtCounts.UpdateSingleData(new float[]{r10});
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void drainAndDrawWifi() {
        if (this.mLineChartWifiCounts != null) goto L5;
        return;
    L5:
        Object r8 = this.mWifiStatsLock;
        monitor-enter(r8);
        int r10 = this.mWifiCounts.size();     // Catch: Throwable -> L11
        this.mWifiCounts.clear();     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        this.mLineChartWifiCounts.UpdateSingleData(new float[]{r10});
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void e(UserAwareLauncherActivity r8, DialogInterface r10, int r11) {
        r8.lambda$onSwitchChanged$7(r10, r11);
    }

    public static /* synthetic */ void f(UserAwareLauncherActivity r8, DialogInterface r10, int r11) {
        r8.lambda$showProgressDialog$11(r10, r11);
    }

    public static /* synthetic */ void g(UserAwareLauncherActivity r8, OCheckBox r10, boolean r11) {
        r8.onCheckBoxSelected(r10, r11);
    }

    private String getCheckBoxesString(int r8) {
        this.mRecordMask = DEFAULT_COLLECT_MASK;
        String r10 = getString(R.string.user_aware_scenario_selected);
        if (r8 != R.id.check_subway) goto L6;
        this.mRecordTime = 7200000;
        StringBuilder r11 = android.aimedia.a.j(r10);
        int r12 = R.string.user_aware_check_subway;
    L44:
        r11.append(getString(r12));
        return r11.toString();
    L6:
        if (r8 != R.id.check_railway) goto L9;
        this.mRecordTime = 7200000;
        r11 = android.aimedia.a.j(r10);
        r12 = R.string.user_aware_check_railway;
        goto L44
    L9:
        if (r8 != R.id.check_drive_car) goto L12;
        this.mRecordTime = 7200000;
        r11 = android.aimedia.a.j(r10);
        r12 = R.string.user_aware_check_drive_car;
        goto L44
    L12:
        if (r8 != R.id.check_car_passenger) goto L15;
        this.mRecordTime = 7200000;
        r11 = android.aimedia.a.j(r10);
        r12 = R.string.user_aware_check_car_passenger;
        goto L44
    L15:
        if (r8 != R.id.check_drive_motor) goto L18;
        this.mRecordTime = 7200000;
        r11 = android.aimedia.a.j(r10);
        r12 = R.string.user_aware_check_drive_motor;
        goto L44
    L18:
        if (r8 != R.id.check_stand) goto L21;
        this.mRecordTime = 1800000;
        r11 = android.aimedia.a.j(r10);
        r12 = R.string.user_aware_check_stand;
        goto L44
    L21:
        if (r8 != R.id.check_walk) goto L24;
        this.mRecordTime = 1800000;
        r11 = android.aimedia.a.j(r10);
        r12 = R.string.user_aware_check_walk;
        goto L44
    L24:
        if (r8 != R.id.check_bicycle) goto L27;
        this.mRecordTime = 1800000;
        r11 = android.aimedia.a.j(r10);
        r12 = R.string.user_aware_check_bicycle;
        goto L44
    L27:
        if (r8 != R.id.check_run_inside) goto L30;
        this.mRecordTime = 1800000;
        r11 = android.aimedia.a.j(r10);
        r12 = R.string.user_aware_check_run_inside;
        goto L44
    L30:
        if (r8 != R.id.check_run_outside) goto L33;
        this.mRecordTime = 1800000;
        r11 = android.aimedia.a.j(r10);
        r12 = R.string.user_aware_check_run_outside;
        goto L44
    L33:
        if (r8 != R.id.check_elevator) goto L36;
        this.mRecordTime = 120000;
        r11 = android.aimedia.a.j(r10);
        r12 = R.string.user_aware_check_elevator;
        goto L44
    L36:
        if (r8 != R.id.check_mall) goto L39;
        this.mRecordTime = 1800000;
        r11 = android.aimedia.a.j(r10);
        r12 = R.string.user_aware_check_mall;
        goto L44
    L39:
        if (r8 != R.id.check_full_day) goto L42;
        this.mRecordTime = 86400000;
        r11 = android.aimedia.a.j(r10);
        r12 = R.string.user_aware_check_full_day;
        goto L44
    L42:
        if (r8 != R.id.check_zpp_collect) goto L46;
        this.mRecordTime = 604800000;
        this.mRecordMask = 0;
        r11 = android.aimedia.a.j(r10);
        r12 = R.string.user_aware_zpp_collect;
        goto L44
    L46:
        return "";
    }

    public static /* synthetic */ void h(UserAwareLauncherActivity r8) {
        r8.lambda$onZppGetLocationClicked$2();
    }

    public static /* synthetic */ void i(UserAwareLauncherActivity r8, View r10) {
        r8.onCollectButtonClicked(r10);
    }

    private void initDevtools() {
        CaeLog.d(TAG, "Initializing Devtools...");     // Catch: Exception -> L5
        ByteIOUtils.initDevtools();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "Failed to initialize Devtools: " + e.getMessage(), e);
    }

    private void initSensor() {
        ax = new ArrayList();
        ay = new ArrayList();
        az = new ArrayList();
        gx = new ArrayList();
        gy = new ArrayList();
        gz = new ArrayList();
        lx = new ArrayList();
        ly = new ArrayList();
        lz = new ArrayList();
        mx = new ArrayList();
        my = new ArrayList();
        mz = new ArrayList();
        timestamps = new ArrayList();
    }

    @SuppressLint({"NewApi"})
    private void initUI() {
        OCTitleBar r8 = (OCTitleBar) findViewById(R.id.aware_launcher_title);
        this.mTitle = r8;
        final int r10 = 0;
        if (r8 == null) goto L5;
        r8.getMLeftActionBack().setOnClickListener(new l1(this, r10));
    L5:
        OListItemSettings r11 = (OListItemSettings) findViewById(R.id.aware_scene_aware);
        if (r11 == null) goto L8;
        r11.setOnClickListener(new m1(this, r10));
    L8:
        OListItemSwitch r12 = (OListItemSwitch) findViewById(R.id.list_item_collect_data);
        this.mCollectSwitch = r12;
        if (r12 == null) goto L11;
        r12.setChecked(false);
        this.mCollectSwitch.setOnCheckedChangeListener(new n1(this));
    L11:
        Button r13 = (Button) findViewById(R.id.button_submit);
        this.mCollectButton = r13;
        final int r14 = 1;
        if (r13 == null) goto L14;
        r13.setOnClickListener(new l1(this, r14));
    L14:
        Button r15 = (Button) findViewById(R.id.button_zpp_get_location);
        this.mZppGetLocationButton = r15;
        if (r15 == null) goto L17;
        r15.setOnClickListener(new m1(this, r14));
    L17:
        Button r16 = (Button) findViewById(R.id.button_zpp_auto_collect_location);
        this.mZppAutoCollectLocationButton = r16;
        if (r16 == null) goto L20;
        r16.setOnClickListener(new com.google.android.material.search.a(this, 7));
    L20:
        OCheckBox r17 = (OCheckBox) findViewById(R.id.check_subway);
        this.mCheckBoxSubway = r17;
        this.mCheckBoxesList.add(r17);
        OCheckBox r18 = (OCheckBox) findViewById(R.id.check_railway);
        this.mCheckBoxRailway = r18;
        this.mCheckBoxesList.add(r18);
        OCheckBox r19 = (OCheckBox) findViewById(R.id.check_drive_car);
        this.mCheckBoxDriveCar = r19;
        this.mCheckBoxesList.add(r19);
        OCheckBox r20 = (OCheckBox) findViewById(R.id.check_car_passenger);
        this.mCheckBoxCarPassenger = r20;
        this.mCheckBoxesList.add(r20);
        OCheckBox r21 = (OCheckBox) findViewById(R.id.check_drive_motor);
        this.mCheckBoxMotor = r21;
        this.mCheckBoxesList.add(r21);
        OCheckBox r22 = (OCheckBox) findViewById(R.id.check_stand);
        this.mCheckBoxStand = r22;
        this.mCheckBoxesList.add(r22);
        OCheckBox r23 = (OCheckBox) findViewById(R.id.check_walk);
        this.mCheckBoxWalk = r23;
        this.mCheckBoxesList.add(r23);
        OCheckBox r24 = (OCheckBox) findViewById(R.id.check_run_inside);
        this.mCheckBoxRunInside = r24;
        this.mCheckBoxesList.add(r24);
        OCheckBox r25 = (OCheckBox) findViewById(R.id.check_run_outside);
        this.mCheckBoxRunOutside = r25;
        this.mCheckBoxesList.add(r25);
        OCheckBox r26 = (OCheckBox) findViewById(R.id.check_bicycle);
        this.mCheckBoxBicycle = r26;
        this.mCheckBoxesList.add(r26);
        OCheckBox r27 = (OCheckBox) findViewById(R.id.check_elevator);
        this.mCheckBoxElevator = r27;
        this.mCheckBoxesList.add(r27);
        OCheckBox r28 = (OCheckBox) findViewById(R.id.check_mall);
        this.mCheckBoxMall = r28;
        this.mCheckBoxesList.add(r28);
        OCheckBox r29 = (OCheckBox) findViewById(R.id.check_full_day);
        this.mCheckBoxFullDay = r29;
        this.mCheckBoxesList.add(r29);
        OCheckBox r30 = (OCheckBox) findViewById(R.id.check_zpp_collect);
        this.mCheckBoxZppCollect = r30;
        this.mCheckBoxesList.add(r30);
        Iterator<OCheckBox> r31 = this.mCheckBoxesList.iterator();
    L22:
        if (r31.hasNext() == false) goto L24;
        r31.next().setOnCheckedChangeListener(new androidx.core.app.b(this));
        goto L22
    L24:
        OInputView r32 = (OInputView) findViewById(R.id.input_more);
        this.mInputView = r32;
        r32.f6294c0.addTextChangedListener(this);
        this.mLineChartAcc = (LineChart) findViewById(R.id.line_chart_acc);
        this.mLineChartGyro = (LineChart) findViewById(R.id.line_chart_gyro);
        LineChart r33 = (LineChart) findViewById(R.id.line_chart_location_2d);
        this.mLineChartLocation2d = r33;
        if (r33 == null) goto L27;
        r33.setMode(1);
        this.mLineChartLocation2d.setXYRange(-0.5f, 0.5f, -0.5f, 0.5f);
        this.mLineChartLocation2d.setXYAxisXWrapTo180(true);
    L27:
        LineChart r34 = (LineChart) findViewById(R.id.line_chart_gnss_cn0);
        this.mLineChartGnssCn0 = r34;
        if (r34 == null) goto L30;
        r34.setMode(0);
        this.mLineChartGnssCn0.setYAxisRange(-5.0f, 45.0f);
        this.mLineChartGnssCn0.setSingleLineColor(-16711936);
        this.mLineChartGnssCn0.setShowYAxisGrid(true);
        this.mLineChartGnssCn0.setYAxisTickCount(5);
        this.mLineChartGnssCn0.setXStep(10);
    L30:
        LineChart r35 = (LineChart) findViewById(R.id.line_chart_bt_counts);
        this.mLineChartBtCounts = r35;
        if (r35 == null) goto L33;
        r35.setMode(0);
        this.mLineChartBtCounts.setYAxisRange(0.0f, 200.0f);
        this.mLineChartBtCounts.setSingleLineColor(-16711936);
        this.mLineChartBtCounts.setShowYAxisGrid(true);
        this.mLineChartBtCounts.setYAxisTickCount(5);
        this.mLineChartBtCounts.setXStep(10);
    L33:
        LineChart r36 = (LineChart) findViewById(R.id.line_chart_wifi_counts);
        this.mLineChartWifiCounts = r36;
        if (r36 == null) goto L38;
        r36.setMode(0);
        this.mLineChartWifiCounts.setYAxisRange(0.0f, 100.0f);
        this.mLineChartWifiCounts.setSingleLineColor(-16711936);
        this.mLineChartWifiCounts.setShowYAxisGrid(true);
        this.mLineChartWifiCounts.setYAxisTickCount(5);
        this.mLineChartWifiCounts.setXStep(10);
        return;
    }

    private boolean isFirstCollection() {
        if (Settings.Global.getInt(getContentResolver(), KEY_COLLECTION_STATE, 0) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static /* synthetic */ xd.j j(UserAwareLauncherActivity r8, FrameLayout r10) {
        return r8.lambda$showProgressDialog$9(r10);
    }

    public static /* synthetic */ void k(UserAwareLauncherActivity r8, CompoundButton r10, boolean r11) {
        r8.onSwitchChanged(r10, r11);
    }

    public static /* synthetic */ xd.j l(UserAwareLauncherActivity r8, FrameLayout r10) {
        return r8.lambda$showCollectConfirmDialog$4(r10);
    }

    private /* synthetic */ void lambda$initUI$0(View r8) {
        finish();
    }

    private /* synthetic */ void lambda$initUI$1(View r8) {
        startSceneAwareHomeActivity();
    }

    private /* synthetic */ void lambda$onSwitchChanged$7(DialogInterface r8, int r10) {
        r8.dismiss();
        this.mCollectSwitch.setOnCheckedChangeListener(null);
        this.mCollectSwitch.setChecked(false);
        this.mCollectSwitch.setOnCheckedChangeListener(new g1(this, 0));
    }

    private /* synthetic */ void lambda$onZppGetLocationClicked$2() {
        this.mZppGetLocationButton.setVisibility(0);
    }

    private /* synthetic */ void lambda$onZppGetLocationClicked$3(int r8) {
        Thread.sleep(r8 * 1000);     // Catch: InterruptedException -> L5
        runOnUiThread(new b0(this, 3));     // Catch: InterruptedException -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "InterruptedException: " + e.getMessage());
    }

    private /* synthetic */ xd.j lambda$showCollectConfirmDialog$4(FrameLayout r8) {
        r8.addView(createView());
        return xd.j.f13877a;
    }

    private /* synthetic */ void lambda$showCollectConfirmDialog$5(boolean r8, DialogInterface r10, int r11) {
        r10.dismiss();
        setCollectionState(false);
        this.mCollectSwitch.setChecked(r8);
        onSwitchChanged(null, r8);
    }

    private static /* synthetic */ void lambda$showCollectConfirmDialog$6(DialogInterface r8, int r10) {
        r8.dismiss();
    }

    private /* synthetic */ void lambda$showProgressDialog$10(DialogInterface r8, int r10) {
        CaeLog.d(TAG, "Upload in background clicked.");
        if (r8 == null) goto L6;
        dismissProgressDialog();
        return;
    }

    private /* synthetic */ void lambda$showProgressDialog$11(DialogInterface r8, int r10) {
        CaeLog.d(TAG, "Cancel upload clicked.");
        FileController.getInstance(this).checkAndCleanOneTimeTasks();
        if (this.tvProgressTitleDialog == null) goto L5;
        String r11 = getString(R.string.user_aware_upload_cancelled_message);
        this.tvProgressTitleDialog.setText(r11);
    L6:
        if (r8 == null) goto L8;
        new Handler(getMainLooper()).postDelayed(new c0(this, 5), 1500);
        return;
    L8:
        CaeLog.w(TAG, "Dialog is null in cancel upload callback, cannot dismiss.");
        return;
    L5:
        CaeLog.w(TAG, "tvProgressTitleDialog is null when trying to set cancel message.");
        goto L6
    }

    private /* synthetic */ xd.j lambda$showProgressDialog$9(FrameLayout r8) {
        View r10 = getLayoutInflater().inflate(R.layout.dialog_upload_progress, r8, false);
        this.tvProgressTitleDialog = (TextView) r10.findViewById(R.id.tv_progress_title_dialog);
        this.tvProgressOverallDialog = (TextView) r10.findViewById(R.id.tv_progress_overall_dialog);
        this.pbUploadOverallDialog = (ProgressBar) r10.findViewById(R.id.pb_upload_overall_dialog);
        this.tvProgressCurrentFileDialog = (TextView) r10.findViewById(R.id.tv_progress_current_file_dialog);
        this.pbUploadCurrentFileDialog = (ProgressBar) r10.findViewById(R.id.pb_upload_current_file_dialog);
        TextView r11 = this.tvProgressTitleDialog;
        if (r11 == null) goto L5;
        r11.setText(getString(R.string.user_aware_compress_file));
    L6:
        TextView r12 = this.tvProgressOverallDialog;
        if (r12 == null) goto L9;
        r12.setText(getString(R.string.user_aware_overall_progress_calculating));
    L10:
        ProgressBar r13 = this.pbUploadOverallDialog;
        if (r13 == null) goto L13;
        r13.setIndeterminate(true);
        this.pbUploadOverallDialog.setMax(100);
    L14:
        TextView r14 = this.tvProgressCurrentFileDialog;
        if (r14 == null) goto L17;
        r14.setText(getString(R.string.user_aware_current_file_progress_calculating));
    L18:
        ProgressBar r15 = this.pbUploadCurrentFileDialog;
        if (r15 == null) goto L21;
        r15.setIndeterminate(true);
        this.pbUploadCurrentFileDialog.setMax(100);
    L22:
        r8.addView(r10);
        return xd.j.f13877a;
    L21:
        CaeLog.w(TAG, "pbUploadCurrentFileDialog is null in showProgressDialog.");
        goto L22
    L17:
        CaeLog.w(TAG, "tvProgressCurrentFileDialog is null in showProgressDialog.");
        goto L18
    L13:
        CaeLog.w(TAG, "pbUploadOverallDialog is null in showProgressDialog.");
        goto L14
    L9:
        CaeLog.w(TAG, "tvProgressOverallDialog is null in showProgressDialog.");
        goto L10
    L5:
        CaeLog.w(TAG, "tvProgressTitleDialog is null in showProgressDialog.");
        goto L6
    }

    private void lambda$startUpload$8(androidx.work.u r18) {
        if (r18 == null) goto L61;
        dc.e r8 = this.progressDialog;
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.isShowing() == false) goto L63;
        androidx.work.e r10 = r18.f2949e;
        String r11 = r10.d("type");
        String r12 = TAG;
        if (r11 != null) goto L11;
    L45:
        androidx.work.u.a r13 = r18.f2946b;
        if (r13.a() == false) goto L64;
        CaeLog.i(r12, "Upload work finished with state: " + r13);
        String r14 = UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_upload_done);
        if (r13 != androidx.work.u.a.f2955n) goto L51;
        Application r15 = getApplication();
        int r16 = R.string.user_aware_upload_failed;
    L53:
        r14 = UserAwareUtil.getStringValueFromXML(r15, r16);
    L54:
        TextView r17 = this.tvProgressTitleDialog;
        if (r17 == null) goto L57;
        r17.setText(r14);
        this.pbUploadOverallDialog.setProgress(100);
        this.tvProgressOverallDialog.setText(UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_upload_overall_text) + "100%");
    L57:
        UserAwareUtil.deleteEmptySubdirectories(UserAwareUtil.getNearbyLogPathFile(getApplicationContext()));
        new Handler(getMainLooper()).postDelayed(new androidx.activity.k(this, 27), 2000);
        return;
    L51:
        if (r13 != androidx.work.u.a.f2957p) goto L54;
        r15 = getApplication();
        r16 = R.string.user_aware_upload_cancelled;
        goto L53
    L64:
        return;
    L11:
        if (r11.equals(UploadWorker.KEY_PROGRESS_DATA_TYPE_OVERALL) == false) goto L27;
        long r19 = r10.c(UploadWorker.KEY_PROGRESS_TOTAL_FILE_COUNT_TO_UPLOAD);
        long r110 = r10.c(UploadWorker.KEY_PROGRESS_UPLOADED_FILE_COUNT);
        double r20 = Math.min(r10.b(UploadWorker.KEY_PROGRESS_PERCENTAGE_BY_SIZE, -1.0d), 100.0d);
        if (r19 != (-1)) goto L15;
        return;
    L15:
        if (r110 != (-1)) goto L17;
        return;
    L17:
        if (r20 == (-1.0d)) goto L60;
        String r21 = String.format(Locale.getDefault(), UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_upload_overall_text) + " %d/%d" + UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_file) + "(%.1f%%)", new Object[]{Long.valueOf(r110), Long.valueOf(r19), Double.valueOf(r20)});
        r12 = TAG;
        CaeLog.d(r12, r21);
        this.tvProgressTitleDialog.setText(getString(R.string.user_aware_uploading_title));
        TextView r22 = this.tvProgressOverallDialog;
        if (r22 == null) goto L22;
        r22.setText(r21);
    L22:
        ProgressBar r23 = this.pbUploadOverallDialog;
        if (r23 == null) goto L45;
    L44:
        r23.setIndeterminate(false);
        this.pbUploadOverallDialog.setProgress((int) r20);
        goto L45
    L60:
        return;
    L27:
        if (r11.equals(UploadWorker.KEY_PROGRESS_DATA_TYPE_CURRENT_FILE) == false) goto L35;
        String r24 = r10.d(UploadWorker.KEY_PROGRESS_FILE_NAME);
        double r25 = Math.min(r10.b(UploadWorker.KEY_PROGRESS_CURRENT_FILE_PERCENTAGE, 0.0d), 100.0d);
        String r26 = String.format(Locale.getDefault(), UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_upload_current_file_text) + " %s (%.1f%%)", new Object[]{r24, Double.valueOf(r25)});
        CaeLog.d(TAG, r26);
        this.tvProgressTitleDialog.setText(getString(R.string.user_aware_uploading_title));
        TextView r27 = this.tvProgressCurrentFileDialog;
        if (r27 == null) goto L31;
        r27.setText(r26);
    L31:
        ProgressBar r28 = this.pbUploadCurrentFileDialog;
        if (r28 == null) goto L45;
        r28.setIndeterminate(false);
        this.pbUploadCurrentFileDialog.setProgress((int) r25);
        goto L45
    L35:
        if (r11.equals(UploadWorker.KEY_PROGRESS_DATA_TYPE_COMPRESSION) == false) goto L45;
        r20 = r10.b(UploadWorker.KEY_PROGRESS_COMPRESSION_PERCENTAGE, 0.0d);
        if (r20 != 0.0d) goto L39;
        return;
    L39:
        String r29 = String.format(Locale.getDefault(), UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_compress_file_progress_text) + " %.1f%%", new Object[]{Double.valueOf(r20)});
        CaeLog.d(TAG, r29);
        this.tvProgressTitleDialog.setText(getString(R.string.user_aware_compress_file));
        TextView r30 = this.tvProgressOverallDialog;
        if (r30 == null) goto L42;
        r30.setText(r29);
    L42:
        r23 = this.pbUploadOverallDialog;
        if (r23 == null) goto L45;
    L63:
        return;
    }

    public static /* synthetic */ void m(UserAwareLauncherActivity r8, View r10) {
        r8.lambda$initUI$0(r10);
    }

    public static /* synthetic */ void n(UserAwareLauncherActivity r8, boolean r10, DialogInterface r11, int r12) {
        r8.lambda$showCollectConfirmDialog$5(r10, r11, r12);
    }

    private static double normalizeLongitude(double r8) {
        if (Double.isNaN(r8) == false) goto L5;
        return 0.0d;
    L5:
        if (Double.isInfinite(r8) == false) goto L8;
        return 0.0d;
    L8:
        if (r8 > (-180.0d)) goto L11;
        r8 = r8 + 360.0d;
    L11:
        if (r8 <= 180.0d) goto L14;
        r8 = r8 - 360.0d;
        goto L11
    L14:
        if (r8 == (-180.0d)) goto L16;
        return r8;
    L16:
        return 180.0d;
    }

    public static /* synthetic */ void o(UserAwareLauncherActivity r8, View r10) {
        r8.lambda$initUI$1(r10);
    }

    private void onBtAwareInfo(BtAwareInfo r8) {
        if (this.mIsCollecting == true) goto L5;
        return;
    L5:
        if (r8 != null) goto L7;
        return;
    L7:
        String r10 = r8.getAddress();
        if (r10 != null) goto L10;
        return;
    L10:
        if (r10.isEmpty() == true) goto L23;
        Object r11 = this.mBtStatsLock;
        monitor-enter(r11);
        HashMap<String, Integer> r12 = this.mBtCounts;     // Catch: Throwable -> L17
        r12.put(r10, Integer.valueOf(r12.getOrDefault(r10, 0).intValue() + 1));     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private void onCheckBoxSelected(OCheckBox r8, boolean r10) {
        CaeLog.d(TAG, "oCheckBox: " + r8.getId() + " isChecked: " + r10);
        if (r10 == false) goto L23;
        Iterator<OCheckBox> r11 = this.mCheckBoxesList.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r11.next().setOnCheckedChangeListener(null);
        goto L6
    L8:
        Iterator<OCheckBox> r12 = this.mCheckBoxesList.iterator();
    L10:
        if (r12.hasNext() == false) goto L19;
        OCheckBox r13 = r12.next();
        int r14 = r13.getId();
        if (r14 == r8.getId()) goto L13;
        r13.setChecked(false);
        goto L10
    L13:
        r13.setChecked(true);
        setSelectedCheckBoxId(r14);
        String r15 = this.mUserInputScene;
        if (r15 == null) goto L17;
        if (r15.isEmpty() == false) goto L10;
    L17:
        this.mCollectSwitch.setSubTitleString(getCheckBoxesString(r14));
        goto L10
    L19:
        Iterator<OCheckBox> r16 = this.mCheckBoxesList.iterator();
    L21:
        if (r16.hasNext() == false) goto L36;
        r16.next().setOnCheckedChangeListener(new k1(this));
        goto L21
    L36:
        return;
    L23:
        this.mSelectedCheckBoxId = 0;
        this.mCollectSwitch.setSubTitleString(getString(R.string.user_aware_scenario_selected));
    }

    private void onCollectButtonClicked(View r8) {
        File r10 = UserAwareUtil.getNearbyLogPathFile(getApplicationContext());
        CaeLog.d(TAG, "path is " + r10.getAbsolutePath());
        startUpload(r10);
    }

    private void onSwitchChanged(CompoundButton r14, boolean r15) {
        if (r15 == false) goto L13;
        if (getSelectedCheckBoxId() != 0) goto L13;
        String r8 = this.mUserInputScene;
        if (r8 != null) goto L9;
    L10:
        this.mCollectSwitch.setChecked(false);
        CaeUtil.showShortToast(this, getString(R.string.user_aware_aware_collection_warning));
        return;
    L9:
        if (r8.isEmpty() == true) goto L10;
    L13:
        if (isFirstCollection() == false) goto L15;
        showCollectConfirmDialog(r15);
    L37:
        if (r15 == false) goto L48;
        boolean r10 = LocationUtil.getInstance().isLocationUiEnabled();
        BluetoothAdapter r11 = BluetoothAdapter.getDefaultAdapter();
        int r12 = 1;
        if (r11 != null) goto L41;
    L43:
        boolean r13 = false;
    L44:
        if (r10 == false) goto L46;
        if (r13 == true) goto L48;
    L46:
        dc.k r16 = new dc.k(this);
        String r17 = r16.f7071s.getString(R.string.user_aware_switch_on_title);
        r16.f7060h = false;
        r16.f7059g = r17;
        r16.f7068p = false;
        r16.d(R.string.user_aware_aware_collection_cancel, new j1(this, r12));
        r16.a().show();
        return;
    L41:
        if (r11.isEnabled() == false) goto L43;
        r13 = true;
    L48:
        if (r15 == false) goto L50;
        startCollection();
        return;
    L50:
        stopCollection();
        return;
    L15:
        this.mIsCollecting = r15;
        if (this.mService == null) goto L29;
        if (r15 == false) goto L28;
        String r18 = this.mUserInputScene;
        if (r18 != null) goto L21;
    L23:
        String r19 = getCheckBoxesString(getSelectedCheckBoxId());
    L24:
        String r20 = r19;
        CaeLog.d(TAG, "description: " + r20);
        if (getSelectedCheckBoxId() != R.id.check_zpp_collect) goto L27;
        this.mZppGetLocationButton.setVisibility(0);
        this.mZppAutoCollectLocationButton.setVisibility(0);
    L27:
        UserAwareManager.getInstance().recordNearbyInfo(getApplicationContext(), true, r20, this.mRecordTime, this.mRecordMask);
        goto L29
    L21:
        if (r18.isEmpty() == true) goto L23;
        r19 = this.mUserInputScene;
        goto L24
    L28:
        UserAwareManager.getInstance().recordNearbyInfo(getApplicationContext(), false, null, 0, 0);
    L29:
        if (r15 == true) goto L33;
        this.mZppGetLocationButton.setVisibility(8);
        this.mZppAutoCollectLocationButton.setVisibility(8);
        androidx.work.v r21 = this.mWorkManager;
        if (r21 == null) goto L33;
        r21.a();
        this.mWorkManager = null;
    L33:
        if (r15 == false) goto L35;
        int r22 = R.string.user_aware_aware_collection_start;
    L36:
        CaeUtil.showShortToast(this, getString(r22));
        goto L37
    L35:
        r22 = R.string.user_aware_aware_collection_stop;
        goto L36
    }

    private void onWifiStandardData(WifiStandardData r8) {
        if (this.mIsCollecting == true) goto L5;
        return;
    L5:
        if (r8 != null) goto L7;
        return;
    L7:
        String r10 = r8.getBssid();
        if (r10 != null) goto L10;
        return;
    L10:
        if (r10.isEmpty() == true) goto L23;
        Object r11 = this.mWifiStatsLock;
        monitor-enter(r11);
        HashMap<String, Integer> r12 = this.mWifiCounts;     // Catch: Throwable -> L17
        r12.put(r10, Integer.valueOf(r12.getOrDefault(r10, 0).intValue() + 1));     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private void onZppAutoCollectLocationClicked(View r8) {
        this.mZppAutoCollectLocationButton.setVisibility(8);
        this.mWorkManager = j1.b0.f(this);
        androidx.work.o r10 = new androidx.work.o.a(ZppLocationWork.class).a();
        androidx.work.v r11 = this.mWorkManager;
        androidx.work.g r12 = androidx.work.g.f2827a;
        r11.getClass();
        r11.b(ZPP_LOCATION_WORK_NAME, Collections.singletonList(r10));
        CaeUtil.showShortToast(this, getString(R.string.user_aware_zpp_auto_collect_location_description));
    }

    private void onZppGetLocationClicked(View r8) {
        this.mZppGetLocationButton.setVisibility(8);
        CaeUtil.showShortToast(this, getString(R.string.user_aware_zpp_collect_location_description));
        UserAwareManager.getInstance().zppCollectLocation(10);
        new Thread(new a0(10, 1, this), "ZppGetLocationThread").start();
    }

    public static /* synthetic */ void p(UserAwareLauncherActivity r8, View r10) {
        r8.onZppGetLocationClicked(r10);
    }

    public static /* synthetic */ void q(UserAwareLauncherActivity r8, androidx.work.u r10) {
        r8.lambda$startUpload$8(r10);
    }

    public static /* synthetic */ void r(UserAwareLauncherActivity r8, int r10) {
        r8.lambda$onZppGetLocationClicked$3(r10);
    }

    private void recordData() {
        if (ax.size() >= 100) goto L5;
        return;
    L5:
        if (ay.size() >= 100) goto L7;
        return;
    L7:
        if (az.size() >= 100) goto L9;
        return;
    L9:
        if (gx.size() >= 100) goto L11;
        return;
    L11:
        if (gy.size() >= 100) goto L13;
        return;
    L13:
        if (gz.size() >= 100) goto L15;
        return;
    L15:
        if (lx.size() >= 100) goto L17;
        return;
    L17:
        if (ly.size() >= 100) goto L19;
        return;
    L19:
        if (lz.size() >= 100) goto L21;
        return;
    L21:
        if (mx.size() >= 100) goto L23;
        return;
    L23:
        if (my.size() >= 100) goto L25;
        return;
    L25:
        if (mz.size() >= 100) goto L27;
        return;
    L27:
        if (timestamps.size() < 100) goto L42;
        this.mLineChartAcc.UpdateData(toFloatArray(ax), toFloatArray(ay), toFloatArray(az));
        this.mLineChartGyro.UpdateData(toFloatArray(gx), toFloatArray(gy), toFloatArray(gz));
        ax.clear();
        ay.clear();
        az.clear();
        gx.clear();
        gy.clear();
        gz.clear();
        lx.clear();
        ly.clear();
        lz.clear();
        mx.clear();
        my.clear();
        mz.clear();
        timestamps.clear();
        return;
    }

    private void redrawLocationTrace() {
        if (this.mLineChartLocation2d != null) goto L6;
        return;
    L6:
        if (this.mLocSeriesXNetwork.isEmpty() == true) goto L9;
        this.mLineChartLocation2d.UpdateXYData(toFloatArrayNoNull(this.mLocSeriesXNetwork), toFloatArrayNoNull(this.mLocSeriesYNetwork), 1, -16776961);
    L9:
        if (this.mLocSeriesXGps.isEmpty() == true) goto L12;
        this.mLineChartLocation2d.UpdateXYData(toFloatArrayNoNull(this.mLocSeriesXGps), toFloatArrayNoNull(this.mLocSeriesYGps), 2, -16711936);
    L12:
        if (this.mLocSeriesXOther.isEmpty() == true) goto L15;
        this.mLineChartLocation2d.UpdateXYData(toFloatArrayNoNull(this.mLocSeriesXOther), toFloatArrayNoNull(this.mLocSeriesYOther), 0, -16711681);
        return;
    }

    private void resetAllExtraChartsAndStats() {
        Object r8 = this.mBtStatsLock;
        monitor-enter(r8);
        this.mBtCounts.clear();     // Catch: Throwable -> L26
        monitor-exit(r8);     // Catch: Throwable -> L26
        Object r10 = this.mWifiStatsLock;
        monitor-enter(r10);
        this.mWifiCounts.clear();     // Catch: Throwable -> L23
        monitor-exit(r10);     // Catch: Throwable -> L23
        this.mHasLocationOrigin = false;
        this.mOriginLatDeg = 0.0d;
        this.mOriginLonDeg = 0.0d;
        this.mLocationSpanDeg = LOCATION_SPAN_INITIAL_DEG;
        this.mLocSeriesXOther.clear();
        this.mLocSeriesYOther.clear();
        this.mLocSeriesXNetwork.clear();
        this.mLocSeriesYNetwork.clear();
        this.mLocSeriesXGps.clear();
        this.mLocSeriesYGps.clear();
        LineChart r11 = this.mLineChartLocation2d;
        if (r11 == null) goto L13;
        r11.reset();
    L13:
        LineChart r12 = this.mLineChartGnssCn0;
        if (r12 == null) goto L16;
        r12.reset();
    L16:
        LineChart r13 = this.mLineChartBtCounts;
        if (r13 == null) goto L19;
        r13.reset();
    L19:
        LineChart r14 = this.mLineChartWifiCounts;
        if (r14 == null) goto L33;
        r14.reset();
        return;
    L33:
        return;
    L23:
        th = move-exception;
        throw th;
    L26:
        th = move-exception;
        throw th;
    }

    private void setCheckBoxClickable(boolean r8) {
        Iterator<OCheckBox> r10 = this.mCheckBoxesList.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().setClickable(r8);
        goto L4
    }

    private void setCollectionState(boolean r8) {
        Settings.Global.putInt(getContentResolver(), KEY_COLLECTION_STATE, !r8 ? 1 : 0);
    }

    private void showCollectConfirmDialog(final boolean r8) {
        this.mCollectSwitch.setOnCheckedChangeListener(null);
        this.mCollectSwitch.setChecked(!r8);
        dc.k r10 = new dc.k(this);
        Context r11 = r10.f7071s;
        String r12 = r11.getString(R.string.user_aware_collect_confirm_title);
        r10.f7060h = false;
        r10.f7059g = r12;
        r10.f7068p = false;
        int r13 = 1;
        r10.f7070r = new dc.l(new i1(this, r13));
        DialogInterface.OnClickListener r14 = new o1(this, r8);
        String r15 = r11.getString(R.string.user_aware_aware_collection_confirm);
        he.i.e(r15, "context.getString(text)");
        r10.f7065m = r15;
        r10.f7066n = r14;
        r10.f7067o = null;
        r10.d(R.string.user_aware_aware_collection_cancel, new s(2));
        this.mCollectConfirmDialogBuilder = r10;
        dc.e r16 = r10.a();
        this.mCollectConfirmDialog = r16;
        r16.show();
        this.mCollectSwitch.setOnCheckedChangeListener(new g1(this, r13));
    }

    private void showProgressDialog() {
        dc.e r8 = this.progressDialog;
        if (r8 != null) goto L5;
    L7:
        CaeLog.d(TAG, "Attempting to show progress dialog.");
        dc.k r10 = new dc.k(this);
        int r11 = 0;
        r10.f7070r = new dc.l(new i1(this, r11));
        j1 r12 = new j1(this, r11);
        String r13 = r10.f7071s.getString(R.string.user_aware_upload_in_background);
        he.i.e(r13, "context.getString(text)");
        r10.f7065m = r13;
        r10.f7066n = r12;
        r10.f7067o = null;
        r10.d(R.string.user_aware_cancel_upload, new h(this, 2));
        dc.e r14 = r10.a();
        this.progressDialog = r14;
        r14.setCancelable(false);
        this.progressDialog.show();
        String r15 = "Progress dialog shown.";
    L8:
        CaeLog.d(TAG, r15);
        return;
    L5:
        if (r8.isShowing() == false) goto L7;
        r15 = "Progress dialog is already showing.";
        goto L8
    }

    private void startAwareCurrentActivity() {
        Intent r8 = new Intent(this, UserAwareCurrentActivity.class);
        r8.addFlags(335544320);
        startActivity(r8);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    private void startAwareNearElevatorActivity() {
        Intent r8 = new Intent(this, NearElevatorActivity.class);
        r8.addFlags(335544320);
        startActivity(r8);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    private void startCollection() {
        this.mIsCollecting = true;
        resetAllExtraChartsAndStats();
        startStatsTicker();
        if (this.mService == null) goto L14;
        String r8 = this.mUserInputScene;
        if (r8 != null) goto L7;
    L9:
        String r10 = getCheckBoxesString(getSelectedCheckBoxId());
    L10:
        String r11 = r10;
        CaeLog.d(TAG, "description: " + r11);
        if (getSelectedCheckBoxId() != R.id.check_zpp_collect) goto L13;
        this.mZppGetLocationButton.setVisibility(0);
        this.mZppAutoCollectLocationButton.setVisibility(0);
    L13:
        UserAwareManager.getInstance().recordNearbyInfo(getApplicationContext(), true, r11, this.mRecordTime, this.mRecordMask);
        goto L14
    L7:
        if (r8.isEmpty() == true) goto L9;
        r10 = this.mUserInputScene;
    L14:
        CaeUtil.showShortToast(this, getString(R.string.user_aware_aware_collection_start));
        setCheckBoxClickable(false);
    }

    private void startHARStatusActivity() {
        Intent r8 = new Intent(this, HARStatusActivity.class);
        r8.addFlags(335544320);
        startActivity(r8);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    private void startSceneAwareHomeActivity() {
        Intent r8 = new Intent(this, SceneAwareHomeActivity.class);
        r8.addFlags(335544320);
        startActivity(r8);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    private void startStarZppModelActivity() {
        Intent r8 = new Intent();
        r8.setComponent(new ComponentName(getPackageName(), "com.obric.cae.location.zpp.ui.StarZppModelActivity"));
        r8.addFlags(335544320);
        startActivity(r8);     // Catch: Exception -> L5
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private void startStatsTicker() {
        if (this.mStatsTickerRunning == false) goto L5;
        return;
    L5:
        this.mStatsTickerRunning = true;
        this.mChartHandler.removeCallbacks(this.mStatsTicker);
        this.mChartHandler.post(this.mStatsTicker);
    }

    private void startUpload(File r8) {
        CaeLog.i(TAG, "startUpload local files");
        if (this.mCollectSwitch.L.isChecked() == false) goto L7;
        CaeUtil.showShortToast(this, UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_stop_collect));
        return;
    L7:
        if (UserAwareUtil.isWifiConnectedAndValidated(getApplicationContext()) == true) goto L10;
        CaeUtil.showShortToast(this, UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_prompt_connect_wifi));
        return;
    L10:
        ArrayList r10 = new ArrayList();
        UserAwareUtil.findFilesRecursively(r8, r10);
        if (r10.isEmpty() == false) goto L14;
        CaeUtil.showShortToast(this, UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_no_need_to_upload));
        return;
    L14:
        String r11 = FileController.getInstance(this).startOneTimeUpload();
        if (r11 == null) goto L23;
        this.uploadWorkerId = UUID.fromString(r11);
        CaeLog.i(TAG, "Upload work started successfully via FileController, work ID: " + this.uploadWorkerId);
        LiveData<androidx.work.u> r12 = this.workInfoLiveData;
        if (r12 == null) goto L21;
        androidx.lifecycle.u<androidx.work.u> r13 = this.workInfoObserver;
        if (r13 == null) goto L21;
        r12.h(r13);
        CaeLog.d(TAG, "Previous WorkInfo observer removed before starting new one.");
    L21:
        showProgressDialog();
        this.workInfoObserver = new h1(this);
        androidx.lifecycle.r r14 = j1.b0.f(this).g(this.uploadWorkerId);
        this.workInfoLiveData = r14;
        r14.d(this.workInfoObserver);
        return;
    L23:
        CaeLog.w(TAG, "Upload task not started, existing task is running");
        this.uploadWorkerId = null;
        CaeUtil.showShortToast(this, UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_upload_work_not_start));
    }

    private void stopCollection() {
        this.mIsCollecting = false;
        stopStatsTicker();
        UserAwareManager.getInstance().recordNearbyInfo(getApplicationContext(), false, null, 0, 0);
        this.mZppGetLocationButton.setVisibility(8);
        this.mZppAutoCollectLocationButton.setVisibility(8);
        androidx.work.v r8 = this.mWorkManager;
        if (r8 == null) goto L5;
        r8.a();
        this.mWorkManager = null;
    L5:
        CaeUtil.showShortToast(this, getString(R.string.user_aware_aware_collection_stop));
        setCheckBoxClickable(true);
    }

    private void stopStatsTicker() {
        this.mStatsTickerRunning = false;
        this.mChartHandler.removeCallbacks(this.mStatsTicker);
    }

    private float[] toFloatArray(List<Float> r8) {
        float[] r10 = new float[r8.size()];
        Iterator<Float> r11 = r8.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L10;
        Float r13 = r11.next();
        int r14 = r12 + 1;
        if (r13 == null) goto L8;
        float r15 = r13.floatValue();
    L9:
        r10[r12] = r15;
        r12 = r14;
        goto L4
    L8:
        r15 = Float.NaN;
        goto L9
    L10:
        return r10;
    }

    private static float[] toFloatArrayNoNull(List<Float> r8) {
        float[] r10 = new float[r8.size()];
        Iterator<Float> r11 = r8.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L10;
        Float r13 = r11.next();
        int r14 = r12 + 1;
        if (r13 == null) goto L8;
        float r15 = r13.floatValue();
    L9:
        r10[r12] = r15;
        r12 = r14;
        goto L4
    L8:
        r15 = Float.NaN;
        goto L9
    L10:
        return r10;
    }

    private void updateGnssCn0Chart(GnssSvAwareInfo r8) {
        if (this.mIsCollecting == true) goto L6;
        return;
    L6:
        if (this.mLineChartGnssCn0 != null) goto L8;
        return;
    L8:
        if (r8 != null) goto L10;
        return;
    L10:
        float r10 = r8.getVisibleSvMeanCn0();
        this.mLineChartGnssCn0.UpdateSingleData(new float[]{r10});
    }

    private void updateLocation2dChart(LocationAwareInfo r13) {
        if (this.mIsCollecting == true) goto L6;
        return;
    L6:
        if (this.mLineChartLocation2d != null) goto L8;
        return;
    L8:
        if (r13 != null) goto L10;
        return;
    L10:
        double r8 = clampLatitude(r13.getLatitudeDegrees());
        double r10 = normalizeLongitude(r13.getLongitudeDegrees());
        if (this.mHasLocationOrigin == true) goto L13;
        this.mOriginLatDeg = r8;
        this.mOriginLonDeg = r10;
        this.mHasLocationOrigin = true;
        this.mLocationSpanDeg = LOCATION_SPAN_INITIAL_DEG;
        this.mLocSeriesXOther.clear();
        this.mLocSeriesYOther.clear();
        this.mLocSeriesXNetwork.clear();
        this.mLocSeriesYNetwork.clear();
        this.mLocSeriesXGps.clear();
        this.mLocSeriesYGps.clear();
        LineChart r11 = this.mLineChartLocation2d;
        double r12 = this.mLocationSpanDeg;
        r11.setXYRange((float) (-r12), (float) r12, (float) (-r12), (float) r12);
        this.mLineChartLocation2d.setXYAxisCenterValues(this.mOriginLonDeg, this.mOriginLatDeg);
        this.mLineChartLocation2d.reset();
    L13:
        float r14 = (float) (r8 - this.mOriginLatDeg);
        float r15 = (float) deltaLongitudeDeg(r10, this.mOriginLonDeg);
        String r16 = r13.getProvider();
        if (r16 != null) goto L16;
    L18:
        if (r16 != null) goto L20;
    L22:
        ArrayList<Float> r17 = this.mLocSeriesXOther;
        ArrayList<Float> r18 = this.mLocSeriesYOther;
        int r19 = -16711681;
        int r20 = 0;
    L23:
        appendLocationPoint(r17, r18, r15, r14);
        if (Math.abs(r14) <= this.mLocationSpanDeg) goto L26;
    L29:
        boolean r110 = true;
    L30:
        if (r110 == true) goto L32;
        this.mLineChartLocation2d.UpdateXYData(new float[]{r15}, new float[]{r14}, r20, r19);
        return;
    L32:
        if (Math.abs(r14) > this.mLocationSpanDeg) goto L38;
        double r21 = Math.abs(r15);
        double r22 = this.mLocationSpanDeg;
        if (r21 > r22) goto L38;
        this.mLineChartLocation2d.setXYRange((float) (-r22), (float) r22, (float) (-r22), (float) r22);
        this.mLineChartLocation2d.reset();
        redrawLocationTrace();
        return;
    L38:
        this.mLocationSpanDeg *= 2.0d;
        goto L32
    L26:
        if (Math.abs(r15) > this.mLocationSpanDeg) goto L29;
        r110 = false;
        goto L30
    L20:
        if (r16.equalsIgnoreCase(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS) == false) goto L22;
        r17 = this.mLocSeriesXGps;
        r18 = this.mLocSeriesYGps;
        r20 = 2;
        r19 = -16711936;
        goto L23
    L16:
        if (r16.equalsIgnoreCase("network") == false) goto L18;
        r17 = this.mLocSeriesXNetwork;
        r18 = this.mLocSeriesYNetwork;
        r19 = -16776961;
        r20 = 1;
        goto L23
    }

    private void updateTitle() {
        UserAwareService r8 = this.mService;
        if (r8 == null) goto L6;
        this.mLearningProgressValue = r8.getLearningProgressValue();
        this.mLocationStateValue = this.mService.getLocationStateValueDesc();
        CaeLog.d(TAG, "updateTitle mLocationStateValue: " + this.mLocationStateValue + ", mLearningProgressValue: " + this.mLearningProgressValue);
        return;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r8) {
        this.mUserInputScene = r8.toString();
        this.mRecordTime = 7200000;
        Log.d(TAG, "mUserInputScene: " + this.mUserInputScene);
        this.mCollectSwitch.setSubTitleString(getString(R.string.user_aware_scenario_selected) + this.mUserInputScene);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r8, int r10, int r11, int r12) {
    }

    public synchronized int getSelectedCheckBoxId() {
        monitor-enter(this);
        int r8 = this.mSelectedCheckBoxId;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r8;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if ((System.currentTimeMillis() - this.lastBackPressedTime) >= 2000) goto L5;
        super.onBackPressed();
        return;
    L5:
        this.lastBackPressedTime = System.currentTimeMillis();
        CaeUtil.showShortToast(this, "再按一次退出");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r8) {
        CaeLog.d(TAG, "onCreate");
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(Color.rgb(247, 247, 247));
        UserAwareUtil.setLightStatusBarIcon(this, true);
        super.onCreate(r8);
        setContentView(R.layout.aware_launcher);
        this.mLauncherCallback = new LauncherCallback(this, null);
        UserAwareService r10 = UserAwareService.getService();
        this.mService = r10;
        if (r10 == null) goto L5;
        UserAwareManager.getInstance().registerInnerCallback(this.mLauncherCallback);
    L5:
        initSensor();
        initUI();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CaeLog.d(TAG, "onDestroy");
        stopStatsTicker();
        if (this.mService == null) goto L9;
        if (this.mCollectSwitch.L.isChecked() == false) goto L7;
        this.mCollectSwitch.setChecked(false);
    L7:
        UserAwareManager.getInstance().unregisterInnerCallback(this.mLauncherCallback);
    L9:
        if (this.mLauncherCallback == null) goto L11;
        this.mLauncherCallback = null;
    L11:
        LiveData<androidx.work.u> r8 = this.workInfoLiveData;
        if (r8 == null) goto L17;
        androidx.lifecycle.u<androidx.work.u> r10 = this.workInfoObserver;
        if (r10 == null) goto L18;
        r8.h(r10);
        CaeLog.d(TAG, "WorkInfo observer removed.");
        return;
    L18:
        return;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        stopStatsTicker();
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean r8) {
        super.onPointerCaptureChanged(r8);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        CaeLog.d(TAG, "onResume");
        updateTitle();
        if (this.mIsCollecting == false) goto L6;
        startStatsTicker();
        return;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r8, int r10, int r11, int r12) {
    }

    public synchronized void setSelectedCheckBoxId(int r8) {
        monitor-enter(this);
        this.mSelectedCheckBoxId = r8;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
