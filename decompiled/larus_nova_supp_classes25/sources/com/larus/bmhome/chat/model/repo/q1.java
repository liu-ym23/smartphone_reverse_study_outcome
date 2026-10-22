package com.larus.bmhome.chat.model.repo;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q1 implements IIMCallback<List<? extends Message>> {
    public final /* synthetic */ kotlinx.coroutines.i<List<Message>> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public q1(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        this.a.resumeWith(Result.constructor-impl(null));
    }

    public final void onSuccess(Object r2) {
        List r3 = (List) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        this.a.resumeWith(Result.constructor-impl(r3));
    }
}
