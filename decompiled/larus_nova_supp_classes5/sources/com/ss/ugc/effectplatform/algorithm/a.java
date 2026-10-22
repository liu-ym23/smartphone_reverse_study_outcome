package com.ss.ugc.effectplatform.algorithm;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.download.DownloadType;
import com.ss.ugc.effectplatform.k;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.task.algorithm.FetchModelTask;
import com.ss.ugc.effectplatform.task.o1;
import com.ss.ugc.effectplatform.task.x0;
import com.ss.ugc.effectplatform.task.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a implements blc.a {
    public final com.ss.ugc.effectplatform.task.algorithm.c a;
    public final k b;
    public final EffectConfig c;
    public final x0 d;
    public final d e;
    public final com.ss.ugc.effectplatform.cache.a f;

    @Override // blc.a
    public final o1<nlc.a> a(blc.b r10) {
        EffectConfig r0 = this.c;
        com.ss.ugc.effectplatform.download.f.a r1 = new com.ss.ugc.effectplatform.download.f.a();
        Object r2 = r0.u.a;
        if (r2 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        r1.b = (INetworkClient) r2;
        r1.d = new com.ss.ugc.effectplatform.download.h(r10, r0);
        Effect r3 = r10.a;
        r1.a = new com.ss.ugc.effectplatform.download.i(r3);
        r1.e = r3.getZipPath();
        r1.c = DownloadType.EFFECT;
        y r4 = new y(r10, r1.a(), r0);
        r10.e = this.b;
        return new com.ss.ugc.effectplatform.task.algorithm.c(r4, r10, this.d, this.e, this.f, this.c);
    }

    public static Collection b(a r14, String[] r15) {
        x0.k.getClass();
        com.ss.ugc.effectplatform.model.c r0 = x0.b(x0.a.a(), 0);
        if (r0 == null) goto L13;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L6
        com.ss.ugc.effectplatform.task.algorithm.c r16 = r14.a;     // Catch: Throwable -> L6
        r16.getClass();     // Catch: Throwable -> L6
        Object r17 = Result.constructor-impl(new FetchModelTask(r16.l, r16.i, r16.j, r16.k, null, 0, null, null, null, 2032).g(0, r15, r0));     // Catch: Throwable -> L6
    L8:
        ArrayList r18 = new ArrayList();
        if (Result.isFailure-impl(r17) == false) goto L16;
        r17 = r18;
    L16:
        return (Collection) r17;
    L6:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    L13:
        return new ArrayList();
    }

    public final void c(List<String> r86, Map<String, ? extends List<String>> r87) {
        com.ss.ugc.effectplatform.task.algorithm.c r3 = this.a;
        r3.getClass();
        Effect r15 = new Effect(null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, false, null, false, null, null, 0, null, null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, 0, null, null, 0, null, null, 0, 0, 0, -1, -1, 15, null);
        r15.setEffect_id("1111111");
        r15.setPanel("model");
        r15.setName("Stub");
        if (r86 == null) goto L5;
        r15.setRequirements(r86);
    L5:
        int r0 = bytekn.foundation.utils.a.a;
        if (r87 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L22;
        dlc.a r2 = r3.l.t;
        if (r2 == null) goto L20;
        if (r87 != null) goto L17;
        Intrinsics.throwNpe();
    L17:
        String r4 = r2.a.convertObjToJson(r87);
        if (r4 == null) goto L20;
    L21:
        r15.setModel_names(r4);
    L20:
        r4 = "";
    L22:
        com.ss.ugc.effectplatform.task.algorithm.c.k(r3, new blc.b(r15, null, null));
        return;
    L8:
        if (r87.isEmpty() == true) goto L11;
        r1 = false;
        goto L12
    }

    public a(EffectConfig r9, x0 r10, d r11, com.ss.ugc.effectplatform.cache.a r12) {
        this.c = r9;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.a = new com.ss.ugc.effectplatform.task.algorithm.c(null, null, r10, r11, r12, r9);
        int r13 = r9.y + 8;
        Logger.INSTANCE.d("JKL", "[初始化][模型线程池][最大并发任务数:" + r13 + ']');
        this.b = glc.a.a(r13, 15000);
    }
}
