package com.bytedance.ai.applet.render.core.lynx;

import com.lynx.tasm.q1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m extends q1 {
    public final /* synthetic */ LynxRenderView a;

    public final void onLynxViewAndJSRuntimeDestroy() {
        com.bytedance.ai.applet.base.log.a.a("LynxRenderView", "onLynxViewAndJSRuntimeDestroy");
        this.a.getBridge().g();
    }

    public m(LynxRenderView r1) {
        this.a = r1;
    }
}
