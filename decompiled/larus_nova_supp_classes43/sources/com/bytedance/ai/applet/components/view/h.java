package com.bytedance.ai.applet.components.view;

import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.debug.IAISDKDebugService$d;
import com.lynx.tasm.q1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h extends q1 {
    public final /* synthetic */ IAISDKDebugService$d a;

    public final void onLynxViewAndJSRuntimeDestroy() {
        IAISDKDebugService.a.D(this.a);
    }

    public h(IAISDKDebugService$d r1) {
        this.a = r1;
    }
}
