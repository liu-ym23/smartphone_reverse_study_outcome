package com.obric.oui.window.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\rJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\u000fJ\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/window/calculator/WindowSizeCalculator;", "", "()V", "TAG", "", "computeCurrentWindowMetrics", "Lcom/obric/oui/window/model/WindowMetrics;", "activity", "Landroid/app/Activity;", "computeWindowBoundsN", "Landroid/graphics/Rect;", "computeWindowBoundsN$OUI_standardRelease", "computeWindowBoundsP", "computeWindowBoundsP$OUI_standardRelease", "computeWindowBoundsQ", "computeWindowBoundsQ$OUI_standardRelease", "computeWindowBoundsUnderN", "getCutoutForDisplay", "Landroid/view/DisplayCutout;", "display", "Landroid/view/Display;", "getNavigationBarHeight", "", "context", "Landroid/content/Context;", "getRealSizeForDisplay", "Landroid/graphics/Point;", "getRectSizeFromDisplay", "", "bounds", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f14884a = null;

    static {
        f14884a = new e();
    }

    private e() {
    }

    private final int a(Context r4) {
        Resources r3 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        int r5 = ZeusTransformUtils.getIdentifier(r3, "navigation_bar_height", "dimen", "android", "com.obric.memorydata.plugin");
        if (r5 > 0) goto L7;
        return 0;
    L7:
        return r3.getDimensionPixelSize(r5);
    }

    private final Point a(Display r2) {
        Point r1 = new Point();
        c.f14882a.a(r2, r1);
        return r1;
    }

    private final void a(Activity r2, Rect r3) {
        ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).getWindowManager().getDefaultDisplay().getRectSize(r3);
    }

    private final DisplayCutout b(Display r9) {
        Constructor r1 = ZeusTransformUtils.forName("android.view.DisplayInfo", "com.obric.memorydata.plugin").getConstructor(new Class[0]);     // Catch: Throwable -> L7
        r1.setAccessible(true);     // Catch: Throwable -> L7
        Object r2 = r1.newInstance(new Object[0]);     // Catch: Throwable -> L7
        Method r4 = r9.getClass().getDeclaredMethod("getDisplayInfo", new Class[]{r2.getClass()});     // Catch: Throwable -> L7
        r4.setAccessible(true);     // Catch: Throwable -> L7
        r4.invoke(r9, new Object[]{r2});     // Catch: Throwable -> L7
        Field r10 = r2.getClass().getDeclaredField("displayCutout");     // Catch: Throwable -> L7
        r10.setAccessible(true);     // Catch: Throwable -> L7
        Object r11 = r10.get(r2);     // Catch: Throwable -> L7
        if (ZeusTransformUtils.instanceOf(r11, DisplayCutout.class) == false) goto L9;
        return (DisplayCutout) ZeusTransformUtils.preCheckCast(r11, DisplayCutout.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    L7:
        e = move-exception;
        Log.w("WindowSizeCalculator", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L9
    }

    private final Rect e(Activity r3) {
        Display r4 = ((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin")).getWindowManager().getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(r4, "defaultDisplay");
        Point r2 = a(r4);
        Rect r0 = new Rect();
        if (r2.x != 0) goto L5;
    L8:
        r4.getRectSize(r0);
    L9:
        return r0;
    L5:
        if (r2.y == 0) goto L8;
        r0.right = r2.x;
        r0.bottom = r2.y;
        goto L9
    }

    public final com.obric.oui.window.d.c a(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "activity");
        if (Build.VERSION.SDK_INT < 30) goto L6;
        Rect r2 = b.f14881a.a(r4);
    L16:
        return new com.obric.oui.window.d.c(r2);
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        r2 = b(r4);
        goto L16
    L9:
        if (Build.VERSION.SDK_INT < 28) goto L12;
        r2 = c(r4);
        goto L16
    L12:
        if (Build.VERSION.SDK_INT < 24) goto L14;
        r2 = d(r4);
        goto L16
    L14:
        r2 = e(r4);
        goto L16
    }

    public final Rect b(Activity r8) {
        Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "activity");
        Configuration r1 = ZeusTransformUtils.getResources(r9, "com.obric.memorydata.plugin").getConfiguration();
        Field r3 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: Throwable -> L8
        r3.setAccessible(true);     // Catch: Throwable -> L8
        Object r2 = r3.get(r1);     // Catch: Throwable -> L8
        Object r4 = r2.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r2, new Object[0]);     // Catch: Throwable -> L8
        if (r4 == null) goto L7;
        return new Rect((Rect) ZeusTransformUtils.preCheckCast(r4, Rect.class, "com.obric.memorydata.plugin"));
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: Throwable -> L8
    L8:
        e = move-exception;
        Log.w("WindowSizeCalculator", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return c(r9);
    }

    public final Rect c(Activity r10) {
        Activity r11 = (Activity) ZeusTransformUtils.wrapperContextForParams(r10, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "activity");
        Rect r1 = new Rect();
        Configuration r3 = ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getConfiguration();
        Field r5 = Configuration.class.getDeclaredField("windowConfiguration");     // Catch: Throwable -> L17
        r5.setAccessible(true);     // Catch: Throwable -> L17
        Object r4 = r5.get(r3);     // Catch: Throwable -> L17
        if (a.f14880a.a(r11) == false) goto L12;
        Object r6 = r4.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(r4, new Object[0]);     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17
        if (r6 == null) goto L11;
        Rect r7 = (Rect) ZeusTransformUtils.preCheckCast(r6, Rect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17
    L9:
        r1.set(r7);     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17
    L19:
        Display r0 = r11.getWindowManager().getDefaultDisplay();
        Point r8 = new Point();
        c r9 = c.f14882a;
        Intrinsics.checkNotNullExpressionValue(r0, "currentDisplay");
        r9.a(r0, r8);
        if (a.f14880a.a(r11) == true) goto L31;
        int r2 = a((Context) ZeusTransformUtils.preCheckCast(r11, Context.class, "com.obric.memorydata.plugin"));
        if ((r1.bottom + r2) != r8.y) goto L25;
        r1.bottom += r2;
        goto L31
    L25:
        if ((r1.right + r2) != r8.x) goto L28;
        r1.right += r2;
        goto L31
    L28:
        if (r1.left != r2) goto L31;
        r1.left = 0;
    L31:
        if (r1.width() < r8.x) goto L35;
        if (r1.height() < r8.y) goto L35;
    L50:
        return r1;
    L35:
        if (a.f14880a.a(r11) == true) goto L50;
        DisplayCutout r12 = b(r0);
        if (r12 == null) goto L50;
        if (r1.left != d.f14883a.a(r12)) goto L42;
        r1.left = 0;
    L42:
        if ((r8.x - r1.right) != d.f14883a.c(r12)) goto L45;
        r1.right += d.f14883a.c(r12);
    L45:
        if (r1.top != d.f14883a.b(r12)) goto L48;
        r1.top = 0;
    L48:
        if ((r8.y - r1.bottom) != d.f14883a.d(r12)) goto L50;
        r1.bottom += d.f14883a.d(r12);
        goto L50
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17
    L12:
        Object r13 = r4.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(r4, new Object[0]);     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17
        if (r13 == null) goto L16;
        r7 = (Rect) ZeusTransformUtils.preCheckCast(r13, Rect.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17
        goto L9
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: Throwable -> L17 Throwable -> L17 Throwable -> L17 Throwable -> L17
    L17:
        e = move-exception;
        Log.w("WindowSizeCalculator", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        a(r11, r1);
        goto L19
    }

    public final Rect d(Activity r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "activity");
        Rect r0 = new Rect();
        Display r2 = r6.getWindowManager().getDefaultDisplay();
        r2.getRectSize(r0);
        if (a.f14880a.a(r6) == true) goto L10;
        Intrinsics.checkNotNullExpressionValue(r2, "defaultDisplay");
        Point r3 = a(r2);
        int r4 = a((Context) ZeusTransformUtils.preCheckCast(r6, Context.class, "com.obric.memorydata.plugin"));
        if ((r0.bottom + r4) != r3.y) goto L8;
        r0.bottom += r4;
        goto L10
    L8:
        if ((r0.right + r4) != r3.x) goto L10;
        r0.right += r4;
    L10:
        return r0;
    }
}
