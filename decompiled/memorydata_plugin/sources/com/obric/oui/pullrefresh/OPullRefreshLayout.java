package com.obric.oui.pullrefresh;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.obric.common.oea.foundation.animation.d.d;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.pullrefresh.header.ODefaultRefreshHeader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0015\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u009d\u00012\u00020\u00012\u00020\u0002:\u0002\u009d\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\"\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\b2\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010>H\u0002J\b\u0010?\u001a\u00020;H\u0002J\u0006\u0010@\u001a\u00020;J\b\u0010A\u001a\u00020\u000bH\u0002J\u0012\u0010B\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010DH\u0014J\u0018\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u0013H\u0002J \u0010H\u001a\u00020;2\u0006\u0010I\u001a\u00020\u00132\u0006\u0010J\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010K\u001a\u00020;H\u0002J\u0014\u0010L\u001a\u0004\u0018\u00010\u00102\b\u0010M\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020\u000bJ\b\u0010P\u001a\u00020;H\u0002J\b\u0010Q\u001a\u00020DH\u0014J\u0012\u0010R\u001a\u00020D2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010R\u001a\u00020D2\b\u0010C\u001a\u0004\u0018\u00010DH\u0014J\b\u0010S\u001a\u00020\bH\u0016J\u0010\u0010T\u001a\u00020;2\u0006\u0010U\u001a\u00020\bH\u0002J\b\u0010V\u001a\u00020;H\u0014J\u0010\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020YH\u0016J0\u0010Z\u001a\u00020;2\u0006\u0010[\u001a\u00020\u000b2\u0006\u0010\\\u001a\u00020\b2\u0006\u0010]\u001a\u00020\b2\u0006\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020\bH\u0014J\u0018\u0010`\u001a\u00020;2\u0006\u0010a\u001a\u00020\b2\u0006\u0010b\u001a\u00020\bH\u0014J(\u0010c\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010d\u001a\u00020\u00132\u0006\u0010e\u001a\u00020\u00132\u0006\u0010f\u001a\u00020\u000bH\u0016J \u0010g\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010d\u001a\u00020\u00132\u0006\u0010e\u001a\u00020\u0013H\u0016J0\u0010h\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010i\u001a\u00020\b2\u0006\u0010j\u001a\u00020\b2\u0006\u0010f\u001a\u00020k2\u0006\u0010l\u001a\u00020\bH\u0016J8\u0010m\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010n\u001a\u00020\b2\u0006\u0010o\u001a\u00020\b2\u0006\u0010p\u001a\u00020\b2\u0006\u0010q\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bH\u0016J@\u0010m\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010n\u001a\u00020\b2\u0006\u0010o\u001a\u00020\b2\u0006\u0010p\u001a\u00020\b2\u0006\u0010q\u001a\u00020\b2\u0006\u0010l\u001a\u00020\b2\u0006\u0010f\u001a\u00020kH\u0016J(\u0010r\u001a\u00020;2\u0006\u0010s\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bH\u0016J(\u0010u\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bH\u0016J\u0018\u0010v\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\bH\u0016J\u0010\u0010w\u001a\u00020\u000b2\u0006\u0010x\u001a\u00020YH\u0016J \u0010y\u001a\u00020\u00132\u0006\u0010z\u001a\u00020\u00132\u0006\u0010{\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010|\u001a\u00020;2\u0006\u0010}\u001a\u00020\bJ\u000e\u0010~\u001a\u00020;2\u0006\u0010}\u001a\u00020\bJ\u0010\u0010\u007f\u001a\u00020;2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001J\u000e\u0010\u007f\u001a\u00020;2\u0006\u0010}\u001a\u00020\bJ>\u0010\u0082\u0001\u001a\u00020;2\f\b\u0002\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00012\f\b\u0002\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00012\f\b\u0002\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0084\u00012\u000b\b\u0002\u0010O\u001a\u0005\u0018\u00010\u0084\u0001J\u000f\u0010\u0087\u0001\u001a\u00020;2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0088\u0001\u001a\u00020;2\u0007\u0010\u0089\u0001\u001a\u00020\u0013J\u0010\u0010\u008a\u0001\u001a\u00020;2\u0007\u0010\u008b\u0001\u001a\u00020\bJ\u0010\u0010\u008c\u0001\u001a\u00020;2\u0007\u0010\u008d\u0001\u001a\u00020\u000bJ\u001d\u0010\u008e\u0001\u001a\u00020;2\u0014\u0010\u008f\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020;0\u0090\u0001J\u0012\u0010\u008e\u0001\u001a\u00020;2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010'J)\u0010\u0092\u0001\u001a\u00020;2 \u0010\u008f\u0001\u001a\u001b\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020;0\u0093\u0001J\u0012\u0010\u0092\u0001\u001a\u00020;2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010)J\u0010\u0010\u0094\u0001\u001a\u00020;2\u0007\u0010\u0095\u0001\u001a\u000201J\u0012\u0010\u0096\u0001\u001a\u00020;2\u0007\u0010\u0097\u0001\u001a\u00020\rH\u0002J\u000f\u0010\u0098\u0001\u001a\u00020;2\u0006\u00109\u001a\u00020\u0013J\t\u0010\u0099\u0001\u001a\u00020;H\u0002J\u0012\u0010\u009a\u0001\u001a\u00020;2\u0007\u0010\u009b\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u009c\u0001\u001a\u00020;H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001bR\u000e\u0010\u001f\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00105\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b6\u00107R\u000e\u00108\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u009e\u0001"}, d2 = {"Lcom/obric/oui/pullrefresh/OPullRefreshLayout;", "Landroid/view/ViewGroup;", "Landroidx/core/view/NestedScrollingParent3;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_isAnimatingOffset", "", "_state", "Lcom/obric/oui/pullrefresh/RefreshState;", "contentOriginalLayerType", "contentView", "Landroid/view/View;", "currentOffset", "dragDamping", "", "headerHeight", "headerInsetStart", "headerOriginalLayerType", "headerView", "initialDownX", "initialDownY", "isAnimatingOffset", "()Z", "isBeingDragged", "isPerformedHapticFeedback", "isRefreshing", "lastMotionY", "lastOnPullingDispatchTime", "", "layerTypeOverriddenForAnimation", "nestedScrollEnabledWhileAnimatingOffset", "offsetAnimationManager", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "onRefreshListener", "Lcom/obric/oui/pullrefresh/OnRefreshListener;", "onStateChangeListener", "Lcom/obric/oui/pullrefresh/OnStateChangeListener;", "parentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "refreshEnable", "getRefreshEnable", "setRefreshEnable", "(Z)V", "refreshHeader", "Lcom/obric/oui/pullrefresh/header/ORefreshHeader;", "rubberRemainder", "scrollChild", "selfOriginalLayerType", "state", "getState", "()Lcom/obric/oui/pullrefresh/RefreshState;", "touchSlop", "triggerRate", "animateOffsetTo", "", TypedValues.AttributesType.S_TARGET, "endAction", "Lkotlin/Function0;", "applyCurrentOffsetToTranslation", "autoRefresh", "canScrollUpInner", "checkLayoutParams", "p", "Landroid/view/ViewGroup$LayoutParams;", "computeRubberIncrement", "current", "deltaPull", "dispatchOnPullingThrottled", "fraction", "offsetY", "ensureContentView", "findScrollableChild", "root", "finishRefresh", "success", "finishSpinner", "generateDefaultLayoutParams", "generateLayoutParams", "getNestedScrollAxes", "moveSpinner", "targetOffset", "onFinishInflate", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedFling", "velocityX", "velocityY", "consumed", "onNestedPreFling", "onNestedPreScroll", "dx", "dy", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "onStopNestedScroll", "onTouchEvent", "event", "rubberMap", "distance", "maxDistance", "setDefaultHeaderIconColor", TypedValues.Custom.S_COLOR, "setDefaultHeaderProgressBackgroundColor", "setDefaultHeaderTextColor", "colors", "Landroid/content/res/ColorStateList;", "setDefaultHeaderTexts", "pull", "", "release", "refreshing", "setDragDamping", "setHeaderInsetStartDp", "headerInsetStartDp", "setHeaderInsetStartPx", "headerInsetStartPx", "setNestedScrollEnabledWhileAnimatingOffset", "enabled", "setOnRefreshListener", "block", "Lkotlin/Function1;", "listener", "setOnStateChangeListener", "Lkotlin/Function3;", "setRefreshHeader", "header", "setState", "newState", "setTriggerRate", "startRefreshing", "updateLayerTypeForAnimation", "enable", "updateStateByOffset", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPullRefreshLayout extends ViewGroup implements NestedScrollingParent3 {
    public static final a Companion = null;
    private static final int MIN_OFFSET_FOR_ANIMATION_PX = 2;
    private static final long ON_PULLING_MIN_INTERVAL_MS = 16;
    private boolean _isAnimatingOffset;
    private RefreshState _state;
    private int contentOriginalLayerType;
    private View contentView;
    private int currentOffset;
    private float dragDamping;
    private int headerHeight;
    private int headerInsetStart;
    private int headerOriginalLayerType;
    private View headerView;
    private float initialDownX;
    private float initialDownY;
    private boolean isBeingDragged;
    private boolean isPerformedHapticFeedback;
    private float lastMotionY;
    private long lastOnPullingDispatchTime;
    private boolean layerTypeOverriddenForAnimation;
    private boolean nestedScrollEnabledWhileAnimatingOffset;
    private d offsetAnimationManager;
    private com.obric.oui.pullrefresh.a onRefreshListener;
    private com.obric.oui.pullrefresh.b onStateChangeListener;
    private final NestedScrollingParentHelper parentHelper;
    private boolean refreshEnable;
    private com.obric.oui.pullrefresh.header.a refreshHeader;
    private float rubberRemainder;
    private View scrollChild;
    private int selfOriginalLayerType;
    private final int touchSlop;
    private float triggerRate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/pullrefresh/OPullRefreshLayout$Companion;", "", "()V", "MIN_OFFSET_FOR_ANIMATION_PX", "", "ON_PULLING_MIN_INTERVAL_MS", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b implements com.obric.oui.pullrefresh.a, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f14406a;

        b(Function1 r3) {
            this.f14406a = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.oui.pullrefresh.a
        public final /* synthetic */ void a(OPullRefreshLayout r1) {
            this.f14406a.invoke(r1);
        }

        public final boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.pullrefresh.a.class) == true) goto L5;
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, FunctionAdapter.class) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) ZeusTransformUtils.preCheckCast(r3, FunctionAdapter.class, "com.obric.memorydata.plugin")).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return (Function) ZeusTransformUtils.preCheckCast(this.f14406a, Function.class, "com.obric.memorydata.plugin");
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c implements com.obric.oui.pullrefresh.b, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function3 f14407a;

        c(Function3 r3) {
            this.f14407a = (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.oui.pullrefresh.b
        public final /* synthetic */ void a(OPullRefreshLayout r1, RefreshState r2, RefreshState r3) {
            this.f14407a.invoke(r1, r2, r3);
        }

        public final boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.pullrefresh.b.class) == true) goto L5;
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, FunctionAdapter.class) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) ZeusTransformUtils.preCheckCast(r3, FunctionAdapter.class, "com.obric.memorydata.plugin")).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return (Function) ZeusTransformUtils.preCheckCast(this.f14407a, Function.class, "com.obric.memorydata.plugin");
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    static {
        Companion = new a(null);
    }

    public OPullRefreshLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OPullRefreshLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OPullRefreshLayout(Context r13, AttributeSet r14, int r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r17 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r14, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "context");
        super(r16, r17, r15);
        this.parentHelper = new NestedScrollingParentHelper((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        this.dragDamping = 0.8f;
        this.triggerRate = 1.0f;
        this._state = RefreshState.IDLE;
        this.touchSlop = ViewConfiguration.get(r16).getScaledTouchSlop();
        this.nestedScrollEnabledWhileAnimatingOffset = true;
        this.refreshEnable = true;
        setChildrenDrawingOrderEnabled(true);
        setClipToPadding(true);
        setClipChildren(true);
        AttributeSet r4 = null;
        Object[] r5 = 0;
        if (r17 == null) goto L25;
        TypedArray r18 = r16.obtainStyledAttributes(r17, R.styleable.OPullRefreshLayout, r15, 0);
        Intrinsics.checkNotNullExpressionValue(r18, "context.obtainStyledAttr…          0\n            )");
        this.dragDamping = RangesKt.coerceIn(r18.getFloat(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_dragDamping, "styleable", "OPullRefreshLayout_o_pr_dragDamping"), 0.8f), 0.2f, 1.0f);
        this.triggerRate = RangesKt.coerceAtLeast(r18.getFloat(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_triggerRate, "styleable", "OPullRefreshLayout_o_pr_triggerRate"), 1.0f), 0.5f);
        this.headerInsetStart = r18.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_headerInsetStart, "styleable", "OPullRefreshLayout_o_pr_headerInsetStart"), 0);
        this.refreshEnable = r18.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_refreshEnable, "styleable", "OPullRefreshLayout_o_pr_refreshEnable"), true);
        String r19 = r18.getString(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextPull, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderTextPull"));
        String r0 = r18.getString(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextRelease, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderTextRelease"));
        String r2 = r18.getString(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextRefreshing, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderTextRefreshing"));
        String r3 = r18.getString(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextSuccess, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderTextSuccess"));
        if (r18.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextColor, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderTextColor")) == false) goto L7;
        Integer r7 = Integer.valueOf(r18.getColor(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextColor, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderTextColor"), 0));
    L9:
        if (r18.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderIconColor, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderIconColor")) == false) goto L11;
        Integer r8 = Integer.valueOf(r18.getColor(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderIconColor, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderIconColor"), 0));
    L13:
        if (r18.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderProgressBackgroundColor, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderProgressBackgroundColor")) == false) goto L15;
        Integer r9 = Integer.valueOf(r18.getColor(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderProgressBackgroundColor, "styleable", "OPullRefreshLayout_o_pr_defaultHeaderProgressBackgroundColor"), 0));
    L16:
        int r6 = r18.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OPullRefreshLayout_o_pr_headerView, "styleable", "OPullRefreshLayout_o_pr_headerView"), 0);
        r18.recycle();
        if (r6 == 0) goto L27;
        final View r110 = ViewGroup.inflate(r16, r6, null);
        if (ZeusTransformUtils.instanceOf(r110, com.obric.oui.pullrefresh.header.a.class) == false) goto L21;
        com.obric.oui.pullrefresh.header.a r10 = (com.obric.oui.pullrefresh.header.a) ZeusTransformUtils.preCheckCast(r110, com.obric.oui.pullrefresh.header.a.class, "com.obric.memorydata.plugin");
    L22:
        if (r10 == null) goto L24;
        setRefreshHeader(r10);
        goto L27
    L24:
        setRefreshHeader((com.obric.oui.pullrefresh.header.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r110), com.obric.oui.pullrefresh.header.a.class, "com.obric.memorydata.plugin"));
        goto L27
    L21:
        r10 = null;
    L27:
        if (this.refreshHeader != null) goto L29;
        setRefreshHeader((com.obric.oui.pullrefresh.header.a) ZeusTransformUtils.preCheckCast(new ODefaultRefreshHeader(r16, r4, 2, r5 == true ? 1 : 0), com.obric.oui.pullrefresh.header.a.class, "com.obric.memorydata.plugin"));
    L29:
        setDefaultHeaderTexts((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r7 == null) goto L33;
        setDefaultHeaderTextColor(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue());
    L33:
        if (r9 == null) goto L36;
        setDefaultHeaderProgressBackgroundColor(((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue());
    L36:
        if (r8 == null) goto L40;
        setDefaultHeaderIconColor(((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L40:
        return;
    L15:
        r9 = null;
        goto L16
    L11:
        r8 = null;
        goto L13
    L7:
        r7 = null;
        goto L9
    L25:
        r19 = null;
        r0 = null;
        r2 = null;
        r3 = null;
        r7 = null;
        r8 = null;
        r9 = null;
        goto L27
    }

    public /* synthetic */ OPullRefreshLayout(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    public static final /* synthetic */ void access$moveSpinner(OPullRefreshLayout r0, int r1) {
        r0.moveSpinner(r1);
    }

    public static final /* synthetic */ void access$setOffsetAnimationManager$p(OPullRefreshLayout r0, d r1) {
        r0.offsetAnimationManager = r1;
    }

    public static final /* synthetic */ void access$setState(OPullRefreshLayout r0, RefreshState r1) {
        r0.setState(r1);
    }

    public static final /* synthetic */ void access$set_isAnimatingOffset$p(OPullRefreshLayout r0, boolean r1) {
        r0._isAnimatingOffset = r1;
    }

    public static final /* synthetic */ void access$updateLayerTypeForAnimation(OPullRefreshLayout r0, boolean r1) {
        r0.updateLayerTypeForAnimation(r1);
    }

    private final void animateOffsetTo(int r14, Function0<Unit> r15) {
        final Function0 r16 = (Function0) ZeusTransformUtils.wrapperContextForParams(r15, Function0.class, "com.obric.memorydata.plugin");
        int r0 = this.currentOffset;
        if (r0 != r14) goto L8;
        if (r16 == null) goto L30;
        r16.invoke();
        return;
    L30:
        return;
    L8:
        int r1 = Math.abs(r0 - r14);
        if (ViewCompat.isLaidOut((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")) == true) goto L11;
    L21:
        d r2 = this.offsetAnimationManager;
        if (r2 == null) goto L25;
        d.a(r2, false, 1, null);
    L25:
        moveSpinner(r14);
        if (r16 == null) goto L31;
        r16.invoke();
        return;
    L31:
        return;
    L11:
        if (isAttachedToWindow() == false) goto L21;
        if (r1 <= 2) goto L21;
        d r3 = this.offsetAnimationManager;
        if (r3 == null) goto L19;
        d.a(r3, false, 1, null);
    L19:
        this.offsetAnimationManager = com.obric.common.oea.foundation.animation.builder.c.a.a(new com.obric.common.oea.foundation.animation.builder.c.a(), this.currentOffset, r14, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.spec.b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null), com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 8, null).a((Function3) ZeusTransformUtils.preCheckCast(new C12321(this), Function3.class, "com.obric.memorydata.plugin")).a((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r16), Function2.class, "com.obric.memorydata.plugin")).a().a();
        this._isAnimatingOffset = true;
        updateLayerTypeForAnimation(true);
    }

    static /* synthetic */ void animateOffsetTo$default(OPullRefreshLayout r1, int r2, Function0 r3, int r4, Object r5) {
        Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.animateOffsetTo(r2, r6);
    }

    private final void applyCurrentOffsetToTranslation() {
        float r0 = this.currentOffset;
        View r1 = this.headerView;
        boolean r2 = true;
        if (r1 != null) goto L6;
    L11:
        View r5 = this.contentView;
        if (r5 != null) goto L15;
        return;
    L15:
        if (r5.getTranslationY() == r0) goto L18;
        r2 = false;
    L18:
        if (r2 == true) goto L21;
        r5.setTranslationY(r0);
        return;
    L21:
        return;
    L6:
        if (r1.getTranslationY() != r0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == true) goto L11;
        r1.setTranslationY(r0);
        goto L11
    L8:
        r4 = false;
        goto L9
    }

    /* JADX INFO: renamed from: autoRefresh$lambda-7, reason: not valid java name */
    private static final void m1348autoRefresh$lambda7(OPullRefreshLayout r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.autoRefresh();
    }

    private final boolean canScrollUpInner() {
        View r3 = this.scrollChild;
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.canScrollVertically(-1) == true) goto L8;
        return false;
    L8:
        return true;
    }

    private final int computeRubberIncrement(int r3, float r4) {
        int r0 = this.headerHeight;
        if (r0 <= 0) goto L5;
        float r1 = r0 * 2.0f;
    L6:
        float r5 = r3;
        float r6 = (rubberMap(RangesKt.coerceAtLeast(r5 + r4, 0.0f), r1, this.dragDamping) - rubberMap(r5, r1, this.dragDamping)) + this.rubberRemainder;
        int r7 = (int) r6;
        this.rubberRemainder = r6 - r7;
        return r7;
    L5:
        r1 = RangesKt.coerceAtLeast(getMeasuredHeight() * 2.0f, 1.0f);
        goto L6
    }

    private final void dispatchOnPullingThrottled(float r7, int r8, int r9) {
        long r0 = SystemClock.uptimeMillis();
        if ((r0 - this.lastOnPullingDispatchTime) >= 16) goto L8;
        if (r8 == 0) goto L8;
        if (r8 == r9) goto L8;
        boolean r2 = false;
    L9:
        if (r2 == true) goto L11;
        return;
    L11:
        this.lastOnPullingDispatchTime = r0;
        com.obric.oui.pullrefresh.header.a r1 = this.refreshHeader;
        if (r1 == null) goto L16;
        r1.a(this, r7, r8, r9);
        return;
    L16:
        return;
    L8:
        r2 = true;
        goto L9
    }

    private final void ensureContentView() {
        if (this.contentView == null) goto L5;
        return;
    L5:
        int r0 = 0;
        int r1 = getChildCount();
    L6:
        if (r0 >= r1) goto L14;
        int r2 = r0 + 1;
        View r3 = getChildAt(r0);
        if (r3 != this.headerView) goto L9;
        r0 = r2;
        goto L6
    L9:
        this.contentView = r3;
        return;
    }

    private final View findScrollableChild(View r7) {
        if (r7 != null) goto L5;
    L24:
        return null;
    L5:
        if (r7 == this.headerView) goto L24;
        if (ZeusTransformUtils.instanceOf(r7, ScrollView.class) == false) goto L10;
    L23:
        return r7;
    L10:
        if (ZeusTransformUtils.instanceOf(r7, AbsListView.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r7, NestedScrollingChild.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.class) == false) goto L22;
        int r1 = 0;
        int r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount();
    L17:
        if (r1 >= r2) goto L22;
        int r4 = r1 + 1;
        View r3 = findScrollableChild(((ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.memorydata.plugin")).getChildAt(r1));
        if (r3 != null) goto L20;
        r1 = r4;
        goto L17
    L20:
        return r3;
    L22:
        return null;
    }

    public static /* synthetic */ void finishRefresh$default(OPullRefreshLayout r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.finishRefresh(r1);
    }

    /* JADX INFO: renamed from: finishRefresh$lambda-8, reason: not valid java name */
    private static final void m1349finishRefresh$lambda8(final OPullRefreshLayout r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        com.obric.oui.pullrefresh.header.a r0 = r3.refreshHeader;
        if (r0 == null) goto L6;
        r0.a(r3, r4);
    L6:
        r3.animateOffsetTo(0, (Function0) ZeusTransformUtils.preCheckCast(new OPullRefreshLayout$finishRefresh$1$1(r3), Function0.class, "com.obric.memorydata.plugin"));
    }

    private final void finishSpinner() {
        int r0 = this.headerHeight;
        if (r0 > 0) goto L6;
        return;
    L6:
        if (this.currentOffset >= ((int) (r0 * this.triggerRate))) goto L8;
    L12:
        animateOffsetTo(0, (Function0) ZeusTransformUtils.preCheckCast(new C12331(this), Function0.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        if (this._state != RefreshState.RELEASE_TO_REFRESH) goto L10;
    L11:
        startRefreshing();
        return;
    L10:
        if (this._state != RefreshState.PULL_TO_REFRESH) goto L12;
        goto L11
    }

    public static /* synthetic */ void lambda$6A0zgmJXTW6WpQ1j3818fXwnOaM(OPullRefreshLayout r0, boolean r1) {
        m1349finishRefresh$lambda8(r0, r1);
    }

    public static /* synthetic */ void lambda$EV9ERZ5bsgOFkCCyo31yccQBufY(OPullRefreshLayout r0) {
        m1348autoRefresh$lambda7(r0);
    }

    private final void moveSpinner(int r3) {
        int r4 = Math.max(0, r3);
        if (r4 != this.currentOffset) goto L5;
        return;
    L5:
        this.currentOffset = r4;
        applyCurrentOffsetToTranslation();
        int r5 = this.headerHeight;
        if (r5 <= 0) goto L9;
        dispatchOnPullingThrottled(RangesKt.coerceIn(this.currentOffset / r5, 0.0f, 1.0f), this.currentOffset, this.headerHeight);
    L9:
        if (this._state == RefreshState.REFRESHING) goto L11;
    L15:
        updateStateByOffset();
    L13:
        ViewCompat.postInvalidateOnAnimation((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        if (this.currentOffset != 0) goto L15;
        finishRefresh(true);
        goto L13
    }

    private final float rubberMap(float r2, float r3, float r4) {
        float r1 = RangesKt.coerceIn(r4, 0.01f, 1.0f);
        float r5 = Math.max(1.0f, r3);
        return (1.0f - (1.0f / (((r2 * r1) / r5) + 1.0f))) * r5;
    }

    public static /* synthetic */ void setDefaultHeaderTexts$default(OPullRefreshLayout r1, CharSequence r2, CharSequence r3, CharSequence r4, CharSequence r5, int r6, Object r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r9 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r10 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r11 = null;
    L14:
        r1.setDefaultHeaderTexts(r8, r9, r10, r11);
    }

    private final void setState(RefreshState r3) {
        RefreshState r0 = this._state;
        if (r0 != r3) goto L5;
        return;
    L5:
        this._state = r3;
        com.obric.oui.pullrefresh.header.a r1 = this.refreshHeader;
        if (r1 == null) goto L9;
        r1.a(this, r0, r3);
    L9:
        com.obric.oui.pullrefresh.b r2 = this.onStateChangeListener;
        if (r2 == null) goto L14;
        r2.a(this, r0, r3);
        return;
    }

    private final void startRefreshing() {
        if (this.headerHeight > 0) goto L11;
        View r0 = this.headerView;
        if (r0 != null) goto L7;
        int r1 = 0;
    L8:
        this.headerHeight = r1;
        if (r1 > 0) goto L11;
        return;
    L7:
        r1 = r0.getMeasuredHeight();
    L11:
        setState(RefreshState.REFRESHING);
        animateOffsetTo(this.headerHeight, null);
        com.obric.oui.pullrefresh.a r2 = this.onRefreshListener;
        if (r2 == null) goto L16;
        r2.a(this);
        return;
    }

    private final void updateLayerTypeForAnimation(boolean r5) {
        View r0 = this.headerView;
        View r1 = this.contentView;
        int r2 = 0;
        if (r5 == false) goto L23;
        if (this.layerTypeOverriddenForAnimation == true) goto L15;
        this.layerTypeOverriddenForAnimation = true;
        this.selfOriginalLayerType = getLayerType();
        if (r0 != null) goto L9;
        int r6 = 0;
    L10:
        this.headerOriginalLayerType = r6;
        if (r1 == null) goto L14;
        r2 = r1.getLayerType();
    L14:
        this.contentOriginalLayerType = r2;
        goto L15
    L9:
        r6 = r0.getLayerType();
    L15:
        setLayerType(2, null);
        if (r0 == null) goto L19;
        r0.setLayerType(2, null);
    L19:
        if (r1 == null) goto L34;
        r1.setLayerType(2, null);
        return;
    L34:
        return;
    L23:
        if (this.layerTypeOverriddenForAnimation == false) goto L33;
        this.layerTypeOverriddenForAnimation = false;
        setLayerType(this.selfOriginalLayerType, null);
        if (r0 == null) goto L28;
        r0.setLayerType(this.headerOriginalLayerType, null);
    L28:
        if (r1 == null) goto L35;
        r1.setLayerType(this.contentOriginalLayerType, null);
        return;
    L35:
        return;
    }

    private final void updateStateByOffset() {
        if (this._state != RefreshState.REFRESHING) goto L5;
        return;
    L5:
        if (this._state == RefreshState.FINISH) goto L19;
        int r0 = (int) (this.headerHeight * this.triggerRate);
        int r1 = this.currentOffset;
        if (r1 > 0) goto L10;
        RefreshState r2 = RefreshState.IDLE;
    L16:
        setState(r2);
        return;
    L10:
        if (r1 >= r0) goto L13;
        this.isPerformedHapticFeedback = false;
        r2 = RefreshState.PULL_TO_REFRESH;
        goto L16
    L13:
        if (this.isPerformedHapticFeedback == true) goto L15;
        this.isPerformedHapticFeedback = true;
        com.obric.oui.a.a.f13272a.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4);
    L15:
        r2 = RefreshState.RELEASE_TO_REFRESH;
        goto L16
    }

    public final void autoRefresh() {
        if (this.refreshEnable == true) goto L6;
        return;
    L6:
        if (this._state != RefreshState.REFRESHING) goto L9;
        return;
    L9:
        if (ViewCompat.isLaidOut((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")) == true) goto L12;
        post(new $$Lambda$OPullRefreshLayout$EV9ERZ5bsgOFkCCyo31yccQBufY(this));
        return;
    L12:
        startRefreshing();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, ViewGroup.MarginLayoutParams.class);
    }

    public final void finishRefresh(final boolean r4) {
        if (this._state != RefreshState.REFRESHING) goto L5;
    L7:
        setState(RefreshState.FINISH);
        postDelayed(new $$Lambda$OPullRefreshLayout$6A0zgmJXTW6WpQ1j3818fXwnOaM(this, r4), 200);
        return;
    L5:
        if (this._state == RefreshState.RELEASE_TO_REFRESH) goto L7;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(r2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.parentHelper.getNestedScrollAxes();
    }

    public final boolean getRefreshEnable() {
        return this.refreshEnable;
    }

    public final RefreshState getState() {
        return this._state;
    }

    public final boolean isAnimatingOffset() {
        return this._isAnimatingOffset;
    }

    public final boolean isRefreshing() {
        if (this._state != RefreshState.REFRESHING) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        ensureContentView();
        this.scrollChild = findScrollableChild(this.contentView);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        boolean r1 = false;
        if (isEnabled() == true) goto L5;
    L57:
        return false;
    L5:
        if (this.refreshEnable == false) goto L57;
        int r0 = r8.getActionMasked();
        if (r0 != 0) goto L10;
        this.isBeingDragged = false;
        this.initialDownY = r8.getY();
        this.initialDownX = r8.getX();
        this.lastMotionY = this.initialDownY;
    L56:
        return this.isBeingDragged;
    L10:
        if (r0 != 1) goto L12;
    L53:
        this.isBeingDragged = false;
        goto L56
    L12:
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L53;
    L17:
        if (this.isBeingDragged == true) goto L56;
        float r2 = r8.getY() - this.initialDownY;
        float r3 = r8.getX() - this.initialDownX;
        float r4 = Math.abs(r2);
        float r5 = Math.abs(r3);
        if (r4 <= this.touchSlop) goto L56;
        if (r4 <= r5) goto L56;
        if (this.scrollChild != null) goto L25;
    L28:
        boolean r6 = true;
    L30:
        if (r2 <= 0.0f) goto L32;
        boolean r7 = true;
    L34:
        if (r2 < 0.0f) goto L36;
    L38:
        boolean r9 = false;
    L40:
        if (ZeusTransformUtils.instanceOf(this.scrollChild, NestedScrollingChild.class) == true) goto L42;
    L44:
        if (r7 == false) goto L47;
        if (r1 == true) goto L47;
        if (r6 == false) goto L47;
    L49:
        this.isBeingDragged = true;
        this.lastMotionY = r8.getY();
        ViewParent r10 = getParent();
        if (r10 == null) goto L56;
        r10.requestDisallowInterceptTouchEvent(true);
    L47:
        if (r9 == false) goto L56;
        if (r1 == true) goto L56;
    L42:
        if (ZeusTransformUtils.instanceOf(this.contentView, CoordinatorLayout.class) == true) goto L44;
        r1 = true;
        goto L44
    L36:
        if (this.currentOffset <= 0) goto L38;
        r9 = true;
        goto L40
    L32:
        r7 = false;
        goto L34
    L25:
        if (canScrollUpInner() == false) goto L28;
        r6 = false;
        goto L30
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        ensureContentView();
        int r13 = getMeasuredWidth();
        int r14 = getMeasuredHeight();
        if (r13 == 0) goto L16;
        if (r14 == 0) goto L17;
        int r15 = getPaddingLeft();
        int r16 = getPaddingTop();
        int r17 = r13 - getPaddingRight();
        int r18 = r14 - getPaddingBottom();
        View r19 = this.headerView;
        if (r19 == null) goto L10;
        ViewGroup.LayoutParams r2 = r19.getLayoutParams();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r4 = r19.getMeasuredHeight();
        int r5 = r3.leftMargin + r15;
        int r6 = ((r16 - r4) + this.headerInsetStart) + r3.topMargin;
        r19.layout(r5, r6, r19.getMeasuredWidth() + r5, r4 + r6);
    L10:
        View r110 = this.contentView;
        if (r110 == null) goto L14;
        ViewGroup.LayoutParams r7 = r110.getLayoutParams();
        Objects.requireNonNull(r7, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r110.layout(r15 + r0.leftMargin, r16 + r0.topMargin, r17 - r0.rightMargin, r18 - r0.bottomMargin);
    L14:
        applyCurrentOffsetToTranslation();
        return;
    L17:
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        ensureContentView();
        int r0 = getMeasuredWidth();
        int r1 = getMeasuredHeight();
        if (r0 == 0) goto L15;
        if (r1 == 0) goto L16;
        int r2 = View.MeasureSpec.makeMeasureSpec((r0 - getPaddingLeft()) - getPaddingRight(), 1073741824);
        int r3 = View.MeasureSpec.makeMeasureSpec((r1 - getPaddingTop()) - getPaddingBottom(), 1073741824);
        View r4 = this.contentView;
        if (r4 == null) goto L10;
        r4.measure(r2, r3);
    L10:
        View r7 = this.headerView;
        if (r7 == null) goto L17;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r7.measure(ViewGroup.getChildMeasureSpec(r5, ((getPaddingLeft() + getPaddingRight()) + r9.leftMargin) + r9.rightMargin, r9.width), ViewGroup.getChildMeasureSpec(r6, ((getPaddingTop() + getPaddingBottom()) + r9.topMargin) + r9.bottomMargin, r9.height));
        this.headerHeight = r7.getMeasuredHeight();
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, TypedValues.AttributesType.S_TARGET);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r1, float r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, TypedValues.AttributesType.S_TARGET);
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r1, int r2, int r3, int[] r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r4, "consumed");
        if (r5 == 0) goto L6;
        return;
    L6:
        if (this.refreshEnable == true) goto L9;
        return;
    L9:
        if (this.nestedScrollEnabledWhileAnimatingOffset == true) goto L14;
        if (this._isAnimatingOffset == false) goto L14;
        return;
    L14:
        if (r3 <= 0) goto L18;
        int r6 = this.currentOffset;
        if (r6 <= 0) goto L18;
        int r7 = Math.min(r3, r6);
        moveSpinner(this.currentOffset - r7);
        r4[1] = r7;
    L18:
        if (r3 < 0) goto L20;
        return;
    L20:
        if (canScrollUpInner() == false) goto L22;
        return;
    L22:
        if (this._state == RefreshState.REFRESHING) goto L29;
        int r8 = computeRubberIncrement(this.currentOffset, Math.abs(r3));
        if (r8 <= 0) goto L30;
        moveSpinner(this.currentOffset + r8);
        r4[1] = r3;
        return;
    L30:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, TypedValues.AttributesType.S_TARGET);
        onNestedScroll(r10, r11, r12, r13, r14, r15, new int[2]);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6, int[] r7) {
        Intrinsics.checkNotNullParameter(r1, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r7, "consumed");
        if (r6 == 0) goto L6;
        return;
    L6:
        if (this.refreshEnable == true) goto L9;
        return;
    L9:
        if (this.nestedScrollEnabledWhileAnimatingOffset == false) goto L11;
    L13:
        if (r5 < 0) goto L15;
        return;
    L15:
        if (canScrollUpInner() == false) goto L17;
        return;
    L17:
        if (isRefreshing() == true) goto L24;
        int r8 = computeRubberIncrement(this.currentOffset, Math.abs(r5));
        if (r8 <= 0) goto L25;
        moveSpinner(this.currentOffset + r8);
        r7[1] = r7[1] + r5;
        return;
    L25:
        return;
    L24:
        return;
    L11:
        if (this._isAnimatingOffset == false) goto L13;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r2, View r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, TypedValues.AttributesType.S_TARGET);
        this.parentHelper.onNestedScrollAccepted(r2, r3, r4, r5);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "child");
        Intrinsics.checkNotNullParameter(r2, TypedValues.AttributesType.S_TARGET);
        if (isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.refreshEnable == false) goto L9;
        if ((r3 & 2) == 0) goto L9;
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, TypedValues.AttributesType.S_TARGET);
        this.parentHelper.onStopNestedScroll(r2, r3);
        if (r3 == 0) goto L5;
        return;
    L5:
        if (this._state == RefreshState.REFRESHING) goto L9;
        finishSpinner();
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (isEnabled() == false) goto L62;
        if (this.refreshEnable == false) goto L62;
        int r0 = r10.getActionMasked();
        if (r0 == 0) goto L59;
        if (r0 == 1) goto L52;
        if (r0 != 2) goto L13;
        float r1 = r10.getY();
        float r3 = r1 - this.lastMotionY;
        this.lastMotionY = r1;
        if (this.isBeingDragged == true) goto L32;
        float r4 = r1 - this.initialDownY;
        float r6 = r10.getX() - this.initialDownX;
        float r7 = Math.abs(r4);
        float r8 = Math.abs(r6);
        if (r7 <= this.touchSlop) goto L32;
        if (r7 <= r8) goto L32;
        if (r4 <= 0.0f) goto L32;
        if (this.scrollChild != null) goto L26;
    L27:
        this.isBeingDragged = true;
        this.lastMotionY = r1;
        ViewParent r2 = getParent();
        if (r2 == null) goto L32;
        r2.requestDisallowInterceptTouchEvent(true);
        goto L32
    L26:
        if (canScrollUpInner() == false) goto L27;
    L32:
        if (this.isBeingDragged == true) goto L34;
    L58:
        return super.onTouchEvent(r10);
    L34:
        if (r3 < 0.0f) goto L36;
    L38:
        if (r3 >= 0.0f) goto L48;
        int r11 = Math.min((int) Math.abs(r3), this.currentOffset);
        if (r11 <= 0) goto L42;
        moveSpinner(this.currentOffset - r11);
    L42:
        this.rubberRemainder = 0.0f;
        if (((int) Math.abs(r3)) <= r11) goto L46;
        this.isBeingDragged = false;
        return false;
    L46:
        return true;
    L48:
        if (isRefreshing() == true) goto L50;
        int r12 = this.currentOffset;
        moveSpinner(r12 + computeRubberIncrement(r12, r3));
    L50:
        return true;
    L36:
        if (this.currentOffset > 0) goto L38;
        return false;
    L13:
        if (r0 != 3) goto L58;
    L52:
        if (this.isBeingDragged == false) goto L58;
        this.isBeingDragged = false;
        if (this._state == RefreshState.REFRESHING) goto L56;
        finishSpinner();
    L56:
        return true;
    L59:
        this.isBeingDragged = false;
        this.initialDownY = r10.getY();
        this.initialDownX = r10.getX();
        this.lastMotionY = this.initialDownY;
        return true;
    L62:
        return super.onTouchEvent(r10);
    }

    public final void setDefaultHeaderIconColor(int r3) {
        com.obric.oui.pullrefresh.header.a r2 = this.refreshHeader;
        if (ZeusTransformUtils.instanceOf(r2, ODefaultRefreshHeader.class) == false) goto L5;
        ODefaultRefreshHeader r4 = (ODefaultRefreshHeader) ZeusTransformUtils.preCheckCast(r2, ODefaultRefreshHeader.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 == null) goto L10;
        r4.setIconColor(r3);
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void setDefaultHeaderProgressBackgroundColor(int r3) {
        com.obric.oui.pullrefresh.header.a r2 = this.refreshHeader;
        if (ZeusTransformUtils.instanceOf(r2, ODefaultRefreshHeader.class) == false) goto L5;
        ODefaultRefreshHeader r4 = (ODefaultRefreshHeader) ZeusTransformUtils.preCheckCast(r2, ODefaultRefreshHeader.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 == null) goto L10;
        r4.setProgressBackgroundColor(r3);
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void setDefaultHeaderTextColor(int r3) {
        com.obric.oui.pullrefresh.header.a r2 = this.refreshHeader;
        if (ZeusTransformUtils.instanceOf(r2, ODefaultRefreshHeader.class) == false) goto L5;
        ODefaultRefreshHeader r4 = (ODefaultRefreshHeader) ZeusTransformUtils.preCheckCast(r2, ODefaultRefreshHeader.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 == null) goto L10;
        r4.setTextColor(r3);
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void setDefaultHeaderTextColor(ColorStateList r3) {
        Intrinsics.checkNotNullParameter(r3, "colors");
        com.obric.oui.pullrefresh.header.a r2 = this.refreshHeader;
        if (ZeusTransformUtils.instanceOf(r2, ODefaultRefreshHeader.class) == false) goto L5;
        ODefaultRefreshHeader r4 = (ODefaultRefreshHeader) ZeusTransformUtils.preCheckCast(r2, ODefaultRefreshHeader.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 == null) goto L10;
        r4.setTextColor(r3);
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void setDefaultHeaderTexts(CharSequence r3, CharSequence r4, CharSequence r5, CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        com.obric.oui.pullrefresh.header.a r2 = this.refreshHeader;
        if (ZeusTransformUtils.instanceOf(r2, ODefaultRefreshHeader.class) == false) goto L5;
        ODefaultRefreshHeader r11 = (ODefaultRefreshHeader) ZeusTransformUtils.preCheckCast(r2, ODefaultRefreshHeader.class, "com.obric.memorydata.plugin");
    L6:
        if (r11 == null) goto L10;
        r11.a(r7, r8, r9, r10);
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void setDragDamping(float r1) {
        this.dragDamping = r1;
    }

    public final void setHeaderInsetStartDp(float r3) {
        this.headerInsetStart = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void setHeaderInsetStartPx(int r1) {
        this.headerInsetStart = r1;
    }

    public final void setNestedScrollEnabledWhileAnimatingOffset(boolean r1) {
        this.nestedScrollEnabledWhileAnimatingOffset = r1;
    }

    public final void setOnRefreshListener(com.obric.oui.pullrefresh.a r3) {
        this.onRefreshListener = (com.obric.oui.pullrefresh.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.pullrefresh.a.class, "com.obric.memorydata.plugin");
    }

    public final void setOnRefreshListener(Function1<? super OPullRefreshLayout, Unit> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "block");
        this.onRefreshListener = (com.obric.oui.pullrefresh.a) ZeusTransformUtils.preCheckCast(new b(r4), com.obric.oui.pullrefresh.a.class, "com.obric.memorydata.plugin");
    }

    public final void setOnStateChangeListener(com.obric.oui.pullrefresh.b r3) {
        this.onStateChangeListener = (com.obric.oui.pullrefresh.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.pullrefresh.b.class, "com.obric.memorydata.plugin");
    }

    public final void setOnStateChangeListener(Function3<? super OPullRefreshLayout, ? super RefreshState, ? super RefreshState, Unit> r3) {
        Function3 r4 = (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "block");
        this.onStateChangeListener = (com.obric.oui.pullrefresh.b) ZeusTransformUtils.preCheckCast(new c(r4), com.obric.oui.pullrefresh.b.class, "com.obric.memorydata.plugin");
    }

    public final void setRefreshEnable(boolean r1) {
        this.refreshEnable = r1;
    }

    public final void setRefreshHeader(com.obric.oui.pullrefresh.header.a r3) {
        com.obric.oui.pullrefresh.header.a r4 = (com.obric.oui.pullrefresh.header.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.pullrefresh.header.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "header");
        View r0 = this.headerView;
        if (r0 == null) goto L6;
        removeView(r0);
    L6:
        this.refreshHeader = r4;
        View r5 = r4.getView();
        this.headerView = r5;
        addView(r5, 0);
        requestLayout();
    }

    public final void setTriggerRate(float r1) {
        this.triggerRate = r1;
    }
}
