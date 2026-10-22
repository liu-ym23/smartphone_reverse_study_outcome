package com.larus.bmhome.chat.component.bottom.multimodal.sender;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h implements IIMCallback<Message> {
    public h() {
    }

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        Message r2 = (Message) r1;
    }
}
