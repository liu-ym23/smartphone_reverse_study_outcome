package com.larus.bmhome.chat.detail.code.preview;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f implements IIMCallback<Message> {
    public final /* synthetic */ CompletableDeferred<Boolean> a;
    public final /* synthetic */ CodeBlockDetailPreviewComponent b;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        this.a.complete(Boolean.FALSE);
    }

    public final void onSuccess(Object r3) {
        Message r4 = (Message) r3;
        CompletableDeferred<Boolean> r0 = this.a;
        if (r4 == null) goto L5;
        String r5 = r4.getMessageId();
    L6:
        r0.complete(Boolean.valueOf(Intrinsics.areEqual(r5, this.b.m)));
        return;
    L5:
        r5 = null;
        goto L6
    }

    public f(CompletableDeferred<Boolean> r1, CodeBlockDetailPreviewComponent r2) {
        this.a = r1;
        this.b = r2;
    }
}
