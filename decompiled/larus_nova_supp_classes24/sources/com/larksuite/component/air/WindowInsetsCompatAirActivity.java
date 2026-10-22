package com.larksuite.component.air;

import android.R;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import com.ss.android.lark.insets.h;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import kotlin.jvm.internal.Intrinsics;
import my7.d;
import my7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class WindowInsetsCompatAirActivity extends AirActivity {
    private static final String SOFT_INPUT_ADJUST_RESIZE = "adjust_resize";
    private static final String TAG = "InsetsCompatAirActivity";
    private ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private boolean hasInit;
    private boolean isIgnoreWindowFlags;
    private boolean isSoftInputAdjustResize;
    private boolean isSystemUIFullscreen;
    private boolean isSystemUIHideNavigation;
    private boolean isWindowNoLimit;

    @Nullable
    private Boolean remoteAdjustResize;

    public static /* synthetic */ void y1(WindowInsetsCompatAirActivity r0, View r1, f r2) {
        r0.lambda$setupWindowInsets$0(r1, r2);
    }

    public void com_larksuite_component_air_WindowInsetsCompatAirActivity__finish$___twin___() {
        super.finish();
    }

    @Override // com.larksuite.component.air.AirActivity
    public void finish() {
        com_larksuite_component_air_WindowInsetsCompatAirActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public void initDefaultNavBarColor() {
    }

    public void initDefaultStatusBarColor() {
    }

    @Override // com.larksuite.component.air.AirActivity
    public void onCreate(Bundle r1) {
        com_larksuite_component_air_WindowInsetsCompatAirActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    @Override // com.larksuite.component.air.AirActivity
    public void onDestroy() {
        com_larksuite_component_air_WindowInsetsCompatAirActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_larksuite_component_air_WindowInsetsCompatAirActivity__onDestroy$___twin___() {
        if (this.globalLayoutListener == null) goto L5;
        INVOKEVIRTUAL_com_larksuite_component_air_WindowInsetsCompatAirActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()).getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
    L5:
        super.onDestroy();
    }

    public WindowInsetsCompatAirActivity() {
        this.isSystemUIFullscreen = false;
        this.isSystemUIHideNavigation = false;
        this.isSoftInputAdjustResize = false;
        this.isWindowNoLimit = false;
        this.hasInit = false;
        this.remoteAdjustResize = null;
        this.isIgnoreWindowFlags = false;
    }

    private void fetchRemoteIMEInsetsConfig() {
        System.currentTimeMillis();
        List<ActivitySoftInputOverrideConfig.Item> r0 = ((ActivitySoftInputOverrideConfig) SettingManager.getInstance().get(ActivitySoftInputOverrideConfig.class)).getItems();
        if (r0 == null) goto L10;
        Iterator<ActivitySoftInputOverrideConfig.Item> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ActivitySoftInputOverrideConfig.Item r2 = r1.next();
        if (getClass().getName().equals(r2.getActivity()) == false) goto L6;
        this.remoteAdjustResize = Boolean.valueOf(Objects.equals(r2.getSoftInputMode(), SOFT_INPUT_ADJUST_RESIZE));
        this.isIgnoreWindowFlags = r2.isIgnoreWindowFlags();
    L10:
        System.currentTimeMillis();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void considerResetConsumeIME() {
        h r0 = WindowInsetsUtils.c(this);
        Boolean r1 = this.remoteAdjustResize;
        if (r1 == null) goto L5;
        boolean r2 = r1.booleanValue();
    L7:
        if (this.isIgnoreWindowFlags == false) goto L9;
        r0.f(r2);
        return;
    L9:
        if (r2 == true) goto L11;
    L17:
        boolean r3 = false;
    L18:
        r0.f(r3);
        return;
    L11:
        if (this.isSystemUIFullscreen == true) goto L17;
        if (this.isSystemUIHideNavigation == true) goto L17;
        if (this.isWindowNoLimit == true) goto L17;
        r3 = true;
        goto L18
    L5:
        r2 = this.isSoftInputAdjustResize;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setupWindowInsets() {
        fetchRemoteIMEInsetsConfig();
        Window r0 = getWindow();
        List<d.a> r1 = d.a;
        Intrinsics.checkNotNullParameter(this, "activity");
        Intrinsics.checkNotNullParameter(r0, "window");
        Intrinsics.checkNotNullParameter(TAG, "tag");
        final View r2 = r0.getDecorView();     // Catch: Throwable -> L9
        if (c.e == false) goto L20;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L9
        Thread r3 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L9
        if (r3 == c.a) goto L20;
        c.a(r3, "getDecorView");     // Catch: Throwable -> L9
    L20:
        if (r2 != null) goto L22;
        return;
    L22:
        int r4 = r2.getSystemUiVisibility();
        boolean r5 = false;
        if ((r4 & 1024) == 0) goto L25;
        boolean r6 = true;
    L26:
        this.isSystemUIFullscreen = r6;
        if ((r4 & 512) == 0) goto L29;
        boolean r7 = true;
    L30:
        this.isSystemUIHideNavigation = r7;
        if ((r0.getAttributes().flags & 512) == 0) goto L33;
        boolean r8 = true;
    L34:
        this.isWindowNoLimit = r8;
        if ((r0.getAttributes().softInputMode & 240) != 16) goto L37;
        r5 = true;
    L37:
        this.isSoftInputAdjustResize = r5;
        final h r9 = WindowInsetsUtils.c(this);
        if (Build.VERSION.SDK_INT < 26) goto L40;
        r9.r(true);
    L40:
        r9.o(true);
        r9.c(true);
        r9.k(true);
        initDefaultStatusBarColor();
        initDefaultNavBarColor();
        considerResetConsumeIME();
        this.globalLayoutListener = new e(this, r2, r9);
        if (this.isIgnoreWindowFlags == true) goto L43;
        r2.getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
    L43:
        this.hasInit = true;
        return;
    L33:
        r8 = false;
        goto L34
    L29:
        r7 = false;
        goto L30
    L25:
        r6 = false;
    L9:
        th = move-exception;
        Iterator<T> r10 = d.a.iterator();
    L12:
        if (r10.hasNext() == false) goto L16;
        Object r11 = r10.next();
        if (((d.a) r11).b(th) == false) goto L12;
    L17:
        d.a r12 = (d.a) r11;
        if (r12 == null) goto L45;
        r12.a(this, th);
        r2 = null;
        goto L20
    L45:
        throw th;
    L16:
        r11 = null;
        goto L17
    }

    public static View INVOKEVIRTUAL_com_larksuite_component_air_WindowInsetsCompatAirActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_larksuite_component_air_WindowInsetsCompatAirActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(WindowInsetsCompatAirActivity r11) {
        r11.com_larksuite_component_air_WindowInsetsCompatAirActivity__finish$___twin___();
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

    public static void com_larksuite_component_air_WindowInsetsCompatAirActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(WindowInsetsCompatAirActivity r3) {
        if ((r3 instanceof FragmentActivity) == true) goto L5;
    L7:
        r3.com_larksuite_component_air_WindowInsetsCompatAirActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r3) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r3);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r3.getClass().getName()));
        goto L7
    }

    public void com_larksuite_component_air_WindowInsetsCompatAirActivity__onCreate$___twin___(Bundle r1) {
        setupWindowInsets();
        super.onCreate(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onWindowAttributesChanged(WindowManager.LayoutParams r5) {
        super/*android.app.Activity*/.onWindowAttributesChanged(r5);
        if (this.isIgnoreWindowFlags == false) goto L5;
        return;
    L5:
        boolean r1 = false;
        if ((r5.flags & 512) == 0) goto L8;
        boolean r0 = true;
    L10:
        if ((r5.softInputMode & 240) != 16) goto L13;
        r1 = true;
    L13:
        if (this.hasInit == true) goto L15;
        return;
    L15:
        if (r1 == this.isSoftInputAdjustResize) goto L17;
    L18:
        this.isSoftInputAdjustResize = r1;
        this.isWindowNoLimit = r0;
        if (((com.ss.android.lark.insets.c) WindowInsetsUtils.c(this)).g == false) goto L24;
        considerResetConsumeIME();
        return;
    L24:
        return;
    L17:
        if (r0 != this.isWindowNoLimit) goto L18;
        return;
    L8:
        r0 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_larksuite_component_air_WindowInsetsCompatAirActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(WindowInsetsCompatAirActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(r1) == false) goto L8;
        v19.f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_larksuite_component_air_WindowInsetsCompatAirActivity__onCreate$___twin___(r2);
    }

    private /* synthetic */ void lambda$setupWindowInsets$0(View r4, f r5) {
        int r6 = r4.getSystemUiVisibility();
        boolean r1 = true;
        if ((r6 & 1024) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r6 & 512) != 0) goto L11;
        r1 = false;
    L11:
        if (this.hasInit == true) goto L13;
        return;
    L13:
        if (r0 == this.isSystemUIFullscreen) goto L15;
    L16:
        this.isSystemUIFullscreen = r0;
        this.isSystemUIHideNavigation = r1;
        if (r5.m() == false) goto L22;
        considerResetConsumeIME();
        return;
    L22:
        return;
    L15:
        if (r1 != this.isSystemUIHideNavigation) goto L16;
        return;
    L5:
        r0 = false;
        goto L7
    }
}
