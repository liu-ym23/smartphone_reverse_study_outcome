package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements Function1<f5b.b, f5b.b> {
    public final int a;

    public f(int r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        f5b.b r5 = (f5b.b) r4;
        if (r5 == null) goto L7;
        Message r0 = r5.getMessage();
        if (r0.getType() != Message.Type.IMAGE) goto L7;
        ((ImageContent) r0.getContent()).setProgress(this.a);
    L7:
        return r5;
    }
}
