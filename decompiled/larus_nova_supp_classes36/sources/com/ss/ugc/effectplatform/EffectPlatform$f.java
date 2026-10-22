package com.ss.ugc.effectplatform;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class EffectPlatform$f implements IEffectPlatformBaseListener<Effect> {
    public final /* synthetic */ EffectPlatform a;
    public final /* synthetic */ IEffectPlatformBaseListener b;

    public final void onSuccess(Object r3) {
        EffectPlatform r0 = this.a;
        r0.fetchEffect((Effect) r3, new c(this));
    }

    public EffectPlatform$f(EffectPlatform r1, IEffectPlatformBaseListener r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFail(Object r2, ExceptionResult r3) {
        Effect r4 = (Effect) r2;
        IEffectPlatformBaseListener r0 = this.b;
        if (r0 == null) goto L6;
        r0.onFail(r4, r3);
        return;
    }
}
