package com.obric.memorydata.ui;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\t¨\u0006\r"}, d2 = {"applyNavigationBarScheme", "", "Landroid/view/Window;", "scheme", "Lcom/obric/memorydata/ui/NavigationBarScheme;", "applyNavigationBarIconAppearance", "useDarkIcons", "", "applyNavigationBarBottomPadding", "Landroid/view/View;", "additionalBottomDp", "", "applyNavigationBarBottomMargin", "ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class g {
    private static final WindowInsetsCompat a(int r4, int r5, View r6, WindowInsetsCompat r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "insets");
        int r0 = r7.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        r6.setPadding(r6.getPaddingLeft(), r6.getPaddingTop(), r6.getPaddingRight(), (r4 + r0) + r5);
        return r7;
    }

    private static final WindowInsetsCompat a(int r6, View r7, WindowInsetsCompat r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "insets");
        WindowInsetsCompat r0 = ViewCompat.getRootWindowInsets(r7);
        boolean r1 = true;
        ViewGroup.MarginLayoutParams r3 = null;
        if (r0 == null) goto L15;
        Insets r2 = r0.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r2 == null) goto L15;
        Integer r4 = Integer.valueOf(r2.bottom);
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L15;
    L23:
        int r9 = r4.intValue();
    L25:
        ViewGroup.LayoutParams r10 = r7.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r10, ViewGroup.MarginLayoutParams.class) == false) goto L28;
        r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L28:
        if (r3 != null) goto L30;
        return r8;
    L30:
        int r11 = r6 + r9;
        if (r3.bottomMargin == r11) goto L33;
        r3.bottomMargin = r11;
        r7.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    L33:
        return r8;
    L9:
        r5 = false;
    L15:
        r4 = Integer.valueOf(r8.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom);
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue() > 0) goto L19;
        r1 = false;
    L19:
        if (r1 == true) goto L22;
        r4 = null;
    L22:
        if (r4 != null) goto L23;
        r9 = BaseActivity.Companion.b();
        goto L25
    }

    public static final void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L9;
        final int r2 = r1.bottomMargin;
        ViewCompat.setOnApplyWindowInsetsListener(r3, new $$Lambda$g$A5ZUkbKbtcfojvgBIKhDIeCpa0(r2));
        ViewCompat.requestApplyInsets(r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final void a(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        final int r0 = r3.getPaddingBottom();
        final int r5 = MathKt.roundToInt(r4 * ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getDisplayMetrics().density);
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L5;
        ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L8;
        r1.setClipToPadding(false);
    L8:
        ViewCompat.setOnApplyWindowInsetsListener(r3, new $$Lambda$g$4Tw8X3dy_YkgaVZt8t3BB47U88(r0, r5));
        ViewCompat.requestApplyInsets(r3);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static /* synthetic */ void a(View r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 16;
    L5:
        a(r0, r1);
    }

    public static final void a(Window r2, NavigationBarScheme r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "scheme");
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        r2.setNavigationBarColor(0);
        return;
    L5:
        if (r2.isNavigationBarContrastEnforced() == r3.getContrastEnforced()) goto L9;
        r2.setNavigationBarContrastEnforced(r3.getContrastEnforced());
        return;
    }

    public static final void a(Window r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (Build.VERSION.SDK_INT < 30) goto L11;
        WindowInsetsController r5 = r3.getInsetsController();
        if (r5 == null) goto L18;
        if (r4 == false) goto L8;
        int r6 = 16;
    L9:
        r5.setSystemBarsAppearance(r6, 16);
        return;
    L8:
        r6 = 0;
        goto L9
    L18:
        return;
    L11:
        if (Build.VERSION.SDK_INT < 26) goto L20;
        View r0 = r3.getDecorView();
        int r7 = r3.getDecorView().getSystemUiVisibility();
        if (r4 == false) goto L15;
        int r8 = r7 | 16;
    L16:
        r0.setSystemUiVisibility(r8);
        return;
    L15:
        r8 = r7 & (-17);
        goto L16
    }

    /* JADX INFO: renamed from: lambda$4Tw8X3dy_YkgaV-Zt8t3BB47U88, reason: not valid java name */
    public static /* synthetic */ WindowInsetsCompat m1216lambda$4Tw8X3dy_YkgaVZt8t3BB47U88(int r0, int r1, View r2, WindowInsetsCompat r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$A5ZU-kbKbtcfojvgBIKhDIeCpa0, reason: not valid java name */
    public static /* synthetic */ WindowInsetsCompat m1217lambda$A5ZUkbKbtcfojvgBIKhDIeCpa0(int r0, View r1, WindowInsetsCompat r2) {
        return a(r0, r1, r2);
    }
}
