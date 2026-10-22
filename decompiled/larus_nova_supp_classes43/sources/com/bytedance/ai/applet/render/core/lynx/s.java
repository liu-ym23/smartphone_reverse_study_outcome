package com.bytedance.ai.applet.render.core.lynx;

import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s extends d8a.k<Object, byte[]> {
    public final o a;

    public static final class a {
    }

    static {
    }

    public s(o r10) {
        Intrinsics.checkNotNullParameter(r10, "loader");
        this.a = r10;
    }

    public final void request(final LynxResourceRequest<? super Object> r10, final LynxResourceCallback<byte[]> r11) {
        Intrinsics.checkNotNullParameter(r10, "request");
        Intrinsics.checkNotNullParameter(r11, "callback");
        com.bytedance.ai.applet.base.log.b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("RenderExternalJSProvider", "request: start to load " + r10.a);
        this.a.b(r10.a, new q(r10, r11), new r(r10, r11));
    }
}
