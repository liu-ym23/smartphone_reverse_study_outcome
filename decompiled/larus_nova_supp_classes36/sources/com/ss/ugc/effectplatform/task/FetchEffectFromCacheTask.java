package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FetchEffectFromCacheTask extends BaseTask {
    public final EffectConfig g;
    public final Effect h;
    public final String i;

    public final void a() {
        if (this.h != null) goto L5;
    L6:
        final ExceptionResult r0 = new ExceptionResult(10003);
        e(new FetchEffectFromCacheTask$onFail$1(this, r0));
    L7:
        com.ss.ugc.effectplatform.cache.j r1 = (com.ss.ugc.effectplatform.cache.j) this.g.A.a;
        if (r1 == null) goto L23;
        final Effect r2 = this.h;
        if (r2 == null) goto L24;
    L16:
        e = move-exception;
        final ExceptionResult r3 = new ExceptionResult(e);
        e(new FetchEffectFromCacheTask$onFail$1(this, r3));
        return;
    L12:
        if (r1.has(r2.getId()) == false) goto L14;
        e(new FetchEffectFromCacheTask$execute$1(this, r2));     // Catch: Exception -> L16
    L19:
        return;
    L14:
        final ExceptionResult r4 = new ExceptionResult(10003);     // Catch: Exception -> L16
        e(new FetchEffectFromCacheTask$onFail$1(this, r4));     // Catch: Exception -> L16
        goto L19
    L24:
        return;
    L23:
        return;
    L5:
        if (this.g.A.a != null) goto L7;
        goto L6
    }

    public final void b() {
        e(new FetchEffectFromCacheTask$onCancel$1(this));
    }

    public FetchEffectFromCacheTask(EffectConfig r2, Effect r3, String r4) {
        super(r4, null);
        this.g = r2;
        this.h = r3;
        this.i = r4;
    }
}
