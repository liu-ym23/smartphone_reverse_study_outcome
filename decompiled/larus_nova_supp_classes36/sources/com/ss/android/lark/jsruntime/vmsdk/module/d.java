package com.ss.android.lark.jsruntime.vmsdk.module;

import com.bytedance.vmsdk.net.Response;
import com.bytedance.vmsdk.worker.JsWorker;
import com.ss.android.lark.jsruntime.vmsdk.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements com.ss.android.lark.jsruntime.vmsdk.b<i> {
    public final /* synthetic */ com.bytedance.vmsdk.net.a<Response> a;

    public d(JsWorker.b r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.jsruntime.vmsdk.b
    public final void a(i r9) {
        i r10 = r9;
        Intrinsics.checkNotNullParameter(r10, "params");
        rnb.c.c("VmSDKRequestDelegate", "execute() called }");
        com.bytedance.vmsdk.net.a<Response> r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(new Response(r10.a, r10.b, r10.c, r10.d, r10.e));
        return;
    }
}
