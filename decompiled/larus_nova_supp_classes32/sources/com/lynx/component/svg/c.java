package com.lynx.component.svg;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.serval.svg.SVGRender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements Runnable {
    public final /* synthetic */ com.lynx.component.svg.a a;

    public class a implements SVGRender.c {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // com.lynx.serval.svg.SVGRender.c
        public final void a(String r3, SVGRender.a r4) {
            this.a.a.s.b(r3, new b(r4));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (this.a.v == true) goto L10;
        SVGRender r0 = new SVGRender();     // Catch: Throwable -> L7
        r0.setResourceManager(new a(this));     // Catch: Throwable -> L7
        this.a.r = r0;     // Catch: Throwable -> L7
        return;
    }

    public c(com.lynx.component.svg.a r1) {
        this.a = r1;
    }
}
