package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.task.BaseTask;
import java.util.Map;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends BaseTask {
    public final /* synthetic */ AlgorithmRepository g;
    public final /* synthetic */ String[] h;
    public final /* synthetic */ Map i;
    public final /* synthetic */ IEffectPlatformBaseListener j;

    public final void b() {
    }

    public final void a() {
        this.g.d().c(ArraysKt.toList(this.h), this.i);     // Catch: Exception -> L6
        IEffectPlatformBaseListener r0 = this.j;     // Catch: Exception -> L6
        if (r0 == null) goto L13;
        r0.onSuccess(Long.valueOf(this.g.e().getEffectHandle()));     // Catch: Exception -> L6
        return;
    L13:
        return;
    L6:
        e = move-exception;
        IEffectPlatformBaseListener r1 = this.j;
        if (r1 == null) goto L14;
        r1.onFail(null, new ExceptionResult(e));
        return;
    }

    public a(AlgorithmRepository r1, String[] r2, Map r3, IEffectPlatformBaseListener r4, String r5) {
        this.g = r1;
        this.h = r2;
        this.i = r3;
        this.j = r4;
        super(r5, null);
    }
}
