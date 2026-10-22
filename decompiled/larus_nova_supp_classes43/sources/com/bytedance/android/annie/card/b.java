package com.bytedance.android.annie.card;

import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements Runnable {
    public final /* synthetic */ AnnieCard a;
    public final /* synthetic */ String b;

    public b(AnnieCard r1, String r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void a() {
        AnnieCard r0 = this.a;
        if (r0.v == false) goto L6;
        r0.getMAnnieContext().d.e("AnnieCard", "loadScheme() has been invoked during the redirection of " + this.b + ", resulting in onRedirectSuccess() directly return!");
        return;
    L6:
        UriProtector.parse(this.b);
        AnnieCard r1 = this.a;
        if (r1.w == true) goto L10;
        r1.getMAnnieContext().d.e("AnnieCard", "load() has not been invoked during the redirection of " + this.b + ". Only parameters and views will be initialized!");
        this.a.setMHybridParamVoNew(com.bytedance.android.annie.param.c.a(UriProtector.parse(this.b), null));
        this.a.m();
        return;
    L10:
        r1.a(UriProtector.parse(this.b), null);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
