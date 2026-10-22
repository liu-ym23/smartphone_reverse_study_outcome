package com.ss.ugc.effectplatform.algorithm;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.task.BaseTask;
import com.ss.ugc.effectplatform.task.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AlgorithmResourceManager$Companion$a extends BaseTask {
    public final /* synthetic */ int g;

    public final void b() {
    }

    public final void a() {
        x0.a r0 = x0.k;     // Catch: Exception -> L4
        EffectConfig r1 = AlgorithmResourceManager.Companion.getInstance().getEffectConfig();     // Catch: Exception -> L4
        r0.getClass();     // Catch: Exception -> L4
        x0.a.b(r1).a(this.g, false);     // Catch: Exception -> L4
        return;
    }

    public AlgorithmResourceManager$Companion$a(int r1, String r2) {
        this.g = r1;
        super(r2, null);
    }
}
