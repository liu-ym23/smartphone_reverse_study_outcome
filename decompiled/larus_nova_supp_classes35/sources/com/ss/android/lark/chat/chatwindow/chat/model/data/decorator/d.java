package com.ss.android.lark.chat.chatwindow.chat.model.data.decorator;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.utils.UrlTranslateUtils;
import com.ss.android.lark.chat.utils.h0;
import com.ss.android.lark.chatbase.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements i<MessageInfo> {
    public final v a;

    public static final class a {
    }

    static {
    }

    public d(v r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.a = r2;
    }

    @Override // com.ss.android.lark.chatbase.i
    public final void a(f5b.b r5) {
        MessageInfo r6 = (MessageInfo) r5;
        Intrinsics.checkNotNullParameter(r6, "chatMessage");
        v r0 = this.a;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r0, "container");
        if (r6.getMessage().getType() != Message.Type.TEXT) goto L5;
    L6:
        BaseTextContent r1 = (BaseTextContent) r6.getMessage().getContent();
        if (r6.getTranslateInfo() != null) goto L9;
        return;
    L9:
        if (h0.a((BaseTextContent) r6.getTranslateInfo().getTranslateContent(), r1.getPreviewHangPoints(), r6.getTranslateInfo().getLanguage()) == false) goto L14;
        new UrlTranslateUtils(r0.x(), r0.A()).a(r6);
        return;
    L14:
        return;
    L5:
        if (r6.getMessage().getType() == Message.Type.POST) goto L6;
    }
}
