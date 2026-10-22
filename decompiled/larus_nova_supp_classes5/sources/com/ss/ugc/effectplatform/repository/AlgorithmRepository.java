package com.ss.ugc.effectplatform.repository;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.algorithm.AlgorithmResourceFinder;
import com.ss.ugc.effectplatform.cache.j;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import com.ss.ugc.effectplatform.task.algorithm.FetchModelTask;
import com.ss.ugc.effectplatform.task.q1;
import com.ss.ugc.effectplatform.task.x0;
import com.ss.ugc.effectplatform.util.PlatformType;
import com.ss.ugc.effectplatform.util.k;
import com.ss.ugc.effectplatform.util.n;
import kotlin.jvm.internal.Intrinsics;
import z.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class AlgorithmRepository {
    public static AlgorithmRepository g;
    public final x0 a;
    public com.ss.ugc.effectplatform.algorithm.a b;
    public final com.ss.ugc.effectplatform.cache.a c;
    public final com.ss.ugc.effectplatform.algorithm.d d;
    public AlgorithmResourceFinder e;
    public final EffectConfig f;

    public static final class a {
        public static AlgorithmRepository a() {
            AlgorithmRepository r0 = AlgorithmRepository.g;
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new RuntimeException("Please initialize AlgorithmRepository first!");
        }
    }

    static {
    }

    public final com.ss.ugc.effectplatform.algorithm.a d() {
        com.ss.ugc.effectplatform.algorithm.a r0 = this.b;
        if (r0 != null) goto L7;
        com.ss.ugc.effectplatform.algorithm.a r1 = new com.ss.ugc.effectplatform.algorithm.a(this.f, this.a, this.d, this.c);
        this.b = r1;
        return r1;
    L7:
        return r0;
    }

    public final AlgorithmResourceFinder e() {
        AlgorithmResourceFinder r0 = this.e;
        if (r0 != null) goto L7;
        com.ss.ugc.effectplatform.cache.a r1 = this.c;
        com.ss.ugc.effectplatform.algorithm.d r2 = this.d;
        this.f.getClass();
        AlgorithmResourceFinder r3 = new AlgorithmResourceFinder(r1, r2, null);
        this.e = r3;
        return r3;
    L7:
        return r0;
    }

    public AlgorithmRepository(EffectConfig r14) {
        this.f = r14;
        com.ss.ugc.effectplatform.algorithm.d r6 = new com.ss.ugc.effectplatform.algorithm.d(r14.G, r14.I, r14.c0);
        this.d = r6;
        x0.k.getClass();
        this.a = x0.a.b(r14);
        b<String, j> r0 = com.ss.ugc.effectplatform.cache.h.a;
        j r1 = com.ss.ugc.effectplatform.cache.h.a(r14.K);
        if (r1 != null) goto L5;
    L8:
        com.ss.ugc.effectplatform.cache.a r7 = new com.ss.ugc.effectplatform.cache.a(r14, r14.K, r14.j, r14.Q.hashCode(), r6);
        this.c = r7;
        String r2 = r14.K;
        com.ss.ugc.effectplatform.cache.h.a.put(r2, r7);
    L10:
        if (r14.V == false) goto L15;
        FetchModelTask r11 = new FetchModelTask(r14, null, r6, this.c, null, 0, null, null, null, 2016);
        q1 r15 = r14.D;
        if (r15 == null) goto L16;
        r15.a(r11);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if ((r1 instanceof com.ss.ugc.effectplatform.cache.a) == false) goto L8;
        this.c = (com.ss.ugc.effectplatform.cache.a) r1;
        goto L10
    }

    public final boolean a(Effect r20) {
        if (com.ss.ugc.effectplatform.util.a.b(r20) == false) goto L6;
        Logger.e$default(Logger.INSTANCE, "AlgorithmRepository", "decrypt error effect: " + r20.getEffect_id() + ", name: " + r20.getName() + ", requirements_sec: " + r20.getRequirements_sec(), null, 4, null);
        return false;
    L6:
        EffectConfig r0 = this.f;
        String[] r1 = com.ss.ugc.effectplatform.util.a.a(r20, r0.t, r0.G);
        if (r1 != null) goto L9;
    L15:
        boolean r6 = true;
    L16:
        if (r6 == false) goto L19;
        Logger.INSTANCE.d("AlgorithmRepository", "effect: " + r20.getEffect_id() + ", name: " + r20.getName() + " returned empty resourceNameArrayOfEffect");
        return true;
    L19:
        this.c.e();
        int r2 = r1.length;
        int r5 = 0;
    L20:
        if (r5 >= r2) goto L58;
        String r7 = r1[r5];
        if (com.ss.ugc.effectplatform.algorithm.c.c.a() == false) goto L54;
        String r8 = k.d(r7);
        if (this.f.V == false) goto L26;
        r8 = bytekn.foundation.utils.c.a(r8);
    L26:
        int r9 = n.a;
        if (PlatformType.ANDROID == PlatformType.PC) goto L51;
        if (r8 == null) goto L51;
        c0.e r10 = com.ss.ugc.effectplatform.algorithm.c.a;
        r10.a();
        com.ss.ugc.effectplatform.algorithm.h r11 = (com.ss.ugc.effectplatform.algorithm.h) com.ss.ugc.effectplatform.algorithm.c.b.get(r8);     // Catch: Throwable -> L48
        r10.b();
        if (r11 != null) goto L35;
        Logger.e$default(Logger.INSTANCE, "AlgorithmModelInfoMemoryCache", "model: " + r8 + " not in cache!", null, 4, null);
        goto L51
    L35:
        com.ss.ugc.effectplatform.model.d r12 = r11.a;
        ModelInfo r13 = r11.b;
        if ((!Intrinsics.areEqual(r12.d(), r13.getVersion())) == false) goto L39;
        Logger.e$default(Logger.INSTANCE, "AlgorithmModelInfoMemoryCache", "model: " + r8 + " version not match. local version: " + r12.d() + ", server version: " + r13.getVersion(), null, 4, null);
        goto L51
    L39:
        if (r12.e == false) goto L42;
    L47:
        boolean r14 = true;
    L52:
        if (r14 == true) goto L55;
        r14 = b(r7);
    L55:
        if (r14 == false) goto L56;
        r5 = r5 + 1;
        goto L20
    L56:
        return false;
    L42:
        if (r12.c() == r13.getType()) goto L45;
        Logger.e$default(Logger.INSTANCE, "AlgorithmModelInfoMemoryCache", "model: " + r8 + " size not match. local size: " + r12.c() + ", server size: " + r13.getType(), null, 4, null);
        goto L51
    L45:
        if ((!Intrinsics.areEqual(r12.a(), ilc.b.a(r13))) == false) goto L47;
        Logger.e$default(Logger.INSTANCE, "AlgorithmModelInfoMemoryCache", "model: " + r8 + " md5 not match. local md5: " + r12.a() + ", server md5: " + ilc.b.a(r13), null, 4, null);
    L48:
        th = move-exception;
        r10.b();
        throw th;
    L51:
        r14 = false;
        goto L52
    L54:
        r14 = b(r7);
        goto L55
    L58:
        return true;
    L9:
        if (r1.length != 0) goto L11;
        boolean r15 = true;
    L12:
        if (r15 == true) goto L15;
        r6 = false;
        goto L16
    L11:
        r15 = false;
        goto L12
    }

    public final boolean b(String r5) {
        boolean r0 = e().isResourceAvailable(r5);
        if (com.ss.ugc.effectplatform.algorithm.a.b(d(), new String[]{r5}).isEmpty() == false) goto L5;
        return r0;
    L5:
        return false;
    }

    public final void f(long r3) {
        this.c.a(r3, new removeUnused.1(this));
    }

    public final void c(int r14, String[] r15, com.ss.ugc.effectplatform.a r16, IEffectPlatformBaseListener<String[]> r17) {
        FetchModelTask r12 = new FetchModelTask(this.f, this.a, this.d, this.c, r15, r14, null, r16, null, 1856);
        q1 r1 = this.f.D;
        if (r1 == null) goto L6;
        r1.a(new AlgorithmRepository$fetchResourcesWithModelNames$1(r12, r17, r15));
        return;
    }
}
