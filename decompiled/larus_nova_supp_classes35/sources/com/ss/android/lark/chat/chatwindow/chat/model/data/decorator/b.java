package com.ss.android.lark.chat.chatwindow.chat.model.data.decorator;

import a2b.o;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chatbase.i;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends com.ss.android.lark.chat.api.service.impl.usergroup.a implements i<MessageInfo> {

    public static final class a {
    }

    static {
    }

    public b(o r2) {
        Intrinsics.checkNotNullParameter(r2, "userGroupService");
        super(r2);
    }

    @Override // com.ss.android.lark.chatbase.i
    public final void a(f5b.b r2) {
        MessageInfo r3 = (MessageInfo) r2;
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        Message r4 = r3.getMessage();
        Intrinsics.checkNotNullParameter(r4, "message");
        Content r0 = r4.getContent();
        if (r0 != null) goto L6;
        return;
    L6:
        if ((r0 instanceof BaseTextContent) == false) goto L11;
        this.a.La(r4);
        return;
    }
}
