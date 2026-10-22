package com.larus.bmhome.chat.component.list;

import android.os.Bundle;
import com.larus.bmhome.chat.component.push.a$a;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.OpenPushReminderScene;
import kotlin.jvm.internal.Intrinsics;
import o99.a;
import q99.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l5 implements a {
    public final /* synthetic */ ChatListComponent a;

    public final void d() {
    }

    public final void e(d r1) {
    }

    public final void h() {
    }

    public final void i() {
    }

    public l5(ChatListComponent r1) {
        this.a = r1;
    }

    public final Bundle b(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        Intrinsics.checkNotNullParameter(r2, "bundle");
        return r2;
    }

    public final hq9.n3 f(hq9.n3 r2) {
        Intrinsics.checkNotNullParameter(r2, "originalRequest");
        Intrinsics.checkNotNullParameter(r2, "originalRequest");
        return r2;
    }

    public final void a(q99.m r2, q99.l r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "error");
    }

    public final void c(q99.e r1, q99.a r2) {
        a.a.a(r1, r2);
    }

    public final void g(q99.m r2, q99.n r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    public final void j(q99.e r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "delivery");
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        final Message r4 = r0.e4(r13);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r14 == false) goto L27;
        final ChatListComponent r15 = this.a;
        final String r2 = r13.d;
        final String r16 = r13.b;
        if (r16 != null) goto L9;
        r16 = r4.getMessageId();
    L9:
        wc9.e r7 = r15.R4();
        if (r7 == null) goto L12;
        String r3 = r7.a;
    L14:
        if (Intrinsics.areEqual(r3, r4.getConversationId()) == true) goto L16;
    L25:
        ChatListComponent.L7(r15, r2, r16, r4);
        return;
    L16:
        if (ic8.n.v(r7) == true) goto L20;
        if (ic8.n.D(r7) == false) goto L25;
    L20:
        if (com.larus.bmhome.chat.bean.d.G0(r4) == true) goto L25;
        com.larus.bmhome.chat.component.push.a r5 = (com.larus.bmhome.chat.component.push.a) r15.b3.getValue();
        if (r5 == null) goto L24;
        a$a.a(r5, OpenPushReminderScene.LikeMsgForMainBot, r7, r15.j0(), null, new u0(r15, r2, r16, r4), 8);
        return;
    L24:
        ChatListComponent.L7(r15, r2, r16, r4);
        return;
    L12:
        r3 = null;
        goto L14
    L27:
        this.a.U5().onDislikeMessage(r4);
        ChatControlTrace.b.Qa("answer", r4, s1a.a.c(this.a), de8.d.a(this.a.f1()));
    }
}
