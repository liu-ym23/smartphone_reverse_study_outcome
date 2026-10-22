package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m {
    public final TabLayout a;
    public final ViewPager2 b;
    public final b c;
    public RecyclerView.Adapter<?> d;
    public boolean e;
    public c f;
    public d g;
    public a h;

    public class a extends RecyclerView.AdapterDataObserver {
        public final /* synthetic */ m a;

        public final void onChanged() {
            this.a.a();
        }

        public a(m r1) {
            this.a = r1;
        }

        public final void onItemRangeChanged(int r1, int r2) {
            this.a.a();
        }

        public final void onItemRangeInserted(int r1, int r2) {
            this.a.a();
        }

        public final void onItemRangeRemoved(int r1, int r2) {
            this.a.a();
        }

        public final void onItemRangeChanged(int r1, int r2, Object r3) {
            this.a.a();
        }

        public final void onItemRangeMoved(int r1, int r2, int r3) {
            this.a.a();
        }
    }

    public interface b {
        void a(TabLayout.Tab r1, int r2);

        void b(int r1);
    }

    public static class c extends ViewPager2.OnPageChangeCallback {
        public final WeakReference<TabLayout> a;
        public final b b;
        public int c;
        public int d;

        public final void onPageScrollStateChanged(int r2) {
            this.c = this.d;
            this.d = r2;
        }

        public final void onPageSelected(int r4) {
            TabLayout r0 = this.a.get();
            if (r0 != null) goto L5;
        L14:
            this.b.b(r4);
            return;
        L5:
            if (r0.getSelectedTabPosition() == r4) goto L14;
            if (r4 >= r0.getTabCount()) goto L14;
            if (this.d != 0) goto L11;
        L11:
            TabLayout.Tab r1 = r0.getTabAt(r4);
            if (r1 == null) goto L14;
            r1.select();
            goto L14
        }

        public c(TabLayout r2, b r3) {
            this.a = new WeakReference(r2);
            this.b = r3;
            this.d = 0;
            this.c = 0;
        }

        public final void onPageScrolled(int r4, float r5, int r6) {
            TabLayout r7 = this.a.get();
            if (r7 == null) goto L12;
            boolean r2 = true;
            if (this.d == 2) goto L7;
        L10:
            r7.setScrollPosition(r4, r5, r2);
            return;
        L7:
            if (this.c == 1) goto L10;
            r2 = false;
            goto L10
        }
    }

    public static class d implements TabLayout.OnTabSelectedListener {
        public final ViewPager2 a;
        public final boolean b;

        public final void onTabReselected(TabLayout.Tab r1) {
        }

        public final void onTabUnselected(TabLayout.Tab r1) {
        }

        public final void onTabSelected(TabLayout.Tab r3) {
            this.a.setCurrentItem(r3.getPosition(), this.b);
        }

        public d(ViewPager2 r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final void a() {
        this.a.removeAllTabs();
        RecyclerView.Adapter<?> r0 = this.d;
        if (r0 == null) goto L15;
        int r1 = r0.getItemCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        TabLayout.Tab r3 = this.a.newTab();
        this.c.a(r3, r2);
        this.a.addTab(r3, false);
        r2 = r2 + 1;
        goto L5
    L7:
        if (r1 <= 0) goto L16;
        int r4 = Math.min(this.b.getCurrentItem(), this.a.getTabCount() - 1);
        if (r4 == this.a.getSelectedTabPosition()) goto L17;
        TabLayout.Tab r5 = this.a.getTabAt(r4);
        if (r5 == null) goto L18;
        r5.select();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public m(TabLayout r1, ViewPager2 r2, ProfileTabsComponent.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
