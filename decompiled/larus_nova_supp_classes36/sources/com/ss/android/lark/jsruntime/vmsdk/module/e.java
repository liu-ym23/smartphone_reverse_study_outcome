package com.ss.android.lark.jsruntime.vmsdk.module;

import com.bytedance.vmsdk.worker.JsWorker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements com.ss.android.lark.jsruntime.vmsdk.b<Throwable> {
    public final /* synthetic */ com.bytedance.vmsdk.net.a<Throwable> a;

    public e(JsWorker.c r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.jsruntime.vmsdk.b
    public final void a(Throwable r3) {
        Throwable r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "e");
        rnb.c.c("VmSDKRequestDelegate", "execute() called with: e = " + r4 + " reject:" + this.a);
        com.bytedance.vmsdk.net.a<Throwable> r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(r4);
        return;
    }
}
