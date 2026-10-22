package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.PrerenderResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o1 implements s9.e {
    public final /* synthetic */ p1 a;

    public o1(p1 r1) {
        this.a = r1;
    }

    @Override // s9.e
    public final void onSuccess(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        p1 r11 = this.a;
        PrerenderResultModel r0 = new PrerenderResultModel();
        r0.a(PrerenderResultModel.Code.Success);
        r0.b("Success!!!");
        r11.finishWithResult(r0);
    }

    @Override // s9.e
    public final void onFailed(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "reason");
        p1 r0 = this.a;
        PrerenderResultModel r1 = new PrerenderResultModel();
        r1.a(PrerenderResultModel.Code.Failed);
        r1.b(r11 + "with schema: " + r10);
        r0.finishWithResult(r1);
    }
}
