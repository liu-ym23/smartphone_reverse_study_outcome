package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements aqb.h {
    public final /* synthetic */ o.a a;

    public n(o.a r1) {
        this.a = r1;
    }

    public final MessageInfo p(String r2) {
        return this.a.b.c.getMessageById(r2);
    }

    public final void q(MessageInfo r3) {
        if (this.a.b.b == null) goto L6;
        ArrayList r0 = new ArrayList();
        r0.add(r3);
        this.a.b.b.onPushMessage(r0, false);
        return;
    }
}
