package com.obric.oui.orecyclerview.widget;

import android.util.Log;
import android.view.ViewGroup;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
class g implements s.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcatAdapter f14159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ae f14160b;
    private List<WeakReference<RecyclerView>> c;
    private final IdentityHashMap<RecyclerView.v, s> d;
    private List<s> e;
    private a f;
    private final ConcatAdapter.Config.StableIdMode g;
    private final ab h;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        s f14161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14162b;
        boolean c;

        a() {
        }
    }

    g(ConcatAdapter r2, ConcatAdapter.Config r3) {
        this.c = new ArrayList();
        this.d = new IdentityHashMap();
        this.e = new ArrayList();
        this.f = new a();
        this.f14159a = r2;
        if (r3.f14050a == false) goto L5;
        ae r4 = new ae.a();
    L6:
        this.f14160b = r4;
        this.g = r3.f14051b;
        if (r3.f14051b != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) goto L11;
        ab r5 = new ab.b();
    L9:
        this.h = r5;
        return;
    L11:
        if (r3.f14051b != ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) goto L14;
        r5 = new ab.a();
        goto L9
    L14:
        if (r3.f14051b != ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) goto L18;
        r5 = new ab.c();
        goto L9
    L18:
        throw new IllegalArgumentException("unknown stable id mode");
    L5:
        r4 = new ae.b();
        goto L6
    }

    private void a(a r2) {
        r2.c = false;
        r2.f14161a = null;
        r2.f14162b = -1;
        this.f = r2;
    }

    private s b(RecyclerView.Adapter<RecyclerView.v> r2) {
        int r3 = c(r2);
        if (r3 != (-1)) goto L7;
        return null;
    L7:
        return (s) ZeusTransformUtils.preCheckCast(this.e.get(r3), s.class, "com.obric.memorydata.plugin");
    }

    private int c(RecyclerView.Adapter<RecyclerView.v> r6) {
        int r0 = this.e.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (((s) ZeusTransformUtils.preCheckCast(this.e.get(r1), s.class, "com.obric.memorydata.plugin")).f14230a == r6) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    private int c(s r5) {
        Iterator<s> r4 = this.e.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L8;
        s r1 = (s) ZeusTransformUtils.preCheckCast(r4.next(), s.class, "com.obric.memorydata.plugin");
        if (r1 == r5) goto L8;
        r0 = r0 + r1.a();
    L8:
        return r0;
    }

    private a c(int r6) {
        if (this.f.c == false) goto L5;
        a r0 = new a();
    L6:
        Iterator<s> r5 = this.e.iterator();
        int r1 = r6;
    L8:
        if (r5.hasNext() == false) goto L14;
        s r2 = (s) ZeusTransformUtils.preCheckCast(r5.next(), s.class, "com.obric.memorydata.plugin");
        if (r2.a() > r1) goto L11;
        r1 = r1 - r2.a();
        goto L8
    L11:
        r0.f14161a = r2;
        r0.f14162b = r1;
    L14:
        if (r0.f14161a == null) goto L17;
        return r0;
    L17:
        throw new IllegalArgumentException("Cannot find wrapper for " + r6);
    L5:
        this.f.c = true;
        r0 = this.f;
        goto L6
    }

    private boolean c(RecyclerView r4) {
        Iterator<WeakReference<RecyclerView>> r3 = this.c.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.next(), WeakReference.class, "com.obric.memorydata.plugin")).get() != r4) goto L4;
        return true;
    L9:
        return false;
    }

    private void d() {
        RecyclerView.Adapter.StateRestorationPolicy r0 = e();
        if (r0 == this.f14159a.i()) goto L6;
        this.f14159a.b(r0);
        return;
    }

    private RecyclerView.Adapter.StateRestorationPolicy e() {
        Iterator<s> r3 = this.e.iterator();
    L4:
        if (r3.hasNext() == false) goto L16;
        s r0 = (s) ZeusTransformUtils.preCheckCast(r3.next(), s.class, "com.obric.memorydata.plugin");
        RecyclerView.Adapter.StateRestorationPolicy r1 = r0.f14230a.i();
        if (r1 == RecyclerView.Adapter.StateRestorationPolicy.PREVENT) goto L8;
        if (r1 != RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) goto L4;
        if (r0.a() != 0) goto L4;
        return RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
    L8:
        return RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
    L16:
        return RecyclerView.Adapter.StateRestorationPolicy.ALLOW;
    }

    private s e(RecyclerView.v r4) {
        s r0 = (s) ZeusTransformUtils.preCheckCast(this.d.get(r4), s.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Cannot find wrapper for " + r4 + ", seems like it is not bound by this adapter: " + this);
    }

    public int a() {
        Iterator<s> r4 = this.e.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + ((s) ZeusTransformUtils.preCheckCast(r4.next(), s.class, "com.obric.memorydata.plugin")).a();
        goto L4
    L6:
        return r0;
    }

    public int a(RecyclerView.Adapter<? extends RecyclerView.v> r4, RecyclerView.v r5, int r6) {
        s r0 = (s) ZeusTransformUtils.preCheckCast(this.d.get(r5), s.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return -1;
    L6:
        int r7 = r6 - c(r0);
        int r3 = r0.f14230a.d();
        if (r7 < 0) goto L12;
        if (r7 >= r3) goto L12;
        return r0.f14230a.a(r4, r5, r7);
    L12:
        throw new IllegalStateException("Detected inconsistent adapter updates. The local position of the view holder maps to " + r7 + " which is out of bounds for the adapter with size " + r3 + ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:" + r5 + "adapter:" + r4);
    }

    public long a(int r3) {
        a r4 = c(r3);
        long r0 = r4.f14161a.b(r4.f14162b);
        a(r4);
        return r0;
    }

    public RecyclerView.v a(ViewGroup r1, int r2) {
        return this.f14160b.a(r2).a(r1, r2);
    }

    public void a(RecyclerView.v r1) {
        e(r1).f14230a.a(r1);
    }

    public void a(RecyclerView.v r3, int r4) {
        a r5 = c(r4);
        this.d.put(r3, r5.f14161a);
        r5.f14161a.a(r3, r5.f14162b);
        a(r5);
    }

    public void a(RecyclerView r4) {
        if (c(r4) == false) goto L5;
        return;
    L5:
        this.c.add(new WeakReference(r4));
        Iterator<s> r3 = this.e.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((s) ZeusTransformUtils.preCheckCast(r3.next(), s.class, "com.obric.memorydata.plugin")).f14230a.a(r4);
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.s.a
    public void a(s r1) {
        this.f14159a.h();
        d();
    }

    @Override // com.obric.oui.orecyclerview.widget.s.a
    public void a(s r1, int r2, int r3) {
        int r4 = c(r1);
        this.f14159a.c(r2 + r4, r3);
    }

    @Override // com.obric.oui.orecyclerview.widget.s.a
    public void a(s r1, int r2, int r3, Object r4) {
        int r5 = c(r1);
        this.f14159a.a(r2 + r5, r3, r4);
    }

    boolean a(int r5, RecyclerView.Adapter<RecyclerView.v> r6) {
        if (r5 < 0) goto L27;
        if (r5 > this.e.size()) goto L27;
        if (c() == false) goto L9;
        Preconditions.checkArgument(r6.f(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
    L12:
        if (b(r6) == null) goto L15;
        return false;
    L15:
        s r0 = new s(r6, this, this.f14160b, this.h.a());
        this.e.add(r5, r0);
        Iterator<WeakReference<RecyclerView>> r7 = this.c.iterator();
    L17:
        if (r7.hasNext() == false) goto L22;
        RecyclerView r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r7.next(), WeakReference.class, "com.obric.memorydata.plugin")).get(), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L17;
        r6.a(r1);
        goto L17
    L22:
        if (r0.a() <= 0) goto L24;
        this.f14159a.c(c(r0), r0.a());
    L24:
        d();
        return true;
    L9:
        if (r6.f() == false) goto L12;
        Log.w("ConcatAdapter", "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
    L27:
        throw new IndexOutOfBoundsException("Index must be between 0 and " + this.e.size() + ". Given:" + r5);
    }

    boolean a(RecyclerView.Adapter<RecyclerView.v> r2) {
        return a(this.e.size(), r2);
    }

    public int b(int r3) {
        a r4 = c(r3);
        int r0 = r4.f14161a.a(r4.f14162b);
        a(r4);
        return r0;
    }

    public List<RecyclerView.Adapter<? extends RecyclerView.v>> b() {
        if (this.e.isEmpty() == true) goto L5;
        ArrayList r0 = new ArrayList(this.e.size());
        Iterator<s> r4 = this.e.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r0.add(((s) ZeusTransformUtils.preCheckCast(r4.next(), s.class, "com.obric.memorydata.plugin")).f14230a);
        goto L8
    L10:
        return r0;
    L5:
        return Collections.emptyList();
    }

    public void b(RecyclerView.v r1) {
        e(r1).f14230a.d(r1);
    }

    public void b(RecyclerView r5) {
        int r0 = this.c.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L12;
        WeakReference r2 = (WeakReference) ZeusTransformUtils.preCheckCast(this.c.get(r0), WeakReference.class, "com.obric.memorydata.plugin");
        if (r2.get() != null) goto L9;
        this.c.remove(r0);
        goto L3
    L9:
        if (r2.get() != r5) goto L3;
        this.c.remove(r0);
    L12:
        Iterator<s> r4 = this.e.iterator();
    L14:
        if (r4.hasNext() == false) goto L16;
        ((s) ZeusTransformUtils.preCheckCast(r4.next(), s.class, "com.obric.memorydata.plugin")).f14230a.b(r5);
        goto L14
    }

    @Override // com.obric.oui.orecyclerview.widget.s.a
    public void b(s r1) {
        d();
    }

    @Override // com.obric.oui.orecyclerview.widget.s.a
    public void b(s r1, int r2, int r3) {
        int r4 = c(r1);
        this.f14159a.d(r2 + r4, r3);
    }

    public void c(RecyclerView.v r4) {
        s r0 = (s) ZeusTransformUtils.preCheckCast(this.d.get(r4), s.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        r0.f14230a.b(r4);
        this.d.remove(r4);
        return;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r4 + ", seems like it is not bound by this adapter: " + this);
    }

    @Override // com.obric.oui.orecyclerview.widget.s.a
    public void c(s r1, int r2, int r3) {
        int r4 = c(r1);
        this.f14159a.b(r2 + r4, r3 + r4);
    }

    public boolean c() {
        if (this.g == ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d(RecyclerView.v r4) {
        s r0 = (s) ZeusTransformUtils.preCheckCast(this.d.get(r4), s.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        boolean r1 = r0.f14230a.c(r4);
        this.d.remove(r4);
        return r1;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r4 + ", seems like it is not bound by this adapter: " + this);
    }
}
