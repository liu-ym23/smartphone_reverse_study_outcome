package com.ss.android.lark.message.vote.message;

import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements v5b.b<VoteContentVO> {
    public d() {
    }

    public final MessageType a() {
        return MessageType.CARD;
    }

    public final CharSequence b(p5b.c r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        if (r2.getMessage().getContent().getType() != CardContent.Type.VOTE) goto L5;
        int r3 = 2131891920;
    L7:
        return UIHelper.getString(r3);
    L5:
        r3 = 2131892296;
        goto L7
    }

    public final v5b.a c(p5b.c r3) {
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        CardContent r4 = r3.getMessage().getContent();
        if ((r4 instanceof CardContent) == false) goto L7;
        CardContent r5 = r4;
        if (r5.getType() != CardContent.Type.VOTE) goto L7;
        return new VoteContentVO(r5);
    L7:
        return null;
    }
}
