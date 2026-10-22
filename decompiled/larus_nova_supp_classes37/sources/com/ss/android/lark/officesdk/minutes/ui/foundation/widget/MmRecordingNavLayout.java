package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.core.view.NestedScrollingParent2;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u000f\u0018\u0000 o2\u00020\u00012\u00020\u0002:\u0002opB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010-\u001a\u00020*2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010.\u001a\u00020*2\u0006\u0010!\u001a\u00020\nJ\u001a\u0010/\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u000e\u00101\u001a\u00020*2\u0006\u0010$\u001a\u00020\u0019J>\u00102\u001a\u00020*26\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020*0)J>\u00107\u001a\u00020*26\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020*0)J\b\u00108\u001a\u00020*H\u0014J\b\u00109\u001a\u00020*H\u0014J0\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u0019H\u0014J(\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u0019H\u0014J\b\u0010E\u001a\u00020*H\u0002J\u0018\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020\u00192\u0006\u0010H\u001a\u00020\u0019H\u0016J\u000e\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020\u0011J(\u0010K\u001a\u00020\u00112\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u0019H\u0016J(\u0010P\u001a\u00020*2\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u0019H\u0016J\u0018\u0010Q\u001a\u00020*2\u0006\u0010M\u001a\u00020\n2\u0006\u0010O\u001a\u00020\u0019H\u0016J8\u0010R\u001a\u00020*2\u0006\u0010M\u001a\u00020\n2\u0006\u0010S\u001a\u00020\u00192\u0006\u0010T\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u0019H\u0016J \u0010W\u001a\u00020\u00112\u0006\u0010M\u001a\u00020\n2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020YH\u0016J(\u0010[\u001a\u00020*2\u0006\u0010<\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u00192\u0006\u0010\\\u001a\u00020\u00192\u0006\u0010]\u001a\u00020\u0019H\u0014J0\u0010^\u001a\u00020*2\u0006\u0010M\u001a\u00020\n2\u0006\u0010_\u001a\u00020\u00192\u0006\u0010`\u001a\u00020\u00192\u0006\u0010a\u001a\u00020b2\u0006\u0010O\u001a\u00020\u0019H\u0016J\b\u0010c\u001a\u00020*H\u0016J\u0006\u0010d\u001a\u00020*J\u0006\u0010e\u001a\u00020*J\b\u0010f\u001a\u00020*H\u0002J\n\u0010g\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010h\u001a\u00020\u00192\u0006\u00100\u001a\u00020\n2\u0006\u0010i\u001a\u00020\u0019H\u0002J\u0012\u0010j\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010k\u001a\u00020*H\u0002J\b\u0010l\u001a\u00020*H\u0002J\u0010\u0010m\u001a\u00020\u00192\u0006\u00100\u001a\u00020\nH\u0002J\u0010\u0010n\u001a\u00020\u00192\u0006\u00100\u001a\u00020\nH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00190&X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010'\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020*0)0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmRecordingNavLayout;", "Landroid/widget/LinearLayout;", "Landroidx/core/view/NestedScrollingParent2;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "titleNameView", "Landroid/view/View;", "titleTextView", "tabView", "middleContainer", "listener", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmRecordingNavLayout$IMmStickNavListener;", "value", "", "isForceHideTopView", "()Z", "setForceHideTopView", "(Z)V", "smoothScroller", "Landroid/widget/Scroller;", "magic20", "", "highThreshold", "titleVisibilityHysteresis", "scrolledDistance", "controlsVisible", "topHeaderVisibleHeight", "topHeaderScrollRange", "isEnableScroll", "topBarView", "topBarBottom", "wasTitleVisible", "contentTopInsetPx", "titleBaseTopMargins", "Ljava/util/WeakHashMap;", "onScrollChangedListeners", "", "Lkotlin/Function2;", "", "updateMiddleContainerRunnable", "Ljava/lang/Runnable;", "setListener", "setTopBarView", "bindSlotViews", "titleView", "setContentTopInsetPx", "addOnScrollChangedListener", "Lkotlin/ParameterName;", AppbrandHostConstants.Schema_Meta.NAME, "scrollY", "oldScrollY", "removeOnScrollChangedListener", "onDetachedFromWindow", "onFinishInflate", "onLayout", "changed", "l", "t", "r", "b", "onSizeChanged", "w", "h", "oldw", "oldh", "updateTopBarBottom", "scrollTo", "x", "y", "setEnableScroll", "enableScroll", "onStartNestedScroll", "child", PickerReporterConstants.KEY.TARGET, "axes", "type", "onNestedScrollAccepted", "onStopNestedScroll", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedPreFling", "velocityX", "", "velocityY", "onScrollChanged", "oldl", "oldt", "onNestedPreScroll", "dx", "dy", "consumed", "", "computeScroll", "hideTopView", "showTopView", "checkTitleVisibility", "getTitleTextView", "getTitleContentBottom", "titleTopOnScreen", "applyContentTopInset", "updateTopHeaderMetrics", "updateMiddleContainerHeight", "getTopHeaderVisibleHeight", "getTopHeaderScrollRange", "Companion", "IMmStickNavListener", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmRecordingNavLayout extends LinearLayout implements NestedScrollingParent2 {
    public static final /* synthetic */ int v = 0;
    public View a;
    public View b;
    public View c;
    public View d;
    public b e;
    public boolean f;
    public final Scroller g;
    public final int h;
    public final int i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public View o;
    public int p;
    public boolean q;
    public int r;
    public final WeakHashMap<View, Integer> s;
    public final Set<Function2<Integer, Integer, Unit>> t;
    public final c u;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void c(boolean r1);

        void d();

        void e();

        void f();
    }

    public static final class c implements Runnable {
        public final /* synthetic */ MmRecordingNavLayout a;

        public c(MmRecordingNavLayout r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MmRecordingNavLayout r0 = this.a;     // Catch: Throwable -> L4
            int r1 = MmRecordingNavLayout.v;     // Catch: Throwable -> L4
            r0.c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, PickerReporterConstants.KEY.TARGET);
    }

    public final void onNestedScrollAccepted(View r1, View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "child");
        Intrinsics.checkNotNullParameter(r2, PickerReporterConstants.KEY.TARGET);
    }

    public final boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "child");
        Intrinsics.checkNotNullParameter(r2, PickerReporterConstants.KEY.TARGET);
        if ((r3 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final View getTitleTextView() {
        View r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        View r1 = this.a;
        if (r1 != null) goto L8;
        r1 = findViewById(2131380195);
        this.a = r1;
    L8:
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(2131390088);
        if (r2 == null) goto L12;
        this.b = r2;
        return r2;
    L12:
        return null;
    }

    public final void c() {
        View r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = RangesKt.coerceAtLeast(this.l - getScrollY(), 0);
        int r2 = getMeasuredHeight() - r1;
        ViewGroup.LayoutParams r3 = r0.getLayoutParams();
        int r4 = bwb.b.a;
        MmUiLogScene r5 = MmUiLogScene.FOUNDATION;
        bwb.b.b(r5, "updateMiddleContainerHeight", "measuredHeight=" + getMeasuredHeight() + ", scrollY=" + getScrollY() + ", topHeaderVisibleHeight=" + this.l + ", topHeaderScrollRange=" + this.m + ", topVisibleHeight=" + r1 + ", targetHeight=" + r2 + ", middleCurrentHeight=" + r0.getHeight() + ", middleLpHeight=" + r3.height, null, 8);
        if (r3.height == r2) goto L9;
        r3.height = r2;
        r0.setLayoutParams(r3);
        bwb.b.b(r5, "updateMiddleContainerHeight", "height: " + r2 + ", topVisibleHeight: " + r1, null, 8);
        return;
    }

    public final void d() {
        View r0 = this.a;
        if (r0 == null) goto L31;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        ViewGroup.MarginLayoutParams r3 = null;
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
    L8:
        int r4 = r0.getMeasuredHeight();
        int r5 = 0;
        if (r2 == null) goto L11;
        int r6 = r2.topMargin;
    L12:
        int r7 = r4 + r6;
        if (r2 == null) goto L15;
        int r8 = r2.bottomMargin;
    L16:
        int r9 = r7 + r8;
        ViewGroup.LayoutParams r10 = r0.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        r3 = (ViewGroup.MarginLayoutParams) r10;
    L19:
        int r11 = r0.getMeasuredHeight();
        if (r3 == null) goto L22;
        r5 = r3.bottomMargin;
    L22:
        int r12 = r11 + r5;
        if (this.l == r9) goto L25;
    L26:
        this.l = r9;
        this.m = r12;
        if (getScrollY() <= this.m) goto L29;
        scrollTo(getScrollX(), this.m);
    L29:
        removeCallbacks(this.u);
        post(this.u);
        return;
    L25:
        if (this.m != r12) goto L26;
        return;
    L15:
        r8 = 0;
        goto L16
    L11:
        r6 = 0;
        goto L12
    L7:
        r2 = null;
        goto L8
    }

    public final void b() {
        View r0 = getTitleTextView();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getVisibility() == 0) goto L8;
        return;
    L8:
        boolean r2 = true;
        if (this.p != 0) goto L14;
        View r1 = this.o;
        if (r1 == null) goto L14;
        int[] r4 = new int[2];
        r1.getLocationOnScreen(r4);
        this.p = r4[1] + r1.getHeight();
    L14:
        int[] r3 = new int[2];
        r0.getLocationOnScreen(r3);
        int r5 = r3[1];
        if ((r0 instanceof TextView) == false) goto L17;
        TextView r6 = (TextView) r0;
    L18:
        if (r6 != null) goto L20;
        int r7 = r0.getHeight();
    L27:
        int r8 = r5 + r7;
        boolean r9 = this.q;
        if (r9 == false) goto L30;
        int r10 = this.p;
    L31:
        if (r8 > r10) goto L34;
        r2 = false;
    L34:
        if (r9 != r2) goto L36;
        return;
    L36:
        if (this.e == null) goto L42;
        int r11 = bwb.b.a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "checkTitleVisibility", "titleBottom=" + r8 + ", topBarBottom=" + this.p + ", visibleThreshold=" + r10 + ", isTitleVisible=" + r2 + ", listener=" + this.e, null, 8);
        this.q = r2;
        b r12 = this.e;
        if (r12 == null) goto L43;
        r12.c(r2);
        return;
    L43:
        return;
    L42:
        return;
    L30:
        r10 = this.p + this.i;
        goto L31
    L20:
        Layout r13 = r6.getLayout();
        if (r13 != null) goto L24;
        r7 = ((TextView) r0).getHeight();
        goto L27
    L24:
        if (r13.getLineCount() > 0) goto L26;
        r7 = ((TextView) r0).getHeight();
        goto L27
    L26:
        r7 = r13.getLineBottom(r13.getLineCount() - 1);
        r5 = r5 + r6.getTotalPaddingTop();
        goto L27
    L17:
        r6 = null;
        goto L18
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.g.computeScrollOffset() == false) goto L6;
        scrollTo(this.g.getCurrX(), this.g.getCurrY());
        postInvalidate();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.u);
        this.b = null;
        this.e = null;
        this.t.clear();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View r0 = findViewById(2131380195);
        this.a = r0;
        if (r0 == null) goto L5;
        View r1 = r0.findViewById(2131390088);
    L6:
        this.b = r1;
        this.c = findViewById(2131380194);
        this.d = findViewById(2131380185);
        int r2 = bwb.b.a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "onFinishInflate", null, null, 12);
        removeCallbacks(this.u);
        postDelayed(this.u, 100);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public MmRecordingNavLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void a(View r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L8:
        if (r1 != null) goto L10;
        return;
    L10:
        WeakHashMap<View, Integer> r2 = this.s;
        Integer r3 = r2.get(r4);
        if (r3 != null) goto L13;
        r3 = Integer.valueOf(r1.topMargin);
        r2.put(r4, r3);
    L13:
        int r5 = r3.intValue() + this.r;
        if (r1.topMargin == r5) goto L17;
        r1.topMargin = r5;
        r4.setLayoutParams(r1);
        return;
    L17:
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final void setContentTopInsetPx(int r2) {
        int r3 = RangesKt.coerceAtLeast(r2, 0);
        if (this.r != r3) goto L5;
        return;
    L5:
        this.r = r3;
        a(this.a);
        d();
        removeCallbacks(this.u);
        post(this.u);
        requestLayout();
    }

    public final void setEnableScroll(boolean r1) {
        this.n = r1;
    }

    public final void setForceHideTopView(boolean r2) {
        this.f = r2;
        if (r2 == false) goto L10;
        int r3 = getScrollY();
        int r0 = this.m;
        if (r3 >= r0) goto L11;
        scrollBy(0, r0 - getScrollY());
        b r4 = this.e;
        if (r4 == null) goto L12;
        getScrollY();
        r4.e();
        r4.d();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.e = r2;
    }

    public final void setTopBarView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "topBarView");
        this.o = r2;
    }

    public MmRecordingNavLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.g = new Scroller(r2);
        this.h = UIUtils.dp2px(r2, 20);
        this.i = UIUtils.dp2px(r2, 8.0f);
        this.k = true;
        this.n = true;
        this.q = true;
        this.s = new WeakHashMap();
        this.t = new LinkedHashSet();
        this.u = new c(this);
        setOrientation(1);
    }

    public final void onStopNestedScroll(View r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, PickerReporterConstants.KEY.TARGET);
        int r6 = bwb.b.a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "onStopNestedScroll", "type=" + r5 + ", scrollY=" + getScrollY() + ", topHeaderVisibleHeight=" + this.l + ", topHeaderScrollRange=" + this.m, null, 8);
    }

    @Override // android.view.View
    public final void scrollTo(int r2, int r3) {
        if (r3 >= 0) goto L4;
        r3 = 0;
    L4:
        int r0 = this.m;
        if (r3 <= r0) goto L8;
        r3 = r0;
    L8:
        if (r3 == getScrollY()) goto L11;
        super.scrollTo(r2, r3);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r3, float r4, float r5) {
        Intrinsics.checkNotNullParameter(r3, PickerReporterConstants.KEY.TARGET);
        if (getScrollY() >= this.m) goto L7;
        return false;
    L7:
        return super.onNestedPreFling(r3, r4, r5);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r4, int r5, int r6, int r7) {
        super.onScrollChanged(r4, r5, r6, r7);
        int r8 = bwb.b.a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "onScrollChanged", "current t: " + r5 + ", oldt: " + r7, null, 8);
        Iterator<T> r9 = this.t.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        ((Function2) r9.next()).invoke(Integer.valueOf(r5), Integer.valueOf(r7));
        goto L4
    L6:
        int r10 = r5 - r7;
        int r11 = this.j;
        int r12 = this.h;
        if (r11 <= r12) goto L15;
        if (this.k == false) goto L15;
        b r13 = this.e;
        if (r13 == null) goto L13;
        r13.b();
    L13:
        this.k = false;
        this.j = 0;
    L22:
        boolean r14 = this.k;
        if (r14 == false) goto L25;
        if (r10 <= 0) goto L25;
    L27:
        this.j += r10;
    L28:
        c();
        b();
        return;
    L25:
        if (r14 == true) goto L28;
        if (r10 >= 0) goto L28;
    L15:
        if (r11 >= (-r12)) goto L22;
        if (this.k == true) goto L22;
        b r15 = this.e;
        if (r15 == null) goto L21;
        r15.a();
    L21:
        this.k = true;
        this.j = 0;
        goto L22
    }

    @Override // android.view.View
    public final void onSizeChanged(int r2, int r3, int r4, int r5) {
        super.onSizeChanged(r2, r3, r4, r5);
        int r6 = bwb.b.a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "onSizeChanged", "w: " + r2 + ", h: " + r3, null, 8);
        removeCallbacks(this.u);
        postDelayed(this.u, 100);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        a(this.a);
        d();
        View r6 = this.o;
        if (r6 == null) goto L6;
        int[] r7 = new int[2];
        r6.getLocationOnScreen(r7);
        this.p = r7[1] + r6.getHeight();
    L6:
        b();
    }

    public final void onNestedPreScroll(View r8, int r9, int r10, int[] r11, int r12) {
        Intrinsics.checkNotNullParameter(r8, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r11, "consumed");
        if (this.n == true) goto L6;
        return;
    L6:
        if (r12 != 0) goto L9;
        getParent().requestDisallowInterceptTouchEvent(true);
    L9:
        if (this.f == false) goto L18;
        if (getScrollY() < this.m) goto L18;
        if (r12 != 1) goto L44;
        b r13 = this.e;
        if (r13 == null) goto L45;
        r13.f();
        return;
    L45:
        return;
    L44:
        return;
    L18:
        if (r10 > 0) goto L20;
    L22:
        boolean r1 = false;
    L23:
        if (r10 < 0) goto L25;
    L29:
        boolean r14 = false;
    L30:
        int r2 = bwb.b.a;
        bwb.b.b(MmUiLogScene.FOUNDATION, "onNestedPreScroll", "hiddenTop: " + r1 + ", showTop: " + r14 + ", scrollY: " + getScrollY() + ", topHeaderVisibleHeight=" + this.l + ", topHeaderScrollRange=" + this.m, null, 8);
        b r3 = this.e;
        if (r3 == null) goto L38;
        getScrollY();
        r3.e();
        getScrollY();
        r3.d();
        if (r12 != 1) goto L38;
        if (getScrollY() != 0) goto L38;
        r3.f();
    L38:
        if (getScrollY() != 0) goto L40;
        this.g.abortAnimation();
    L40:
        if (r1 == true) goto L42;
        if (r14 == true) goto L42;
        return;
    L42:
        scrollBy(0, r10);
        r11[1] = r10;
        return;
    L25:
        if (getScrollY() < 0) goto L29;
        if (r8.canScrollVertically(-1) == true) goto L29;
        r14 = true;
        goto L30
    L20:
        if (getScrollY() >= this.m) goto L22;
        r1 = true;
        goto L23
    }
}
