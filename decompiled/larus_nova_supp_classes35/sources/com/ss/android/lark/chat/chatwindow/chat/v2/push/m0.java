package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.message.MessageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m0 implements com.ss.android.lark.threaddetail.model.g.a {
    public final /* synthetic */ ThreadTopic a;
    public final /* synthetic */ l0 b;

    public final MessageInfo O1() {
        return this.b.e.getTopicMessageInfo();
    }

    public final ThreadTopic N1() {
        return this.a;
    }

    public m0(l0 r1, ThreadTopic r2) {
        this.b = r1;
        this.a = r2;
    }
}
