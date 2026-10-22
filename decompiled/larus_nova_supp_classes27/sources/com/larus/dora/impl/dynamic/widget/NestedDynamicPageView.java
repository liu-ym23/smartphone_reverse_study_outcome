package com.larus.dora.impl.dynamic.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import c59.e0;
import c59.f0;
import c59.n;
import c59.p;
import c59.t;
import com.google.android.material.tabs.TabLayout;
import com.larus.dora.impl.dynamic.DoraDynamicListFragment;
import com.larus.dora.impl.dynamic.DoraDynamicPagerAdapter;
import com.larus.dora.impl.dynamic.DslCardAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\t*\u0002#*\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\bJ\u0010\u00108\u001a\u0002062\b\u00109\u001a\u0004\u0018\u00010:J\u0010\u0010;\u001a\u0002062\b\u00109\u001a\u0004\u0018\u00010<J,\u0010=\u001a\u0002062\u0006\u0010>\u001a\u0002012\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\f2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u000eJ\u001e\u0010B\u001a\u0002062\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0086@¢\u0006\u0002\u0010GJ\u0006\u0010H\u001a\u000206J\u0018\u0010I\u001a\u0002062\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\bH\u0014J0\u0010L\u001a\u0002062\u0006\u0010M\u001a\u0002012\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\bH\u0014J\u0010\u0010R\u001a\u0002012\u0006\u0010S\u001a\u00020TH\u0016J\u0010\u0010U\u001a\u0002012\u0006\u0010S\u001a\u00020TH\u0016J\b\u0010V\u001a\u00020\bH\u0002J(\u0010W\u001a\u0002012\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020Y2\u0006\u0010[\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\bH\u0016J(\u0010]\u001a\u0002062\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020Y2\u0006\u0010[\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\bH\u0016J\u0018\u0010^\u001a\u0002062\u0006\u0010Z\u001a\u00020Y2\u0006\u0010\\\u001a\u00020\bH\u0016J0\u0010_\u001a\u0002062\u0006\u0010Z\u001a\u00020Y2\u0006\u0010`\u001a\u00020\b2\u0006\u0010a\u001a\u00020\b2\u0006\u0010b\u001a\u00020c2\u0006\u0010\\\u001a\u00020\bH\u0016J(\u0010d\u001a\u0002062\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b2\u0006\u0010e\u001a\u00020\b2\u0006\u0010f\u001a\u00020\bH\u0014J8\u0010g\u001a\u0002062\u0006\u0010Z\u001a\u00020Y2\u0006\u0010h\u001a\u00020\b2\u0006\u0010i\u001a\u00020\b2\u0006\u0010j\u001a\u00020\b2\u0006\u0010k\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\bH\u0016R$\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+R\u0011\u0010,\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001e\u00102\u001a\u0002012\u0006\u00100\u001a\u000201@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/larus/dora/impl/dynamic/widget/NestedDynamicPageView;", "Landroidx/core/widget/NestedScrollView;", "Landroidx/core/view/NestedScrollingParent2;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastTabConfigList", "", "", "", "", "mDownX", "", "mDownY", "velocityTracker", "Landroid/view/VelocityTracker;", "touchSlop", "contentContainer", "Landroid/widget/LinearLayout;", "getContentContainer", "()Landroid/widget/LinearLayout;", "aboveTabView", "Landroidx/recyclerview/widget/RecyclerView;", "getAboveTabView", "()Landroidx/recyclerview/widget/RecyclerView;", "newcomerGuideWidget", "Lcom/larus/dora/impl/dynamic/widget/NewcomerGuideWidget;", "getNewcomerGuideWidget", "()Lcom/larus/dora/impl/dynamic/widget/NewcomerGuideWidget;", "tabSelectedListener", "com/larus/dora/impl/dynamic/widget/NestedDynamicPageView$tabSelectedListener$1", "Lcom/larus/dora/impl/dynamic/widget/NestedDynamicPageView$tabSelectedListener$1;", "tabView", "Lcom/google/android/material/tabs/TabLayout;", "getTabView", "()Lcom/google/android/material/tabs/TabLayout;", "pageChangeCallback", "com/larus/dora/impl/dynamic/widget/NestedDynamicPageView$pageChangeCallback$1", "Lcom/larus/dora/impl/dynamic/widget/NestedDynamicPageView$pageChangeCallback$1;", "viewPage2", "Landroidx/viewpager2/widget/ViewPager2;", "getViewPage2", "()Landroidx/viewpager2/widget/ViewPager2;", "value", "", "isTabSticky", "()Z", "lastGuideVisible", "onTabSelected", "", "pos", "setAboveAdapter", "adapter", "Lcom/larus/dora/impl/dynamic/DslCardAdapter;", "setPagerAdapter", "Lcom/larus/dora/impl/dynamic/DoraDynamicPagerAdapter;", "showNewcomerGuide", "show", "config", "Lcom/larus/platform/model/NewcomerGuideItem;", "userType", "setPageInfo", "pageInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslDeviceManagementPage;", "connectState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "(Lcom/larus/dora/impl/dynamic/dsl/DslDeviceManagementPage;Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDestroyView", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "l", "t", "r", "b", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "getHeaderHeight", "onStartNestedScroll", "child", "Landroid/view/View;", "target", "axes", "type", "onNestedScrollAccepted", "onStopNestedScroll", "onNestedPreScroll", "dx", "dy", "consumed", "", "onScrollChanged", "oldl", "oldt", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NestedDynamicPageView extends NestedScrollView implements NestedScrollingParent2 {
    public List<? extends Map<String, ? extends Object>> a;
    public float b;
    public float c;
    public VelocityTracker d;
    public final int e;
    public final LinearLayout f;
    public final RecyclerView g;
    public final NewcomerGuideWidget h;
    public final TabLayout i;
    public final NestedDynamicPageView$pageChangeCallback$1 j;
    public final ViewPager2 k;
    public boolean l;
    public boolean m;

    public static final class a implements TabLayout.OnTabSelectedListener {
        public final /* synthetic */ NestedDynamicPageView a;

        public final void onTabReselected(TabLayout.Tab r1) {
        }

        public final void onTabUnselected(TabLayout.Tab r1) {
        }

        public a(NestedDynamicPageView r1) {
            this.a = r1;
        }

        public final void onTabSelected(TabLayout.Tab r2) {
            if (r2 == null) goto L5;
            int r3 = r2.getPosition();
            this.a.k.setCurrentItem(r3);
            return;
        }
    }

    public NestedDynamicPageView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public NestedDynamicPageView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "child");
        Intrinsics.checkNotNullParameter(r2, "target");
        if ((r3 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getHeaderHeight() {
        int r1 = 0;
        if (this.g.getVisibility() == 8) goto L5;
        int r0 = this.g.getMeasuredHeight();
    L7:
        if (this.h.getVisibility() == 8) goto L10;
        r1 = this.h.getMeasuredHeight();
    L10:
        return r0 + r1;
    L5:
        r0 = 0;
        goto L7
    }

    public final RecyclerView getAboveTabView() {
        return this.g;
    }

    public final LinearLayout getContentContainer() {
        return this.f;
    }

    public final NewcomerGuideWidget getNewcomerGuideWidget() {
        return this.h;
    }

    public final TabLayout getTabView() {
        return this.i;
    }

    public final ViewPager2 getViewPage2() {
        return this.k;
    }

    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        int r0 = r5.getActionMasked();
        if (r0 != 0) goto L5;
        this.b = r5.getX();
        this.c = r5.getY();
        VelocityTracker r1 = this.d;
        if (r1 == null) goto L27;
        r1.recycle();
    L27:
        VelocityTracker r2 = VelocityTracker.obtain();
        this.d = r2;
        if (r2 == null) goto L31;
        r2.addMovement(r5);
    L31:
        return super.onInterceptTouchEvent(r5);
    L5:
        if (r0 != 1) goto L7;
    L21:
        VelocityTracker r3 = this.d;
        if (r3 == null) goto L31;
        r3.addMovement(r5);
        goto L31
    L7:
        if (r0 != 2) goto L9;
        float r4 = r5.getX() - this.b;
        float r6 = r5.getY() - this.c;
        VelocityTracker r7 = this.d;
        if (r7 == null) goto L15;
        r7.addMovement(r5);
    L15:
        if (Math.abs(r6) <= Math.abs(r4)) goto L31;
        if (Math.abs(r6) <= this.e) goto L31;
        if (this.l == false) goto L31;
        return true;
    L9:
        if (r0 == 3) goto L21;
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "ev");
        int r0 = r9.getActionMasked();
        int r1 = -1;
        RecyclerView r4 = null;
        if (r0 != 1) goto L5;
    L34:
        VelocityTracker r2 = this.d;
        if (r2 == null) goto L37;
        r2.addMovement(r9);
    L37:
        VelocityTracker r3 = this.d;
        if (r3 == null) goto L40;
        r3.computeCurrentVelocity(1000);
    L40:
        VelocityTracker r5 = this.d;
        if (r5 == null) goto L43;
        float r6 = r5.getYVelocity();
    L44:
        VelocityTracker r7 = this.d;
        if (r7 == null) goto L47;
        r7.recycle();
    L47:
        this.d = null;
        if (this.l == false) goto L74;
        DoraDynamicPagerAdapter r8 = this.k.getAdapter();
        if ((r8 instanceof DoraDynamicPagerAdapter) == false) goto L52;
        DoraDynamicPagerAdapter r10 = r8;
    L53:
        if (r10 == null) goto L58;
        DoraDynamicListFragment r11 = r10.y2(this.k.getCurrentItem());
        if (r11 == null) goto L58;
        r4 = r11.f;
    L58:
        if (r6 > 0.0f) goto L61;
        r1 = 1;
    L61:
        if (r4 != null) goto L63;
    L65:
        int r12 = (int) (-r6);
        if (r1 > 0) goto L68;
    L71:
        fling(r12);
    L72:
        return true;
    L68:
        if (r12 <= 1800) goto L70;
        r12 = 1800;
    L70:
        super.onTouchEvent(r9);
        goto L71
    L63:
        if (r4.canScrollVertically(r1) == false) goto L65;
        r4.fling(0, (int) (-r6));
        goto L72
    L52:
        r10 = null;
    L74:
        return super.onTouchEvent(r9);
    L43:
        r6 = 0.0f;
        goto L44
    L5:
        if (r0 != 2) goto L7;
        float r13 = r9.getY() - this.c;
        this.b = r9.getX();
        this.c = r9.getY();
        VelocityTracker r14 = this.d;
        if (r14 == null) goto L13;
        r14.addMovement(r9);
    L13:
        if (this.l == false) goto L74;
        DoraDynamicPagerAdapter r15 = this.k.getAdapter();
        if ((r15 instanceof DoraDynamicPagerAdapter) == false) goto L17;
        DoraDynamicPagerAdapter r16 = r15;
    L18:
        if (r16 == null) goto L22;
        DoraDynamicListFragment r17 = r16.y2(this.k.getCurrentItem());
        if (r17 == null) goto L22;
        r4 = r17.f;
    L22:
        if (r4 != null) goto L24;
    L30:
        boolean r18 = false;
    L31:
        if (r18 == true) goto L33;
        scrollTo(0, RangesKt.coerceIn(getScrollY() - ((int) r13), 0, getHeaderHeight()));
    L33:
        return true;
    L24:
        if (r13 > 0.0f) goto L28;
        r1 = 1;
    L28:
        if (r4.canScrollVertically(r1) == false) goto L30;
        r4.scrollBy(0, (int) (-r13));
        r18 = true;
        goto L31
    L17:
        r16 = null;
        goto L18
    L7:
        if (r0 == 3) goto L34;
        goto L34
    }

    public final void setAboveAdapter(DslCardAdapter r2) {
        this.g.setAdapter(r2);
    }

    public final void setPagerAdapter(DoraDynamicPagerAdapter r2) {
        this.k.setAdapter(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onMeasure(int r8, int r9) {
        super.onMeasure(r8, r9);
        int r10 = View.MeasureSpec.getSize(r8);
        int r11 = View.MeasureSpec.getSize(r9);
        int r1 = 0;
        if (this.g.getVisibility() == 8) goto L5;
        this.g.measure(View.MeasureSpec.makeMeasureSpec(r10, 1073741824), View.MeasureSpec.makeMeasureSpec(r11, Integer.MIN_VALUE));
        int r0 = this.g.getMeasuredHeight();
    L7:
        if (this.h.getVisibility() == 8) goto L9;
        this.h.measure(View.MeasureSpec.makeMeasureSpec(r10, 1073741824), View.MeasureSpec.makeMeasureSpec(r11, Integer.MIN_VALUE));
        r1 = this.h.getMeasuredHeight();
    L9:
        this.i.measure(View.MeasureSpec.makeMeasureSpec(r10, 1073741824), View.MeasureSpec.makeMeasureSpec(r11, Integer.MIN_VALUE));
        this.k.measure(View.MeasureSpec.makeMeasureSpec(r10, 1073741824), View.MeasureSpec.makeMeasureSpec(r11 - this.i.getMeasuredHeight(), 1073741824));
        int r2 = ((r0 + r1) + this.i.getMeasuredHeight()) + this.k.getMeasuredHeight();
        this.f.measure(View.MeasureSpec.makeMeasureSpec(r10, 1073741824), View.MeasureSpec.makeMeasureSpec(r2, 1073741824));
        setMeasuredDimension(r10, r11);
        return;
    L5:
        r0 = 0;
        goto L7
    }

    public final void onStopNestedScroll(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "target");
        super.onStopNestedScroll(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback, com.larus.dora.impl.dynamic.widget.NestedDynamicPageView$pageChangeCallback$1] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, android.view.ViewGroup, com.larus.dora.impl.dynamic.widget.NewcomerGuideWidget] */
    public NestedDynamicPageView(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        this.a = CollectionsKt.emptyList();
        this.e = ViewConfiguration.get(r11).getScaledTouchSlop();
        LinearLayout r14 = new LinearLayout(r11);
        r14.setOrientation(1);
        r14.setNestedScrollingEnabled(true);
        this.f = r14;
        RecyclerView r0 = new RecyclerView(r11);
        r0.setItemAnimator(null);
        r0.setLayoutManager(new LinearLayoutManager(r11));
        r0.setNestedScrollingEnabled(false);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.g = r0;
        ?? r3 = new NewcomerGuideWidget(r11, null, 6, 0);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, -2);
        int r6 = c7.b(16);
        r1.setMargins(r6, c7.b(8), r6, 0);
        r3.setLayoutParams(r1);
        r3.setVisibility(8);
        this.h = r3;
        a r2 = new a(this);
        TabLayout r7 = new TabLayout(r11);
        r7.setMinimumHeight(c7.b(32));
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-1, -2);
        int r5 = c7.b(12);
        r8.setMargins(r5, 0, r5, 0);
        r7.setLayoutParams(r8);
        r7.setTabMode(1);
        r7.setTabGravity(0);
        r7.setSelectedTabIndicatorColor(ContextCompat.getColor(r11, v19.c.b(2130972079, r11, 2131103136)));
        r7.setTabTextColors(ContextCompat.getColor(r11, v19.c.b(2130972081, r11, 2131103143)), ContextCompat.getColor(r11, v19.c.b(2130972079, r11, 2131103136)));
        r7.setTabIndicatorFullWidth(true);
        r7.setTabRippleColor(ColorStateList.valueOf(0));
        r7.addOnTabSelectedListener(r2);
        this.i = r7;
        ?? r4 = new NestedDynamicPageView$pageChangeCallback$1(this);
        this.j = r4;
        ViewPager2 r9 = new ViewPager2(r11);
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-1, -1);
        r15.topMargin = c7.b(24);
        r9.setLayoutParams(r15);
        r9.setNestedScrollingEnabled(true);
        r9.registerOnPageChangeCallback(r4);
        this.k = r9;
        addView(r14);
        r14.addView(r0);
        r14.addView(r3);
        r14.addView(r7);
        r14.addView(r9);
        setNestedScrollingEnabled(true);
        setOverScrollMode(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [com.larus.dora.impl.dynamic.widget.NestedDynamicPageView] */
    /* JADX WARN: Type inference failed for: r10v13, types: [com.larus.dora.impl.dynamic.widget.NestedDynamicPageView] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15, types: [android.widget.FrameLayout, com.larus.dora.impl.dynamic.widget.NestedDynamicPageView] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a0 -> B:28:0x00a3). Please report as a decompilation issue!!! */
    public final Object e(c59.m r9, e59.b r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof NestedDynamicPageView$setPageInfo$1) == false) goto L7;
        NestedDynamicPageView$setPageInfo$1 r0 = (NestedDynamicPageView$setPageInfo$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Iterator<e0> r13 = (Iterator) r0.L$0;
        ResultKt.throwOnFailure(r12);
        ?? r14 = this;
    L28:
        f0 r15 = (f0) r12;
        if (r15 == null) goto L34;
        t r16 = r15.a();
        if (r16 == null) goto L34;
        String r17 = p.b(r16);
        if (r17 == null) goto L34;
    L35:
        TabLayout.Tab r4 = r14.i.newTab();
        View r6 = LayoutInflater.from(r14.getContext()).inflate(2131562300, null);
        ((TextView) r6.findViewById(2131388514)).setText(r17);
        r14.i.addTab(r4.setCustomView(r6));
        ?? r18 = r14;
    L23:
        ?? r110 = r18;
        if (r13.hasNext() == false) goto L37;
        e0 r111 = r13.next();
        CoroutineDispatcher r5 = Dispatchers.getIO();
        NestedDynamicPageView$setPageInfo$2$tabConfig$1 r7 = new NestedDynamicPageView$setPageInfo$2$tabConfig$1(r111, null);
        r0.L$0 = r13;
        r0.label = 1;
        r12 = BuildersKt.withContext(r5, r7, r0);
        r14 = r18;
        if (r12 != r2) goto L28;
        return r2;
    L37:
        int r20 = RangesKt.coerceIn(r110.k.getCurrentItem(), 0, RangesKt.coerceAtLeast(r110.i.getTabCount() - 1, 0));
        int r112 = r110.i.getTabCount();
        ?? r113 = r110;
        if (r112 > 0) goto L40;
    L46:
        RecyclerView.Adapter r21 = r113.k.getAdapter();
        if (r21 == null) goto L49;
        int r22 = r21.getItemCount();
    L50:
        int r114 = 0;
    L51:
        if (r114 >= r22) goto L63;
        DoraDynamicPagerAdapter r8 = r113.k.getAdapter();
        if ((r8 instanceof DoraDynamicPagerAdapter) == false) goto L55;
        DoraDynamicPagerAdapter r23 = r8;
    L56:
        if (r23 == null) goto L62;
        DoraDynamicListFragment r24 = r23.y2(r114);
        if (r24 == null) goto L62;
        RecyclerView r25 = r24.f;
        if (r25 == null) goto L62;
        r25.scrollToPosition(0);
    L62:
        r114 = r114 + 1;
        goto L51
    L55:
        r23 = null;
        goto L56
    L63:
        r113.g.scrollToPosition(0);
        return Unit.INSTANCE;
    L49:
        r22 = 0;
        goto L50
    L40:
        if (r110.k.getCurrentItem() == r20) goto L42;
        r110.k.setCurrentItem(r20, false);
    L42:
        TabLayout.Tab r26 = r110.i.getTabAt(r20);
        r113 = r110;
        if (r26 == null) goto L46;
        r26.select();
        r113 = r110;
    L34:
        r17 = "";
        goto L35
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        n r27 = (n) CollectionsKt.getOrNull(r9.b, !(r10 instanceof e59.b.a) ? 1 : 0);
        if (r27 == null) goto L45;
        List<e0> r115 = r27.b;
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
        Iterator r117 = r115.iterator();
    L18:
        if (r117.hasNext() == false) goto L21;
        r116.add(((e0) r117.next()).a);
        goto L18
    L21:
        if (Intrinsics.areEqual(this.a, r116) == true) goto L36;
        this.a = r116;
        this.i.removeAllTabs();
        r13 = r27.b.iterator();
        r18 = this;
        goto L23
    L36:
        r110 = this;
        goto L37
    L45:
        r113 = this;
    L7:
        r0 = new NestedDynamicPageView$setPageInfo$1(this, r11);
        goto L8
    }

    public /* synthetic */ NestedDynamicPageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void onNestedScrollAccepted(View r2, View r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "target");
        super.onNestedScrollAccepted(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        int r5 = getHeaderHeight();
        if (r2 < r5) goto L5;
        boolean r6 = true;
    L6:
        this.l = r6;
        if (r2 <= r5) goto L9;
        setScrollY(r5);
        return;
    L9:
        if (r2 >= 0) goto L13;
        setScrollY(0);
        return;
    L13:
        return;
    L5:
        r6 = false;
        goto L6
    }

    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        LinearLayout r6 = this.f;
        r6.layout(0, 0, r6.getMeasuredWidth(), this.f.getMeasuredHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNestedPreScroll(View r2, int r3, int r4, int[] r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r5, "consumed");
        r5[0] = 0;
        if (this.l == false) goto L5;
        r5[1] = 0;
    L9:
        int r7 = r5[1];
        if (r7 == 0) goto L13;
        scrollBy(0, r7);
        return;
    L13:
        return;
    L5:
        int r8 = getHeaderHeight();
        if (r4 >= 0) goto L8;
        r5[1] = RangesKt.coerceAtLeast(r4, -getScrollY());
        goto L9
    L8:
        r5[1] = RangesKt.coerceAtMost(r4, r8 - getScrollY());
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, "target");
        if (r5 == 0) goto L6;
        int r7 = getHeaderHeight();
        scrollTo(0, RangesKt.coerceIn(getScrollY() + r5, 0, r7));
        return;
    }
}
