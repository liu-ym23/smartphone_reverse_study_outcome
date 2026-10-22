package com.ss.ugc.effectplatform;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class EffectPlatform$e implements IEffectPlatformBaseListener<List<? extends Effect>> {
    public final /* synthetic */ hlc.d a;

    public EffectPlatform$e(hlc.d r1) {
        this.a = r1;
    }

    public final void onSuccess(Object r3) {
        List r4 = (List) r3;
        if ((!r4.isEmpty()) == false) goto L7;
        hlc.d r0 = this.a;
        if (r0 == null) goto L11;
        r0.onSuccess(ListProtector.get(r4, 0));
        return;
    L11:
        return;
    L7:
        hlc.d r5 = this.a;
        if (r5 == null) goto L13;
        r5.onFail(null, new ExceptionResult(1));
        return;
    }

    public final void onFail(Object r2, ExceptionResult r3) {
        List r4 = (List) r2;
        hlc.d r5 = this.a;
        if (r5 == null) goto L6;
        r5.onFail(null, r3);
        return;
    }
}
