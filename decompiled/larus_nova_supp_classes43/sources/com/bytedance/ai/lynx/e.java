package com.bytedance.ai.lynx;

import com.bytedance.ai.resource.AppletResourceTool;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceRequest;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e extends d8a.k<Object, byte[]> {
    public final String a;
    public final String b;

    public e(String r1, String r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void request(final LynxResourceRequest<Object> r10, final LynxResourceCallback<byte[]> r11) {
        Intrinsics.checkNotNullParameter(r10, "request");
        Intrinsics.checkNotNullParameter(r11, "callback");
        String r0 = this.b;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        String r12 = r10.a;
    L12:
        com.bytedance.ai.utils.g.a.i("AppletResourceLoader", "AppletExternalJSProvider start to load " + r10.a + ", realUrl: " + r12);
        AppletResourceTool r13 = AppletResourceTool.a;
        String r14 = this.a;
        Intrinsics.checkNotNull(r12);
        Function1 r15 = new c(r10, r11);
        Function1 r16 = new d(r10, r11);
        r13.getClass();
        AppletResourceTool.q(r14, r12, r15, r16, false);
        return;
    L11:
        r12 = AppletResourceTool.a.g(r10.a, this.b);
        goto L12
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
