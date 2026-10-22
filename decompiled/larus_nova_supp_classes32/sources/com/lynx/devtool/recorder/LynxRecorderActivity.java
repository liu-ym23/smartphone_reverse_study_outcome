package com.lynx.devtool.recorder;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxRecorderActivity extends AppCompatActivity {
    public static final String LYNX_VIEW_DENSITY = "LynxViewDensity";
    public static final String LYNX_VIEW_HEIGHT = "LynxViewHeight";
    public static final String LYNX_VIEW_WIDTH = "LynxViewWidth";
    private static final String TAG = "LynxRecorderActivity";
    private LynxRecorderActionManager mActionManager;
    private RelativeLayout mContainerView;
    private boolean mHasBeenRemoveFromPageStack;
    private LifecycleRegistry mLifecycleRegistry;
    private LynxView mLynxView;
    private String url;

    public static /* synthetic */ void access$000(AppCompatActivity r0, Configuration r1) {
        super.onConfigurationChanged(r1);
    }

    public static /* synthetic */ void y1(LynxRecorderActivity r0, View r1) {
        r0.lambda$onCreate$0(r1);
    }

    public void com_lynx_devtool_recorder_LynxRecorderActivity__finish$___twin___() {
        super.finish();
    }

    public void com_lynx_devtool_recorder_LynxRecorderActivity__onStop$___twin___() {
        super.onStop();
    }

    public void finish() {
        com_lynx_devtool_recorder_LynxRecorderActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public void onCreate(Bundle r1) {
        com_lynx_devtool_recorder_LynxRecorderActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    public void onDestroy() {
        com_lynx_devtool_recorder_LynxRecorderActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    public void onStop() {
        com_lynx_devtool_recorder_LynxRecorderActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public Lifecycle getLifecycle() {
        if (this.mLifecycleRegistry != null) goto L6;
        this.mLifecycleRegistry = new LifecycleRegistry(this);
    L6:
        return this.mLifecycleRegistry;
    }

    public LynxGroup getLynxGroup() {
        return this.mActionManager.getLynxGroup();
    }

    public LynxRecorderActivity() {
        this.mLifecycleRegistry = null;
        this.mHasBeenRemoveFromPageStack = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_lynx_devtool_recorder_LynxRecorderActivity__onDestroy$___twin___() {
        super.onDestroy();
        LynxRecorderPageManager.getInstance().onActivityDestroy(getIntent().getStringExtra("pageName"), this.mHasBeenRemoveFromPageStack);
        LynxRecorderActionManager r0 = this.mActionManager;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
        LynxView r0 = this.mLynxView;
        if (r0 == null) goto L6;
        r0.onEnterBackground();
        return;
    }

    public void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        LynxView r0 = this.mLynxView;
        if (r0 == null) goto L5;
        r0.onEnterForeground();
    L5:
        this.mLifecycleRegistry.markState(Lifecycle.State.RESUMED);
    }

    public void onStart() {
        super.onStart();
        this.mLifecycleRegistry.markState(Lifecycle.State.STARTED);
    }

    public static View INVOKEVIRTUAL_com_lynx_devtool_recorder_LynxRecorderActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_lynx_devtool_recorder_LynxRecorderActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(LynxRecorderActivity r1) {
        r1.com_lynx_devtool_recorder_LynxRecorderActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_lynx_devtool_recorder_LynxRecorderActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_lynx_devtool_recorder_LynxRecorderActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(LynxRecorderActivity r11) {
        r11.com_lynx_devtool_recorder_LynxRecorderActivity__finish$___twin___();
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

    public static void com_lynx_devtool_recorder_LynxRecorderActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(LynxRecorderActivity r3) {
        if ((r3 instanceof FragmentActivity) == true) goto L5;
    L7:
        r3.com_lynx_devtool_recorder_LynxRecorderActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r3) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r3);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r3.getClass().getName()));
        goto L7
    }

    private /* synthetic */ void lambda$onCreate$0(View r1) {
        this.mActionManager.load();
        LynxView r2 = this.mLynxView;
        if (r2 == null) goto L6;
        r2.onEnterForeground();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_lynx_devtool_recorder_LynxRecorderActivity__onCreate$___twin___(Bundle r5) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r5);
        Intent r6 = getIntent();
        QueryMapUtils r0 = new QueryMapUtils();
        String r1 = r6.getStringExtra(LynxRecorderEnv.getInstance().mUriKey);
        this.url = r1;
        r0.parse(r1);
        if (r0.getBoolean("fullScreen", false) == false) goto L5;
        setContentView(2131564270);
        getWindow().addFlags(1024);
    L9:
        if (r0.getBoolean("landscape", false) == false) goto L11;
        setRequestedOrientation(0);
    L11:
        this.mContainerView = (RelativeLayout) findViewById(2131367728);
        getWindow().setSoftInputMode(48);
        this.mActionManager = new LynxRecorderActionManager(r6, this, this.mContainerView, null);
        LynxRecorderPageManager.getInstance().initLynxGroup(r6.getStringExtra("groupName"), this);
        LynxRecorderPageManager.getInstance().registerActivity(r6.getStringExtra("pageName"), this);
        if (this.mLifecycleRegistry != null) goto L14;
        this.mLifecycleRegistry = new LifecycleRegistry(this);
    L14:
        this.mLifecycleRegistry.markState(Lifecycle.State.CREATED);
        this.mActionManager.registerCallback(new AnonymousClass1(this));
        Iterator<LynxRecorderActionCallback> r7 = LynxRecorderPageManager.getInstance().getCallbacks().iterator();
    L16:
        if (r7.hasNext() == false) goto L18;
        LynxRecorderActionCallback r2 = r7.next();
        this.mActionManager.registerCallback(r2);
        goto L16
    L18:
        this.mActionManager.startWithUrl(this.url);
        return;
    L5:
        setContentView(2131564269);
        View r3 = findViewById(2131362131);
        if (r3 == null) goto L9;
        r3.setOnClickListener(new g(this));
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration r3) {
        INVOKESPECIAL_com_lynx_devtool_recorder_LynxRecorderActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, r3);
        DisplayMetrics r4 = DisplayMetricsHolder.getRealScreenDisplayMetrics(this);
        LynxView r0 = this.mLynxView;
        if (r0 == null) goto L5;
        r0.updateScreenMetrics(r4.widthPixels, r4.heightPixels);
    L5:
        LynxRecorderReplayStateView r5 = (LynxRecorderReplayStateView) findViewById(2131384053);
        if (r5 == null) goto L9;
        r5.updateScreenMetrics();
        return;
    }

    public void setLynxGroup(LynxGroup r2) {
        this.mActionManager.setLynxGroup(r2);
    }

    public void setState(boolean r1) {
        this.mHasBeenRemoveFromPageStack = r1;
    }

    public static void INVOKESPECIAL_com_lynx_devtool_recorder_LynxRecorderActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(AppCompatActivity r3, Configuration r4) {
        access$000(r3, r4);
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

    public static /* synthetic */ LynxView access$002(LynxRecorderActivity r0, LynxView r1) {
        r0.mLynxView = r1;
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_lynx_devtool_recorder_LynxRecorderActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(LynxRecorderActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(r1) == false) goto L8;
        v19.f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_lynx_devtool_recorder_LynxRecorderActivity__onCreate$___twin___(r2);
    }

    private void attachToView(ViewGroup r3, int r4, int r5) {
        LynxView r0 = this.mLynxView;
        if (r0 == null) goto L6;
        r3.addView(r0, new LinearLayout.LayoutParams(r4, r5));
        return;
    }

    public static /* synthetic */ void access$100(LynxRecorderActivity r0, ViewGroup r1, int r2, int r3) {
        r0.attachToView(r1, r2, r3);
    }
}
