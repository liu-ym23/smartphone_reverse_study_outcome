package com.obric.oui.button;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.common.style.b;
import com.obric.oui.common.style.h;
import com.obric.oui.common.style.j;
import com.obric.oui.common.style.l;
import com.obric.oui.common.style.o;
import com.obric.oui.common.style.q;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001KJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0011\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J-\u0010\u0018\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00170\u0014H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\u001f\u001a\u00020\u00072\b\b\u0001\u0010\u001e\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0011H\u0096\u0001J\u0011\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010&\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010'\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010,\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u001aH\u0096\u0001J\u0011\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0011H\u0096\u0001J\u0011\u00101\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0011H\u0096\u0001J\u0011\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0011H\u0096\u0001J\u0013\u00105\u001a\u00020\u00072\b\b\u0001\u00104\u001a\u00020\u0011H\u0096\u0001J\u0011\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0005H\u0096\u0001J\u0011\u00108\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010:\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0011H\u0096\u0001J\t\u0010;\u001a\u00020\u0002H\u0096\u0001J\t\u0010=\u001a\u00020<H\u0096\u0001J\t\u0010>\u001a\u00020\u0003H\u0096\u0001J\u000e\u0010@\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u001aJ\u000e\u0010B\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0011J\u0010\u0010C\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010F\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0005H\u0016J\u0010\u0010H\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0005H\u0016J\u000e\u0010J\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u001a¨\u0006L"}, d2 = {"Lcom/obric/oui/button/OIconButton;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/obric/oui/common/style/a;", "Lcom/obric/oui/common/style/b;", "", "", "pressed", "", "setPressState", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "", "color", "setOverridePressColor", "", "Lcom/obric/oui/common/style/q;", "kotlin.jvm.PlatformType", "", "getCurrentShadows", "getRadius", "", "getShadowAlpha", "getShadowColor", "getShadowElevation", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "enableShadowWidthRadius", "setEnableShadowWidthRadius", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "minWidth", "setWidthMin", "getAlphaHelper", "Lcom/obric/oui/common/style/j;", "getEffectHelper", "getLayoutHelper", "progress", "setAlignmentProgress", "padding", "setTargetLeftPadding", "setBackgroundColor", "setPressed", "enabled", "setEnabled", "selected", "setSelected", "alpha", "setDisabledAlpha", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OIconButton extends AppCompatImageView implements com.obric.oui.common.style.a, b {
    public final /* synthetic */ h a;
    public final /* synthetic */ l b;
    public final /* synthetic */ o c;
    public final l d;
    public final h e;
    public final j f;
    public boolean g;
    public final boolean h;
    public int i;
    public float j;
    public float k;
    public int l;

    public static final class a {
    }

    static {
    }

    public OIconButton(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 0, 30);
    }

    public OIconButton(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 0, 28);
    }

    public OIconButton(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, r10, 0, 24);
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

    @Override // com.obric.oui.common.style.b
    public List<q> getCurrentShadows() {
        return this.b.getCurrentShadows();
    }

    public j getEffectHelper() {
        return this.c.a();
    }

    public final void j(q r2, q r3, boolean r4) {
        this.b.A(r2, r3, false);
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

    public int getShadowColor() {
        return this.b.V;
    }

    public int getShadowElevation() {
        return this.b.T;
    }

    private final void setPressState(boolean r2) {
        if (this.g != r2) goto L5;
        return;
    L5:
        this.g = r2;
        j r0 = this.f;
        if (r0 == null) goto L9;
        r0.g(r2);
    L9:
        h r1 = this.e;
        if (r1 == null) goto L14;
        r1.f(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.oui.common.style.b
    public final void Q5(int r4) {
        if (this.h == true) goto L5;
        return;
    L5:
        float r5 = RangesKt.coerceIn(r4 / 255.0f, 0.0f, 1.0f);
        if (this.i != 0) goto L8;
        this.i = getImageAlpha();
    L8:
        int r0 = this.i;
        if (r0 == 0) goto L13;
        setImageAlpha(RangesKt.coerceIn((int) (r0 * (1 - (r5 * 0.7f))), 0, 255));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatchDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super/*android.widget.ImageView*/.dispatchDraw(r4);
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.e(r4, getWidth(), getHeight());
    L6:
        l r1 = this.d;
        if (r1 == null) goto L11;
        r1.c(r4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        l r0 = this.d;
        if (r0 == null) goto L6;
        r0.d(r2);
    L6:
        super/*android.widget.ImageView*/.draw(r2);
    }

    @Override // com.obric.oui.common.style.a
    public final void f1(boolean r2) {
        this.a.g = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(boolean r3) {
        if (r3 == true) goto L8;
        Drawable r4 = getDrawable();
        if (r4 == null) goto L14;
        r4.setAlpha((int) (this.j * 255));
        return;
    L14:
        return;
    L8:
        Drawable r5 = getDrawable();
        if (r5 == null) goto L15;
        r5.setAlpha(255);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        if (this.k != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        super/*android.widget.ImageView*/.onDraw(r5);
        return;
    L9:
        Drawable r1 = getDrawable();
        if (r1 != null) goto L13;
        super/*android.widget.ImageView*/.onDraw(r5);
        return;
    L13:
        int r2 = r1.getIntrinsicWidth();
        if (r2 > 0) goto L17;
        super/*android.widget.ImageView*/.onDraw(r5);
        return;
    L17:
        float r3 = (this.l - (getPaddingLeft() + ((((getWidth() - getPaddingLeft()) - getPaddingRight()) - r2) / 2.0f))) * this.k;
        int r4 = r5.save();
        r5.translate(r3, 0.0f);
        super/*android.widget.ImageView*/.onDraw(r5);
        r5.restoreToCount(r4);
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setAlignmentProgress(float r2) {
        if (this.k != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.k = r2;
        invalidate();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundColor(int r3) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setCornerRadius(getRadius());
        r0.setColor(r3);
        setBackground(r0);
    }

    public void setChangeAlphaWhenSelected(boolean r2) {
        this.a.f = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setDisabledAlpha(float r1) {
        this.j = r1;
        if (isEnabled() == true) goto L6;
        l(false);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setEnabled(boolean r2) {
        super/*android.widget.ImageView*/.setEnabled(r2);
        h r0 = this.e;
        if (r0 == null) goto L6;
        r0.e(this, r2);
    L6:
        l(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPressed(boolean r2) {
        super/*android.widget.ImageView*/.setPressed(r2);
        j r0 = this.f;
        if (r0 == null) goto L6;
        r0.g(r2);
    L6:
        h r1 = this.e;
        if (r1 == null) goto L11;
        r1.f(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSelected(boolean r2) {
        super/*android.widget.ImageView*/.setSelected(r2);
        h r0 = this.e;
        if (r0 == null) goto L7;
        r0.Y4(this, r2);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowCornerRadius(int r2) {
        this.b.p1 = r2;
    }

    public final void setTargetLeftPadding(int r1) {
        this.l = r1;
    }

    @Override // com.obric.oui.common.style.b
    public void setWidthMin(int r2) {
        this.b.d = r2;
    }

    @Override // com.obric.oui.common.style.b
    public final void h1(q r2, q r3) {
        j(r2, r3, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OIconButton(Context r4, AttributeSet r5, int r6, int r7, int r8) {
        o r1 = null;
        if ((r8 & 2) == 0) goto L6;
        r5 = null;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r6 = 0;
    L9:
        if ((r8 & 8) == 0) goto L12;
        r7 = 0;
    L12:
        if ((r8 & 16) == 0) goto L14;
        r1 = new o(r4, r5, r6, r7);
    L14:
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r1, "provider");
        super(r4, r5, r6);
        this.a = r1.b;
        this.b = r1.a;
        this.c = r1;
        this.j = 1.0f;
        r1.b(this);
        setEnableShadowWidthRadius(true);
        this.d = (l) getLayoutHelper();
        h r9 = (h) getAlphaHelper();
        this.e = r9;
        if (r9 == null) goto L18;
        r9.h(getRadius());
    L18:
        this.f = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        TypedArray r10 = r4.obtainStyledAttributes(r5, new int[]{2130970280, 2130970297, 2130973062, 2130973068, 2130973372, 2130973393});
        this.h = r10.getBoolean(2, false);
        this.j = r10.getFloat(4, 1.0f);
        r10.recycle();
        l(isEnabled());
        Resources r11 = r4.getResources();
        this.l = MathKt.roundToInt(16 * WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).density);
        if ((getBackground() instanceof ColorDrawable) == false) goto L25;
        GradientDrawable r12 = new GradientDrawable();
        r12.setShape(0);
        r12.setCornerRadius(getRadius());
        Drawable r13 = getBackground();
        if (r13 == null) goto L24;
        r12.setColor(((ColorDrawable) r13).getColor());
        setBackground(r12);
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    }
}
