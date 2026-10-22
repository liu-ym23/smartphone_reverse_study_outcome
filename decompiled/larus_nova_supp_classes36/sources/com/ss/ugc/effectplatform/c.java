package com.ss.ugc.effectplatform;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements hlc.d {
    public final /* synthetic */ EffectPlatform$f a;

    public final void onProgress(Effect r1, int r2, long r3) {
    }

    public final void onStart(Effect r1) {
    }

    public c(EffectPlatform$f r1) {
        this.a = r1;
    }

    public final void onSuccess(Object r2) {
        Effect r3 = (Effect) r2;
        if (r3 == null) goto L8;
        IEffectPlatformBaseListener r0 = this.a.b;
        if (r0 == null) goto L9;
        r0.onSuccess(r3);
        return;
    L9:
        return;
    }

    public final void onFail(Object r2, ExceptionResult r3) {
        Effect r4 = (Effect) r2;
        IEffectPlatformBaseListener r0 = this.a.b;
        if (r0 == null) goto L6;
        r0.onFail(r4, r3);
        return;
    }
}
