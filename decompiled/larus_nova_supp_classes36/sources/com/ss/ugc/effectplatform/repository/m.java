package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m implements IEffectPlatformBaseListener<HashMap<String, String>> {
    public final /* synthetic */ l a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ IEffectPlatformBaseListener d;

    public final void onSuccess(Object r4) {
        HashMap r5 = (HashMap) r4;
        a0.b<z.b<String, String>> r0 = this.a.a;
        if (r0.a != null) goto L5;
        r0.a = new z.b(true);
    L5:
        z.b r1 = (z.b) this.a.a.a;
        if (r1 == null) goto L8;
        r1.putAll(r5);
    L8:
        this.a.a(this.b, this.c, this.d);
    }

    public final void onFail(Object r2, ExceptionResult r3) {
        HashMap r4 = (HashMap) r2;
        a0.b<z.b<String, String>> r5 = this.a.a;
        if (r5.a != null) goto L5;
        r5.a = new z.b(true);
    L5:
        IEffectPlatformBaseListener r6 = this.d;
        if (r6 == null) goto L9;
        r6.onSuccess(Boolean.TRUE);
        return;
    }

    public m(l r1, String r2, String r3, IEffectPlatformBaseListener r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
