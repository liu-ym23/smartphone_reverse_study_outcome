package com.obric.oui.toast;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.n;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ym.h;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/oui/toast/ToastBackgroundView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getCornerRadius", "()I", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ToastBackgroundView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f14879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14880c;
    public final Paint d;
    public boolean e;
    public final boolean f;

    @JvmOverloads
    public ToastBackgroundView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static void a(ToastBackgroundView r5, int r10) {
        boolean r11 = r5.f;
        int r12 = r5.f14878a;
        if (r11 == false) goto L10;
        r5.e = false;
        GradientDrawable r13 = new GradientDrawable();
        r13.setShape(0);
        r13.setCornerRadius(r12);
        r13.setColor(0);
        r5.setBackground(r13);
        r5.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        Function1<Boolean, com.obric.oui.material.c[]> r14 = MaterialToken.OUI_Bg_Popup;
        int r15 = r5.f14880c;
        if (r15 != 0) goto L7;
        boolean r16 = a.a.v(r5);
    L8:
        a.a.y(r5, r14.invoke(Boolean.valueOf(!r16)), false, 3, 10);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        n.r(null, r5);
        return;
    L7:
        r16 = h.j(r15);
        goto L8
    L10:
        if (r10 != (r12 * 2)) goto L12;
        r5.setBackground(ResourcesCompat.getDrawable(r5.getResources(), R$drawable.o_toast_background_capsule_form, r5.getContext().getTheme()));
        r5.e = false;
    L13:
        ps.a.a("ToastBackgroundView", "setupBackground: drawSelf = " + r5.e + ", height = " + r10);
        r5.invalidate();
        return;
    L12:
        r5.e = true;
        goto L13
    }

    public final int getCornerRadius() {
        return this.f14878a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        float r5 = this.f14878a * 1.0f;
        RectF r11 = this.f14879b;
        r11.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (this.e == false) goto L5;
        r10.drawRoundRect(r11, r5, r5, this.d);
    L5:
        super.onDraw(r10);
    }

    @JvmOverloads
    public final void setupBackground(int r5) {
        a(this, r5);
    }

    @JvmOverloads
    public ToastBackgroundView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ ToastBackgroundView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public ToastBackgroundView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f14878a = com.lynx.tasm.utils.a.A(24.0f, this);
        this.f14879b = new RectF();
        boolean r12 = true;
        Paint r13 = new Paint(1);
        r13.setStyle(Paint.Style.FILL);
        this.d = r13;
        new Paint(1).setStyle(Paint.Style.STROKE);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (n.i(r5) == true) goto L5;
    L7:
        r12 = false;
    L8:
        this.f = r12;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if ((getBackground() instanceof ColorDrawable) == false) goto L16;
        Drawable r14 = getBackground();
        if (r14 == null) goto L14;
        Integer r15 = Integer.valueOf(((ColorDrawable) r14).getColor());
    L26:
        setBackgroundColor(0);
        if (r15 != null) goto L29;
        int r16 = ResourcesCompat.getColor(getResources(), R$color.oui_toast_background, getContext().getTheme());
        if (r13.getColor() == r16) goto L37;
        r13.setColor(r16);
        this.f14880c = r16;
        ps.a.a("ToastBackgroundView", Intrinsics.stringPlus("resolveColors: bg=", Integer.valueOf(r16)));
        return;
    L37:
        return;
    L29:
        if (r13.getColor() == r15.intValue()) goto L35;
        r13.setColor(r15.intValue());
        this.f14880c = r15.intValue();
        ps.a.a("ToastBackgroundView", "resolveColors: bg=" + r15 + " from originBgColor");
        return;
    L35:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L16:
        if ((getBackground() instanceof GradientDrawable) == false) goto L25;
        Drawable r17 = getBackground();
        if (r17 == null) goto L24;
        ColorStateList r18 = ((GradientDrawable) r17).getColor();
        if (r18 == null) goto L25;
        r15 = Integer.valueOf(r18.getDefaultColor());
        goto L26
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L25:
        r15 = null;
        goto L26
    L5:
        if (n.k() == false) goto L7;
        goto L7
    }
}
