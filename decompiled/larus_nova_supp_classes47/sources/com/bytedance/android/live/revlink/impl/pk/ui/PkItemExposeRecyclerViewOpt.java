package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.AnchorLinkTabTitleViewHolder;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0012#B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cB\u001b\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001b\u0010\u001fB#\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\u001b\u0010\"J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/PkItemExposeRecyclerViewOpt;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/core/view/NestedScrollingParent2;", "Landroidx/core/view/NestedScrollingParentHelper;", "getScrollingParentHelper", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "", "setAdapter", "", "a", "Ljava/lang/String;", "getInviteIconPanelType", "()Ljava/lang/String;", "setInviteIconPanelType", "(Ljava/lang/String;)V", "inviteIconPanelType", "Landroid/widget/FrameLayout;", "b", "Landroid/widget/FrameLayout;", "getTabTitlePlace", "()Landroid/widget/FrameLayout;", "setTabTitlePlace", "(Landroid/widget/FrameLayout;)V", "tabTitlePlace", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defaultStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkItemExposeRecyclerViewOpt extends RecyclerView implements NestedScrollingParent2 {
    public static final /* synthetic */ int q = 0;
    public String a;
    public FrameLayout b;
    public final HashSet<String> c;
    public NestedScrollingParentHelper d;
    public int e;
    public VelocityTracker f;
    public int g;
    public final c h;
    public final int[] i;
    public final int[] j;
    public final int[] k;
    public boolean l;
    public boolean m;
    public AnchorLinkTabTitleViewHolder n;
    public Integer o;
    public Integer p;

    public static final class a implements ViewTreeObserver.OnScrollChangedListener {
        public final /* synthetic */ PkItemExposeRecyclerViewOpt a;

        public a(PkItemExposeRecyclerViewOpt r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            this.a.r();
        }
    }

    public static final class b {
    }

    public final class c implements Runnable {
        public final OverScroller a;
        public int b;
        public final /* synthetic */ PkItemExposeRecyclerViewOpt c;

        public static final class a implements Interpolator {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float r3) {
                float r4 = r3 - 1.0f;
                return ((((r4 * r4) * r4) * r4) * r4) + 1.0f;
            }
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [android.view.ViewGroup, androidx.recyclerview.widget.RecyclerView, com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerViewOpt] */
        public final void a() {
            OverScroller r0 = this.a;
            if (r0.computeScrollOffset() == false) goto L38;
            int r1 = r0.getCurrY();
            int r2 = r1 - this.b;
            this.b = r1;
            ?? r3 = this.c;
            int r4 = PkItemExposeRecyclerViewOpt.q;
            boolean r10 = true;
            if ((!r3.canScrollVertically(1)) == false) goto L20;
            SSViewPager r5 = (View) SequencesKt.lastOrNull(UtilityKotlinExtentionsKt.g(r3));
            if ((r5 instanceof SSViewPager) == false) goto L20;
            SSViewPager r6 = r5;
            int r7 = r6.getCurrentItem();
            Integer r8 = r3.o;
            if (r8 != null) goto L11;
        L13:
            r3.o = Integer.valueOf(r7);
            FragmentPagerAdapter r9 = r6.getAdapter();
            if ((r9 instanceof FragmentPagerAdapter) == false) goto L20;
            View r12 = r9.getItem(r7).getView();
            if ((r12 instanceof RecyclerView) == false) goto L20;
            if (r12.canScrollVertically(r2) == false) goto L20;
            r12.scrollBy(0, r2);
        L27:
            if (r0.getCurrY() != r0.getFinalY()) goto L29;
            boolean r13 = true;
        L31:
            if (r0.isFinished() == true) goto L35;
            if (r13 == true) goto L35;
            r10 = false;
        L35:
            if (r10 == true) goto L39;
            this.c.removeCallbacks(this);
            ViewCompat.postOnAnimation(this.c, this);
            return;
        L39:
            return;
        L29:
            r13 = false;
            goto L31
        L11:
            if (r8.intValue() == r7) goto L13;
            c r14 = r3.h;
            r14.b = 0;
            r14.a.abortAnimation();
            r14.c.removeCallbacks(r14);
            r14.c.stopNestedScroll(1);
        L20:
            int[] r15 = r3.j;
            r15[0] = 0;
            r15[1] = 0;
            if (r3.dispatchNestedPreScroll(0, r2, r15, r3.i, 1) == false) goto L23;
            r2 = r2 - r3.j[1];
            r3.getParent().requestDisallowInterceptTouchEvent(true);
        L23:
            int r16 = r2;
            r3.l = false;
            r3.scrollBy(0, r16);
            if (r3.l == true) goto L27;
            r3.dispatchNestedScroll(0, 0, 0, r16, null, 1);
            goto L27
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(PkItemExposeRecyclerViewOpt r3) {
            this.c = r3;
            a r0 = a.a;
            this.a = new OverScroller(r3.getContext(), r0);
        }
    }

    static {
    }

    public final void onNestedPreScroll(View r1, int r2, int r3, int[] r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "target");
        Intrinsics.checkNotNullParameter(r4, "consumed");
    }

    public final void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, "target");
    }

    public final boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "child");
        Intrinsics.checkNotNullParameter(r2, "target");
        if ((r3 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final NestedScrollingParentHelper getScrollingParentHelper() {
        if (this.d != null) goto L6;
        this.d = new NestedScrollingParentHelper(this);
    L6:
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r() {
        Rect r0 = new Rect();
        if (isShown() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return;
    L10:
        int r2 = getChildCount();
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L47;
        View r4 = getChildAt(r3);
        if (r4 == null) goto L46;
        j r5 = getChildViewHolder(r4);
        RecyclerView.LayoutManager r6 = getLayoutManager();
        if ((r6 instanceof LinearLayoutManager) == true) goto L18;
        r6 = null;
    L18:
        LinearLayoutManager r7 = (LinearLayoutManager) r6;
        if (r7 == null) goto L21;
        int r8 = r7.getOrientation();
    L22:
        Rect r9 = new Rect();
        if (r4.isShown() == true) goto L25;
    L39:
        boolean r10 = false;
    L40:
        if (r10 == false) goto L46;
        if ((r5 instanceof j) == false) goto L46;
        j r12 = r5;
        String r13 = r12.G();
        if (this.c.contains(r13) == true) goto L46;
        r12.N(this.a);
        this.c.add(r12.G());
        goto L46
    L25:
        if (r4.getGlobalVisibleRect(r9) == false) goto L39;
        if (r8 == 1) goto L28;
    L30:
        boolean r14 = false;
    L31:
        if (r8 == 0) goto L33;
    L35:
        boolean r15 = false;
    L36:
        if (r14 == true) goto L38;
        if (r15 == false) goto L39;
    L38:
        r10 = true;
        goto L40
    L33:
        if (r9.width() <= (r4.getMeasuredWidth() / 2)) goto L35;
        r15 = true;
        goto L36
    L28:
        if (r9.height() <= (r4.getMeasuredHeight() / 2)) goto L30;
        r14 = true;
        goto L31
    L21:
        r8 = -1;
    L46:
        r3 = r3 + 1;
        goto L11
    L47:
        return;
    L5:
        if (getGlobalVisibleRect(r0) == false) goto L7;
        r1 = true;
        goto L8
    }

    public final String getInviteIconPanelType() {
        return this.a;
    }

    public final FrameLayout getTabTitlePlace() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PkItemExposeRecyclerViewOpt(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = "";
        this.c = new HashSet();
        this.g = -1;
        this.i = new int[2];
        this.j = new int[2];
        this.k = new int[2];
        this.h = new c(this);
        getViewTreeObserver().addOnScrollChangedListener(new a(this));
        addOnScrollListener(new AnonymousClass2(this));
    }

    public final boolean onInterceptTouchEvent(MotionEvent r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.getAction() != 0) goto L8;
        t(r3);
    L8:
        boolean r4 = super.onInterceptTouchEvent(r3);
        if (this.m == true) goto L12;
        if (r4 == false) goto L12;
        stopNestedScroll();
        startNestedScroll(2, 0);
    L12:
        this.m = r4;
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r13) {
        if (r13 != null) goto L5;
        return false;
    L5:
        MotionEvent r1 = MotionEvent.obtain(r13);
        int[] r2 = this.k;
        r1.offsetLocation(r2[0], r2[1]);
        int r3 = (int) (r13.getY() + 0.5f);
        if (this.f != null) goto L9;
        this.f = VelocityTracker.obtain();
    L9:
        if (r13.getAction() != 0) goto L14;
        t(r13);
        VelocityTracker r14 = this.f;
        if (r14 == null) goto L13;
        r14.addMovement(r1);
    L13:
        return true;
    L14:
        VelocityTracker r4 = this.f;
        if (r4 == null) goto L17;
        r4.addMovement(r1);
    L17:
        int r5 = this.e - r3;
        if ((!canScrollVertically(1)) == false) goto L34;
        SSViewPager r6 = (View) SequencesKt.lastOrNull(UtilityKotlinExtentionsKt.g(this));
        if ((r6 instanceof SSViewPager) == false) goto L34;
        SSViewPager r7 = r6;
        FragmentPagerAdapter r8 = r7.getAdapter();
        int r9 = r7.getCurrentItem();
        if ((r8 instanceof FragmentPagerAdapter) == false) goto L34;
        View r10 = r8.getItem(r9).getView();
        if ((r10 instanceof RecyclerView) == false) goto L34;
        if (r10.canScrollVertically(r5) == false) goto L34;
        r10.scrollBy(0, r5);
        this.e = r3 - this.i[1];
        if (r13.getAction() != 3) goto L30;
    L31:
        u(r13);
    L32:
        r1.recycle();
        return true;
    L30:
        if (r13.getAction() != 1) goto L32;
    L34:
        int[] r12 = this.j;
        r12[0] = 0;
        r12[1] = 0;
        if (dispatchNestedPreScroll(0, r5, r12, this.i, 0) == false) goto L37;
        r5 = r5 - this.j[1];
        int[] r15 = this.k;
        int r16 = r15[0];
        int[] r17 = this.i;
        r15[0] = r16 + r17[0];
        r15[1] = r15[1] + r17[1];
        getParent().requestDisallowInterceptTouchEvent(true);
    L37:
        int[] r18 = this.i;
        this.e = r3 - r18[1];
        getLocationInWindow(r18);
        int[] r19 = this.i;
        int r20 = r19[0];
        int r22 = r19[1];
        scrollBy(0, r5);
        getLocationInWindow(this.i);
        int[] r23 = this.i;
        int r24 = r23[0] - r20;
        r23[0] = r24;
        int r25 = r23[1] - r22;
        r23[1] = r25;
        this.e -= r25;
        int[] r26 = this.k;
        r26[0] = r26[0] + r24;
        r26[1] = r26[1] + r25;
        if (r13.getAction() != 3) goto L40;
    L41:
        u(r13);
    L42:
        r1.recycle();
        return true;
    L40:
        if (r13.getAction() != 1) goto L42;
        goto L41
    }

    public void setAdapter(RecyclerView.Adapter<?> r2) {
        super.setAdapter(r2);
        if (r2 == null) goto L6;
        r2.registerAdapterDataObserver(new AnonymousClass1(this));
        return;
    }

    public final void setInviteIconPanelType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void setTabTitlePlace(FrameLayout r1) {
        this.b = r1;
    }

    public final void t(MotionEvent r6) {
        int r0 = (int) (r6.getY() + 0.5f);
        int[] r1 = this.k;
        r1[0] = 0;
        r1[1] = 0;
        c r2 = this.h;
        r2.b = 0;
        r2.a.abortAnimation();
        r2.c.removeCallbacks(r2);
        r2.c.stopNestedScroll(1);
        VelocityTracker r3 = this.f;
        if (r3 == null) goto L5;
        r3.clear();
    L5:
        this.e = r0;
        this.g = r6.getPointerId(0);
        startNestedScroll(2, 0);
    }

    public final void u(MotionEvent r12) {
        stopScroll();
        if (r12.getAction() != 1) goto L14;
        VelocityTracker r13 = this.f;
        if (r13 == null) goto L7;
        r13.computeCurrentVelocity(WebcastRedirectException.UNKNOWN, getMaxFlingVelocity());
    L7:
        VelocityTracker r14 = this.f;
        if (r14 == null) goto L10;
        float r15 = r14.getYVelocity(this.g);
    L11:
        float r16 = r15 * (-1.0f);
        if (r16 == 0.0f) goto L14;
        c r1 = this.h;
        int r6 = (int) r16;
        r1.b = 0;
        PkItemExposeRecyclerViewOpt r17 = r1.c;
        r17.o = null;
        r17.startNestedScroll(2, 1);
        r1.a.fling(0, 0, 0, r6, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        r1.c.removeCallbacks(r1);
        ViewCompat.postOnAnimation(r1.c, r1);
        goto L14
    L10:
        r15 = 0.0f;
    L14:
        VelocityTracker r18 = this.f;
        if (r18 == null) goto L18;
        r18.clear();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PkItemExposeRecyclerViewOpt(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = "";
        this.c = new HashSet();
        this.g = -1;
        this.i = new int[2];
        this.j = new int[2];
        this.k = new int[2];
        this.h = new c(this);
        getViewTreeObserver().addOnScrollChangedListener(new a(this));
        addOnScrollListener(new AnonymousClass2(this));
    }

    public final void onStopNestedScroll(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "target");
        NestedScrollingParentHelper r0 = getScrollingParentHelper();
        if (r0 == null) goto L6;
        r0.onStopNestedScroll(r2, r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PkItemExposeRecyclerViewOpt(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = "";
        this.c = new HashSet();
        this.g = -1;
        this.i = new int[2];
        this.j = new int[2];
        this.k = new int[2];
        this.h = new c(this);
        getViewTreeObserver().addOnScrollChangedListener(new a(this));
        addOnScrollListener(new AnonymousClass2(this));
    }

    public final void onNestedScrollAccepted(View r2, View r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "target");
        NestedScrollingParentHelper r0 = getScrollingParentHelper();
        if (r0 == null) goto L6;
        r0.onNestedScrollAccepted(r2, r3, r4, r5);
        return;
    }
}
