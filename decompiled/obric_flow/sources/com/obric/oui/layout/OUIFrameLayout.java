package com.obric.oui.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import com.obric.oui.common.style.a;
import com.obric.oui.common.style.b;
import com.obric.oui.common.style.g;
import com.obric.oui.common.style.h;
import com.obric.oui.common.style.i;
import com.obric.oui.common.style.k;
import com.obric.oui.common.style.m;
import com.obric.oui.lisitem.OListItemSwitch;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\u000b\u0010\tJ\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\r\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\u000f\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u0015J\u0010\u0010\u001a\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u0015J\u001a\u0010\u001c\u001a\u00020\u00072\b\b\u0001\u0010\u001b\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u0013J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u001e\u0010\u0013J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b \u0010\u0013J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\"\u0010\tJ\u0018\u0010#\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b#\u0010\u0013J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b$\u0010\u0013J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b&\u0010\tJ\u0018\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b(\u0010\u0013J\u0018\u0010)\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b)\u0010\u0013J\u0018\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0016H\u0096\u0001¢\u0006\u0004\b+\u0010,J\u0018\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b.\u0010\u0013J\u0018\u0010/\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b/\u0010\u0013J\u0018\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b1\u0010\u0013J\u001a\u00103\u001a\u00020\u00072\b\b\u0001\u00102\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b3\u0010\u0013J\u0018\u00105\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b5\u0010\tJ\u0018\u00106\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b6\u0010\u0013J\u0018\u00108\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b8\u0010\u0013J\u0010\u00109\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b9\u0010:J\u0010\u0010<\u001a\u00020;H\u0096\u0001¢\u0006\u0004\b<\u0010=J\u0010\u0010>\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0005H\u0016¢\u0006\u0004\bA\u0010\tJ\u0017\u0010C\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0005H\u0016¢\u0006\u0004\bC\u0010\tJ\u0015\u0010D\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0005¢\u0006\u0004\bD\u0010\tJ\u0015\u0010E\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0005¢\u0006\u0004\bE\u0010\tJ\u0017\u0010G\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0005H\u0016¢\u0006\u0004\bG\u0010\tJ\u0017\u0010I\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u0005H\u0016¢\u0006\u0004\bI\u0010\tJ\u0017\u0010L\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010JH\u0016¢\u0006\u0004\bL\u0010M¨\u0006N"}, d2 = {"Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/common/style/a;", "Lcom/obric/oui/common/style/b;", "", "", "changeAlphaWhenDisable", "", "setChangeAlphaWhenDisable", "(Z)V", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "", "color", "setOverridePressColor", "(I)V", "getRadius", "()I", "", "getShadowAlpha", "()F", "getShadowColor", "getShadowElevation", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "enableShadowWidthRadius", "setEnableShadowWidthRadius", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "(F)V", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "minWidth", "setWidthMin", "getAlphaHelper", "()Lcom/obric/oui/common/style/a;", "Lcom/obric/oui/common/style/h;", "getEffectHelper", "()Lcom/obric/oui/common/style/h;", "getLayoutHelper", "()Lcom/obric/oui/common/style/b;", "pressed", "setPressed", "enabled", "setEnabled", "setVibrateEnabled", "setSoundEffectEnabled", "fakePressed", "setFakePressed", "selected", "setSelected", "", "Lcom/obric/oui/common/style/m;", "getCurrentShadows", "()Ljava/util/List;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OUIFrameLayout extends FrameLayout implements a, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f13531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f13532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f13533c;
    public final i d;
    public final g e;
    public final h f;
    public boolean g;

    @JvmOverloads
    public OUIFrameLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null, 0, 14);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean b() {
        return this.g;
    }

    @Override // com.obric.oui.common.style.b
    public final void c(List r5) {
        this.f13532b.c(r5);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean d() {
        return this.f13532b.J;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.dispatchDraw(r5);
        i r10 = this.d;
        if (r10 == null) goto L6;
        r10.i(r5, getWidth(), getHeight());
    L6:
        if (r10 == null) goto L10;
        r10.e(r5);
        return;
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        h r10 = this.f;
        if (r10 == null) goto L7;
        r10.g(r5);
    L7:
        return super.dispatchGenericMotionEvent(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        h r10 = this.f;
        if (r10 == null) goto L7;
        r10.g(r5);
    L7:
        if (this.e == null) goto L13;
        if (r5 == null) goto L13;
        r5.getAction();
    L13:
        return super.dispatchTouchEvent(r5);
    }

    @Override // android.view.View
    public final void draw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        i r10 = this.d;
        if (r10 == null) goto L6;
        r10.h(r5);
    L6:
        super.draw(r5);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean g() {
        this.f13532b.getClass();
        return false;
    }

    public a getAlphaHelper() {
        return this.f13533c.f12510b;
    }

    @Override // com.obric.oui.common.style.b
    public List<m> getCurrentShadows() {
        i r5 = this.d;
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5.getCurrentShadows();
    }

    public h getEffectHelper() {
        return this.f13533c.a();
    }

    public b getLayoutHelper() {
        return this.f13533c.f12509a;
    }

    public int getRadius() {
        return this.f13532b.C;
    }

    public float getShadowAlpha() {
        return this.f13532b.U;
    }

    public int getShadowColor() {
        return this.f13532b.V;
    }

    public int getShadowElevation() {
        return this.f13532b.T;
    }

    @Override // com.obric.oui.common.style.a
    public final void h(View r5, boolean r10) {
        this.f13531a.h(r5, r10);
    }

    @Override // com.obric.oui.common.style.a
    public final void i(String r5) {
        this.f13531a.i(r5);
    }

    @Override // com.obric.oui.common.style.b
    public final void j(int r5) {
        this.f13532b.getClass();
    }

    public boolean k() {
        this.f13532b.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final void l(m r5, m r10, boolean r11) {
        this.f13532b.l(r5, r10, r11);
    }

    @Override // com.obric.oui.common.style.b
    public final void m(float r5) {
        this.f13532b.m(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onHoverChanged(boolean r5) {
        super.onHoverChanged(r5);
        h r10 = this.f;
        if (r10 == null) goto L7;
        r10.d(r5);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        i r11 = this.d;
        if (r11 == null) goto L8;
        Intrinsics.checkNotNull(r11);
        int r12 = r11.q(r5);
        Intrinsics.checkNotNull(r11);
        int r13 = r11.p(r10);
        super.onMeasure(r12, r13);
        Intrinsics.checkNotNull(r11);
        int r14 = r11.t(r12, getMeasuredWidth());
        Intrinsics.checkNotNull(r11);
        int r15 = r11.s(r13, getMeasuredHeight());
        if (r12 != r14) goto L7;
        if (r13 != r15) goto L7;
        return;
    L7:
        super.onMeasure(r14, r15);
        return;
    L8:
        super.onMeasure(r5, r10);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r5) {
        super.onWindowVisibilityChanged(r5);
        h r10 = this.f;
        if (r10 == null) goto L7;
        r10.e(r5);
        return;
    }

    public void setBorderColor(@ColorInt int r5) {
        this.f13532b.w(r5);
    }

    public void setBorderWidth(int r5) {
        this.f13532b.x(r5);
    }

    public void setBottomDividerAlpha(int r5) {
        this.f13532b.y(r5);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r5) {
        this.f13531a.setChangeAlphaWhenDisable(r5);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r5) {
        this.f13531a.setChangeAlphaWhenPress(r5);
    }

    public void setChangeAlphaWhenSelected(boolean r5) {
        this.f13531a.e = r5;
    }

    public void setEnableShadowWidthRadius(boolean r5) {
        this.f13532b.z(r5);
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        g r10 = this.e;
        if (r10 == null) goto L7;
        r10.d(this, r5);
        return;
    }

    public void setFakePressed(boolean r5) {
        if (this.g == r5) goto L13;
        this.g = r5;
        h r10 = this.f;
        if (r10 == null) goto L8;
        r10.f(r5);
    L8:
        g r11 = this.e;
        if (r11 == null) goto L14;
        r11.e(this.g);
        return;
    L14:
        return;
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(boolean r5) {
        this.f13531a.setKeepPressAlpha(r5);
    }

    public void setLeftDividerAlpha(int r5) {
        this.f13532b.A(r5);
    }

    public void setOuterNormalColor(int r5) {
        this.f13532b.B(r5);
    }

    public void setOutlineExcludePadding(boolean r5) {
        this.f13532b.C(r5);
    }

    public void setOverridePressColor(int r5) {
        this.f13531a.g(r5);
    }

    @Override // android.view.View
    public void setPressed(boolean r5) {
        if ((this instanceof OListItemSwitch) == true) goto L13;
        h r10 = this.f;
        if (r10 == null) goto L8;
        r10.f(r5);
    L8:
        super.setPressed(r5);
        g r11 = this.e;
        if (r11 == null) goto L14;
        r11.e(r5);
        return;
    L14:
        return;
    }

    public void setRadius(int r5) {
        this.f13532b.D(r5);
    }

    public void setRightDividerAlpha(int r5) {
        this.f13532b.F(r5);
    }

    @Override // android.view.View
    public void setSelected(boolean r5) {
        super.setSelected(r5);
        g r10 = this.e;
        if (r10 == null) goto L7;
        r10.h(this, r5);
        return;
    }

    public void setShadowAlpha(float r5) {
        this.f13532b.G(r5);
    }

    public void setShadowColor(int r5) {
        this.f13532b.H(r5);
    }

    public void setShadowCornerRadius(int r5) {
        this.f13532b.i0 = r5;
    }

    public void setShadowElevation(int r5) {
        this.f13532b.I(r5);
    }

    public void setShadowStyle(@StyleRes int r5) {
        this.f13532b.J(r5);
    }

    public void setShowBorderOnlyBeforeL(boolean r5) {
        this.f13532b.K(r5);
    }

    public final void setSoundEffectEnabled(boolean r5) {
        h r10 = this.f;
        if (r10 == null) goto L7;
        r10.d = r5;
        return;
    }

    public void setTopDividerAlpha(int r5) {
        this.f13532b.L(r5);
    }

    public final void setVibrateEnabled(boolean r5) {
        h r10 = this.f;
        if (r10 == null) goto L7;
        r10.f12478c = r5;
        return;
    }

    public void setWidthMin(int r5) {
        this.f13532b.d = r5;
    }

    @JvmOverloads
    public OUIFrameLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r11 = 0;
        this(r5, r10, r11, 12);
    }

    @JvmOverloads
    public OUIFrameLayout(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, r11, 8);
    }

    public /* synthetic */ OUIFrameLayout(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = 0;
    L8:
        this(r5, r10, new k(r5, r10, r11, 0));
    }

    public OUIFrameLayout(Context r5, AttributeSet r10, k r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r11, "provider");
        super(r5, r10);
        this.f13531a = r11.f12510b;
        this.f13532b = r11.f12509a;
        this.f13533c = r11;
        r11.b(this);
        this.d = (i) getLayoutHelper();
        this.e = (g) getAlphaHelper();
        this.f = getEffectHelper();
        Intrinsics.checkNotNullParameter(r5, "context");
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        setVibrateEnabled(false);
        setSoundEffectEnabled(false);
        setWillNotDraw(false);
    }
}
