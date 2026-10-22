package com.obric.oui.window;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.Size;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.oui.common.util.h;
import com.obric.oui.view.b;
import com.obric.oui.view.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\fH\u0007J)\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010 \u001a\u00020!2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0007J!\u0010&\u001a\u00020\u001f2\b\u0010'\u001a\u0004\u0018\u00010\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u001f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0006\u0010*\u001a\u00020\u001fJ\u0012\u0010+\u001a\u00020\u001f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u001c\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020%2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100H\u0007J&\u00101\u001a\u0002022\u0006\u0010.\u001a\u00020%2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\u0004H\u0007J\u0010\u00104\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u00105\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0006\u00106\u001a\u00020\u0004J\b\u00107\u001a\u00020\u0004H\u0007J\u000e\u00107\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u00108\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u00109\u001a\u00020\u0004J\u0012\u0010:\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\u0017H\u0007JC\u0010;\u001a\u00020\r2\u0006\u0010.\u001a\u00020%2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\u00042\u0017\u0010<\u001a\u0013\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\r0=¢\u0006\u0002\b>H\u0086\bø\u0001\u0000J\u001e\u0010?\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u0010\u0010?\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\fH\u0007J&\u0010A\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00172\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u001fJ\u000e\u0010F\u001a\u00020\r2\u0006\u0010G\u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006H"}, d2 = {"Lcom/obric/oui/window/OWindowConfigController;", "", "()V", "mIsInit", "", "Ljava/lang/Boolean;", "addWindowConfigChangeListener", "Landroidx/lifecycle/Observer;", "Lcom/obric/oui/window/bean/WindowSizeWithPageSize;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "callback", "Lcom/obric/oui/window/interfaces/OnWindowConfigChangeListener;", "", "listener", "applyLandscapeCutoutMode", "context", "Landroid/content/Context;", TrackerImpl.PARAMS, "Landroid/view/WindowManager$LayoutParams;", "includeCutoutInLandscape", "(Landroid/content/Context;Landroid/view/WindowManager$LayoutParams;Ljava/lang/Boolean;)V", "getActivity", "Landroid/app/Activity;", "getBaseGridColumnWidth", "", "getCurrentWindowSize", "Lcom/obric/oui/window/bean/AvailableWindowSize;", "getCurrentWindowSizeClass", "Lcom/obric/oui/window/bean/WindowSizeClass;", "getFullScreenHeight", "", "getFullWindowSize", "Landroid/util/Size;", "getGestureNavigationHeight", "getImeHeight", "rootView", "Landroid/view/View;", "getLandscapeCutoutMode", "activity", "(Landroid/app/Activity;Ljava/lang/Boolean;)I", "getNavigationBarHeight", "getScreenModeInInt", "getStatusBarHeight", "getSystemBarInsets", "Landroidx/core/graphics/Insets;", "view", "windowInsets", "Landroid/view/WindowInsets;", "getSystemBarInsetsInfo", "Lcom/obric/oui/view/Insets;", "excludeIme", "isGestureNavigation", "isGestureNavigationApi29", "isHSplit", "isInMultiWindowMode", "isLandscape", "isVSplit", "isWindowConfigInit", "processSystemBarInsets", "process", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "removeWindowConfigChangeListener", "observer", "setWindowConfig", "config", "Landroid/content/res/Configuration;", "currentWidth", "currentHeight", "setWindowConfigInitStatus", "isInit", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14878a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Boolean f14879b;

    static {
        f14878a = new a();
    }

    private a() {
    }

    @JvmStatic
    public static final int a(Activity r2, Boolean r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        if (r4 != null) goto L13;
        return 2;
    L13:
        Window r5 = ZeusTransformUtils.getWindow(r4, "com.obric.memorydata.plugin");
        if (r5 == null) goto L23;
        WindowManager.LayoutParams r6 = r5.getAttributes();
        if (r6 != null) goto L20;
        return 2;
    L20:
        return r6.layoutInDisplayCutoutMode;
    L23:
        return 2;
    L5:
        if (r3.booleanValue() == true) goto L7;
        return 2;
    L7:
        if (Build.VERSION.SDK_INT < 30) goto L9;
        return 3;
    L9:
        return 1;
    }

    @JvmStatic
    public static final int a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return 0;
    L5:
        int r2 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin"), "status_bar_height", "dimen", "android", "com.obric.memorydata.plugin");
        if (r2 > 0) goto L8;
        Class r3 = ZeusTransformUtils.forName("com.android.internal.R$dimen", "com.obric.memorydata.plugin");     // Catch: Exception -> L11
        Object r4 = r3.newInstance();     // Catch: Exception -> L11
        int r5 = Integer.parseInt(r3.getField("status_bar_height").get(r4).toString());     // Catch: Exception -> L11
        return ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getDimensionPixelSize(r5);
    L11:
        return 0;
    L8:
        return ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getDimensionPixelSize(r2);
    }

    @JvmStatic
    public static final b a(View r3, WindowInsets r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        return a(r3, r4, false, 4, null);
    }

    @JvmStatic
    public static final b a(View r3, WindowInsets r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        b r6 = b.f14818a;
        Intrinsics.checkNotNullExpressionValue(r6, "NONE");
        return r6;
    L6:
        if (r4 != null) goto L8;
        r4 = r3.getRootWindowInsets();
    L8:
        if (r4 != null) goto L11;
        b r7 = b.f14818a;
        Intrinsics.checkNotNullExpressionValue(r7, "NONE");
        return r7;
    L11:
        e r8 = e.a(r4);
        if (r5 == false) goto L15;
        b r9 = r8.a(e.m.b());
        Intrinsics.checkNotNullExpressionValue(r9, "toWindowInsetsCompat(ins…Compat.Type.systemBars())");
        return r9;
    L15:
        b r10 = r8.e();
        Intrinsics.checkNotNullExpressionValue(r10, "toWindowInsetsCompat(insets).systemWindowInsets");
        return r10;
    }

    public static /* synthetic */ b a(View r0, WindowInsets r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 4) == 0) goto L9;
        r2 = true;
    L9:
        return a(r0, r1, r2);
    }

    @JvmStatic
    public static final void a(Context r3, WindowManager.LayoutParams r4, Boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, TrackerImpl.PARAMS);
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return;
    L5:
        if (r6 != null) goto L7;
        return;
    L7:
        a r0 = f14878a;
        if (r0.g(r6) == true) goto L10;
        return;
    L10:
        r4.layoutInDisplayCutoutMode = a((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getActivity(r6), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin"), r5);
    }

    @JvmStatic
    public static final Size d(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L5;
        Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(f14878a.getActivity(r6), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
        Object r1 = r6.getSystemService("window");
        Rect r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, WindowManager.class) == false) goto L13;
        WindowManager r2 = (WindowManager) ZeusTransformUtils.preCheckCast(r1, WindowManager.class, "com.obric.memorydata.plugin");
    L15:
        if (Build.VERSION.SDK_INT < 30) goto L22;
        if (r2 == null) goto L23;
        WindowMetrics r4 = r2.getCurrentWindowMetrics();
        if (r4 == null) goto L23;
        r3 = r4.getBounds();
    L23:
        if (r3 == null) goto L27;
        return new Size(r3.width(), r3.height());
    L27:
        return new Size(h.a(r6), h.b(r6));
    L22:
        r3 = (Rect) ZeusTransformUtils.preCheckCast(null, Rect.class, "com.obric.memorydata.plugin");
        goto L23
    L13:
        r2 = null;
        goto L15
    L9:
        return new Size(com.obric.oui.window.a.e.f14884a.a(r0).a().width(), com.obric.oui.window.a.e.f14884a.a(r0).a().height());
    L5:
        return new Size(0, 0);
    }

    @JvmStatic
    public static final boolean e(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Resources r6 = ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin");
        int r0 = ZeusTransformUtils.getIdentifier(r6, "config_navBarInteractionMode", TypedValues.Custom.S_INT, "android", "com.obric.memorydata.plugin");
        if (r0 > 0) goto L5;
        return false;
    L5:
        if (r6.getInteger(r0) != 2) goto L9;
        return true;
    L9:
        return false;
    }

    @JvmStatic
    public static final boolean f(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        if (Build.VERSION.SDK_INT >= 29) goto L7;
        return false;
    L7:
        return e(r3);
    }

    public final int a(View r9) {
        Intrinsics.checkNotNullParameter(r9, "rootView");
        WindowInsetsController r10 = r9.getWindowInsetsController();     // Catch: Exception -> L38
        if (r10 != null) goto L6;
        return 0;
    L6:
        Method r0 = r10.getClass().getDeclaredMethod("getState", new Class[0]);     // Catch: Exception -> L38
        r0.setAccessible(true);     // Catch: Exception -> L38
        Object r11 = r0.invoke(r10, new Object[0]);     // Catch: Exception -> L38
        if (Build.VERSION.SDK_INT < 35) goto L11;
        String r1 = "android.view.InsetsSource";
    L10:
        Class r2 = ZeusTransformUtils.forName(r1, "com.obric.memorydata.plugin");     // Catch: Exception -> L38
        if (Build.VERSION.SDK_INT < 35) goto L16;
        String r3 = "ID_IME";
    L15:
        Field r4 = r2.getDeclaredField(r3);     // Catch: Exception -> L38
        r4.setAccessible(true);     // Catch: Exception -> L38
        Rect r5 = null;
        int r6 = r4.getInt(null);     // Catch: Exception -> L38
        Method r7 = r11.getClass().getDeclaredMethod("peekSource", new Class[]{Integer.TYPE});     // Catch: Exception -> L38
        r7.setAccessible(true);     // Catch: Exception -> L38
        Object r12 = r7.invoke(r11, new Object[]{Integer.valueOf(r6)});     // Catch: Exception -> L38
        if (r12 != null) goto L21;
        r12 = null;
    L21:
        if (r12 != null) goto L23;
        return 0;
    L23:
        Method r8 = r12.getClass().getDeclaredMethod("isVisible", new Class[0]);     // Catch: Exception -> L38
        r8.setAccessible(true);     // Catch: Exception -> L38
        Object r13 = r8.invoke(r12, new Object[0]);     // Catch: Exception -> L38
        if (ZeusTransformUtils.instanceOf(r13, Boolean.class) == false) goto L26;
        Boolean r14 = (Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L38
    L27:
        if (r14 != null) goto L30;
        return 0;
    L30:
        if (r14.booleanValue() == false) goto L40;
        Method r15 = r12.getClass().getDeclaredMethod("getFrame", new Class[0]);     // Catch: Exception -> L38
        r15.setAccessible(true);     // Catch: Exception -> L38
        Object r16 = r15.invoke(r12, new Object[0]);     // Catch: Exception -> L38
        if (ZeusTransformUtils.instanceOf(r16, Rect.class) == false) goto L34;
        r5 = (Rect) ZeusTransformUtils.preCheckCast(r16, Rect.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L38
    L34:
        if (r5 != null) goto L36;
        return 0;
    L36:
        return r5.height();
    L40:
        return 0;
    L26:
        r14 = null;
        goto L27
    L16:
        r3 = "ITYPE_IME";
        goto L15
    L11:
        r1 = "android.view.InsetsState";
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    }

    public final void a(boolean r1) {
        f14879b = Boolean.valueOf(r1);
    }

    public final int b(Context r6) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r1 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin"), "navigation_bar_height", "dimen", "android", "com.obric.memorydata.plugin");
        if (r1 > 0) goto L8;
        Class r2 = ZeusTransformUtils.forName("com.android.internal.R$dimen", "com.obric.memorydata.plugin");     // Catch: Exception -> L11
        Object r3 = r2.newInstance();     // Catch: Exception -> L11
        int r4 = Integer.parseInt(r2.getField("navigation_bar_height").get(r3).toString());     // Catch: Exception -> L11
        return ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getDimensionPixelSize(r4);
    L11:
        return 0;
    L8:
        return ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getDimensionPixelSize(r1);
    }

    public final boolean c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(r4), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L8;
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.isInMultiWindowMode();
    L8:
        return false;
    }

    public final boolean g(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        if (ZeusTransformUtils.getResources(r2, "com.obric.memorydata.plugin").getConfiguration().orientation == 2) goto L13;
        return false;
    L13:
        return true;
    L7:
        e = move-exception;
        com.obric.oui.c.a.b.a("OWindowConfigController", "isLandscape error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    public final Activity getActivity(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        if (ZeusTransformUtils.instanceOf(r4, Activity.class) == false) goto L8;
        Object r2 = ZeusTransformUtils.preCheckCast(r4, Activity.class, "com.obric.memorydata.plugin");
    L6:
        return (Activity) r2;
    L8:
        if (ZeusTransformUtils.instanceOf(r4, ContextWrapper.class) == false) goto L10;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r4, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "context.baseContext");
        r2 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(r5), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        goto L6
    L10:
        return null;
    }
}
