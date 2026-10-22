package com.obric.oui.indicator;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u0097\u00012\u00020\u0001:\b\u0097\u0001\u0098\u0001\u0099\u0001\u009a\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u00109\u001a\u00020%2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0007H\u0017J \u0010>\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020AH\u0002J(\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020IH\u0002J\u0018\u0010J\u001a\u00020<2\u0006\u0010C\u001a\u00020D2\u0006\u0010K\u001a\u00020FH\u0002J \u0010L\u001a\u00020<2\u0006\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020IH\u0002J \u0010P\u001a\u00020<2\u0006\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020IH\u0002J\b\u0010Q\u001a\u00020<H\u0002J\u0010\u0010R\u001a\u00020<2\u0006\u0010@\u001a\u00020AH\u0002J \u0010S\u001a\u00020<2\u0006\u0010T\u001a\u00020A2\u0006\u0010U\u001a\u00020A2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010V\u001a\u00020<2\u0006\u0010W\u001a\u00020(H\u0002J\b\u0010X\u001a\u00020YH\u0016J\u0010\u0010Z\u001a\u00020<2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010[\u001a\u00020<H\u0002J\b\u0010\\\u001a\u00020\u001dH\u0002J\u001e\u0010]\u001a\u00020<2\u0006\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020IJ\u0012\u0010^\u001a\u0004\u0018\u00010(2\u0006\u0010_\u001a\u00020\u0007H\u0002J\u0012\u0010`\u001a\u00020<2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010a\u001a\u00020I2\u0006\u0010b\u001a\u00020I2\u0006\u0010c\u001a\u00020I2\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010d\u001a\u00020<H\u0014J\b\u0010e\u001a\u00020<H\u0014J\b\u0010f\u001a\u00020<H\u0014J\b\u0010g\u001a\u00020<H\u0014J\u0018\u0010h\u001a\u00020<2\u0006\u0010@\u001a\u00020A2\u0006\u0010i\u001a\u00020jH\u0002J\u0016\u0010k\u001a\u00020<2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\u0010\u0010m\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0007H\u0016J\b\u0010n\u001a\u00020<H\u0016J\u0018\u0010o\u001a\u00020<2\u0006\u0010W\u001a\u00020(2\u0006\u0010p\u001a\u00020\u0007H\u0002J\b\u0010q\u001a\u00020<H\u0002J\b\u0010r\u001a\u00020<H\u0002J\u0010\u0010s\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0007H\u0017J\u0018\u0010t\u001a\u00020<2\u0006\u0010u\u001a\u00020\u00072\u0006\u0010i\u001a\u00020jH\u0002J\b\u0010v\u001a\u00020\u0007H\u0002J\b\u0010w\u001a\u00020\u0007H\u0002J\b\u0010x\u001a\u00020\u0007H\u0002J\b\u0010y\u001a\u00020\u0007H\u0002J\u0010\u0010z\u001a\u00020{2\u0006\u0010,\u001a\u00020\u0007H\u0002J\u0010\u0010|\u001a\u00020I2\u0006\u0010K\u001a\u00020FH\u0002J\u0010\u0010}\u001a\u00020I2\u0006\u0010K\u001a\u00020FH\u0002J\"\u0010~\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010\u007f2\u0007\u0010\u0081\u0001\u001a\u00020\u00072\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J\u0015\u0010\u0084\u0001\u001a\u0004\u0018\u0001062\b\u0010\u0085\u0001\u001a\u00030\u0080\u0001H\u0002J\u0019\u0010\u0086\u0001\u001a\u00020F2\u0006\u0010W\u001a\u00020(2\u0006\u0010@\u001a\u00020AH\u0002J\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0003\u0010\u0088\u0001J\t\u0010\u0089\u0001\u001a\u00020\u0007H\u0002J\u001a\u0010\u008a\u0001\u001a\u00020A2\u0007\u0010\u0081\u0001\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u0007H\u0002J\t\u0010\u008b\u0001\u001a\u00020IH\u0002J\u0013\u0010\u008c\u0001\u001a\u00020<2\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001J\u0012\u0010\u008c\u0001\u001a\u00020<2\t\b\u0001\u0010\u008f\u0001\u001a\u00020\u0007J\u0013\u0010\u0090\u0001\u001a\u00020\u00192\b\u0010\u0091\u0001\u001a\u00030\u0083\u0001H\u0002J\u0011\u0010\u0092\u0001\u001a\u00020<2\u0006\u0010C\u001a\u00020DH\u0002J\u0011\u0010\u0093\u0001\u001a\u00020<2\u0006\u0010W\u001a\u00020(H\u0002J\t\u0010\u0094\u0001\u001a\u00020<H\u0002J\t\u0010\u0095\u0001\u001a\u00020<H\u0002J\u000e\u0010\u0096\u0001\u001a\u00020\u0007*\u00030\u0083\u0001H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010)\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00078\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\"R$\u0010,\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010\"R(\u00100\u001a\u0004\u0018\u00010/2\b\u0010\u001e\u001a\u0004\u0018\u00010/@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009b\u0001"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator;", "Lcom/obric/oui/indicator/OBaseIndicator;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "custom", "Lcom/obric/oui/indicator/OBaseIndicator$CustomDot;", "getCustom", "()Lcom/obric/oui/indicator/OBaseIndicator$CustomDot;", "defaultSidePadding", "getDefaultSidePadding", "()I", "defaultVerticalSidePadding", "getDefaultVerticalSidePadding", "dotsTrackLayout", "Landroid/widget/LinearLayout;", "groupLayout", "Lcom/obric/oui/indicator/IndicatorGroupLayout;", "hasExplicitDotsHeight", "", "hasExplicitDotsSpacing", "hasExplicitDotsWidth", "indicatorAnimator", "Lcom/obric/oui/indicator/IndicatorAnimator;", EventBody.KEY_VALUE, "maxVisibleDots", "getMaxVisibleDots", "setMaxVisibleDots", "(I)V", "recycledDefaultDots", "Ljava/util/ArrayDeque;", "Lcom/obric/oui/indicator/IndicatorDotView;", "renderedSlot", "", "Lcom/obric/oui/indicator/OCarouselIndicator$RenderSlot;", "selectedDotColor", "getSelectedDotColor", "setSelectedDotColor", "sizeStyle", "getSizeStyle", "setSizeStyle", "Landroid/content/res/ColorStateList;", "startDotTintList", "getStartDotTintList", "()Landroid/content/res/ColorStateList;", "setStartDotTintList", "(Landroid/content/res/ColorStateList;)V", "startDrawableDotView", "Lcom/obric/oui/indicator/IndicatorImageDotView;", "viewportTransitionInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "acquireDefaultDotView", "reusableDefaultDots", "addDot", "", "index", "applyDotColorIfVisible", TypedValues.Custom.S_COLOR, "state", "Lcom/obric/oui/indicator/IndicatorViewportState;", "applyDotTransitionVisualState", "dotView", "Landroid/view/View;", "sourceVisualState", "Lcom/obric/oui/indicator/IndicatorDotVisualState;", "targetVisualState", "progress", "", "applyDotVisualState", "visualState", "applyPageScroll", "selectedPosition", "nextPosition", "positionOffset", "applyScrollColors", "applySizeStyle", "applyViewportState", "applyViewportTransitionProgress", "sourceState", "targetState", "bindSlot", "slot", "buildOnPageChangedListener", "Lcom/obric/oui/indicator/OnPageChangeListenerHelper;", "cancelDotAnimation", "cancelVisibleDotAnimations", "createViewportTransitionAnimator", "dispatchManualPageScroll", "findVisibleSlot", "pageIndex", CommonConsts.APM_INNER_EVENT_COST_INIT, "interpolate", CommonConsts.APM_INNER_EVENT_COST_START, "end", "onRefreshDotsDraws", "onRefreshDotsSize", "onRefreshDotsSpacing", "onRefreshIndicator", "rebindVisibleSlots", InfoRequestQPSOptTraceLogger.REASON, "Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "recycleDefaultDots", "defaultDots", "refreshDotDraw", "refreshParentLayout", "refreshRenderedSlot", "currentItem", "refreshVisibleDotsDraws", "refreshVisibleDotsSize", "removeDot", "renderViewportState", "current", "resolveBoxHeightPx", "resolveBoxSizePx", "resolveBoxSpacingPx", "resolveBoxWidthPx", "resolveDotLayoutProfile", "Lcom/obric/oui/indicator/OCarouselIndicator$DotLayoutProfile;", "resolveDotTargetAlpha", "resolveDotTargetScale", "resolveRenderSlotBindings", "", "Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding;", "totalCount", "visibleRange", "Lkotlin/ranges/IntRange;", "resolveReplacementView", "binding", "resolveSlotVisualState", "resolveStableContentWidth", "()Ljava/lang/Integer;", "resolveStartIconSizePx", "resolveViewportState", "resolveViewportStepDistance", "setStartDotDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "iconResId", "shouldRebindVisibleSlots", "targetRange", "updateDotLayout", "updateSlotLayout", "updateStableContentWidth", "updateVisibleDotsSpacing", "size", "Companion", "DotLayoutProfile", "RenderSlot", "SlotBinding", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCarouselIndicator extends OBaseIndicator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f13944b = null;
    private static final boolean r = false;
    private IndicatorGroupLayout c;
    private LinearLayout d;
    private IndicatorAnimator e;
    private final List<c> f;
    private final ArrayDeque<IndicatorDotView> g;
    private boolean h;
    private boolean i;
    private boolean j;
    private IndicatorImageDotView k;
    private final DecelerateInterpolator l;
    private ColorStateList m;
    private int n;
    private int o;
    private int p;
    private final ArgbEvaluator q;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator$Companion;", "", "()V", "DEFAULT_CORNER_RADIUS", "", "DEFAULT_DOT_HEIGHT_DP", "", "DEFAULT_DOT_SPACING_DP", "DEFAULT_DOT_WIDTH_DP", "EDGE_DOT_SCALE", "IF_DEBUG", "", "NORMAL_BOX_SIZE_DP", "NORMAL_HORIZONTAL_PADDING_DP", "NORMAL_PIC_HORIZONTAL_PADDING_DP", "NORMAL_VERTICAL_PADDING_DP", "SIZE_STYLE_SMALL_DP", "SIZE_STYLE_SMALL_SPACING_DP", "SMALL_BOX_SIZE_DP", "SMALL_PADDING_DP", "START_ICON_DOT_SIZE_DP", "START_ICON_SMALL_DOT_SIZE_DP", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator$DotLayoutProfile;", "", "width", "", "height", "spacing", "(FFF)V", "getHeight", "()F", "getSpacing", "getWidth", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f13945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f13946b;
        private final float c;

        public b(float r1, float r2, float r3) {
            this.f13945a = r1;
            this.f13946b = r2;
            this.c = r3;
        }

        public final float a() {
            return this.f13945a;
        }

        public final float b() {
            return this.f13946b;
        }

        public final float c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(Float.valueOf(this.f13945a), Float.valueOf(r6.f13945a)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.f13946b), Float.valueOf(r6.f13946b)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.c), Float.valueOf(r6.c)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Float.hashCode(this.f13945a) * 31) + Float.hashCode(this.f13946b)) * 31) + Float.hashCode(this.c);
        }

        public String toString() {
            return "DotLayoutProfile(width=" + this.f13945a + ", height=" + this.f13946b + ", spacing=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator$RenderSlot;", "", "binding", "Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding;", "box", "Landroid/widget/FrameLayout;", "view", "Landroid/view/View;", "indicator", "Lcom/obric/oui/indicator/IndicatorIcon;", "(Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding;Landroid/widget/FrameLayout;Landroid/view/View;Lcom/obric/oui/indicator/IndicatorIcon;)V", "getBinding", "()Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding;", "getBox", "()Landroid/widget/FrameLayout;", "getIndicator", "()Lcom/obric/oui/indicator/IndicatorIcon;", "getView", "()Landroid/view/View;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f13947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final FrameLayout f13948b;
        private final View c;
        private final com.obric.oui.indicator.b d;

        public c(d r3, FrameLayout r4, View r5, com.obric.oui.indicator.b r6) {
            com.obric.oui.indicator.b r7 = (com.obric.oui.indicator.b) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.oui.indicator.b.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "binding");
            Intrinsics.checkNotNullParameter(r4, "box");
            Intrinsics.checkNotNullParameter(r5, "view");
            Intrinsics.checkNotNullParameter(r7, "indicator");
            this.f13947a = r3;
            this.f13948b = r4;
            this.c = r5;
            this.d = r7;
        }

        public final d a() {
            return this.f13947a;
        }

        public final FrameLayout b() {
            return this.f13948b;
        }

        public final View c() {
            return this.c;
        }

        public final com.obric.oui.indicator.b d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13947a, r6.f13947a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13948b, r6.f13948b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f13947a.hashCode() * 31) + this.f13948b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "RenderSlot(binding=" + this.f13947a + ", box=" + this.f13948b + ", view=" + this.c + ", indicator=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding;", "", "()V", "LeadingDummy", "Page", "TrailingDummy", "Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding$Page;", "Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding$LeadingDummy;", "Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding$TrailingDummy;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static abstract class d {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding$LeadingDummy;", "Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding;", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f13949a = null;

            static {
                f13949a = new a();
            }

            private a() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding$Page;", "Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding;", "pageIndex", "", "(I)V", "getPageIndex", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f13950a;

            public b(int r2) {
                super(null);
                this.f13950a = r2;
            }

            public final int a() {
                return this.f13950a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
                return false;
            L8:
                b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
                if (this.f13950a == r6.f13950a) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return Integer.hashCode(this.f13950a);
            }

            public String toString() {
                return "Page(pageIndex=" + this.f13950a + ')';
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding$TrailingDummy;", "Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding;", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class c extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f13951a = null;

            static {
                f13951a = new c();
            }

            private c() {
                super(null);
            }
        }

        private d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13952a = null;

        static {
            int[] r0 = new int[IndicatorDotVisualState.values().length];
            r0[IndicatorDotVisualState.EDGE.ordinal()] = 1;
            r0[IndicatorDotVisualState.HIDDEN.ordinal()] = 2;
            f13952a = r0;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0010¢\u0006\u0002\b\fR\u0014\u0010\u0002\u001a\u00020\u00038PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"com/obric/oui/indicator/OCarouselIndicator$buildOnPageChangedListener$1", "Lcom/obric/oui/indicator/OnPageChangeListenerHelper;", "pageCount", "", "getPageCount$OUI_standardRelease", "()I", "onPageScrolled", "", "selectedPosition", "nextPosition", "positionOffset", "", "onPageScrolled$OUI_standardRelease", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f extends com.obric.oui.indicator.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OCarouselIndicator f13953a;

        f(OCarouselIndicator r1) {
            this.f13953a = r1;
        }

        @Override // com.obric.oui.indicator.e
        public int a() {
            return this.f13953a.i();
        }

        @Override // com.obric.oui.indicator.e
        public void a(int r1, int r2, float r3) {
            OCarouselIndicator.a(this.f13953a, r1, r2, r3);
        }
    }

    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u001a"}, d2 = {"com/obric/oui/indicator/OCarouselIndicator$createViewportTransitionAnimator$1", "Lcom/obric/oui/indicator/IndicatorAnimator$Host;", "maxVisibleDots", "", "getMaxVisibleDots", "()I", "pagerCount", "getPagerCount", "applyViewportState", "", "state", "Lcom/obric/oui/indicator/IndicatorViewportState;", "applyViewportTransitionProgress", "sourceState", "targetState", "progress", "", "cancelVisibleDotAnimations", "rebindVisibleSlots", InfoRequestQPSOptTraceLogger.REASON, "Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "resolveViewportStepDistance", "shouldRebindVisibleSlots", "", "targetRange", "Lkotlin/ranges/IntRange;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class g implements IndicatorAnimator.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OCarouselIndicator f13954a;

        g(OCarouselIndicator r1) {
            this.f13954a = r1;
        }

        @Override // com.obric.oui.indicator.IndicatorAnimator.c
        public int a() {
            return this.f13954a.i();
        }

        @Override // com.obric.oui.indicator.IndicatorAnimator.c
        public void a(com.obric.oui.indicator.c r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            OCarouselIndicator.a(this.f13954a, r2);
        }

        @Override // com.obric.oui.indicator.IndicatorAnimator.c
        public void a(com.obric.oui.indicator.c r2, IndicatorAnimator.RenderReason r3) {
            Intrinsics.checkNotNullParameter(r2, "state");
            Intrinsics.checkNotNullParameter(r3, InfoRequestQPSOptTraceLogger.REASON);
            OCarouselIndicator.a(this.f13954a, r2, r3);
        }

        @Override // com.obric.oui.indicator.IndicatorAnimator.c
        public void a(com.obric.oui.indicator.c r2, com.obric.oui.indicator.c r3, float r4) {
            Intrinsics.checkNotNullParameter(r2, "sourceState");
            Intrinsics.checkNotNullParameter(r3, "targetState");
            OCarouselIndicator.a(this.f13954a, r2, r3, r4);
        }

        @Override // com.obric.oui.indicator.IndicatorAnimator.c
        public boolean a(IntRange r2) {
            Intrinsics.checkNotNullParameter(r2, "targetRange");
            return OCarouselIndicator.a(this.f13954a, r2);
        }

        @Override // com.obric.oui.indicator.IndicatorAnimator.c
        public int b() {
            return this.f13954a.getMaxVisibleDots();
        }

        @Override // com.obric.oui.indicator.IndicatorAnimator.c
        public float c() {
            return OCarouselIndicator.a(this.f13954a);
        }
    }

    static {
        f13944b = new a(null);
    }

    public OCarouselIndicator(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OCarouselIndicator(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OCarouselIndicator(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.f = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.g = new ArrayDeque();
        this.l = new DecelerateInterpolator();
        this.n = Integer.MAX_VALUE;
        this.p = ContextCompat.getColor(r6, ZeusTransformUtils.mapRes(R.color.oui_text_1, TypedValues.Custom.S_COLOR, "oui_text_1"));
        this.q = new ArgbEvaluator();
        a(r7);
        a();
        f();
    }

    public /* synthetic */ OCarouselIndicator(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final float a(float r1, float r2, float r3) {
        return r1 + ((r2 - r1) * r3);
    }

    private final float a(IndicatorDotVisualState r1) {
        int r0 = e.f13952a[r1.ordinal()];
        if (r0 != 1) goto L5;
        return 0.5f;
    L5:
        if (r0 == 2) goto L7;
        return 1.0f;
    L7:
        return 0.0f;
    }

    public static final /* synthetic */ float a(OCarouselIndicator r0) {
        return r0.s();
    }

    private final IndicatorDotView a(ArrayDeque<IndicatorDotView> r9) {
        IndicatorDotView r10 = (IndicatorDotView) ZeusTransformUtils.preCheckCast(r9.pollFirst(), IndicatorDotView.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L14;
        r10 = (IndicatorDotView) ZeusTransformUtils.preCheckCast(this.g.pollFirst(), IndicatorDotView.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L12;
        if (r == false) goto L9;
        com.obric.oui.c.a.b.b("OCarouselIndicator", "Create new default dot");
    L9:
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        return new IndicatorDotView(r3, null, 0, 6, null);
    L12:
        if (r == false) goto L14;
        com.obric.oui.c.a.b.b("OCarouselIndicator", Intrinsics.stringPlus("Reuse pooled default dot, remaining=", Integer.valueOf(this.g.size())));
    L14:
        return r10;
    }

    private final IndicatorDotVisualState a(c r2, com.obric.oui.indicator.c r3) {
        d r1 = r2.a();
        if (ZeusTransformUtils.instanceOf(r1, d.b.class) == false) goto L6;
        return r3.a(((d.b) ZeusTransformUtils.preCheckCast(r1, d.b.class, "com.obric.memorydata.plugin")).a());
    L6:
        if (Intrinsics.areEqual(r1, d.a.f13949a) == false) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L13;
        return IndicatorDotVisualState.HIDDEN;
    L13:
        throw new NoWhenBranchMatchedException();
    L8:
        r4 = Intrinsics.areEqual(r1, d.c.f13951a);
        goto L9
    }

    private final IndicatorImageDotView a(d r4) {
        if (ZeusTransformUtils.instanceOf(r4, d.b.class) == false) goto L8;
        if (((d.b) ZeusTransformUtils.preCheckCast(r4, d.b.class, "com.obric.memorydata.plugin")).a() == 0) goto L15;
        return null;
    L15:
        return this.k;
    L8:
        if (Intrinsics.areEqual(r4, d.a.f13949a) == false) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        return null;
    L14:
        throw new NoWhenBranchMatchedException();
    L10:
        r3 = Intrinsics.areEqual(r4, d.c.f13951a);
        goto L11
    }

    private final b a(int r7) {
        b r0 = new b(getCustom().a(), getCustom().b(), getCustom().c());
        if (r7 != 1) goto L6;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r8, "context");
        float r9 = h.c(r8, 4.0f);
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "context");
        float r3 = h.c(r4, 4.0f);
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "context");
        return new b(r9, r3, h.c(r6, 2.0f));
    L6:
        return r0;
    }

    private final com.obric.oui.indicator.c a(int r1, int r2) {
        return com.obric.oui.indicator.d.a(r1, r2, this.n);
    }

    private final List<d> a(int r6, IntRange r7) {
        if (r6 <= 0) goto L24;
        if (r7.isEmpty() == true) goto L24;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r2.add(new d.b(((IntIterator) ZeusTransformUtils.preCheckCast(r1, IntIterator.class, "com.obric.memorydata.plugin")).nextInt()));
        goto L8
    L10:
        List<d> r3 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        if (r6 > b(r7)) goto L13;
        return r3;
    L13:
        List r5 = CollectionsKt.createListBuilder(r3.size() + 2);
        if (r7.getFirst() <= 0) goto L16;
        Object r4 = new d.b(r7.getFirst() - 1);
    L17:
        r5.add((d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.memorydata.plugin"));
        r5.addAll((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin"));
        if (r7.getLast() >= (r6 - 1)) goto L20;
        Object r8 = new d.b(r7.getLast() + 1);
    L21:
        r5.add((d) ZeusTransformUtils.preCheckCast(r8, d.class, "com.obric.memorydata.plugin"));
        return CollectionsKt.build(r5);
    L20:
        r8 = d.c.f13951a;
        goto L21
    L16:
        r4 = d.a.f13949a;
    L24:
        return CollectionsKt.emptyList();
    }

    private final void a(int r6, int r7, float r8) {
        int r0 = i();
        com.obric.oui.indicator.c r1 = a(r0, r6);
        com.obric.oui.indicator.c r2 = a(r0, r7);
        IndicatorAnimator r3 = null;
        if (Intrinsics.areEqual(r1.b(), r2.b()) == true) goto L9;
        IndicatorAnimator r4 = this.e;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
    L8:
        a(r3.a(r6, r7, r8), IndicatorAnimator.RenderReason.SCROLL);
    L14:
        b(r6, r7, r8);
        invalidate();
        return;
    L7:
        r3 = r4;
        goto L8
    L9:
        IndicatorAnimator r5 = this.e;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
    L13:
        r3.a(IndicatorAnimator.RenderReason.REFRESH_DOTS, r1);
        a(r1, r2, r8);
        goto L14
    L12:
        r3 = r5;
        goto L13
    }

    private final void a(int r1, int r2, com.obric.oui.indicator.c r3) {
        if (r3.b(r1) == true) goto L5;
        return;
    L5:
        c r0 = b(r1);
        if (r0 != null) goto L8;
        return;
    L8:
        r0.d().setDotColor(r2);
        r0.d().invalidate();
    }

    private final void a(int r2, IndicatorAnimator.RenderReason r3) {
        com.obric.oui.indicator.c r4 = a(i(), r2);
        IndicatorAnimator r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
        r1 = null;
    L5:
        r1.a(r3, r4);
    }

    private final void a(AttributeSet r11) {
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        IndicatorGroupLayout r0 = new IndicatorGroupLayout(r3, null, 0, 6, null);
        r0.setGravity(17);
        this.c = r0;
        LinearLayout r1 = new LinearLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r1.setOrientation(0);
        r1.setGravity(17);
        this.d = r1;
        IndicatorGroupLayout r2 = this.c;
        IndicatorGroupLayout r4 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r2 = null;
    L5:
        LinearLayout r5 = this.d;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dotsTrackLayout");
        r5 = null;
    L8:
        r2.addView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        IndicatorGroupLayout r6 = this.c;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
    L12:
        addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-2, getLayoutHeight()), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.e = m();
        if (r12 == null) goto L15;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        TypedArray r13 = r7.obtainStyledAttributes(r12, getCustom().d(), 0, 0);
        Intrinsics.checkNotNullExpressionValue(r13, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.h = r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsWidth, "styleable", "OCarouselIndicator_oui_dotsWidth"));
        this.i = r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsHeight, "styleable", "OCarouselIndicator_oui_dotsHeight"));
        this.j = r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsSpacing, "styleable", "OCarouselIndicator_oui_dotsSpacing"));
        setSelectedDotColor(r13.getColor(ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_selectedDotColor, "styleable", "OCarouselIndicator_oui_selectedDotColor"), getSelectedDotColor()));
        setMaxVisibleDots(r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_maxVisibleDots, "styleable", "OCarouselIndicator_oui_maxVisibleDots"), getMaxVisibleDots()));
        setSizeStyle(r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_sizeStyle, "styleable", "OCarouselIndicator_oui_sizeStyle"), 0));
        r13.recycle();
    L15:
        n();
        return;
    L11:
        r4 = r6;
        goto L12
    }

    private final void a(View r1) {
        r1.animate().setListener(null).cancel();
    }

    private final void a(View r6, IndicatorDotVisualState r7) {
        boolean r1 = false;
        if (r7 != IndicatorDotVisualState.HIDDEN) goto L5;
        int r0 = 4;
    L6:
        float r2 = a(r7);
        float r8 = b(r7);
        if (r6.getVisibility() == r0) goto L9;
    L23:
        a(r6);
        r6.setVisibility(r0);
        r6.setScaleX(r2);
        r6.setScaleY(r2);
        r6.setAlpha(r8);
        return;
    L9:
        if (r6.getScaleX() != r2) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L23;
        if (r6.getScaleY() != r2) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L23;
        if (r6.getAlpha() != r8) goto L21;
        r1 = true;
    L21:
        if (r1 == false) goto L23;
        return;
    L16:
        r4 = false;
        goto L17
    L11:
        r3 = false;
        goto L12
    L5:
        r0 = 0;
        goto L6
    }

    private final void a(View r4, IndicatorDotVisualState r5, IndicatorDotVisualState r6, float r7) {
        if (r5 != r6) goto L5;
        a(r4, r5);
        return;
    L5:
        float r0 = a(r5);
        float r1 = a(r6);
        float r8 = b(r5);
        float r2 = b(r6);
        float r3 = a(r0, r1, r7);
        float r9 = a(r8, r2, r7);
        boolean r10 = false;
        if (r7 >= 1.0f) goto L8;
    L10:
        int r11 = 0;
    L12:
        if (r4.getVisibility() == r11) goto L14;
    L28:
        a(r4);
        r4.setVisibility(r11);
        r4.setScaleX(r3);
        r4.setScaleY(r3);
        r4.setAlpha(r9);
        return;
    L14:
        if (r4.getScaleX() != r3) goto L16;
        boolean r12 = true;
    L17:
        if (r12 == false) goto L28;
        if (r4.getScaleY() != r3) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == false) goto L28;
        if (r4.getAlpha() != r9) goto L26;
        r10 = true;
    L26:
        if (r10 == false) goto L28;
        return;
    L21:
        r13 = false;
        goto L22
    L16:
        r12 = false;
        goto L17
    L8:
        if (r6 != IndicatorDotVisualState.HIDDEN) goto L10;
        r11 = 4;
        goto L12
    }

    private final void a(final c r3) {
        b(r3);
        OBaseIndicator.e r0 = getPager();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        a(r3, r1);
        r3.b().setOnClickListener(new $$Lambda$OCarouselIndicator$Ijk6gZ_1qxcV56rAP8xql9lc44(r3, this));
        return;
    L5:
        r1 = r0.b();
        goto L6
    }

    private final void a(c r6, int r7) {
        boolean r2 = true;
        if (r6.c() != this.k) goto L9;
        IndicatorImageDotView r0 = (IndicatorImageDotView) ZeusTransformUtils.preCheckCast(r6.c(), IndicatorImageDotView.class, "com.obric.memorydata.plugin");
        if (r7 != 0) goto L7;
        boolean r1 = true;
    L8:
        r0.setSelected(r1);
        goto L9
    L7:
        r1 = false;
    L9:
        com.obric.oui.indicator.b r3 = r6.d();
        d r4 = r6.a();
        if (ZeusTransformUtils.instanceOf(r4, d.b.class) == false) goto L16;
        if (((d.b) ZeusTransformUtils.preCheckCast(r4, d.b.class, "com.obric.memorydata.plugin")).a() != r7) goto L14;
        int r8 = this.p;
    L21:
        r3.setDotColor(r8);
        r6.d().setCornerRadius(getDotsCornerRadius());
        r6.d().setStrokeWidth(getDotsStrokeWidth());
        r6.d().setStrokeColor(getDotsStrokeColor());
        r6.d().invalidate();
        return;
    L14:
        r8 = getDotsColor();
        goto L21
    L16:
        if (Intrinsics.areEqual(r4, d.a.f13949a) == true) goto L19;
        r2 = Intrinsics.areEqual(r4, d.c.f13951a);
    L19:
        if (r2 == true) goto L14;
        throw new NoWhenBranchMatchedException();
    }

    private static final void a(c r2, OCarouselIndicator r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "$slot");
        Intrinsics.checkNotNullParameter(r3, "this$0");
        d r5 = r2.a();
        if (ZeusTransformUtils.instanceOf(r5, d.b.class) == true) goto L5;
        return;
    L5:
        if (r3.getDotsClickable() == true) goto L7;
        return;
    L7:
        if (((d.b) ZeusTransformUtils.preCheckCast(r5, d.b.class, "com.obric.memorydata.plugin")).a() >= r3.i()) goto L15;
        OBaseIndicator.e r6 = r3.getPager();
        if (r6 == null) goto L16;
        r6.a(((d.b) ZeusTransformUtils.preCheckCast(r5, d.b.class, "com.obric.memorydata.plugin")).a(), false);
        return;
    L16:
        return;
    }

    public static final /* synthetic */ void a(OCarouselIndicator r0, int r1, int r2, float r3) {
        r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ void a(OCarouselIndicator r0, com.obric.oui.indicator.c r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(OCarouselIndicator r0, com.obric.oui.indicator.c r1, IndicatorAnimator.RenderReason r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(OCarouselIndicator r0, com.obric.oui.indicator.c r1, com.obric.oui.indicator.c r2, float r3) {
        r0.a(r1, r2, r3);
    }

    private final void a(com.obric.oui.indicator.c r7) {
        OBaseIndicator.e r0 = getPager();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.memorydata.plugin");
        a(r3.c(), a(r3, r7));
        r3.b().setVisibility(r3.c().getVisibility());
        a(r3, r1);
        goto L8
    L10:
        return;
    L5:
        r1 = r0.b();
        goto L6
    }

    private final void a(com.obric.oui.indicator.c r13, IndicatorAnimator.RenderReason r14) {
        v();
        IntRange r0 = r13.b();
        ArrayDeque<IndicatorDotView> r1 = new ArrayDeque();
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        IndicatorDotView r5 = null;
        if (r2.hasNext() == false) goto L11;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.memorydata.plugin");
        r3.b().removeView(r3.c());
        View r4 = r3.c();
        if (ZeusTransformUtils.instanceOf(r4, IndicatorDotView.class) == false) goto L8;
        r5 = (IndicatorDotView) ZeusTransformUtils.preCheckCast(r4, IndicatorDotView.class, "com.obric.memorydata.plugin");
    L8:
        if (r5 == null) goto L3;
        r1.addLast(r5);
        goto L3
    L11:
        LinearLayout r6 = this.d;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("dotsTrackLayout");
        r6 = null;
    L14:
        r6.removeAllViews();
        this.f.clear();
        List<d> r15 = a(r13.a(), r0);
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r7.hasNext() == false) goto L24;
        d r8 = (d) ZeusTransformUtils.preCheckCast(r7.next(), d.class, "com.obric.memorydata.plugin");
        Object r9 = a(r8);
        if (r9 != null) goto L20;
        r9 = a(r1);
    L20:
        c r10 = new c(r8, new FrameLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), (View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"), (com.obric.oui.indicator.b) ZeusTransformUtils.preCheckCast(r9, com.obric.oui.indicator.b.class, "com.obric.memorydata.plugin"));
        a(r10);
        r10.b().addView(r10.c());
        LinearLayout r11 = this.d;
        if (r11 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("dotsTrackLayout");
        r11 = null;
    L23:
        r11.addView((View) ZeusTransformUtils.preCheckCast(r10.b(), View.class, "com.obric.memorydata.plugin"));
        this.f.add(r10);
        goto L16
    L24:
        b(r1);
        z();
        if (r == false) goto L36;
        com.obric.oui.c.a.b.b("OCarouselIndicator", "Rebound slots, reason=" + r14.getLogValue() + " range=" + r0 + " bindings=" + r15 + " visible=" + this.f.size() + " recycled=" + this.g.size());
        return;
    }

    private final void a(com.obric.oui.indicator.c r8, com.obric.oui.indicator.c r9, float r10) {
        OBaseIndicator.e r0 = getPager();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.memorydata.plugin");
        a(r3.c(), a(r3, r8), a(r3, r9), r10);
        r3.b().setVisibility(r3.c().getVisibility());
        a(r3, r1);
        goto L8
    L10:
        return;
    L5:
        r1 = r0.b();
        goto L6
    }

    public static final /* synthetic */ boolean a(OCarouselIndicator r0, IntRange r1) {
        return r0.a(r1);
    }

    private final boolean a(IntRange r9) {
        List<d> r10 = a(i(), r9);
        if (this.f.size() == r10.size()) goto L5;
        return true;
    L5:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r3 = 0;
    L7:
        if (r11.hasNext() == false) goto L26;
        Object r4 = r11.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.memorydata.plugin");
        c r7 = (c) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(this.f, r3), c.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        IndicatorImageDotView r8 = a(r6);
        if (Intrinsics.areEqual(r7.a(), r6) == false) goto L16;
        if (r8 != null) goto L19;
    L21:
        if (r8 != null) goto L25;
        if (ZeusTransformUtils.instanceOf(r7.c(), IndicatorDotView.class) == true) goto L25;
        return true;
    L25:
        r3 = r5;
        goto L7
    L19:
        if (r7.c() == r8) goto L21;
        return true;
    L16:
        return true;
    L13:
        return true;
    L26:
        return false;
    }

    private final float b(IndicatorDotVisualState r1) {
        if (e.f13952a[r1.ordinal()] != 2) goto L5;
        return 0.0f;
    L5:
        return 1.0f;
    }

    private final int b(IntRange r1) {
        if (r1.isEmpty() == false) goto L6;
        return 0;
    L6:
        return (r1.getLast() - r1.getFirst()) + 1;
    }

    private final c b(int r7) {
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L19;
        Object r0 = r6.next();
        d r2 = ((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin")).a();
        boolean r4 = false;
        boolean r5 = true;
        if (ZeusTransformUtils.instanceOf(r2, d.b.class) == false) goto L11;
        if (((d.b) ZeusTransformUtils.preCheckCast(r2, d.b.class, "com.obric.memorydata.plugin")).a() != r7) goto L15;
        r4 = true;
    L15:
        if (r4 == false) goto L4;
    L21:
        return (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin");
    L11:
        if (Intrinsics.areEqual(r2, d.a.f13949a) == true) goto L14;
        r5 = Intrinsics.areEqual(r2, d.c.f13951a);
    L14:
        if (r5 == true) goto L15;
        throw new NoWhenBranchMatchedException();
    L19:
        r0 = null;
        goto L21
    }

    private final void b(int r8, int r9, float r10) {
        IndicatorAnimator r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
        r0 = null;
    L5:
        com.obric.oui.indicator.c r1 = r0.b();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.b(r8) == true) goto L11;
        return;
    L11:
        if (r1.b(r9) == false) goto L24;
        Object r2 = this.q.evaluate(r10, Integer.valueOf(this.p), Integer.valueOf(getDotsColor()));
        Objects.requireNonNull(r2, "null cannot be cast to non-null type kotlin.Int");
        int r3 = ((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue();
        Object r11 = this.q.evaluate(r10, Integer.valueOf(getDotsColor()), Integer.valueOf(this.p));
        Objects.requireNonNull(r11, "null cannot be cast to non-null type kotlin.Int");
        a(r9, ((Integer) ZeusTransformUtils.preCheckCast(r11, Integer.class, "com.obric.memorydata.plugin")).intValue(), r1);
        OBaseIndicator.e r12 = getPager();
        boolean r13 = false;
        if (r12 != null) goto L17;
    L19:
        if (r13 == false) goto L21;
        r3 = this.p;
    L21:
        a(r8, r3, r1);
        return;
    L17:
        if (r8 != r12.b()) goto L19;
        r13 = true;
        goto L19
    }

    private final void b(View r4) {
        int r0 = w();
        if (r4 != this.k) goto L5;
        int r1 = r0;
    L7:
        if (r4 == this.k) goto L10;
        r0 = (int) getDotsHeight();
    L10:
        r4.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(r1, r0, 17), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r1 = (int) getDotsWidth();
        goto L7
    }

    private final void b(c r6) {
        int r0 = p();
        int r1 = q();
        ViewGroup.LayoutParams r2 = r6.b().getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r2, LinearLayout.LayoutParams.class) == false) goto L5;
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r3 != null) goto L8;
        r3 = new LinearLayout.LayoutParams(r0, r1);
    L8:
        r3.width = r0;
        r3.height = r1;
        r6.b().setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        b(r6.c());
        return;
    L5:
        r3 = null;
        goto L6
    }

    private final void b(ArrayDeque<IndicatorDotView> r4) {
    L3:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
        this.g.addLast((IndicatorDotView) ZeusTransformUtils.preCheckCast(r4.removeFirst(), IndicatorDotView.class, "com.obric.memorydata.plugin"));
        goto L3
    }

    /* JADX INFO: renamed from: lambda$Ijk6g-Z_1qxcV56rAP8xql9lc44, reason: not valid java name */
    public static /* synthetic */ void m1316lambda$Ijk6gZ_1qxcV56rAP8xql9lc44(c r0, OCarouselIndicator r1, View r2) {
        a(r0, r1, r2);
    }

    private final IndicatorAnimator m() {
        LinearLayout r1 = this.d;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dotsTrackLayout");
        r1 = null;
    L6:
        return new IndicatorAnimator((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"), (TimeInterpolator) ZeusTransformUtils.preCheckCast(this.l, TimeInterpolator.class, "com.obric.memorydata.plugin"), (IndicatorAnimator.c) ZeusTransformUtils.preCheckCast(new g(this), IndicatorAnimator.c.class, "com.obric.memorydata.plugin"));
    }

    private final void n() {
        b r0 = a(this.o);
        if (this.h == true) goto L6;
        setDotsWidth(r0.a());
    L6:
        if (this.i == true) goto L9;
        setDotsHeight(r0.b());
    L9:
        if (this.j == true) goto L12;
        setDotsSpacing(r0.c());
    L12:
        if (r == false) goto L15;
        com.obric.oui.c.a.b.b("OCarouselIndicator", "sizeStyle=" + this.o + " resolved to w=" + getDotsWidth() + " h=" + getDotsHeight() + " spacing=" + getDotsSpacing() + " explicit=[" + this.h + ',' + this.i + ',' + this.j + ']');
        return;
    }

    private final int o() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        if (this.o != 1) goto L5;
        float r3 = 8.0f;
    L7:
        return h.b(r0, r3);
    L5:
        r3 = 12.0f;
        goto L7
    }

    private final int p() {
        return Math.max(o(), (int) getDotsWidth());
    }

    private final int q() {
        return Math.max(o(), (int) getDotsHeight());
    }

    private final int r() {
        return MathKt.roundToInt(getDotsWidth() + (getDotsSpacing() * 2.0f)) - p();
    }

    private final float s() {
        return p() + r();
    }

    private final void t() {
        Integer r0 = u();
        IndicatorGroupLayout r1 = this.c;
        IndicatorGroupLayout r2 = null;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r1 = null;
    L6:
        if (Intrinsics.areEqual(r1.getFixedContentWidthPx(), r0) == false) goto L8;
        return;
    L8:
        IndicatorGroupLayout r3 = this.c;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
    L12:
        r2.setFixedContentWidthPx(r0);
        if (r == false) goto L16;
        com.obric.oui.c.a.b.b("OCarouselIndicator", "Stable content width updated, width=" + r0 + " pagerCount=" + i() + " maxVisibleDots=" + this.n);
        return;
    L16:
        return;
    L11:
        r2 = r3;
        goto L12
    }

    private final Integer u() {
        int r0 = i();
        if (r0 <= 0) goto L12;
        int r2 = this.n;
        if (r0 <= r2) goto L12;
        if (r2 != 0) goto L11;
        com.obric.oui.c.a.b.d("OCarouselIndicator", Intrinsics.stringPlus("Skip stable content width because maxVisibleDots is invalid, maxVisibleDots=", Integer.valueOf(r2)));
        return null;
    L11:
        return Integer.valueOf((p() * r2) + ((r2 - 1) * r()));
    L12:
        return null;
    }

    private final void v() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        a(((c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.memorydata.plugin")).c());
        goto L4
    }

    private final int w() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        if (this.o != 1) goto L5;
        float r3 = 6.0f;
    L7:
        return h.b(r0, r3);
    L5:
        r3 = 10.0f;
        goto L7
    }

    private final void x() {
        OBaseIndicator.e r0 = getPager();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        a((c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.memorydata.plugin"), r1);
        goto L8
    L10:
        return;
    L5:
        r1 = r0.b();
        goto L6
    }

    private final void y() {
        OBaseIndicator.e r0 = getPager();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.memorydata.plugin");
        b(r3);
        a(r3, r1);
        goto L8
    L10:
        return;
    L5:
        r1 = r0.b();
        goto L6
    }

    private final void z() {
        if (this.f.isEmpty() == false) goto L5;
        return;
    L5:
        int r0 = r();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r4 = 0;
    L7:
        if (r1.hasNext() == false) goto L16;
        Object r5 = r1.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        c r7 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r8 = r7.b().getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r9 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r8, LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r9.setMarginStart(0);
        if (r4 != CollectionsKt.getLastIndex(this.f)) goto L14;
        int r10 = 0;
    L15:
        r9.setMarginEnd(r10);
        r7.b().setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r4 = r6;
        goto L7
    L14:
        r10 = r0;
        goto L15
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void b() {
        t();
        OBaseIndicator.e r0 = getPager();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        a(r1, IndicatorAnimator.RenderReason.REFRESH_DOTS);
        return;
    L5:
        r1 = r0.b();
        goto L6
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void c() {
        x();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void d() {
        t();
        z();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void e() {
        t();
        y();
        z();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void f() {
        if (getInitialized() == true) goto L6;
        setPendingRefreshParentLayout(true);
        return;
    L6:
        setPendingRefreshParentLayout(false);
        IndicatorGroupLayout r5 = null;
        if (getType() != 1) goto L18;
        IndicatorGroupLayout r0 = this.c;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r0 = null;
    L11:
        r0.setBgColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.carousel_indicator_bg_color, TypedValues.Custom.S_COLOR, "carousel_indicator_bg_color")));
        IndicatorGroupLayout r1 = this.c;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r1 = null;
    L14:
        r1.setCornerRadius(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 100));
        IndicatorGroupLayout r2 = this.c;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r2 = null;
    L17:
        r2.setDrawBackground(true);
    L25:
        IndicatorGroupLayout r3 = this.c;
        if (r3 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r3 = null;
    L28:
        r3.setPadding(getSidePadding(), getVerticalSidePadding(), getSidePadding(), getVerticalSidePadding());
        t();
        IndicatorGroupLayout r4 = this.c;
        if (r4 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r4 = null;
    L31:
        IndicatorGroupLayout r6 = this.c;
        if (r6 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
    L35:
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
        r7.height = getLayoutHeight();
        r4.setLayoutParams(r7);
        requestLayout();
        return;
    L34:
        r5 = r6;
        goto L35
    L18:
        IndicatorGroupLayout r8 = this.c;
        if (r8 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r8 = null;
    L21:
        r8.setBgColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.Transparent, TypedValues.Custom.S_COLOR, "Transparent")));
        IndicatorGroupLayout r9 = this.c;
        if (r9 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r9 = null;
    L24:
        r9.setDrawBackground(false);
        goto L25
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public com.obric.oui.indicator.e g() {
        return (com.obric.oui.indicator.e) ZeusTransformUtils.preCheckCast(new f(this), com.obric.oui.indicator.e.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public OBaseIndicator.b getCustom() {
        float r1 = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 6.0f);
        float r3 = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 6.0f);
        float r4 = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4.0f);
        int[] r5 = R.styleable.OCarouselIndicator;
        Intrinsics.checkNotNullExpressionValue(r5, "OCarouselIndicator");
        return new OBaseIndicator.b(r1, r3, r4, r5, ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_type, "styleable", "OCarouselIndicator_oui_type"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_layoutHeight, "styleable", "OCarouselIndicator_oui_layoutHeight"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsWidth, "styleable", "OCarouselIndicator_oui_dotsWidth"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsHeight, "styleable", "OCarouselIndicator_oui_dotsHeight"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsSpacing, "styleable", "OCarouselIndicator_oui_dotsSpacing"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsColor, "styleable", "OCarouselIndicator_oui_dotsColor"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsCornerRadius, "styleable", "OCarouselIndicator_oui_dotsCornerRadius"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsClickable, "styleable", "OCarouselIndicator_oui_dotsClickable"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsStrokeColor, "styleable", "OCarouselIndicator_oui_dotsStrokeColor"), ZeusTransformUtils.mapRes(R.styleable.OCarouselIndicator_oui_dotsStrokeWidth, "styleable", "OCarouselIndicator_oui_dotsStrokeWidth"));
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public int getDefaultSidePadding() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        if (this.o != 1) goto L6;
        float r3 = 2.0f;
    L10:
        return h.b(r0, r3);
    L6:
        if (getType() != 1) goto L8;
        r3 = 7.0f;
        goto L10
    L8:
        r3 = 6.0f;
        goto L10
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public int getDefaultVerticalSidePadding() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        if (this.o != 1) goto L5;
        float r3 = 2.0f;
    L7:
        return h.b(r0, r3);
    L5:
        r3 = 4.0f;
        goto L7
    }

    public final int getMaxVisibleDots() {
        return this.n;
    }

    public final int getSelectedDotColor() {
        return this.p;
    }

    public final int getSizeStyle() {
        return this.o;
    }

    public final ColorStateList getStartDotTintList() {
        return this.m;
    }

    public final void setMaxVisibleDots(int r2) {
        if (this.n == r2) goto L6;
        this.n = r2;
        h();
        return;
    }

    public final void setSelectedDotColor(int r4) {
        if (getType() != 1) goto L5;
        r4 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"));
    L8:
        this.p = r4;
        j();
        return;
    L5:
        if (this.p != r4) goto L8;
    }

    public final void setSizeStyle(int r2) {
        if (this.o == r2) goto L6;
        this.o = r2;
        n();
        f();
        h();
        return;
    }

    public final void setStartDotDrawable(int r5) {
        if (r5 == 0) goto L5;
        Drawable r1 = ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
        if (r1 == null) goto L11;
        setStartDotDrawable(r1);
        return;
    L11:
        if (r == false) goto L17;
        com.obric.oui.c.a.b.c("OCarouselIndicator", Intrinsics.stringPlus("setStartDotDrawable(iconResId) ignored, drawable not found for resId=", Integer.valueOf(r5)));
        return;
    L17:
        return;
    L5:
        if (r == false) goto L16;
        com.obric.oui.c.a.b.c("OCarouselIndicator", "setStartDotDrawable(iconResId) ignored, iconResId=0");
        return;
    }

    public final void setStartDotDrawable(Drawable r6) {
        if (r6 != null) goto L5;
        this.k = null;
        h();
        return;
    L5:
        Drawable.ConstantState r7 = r6.getConstantState();
        if (r7 != null) goto L9;
        com.obric.oui.c.a.b.d("OCarouselIndicator", "setStartDotDrawable(drawable) ignored, drawable.constantState is null");
        return;
    L9:
        Drawable r8 = r7.newDrawable(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin")).mutate();
        Intrinsics.checkNotNullExpressionValue(r8, "constantState.newDrawable(resources).mutate()");
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        IndicatorImageDotView r2 = new IndicatorImageDotView(r3, r8);
        r2.setDotTintList(getStartDotTintList());
        this.k = r2;
        if (r == false) goto L23;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin");
        boolean r4 = false;
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L14;
    L16:
        Iterator r10 = r9.iterator();
    L18:
        if (r10.hasNext() == false) goto L22;
        if (Intrinsics.areEqual(((c) ZeusTransformUtils.preCheckCast(r10.next(), c.class, "com.obric.memorydata.plugin")).a(), new d.b(0)) == false) goto L18;
        r4 = true;
    L22:
        com.obric.oui.c.a.b.b("OCarouselIndicator", Intrinsics.stringPlus("Registered start drawable dot, visible=", Boolean.valueOf(r4)));
        goto L23
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L16;
    L23:
        h();
    }

    public final void setStartDotTintList(ColorStateList r2) {
        this.m = r2;
        IndicatorImageDotView r0 = this.k;
        if (r0 == null) goto L6;
        r0.setDotTintList(r2);
    L6:
        j();
    }
}
