package com.obric.oui.text;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.style.a;
import com.obric.oui.common.style.b;
import com.obric.oui.common.style.c;
import com.obric.oui.common.style.e;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.i;
import com.obric.oui.common.style.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\bM\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B/\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u001c\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000fH\u0096\u0001J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0017J\t\u0010$\u001a\u00020\u0002H\u0096\u0001J-\u0010%\u001a&\u0012\f\u0012\n (*\u0004\u0018\u00010'0' (*\u0012\u0012\f\u0012\n (*\u0004\u0018\u00010'0'\u0018\u00010)0&H\u0096\u0001J\t\u0010*\u001a\u00020\u001aH\u0096\u0001J\t\u0010+\u001a\u00020\u0003H\u0096\u0001J\t\u0010,\u001a\u00020\nH\u0096\u0001J\t\u0010-\u001a\u00020.H\u0096\u0001J\t\u0010/\u001a\u00020\nH\u0096\u0001J\t\u00100\u001a\u00020\nH\u0096\u0001J\u0019\u00101\u001a\u00020\u001e2\u000e\u00102\u001a\n (*\u0004\u0018\u00010303H\u0096\u0001J\t\u00104\u001a\u00020\u000fH\u0096\u0001J\t\u00105\u001a\u00020\u000fH\u0096\u0001J\t\u00106\u001a\u00020\u000fH\u0096\u0001J\t\u00107\u001a\u00020\u000fH\u0096\u0001J\t\u00108\u001a\u00020\u000fH\u0096\u0001J\t\u00109\u001a\u00020\u000fH\u0096\u0001J\t\u0010:\u001a\u00020\u000fH\u0096\u0001J0\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\nH\u0014J\u0018\u0010A\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0014J\u0011\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\nH\u0096\u0001J!\u0010F\u001a\u00020\u001e2\u000e\u0010G\u001a\n (*\u0004\u0018\u00010H0H2\u0006\u0010I\u001a\u00020\u000fH\u0096\u0001J!\u0010J\u001a\u00020\u001e2\u000e\u0010G\u001a\n (*\u0004\u0018\u00010H0H2\u0006\u0010I\u001a\u00020\u000fH\u0096\u0001J)\u0010K\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\u0006\u0010O\u001a\u00020\nH\u0096\u0001J)\u0010P\u001a\u00020\u001e2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\nH\u0096\u0001J)\u0010U\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\n2\u0006\u0010X\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\nH\u0096\u0001J)\u0010Z\u001a\u00020\u001e2\u0006\u0010[\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\n2\u0006\u0010]\u001a\u00020\n2\u0006\u0010^\u001a\u00020\nH\u0096\u0001J\u0019\u0010_\u001a\u00020\u001e2\u000e\u0010`\u001a\n (*\u0004\u0018\u00010a0aH\u0096\u0001J\t\u0010b\u001a\u00020\u001eH\u0096\u0001J\u0013\u0010c\u001a\u00020\u001e2\b\b\u0001\u0010d\u001a\u00020\nH\u0096\u0001J\u0011\u0010e\u001a\u00020\u001e2\u0006\u0010f\u001a\u00020\nH\u0096\u0001J\u0011\u0010g\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020\nH\u0096\u0001J\u0011\u0010i\u001a\u00020\u001e2\u0006\u0010j\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010k\u001a\u00020\u001e2\u0006\u0010l\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010m\u001a\u00020\u001e2\u0006\u0010n\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010o\u001a\u00020\u001e2\u0006\u0010p\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010q\u001a\u00020\u000f2\u0006\u0010r\u001a\u00020\nH\u0096\u0001J\u0011\u0010s\u001a\u00020\u001e2\u0006\u0010t\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010u\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020\nH\u0096\u0001J\u0011\u0010v\u001a\u00020\u001e2\u0006\u0010w\u001a\u00020\nH\u0096\u0001J\u0011\u0010x\u001a\u00020\u001e2\u0006\u0010y\u001a\u00020\u000fH\u0096\u0001J)\u0010z\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\nH\u0096\u0001J\u0011\u0010{\u001a\u00020\u001e2\u0006\u0010w\u001a\u00020\nH\u0096\u0001J\u0010\u0010|\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020\u000fH\u0016J\u0011\u0010}\u001a\u00020\u001e2\u0006\u0010~\u001a\u00020\nH\u0096\u0001J,\u0010}\u001a\u00020\u001e2\u0006\u0010\u007f\u001a\u00020\n2\u0007\u0010\u0080\u0001\u001a\u00020\n2\u0007\u0010\u0081\u0001\u001a\u00020\n2\u0007\u0010\u0082\u0001\u001a\u00020\nH\u0096\u0001J$\u0010\u0083\u0001\u001a\u00020\u001e2\u0006\u0010~\u001a\u00020\n2\u0007\u0010\u0084\u0001\u001a\u00020\n2\u0007\u0010\u0085\u0001\u001a\u00020.H\u0096\u0001J-\u0010\u0083\u0001\u001a\u00020\u001e2\u0006\u0010~\u001a\u00020\n2\u0007\u0010\u0084\u0001\u001a\u00020\n2\u0007\u0010\u0086\u0001\u001a\u00020\n2\u0007\u0010\u0085\u0001\u001a\u00020.H\u0096\u0001J\u0012\u0010\u0087\u0001\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020\nH\u0096\u0001J-\u0010\u0088\u0001\u001a\u00020\u001e2\u000b\b\u0001\u0010\u0089\u0001\u001a\u0004\u0018\u00010'2\u000b\b\u0001\u0010\u008a\u0001\u001a\u0004\u0018\u00010'2\u0007\u0010\u008b\u0001\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010\u008c\u0001\u001a\u00020\u001e2\u0007\u0010\u0085\u0001\u001a\u00020.H\u0096\u0001J\u0013\u0010\u008d\u0001\u001a\u00020\u001e2\u0007\u0010\u0086\u0001\u001a\u00020\nH\u0096\u0001J\u0012\u0010\u008e\u0001\u001a\u00020\u001e2\u0006\u0010~\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u008f\u0001\u001a\u00020\u001e2\u0007\u0010\u0090\u0001\u001a\u00020\nH\u0096\u0001J\u001c\u0010\u0091\u0001\u001a\u00020\u001e2\u0007\u0010\u0092\u0001\u001a\u00020\n2\u0007\u0010\u0093\u0001\u001a\u00020\nH\u0096\u0001J\u0015\u0010\u0094\u0001\u001a\u00020\u001e2\t\b\u0001\u0010\u0095\u0001\u001a\u00020\nH\u0096\u0001J\u001c\u0010\u0096\u0001\u001a\u00020\u001e2\u0007\u0010\u0097\u0001\u001a\u00020\u000f2\u0007\u0010\u008b\u0001\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010\u0098\u0001\u001a\u00020\u001e2\u0007\u0010\u0099\u0001\u001a\u00020\u000fH\u0096\u0001J\u0012\u0010\u009a\u0001\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020\nH\u0096\u0001J\n\u0010\u009b\u0001\u001a\u00020\u001eH\u0096\u0001J\u0013\u0010\u009c\u0001\u001a\u00020\u000f2\u0007\u0010\u009d\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u009e\u0001\u001a\u00020\u001e2\u0007\u0010\u009f\u0001\u001a\u00020\nH\u0096\u0001J\n\u0010 \u0001\u001a\u00020\u000fH\u0096\u0001J*\u0010¡\u0001\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\u0006\u0010O\u001a\u00020\nH\u0096\u0001J\u0012\u0010¢\u0001\u001a\u00020\u001e2\u0006\u0010w\u001a\u00020\nH\u0096\u0001J\u0013\u0010£\u0001\u001a\u00020\u001e2\u0007\u0010¤\u0001\u001a\u00020.H\u0096\u0001J\t\u0010¥\u0001\u001a\u00020\u001eH\u0002J*\u0010¦\u0001\u001a\u00020\u001e2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\nH\u0096\u0001J\u0012\u0010§\u0001\u001a\u00020\u001e2\u0006\u0010w\u001a\u00020\nH\u0096\u0001J*\u0010¨\u0001\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\n2\u0006\u0010X\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\nH\u0096\u0001J\u0012\u0010©\u0001\u001a\u00020\u001e2\u0006\u0010w\u001a\u00020\nH\u0096\u0001J;\u0010ª\u0001\u001a\u00020\u001e2/\b\u0001\u0010«\u0001\u001a(\u0012\f\u0012\n (*\u0004\u0018\u00010'0'\u0018\u0001 (*\u0012\u0012\f\u0012\n (*\u0004\u0018\u00010'0'\u0018\u00010)0&H\u0096\u0001J*\u0010¬\u0001\u001a\u00020\u001e2\u0006\u0010[\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\n2\u0006\u0010]\u001a\u00020\n2\u0006\u0010^\u001a\u00020\nH\u0096\u0001J\u0012\u0010\u00ad\u0001\u001a\u00020\u001e2\u0006\u0010w\u001a\u00020\nH\u0096\u0001R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006®\u0001"}, d2 = {"Lcom/obric/oui/text/OTextView;", "Landroid/widget/TextView;", "Lcom/obric/oui/common/style/IOUIAlpha;", "Lcom/obric/oui/common/style/IOUILayout;", "Lcom/obric/oui/common/style/IOUIStyleProvider;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "provider", "Lcom/obric/oui/common/style/OUIStyleProvider;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/obric/oui/common/style/OUIStyleProvider;)V", EventBody.KEY_VALUE, "", "enableAutoAlignLeft", "getEnableAutoAlignLeft", "()Z", "setEnableAutoAlignLeft", "(Z)V", "mAlphaHelper", "Lcom/obric/oui/common/style/OUIAlphaHelper;", "mLayoutHelper", "Lcom/obric/oui/common/style/OUILayoutHelper;", "mOUIEffectHelper", "Lcom/obric/oui/common/style/OUIEffectHelper;", "originalGravity", "decideIsNeedUpdatePressedForegroundBySelf", "disablePressReleaseAnim", "", "disable", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "draw", "getAlphaHelper", "getCurrentShadows", "", "Lcom/obric/oui/common/style/Shadow;", "kotlin.jvm.PlatformType", "", "getEffectHelper", "getLayoutHelper", "getRadius", "getShadowAlpha", "", "getShadowColor", "getShadowElevation", "handleTouchEvent", "event", "Landroid/view/MotionEvent;", "hasBorder", "hasBottomSeparator", "hasLeftSeparator", "hasRightSeparator", "hasTopSeparator", "isEnableShadowWidthRadius", "isShadowVisible", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPressAlphaChange", "alpha", "onPressedChanged", "current", "Landroid/view/View;", "pressed", "onSelectedChanged", "onlyShowBottomDivider", "bottomInsetLeft", "bottomInsetRight", "bottomDividerHeight", "bottomDividerColor", "onlyShowLeftDivider", "leftInsetTop", "leftInsetBottom", "leftDividerWidth", "leftDividerColor", "onlyShowRightDivider", "rightInsetTop", "rightInsetBottom", "rightDividerWidth", "rightDividerColor", "onlyShowTopDivider", "topInsetLeft", "topInsetRight", "topDividerHeight", "topDividerColor", "refreshColors", MemoryInfoSectionEditActivity.KIND_SCENE, "", "resetAlphaAnim", "setBorderColor", "borderColor", "setBorderWidth", "borderWidth", "setBottomDividerAlpha", "dividerAlpha", "setChangeAlphaWhenDisable", "changeAlphaWhenDisable", "setChangeAlphaWhenPress", "changeAlphaWhenPress", "setChangeAlphaWhenSelected", "changeAlphaWhenSelected", "setEnableShadowWidthRadius", "enableShadowWidthRadius", "setHeightLimit", "heightLimit", "setKeepPressAlpha", "keep", "setLeftDividerAlpha", "setOuterNormalColor", TypedValues.Custom.S_COLOR, "setOutlineExcludePadding", "outlineExcludePadding", "setOutlineInset", "setOverridePressColor", "setPressed", "setRadius", "radius", "tlRadius", "trRadius", "blRadius", "brRadius", "setRadiusAndShadow", "shadowElevation", "shadowAlpha", "shadowColor", "setRightDividerAlpha", "setShadow", "firstShadow", "secondShadow", "animate", "setShadowAlpha", "setShadowColor", "setShadowCornerRadius", "setShadowElevation", "elevation", "setShadowInsets", "insetX", "insetY", "setShadowStyle", "styleResId", "setShadowVisible", "visible", "setShowBorderOnlyBeforeL", "showBorderOnlyBeforeL", "setTopDividerAlpha", "setUseThemeGeneralShadowElevation", "setWidthLimit", "widthLimit", "setWidthMin", "minWidth", "shouldUpdateDividerColorOnPress", "updateBottomDivider", "updateBottomSeparatorColor", "updateDividerColorStrength", "strength", "updateGravityForText", "updateLeftDivider", "updateLeftSeparatorColor", "updateRightDivider", "updateRightSeparatorColor", "updateShadows", "shadows", "updateTopDivider", "updateTopSeparatorColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OTextView extends TextView implements a, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ a f14561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ b f14562b;
    private final /* synthetic */ i c;
    private f d;
    private c e;
    private e f;
    private final int g;
    private boolean h;

    public OTextView(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, null, 14, null);
    }

    public OTextView(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, null, 12, null);
    }

    public OTextView(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r12, null, 8, null);
    }

    public OTextView(Context r3, AttributeSet r4, int r5, i r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r6, "provider");
        super(r7, r8, r5);
        this.f14561a = r6.a();
        this.f14562b = r6.b();
        this.c = r6;
        this.g = getGravity();
        r6.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        this.d = (f) ZeusTransformUtils.preCheckCast(getLayoutHelper(), f.class, "com.obric.memorydata.plugin");
        this.e = (c) ZeusTransformUtils.preCheckCast(getAlphaHelper(), c.class, "com.obric.memorydata.plugin");
        this.f = getEffectHelper();
        c r9 = this.e;
        if (r9 == null) goto L6;
        r9.setChangeAlphaWhenPress(false);
    L6:
        c r10 = this.e;
        if (r10 == null) goto L10;
        r10.setChangeAlphaWhenDisable(false);
    L10:
        setHighlightColor(r7.getColor(ZeusTransformUtils.mapRes(R.color.oui_text_highlight_color, TypedValues.Custom.S_COLOR, "oui_text_highlight_color")));
        setIncludeFontPadding(false);
    }

    public /* synthetic */ OTextView(Context r2, AttributeSet r3, int r4, i r5, int r6, DefaultConstructorMarker r7) {
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

    private final void a() {
        int r1 = 1;
        if (getLineCount() > 1) goto L5;
        boolean r0 = true;
    L6:
        int r2 = this.g & 112;
        if (r0 == true) goto L10;
        r1 = 3;
    L10:
        int r3 = r2 | r1;
        if (getGravity() == r3) goto L14;
        setGravity(r3);
        return;
    L14:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.oui.common.style.b
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.f14562b.decideIsNeedUpdatePressedForegroundBySelf();
    }

    @Override // com.obric.oui.common.style.a
    public void disablePressReleaseAnim(boolean r1) {
        this.f14561a.disablePressReleaseAnim(r1);
    }

    @Override // android.view.View
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
        return this.f14562b.getCurrentShadows();
    }

    public e getEffectHelper() {
        return this.c.c();
    }

    public final boolean getEnableAutoAlignLeft() {
        return this.h;
    }

    public b getLayoutHelper() {
        return this.c.b();
    }

    @Override // com.obric.oui.common.style.b
    public int getRadius() {
        return this.f14562b.getRadius();
    }

    @Override // com.obric.oui.common.style.b
    public float getShadowAlpha() {
        return this.f14562b.getShadowAlpha();
    }

    @Override // android.widget.TextView, com.obric.oui.common.style.b
    public int getShadowColor() {
        return this.f14562b.getShadowColor();
    }

    @Override // com.obric.oui.common.style.b
    public int getShadowElevation() {
        return this.f14562b.getShadowElevation();
    }

    @Override // com.obric.oui.common.style.a
    public void handleTouchEvent(MotionEvent r1) {
        this.f14561a.handleTouchEvent(r1);
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasBorder() {
        return this.f14562b.hasBorder();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasBottomSeparator() {
        return this.f14562b.hasBottomSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasLeftSeparator() {
        return this.f14562b.hasLeftSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasRightSeparator() {
        return this.f14562b.hasRightSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasTopSeparator() {
        return this.f14562b.hasTopSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean isEnableShadowWidthRadius() {
        return this.f14562b.isEnableShadowWidthRadius();
    }

    @Override // com.obric.oui.common.style.b
    public boolean isShadowVisible() {
        return this.f14562b.isShadowVisible();
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.h == false) goto L6;
        a();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // com.obric.oui.common.style.b
    public void onPressAlphaChange(int r1) {
        this.f14562b.onPressAlphaChange(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void onPressedChanged(View r1, boolean r2) {
        this.f14561a.onPressedChanged(r1, r2);
    }

    @Override // com.obric.oui.common.style.a
    public void onSelectedChanged(View r1, boolean r2) {
        this.f14561a.onSelectedChanged(r1, r2);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowBottomDivider(int r1, int r2, int r3, int r4) {
        this.f14562b.onlyShowBottomDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowLeftDivider(int r1, int r2, int r3, int r4) {
        this.f14562b.onlyShowLeftDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowRightDivider(int r1, int r2, int r3, int r4) {
        this.f14562b.onlyShowRightDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowTopDivider(int r1, int r2, int r3, int r4) {
        this.f14562b.onlyShowTopDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.a
    public void refreshColors(String r1) {
        this.f14561a.refreshColors(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void resetAlphaAnim() {
        this.f14561a.resetAlphaAnim();
    }

    @Override // com.obric.oui.common.style.b
    public void setBorderColor(int r1) {
        this.f14562b.setBorderColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setBorderWidth(int r1) {
        this.f14562b.setBorderWidth(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setBottomDividerAlpha(int r1) {
        this.f14562b.setBottomDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r1) {
        this.f14561a.setChangeAlphaWhenDisable(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r1) {
        this.f14561a.setChangeAlphaWhenPress(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenSelected(boolean r1) {
        this.f14561a.setChangeAlphaWhenSelected(r1);
    }

    public final void setEnableAutoAlignLeft(boolean r2) {
        if (this.h == r2) goto L6;
        this.h = r2;
        requestLayout();
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setEnableShadowWidthRadius(boolean r1) {
        this.f14562b.setEnableShadowWidthRadius(r1);
    }

    @Override // com.obric.oui.common.style.b
    public boolean setHeightLimit(int r1) {
        return this.f14562b.setHeightLimit(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(boolean r1) {
        this.f14561a.setKeepPressAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setLeftDividerAlpha(int r1) {
        this.f14562b.setLeftDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setOuterNormalColor(int r1) {
        this.f14562b.setOuterNormalColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setOutlineExcludePadding(boolean r1) {
        this.f14562b.setOutlineExcludePadding(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setOutlineInset(int r1, int r2, int r3, int r4) {
        this.f14562b.setOutlineInset(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.a
    public void setOverridePressColor(int r1) {
        this.f14561a.setOverridePressColor(r1);
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
        this.f14562b.setRadius(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setRadius(int r1, int r2, int r3, int r4) {
        this.f14562b.setRadius(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void setRadiusAndShadow(int r1, int r2, float r3) {
        this.f14562b.setRadiusAndShadow(r1, r2, r3);
    }

    @Override // com.obric.oui.common.style.b
    public void setRadiusAndShadow(int r1, int r2, int r3, float r4) {
        this.f14562b.setRadiusAndShadow(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void setRightDividerAlpha(int r1) {
        this.f14562b.setRightDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadow(k r1, k r2, boolean r3) {
        this.f14562b.setShadow(r1, r2, r3);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowAlpha(float r1) {
        this.f14562b.setShadowAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowColor(int r1) {
        this.f14562b.setShadowColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowCornerRadius(int r1) {
        this.f14562b.setShadowCornerRadius(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowElevation(int r1) {
        this.f14562b.setShadowElevation(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowInsets(int r1, int r2) {
        this.f14562b.setShadowInsets(r1, r2);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowStyle(int r1) {
        this.f14562b.setShadowStyle(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowVisible(boolean r1, boolean r2) {
        this.f14562b.setShadowVisible(r1, r2);
    }

    @Override // com.obric.oui.common.style.b
    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.f14562b.setShowBorderOnlyBeforeL(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setTopDividerAlpha(int r1) {
        this.f14562b.setTopDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setUseThemeGeneralShadowElevation() {
        this.f14562b.setUseThemeGeneralShadowElevation();
    }

    @Override // com.obric.oui.common.style.b
    public boolean setWidthLimit(int r1) {
        return this.f14562b.setWidthLimit(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setWidthMin(int r1) {
        this.f14562b.setWidthMin(r1);
    }

    @Override // com.obric.oui.common.style.b
    public boolean shouldUpdateDividerColorOnPress() {
        return this.f14562b.shouldUpdateDividerColorOnPress();
    }

    @Override // com.obric.oui.common.style.b
    public void updateBottomDivider(int r1, int r2, int r3, int r4) {
        this.f14562b.updateBottomDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateBottomSeparatorColor(int r1) {
        this.f14562b.updateBottomSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateDividerColorStrength(float r1) {
        this.f14562b.updateDividerColorStrength(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateLeftDivider(int r1, int r2, int r3, int r4) {
        this.f14562b.updateLeftDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateLeftSeparatorColor(int r1) {
        this.f14562b.updateLeftSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateRightDivider(int r1, int r2, int r3, int r4) {
        this.f14562b.updateRightDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateRightSeparatorColor(int r1) {
        this.f14562b.updateRightSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateShadows(List<k> r3) {
        List<k> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.f14562b.updateShadows(r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateTopDivider(int r1, int r2, int r3, int r4) {
        this.f14562b.updateTopDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateTopSeparatorColor(int r1) {
        this.f14562b.updateTopSeparatorColor(r1);
    }
}
