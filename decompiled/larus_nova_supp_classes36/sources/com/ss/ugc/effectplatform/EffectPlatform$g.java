package com.ss.ugc.effectplatform;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class EffectPlatform$g implements IEffectPlatformBaseListener<List<? extends Effect>> {
    public final /* synthetic */ EffectPlatform a;
    public final /* synthetic */ IEffectPlatformBaseListener b;

    public final void onSuccess(Object r7) {
        EffectPlatform r0 = this.a;
        EffectPlatform.downloadEffectList$default(r0, (List) r7, this.b, null, 4, null);
    }

    public EffectPlatform$g(EffectPlatform r1, IEffectPlatformBaseListener r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFail(Object r2, ExceptionResult r3) {
        List r4 = (List) r2;
        IEffectPlatformBaseListener r0 = this.b;
        if (r0 == null) goto L6;
        r0.onFail(r4, r3);
        return;
    }
}
