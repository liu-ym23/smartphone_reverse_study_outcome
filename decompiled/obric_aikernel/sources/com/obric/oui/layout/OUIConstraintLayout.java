package com.obric.oui.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B5\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010 \u0001\u001a\u00030\u009f\u0001¢\u0006\u0006\b¡\u0001\u0010¢\u0001J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tJ\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0014J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0017J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0011H\u0016J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001fH\u0016J\u000e\u0010#\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0011J\u000e\u0010$\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0011J\b\u0010%\u001a\u00020\u000bH\u0014J\b\u0010&\u001a\u00020\u000bH\u0014J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\tH\u0014J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0011H\u0016J\u0011\u0010,\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0011H\u0096\u0001J\u0019\u0010.\u001a\u00020\u000b2\u000e\u0010 \u001a\n -*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J!\u00101\u001a\u00020\u000b2\u000e\u00100\u001a\n -*\u0004\u0018\u00010/0/2\u0006\u0010\u0019\u001a\u00020\u0011H\u0096\u0001J!\u00102\u001a\u00020\u000b2\u000e\u00100\u001a\n -*\u0004\u0018\u00010/0/2\u0006\u0010\u0019\u001a\u00020\u0011H\u0096\u0001J\u0019\u00105\u001a\u00020\u000b2\u000e\u00104\u001a\n -*\u0004\u0018\u00010303H\u0096\u0001J\t\u00106\u001a\u00020\u000bH\u0096\u0001J\u0011\u00108\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010:\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010<\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010>\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010@\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\tH\u0096\u0001J\t\u0010A\u001a\u00020\u0011H\u0096\u0001J\t\u0010B\u001a\u00020\tH\u0096\u0001J\t\u0010D\u001a\u00020CH\u0096\u0001J\t\u0010E\u001a\u00020\tH\u0096\u0001J\t\u0010F\u001a\u00020\tH\u0096\u0001J\t\u0010G\u001a\u00020\u0011H\u0096\u0001J\t\u0010H\u001a\u00020\u0011H\u0096\u0001J\t\u0010I\u001a\u00020\u0011H\u0096\u0001J\t\u0010J\u001a\u00020\u0011H\u0096\u0001J\t\u0010K\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010M\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\tH\u0096\u0001J)\u0010R\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\tH\u0096\u0001J)\u0010W\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\t2\u0006\u0010V\u001a\u00020\tH\u0096\u0001J)\u0010\\\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020\tH\u0096\u0001J)\u0010a\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020\tH\u0096\u0001J\u0013\u0010c\u001a\u00020\u000b2\b\b\u0001\u0010b\u001a\u00020\tH\u0096\u0001J\u0011\u0010e\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020\tH\u0096\u0001J\u0011\u0010g\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\tH\u0096\u0001J\u0011\u0010h\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\tH\u0096\u0001J\u0011\u0010i\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\tH\u0096\u0001J\u0011\u0010k\u001a\u00020\u000b2\u0006\u0010j\u001a\u00020\u0011H\u0096\u0001J)\u0010p\u001a\u00020\u000b2\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020\t2\u0006\u0010n\u001a\u00020\t2\u0006\u0010o\u001a\u00020\tH\u0096\u0001J\u0011\u0010r\u001a\u00020\u000b2\u0006\u0010q\u001a\u00020\tH\u0096\u0001J)\u0010r\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\t2\u0006\u0010t\u001a\u00020\t2\u0006\u0010u\u001a\u00020\t2\u0006\u0010v\u001a\u00020\tH\u0096\u0001J!\u0010y\u001a\u00020\u000b2\u0006\u0010q\u001a\u00020\t2\u0006\u0010w\u001a\u00020\t2\u0006\u0010x\u001a\u00020CH\u0096\u0001J)\u0010y\u001a\u00020\u000b2\u0006\u0010q\u001a\u00020\t2\u0006\u0010w\u001a\u00020\t2\u0006\u0010z\u001a\u00020\t2\u0006\u0010x\u001a\u00020CH\u0096\u0001J\u0011\u0010{\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\tH\u0096\u0001J!\u0010\u007f\u001a\u00020\u000b2\n\b\u0001\u0010}\u001a\u0004\u0018\u00010|2\n\b\u0001\u0010~\u001a\u0004\u0018\u00010|H\u0096\u0001J\u0012\u0010\u0080\u0001\u001a\u00020\u000b2\u0006\u0010x\u001a\u00020CH\u0096\u0001J\u0012\u0010\u0081\u0001\u001a\u00020\u000b2\u0006\u0010z\u001a\u00020\tH\u0096\u0001J\u0012\u0010\u0082\u0001\u001a\u00020\u000b2\u0006\u0010q\u001a\u00020\tH\u0096\u0001J\u0013\u0010\u0084\u0001\u001a\u00020\u000b2\u0007\u0010\u0083\u0001\u001a\u00020\tH\u0096\u0001J\u001c\u0010\u0087\u0001\u001a\u00020\u000b2\u0007\u0010\u0085\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020\tH\u0096\u0001J\u0015\u0010\u0089\u0001\u001a\u00020\u000b2\t\b\u0001\u0010\u0088\u0001\u001a\u00020\tH\u0096\u0001J\u0013\u0010\u008b\u0001\u001a\u00020\u000b2\u0007\u0010\u008a\u0001\u001a\u00020\u0011H\u0096\u0001J\u0012\u0010\u008c\u0001\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\tH\u0096\u0001J\n\u0010\u008d\u0001\u001a\u00020\u000bH\u0096\u0001J\u0013\u0010\u008f\u0001\u001a\u00020\u000b2\u0007\u0010\u008e\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u0090\u0001\u001a\u00020\u0011H\u0096\u0001J*\u0010\u0091\u0001\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\tH\u0096\u0001J\u0012\u0010\u0092\u0001\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\tH\u0096\u0001J\u0013\u0010\u0094\u0001\u001a\u00020\u000b2\u0007\u0010\u0093\u0001\u001a\u00020CH\u0096\u0001J*\u0010\u0095\u0001\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\t2\u0006\u0010V\u001a\u00020\tH\u0096\u0001J\u0012\u0010\u0096\u0001\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\tH\u0096\u0001J*\u0010\u0097\u0001\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020\tH\u0096\u0001J\u0012\u0010\u0098\u0001\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\tH\u0096\u0001J*\u0010\u0099\u0001\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020\tH\u0096\u0001J\u0012\u0010\u009a\u0001\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\tH\u0096\u0001J\n\u0010\u009b\u0001\u001a\u00020\u0002H\u0096\u0001J\u000b\u0010\u009d\u0001\u001a\u00030\u009c\u0001H\u0096\u0001J\n\u0010\u009e\u0001\u001a\u00020\u0003H\u0096\u0001¨\u0006£\u0001"}, d2 = {"Lcom/obric/oui/layout/OUIConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lo9/a;", "Lo9/b;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "widthLimit", "", "setWidthLimit", "heightLimit", "setHeightLimit", "Landroid/graphics/Canvas;", "canvas", "draw", "dispatchDraw", "pressed", "setPressed", "enabled", "setEnabled", "hovered", "onHoverChanged", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "dispatchGenericMotionEvent", "dispatchTouchEvent", "setVibrateEnabled", "setSoundEffectEnabled", "onAttachedToWindow", "onDetachedFromWindow", "visibility", "onWindowVisibilityChanged", "selected", "setSelected", "disable", "disablePressReleaseAnim", "kotlin.jvm.PlatformType", "handleTouchEvent", "Landroid/view/View;", "current", "onPressedChanged", "onSelectedChanged", "", "scene", "refreshColors", "resetAlphaAnim", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", TypedValues.Custom.S_COLOR, "setOverridePressColor", "decideIsNeedUpdatePressedForegroundBySelf", "getRadius", "", "getShadowAlpha", "getShadowColor", "getShadowElevation", "hasBorder", "hasBottomSeparator", "hasLeftSeparator", "hasRightSeparator", "hasTopSeparator", "alpha", "onPressAlphaChange", "bottomInsetLeft", "bottomInsetRight", "bottomDividerHeight", "bottomDividerColor", "onlyShowBottomDivider", "leftInsetTop", "leftInsetBottom", "leftDividerWidth", "leftDividerColor", "onlyShowLeftDivider", "rightInsetTop", "rightInsetBottom", "rightDividerWidth", "rightDividerColor", "onlyShowRightDivider", "topInsetLeft", "topInsetRight", "topDividerHeight", "topDividerColor", "onlyShowTopDivider", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "left", "top", "right", "bottom", "setOutlineInset", "radius", "setRadius", "tlRadius", "trRadius", "blRadius", "brRadius", "shadowElevation", "shadowAlpha", "setRadiusAndShadow", "shadowColor", "setRightDividerAlpha", "Lo9/p;", "firstShadow", "secondShadow", "setShadow", "setShadowAlpha", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "insetX", "insetY", "setShadowInsets", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "setUseThemeGeneralShadowElevation", "minWidth", "setWidthMin", "shouldUpdateDividerColorOnPress", "updateBottomDivider", "updateBottomSeparatorColor", "strength", "updateDividerColorStrength", "updateLeftDivider", "updateLeftSeparatorColor", "updateRightDivider", "updateRightSeparatorColor", "updateTopDivider", "updateTopSeparatorColor", "getAlphaHelper", "Lo9/j;", "getEffectHelper", "getLayoutHelper", "Lo9/n;", "provider", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILo9/n;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OUIConstraintLayout extends ConstraintLayout implements a, b {
    private final /* synthetic */ a $$delegate_0;
    private final /* synthetic */ b $$delegate_1;
    private final /* synthetic */ n $$delegate_2;
    private g mAlphaHelper;
    private k mLayoutHelper;
    private j mOUIEffectHelper;

    @JvmOverloads
    public OUIConstraintLayout(Context r10) {
        this(r10, null, 0, null, 14, null);
    }

    @JvmOverloads
    public OUIConstraintLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 0, null, 12, null);
    }

    @JvmOverloads
    public OUIConstraintLayout(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, null, 8, null);
    }

    @JvmOverloads
    public OUIConstraintLayout(Context r10, AttributeSet r11, int r12, n r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r13, "provider");
        super(r10, r11);
        this.$$delegate_0 = r13.a();
        this.$$delegate_1 = r13.c();
        this.$$delegate_2 = r13;
        r13.d(this);
        b r14 = getLayoutHelper();
        Objects.requireNonNull(r14, "null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
        this.mLayoutHelper = (k) r14;
        a r15 = getAlphaHelper();
        Objects.requireNonNull(r15, "null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
        this.mAlphaHelper = (g) r15;
        this.mOUIEffectHelper = getEffectHelper();
        init(r10, r11, r12);
    }

    public /* synthetic */ OUIConstraintLayout(Context r10, AttributeSet r11, int r12, n r13, int r14, DefaultConstructorMarker r15) {
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

    @Override // o9.b
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.$$delegate_1.decideIsNeedUpdatePressedForegroundBySelf();
    }

    @Override // o9.a
    public void disablePressReleaseAnim(boolean r10) {
        this.$$delegate_0.disablePressReleaseAnim(r10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.dispatchDraw(r10);
        k r11 = this.mLayoutHelper;
        if (r11 == null) goto L5;
        r11.q(r10, getWidth(), getHeight());
    L5:
        k r12 = this.mLayoutHelper;
        if (r12 == null) goto L9;
        r12.o(r10);
        return;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        j r11 = this.mOUIEffectHelper;
        if (r11 == null) goto L6;
        r11.c(r10);
    L6:
        return super.dispatchGenericMotionEvent(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        j r11 = this.mOUIEffectHelper;
        if (r11 == null) goto L5;
        r11.d(r10);
    L5:
        g r12 = this.mAlphaHelper;
        if (r12 == null) goto L9;
        r12.handleTouchEvent(r10);
    L9:
        return super.dispatchTouchEvent(r10);
    }

    @Override // android.view.View
    @RequiresApi(26)
    public void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        k r11 = this.mLayoutHelper;
        if (r11 == null) goto L5;
        r11.p(r10);
    L5:
        super.draw(r10);
    }

    public a getAlphaHelper() {
        return this.$$delegate_2.a();
    }

    public j getEffectHelper() {
        return this.$$delegate_2.b();
    }

    public b getLayoutHelper() {
        return this.$$delegate_2.c();
    }

    @Override // o9.b
    public int getRadius() {
        return this.$$delegate_1.getRadius();
    }

    @Override // o9.b
    public float getShadowAlpha() {
        return this.$$delegate_1.getShadowAlpha();
    }

    @Override // o9.b
    public int getShadowColor() {
        return this.$$delegate_1.getShadowColor();
    }

    @Override // o9.b
    public int getShadowElevation() {
        return this.$$delegate_1.getShadowElevation();
    }

    @Override // o9.a
    public void handleTouchEvent(MotionEvent r10) {
        this.$$delegate_0.handleTouchEvent(r10);
    }

    @Override // o9.b
    public boolean hasBorder() {
        return this.$$delegate_1.hasBorder();
    }

    @Override // o9.b
    public boolean hasBottomSeparator() {
        return this.$$delegate_1.hasBottomSeparator();
    }

    @Override // o9.b
    public boolean hasLeftSeparator() {
        return this.$$delegate_1.hasLeftSeparator();
    }

    @Override // o9.b
    public boolean hasRightSeparator() {
        return this.$$delegate_1.hasRightSeparator();
    }

    @Override // o9.b
    public boolean hasTopSeparator() {
        return this.$$delegate_1.hasTopSeparator();
    }

    public final void init(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        setVibrateEnabled(false);
        setSoundEffectEnabled(false);
        setWillNotDraw(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        j r10 = this.mOUIEffectHelper;
        if (r10 == null) goto L6;
        r10.m();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j r10 = this.mOUIEffectHelper;
        if (r10 == null) goto L6;
        r10.n();
        return;
    }

    @Override // android.view.View
    public void onHoverChanged(boolean r10) {
        super.onHoverChanged(r10);
        j r11 = this.mOUIEffectHelper;
        if (r11 == null) goto L6;
        r11.o(r10);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        k r12 = this.mLayoutHelper;
        if (r12 == null) goto L8;
        Intrinsics.checkNotNull(r12);
        int r13 = r12.x(r10);
        k r14 = this.mLayoutHelper;
        Intrinsics.checkNotNull(r14);
        int r15 = r14.w(r11);
        super.onMeasure(r13, r15);
        k r16 = this.mLayoutHelper;
        Intrinsics.checkNotNull(r16);
        int r17 = r16.A(r13, getMeasuredWidth());
        k r18 = this.mLayoutHelper;
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

    @Override // o9.b
    public void onPressAlphaChange(int r10) {
        this.$$delegate_1.onPressAlphaChange(r10);
    }

    @Override // o9.a
    public void onPressedChanged(View r10, boolean r11) {
        this.$$delegate_0.onPressedChanged(r10, r11);
    }

    @Override // o9.a
    public void onSelectedChanged(View r10, boolean r11) {
        this.$$delegate_0.onSelectedChanged(r10, r11);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int r10) {
        super.onWindowVisibilityChanged(r10);
        j r11 = this.mOUIEffectHelper;
        if (r11 == null) goto L6;
        r11.s(r10);
        return;
    }

    @Override // o9.b
    public void onlyShowBottomDivider(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.onlyShowBottomDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void onlyShowLeftDivider(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.onlyShowLeftDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void onlyShowRightDivider(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.onlyShowRightDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void onlyShowTopDivider(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.onlyShowTopDivider(r10, r11, r12, r13);
    }

    @Override // o9.a
    public void refreshColors(String r10) {
        this.$$delegate_0.refreshColors(r10);
    }

    @Override // o9.a
    public void resetAlphaAnim() {
        this.$$delegate_0.resetAlphaAnim();
    }

    @Override // o9.b
    public void setBorderColor(@ColorInt int r10) {
        this.$$delegate_1.setBorderColor(r10);
    }

    @Override // o9.b
    public void setBorderWidth(int r10) {
        this.$$delegate_1.setBorderWidth(r10);
    }

    @Override // o9.b
    public void setBottomDividerAlpha(int r10) {
        this.$$delegate_1.setBottomDividerAlpha(r10);
    }

    @Override // o9.a
    public void setChangeAlphaWhenDisable(boolean r10) {
        this.$$delegate_0.setChangeAlphaWhenDisable(r10);
    }

    @Override // o9.a
    public void setChangeAlphaWhenPress(boolean r10) {
        this.$$delegate_0.setChangeAlphaWhenPress(r10);
    }

    @Override // o9.a
    public void setChangeAlphaWhenSelected(boolean r10) {
        this.$$delegate_0.setChangeAlphaWhenSelected(r10);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        g r11 = this.mAlphaHelper;
        if (r11 == null) goto L6;
        r11.n(this, r10);
        return;
    }

    @Override // o9.b
    public boolean setHeightLimit(int r10) {
        k r11 = this.mLayoutHelper;
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
        this.$$delegate_0.setKeepPressAlpha(r10);
    }

    @Override // o9.b
    public void setLeftDividerAlpha(int r10) {
        this.$$delegate_1.setLeftDividerAlpha(r10);
    }

    @Override // o9.b
    public void setOuterNormalColor(int r10) {
        this.$$delegate_1.setOuterNormalColor(r10);
    }

    @Override // o9.b
    public void setOutlineExcludePadding(boolean r10) {
        this.$$delegate_1.setOutlineExcludePadding(r10);
    }

    @Override // o9.b
    public void setOutlineInset(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.setOutlineInset(r10, r11, r12, r13);
    }

    @Override // o9.a
    public void setOverridePressColor(int r10) {
        this.$$delegate_0.setOverridePressColor(r10);
    }

    @Override // android.view.View
    public void setPressed(boolean r10) {
        j r11 = this.mOUIEffectHelper;
        if (r11 == null) goto L5;
        r11.u(r10);
    L5:
        super.setPressed(r10);
        g r12 = this.mAlphaHelper;
        if (r12 == null) goto L9;
        r12.onPressedChanged(this, r10);
        return;
    }

    @Override // o9.b
    public void setRadius(int r10) {
        this.$$delegate_1.setRadius(r10);
    }

    @Override // o9.b
    public void setRadius(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.setRadius(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void setRadiusAndShadow(int r10, int r11, float r12) {
        this.$$delegate_1.setRadiusAndShadow(r10, r11, r12);
    }

    @Override // o9.b
    public void setRadiusAndShadow(int r10, int r11, int r12, float r13) {
        this.$$delegate_1.setRadiusAndShadow(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void setRightDividerAlpha(int r10) {
        this.$$delegate_1.setRightDividerAlpha(r10);
    }

    @Override // android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        g r11 = this.mAlphaHelper;
        if (r11 == null) goto L6;
        r11.onSelectedChanged(this, r10);
        return;
    }

    @Override // o9.b
    public void setShadow(@Nullable p r10, @Nullable p r11) {
        this.$$delegate_1.setShadow(r10, r11);
    }

    @Override // o9.b
    public void setShadowAlpha(float r10) {
        this.$$delegate_1.setShadowAlpha(r10);
    }

    @Override // o9.b
    public void setShadowColor(int r10) {
        this.$$delegate_1.setShadowColor(r10);
    }

    @Override // o9.b
    public void setShadowCornerRadius(int r10) {
        this.$$delegate_1.setShadowCornerRadius(r10);
    }

    @Override // o9.b
    public void setShadowElevation(int r10) {
        this.$$delegate_1.setShadowElevation(r10);
    }

    @Override // o9.b
    public void setShadowInsets(int r10, int r11) {
        this.$$delegate_1.setShadowInsets(r10, r11);
    }

    @Override // o9.b
    public void setShadowStyle(@StyleRes int r10) {
        this.$$delegate_1.setShadowStyle(r10);
    }

    @Override // o9.b
    public void setShowBorderOnlyBeforeL(boolean r10) {
        this.$$delegate_1.setShowBorderOnlyBeforeL(r10);
    }

    public final void setSoundEffectEnabled(boolean r10) {
        j r11 = this.mOUIEffectHelper;
        if (r11 == null) goto L6;
        r11.v(r10);
        return;
    }

    @Override // o9.b
    public void setTopDividerAlpha(int r10) {
        this.$$delegate_1.setTopDividerAlpha(r10);
    }

    @Override // o9.b
    public void setUseThemeGeneralShadowElevation() {
        this.$$delegate_1.setUseThemeGeneralShadowElevation();
    }

    public final void setVibrateEnabled(boolean r10) {
        j r11 = this.mOUIEffectHelper;
        if (r11 == null) goto L6;
        r11.w(r10);
        return;
    }

    @Override // o9.b
    public boolean setWidthLimit(int r10) {
        k r11 = this.mLayoutHelper;
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
        this.$$delegate_1.setWidthMin(r10);
    }

    @Override // o9.b
    public boolean shouldUpdateDividerColorOnPress() {
        return this.$$delegate_1.shouldUpdateDividerColorOnPress();
    }

    @Override // o9.b
    public void updateBottomDivider(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.updateBottomDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void updateBottomSeparatorColor(int r10) {
        this.$$delegate_1.updateBottomSeparatorColor(r10);
    }

    @Override // o9.b
    public void updateDividerColorStrength(float r10) {
        this.$$delegate_1.updateDividerColorStrength(r10);
    }

    @Override // o9.b
    public void updateLeftDivider(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.updateLeftDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void updateLeftSeparatorColor(int r10) {
        this.$$delegate_1.updateLeftSeparatorColor(r10);
    }

    @Override // o9.b
    public void updateRightDivider(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.updateRightDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void updateRightSeparatorColor(int r10) {
        this.$$delegate_1.updateRightSeparatorColor(r10);
    }

    @Override // o9.b
    public void updateTopDivider(int r10, int r11, int r12, int r13) {
        this.$$delegate_1.updateTopDivider(r10, r11, r12, r13);
    }

    @Override // o9.b
    public void updateTopSeparatorColor(int r10) {
        this.$$delegate_1.updateTopSeparatorColor(r10);
    }
}
