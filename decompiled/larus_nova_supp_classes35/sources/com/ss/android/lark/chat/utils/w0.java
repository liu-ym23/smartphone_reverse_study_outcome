package com.ss.android.lark.chat.utils;

import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class w0 extends aqb.a {
    public final /* synthetic */ aqb.k a;

    public w0(aqb.k r1) {
        this.a = r1;
    }

    public final void a(com.ss.android.lark.biz.im.api.g1 r2) {
        aqb.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.d(r2);
        return;
    }

    public final void b(PushMessageReadStates r2) {
        aqb.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.g(r2);
        return;
    }

    public final void c(MessageInfo r2) {
        aqb.k r0 = this.a;
        if (r0 == null) goto L7;
        if (r2 == null) goto L8;
        r0.e(r2);
        return;
    L8:
        return;
    }

    public final void f(PushMessageReactions r2) {
        aqb.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    public final void onPushChat(Chat r2) {
        aqb.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public final void onPushChatRemoveMe(Chat r2) {
        aqb.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public final void onPushThreadTopic(ThreadTopic r2) {
        aqb.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.h(r2);
        return;
    }

    public final void g(Chat r2, Map<String, ? extends Chatter> r3) {
        aqb.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.c(r2, r3);
        return;
    }

    public final void h(Chat r2, Map<String, ? extends Chatter> r3) {
        aqb.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "chat");
        Intrinsics.checkNotNullParameter(r3, "chatterMap");
        return;
    }

    public final void i(Chat r2, Map<String, ? extends Chatter> r3) {
        aqb.k r0 = this.a;
        if (r0 == null) goto L6;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "chat");
        Intrinsics.checkNotNullParameter(r3, "chatterMap");
        return;
    }
}
