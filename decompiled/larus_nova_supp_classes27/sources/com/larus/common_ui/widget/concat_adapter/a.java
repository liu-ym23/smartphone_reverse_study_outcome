package com.larus.common_ui.widget.concat_adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements b.InterfaceC0016b {
    public final ConcatAdapter a;
    public final a29.a b;
    public final List<WeakReference<RecyclerView>> c;
    public final IdentityHashMap<RecyclerView.ViewHolder, b> d;
    public final List<b> e;
    public C0015a f;
    public final ConcatAdapter.Config.StableIdMode g;
    public final c h;

    /* JADX INFO: renamed from: com.larus.common_ui.widget.concat_adapter.a$a, reason: collision with other inner class name */
    public static class C0015a {
        public b a;
        public int b;
        public boolean c;

        public C0015a() {
        }
    }

    public final RecyclerView d() {
        if (((ArrayList) this.c).size() > 0) goto L5;
        return null;
    L5:
        return (RecyclerView) ((WeakReference) ListProtector.get(this.c, 0)).get();
    }

    public final int b(b r4) {
        Iterator r0 = ((ArrayList) this.e).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L8;
        b r2 = (b) r0.next();
        if (r2 == r4) goto L8;
        r1 = r1 + r2.e;
    L8:
        return r1;
    }

    public final C0015a c(int r6) {
        C0015a r0 = this.f;
        if (r0.c == false) goto L5;
        r0 = new C0015a();
    L6:
        Iterator r1 = ((ArrayList) this.e).iterator();
        int r2 = r6;
    L8:
        if (r1.hasNext() == false) goto L14;
        b r3 = (b) r1.next();
        int r4 = r3.e;
        if (r4 > r2) goto L11;
        r2 = r2 - r4;
        goto L8
    L11:
        r0.a = r3;
        r0.b = r2;
    L14:
        if (r0.a == null) goto L17;
        return r0;
    L17:
        throw new IllegalArgumentException("Cannot find wrapper for " + r6);
    L5:
        r0.c = true;
        goto L6
    }

    public final b e(RecyclerView.ViewHolder r4) {
        b r0 = this.d.get(r4);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Cannot find wrapper for " + r4 + ", seems like it is not bound by this adapter: " + this);
    }

    public final int f(RecyclerView.Adapter<RecyclerView.ViewHolder> r4) {
        int r0 = ((ArrayList) this.e).size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (((b) ListProtector.get(this.e, r1)).c == r4) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    public a(ConcatAdapter r2, ConcatAdapter.Config r3) {
        this.c = new ArrayList();
        this.d = new IdentityHashMap();
        this.e = new ArrayList();
        this.f = new C0015a();
        this.a = r2;
        r3.getClass();
        this.b = new a29.a();
        ConcatAdapter.Config.StableIdMode r4 = r3.a;
        this.g = r4;
        if (r4 != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) goto L6;
        this.h = new c.b();
        return;
    L6:
        if (r4 != ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) goto L9;
        this.h = new c.a();
        return;
    L9:
        if (r4 != ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) goto L13;
        this.h = new c.C0018c();
        return;
    L13:
        throw new IllegalArgumentException("unknown stable id mode");
    }

    public final boolean a(int r5, RecyclerView.Adapter<RecyclerView.ViewHolder> r6) {
        if (r5 < 0) goto L29;
        if (r5 > ((ArrayList) this.e).size()) goto L29;
        if (this.g == ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        r6.hasStableIds();
    L12:
        int r1 = f(r6);
        if (r1 != (-1)) goto L15;
        b r2 = null;
    L16:
        if (r2 == null) goto L18;
        return false;
    L18:
        b r3 = new b(r6, this, this.b, this.h.createStableIdLookup());
        ListProtector.add(this.e, r5, r3);
        Iterator r7 = ((ArrayList) this.c).iterator();
    L20:
        if (r7.hasNext() == false) goto L25;
        RecyclerView r4 = (RecyclerView) ((WeakReference) r7.next()).get();
        if (r4 == null) goto L20;
        r6.onAttachedToRecyclerView(r4);
        goto L20
    L25:
        if (r3.e <= 0) goto L27;
        this.a.notifyItemRangeInserted(b(r3), r3.e);
    L27:
        return true;
    L15:
        r2 = (b) ListProtector.get(this.e, r1);
        goto L16
    L11:
        r6.hasStableIds();
        goto L12
    L8:
        r0 = false;
    L29:
        throw new IndexOutOfBoundsException("Index must be between 0 and " + ((ArrayList) this.e).size() + ". Given:" + r5);
    }

    public final void g(b r2, int r3, int r4, Object r5) {
        int r6 = b(r2);
        RecyclerView r0 = d();
        if (r0 != null) goto L5;
    L9:
        FLogger.a.e("ConcatAdapterController", "onItemRangeChanged return, recyclerView is null or is computing layout");
        return;
    L5:
        if (r0.isComputingLayout() == true) goto L9;
        this.a.notifyItemRangeChanged(r3 + r6, r4, r5);
    }
}
