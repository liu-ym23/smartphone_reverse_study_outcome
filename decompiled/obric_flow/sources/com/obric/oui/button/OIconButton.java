package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NotificationCompat;
import com.obric.common.oui.R$styleable;
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
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\u000b\u0010\tJ\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\r\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\u000f\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J4\u0010\u0018\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00170\u0014H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cH\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u001f\u0010\u001bJ\u0010\u0010 \u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b \u0010\u001bJ\u001a\u0010\"\u001a\u00020\u00072\b\b\u0001\u0010!\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\"\u0010\u0013J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b$\u0010\u0013J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b&\u0010\u0013J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b(\u0010\tJ\u0018\u0010)\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b)\u0010\u0013J\u0018\u0010*\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b*\u0010\u0013J\u0018\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b,\u0010\tJ\u0018\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b.\u0010\u0013J\u0018\u0010/\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b/\u0010\u0013J\u0018\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u001cH\u0096\u0001¢\u0006\u0004\b1\u00102J\u0018\u00104\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b4\u0010\u0013J\u0018\u00105\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b5\u0010\u0013J\u0018\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b7\u0010\u0013J\u001a\u00109\u001a\u00020\u00072\b\b\u0001\u00108\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b9\u0010\u0013J\u0018\u0010;\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b;\u0010\tJ\u0018\u0010<\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b<\u0010\u0013J\u0018\u0010>\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b>\u0010\u0013J\u0010\u0010?\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b?\u0010@J\u0010\u0010B\u001a\u00020AH\u0096\u0001¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\bD\u0010EJ\u0015\u0010G\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u001c¢\u0006\u0004\bG\u00102J\u0015\u0010I\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u0010¢\u0006\u0004\bI\u0010\u0013J\u0017\u0010J\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\bJ\u0010\u0013J\u0017\u0010L\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0005H\u0016¢\u0006\u0004\bL\u0010\tJ\u0017\u0010N\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0005H\u0016¢\u0006\u0004\bN\u0010\tJ\u0017\u0010P\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0005H\u0016¢\u0006\u0004\bP\u0010\tJ\u0015\u0010R\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u001c¢\u0006\u0004\bR\u00102J\u0017\u0010S\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0005H\u0002¢\u0006\u0004\bS\u0010\t¨\u0006T"}, d2 = {"Lcom/obric/oui/button/OIconButton;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/obric/oui/common/style/a;", "Lcom/obric/oui/common/style/b;", "", "", "changeAlphaWhenDisable", "", "setChangeAlphaWhenDisable", "(Z)V", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "", "color", "setOverridePressColor", "(I)V", "", "Lcom/obric/oui/common/style/m;", "kotlin.jvm.PlatformType", "", "getCurrentShadows", "()Ljava/util/List;", "getRadius", "()I", "", "getShadowAlpha", "()F", "getShadowColor", "getShadowElevation", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "enableShadowWidthRadius", "setEnableShadowWidthRadius", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "(F)V", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "minWidth", "setWidthMin", "getAlphaHelper", "()Lcom/obric/oui/common/style/a;", "Lcom/obric/oui/common/style/h;", "getEffectHelper", "()Lcom/obric/oui/common/style/h;", "getLayoutHelper", "()Lcom/obric/oui/common/style/b;", NotificationCompat.CATEGORY_PROGRESS, "setAlignmentProgress", "padding", "setTargetLeftPadding", "setBackgroundColor", "pressed", "setPressed", "enabled", "setEnabled", "selected", "setSelected", "alpha", "setDisabledAlpha", "setPressState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OIconButton extends AppCompatImageView implements a, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f12133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f12134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f12135c;
    public final i d;
    public final g e;
    public final h f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f12136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f12138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f12139k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12140l;

    @JvmOverloads
    public OIconButton(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, null, 0, 0, 30);
    }

    private final void setPressState(boolean r5) {
        if (this.g != r5) goto L5;
        return;
    L5:
        this.g = r5;
        h r10 = this.f;
        if (r10 == null) goto L9;
        r10.f(r5);
    L9:
        g r11 = this.e;
        if (r11 == null) goto L14;
        r11.e(r5);
        return;
    }

    public final void a(boolean r5) {
        if (r5 == true) goto L8;
        Drawable r10 = getDrawable();
        if (r10 == null) goto L14;
        r10.setAlpha((int) (this.f12138j * 255));
        return;
    L14:
        return;
    L8:
        Drawable r11 = getDrawable();
        if (r11 == null) goto L15;
        r11.setAlpha(255);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public final void c(List r5) {
        this.f12134b.c(r5);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean d() {
        return this.f12134b.J;
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
        this.f12134b.getClass();
        return false;
    }

    public a getAlphaHelper() {
        return this.f12135c.f12510b;
    }

    @Override // com.obric.oui.common.style.b
    public List<m> getCurrentShadows() {
        return this.f12134b.getCurrentShadows();
    }

    public h getEffectHelper() {
        return this.f12135c.a();
    }

    public b getLayoutHelper() {
        return this.f12135c.f12509a;
    }

    public int getRadius() {
        return this.f12134b.C;
    }

    public float getShadowAlpha() {
        return this.f12134b.U;
    }

    public int getShadowColor() {
        return this.f12134b.V;
    }

    public int getShadowElevation() {
        return this.f12134b.T;
    }

    @Override // com.obric.oui.common.style.a
    public final void h(View r5, boolean r10) {
        this.f12133a.h(r5, r10);
    }

    @Override // com.obric.oui.common.style.a
    public final void i(String r5) {
        this.f12133a.i(r5);
    }

    @Override // com.obric.oui.common.style.b
    public final void j(int r5) {
        if (this.f12136h == true) goto L5;
        return;
    L5:
        float r10 = RangesKt.coerceIn(r5 / 255.0f, 0.0f, 1.0f);
        if (this.f12137i != 0) goto L8;
        this.f12137i = getImageAlpha();
    L8:
        int r11 = this.f12137i;
        if (r11 == 0) goto L13;
        setImageAlpha(RangesKt.coerceIn((int) ((1 - (r10 * 0.7f)) * r11), 0, 255));
        return;
    }

    @Override // com.obric.oui.common.style.b
    public final boolean k() {
        this.f12134b.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final void l(m r5, m r10, boolean r11) {
        this.f12134b.l(r5, r10, false);
    }

    @Override // com.obric.oui.common.style.b
    public final void m(float r5) {
        this.f12134b.m(r5);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        if (this.f12139k != 0.0f) goto L6;
        super.onDraw(r5);
        return;
    L6:
        Drawable r10 = getDrawable();
        if (r10 != null) goto L10;
        super.onDraw(r5);
        return;
    L10:
        int r11 = r10.getIntrinsicWidth();
        if (r11 > 0) goto L14;
        super.onDraw(r5);
        return;
    L14:
        float r12 = (this.f12140l - (((((getWidth() - getPaddingLeft()) - getPaddingRight()) - r11) / 2.0f) + getPaddingLeft())) * this.f12139k;
        int r13 = r5.save();
        r5.translate(r12, 0.0f);
        super.onDraw(r5);
        r5.restoreToCount(r13);
    }

    public final void setAlignmentProgress(float r5) {
        if (this.f12139k == r5) goto L7;
        this.f12139k = r5;
        invalidate();
        return;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r5) {
        GradientDrawable r10 = new GradientDrawable();
        r10.setShape(0);
        r10.setCornerRadius(getRadius());
        r10.setColor(r5);
        setBackground(r10);
    }

    public void setBorderColor(@ColorInt int r5) {
        this.f12134b.w(r5);
    }

    public void setBorderWidth(int r5) {
        this.f12134b.x(r5);
    }

    public void setBottomDividerAlpha(int r5) {
        this.f12134b.y(r5);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r5) {
        this.f12133a.setChangeAlphaWhenDisable(r5);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r5) {
        this.f12133a.setChangeAlphaWhenPress(r5);
    }

    public void setChangeAlphaWhenSelected(boolean r5) {
        this.f12133a.e = r5;
    }

    public final void setDisabledAlpha(float r5) {
        this.f12138j = r5;
        if (isEnabled() == true) goto L6;
        a(false);
        return;
    }

    public void setEnableShadowWidthRadius(boolean r5) {
        this.f12134b.z(r5);
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        g r10 = this.e;
        if (r10 == null) goto L6;
        r10.d(this, r5);
    L6:
        a(r5);
    }

    public /* bridge */ /* synthetic */ void setFakePressed(boolean r5) {
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(boolean r5) {
        this.f12133a.setKeepPressAlpha(r5);
    }

    public void setLeftDividerAlpha(int r5) {
        this.f12134b.A(r5);
    }

    public void setOuterNormalColor(int r5) {
        this.f12134b.B(r5);
    }

    public void setOutlineExcludePadding(boolean r5) {
        this.f12134b.C(r5);
    }

    public void setOverridePressColor(int r5) {
        this.f12133a.g(r5);
    }

    @Override // android.view.View
    public void setPressed(boolean r5) {
        super.setPressed(r5);
        h r10 = this.f;
        if (r10 == null) goto L6;
        r10.f(r5);
    L6:
        g r11 = this.e;
        if (r11 == null) goto L11;
        r11.e(r5);
        return;
    }

    public void setRadius(int r5) {
        this.f12134b.D(r5);
    }

    public void setRightDividerAlpha(int r5) {
        this.f12134b.F(r5);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean r5) {
        super.setSelected(r5);
        g r10 = this.e;
        if (r10 == null) goto L7;
        r10.h(this, r5);
        return;
    }

    public void setShadowAlpha(float r5) {
        this.f12134b.G(r5);
    }

    public void setShadowColor(int r5) {
        this.f12134b.H(r5);
    }

    public void setShadowCornerRadius(int r5) {
        this.f12134b.i0 = r5;
    }

    public void setShadowElevation(int r5) {
        this.f12134b.I(r5);
    }

    public void setShadowStyle(@StyleRes int r5) {
        this.f12134b.J(r5);
    }

    public void setShowBorderOnlyBeforeL(boolean r5) {
        this.f12134b.K(r5);
    }

    public final void setTargetLeftPadding(int r5) {
        this.f12140l = r5;
    }

    public void setTopDividerAlpha(int r5) {
        this.f12134b.L(r5);
    }

    @Override // com.obric.oui.common.style.b
    public void setWidthMin(int r5) {
        this.f12134b.d = r5;
    }

    @JvmOverloads
    public OIconButton(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 0, 0, 28);
    }

    @JvmOverloads
    public OIconButton(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, 0, 24);
    }

    public OIconButton(Context r5, AttributeSet r10, int r11, int r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r11 = 0;
    L9:
        if ((r13 & 8) == 0) goto L11;
        r12 = 0;
    L11:
        k r14 = new k(r5, r10, r11, r12);
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r14, "provider");
        super(r5, r10, r11);
        this.f12133a = r14.f12510b;
        this.f12134b = r14.f12509a;
        this.f12135c = r14;
        this.f12138j = 1.0f;
        r14.b(this);
        setEnableShadowWidthRadius(true);
        this.d = (i) getLayoutHelper();
        g r15 = (g) getAlphaHelper();
        this.e = r15;
        if (r15 == null) goto L20;
        int r16 = getRadius();
        if (r15.f12468r == r16) goto L20;
        r15.f12468r = r16;
        View r17 = (View) r15.f12455a.get();
        if (r17 != null) goto L19;
        ps.a.c("OUIAlphaHelper", "setRadius: owner is null");
        goto L20
    L19:
        r15.c(r17);
    L20:
        this.f = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        TypedArray r18 = r5.obtainStyledAttributes(r10, R$styleable.OButton);
        this.f12136h = r18.getBoolean(R$styleable.OButton_oui_buttonChangeAlphaWhenPressed, false);
        this.f12138j = r18.getFloat(R$styleable.OButton_oui_widgetDisableAlpha, 1.0f);
        r18.recycle();
        a(isEnabled());
        this.f12140l = MathKt.roundToInt(16 * r5.getResources().getDisplayMetrics().density);
        if ((getBackground() instanceof ColorDrawable) == false) goto L27;
        GradientDrawable r19 = new GradientDrawable();
        r19.setShape(0);
        r19.setCornerRadius(getRadius());
        Drawable r20 = getBackground();
        if (r20 == null) goto L26;
        r19.setColor(((ColorDrawable) r20).getColor());
        setBackground(r19);
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    }
}
