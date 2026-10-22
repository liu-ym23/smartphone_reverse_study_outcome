package com.obric.oui.button;

import android.annotation.SuppressLint;
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
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$style;
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
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import zm.p;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\u000b\u0010\tJ\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\r\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\u000f\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J4\u0010\u0018\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00170\u0014H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cH\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u001f\u0010\u001bJ\u0010\u0010 \u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b \u0010\u001bJ\u001a\u0010\"\u001a\u00020\u00072\b\b\u0001\u0010!\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\"\u0010\u0013J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b$\u0010\u0013J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b&\u0010\u0013J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b(\u0010\tJ\u0018\u0010)\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b)\u0010\u0013J\u0018\u0010*\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b*\u0010\u0013J\u0018\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b,\u0010\tJ\u0018\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b.\u0010\u0013J\u0018\u0010/\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b/\u0010\u0013J\u0018\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u001cH\u0096\u0001¢\u0006\u0004\b1\u00102J\u0018\u00104\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b4\u0010\u0013J\u0018\u00105\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b5\u0010\u0013J\u0018\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b7\u0010\u0013J\u001a\u00109\u001a\u00020\u00072\b\b\u0001\u00108\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b9\u0010\u0013J\u0018\u0010;\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b;\u0010\tJ\u0018\u0010<\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b<\u0010\u0013J\u0018\u0010>\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b>\u0010\u0013J\u0010\u0010?\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b?\u0010@J\u0010\u0010B\u001a\u00020AH\u0096\u0001¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\bD\u0010EJ\u0015\u0010G\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0010¢\u0006\u0004\bG\u0010\u0013J\u0017\u0010I\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u0005H\u0016¢\u0006\u0004\bI\u0010\tJ\u0017\u0010K\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0005H\u0016¢\u0006\u0004\bK\u0010\tJ\u0017\u0010M\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0005H\u0016¢\u0006\u0004\bM\u0010\tJ\u0015\u0010O\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u001c¢\u0006\u0004\bO\u00102J\u0017\u0010P\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\bP\u0010\u0013J\u0017\u0010Q\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0005H\u0002¢\u0006\u0004\bQ\u0010\tR.\u0010Z\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010R8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR*\u0010_\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\u00108\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010\u001b\"\u0004\b^\u0010\u0013¨\u0006`"}, d2 = {"Lcom/obric/oui/button/OButton;", "Landroid/widget/Button;", "Lcom/obric/oui/common/style/a;", "Lcom/obric/oui/common/style/b;", "", "", "changeAlphaWhenDisable", "", "setChangeAlphaWhenDisable", "(Z)V", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "", "color", "setOverridePressColor", "(I)V", "", "Lcom/obric/oui/common/style/m;", "kotlin.jvm.PlatformType", "", "getCurrentShadows", "()Ljava/util/List;", "getRadius", "()I", "", "getShadowAlpha", "()F", "getShadowColor", "getShadowElevation", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "enableShadowWidthRadius", "setEnableShadowWidthRadius", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "(F)V", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "minWidth", "setWidthMin", "getAlphaHelper", "()Lcom/obric/oui/common/style/a;", "Lcom/obric/oui/common/style/h;", "getEffectHelper", "()Lcom/obric/oui/common/style/h;", "getLayoutHelper", "()Lcom/obric/oui/common/style/b;", "resId", "setButtonSourceBitmap", "selected", "setSelected", "enabled", "setEnabled", "pressed", "setPressed", "alpha", "setDisabledTextAlpha", "setTextColor", "setPressState", "Landroid/graphics/drawable/Drawable;", "value", "f", "Landroid/graphics/drawable/Drawable;", "getMIcon", "()Landroid/graphics/drawable/Drawable;", "setMIcon", "(Landroid/graphics/drawable/Drawable;)V", "mIcon", "h", "I", "getMImageTintColorId", "setMImageTintColorId", "mImageTintColorId", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"AppCompatCustomView"})
public class OButton extends Button implements a, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f12119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f12120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f12121c;
    public final g d;
    public final h e;
    public Drawable f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12122h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f12123i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12124j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12125k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f12126l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f12127m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f12128n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f12129o;

    @JvmOverloads
    public OButton(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 0, 28);
    }

    private final void setPressState(boolean r5) {
        if (this.f12123i != r5) goto L6;
        ps.a.g("OButton", Intrinsics.stringPlus("setPressState, already set, skip! pressed: ", Boolean.valueOf(r5)));
        return;
    L6:
        this.f12123i = r5;
        h r10 = this.e;
        if (r10 == null) goto L10;
        r10.f(r5);
    L10:
        g r11 = this.d;
        if (r11 == null) goto L15;
        r11.e(r5);
        return;
    }

    public final void a(boolean r5) {
        int r10 = getPaddingTop();
        int r11 = getPaddingRight();
        int r12 = getPaddingBottom();
        if (r5 == false) goto L5;
        int r13 = getPaddingRight() - this.f12127m;
    L7:
        if (r13 == getPaddingLeft()) goto L10;
        setPadding(r13, r10, r11, r12);
        return;
    L10:
        return;
    L5:
        r13 = getPaddingRight();
        goto L7
    }

    @Override // com.obric.oui.common.style.b
    public final void c(List r5) {
        this.f12120b.c(r5);
    }

    @Override // com.obric.oui.common.style.b
    public final boolean d() {
        return this.f12120b.J;
    }

    public final void e(boolean r10) {
        int r5 = this.f12124j;
        if (r5 != 0) goto L5;
        return;
    L5:
        int r11 = 0;
        if (r10 == true) goto L14;
        int r12 = p.n(this.f12128n, r5);
        this.f12129o = true;
        super.setTextColor(r12);
        this.f12129o = false;
        Drawable[] r13 = getCompoundDrawables();
        int r14 = r13.length;
    L8:
        if (r11 >= r14) goto L21;
        Drawable r15 = r13[r11];
        if (r15 == null) goto L13;
        r15.setAlpha((int) (this.f12128n * 255));
    L13:
        r11 = r11 + 1;
    L21:
        invalidate();
        return;
    L14:
        this.f12129o = true;
        super.setTextColor(r5);
        this.f12129o = false;
        Drawable[] r16 = getCompoundDrawables();
        int r17 = r16.length;
    L15:
        if (r11 >= r17) goto L21;
        Drawable r18 = r16[r11];
        if (r18 == null) goto L20;
        r18.setAlpha(255);
    L20:
        r11 = r11 + 1;
        goto L15
    }

    @Override // com.obric.oui.common.style.b
    public final boolean g() {
        this.f12120b.getClass();
        return false;
    }

    public a getAlphaHelper() {
        return this.f12121c.f12510b;
    }

    @Override // com.obric.oui.common.style.b
    public List<m> getCurrentShadows() {
        return this.f12120b.getCurrentShadows();
    }

    public h getEffectHelper() {
        return this.f12121c.a();
    }

    public b getLayoutHelper() {
        return this.f12121c.f12509a;
    }

    public final Drawable getMIcon() {
        return this.f;
    }

    public final int getMImageTintColorId() {
        return this.f12122h;
    }

    public int getRadius() {
        return this.f12120b.C;
    }

    public float getShadowAlpha() {
        return this.f12120b.U;
    }

    @Override // android.widget.TextView
    public int getShadowColor() {
        return this.f12120b.V;
    }

    public int getShadowElevation() {
        return this.f12120b.T;
    }

    @Override // com.obric.oui.common.style.a
    public final void h(View r5, boolean r10) {
        this.f12119a.h(r5, r10);
    }

    @Override // com.obric.oui.common.style.a
    public final void i(String r5) {
        this.f12119a.i(r5);
    }

    @Override // com.obric.oui.common.style.b
    public final void j(int r13) {
        if (this.f12126l == true) goto L5;
        return;
    L5:
        float r14 = RangesKt.coerceIn(r13 / 255.0f, 0.0f, 1.0f);
        int r5 = this.f12124j;
        if (r5 == 0) goto L9;
        int r10 = (r5 >> 24) & 255;
        int r11 = RangesKt.coerceIn((int) ((1 - (r14 * 0.7f)) * r10), 0, 255);
        int r12 = ((r5 >> 16) & 255) << 16;
        setTextColor((r5 & 255) | ((r12 | (r11 << 24)) | (((r5 >> 8) & 255) << 8)));
        ps.a.a("OButton", "updateTextColorOnPress, fraction: " + r14 + ", newTextAlpha: " + r11 + ", originTextAlpha: " + r10);
    L9:
        int r15 = this.f12125k;
        if (r15 == 0) goto L18;
        int r16 = RangesKt.coerceIn((int) ((1 - (0.7f * r14)) * r15), 0, 255);
        Drawable r17 = this.f;
        if (r17 == null) goto L16;
        r17.setAlpha(r16);
    L16:
        ps.a.a("OButton", "updateIconAlphaOnPress, fraction: " + r14 + ", alpha: " + r16 + ", originIconAlpha: " + this.f12125k);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public final boolean k() {
        this.f12120b.getClass();
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final void l(m r5, m r10, boolean r11) {
        this.f12120b.l(r5, r10, false);
    }

    @Override // com.obric.oui.common.style.b
    public final void m(float r5) {
        this.f12120b.m(r5);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        if (r10 == null) goto L13;
        Drawable r5 = this.f;
        if (r5 == null) goto L14;
        int r11 = (getWidth() - r5.getIntrinsicWidth()) / 2;
        int r12 = (getHeight() - r5.getIntrinsicHeight()) / 2;
        r5.setBounds(r11, r12, r5.getIntrinsicWidth() + r11, r5.getIntrinsicHeight() + r12);
        if (this.f12122h == 0) goto L11;
        r5.setColorFilter(new PorterDuffColorFilter(getResources().getColor(this.f12122h), PorterDuff.Mode.SRC_IN));
    L11:
        r5.draw(r10);
        return;
    L14:
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        int r11 = getMeasuredWidth();
        int r12 = getMeasuredHeight();
        Drawable r13 = this.f;
        if (r13 == null) goto L6;
        int r14 = r13.getIntrinsicWidth();
        int r15 = getPaddingLeft() + r14;
        r11 = Math.max(r11, getPaddingRight() + r15);
        int r16 = r13.getIntrinsicHeight();
        int r17 = getPaddingTop() + r16;
        r12 = Math.max(r12, getPaddingBottom() + r17);
    L6:
        setMeasuredDimension(r11, r12);
    }

    public void setBorderColor(@ColorInt int r5) {
        this.f12120b.w(r5);
    }

    public void setBorderWidth(int r5) {
        this.f12120b.x(r5);
    }

    public void setBottomDividerAlpha(int r5) {
        this.f12120b.y(r5);
    }

    public final void setButtonSourceBitmap(int r5) {
        if (r5 != 0) goto L4;
        return;
    L4:
        setMIcon(ContextCompat.getDrawable(getContext(), r5));
        Drawable r10 = this.f;
        if (r10 != null) goto L7;
        int r11 = 0;
    L8:
        this.f12125k = r11;
        invalidate();
        return;
    L7:
        r11 = r10.getAlpha();
        goto L8
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r5) {
        this.f12119a.setChangeAlphaWhenDisable(r5);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r5) {
        this.f12119a.setChangeAlphaWhenPress(r5);
    }

    public void setChangeAlphaWhenSelected(boolean r5) {
        this.f12119a.e = r5;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable r5, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawables(r5, r10, r11, r12);
        if (r5 == null) goto L5;
        boolean r13 = true;
    L6:
        a(r13);
        return;
    L5:
        r13 = false;
        goto L6
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable r5, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawablesRelative(r5, r10, r11, r12);
        if (r5 == null) goto L5;
        boolean r13 = true;
    L6:
        a(r13);
        return;
    L5:
        r13 = false;
        goto L6
    }

    public final void setDisabledTextAlpha(float r5) {
        this.f12128n = r5;
        if (isEnabled() == true) goto L6;
        e(false);
        return;
    }

    public void setEnableShadowWidthRadius(boolean r5) {
        this.f12120b.z(r5);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        g r10 = this.d;
        if (r10 == null) goto L6;
        r10.d(this, r5);
    L6:
        e(r5);
    }

    public /* bridge */ /* synthetic */ void setFakePressed(boolean r5) {
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(boolean r5) {
        this.f12119a.setKeepPressAlpha(r5);
    }

    public void setLeftDividerAlpha(int r5) {
        this.f12120b.A(r5);
    }

    public final void setMIcon(Drawable r5) {
        this.f = r5;
        requestLayout();
        invalidate();
    }

    public final void setMImageTintColorId(int r5) {
        this.f12122h = r5;
        invalidate();
    }

    public void setOuterNormalColor(int r5) {
        this.f12120b.B(r5);
    }

    public void setOutlineExcludePadding(boolean r5) {
        this.f12120b.C(r5);
    }

    public void setOverridePressColor(int r5) {
        this.f12119a.g(r5);
    }

    @Override // android.view.View
    public void setPressed(boolean r5) {
        super.setPressed(r5);
        h r10 = this.e;
        if (r10 == null) goto L6;
        r10.f(r5);
    L6:
        g r11 = this.d;
        if (r11 == null) goto L11;
        r11.e(r5);
        return;
    }

    public void setRadius(int r5) {
        this.f12120b.D(r5);
    }

    public void setRightDividerAlpha(int r5) {
        this.f12120b.F(r5);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r5) {
        super.setSelected(r5);
        g r10 = this.d;
        if (r10 == null) goto L7;
        r10.h(this, r5);
        return;
    }

    public void setShadowAlpha(float r5) {
        this.f12120b.G(r5);
    }

    public void setShadowColor(int r5) {
        this.f12120b.H(r5);
    }

    public void setShadowCornerRadius(int r5) {
        this.f12120b.i0 = r5;
    }

    public void setShadowElevation(int r5) {
        this.f12120b.I(r5);
    }

    public void setShadowStyle(@StyleRes int r5) {
        this.f12120b.J(r5);
    }

    public void setShowBorderOnlyBeforeL(boolean r5) {
        this.f12120b.K(r5);
    }

    @Override // android.widget.TextView
    public void setTextColor(int r5) {
        if (this.f12129o == true) goto L5;
        this.f12124j = r5;
    L5:
        super.setTextColor(r5);
    }

    public void setTopDividerAlpha(int r5) {
        this.f12120b.L(r5);
    }

    @Override // com.obric.oui.common.style.b
    public void setWidthMin(int r5) {
        this.f12120b.d = r5;
    }

    @JvmOverloads
    public OButton(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, r11, 24);
    }

    public OButton(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r12 & 4) == 0) goto L5;
        r11 = 0;
    L5:
        k r13 = new k(r5, r10, r11, 0);
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r13, "provider");
        super(r5, r10, r11);
        this.f12119a = r13.f12510b;
        i r14 = r13.f12509a;
        this.f12120b = r14;
        this.f12121c = r13;
        this.f12128n = 1.0f;
        r14.f12485d0 = true;
        r13.b(this);
        i r15 = (i) getLayoutHelper();
        this.d = (g) getAlphaHelper();
        this.e = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        TypedArray r16 = r5.obtainStyledAttributes(r10, R$styleable.OButton);
        this.g = r16.getResourceId(R$styleable.OButton_icon, 0);
        setMImageTintColorId(r16.getResourceId(R$styleable.OButton_iconTint, 0));
        int r17 = this.g;
        if (r17 == 0) goto L8;
        setButtonSourceBitmap(r17);
    L8:
        setTextAppearance(r16.getResourceId(R$styleable.OButton_oui_buttonTextStyle, R$style.Title_Title_M_Thick));
        this.f12126l = r16.getBoolean(R$styleable.OButton_oui_buttonChangeAlphaWhenPressed, false);
        int r18 = getCurrentTextColor();
        this.f12124j = r18;
        setCompoundDrawableTintList(ColorStateList.valueOf(r18));
        this.f12127m = r16.getDimensionPixelSize(R$styleable.OButton_oui_widgetPaddingOffset, 0);
        if (((Drawable) ArraysKt.getOrNull(getCompoundDrawables(), 0)) == null) goto L11;
        a(true);
    L11:
        this.f12128n = r16.getFloat(R$styleable.OButton_oui_widgetDisableAlpha, 1.0f);
        r16.recycle();
        e(isEnabled());
    }
}
