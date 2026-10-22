package com.google.android.material.tabs;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class TabLayoutMediator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TabLayout f4128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewPager2 f4129b;
    private final boolean c;
    private final boolean d;
    private final a e;
    private RecyclerView.Adapter<?> f;
    private boolean g;
    private TabLayoutOnPageChangeCallback h;
    private TabLayout.b i;
    private RecyclerView.AdapterDataObserver j;

    private class PagerAdapterObserver extends RecyclerView.AdapterDataObserver {
        final /* synthetic */ TabLayoutMediator this$0;

        PagerAdapterObserver(TabLayoutMediator r1) {
            this.this$0 = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            this.this$0.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r1, int r2) {
            this.this$0.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r1, int r2, Object r3) {
            this.this$0.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int r1, int r2) {
            this.this$0.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int r1, int r2, int r3) {
            this.this$0.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int r1, int r2) {
            this.this$0.b();
        }
    }

    private static class TabLayoutOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        private int previousScrollState;
        private int scrollState;
        private final WeakReference<TabLayout> tabLayoutRef;

        TabLayoutOnPageChangeCallback(TabLayout r2) {
            this.tabLayoutRef = new WeakReference(r2);
            reset();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int r2) {
            this.previousScrollState = this.scrollState;
            this.scrollState = r2;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int r6, float r7, int r8) {
            TabLayout r9 = (TabLayout) ZeusTransformUtils.preCheckCast(this.tabLayoutRef.get(), TabLayout.class, "com.obric.memorydata.plugin");
            if (r9 == null) goto L17;
            int r0 = this.scrollState;
            boolean r1 = false;
            if (r0 == 2) goto L7;
        L10:
            boolean r4 = true;
        L11:
            if (r0 == 2) goto L13;
        L14:
            r1 = true;
        L15:
            r9.a(r6, r7, r4, r1);
            return;
        L13:
            if (this.previousScrollState == 0) goto L15;
        L7:
            if (this.previousScrollState == 1) goto L10;
            r4 = false;
            goto L11
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int r4) {
            TabLayout r0 = (TabLayout) ZeusTransformUtils.preCheckCast(this.tabLayoutRef.get(), TabLayout.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r4) goto L7;
            return;
        L7:
            if (r4 >= r0.getTabCount()) goto L21;
            int r1 = this.scrollState;
            if (r1 != 0) goto L11;
        L16:
            boolean r3 = true;
        L17:
            r0.b(r0.a(r4), r3);
            return;
        L11:
            if (r1 == 2) goto L13;
        L15:
            r3 = false;
            goto L17
        L13:
            if (this.previousScrollState != 0) goto L15;
        }

        void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    public interface a {
        void onConfigureTab(TabLayout.e r1, int r2);
    }

    private static class b implements TabLayout.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewPager2 f4130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f4131b;

        b(ViewPager2 r1, boolean r2) {
            this.f4130a = r1;
            this.f4131b = r2;
        }

        @Override // com.google.android.material.tabs.TabLayout.a
        public void a(TabLayout.e r2) {
            this.f4130a.setCurrentItem(r2.c(), this.f4131b);
        }

        @Override // com.google.android.material.tabs.TabLayout.a
        public void b(TabLayout.e r1) {
        }

        @Override // com.google.android.material.tabs.TabLayout.a
        public void c(TabLayout.e r1) {
        }
    }

    public TabLayoutMediator(TabLayout r3, ViewPager2 r4, a r5) {
        this(r3, r4, true, (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin"));
    }

    public TabLayoutMediator(TabLayout r7, ViewPager2 r8, boolean r9, a r10) {
        this(r7, r8, r9, true, (a) ZeusTransformUtils.wrapperContextForParams(r10, a.class, "com.obric.memorydata.plugin"));
    }

    public TabLayoutMediator(TabLayout r3, ViewPager2 r4, boolean r5, boolean r6, a r7) {
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.memorydata.plugin");
        this.f4128a = r3;
        this.f4129b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r8;
    }

    public void a() {
        if (this.g == true) goto L14;
        RecyclerView.Adapter<?> r0 = this.f4129b.getAdapter();
        this.f = r0;
        if (r0 == null) goto L12;
        this.g = true;
        TabLayoutOnPageChangeCallback r1 = new TabLayoutOnPageChangeCallback(this.f4128a);
        this.h = r1;
        this.f4129b.registerOnPageChangeCallback(r1);
        b r2 = new b(this.f4129b, this.d);
        this.i = r2;
        this.f4128a.a(r2);
        if (this.c == false) goto L9;
        PagerAdapterObserver r3 = new PagerAdapterObserver(this);
        this.j = r3;
        this.f.registerAdapterDataObserver(r3);
    L9:
        b();
        this.f4128a.a(this.f4129b.getCurrentItem(), 0.0f, true);
        return;
    L12:
        throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
    L14:
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    void b() {
        this.f4128a.c();
        RecyclerView.Adapter<?> r0 = this.f;
        if (r0 == null) goto L13;
        int r1 = r0.getItemCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        TabLayout.e r3 = this.f4128a.a();
        this.e.onConfigureTab(r3, r2);
        this.f4128a.a(r3, false);
        r2 = r2 + 1;
        goto L5
    L7:
        if (r1 <= 0) goto L14;
        int r4 = Math.min(this.f4129b.getCurrentItem(), this.f4128a.getTabCount() - 1);
        if (r4 == this.f4128a.getSelectedTabPosition()) goto L15;
        TabLayout r5 = this.f4128a;
        r5.c(r5.a(r4));
        return;
    L15:
        return;
    L14:
        return;
    }
}
