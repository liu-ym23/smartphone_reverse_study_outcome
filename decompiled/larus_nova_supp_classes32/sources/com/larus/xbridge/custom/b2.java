package com.larus.xbridge.custom;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.lynx.tasm.LynxError;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b2 implements com.bytedance.ies.bullet.prefetchv2.z.a {
    public final /* synthetic */ CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> a;
    public final /* synthetic */ RequestMethod b;
    public final /* synthetic */ m16.b c;
    public final /* synthetic */ com.bytedance.sdk.xbridge.cn.network.a.b d;
    public final /* synthetic */ long e;

    public final void b(com.bytedance.ies.bullet.prefetchv2.p r14, Throwable r15) {
        Intrinsics.checkNotNullParameter(r14, "request");
        Intrinsics.checkNotNullParameter(r15, LynxError.LYNX_THROWABLE);
        CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r0 = this.a;
        String r1 = r15.toString();
        XBaseResultModel r2 = ne7.e.c(Reflection.getOrCreateKotlinClass(com.bytedance.sdk.xbridge.cn.network.a.c.class));
        com.bytedance.sdk.xbridge.cn.network.a.c r3 = (com.bytedance.sdk.xbridge.cn.network.a.c) r2;
        r3.setHttpCode(-408);
        r3.setClientCode(r3.getClientCode());
        r3.setPrefetchStatus(1);
        r3.setRawResponse(r3.getRawResponse());
        Unit r4 = Unit.INSTANCE;
        r0.onFailure(-688, r1, r2);
        this.b.c(this.c, this.d.getUrl(), false, 1, r15.toString(), System.currentTimeMillis() - this.e, r14.m);
    }

    public final void d(com.bytedance.ies.bullet.prefetchv2.p r13, com.bytedance.ies.bullet.prefetchv2.v r14) {
        Intrinsics.checkNotNullParameter(r13, "request");
        Intrinsics.checkNotNullParameter(r14, "result");
        CompletionBlock.DefaultImpls.onSuccess$default(this.a, h2.a(r14, 1), null, 2, null);
        this.b.c(this.c, this.d.getUrl(), true, 1, "hit pending success", System.currentTimeMillis() - this.e, r14.h);
    }

    public b2(CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r1, RequestMethod r2, m16.b r3, com.bytedance.sdk.xbridge.cn.network.a.b r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
