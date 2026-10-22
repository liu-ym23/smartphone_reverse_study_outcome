package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements IEffectPlatformBaseListener<HashMap<String, String>> {
    public final /* synthetic */ l a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ hlc.f e;

    public final void onSuccess(Object r5) {
        HashMap r6 = (HashMap) r5;
        a0.b<z.b<String, String>> r0 = this.a.a;
        if (r0.a != null) goto L5;
        r0.a = new z.b(true);
    L5:
        z.b r1 = (z.b) this.a.a.a;
        if (r1 == null) goto L8;
        r1.putAll(r6);
    L8:
        this.a.b(this.b, this.c, this.d, this.e);
    }

    public final void onFail(Object r2, ExceptionResult r3) {
        HashMap r4 = (HashMap) r2;
        a0.b<z.b<String, String>> r5 = this.a.a;
        if (r5.a != null) goto L6;
        r5.a = new z.b(true);
        return;
    }

    public n(l r1, String r2, String r3, String r4, hlc.f r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
