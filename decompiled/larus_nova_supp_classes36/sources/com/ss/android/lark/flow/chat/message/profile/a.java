package com.ss.android.lark.flow.chat.message.profile;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.utils.UIHelper;
import f5b.b;
import kotlin.jvm.internal.Intrinsics;
import y6b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements d<FlowProfileContentVO> {
    public a() {
    }

    public final Message.Type a() {
        return Message.Type.SHARE_USER_CARD;
    }

    public final CharSequence b(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return d(r2);
    }

    public final CharSequence d(b r3) {
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        return UIHelper.mustacheFormat(2131892097, "user_name", r3.getMessage().getContent().getDisplayName());
    }

    public final v5b.a c(v r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "containerOwner");
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        return new FlowProfileContentVO(r3.getMessage().getContent());
    }
}
