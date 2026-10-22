package com.obric.oui.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o9.a;
import o9.b;
import o9.g;
import o9.j;
import o9.k;
import o9.n;
import o9.p;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B1\b\u0007\u0012\u0006\u0010A\u001a\u00020@\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B\u0012\b\b\u0002\u0010D\u001a\u00020\u000f\u0012\b\b\u0002\u0010F\u001a\u00020E¢\u0006\u0004\bG\u0010HJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0011\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u001c\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u001e\u001a\u00020\u001dH\u0096\u0001J\t\u0010\u001f\u001a\u00020\u000fH\u0096\u0001J\t\u0010 \u001a\u00020\u000fH\u0096\u0001J\u0013\u0010\"\u001a\u00020\u00072\b\b\u0001\u0010!\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010'\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010(\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010-\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u001dH\u0096\u0001J\u0011\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u000fH\u0096\u0001J\u0011\u00102\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u000fH\u0096\u0001J\u0011\u00104\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u000fH\u0096\u0001J\u0013\u00106\u001a\u00020\u00072\b\b\u0001\u00105\u001a\u00020\u000fH\u0096\u0001J\u0011\u00108\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0005H\u0096\u0001J\u0011\u00109\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010;\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u000fH\u0096\u0001J\t\u0010<\u001a\u00020\u0002H\u0096\u0001J\t\u0010>\u001a\u00020=H\u0096\u0001J\t\u0010?\u001a\u00020\u0003H\u0096\u0001¨\u0006I"}, d2 = {"Lcom/obric/oui/layout/OUILinearLayout;", "Landroid/widget/LinearLayout;", "Lo9/a;", "Lo9/b;", "", "", "pressed", "", "setPressed", "enabled", "setEnabled", "setVibrateEnabled", "setSoundEffectEnabled", "selected", "setSelected", "", "minHeight", "setMinimumHeight", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", TypedValues.Custom.S_COLOR, "setOverridePressColor", "getRadius", "", "getShadowAlpha", "getShadowColor", "getShadowElevation", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "minWidth", "setWidthMin", "getAlphaHelper", "Lo9/j;", "getEffectHelper", "getLayoutHelper", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "Lo9/n;", "provider", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILo9/n;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OUILinearLayout extends LinearLayout implements a, b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private k f6845c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private g f6846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private j f6847h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ a f6848i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ b f6849j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ n f6850k;

    @JvmOverloads
    public OUILinearLayout(Context r10) {
        this(r10, null, 0, null, 14, null);
    }

    @JvmOverloads
    public OUILinearLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 0, null, 12, null);
    }

    @JvmOverloads
    public OUILinearLayout(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, null, 8, null);
    }

    @JvmOverloads
    public OUILinearLayout(Context r10, AttributeSet r11, int r12, n r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r13, "provider");
        super(r10, r11);
        this.f6848i = r13.a();
        this.f6849j = r13.c();
        this.f6850k = r13;
        r13.d(this);
        b r14 = getLayoutHelper();
        Objects.requireNonNull(r14, "null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
        this.f6845c = (k) r14;
        a r15 = getAlphaHelper();
        Objects.requireNonNull(r15, "null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
        this.f6846g = (g) r15;
        this.f6847h = getEffectHelper();
        a(r10, r11, r12);
    }

    public /* synthetic */ OUILinearLayout(Context r10, AttributeSet r11, int r12, n r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = new n(r10, r11, r12, 0);
    L11:
        this(r10, r11, r12, r13);
    }

    public final void a(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        setVibrateEnabled(false);
        setSoundEffectEnabled(false);
        setWillNotDraw(false);
    }

    @Override // o9.b
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.f6849j.decideIsNeedUpdatePressedForegroundBySelf();
    }

    @Override // o9.a
    public void disablePressReleaseAnim(boolean r10) {
        this.f6848i.disablePressReleaseAnim(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.dispatchDraw(r10);
        k r11 = this.f6845c;
        if (r11 == null) goto L5;
        r11.q(r10, getWidth(), getHeight());
    L5:
        k r12 = this.f6845c;
        if (r12 == null) goto L9;
        r12.o(r10);
        return;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        j r11 = this.f6847h;
        if (r11 == null) goto L6;
        r11.c(r10);
    L6:
        return super.dispatchGenericMotionEvent(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        j r11 = this.f6847h;
        if (r11 == null) goto L5;
        r11.d(r10);
    L5:
        g r12 = this.f6846g;
        if (r12 == null) goto L9;
        r12.handleTouchEvent(r10);
    L9:
        return super.dispatchTouchEvent(r10);
    }

    @Override // android.view.View
    @RequiresApi(26)
    public void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        k r11 = this.f6845c;
        if (r11 == null) goto L5;
        r11.p(r10);
    L5:
        super.draw(r10);
    }

    public a getAlphaHelper() {
        return this.f6850k.a();
    }

    public j getEffectHelper() {
        return this.f6850k.b();
    }

    public b getLayoutHelper() {
        return this.f6850k.c();
    }

    @Override // o9.b
    public int getRadius() {
        return this.f6849j.getRadius();
    }

    @Override // o9.b
    public float getShadowAlpha() {
        return this.f6849j.getShadowAlpha();
    }

    @Override // o9.b
    public int getShadowColor() {
        return this.f6849j.getShadowColor();
    }

    @Override // o9.b
    public int getShadowElevation() {
        return this.f6849j.getShadowElevation();
    }

    @Override // o9.a
    public void handleTouchEvent(MotionEvent r10) {
        this.f6848i.handleTouchEvent(r10);
    }

    @Override // o9.b
    public boolean hasBorder() {
        return this.f6849j.hasBorder();
    }

    @Override // o9.b
    public boolean hasBottomSeparator() {
        return this.f6849j.hasBottomSeparator();
    }

    @Override // o9.b
    public boolean hasLeftSeparator() {
        return this.f6849j.hasLeftSeparator();
    }

    @Override // o9.b
    public boolean hasRightSeparator() {
        return this.f6849j.hasRightSeparator();
    }

    @Override // o9.b
    public boolean hasTopSeparator() {
        return this.f6849j.hasTopSeparator();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        j r10 = this.f6847h;
        if (r10 == null) goto L6;
        r10.m();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j r10 = this.f6847h;
        if (r10 == null) goto L6;
        r10.n();
        return;
    }

    @Override // android.view.View
    public void onHoverChanged(boolean r10) {
        super.onHoverChanged(r10);
        j r11 = this.f6847h;
        if (r11 == null) goto L6;
        r11.o(r10);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        k r12 = this.f6845c;
        if (r12 == null) goto L8;
        Intrinsics.checkNotNull(r12);
        int r13 = r12.x(r10);
        k r14 = this.f6845c;
        Intrinsics.checkNotNull(r14);
        int r15 = r14.w(r11);
        super.onMeasure(r13, r15);
        k r16 = this.f6845c;
        Intrinsics.checkNotNull(r16);
        int r17 = r16.A(r13, getMeasuredWidth());
        k r18 = this.f6845c;
        Intrinsics.checkNotNull(r18);
        int r19 = r18.z(r15, getMeasuredHeight());
        if (r13 != r17) goto L7;
        if (r15 != r19) goto L7;
        return;
    L7:
        super.onMeasure(r17, r19);
        return;
    L8:
        super.onMeasure(r10, r11);
    }

    public void onPressAlphaChange(int r10) {
        this.f6849j.onPressAlphaChange(r10);
    }

    @Override // o9.a
    public void onPressedChanged(View r10, boolean r11) {
        this.f6848i.onPressedChanged(r10, r11);
    }

    @Override // o9.a
    public void onSelectedChanged(View r10, boolean r11) {
        this.f6848i.onSelectedChanged(r10, r11);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int r10) {
        super.onWindowVisibilityChanged(r10);
        j r11 = this.f6847h;
        if (r11 == null) goto L6;
        r11.s(r10);
        return;
    }

    @Override // o9.b
    public void onlyShowBottomDivider(int r10, int r11, int r12, int r13) {
        this.f6849j.onlyShowBottomDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void onlyShowLeftDivider(int r10, int r11, int r12, int r13) {
        this.f6849j.onlyShowLeftDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void onlyShowRightDivider(int r10, int r11, int r12, int r13) {
        this.f6849j.onlyShowRightDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void onlyShowTopDivider(int r10, int r11, int r12, int r13) {
        this.f6849j.onlyShowTopDivider(r10, r11, r12, r13);
    }

    @Override // o9.a
    public void refreshColors(String r10) {
        this.f6848i.refreshColors(r10);
    }

    @Override // o9.a
    public void resetAlphaAnim() {
        this.f6848i.resetAlphaAnim();
    }

    @Override // o9.b
    public void setBorderColor(@ColorInt int r10) {
        this.f6849j.setBorderColor(r10);
    }

    @Override // o9.b
    public void setBorderWidth(int r10) {
        this.f6849j.setBorderWidth(r10);
    }

    @Override // o9.b
    public void setBottomDividerAlpha(int r10) {
        this.f6849j.setBottomDividerAlpha(r10);
    }

    @Override // o9.a
    public void setChangeAlphaWhenDisable(boolean r10) {
        this.f6848i.setChangeAlphaWhenDisable(r10);
    }

    @Override // o9.a
    public void setChangeAlphaWhenPress(boolean r10) {
        this.f6848i.setChangeAlphaWhenPress(r10);
    }

    @Override // o9.a
    public void setChangeAlphaWhenSelected(boolean r10) {
        this.f6848i.setChangeAlphaWhenSelected(r10);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        g r11 = this.f6846g;
        if (r11 == null) goto L6;
        r11.n(this, r10);
        return;
    }

    @Override // o9.b
    public boolean setHeightLimit(int r10) {
        k r11 = this.f6845c;
        if (r11 == null) goto L8;
        Intrinsics.checkNotNull(r11);
        if (r11.setHeightLimit(r10) == false) goto L10;
        requestLayout();
        invalidate();
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @Override // o9.a
    public void setKeepPressAlpha(boolean r10) {
        this.f6848i.setKeepPressAlpha(r10);
    }

    @Override // o9.b
    public void setLeftDividerAlpha(int r10) {
        this.f6849j.setLeftDividerAlpha(r10);
    }

    @Override // android.view.View
    public void setMinimumHeight(int r10) {
        k r11 = this.f6845c;
        if (r11 == null) goto L5;
        r11.I(r10);
    L5:
        super.setMinimumHeight(r10);
    }

    @Override // o9.b
    public void setOuterNormalColor(int r10) {
        this.f6849j.setOuterNormalColor(r10);
    }

    @Override // o9.b
    public void setOutlineExcludePadding(boolean r10) {
        this.f6849j.setOutlineExcludePadding(r10);
    }

    @Override // o9.b
    public void setOutlineInset(int r10, int r11, int r12, int r13) {
        this.f6849j.setOutlineInset(r10, r11, r12, r13);
    }

    @Override // o9.a
    public void setOverridePressColor(int r10) {
        this.f6848i.setOverridePressColor(r10);
    }

    @Override // android.view.View
    public void setPressed(boolean r10) {
        j r11 = this.f6847h;
        if (r11 == null) goto L5;
        r11.u(r10);
    L5:
        super.setPressed(r10);
        g r12 = this.f6846g;
        if (r12 == null) goto L9;
        r12.onPressedChanged(this, r10);
        return;
    }

    @Override // o9.b
    public void setRadius(int r10) {
        this.f6849j.setRadius(r10);
    }

    @Override // o9.b
    public void setRadius(int r10, int r11, int r12, int r13) {
        this.f6849j.setRadius(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void setRadiusAndShadow(int r10, int r11, float r12) {
        this.f6849j.setRadiusAndShadow(r10, r11, r12);
    }

    @Override // o9.b
    public void setRadiusAndShadow(int r10, int r11, int r12, float r13) {
        this.f6849j.setRadiusAndShadow(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void setRightDividerAlpha(int r10) {
        this.f6849j.setRightDividerAlpha(r10);
    }

    @Override // android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        g r11 = this.f6846g;
        if (r11 == null) goto L6;
        r11.onSelectedChanged(this, r10);
        return;
    }

    @Override // o9.b
    public void setShadow(@Nullable p r10, @Nullable p r11) {
        this.f6849j.setShadow(r10, r11);
    }

    @Override // o9.b
    public void setShadowAlpha(float r10) {
        this.f6849j.setShadowAlpha(r10);
    }

    @Override // o9.b
    public void setShadowColor(int r10) {
        this.f6849j.setShadowColor(r10);
    }

    @Override // o9.b
    public void setShadowCornerRadius(int r10) {
        this.f6849j.setShadowCornerRadius(r10);
    }

    @Override // o9.b
    public void setShadowElevation(int r10) {
        this.f6849j.setShadowElevation(r10);
    }

    @Override // o9.b
    public void setShadowInsets(int r10, int r11) {
        this.f6849j.setShadowInsets(r10, r11);
    }

    @Override // o9.b
    public void setShadowStyle(@StyleRes int r10) {
        this.f6849j.setShadowStyle(r10);
    }

    @Override // o9.b
    public void setShowBorderOnlyBeforeL(boolean r10) {
        this.f6849j.setShowBorderOnlyBeforeL(r10);
    }

    public final void setSoundEffectEnabled(boolean r10) {
        j r11 = this.f6847h;
        if (r11 == null) goto L6;
        r11.v(r10);
        return;
    }

    @Override // o9.b
    public void setTopDividerAlpha(int r10) {
        this.f6849j.setTopDividerAlpha(r10);
    }

    @Override // o9.b
    public void setUseThemeGeneralShadowElevation() {
        this.f6849j.setUseThemeGeneralShadowElevation();
    }

    public final void setVibrateEnabled(boolean r10) {
        j r11 = this.f6847h;
        if (r11 == null) goto L6;
        r11.w(r10);
        return;
    }

    @Override // o9.b
    public boolean setWidthLimit(int r10) {
        k r11 = this.f6845c;
        if (r11 == null) goto L8;
        Intrinsics.checkNotNull(r11);
        if (r11.setWidthLimit(r10) == false) goto L10;
        requestLayout();
        invalidate();
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @Override // o9.b
    public void setWidthMin(int r10) {
        this.f6849j.setWidthMin(r10);
    }

    @Override // o9.b
    public boolean shouldUpdateDividerColorOnPress() {
        return this.f6849j.shouldUpdateDividerColorOnPress();
    }

    @Override // o9.b
    public void updateBottomDivider(int r10, int r11, int r12, int r13) {
        this.f6849j.updateBottomDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void updateBottomSeparatorColor(int r10) {
        this.f6849j.updateBottomSeparatorColor(r10);
    }

    @Override // o9.b
    public void updateDividerColorStrength(float r10) {
        this.f6849j.updateDividerColorStrength(r10);
    }

    @Override // o9.b
    public void updateLeftDivider(int r10, int r11, int r12, int r13) {
        this.f6849j.updateLeftDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void updateLeftSeparatorColor(int r10) {
        this.f6849j.updateLeftSeparatorColor(r10);
    }

    @Override // o9.b
    public void updateRightDivider(int r10, int r11, int r12, int r13) {
        this.f6849j.updateRightDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void updateRightSeparatorColor(int r10) {
        this.f6849j.updateRightSeparatorColor(r10);
    }

    @Override // o9.b
    public void updateTopDivider(int r10, int r11, int r12, int r13) {
        this.f6849j.updateTopDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void updateTopSeparatorColor(int r10) {
        this.f6849j.updateTopSeparatorColor(r10);
    }
}
