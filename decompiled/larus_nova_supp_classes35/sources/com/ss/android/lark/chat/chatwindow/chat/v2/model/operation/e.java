package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements Function1<f5b.b, f5b.b> {
    public e() {
    }

    public final Object invoke(Object r4) {
        f5b.b r5 = (f5b.b) r4;
        if (r5 == null) goto L11;
        Message r0 = r5.getMessage();
        Message.Type r1 = r0.getType();
        if (r1 != Message.Type.FILE) goto L7;
    L8:
        r0.setSendStatus(SendStatus.FAIL);
        if (r1 != Message.Type.MEDIA) goto L11;
        MediaContent r2 = (MediaContent) r0.getContent();
        r2.setProgress(0);
        r2.setFileState(FileState.PAUSE);
        goto L11
    L7:
        if (r1 == Message.Type.MEDIA) goto L8;
    L11:
        return r5;
    }
}
