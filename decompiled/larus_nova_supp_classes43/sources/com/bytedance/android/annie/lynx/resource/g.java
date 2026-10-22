package com.bytedance.android.annie.lynx.resource;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements Runnable {
    public final /* synthetic */ LynxTemplateProvider a;
    public final /* synthetic */ String b;
    public final /* synthetic */ d8a.b.a c;
    public final /* synthetic */ Map<String, Object> d;
    public final /* synthetic */ boolean e;

    public g(LynxTemplateProvider r1, String r10, d8a.b.a r11, Map<String, Object> r12, boolean r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b, this.c, false, this.d, this.e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
