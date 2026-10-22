package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class WriteUpdateTagTask extends BaseTask {
    public final EffectConfig g;
    public final String h;
    public final z.b<String, String> i;

    public static final class a {
    }

    static {
    }

    public final void a() {
        HashMap r0 = new HashMap();
        z.b<String, String> r1 = this.i;
        if (r1 == null) goto L18;
        r0.putAll(r1);
    L18:
        dlc.a r2 = this.g.t;     // Catch: Exception -> L15
        if (r2 == null) goto L8;
        String r3 = r2.a.convertObjToJson(r0);     // Catch: Exception -> L15
    L9:
        if (r3 == null) goto L13;
        com.ss.ugc.effectplatform.cache.j r4 = (com.ss.ugc.effectplatform.cache.j) this.g.A.a;     // Catch: Exception -> L15
        if (r4 == null) goto L13;
        r4.save("updatetime", r3);     // Catch: Exception -> L15
    L13:
        e(new WriteUpdateTagTask$onSuccess$1(this));     // Catch: Exception -> L15
        return;
    L8:
        r3 = null;
    L15:
        e = move-exception;
        final ExceptionResult r5 = new ExceptionResult(e);
        e(new WriteUpdateTagTask$onFail$1(this, r5));
        Logger.e$default(Logger.INSTANCE, "WriteUpdateTagTask", String.valueOf(e), null, 4, null);
    }

    public final void b() {
        e(new WriteUpdateTagTask$onCancel$1(this));
    }

    public WriteUpdateTagTask(EffectConfig r2, String r3, z.b<String, String> r4) {
        super(r3, null);
        this.g = r2;
        this.h = r3;
        this.i = r4;
    }
}
