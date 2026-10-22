package com.obric.oui.text;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import com.obric.common.oui.R$color;
import com.obric.oui.common.style.a;
import com.obric.oui.common.style.b;
import com.obric.oui.common.style.g;
import com.obric.oui.common.style.h;
import com.obric.oui.common.style.i;
import com.obric.oui.common.style.k;
import com.obric.oui.common.style.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\u000b\u0010\tJ\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\r\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\u000f\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J4\u0010\u0018\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00170\u0014H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cH\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u001f\u0010\u001bJ\u0010\u0010 \u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b \u0010\u001bJ\u001a\u0010\"\u001a\u00020\u00072\b\b\u0001\u0010!\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\"\u0010\u0013J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b$\u0010\u0013J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b&\u0010\u0013J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b(\u0010\tJ\u0018\u0010)\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b)\u0010\u0013J\u0018\u0010*\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b*\u0010\u0013J\u0018\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b,\u0010\tJ\u0018\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b.\u0010\u0013J\u0018\u0010/\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b/\u0010\u0013J\u0018\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u001cH\u0096\u0001¢\u0006\u0004\b1\u00102J\u0018\u00104\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b4\u0010\u0013J\u0018\u00105\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b5\u0010\u0013J\u0018\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b7\u0010\u0013J\u001a\u00109\u001a\u00020\u00072\b\b\u0001\u00108\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b9\u0010\u0013J\u0018\u0010;\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b;\u0010\tJ\u0018\u0010<\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b<\u0010\u0013J\u0018\u0010>\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b>\u0010\u0013J\u0010\u0010?\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b?\u0010@J\u0010\u0010B\u001a\u00020AH\u0096\u0001¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0005H\u0016¢\u0006\u0004\bG\u0010\tR*\u0010N\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010\t¨\u0006O"}, d2 = {"Lcom/obric/oui/text/OTextView;", "Landroid/widget/TextView;", "Lcom/obric/oui/common/style/a;", "Lcom/obric/oui/common/style/b;", "", "", "changeAlphaWhenDisable", "", "setChangeAlphaWhenDisable", "(Z)V", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "", "color", "setOverridePressColor", "(I)V", "", "Lcom/obric/oui/common/style/m;", "kotlin.jvm.PlatformType", "", "getCurrentShadows", "()Ljava/util/List;", "getRadius", "()I", "", "getShadowAlpha", "()F", "getShadowColor", "getShadowElevation", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "enableShadowWidthRadius", "setEnableShadowWidthRadius", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "(F)V", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "minWidth", "setWidthMin", "getAlphaHelper", "()Lcom/obric/oui/common/style/a;", "Lcom/obric/oui/common/style/h;", "getEffectHelper", "()Lcom/obric/oui/common/style/h;", "getLayoutHelper", "()Lcom/obric/oui/common/style/b;", "pressed", "setPressed", "value", "h", "Z", "getEnableAutoAlignLeft", "()Z", "setEnableAutoAlignLeft", "enableAutoAlignLeft", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"AppCompatCustomView"})
public class OTextView extends TextView implements a, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f14694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f14695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f14696c;
    public final i d;
    public final g e;
    public final h f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14697h;

    @JvmOverloads
    public OTextView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null, 0, 14);
    }

    @Override // com.obric.oui.common.style.b
    public final void c(List r5) {
        this.f14695b.c(r5);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean d() {
        return this.f14695b.J;
    }

    @Override // android.view.View
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
        this.f14695b.getClass();
        return false;
    }

    public a getAlphaHelper() {
        return this.f14696c.f12510b;
    }

    @Override // com.obric.oui.common.style.b
    public List<m> getCurrentShadows() {
        return this.f14695b.getCurrentShadows();
    }

    public h getEffectHelper() {
        return this.f14696c.a();
    }

    public final boolean getEnableAutoAlignLeft() {
        return this.f14697h;
    }

    public b getLayoutHelper() {
        return this.f14696c.f12509a;
    }

    public int getRadius() {
        return this.f14695b.C;
    }

    public float getShadowAlpha() {
        return this.f14695b.U;
    }

    @Override // android.widget.TextView
    public int getShadowColor() {
        return this.f14695b.V;
    }

    public int getShadowElevation() {
        return this.f14695b.T;
    }

    @Override // com.obric.oui.common.style.a
    public final void h(View r5, boolean r10) {
        this.f14694a.h(r5, r10);
    }

    @Override // com.obric.oui.common.style.a
    public final void i(String r5) {
        this.f14694a.i(r5);
    }

    @Override // com.obric.oui.common.style.b
    public final void j(int r5) {
        this.f14695b.getClass();
    }

    @Override // com.obric.oui.common.style.b
    public final boolean k() {
        this.f14695b.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final void l(m r5, m r10, boolean r11) {
        this.f14695b.l(r5, r10, false);
    }

    @Override // com.obric.oui.common.style.b
    public final void m(float r5) {
        this.f14695b.m(r5);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        if (this.f14697h == false) goto L16;
        int r14 = 1;
        if (getLineCount() > 1) goto L7;
        boolean r15 = true;
    L8:
        int r16 = this.g & 112;
        if (r15 == true) goto L12;
        r14 = 3;
    L12:
        int r17 = r16 | r14;
        if (getGravity() == r17) goto L17;
        setGravity(r17);
        return;
    L17:
        return;
    L7:
        r15 = false;
        goto L8
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
    }

    public void setBorderColor(@ColorInt int r5) {
        this.f14695b.w(r5);
    }

    public void setBorderWidth(int r5) {
        this.f14695b.x(r5);
    }

    public void setBottomDividerAlpha(int r5) {
        this.f14695b.y(r5);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r5) {
        this.f14694a.setChangeAlphaWhenDisable(r5);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r5) {
        this.f14694a.setChangeAlphaWhenPress(r5);
    }

    public void setChangeAlphaWhenSelected(boolean r5) {
        this.f14694a.e = r5;
    }

    public final void setEnableAutoAlignLeft(boolean r5) {
        if (this.f14697h == r5) goto L6;
        this.f14697h = r5;
        requestLayout();
        return;
    }

    public void setEnableShadowWidthRadius(boolean r5) {
        this.f14695b.z(r5);
    }

    public /* bridge */ /* synthetic */ void setFakePressed(boolean r5) {
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(boolean r5) {
        this.f14694a.setKeepPressAlpha(r5);
    }

    public void setLeftDividerAlpha(int r5) {
        this.f14695b.A(r5);
    }

    public void setOuterNormalColor(int r5) {
        this.f14695b.B(r5);
    }

    public void setOutlineExcludePadding(boolean r5) {
        this.f14695b.C(r5);
    }

    public void setOverridePressColor(int r5) {
        this.f14694a.g(r5);
    }

    @Override // android.view.View
    public void setPressed(boolean r5) {
        h r10 = this.f;
        if (r10 == null) goto L6;
        r10.f(r5);
    L6:
        super.setPressed(r5);
        g r11 = this.e;
        if (r11 == null) goto L11;
        r11.e(r5);
        return;
    }

    public void setRadius(int r5) {
        this.f14695b.D(r5);
    }

    public void setRightDividerAlpha(int r5) {
        this.f14695b.F(r5);
    }

    public void setShadowAlpha(float r5) {
        this.f14695b.G(r5);
    }

    public void setShadowColor(int r5) {
        this.f14695b.H(r5);
    }

    public void setShadowCornerRadius(int r5) {
        this.f14695b.i0 = r5;
    }

    public void setShadowElevation(int r5) {
        this.f14695b.I(r5);
    }

    public void setShadowStyle(@StyleRes int r5) {
        this.f14695b.J(r5);
    }

    public void setShowBorderOnlyBeforeL(boolean r5) {
        this.f14695b.K(r5);
    }

    public void setTopDividerAlpha(int r5) {
        this.f14695b.L(r5);
    }

    @Override // com.obric.oui.common.style.b
    public void setWidthMin(int r5) {
        this.f14695b.d = r5;
    }

    @JvmOverloads
    public OTextView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 0, 12);
    }

    @JvmOverloads
    public OTextView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, r11, 8);
    }

    public OTextView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = 0;
    L8:
        k r13 = new k(r5, r10, r11, 0);
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r13, "provider");
        super(r5, r10, r11);
        this.f14694a = r13.f12510b;
        this.f14695b = r13.f12509a;
        this.f14696c = r13;
        this.g = getGravity();
        r13.b(this);
        this.d = (i) getLayoutHelper();
        g r14 = (g) getAlphaHelper();
        this.e = r14;
        this.f = getEffectHelper();
        if (r14 == null) goto L12;
        r14.setChangeAlphaWhenPress(false);
    L12:
        if (r14 == null) goto L15;
        r14.setChangeAlphaWhenDisable(false);
    L15:
        setHighlightColor(r5.getColor(R$color.oui_text_highlight_color));
        setIncludeFontPadding(false);
    }
}
