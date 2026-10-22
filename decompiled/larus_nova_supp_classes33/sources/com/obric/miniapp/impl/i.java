package com.obric.miniapp.impl;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.List;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i implements IIMCallback<List<? extends Message>> {
    public final /* synthetic */ kotlinx.coroutines.i<List<Message>> a;

    public final boolean mustInMain() {
        return true;
    }

    public i(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        com.bytedance.ai.utils.g.a.w("MiniAppService", "query conversation messages failed: " + r4);
        if (this.a.isActive() == false) goto L6;
        kotlinx.coroutines.i<List<Message>> r5 = this.a;
        Result.Companion r0 = Result.Companion;
        r5.resumeWith(Result.constructor-impl(CollectionsKt.emptyList()));
        return;
    }

    public final void onSuccess(Object r2) {
        List r3 = (List) r2;
        Intrinsics.checkNotNullParameter(r3, WindowEvent.Params.RESULT);
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(r3));
        return;
    }
}
