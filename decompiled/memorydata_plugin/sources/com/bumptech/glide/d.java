package com.bumptech.glide;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.bitmap_recycle.k;
import com.bumptech.glide.manager.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, j<?, ?>> f529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f.a f530b;
    private com.bumptech.glide.load.engine.i c;
    private com.bumptech.glide.load.engine.bitmap_recycle.e d;
    private com.bumptech.glide.load.engine.bitmap_recycle.b e;
    private com.bumptech.glide.load.engine.a.h f;
    private com.bumptech.glide.load.engine.b.a g;
    private com.bumptech.glide.load.engine.b.a h;
    private com.bumptech.glide.load.engine.a.a.InterfaceC0065a i;
    private com.bumptech.glide.load.engine.a.i j;
    private com.bumptech.glide.manager.c k;
    private int l;
    private c.a m;
    private n.a n;
    private com.bumptech.glide.load.engine.b.a o;
    private boolean p;
    private List<com.bumptech.glide.request.e<Object>> q;

    static final class a implements f.b {
        a() {
        }
    }

    public static final class b implements f.b {
        public b() {
        }
    }

    public d() {
        this.f529a = new ArrayMap();
        this.f530b = new f.a();
        this.l = 4;
        this.m = new AnonymousClass1(this);
    }

    c a(Context r19, List<com.bumptech.glide.c.c> r20, com.bumptech.glide.c.a r21) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        if (this.g != null) goto L6;
        this.g = com.bumptech.glide.load.engine.b.a.d();
    L6:
        if (this.h != null) goto L9;
        this.h = com.bumptech.glide.load.engine.b.a.b();
    L9:
        if (this.o != null) goto L12;
        this.o = com.bumptech.glide.load.engine.b.a.h();
    L12:
        if (this.j != null) goto L15;
        this.j = new com.bumptech.glide.load.engine.a.i.a(r4).a();
    L15:
        if (this.k != null) goto L18;
        this.k = new com.bumptech.glide.manager.e();
    L18:
        if (this.d != null) goto L24;
        int r1 = this.j.b();
        if (r1 <= 0) goto L22;
        this.d = new k(r1);
        goto L24
    L22:
        this.d = new com.bumptech.glide.load.engine.bitmap_recycle.f();
    L24:
        if (this.e != null) goto L27;
        this.e = new com.bumptech.glide.load.engine.bitmap_recycle.j(this.j.c());
    L27:
        if (this.f != null) goto L30;
        this.f = new com.bumptech.glide.load.engine.a.g(this.j.a());
    L30:
        if (this.i != null) goto L33;
        this.i = new com.bumptech.glide.load.engine.a.f(r4);
    L33:
        if (this.c != null) goto L35;
        this.c = new com.bumptech.glide.load.engine.i(this.f, this.i, this.h, this.g, com.bumptech.glide.load.engine.b.a.e(), this.o, this.p);
    L35:
        List<com.bumptech.glide.request.e<Object>> r2 = this.q;
        if (r2 != null) goto L38;
        List<com.bumptech.glide.request.e<Object>> r3 = Collections.emptyList();
    L39:
        this.q = r3;
        f r17 = this.f530b.a();
        return new c(r4, this.c, this.f, this.d, this.e, new n(this.n), this.k, this.l, this.m, this.f529a, this.q, r15, r21, r17);
    L38:
        r3 = Collections.unmodifiableList(r2);
        goto L39
    }

    void a(n.a r3) {
        this.n = (n.a) ZeusTransformUtils.wrapperContextForParams(r3, n.a.class, "com.obric.memorydata.plugin");
    }
}
