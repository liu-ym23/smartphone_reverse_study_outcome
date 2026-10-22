package com.ss.android.lark.flow.chat.message.redpacket;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements y6b.d<c> {
    public final Message.Type a;

    public final Message.Type a() {
        return this.a;
    }

    public d(Message.Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.a = r2;
    }

    public final CharSequence b(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return d(r2);
    }

    public final CharSequence d(f5b.b r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return UIHelper.getString(2131890895);
    }

    public final v5b.a c(v r2, f5b.b r3) {
        Intrinsics.checkNotNullParameter(r2, "containerOwner");
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        return new c(r3.getMessage().getContent());
    }
}
