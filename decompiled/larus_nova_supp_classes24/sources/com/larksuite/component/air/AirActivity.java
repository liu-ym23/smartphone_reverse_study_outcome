package com.larksuite.component.air;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.autoscale.a;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.CarUtils;
import dc9.d;
import fsb.b;
import fsb.f;
import java.lang.reflect.Field;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import my7.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class AirActivity extends AppCompatActivity {
    private final String TAG;
    private Resources autoscaleResources;
    private int currentUiMode;
    private final String isReportActivityInfoFG;
    private final c mDelegate;

    public static /* synthetic */ void access$000(AppCompatActivity r0, Configuration r1) {
        super.onConfigurationChanged(r1);
    }

    public void com_larksuite_component_air_AirActivity__finish$___twin___() {
        super.finish();
    }

    public void finish() {
        com_larksuite_component_air_AirActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public void onCreate(Bundle r1) {
        com_larksuite_component_air_AirActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    public void onDestroy() {
        com_larksuite_component_air_AirActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    private Resources getAutoscaleResources() {
        int r0 = a.a;
        return super.getResources();
    }

    public void com_larksuite_component_air_AirActivity__onDestroy$___twin___() {
        c r0 = this.mDelegate;
        if (r0 == null) goto L5;
        r0.onDestroy();
    L5:
        super.onDestroy();
    }

    public AirActivity() {
        if (my7.a.a == null) goto L5;
    L14:
        my7.a.a.getClass();
        this.mDelegate = null;
        this.isReportActivityInfoFG = "im.performance.monitor_report_activity";
        this.TAG = "airActivity";
        this.currentUiMode = -1;
        return;
    L5:
        monitor-enter(my7.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (my7.a.a != null) goto L9;
        my7.a.a = new my7.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(my7.a.class);     // Catch: Throwable -> L11
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Resources getResources() {
        Resources r0 = getAutoscaleResources();
        c r1 = this.mDelegate;
        if (r1 == null) goto L10;
        Resources r2 = r1.getResources(this, r0);
        if (r2 == null) goto L10;
        if (Build.VERSION.SDK_INT > 28) goto L9;
        fixAppCompatThemeBug(r0, r2);
    L9:
        return r2;
    L10:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Resources.Theme getTheme() {
        return super/*android.app.Activity*/.getTheme();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_larksuite_component_air_AirActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(AirActivity r11) {
        r11.com_larksuite_component_air_AirActivity__finish$___twin___();
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

    public static void com_larksuite_component_air_AirActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(AirActivity r3) {
        if ((r3 instanceof FragmentActivity) == true) goto L5;
    L7:
        r3.com_larksuite_component_air_AirActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r3) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r3);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r3.getClass().getName()));
        goto L7
    }

    public void com_larksuite_component_air_AirActivity__onCreate$___twin___(Bundle r2) {
        c r0 = this.mDelegate;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r2);
        c r3 = this.mDelegate;
        if (r3 == null) goto L8;
        r3.a();
    L8:
        String[] r4 = CarUtils.a;
    }

    public void onConfigurationChanged(Configuration r1) {
        INVOKESPECIAL_com_larksuite_component_air_AirActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, r1);
        int r2 = a.a;
        String[] r3 = CarUtils.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPostCreate(Bundle r3) {
        super.onPostCreate(r3);
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.performance.monitor_report_activity") == false) goto L10;
        String r4 = getLocalClassName();     // Catch: Throwable -> L7
        f r0 = f.e;     // Catch: Throwable -> L7
        CoreThreadPool.getDefault().getFixedThreadPool().submit(new b(r4));     // Catch: Throwable -> L7
        return;
    L10:
        return;
    }

    public static void INVOKESPECIAL_com_larksuite_component_air_AirActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(AppCompatActivity r3, Configuration r4) {
        access$000(r3, r4);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (d.a() == true) goto L22;
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

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_larksuite_component_air_AirActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(AirActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(r1) == false) goto L8;
        v19.f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_larksuite_component_air_AirActivity__onCreate$___twin___(r2);
    }

    private void fixAppCompatThemeBug(Resources r3, Resources r4) {
        if (r3.getAssets() == r4.getAssets()) goto L11;
        Field r0 = Resources.class.getDeclaredField("mResourcesImpl");     // Catch: Throwable -> L6
        r0.setAccessible(true);     // Catch: Throwable -> L6
        r0.set(r4, r0.get(r3));     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
