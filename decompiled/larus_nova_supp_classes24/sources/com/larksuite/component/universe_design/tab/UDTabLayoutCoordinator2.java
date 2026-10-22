package com.larksuite.component.universe_design.tab;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UDTabLayoutCoordinator2 {
    public final UDTabLayout a;
    public final ViewPager2 b;
    public final a c;
    public boolean d;
    public final UDTabLayoutCoordinator2$onPageChangeCallback$1 e;
    public final b f;
    public final UDTabLayoutCoordinator2$pagerAdapterObserver$1 g;

    public interface a {
        void a(int r1, com.larksuite.component.universe_design.tab.b r2);
    }

    public static final class b implements UDTabLayout.b {
        public final /* synthetic */ UDTabLayoutCoordinator2 a;

        @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
        public final void a(com.larksuite.component.universe_design.tab.b r2) {
            Intrinsics.checkNotNullParameter(r2, "tab");
        }

        @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
        public final void c(com.larksuite.component.universe_design.tab.b r2) {
            Intrinsics.checkNotNullParameter(r2, "tab");
        }

        public b(UDTabLayoutCoordinator2 r1) {
            this.a = r1;
        }

        @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
        public final void b(com.larksuite.component.universe_design.tab.b r2) {
            Intrinsics.checkNotNullParameter(r2, "tab");
            int r0 = this.a.b.getCurrentItem();
            int r3 = r2.f;
            if (r0 == r3) goto L6;
            this.a.b.setCurrentItem(r3);
            return;
        }
    }

    public final void a() {
        if ((!this.d) == false) goto L14;
        if (this.b.getAdapter() == null) goto L12;
        this.d = true;
        this.a.addOnTabSelectedListener(this.f);
        this.b.registerOnPageChangeCallback(this.e);
        RecyclerView.Adapter r0 = this.b.getAdapter();
        if (r0 == null) goto L9;
        r0.registerAdapterDataObserver(this.g);
    L9:
        b();
        return;
    L12:
        throw new IllegalStateException("UDTabLayoutCoordinator2 attached before viewPager2 has an adapter".toString());
    L14:
        throw new IllegalStateException("UDTabLayoutCoordinator2 is already attached".toString());
    }

    public final void b() {
        this.a.removeAllTabs();
        RecyclerView.Adapter r0 = this.b.getAdapter();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.getItemCount();
        int r2 = this.b.getCurrentItem();
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L8;
        com.larksuite.component.universe_design.tab.b r4 = this.a.newTab();
        this.c.a(r3, r4);
        this.a.addTab(r4);
        r3 = r3 + 1;
        goto L6
    L8:
        if (r1 <= 0) goto L14;
        if (r2 >= r1) goto L15;
        if (r2 < 0) goto L16;
        this.a.selectTabAt$universe_ui_tab_release(r2, true);
        return;
    L16:
        return;
    L15:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator2$onPageChangeCallback$1] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator2$pagerAdapterObserver$1] */
    public UDTabLayoutCoordinator2(UDTabLayout r2, ViewPager2 r3, a r4) {
        Intrinsics.checkNotNullParameter(r2, "tabLayout");
        Intrinsics.checkNotNullParameter(r3, "viewPager");
        Intrinsics.checkNotNullParameter(r4, "tabConfig");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = new UDTabLayoutCoordinator2$onPageChangeCallback$1(this);
        this.f = new b(this);
        this.g = new UDTabLayoutCoordinator2$pagerAdapterObserver$1(this);
    }
}
