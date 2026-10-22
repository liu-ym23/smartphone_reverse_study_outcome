package com.ss.ugc.effectplatform;

import bytekn.foundation.io.file.FileManager;
import com.ss.ugc.effectplatform.cache.j;
import com.ss.ugc.effectplatform.task.BaseTask;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class EffectPlatform$c extends BaseTask {
    public final /* synthetic */ EffectPlatform g;

    public final void b() {
    }

    public final void a() {
        j r0 = (j) this.g.getEffectConfig().A.a;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        c0.e r1 = com.ss.ugc.effectplatform.algorithm.c.a;
        r1.a();
        com.ss.ugc.effectplatform.algorithm.c.b.clear();     // Catch: Throwable -> L15
        com.ss.ugc.effectplatform.algorithm.c.c.b(false);     // Catch: Throwable -> L15
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r1.b();
        String r3 = FileManager.a;     // Catch: Exception -> L12
        FileManager.o(this.g.getEffectConfig().j);     // Catch: Exception -> L12
        com.ss.ugc.effectplatform.preload.b.a r4 = com.ss.ugc.effectplatform.preload.b.d;     // Catch: Exception -> L12
        Object r5 = this.g.getEffectConfig().G;     // Catch: Exception -> L12
        r4.getClass();     // Catch: Exception -> L12
        com.ss.ugc.effectplatform.preload.b r6 = com.ss.ugc.effectplatform.preload.b.a.a(r5);     // Catch: Exception -> L12
        if (r6 == null) goto L22;
        r6.b();     // Catch: Exception -> L12
        return;
    L22:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L15:
        th = move-exception;
        r1.b();
        throw th;
    }

    public EffectPlatform$c(EffectPlatform r1, String r2) {
        this.g = r1;
        super(r2, null);
    }
}
