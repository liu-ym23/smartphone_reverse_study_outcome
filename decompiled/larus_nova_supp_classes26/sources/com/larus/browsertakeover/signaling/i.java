package com.larus.browsertakeover.signaling;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.OmniDispatchCommandAcceptedResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i implements IIMCallback<OmniDispatchCommandAcceptedResponse> {
    public final /* synthetic */ LocalPcSignaling.b a;

    public final boolean mustInMain() {
        return true;
    }

    public i(LocalPcSignaling.b r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        final LocalPcSignaling.b r3 = this.a;
        r3.c(new g(r3));
    }

    public final void onSuccess(Object r3) {
        final OmniDispatchCommandAcceptedResponse r4 = (OmniDispatchCommandAcceptedResponse) r3;
        Intrinsics.checkNotNullParameter(r4, "result");
        final LocalPcSignaling.b r0 = this.a;
        r0.c(new h(r0, r4));
    }
}
