package com.lynx.devtool.recorder;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxRecorderMultiPagesActivity extends AppCompatActivity {
    private RelativeLayout mContainerView;
    private ArrayList<LynxRecorderView> mPageInstances;
    private JSONArray mPages;
    private String url;

    public static /* synthetic */ void access$001(AppCompatActivity r0, Configuration r1) {
        super.onConfigurationChanged(r1);
    }

    public void com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity__finish$___twin___() {
        super.finish();
    }

    public void com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity__onStop$___twin___() {
        super.onStop();
    }

    public void finish() {
        com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public void onCreate(Bundle r1) {
        com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    public void onDestroy() {
        com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    public void onStop() {
        com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void buildPages() {
        int r2 = 0;
    L4:
        if (r2 >= this.mPages.length()) goto L10;
        JSONObject r3 = JSONArrayProtectorUtils.getJSONObject(this.mPages, r2);     // Catch: JSONException -> L7
        String r4 = JSONObjectProtectorUtils.getString(r3, LynxEventReporter.PROP_NAME_URL);     // Catch: JSONException -> L7
        int r5 = JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(r3, "frame"), "x");     // Catch: JSONException -> L7
        int r6 = JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(r3, "frame"), "y");     // Catch: JSONException -> L7
        LynxRecorderView r7 = new LynxRecorderView(this);     // Catch: JSONException -> L7
        this.mContainerView.addView(r7);     // Catch: JSONException -> L7
        this.mPageInstances.add(r7);     // Catch: JSONException -> L7
        r7.loadPageWithPoint(r4, new int[]{r5, r6}, getIntent());     // Catch: JSONException -> L7
    L9:
        r2 = r2 + 1;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    private void loadFile() {
        QueryMapUtils r0 = new QueryMapUtils();
        r0.parse(this.url);
        String r1 = r0.getString(LynxEventReporter.PROP_NAME_URL);
        LynxEnv.inst().getTemplateProvider().loadTemplate(r1, new AnonymousClass2(this));
    }

    public void com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity__onDestroy$___twin___() {
        super.onDestroy();
        Iterator<LynxRecorderView> r0 = this.mPageInstances.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().destroy();
        goto L4
    }

    public LynxRecorderMultiPagesActivity() {
    }

    public void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
    }

    public static View INVOKEVIRTUAL_com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static /* synthetic */ ArrayList access$000(LynxRecorderMultiPagesActivity r0) {
        return r0.mPageInstances;
    }

    public static /* synthetic */ void access$200(LynxRecorderMultiPagesActivity r0) {
        r0.buildPages();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(LynxRecorderMultiPagesActivity r1) {
        r1.com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(LynxRecorderMultiPagesActivity r11) {
        r11.com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity__finish$___twin___();
        if ((r11 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(r11.getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(r11);     // Catch: Throwable -> L50
        if (r6 != null) goto L10;
    L13:
        r5.put(r11, Long.valueOf(r3));     // Catch: Throwable -> L50
        monitor-exit(r5);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L16:
        if (r11.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L20;
        r2.i("ActivityLancet", "quit !resume, current state = " + r11.getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        return;
    L20:
        if (r11.isFinishing() == true) goto L24;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        return;
    L24:
        if (ActivityStartBehavior.isInternalActivityConsumed(r11) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        return;
    L28:
        if (ActivityLancet.isOnlyActivityInTask(r11) == true) goto L32;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        return;
    L32:
        if (ActivityLancet.isExcludedActivity(r11) == false) goto L36;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        return;
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        return;
    L38:
        Intent r1 = r11.getPackageManager().getLaunchIntentForPackage(r11.getPackageName());     // Catch: Throwable -> L47
        if (r1 != null) goto L41;
        return;
    L41:
        r1.addFlags(268435456);     // Catch: Throwable -> L47
        r1.addFlags(2097152);     // Catch: Throwable -> L47
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r11);     // Catch: Throwable -> L47
        r11.startActivity(r1);     // Catch: Throwable -> L44
        r11.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L44
    L58:
        return;
    L44:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        return;
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    }

    public static void com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(LynxRecorderMultiPagesActivity r3) {
        if ((r3 instanceof FragmentActivity) == true) goto L5;
    L7:
        r3.com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r3) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r3);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r3.getClass().getName()));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity__onCreate$___twin___(Bundle r4) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r4);
        Intent r5 = getIntent();
        QueryMapUtils r0 = new QueryMapUtils();
        this.url = r5.getStringExtra(LynxRecorderEnv.getInstance().mUriKey);
        this.mPageInstances = new ArrayList();
        r0.parse(this.url);
        if (r0.getBoolean("fullScreen", false) == false) goto L5;
        setContentView(2131564270);
        getWindow().addFlags(1024);
    L7:
        if (r0.getBoolean("landscape", false) == false) goto L9;
        setRequestedOrientation(0);
    L9:
        this.mContainerView = (RelativeLayout) findViewById(2131367728);
        getWindow().setSoftInputMode(48);
        loadFile();
        return;
    L5:
        setContentView(2131564271);
        findViewById(2131362131).setOnClickListener(new AnonymousClass1(this));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration r5) {
        INVOKESPECIAL_com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, r5);
        DisplayMetrics r6 = DisplayMetricsHolder.getRealScreenDisplayMetrics(this);
        Iterator<LynxRecorderView> r0 = this.mPageInstances.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().updateScreenMetrics(r6.widthPixels, r6.heightPixels);
        goto L4
    }

    public static void INVOKESPECIAL_com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(AppCompatActivity r3, Configuration r4) {
        access$001(r3, r4);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L22;
        int r2 = r3.getRequestedOrientation();     // Catch: Throwable -> L17
        if (r4 == null) goto L8;
        Integer r5 = Integer.valueOf(r4.orientation);     // Catch: Throwable -> L17
    L9:
        if (r5 != null) goto L12;
    L14:
        if (r2 != 3) goto L24;
        r3.setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:" + r3.getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L12:
        if (r5.intValue() != r2) goto L14;
        return;
    L8:
        r5 = null;
        goto L9
    L22:
        return;
    L17:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
    }

    public static /* synthetic */ JSONArray access$102(LynxRecorderMultiPagesActivity r0, JSONArray r1) {
        r0.mPages = r1;
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(LynxRecorderMultiPagesActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(r1) == false) goto L8;
        v19.f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_lynx_devtool_recorder_LynxRecorderMultiPagesActivity__onCreate$___twin___(r2);
    }
}
