package com.obric.feature.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import bq.b;
import com.google.android.material.internal.ViewUtils;
import com.obric.common.oui.R$color;
import com.obric.flow.cardlistpage.R$styleable;
import com.obric.oui.common.style.a;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ\u0017\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u000fJ\u0017\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u000fJ\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\u000fJ\u0017\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/obric/feature/view/ORelativeLayout;", "Landroid/widget/RelativeLayout;", "Lcom/obric/oui/common/style/a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "pressed", "", "setPressed", "(Z)V", "enabled", "setEnabled", "selected", "setSelected", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "color", "setOverridePressColor", "(I)V", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class ORelativeLayout extends RelativeLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f11431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11432b;

    @JvmOverloads
    public ORelativeLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    @Override // com.obric.oui.common.style.a
    public final void h(View r5, boolean r10) {
        b r11 = this.f11431a;
        if (r11 == null) goto L6;
        r11.h(r5, r10);
        return;
    }

    @Override // com.obric.oui.common.style.a
    public final void i(String r5) {
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r5) {
        b r10 = this.f11431a;
        if (r10 == null) goto L6;
        r10.setChangeAlphaWhenDisable(r5);
        return;
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r5) {
        b r10 = this.f11431a;
        if (r10 == null) goto L6;
        r10.setChangeAlphaWhenPress(r5);
        return;
    }

    public void setChangeAlphaWhenSelected(boolean r5) {
        b r10 = this.f11431a;
        if (r10 == null) goto L6;
        r10.d = r5;
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        b r10 = this.f11431a;
        if (r10 == null) goto L6;
        r10.b(this, r5);
        return;
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(boolean r5) {
    }

    public void setOverridePressColor(int r5) {
    }

    @Override // android.view.View
    public void setPressed(boolean r5) {
        super.setPressed(r5);
        b r10 = this.f11431a;
        if (r10 != null) goto L5;
        return;
    L5:
        if (((View) r10.f971a.get()) == null) goto L16;
        r10.f974h.cancel();
        r10.f975i.cancel();
        if (r10.f972b == false) goto L14;
        if (r5 == false) goto L11;
        r10.a();
        r10.f974h.start();
        return;
    L11:
        r10.f975i.start();
        return;
    L14:
        return;
    }

    @Override // android.view.View
    public void setSelected(boolean r5) {
        super.setSelected(r5);
        b r10 = this.f11431a;
        if (r10 == null) goto L6;
        r10.h(this, r5);
        return;
    }

    @JvmOverloads
    public ORelativeLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ ORelativeLayout(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public ORelativeLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        b r5 = new b();
        boolean r13 = true;
        r5.f972b = true;
        r5.f973c = true;
        r5.d = false;
        r5.e = 0;
        r5.f = 0.3f;
        r5.f976j = 0.0f;
        this.f11431a = r5;
        this.f11432b = 16;
        if (r11 == null) goto L6;
        TypedArray r14 = getContext().obtainStyledAttributes(r11, R$styleable.PressedContainer);
        this.f11432b = (int) r14.getDimension(R$styleable.PressedContainer_radius, 2.0f);
        r14.recycle();
    L6:
        int r15 = this.f11432b;
        r5.f971a = new WeakReference(this);
        int r16 = ContextCompat.getColor(getContext(), R$color.oui_fill_element_2);
        int[] r17 = {ContextCompat.getColor(getContext(), R$color.oui_accent_bg), ContextCompat.getColor(getContext(), R$color.oui_functional_red_6)};
        r5.e = r16;
        TypedArray r18 = r10.obtainStyledAttributes(r11, com.obric.common.oui.R$styleable.OUIAlpha, r12, 0);
        if (r11 != null) goto L10;
        if (r12 != 0) goto L10;
    L19:
        r5.f976j = ViewUtils.dpToPx(getContext(), r15);
        if (r5.e != r16) goto L30;
        Drawable r19 = getBackground();
        if ((r19 instanceof ColorDrawable) == false) goto L30;
        int r110 = 0;
    L25:
        if (r110 >= 2) goto L30;
        if (((ColorDrawable) r19).getColor() != r17[r110]) goto L29;
        r5.e = ContextCompat.getColor(getContext(), R$color.oui_pressed_on_color);
    L29:
        r110 = r110 + 1;
    L30:
        GradientDrawable r111 = new GradientDrawable();
        r5.g = r111;
        r111.setColor(r5.e);
        r5.g.setCornerRadius(r5.f976j);
        r5.g.setAlpha(0);
        if (r5.e <= 0) goto L33;
        boolean r112 = true;
    L34:
        r5.f972b = r112;
        if (r5.f > 0.0f) goto L38;
        r13 = false;
    L38:
        r5.f973c = r13;
        r5.b(this, isEnabled());
        ObjectAnimator r20 = ObjectAnimator.ofInt(r5.g, "alpha", new int[]{0, 255});
        r5.f974h = r20;
        r20.setDuration(200);
        r5.f974h.setInterpolator(new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f));
        ObjectAnimator r21 = ObjectAnimator.ofInt(r5.g, "alpha", new int[]{255, 0});
        r5.f975i = r21;
        r21.setDuration(300);
        r5.f975i.setInterpolator(new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f));
        r5.f975i.addListener(new bq.a(r5, 0));
        return;
    L33:
        r112 = false;
    L10:
        int r113 = r18.getIndexCount();
        int r114 = 0;
    L11:
        if (r114 >= r113) goto L19;
        int r22 = r18.getIndex(r114);
        if (r22 != com.obric.common.oui.R$styleable.OUIAlpha_OUI_alpha_pressed) goto L16;
        r5.e = r18.getColor(r22, r16);
    L18:
        r114 = r114 + 1;
        goto L11
    L16:
        if (r22 != com.obric.common.oui.R$styleable.OUIAlpha_OUI_alpha_disabled) goto L18;
        r5.f = r18.getFloat(r22, -1.0f);
        goto L18
    }
}
