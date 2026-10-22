package com.bytedance.ai.lynx;

import android.content.Context;
import com.bytedance.ai.resource.AppletResourceTool;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p extends com.bytedance.ai.applet.render.core.lynx.b {
    public final String b;
    public final String c;

    @Override // com.bytedance.ai.applet.render.core.lynx.b
    public final void d(String r10, final e8a.a<h8a.b> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        String r0 = this.c;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        String r12 = r10;
    L12:
        com.bytedance.ai.utils.g.a.i("AppletResourceLoader", "AppletTemplateResourceFetcher start to load " + r10 + ", realUrl: " + r12);
        AppletResourceTool r13 = AppletResourceTool.a;
        String r14 = this.b;
        Function1 r15 = new n(r11, this);
        Function1 r16 = new o(r11, this);
        r13.getClass();
        AppletResourceTool.q(r14, r12, r15, r16, false);
        return;
    L11:
        r12 = AppletResourceTool.a.g(r10, this.c);
        goto L12
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public p(Context r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        this.b = r11;
        this.c = r12;
    }
}
