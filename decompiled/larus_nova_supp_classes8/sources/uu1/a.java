package uu1;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ju1.c;
import ju1.h;
import ju1.l;
import ju1.n;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;
import vu1.d;
import vu1.e;
import vu1.f;
import vu1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements uu1.b, vu1.b {
    public final d a;
    public final g b;
    public Function2<? super String, ? super n, Unit> c;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: uu1.a$a, reason: collision with other inner class name */
    public static final class C0420a<T> implements iu1.a<T> {
        public final /* synthetic */ a a;
        public final /* synthetic */ c b;

        @Override // iu1.a
        public void update(T r4) {
            Intrinsics.checkNotNullParameter(r4, "state");
            this.a.b.c(this.b.a, r4, false);
        }

        public C0420a(a r1, c r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements iu1.a<Object> {
        public final /* synthetic */ c a;
        public final /* synthetic */ a b;

        @Override // iu1.a
        public void update(Object r4) {
            Intrinsics.checkNotNullParameter(r4, "state");
            this.b.b.c(this.a.a, r4, false);
        }

        public b(c r1, a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // vu1.b
    public final void d(c<Object> r2, Object r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "factor");
        Intrinsics.checkNotNullParameter(r3, "oldState");
        Intrinsics.checkNotNullParameter(r4, "newState");
    }

    @Override // uu1.b
    public final void destroy() {
        this.c = null;
        Iterator<vu1.c> r1 = this.a.d();
    L4:
        if (r1.hasNext() == false) goto L6;
        DynamicFactor<Object> r2 = r1.next().b;
        r2.a = null;
        r2.e();
        goto L4
    L6:
        Iterator<e> r3 = this.a.b();
        if (r3.hasNext() == true) goto L14;
        Iterator<f> r4 = this.a.a();
    L10:
        if (r4.hasNext() == false) goto L12;
        r4.next().b.onDestroy();
        goto L10
    L12:
        d r5 = this.a;
        r5.a.clear();
        r5.b.clear();
        r5.c.clear();
        g r6 = this.b;
        r6.e = null;
        ((ConcurrentHashMap) r6.a).clear();
        r6.d.clear();
        ((ConcurrentHashMap) r6.b).clear();
        ((ConcurrentHashMap) r6.c).clear();
        return;
    L14:
        r3.next().getClass();
        throw null;
    }

    @Override // uu1.b
    public final List<DynamicFactor<?>> f() {
        ArrayList r0 = new ArrayList();
        Iterator<vu1.c> r1 = this.a.d();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(r1.next().b);
        goto L4
    L6:
        return r0;
    }

    @Override // uu1.b
    public final Map<String, n> g() {
        return this.b.c;
    }

    @Override // uu1.b
    public final List<l> getSceneList() {
        ArrayList r0 = new ArrayList();
        Iterator<e> r1 = this.a.b();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().getClass();
        r0.add(null);
        goto L4
    L6:
        return r0;
    }

    @Override // uu1.b
    public final long i() {
        g r0 = this.b;
        long r1 = r0.f;
        if (r1 > 0) goto L5;
        return 0;
    L5:
        return (r0.g / r1) + 1;
    }

    @Override // uu1.b
    public final List<h> j() {
        ArrayList r0 = new ArrayList();
        Iterator<f> r1 = this.a.a();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(r1.next().a);
        goto L4
    L6:
        return r0;
    }

    @Override // uu1.b
    public final List<c<Object>> m() {
        ArrayList r0 = new ArrayList();
        Iterator<vu1.c> r1 = this.a.d();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(r1.next().a);
        goto L4
    L6:
        return r0;
    }

    @Override // uu1.b
    public final List<iu1.b> o() {
        ArrayList r0 = new ArrayList();
        Iterator<f> r1 = this.a.a();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(r1.next().b);
        goto L4
    L6:
        return r0;
    }

    @Override // uu1.b
    public final void prepare() {
        g r0 = this.b;
        r0.h = true;
        Iterator<vu1.c> r2 = r0.j.d();
    L4:
        if (r2.hasNext() == false) goto L6;
        c<Object> r3 = r2.next().a;
        String r4 = r3.a;
        Object r5 = r3.b;
        ((ConcurrentHashMap) r0.a).put(r4, r5);
        goto L4
    L6:
        Iterator<e> r6 = r0.j.b();
        if (r6.hasNext() == true) goto L30;
        Iterator<f> r7 = r0.j.a();
    L10:
        if (r7.hasNext() == false) goto L14;
        g.c r8 = r0.e(r7.next().a);
        if (r8 == null) goto L10;
        int r9 = k.a;
        k.e(r8.a, r8.b, r8.c, r8.d);
        goto L10
    L14:
        r0.j.g(r0.i);
        this.b.e = this;
        Iterator<vu1.c> r1 = this.a.d();
    L16:
        if (r1.hasNext() == false) goto L18;
        vu1.c r10 = r1.next();
        DynamicFactor<Object> r11 = r10.b;
        iu1.a r12 = r10.c;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "wrapper");
        r11.a = r12;
        r11.d();
        goto L16
    L18:
        Iterator<e> r13 = this.a.b();
        if (r13.hasNext() == true) goto L28;
        Iterator<f> r14 = this.a.a();
    L22:
        if (r14.hasNext() == false) goto L27;
        f r15 = r14.next();
        String r16 = r15.a.b();
        g r17 = this.b;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r16, LiveEndPageData.TAG_NAME);
        n r18 = (n) ((ConcurrentHashMap) r17.c).get(r16);
        if (r18 != null) goto L26;
        r18 = new n(r15.a.a(), true);
    L26:
        r15.b.b(r18);
        goto L22
    L27:
        return;
    L28:
        r13.next().getClass();
        throw null;
    L30:
        r6.next().getClass();
        throw null;
    }

    @Override // uu1.b
    public final Map<String, Object> q() {
        return this.b.a;
    }

    public a() {
        d r0 = new d();
        this.a = r0;
        this.b = new g(r0);
    }

    @Override // uu1.b
    public final <T> void a(DynamicFactor<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "factor");
        c r0 = new c(r4.c(), r4.b());
        vu1.c r2 = new vu1.c(r0, r4, new C0420a(this, r0));
        d r5 = this.a;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r2, "repoFactor");
        r5.a.put(r2.a.a, r2);
        vu1.a.InterfaceC0425a r6 = r5.d;
        if (r6 == null) goto L6;
        r6.a(CollectionsKt.listOf(r2.a));
        return;
    }

    @Override // uu1.b
    public final void b(List<? extends DynamicFactor<? extends Object>> r7) {
        Intrinsics.checkNotNullParameter(r7, "factorList");
        List<? extends DynamicFactor<? extends Object>> r8 = r7;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        DynamicFactor r2 = (DynamicFactor) r9.next();
        c r3 = new c(r2.c(), r2.b());
        r0.add(new vu1.c(r3, r2, new b(r3, this)));
        goto L4
    L6:
        d r10 = this.a;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r0, "repoFactorList");
        Iterator r4 = r0.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        vu1.c r5 = (vu1.c) r4.next();
        r10.a.put(r5.a.a, r5);
        goto L8
    L10:
        vu1.a.InterfaceC0425a r11 = r10.d;
        if (r11 == null) goto L21;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L14:
        if (r1.hasNext() == false) goto L16;
        r6.add(((vu1.c) r1.next()).a);
        goto L14
    L16:
        r11.a(r6);
        return;
    }

    @Override // uu1.b
    public final void c(iu1.b r4) {
        Intrinsics.checkNotNullParameter(r4, "strategy");
        h r0 = r4.getStrategy();
        d r1 = this.a;
        f r2 = new f(r0, r4);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "repoStrategy");
        r1.c.put(r2.a.b(), r2);
    }

    @Override // uu1.b
    public final n e(String r3) {
        Intrinsics.checkNotNullParameter(r3, LiveEndPageData.TAG_NAME);
        g r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, LiveEndPageData.TAG_NAME);
        return (n) ((ConcurrentHashMap) r1.c).get(r3);
    }

    @Override // uu1.b
    public final void h(String r6) {
        Intrinsics.checkNotNullParameter(r6, LiveEndPageData.TAG_NAME);
        d r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, LiveEndPageData.TAG_NAME);
        f r7 = r1.c.get(r6);
        if (r7 == null) goto L12;
        h r8 = r7.a;
        if (r8 == null) goto L13;
        g r0 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r8, "strategy");
        g.c r9 = r0.e(r8);
        if (r9 == null) goto L14;
        int r2 = k.a;
        k.e(r9.a, r9.b, r9.c, r9.d);
        vu1.b r3 = r0.e;
        if (r3 == null) goto L15;
        r3.l(r9.a, r9.c, r9.d);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // uu1.b
    public final void k(Function2<? super String, ? super n, Unit> r1) {
        this.c = r1;
    }

    @Override // vu1.b
    public final void n(l r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        d r0 = this.a;
        String r4 = r3.b();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, LiveEndPageData.TAG_NAME);
        e r5 = r0.b.get(r4);
    }

    @Override // uu1.b
    public final void p(String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "featureName");
        Intrinsics.checkNotNullParameter(r4, "featureValue");
        this.b.c(r3, r4, true);
    }

    @Override // vu1.b
    public final void l(h r3, n r4, Map r5) {
        Intrinsics.checkNotNullParameter(r3, "strategy");
        Intrinsics.checkNotNullParameter(r4, "newResult");
        Intrinsics.checkNotNullParameter(r5, "stateMap");
        d r6 = this.a;
        String r0 = r3.b();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, LiveEndPageData.TAG_NAME);
        f r7 = r6.c.get(r0);
        if (r7 == null) goto L7;
        iu1.b r8 = r7.b;
        if (r8 == null) goto L7;
        r8.a(r4);
    L7:
        Function2<? super String, ? super n, Unit> r9 = this.c;
        if (r9 == null) goto L11;
        Unit r10 = (Unit) r9.invoke(r3.b(), r4);
        return;
    }
}
