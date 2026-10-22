package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ReadUpdateTagTask extends BaseTask {
    public final EffectConfig g;
    public final String h;

    public final void a() {
        com.ss.ugc.effectplatform.cache.j r0 = (com.ss.ugc.effectplatform.cache.j) this.g.A.a;
        final HashMap r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.queryToValue("updatetime");
    L6:
        if (r2 != null) goto L18;
        final ExceptionResult r3 = new ExceptionResult(10009);
        e(new ReadUpdateTagTask$onFail$1(this, r3));
        return;
    L18:
        dlc.a r4 = this.g.t;     // Catch: Exception -> L15
        if (r4 == null) goto L11;
        r1 = (HashMap) r4.a.convertJsonToObj(r2, HashMap.class);     // Catch: Exception -> L15
    L11:
        if (r1 == null) goto L13;
        e(new ReadUpdateTagTask$onSuccess$1(this, r1));     // Catch: Exception -> L15
        return;
    L13:
        final ExceptionResult r5 = new ExceptionResult(new IllegalStateException("local file destroy"));     // Catch: Exception -> L15
        e(new ReadUpdateTagTask$onFail$1(this, r5));     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        final ExceptionResult r6 = new ExceptionResult(e);
        e(new ReadUpdateTagTask$onFail$1(this, r6));
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void b() {
        e(new ReadUpdateTagTask$onCancel$1(this));
    }

    public ReadUpdateTagTask(EffectConfig r2, String r3) {
        super(r3, null);
        this.g = r2;
        this.h = r3;
    }
}
