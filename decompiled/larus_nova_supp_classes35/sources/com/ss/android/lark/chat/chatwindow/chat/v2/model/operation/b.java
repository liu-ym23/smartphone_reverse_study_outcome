package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements Function1<f5b.b, f5b.b> {
    public final String a;

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "avatarKey");
        this.a = r2;
    }

    public final Object invoke(Object r3) {
        f5b.b r4 = (f5b.b) r3;
        if (r4 == null) goto L5;
        ChatChatter r0 = r4.getMessageSender();
    L6:
        if (r0 == null) goto L8;
        ChatChatter r1 = r4.getMessageSender();
        Intrinsics.checkNotNull(r1);
        r1.setAvatarKey(this.a);
    L8:
        return r4;
    L5:
        r0 = null;
        goto L6
    }
}
