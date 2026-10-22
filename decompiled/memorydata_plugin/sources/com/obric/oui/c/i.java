package com.obric.oui.c;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0002¢\u0006\u0002\u0010\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004\u001a\u0012\u0010\t\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004\u001a\u0012\u0010\u000b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004\u001a\u001a\u0010\r\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004\u001a\u0012\u0010\u000f\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004¨\u0006\u0010"}, d2 = {"isDarkMode", "", "Landroid/view/View;", "parseBgColor", "", "(Landroid/view/View;)Ljava/lang/Integer;", "setHeight", "", "height", "setHorizontalMargin", "margin", "setMarginBottom", "marginBottom", "setSize", "width", "setWidth", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class i {
    public static final void a(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.getLayoutParams().width = r2;
        r1.requestLayout();
    }

    public static final boolean a(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Integer b(View r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4.getBackground(), ColorDrawable.class) == false) goto L7;
        Drawable r5 = r4.getBackground();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
        return Integer.valueOf(((ColorDrawable) ZeusTransformUtils.preCheckCast(r5, ColorDrawable.class, "com.obric.memorydata.plugin")).getColor());
    L7:
        if (ZeusTransformUtils.instanceOf(r4.getBackground(), GradientDrawable.class) == true) goto L9;
        return null;
    L9:
        if (Build.VERSION.SDK_INT < 24) goto L15;
        Drawable r6 = r4.getBackground();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ColorStateList r7 = ((GradientDrawable) ZeusTransformUtils.preCheckCast(r6, GradientDrawable.class, "com.obric.memorydata.plugin")).getColor();
        if (r7 != null) goto L17;
        return null;
    L17:
        return Integer.valueOf(r7.getDefaultColor());
    L15:
        return (Integer) ZeusTransformUtils.preCheckCast(null, Integer.class, "com.obric.memorydata.plugin");
    }

    public static final void b(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.getLayoutParams().height = r2;
        r1.requestLayout();
    }

    public static final void c(View r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        ViewGroup.LayoutParams r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L25;
        ViewGroup.LayoutParams r3 = r7.getLayoutParams();
        int r5 = 0;
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L11;
        int r4 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"));
    L12:
        ViewGroup.LayoutParams r6 = r7.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.MarginLayoutParams.class) == false) goto L16;
        r2 = r6;
    L16:
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L19;
        int r10 = r9.topMargin;
    L20:
        ViewGroup.LayoutParams r11 = r7.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r11, ViewGroup.MarginLayoutParams.class) == false) goto L23;
        r5 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"));
    L23:
        r1.setMargins(r4, r10, r5, r8);
        r7.requestLayout();
        return;
    L19:
        r10 = 0;
        goto L20
    L11:
        r4 = 0;
        goto L12
    L25:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
