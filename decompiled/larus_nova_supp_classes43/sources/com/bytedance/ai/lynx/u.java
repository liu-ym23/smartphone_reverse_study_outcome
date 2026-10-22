package com.bytedance.ai.lynx;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u extends com.bytedance.ai.applet.render.core.lynx.b {
    public final com.bytedance.ai.applet.render.core.lynx.o b;

    public static final class a {
    }

    static {
    }

    public u(Context r10, com.bytedance.ai.applet.render.core.lynx.o r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        this.b = r11;
    }

    @Override // com.bytedance.ai.applet.render.core.lynx.b
    public final void d(final String r10, final e8a.a<h8a.b> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        com.bytedance.ai.applet.render.core.lynx.o r0 = this.b;
        if (r0 != null) goto L6;
        com.bytedance.ai.applet.base.log.b r1 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("RenderTemplateResourceFetcher", "fetchRemoteTemplate: loader is null, url = " + r10, null);
        r11.onResponse(com.bytedance.ai.applet.render.core.lynx.b.c(new IllegalArgumentException("unsupported template url: " + r10)));
        return;
    L6:
        com.bytedance.ai.applet.base.log.b r12 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("RenderTemplateResourceFetcher", "fetchRemoteTemplate: start to load " + r10);
        r0.b(r10, new s(r10, r11), new t(r11, this));
    }
}
