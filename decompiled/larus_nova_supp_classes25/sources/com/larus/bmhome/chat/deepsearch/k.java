package com.larus.bmhome.chat.deepsearch;

import com.larus.bmhome.chat.list.cell.prompt.w0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k implements xc8.g {
    public final int c() {
        return 42;
    }

    public k() {
    }

    public final boolean a(Object r3) {
        Message r4 = (Message) r3;
        Intrinsics.checkNotNullParameter(r4, "sourceData");
        if (r4.getContentType() == 2) goto L5;
    L9:
        return false;
    L5:
        if (r4.getMessageStatus() != MessageStatus.MessageStatus_AVAILABLE) goto L9;
        if (r4.getMessageStatusLocal() != 21) goto L9;
        return true;
    }

    public final ei9.f b(Object r2) {
        Message r3 = (Message) r2;
        Intrinsics.checkNotNullParameter(r3, "sourceData");
        return new w0(r3);
    }
}
