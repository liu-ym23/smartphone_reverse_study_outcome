package com.larus.bmhome.chat.detail.code.preview;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e implements IIMCallback<Message> {
    public final /* synthetic */ CompletableDeferred<Boolean> a;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public e(CompletableDeferred<Boolean> r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        this.a.complete(Boolean.FALSE);
    }

    public final void onSuccess(Object r3) {
        Message r4 = (Message) r3;
        Intrinsics.checkNotNullParameter(r4, "result");
        CompletableDeferred<Boolean> r0 = this.a;
        if (r4.getMessageStatusLocal() == 20) goto L5;
        boolean r5 = true;
    L6:
        r0.complete(Boolean.valueOf(r5));
        return;
    L5:
        r5 = false;
        goto L6
    }
}
