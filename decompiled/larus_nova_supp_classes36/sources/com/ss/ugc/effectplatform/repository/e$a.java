package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.QueryCustomizedEffectsData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e$a implements IEffectPlatformBaseListener<QueryCustomizedEffectsData> {
    public final /* synthetic */ e a;
    public final /* synthetic */ IEffectPlatformBaseListener b;

    public final void onSuccess(Object r2) {
        QueryCustomizedEffectsData r3 = (QueryCustomizedEffectsData) r2;
        this.a.a.getClass();
        this.a.a.getClass();
        IEffectPlatformBaseListener r0 = this.b;
        if (r0 == null) goto L6;
        r0.onSuccess(r3);
        return;
    }

    public e$a(e r1, IEffectPlatformBaseListener r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFail(Object r2, ExceptionResult r3) {
        QueryCustomizedEffectsData r4 = (QueryCustomizedEffectsData) r2;
        IEffectPlatformBaseListener r0 = this.b;
        if (r0 == null) goto L6;
        r0.onFail(r4, r3);
        return;
    }
}
