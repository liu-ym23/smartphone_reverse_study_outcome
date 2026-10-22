package com.obric.oui.text;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
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
import u8.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B1\b\u0007\u0012\u0006\u0010A\u001a\u00020@\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B\u0012\b\b\u0002\u0010D\u001a\u00020\u0011\u0012\b\b\u0002\u0010F\u001a\u00020E¢\u0006\u0004\bG\u0010HJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0011\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0015H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\b\u0001\u0010\u0019\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010 \u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010%\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0015H\u0096\u0001J\u0011\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010*\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010.\u001a\u00020\u00072\b\b\u0001\u0010-\u001a\u00020\u0011H\u0096\u0001J\u0011\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0005H\u0096\u0001J\u0011\u00101\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0011H\u0096\u0001J\u0011\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0011H\u0096\u0001J\t\u00104\u001a\u00020\u0002H\u0096\u0001J\t\u00106\u001a\u000205H\u0096\u0001J\t\u00107\u001a\u00020\u0003H\u0096\u0001R*\u0010?\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006I"}, d2 = {"Lcom/obric/oui/text/OTextView;", "Landroid/widget/TextView;", "Lo9/a;", "Lo9/b;", "", "", "pressed", "", "setPressed", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "", TypedValues.Custom.S_COLOR, "setOverridePressColor", "getRadius", "", "getShadowAlpha", "getShadowColor", "getShadowElevation", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "radius", "setRadius", "setRightDividerAlpha", "shadowAlpha", "setShadowAlpha", "shadowColor", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "minWidth", "setWidthMin", "getAlphaHelper", "Lo9/j;", "getEffectHelper", "getLayoutHelper", EventBody.KEY_VALUE, "j", "Z", "getEnableAutoAlignLeft", "()Z", "setEnableAutoAlignLeft", "(Z)V", "enableAutoAlignLeft", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "Lo9/n;", "provider", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILo9/n;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
@SuppressLint({"AppCompatCustomView"})
public class OTextView extends TextView implements a, b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private k f7625c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private g f7626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private j f7627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f7628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f7629j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ a f7630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final /* synthetic */ b f7631l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final /* synthetic */ n f7632m;

    @JvmOverloads
    public OTextView(Context r10) {
        this(r10, null, 0, null, 14, null);
    }

    @JvmOverloads
    public OTextView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, null, 12, null);
    }

    @JvmOverloads
    public OTextView(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, null, 8, null);
    }

    @JvmOverloads
    public OTextView(Context r10, AttributeSet r11, int r12, n r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r13, "provider");
        super(r10, r11, r12);
        this.f7630k = r13.a();
        this.f7631l = r13.c();
        this.f7632m = r13;
        this.f7628i = getGravity();
        r13.d(this);
        b r14 = getLayoutHelper();
        Objects.requireNonNull(r14, "null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
        this.f7625c = (k) r14;
        a r15 = getAlphaHelper();
        Objects.requireNonNull(r15, "null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
        this.f7626g = (g) r15;
        this.f7627h = getEffectHelper();
        g r16 = this.f7626g;
        if (r16 == null) goto L5;
        r16.setChangeAlphaWhenPress(false);
    L5:
        g r17 = this.f7626g;
        if (r17 == null) goto L8;
        r17.setChangeAlphaWhenDisable(false);
    L8:
        setHighlightColor(r10.getColor(c.oui_text_highlight_color));
    }

    public /* synthetic */ OTextView(Context r10, AttributeSet r11, int r12, n r13, int r14, DefaultConstructorMarker r15) {
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

    private final void a() {
        int r10 = 1;
        if (getLineCount() > 1) goto L5;
        boolean r11 = true;
    L6:
        int r12 = this.f7628i & 112;
        if (r11 == true) goto L10;
        r10 = 3;
    L10:
        int r13 = r12 | r10;
        if (getGravity() == r13) goto L14;
        setGravity(r13);
        return;
    L14:
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // o9.b
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.f7631l.decideIsNeedUpdatePressedForegroundBySelf();
    }

    @Override // o9.a
    public void disablePressReleaseAnim(boolean r10) {
        this.f7630k.disablePressReleaseAnim(r10);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.dispatchDraw(r10);
        k r11 = this.f7625c;
        if (r11 == null) goto L5;
        r11.q(r10, getWidth(), getHeight());
    L5:
        k r12 = this.f7625c;
        if (r12 == null) goto L9;
        r12.o(r10);
        return;
    }

    @Override // android.view.View
    @RequiresApi(26)
    public void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        k r11 = this.f7625c;
        if (r11 == null) goto L5;
        r11.p(r10);
    L5:
        super.draw(r10);
    }

    public a getAlphaHelper() {
        return this.f7632m.a();
    }

    public j getEffectHelper() {
        return this.f7632m.b();
    }

    public final boolean getEnableAutoAlignLeft() {
        return this.f7629j;
    }

    public b getLayoutHelper() {
        return this.f7632m.c();
    }

    @Override // o9.b
    public int getRadius() {
        return this.f7631l.getRadius();
    }

    @Override // o9.b
    public float getShadowAlpha() {
        return this.f7631l.getShadowAlpha();
    }

    @Override // android.widget.TextView, o9.b
    public int getShadowColor() {
        return this.f7631l.getShadowColor();
    }

    @Override // o9.b
    public int getShadowElevation() {
        return this.f7631l.getShadowElevation();
    }

    @Override // o9.a
    public void handleTouchEvent(MotionEvent r10) {
        this.f7630k.handleTouchEvent(r10);
    }

    @Override // o9.b
    public boolean hasBorder() {
        return this.f7631l.hasBorder();
    }

    @Override // o9.b
    public boolean hasBottomSeparator() {
        return this.f7631l.hasBottomSeparator();
    }

    @Override // o9.b
    public boolean hasLeftSeparator() {
        return this.f7631l.hasLeftSeparator();
    }

    @Override // o9.b
    public boolean hasRightSeparator() {
        return this.f7631l.hasRightSeparator();
    }

    @Override // o9.b
    public boolean hasTopSeparator() {
        return this.f7631l.hasTopSeparator();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        if (this.f7629j == false) goto L6;
        a();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // o9.b
    public void onPressAlphaChange(int r10) {
        this.f7631l.onPressAlphaChange(r10);
    }

    @Override // o9.a
    public void onPressedChanged(View r10, boolean r11) {
        this.f7630k.onPressedChanged(r10, r11);
    }

    @Override // o9.a
    public void onSelectedChanged(View r10, boolean r11) {
        this.f7630k.onSelectedChanged(r10, r11);
    }

    @Override // o9.b
    public void onlyShowBottomDivider(int r10, int r11, int r12, int r13) {
        this.f7631l.onlyShowBottomDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void onlyShowLeftDivider(int r10, int r11, int r12, int r13) {
        this.f7631l.onlyShowLeftDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void onlyShowRightDivider(int r10, int r11, int r12, int r13) {
        this.f7631l.onlyShowRightDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void onlyShowTopDivider(int r10, int r11, int r12, int r13) {
        this.f7631l.onlyShowTopDivider(r10, r11, r12, r13);
    }

    @Override // o9.a
    public void refreshColors(String r10) {
        this.f7630k.refreshColors(r10);
    }

    @Override // o9.a
    public void resetAlphaAnim() {
        this.f7630k.resetAlphaAnim();
    }

    @Override // o9.b
    public void setBorderColor(@ColorInt int r10) {
        this.f7631l.setBorderColor(r10);
    }

    @Override // o9.b
    public void setBorderWidth(int r10) {
        this.f7631l.setBorderWidth(r10);
    }

    @Override // o9.b
    public void setBottomDividerAlpha(int r10) {
        this.f7631l.setBottomDividerAlpha(r10);
    }

    @Override // o9.a
    public void setChangeAlphaWhenDisable(boolean r10) {
        this.f7630k.setChangeAlphaWhenDisable(r10);
    }

    @Override // o9.a
    public void setChangeAlphaWhenPress(boolean r10) {
        this.f7630k.setChangeAlphaWhenPress(r10);
    }

    @Override // o9.a
    public void setChangeAlphaWhenSelected(boolean r10) {
        this.f7630k.setChangeAlphaWhenSelected(r10);
    }

    public final void setEnableAutoAlignLeft(boolean r10) {
        if (this.f7629j == r10) goto L6;
        this.f7629j = r10;
        requestLayout();
        return;
    }

    @Override // o9.b
    public boolean setHeightLimit(int r10) {
        return this.f7631l.setHeightLimit(r10);
    }

    @Override // o9.a
    public void setKeepPressAlpha(boolean r10) {
        this.f7630k.setKeepPressAlpha(r10);
    }

    @Override // o9.b
    public void setLeftDividerAlpha(int r10) {
        this.f7631l.setLeftDividerAlpha(r10);
    }

    @Override // o9.b
    public void setOuterNormalColor(int r10) {
        this.f7631l.setOuterNormalColor(r10);
    }

    @Override // o9.b
    public void setOutlineExcludePadding(boolean r10) {
        this.f7631l.setOutlineExcludePadding(r10);
    }

    @Override // o9.b
    public void setOutlineInset(int r10, int r11, int r12, int r13) {
        this.f7631l.setOutlineInset(r10, r11, r12, r13);
    }

    @Override // o9.a
    public void setOverridePressColor(int r10) {
        this.f7630k.setOverridePressColor(r10);
    }

    @Override // android.view.View
    public void setPressed(boolean r10) {
        j r11 = this.f7627h;
        if (r11 == null) goto L5;
        r11.u(r10);
    L5:
        super.setPressed(r10);
        g r12 = this.f7626g;
        if (r12 == null) goto L9;
        r12.onPressedChanged(this, r10);
        return;
    }

    @Override // o9.b
    public void setRadius(int r10) {
        this.f7631l.setRadius(r10);
    }

    @Override // o9.b
    public void setRadius(int r10, int r11, int r12, int r13) {
        this.f7631l.setRadius(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void setRadiusAndShadow(int r10, int r11, float r12) {
        this.f7631l.setRadiusAndShadow(r10, r11, r12);
    }

    @Override // o9.b
    public void setRadiusAndShadow(int r10, int r11, int r12, float r13) {
        this.f7631l.setRadiusAndShadow(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void setRightDividerAlpha(int r10) {
        this.f7631l.setRightDividerAlpha(r10);
    }

    @Override // o9.b
    public void setShadow(@Nullable p r10, @Nullable p r11) {
        this.f7631l.setShadow(r10, r11);
    }

    @Override // o9.b
    public void setShadowAlpha(float r10) {
        this.f7631l.setShadowAlpha(r10);
    }

    @Override // o9.b
    public void setShadowColor(int r10) {
        this.f7631l.setShadowColor(r10);
    }

    @Override // o9.b
    public void setShadowCornerRadius(int r10) {
        this.f7631l.setShadowCornerRadius(r10);
    }

    @Override // o9.b
    public void setShadowElevation(int r10) {
        this.f7631l.setShadowElevation(r10);
    }

    @Override // o9.b
    public void setShadowInsets(int r10, int r11) {
        this.f7631l.setShadowInsets(r10, r11);
    }

    @Override // o9.b
    public void setShadowStyle(@StyleRes int r10) {
        this.f7631l.setShadowStyle(r10);
    }

    @Override // o9.b
    public void setShowBorderOnlyBeforeL(boolean r10) {
        this.f7631l.setShowBorderOnlyBeforeL(r10);
    }

    @Override // o9.b
    public void setTopDividerAlpha(int r10) {
        this.f7631l.setTopDividerAlpha(r10);
    }

    @Override // o9.b
    public void setUseThemeGeneralShadowElevation() {
        this.f7631l.setUseThemeGeneralShadowElevation();
    }

    @Override // o9.b
    public boolean setWidthLimit(int r10) {
        return this.f7631l.setWidthLimit(r10);
    }

    @Override // o9.b
    public void setWidthMin(int r10) {
        this.f7631l.setWidthMin(r10);
    }

    @Override // o9.b
    public boolean shouldUpdateDividerColorOnPress() {
        return this.f7631l.shouldUpdateDividerColorOnPress();
    }

    @Override // o9.b
    public void updateBottomDivider(int r10, int r11, int r12, int r13) {
        this.f7631l.updateBottomDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void updateBottomSeparatorColor(int r10) {
        this.f7631l.updateBottomSeparatorColor(r10);
    }

    @Override // o9.b
    public void updateDividerColorStrength(float r10) {
        this.f7631l.updateDividerColorStrength(r10);
    }

    @Override // o9.b
    public void updateLeftDivider(int r10, int r11, int r12, int r13) {
        this.f7631l.updateLeftDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void updateLeftSeparatorColor(int r10) {
        this.f7631l.updateLeftSeparatorColor(r10);
    }

    @Override // o9.b
    public void updateRightDivider(int r10, int r11, int r12, int r13) {
        this.f7631l.updateRightDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void updateRightSeparatorColor(int r10) {
        this.f7631l.updateRightSeparatorColor(r10);
    }

    @Override // o9.b
    public void updateTopDivider(int r10, int r11, int r12, int r13) {
        this.f7631l.updateTopDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void updateTopSeparatorColor(int r10) {
        this.f7631l.updateTopSeparatorColor(r10);
    }
}
