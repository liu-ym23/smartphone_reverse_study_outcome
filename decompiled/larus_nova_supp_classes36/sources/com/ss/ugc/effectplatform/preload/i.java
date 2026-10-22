package com.ss.ugc.effectplatform.preload;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.download.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements j {
    public final EffectConfig a;
    public final String b;

    public final boolean a(String r9) {
        com.ss.ugc.effectplatform.util.i r0 = com.ss.ugc.effectplatform.util.i.a;
        boolean r1 = false;
        if (com.ss.ugc.effectplatform.util.i.g(r9) == null) goto L21;
        String r2 = com.ss.ugc.effectplatform.util.i.a(this.b);
        if (r2 == null) goto L21;
        String r3 = FileManager.a;     // Catch: Exception -> L18
        FileManager.o(r2);     // Catch: Exception -> L18
        if (this.a.p == false) goto L9;
        boolean r4 = FileManager.r(r9, r2);     // Catch: Exception -> L18
    L10:
        if (r4 == true) goto L12;
    L14:
        FileManager.o(r9);     // Catch: Exception -> L18
        if (r1 == true) goto L17;
        FileManager.o(r2);     // Catch: Exception -> L18
        FileManager.o(this.b);     // Catch: Exception -> L18
    L17:
        return r1;
    L12:
        if (com.ss.ugc.effectplatform.util.i.h(r2, this.b, true) == false) goto L14;
        r1 = true;
        goto L14
    L9:
        r4 = FileManager.q(r9, r2);     // Catch: Exception -> L18
    L18:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "JKL", "[预加载][解压][失败][" + r9 + ']', null, 4, null);
        String r10 = FileManager.a;
        FileManager.o(r2);
        FileManager.o(this.b);
        throw e;
    L21:
        return false;
    }

    public i(EffectConfig r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
