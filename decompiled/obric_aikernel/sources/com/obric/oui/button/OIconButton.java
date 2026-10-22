package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import o9.b;
import o9.g;
import o9.j;
import o9.k;
import o9.n;
import o9.p;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\bG\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 £\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002¤\u0001BE\b\u0007\u0012\b\u0010\u009a\u0001\u001a\u00030\u0099\u0001\u0012\f\b\u0002\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u0001\u0012\t\b\u0002\u0010\u009d\u0001\u001a\u00020\u0017\u0012\t\b\u0002\u0010\u009e\u0001\u001a\u00020\u0017\u0012\n\b\u0002\u0010 \u0001\u001a\u00030\u009f\u0001¢\u0006\u0006\b¡\u0001\u0010¢\u0001J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0017J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0017J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000bJ\u0011\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010 \u001a\u00020\u00072\u000e\u0010\u001f\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J!\u0010#\u001a\u00020\u00072\u000e\u0010\"\u001a\n \u001e*\u0004\u0018\u00010!0!2\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J!\u0010$\u001a\u00020\u00072\u000e\u0010\"\u001a\n \u001e*\u0004\u0018\u00010!0!2\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010'\u001a\u00020\u00072\u000e\u0010&\u001a\n \u001e*\u0004\u0018\u00010%0%H\u0096\u0001J\t\u0010(\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0005H\u0096\u0001J\u0011\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0005H\u0096\u0001J\u0011\u00102\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0017H\u0096\u0001J\t\u00103\u001a\u00020\u0005H\u0096\u0001J\t\u00104\u001a\u00020\u0017H\u0096\u0001J\t\u00105\u001a\u00020\u000bH\u0096\u0001J\t\u00106\u001a\u00020\u0017H\u0096\u0001J\t\u00107\u001a\u00020\u0017H\u0096\u0001J\t\u00108\u001a\u00020\u0005H\u0096\u0001J\t\u00109\u001a\u00020\u0005H\u0096\u0001J\t\u0010:\u001a\u00020\u0005H\u0096\u0001J\t\u0010;\u001a\u00020\u0005H\u0096\u0001J\t\u0010<\u001a\u00020\u0005H\u0096\u0001J)\u0010A\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u0017H\u0096\u0001J)\u0010F\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u00172\u0006\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u0017H\u0096\u0001J)\u0010K\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00172\u0006\u0010H\u001a\u00020\u00172\u0006\u0010I\u001a\u00020\u00172\u0006\u0010J\u001a\u00020\u0017H\u0096\u0001J)\u0010P\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00172\u0006\u0010M\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u00172\u0006\u0010O\u001a\u00020\u0017H\u0096\u0001J\u0013\u0010R\u001a\u00020\u00072\b\b\u0001\u0010Q\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010T\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010V\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010X\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010Y\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010Z\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010\\\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u0005H\u0096\u0001J)\u0010a\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\u00172\u0006\u0010^\u001a\u00020\u00172\u0006\u0010_\u001a\u00020\u00172\u0006\u0010`\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010c\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0017H\u0096\u0001J)\u0010c\u001a\u00020\u00072\u0006\u0010d\u001a\u00020\u00172\u0006\u0010e\u001a\u00020\u00172\u0006\u0010f\u001a\u00020\u00172\u0006\u0010g\u001a\u00020\u0017H\u0096\u0001J!\u0010j\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u00172\u0006\u0010h\u001a\u00020\u00172\u0006\u0010i\u001a\u00020\u000bH\u0096\u0001J)\u0010j\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u00172\u0006\u0010h\u001a\u00020\u00172\u0006\u0010k\u001a\u00020\u00172\u0006\u0010i\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010l\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0017H\u0096\u0001J!\u0010p\u001a\u00020\u00072\n\b\u0001\u0010n\u001a\u0004\u0018\u00010m2\n\b\u0001\u0010o\u001a\u0004\u0018\u00010mH\u0096\u0001J\u0011\u0010q\u001a\u00020\u00072\u0006\u0010i\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010r\u001a\u00020\u00072\u0006\u0010k\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010s\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010u\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\u0017H\u0096\u0001J\u0019\u0010x\u001a\u00020\u00072\u0006\u0010v\u001a\u00020\u00172\u0006\u0010w\u001a\u00020\u0017H\u0096\u0001J\u0013\u0010z\u001a\u00020\u00072\b\b\u0001\u0010y\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010|\u001a\u00020\u00072\u0006\u0010{\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010}\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0017H\u0096\u0001J\t\u0010~\u001a\u00020\u0007H\u0096\u0001J\u0012\u0010\u0080\u0001\u001a\u00020\u00052\u0006\u0010\u007f\u001a\u00020\u0017H\u0096\u0001J\u0013\u0010\u0082\u0001\u001a\u00020\u00072\u0007\u0010\u0081\u0001\u001a\u00020\u0017H\u0096\u0001J\n\u0010\u0083\u0001\u001a\u00020\u0005H\u0096\u0001J*\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u0017H\u0096\u0001J\u0012\u0010\u0085\u0001\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0017H\u0096\u0001J\u0013\u0010\u0087\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00020\u000bH\u0096\u0001J*\u0010\u0088\u0001\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u00172\u0006\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u0017H\u0096\u0001J\u0012\u0010\u0089\u0001\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0017H\u0096\u0001J*\u0010\u008a\u0001\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00172\u0006\u0010H\u001a\u00020\u00172\u0006\u0010I\u001a\u00020\u00172\u0006\u0010J\u001a\u00020\u0017H\u0096\u0001J\u0012\u0010\u008b\u0001\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0017H\u0096\u0001J*\u0010\u008c\u0001\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00172\u0006\u0010M\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u00172\u0006\u0010O\u001a\u00020\u0017H\u0096\u0001J\u0012\u0010\u008d\u0001\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0017H\u0096\u0001J\n\u0010\u008e\u0001\u001a\u00020\u0002H\u0096\u0001J\u000b\u0010\u0090\u0001\u001a\u00030\u008f\u0001H\u0096\u0001J\n\u0010\u0091\u0001\u001a\u00020\u0003H\u0096\u0001R\u0019\u0010\u0092\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0019\u0010\u0094\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0093\u0001R\u0019\u0010\u0095\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0019\u0010\u0097\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001¨\u0006¥\u0001"}, d2 = {"Lcom/obric/oui/button/OIconButton;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lo9/a;", "Lo9/b;", "", "", "pressed", "", "setPressState", "enabled", "updateUIOnEnableChanged", "", "fraction", "updateIconAlphaOnPress", "getAnimatedPressAlpha", "setPressed", "setEnabled", "selected", "setSelected", "Landroid/graphics/Canvas;", "canvas", "draw", "dispatchDraw", "", "alpha", "onPressAlphaChange", "setDisabledAlpha", "disable", "disablePressReleaseAnim", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_EVENT, "handleTouchEvent", "Landroid/view/View;", "current", "onPressedChanged", "onSelectedChanged", "", "scene", "refreshColors", "resetAlphaAnim", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", TypedValues.Custom.S_COLOR, "setOverridePressColor", "decideIsNeedUpdatePressedForegroundBySelf", "getRadius", "getShadowAlpha", "getShadowColor", "getShadowElevation", "hasBorder", "hasBottomSeparator", "hasLeftSeparator", "hasRightSeparator", "hasTopSeparator", "bottomInsetLeft", "bottomInsetRight", "bottomDividerHeight", "bottomDividerColor", "onlyShowBottomDivider", "leftInsetTop", "leftInsetBottom", "leftDividerWidth", "leftDividerColor", "onlyShowLeftDivider", "rightInsetTop", "rightInsetBottom", "rightDividerWidth", "rightDividerColor", "onlyShowRightDivider", "topInsetLeft", "topInsetRight", "topDividerHeight", "topDividerColor", "onlyShowTopDivider", "borderColor", "setBorderColor", "borderWidth", "setBorderWidth", "dividerAlpha", "setBottomDividerAlpha", "heightLimit", "setHeightLimit", "setLeftDividerAlpha", "setOuterNormalColor", "outlineExcludePadding", "setOutlineExcludePadding", "left", "top", "right", "bottom", "setOutlineInset", "radius", "setRadius", "tlRadius", "trRadius", "blRadius", "brRadius", "shadowElevation", "shadowAlpha", "setRadiusAndShadow", "shadowColor", "setRightDividerAlpha", "Lo9/p;", "firstShadow", "secondShadow", "setShadow", "setShadowAlpha", "setShadowColor", "setShadowCornerRadius", "elevation", "setShadowElevation", "insetX", "insetY", "setShadowInsets", "styleResId", "setShadowStyle", "showBorderOnlyBeforeL", "setShowBorderOnlyBeforeL", "setTopDividerAlpha", "setUseThemeGeneralShadowElevation", "widthLimit", "setWidthLimit", "minWidth", "setWidthMin", "shouldUpdateDividerColorOnPress", "updateBottomDivider", "updateBottomSeparatorColor", "strength", "updateDividerColorStrength", "updateLeftDivider", "updateLeftSeparatorColor", "updateRightDivider", "updateRightSeparatorColor", "updateTopDivider", "updateTopSeparatorColor", "getAlphaHelper", "Lo9/j;", "getEffectHelper", "getLayoutHelper", "changeAlphaWhenPressed", "Z", "internalPressState", "disabledAlpha", "F", "originIconAlpha", "I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "Lo9/n;", "provider", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILo9/n;)V", "Companion", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OIconButton extends AppCompatImageView implements o9.a, b {
    private static final float ALPHA_ON_PRESS = 0.3f;
    public static final a Companion = null;
    private final /* synthetic */ o9.a $$delegate_0;
    private final /* synthetic */ b $$delegate_1;
    private final /* synthetic */ n $$delegate_2;
    private boolean changeAlphaWhenPressed;
    private float disabledAlpha;
    private boolean internalPressState;
    private g mAlphaHelper;
    private k mLayoutHelper;
    private j mOUIEffectHelper;
    private int originIconAlpha;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    @JvmOverloads
    public OIconButton(Context r10) {
        this(r10, null, 0, 0, null, 30, null);
    }

    @JvmOverloads
    public OIconButton(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 0, null, 28, null);
    }

    @JvmOverloads
    public OIconButton(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 0, null, 24, null);
    }

    @JvmOverloads
    public OIconButton(Context r10, AttributeSet r11, int r12, int r13) {
        this(r10, r11, r12, r13, null, 16, null);
    }

    @JvmOverloads
    public OIconButton(Context r10, AttributeSet r11, int r12, int r13, n r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r14, "provider");
        super(r10, r11, r12);
        this.$$delegate_0 = r14.a();
        this.$$delegate_1 = r14.c();
        this.$$delegate_2 = r14;
        this.disabledAlpha = 1.0f;
        r14.d(this);
        b r15 = getLayoutHelper();
        Objects.requireNonNull(r15, "null cannot be cast to non-null type com.obric.oui.common.style.OUILayoutHelper");
        this.mLayoutHelper = (k) r15;
        o9.a r16 = getAlphaHelper();
        Objects.requireNonNull(r16, "null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
        this.mAlphaHelper = (g) r16;
        this.mOUIEffectHelper = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        TypedArray r17 = r10.obtainStyledAttributes(r11, l.OButton);
        Intrinsics.checkNotNullExpressionValue(r17, "context.obtainStyledAttr…trs, R.styleable.OButton)");
        this.changeAlphaWhenPressed = r17.getBoolean(l.OButton_oui_buttonChangeAlphaWhenPressed, false);
        this.disabledAlpha = r17.getFloat(l.OButton_oui_widgetDisableAlpha, 1.0f);
        r17.recycle();
        updateUIOnEnableChanged(isEnabled());
    }

    public /* synthetic */ OIconButton(Context r10, AttributeSet r11, int r12, int r13, n r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 2) == 0) goto L5;
        r11 = null;
    L5:
        AttributeSet r17 = r11;
        if ((r15 & 4) == 0) goto L8;
        int r18 = 0;
    L10:
        if ((r15 & 8) == 0) goto L12;
        int r19 = 0;
    L14:
        if ((r15 & 16) == 0) goto L16;
        r14 = new n(r10, r17, r18, r19);
    L16:
        this(r10, r17, r18, r19, r14);
        return;
    L12:
        r19 = r13;
        goto L14
    L8:
        r18 = r12;
        goto L10
    }

    private final float getAnimatedPressAlpha(float r10) {
        return 1 - (r10 * 0.7f);
    }

    private final void setPressState(boolean r10) {
        if (this.internalPressState != r10) goto L5;
        return;
    L5:
        this.internalPressState = r10;
        j r11 = this.mOUIEffectHelper;
        if (r11 == null) goto L8;
        r11.u(r10);
    L8:
        g r12 = this.mAlphaHelper;
        if (r12 == null) goto L12;
        r12.onPressedChanged(this, r10);
        return;
    }

    private final void updateIconAlphaOnPress(float r10) {
        if (this.originIconAlpha != 0) goto L5;
        this.originIconAlpha = getImageAlpha();
    L5:
        int r11 = this.originIconAlpha;
        if (r11 != 0) goto L8;
        return;
    L8:
        setImageAlpha(RangesKt.coerceIn((int) (r11 * getAnimatedPressAlpha(r10)), 0, 255));
    }

    private final void updateUIOnEnableChanged(boolean r10) {
        if (r10 == true) goto L6;
        Drawable r11 = getDrawable();
        if (r11 == null) goto L10;
        r11.setAlpha((int) (this.disabledAlpha * 255));
        return;
    L10:
        return;
    L6:
        Drawable r12 = getDrawable();
        if (r12 == null) goto L12;
        r12.setAlpha((int) 255.0f);
        return;
    }

    @Override // o9.b
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.$$delegate_1.decideIsNeedUpdatePressedForegroundBySelf();
    }

    @Override // o9.a
    public void disablePressReleaseAnim(boolean r10) {
        this.$$delegate_0.disablePressReleaseAnim(r10);
    }

    @Override // android.view.View
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
    @RequiresApi(26)
    public void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        k r11 = this.mLayoutHelper;
        if (r11 == null) goto L5;
        r11.p(r10);
    L5:
        super.draw(r10);
    }

    public o9.a getAlphaHelper() {
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

    @Override // o9.b
    @RequiresApi(26)
    public void onPressAlphaChange(int r10) {
        if (this.changeAlphaWhenPressed == true) goto L5;
        return;
    L5:
        updateIconAlphaOnPress(RangesKt.coerceIn(r10 / 255.0f, 0.0f, 1.0f));
    }

    @Override // o9.a
    public void onPressedChanged(View r10, boolean r11) {
        this.$$delegate_0.onPressedChanged(r10, r11);
    }

    @Override // o9.a
    public void onSelectedChanged(View r10, boolean r11) {
        this.$$delegate_0.onSelectedChanged(r10, r11);
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

    public final void setDisabledAlpha(float r10) {
        this.disabledAlpha = r10;
        if (isEnabled() == true) goto L6;
        updateUIOnEnableChanged(false);
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        g r11 = this.mAlphaHelper;
        if (r11 == null) goto L5;
        r11.n(this, r10);
    L5:
        updateUIOnEnableChanged(r10);
    }

    @Override // o9.b
    public boolean setHeightLimit(int r10) {
        return this.$$delegate_1.setHeightLimit(r10);
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
        super.setPressed(r10);
        j r11 = this.mOUIEffectHelper;
        if (r11 == null) goto L5;
        r11.u(r10);
    L5:
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

    @Override // android.widget.ImageView, android.view.View
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

    @Override // o9.b
    public void setTopDividerAlpha(int r10) {
        this.$$delegate_1.setTopDividerAlpha(r10);
    }

    @Override // o9.b
    public void setUseThemeGeneralShadowElevation() {
        this.$$delegate_1.setUseThemeGeneralShadowElevation();
    }

    @Override // o9.b
    public boolean setWidthLimit(int r10) {
        return this.$$delegate_1.setWidthLimit(r10);
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
