package com.ss.ugc.effectplatform.task;

import bytekn.foundation.concurrent.executor.AsyncExecutor;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.io.file.f;
import bytekn.foundation.logger.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.algorithm.d;
import com.ss.ugc.effectplatform.cache.j;
import com.ss.ugc.effectplatform.cache.k;
import com.ss.ugc.effectplatform.cache.l;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import com.ss.ugc.effectplatform.model.algorithm.SingleAlgorithmModelResponse;
import com.ss.ugc.effectplatform.model.h;
import com.ss.ugc.effectplatform.task.algorithm.e;
import com.ss.ugc.effectplatform.util.PlatformType;
import com.ss.ugc.effectplatform.util.n;
import com.ss.ugc.effectplatform.util.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class x0 {
    public static final z.b<String, com.ss.ugc.effectplatform.model.c> h = null;
    public static final z.b<String, ModelInfo> i = null;
    public static final a0.b<x0> j = null;
    public static final a k = null;
    public final d a;
    public final z.b<String, Exception> b;
    public final z.b<String, k0> c;
    public final z.b<String, Integer> d;
    public final z.b<String, e> e;
    public final z.b<String, Boolean> f;
    public final EffectConfig g;

    public static final class a {
        public a() {
        }

        public static x0 a() {
            Object r0 = x0.j.a;
            if (r0 == null) goto L7;
            return (x0) r0;
        L7:
            throw new RuntimeException("Please initialize AlgorithmRepository first!");
        }

        public static x0 b(EffectConfig r2) {
            a0.b<x0> r0 = x0.j;
            if (r0.a == null) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L9;
            r0.a = new x0(r2);
        L9:
            return a();
        L5:
            r1 = false;
            goto L6
        }
    }

    public static final class b implements k0.a {
        public final /* synthetic */ x0 a;
        public final /* synthetic */ String b;

        @Override // com.ss.ugc.effectplatform.task.k0.a
        public final void a(h r10) {
            x0.k.getClass();
            z.b<String, com.ss.ugc.effectplatform.model.c> r0 = x0.h;
            String r1 = this.b;
            com.ss.ugc.effectplatform.model.c r2 = r10.a;
            if (r2 != null) goto L34;
            HashMap r3 = new HashMap();
            Iterator r4 = ((ArrayList) r10.b.b()).iterator();
        L7:
            if (r4.hasNext() == false) goto L18;
            ModelInfo r5 = (ModelInfo) r4.next();
            String r6 = r5.getName();
            if (r6 == null) goto L18;
            if (r3.containsKey(r6) == true) goto L13;
            r3.put(r6, r5.getVersion());
            goto L7
        L13:
            if ((!Intrinsics.areEqual((String) r3.get(r6), r5.getVersion())) == false) goto L7;
            throw new RuntimeException("model " + r6 + " has different versions in ServerTable,Please modify the file to the correct format ");
        L18:
            r2 = new com.ss.ugc.effectplatform.model.c();
            bytekn.foundation.utils.d<String, com.ss.ugc.effectplatform.model.c.a> r7 = new bytekn.foundation.utils.d();
            Iterator r8 = r10.b.a.keySet().iterator();
        L20:
            if (r8.hasNext() == false) goto L29;
            String r9 = (String) r8.next();
            ArrayList r11 = (z.a) r10.b.a.get(r9);
            if (r11 != null) goto L25;
            r11 = new ArrayList();
        L25:
            Iterator r12 = r11.iterator();
        L27:
            if (r12.hasNext() == false) goto L20;
            r7.a(r9, new com.ss.ugc.effectplatform.model.c.a((ModelInfo) r12.next()));
            goto L27
        L29:
            r2.a = r7;
            r2.b.clear();
            Iterator r13 = ((ArrayList) r7.b()).iterator();
        L31:
            if (r13.hasNext() == false) goto L33;
            com.ss.ugc.effectplatform.model.c.a r14 = (com.ss.ugc.effectplatform.model.c.a) r13.next();
            r2.b.put(r14.a.getName(), r14.a);
            goto L31
        L33:
            r10.a = r2;
        L34:
            r0.put(r1, r2);
            this.a.c.remove(this.b);
        }

        @Override // com.ss.ugc.effectplatform.task.k0.a
        public final void onFail(Exception r4) {
            this.a.b.put(this.b, r4);
            Logger.INSTANCE.e("FetchModelListTask", "fetch model list error happens!", r4);
            this.a.c.remove(this.b);
            this.a.f.put(this.b, Boolean.FALSE);
        }

        public b(x0 r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ com.ss.ugc.effectplatform.model.c a;
        public final /* synthetic */ x0 b;

        public final void a() {
            c0.e r0 = com.ss.ugc.effectplatform.algorithm.c.a;
            com.ss.ugc.effectplatform.model.c r1 = this.a;
            z.b<String, j> r2 = com.ss.ugc.effectplatform.cache.h.a;
            j r3 = com.ss.ugc.effectplatform.cache.h.a(this.b.g.K);
            if (r3 == null) goto L136;
            com.ss.ugc.effectplatform.cache.a r4 = (com.ss.ugc.effectplatform.cache.a) r3;
            int r5 = n.a;
            if (PlatformType.ANDROID == PlatformType.PC) goto L126;
            z.b r6 = r1.b();
            if (r6 != null) goto L10;
        L13:
            boolean r7 = true;
        L14:
            if (r7 == false) goto L16;
            com.ss.ugc.effectplatform.algorithm.c.c.b(false);
            goto L126
        L16:
            HashMap r8 = new HashMap();
            EffectConfig r9 = r4.k;
            if (r9.T == false) goto L43;
            com.ss.ugc.effectplatform.preload.b.a r10 = com.ss.ugc.effectplatform.preload.b.d;
            Object r11 = r9.G;
            r10.getClass();
            com.ss.ugc.effectplatform.preload.b r12 = com.ss.ugc.effectplatform.preload.b.a.a(r11);
            if (r12 == null) goto L26;
            List r13 = r12.f();
            ArrayList r14 = new ArrayList();
            Iterator r15 = ((ArrayList) r13).iterator();
        L22:
            if (r15.hasNext() == false) goto L27;
            Object r16 = r15.next();
            com.ss.ugc.effectplatform.preload.c r17 = (com.ss.ugc.effectplatform.preload.c) r16;
            if ((!Intrinsics.areEqual(r17.c, r17.d)) == false) goto L22;
            r14.add(r16);
        L27:
            if (r14 == null) goto L43;
            Iterator r18 = r14.iterator();
        L30:
            if (r18.hasNext() == false) goto L43;
            com.ss.ugc.effectplatform.preload.c r19 = (com.ss.ugc.effectplatform.preload.c) r18.next();
            String r110 = r19.a;     // Catch: Exception -> L40
            String r20 = r19.d;     // Catch: Exception -> L40
            StringBuilder r111 = new StringBuilder();     // Catch: Exception -> L40
            r111.append(r4.l);     // Catch: Exception -> L40
            String r112 = FileManager.a;     // Catch: Exception -> L40
            String r113 = FileManager.a;     // Catch: Exception -> L40
            r111.append(r113);     // Catch: Exception -> L40
            r111.append(r110);     // Catch: Exception -> L40
            String r114 = r111.toString();     // Catch: Exception -> L40
            if (FileManager.d(r4.l + r113 + r110) == false) goto L36;
            Logger.INSTANCE.w("JKL", "[预加载][读取][模型列表][已下载][" + r20 + "][" + r110 + ']');     // Catch: Exception -> L40
            com.ss.ugc.effectplatform.model.d r21 = new com.ss.ugc.effectplatform.model.d(r114);     // Catch: Exception -> L40
            r21.e = false;     // Catch: Exception -> L40
            com.ss.ugc.effectplatform.cache.a.h(r8, r20, r21);     // Catch: Exception -> L40
            goto L30
        L36:
            Logger.INSTANCE.w("JKL", "[预加载][读取][模型][文件被意外删除][" + r20 + "][" + r110 + ']');     // Catch: Exception -> L40
            com.ss.ugc.effectplatform.preload.b.a r22 = com.ss.ugc.effectplatform.preload.b.d;     // Catch: Exception -> L40
            Object r23 = r4.k.G;     // Catch: Exception -> L40
            r22.getClass();     // Catch: Exception -> L40
            com.ss.ugc.effectplatform.preload.b r24 = com.ss.ugc.effectplatform.preload.b.a.a(r23);     // Catch: Exception -> L40
            if (r24 == null) goto L30;
            r24.c(r110);     // Catch: Exception -> L40
        L40:
            e = move-exception;
            e.printStackTrace();
            goto L30
        L26:
            r14 = null;
        L43:
            EffectConfig r25 = r4.k;
            if (r25.b0 == false) goto L143;
            l.a r26 = l.c;
            Object r27 = r25.G;
            r26.getClass();
            if (l.a.a(r27) == null) goto L143;
            ArrayList r28 = new ArrayList();
            ArrayList r29 = new ArrayList();
            Iterator r30 = r28.iterator();
        L49:
            if (r30.hasNext() == false) goto L53;
            Object r31 = r30.next();
            String r115 = FileManager.a;
            if (FileManager.d(((k) r31).f) == false) goto L49;
            r29.add(r31);
            goto L49
        L53:
            Iterator r32 = r29.iterator();
        L55:
            if (r32.hasNext() == false) goto L143;
            k r33 = (k) r32.next();
            int r34 = com.ss.ugc.effectplatform.model.d.g;
            com.ss.ugc.effectplatform.model.d r35 = new com.ss.ugc.effectplatform.model.d(r33.f);
            String r36 = r33.l;
            r35.a = r36;
            com.ss.ugc.effectplatform.cache.a.h(r8, r36, r35);
        L143:
            List<String> r37 = r4.m.c("model");     // Catch: Exception -> L75
            if (r37 == null) goto L141;
            Iterator<T> r38 = r37.iterator();     // Catch: Exception -> L75
        L61:
            if (r38.hasNext() == false) goto L141;
            String r39 = (String) r38.next();     // Catch: Exception -> L75
            List<String> r40 = r4.m.c("model/" + r39);     // Catch: Exception -> L75
            if (r40 == null) goto L61;
            Iterator<T> r41 = r40.iterator();     // Catch: Exception -> L75
        L66:
            if (r41.hasNext() == false) goto L61;
            String r42 = (String) r41.next();     // Catch: Exception -> L75
            String r43 = com.ss.ugc.effectplatform.util.k.d(r42);     // Catch: Exception -> L70
        L72:
            if ((!Intrinsics.areEqual(r43, "")) == false) goto L66;
            String r44 = com.ss.ugc.effectplatform.util.k.f(r42);     // Catch: Exception -> L75
            com.ss.ugc.effectplatform.model.d r116 = new com.ss.ugc.effectplatform.model.d("");     // Catch: Exception -> L75
            r116.a = r43;     // Catch: Exception -> L75
            r116.b = r44;     // Catch: Exception -> L75
            r116.e = true;     // Catch: Exception -> L75
            com.ss.ugc.effectplatform.cache.a.h(r8, r43, r116);     // Catch: Exception -> L75
        L70:
            r43 = "";
        L141:
            com.ss.ugc.effectplatform.cache.disklrucache.a r45 = r4.e();     // Catch: Exception -> L96
            if (r45 == null) goto L80;
            Set<String> r46 = r45.f();     // Catch: Exception -> L96
        L81:
            if (r46 == null) goto L99;
            Iterator<T> r47 = r46.iterator();     // Catch: Exception -> L96
        L83:
            if (r47.hasNext() == false) goto L99;
            String r48 = (String) r47.next();     // Catch: Exception -> L96
            String r49 = com.ss.ugc.effectplatform.util.k.d(r48);     // Catch: Exception -> L96
            com.ss.ugc.effectplatform.cache.disklrucache.a r50 = r4.e();     // Catch: Exception -> L96
            if (r50 == null) goto L88;
            com.ss.ugc.effectplatform.cache.disklrucache.a.d r51 = r50.e(r48);     // Catch: Exception -> L96
        L89:
            if (r51 == null) goto L83;
            f r52 = r51.a[0];     // Catch: Exception -> L96
            if (r52 == null) goto L83;
            String r53 = r52.b;     // Catch: Exception -> L96
            if (r53 == null) goto L83;
            com.ss.ugc.effectplatform.model.d r54 = new com.ss.ugc.effectplatform.model.d(r53);     // Catch: Exception -> L96
            r54.e = false;     // Catch: Exception -> L96
            com.ss.ugc.effectplatform.cache.a.h(r8, r49, r54);     // Catch: Exception -> L96
            goto L83
        L88:
            r51 = null;
        L99:
            if (r8.isEmpty() == false) goto L101;
            com.ss.ugc.effectplatform.algorithm.c.c.b(false);
            goto L126
        L101:
            c0.e r55 = com.ss.ugc.effectplatform.algorithm.c.a;
            r55.a();
            Iterator r56 = r6.entrySet().iterator();     // Catch: Throwable -> L132
        L104:
            if (r56.hasNext() == false) goto L124;
            Map.Entry r57 = (Map.Entry) r56.next();     // Catch: Throwable -> L132
            String r58 = (String) r57.getKey();     // Catch: Throwable -> L132
            List r59 = (List) r8.get(r58);     // Catch: Throwable -> L132
            if (r59 == null) goto L104;
            if ((!r59.isEmpty()) == false) goto L104;
            String r60 = ilc.b.a((ModelInfo) r57.getValue());     // Catch: Throwable -> L132
            if (r.b(r60) == true) goto L119;
            Iterator r61 = r59.iterator();     // Catch: Throwable -> L132
        L113:
            if (r61.hasNext() == false) goto L117;
            Object r62 = r61.next();     // Catch: Throwable -> L132
            if (StringsKt.equals$default(r60, ((com.ss.ugc.effectplatform.model.d) r62).a(), false, 2, null) == false) goto L113;
        L118:
            com.ss.ugc.effectplatform.model.d r63 = (com.ss.ugc.effectplatform.model.d) r62;     // Catch: Throwable -> L132
        L120:
            if (r63 != null) goto L122;
            r63 = (com.ss.ugc.effectplatform.model.d) r59.get(r59.size() - 1);     // Catch: Throwable -> L132
        L122:
            com.ss.ugc.effectplatform.algorithm.c.b.put(r58, new com.ss.ugc.effectplatform.algorithm.h(r63, (ModelInfo) r57.getValue()));     // Catch: Throwable -> L132
            goto L104
        L117:
            r62 = null;
            goto L118
        L119:
            r63 = null;
            goto L120
        L124:
            Unit r64 = Unit.INSTANCE;     // Catch: Throwable -> L132
            r55.b();
            com.ss.ugc.effectplatform.algorithm.c.c.b(true);
        L132:
            th = move-exception;
            r55.b();
            throw th;
        L80:
            r46 = null;
        L96:
            e = move-exception;
            Logger.INSTANCE.e("AlgorithmModelCache", "error while getLocalModelInfoList", e);
        L75:
            e = move-exception;
            Logger.INSTANCE.e("AlgorithmModelCache", "getLocalModelInfoList built in error", e);
            goto L141
        L10:
            if (r6.isEmpty() == true) goto L13;
            r7 = false;
        L126:
            l.a r65 = l.c;
            Object r66 = this.b.g.G;
            r65.getClass();
            if (l.a.a(r66) == null) goto L189;
            z.b r67 = this.a.b();
            if (r67 == null) goto L190;
            r67.values();
            return;
        L190:
            return;
        L189:
            return;
        L136:
            throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.cache.AlgorithmModelCache");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(com.ss.ugc.effectplatform.model.c r1, x0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        k = new a();
        h = new z.b(true);
        i = new z.b(true);
        j = new a0.b(null);
    }

    public x0(EffectConfig r4) {
        this.g = r4;
        this.a = new d(r4.G, r4.I, r4.c0);
        this.b = new z.b(true);
        this.c = new z.b(true);
        this.d = new z.b(true);
        this.e = new z.b(true);
        this.f = new z.b(true);
    }

    public static com.ss.ugc.effectplatform.model.c b(x0 r4, int r5) {
        r4.getClass();
        com.ss.ugc.effectplatform.model.c r0 = (com.ss.ugc.effectplatform.model.c) h.get("biz_" + r5);
        if (r0 != null) goto L7;
        Logger.INSTANCE.d("JKL", "[ModelListTask][CreateThread]");
        q1 r1 = r4.g.D;
        if (r1 == null) goto L7;
        r1.b("ModelListTask", new com.ss.ugc.effectplatform.task.b(new ModelConfigArbiter.requireDecidedConfigNonBlocking.1(r4, r5)));
    L7:
        return r0;
    }

    public final synchronized com.ss.ugc.effectplatform.model.c a(int r8, boolean r9) {
        monitor-enter(this);
        String r0 = "biz_" + r8;     // Catch: Throwable -> L37
        z.b<String, com.ss.ugc.effectplatform.model.c> r1 = h;     // Catch: Throwable -> L37
        if (r1.get(r0) != null) goto L34;
        this.f.put(r0, Boolean.TRUE);     // Catch: Throwable -> L37
        z.b<String, Integer> r2 = this.d;     // Catch: Throwable -> L37
        Object r3 = r2.get(r0);     // Catch: Throwable -> L37
        if (r3 != null) goto L8;
        r3 = 0;     // Catch: Throwable -> L37
        r2.put(r0, r3);     // Catch: Throwable -> L37
    L8:
        int r4 = ((Number) r3).intValue();     // Catch: Throwable -> L37
        if (r9 == false) goto L11;
    L12:
        z.b<String, k0> r10 = this.c;     // Catch: Throwable -> L37
        Object r5 = r10.get(r0);     // Catch: Throwable -> L37
        if (r5 != null) goto L15;
        r5 = new k0(this.g, this.a, r8, new b(this, r0));     // Catch: Throwable -> L37
        r10.put(r0, r5);     // Catch: Throwable -> L37
    L15:
        k0 r6 = (k0) r5;     // Catch: Throwable -> L37
        this.d.put(r0, Integer.valueOf(r4 + 1));     // Catch: Throwable -> L37
        c0.e r11 = l0.a;     // Catch: Throwable -> L37
        r11.a();     // Catch: Throwable -> L37
    L31:
        th = move-exception;
        r11.b();     // Catch: Throwable -> L37
        throw th;     // Catch: Throwable -> L37
    L17:
        if (r6.g.a() == true) goto L19;
        r6.run();     // Catch: Throwable -> L31
        r6.g.b(true);     // Catch: Throwable -> L31
    L19:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L31
        r11.b();     // Catch: Throwable -> L37
        com.ss.ugc.effectplatform.model.c r13 = (com.ss.ugc.effectplatform.model.c) r1.get(r0);     // Catch: Throwable -> L37
        if (r13 == null) goto L24;
        new AsyncExecutor().execute(new c(r13, this));     // Catch: Throwable -> L37
    L24:
        if (r1.get(r0) != null) goto L30;
        Exception r14 = (Exception) this.b.get(r0);     // Catch: Throwable -> L37
        if (r14 == null) goto L28;
        throw r14;     // Catch: Throwable -> L37
    L28:
        this.f.put(r0, Boolean.FALSE);     // Catch: Throwable -> L37
        throw new RuntimeException("error happens when requireDecidedConfig");     // Catch: Throwable -> L37
    L30:
        this.f.put(r0, Boolean.FALSE);     // Catch: Throwable -> L37
        goto L34
    L11:
        if (r4 >= this.g.r) goto L24;
    L34:
        com.ss.ugc.effectplatform.model.c r15 = (com.ss.ugc.effectplatform.model.c) r1.get(r0);     // Catch: Throwable -> L37
        monitor-exit(this);
        return r15;
    L37:
        th = move-exception;
        throw th;
    }

    public final synchronized ModelInfo c(int r7, String r8) {
        monitor-enter(this);
        ModelInfo r0 = null;
        if (r8 != null) goto L24;
        monitor-exit(this);
        return null;
    L24:
        z.b<String, ModelInfo> r1 = i;     // Catch: Throwable -> L19
        ModelInfo r2 = (ModelInfo) r1.get(r8);     // Catch: Throwable -> L19
        if (r2 != null) goto L17;
        String r3 = r8 + '_' + r7;     // Catch: Throwable -> L19
        z.b<String, e> r4 = this.e;     // Catch: Throwable -> L19
        Object r5 = r4.get(r3);     // Catch: Throwable -> L19
        if (r5 != null) goto L10;
        r5 = new e(this.g, r8, r7);     // Catch: Throwable -> L19
        r4.put(r3, r5);     // Catch: Throwable -> L19
    L10:
        SingleAlgorithmModelResponse r9 = ((e) r5).g();     // Catch: Throwable -> L19
        if (r9 == null) goto L13;
        r0 = r9.getData();     // Catch: Throwable -> L19
    L13:
        if (r0 == null) goto L15;
        r1.put(r8, r0);     // Catch: Throwable -> L19
    L15:
        this.e.remove(r3);     // Catch: Throwable -> L19
        r2 = r0;
    L17:
        monitor-exit(this);
        return r2;
    L19:
        th = move-exception;
        throw th;
    }

    public final ModelInfo d(int r4, String r5, boolean r6) {
        if (r5 == null) goto L10;
        ModelInfo r0 = (ModelInfo) i.get(r5);
        if (r0 != null) goto L9;
        if (r6 == false) goto L9;
        q1 r7 = this.g.D;
        if (r7 == null) goto L9;
        r7.a(new d(this, r4, r5, com.ss.ugc.effectplatform.util.q.a()));
    L9:
        return r0;
    L10:
        return null;
    }
}
