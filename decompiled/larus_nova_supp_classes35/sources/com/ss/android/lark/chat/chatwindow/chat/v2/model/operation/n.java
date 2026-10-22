package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements Function1<f5b.b, f5b.b> {
    public final int a;

    public n(int r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        f5b.b r5 = (f5b.b) r4;
        if (r5 != null) goto L5;
    L16:
        return r5;
    L5:
        if (r5.getMessage().getMessageType() != MessageType.IMAGE) goto L16;
        ImageContent r0 = (ImageContent) r5.getMessage().getMessageContent();
        int r1 = this.a;
        if (r1 >= 0) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L16;
        if (r1 <= r0.getProgress()) goto L16;
        r0.setProgress(this.a);
        goto L16
    L9:
        if (r1 >= 101) goto L11;
        r2 = true;
        goto L12
    }
}
