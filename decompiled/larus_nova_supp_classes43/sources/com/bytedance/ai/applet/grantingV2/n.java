package com.bytedance.ai.applet.grantingV2;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class n implements Function1 {
    public final /* synthetic */ String a;

    public /* synthetic */ n(String r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        String r0 = this.a;
        if (((Boolean) r10).booleanValue() == false) goto L5;
        com.bytedance.ai.utils.g.a.d("McpGrantingManagerV2", "handleExpiredCardOnBind: Successfully for msgID=" + r0);
    L7:
        return Unit.INSTANCE;
    L5:
        com.bytedance.ai.utils.g.a.e("McpGrantingManagerV2", "handleExpiredCardOnBind: Failed for msgID=" + r0);
        goto L7
    }
}
