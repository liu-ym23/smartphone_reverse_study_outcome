package u2c;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final TabLayout a;
    public final ViewPager2 b;
    public final b c;
    public RecyclerView.Adapter<?> d;
    public boolean e;
    public c f;
    public d g;
    public C0197a h;

    /* JADX INFO: renamed from: u2c.a$a, reason: collision with other inner class name */
    public class C0197a extends RecyclerView.AdapterDataObserver {
        public final /* synthetic */ a a;

        public final void onChanged() {
            this.a.c();
        }

        public C0197a(a r1) {
            this.a = r1;
        }

        public final void onItemRangeChanged(int r1, int r2) {
            this.a.c();
        }

        public final void onItemRangeInserted(int r1, int r2) {
            this.a.c();
        }

        public final void onItemRangeRemoved(int r1, int r2) {
            this.a.c();
        }

        public final void onItemRangeChanged(int r1, int r2, Object r3) {
            this.a.c();
        }

        public final void onItemRangeMoved(int r1, int r2, int r3) {
            this.a.c();
        }
    }

    public interface b {
        void a(TabLayout.Tab r1, int r2);
    }

    public static class c extends ViewPager2.OnPageChangeCallback {
        public final WeakReference<TabLayout> a;
        public int b;
        public int c;

        public c(TabLayout r2) {
            this.a = new WeakReference(r2);
            this.c = 0;
            this.b = 0;
        }

        public final void onPageScrollStateChanged(int r2) {
            this.b = this.c;
            this.c = r2;
        }

        public final void onPageSelected(int r10) {
            TabLayout r0 = this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r10) goto L7;
            return;
        L7:
            if (r10 >= r0.getTabCount()) goto L26;
            int r1 = this.c;
            if (r1 == 0) goto L15;
            if (r1 == 2) goto L12;
        L14:
            boolean r2 = false;
        L16:
            TabLayout.Tab r11 = r0.getTabAt(r10);
            Method r5 = TabLayout.class.getDeclaredMethod("selectTab", new Class[]{TabLayout.Tab.class, Boolean.TYPE});     // Catch: Exception -> L19
            r5.setAccessible(true);     // Catch: Exception -> L19
            r5.invoke(r0, new Object[]{r11, Boolean.valueOf(r2)});     // Catch: Exception -> L19
            return;
        L19:
            e = move-exception;
            e.printStackTrace();
            return;
        L12:
            if (this.b != 0) goto L14;
        L15:
            r2 = true;
            goto L16
        }

        public final void onPageScrolled(int r12, float r13, int r14) {
            TabLayout r15 = this.a.get();
            if (r15 == null) goto L24;
            int r0 = this.c;
            if (r0 == 2) goto L7;
        L10:
            boolean r4 = true;
        L11:
            if (r0 == 2) goto L13;
        L16:
            boolean r1 = true;
        L22:
            Class r9 = Boolean.TYPE;     // Catch: Exception -> L19
            Method r5 = TabLayout.class.getDeclaredMethod("setScrollPosition", new Class[]{Integer.TYPE, Float.TYPE, r9, r9});     // Catch: Exception -> L19
            r5.setAccessible(true);     // Catch: Exception -> L19
            r5.invoke(r15, new Object[]{Integer.valueOf(r12), Float.valueOf(r13), Boolean.valueOf(r4), Boolean.valueOf(r1)});     // Catch: Exception -> L19
            return;
        L19:
            e = move-exception;
            e.printStackTrace();
            return;
        L13:
            if (this.b != 0) goto L16;
            r1 = false;
            goto L22
        L7:
            if (this.b == 1) goto L10;
            r4 = false;
            goto L11
        }
    }

    public static class d implements TabLayout.BaseOnTabSelectedListener {
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
        if (this.e == true) goto L11;
        RecyclerView.Adapter<?> r0 = this.b.getAdapter();
        this.d = r0;
        if (r0 == null) goto L9;
        this.e = true;
        c r1 = new c(this.a);
        this.f = r1;
        this.b.registerOnPageChangeCallback(r1);
        d r2 = new d(this.b, true);
        this.g = r2;
        this.a.addOnTabSelectedListener(r2);
        C0197a r3 = new C0197a(this);
        this.h = r3;
        this.d.registerAdapterDataObserver(r3);
        c();
        this.a.setScrollPosition(this.b.getCurrentItem(), 0.0f, true);
        return;
    L9:
        throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
    L11:
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public final void b() {
        RecyclerView.Adapter<?> r0 = this.d;
        if (r0 == null) goto L5;
        r0.unregisterAdapterDataObserver(this.h);
        this.h = null;
    L5:
        this.a.removeOnTabSelectedListener(this.g);
        this.b.unregisterOnPageChangeCallback(this.f);
        this.g = null;
        this.f = null;
        this.d = null;
        this.e = false;
    }

    public final void c() {
        this.a.removeAllTabs();
        RecyclerView.Adapter<?> r0 = this.d;
        if (r0 == null) goto L19;
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
        if (r1 <= 0) goto L20;
        int r4 = Math.min(this.b.getCurrentItem(), this.a.getTabCount() - 1);
        if (r4 == this.a.getSelectedTabPosition()) goto L21;
        TabLayout r5 = this.a;
        TabLayout.Tab r6 = r5.getTabAt(r4);
        Method r7 = TabLayout.class.getDeclaredMethod("selectTab", new Class[]{TabLayout.Tab.class});     // Catch: Exception -> L13
        r7.setAccessible(true);     // Catch: Exception -> L13
        r7.invoke(r5, new Object[]{r6});     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        return;
    L20:
        return;
    }

    public a(TabLayout r1, ViewPager2 r2, b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
