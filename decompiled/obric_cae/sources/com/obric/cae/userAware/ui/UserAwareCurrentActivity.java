package com.obric.cae.userAware.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.cae.R;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.userAware.UserAwareService;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.userAware.datacollection.UserFeedbackInfo;
import com.obric.cae.userAware.report.CaeUserAwareReportBase;
import com.obric.cae.userAware.report.CaeUserAwareReportFactory;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OCTitleBar;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UserAwareCurrentActivity extends Activity {
    private static final int MAX_SHOW_RESULTS = 5;
    public static final String SETTINGS_GLOBAL_USER_LOCATION_STATE = "user_location_state";
    private static final String TAG = "UserAwareCurrentActivity";
    private OCTitleBar mAwareCurrentTitle;
    private CurrentCallback mCurrentCallback;
    private String mLocationStateValueDesc;
    private OSwitch mPredictSwitch;
    private OButton mSceneCorrectionButton;
    private sc.a mSceneCorrectionDialog;
    private UserAwareService mService;
    private OTextView mTxtEnterTime;
    private OTextView mTxtGeofence;
    private OTextView mTxtLearningDetails;
    private OTextView mTxtNeighborWifiInfo;
    private OTextView mTxtWifiRssi;

    public class CurrentCallback extends InnerAwareInfoCallback {
        final /* synthetic */ UserAwareCurrentActivity this$0;

        private CurrentCallback(UserAwareCurrentActivity r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(CurrentCallback r8, StarGeofence r10) {
            r8.lambda$onGeofenceInfoChange$0(r10);
        }

        public static /* synthetic */ void b(CurrentCallback r8, WifiStandardData r10) {
            r8.lambda$onWifiConnectInfoChanged$1(r10);
        }

        public static /* synthetic */ void c(CurrentCallback r8, List r10) {
            r8.lambda$onWifiScanNeighborApChanged$2(r10);
        }

        private /* synthetic */ void lambda$onGeofenceInfoChange$0(StarGeofence r8) {
            UserAwareCurrentActivity.access$400(this.this$0, r8);
        }

        private /* synthetic */ void lambda$onWifiConnectInfoChanged$1(WifiStandardData r8) {
            UserAwareCurrentActivity.access$300(this.this$0, r8);
        }

        private /* synthetic */ void lambda$onWifiScanNeighborApChanged$2(List r8) {
            UserAwareCurrentActivity.access$200(this.this$0, r8);
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onGeofenceInfoChange(StarGeofence r8, Location r10) {
            CaeLog.d(UserAwareCurrentActivity.TAG, "onGeofenceInfoChange: " + r8);
            this.this$0.runOnUiThread(new e1(0, this, r8));
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onLocationStateValueChange(String r8) {
            defpackage.b.o("onLocationStateValueChange: ", r8, UserAwareCurrentActivity.TAG);
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onWifiConnectInfoChanged(WifiStandardData r8) {
            this.this$0.runOnUiThread(new p0(1, this, r8));
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public void onWifiScanNeighborApChanged(List<WifiStandardData> r8) {
            this.this$0.runOnUiThread(new f1(0, this, r8));
        }

        public /* synthetic */ CurrentCallback(UserAwareCurrentActivity r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public UserAwareCurrentActivity() {
    }

    public static /* synthetic */ void a(UserAwareCurrentActivity r8, CompoundButton r10, boolean r11) {
        r8.lambda$initUI$2(r10, r11);
    }

    public static /* synthetic */ void access$100(UserAwareCurrentActivity r8, int r10) {
        r8.updateScene(r10);
    }

    public static /* synthetic */ void access$200(UserAwareCurrentActivity r8, List r10) {
        r8.updateNeighborWifiInfo(r10);
    }

    public static /* synthetic */ void access$300(UserAwareCurrentActivity r8, WifiStandardData r10) {
        r8.updateConnectRssi(r10);
    }

    public static /* synthetic */ void access$400(UserAwareCurrentActivity r8, StarGeofence r10) {
        r8.updateStarGeofenceUI(r10);
    }

    public static /* synthetic */ void b(UserAwareCurrentActivity r8, View r10) {
        r8.lambda$initUI$0(r10);
    }

    public static /* synthetic */ void c(UserAwareCurrentActivity r8, View r10) {
        r8.lambda$initUI$1(r10);
    }

    private sc.a createSceneCorrectionDialog() {
        final sc.a r8 = new sc.a(this);
        r8.f12080o = sc.a.b.f12081a;
        Context r10 = r8.getContext();
        he.i.e(r10, "context");
        Resources r11 = r10.getResources();
        he.i.e(r11, "context.resources");
        int r12 = r11.getDisplayMetrics().widthPixels;
        Context r13 = r8.getContext();
        he.i.e(r13, "context");
        int r14 = r12 - (r13.getResources().getDimensionPixelSize(R.dimen.oui_dialog_narrow_layout_margin) * 2);
        Context r15 = r8.getContext();
        he.i.e(r15, "context");
        if (t2.b.J(r15) == false) goto L7;
        int r16 = android.aimedia.a.a("Resources.getSystem()", 1, 440);
        if (r14 <= r16) goto L7;
        r14 = r16;
    L7:
        RadiusLayout r17 = r8.f12079n;
        if (r17 == null) goto L34;
        defpackage.c.k0(r17, r14);
        RadiusLayout r18 = r8.f12079n;
        if (r18 == null) goto L32;
        Context r19 = r8.getContext();
        he.i.e(r19, "context");
        r18.setRadius(r19.getResources().getDimension(R.dimen.oui_r_l2));
        sc.f r20 = new sc.f(this);
        r20.setTitleText(getString(R.string.user_aware_scene_correction_title));
        r20.setShowLeftBack(false);
        LinearLayout r21 = r20.f12089a;
        he.i.f(r21, "root");
        OButton.f6184z.getClass();
        if (((OButton) r21.findViewById(R.id.btn_titlebar)) != null) goto L14;
        View r22 = Button.inflate(this, R.layout.o_widget_titlebar_button_neutral, r21).findViewById(R.id.btn_titlebar);
        he.i.c(r22);
        OButton r23 = (OButton) r22;
    L17:
        r23.setButtonSourceBitmap(R.drawable.o_ic_close);
        r23.setOnClickListener(new AnonymousClass1(this, r8));
        r20.getMTitleView().setTextSize(16.0f);
        FrameLayout r24 = r8.f12076a;
        if (r24 == null) goto L28;
        bc.a.c(r24);
        r24.removeAllViews();
        r24.addView(r20);
        rc.e r25 = new rc.e(this);
        r25.f11790s = true;
        final ArrayList r26 = new ArrayList();
        String[] r27 = getResources().getStringArray(R.array.scene_correction_options);
        int r28 = r27.length;
        int r29 = 0;
    L20:
        if (r29 >= r28) goto L22;
        r26.add(new rc.d.c(null, r27[r29], null));
        r29 = r29 + 1;
        goto L20
    L22:
        r25.setItems(r26);
        ConstraintLayout r30 = r25.f11786o;
        r30.setMinHeight(0);
        r30.setMinimumHeight(0);
        r25.f11788q = false;
        r25.setOnItemSelectListener(new AnonymousClass2(this, r26, r8));
        FrameLayout r110 = r8.f12078m;
        if (r110 == null) goto L26;
        bc.a.c(r110);
        r110.removeAllViews();
        r110.addView(r25);
        return r8;
    L26:
        he.i.j("contentContainer");
        throw null;
    L28:
        he.i.j("headerContainer");
        throw null;
    L14:
        View r31 = LayoutInflater.from(this).inflate(R.layout.o_widget_titlebar_button_neutral, r21, false);
        if (r31 == null) goto L31;
        OButton r32 = (OButton) r31;
        r32.setId(-1);
        r21.addView(r32);
        r23 = r32;
        goto L17
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OButton");
    L32:
        he.i.j("rootContainer");
        throw null;
    L34:
        he.i.j("rootContainer");
        throw null;
    }

    private String getUserLocationSettingsGlobal() {
        String r8 = Settings.Global.getString(getContentResolver(), "user_location_state");
        if (r8 != null) goto L7;
        return "";
    L7:
        return r8;
    }

    private void initUI() {
        this.mAwareCurrentTitle = (OCTitleBar) findViewById(R.id.aware_current_title);
        UserAwareService r8 = this.mService;
        if (r8 != null) goto L6;
        CaeLog.e(TAG, "mService is null...return");
        return;
    L6:
        String r10 = r8.getLearningProgressValue();
        this.mLocationStateValueDesc = this.mService.getLocationStateValueDesc();
        CaeLog.d(TAG, "mLocationStateValueDesc: " + this.mLocationStateValueDesc + ", mLearningProgressValue: " + r10);
        String r11 = UserAwareUtil.getSceneTitle(this, r10, this.mLocationStateValueDesc);
        OCTitleBar r12 = this.mAwareCurrentTitle;
        if (r12 == null) goto L9;
        r12.setTitleText(getResources().getString(R.string.user_aware_scenario_current) + r11);
        this.mAwareCurrentTitle.getMLeftActionBack().setOnClickListener(new n(this, 3));
    L9:
        OTextView r13 = (OTextView) findViewById(R.id.learning_details);
        this.mTxtLearningDetails = r13;
        r13.setVisibility(0);
        this.mTxtLearningDetails.setText(getString(R.string.user_aware_aware_learning_details) + r10);
        this.mTxtEnterTime = (OTextView) findViewById(R.id.enter_time);
        this.mTxtGeofence = (OTextView) findViewById(R.id.geofence_info);
        byte r14 = UserAwareUtil.LocationStateValueToByte(this, this.mLocationStateValueDesc);
        defpackage.b.m("geoType: ", r14, TAG);
        StarGeofence r15 = this.mService.getGeofenceStatusByGeoType(r14);
        CaeLog.d(TAG, "geofence: " + r15);
        updateStarGeofenceUI(r15);
        this.mTxtWifiRssi = (OTextView) findViewById(R.id.wifi_rssi);
        WifiStandardData r16 = this.mService.getWifiConnectInfo();
        if (r16 == null) goto L12;
        updateConnectRssi(r16);
    L12:
        this.mTxtNeighborWifiInfo = (OTextView) findViewById(R.id.neighbor_wifi_info);
        List<WifiStandardData> r17 = this.mService.getWifiScanNeighborAp();
        CaeLog.d(TAG, "wifiStandardDataList: " + r17);
        if (r17 == null) goto L18;
        if (r17.isEmpty() == true) goto L18;
        updateNeighborWifiInfo(r17);
    L18:
        if (r11.equals(getString(R.string.user_aware_aware_local_state_learning)) == false) goto L20;
        this.mTxtEnterTime.setVisibility(8);
        this.mTxtGeofence.setVisibility(8);
        this.mTxtWifiRssi.setVisibility(8);
        this.mTxtNeighborWifiInfo.setVisibility(8);
    L20:
        OButton r18 = (OButton) findViewById(R.id.aware_correction_button);
        this.mSceneCorrectionButton = r18;
        if (r18 == null) goto L23;
        r18.setOnClickListener(new com.google.android.material.search.a(this, 6));
    L23:
        this.mPredictSwitch = (OSwitch) findViewById(R.id.predictSwitch);
        initializeSwitchState();
        this.mPredictSwitch.setOnCheckedChangeListener(new f(this, 1));
    }

    private void initializeSwitchState() {
        boolean r8 = "1".equals(Settings.Global.getString(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH));     // Catch: Exception -> L5
        this.mPredictSwitch.setChecked(r8);     // Catch: Exception -> L5
        CaeLog.d(TAG, "initializeSwitchState: " + r8);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        defpackage.b.k(e, new StringBuilder("Error getting switch state: "), TAG);
        this.mPredictSwitch.setChecked(false);
    }

    private /* synthetic */ void lambda$initUI$0(View r8) {
        finish();
    }

    private /* synthetic */ void lambda$initUI$1(View r8) {
        releaseSceneCorrectionDialog();
        sc.a r10 = createSceneCorrectionDialog();
        this.mSceneCorrectionDialog = r10;
        r10.show();
    }

    private /* synthetic */ void lambda$initUI$2(CompoundButton r8, boolean r10) {
        CaeLog.d(TAG, "Predict switch changed, checked: " + r10);
        ContentResolver r11 = getContentResolver();
        if (r10 == false) goto L5;
        String r12 = "1";
    L6:
        Settings.Global.putString(r11, AwareStateListener.SETTINGS_GLOBAL_USER_FEEDBACK_PREDICT_SWITCH, r12);
        return;
    L5:
        r12 = "0";
        goto L6
    }

    private void releaseSceneCorrectionDialog() {
        sc.a r8 = this.mSceneCorrectionDialog;
        if (r8 == null) goto L6;
        r8.dismiss();
        this.mSceneCorrectionDialog = null;
        return;
    }

    private void updateConnectRssi(WifiStandardData r8) {
        if (this.mLocationStateValueDesc != null) goto L5;
    L7:
        this.mTxtWifiRssi.setText(getString(R.string.user_aware_wifi_rssi) + r8.getRssi());
        return;
    L5:
        if (getResources().getString(R.string.user_aware_aware_local_state_learning).equals(this.mLocationStateValueDesc) == false) goto L7;
    }

    private void updateNeighborWifiInfo(List<WifiStandardData> r8) {
        if (r8 != null) goto L5;
    L19:
        this.mTxtNeighborWifiInfo.setText(getString(R.string.user_aware_neighbor_wifi_info));
        return;
    L5:
        if (r8.isEmpty() == true) goto L19;
        int r10 = 0;
        ArrayList r11 = new ArrayList(r8.subList(0, Math.min(5, r8.size())));
        StringBuilder r12 = new StringBuilder();
    L9:
        if (r10 >= r11.size()) goto L17;
        WifiStandardData r13 = (WifiStandardData) r11.get(r10);
        if (r13 == null) goto L16;
        CaeLog.d(TAG, "updateNeighborWifiInfo: " + r13);
        r12.append("BSSID: ");
        r12.append(r13.getBssid());
        r12.append(", SSID: ");
        r12.append(r13.getSsid());
        r12.append(", RSSI:");
        r12.append(r13.getRssi());
        r12.append(", Frequency: ");
        r12.append(r13.getFrequency());
        if (r10 >= (r11.size() - 1)) goto L16;
        r12.append('\n');
    L16:
        r10 = r10 + 1;
        goto L9
    L17:
        this.mTxtNeighborWifiInfo.setText(getString(R.string.user_aware_neighbor_wifi_info) + r12);
    }

    private void updateScene(int r8) {
        CaeUserAwareReportBase r10 = CaeUserAwareReportFactory.getReportInstance();
        if (r10 != null) goto L5;
        return;
    L5:
        UserFeedbackInfo r11 = new UserFeedbackInfo();
        r11.setType("UserFeedback");
        r11.setTimeStamp(System.currentTimeMillis());
        r11.setStateCode(UserAwareUtil.getCurrentLocationInteger(getUserLocationSettingsGlobal()));
        r11.setUserChoice(0);
        r11.setStateChange(r8);
        r10.reportUserFeedbackInfo(r11);
    }

    private void updateStarGeofenceUI(StarGeofence r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.mTxtEnterTime.setText(getString(R.string.user_aware_enter_time) + UserAwareUtil.timeMillisToDateString(r8.getEventTimestamp()));
        this.mTxtGeofence.setText(getString(R.string.user_aware_gps_info) + UserAwareUtil.getGeofenceStateString(this, r8));
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r8) {
        CaeLog.d(TAG, "onCreate");
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(Color.rgb(247, 247, 247));
        UserAwareUtil.setLightStatusBarIcon(this, true);
        super.onCreate(r8);
        setContentView(R.layout.aware_current);
        this.mCurrentCallback = new CurrentCallback(this, null);
        UserAwareService r10 = UserAwareService.getService();
        this.mService = r10;
        if (r10 == null) goto L5;
        UserAwareManager.getInstance().registerInnerCallback(this.mCurrentCallback);
    L5:
        initUI();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CaeLog.d(TAG, "onDestroy");
        releaseSceneCorrectionDialog();
        if (this.mService == null) goto L6;
        UserAwareManager.getInstance().unregisterInnerCallback(this.mCurrentCallback);
    L6:
        if (this.mCurrentCallback == null) goto L9;
        this.mCurrentCallback = null;
        return;
    }
}
