package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.style.b;
import com.obric.oui.common.style.c;
import com.obric.oui.common.style.e;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.i;
import com.obric.oui.common.style.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b^\b\u0016\u0018\u0000 º\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002º\u0001B9\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001f\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0014H\u0096\u0001J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0017J\t\u0010'\u001a\u00020\u0002H\u0096\u0001J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010H\u0002J-\u0010*\u001a&\u0012\f\u0012\n -*\u0004\u0018\u00010,0, -*\u0012\u0012\f\u0012\n -*\u0004\u0018\u00010,0,\u0018\u00010.0+H\u0096\u0001J\t\u0010/\u001a\u00020\u001cH\u0096\u0001J\t\u00100\u001a\u00020\u0003H\u0096\u0001J\t\u00101\u001a\u00020\nH\u0096\u0001J\t\u00102\u001a\u00020\u0010H\u0096\u0001J\t\u00103\u001a\u00020\nH\u0096\u0001J\t\u00104\u001a\u00020\nH\u0096\u0001J\u0019\u00105\u001a\u00020!2\u000e\u00106\u001a\n -*\u0004\u0018\u00010707H\u0096\u0001J\t\u00108\u001a\u00020\u0014H\u0096\u0001J\t\u00109\u001a\u00020\u0014H\u0096\u0001J\t\u0010:\u001a\u00020\u0014H\u0096\u0001J\t\u0010;\u001a\u00020\u0014H\u0096\u0001J\t\u0010<\u001a\u00020\u0014H\u0096\u0001J\t\u0010=\u001a\u00020\u0014H\u0096\u0001J\t\u0010>\u001a\u00020\u0014H\u0096\u0001J\u0010\u0010?\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0014J\u0010\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020\nH\u0017J!\u0010B\u001a\u00020!2\u000e\u0010C\u001a\n -*\u0004\u0018\u00010D0D2\u0006\u0010E\u001a\u00020\u0014H\u0096\u0001J!\u0010F\u001a\u00020!2\u000e\u0010C\u001a\n -*\u0004\u0018\u00010D0D2\u0006\u0010E\u001a\u00020\u0014H\u0096\u0001J)\u0010G\u001a\u00020!2\u0006\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020\nH\u0096\u0001J)\u0010L\u001a\u00020!2\u0006\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\nH\u0096\u0001J)\u0010Q\u001a\u00020!2\u0006\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\nH\u0096\u0001J)\u0010V\u001a\u00020!2\u0006\u0010W\u001a\u00020\n2\u0006\u0010X\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\nH\u0096\u0001J\u0019\u0010[\u001a\u00020!2\u000e\u0010\\\u001a\n -*\u0004\u0018\u00010]0]H\u0096\u0001J\t\u0010^\u001a\u00020!H\u0096\u0001J\u000e\u0010_\u001a\u00020!2\u0006\u0010`\u001a\u00020\u0010J\u0010\u0010a\u001a\u00020!2\u0006\u0010b\u001a\u00020\nH\u0016J\u0013\u0010c\u001a\u00020!2\b\b\u0001\u0010d\u001a\u00020\nH\u0096\u0001J\u0011\u0010e\u001a\u00020!2\u0006\u0010f\u001a\u00020\nH\u0096\u0001J\u0011\u0010g\u001a\u00020!2\u0006\u0010h\u001a\u00020\nH\u0096\u0001J\u0011\u0010i\u001a\u00020!2\u0006\u0010j\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010k\u001a\u00020!2\u0006\u0010l\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010m\u001a\u00020!2\u0006\u0010n\u001a\u00020\u0014H\u0096\u0001J\u000e\u0010o\u001a\u00020!2\u0006\u0010A\u001a\u00020\u0010J\u0011\u0010p\u001a\u00020!2\u0006\u0010q\u001a\u00020\u0014H\u0096\u0001J\u0010\u0010r\u001a\u00020!2\u0006\u0010s\u001a\u00020\u0014H\u0016J\u0011\u0010t\u001a\u00020\u00142\u0006\u0010u\u001a\u00020\nH\u0096\u0001J\u0011\u0010v\u001a\u00020!2\u0006\u0010w\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010x\u001a\u00020!2\u0006\u0010h\u001a\u00020\nH\u0096\u0001J\u0011\u0010y\u001a\u00020!2\u0006\u0010b\u001a\u00020\nH\u0096\u0001J\u0011\u0010z\u001a\u00020!2\u0006\u0010{\u001a\u00020\u0014H\u0096\u0001J*\u0010|\u001a\u00020!2\u0006\u0010}\u001a\u00020\n2\u0006\u0010~\u001a\u00020\n2\u0006\u0010\u007f\u001a\u00020\n2\u0007\u0010\u0080\u0001\u001a\u00020\nH\u0096\u0001J\u0012\u0010\u0081\u0001\u001a\u00020!2\u0006\u0010b\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0082\u0001\u001a\u00020!2\u0006\u0010E\u001a\u00020\u0014H\u0002J\u0011\u0010\u0083\u0001\u001a\u00020!2\u0006\u0010E\u001a\u00020\u0014H\u0016J\u0013\u0010\u0084\u0001\u001a\u00020!2\u0007\u0010\u0085\u0001\u001a\u00020\nH\u0096\u0001J.\u0010\u0084\u0001\u001a\u00020!2\u0007\u0010\u0086\u0001\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\n2\u0007\u0010\u0088\u0001\u001a\u00020\n2\u0007\u0010\u0089\u0001\u001a\u00020\nH\u0096\u0001J%\u0010\u008a\u0001\u001a\u00020!2\u0007\u0010\u0085\u0001\u001a\u00020\n2\u0007\u0010\u008b\u0001\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\u0010H\u0096\u0001J.\u0010\u008a\u0001\u001a\u00020!2\u0007\u0010\u0085\u0001\u001a\u00020\n2\u0007\u0010\u008b\u0001\u001a\u00020\n2\u0007\u0010\u008d\u0001\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\u0010H\u0096\u0001J\u0012\u0010\u008e\u0001\u001a\u00020!2\u0006\u0010h\u001a\u00020\nH\u0096\u0001J\u0012\u0010\u008f\u0001\u001a\u00020!2\u0007\u0010\u0090\u0001\u001a\u00020\u0014H\u0016J-\u0010\u0091\u0001\u001a\u00020!2\u000b\b\u0001\u0010\u0092\u0001\u001a\u0004\u0018\u00010,2\u000b\b\u0001\u0010\u0093\u0001\u001a\u0004\u0018\u00010,2\u0007\u0010\u0094\u0001\u001a\u00020\u0014H\u0096\u0001J\u0013\u0010\u0095\u0001\u001a\u00020!2\u0007\u0010\u008c\u0001\u001a\u00020\u0010H\u0096\u0001J\u0013\u0010\u0096\u0001\u001a\u00020!2\u0007\u0010\u008d\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u0097\u0001\u001a\u00020!2\u0007\u0010\u0085\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u0098\u0001\u001a\u00020!2\u0007\u0010\u0099\u0001\u001a\u00020\nH\u0096\u0001J\u001c\u0010\u009a\u0001\u001a\u00020!2\u0007\u0010\u009b\u0001\u001a\u00020\n2\u0007\u0010\u009c\u0001\u001a\u00020\nH\u0096\u0001J\u0015\u0010\u009d\u0001\u001a\u00020!2\t\b\u0001\u0010\u009e\u0001\u001a\u00020\nH\u0096\u0001J\u001c\u0010\u009f\u0001\u001a\u00020!2\u0007\u0010 \u0001\u001a\u00020\u00142\u0007\u0010\u0094\u0001\u001a\u00020\u0014H\u0096\u0001J\u0013\u0010¡\u0001\u001a\u00020!2\u0007\u0010¢\u0001\u001a\u00020\u0014H\u0096\u0001J\u0010\u0010£\u0001\u001a\u00020!2\u0007\u0010¤\u0001\u001a\u00020\nJ\u0012\u0010¥\u0001\u001a\u00020!2\u0006\u0010h\u001a\u00020\nH\u0096\u0001J\n\u0010¦\u0001\u001a\u00020!H\u0096\u0001J\u0013\u0010§\u0001\u001a\u00020\u00142\u0007\u0010¨\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010©\u0001\u001a\u00020!2\u0007\u0010ª\u0001\u001a\u00020\nH\u0096\u0001J\n\u0010«\u0001\u001a\u00020\u0014H\u0096\u0001J*\u0010¬\u0001\u001a\u00020!2\u0006\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020\nH\u0096\u0001J\u0012\u0010\u00ad\u0001\u001a\u00020!2\u0006\u0010b\u001a\u00020\nH\u0096\u0001J\u0013\u0010®\u0001\u001a\u00020!2\u0007\u0010¯\u0001\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010°\u0001\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0010H\u0002J*\u0010±\u0001\u001a\u00020!2\u0006\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\nH\u0096\u0001J\u0012\u0010²\u0001\u001a\u00020!2\u0006\u0010b\u001a\u00020\nH\u0096\u0001J*\u0010³\u0001\u001a\u00020!2\u0006\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\nH\u0096\u0001J\u0012\u0010´\u0001\u001a\u00020!2\u0006\u0010b\u001a\u00020\nH\u0096\u0001J;\u0010µ\u0001\u001a\u00020!2/\b\u0001\u0010¶\u0001\u001a(\u0012\f\u0012\n -*\u0004\u0018\u00010,0,\u0018\u0001 -*\u0012\u0012\f\u0012\n -*\u0004\u0018\u00010,0,\u0018\u00010.0+H\u0096\u0001J*\u0010·\u0001\u001a\u00020!2\u0006\u0010W\u001a\u00020\n2\u0006\u0010X\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\nH\u0096\u0001J\u0012\u0010¸\u0001\u001a\u00020!2\u0006\u0010b\u001a\u00020\nH\u0096\u0001J\u0011\u0010¹\u0001\u001a\u00020!2\u0006\u0010s\u001a\u00020\u0014H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006»\u0001"}, d2 = {"Lcom/obric/oui/button/OIconButton;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/obric/oui/common/style/IOUIAlpha;", "Lcom/obric/oui/common/style/IOUILayout;", "Lcom/obric/oui/common/style/IOUIStyleProvider;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "provider", "Lcom/obric/oui/common/style/OUIStyleProvider;", "(Landroid/content/Context;Landroid/util/AttributeSet;IILcom/obric/oui/common/style/OUIStyleProvider;)V", "alignmentProgress", "", "backgroundColor", "Ljava/lang/Integer;", "changeAlphaWhenPressed", "", "disabledAlpha", "internalPressState", "mAlphaHelper", "Lcom/obric/oui/common/style/OUIAlphaHelper;", "mLayoutHelper", "Lcom/obric/oui/common/style/OUILayoutHelper;", "mOUIEffectHelper", "Lcom/obric/oui/common/style/OUIEffectHelper;", "originIconAlpha", "targetLeftPadding", "decideIsNeedUpdatePressedForegroundBySelf", "disablePressReleaseAnim", "", "disable", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "draw", "getAlphaHelper", "getAnimatedPressAlpha", "fraction", "getCurrentShadows", "", "Lcom/obric/oui/common/style/Shadow;", "kotlin.jvm.PlatformType", "", "getEffectHelper", "getLayoutHelper", "getRadius", "getShadowAlpha", "getShadowColor", "getShadowElevation", "handleTouchEvent", "event", "Landroid/view/MotionEvent;", "hasBorder", "hasBottomSeparator", "hasLeftSeparator", "hasRightSeparator", "hasTopSeparator", "isEnableShadowWidthRadius", "isShadowVisible", "onDraw", "onPressAlphaChange", "alpha", "onPressedChanged", "current", "Landroid/view/View;", "pressed", "onSelectedChanged", "onlyShowBottomDivider", "bottomInsetLeft", "bottomInsetRight", "bottomDividerHeight", "bottomDividerColor", "onlyShowLeftDivider", "leftInsetTop", "leftInsetBottom", "leftDividerWidth", "leftDividerColor", "onlyShowRightDivider", "rightInsetTop", "rightInsetBottom", "rightDividerWidth", "rightDividerColor", "onlyShowTopDivider", "topInsetLeft", "topInsetRight", "topDividerHeight", "topDividerColor", "refreshColors", MemoryInfoSectionEditActivity.KIND_SCENE, "", "resetAlphaAnim", "setAlignmentProgress", "progress", "setBackgroundColor", TypedValues.Custom.S_COLOR, "setBorderColor", "borderColor", "setBorderWidth", "borderWidth", "setBottomDividerAlpha", "dividerAlpha", "setChangeAlphaWhenDisable", "changeAlphaWhenDisable", "setChangeAlphaWhenPress", "changeAlphaWhenPress", "setChangeAlphaWhenSelected", "changeAlphaWhenSelected", "setDisabledAlpha", "setEnableShadowWidthRadius", "enableShadowWidthRadius", "setEnabled", "enabled", "setHeightLimit", "heightLimit", "setKeepPressAlpha", "keep", "setLeftDividerAlpha", "setOuterNormalColor", "setOutlineExcludePadding", "outlineExcludePadding", "setOutlineInset", "left", "top", "right", "bottom", "setOverridePressColor", "setPressState", "setPressed", "setRadius", "radius", "tlRadius", "trRadius", "blRadius", "brRadius", "setRadiusAndShadow", "shadowElevation", "shadowAlpha", "shadowColor", "setRightDividerAlpha", "setSelected", BuildConfig.FLAVOR, "setShadow", "firstShadow", "secondShadow", "animate", "setShadowAlpha", "setShadowColor", "setShadowCornerRadius", "setShadowElevation", "elevation", "setShadowInsets", "insetX", "insetY", "setShadowStyle", "styleResId", "setShadowVisible", "visible", "setShowBorderOnlyBeforeL", "showBorderOnlyBeforeL", "setTargetLeftPadding", "padding", "setTopDividerAlpha", "setUseThemeGeneralShadowElevation", "setWidthLimit", "widthLimit", "setWidthMin", "minWidth", "shouldUpdateDividerColorOnPress", "updateBottomDivider", "updateBottomSeparatorColor", "updateDividerColorStrength", "strength", "updateIconAlphaOnPress", "updateLeftDivider", "updateLeftSeparatorColor", "updateRightDivider", "updateRightSeparatorColor", "updateShadows", "shadows", "updateTopDivider", "updateTopSeparatorColor", "updateUIOnEnableChanged", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OIconButton extends AppCompatImageView implements com.obric.oui.common.style.a, b {
    private static final float ALPHA_ON_PRESS = 0.3f;
    public static final a Companion = null;
    private final /* synthetic */ com.obric.oui.common.style.a $$delegate_0;
    private final /* synthetic */ b $$delegate_1;
    private final /* synthetic */ i $$delegate_2;
    private float alignmentProgress;
    private Integer backgroundColor;
    private boolean changeAlphaWhenPressed;
    private float disabledAlpha;
    private boolean internalPressState;
    private c mAlphaHelper;
    private f mLayoutHelper;
    private e mOUIEffectHelper;
    private int originIconAlpha;
    private int targetLeftPadding;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/button/OIconButton$Companion;", "", "()V", "ALPHA_ON_PRESS", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public OIconButton(Context r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 0, null, 30, null);
    }

    public OIconButton(Context r11, AttributeSet r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 0, null, 28, null);
    }

    public OIconButton(Context r11, AttributeSet r12, int r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r13, 0, null, 24, null);
    }

    public OIconButton(Context r11, AttributeSet r12, int r13, int r14) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r13, r14, null, 16, null);
    }

    public OIconButton(Context r4, AttributeSet r5, int r6, int r7, i r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r8, "provider");
        super(r9, r10, r6);
        this.$$delegate_0 = r8.a();
        this.$$delegate_1 = r8.b();
        this.$$delegate_2 = r8;
        this.disabledAlpha = 1.0f;
        r8.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        setEnableShadowWidthRadius(true);
        this.mLayoutHelper = (f) ZeusTransformUtils.preCheckCast(getLayoutHelper(), f.class, "com.obric.memorydata.plugin");
        c r11 = (c) ZeusTransformUtils.preCheckCast(getAlphaHelper(), c.class, "com.obric.memorydata.plugin");
        this.mAlphaHelper = r11;
        if (r11 == null) goto L6;
        r11.a(getRadius());
    L6:
        this.mOUIEffectHelper = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        TypedArray r12 = r9.obtainStyledAttributes(r10, R.styleable.OButton);
        Intrinsics.checkNotNullExpressionValue(r12, "context.obtainStyledAttr…trs, R.styleable.OButton)");
        this.changeAlphaWhenPressed = r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OButton_oui_buttonChangeAlphaWhenPressed, "styleable", "OButton_oui_buttonChangeAlphaWhenPressed"), false);
        this.disabledAlpha = r12.getFloat(ZeusTransformUtils.mapRes(R.styleable.OButton_oui_widgetDisableAlpha, "styleable", "OButton_oui_widgetDisableAlpha"), 1.0f);
        r12.recycle();
        updateUIOnEnableChanged(isEnabled());
        this.targetLeftPadding = MathKt.roundToInt(16 * ZeusTransformUtils.getResources(r9, "com.obric.memorydata.plugin").getDisplayMetrics().density);
        if (ZeusTransformUtils.instanceOf(getBackground(), ColorDrawable.class) == false) goto L10;
        GradientDrawable r13 = new GradientDrawable();
        r13.setShape(0);
        r13.setCornerRadius(getRadius());
        Drawable r14 = getBackground();
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
        r13.setColor(((ColorDrawable) ZeusTransformUtils.preCheckCast(r14, ColorDrawable.class, "com.obric.memorydata.plugin")).getColor());
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r13, Drawable.class, "com.obric.memorydata.plugin"));
        return;
    }

    public /* synthetic */ OIconButton(Context r4, AttributeSet r5, int r6, int r7, i r8, int r9, DefaultConstructorMarker r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r9 & 2) == 0) goto L5;
        r12 = null;
    L5:
        AttributeSet r13 = r12;
        int r0 = 0;
        if ((r9 & 4) == 0) goto L8;
        int r1 = 0;
    L10:
        if ((r9 & 8) != 0) goto L14;
        r0 = r7;
    L14:
        if ((r9 & 16) == 0) goto L16;
        r8 = new i(r11, r13, r1, r0);
    L16:
        this(r11, r13, r1, r0, r8);
        return;
    L8:
        r1 = r6;
        goto L10
    }

    private final float getAnimatedPressAlpha(float r2) {
        return 1 - (r2 * 0.7f);
    }

    private final void setPressState(boolean r4) {
        if (this.internalPressState != r4) goto L5;
        return;
    L5:
        this.internalPressState = r4;
        e r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L9;
        r0.b(r4);
    L9:
        c r1 = this.mAlphaHelper;
        if (r1 == null) goto L14;
        r1.onPressedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4);
        return;
    }

    private final void updateIconAlphaOnPress(float r3) {
        if (this.originIconAlpha != 0) goto L5;
        this.originIconAlpha = getImageAlpha();
    L5:
        int r0 = this.originIconAlpha;
        if (r0 != 0) goto L8;
        return;
    L8:
        setImageAlpha(RangesKt.coerceIn((int) (r0 * getAnimatedPressAlpha(r3)), 0, 255));
    }

    private final void updateUIOnEnableChanged(boolean r2) {
        if (r2 == true) goto L8;
        Drawable r3 = getDrawable();
        if (r3 == null) goto L14;
        r3.setAlpha((int) (this.disabledAlpha * 255));
        return;
    L14:
        return;
    L8:
        Drawable r1 = getDrawable();
        if (r1 == null) goto L15;
        r1.setAlpha(255);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.$$delegate_1.decideIsNeedUpdatePressedForegroundBySelf();
    }

    @Override // com.obric.oui.common.style.a
    public void disablePressReleaseAnim(boolean r1) {
        this.$$delegate_0.disablePressReleaseAnim(r1);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.dispatchDraw(r4);
        f r0 = this.mLayoutHelper;
        if (r0 == null) goto L6;
        r0.a(r4, getWidth(), getHeight());
    L6:
        f r3 = this.mLayoutHelper;
        if (r3 == null) goto L11;
        r3.b(r4);
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        f r0 = this.mLayoutHelper;
        if (r0 == null) goto L6;
        r0.a(r2);
    L6:
        super.draw(r2);
    }

    public com.obric.oui.common.style.a getAlphaHelper() {
        return this.$$delegate_2.a();
    }

    @Override // com.obric.oui.common.style.b
    public List<k> getCurrentShadows() {
        return this.$$delegate_1.getCurrentShadows();
    }

    public e getEffectHelper() {
        return this.$$delegate_2.c();
    }

    public b getLayoutHelper() {
        return this.$$delegate_2.b();
    }

    @Override // com.obric.oui.common.style.b
    public int getRadius() {
        return this.$$delegate_1.getRadius();
    }

    @Override // com.obric.oui.common.style.b
    public float getShadowAlpha() {
        return this.$$delegate_1.getShadowAlpha();
    }

    @Override // com.obric.oui.common.style.b
    public int getShadowColor() {
        return this.$$delegate_1.getShadowColor();
    }

    @Override // com.obric.oui.common.style.b
    public int getShadowElevation() {
        return this.$$delegate_1.getShadowElevation();
    }

    @Override // com.obric.oui.common.style.a
    public void handleTouchEvent(MotionEvent r1) {
        this.$$delegate_0.handleTouchEvent(r1);
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasBorder() {
        return this.$$delegate_1.hasBorder();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasBottomSeparator() {
        return this.$$delegate_1.hasBottomSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasLeftSeparator() {
        return this.$$delegate_1.hasLeftSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasRightSeparator() {
        return this.$$delegate_1.hasRightSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasTopSeparator() {
        return this.$$delegate_1.hasTopSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean isEnableShadowWidthRadius() {
        return this.$$delegate_1.isEnableShadowWidthRadius();
    }

    @Override // com.obric.oui.common.style.b
    public boolean isShadowVisible() {
        return this.$$delegate_1.isShadowVisible();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        if (this.alignmentProgress != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        super.onDraw(r5);
        return;
    L9:
        Drawable r1 = getDrawable();
        if (r1 != null) goto L13;
        OIconButton r2 = (OIconButton) ZeusTransformUtils.preCheckCast(this, OIconButton.class, "com.obric.memorydata.plugin");
        super.onDraw(r5);
        return;
    L13:
        int r3 = r1.getIntrinsicWidth();
        if (r3 > 0) goto L17;
        super.onDraw(r5);
        return;
    L17:
        float r4 = (this.targetLeftPadding - (getPaddingLeft() + ((((getWidth() - getPaddingLeft()) - getPaddingRight()) - r3) / 2.0f))) * this.alignmentProgress;
        int r6 = r5.save();
        r5.translate(r4, 0.0f);
        super.onDraw(r5);
        r5.restoreToCount(r6);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.oui.common.style.b
    public void onPressAlphaChange(int r3) {
        if (this.changeAlphaWhenPressed == true) goto L5;
        return;
    L5:
        updateIconAlphaOnPress(RangesKt.coerceIn(r3 / 255.0f, 0.0f, 1.0f));
    }

    @Override // com.obric.oui.common.style.a
    public void onPressedChanged(View r1, boolean r2) {
        this.$$delegate_0.onPressedChanged(r1, r2);
    }

    @Override // com.obric.oui.common.style.a
    public void onSelectedChanged(View r1, boolean r2) {
        this.$$delegate_0.onSelectedChanged(r1, r2);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowBottomDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.onlyShowBottomDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowLeftDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.onlyShowLeftDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowRightDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.onlyShowRightDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowTopDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.onlyShowTopDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.a
    public void refreshColors(String r1) {
        this.$$delegate_0.refreshColors(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void resetAlphaAnim() {
        this.$$delegate_0.resetAlphaAnim();
    }

    public final void setAlignmentProgress(float r2) {
        if (this.alignmentProgress != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.alignmentProgress = r2;
        invalidate();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.view.View
    public void setBackgroundColor(int r3) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setCornerRadius(getRadius());
        r0.setColor(r3);
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r0, Drawable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.common.style.b
    public void setBorderColor(int r1) {
        this.$$delegate_1.setBorderColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setBorderWidth(int r1) {
        this.$$delegate_1.setBorderWidth(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setBottomDividerAlpha(int r1) {
        this.$$delegate_1.setBottomDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r1) {
        this.$$delegate_0.setChangeAlphaWhenDisable(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r1) {
        this.$$delegate_0.setChangeAlphaWhenPress(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenSelected(boolean r1) {
        this.$$delegate_0.setChangeAlphaWhenSelected(r1);
    }

    public final void setDisabledAlpha(float r1) {
        this.disabledAlpha = r1;
        if (isEnabled() == true) goto L6;
        updateUIOnEnableChanged(false);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setEnableShadowWidthRadius(boolean r1) {
        this.$$delegate_1.setEnableShadowWidthRadius(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r4) {
        super.setEnabled(r4);
        c r0 = this.mAlphaHelper;
        if (r0 == null) goto L6;
        r0.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4);
    L6:
        updateUIOnEnableChanged(r4);
    }

    @Override // com.obric.oui.common.style.b
    public boolean setHeightLimit(int r1) {
        return this.$$delegate_1.setHeightLimit(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(boolean r1) {
        this.$$delegate_0.setKeepPressAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setLeftDividerAlpha(int r1) {
        this.$$delegate_1.setLeftDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setOuterNormalColor(int r1) {
        this.$$delegate_1.setOuterNormalColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setOutlineExcludePadding(boolean r1) {
        this.$$delegate_1.setOutlineExcludePadding(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setOutlineInset(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.setOutlineInset(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.a
    public void setOverridePressColor(int r1) {
        this.$$delegate_0.setOverridePressColor(r1);
    }

    @Override // android.view.View
    public void setPressed(boolean r4) {
        super.setPressed(r4);
        e r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L6;
        r0.b(r4);
    L6:
        c r1 = this.mAlphaHelper;
        if (r1 == null) goto L11;
        r1.onPressedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setRadius(int r1) {
        this.$$delegate_1.setRadius(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setRadius(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.setRadius(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void setRadiusAndShadow(int r1, int r2, float r3) {
        this.$$delegate_1.setRadiusAndShadow(r1, r2, r3);
    }

    @Override // com.obric.oui.common.style.b
    public void setRadiusAndShadow(int r1, int r2, int r3, float r4) {
        this.$$delegate_1.setRadiusAndShadow(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void setRightDividerAlpha(int r1) {
        this.$$delegate_1.setRightDividerAlpha(r1);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean r4) {
        super.setSelected(r4);
        c r0 = this.mAlphaHelper;
        if (r0 == null) goto L7;
        r0.onSelectedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setShadow(k r1, k r2, boolean r3) {
        this.$$delegate_1.setShadow(r1, r2, r3);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowAlpha(float r1) {
        this.$$delegate_1.setShadowAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowColor(int r1) {
        this.$$delegate_1.setShadowColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowCornerRadius(int r1) {
        this.$$delegate_1.setShadowCornerRadius(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowElevation(int r1) {
        this.$$delegate_1.setShadowElevation(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowInsets(int r1, int r2) {
        this.$$delegate_1.setShadowInsets(r1, r2);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowStyle(int r1) {
        this.$$delegate_1.setShadowStyle(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowVisible(boolean r1, boolean r2) {
        this.$$delegate_1.setShadowVisible(r1, r2);
    }

    @Override // com.obric.oui.common.style.b
    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.$$delegate_1.setShowBorderOnlyBeforeL(r1);
    }

    public final void setTargetLeftPadding(int r1) {
        this.targetLeftPadding = r1;
    }

    @Override // com.obric.oui.common.style.b
    public void setTopDividerAlpha(int r1) {
        this.$$delegate_1.setTopDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setUseThemeGeneralShadowElevation() {
        this.$$delegate_1.setUseThemeGeneralShadowElevation();
    }

    @Override // com.obric.oui.common.style.b
    public boolean setWidthLimit(int r1) {
        return this.$$delegate_1.setWidthLimit(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setWidthMin(int r1) {
        this.$$delegate_1.setWidthMin(r1);
    }

    @Override // com.obric.oui.common.style.b
    public boolean shouldUpdateDividerColorOnPress() {
        return this.$$delegate_1.shouldUpdateDividerColorOnPress();
    }

    @Override // com.obric.oui.common.style.b
    public void updateBottomDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.updateBottomDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateBottomSeparatorColor(int r1) {
        this.$$delegate_1.updateBottomSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateDividerColorStrength(float r1) {
        this.$$delegate_1.updateDividerColorStrength(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateLeftDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.updateLeftDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateLeftSeparatorColor(int r1) {
        this.$$delegate_1.updateLeftSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateRightDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.updateRightDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateRightSeparatorColor(int r1) {
        this.$$delegate_1.updateRightSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateShadows(List<k> r3) {
        List<k> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.$$delegate_1.updateShadows(r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateTopDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.updateTopDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateTopSeparatorColor(int r1) {
        this.$$delegate_1.updateTopSeparatorColor(r1);
    }
}
