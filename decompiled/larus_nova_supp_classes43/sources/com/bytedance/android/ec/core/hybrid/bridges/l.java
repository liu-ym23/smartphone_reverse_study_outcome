package com.bytedance.android.ec.core.hybrid.bridges;

import android.app.Activity;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "ec.preloadPdpFull")
public final class l extends b {
    public l() {
    }

    public final void handle(IBDXBridgeContext r10, XBaseParamModel r11, CompletionBlock r12) {
        b.InterfaceC0134b r13 = (b.InterfaceC0134b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Activity r14 = r10.getOwnerActivity();
        String r15 = r13.getSchema();
        if (r14 == null) goto L8;
        if (r15 == null) goto L8;
        int r0 = ECSdk.a;
        ca3.c r1 = (ca3.c) ECSdk.a(ca3.c.class);
        if (r1 == null) goto L8;
        r1.a(r14, r15);
    L8:
        CompletionBlock.DefaultImpls.onSuccess$default(r12, ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class)), null, 2, null);
    }
}
