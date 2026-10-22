package com.obric.oui.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.oui.common.style.a;
import com.obric.oui.common.style.b;
import com.obric.oui.common.style.c;
import com.obric.oui.common.style.e;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.i;
import com.obric.oui.common.style.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\bZ\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B/\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0096\u0001J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0017J\t\u0010\"\u001a\u00020\u0002H\u0096\u0001J-\u0010#\u001a&\u0012\f\u0012\n &*\u0004\u0018\u00010%0% &*\u0012\u0012\f\u0012\n &*\u0004\u0018\u00010%0%\u0018\u00010'0$H\u0096\u0001J\t\u0010(\u001a\u00020\u0015H\u0096\u0001J\t\u0010)\u001a\u00020\u0003H\u0096\u0001J\t\u0010*\u001a\u00020\nH\u0096\u0001J\t\u0010+\u001a\u00020,H\u0096\u0001J\t\u0010-\u001a\u00020\nH\u0096\u0001J\t\u0010.\u001a\u00020\nH\u0096\u0001J\u0019\u0010/\u001a\u00020\u00182\u000e\u0010\u001e\u001a\n &*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J\t\u00100\u001a\u00020\u0011H\u0096\u0001J\t\u00101\u001a\u00020\u0011H\u0096\u0001J\t\u00102\u001a\u00020\u0011H\u0096\u0001J\t\u00103\u001a\u00020\u0011H\u0096\u0001J\t\u00104\u001a\u00020\u0011H\u0096\u0001J \u00105\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\t\u00106\u001a\u00020\u0011H\u0096\u0001J\b\u00107\u001a\u00020\u0011H\u0016J\t\u00108\u001a\u00020\u0011H\u0096\u0001J\b\u00109\u001a\u00020\u0018H\u0014J\b\u0010:\u001a\u00020\u0018H\u0014J\u0010\u0010;\u001a\u00020\u00182\u0006\u0010<\u001a\u00020\u0011H\u0016J\u0018\u0010=\u001a\u00020\u00182\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nH\u0014J\u0011\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\nH\u0096\u0001J!\u0010B\u001a\u00020\u00182\u000e\u0010C\u001a\n &*\u0004\u0018\u00010D0D2\u0006\u0010E\u001a\u00020\u0011H\u0096\u0001J!\u0010F\u001a\u00020\u00182\u000e\u0010C\u001a\n &*\u0004\u0018\u00010D0D2\u0006\u0010E\u001a\u00020\u0011H\u0096\u0001J\u0010\u0010G\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\nH\u0014J)\u0010I\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\nH\u0096\u0001J)\u0010N\u001a\u00020\u00182\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\nH\u0096\u0001J)\u0010S\u001a\u00020\u00182\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\nH\u0096\u0001J)\u0010X\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\nH\u0096\u0001J\u0019\u0010]\u001a\u00020\u00182\u000e\u0010^\u001a\n &*\u0004\u0018\u00010_0_H\u0096\u0001J\t\u0010`\u001a\u00020\u0018H\u0096\u0001J\u0013\u0010a\u001a\u00020\u00182\b\b\u0001\u0010b\u001a\u00020\nH\u0096\u0001J\u0011\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\nH\u0096\u0001J\u0011\u0010e\u001a\u00020\u00182\u0006\u0010f\u001a\u00020\nH\u0096\u0001J\u0011\u0010g\u001a\u00020\u00182\u0006\u0010h\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010i\u001a\u00020\u00182\u0006\u0010j\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010k\u001a\u00020\u00182\u0006\u0010l\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010m\u001a\u00020\u00182\u0006\u0010n\u001a\u00020\u0011H\u0096\u0001J\u0010\u0010o\u001a\u00020\u00182\u0006\u0010p\u001a\u00020\u0011H\u0016J\u0010\u0010q\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u0011H\u0016J\u0010\u0010s\u001a\u00020\u00112\u0006\u0010t\u001a\u00020\nH\u0016J\u0011\u0010u\u001a\u00020\u00182\u0006\u0010v\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010w\u001a\u00020\u00182\u0006\u0010f\u001a\u00020\nH\u0096\u0001J\u0010\u0010x\u001a\u00020\u00182\u0006\u0010y\u001a\u00020\nH\u0016J\u0011\u0010z\u001a\u00020\u00182\u0006\u0010{\u001a\u00020\nH\u0096\u0001J\u0011\u0010|\u001a\u00020\u00182\u0006\u0010}\u001a\u00020\u0011H\u0096\u0001J,\u0010~\u001a\u00020\u00182\u0006\u0010\u007f\u001a\u00020\n2\u0007\u0010\u0080\u0001\u001a\u00020\n2\u0007\u0010\u0081\u0001\u001a\u00020\n2\u0007\u0010\u0082\u0001\u001a\u00020\nH\u0096\u0001J\u0012\u0010\u0083\u0001\u001a\u00020\u00182\u0006\u0010{\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0084\u0001\u001a\u00020\u00182\u0006\u0010E\u001a\u00020\u0011H\u0016J\u0013\u0010\u0085\u0001\u001a\u00020\u00182\u0007\u0010\u0086\u0001\u001a\u00020\nH\u0096\u0001J.\u0010\u0085\u0001\u001a\u00020\u00182\u0007\u0010\u0087\u0001\u001a\u00020\n2\u0007\u0010\u0088\u0001\u001a\u00020\n2\u0007\u0010\u0089\u0001\u001a\u00020\n2\u0007\u0010\u008a\u0001\u001a\u00020\nH\u0096\u0001J%\u0010\u008b\u0001\u001a\u00020\u00182\u0007\u0010\u0086\u0001\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\n2\u0007\u0010\u008d\u0001\u001a\u00020,H\u0096\u0001J.\u0010\u008b\u0001\u001a\u00020\u00182\u0007\u0010\u0086\u0001\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\n2\u0007\u0010\u008e\u0001\u001a\u00020\n2\u0007\u0010\u008d\u0001\u001a\u00020,H\u0096\u0001J\u0012\u0010\u008f\u0001\u001a\u00020\u00182\u0006\u0010f\u001a\u00020\nH\u0096\u0001J\u0012\u0010\u0090\u0001\u001a\u00020\u00182\u0007\u0010\u0091\u0001\u001a\u00020\u0011H\u0016J-\u0010\u0092\u0001\u001a\u00020\u00182\u000b\b\u0001\u0010\u0093\u0001\u001a\u0004\u0018\u00010%2\u000b\b\u0001\u0010\u0094\u0001\u001a\u0004\u0018\u00010%2\u0007\u0010\u0095\u0001\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\u0096\u0001\u001a\u00020\u00182\u0007\u0010\u008d\u0001\u001a\u00020,H\u0096\u0001J\u0013\u0010\u0097\u0001\u001a\u00020\u00182\u0007\u0010\u008e\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u0098\u0001\u001a\u00020\u00182\u0007\u0010\u0086\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u0099\u0001\u001a\u00020\u00182\u0007\u0010\u009a\u0001\u001a\u00020\nH\u0096\u0001J\u001c\u0010\u009b\u0001\u001a\u00020\u00182\u0007\u0010\u009c\u0001\u001a\u00020\n2\u0007\u0010\u009d\u0001\u001a\u00020\nH\u0096\u0001J\u0015\u0010\u009e\u0001\u001a\u00020\u00182\t\b\u0001\u0010\u009f\u0001\u001a\u00020\nH\u0096\u0001J\u001c\u0010 \u0001\u001a\u00020\u00182\u0007\u0010¡\u0001\u001a\u00020\u00112\u0007\u0010\u0095\u0001\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010¢\u0001\u001a\u00020\u00182\u0007\u0010£\u0001\u001a\u00020\u0011H\u0096\u0001J\u000f\u0010¤\u0001\u001a\u00020\u00182\u0006\u0010p\u001a\u00020\u0011J\u0012\u0010¥\u0001\u001a\u00020\u00182\u0006\u0010f\u001a\u00020\nH\u0096\u0001J\n\u0010¦\u0001\u001a\u00020\u0018H\u0096\u0001J\u000f\u0010§\u0001\u001a\u00020\u00182\u0006\u0010p\u001a\u00020\u0011J\u0012\u0010¨\u0001\u001a\u00020\u00112\u0007\u0010©\u0001\u001a\u00020\nH\u0016J\u0013\u0010ª\u0001\u001a\u00020\u00182\u0007\u0010«\u0001\u001a\u00020\nH\u0096\u0001J\n\u0010¬\u0001\u001a\u00020\u0011H\u0096\u0001J*\u0010\u00ad\u0001\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\nH\u0096\u0001J\u0012\u0010®\u0001\u001a\u00020\u00182\u0006\u0010{\u001a\u00020\nH\u0096\u0001J\u0013\u0010¯\u0001\u001a\u00020\u00182\u0007\u0010°\u0001\u001a\u00020,H\u0096\u0001J*\u0010±\u0001\u001a\u00020\u00182\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\nH\u0096\u0001J\u0012\u0010²\u0001\u001a\u00020\u00182\u0006\u0010{\u001a\u00020\nH\u0096\u0001J*\u0010³\u0001\u001a\u00020\u00182\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\nH\u0096\u0001J\u0012\u0010´\u0001\u001a\u00020\u00182\u0006\u0010{\u001a\u00020\nH\u0096\u0001J;\u0010µ\u0001\u001a\u00020\u00182/\b\u0001\u0010¶\u0001\u001a(\u0012\f\u0012\n &*\u0004\u0018\u00010%0%\u0018\u0001 &*\u0012\u0012\f\u0012\n &*\u0004\u0018\u00010%0%\u0018\u00010'0$H\u0096\u0001J*\u0010·\u0001\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\nH\u0096\u0001J\u0012\u0010¸\u0001\u001a\u00020\u00182\u0006\u0010{\u001a\u00020\nH\u0096\u0001R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¹\u0001"}, d2 = {"Lcom/obric/oui/layout/OUILinearLayout;", "Landroid/widget/LinearLayout;", "Lcom/obric/oui/common/style/IOUIAlpha;", "Lcom/obric/oui/common/style/IOUILayout;", "Lcom/obric/oui/common/style/IOUIStyleProvider;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "provider", "Lcom/obric/oui/common/style/OUIStyleProvider;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/obric/oui/common/style/OUIStyleProvider;)V", "mAlphaHelper", "Lcom/obric/oui/common/style/OUIAlphaHelper;", "mIsFakePressed", "", "mLayoutHelper", "Lcom/obric/oui/common/style/OUILayoutHelper;", "mOUIEffectHelper", "Lcom/obric/oui/common/style/OUIEffectHelper;", "decideIsNeedUpdatePressedForegroundBySelf", "disablePressReleaseAnim", "", "disable", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchGenericMotionEvent", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "draw", "getAlphaHelper", "getCurrentShadows", "", "Lcom/obric/oui/common/style/Shadow;", "kotlin.jvm.PlatformType", "", "getEffectHelper", "getLayoutHelper", "getRadius", "getShadowAlpha", "", "getShadowColor", "getShadowElevation", "handleTouchEvent", "hasBorder", "hasBottomSeparator", "hasLeftSeparator", "hasRightSeparator", "hasTopSeparator", CommonConsts.APM_INNER_EVENT_COST_INIT, "isEnableShadowWidthRadius", "isFakePressed", "isShadowVisible", "onAttachedToWindow", "onDetachedFromWindow", "onHoverChanged", "hovered", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPressAlphaChange", "alpha", "onPressedChanged", "current", "Landroid/view/View;", "pressed", "onSelectedChanged", "onWindowVisibilityChanged", "visibility", "onlyShowBottomDivider", "bottomInsetLeft", "bottomInsetRight", "bottomDividerHeight", "bottomDividerColor", "onlyShowLeftDivider", "leftInsetTop", "leftInsetBottom", "leftDividerWidth", "leftDividerColor", "onlyShowRightDivider", "rightInsetTop", "rightInsetBottom", "rightDividerWidth", "rightDividerColor", "onlyShowTopDivider", "topInsetLeft", "topInsetRight", "topDividerHeight", "topDividerColor", "refreshColors", MemoryInfoSectionEditActivity.KIND_SCENE, "", "resetAlphaAnim", "setBorderColor", "borderColor", "setBorderWidth", "borderWidth", "setBottomDividerAlpha", "dividerAlpha", "setChangeAlphaWhenDisable", "changeAlphaWhenDisable", "setChangeAlphaWhenPress", "changeAlphaWhenPress", "setChangeAlphaWhenSelected", "changeAlphaWhenSelected", "setEnableShadowWidthRadius", "enableShadowWidthRadius", "setEnabled", "enabled", "setFakePressed", "fakePressed", "setHeightLimit", "heightLimit", "setKeepPressAlpha", "keep", "setLeftDividerAlpha", "setMinimumHeight", "minHeight", "setOuterNormalColor", TypedValues.Custom.S_COLOR, "setOutlineExcludePadding", "outlineExcludePadding", "setOutlineInset", "left", "top", "right", "bottom", "setOverridePressColor", "setPressed", "setRadius", "radius", "tlRadius", "trRadius", "blRadius", "brRadius", "setRadiusAndShadow", "shadowElevation", "shadowAlpha", "shadowColor", "setRightDividerAlpha", "setSelected", BuildConfig.FLAVOR, "setShadow", "firstShadow", "secondShadow", "animate", "setShadowAlpha", "setShadowColor", "setShadowCornerRadius", "setShadowElevation", "elevation", "setShadowInsets", "insetX", "insetY", "setShadowStyle", "styleResId", "setShadowVisible", "visible", "setShowBorderOnlyBeforeL", "showBorderOnlyBeforeL", "setSoundEffectEnabled", "setTopDividerAlpha", "setUseThemeGeneralShadowElevation", "setVibrateEnabled", "setWidthLimit", "widthLimit", "setWidthMin", "minWidth", "shouldUpdateDividerColorOnPress", "updateBottomDivider", "updateBottomSeparatorColor", "updateDividerColorStrength", "strength", "updateLeftDivider", "updateLeftSeparatorColor", "updateRightDivider", "updateRightSeparatorColor", "updateShadows", "shadows", "updateTopDivider", "updateTopSeparatorColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OUILinearLayout extends LinearLayout implements a, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ a f13965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ b f13966b;
    private final /* synthetic */ i c;
    private f d;
    private c e;
    private e f;
    private boolean g;

    public OUILinearLayout(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, null, 14, null);
    }

    public OUILinearLayout(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, null, 12, null);
    }

    public OUILinearLayout(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r12, null, 8, null);
    }

    public OUILinearLayout(Context r3, AttributeSet r4, int r5, i r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r6, "provider");
        super(r7, r8);
        this.f13965a = r6.a();
        this.f13966b = r6.b();
        this.c = r6;
        r6.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        this.d = (f) ZeusTransformUtils.preCheckCast(getLayoutHelper(), f.class, "com.obric.memorydata.plugin");
        this.e = (c) ZeusTransformUtils.preCheckCast(getAlphaHelper(), c.class, "com.obric.memorydata.plugin");
        this.f = getEffectHelper();
        a(r7, r8, r5);
    }

    public /* synthetic */ OUILinearLayout(Context r2, AttributeSet r3, int r4, i r5, int r6, DefaultConstructorMarker r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = new i(r8, r9, r4, 0);
    L11:
        this(r8, r9, r4, r5);
    }

    public final void a(Context r2, AttributeSet r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        setVibrateEnabled(false);
        setSoundEffectEnabled(false);
        setWillNotDraw(false);
    }

    @Override // com.obric.oui.common.style.b
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.f13966b.decideIsNeedUpdatePressedForegroundBySelf();
    }

    @Override // com.obric.oui.common.style.a
    public void disablePressReleaseAnim(boolean r1) {
        this.f13965a.disablePressReleaseAnim(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.dispatchDraw(r4);
        f r0 = this.d;
        if (r0 == null) goto L6;
        r0.a(r4, getWidth(), getHeight());
    L6:
        f r3 = this.d;
        if (r3 == null) goto L11;
        r3.b(r4);
        return;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        e r0 = this.f;
        if (r0 == null) goto L7;
        r0.a(r2);
    L7:
        return super.dispatchGenericMotionEvent(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        e r0 = this.f;
        if (r0 == null) goto L6;
        r0.b(r2);
    L6:
        c r1 = this.e;
        if (r1 == null) goto L11;
        r1.handleTouchEvent(r2);
    L11:
        return super.dispatchTouchEvent(r2);
    }

    @Override // android.view.View
    public void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        f r0 = this.d;
        if (r0 == null) goto L6;
        r0.a(r2);
    L6:
        super.draw(r2);
    }

    public a getAlphaHelper() {
        return this.c.a();
    }

    @Override // com.obric.oui.common.style.b
    public List<k> getCurrentShadows() {
        return this.f13966b.getCurrentShadows();
    }

    public e getEffectHelper() {
        return this.c.c();
    }

    public b getLayoutHelper() {
        return this.c.b();
    }

    @Override // com.obric.oui.common.style.b
    public int getRadius() {
        return this.f13966b.getRadius();
    }

    @Override // com.obric.oui.common.style.b
    public float getShadowAlpha() {
        return this.f13966b.getShadowAlpha();
    }

    @Override // com.obric.oui.common.style.b
    public int getShadowColor() {
        return this.f13966b.getShadowColor();
    }

    @Override // com.obric.oui.common.style.b
    public int getShadowElevation() {
        return this.f13966b.getShadowElevation();
    }

    @Override // com.obric.oui.common.style.a
    public void handleTouchEvent(MotionEvent r1) {
        this.f13965a.handleTouchEvent(r1);
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasBorder() {
        return this.f13966b.hasBorder();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasBottomSeparator() {
        return this.f13966b.hasBottomSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasLeftSeparator() {
        return this.f13966b.hasLeftSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasRightSeparator() {
        return this.f13966b.hasRightSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasTopSeparator() {
        return this.f13966b.hasTopSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean isEnableShadowWidthRadius() {
        return this.f13966b.isEnableShadowWidthRadius();
    }

    @Override // com.obric.oui.common.style.b
    public boolean isFakePressed() {
        return this.g;
    }

    @Override // com.obric.oui.common.style.b
    public boolean isShadowVisible() {
        return this.f13966b.isShadowVisible();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e r0 = this.f;
        if (r0 == null) goto L7;
        r0.c();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e r0 = this.f;
        if (r0 == null) goto L7;
        r0.d();
        return;
    }

    @Override // android.view.View
    public void onHoverChanged(boolean r1) {
        super.onHoverChanged(r1);
        e r0 = this.f;
        if (r0 == null) goto L7;
        r0.a(r1);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r4, int r5) {
        f r0 = this.d;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        int r6 = r0.a(r4);
        f r1 = this.d;
        Intrinsics.checkNotNull(r1);
        int r7 = r1.b(r5);
        super.onMeasure(r6, r7);
        f r2 = this.d;
        Intrinsics.checkNotNull(r2);
        int r3 = r2.a(r6, getMeasuredWidth());
        f r8 = this.d;
        Intrinsics.checkNotNull(r8);
        int r9 = r8.b(r7, getMeasuredHeight());
        if (r6 != r3) goto L7;
        if (r7 != r9) goto L7;
        return;
    L7:
        super.onMeasure(r3, r9);
        return;
    L8:
        super.onMeasure(r4, r5);
    }

    public void onPressAlphaChange(int r1) {
        this.f13966b.onPressAlphaChange(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void onPressedChanged(View r1, boolean r2) {
        this.f13965a.onPressedChanged(r1, r2);
    }

    @Override // com.obric.oui.common.style.a
    public void onSelectedChanged(View r1, boolean r2) {
        this.f13965a.onSelectedChanged(r1, r2);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        e r0 = this.f;
        if (r0 == null) goto L7;
        r0.a(r1);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowBottomDivider(int r1, int r2, int r3, int r4) {
        this.f13966b.onlyShowBottomDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowLeftDivider(int r1, int r2, int r3, int r4) {
        this.f13966b.onlyShowLeftDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowRightDivider(int r1, int r2, int r3, int r4) {
        this.f13966b.onlyShowRightDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowTopDivider(int r1, int r2, int r3, int r4) {
        this.f13966b.onlyShowTopDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.a
    public void refreshColors(String r1) {
        this.f13965a.refreshColors(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void resetAlphaAnim() {
        this.f13965a.resetAlphaAnim();
    }

    @Override // com.obric.oui.common.style.b
    public void setBorderColor(int r1) {
        this.f13966b.setBorderColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setBorderWidth(int r1) {
        this.f13966b.setBorderWidth(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setBottomDividerAlpha(int r1) {
        this.f13966b.setBottomDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r1) {
        this.f13965a.setChangeAlphaWhenDisable(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r1) {
        this.f13965a.setChangeAlphaWhenPress(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenSelected(boolean r1) {
        this.f13965a.setChangeAlphaWhenSelected(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setEnableShadowWidthRadius(boolean r1) {
        this.f13966b.setEnableShadowWidthRadius(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r4) {
        super.setEnabled(r4);
        c r0 = this.e;
        if (r0 == null) goto L7;
        r0.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4);
        return;
    }

    public void setFakePressed(boolean r3) {
        if (this.g == r3) goto L13;
        this.g = r3;
        e r0 = this.f;
        if (r0 == null) goto L8;
        r0.b(r3);
    L8:
        c r4 = this.e;
        if (r4 == null) goto L14;
        r4.onPressedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), this.g);
        return;
    L14:
        return;
    }

    @Override // com.obric.oui.common.style.b
    public boolean setHeightLimit(int r2) {
        f r0 = this.d;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        if (r0.setHeightLimit(r2) == false) goto L10;
        requestLayout();
        invalidate();
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(boolean r1) {
        this.f13965a.setKeepPressAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setLeftDividerAlpha(int r1) {
        this.f13966b.setLeftDividerAlpha(r1);
    }

    @Override // android.view.View
    public void setMinimumHeight(int r2) {
        f r0 = this.d;
        if (r0 == null) goto L6;
        r0.c(r2);
    L6:
        super.setMinimumHeight(r2);
    }

    @Override // com.obric.oui.common.style.b
    public void setOuterNormalColor(int r1) {
        this.f13966b.setOuterNormalColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setOutlineExcludePadding(boolean r1) {
        this.f13966b.setOutlineExcludePadding(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setOutlineInset(int r1, int r2, int r3, int r4) {
        this.f13966b.setOutlineInset(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.a
    public void setOverridePressColor(int r1) {
        this.f13965a.setOverridePressColor(r1);
    }

    @Override // android.view.View
    public void setPressed(boolean r4) {
        e r0 = this.f;
        if (r0 == null) goto L6;
        r0.b(r4);
    L6:
        super.setPressed(r4);
        c r1 = this.e;
        if (r1 == null) goto L11;
        r1.onPressedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setRadius(int r1) {
        this.f13966b.setRadius(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setRadius(int r1, int r2, int r3, int r4) {
        this.f13966b.setRadius(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void setRadiusAndShadow(int r1, int r2, float r3) {
        this.f13966b.setRadiusAndShadow(r1, r2, r3);
    }

    @Override // com.obric.oui.common.style.b
    public void setRadiusAndShadow(int r1, int r2, int r3, float r4) {
        this.f13966b.setRadiusAndShadow(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void setRightDividerAlpha(int r1) {
        this.f13966b.setRightDividerAlpha(r1);
    }

    @Override // android.view.View
    public void setSelected(boolean r4) {
        super.setSelected(r4);
        c r0 = this.e;
        if (r0 == null) goto L7;
        r0.onSelectedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setShadow(k r1, k r2, boolean r3) {
        this.f13966b.setShadow(r1, r2, r3);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowAlpha(float r1) {
        this.f13966b.setShadowAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowColor(int r1) {
        this.f13966b.setShadowColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowCornerRadius(int r1) {
        this.f13966b.setShadowCornerRadius(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowElevation(int r1) {
        this.f13966b.setShadowElevation(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowInsets(int r1, int r2) {
        this.f13966b.setShadowInsets(r1, r2);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowStyle(int r1) {
        this.f13966b.setShadowStyle(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowVisible(boolean r1, boolean r2) {
        this.f13966b.setShadowVisible(r1, r2);
    }

    @Override // com.obric.oui.common.style.b
    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.f13966b.setShowBorderOnlyBeforeL(r1);
    }

    public final void setSoundEffectEnabled(boolean r1) {
        e r0 = this.f;
        if (r0 == null) goto L7;
        r0.d(r1);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setTopDividerAlpha(int r1) {
        this.f13966b.setTopDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setUseThemeGeneralShadowElevation() {
        this.f13966b.setUseThemeGeneralShadowElevation();
    }

    public final void setVibrateEnabled(boolean r1) {
        e r0 = this.f;
        if (r0 == null) goto L7;
        r0.c(r1);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public boolean setWidthLimit(int r2) {
        f r0 = this.d;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        if (r0.setWidthLimit(r2) == false) goto L10;
        requestLayout();
        invalidate();
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public void setWidthMin(int r1) {
        this.f13966b.setWidthMin(r1);
    }

    @Override // com.obric.oui.common.style.b
    public boolean shouldUpdateDividerColorOnPress() {
        return this.f13966b.shouldUpdateDividerColorOnPress();
    }

    @Override // com.obric.oui.common.style.b
    public void updateBottomDivider(int r1, int r2, int r3, int r4) {
        this.f13966b.updateBottomDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateBottomSeparatorColor(int r1) {
        this.f13966b.updateBottomSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateDividerColorStrength(float r1) {
        this.f13966b.updateDividerColorStrength(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateLeftDivider(int r1, int r2, int r3, int r4) {
        this.f13966b.updateLeftDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateLeftSeparatorColor(int r1) {
        this.f13966b.updateLeftSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateRightDivider(int r1, int r2, int r3, int r4) {
        this.f13966b.updateRightDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateRightSeparatorColor(int r1) {
        this.f13966b.updateRightSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateShadows(List<k> r3) {
        List<k> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.f13966b.updateShadows(r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateTopDivider(int r1, int r2, int r3, int r4) {
        this.f13966b.updateTopDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateTopSeparatorColor(int r1) {
        this.f13966b.updateTopSeparatorColor(r1);
    }
}
