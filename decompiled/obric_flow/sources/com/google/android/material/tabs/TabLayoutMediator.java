package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class TabLayoutMediator {

    @Nullable
    private RecyclerView.Adapter<?> adapter;
    private boolean attached;
    private final boolean autoRefresh;

    @Nullable
    private TabLayoutOnPageChangeCallback onPageChangeCallback;

    @Nullable
    private TabLayout.OnTabSelectedListener onTabSelectedListener;

    @Nullable
    private RecyclerView.AdapterDataObserver pagerAdapterObserver;
    private final boolean smoothScroll;
    private final TabConfigurationStrategy tabConfigurationStrategy;

    @NonNull
    private final TabLayout tabLayout;

    @NonNull
    private final ViewPager2 viewPager;

    public class PagerAdapterObserver extends RecyclerView.AdapterDataObserver {
        final /* synthetic */ TabLayoutMediator this$0;

        public PagerAdapterObserver(TabLayoutMediator r5) {
            this.this$0 = r5;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            this.this$0.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r5, int r10) {
            this.this$0.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int r5, int r10) {
            this.this$0.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int r5, int r10, int r11) {
            this.this$0.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int r5, int r10) {
            this.this$0.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r5, int r10, @Nullable Object r11) {
            this.this$0.populateTabsFromPagerAdapter();
        }
    }

    public interface TabConfigurationStrategy {
        void onConfigureTab(@NonNull TabLayout.Tab r5, int r10);
    }

    public static class TabLayoutOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        private int previousScrollState;
        private int scrollState;

        @NonNull
        private final WeakReference<TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeCallback(TabLayout r5) {
            this.tabLayoutRef = new WeakReference(r5);
            reset();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int r5) {
            this.previousScrollState = this.scrollState;
            this.scrollState = r5;
            TabLayout r10 = this.tabLayoutRef.get();
            if (r10 == null) goto L6;
            r10.updateViewPagerScrollState(this.scrollState);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int r10, float r11, int r12) {
            TabLayout r5 = this.tabLayoutRef.get();
            if (r5 == null) goto L19;
            int r13 = this.scrollState;
            if (r13 == 2) goto L7;
        L10:
            boolean r14 = true;
        L11:
            if (r13 == 2) goto L13;
        L16:
            boolean r15 = true;
        L17:
            r5.setScrollPosition(r10, r11, r14, r15, false);
            return;
        L13:
            if (this.previousScrollState != 0) goto L16;
            r15 = false;
            goto L17
        L7:
            if (this.previousScrollState == 1) goto L10;
            r14 = false;
            goto L11
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int r5) {
            TabLayout r10 = this.tabLayoutRef.get();
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.getSelectedTabPosition() != r5) goto L7;
            return;
        L7:
            if (r5 >= r10.getTabCount()) goto L21;
            int r11 = this.scrollState;
            if (r11 != 0) goto L11;
        L16:
            boolean r12 = true;
        L17:
            r10.selectTab(r10.getTabAt(r5), r12);
            return;
        L11:
            if (r11 == 2) goto L13;
        L15:
            r12 = false;
            goto L17
        L13:
            if (this.previousScrollState != 0) goto L15;
        }

        public void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    public static class ViewPagerOnTabSelectedListener implements TabLayout.OnTabSelectedListener {
        private final boolean smoothScroll;
        private final ViewPager2 viewPager;

        public ViewPagerOnTabSelectedListener(ViewPager2 r5, boolean r10) {
            this.viewPager = r5;
            this.smoothScroll = r10;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab r5) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@NonNull TabLayout.Tab r5) {
            this.viewPager.setCurrentItem(r5.getPosition(), this.smoothScroll);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab r5) {
        }
    }

    public TabLayoutMediator(@NonNull TabLayout r5, @NonNull ViewPager2 r10, @NonNull TabConfigurationStrategy r11) {
        this(r5, r10, true, r11);
    }

    public void attach() {
        if (this.attached == true) goto L14;
        RecyclerView.Adapter<?> r5 = this.viewPager.getAdapter();
        this.adapter = r5;
        if (r5 == null) goto L12;
        this.attached = true;
        TabLayoutOnPageChangeCallback r10 = new TabLayoutOnPageChangeCallback(this.tabLayout);
        this.onPageChangeCallback = r10;
        this.viewPager.registerOnPageChangeCallback(r10);
        ViewPagerOnTabSelectedListener r11 = new ViewPagerOnTabSelectedListener(this.viewPager, this.smoothScroll);
        this.onTabSelectedListener = r11;
        this.tabLayout.addOnTabSelectedListener(r11);
        if (this.autoRefresh == false) goto L9;
        PagerAdapterObserver r12 = new PagerAdapterObserver(this);
        this.pagerAdapterObserver = r12;
        this.adapter.registerAdapterDataObserver(r12);
    L9:
        populateTabsFromPagerAdapter();
        this.tabLayout.setScrollPosition(this.viewPager.getCurrentItem(), 0.0f, true);
        return;
    L12:
        throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
    L14:
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public void detach() {
        if (this.autoRefresh == false) goto L7;
        RecyclerView.Adapter<?> r5 = this.adapter;
        if (r5 == null) goto L7;
        r5.unregisterAdapterDataObserver(this.pagerAdapterObserver);
        this.pagerAdapterObserver = null;
    L7:
        this.tabLayout.removeOnTabSelectedListener(this.onTabSelectedListener);
        this.viewPager.unregisterOnPageChangeCallback(this.onPageChangeCallback);
        this.onTabSelectedListener = null;
        this.onPageChangeCallback = null;
        this.adapter = null;
        this.attached = false;
    }

    public boolean isAttached() {
        return this.attached;
    }

    public void populateTabsFromPagerAdapter() {
        this.tabLayout.removeAllTabs();
        RecyclerView.Adapter<?> r5 = this.adapter;
        if (r5 == null) goto L13;
        int r10 = r5.getItemCount();
        int r11 = 0;
    L5:
        if (r11 >= r10) goto L7;
        TabLayout.Tab r12 = this.tabLayout.newTab();
        this.tabConfigurationStrategy.onConfigureTab(r12, r11);
        this.tabLayout.addTab(r12, false);
        r11 = r11 + 1;
        goto L5
    L7:
        if (r10 <= 0) goto L14;
        int r13 = Math.min(this.viewPager.getCurrentItem(), this.tabLayout.getTabCount() - 1);
        if (r13 == this.tabLayout.getSelectedTabPosition()) goto L15;
        TabLayout r14 = this.tabLayout;
        r14.selectTab(r14.getTabAt(r13));
        return;
    L15:
        return;
    L14:
        return;
    }

    public TabLayoutMediator(@NonNull TabLayout r10, @NonNull ViewPager2 r11, boolean r12, @NonNull TabConfigurationStrategy r13) {
        this(r10, r11, r12, true, r13);
    }

    public TabLayoutMediator(@NonNull TabLayout r5, @NonNull ViewPager2 r10, boolean r11, boolean r12, @NonNull TabConfigurationStrategy r13) {
        this.tabLayout = r5;
        this.viewPager = r10;
        this.autoRefresh = r11;
        this.smoothScroll = r12;
        this.tabConfigurationStrategy = r13;
    }
}
