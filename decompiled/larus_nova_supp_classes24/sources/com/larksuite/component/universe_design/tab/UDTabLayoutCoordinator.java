package com.larksuite.component.universe_design.tab;

import android.database.DataSetObserver;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0004\u0010\u0013\u0016\u0019\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/larksuite/component/universe_design/tab/UDTabLayoutCoordinator;", "", "tabLayout", "Lcom/larksuite/component/universe_design/tab/UDTabLayout;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "<init>", "(Lcom/larksuite/component/universe_design/tab/UDTabLayout;Landroidx/viewpager/widget/ViewPager;)V", "attached", "", "attach", "", "detach", "setupPagerAdapter", "setupTabsWithPagerAdapter", "onViewPagerPageChangeListener", "com/larksuite/component/universe_design/tab/UDTabLayoutCoordinator$onViewPagerPageChangeListener$1", "Lcom/larksuite/component/universe_design/tab/UDTabLayoutCoordinator$onViewPagerPageChangeListener$1;", "onTabSelectedListener", "com/larksuite/component/universe_design/tab/UDTabLayoutCoordinator$onTabSelectedListener$1", "Lcom/larksuite/component/universe_design/tab/UDTabLayoutCoordinator$onTabSelectedListener$1;", "viewPagerAdapterDataSetObserver", "com/larksuite/component/universe_design/tab/UDTabLayoutCoordinator$viewPagerAdapterDataSetObserver$1", "Lcom/larksuite/component/universe_design/tab/UDTabLayoutCoordinator$viewPagerAdapterDataSetObserver$1;", "viewPagerAdapterChangeListener", "com/larksuite/component/universe_design/tab/UDTabLayoutCoordinator$viewPagerAdapterChangeListener$1", "Lcom/larksuite/component/universe_design/tab/UDTabLayoutCoordinator$viewPagerAdapterChangeListener$1;", "universe-ui-tab_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UDTabLayoutCoordinator {
    private boolean attached;
    private final a onTabSelectedListener;
    private final UDTabLayoutCoordinator$onViewPagerPageChangeListener$1 onViewPagerPageChangeListener;
    private final UDTabLayout tabLayout;
    private final ViewPager viewPager;
    private final UDTabLayoutCoordinator$viewPagerAdapterChangeListener$1 viewPagerAdapterChangeListener;
    private final b viewPagerAdapterDataSetObserver;

    public static final class a implements UDTabLayout.b {
        public final /* synthetic */ UDTabLayoutCoordinator a;

        @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
        public final void a(com.larksuite.component.universe_design.tab.b r2) {
            Intrinsics.checkNotNullParameter(r2, "tab");
        }

        @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
        public final void c(com.larksuite.component.universe_design.tab.b r2) {
            Intrinsics.checkNotNullParameter(r2, "tab");
        }

        public a(UDTabLayoutCoordinator r1) {
            this.a = r1;
        }

        @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
        public final void b(com.larksuite.component.universe_design.tab.b r3) {
            Intrinsics.checkNotNullParameter(r3, "tab");
            if (UDTabLayoutCoordinator.access$getViewPager$p(this.a).getCurrentItem() == r3.f) goto L6;
            UDTabLayoutCoordinator.access$getViewPager$p(this.a).setCurrentItem(r3.f);
            return;
        }
    }

    public static final class b extends DataSetObserver {
        public final /* synthetic */ UDTabLayoutCoordinator a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            UDTabLayoutCoordinator.access$setupTabsWithPagerAdapter(this.a);
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            UDTabLayoutCoordinator.access$setupTabsWithPagerAdapter(this.a);
        }

        public b(UDTabLayoutCoordinator r1) {
            this.a = r1;
        }
    }

    private final void setupPagerAdapter() {
        PagerAdapter r0 = this.viewPager.getAdapter();
        if (r0 == null) goto L5;
        r0.registerDataSetObserver(this.viewPagerAdapterDataSetObserver);
    L5:
        setupTabsWithPagerAdapter();
    }

    private final void setupTabsWithPagerAdapter() {
        PagerAdapter r0 = this.viewPager.getAdapter();
        if (r0 != null) goto L6;
        this.tabLayout.removeAllTabs();
        return;
    L6:
        int r1 = r0.getCount();
        int r3 = 0;
        if (r1 != this.tabLayout.getTabCount()) goto L10;
    L8:
        if (r3 >= r1) goto L23;
        this.tabLayout.getTabAt(r3).b(r0.getPageTitle(r3));
        r3 = r3 + 1;
        goto L8
    L23:
        return;
    L10:
        this.tabLayout.removeAllTabs();
        int r2 = this.viewPager.getCurrentItem();
    L11:
        if (r3 >= r1) goto L13;
        com.larksuite.component.universe_design.tab.b r4 = this.tabLayout.newTab();
        r4.b(r0.getPageTitle(r3));
        this.tabLayout.addTab(r4);
        r3 = r3 + 1;
        goto L11
    L13:
        if (r1 <= 0) goto L20;
        if (r2 >= r1) goto L21;
        if (r2 < 0) goto L22;
        this.tabLayout.selectTabAt$universe_ui_tab_release(r2, true);
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void attach() {
        if ((!this.attached) == false) goto L7;
        this.attached = true;
        this.viewPager.addOnPageChangeListener(this.onViewPagerPageChangeListener);
        this.tabLayout.addOnTabSelectedListener(this.onTabSelectedListener);
        this.viewPager.addOnAdapterChangeListener(this.viewPagerAdapterChangeListener);
        setupPagerAdapter();
        return;
    L7:
        throw new IllegalStateException("UDTabLayoutCoordinator is already attached".toString());
    }

    public final void detach() {
        this.viewPager.removeOnPageChangeListener(this.onViewPagerPageChangeListener);
        this.tabLayout.removeOnTabSelectedListener(this.onTabSelectedListener);
        PagerAdapter r0 = this.viewPager.getAdapter();
        if (r0 == null) goto L5;
        r0.unregisterDataSetObserver(this.viewPagerAdapterDataSetObserver);
    L5:
        this.tabLayout.removeAllTabs();
        this.attached = false;
    }

    public static final /* synthetic */ UDTabLayout access$getTabLayout$p(UDTabLayoutCoordinator r0) {
        return r0.tabLayout;
    }

    public static final /* synthetic */ ViewPager access$getViewPager$p(UDTabLayoutCoordinator r0) {
        return r0.viewPager;
    }

    public static final /* synthetic */ b access$getViewPagerAdapterDataSetObserver$p(UDTabLayoutCoordinator r0) {
        return r0.viewPagerAdapterDataSetObserver;
    }

    public static final /* synthetic */ void access$setupPagerAdapter(UDTabLayoutCoordinator r0) {
        r0.setupPagerAdapter();
    }

    public static final /* synthetic */ void access$setupTabsWithPagerAdapter(UDTabLayoutCoordinator r0) {
        r0.setupTabsWithPagerAdapter();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator$onViewPagerPageChangeListener$1] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator$viewPagerAdapterChangeListener$1] */
    public UDTabLayoutCoordinator(UDTabLayout r2, ViewPager r3) {
        Intrinsics.checkNotNullParameter(r2, "tabLayout");
        Intrinsics.checkNotNullParameter(r3, "viewPager");
        this.tabLayout = r2;
        this.viewPager = r3;
        this.onViewPagerPageChangeListener = new UDTabLayoutCoordinator$onViewPagerPageChangeListener$1(this);
        this.onTabSelectedListener = new a(this);
        this.viewPagerAdapterDataSetObserver = new b(this);
        this.viewPagerAdapterChangeListener = new UDTabLayoutCoordinator$viewPagerAdapterChangeListener$1(this);
    }
}
