package com.obric.oui.orecyclerview.widget;

import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.Adapter<RecyclerView.v> f14230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a f14231b;
    int c;
    private final ae.c d;
    private final ab.d e;
    private RecyclerView.b f;

    interface a {
        void a(s r1);

        void a(s r1, int r2, int r3);

        void a(s r1, int r2, int r3, Object r4);

        void b(s r1);

        void b(s r1, int r2, int r3);

        void c(s r1, int r2, int r3);
    }

    s(RecyclerView.Adapter<RecyclerView.v> r3, a r4, ae r5, ab.d r6) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        ae r8 = (ae) ZeusTransformUtils.wrapperContextForParams(r5, ae.class, "com.obric.memorydata.plugin");
        ab.d r9 = (ab.d) ZeusTransformUtils.wrapperContextForParams(r6, ab.d.class, "com.obric.memorydata.plugin");
        this.f = new AnonymousClass1(this);
        this.f14230a = r3;
        this.f14231b = r7;
        this.d = r8.a(this);
        this.e = r9;
        this.c = r3.d();
        r3.a(this.f);
    }

    int a() {
        return this.c;
    }

    int a(int r2) {
        return this.d.a(this.f14230a.a(r2));
    }

    RecyclerView.v a(ViewGroup r2, int r3) {
        int r4 = this.d.b(r3);
        return this.f14230a.a(r2, r4);
    }

    void a(RecyclerView.v r1, int r2) {
        this.f14230a.b(r1, r2);
    }

    public long b(int r3) {
        long r0 = this.f14230a.c(r3);
        return this.e.a(r0);
    }
}
