package com.larus.bmhome.chat.detail.table;

import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a extends com.larus.bmhome.chat.detail.a implements b {
    @Override // com.larus.bmhome.chat.detail.table.b
    public final String a() {
        Message r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getConversationId();
    }

    public a() {
    }
}
