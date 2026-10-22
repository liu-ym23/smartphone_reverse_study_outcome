package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.EffectPlatform$d;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements IEffectPlatformBaseListener<Boolean> {
    public final /* synthetic */ e a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ IEffectPlatformBaseListener d;

    public final void onSuccess(Object r23) {
        if (((Boolean) r23).booleanValue() == false) goto L5;
        this.a.b(this.b, this.c, 0, 0, 0, "0", false, null, this.d);
        return;
    L5:
        this.a.b(this.b, this.c, 0, 0, 0, "0", true, null, new f(this));
    }

    public final void onFail(Object r11, ExceptionResult r12) {
        Boolean r13 = (Boolean) r11;
        this.a.b(this.b, this.c, 0, 0, 0, "0", false, null, this.d);
    }

    public g(e r1, String r2, String r3, EffectPlatform$d r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
