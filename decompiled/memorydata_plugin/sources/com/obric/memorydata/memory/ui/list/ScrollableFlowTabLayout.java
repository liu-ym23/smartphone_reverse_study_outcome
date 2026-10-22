package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Scroller;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ¹\u00012\u00020\u00012\u00020\u0002:\u0004¹\u0001º\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\bH\u0014J\u0010\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u001dH\u0016J\b\u00102\u001a\u00020,H\u0002J\b\u0010M\u001a\u00020\u001dH\u0002J\u0010\u0010R\u001a\u00020,2\b\u0010S\u001a\u0004\u0018\u00010PJ\u000e\u0010U\u001a\u00020,2\u0006\u0010V\u001a\u00020\bJ\u000e\u0010W\u001a\u00020,2\u0006\u0010V\u001a\u00020\bJ\u0006\u0010X\u001a\u00020\bJ\u0018\u0010Y\u001a\u00020,2\u0006\u0010Z\u001a\u00020\b2\u0006\u0010[\u001a\u00020\u001dH\u0002J\b\u0010\\\u001a\u00020,H\u0002J\u0010\u0010]\u001a\u00020,2\u0006\u0010^\u001a\u00020\bH\u0002J\b\u0010_\u001a\u00020,H\u0016J\u0018\u0010`\u001a\u00020,2\u0006\u0010a\u001a\u00020\b2\u0006\u0010b\u001a\u00020\bH\u0016J\u0010\u0010c\u001a\u00020\u001d2\u0006\u0010d\u001a\u00020\bH\u0016J\b\u0010e\u001a\u00020\bH\u0014J\b\u0010f\u001a\u00020\bH\u0014J\b\u0010g\u001a\u00020\bH\u0014J(\u0010h\u001a\u00020,2\u0006\u0010i\u001a\u00020\b2\u0006\u0010j\u001a\u00020\b2\u0006\u0010k\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bH\u0014J\u0010\u0010m\u001a\u00020,2\u0006\u0010n\u001a\u00020oH\u0014J\b\u0010p\u001a\u00020,H\u0014J\b\u0010q\u001a\u00020,H\u0002J\u0010\u0010r\u001a\u00020\u001d2\u0006\u0010s\u001a\u00020\bH\u0002J\b\u0010x\u001a\u00020?H\u0016J\u0012\u0010y\u001a\u00020,2\b\u0010S\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010z\u001a\u00020,2\u0006\u0010{\u001a\u00020\u001dH\u0016J\u0006\u0010|\u001a\u00020\u001dJ\b\u0010}\u001a\u00020,H\u0002J\b\u0010~\u001a\u00020,H\u0002J\u0012\u0010\u007f\u001a\u00020,2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u001b\u0010\u0080\u0001\u001a\u00020,2\u0007\u0010\u0081\u0001\u001a\u00020\b2\u0007\u0010\u0082\u0001\u001a\u00020\bH\u0014J\u001b\u0010\u0083\u0001\u001a\u00020,2\u0007\u0010\u0081\u0001\u001a\u00020\b2\u0007\u0010\u0082\u0001\u001a\u00020\bH\u0002J\u001b\u0010\u0084\u0001\u001a\u00020,2\u0007\u0010\u0081\u0001\u001a\u00020\b2\u0007\u0010\u0082\u0001\u001a\u00020\bH\u0002J6\u0010\u0085\u0001\u001a\u00020,2\u0007\u0010\u0086\u0001\u001a\u00020\u001d2\u0007\u0010\u0087\u0001\u001a\u00020\b2\u0007\u0010\u0088\u0001\u001a\u00020\b2\u0007\u0010\u0089\u0001\u001a\u00020\b2\u0007\u0010\u008a\u0001\u001a\u00020\bH\u0014J\t\u0010\u008b\u0001\u001a\u00020,H\u0002J\u0013\u0010\u008c\u0001\u001a\u00020\u001d2\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0016J\u0013\u0010\u008f\u0001\u001a\u00020\u001d2\b\u0010\u0090\u0001\u001a\u00030\u008e\u0001H\u0016J\u0012\u0010\u0091\u0001\u001a\u00020\u001d2\u0007\u0010\u0092\u0001\u001a\u00020\bH\u0002J\u001b\u0010\u0093\u0001\u001a\u00020,2\u0007\u0010\u0094\u0001\u001a\u00020\b2\u0007\u0010\u0095\u0001\u001a\u00020?H\u0002J\u001b\u0010\u0096\u0001\u001a\u00020\b2\u0007\u0010\u0094\u0001\u001a\u00020\b2\u0007\u0010\u0095\u0001\u001a\u00020?H\u0002J\u001b\u0010\u0097\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020\b2\u0007\u0010\u0095\u0001\u001a\u00020?H\u0002J\u0012\u0010\u0099\u0001\u001a\u00020?2\u0007\u0010\u0095\u0001\u001a\u00020?H\u0002J\t\u0010\u009a\u0001\u001a\u00020,H\u0002J\t\u0010\u009b\u0001\u001a\u00020,H\u0002J\t\u0010\u009c\u0001\u001a\u00020,H\u0002J\u001d\u0010\u009d\u0001\u001a\u00020,2\t\u0010\u009e\u0001\u001a\u0004\u0018\u0001092\u0007\u0010\u009f\u0001\u001a\u00020\bH\u0002J\u0012\u0010 \u0001\u001a\u00020,2\u0007\u0010\u0094\u0001\u001a\u00020\bH\u0002J\t\u0010¡\u0001\u001a\u00020,H\u0002J\t\u0010¢\u0001\u001a\u00020,H\u0002J\t\u0010£\u0001\u001a\u00020,H\u0016J\u0013\u0010¤\u0001\u001a\u00020,2\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0002J\t\u0010¥\u0001\u001a\u00020,H\u0002J\t\u0010¦\u0001\u001a\u00020,H\u0002J\t\u0010§\u0001\u001a\u00020,H\u0002J\u000f\u0010¨\u0001\u001a\u00020,2\u0006\u0010V\u001a\u00020\bJ\u0007\u0010©\u0001\u001a\u00020,J\u0007\u0010ª\u0001\u001a\u00020,J\u0007\u0010«\u0001\u001a\u00020\bJ\u0011\u0010¬\u0001\u001a\u0004\u0018\u00010.2\u0006\u0010V\u001a\u00020\bJ(\u0010\u00ad\u0001\u001a\u00020,2\t\u0010®\u0001\u001a\u0004\u0018\u00010.2\u0006\u0010Z\u001a\u00020\b2\n\u0010¯\u0001\u001a\u0005\u0018\u00010°\u0001H\u0016J\u0011\u0010±\u0001\u001a\u00020,2\u0006\u0010Z\u001a\u00020\bH\u0016J\u0014\u0010²\u0001\u001a\u00030°\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010³\u0001\u001a\u00030°\u0001H\u0014J\u0016\u0010²\u0001\u001a\u00030°\u00012\n\u0010´\u0001\u001a\u0005\u0018\u00010°\u0001H\u0014J\u0015\u0010µ\u0001\u001a\u00020\u001d2\n\u0010´\u0001\u001a\u0005\u0018\u00010°\u0001H\u0014J\u001b\u0010¶\u0001\u001a\u00020,2\u0007\u0010\u0081\u0001\u001a\u00020\b2\u0007\u0010\u0082\u0001\u001a\u00020\bH\u0002J\t\u0010·\u0001\u001a\u00020\bH\u0002J\t\u0010¸\u0001\u001a\u00020,H\u0002R$\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R$\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R$\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\u001d@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\u001a\u0010&\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R$\u0010)\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\u001d@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010=\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020,0>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0u0uX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010v\u001a\b\u0012\u0004\u0012\u00020\b0uX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010w\u001a\b\u0012\u0004\u0012\u00020\b0uX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006»\u0001"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/ScrollableFlowTabLayout;", "Landroid/view/ViewGroup;", "Lcom/obric/oui/bouncelayout/IBounceTranslationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", EventBody.KEY_VALUE, "horizontalSpacing", "getHorizontalSpacing", "()I", "setHorizontalSpacing", "(I)V", "verticalSpacing", "getVerticalSpacing", "setVerticalSpacing", "orientation", "getOrientation", "setOrientation", "horizontalGravity", "getHorizontalGravity", "setHorizontalGravity", "verticalGravity", "getVerticalGravity", "setVerticalGravity", "", "singleLine", "getSingleLine", "()Z", "setSingleLine", "(Z)V", "maxLines", "getMaxLines", "setMaxLines", "autoCollapse", "getAutoCollapse", "setAutoCollapse", "isCollapsed", "setCollapsed", "onVisibilityChanged", "", "changedView", "Landroid/view/View;", "visibility", "setEnabled", "enabled", "syncChildrenEnabledState", "scroller", "Landroid/widget/Scroller;", "touchSlop", "minimumVelocity", "maximumVelocity", "bounceLeft", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "bounceRight", "bounceTranslationListener", "Lcom/obric/oui/bouncelayout/OnBounceTranslationListener;", "bounceTranslationCallback", "Lkotlin/Function1;", "", "isFlingScroll", "lastScrollerVelocity", "lastScrollerScrollX", "bounceSettleToken", "velocityTracker", "Landroid/view/VelocityTracker;", "lastMotionX", "lastMotionY", "initialMotionX", "initialMotionY", "isBeingDragged", "activePointerId", "contentWidth", "canScroll", "selectedIndex", "onTabSelectedListener", "Lcom/obric/memorydata/memory/ui/list/ScrollableFlowTabLayout$OnTabSelectedListener;", "listenersSetup", "setOnTabSelectedListener", "listener", "isSyncing", "setSelectedTabSilently", "position", "setSelectedTab", "getSelectedTabPosition", "updateTabStateQuietly", "index", "isSelected", "scrollToSelectedTab", "smoothScrollTo", "targetX", "computeScroll", "scrollTo", "x", "y", "canScrollHorizontally", "direction", "computeHorizontalScrollRange", "computeHorizontalScrollExtent", "computeHorizontalScrollOffset", "onSizeChanged", "w", com.loc.o.g, "oldw", "oldh", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "absorbFinishedFlingIfNeeded", "absorbFlingAtBoundaryIfNeeded", "previousScrollX", "lineViews", "", "lineHeights", "lineWidths", "getBounceTranslation", "setOnBounceTranslationListener", "allowClickDuringOverScroll", "allow", "isOverScrolling", "initBounceEdgeEffects", "updateBounceTranslationListeners", "initAttributes", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "measureHorizontal", "measureVertical", "onLayout", "changed", "l", "t", "r", "b", "layoutVertical", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "fling", "velocityX", "scrollByWithBounce", "deltaX", "touchX", "consumeActiveBounce", "pullBounce", "unconsumedDeltaX", "getDisplacement", "stopBounceIfNeeded", "releaseBounce", "finishBounce", "absorbBounce", "edgeEffect", "velocity", "updateBounceTouchDelta", "scheduleBounceSettleFallback", "cancelPendingBounceSettle", "onCancelPendingInputEvents", "onSecondaryPointerUp", "initVelocityTrackerIfNotExists", "recycleVelocityTracker", "setupTabClickListeners", "selectTab", "selectFirstTab", "selectLastTab", "getTabCount", "getTabAt", "addView", "child", TrackerImpl.PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "removeViewAt", "generateLayoutParams", "generateDefaultLayoutParams", "p", "checkLayoutParams", "measureCollapsed", "getMaxScrollX", "layoutHorizontal", "Companion", "OnTabSelectedListener", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScrollableFlowTabLayout extends ViewGroup implements com.obric.oui.bouncelayout.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11156a = null;
    private float A;
    private boolean B;
    private int C;
    private int D;
    private int E;
    private b F;
    private boolean G;
    private boolean H;
    private final List<List<View>> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final List<Integer> f11157J;
    private final List<Integer> K;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11158b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private int h;
    private boolean i;
    private boolean j;
    private final Scroller k;
    private final int l;
    private final int m;
    private final int n;
    private com.obric.oui.bouncelayout.e o;
    private com.obric.oui.bouncelayout.e p;
    private com.obric.oui.bouncelayout.i q;
    private final Function1<Float, Unit> r;
    private boolean s;
    private float t;
    private int u;
    private int v;
    private VelocityTracker w;
    private float x;
    private float y;
    private float z;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/ScrollableFlowTabLayout$Companion;", "", "<init>", "()V", "TAG", "", "HORIZONTAL", "", "VERTICAL", "HORIZONTAL_GRAVITY_START", "HORIZONTAL_GRAVITY_CENTER", "HORIZONTAL_GRAVITY_END", "VERTICAL_GRAVITY_TOP", "VERTICAL_GRAVITY_CENTER", "VERTICAL_GRAVITY_BOTTOM", "BOUNCE_SETTLE_FALLBACK_DELAY_MS", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/ScrollableFlowTabLayout$OnTabSelectedListener;", "", "onTabSelected", "", "position", "", "view", "Landroid/view/View;", "onTabReselected", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface b {
        void a(int r1, View r2);

        void b(int r1, View r2);
    }

    static {
        f11156a = new a(null);
    }

    public ScrollableFlowTabLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public ScrollableFlowTabLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public ScrollableFlowTabLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.f = 1;
        this.h = Integer.MAX_VALUE;
        this.k = new Scroller(r6);
        this.l = ViewConfiguration.get(r6).getScaledTouchSlop();
        this.m = ViewConfiguration.get(r6).getScaledMinimumFlingVelocity();
        this.n = ViewConfiguration.get(r6).getScaledMaximumFlingVelocity();
        this.r = new $$Lambda$ScrollableFlowTabLayout$zafbHqnZmN7_Z3oQB9GhOD6lrl4(this);
        this.C = -1;
        this.I = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.f11157J = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.K = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        setOverScrollMode(0);
        a(r7);
        f();
    }

    public /* synthetic */ ScrollableFlowTabLayout(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final float a(float r2) {
        if (getWidth() > 0) goto L7;
        return 0.5f;
    L7:
        return RangesKt.coerceIn(r2 / getWidth(), 0.0f, 1.0f);
    }

    private static final Unit a(ScrollableFlowTabLayout r0, float r1) {
        com.obric.oui.bouncelayout.i r2 = r0.q;
        if (r2 == null) goto L6;
        r2.a(r0.getBounceTranslation());
    L6:
        return Unit.INSTANCE;
    }

    private final void a(int r8) {
        int r4 = r8 - getScrollX();
        this.s = false;
        this.k.startScroll(getScrollX(), 0, r4, 0, 300);
        postInvalidateOnAnimation();
    }

    private final void a(int r3, float r4) {
        if (r3 != 0) goto L4;
        return;
    L4:
        if (getWidth() <= 0) goto L16;
        d(r3);
        int r5 = b(r3, r4);
        if (r5 != 0) goto L10;
        postInvalidateOnAnimation();
        return;
    L10:
        int r0 = getScrollX();
        scrollBy(r5, 0);
        int r6 = r5 - (getScrollX() - r0);
        if (r6 == 0) goto L15;
        c(r6, r4);
        return;
    L15:
        return;
    }

    private final void a(int r24, int r25) {
        int r7 = View.MeasureSpec.getMode(r24);
        int r8 = View.MeasureSpec.getSize(r24);
        int r9 = View.MeasureSpec.getMode(r25);
        int r10 = View.MeasureSpec.getSize(r25);
        this.I.clear();
        this.f11157J.clear();
        this.K.clear();
        List<View> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r12 = (r8 - getPaddingLeft()) - getPaddingRight();
        int r13 = getChildCount();
        List<View> r15 = r0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r16 = 0;
        int r17 = 0;
    L3:
        if (r5 >= r13) goto L43;
        View r1 = getChildAt(r5);
        Intrinsics.checkNotNull(r1);
        if (r1.getVisibility() != 8) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L41;
        int r21 = r3;
        int r22 = r4;
        measureChildWithMargins(r1, r24, 0, r25, 0);
        ViewGroup.LayoutParams r6 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r14 = (r1.getMeasuredWidth() + r11.leftMargin) + r11.rightMargin;
        int r18 = (r1.getMeasuredHeight() + r11.topMargin) + r11.bottomMargin;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L12;
        int r19 = this.f11158b;
    L14:
        if (this.g == true) goto L22;
        int r20 = r22;
        if (((r20 + r14) + r19) > r12) goto L18;
    L23:
        boolean r23 = false;
    L24:
        if (r23 == false) goto L30;
        this.I.add(r15);
        this.f11157J.add(Integer.valueOf(r17));
        this.K.add(Integer.valueOf(r20));
        int r26 = Math.max(r21, r20);
        if (this.I.size() <= 1) goto L28;
        int r27 = this.c;
    L29:
        r16 = r16 + (r17 + r27);
        r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r4 = 0;
        r3 = r26;
        int r28 = 0;
    L32:
        if (this.I.size() >= this.h) goto L34;
    L36:
        r15.add(r1);
        if (r15.size() <= 1) goto L39;
        int r29 = this.f11158b;
    L40:
        r4 = r4 + (r14 + r29);
        r17 = Math.max(r28, r18);
    L42:
        r5 = r5 + 1;
        goto L3
    L39:
        r29 = 0;
        goto L40
    L34:
        if (r15.isEmpty() == false) goto L36;
        r17 = r28;
    L45:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L51;
        this.I.add(r15);
        this.f11157J.add(Integer.valueOf(r17));
        this.K.add(Integer.valueOf(r4));
        r3 = Math.max(r3, r4);
        if (this.I.size() <= 1) goto L49;
        int r110 = this.c;
    L50:
        r16 = r16 + (r17 + r110);
        goto L51
    L49:
        r110 = 0;
    L51:
        int r30 = r3 + (getPaddingLeft() + getPaddingRight());
        int r111 = r16 + (getPaddingTop() + getPaddingBottom());
        this.D = r30;
        if (r7 == 1073741824) goto L55;
        r8 = r30;
    L55:
        if (r9 == 1073741824) goto L58;
        r10 = r111;
    L58:
        setMeasuredDimension(r8, r10);
        return;
    L28:
        r27 = 0;
        goto L29
    L30:
        r4 = r20;
        r3 = r21;
        r28 = r17;
        goto L32
    L18:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L23;
        if (this.I.size() >= this.h) goto L23;
        r23 = true;
        goto L24
    L22:
        r20 = r22;
        goto L23
    L12:
        r19 = 0;
        goto L14
    L41:
        r3 = r3;
        goto L42
    L7:
        r2 = false;
        goto L8
    L43:
        r3 = r3;
        goto L45
    }

    private static final void a(int r1, ScrollableFlowTabLayout r2) {
        if (r1 == r2.v) goto L5;
        return;
    L5:
        if (r2.B == false) goto L7;
        return;
    L7:
        if (r2.s == false) goto L10;
        return;
    L10:
        if (r2.a() == false) goto L15;
        r2.k();
        r2.postInvalidateOnAnimation();
        return;
    }

    private final void a(int r2, boolean r3) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 >= getChildCount()) goto L10;
        View r1 = getChildAt(r2);
        if (r1.isSelected() == r3) goto L11;
        r1.setSelected(r3);
        r1.invalidate();
        return;
    L11:
        return;
    }

    private final void a(AttributeSet r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L10;
        TypedArray r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r6, R.styleable.ScrollableFlowTabLayout);
        Intrinsics.checkNotNullExpressionValue(r7, "obtainStyledAttributes(...)");
        setHorizontalSpacing(r7.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ScrollableFlowTabLayout_horizontalSpacing, "styleable", "ScrollableFlowTabLayout_horizontalSpacing"), 0));     // Catch: Throwable -> L7
        setVerticalSpacing(r7.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ScrollableFlowTabLayout_verticalSpacing, "styleable", "ScrollableFlowTabLayout_verticalSpacing"), 0));     // Catch: Throwable -> L7
        setOrientation(r7.getInt(ZeusTransformUtils.mapRes(R.styleable.ScrollableFlowTabLayout_tabFlowOrientation, "styleable", "ScrollableFlowTabLayout_tabFlowOrientation"), 0));     // Catch: Throwable -> L7
        setHorizontalGravity(r7.getInt(ZeusTransformUtils.mapRes(R.styleable.ScrollableFlowTabLayout_tabHorizontalGravity, "styleable", "ScrollableFlowTabLayout_tabHorizontalGravity"), 0));     // Catch: Throwable -> L7
        setVerticalGravity(r7.getInt(ZeusTransformUtils.mapRes(R.styleable.ScrollableFlowTabLayout_tabVerticalGravity, "styleable", "ScrollableFlowTabLayout_tabVerticalGravity"), 1));     // Catch: Throwable -> L7
        r7.recycle();
        return;
    L7:
        th = move-exception;
        r7.recycle();
        throw th;
    }

    private final void a(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r4.getPointerId(r0) != this.C) goto L11;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.x = r4.getX(r1);
        this.y = r4.getY(r1);
        this.C = r4.getPointerId(r1);
        VelocityTracker r3 = this.w;
        if (r3 == null) goto L12;
        r3.clear();
        return;
    L12:
        return;
    L6:
        r1 = 0;
        goto L7
    }

    private static final void a(ScrollableFlowTabLayout r0) {
        r0.d();
    }

    private static final void a(ScrollableFlowTabLayout r0, int r1, View r2) {
        r0.setSelectedTab(r1);
    }

    private final void a(com.obric.oui.bouncelayout.e r1, int r2) {
        if (r1 == null) goto L4;
        r1.onAbsorb(r2);
    L4:
        postInvalidateOnAnimation();
        l();
    }

    private final int b(int r4, float r5) {
        com.obric.oui.bouncelayout.e r0 = this.o;
        float r1 = 0.0f;
        if (r0 == null) goto L5;
        float r2 = r0.getDistance();
    L7:
        if (r2 <= 0.0f) goto L15;
        if (r4 <= 0) goto L15;
        com.obric.oui.bouncelayout.e r3 = this.o;
        if (r3 == null) goto L12;
        r1 = r3.onPullDistance((-r4) / getWidth(), a(r5));
    L12:
        int r6 = MathKt.roundToInt((-r1) * getWidth());
    L14:
        return r4 - r6;
    L15:
        com.obric.oui.bouncelayout.e r7 = this.p;
        if (r7 == null) goto L18;
        float r8 = r7.getDistance();
    L20:
        if (r8 <= 0.0f) goto L26;
        if (r4 >= 0) goto L26;
        com.obric.oui.bouncelayout.e r9 = this.p;
        if (r9 == null) goto L25;
        r1 = r9.onPullDistance(r4 / getWidth(), a(r5));
    L25:
        r6 = MathKt.roundToInt(r1 * getWidth());
    L26:
        return r4;
    L18:
        r8 = 0.0f;
        goto L20
    L5:
        r2 = 0.0f;
        goto L7
    }

    private final void b() {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        getChildAt(r1).setEnabled(isEnabled());
        r1 = r1 + 1;
        goto L3
    }

    private final void b(int r24, int r25) {
        int r7 = View.MeasureSpec.getMode(r24);
        int r8 = View.MeasureSpec.getSize(r24);
        int r9 = View.MeasureSpec.getMode(r25);
        int r10 = View.MeasureSpec.getSize(r25);
        this.I.clear();
        this.f11157J.clear();
        this.K.clear();
        List<View> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r12 = (r10 - getPaddingTop()) - getPaddingBottom();
        int r13 = getChildCount();
        List<View> r15 = r0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r16 = 0;
        int r17 = 0;
    L3:
        if (r5 >= r13) goto L43;
        View r1 = getChildAt(r5);
        Intrinsics.checkNotNull(r1);
        if (r1.getVisibility() != 8) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L41;
        int r21 = r3;
        int r22 = r4;
        measureChildWithMargins(r1, r24, 0, r25, 0);
        ViewGroup.LayoutParams r6 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r14 = (r1.getMeasuredWidth() + r11.leftMargin) + r11.rightMargin;
        int r18 = (r1.getMeasuredHeight() + r11.topMargin) + r11.bottomMargin;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L12;
        int r19 = this.c;
    L14:
        if (this.g == true) goto L22;
        int r20 = r22;
        if (((r20 + r18) + r19) > r12) goto L18;
    L23:
        boolean r23 = false;
    L24:
        if (r23 == false) goto L30;
        this.I.add(r15);
        this.f11157J.add(Integer.valueOf(r20));
        this.K.add(Integer.valueOf(r17));
        if (this.I.size() <= 1) goto L28;
        int r26 = this.f11158b;
    L29:
        r16 = r16 + (r17 + r26);
        int r27 = Math.max(r21, r20);
        r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r4 = 0;
        r3 = r27;
        int r28 = 0;
    L32:
        if (this.I.size() >= this.h) goto L34;
    L36:
        r15.add(r1);
        if (r15.size() <= 1) goto L39;
        int r29 = this.c;
    L40:
        r4 = r4 + (r18 + r29);
        r17 = Math.max(r28, r14);
    L42:
        r5 = r5 + 1;
        goto L3
    L39:
        r29 = 0;
        goto L40
    L34:
        if (r15.isEmpty() == false) goto L36;
        r17 = r28;
    L45:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L51;
        this.I.add(r15);
        this.f11157J.add(Integer.valueOf(r4));
        this.K.add(Integer.valueOf(r17));
        if (this.I.size() <= 1) goto L49;
        int r110 = this.f11158b;
    L50:
        r16 = r16 + (r17 + r110);
        r3 = Math.max(r3, r4);
        goto L51
    L49:
        r110 = 0;
    L51:
        int r30 = r16 + (getPaddingLeft() + getPaddingRight());
        int r31 = r3 + (getPaddingTop() + getPaddingBottom());
        this.D = r30;
        if (r7 == 1073741824) goto L55;
        r8 = r30;
    L55:
        if (r9 == 1073741824) goto L58;
        r10 = r31;
    L58:
        setMeasuredDimension(r8, r10);
        return;
    L28:
        r26 = 0;
        goto L29
    L30:
        r4 = r20;
        r3 = r21;
        r28 = r17;
        goto L32
    L18:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L23;
        if (this.I.size() >= this.h) goto L23;
        r23 = true;
        goto L24
    L22:
        r20 = r22;
        goto L23
    L12:
        r19 = 0;
        goto L14
    L41:
        r3 = r3;
        goto L42
    L7:
        r2 = false;
        goto L8
    L43:
        r3 = r3;
        goto L45
    }

    private static final void b(ScrollableFlowTabLayout r0) {
        r0.requestLayout();
        r0.invalidate();
    }

    private final boolean b(int r7) {
        float r0 = this.t;
        if (r0 > 0.0f) goto L5;
        return false;
    L5:
        int r2 = getMaxScrollX();
        if (getScrollX() != 0) goto L12;
        if (r7 <= 0) goto L12;
        this.k.abortAnimation();
        this.s = false;
        this.t = 0.0f;
        com.obric.oui.bouncelayout.e r8 = this.o;
        int r1 = (int) r0;
    L9:
        a(r8, r1);
        return true;
    L12:
        if (getScrollX() != r2) goto L15;
        if (r7 >= r2) goto L15;
        this.k.abortAnimation();
        this.s = false;
        this.t = 0.0f;
        r8 = this.p;
        r1 = -((int) r0);
    L15:
        return false;
    }

    private final void c(int r3, float r4) {
        float r5 = a(r4);
        if (r3 < 0) goto L5;
    L11:
        if (r3 > 0) goto L13;
        return;
    L13:
        if (getScrollX() != getMaxScrollX()) goto L19;
        com.obric.oui.bouncelayout.e r0 = this.p;
        if (r0 != null) goto L9;
    L10:
        postInvalidateOnAnimation();
        return;
    L9:
        r0.onPull(r3 / getWidth(), r5);
        goto L10
    L19:
        return;
    L5:
        if (getScrollX() != 0) goto L11;
        r0 = this.o;
        if (r0 == null) goto L10;
        r3 = Math.abs(r3);
        goto L9
    }

    private final void c(int r20, int r21) {
        int r7 = View.MeasureSpec.getSize(r20);
        int r8 = View.MeasureSpec.getMode(r21);
        int r9 = View.MeasureSpec.getSize(r21);
        this.I.clear();
        this.f11157J.clear();
        this.K.clear();
        List<View> r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        boolean r12 = false;
        int r13 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r14 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r15 = getChildCount();
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r5 >= r15) goto L15;
        View r1 = getChildAt(r5);
        Intrinsics.checkNotNull(r1);
        if (r1.getVisibility() != 8) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L14;
        int r18 = r4;
        measureChildWithMargins(r1, r13, 0, r14, 0);
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r10 = (r1.getMeasuredWidth() + r6.leftMargin) + r6.rightMargin;
        int r16 = (r1.getMeasuredHeight() + r6.topMargin) + r6.bottomMargin;
        r11.add(r1);
        r3 = r3 + r10;
        if (r11.size() <= 1) goto L12;
        r3 = r3 + this.f11158b;
    L12:
        r4 = Math.max(r18, r16);
    L14:
        r5 = r5 + 1;
        r12 = false;
        goto L3
    L7:
        r0 = r12;
        goto L8
    L15:
        int r17 = r3;
        int r19 = r4;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L18;
        this.I.add(r11);
        this.f11157J.add(Integer.valueOf(r19));
        this.K.add(Integer.valueOf(r17));
    L18:
        this.D = r17;
        if (r8 == 1073741824) goto L22;
        r9 = (r19 + getPaddingTop()) + getPaddingBottom();
    L22:
        setMeasuredDimension(r7, r9);
    }

    private final boolean c() {
        if (isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.j == false) goto L9;
        if (getMaxScrollX() <= 0) goto L9;
        return true;
    }

    private final boolean c(int r11) {
        int r6 = getMaxScrollX();
        if (r6 > 0) goto L7;
        return false;
    L7:
        if (getScrollX() != 0) goto L12;
        if (r11 >= 0) goto L12;
        a(this.o, Math.abs(r11));
        return true;
    L12:
        if (getScrollX() != r6) goto L16;
        if (r11 <= 0) goto L16;
        a(this.p, -Math.abs(r11));
        return true;
    L16:
        this.s = true;
        this.t = 0.0f;
        this.u = getScrollX();
        this.k.fling(getScrollX(), 0, r11, 0, 0, r6, 0, 0);
        postInvalidateOnAnimation();
        return true;
    }

    private final void d() {
        int r0 = this.E;
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 < getChildCount()) goto L7;
        return;
    L7:
        if (this.j == true) goto L9;
        return;
    L9:
        if (isEnabled() == false) goto L16;
        View r1 = getChildAt(this.E);
        a(RangesKt.coerceIn(((r1.getLeft() + r1.getRight()) / 2) - (getWidth() / 2), 0, getMaxScrollX()));
        return;
    }

    private final void d(int r2) {
        float r3 = r2;
        com.obric.oui.bouncelayout.e r0 = this.o;
        if (r0 == null) goto L5;
        r0.b(r3);
    L5:
        com.obric.oui.bouncelayout.e r1 = this.p;
        if (r1 == null) goto L9;
        r1.b(r3);
        return;
    }

    private final void e() {
        this.s = false;
        float r0 = this.t;
        int r1 = this.u;
        this.t = 0.0f;
        this.u = getScrollX();
        if (r0 > 0.0f) goto L5;
        return;
    L5:
        int r2 = getMaxScrollX();
        if (getScrollX() != 0) goto L11;
        if (r1 <= 0) goto L11;
        com.obric.oui.bouncelayout.e r3 = this.o;
        int r4 = (int) r0;
    L9:
        a(r3, r4);
        return;
    L11:
        if (getScrollX() != r2) goto L15;
        if (r1 >= r2) goto L16;
        r3 = this.p;
        r4 = -((int) r0);
        goto L9
    L16:
        return;
    }

    private final void f() {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "getContext(...)");
        this.o = new com.obric.oui.bouncelayout.e(r1, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 2, getWidth());
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "getContext(...)");
        this.p = new com.obric.oui.bouncelayout.e(r2, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 3, getWidth());
        g();
    }

    private final void g() {
        if (this.q != null) goto L5;
        Function1<Float, Unit> r0 = null;
    L6:
        com.obric.oui.bouncelayout.e r1 = this.o;
        if (r1 == null) goto L9;
        r1.a(r0);
    L9:
        com.obric.oui.bouncelayout.e r2 = this.p;
        if (r2 == null) goto L13;
        r2.a(r0);
        return;
    L13:
        return;
    L5:
        r0 = this.r;
        goto L6
    }

    private final int getMaxScrollX() {
        if (this.j == true) goto L5;
        return 0;
    L5:
        int r0 = getWidth();
        return Math.max(0, ((this.D + getPaddingLeft()) + getPaddingRight()) - r0);
    }

    private final void h() {
        int r1 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r2 = getPaddingLeft();
        int r3 = this.e;
        int r5 = 2;
        int r7 = 1;
        if (r3 == 1) goto L11;
        if (r3 != 2) goto L17;
        int r4 = CollectionsKt.sumOfInt((Iterable) ZeusTransformUtils.preCheckCast(this.K, Iterable.class, "com.obric.memorydata.plugin"));
        if (this.K.size() <= 1) goto L9;
        int r8 = (this.K.size() - 1) * this.f11158b;
    L10:
        int r9 = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (r4 + r8);
    L16:
        r2 = r2 + r9;
        goto L17
    L9:
        r8 = 0;
    L17:
        int r6 = ((Collection) ZeusTransformUtils.preCheckCast(this.I, Collection.class, "com.obric.memorydata.plugin")).size();
        int r10 = 0;
    L18:
        if (r10 >= r6) goto L43;
        List r11 = (List) ZeusTransformUtils.preCheckCast(this.I.get(r10), List.class, "com.obric.memorydata.plugin");
        int r12 = ((Number) ZeusTransformUtils.preCheckCast(this.f11157J.get(r10), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r13 = ((Number) ZeusTransformUtils.preCheckCast(this.K.get(r10), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r14 = getPaddingTop();
        int r15 = this.f;
        if (r15 == r7) goto L24;
        if (r15 != r5) goto L26;
        int r16 = r1 - r12;
    L25:
        r14 = r14 + r16;
    L26:
        int r17 = ((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).size();
        int r18 = 0;
    L27:
        if (r18 >= r17) goto L39;
        View r19 = (View) ZeusTransformUtils.preCheckCast(r11.get(r18), View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r110 = r19.getLayoutParams();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r110, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r111 = r19.getMeasuredWidth();
        int r112 = r19.getMeasuredHeight();
        int r21 = r20.leftMargin + r2;
        int r22 = r20.topMargin + r14;
        int r113 = r1;
        int r23 = this.e;
        int r114 = r6;
        if (r23 == 1) goto L34;
        int r24 = 2;
        if (r23 != 2) goto L35;
        r21 = r21 + (((r13 - r111) - r20.leftMargin) - r20.rightMargin);
        r24 = 2;
    L35:
        r19.layout(r21, r22, r111 + r21, r22 + r112);
        r14 = r14 + ((r112 + r20.topMargin) + r20.bottomMargin);
        if (r18 >= (r11.size() - 1)) goto L38;
        r14 = r14 + this.c;
    L38:
        r18 = r18 + 1;
        r5 = r24;
        r1 = r113;
        r6 = r114;
        goto L27
    L34:
        r24 = 2;
        r21 = r21 + ((((r13 - r111) - r20.leftMargin) - r20.rightMargin) / 2);
        goto L35
    L39:
        int r115 = r1;
        int r116 = r6;
        int r25 = r5;
        r2 = r2 + r13;
        if (r10 >= (this.I.size() - 1)) goto L42;
        r2 = r2 + this.f11158b;
    L42:
        r10 = r10 + 1;
        r5 = r25;
        r7 = 1;
        r1 = r115;
        r6 = r116;
        goto L18
    L24:
        r16 = (r1 - r12) / r5;
        goto L25
    L43:
        return;
    L11:
        int r26 = CollectionsKt.sumOfInt((Iterable) ZeusTransformUtils.preCheckCast(this.K, Iterable.class, "com.obric.memorydata.plugin"));
        if (this.K.size() <= 1) goto L14;
        int r27 = (this.K.size() - 1) * this.f11158b;
    L15:
        r9 = (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (r26 + r27)) / 2;
        goto L16
    L14:
        r27 = 0;
        goto L15
    }

    private final void i() {
        m();
        com.obric.oui.bouncelayout.e r0 = this.o;
        if (r0 == null) goto L5;
        float r1 = r0.a();
    L6:
        boolean r2 = true;
        if (r1 != 0.0f) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L22;
        com.obric.oui.bouncelayout.e r4 = this.p;
        if (r4 == null) goto L14;
        float r5 = r4.a();
    L16:
        if (r5 == 0.0f) goto L19;
        r2 = false;
    L19:
        if (r2 == false) goto L22;
        return;
    L14:
        r5 = 0.0f;
    L22:
        if (this.k.isFinished() == true) goto L24;
        this.k.abortAnimation();
        this.s = false;
    L24:
        com.obric.oui.bouncelayout.e r6 = this.o;
        if (r6 == null) goto L27;
        r6.b();
    L27:
        com.obric.oui.bouncelayout.e r7 = this.p;
        if (r7 == null) goto L30;
        r7.b();
    L30:
        postInvalidateOnAnimation();
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = 0.0f;
        goto L6
    }

    private final void j() {
        com.obric.oui.bouncelayout.e r0 = this.o;
        if (r0 == null) goto L5;
        r0.onRelease();
    L5:
        com.obric.oui.bouncelayout.e r1 = this.p;
        if (r1 == null) goto L8;
        r1.onRelease();
    L8:
        postInvalidateOnAnimation();
        l();
    }

    private final void k() {
        m();
        com.obric.oui.bouncelayout.e r0 = this.o;
        if (r0 == null) goto L5;
        r0.finish();
    L5:
        com.obric.oui.bouncelayout.e r1 = this.p;
        if (r1 == null) goto L9;
        r1.finish();
        return;
    }

    private final void l() {
        final int r0 = this.v + 1;
        this.v = r0;
        postDelayed(new $$Lambda$ScrollableFlowTabLayout$0KmFynmgNtE9V1c5x9NEZfzb8IY(r0, this), 700);
    }

    public static /* synthetic */ void lambda$0KmFynmgNtE9V1c5x9NEZfzb8IY(int r0, ScrollableFlowTabLayout r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$JQIsziu4tFRnq2GrhzlGSpaIxiI(ScrollableFlowTabLayout r0) {
        setSelectedTabSilently$lambda$3(r0);
    }

    /* JADX INFO: renamed from: lambda$NdgDkqRffIVtD6hrlJGPeWF-o1Q, reason: not valid java name */
    public static /* synthetic */ void m924lambda$NdgDkqRffIVtD6hrlJGPeWFo1Q(ScrollableFlowTabLayout r0, int r1, View r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$WHR3JTWX4qqmjhayLFMitgIPkzk(ScrollableFlowTabLayout r0) {
        b(r0);
    }

    public static /* synthetic */ void lambda$jbYeBZwbxRjHfd8AsZRv6h20lBw(ScrollableFlowTabLayout r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$oDgpkIhRMlF7tT-SOxes7svzZ3U, reason: not valid java name */
    public static /* synthetic */ void m925lambda$oDgpkIhRMlF7tTSOxes7svzZ3U(ScrollableFlowTabLayout r0) {
        setSelectedTab$lambda$4(r0);
    }

    public static /* synthetic */ Unit lambda$zafbHqnZmN7_Z3oQB9GhOD6lrl4(ScrollableFlowTabLayout r0, float r1) {
        return a(r0, r1);
    }

    private final void m() {
        this.v++;
    }

    private final void n() {
        if (this.w != null) goto L6;
        this.w = VelocityTracker.obtain();
        return;
    }

    private final void o() {
        VelocityTracker r0 = this.w;
        if (r0 == null) goto L5;
        r0.recycle();
    L5:
        this.w = null;
    }

    private final void p() {
        int r0 = getChildCount();
        final int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        View r3 = getChildAt(r2);
        r3.setOnClickListener(new $$Lambda$ScrollableFlowTabLayout$NdgDkqRffIVtD6hrlJGPeWFo1Q(this, r2));
        boolean r4 = true;
        r3.setClickable(true);
        if (r2 == this.E) goto L8;
        r4 = false;
    L8:
        r3.setSelected(r4);
        r3.setEnabled(isEnabled());
        r2 = r2 + 1;
        goto L3
    }

    private final void q() {
        int r1 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r2 = getPaddingTop();
        int r3 = this.f;
        int r5 = 2;
        int r7 = 1;
        if (r3 == 1) goto L11;
        if (r3 != 2) goto L17;
        int r4 = CollectionsKt.sumOfInt((Iterable) ZeusTransformUtils.preCheckCast(this.f11157J, Iterable.class, "com.obric.memorydata.plugin"));
        if (this.f11157J.size() <= 1) goto L9;
        int r8 = (this.f11157J.size() - 1) * this.c;
    L10:
        int r9 = ((getHeight() - getPaddingTop()) - getPaddingBottom()) - (r4 + r8);
    L16:
        r2 = r2 + r9;
        goto L17
    L9:
        r8 = 0;
    L17:
        int r6 = ((Collection) ZeusTransformUtils.preCheckCast(this.I, Collection.class, "com.obric.memorydata.plugin")).size();
        int r10 = 0;
    L18:
        if (r10 >= r6) goto L46;
        List r11 = (List) ZeusTransformUtils.preCheckCast(this.I.get(r10), List.class, "com.obric.memorydata.plugin");
        int r12 = ((Number) ZeusTransformUtils.preCheckCast(this.f11157J.get(r10), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r13 = ((Number) ZeusTransformUtils.preCheckCast(this.K.get(r10), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (this.j == false) goto L22;
        int r14 = getPaddingLeft();
    L29:
        int r15 = ((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).size();
        int r16 = 0;
    L30:
        if (r16 >= r15) goto L42;
        View r17 = (View) ZeusTransformUtils.preCheckCast(r11.get(r16), View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r18, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r110 = r17.getMeasuredWidth();
        int r111 = r17.getMeasuredHeight();
        int r20 = r19.leftMargin + r14;
        int r21 = r19.topMargin + r2;
        int r112 = r1;
        int r22 = this.f;
        int r113 = r6;
        if (r22 != 1) goto L34;
        r21 = r21 + ((((r12 - r111) - r19.topMargin) - r19.bottomMargin) / 2);
    L38:
        r17.layout(r20, r21, r20 + r110, r21 + r111);
        r14 = r14 + ((r110 + r19.leftMargin) + r19.rightMargin);
        if (r16 >= (r11.size() - 1)) goto L41;
        r14 = r14 + this.f11158b;
    L41:
        r16 = r16 + 1;
        r1 = r112;
        r6 = r113;
        goto L30
    L34:
        if (r22 != 2) goto L38;
        r21 = r21 + (((r12 - r111) - r19.topMargin) - r19.bottomMargin);
        goto L38
    L42:
        int r114 = r1;
        int r115 = r6;
        r2 = r2 + r12;
        if (r10 >= (this.I.size() - 1)) goto L45;
        r2 = r2 + this.c;
    L45:
        r10 = r10 + 1;
        r7 = 1;
        r1 = r114;
        r6 = r115;
        r5 = 2;
        goto L18
    L22:
        int r116 = getPaddingLeft();
        int r117 = this.e;
        if (r117 == r7) goto L27;
        if (r117 == r5) goto L26;
        int r118 = 0;
    L28:
        r14 = r118 + r116;
        goto L29
    L26:
        r118 = r1 - r13;
        goto L28
    L27:
        r118 = (r1 - r13) / r5;
        goto L28
    L46:
        return;
    L11:
        int r23 = CollectionsKt.sumOfInt((Iterable) ZeusTransformUtils.preCheckCast(this.f11157J, Iterable.class, "com.obric.memorydata.plugin"));
        if (this.f11157J.size() <= 1) goto L14;
        int r24 = (this.f11157J.size() - 1) * this.c;
    L15:
        r9 = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - (r23 + r24)) / 2;
        goto L16
    L14:
        r24 = 0;
        goto L15
    }

    private static final void setSelectedTab$lambda$4(ScrollableFlowTabLayout r0) {
        r0.d();
    }

    private static final void setSelectedTabSilently$lambda$3(ScrollableFlowTabLayout r0) {
        r0.d();
    }

    public final boolean a() {
        com.obric.oui.bouncelayout.e r0 = this.o;
        if (r0 == null) goto L12;
        Intrinsics.checkNotNull(r0);
        if (r0.getDistance() != 0.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
        com.obric.oui.bouncelayout.e r2 = this.o;
        Intrinsics.checkNotNull(r2);
        if (r2.isFinished() == true) goto L12;
    L11:
        boolean r3 = true;
    L13:
        com.obric.oui.bouncelayout.e r4 = this.p;
        if (r4 == null) goto L23;
        Intrinsics.checkNotNull(r4);
        if (r4.getDistance() != 0.0f) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L22;
        com.obric.oui.bouncelayout.e r6 = this.p;
        Intrinsics.checkNotNull(r6);
        if (r6.isFinished() == true) goto L23;
    L22:
        boolean r7 = true;
    L24:
        if (r3 == true) goto L29;
        if (r7 == false) goto L28;
        return true;
    L28:
        return false;
    L29:
        return true;
    L18:
        r5 = false;
    L23:
        r7 = false;
        goto L24
    L7:
        r1 = false;
    L12:
        r3 = false;
        goto L13
    }

    @Override // android.view.ViewGroup
    public void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        super.addView(r2, r3, r4);
        this.G = false;
        if (getChildCount() != 1) goto L5;
        this.E = 0;
    L5:
        if (r2 == null) goto L8;
        r2.setEnabled(isEnabled());
        return;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r4) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        if (this.j == false) goto L21;
        int r0 = getMaxScrollX();
        if (r4 < 0) goto L10;
        if (r4 > 0) goto L14;
        return false;
    L14:
        if (getScrollX() < r0) goto L18;
        return false;
    L18:
        return true;
    L10:
        if (getScrollX() > 0) goto L18;
        return false;
    L21:
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, ViewGroup.MarginLayoutParams.class);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return getWidth();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return getScrollX();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return (this.D + getPaddingLeft()) + getPaddingRight();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.k.computeScrollOffset() == false) goto L13;
        int r0 = getScrollX();
        scrollTo(this.k.getCurrX(), 0);
        if (this.s == false) goto L10;
        this.t = this.k.getCurrVelocity();
        if (b(r0) == false) goto L9;
        return;
    L9:
        this.u = r0;
    L10:
        postInvalidateOnAnimation();
        return;
    L13:
        if (this.s == false) goto L16;
        e();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        com.obric.oui.bouncelayout.e r0 = this.o;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        com.obric.oui.bouncelayout.e r3 = this.p;
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        float r5 = getBounceTranslation();
        if (r5 == 0.0f) goto L18;
        r1 = false;
    L18:
        if (r1 == true) goto L20;
        int r6 = r8.save();
        r8.translate(r5, 0.0f);
        super.dispatchDraw(r8);
        r8.restoreToCount(r6);
    L21:
        if (r2 == true) goto L23;
        if (r4 == true) goto L23;
        return;
    L23:
        postInvalidateOnAnimation();
        return;
    L20:
        super.dispatchDraw(r8);
        goto L21
    L11:
        if (r3.draw(r8) != true) goto L13;
        r4 = true;
        goto L14
    L5:
        if (r0.draw(r8) != true) goto L7;
        r2 = true;
        goto L8
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
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

    public final boolean getAutoCollapse() {
        return this.i;
    }

    @Override // com.obric.oui.bouncelayout.h
    public float getBounceTranslation() {
        com.obric.oui.bouncelayout.e r0 = this.o;
        float r1 = 0.0f;
        if (r0 == null) goto L5;
        float r2 = r0.a();
    L6:
        com.obric.oui.bouncelayout.e r3 = this.p;
        if (r3 == null) goto L10;
        r1 = r3.a();
    L10:
        return r2 + r1;
    L5:
        r2 = 0.0f;
        goto L6
    }

    public final int getHorizontalGravity() {
        return this.e;
    }

    public final int getHorizontalSpacing() {
        return this.f11158b;
    }

    public final int getMaxLines() {
        return this.h;
    }

    public final int getOrientation() {
        return this.d;
    }

    public final int getSelectedTabPosition() {
        return this.E;
    }

    public final boolean getSingleLine() {
        return this.g;
    }

    public final int getTabCount() {
        return getChildCount();
    }

    public final int getVerticalGravity() {
        return this.f;
    }

    public final int getVerticalSpacing() {
        return this.c;
    }

    @Override // android.view.View
    public void onCancelPendingInputEvents() {
        super.onCancelPendingInputEvents();
        this.B = false;
        this.C = -1;
        j();
        o();
        ViewParent r2 = getParent();
        if (r2 == null) goto L6;
        r2.requestDisallowInterceptTouchEvent(false);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        k();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "ev");
        if (isEnabled() == false) goto L42;
        if (c() == false) goto L42;
        int r0 = r6.getActionMasked();
        if (r0 != 0) goto L10;
        this.C = r6.getPointerId(0);
        this.x = r6.getX();
        float r7 = r6.getY();
        this.y = r7;
        this.z = this.x;
        this.A = r7;
        this.B = false;
        i();
        if (this.k.isFinished() == true) goto L40;
        this.k.abortAnimation();
        this.s = false;
    L40:
        return this.B;
    L10:
        if (r0 != 1) goto L12;
    L35:
        this.B = false;
        this.C = -1;
        o();
        goto L40
    L12:
        if (r0 != 2) goto L14;
        int r1 = this.C;
        if (r1 != (-1)) goto L22;
        return false;
    L22:
        int r2 = r6.findPointerIndex(r1);
        if (r2 != (-1)) goto L25;
        return false;
    L25:
        float r3 = r6.getX(r2);
        float r8 = r6.getY(r2);
        float r4 = Math.abs(r3 - this.z);
        float r5 = Math.abs(r8 - this.A);
        if (r4 <= this.l) goto L40;
        if (r4 <= r5) goto L40;
        if (this.B == true) goto L40;
        this.B = true;
        this.x = r3;
        this.y = r8;
        ViewParent r9 = getParent();
        if (r9 == null) goto L34;
        r9.requestDisallowInterceptTouchEvent(true);
    L34:
        return true;
    L14:
        if (r0 == 3) goto L35;
        if (r0 != 6) goto L40;
        a(r6);
    L42:
        return super.onInterceptTouchEvent(r6);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        if (this.d != 0) goto L5;
    L8:
        q();
    L10:
        if (this.G == true) goto L13;
        p();
        this.G = true;
        return;
    L13:
        return;
    L5:
        if (this.j == true) goto L8;
        h();
        goto L10
    }

    @Override // android.view.View
    public void onMeasure(int r2, int r3) {
        if (getVisibility() == 0) goto L7;
        setMeasuredDimension(0, 0);
        return;
    L7:
        if (this.j == false) goto L10;
        c(r2, r3);
        return;
    L10:
        if (this.d != 0) goto L12;
        a(r2, r3);
        return;
    L12:
        b(r2, r3);
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        float r5 = RangesKt.coerceAtLeast(r1, 0.0f);
        com.obric.oui.bouncelayout.e r6 = this.o;
        if (r6 == null) goto L5;
        r6.a(r5);
    L5:
        com.obric.oui.bouncelayout.e r7 = this.p;
        if (r7 == null) goto L8;
        r7.a(r5);
    L8:
        com.obric.oui.bouncelayout.e r8 = this.o;
        if (r8 == null) goto L11;
        r8.setSize(r1, r2);
    L11:
        com.obric.oui.bouncelayout.e r0 = this.p;
        if (r0 == null) goto L15;
        r0.setSize(r1, r2);
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        if (isEnabled() == false) goto L71;
        if (c() == false) goto L71;
        n();
        VelocityTracker r0 = this.w;
        if (r0 == null) goto L10;
        r0.addMovement(r7);
    L10:
        int r1 = r7.getActionMasked();
        if (r1 != 0) goto L13;
        m();
        i();
        if (this.k.isFinished() == true) goto L68;
        this.k.abortAnimation();
        this.s = false;
    L68:
        this.C = r7.getPointerId(0);
        this.x = r7.getX();
        float r8 = r7.getY();
        this.y = r8;
        this.z = this.x;
        this.A = r8;
    L69:
        return true;
    L13:
        if (r1 == 1) goto L50;
        if (r1 != 2) goto L17;
        int r2 = r7.findPointerIndex(this.C);
        if (r2 != (-1)) goto L33;
        return false;
    L33:
        float r3 = r7.getX(r2);
        float r9 = r7.getY(r2);
        int r4 = (int) (this.x - r3);
        if (this.B == true) goto L47;
        float r5 = Math.abs(r3 - this.z);
        float r10 = Math.abs(r9 - this.A);
        if (r5 <= this.l) goto L47;
        if (r5 <= r10) goto L47;
        this.B = true;
        ViewParent r11 = getParent();
        if (r11 == null) goto L42;
        r11.requestDisallowInterceptTouchEvent(true);
    L42:
        int r12 = this.l;
        if (r4 <= 0) goto L45;
        r4 = r4 - r12;
        goto L47
    L45:
        r4 = r4 + r12;
    L47:
        if (this.B == false) goto L69;
        this.x = r3;
        a(r4, r3);
        goto L69
    L17:
        if (r1 == 3) goto L23;
        if (r1 != 6) goto L69;
        a(r7);
        goto L69
    L23:
        if (this.B == true) goto L25;
    L27:
        this.B = false;
        this.C = -1;
        j();
        o();
        ViewParent r6 = getParent();
        if (r6 == null) goto L69;
    L29:
        r6.requestDisallowInterceptTouchEvent(false);
        goto L69
    L25:
        if (this.k.isFinished() == true) goto L27;
        this.k.abortAnimation();
        this.s = false;
        goto L27
    L50:
        if (this.B == false) goto L58;
        boolean r13 = a();
        VelocityTracker r14 = this.w;
        if (r14 == null) goto L58;
        r14.computeCurrentVelocity(1000, this.n);
        int r15 = (int) r14.getXVelocity(this.C);
        if (r13 == true) goto L58;
        if (Math.abs(r15) <= this.m) goto L58;
        boolean r16 = c(-r15);
    L59:
        this.B = false;
        this.C = -1;
        if (r16 == true) goto L62;
        j();
    L62:
        o();
        r6 = getParent();
        if (r6 == null) goto L69;
    L58:
        r16 = false;
    L71:
        return super.onTouchEvent(r7);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        if (r3 != 0) goto L8;
        if (Intrinsics.areEqual(r2, this) == false) goto L8;
        post(new $$Lambda$ScrollableFlowTabLayout$WHR3JTWX4qqmjhayLFMitgIPkzk(this));
        return;
    L8:
        if (Intrinsics.areEqual(r2, this) == false) goto L12;
        k();
        return;
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int r4) {
        if (r4 == this.E) goto L5;
    L9:
        int r0 = this.E;
        if (r4 >= r0) goto L13;
        int r1 = r0 - 1;
    L12:
        this.E = r1;
    L13:
        super.removeViewAt(r4);
        this.G = false;
        return;
    L5:
        if (getChildCount() <= 1) goto L9;
        if (r4 <= 0) goto L8;
        r1 = r4 - 1;
        goto L12
    L8:
        r1 = 0;
        goto L12
    }

    @Override // android.view.View
    public void scrollTo(int r3, int r4) {
        super.scrollTo(RangesKt.coerceIn(r3, 0, getMaxScrollX()), r4);
    }

    public final void setAutoCollapse(boolean r1) {
        this.i = r1;
    }

    public final void setCollapsed(boolean r2) {
        if (this.j == r2) goto L8;
        this.j = r2;
        setScrollX(0);
        k();
        this.D = 0;
        this.I.clear();
        this.f11157J.clear();
        this.K.clear();
        requestLayout();
        if (r2 == false) goto L9;
        post(new $$Lambda$ScrollableFlowTabLayout$jbYeBZwbxRjHfd8AsZRv6h20lBw(this));
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        if (isEnabled() == r2) goto L6;
        super.setEnabled(r2);
        b();
        return;
    }

    public final void setHorizontalGravity(int r1) {
        this.e = r1;
        requestLayout();
    }

    public final void setHorizontalSpacing(int r1) {
        this.f11158b = r1;
        requestLayout();
    }

    public final void setMaxLines(int r2) {
        this.h = Math.max(1, r2);
        requestLayout();
    }

    public void setOnBounceTranslationListener(com.obric.oui.bouncelayout.i r3) {
        this.q = (com.obric.oui.bouncelayout.i) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.bouncelayout.i.class, "com.obric.memorydata.plugin");
        g();
    }

    public final void setOnTabSelectedListener(b r3) {
        this.F = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    public final void setOrientation(int r1) {
        this.d = r1;
        requestLayout();
    }

    public final void setSelectedTab(int r5) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        if (this.H == true) goto L31;
        if (r5 >= 0) goto L9;
        return;
    L9:
        if (r5 >= getChildCount()) goto L29;
        int r0 = this.E;
        if (r5 == r0) goto L20;
        this.E = r5;
        a(r0, false);
        a(this.E, true);
        b r6 = this.F;
        if (r6 == null) goto L16;
        int r2 = this.E;
        View r3 = getChildAt(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "getChildAt(...)");
        r6.a(r2, r3);
    L16:
        if (this.i == false) goto L24;
        if (this.j == true) goto L24;
        setCollapsed(true);
    L24:
        if (this.j == false) goto L30;
        post(new $$Lambda$ScrollableFlowTabLayout$oDgpkIhRMlF7tTSOxes7svzZ3U(this));
        return;
    L30:
        return;
    L20:
        b r7 = this.F;
        if (r7 == null) goto L24;
        View r4 = getChildAt(r0);
        Intrinsics.checkNotNullExpressionValue(r4, "getChildAt(...)");
        r7.b(r0, r4);
        goto L24
    L29:
        return;
    }

    public final void setSelectedTabSilently(int r4) {
        if (isEnabled() == false) goto L15;
        if (r4 >= 0) goto L6;
        return;
    L6:
        if (r4 >= getChildCount()) goto L17;
        this.H = true;
        int r1 = this.E;
        if (r4 == r1) goto L13;
        this.E = r4;
        a(r1, false);
        a(this.E, true);
        if (this.j == false) goto L13;
        post(new $$Lambda$ScrollableFlowTabLayout$JQIsziu4tFRnq2GrhzlGSpaIxiI(this));
    L13:
        this.H = false;
        return;
    L17:
        return;
    }

    public final void setSingleLine(boolean r1) {
        this.g = r1;
        requestLayout();
    }

    public final void setVerticalGravity(int r1) {
        this.f = r1;
        requestLayout();
    }

    public final void setVerticalSpacing(int r1) {
        this.c = r1;
        requestLayout();
    }
}
