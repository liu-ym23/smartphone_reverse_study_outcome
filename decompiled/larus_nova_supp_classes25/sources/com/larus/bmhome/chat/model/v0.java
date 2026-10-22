package com.larus.bmhome.chat.model;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.Map;
import kotlin.Result;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v0 implements IIMCallback<Map<String, ? extends Message>> {
    public final /* synthetic */ kotlinx.coroutines.i<Map<String, Message>> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public v0(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        if (this.a.isActive() == false) goto L6;
        kotlinx.coroutines.i<Map<String, Message>> r3 = this.a;
        Result.Companion r0 = Result.Companion;
        r3.resumeWith(Result.constructor-impl(MapsKt.emptyMap()));
        return;
    }

    public final void onSuccess(Object r2) {
        Map r3 = (Map) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(r3));
        return;
    }
}
