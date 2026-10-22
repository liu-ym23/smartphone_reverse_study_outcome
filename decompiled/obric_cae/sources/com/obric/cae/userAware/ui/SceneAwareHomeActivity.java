package com.obric.cae.userAware.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.titlebar.OCTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public class SceneAwareHomeActivity extends Activity {
    private static final String TAG = "SceneAwareHomeActivity";
    private String mLearningProgressValue;
    private String mLocationStateValue;
    private OCTitleBar mTitle;

    public SceneAwareHomeActivity() {
    }

    public static /* synthetic */ void a(SceneAwareHomeActivity r8, View r10) {
        r8.lambda$initUI$0(r10);
    }

    public static /* synthetic */ void b(SceneAwareHomeActivity r8, View r10) {
        r8.lambda$initUI$3(r10);
    }

    public static /* synthetic */ void c(SceneAwareHomeActivity r8, View r10) {
        r8.lambda$initUI$4(r10);
    }

    public static /* synthetic */ void d(SceneAwareHomeActivity r8, View r10) {
        r8.lambda$initUI$5(r10);
    }

    public static /* synthetic */ void e(SceneAwareHomeActivity r8, View r10) {
        r8.lambda$initUI$1(r10);
    }

    public static /* synthetic */ void f(SceneAwareHomeActivity r8, View r10) {
        r8.lambda$initUI$2(r10);
    }

    public static /* synthetic */ void g(SceneAwareHomeActivity r8, View r10) {
        r8.lambda$initUI$6(r10);
    }

    private void initUI() {
        OCTitleBar r8 = (OCTitleBar) findViewById(R.id.scene_aware_title);
        this.mTitle = r8;
        final int r10 = 0;
        if (r8 == null) goto L5;
        r8.getMLeftActionBack().setOnClickListener(new q0(this, r10));
    L5:
        findViewById(R.id.scene_home_aware).setOnClickListener(new r0(this, r10));
        findViewById(R.id.scene_har_status).setOnClickListener(new s0(this, r10));
        final int r11 = 1;
        findViewById(R.id.scene_subway_status).setOnClickListener(new q0(this, r11));
        findViewById(R.id.scene_near_elevator).setOnClickListener(new r0(this, r11));
        findViewById(R.id.scene_zpp_model).setOnClickListener(new s0(this, r11));
        final int r12 = 2;
        findViewById(R.id.scene_poi_arrival).setOnClickListener(new q0(this, r12));
    }

    private /* synthetic */ void lambda$initUI$0(View r8) {
        finish();
    }

    private /* synthetic */ void lambda$initUI$1(View r8) {
        startAwareCurrentActivity();
    }

    private /* synthetic */ void lambda$initUI$2(View r8) {
        startHARStatusActivity();
    }

    private /* synthetic */ void lambda$initUI$3(View r8) {
        startSubwayStatusActivity();
    }

    private /* synthetic */ void lambda$initUI$4(View r8) {
        startAwareNearElevatorActivity();
    }

    private /* synthetic */ void lambda$initUI$5(View r8) {
        startStarZppModelActivity();
    }

    private /* synthetic */ void lambda$initUI$6(View r8) {
        startPoiArrivalActivity();
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

    private void startHARStatusActivity() {
        Intent r8 = new Intent(this, HARStatusActivity.class);
        r8.addFlags(335544320);
        startActivity(r8);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    private void startPoiArrivalActivity() {
        Intent r8 = new Intent(this, PoiArrivalActivity.class);
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

    private void startSubwayStatusActivity() {
        Intent r8 = new Intent(this, SubwayStatusActivity.class);
        r8.addFlags(335544320);
        startActivity(r8);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    private void updateTitles() {
        this.mLocationStateValue = UserAwareUtil.getCurrentLocationString(this, Settings.Global.getString(getContentResolver(), "user_location_state"));     // Catch: Exception -> L5
    L31:
        String r8 = Settings.Global.getString(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_USER_LEARNING_PROGRESS);     // Catch: Exception -> L11
        this.mLearningProgressValue = r8;     // Catch: Exception -> L11
        if (r8 != null) goto L27;
        this.mLearningProgressValue = "";     // Catch: Exception -> L11
    L27:
        String r10 = UserAwareUtil.getHarStateString(this, Settings.Global.getInt(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_HAR_STATE, -1));     // Catch: Exception -> L17
        OListItemSettings r11 = (OListItemSettings) findViewById(R.id.scene_har_status);     // Catch: Exception -> L17
        if (r11 == null) goto L29;
        r11.setTrailingText(r10);     // Catch: Exception -> L17
    L29:
        OListItemSettings r12 = (OListItemSettings) findViewById(R.id.scene_home_aware);     // Catch: Exception -> L24
        if (r12 == null) goto L35;
        r12.setTrailingText(UserAwareUtil.getSceneTitle(this, this.mLearningProgressValue, this.mLocationStateValue));     // Catch: Exception -> L24
        return;
    L35:
        return;
    L24:
        e = move-exception;
        CaeLog.e(TAG, "Failed to update home aware title", e);
        return;
    L17:
        e = move-exception;
        CaeLog.e(TAG, "Failed to get HAR state", e);
    L11:
        e = move-exception;
        CaeLog.e(TAG, "Failed to get learning progress", e);
    L5:
        e = move-exception;
        CaeLog.e(TAG, "Failed to get location state", e);
        goto L31
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        setContentView(R.layout.activity_scene_aware_home);
        CaeLog.d(TAG, "onCreate");
        initUI();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        updateTitles();
    }
}
