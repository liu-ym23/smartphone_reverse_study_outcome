package com.obric.oui.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import com.bytedance.apm.util.f;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends RecyclerView.Adapter<com.obric.oui.viewpager2.adapter.c> implements com.obric.oui.viewpager2.adapter.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LongSparseArray<Fragment.SavedState> f14838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Lifecycle f14839b;
    final FragmentManager c;
    final LongSparseArray<Fragment> d;
    b e;
    boolean f;
    private final LongSparseArray<Integer> g;
    private c h;
    private boolean i;

    /* JADX INFO: renamed from: com.obric.oui.viewpager2.adapter.a$a, reason: collision with other inner class name */
    private static abstract class AbstractC0792a extends RecyclerView.b {
        private AbstractC0792a() {
        }

        /* synthetic */ AbstractC0792a(FragmentStateAdapter$1 r1) {
            this();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public abstract void a();

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public final void a(int r1, int r2) {
            a();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public final void a(int r1, int r2, int r3) {
            a();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public final void a(int r1, int r2, Object r3) {
            a();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public final void b(int r1, int r2) {
            a();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.b
        public final void c(int r1, int r2) {
            a();
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<d> f14841a;

        b() {
            this.f14841a = new CopyOnWriteArrayList();
        }

        public List<d.InterfaceC0793a> a(Fragment r5) {
            ArrayList r0 = new ArrayList();
            Iterator<d> r4 = this.f14841a.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r0.add(((d) ZeusTransformUtils.preCheckCast(r4.next(), d.class, "com.obric.memorydata.plugin")).a(r5));
            goto L4
        L6:
            return r0;
        }

        public List<d.InterfaceC0793a> a(Fragment r5, Lifecycle.State r6) {
            ArrayList r0 = new ArrayList();
            Iterator<d> r4 = this.f14841a.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r0.add(((d) ZeusTransformUtils.preCheckCast(r4.next(), d.class, "com.obric.memorydata.plugin")).a(r5, r6));
            goto L4
        L6:
            return r0;
        }

        public void a(List<d.InterfaceC0793a> r3) {
            Iterator r2 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            ((d.InterfaceC0793a) ZeusTransformUtils.preCheckCast(r2.next(), d.InterfaceC0793a.class, "com.obric.memorydata.plugin")).a();
            goto L4
        }

        public List<d.InterfaceC0793a> b(Fragment r5) {
            ArrayList r0 = new ArrayList();
            Iterator<d> r4 = this.f14841a.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r0.add(((d) ZeusTransformUtils.preCheckCast(r4.next(), d.class, "com.obric.memorydata.plugin")).b(r5));
            goto L4
        L6:
            return r0;
        }

        public List<d.InterfaceC0793a> c(Fragment r5) {
            ArrayList r0 = new ArrayList();
            Iterator<d> r4 = this.f14841a.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r0.add(((d) ZeusTransformUtils.preCheckCast(r4.next(), d.class, "com.obric.memorydata.plugin")).c(r5));
            goto L4
        L6:
            return r0;
        }
    }

    class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f14842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ViewPager2.e f14843b;
        private RecyclerView.b c;
        private LifecycleEventObserver d;
        private ViewPager2 e;
        private long f;

        c(a r3) {
            this.f14842a = r3;
            this.f = -1;
        }

        private ViewPager2 c(RecyclerView r3) {
            ViewParent r2 = r3.getParent();
            if (ZeusTransformUtils.instanceOf(r2, ViewPager2.class) == false) goto L7;
            return (ViewPager2) ZeusTransformUtils.preCheckCast(r2, ViewPager2.class, "com.obric.memorydata.plugin");
        L7:
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + r2);
        }

        void a(RecyclerView r2) {
            this.e = c(r2);
            ViewPager2.e r3 = new AnonymousClass1(this);
            this.f14843b = r3;
            this.e.a(r3);
            AbstractC0792a r4 = new AnonymousClass2(this);
            this.c = r4;
            this.f14842a.a(r4);
            this.d = new FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3(this);
            this.f14842a.f14839b.addObserver(this.d);
        }

        void a(boolean r11) {
            if (this.f14842a.c() == false) goto L6;
            return;
        L6:
            if (this.e.getScrollState() == 0) goto L9;
            return;
        L9:
            if (this.f14842a.d.isEmpty() == false) goto L11;
            return;
        L11:
            if (this.f14842a.d() == 0) goto L56;
            int r0 = this.e.getCurrentItem();
            if (r0 < this.f14842a.d()) goto L16;
            return;
        L16:
            long r1 = this.f14842a.c(r0);
            if (r1 != this.f) goto L20;
            if (r11 == true) goto L20;
            return;
        L20:
            Fragment r12 = (Fragment) ZeusTransformUtils.preCheckCast(this.f14842a.d.get(r1), Fragment.class, "com.obric.memorydata.plugin");
            if (r12 != null) goto L23;
            return;
        L23:
            if (r12.isAdded() == false) goto L57;
            this.f = r1;
            FragmentTransaction r13 = this.f14842a.c.beginTransaction();
            Fragment r2 = null;
            ArrayList r3 = new ArrayList();
            int r4 = 0;
        L27:
            if (r4 >= this.f14842a.d.size()) goto L41;
            long r5 = this.f14842a.d.keyAt(r4);
            Fragment r7 = (Fragment) ZeusTransformUtils.preCheckCast(this.f14842a.d.valueAt(r4), Fragment.class, "com.obric.memorydata.plugin");
            if (r7.isAdded() == false) goto L40;
            if (r5 == this.f) goto L34;
            r13.setMaxLifecycle(r7, Lifecycle.State.STARTED);
            r3.add(this.f14842a.e.a(r7, Lifecycle.State.STARTED));
        L36:
            if (r5 != this.f) goto L38;
            boolean r6 = true;
        L39:
            r7.setMenuVisibility(r6);
            goto L40
        L38:
            r6 = false;
            goto L39
        L34:
            r2 = r7;
        L40:
            r4 = r4 + 1;
            goto L27
        L41:
            if (r2 == null) goto L44;
            r13.setMaxLifecycle(r2, Lifecycle.State.RESUMED);
            r3.add(this.f14842a.e.a(r2, Lifecycle.State.RESUMED));
        L44:
            if (r13.isEmpty() == true) goto L55;
            r13.commitNow();
            Collections.reverse(r3);
            Iterator r14 = r3.iterator();
        L47:
            if (r14.hasNext() == false) goto L58;
            this.f14842a.e.a((List) ZeusTransformUtils.preCheckCast(r14.next(), List.class, "com.obric.memorydata.plugin"));
            goto L47
        L58:
            return;
        L55:
            return;
        L57:
            return;
        }

        void b(RecyclerView r2) {
            c(r2).b(this.f14843b);
            this.f14842a.b(this.c);
            this.f14842a.f14839b.removeObserver(this.d);
            this.e = null;
        }
    }

    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final InterfaceC0793a f14846a = null;

        /* JADX INFO: renamed from: com.obric.oui.viewpager2.adapter.a$d$a, reason: collision with other inner class name */
        public interface InterfaceC0793a {
            void a();
        }

        static {
            f14846a = new AnonymousClass1();
        }

        public d() {
        }

        public InterfaceC0793a a(Fragment r1) {
            return f14846a;
        }

        public InterfaceC0793a a(Fragment r1, Lifecycle.State r2) {
            return f14846a;
        }

        public InterfaceC0793a b(Fragment r1) {
            return f14846a;
        }

        public InterfaceC0793a c(Fragment r1) {
            return f14846a;
        }
    }

    public a(Fragment r2) {
        this(r2.getChildFragmentManager(), r2.getLifecycle());
    }

    public a(FragmentActivity r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.memorydata.plugin");
        this(r4.getSupportFragmentManager(), r4.getLifecycle());
    }

    public a(FragmentManager r2, Lifecycle r3) {
        this.d = new LongSparseArray();
        this.f14838a = new LongSparseArray();
        this.g = new LongSparseArray();
        this.e = new b();
        this.f = false;
        this.i = false;
        this.c = r2;
        this.f14839b = r3;
        super.b_(true);
    }

    private static String a(String r1, long r2) {
        return r1 + r2;
    }

    private void a() {
        final Handler r0 = new Handler(Looper.getMainLooper());
        final Runnable r1 = new AnonymousClass1(this);
        this.f14839b.addObserver(new FragmentStateAdapter$4(this, r0, r1));
        r0.postDelayed(r1, 10000);
    }

    private void a(final Fragment r3, final FrameLayout r4) {
        this.c.registerFragmentLifecycleCallbacks(new FragmentStateAdapter$2(this, r3, r4), false);
    }

    private static boolean a(String r1, String r2) {
        if (r1.startsWith(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.length() <= r2.length()) goto L7;
        return true;
    }

    private static long b(String r0, String r1) {
        return Long.parseLong(r0.substring(r1.length()));
    }

    private boolean b(long r3) {
        if (this.g.containsKey(r3) == false) goto L5;
        return true;
    L5:
        Fragment r2 = (Fragment) ZeusTransformUtils.preCheckCast(this.d.get(r3), Fragment.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L8;
        return false;
    L8:
        View r4 = r2.getView();
        if (r4 != null) goto L12;
        return false;
    L12:
        if (r4.getParent() == null) goto L15;
        return true;
    L15:
        return false;
    }

    private void c(long r5) {
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(this.d.get(r5), Fragment.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getView() == null) goto L11;
        ViewParent r1 = r0.getView().getParent();
        if (r1 == null) goto L11;
        ((FrameLayout) ZeusTransformUtils.preCheckCast(r1, FrameLayout.class, "com.obric.memorydata.plugin")).removeAllViews();
    L11:
        if (a(r5) == true) goto L14;
        this.f14838a.remove(r5);
    L14:
        if (r0.isAdded() == true) goto L18;
        this.d.remove(r5);
        return;
    L18:
        if (c() == false) goto L22;
        this.i = true;
        return;
    L22:
        if (r0.isAdded() == true) goto L24;
    L26:
        List<d.InterfaceC0793a> r2 = this.e.c(r0);
        this.c.beginTransaction().remove(r0).commitNow();     // Catch: Throwable -> L30
        this.d.remove(r5);     // Catch: Throwable -> L30
        this.e.a(r2);
        return;
    L30:
        th = move-exception;
        this.e.a(r2);
        throw th;
    L24:
        if (a(r5) == false) goto L26;
        List<d.InterfaceC0793a> r3 = this.e.b(r0);
        Fragment.SavedState r4 = this.c.saveFragmentInstanceState(r0);
        this.e.a(r3);
        this.f14838a.put(r5, r4);
        goto L26
    }

    private Long d(int r6) {
        Long r0 = null;
        int r1 = 0;
    L4:
        if (r1 >= this.g.size()) goto L12;
        if (((Integer) ZeusTransformUtils.preCheckCast(this.g.valueAt(r1), Integer.class, "com.obric.memorydata.plugin")).intValue() != r6) goto L11;
        if (r0 != null) goto L10;
        r0 = Long.valueOf(this.g.keyAt(r1));
        goto L11
    L10:
        throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        return r0;
    }

    private void h(int r6) {
        long r0 = c(r6);
        if (this.d.containsKey(r0) == true) goto L6;
        Fragment r7 = b(r6);
        r7.setInitialSavedState((Fragment.SavedState) ZeusTransformUtils.preCheckCast(this.f14838a.get(r0), Fragment.SavedState.class, "com.obric.memorydata.plugin"));
        this.d.put(r0, r7);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return b(r1, r2);
    }

    @Override // com.obric.oui.viewpager2.adapter.d
    public final void a(Parcelable r7) {
        Parcelable r8 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r7, Parcelable.class, "com.obric.memorydata.plugin");
        if (this.f14838a.isEmpty() == false) goto L28;
        if (this.d.isEmpty() == false) goto L28;
        Bundle r9 = (Bundle) ZeusTransformUtils.preCheckCast(r8, Bundle.class, "com.obric.memorydata.plugin");
        if (r9.getClassLoader() != null) goto L9;
        r9.setClassLoader(getClass().getClassLoader());
    L9:
        Iterator<String> r0 = r9.keySet().iterator();
    L11:
        if (r0.hasNext() == false) goto L24;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (a(r2, "f#") == true) goto L14;
        if (a(r2, "s#") == false) goto L22;
        long r3 = b(r2, "s#");
        Object r4 = (Fragment.SavedState) ZeusTransformUtils.preCheckCast(r9.getParcelable(r2), Fragment.SavedState.class, "com.obric.memorydata.plugin");
        if (a(r3) == false) goto L11;
        LongSparseArray r5 = this.f14838a;
    L15:
        r5.put(r3, r4);
        goto L11
    L22:
        throw new IllegalArgumentException("Unexpected key in savedState: " + r2);
    L14:
        r3 = b(r2, "f#");
        r4 = this.c.getFragment(r9, r2);
        r5 = this.d;
        goto L15
    L24:
        if (this.d.isEmpty() == true) goto L36;
        this.i = true;
        this.f = true;
        b();
        a();
        return;
    L36:
        return;
    L28:
        throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    }

    void a(View r3, FrameLayout r4) {
        if (r4.getChildCount() > 1) goto L16;
        if (r3.getParent() != r4) goto L8;
        return;
    L8:
        if (r4.getChildCount() <= 0) goto L11;
        r4.removeAllViews();
    L11:
        if (r3.getParent() == null) goto L13;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r3.getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).removeView(r3);
    L13:
        r4.addView(r3);
        return;
    L16:
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3) {
        a((com.obric.oui.viewpager2.adapter.c) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.viewpager2.adapter.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((com.obric.oui.viewpager2.adapter.c) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.viewpager2.adapter.c.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView r2) {
        if (this.h != null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        c r1 = new c(this);
        this.h = r1;
        r1.a(r2);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void a(com.obric.oui.viewpager2.adapter.c r1) {
        b(r1);
        b();
    }

    public final void a(com.obric.oui.viewpager2.adapter.c r8, int r9) {
        long r0 = r8.r();
        int r2 = r8.a().getId();
        Long r3 = d(r2);
        if (r3 != null) goto L5;
    L7:
        this.g.put(r0, Integer.valueOf(r2));
        h(r9);
        if (r8.a().isAttachedToWindow() == false) goto L10;
        b(r8);
    L10:
        b();
        return;
    L5:
        if (r3.longValue() == r0) goto L7;
        c(r3.longValue());
        this.g.remove(r3.longValue());
        goto L7
    }

    public boolean a(long r3) {
        if (r3 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r3 >= d()) goto L7;
        return true;
    }

    public abstract Fragment b(int r1);

    public final com.obric.oui.viewpager2.adapter.c b(ViewGroup r1, int r2) {
        return com.obric.oui.viewpager2.adapter.c.a(r1);
    }

    void b() {
        if (this.i == true) goto L5;
        return;
    L5:
        if (c() == true) goto L35;
        ArraySet r0 = new ArraySet();
        int r1 = 0;
        int r2 = 0;
    L9:
        if (r2 >= this.d.size()) goto L15;
        long r3 = this.d.keyAt(r2);
        if (a(r3) == true) goto L13;
        r0.add(Long.valueOf(r3));
        this.g.remove(r3);
    L13:
        r2 = r2 + 1;
        goto L9
    L15:
        if (this.f == true) goto L23;
        this.i = false;
    L18:
        if (r1 >= this.d.size()) goto L23;
        long r4 = this.d.keyAt(r1);
        if (b(r4) == true) goto L22;
        r0.add(Long.valueOf(r4));
    L22:
        r1 = r1 + 1;
    L23:
        Iterator<E> r5 = r0.iterator();
    L25:
        if (r5.hasNext() == false) goto L36;
        c(((Long) ZeusTransformUtils.preCheckCast(r5.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        goto L25
    L36:
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void b(RecyclerView.v r3) {
        c((com.obric.oui.viewpager2.adapter.c) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.viewpager2.adapter.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void b(RecyclerView r2) {
        this.h.b(r2);
        this.h = null;
    }

    void b(final com.obric.oui.viewpager2.adapter.c r8) {
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(this.d.get(r8.r()), Fragment.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L41;
        FrameLayout r2 = r8.a();
        View r3 = r0.getView();
        if (r0.isAdded() == true) goto L11;
        if (r3 == null) goto L11;
        throw new IllegalStateException("Design assumption violated.");
    L11:
        if (r0.isAdded() == false) goto L16;
        if (r3 != null) goto L16;
        a(r0, r2);
        return;
    L16:
        if (r0.isAdded() == false) goto L24;
        if (r3.getParent() == null) goto L24;
        if (r3.getParent() == r2) goto L44;
        a(r3, r2);
        return;
    L44:
        return;
    L24:
        if (r0.isAdded() == false) goto L28;
        a(r3, r2);
        return;
    L28:
        if (c() == true) goto L36;
        a(r0, r2);
        List<d.InterfaceC0793a> r1 = this.e.a(r0);
        r0.setMenuVisibility(false);     // Catch: Throwable -> L32
        this.c.beginTransaction().add(r0, f.f1488a + r8.r()).setMaxLifecycle(r0, Lifecycle.State.STARTED).commitNow();     // Catch: Throwable -> L32
        this.h.a(false);     // Catch: Throwable -> L32
        this.e.a(r1);
        return;
    L32:
        th = move-exception;
        this.e.a(r1);
        throw th;
    L36:
        if (this.c.isDestroyed() == false) goto L38;
        return;
    L38:
        this.f14839b.addObserver(new FragmentStateAdapter$1(this, r8));
        return;
    L41:
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public final void b_(boolean r1) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public long c(int r1) {
        return r1;
    }

    public final void c(com.obric.oui.viewpager2.adapter.c r3) {
        Long r4 = d(r3.a().getId());
        if (r4 == null) goto L6;
        c(r4.longValue());
        this.g.remove(r4.longValue());
        return;
    }

    boolean c() {
        return this.c.isStateSaved();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ boolean c(RecyclerView.v r3) {
        return d((com.obric.oui.viewpager2.adapter.c) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.viewpager2.adapter.c.class, "com.obric.memorydata.plugin"));
    }

    public final boolean d(com.obric.oui.viewpager2.adapter.c r1) {
        return true;
    }

    @Override // com.obric.oui.viewpager2.adapter.d
    public final Parcelable e() {
        Bundle r0 = new Bundle(this.d.size() + this.f14838a.size());
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= this.d.size()) goto L12;
        long r5 = this.d.keyAt(r2);
        Fragment r3 = (Fragment) ZeusTransformUtils.preCheckCast(this.d.get(r5), Fragment.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L10;
        if (r3.isAdded() == false) goto L10;
        this.c.putFragment(r0, a("f#", r5), r3);
    L10:
        r2 = r2 + 1;
    L12:
        if (r1 >= this.f14838a.size()) goto L17;
        long r4 = this.f14838a.keyAt(r1);
        if (a(r4) == false) goto L16;
        r0.putParcelable(a("s#", r4), (Parcelable) ZeusTransformUtils.preCheckCast(this.f14838a.get(r4), Parcelable.class, "com.obric.memorydata.plugin"));
    L16:
        r1 = r1 + 1;
        goto L12
    L17:
        return r0;
    }
}
