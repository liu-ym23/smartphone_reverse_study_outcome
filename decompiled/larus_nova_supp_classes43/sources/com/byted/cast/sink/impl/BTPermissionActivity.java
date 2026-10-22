package com.byted.cast.sink.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BTPermissionActivity extends Activity {
    public static final String[] a = null;
    private static a b;

    static {
        a = new String[]{"android.permission.BLUETOOTH_CONNECT"};
    }

    public BTPermissionActivity() {
    }

    private static void a(Activity r10) {
        ViewGroup r11 = (ViewGroup) r10.findViewById(R.id.content);
        int r0 = r11.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        View r12 = r11.getChildAt(r1);
        if ((r12 instanceof ViewGroup) == false) goto L7;
        r12.setFitsSystemWindows(true);
        ((ViewGroup) r12).setClipToPadding(true);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    public static void b(Activity r0) {
        c(r0);
        a(r0);
    }

    private static void c(Activity r10) {
        r10.getWindow().addFlags(Integer.MIN_VALUE);
        r10.getWindow().clearFlags(67108864);
        r10.getWindow().addFlags(134217728);
        r10.getWindow().setStatusBarColor(0);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r1) {
        super.attachBaseContext(r1);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    public void com_byted_cast_sink_impl_BTPermissionActivity__finish$___twin___() {
        super.finish();
    }

    public void com_byted_cast_sink_impl_BTPermissionActivity__onCreate$___twin___(Bundle r10) {
        super.onCreate(r10);
        b(this);
        if (Build.VERSION.SDK_INT < 23) goto L6;
        requestPermissions(a, 1);
        return;
    }

    public void com_byted_cast_sink_impl_BTPermissionActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    public void finish() {
        com_byted_cast_sink_impl_BTPermissionActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // android.app.Activity
    public void onActivityResult(int r10, int r11, Intent r12) {
        super.onActivityResult(r10, r11, r12);
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r1) {
        com_byted_cast_sink_impl_BTPermissionActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int r10, String[] r11, int[] r12) {
        com_byted_cast_sink_impl_BTPermissionActivity_android_app_Activity_onRequestPermissionsResult_super(this, r10, r11, r12);
        if (r10 != 1) goto L13;
        int r13 = 0;
    L6:
        if (r13 >= r11.length) goto L13;
        String r0 = r11[r13];
        if (r12[r13] != 0) goto L12;
        a r1 = b;
        if (r1 == null) goto L12;
        r1.a();
    L12:
        r13 = r13 + 1;
    L13:
        finish();
    }

    @Override // android.app.Activity
    public void onStop() {
        com_byted_cast_sink_impl_BTPermissionActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public static View INVOKEVIRTUAL_com_byted_cast_sink_impl_BTPermissionActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r10) {
        View r11 = r10.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r11;
    }

    public static void com_byted_cast_sink_impl_BTPermissionActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(BTPermissionActivity r1) {
        r1.com_byted_cast_sink_impl_BTPermissionActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_byted_cast_sink_impl_BTPermissionActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void com_byted_cast_sink_impl_BTPermissionActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(BTPermissionActivity r11) {
        r11.com_byted_cast_sink_impl_BTPermissionActivity__finish$___twin___();
        if ((r11 instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((r11 instanceof ChatWindowActivity) == false) goto L8;
        return;
    L8:
        FLogger r10 = FLogger.a;
        r10.i("ActivityLancet", "finish ".concat(r11.getClass().getName()));
        long r12 = SystemClock.uptimeMillis();
        Map r13 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r13);
        Long r14 = (Long) r13.get(r11);     // Catch: Throwable -> L53
        if (r14 != null) goto L13;
    L16:
        r13.put(r11, Long.valueOf(r12));     // Catch: Throwable -> L53
        monitor-exit(r13);     // Catch: Throwable -> L53
    L50:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L19:
        if (((FragmentActivity) r11).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L23;
        r10.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) r11).getLifecycle().getCurrentState());     // Catch: Throwable -> L50
        return;
    L23:
        if (r11.isFinishing() == true) goto L27;
        r10.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L50
        return;
    L27:
        if (ActivityStartBehavior.isInternalActivityConsumed(r11) == true) goto L31;
        r10.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L50
        return;
    L31:
        if (ActivityLancet.isOnlyActivityInTask(r11) == true) goto L35;
        r10.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L50
        return;
    L35:
        if (ActivityLancet.isExcludedActivity(r11) == false) goto L39;
        r10.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L50
        return;
    L39:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L41;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L50
        return;
    L41:
        Intent r1 = r11.getPackageManager().getLaunchIntentForPackage(r11.getPackageName());     // Catch: Throwable -> L50
        if (r1 != null) goto L44;
        return;
    L44:
        r1.addFlags(268435456);     // Catch: Throwable -> L50
        r1.addFlags(2097152);     // Catch: Throwable -> L50
        r10.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r11);     // Catch: Throwable -> L50
        r11.startActivity(r1);     // Catch: Throwable -> L47
        r11.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L47
    L61:
        return;
    L47:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L50
        return;
    L13:
        if ((r12 - r14.longValue()) >= 800) goto L16;
        monitor-exit(r13);     // Catch: Throwable -> L53
        return;
    L53:
        th = move-exception;
        throw th;
    }

    public static void com_byted_cast_sink_impl_BTPermissionActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(BTPermissionActivity r1, Bundle r10) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(r1) == false) goto L8;
        v19.f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_byted_cast_sink_impl_BTPermissionActivity__onCreate$___twin___(r10);
    }

    private static void com_byted_cast_sink_impl_BTPermissionActivity_android_app_Activity_onRequestPermissionsResult_super(Activity r18, int r19, String[] r20, int[] r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19), r20, r21};
        f06.b r11 = new f06.b();
        g06.a r10 = (g06.a) ApiHookConfig.b.get(102611);
        if (r10 == null) goto L5;
        f06.a[] r12 = r10.i;
    L6:
        f06.a[] r15 = r12;
        int r13 = r15.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L15;
        f06.a r16 = r15[r14];
        int r17 = r14;
        int r110 = r13;
        f06.d r22 = r16.preInvoke(102611, "android/app/Activity", "onRequestPermissionsResult", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r22.a == true) goto L17;
        r0.add(r16);     // Catch: Exception -> L21
    L17:
        if (r22.a == false) goto L19;
        return;
    L19:
        super.onRequestPermissionsResult(r19, r20, r21);
        return;
    L14:
        r14 = r17 + 1;
        r13 = r110;
        goto L8
    L15:
        r22 = new f06.d(false, null);
        goto L17
    L5:
        r12 = ApiHookConfig.d;
        goto L6
    }
}
