package com.larus.browsertakeover.signaling;

import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.im.service.a0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements a0 {
    public final /* synthetic */ LocalPcSignaling.b a;

    public f(LocalPcSignaling.b r1) {
        this.a = r1;
    }

    public final void onReceiveDispatchCommand(final OmniDispatchCommandResponse r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        final LocalPcSignaling.b r0 = this.a;
        r0.c(new e(r0, r3));
    }

    public final void a(String r1, String r2, IIMError r3) {
        a0.a.a(r1, r2, r3);
    }
}
