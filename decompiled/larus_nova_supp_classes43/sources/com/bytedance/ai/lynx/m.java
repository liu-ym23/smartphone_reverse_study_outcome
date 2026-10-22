package com.bytedance.ai.lynx;

import com.bytedance.ai.applet.render.core.webview.EmbedWebView;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import d3.a0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m extends com.lynx.tasm.behavior.a {
    public final /* synthetic */ Function0<a0> a;

    /* JADX WARN: Multi-variable type inference failed */
    public m(Function0<? extends a0> r1) {
        this.a = r1;
        super("embed-webview");
    }

    public final LynxUI<?> createUI(LynxContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        IHostContextDepend r0 = r4.a.a;
        if (r0 == null) goto L6;
        String r1 = r0.getAppUaName();
        if (r1 == null) goto L6;
    L7:
        z2.l r11 = new z2.l(r10, r1, new a3.a(this.a));
        EmbedWebView r12 = new EmbedWebView(r10);
        Intrinsics.checkNotNullParameter(r11, "service");
        r12.b = r11;
        return r12;
    L6:
        r1 = "";
        goto L7
    }
}
