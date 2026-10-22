package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.platform.spi.IAIChatService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c0 implements IIMCallback<com.larus.im.internal.core.message.regen.a> {
    public final /* synthetic */ Message a;

    public final boolean mustInMain() {
        return true;
    }

    public c0(Message r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final void onSuccess(Object r4) {
        com.larus.im.internal.core.message.regen.a r5 = (com.larus.im.internal.core.message.regen.a) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        IAIChatService.Companion r0 = IAIChatService.a;
        String r1 = r0.e7(this.a.getConversationId());
        if (com.larus.utils.o0.d(r5.a) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r1, r5.a) == false) goto L9;
        r0.m4(this.a.getConversationId(), r5.b);
        return;
    }
}
