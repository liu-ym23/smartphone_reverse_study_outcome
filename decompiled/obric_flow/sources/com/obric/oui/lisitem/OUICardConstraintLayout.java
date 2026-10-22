package com.obric.oui.lisitem;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import com.obric.oui.common.style.g;
import com.obric.oui.common.style.h;
import com.obric.oui.common.style.i;
import com.obric.oui.common.style.k;
import com.obric.oui.common.style.m;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\u000b\u0010\tJ\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\r\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\u000f\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J4\u0010\u0018\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00170\u0014H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cH\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u001f\u0010\u001bJ\u0010\u0010 \u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b \u0010\u001bJ\u001a\u0010\"\u001a\u00020\u00072\b\b\u0001\u0010!\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\"\u0010\u0013J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b$\u0010\u0013J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b&\u0010\u0013J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b(\u0010\tJ\u0018\u0010)\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b)\u0010\u0013J\u0018\u0010*\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b*\u0010\u0013J\u0018\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b,\u0010\tJ\u0018\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b.\u0010\u0013J\u0018\u0010/\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b/\u0010\u0013J\u0018\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u001cH\u0096\u0001¢\u0006\u0004\b1\u00102J\u0018\u00104\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b4\u0010\u0013J\u0018\u00105\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b5\u0010\u0013J\u0018\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b7\u0010\u0013J\u001a\u00109\u001a\u00020\u00072\b\b\u0001\u00108\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b9\u0010\u0013J\u0018\u0010;\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b;\u0010\tJ\u0018\u0010<\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b<\u0010\u0013J\u0018\u0010>\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b>\u0010\u0013J\u0010\u0010?\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b?\u0010@J\u0010\u0010B\u001a\u00020AH\u0096\u0001¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0005H\u0016¢\u0006\u0004\bG\u0010\tJ\u0017\u0010I\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u0005H\u0016¢\u0006\u0004\bI\u0010\tJ\u0015\u0010J\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u0005¢\u0006\u0004\bJ\u0010\tJ\u0015\u0010K\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u0005¢\u0006\u0004\bK\u0010\tJ\u0017\u0010M\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0005H\u0016¢\u0006\u0004\bM\u0010\tJ\u0017\u0010O\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u0005H\u0016¢\u0006\u0004\bO\u0010\tJ\u0017\u0010Q\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u0010H\u0016¢\u0006\u0004\bQ\u0010\u0013¨\u0006R"}, d2 = {"Lcom/obric/oui/lisitem/OUICardConstraintLayout;", "Lcom/obric/oui/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/common/style/a;", "Lcom/obric/oui/common/style/b;", "", "", "changeAlphaWhenDisable", "", "setChangeAlphaWhenDisable", "(Z)V", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "", "color", "setOverridePressColor", "(I)V", "", "Lcom/obric/oui/common/style/m;", "kotlin.jvm.PlatformType", "", "getCurrentShadows", "()Ljava/util/List;", "getRadius", "()I", "", "getShadowAlpha", "()F", "getShadowColor", "getShadowElevation", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "enableShadowWidthRadius", "setEnableShadowWidthRadius", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "(F)V", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "minWidth", "setWidthMin", "getAlphaHelper", "()Lcom/obric/oui/common/style/a;", "Lcom/obric/oui/common/style/h;", "getEffectHelper", "()Lcom/obric/oui/common/style/h;", "getLayoutHelper", "()Lcom/obric/oui/common/style/b;", "pressed", "setPressed", "enabled", "setEnabled", "setVibrateEnabled", "setSoundEffectEnabled", "fakePressed", "setFakePressed", "selected", "setSelected", "minHeight", "setMinimumHeight", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OUICardConstraintLayout extends ConstraintLayout implements com.obric.oui.common.style.a, com.obric.oui.common.style.b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ g f13590q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ i f13591r;
    public final /* synthetic */ k s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final i f13592t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final g f13593u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h f13594v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f13595w;

    @JvmOverloads
    public OUICardConstraintLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null, 0, 14);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean b() {
        return this.f13595w;
    }

    @Override // com.obric.oui.common.style.b
    public final void c(List r5) {
        this.f13591r.c(r5);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean d() {
        return this.f13591r.J;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.dispatchDraw(r5);
        i r10 = this.f13592t;
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
        h r10 = this.f13594v;
        if (r10 == null) goto L7;
        r10.g(r5);
    L7:
        return super.dispatchGenericMotionEvent(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        h r10 = this.f13594v;
        if (r10 == null) goto L7;
        r10.g(r5);
    L7:
        if (this.f13593u == null) goto L13;
        if (r5 == null) goto L13;
        r5.getAction();
    L13:
        return super.dispatchTouchEvent(r5);
    }

    @Override // android.view.View
    public final void draw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        i r10 = this.f13592t;
        if (r10 == null) goto L6;
        r10.h(r5);
    L6:
        super.draw(r5);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean g() {
        this.f13591r.getClass();
        return false;
    }

    public com.obric.oui.common.style.a getAlphaHelper() {
        return this.s.f12510b;
    }

    @Override // com.obric.oui.common.style.b
    public List<m> getCurrentShadows() {
        return this.f13591r.getCurrentShadows();
    }

    public h getEffectHelper() {
        return this.s.a();
    }

    public com.obric.oui.common.style.b getLayoutHelper() {
        return this.s.f12509a;
    }

    public int getRadius() {
        return this.f13591r.C;
    }

    public float getShadowAlpha() {
        return this.f13591r.U;
    }

    public int getShadowColor() {
        return this.f13591r.V;
    }

    public int getShadowElevation() {
        return this.f13591r.T;
    }

    @Override // com.obric.oui.common.style.a
    public final void h(View r5, boolean r10) {
        this.f13590q.h(r5, r10);
    }

    @Override // com.obric.oui.common.style.a
    public final void i(String r5) {
        this.f13590q.i(r5);
    }

    @Override // com.obric.oui.common.style.b
    public final void j(int r5) {
        this.f13591r.getClass();
    }

    @Override // com.obric.oui.common.style.b
    public final boolean k() {
        this.f13591r.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final void l(m r5, m r10, boolean r11) {
        this.f13591r.l(r5, r10, false);
    }

    @Override // com.obric.oui.common.style.b
    public final void m(float r5) {
        this.f13591r.m(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onHoverChanged(boolean r5) {
        super.onHoverChanged(r5);
        h r10 = this.f13594v;
        if (r10 == null) goto L7;
        r10.d(r5);
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        i r11 = this.f13592t;
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
        h r10 = this.f13594v;
        if (r10 == null) goto L7;
        r10.e(r5);
        return;
    }

    public void setBorderColor(@ColorInt int r5) {
        this.f13591r.w(r5);
    }

    public void setBorderWidth(int r5) {
        this.f13591r.x(r5);
    }

    public void setBottomDividerAlpha(int r5) {
        this.f13591r.y(r5);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r5) {
        this.f13590q.setChangeAlphaWhenDisable(r5);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r5) {
        this.f13590q.setChangeAlphaWhenPress(r5);
    }

    public void setChangeAlphaWhenSelected(boolean r5) {
        this.f13590q.e = r5;
    }

    public void setEnableShadowWidthRadius(boolean r5) {
        this.f13591r.z(r5);
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        g r10 = this.f13593u;
        if (r10 == null) goto L7;
        r10.d(this, r5);
        return;
    }

    public void setFakePressed(boolean r5) {
        if (this.f13595w == r5) goto L13;
        this.f13595w = r5;
        h r10 = this.f13594v;
        if (r10 == null) goto L8;
        r10.f(r5);
    L8:
        g r11 = this.f13593u;
        if (r11 == null) goto L14;
        r11.e(this.f13595w);
        return;
    L14:
        return;
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(boolean r5) {
        this.f13590q.setKeepPressAlpha(r5);
    }

    public void setLeftDividerAlpha(int r5) {
        this.f13591r.A(r5);
    }

    @Override // android.view.View
    public void setMinimumHeight(int r5) {
        i r10 = this.f13592t;
        if (r10 == null) goto L6;
        r10.e = r5;
    L6:
        super.setMinimumHeight(r5);
    }

    public void setOuterNormalColor(int r5) {
        this.f13591r.B(r5);
    }

    public void setOutlineExcludePadding(boolean r5) {
        this.f13591r.C(r5);
    }

    public void setOverridePressColor(int r5) {
        this.f13590q.g(r5);
    }

    @Override // android.view.View
    public void setPressed(boolean r5) {
        h r10 = this.f13594v;
        if (r10 == null) goto L6;
        r10.f(r5);
    L6:
        super.setPressed(r5);
        g r11 = this.f13593u;
        if (r11 == null) goto L11;
        r11.e(r5);
        return;
    }

    public void setRadius(int r5) {
        this.f13591r.D(r5);
    }

    public void setRightDividerAlpha(int r5) {
        this.f13591r.F(r5);
    }

    @Override // android.view.View
    public void setSelected(boolean r5) {
        super.setSelected(r5);
        g r10 = this.f13593u;
        if (r10 == null) goto L7;
        r10.h(this, r5);
        return;
    }

    public void setShadowAlpha(float r5) {
        this.f13591r.G(r5);
    }

    public void setShadowColor(int r5) {
        this.f13591r.H(r5);
    }

    public void setShadowCornerRadius(int r5) {
        this.f13591r.i0 = r5;
    }

    public void setShadowElevation(int r5) {
        this.f13591r.I(r5);
    }

    public void setShadowStyle(@StyleRes int r5) {
        this.f13591r.J(r5);
    }

    public void setShowBorderOnlyBeforeL(boolean r5) {
        this.f13591r.K(r5);
    }

    public final void setSoundEffectEnabled(boolean r5) {
        h r10 = this.f13594v;
        if (r10 == null) goto L7;
        r10.d = r5;
        return;
    }

    public void setTopDividerAlpha(int r5) {
        this.f13591r.L(r5);
    }

    public final void setVibrateEnabled(boolean r5) {
        h r10 = this.f13594v;
        if (r10 == null) goto L7;
        r10.f12478c = r5;
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setWidthMin(int r5) {
        this.f13591r.d = r5;
    }

    @JvmOverloads
    public OUICardConstraintLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 0, 12);
    }

    @JvmOverloads
    public OUICardConstraintLayout(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, r11, 8);
    }

    public OUICardConstraintLayout(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = 0;
    L8:
        k r13 = new k(r5, r10, r11, 0);
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r13, "provider");
        super(r5, r10);
        this.f13590q = r13.f12510b;
        this.f13591r = r13.f12509a;
        this.s = r13;
        r13.b(this);
        this.f13592t = (i) getLayoutHelper();
        this.f13593u = (g) getAlphaHelper();
        this.f13594v = getEffectHelper();
        Intrinsics.checkNotNullParameter(r5, "context");
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        setVibrateEnabled(false);
        setSoundEffectEnabled(false);
        setWillNotDraw(false);
    }
}
