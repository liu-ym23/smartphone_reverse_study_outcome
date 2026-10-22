package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.task.BaseTask;
import java.util.List;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends BaseTask {
    public final /* synthetic */ AlgorithmRepository g;
    public final /* synthetic */ List h;
    public final /* synthetic */ IEffectPlatformBaseListener i;

    public final void a() {
        this.g.d().c(this.h, null);     // Catch: Exception -> L10
        IEffectPlatformBaseListener r1 = this.i;     // Catch: Exception -> L10
        if (r1 == null) goto L16;
        Object[] r2 = this.h.toArray(new String[0]);     // Catch: Exception -> L10
        if (r2 == null) goto L9;
        r1.onSuccess(r2);     // Catch: Exception -> L10
        return;
    L9:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L10
    L16:
        return;
    L10:
        e = move-exception;
        IEffectPlatformBaseListener r3 = this.i;
        if (r3 == null) goto L18;
        r3.onFail(null, new ExceptionResult(e));
        return;
    }

    public final void b() {
    }

    public b(AlgorithmRepository r1, List r2, IEffectPlatformBaseListener r3, String r4) {
        this.g = r1;
        this.h = r2;
        this.i = r3;
        super(r4, null);
    }
}
