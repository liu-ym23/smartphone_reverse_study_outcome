package com.bytedance.ai.applet.components.view;

import com.bytedance.ai.applet.render.core.lynx.LynxRenderView;
import com.bytedance.ai.applet.render.core.webview.EmbedWebView;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import z2.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g extends com.lynx.tasm.behavior.a {
    public final /* synthetic */ Ref.ObjectRef<LynxRenderView> a;

    public g(Ref.ObjectRef<LynxRenderView> r1) {
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
        final Ref.ObjectRef<LynxRenderView> r11 = this.a;
        l r12 = new l(r10, r1, new a3.a(new f(r11)));
        EmbedWebView r13 = new EmbedWebView(r10);
        Intrinsics.checkNotNullParameter(r12, "service");
        r13.b = r12;
        return r13;
    L6:
        r1 = "";
        goto L7
    }
}
