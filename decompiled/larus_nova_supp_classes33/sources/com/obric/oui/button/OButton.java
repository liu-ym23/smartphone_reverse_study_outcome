package com.obric.oui.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import com.obric.oui.common.style.b;
import com.obric.oui.common.style.h;
import com.obric.oui.common.style.j;
import com.obric.oui.common.style.l;
import com.obric.oui.common.style.o;
import com.obric.oui.common.style.q;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001YJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0011\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J-\u0010\u0018\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00170\u0014H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\u001f\u001a\u00020\u00072\b\b\u0001\u0010\u001e\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0011H\u0096\u0001J\u0011\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010&\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010'\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010,\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u001aH\u0096\u0001J\u0011\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0011H\u0096\u0001J\u0011\u00101\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0011H\u0096\u0001J\u0011\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0011H\u0096\u0001J\u0013\u00105\u001a\u00020\u00072\b\b\u0001\u00104\u001a\u00020\u0011H\u0096\u0001J\u0011\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0005H\u0096\u0001J\u0011\u00108\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010:\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0011H\u0096\u0001J\t\u0010;\u001a\u00020\u0002H\u0096\u0001J\t\u0010=\u001a\u00020<H\u0096\u0001J\t\u0010>\u001a\u00020\u0003H\u0096\u0001J\u000e\u0010@\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0011J\u0010\u0010B\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0005H\u0016J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0005H\u0016J\u0010\u0010E\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010G\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u001aJ\u0010\u0010H\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R.\u0010Q\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010I8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR*\u0010X\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006Z"}, d2 = {"Lcom/obric/oui/button/OButton;", "Landroid/widget/Button;", "Lcom/obric/oui/common/style/a;", "Lcom/obric/oui/common/style/b;", "", "", "pressed", "", "setPressState", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "", "color", "setOverridePressColor", "", "Lcom/obric/oui/common/style/q;", "kotlin.jvm.PlatformType", "", "getCurrentShadows", "getRadius", "", "getShadowAlpha", "getShadowColor", "getShadowElevation", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "enableShadowWidthRadius", "setEnableShadowWidthRadius", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "minWidth", "setWidthMin", "getAlphaHelper", "Lcom/obric/oui/common/style/j;", "getEffectHelper", "getLayoutHelper", "resId", "setButtonSourceBitmap", "selected", "setSelected", "enabled", "setEnabled", "setPressed", "alpha", "setDisabledTextAlpha", "setTextColor", "Landroid/graphics/drawable/Drawable;", "value", "f", "Landroid/graphics/drawable/Drawable;", "getMIcon", "()Landroid/graphics/drawable/Drawable;", "setMIcon", "(Landroid/graphics/drawable/Drawable;)V", "mIcon", "h", "I", "getMImageTintColorId", "()I", "setMImageTintColorId", "(I)V", "mImageTintColorId", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OButton extends Button implements com.obric.oui.common.style.a, b {
    public static final /* synthetic */ int p = 0;
    public final /* synthetic */ h a;
    public final /* synthetic */ l b;
    public final /* synthetic */ o c;
    public final h d;
    public final j e;
    public Drawable f;
    public int g;
    public int h;
    public boolean i;
    public int j;
    public int k;
    public boolean l;
    public int m;
    public float n;
    public boolean o;

    public static final class a {
    }

    static {
    }

    public OButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 28);
    }

    public OButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 24);
    }

    @Override // com.obric.oui.common.style.b
    public final void C1(List<q> r2) {
        this.b.C1(r2);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean R4() {
        this.b.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final boolean S() {
        this.b.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final void T0(float r2) {
        this.b.T0(r2);
    }

    @Override // com.obric.oui.common.style.a
    public final void Y4(View r2, boolean r3) {
        this.a.Y4(r2, r3);
    }

    @Override // com.obric.oui.common.style.b
    public final /* synthetic */ boolean Z2() {
        return false;
    }

    public final void b(q r2, q r3, boolean r4) {
        this.b.A(r2, r3, false);
    }

    @Override // com.obric.oui.common.style.b
    public List<q> getCurrentShadows() {
        return this.b.getCurrentShadows();
    }

    public j getEffectHelper() {
        return this.c.a();
    }

    @Override // com.obric.oui.common.style.a
    public final void m1(String r2) {
        this.a.m1(r2);
    }

    public void setBorderColor(int r2) {
        this.b.p(r2);
    }

    public void setBorderWidth(int r2) {
        this.b.q(r2);
    }

    public void setBottomDividerAlpha(int r2) {
        this.b.r(r2);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r2) {
        this.a.setChangeAlphaWhenDisable(r2);
    }

    @Override // com.obric.oui.common.style.a
    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r1) {
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r2) {
        this.a.setChangeAlphaWhenPress(r2);
    }

    public void setEnableShadowWidthRadius(boolean r2) {
        this.b.s(r2);
    }

    public /* bridge */ /* synthetic */ void setFakePressed(boolean r1) {
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(boolean r2) {
        this.a.setKeepPressAlpha(r2);
    }

    public void setLeftDividerAlpha(int r2) {
        this.b.t(r2);
    }

    public void setOuterNormalColor(int r2) {
        this.b.u(r2);
    }

    public void setOutlineExcludePadding(boolean r2) {
        this.b.v(r2);
    }

    @Override // com.obric.oui.common.style.a
    public void setOverridePressColor(int r2) {
        this.a.setOverridePressColor(r2);
    }

    public void setRadius(int r2) {
        this.b.w(r2);
    }

    public void setRightDividerAlpha(int r2) {
        this.b.z(r2);
    }

    public void setShadowAlpha(float r2) {
        this.b.B(r2);
    }

    public void setShadowColor(int r2) {
        this.b.C(r2);
    }

    public void setShadowElevation(int r2) {
        this.b.D(r2);
    }

    public void setShadowStyle(int r2) {
        this.b.E(r2);
    }

    public void setShowBorderOnlyBeforeL(boolean r2) {
        this.b.F(r2);
    }

    public void setTopDividerAlpha(int r2) {
        this.b.G(r2);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean e1() {
        return this.b.J;
    }

    public com.obric.oui.common.style.a getAlphaHelper() {
        return this.c.b;
    }

    public b getLayoutHelper() {
        return this.c.a;
    }

    public int getRadius() {
        return this.b.C;
    }

    public float getShadowAlpha() {
        return this.b.U;
    }

    @Override // android.widget.TextView
    public int getShadowColor() {
        return this.b.V;
    }

    public int getShadowElevation() {
        return this.b.T;
    }

    public final Drawable getMIcon() {
        return this.f;
    }

    public final int getMImageTintColorId() {
        return this.h;
    }

    private final void setPressState(boolean r2) {
        if (this.i != r2) goto L6;
        wma.b.h("OButton", Intrinsics.stringPlus("setPressState, already set, skip! pressed: ", Boolean.valueOf(r2)));
        return;
    L6:
        this.i = r2;
        j r0 = this.e;
        if (r0 == null) goto L10;
        r0.g(r2);
    L10:
        h r1 = this.d;
        if (r1 == null) goto L15;
        r1.f(r2);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public final void Q5(int r13) {
        if (this.l == true) goto L5;
        return;
    L5:
        float r14 = RangesKt.coerceIn(r13 / 255.0f, 0.0f, 1.0f);
        int r0 = this.j;
        if (r0 == 0) goto L9;
        int r6 = (r0 >> 24) & 255;
        int r9 = RangesKt.coerceIn((int) (r6 * (1 - (r14 * 0.7f))), 0, 255);
        int r7 = ((r0 >> 16) & 255) << 16;
        setTextColor((r0 & 255) | ((r7 | (r9 << 24)) | (((r0 >> 8) & 255) << 8)));
        wma.b.a("OButton", "updateTextColorOnPress, fraction: " + r14 + ", newTextAlpha: " + r9 + ", originTextAlpha: " + r6);
    L9:
        int r1 = this.k;
        if (r1 == 0) goto L18;
        int r2 = RangesKt.coerceIn((int) (r1 * (1 - (0.7f * r14))), 0, 255);
        Drawable r3 = this.f;
        if (r3 == null) goto L16;
        r3.setAlpha(r2);
    L16:
        wma.b.a("OButton", "updateIconAlphaOnPress, fraction: " + r14 + ", alpha: " + r2 + ", originIconAlpha: " + this.k);
        return;
    }

    public final void a(boolean r5) {
        int r0 = getPaddingTop();
        int r1 = getPaddingRight();
        int r2 = getPaddingBottom();
        if (r5 == false) goto L5;
        int r6 = getPaddingRight() - this.m;
    L7:
        if (r6 == getPaddingLeft()) goto L10;
        setPadding(r6, r0, r1, r2);
        return;
    L10:
        return;
    L5:
        r6 = getPaddingRight();
        goto L7
    }

    public final void c(boolean r7) {
        int r0 = this.j;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r2 = 0;
        if (r7 == true) goto L14;
        int r8 = vma.h.a(r0, this.n);
        this.o = true;
        super.setTextColor(r8);
        this.o = false;
        Drawable[] r9 = getCompoundDrawables();
        int r1 = r9.length;
    L8:
        if (r2 >= r1) goto L21;
        Drawable r3 = r9[r2];
        if (r3 == null) goto L13;
        r3.setAlpha((int) (this.n * 255));
    L13:
        r2 = r2 + 1;
    L21:
        invalidate();
        return;
    L14:
        this.o = true;
        super.setTextColor(r0);
        this.o = false;
        Drawable[] r10 = getCompoundDrawables();
        int r4 = r10.length;
    L15:
        if (r2 >= r4) goto L21;
        Drawable r5 = r10[r2];
        if (r5 == null) goto L20;
        r5.setAlpha(255);
    L20:
        r2 = r2 + 1;
        goto L15
    }

    @Override // com.obric.oui.common.style.a
    public final void f1(boolean r2) {
        this.a.g = r2;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super.onDraw(r6);
        if (r6 == null) goto L13;
        Drawable r0 = this.f;
        if (r0 == null) goto L14;
        int r1 = (getWidth() - r0.getIntrinsicWidth()) / 2;
        int r2 = (getHeight() - r0.getIntrinsicHeight()) / 2;
        r0.setBounds(r1, r2, r0.getIntrinsicWidth() + r1, r0.getIntrinsicHeight() + r2);
        if (this.h == 0) goto L11;
        r0.setColorFilter(new PorterDuffColorFilter(getResources().getColor(this.h), PorterDuff.Mode.SRC_IN));
    L11:
        r0.draw(r6);
        return;
    L14:
        return;
    }

    public final void setButtonSourceBitmap(int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        setMIcon(ContextCompat.getDrawable(getContext(), r2));
        Drawable r3 = this.f;
        if (r3 != null) goto L7;
        int r4 = 0;
    L8:
        this.k = r4;
        invalidate();
        return;
    L7:
        r4 = r3.getAlpha();
        goto L8
    }

    public void setChangeAlphaWhenSelected(boolean r2) {
        this.a.f = r2;
    }

    public final void setDisabledTextAlpha(float r1) {
        this.n = r1;
        if (isEnabled() == true) goto L6;
        c(false);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        h r0 = this.d;
        if (r0 == null) goto L6;
        r0.e(this, r2);
    L6:
        c(r2);
    }

    public final void setMIcon(Drawable r1) {
        this.f = r1;
        requestLayout();
        invalidate();
    }

    public final void setMImageTintColorId(int r1) {
        this.h = r1;
        invalidate();
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        super.setPressed(r2);
        j r0 = this.e;
        if (r0 == null) goto L6;
        r0.g(r2);
    L6:
        h r1 = this.d;
        if (r1 == null) goto L11;
        r1.f(r2);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        h r0 = this.d;
        if (r0 == null) goto L7;
        r0.Y4(this, r2);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowCornerRadius(int r2) {
        this.b.p1 = r2;
    }

    @Override // android.widget.TextView
    public void setTextColor(int r2) {
        if (this.o == true) goto L5;
        this.j = r2;
    L5:
        super.setTextColor(r2);
    }

    @Override // com.obric.oui.common.style.b
    public void setWidthMin(int r2) {
        this.b.d = r2;
    }

    @Override // com.obric.oui.common.style.b
    public final void h1(q r2, q r3) {
        b(r2, r3, false);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        int r6 = getMeasuredWidth();
        int r7 = getMeasuredHeight();
        Drawable r0 = this.f;
        if (r0 == null) goto L6;
        r6 = Math.max(r6, (r0.getIntrinsicWidth() + getPaddingLeft()) + getPaddingRight());
        r7 = Math.max(r7, (r0.getIntrinsicHeight() + getPaddingTop()) + getPaddingBottom());
    L6:
        setMeasuredDimension(r6, r7);
    }

    public OButton(Context r4, AttributeSet r5, int r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r6 = 0;
    L6:
        if ((r7 & 16) == 0) goto L8;
        o r8 = new o(r4, r5, r6, 0);
    L9:
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r8, "provider");
        super(r4, r5, r6);
        this.a = r8.b;
        l r9 = r8.a;
        this.b = r9;
        this.c = r8;
        this.n = 1.0f;
        r9.V0 = true;
        r8.b(this);
        l r10 = (l) getLayoutHelper();
        this.d = (h) getAlphaHelper();
        this.e = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        TypedArray r11 = r4.obtainStyledAttributes(r5, new int[]{2130970280, 2130970297, 2130973062, 2130973068, 2130973372, 2130973393});
        this.g = r11.getResourceId(0, 0);
        setMImageTintColorId(r11.getResourceId(1, 0));
        int r12 = this.g;
        if (r12 == 0) goto L12;
        setButtonSourceBitmap(r12);
    L12:
        setTextAppearance(r11.getResourceId(3, 2131953769));
        this.l = r11.getBoolean(2, false);
        int r13 = getCurrentTextColor();
        this.j = r13;
        setCompoundDrawableTintList(ColorStateList.valueOf(r13));
        this.m = r11.getDimensionPixelSize(5, 0);
        if (((Drawable) ArraysKt.getOrNull(getCompoundDrawables(), 0)) == null) goto L15;
        a(true);
    L15:
        this.n = r11.getFloat(4, 1.0f);
        r11.recycle();
        c(isEnabled());
        return;
    L8:
        r8 = null;
        goto L9
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawables(r1, r2, r3, r4);
        if (r1 == null) goto L5;
        boolean r5 = true;
    L6:
        a(r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawablesRelative(r1, r2, r3, r4);
        if (r1 == null) goto L5;
        boolean r5 = true;
    L6:
        a(r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
