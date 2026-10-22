package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.util.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class u extends BaseTask {
    public final z.a<Effect> g;
    public final z.a<Effect> h;
    public final z.a<String> i;
    public final z.a<Effect> j;
    public final z.a<Pair<Effect, ExceptionResult>> k;
    public final EffectConfig l;
    public final List<Effect> m;
    public final String n;
    public final com.ss.ugc.effectplatform.model.a o;

    public static final class a {
    }

    public static final class b implements hlc.d {
        public final /* synthetic */ u a;

        public final void onProgress(Effect r1, int r2, long r3) {
        }

        public final void onStart(Effect r1) {
        }

        public b(u r1) {
            this.a = r1;
        }

        public final void onSuccess(Object r3) {
            Effect r4 = (Effect) r3;
            if (r4 == null) goto L5;
            this.a.i.remove(r4.getId());
            this.a.j.add(r4);
        L5:
            this.a.f();
        }

        public final void onFail(Object r3, ExceptionResult r4) {
            Effect r5 = (Effect) r3;
            if (r5 == null) goto L5;
            this.a.i.remove(r5.getId());
            this.a.k.add(new Pair(r5, r4));
        L5:
            this.a.f();
        }
    }

    static {
    }

    public final void b() {
    }

    public final void a() {
        if (this.h.isEmpty() == false) goto L6;
        e(new DownloadEffectListTask$onSuccess$1(this, new ArrayList()));
        return;
    L6:
        f();
    }

    public final void f() {
        z.a<Pair<Effect, ExceptionResult>> r1 = null;
        if ((!this.h.isEmpty()) == false) goto L25;
        if (this.i.size() >= 5) goto L55;
        int r3 = 5 - this.i.size();
        int r0 = 0;
    L7:
        if (r0 > r3) goto L59;
        if ((!this.h.isEmpty()) == false) goto L60;
        c0.e r4 = v.a;
        r4.a();
        z.a<Effect> r5 = this.h;     // Catch: Throwable -> L21
        if ((!r5.isEmpty()) == true) goto L15;
        r5 = null;
    L15:
        if (r5 == null) goto L20;
        Effect r6 = (Effect) r5.remove(0);     // Catch: Throwable -> L21
        if (r6 == null) goto L20;
        g(r6);     // Catch: Throwable -> L21
        r0 = r0 + 1;
    L20:
        r4.b();
    L21:
        th = move-exception;
        r4.b();
        throw th;
    L60:
        return;
    L59:
        return;
    L55:
        return;
    L25:
        if ((this.j.size() + this.k.size()) == this.g.size()) goto L27;
        return;
    L27:
        if (this.j.size() != this.g.size()) goto L29;
        e(new DownloadEffectListTask$onSuccess$1(this, this.m));
        return;
    L29:
        z.a<Pair<Effect, ExceptionResult>> r2 = this.k;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r8 = r2.iterator();
    L31:
        if (r8.hasNext() == false) goto L33;
        r7.add((Effect) ((Pair) r8.next()).getFirst());
        goto L31
    L33:
        z.a<Pair<Effect, ExceptionResult>> r9 = this.k;
        if ((!r9.isEmpty()) == false) goto L36;
        r1 = r9;
    L36:
        if (r1 == null) goto L42;
        Pair r10 = (Pair) r1.get(0);
        if (r10 == null) goto L42;
        final ExceptionResult r11 = (ExceptionResult) r10.getSecond();
        if (r11 == null) goto L42;
    L44:
        if ((!r7.isEmpty()) == false) goto L58;
        e(new DownloadEffectListTask$onFail$1(this, r11));
        return;
    L58:
        return;
    L42:
        r11 = new ExceptionResult(10002);
        goto L44
    }

    public final void g(Effect r5) {
        this.i.add(r5.getId());
        String r0 = q.a();
        b r1 = new b(this);
        this.l.N.b(r0, r1);
        DownloadEffectTask r2 = new DownloadEffectTask(r5, this.l, r0, this.o);
        q1 r6 = this.l.D;
        if (r6 == null) goto L6;
        r6.a(r2);
        return;
    }

    public u(EffectConfig r2, List<? extends Effect> r3, String r4, com.ss.ugc.effectplatform.model.a r5) {
        super(r4, r2.N);
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
        this.g = new z.a(true);
        this.h = new z.a(true);
        this.i = new z.a(true);
        this.j = new z.a(true);
        this.k = new z.a(true);
        HashSet r6 = new HashSet();
        Iterator<? extends Effect> r7 = r3.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Effect r8 = r7.next();
        String r9 = com.ss.ugc.effectplatform.model.b.a(r8);
        if (r6.contains(r9) == true) goto L4;
        this.g.add(r8);
        r6.add(r9);
        goto L4
    L8:
        this.h.addAll(this.g);
    }
}
