package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MessageIDLStub$h implements IIMCallback<List<? extends Message>> {
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public MessageIDLStub$h(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        this.a.resumeWith(Result.constructor-impl(null));
    }

    public final void onSuccess(Object r2) {
        Intrinsics.checkNotNullParameter((List) r2, "result");
        kotlinx.coroutines.i<Boolean> r3 = this.a;
        Result.Companion r0 = Result.Companion;
        r3.resumeWith(Result.constructor-impl(Boolean.TRUE));
    }
}
