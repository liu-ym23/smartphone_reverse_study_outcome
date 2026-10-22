package com.obric.oui.swipeaction;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.bytedance.crash.entity.EventBody;
import com.loc.o;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "使用 OSwipeLayout")
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 \u0082\u00012\u00020\u0001:\u0004\u0082\u0001\u0083\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010U\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u0007H\u0002J\u0010\u0010X\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u0007H\u0002J\u0010\u0010Y\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u0007H\u0002J\u0006\u0010Z\u001a\u00020[J\b\u0010\\\u001a\u00020[H\u0016J\u0010\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010`\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010a\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_H\u0002J\u001c\u0010b\u001a\u0004\u0018\u00010$2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010fH\u0002J\u0010\u0010g\u001a\u00020\u00122\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010h\u001a\u00020\u00122\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010i\u001a\u00020\u00122\u0006\u0010j\u001a\u00020\u0007H\u0002J\u0010\u0010k\u001a\u00020\u00122\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010l\u001a\u00020\u00122\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010m\u001a\u00020\u00122\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010n\u001a\u00020\u00122\u0006\u0010c\u001a\u00020dH\u0002J\u0012\u0010o\u001a\u00020\u00122\b\u0010p\u001a\u0004\u0018\u00010$H\u0002J\u0018\u0010q\u001a\u00020\u00122\u0006\u0010p\u001a\u00020$2\u0006\u0010r\u001a\u00020sH\u0002J\u0010\u0010t\u001a\u00020[2\u0006\u0010u\u001a\u00020\u0007H\u0002J\b\u0010v\u001a\u00020[H\u0014J\u0010\u0010w\u001a\u00020\u00122\u0006\u0010c\u001a\u00020dH\u0016J(\u0010x\u001a\u00020[2\u0006\u0010y\u001a\u00020\u00072\u0006\u0010z\u001a\u00020\u00072\u0006\u0010{\u001a\u00020\u00072\u0006\u0010|\u001a\u00020\u0007H\u0014J\u0010\u0010}\u001a\u00020\u00122\u0006\u0010c\u001a\u00020dH\u0016J\b\u0010~\u001a\u00020[H\u0002J\u0010\u0010\u007f\u001a\u00020[2\u0006\u0010\u001d\u001a\u00020\u0012H\u0016J\t\u0010\u0080\u0001\u001a\u00020[H\u0002J\t\u0010\u0081\u0001\u001a\u00020[H\u0002R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0014R\u0014\u0010.\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0014R\u0014\u0010/\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u001aR\u000e\u00101\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0014R\u0010\u00106\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0014R\u000e\u0010<\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u001aR\u000e\u0010?\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u001aR\u000e\u0010B\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0014R\u0010\u0010G\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0014R\u000e\u0010L\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010M\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bN\u0010\u0014R\u001e\u0010P\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bQ\u0010\u001cR\u001a\u0010R\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0014\"\u0004\bT\u0010\u0016¨\u0006\u0084\u0001"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeActionLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionsListener", "Lcom/obric/oui/swipeaction/OSwipeActionLayout$SwipeActionsListener;", "getActionsListener", "()Lcom/obric/oui/swipeaction/OSwipeActionLayout$SwipeActionsListener;", "setActionsListener", "(Lcom/obric/oui/swipeaction/OSwipeActionLayout$SwipeActionsListener;)V", "autoOpenSpeed", "", "continuousSwipe", "", "getContinuousSwipe", "()Z", "setContinuousSwipe", "(Z)V", "curDraggingState", "direction", "getDirection", "()I", "setDirection", "(I)V", "disallowIntercept", "dragAfterOpened", "dragHelper", "Landroidx/customview/widget/ViewDragHelper;", "dragHelperCallback", "Landroidx/customview/widget/ViewDragHelper$Callback;", "draggedView", "Landroid/view/View;", "draggedViewId", "draggingViewLeft", "freeDrag", "gestureDetector", "Landroidx/core/view/GestureDetectorCompat;", "gestureDetectorCallBack", "Landroid/view/GestureDetector$OnGestureListener;", "horizontalWidth", "isClosed", "isMoving", "lViewWidth", "getLViewWidth", "leftFullOpenPending", "leftItemFirstExpendWidth", "leftOpen", "leftOpenFinished", "getLeftOpenFinished", "leftView", "leftViewBg", "leftViewBgId", "leftViewId", "leftViewOpened", "getLeftViewOpened", "leftViewPadding", "previousPosition", "getPreviousPosition", "previousUnprocessedPixel", "rViewWidth", "getRViewWidth", "rightFullOpenPending", "rightItemFirstExpendWidth", "rightOpen", "rightOpenFinished", "getRightOpenFinished", "rightView", "rightViewBg", "rightViewBgId", "rightViewEmpty", "getRightViewEmpty", "rightViewId", "rightViewOpened", "getRightViewOpened", EventBody.KEY_VALUE, "rightViewPadding", "setRightViewPadding", "swipeEnabled", "getSwipeEnabled", "setSwipeEnabled", "clampHorizontalViewPosition", "left", "dx", "clampLeftViewPosition", "clampRightViewPosition", IslandSession.REOPEN_VALUE_CLOSE, "", "computeScroll", "getFinalXHorizontalDirection", "xVel", "", "getFinalXLeftDirection", "getFinalXRightDirection", "getNeededTouchView", "event", "Landroid/view/MotionEvent;", "rootView", "Landroid/view/ViewGroup;", "isContinuousSwipeToLeft", "isContinuousSwipeToRight", "isIdleAfterMoving", "state", "isSwipeToClose", "isSwipeToOpenLeft", "isSwipeToOpenRight", "isSwipeViewTarget", "isViewGroup", "view", "isViewTouchTarget", "point", "Landroid/graphics/Point;", "moveTo", "x", "onFinishInflate", "onInterceptTouchEvent", "onSizeChanged", "w", o.g, "oldW", "oldH", "onTouchEvent", "parametersAdjustment", "requestDisallowInterceptTouchEvent", "setupPost", "updateState", "Companion", "SwipeActionsListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSwipeActionLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14501a = null;
    private View A;
    private View B;
    private int C;
    private View D;
    private View E;
    private int F;
    private b G;
    private final GestureDetector.OnGestureListener H;
    private final ViewDragHelper.Callback I;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14502b;
    private boolean c;
    private boolean d;
    private final double e;
    private boolean f;
    private boolean g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private int s;
    private ViewDragHelper t;
    private GestureDetectorCompat u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private View z;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeActionLayout$Companion;", "", "()V", "CLOSE_POSITION", "", "DEFAULT_AUTO_OPEN_SPEED", "HORIZONTAL", "LEFT", "NO_POSITION", "RIGHT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeActionLayout$SwipeActionsListener;", "", "onClose", "", "onOpen", "direction", "", "isContinuous", "", "onToOpen", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        void a();

        void a(int r1, boolean r2);

        void b();
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"com/obric/oui/swipeaction/OSwipeActionLayout$gestureDetectorCallBack$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onScroll", "", "e1", "Landroid/view/MotionEvent;", "e2", "dx", "", "dy", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSwipeActionLayout f14503a;

        c(OSwipeActionLayout r1) {
            this.f14503a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
            Intrinsics.checkNotNullParameter(r1, "e1");
            Intrinsics.checkNotNullParameter(r2, "e2");
            ViewParent r0 = this.f14503a.getParent();
            if (r0 == null) goto L8;
            r0.requestDisallowInterceptTouchEvent(true);
            return false;
        L8:
            return false;
        }
    }

    static {
        f14501a = new a(null);
    }

    public OSwipeActionLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OSwipeActionLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OSwipeActionLayout(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r7);
        this.f14502b = 1;
        this.r = true;
        TypedArray r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r9, R.styleable.OSwipeActionLayout);
        Intrinsics.checkNotNullExpressionValue(r10, "getContext().obtainStyle…eable.OSwipeActionLayout)");
        this.f14502b = 1;
        this.c = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_swipeEnabled, "styleable", "OSwipeActionLayout_oui_sal_swipeEnabled"), true);
        this.d = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_continuousSwipe, "styleable", "OSwipeActionLayout_oui_sal_continuousSwipe"), true);
        this.e = r10.getInt(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_autoMovingSensitivity, "styleable", "OSwipeActionLayout_oui_sal_autoMovingSensitivity"), 1000);
        this.f = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_dragAfterOpened, "styleable", "OSwipeActionLayout_oui_sal_dragAfterOpened"), false);
        this.g = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_freeDrag, "styleable", "OSwipeActionLayout_oui_sal_freeDrag"), true);
        this.h = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_rightItem, "styleable", "OSwipeActionLayout_oui_sal_rightItem"), 0);
        this.i = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_rightItem_bg, "styleable", "OSwipeActionLayout_oui_sal_rightItem_bg"), 0);
        this.j = (int) r10.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_rightItem_first_expand_width, "styleable", "OSwipeActionLayout_oui_sal_rightItem_first_expand_width"), 0.0f);
        this.C = (int) r10.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_rightItem_full_open_pending, "styleable", "OSwipeActionLayout_oui_sal_rightItem_full_open_pending"), 0.0f);
        this.k = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_leftItem, "styleable", "OSwipeActionLayout_oui_sal_leftItem"), 0);
        this.l = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_leftItem_bg, "styleable", "OSwipeActionLayout_oui_sal_leftItem_bg"), 0);
        this.m = (int) r10.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_leftItem_first_expand_width, "styleable", "OSwipeActionLayout_oui_sal_leftItem_first_expand_width"), 0.0f);
        this.F = (int) r10.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_leftItem_full_open_pending, "styleable", "OSwipeActionLayout_oui_sal_leftItem_full_open_pending"), 0.0f);
        this.n = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_draggedItem, "styleable", "OSwipeActionLayout_oui_sal_draggedItem"), 0);
        setRightViewPadding((int) r10.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_rightViewPadding, "styleable", "OSwipeActionLayout_oui_sal_rightViewPadding"), 0.0f));
        this.q = (int) r10.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_leftViewPadding, "styleable", "OSwipeActionLayout_oui_sal_leftViewPadding"), 0.0f);
        e();
        r10.recycle();
        this.H = (GestureDetector.OnGestureListener) ZeusTransformUtils.preCheckCast(new c(this), GestureDetector.OnGestureListener.class, "com.obric.memorydata.plugin");
        this.I = (ViewDragHelper.Callback) ZeusTransformUtils.preCheckCast(new OSwipeActionLayout$dragHelperCallback$1(this), ViewDragHelper.Callback.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ OSwipeActionLayout(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final int a(float r7) {
        if (this.d == true) goto L5;
    L18:
        double r2 = r7;
        double r4 = this.e;
        boolean r0 = true;
        if (r2 <= r4) goto L22;
    L20:
        r0 = false;
    L32:
        if (r0 == true) goto L34;
        return 0;
    L34:
        return -getRViewWidth();
    L22:
        if (r2 < (-r4)) goto L32;
        int r8 = this.v;
        if (r8 < 0) goto L27;
    L29:
        int r9 = this.v;
        if (r9 >= 0) goto L20;
        Math.abs(r9);
        int r1 = getRViewWidth() / 2;
        goto L20
    L27:
        if (Math.abs(r8) <= (getRViewWidth() / 2)) goto L29;
    L5:
        if (getRightViewEmpty() == false) goto L15;
        int r3 = this.v;
        if (r3 >= 0) goto L11;
        if (Math.abs(r3) <= (this.w / 2)) goto L11;
    L13:
        return (-this.w) + this.C;
    L11:
        if (r7 < (-this.e)) goto L13;
        return 0;
    L15:
        if (e(r7) == false) goto L18;
        return (-this.w) + this.C;
    }

    private final int a(int r3) {
        if (this.d == false) goto L17;
        if (getRightViewEmpty() == false) goto L17;
        if (this.g == false) goto L11;
        int r2 = this.w;
        if (r3 <= r2) goto L15;
        return 0;
    L15:
        return RangesKt.coerceAtLeast(r3, -r2);
    L11:
        if (r3 > 0) goto L41;
        r2 = this.w;
        goto L15
    L41:
        return 0;
    L17:
        if (this.f == false) goto L30;
        if (this.g == false) goto L25;
        int r0 = this.w;
        if (r3 <= r0) goto L24;
        return 0;
    L24:
        return RangesKt.coerceAtLeast(r3, this.q - r0);
    L25:
        if (r3 <= 0) goto L28;
        return 0;
    L28:
        return RangesKt.coerceAtLeast(r3, this.q - this.w);
    L30:
        if (this.g == true) goto L32;
        if (r3 <= 0) goto L39;
        return 0;
    L39:
        return RangesKt.coerceAtLeast(r3, -getRViewWidth());
    L32:
        if (r3 <= this.w) goto L35;
        return 0;
    L35:
        return RangesKt.coerceAtLeast(r3, -getRViewWidth());
    }

    private final int a(int r4, int r5) {
        boolean r0 = this.g;
        if (r0 == false) goto L5;
    L9:
        if (r0 == false) goto L11;
    L15:
        boolean r6 = this.f;
        if (r6 == true) goto L20;
        if (r4 <= 0) goto L20;
        return RangesKt.coerceAtMost(r4, getLViewWidth());
    L20:
        if (r6 == true) goto L24;
        if (r4 >= 0) goto L24;
        return RangesKt.coerceAtLeast(r4, -getRViewWidth());
    L24:
        if (r4 >= 0) goto L27;
        return RangesKt.coerceAtLeast(r4, this.q - this.w);
    L27:
        return RangesKt.coerceAtMost(r4, this.w - this.p);
    L11:
        if (this.y == false) goto L15;
        if (r5 <= 0) goto L15;
        return RangesKt.coerceAtMost(r4, 0);
    L5:
        if (this.x == false) goto L9;
        if (r5 >= 0) goto L9;
        return RangesKt.coerceAtLeast(r4, 0);
    }

    public static final /* synthetic */ int a(OSwipeActionLayout r0) {
        return r0.s;
    }

    public static final /* synthetic */ int a(OSwipeActionLayout r0, float r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ int a(OSwipeActionLayout r0, int r1, int r2) {
        return r0.a(r1, r2);
    }

    private final View a(MotionEvent r6, ViewGroup r7) {
        Intrinsics.checkNotNull(r7);
        if (r7.onInterceptTouchEvent(r6) == true) goto L5;
        int r0 = r7.getChildCount();
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L13;
        int r3 = r2 + 1;
        View r4 = r7.getChildAt(r2);
        Intrinsics.checkNotNullExpressionValue(r4, "rootView.getChildAt(i)");
        if (a(r4) == true) goto L12;
        r2 = r3;
        goto L7
    L12:
        return a(r6, (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin"));
    L13:
        return null;
    L5:
        return (View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin");
    }

    private final boolean a() {
        int r2 = this.s;
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    private final boolean a(MotionEvent r4) {
        int[] r0 = new int[2];
        View r1 = this.z;
        Intrinsics.checkNotNull(r1);
        r1.getLocationOnScreen(r0);
        int r2 = r0[1];
        View r3 = this.z;
        Intrinsics.checkNotNull(r3);
        int r5 = r2 + r3.getMeasuredHeight();
        int r6 = r0[1];
        int r7 = (int) r4.getRawY();
        if ((r6 + 1) > r7) goto L7;
        if (r7 >= r5) goto L7;
        return true;
    L7:
        return false;
    }

    private final boolean a(View r1) {
        return ZeusTransformUtils.instanceOf(r1, ViewGroup.class);
    }

    private final boolean a(View r2, Point r3) {
        if (r3.y >= r2.getTop()) goto L5;
    L11:
        return false;
    L5:
        if (r3.y >= r2.getBottom()) goto L11;
        if (r3.x < r2.getLeft()) goto L11;
        if (r3.y >= r2.getRight()) goto L11;
        return true;
    }

    public static final /* synthetic */ boolean a(OSwipeActionLayout r0, int r1) {
        return r0.c(r1);
    }

    private final int b(float r7) {
        if (this.d == true) goto L5;
    L18:
        double r2 = r7;
        double r4 = this.e;
        boolean r0 = true;
        if (r2 <= r4) goto L22;
    L32:
        if (r0 == true) goto L34;
        return 0;
    L34:
        return getLViewWidth();
    L22:
        if (r2 >= (-r4)) goto L24;
    L23:
        r0 = false;
        goto L32
    L24:
        int r8 = this.v;
        if (r8 > 0) goto L27;
    L29:
        int r9 = this.v;
        if (r9 <= 0) goto L23;
        Math.abs(r9);
        int r1 = getLViewWidth() / 2;
        goto L23
    L27:
        if (Math.abs(r8) <= (getLViewWidth() / 2)) goto L29;
    L5:
        if (getRightViewEmpty() == false) goto L15;
        int r3 = this.v;
        if (r3 <= 0) goto L11;
        if (Math.abs(r3) <= (this.w / 2)) goto L11;
    L13:
        return this.w - this.F;
    L11:
        if (r7 > this.e) goto L13;
        return 0;
    L15:
        if (d(r7) == false) goto L18;
        return this.w - this.F;
    }

    private final int b(int r3) {
        if (this.d == false) goto L17;
        if (getRightViewEmpty() == false) goto L17;
        if (this.g == false) goto L11;
        int r2 = this.w;
        if (r3 >= (-r2)) goto L15;
        return -r2;
    L15:
        return RangesKt.coerceAtMost(r3, r2);
    L11:
        if (r3 < 0) goto L41;
        r2 = this.w;
        goto L15
    L41:
        return 0;
    L17:
        if (this.f == false) goto L30;
        if (this.g == false) goto L25;
        int r0 = this.w;
        if (r3 >= (-r0)) goto L24;
        return -r0;
    L24:
        return RangesKt.coerceAtMost(r3, r0 - this.p);
    L25:
        if (r3 >= 0) goto L28;
        return 0;
    L28:
        return RangesKt.coerceAtMost(r3, this.w - this.p);
    L30:
        if (this.g == false) goto L36;
        int r1 = this.w;
        if (r3 >= (-r1)) goto L35;
        return -r1;
    L35:
        return RangesKt.coerceAtMost(r3, getLViewWidth());
    L36:
        if (r3 >= 0) goto L39;
        return 0;
    L39:
        return RangesKt.coerceAtMost(r3, getLViewWidth());
    }

    public static final /* synthetic */ int b(OSwipeActionLayout r0, float r1) {
        return r0.b(r1);
    }

    public static final /* synthetic */ void b(OSwipeActionLayout r0) {
        r0.c();
    }

    public static final /* synthetic */ void b(OSwipeActionLayout r0, int r1) {
        r0.s = r1;
    }

    private final boolean b() {
        if (this.v != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final int c(float r2) {
        if (g(r2) == false) goto L7;
        return getLViewWidth();
    L7:
        if (f(r2) == false) goto L11;
        return -getRViewWidth();
    L11:
        if (h(r2) == false) goto L14;
        return 0;
    L14:
        return -1;
    }

    public static final /* synthetic */ int c(OSwipeActionLayout r0, float r1) {
        return r0.c(r1);
    }

    private final void c() {
        if (b() == false) goto L18;
        this.x = false;
        this.y = false;
        b r0 = this.G;
        if (r0 == null) goto L8;
        r0.b();
    L8:
        View r1 = this.A;
        if (r1 == null) goto L12;
        r1.layout(0, r1.getTop(), r1.getWidth(), r1.getBottom());
    L12:
        View r2 = this.D;
        if (r2 == null) goto L16;
        r2.layout(0, r2.getTop(), r2.getWidth(), r2.getBottom());
    L16:
        this.o = 0;
        return;
    L18:
        if (getLeftOpenFinished() == false) goto L20;
    L30:
        this.x = true;
        this.y = false;
        b r3 = this.G;
        if (r3 == null) goto L39;
        r3.a(2, getLeftOpenFinished());
        return;
    L39:
        return;
    L20:
        if (getLeftViewOpened() == true) goto L30;
        if (getRightOpenFinished() == false) goto L25;
    L26:
        this.x = false;
        this.y = true;
        b r4 = this.G;
        if (r4 == null) goto L38;
        r4.a(1, getRightOpenFinished());
        return;
    L38:
        return;
    L25:
        if (getRightViewOpened() == true) goto L26;
    }

    public static final /* synthetic */ void c(OSwipeActionLayout r0, int r1) {
        r0.v = r1;
    }

    private final boolean c(int r3) {
        int r2 = this.s;
        if (r2 != 1) goto L5;
    L6:
        if (r3 == 0) goto L10;
    L8:
        return false;
    L10:
        return true;
    L5:
        if (r2 != 2) goto L8;
        goto L6
    }

    public static final /* synthetic */ boolean c(OSwipeActionLayout r0) {
        return r0.y;
    }

    public static final /* synthetic */ View d(OSwipeActionLayout r0) {
        return r0.A;
    }

    private final void d() {
        post(new $$Lambda$OSwipeActionLayout$B3NJW7oNhCUgXOLtjkyN7tYlEQ(this));
    }

    public static final /* synthetic */ void d(OSwipeActionLayout r0, int r1) {
        r0.o = r1;
    }

    private final boolean d(float r5) {
        if (r5 > this.e) goto L5;
    L6:
        int r6 = this.v;
        if (r6 > 0) goto L9;
    L11:
        return false;
    L9:
        if (Math.abs(r6) <= (this.w / 2)) goto L11;
    L10:
        return true;
    L5:
        if (Math.abs(this.v) > getLViewWidth()) goto L10;
        goto L6
    }

    public static final /* synthetic */ int e(OSwipeActionLayout r0, int r1) {
        return r0.a(r1);
    }

    private final void e() {
        if (this.d == false) goto L8;
        if (this.f14502b == 3) goto L8;
        this.f = true;
    L8:
        if (this.f14502b != 3) goto L11;
        setRightViewPadding(0);
        this.q = 0;
        return;
    }

    private final boolean e(float r5) {
        if (r5 < (-this.e)) goto L5;
    L6:
        int r6 = this.v;
        if (r6 < 0) goto L9;
    L11:
        return false;
    L9:
        if (Math.abs(r6) <= (this.w / 2)) goto L11;
    L10:
        return true;
    L5:
        if (Math.abs(this.v) > getRViewWidth()) goto L10;
        goto L6
    }

    public static final /* synthetic */ boolean e(OSwipeActionLayout r0) {
        return r0.x;
    }

    public static final /* synthetic */ int f(OSwipeActionLayout r0, int r1) {
        return r0.b(r1);
    }

    public static final /* synthetic */ View f(OSwipeActionLayout r0) {
        return r0.D;
    }

    private final boolean f(float r7) {
        if (r7 <= 0.0f) goto L5;
        return false;
    L5:
        int r0 = this.v;
        if (r0 < 0) goto L8;
    L9:
        if (r0 < 0) goto L11;
        return false;
    L11:
        if (Math.abs(r0) <= (getRViewWidth() / 2)) goto L15;
    L12:
        return true;
    L15:
        return false;
    L8:
        if (r7 < (-this.e)) goto L12;
        goto L9
    }

    public static final /* synthetic */ int g(OSwipeActionLayout r0) {
        return r0.o;
    }

    private final boolean g(float r7) {
        if (r7 >= 0.0f) goto L5;
        return false;
    L5:
        int r0 = this.v;
        if (r0 > 0) goto L8;
    L9:
        if (r0 > 0) goto L11;
        return false;
    L11:
        if (Math.abs(r0) <= (getLViewWidth() / 2)) goto L15;
    L12:
        return true;
    L15:
        return false;
    L8:
        if (r7 > this.e) goto L12;
        goto L9
    }

    private final int getLViewWidth() {
        return this.m;
    }

    private final boolean getLeftOpenFinished() {
        if (this.v != (this.w - this.F)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getLeftViewOpened() {
        if (this.D != null) goto L5;
    L7:
        return false;
    L5:
        if (this.v != getLViewWidth()) goto L7;
        return true;
    }

    private final int getPreviousPosition() {
        if (this.x == false) goto L6;
        return getLViewWidth();
    L6:
        if (this.y == true) goto L11;
        return 0;
    L11:
        return -getRViewWidth();
    }

    private final int getRViewWidth() {
        return this.j;
    }

    private final boolean getRightOpenFinished() {
        if (this.v != ((-this.w) + this.C)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getRightViewEmpty() {
        if (this.A != null) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getRightViewOpened() {
        if (this.A != null) goto L5;
    L7:
        return false;
    L5:
        if (this.v != (-getRViewWidth())) goto L7;
        return true;
    }

    public static final /* synthetic */ View h(OSwipeActionLayout r0) {
        return r0.B;
    }

    private final boolean h(float r6) {
        int r0 = this.v;
        if (r0 >= 0) goto L5;
    L6:
        if (r0 <= 0) goto L8;
    L9:
        if (r0 >= 0) goto L11;
    L12:
        int r7 = this.v;
        if (r7 <= 0) goto L15;
    L17:
        return false;
    L15:
        if (Math.abs(r7) >= (getRViewWidth() / 2)) goto L17;
    L16:
        return true;
    L11:
        if (Math.abs(r0) < (getLViewWidth() / 2)) goto L16;
    L8:
        if (r6 > this.e) goto L16;
    L5:
        if (r6 < (-this.e)) goto L16;
        goto L6
    }

    public static final /* synthetic */ View i(OSwipeActionLayout r0) {
        return r0.z;
    }

    public static final /* synthetic */ View j(OSwipeActionLayout r0) {
        return r0.E;
    }

    public static final /* synthetic */ int k(OSwipeActionLayout r0) {
        return r0.w;
    }

    public static final /* synthetic */ int l(OSwipeActionLayout r0) {
        return r0.getPreviousPosition();
    }

    /* JADX INFO: renamed from: lambda$B3NJW7oNhCUgX-OLtjkyN7tYlEQ, reason: not valid java name */
    public static /* synthetic */ void m1372lambda$B3NJW7oNhCUgXOLtjkyN7tYlEQ(OSwipeActionLayout r0) {
        m1373setupPost$lambda2(r0);
    }

    public static final /* synthetic */ ViewDragHelper m(OSwipeActionLayout r0) {
        return r0.t;
    }

    private final void setRightViewPadding(int r1) {
        this.p = r1;
        e();
    }

    /* JADX INFO: renamed from: setupPost$lambda-2, reason: not valid java name */
    private static final void m1373setupPost$lambda2(OSwipeActionLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        int r0 = r2.f14502b;
        if (r0 != 1) goto L5;
        View r1 = r2.A;
        Intrinsics.checkNotNull(r1);
        float r3 = r2.w;
    L12:
        r1.setX(r3);
        return;
    L5:
        if (r0 != 2) goto L7;
    L10:
        r1 = r2.D;
        Intrinsics.checkNotNull(r1);
        View r4 = r2.D;
        Intrinsics.checkNotNull(r4);
        r3 = -r4.getWidth();
        goto L12
    L7:
        if (r0 != 3) goto L14;
        View r5 = r2.A;
        Intrinsics.checkNotNull(r5);
        r5.setX(r2.w);
        goto L10
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewDragHelper r0 = this.t;
        Intrinsics.checkNotNull(r0);
        if (r0.continueSettling(true) == false) goto L6;
        ViewCompat.postInvalidateOnAnimation((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final b getActionsListener() {
        return this.G;
    }

    public final boolean getContinuousSwipe() {
        return this.d;
    }

    public final int getDirection() {
        return this.f14502b;
    }

    public final boolean getSwipeEnabled() {
        return this.c;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        int r0 = this.n;
        if (r0 == 0) goto L5;
        this.z = findViewById(r0);
    L5:
        int r1 = this.k;
        if (r1 == 0) goto L8;
        this.D = findViewById(r1);
    L8:
        int r2 = this.h;
        if (r2 == 0) goto L11;
        this.A = findViewById(r2);
    L11:
        int r3 = this.i;
        if (r3 == 0) goto L14;
        this.B = findViewById(r3);
    L14:
        int r4 = this.l;
        if (r4 == 0) goto L18;
        this.E = findViewById(r4);
    L18:
        if (this.z == null) goto L61;
        int r5 = this.f14502b;
        if (r5 != 1) goto L27;
        if (this.A != null) goto L27;
        throw new RuntimeException("'oui_sal_rightItem' must be specified");
    L27:
        if (r5 == 2) goto L29;
    L33:
        if (r5 == 1) goto L35;
    L41:
        if (r5 != 2) goto L50;
        if (this.d == true) goto L50;
        if (this.D != null) goto L50;
        throw new RuntimeException("Must be specified 'oui_sal_leftItem'  or flag oui_sal_continuousSwipe = true");
    L50:
        if (r5 == 3) goto L52;
    L58:
        this.t = ViewDragHelper.create((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), 1.0f, this.I);
        this.u = new GestureDetectorCompat((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.H);
        d();
        super.onFinishInflate();
        return;
    L52:
        if (this.A == null) goto L57;
        if (this.D != null) goto L58;
    L57:
        throw new RuntimeException("'oui_sal_leftItem' and 'oui_sal_rightItem' must be specified");
    L35:
        if (this.d == true) goto L41;
        if (this.A != null) goto L41;
        throw new RuntimeException("Must be specified 'oui_sal_rightItem' or flag oui_sal_continuousSwipe = true");
    L29:
        if (this.D != null) goto L33;
        throw new RuntimeException("'oui_sal_leftItem' must be specified");
    L61:
        throw new RuntimeException("'oui_sal_draggedItem' must be specified");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (this.r == false) goto L12;
        if (a(this.z) == false) goto L12;
        View r0 = a(r6, (ViewGroup) ZeusTransformUtils.preCheckCast(this.z, ViewGroup.class, "com.obric.memorydata.plugin"));
        Point r2 = new Point((int) r6.getX(), (int) r6.getY());
        if (r0 == null) goto L12;
        if (a(r0, r2) == false) goto L12;
        return false;
    L12:
        if (a(r6) == false) goto L17;
        ViewDragHelper r5 = this.t;
        Intrinsics.checkNotNull(r5);
        if (r5.shouldInterceptTouchEvent(r6) == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        this.w = r1;
        super.onSizeChanged(r1, r2, r3, r4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (a(r2) == false) goto L5;
    L8:
        GestureDetectorCompat r0 = this.u;
        Intrinsics.checkNotNull(r0);
        r0.onTouchEvent(r2);
        ViewDragHelper r1 = this.t;
        Intrinsics.checkNotNull(r1);
        r1.processTouchEvent(r2);
        return true;
    L5:
        if (a() == true) goto L8;
        return super.onTouchEvent(r2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r1) {
        super.requestDisallowInterceptTouchEvent(r1);
        this.r = r1;
    }

    public final void setActionsListener(b r3) {
        this.G = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    public final void setContinuousSwipe(boolean r1) {
        this.d = r1;
    }

    public final void setDirection(int r1) {
        this.f14502b = r1;
    }

    public final void setSwipeEnabled(boolean r1) {
        this.c = r1;
    }
}
