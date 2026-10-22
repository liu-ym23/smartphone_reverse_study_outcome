package com.larus.voicecall.impl.plugins;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f0 implements IIMCallback<Message> {
    public final /* synthetic */ yc9.f0 a;
    public final /* synthetic */ IIMCallback<Message> b;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r3) {
        Intrinsics.checkNotNullParameter(r3, "error");
        com.larus.im.d.e().addMessage(this.a, this.b);
    }

    public final void onSuccess(Object r2) {
        Intrinsics.checkNotNullParameter((Message) r2, "result");
    }

    public f0(yc9.f0 r1, d0.f r2) {
        this.a = r1;
        this.b = r2;
    }
}
