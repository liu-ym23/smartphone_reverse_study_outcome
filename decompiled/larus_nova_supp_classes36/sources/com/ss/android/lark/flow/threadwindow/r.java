package com.ss.android.lark.flow.threadwindow;

import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.g1;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.c0;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.w0;
import com.ss.android.lark.chat.utils.x0;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class r implements c0.a {
    public final String a;
    public final v b;
    public final WeakReference<t> c;
    public final String d;
    public final b e;
    public final com.ss.android.lark.chat.chatwindow.chat.v2.push.p f;
    public final a g;

    public static final class a extends aqb.k {
        public final /* synthetic */ r a;

        public a(r r1) {
            this.a = r1;
        }

        @Override // aqb.k
        public final void a(Chat r3) {
            Intrinsics.checkNotNullParameter(r3, "chat");
            if (Intrinsics.areEqual(r3.getId(), this.a.a) == true) goto L5;
            return;
        L5:
            t r0 = this.a.c.get();
            if (r0 == null) goto L9;
            r0.onPushChat(r3);
            return;
        }

        @Override // aqb.k
        public final void b(Chat r3) {
            Intrinsics.checkNotNullParameter(r3, "chat");
            if (Intrinsics.areEqual(r3.getId(), this.a.a) == true) goto L5;
            return;
        L5:
            t r0 = this.a.c.get();
            if (r0 == null) goto L9;
            r0.onPushChatRemoveMe(r3);
            return;
        }

        @Override // aqb.k
        public final void d(g1 r7) {
            Intrinsics.checkNotNullParameter(r7, "pushMessageDTO");
            t r0 = this.a.c.get();
            if (r0 != null) goto L5;
            return;
        L5:
            MessageInfo r1 = r7.a;
            Message r2 = r1.getMessage();
            if (Intrinsics.areEqual(r2.getChatId(), this.a.a) == true) goto L8;
            return;
        L8:
            Chat r3 = r7.b;
            if (r3 == null) goto L16;
            r r4 = this.a;
            if (Intrinsics.areEqual(r3.getId(), r4.a) == true) goto L14;
            r3 = null;
        L14:
            if (r3 == null) goto L16;
            r0.onPushChat(r3);
        L16:
            ThreadTopic r5 = r7.c;
            if (r5 != null) goto L19;
        L21:
            if (r5 == null) goto L23;
            r0.onPushThreadReply(r7);
            return;
        L23:
            r0.onPushRootMessage(r1);
            return;
        L19:
            if (s.a(r5, r2.getId()) == false) goto L21;
            r0.onPushRootThread(r7);
        }

        @Override // aqb.k
        public final void f(PushMessageReactions r3) {
            Intrinsics.checkNotNullParameter(r3, "reactions");
            if (Intrinsics.areEqual(r3.chat_id, this.a.a) == true) goto L5;
            return;
        L5:
            t r0 = this.a.c.get();
            if (r0 == null) goto L9;
            r0.onPushThreadReactions(r3);
            return;
        }

        @Override // aqb.k
        public final void h(ThreadTopic r2) {
            Intrinsics.checkNotNullParameter(r2, "threadTopic");
            t r0 = this.a.c.get();
            if (r0 == null) goto L6;
            r0.onPushThreadTopic(r2);
            return;
        }

        @Override // aqb.k
        public final void c(Chat r3, Map<String, ? extends Chatter> r4) {
            Intrinsics.checkNotNullParameter(r3, "chat");
            Intrinsics.checkNotNullParameter(r4, "chatterMap");
            if (Intrinsics.areEqual(r3.getId(), this.a.a) == true) goto L5;
            return;
        L5:
            t r0 = this.a.c.get();
            if (r0 == null) goto L9;
            r0.onPushChatRemoveChatters(r3, r4);
            return;
        }
    }

    public static final class b implements com.ss.android.lark.chat.chatwindow.chat.v2.push.p.b {
        public final /* synthetic */ r a;

        public b(r r1) {
            this.a = r1;
        }

        public final void onThreadRepliesUpdate(n5b.a r2) {
            Intrinsics.checkNotNullParameter(r2, "threadInfo");
            t r0 = this.a.c.get();
            if (r0 == null) goto L6;
            r0.onThreadRepliesUpdate(r2);
            return;
        }
    }

    public final void register() {
        if (this.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        x0 r1 = this.b.Q();
        String r2 = this.d;
        String r3 = this.a;
        a r4 = this.g;
        r1.a.W1(r2, r3, new w0(r4));
        this.f.register();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void unRegister() {
        if (this.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.f.unRegister();
        x0 r1 = this.b.Q();
        String r2 = this.d;
        String r3 = this.a;
        r1.a.V(r2, r3);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public r(String r2, v r3, t r4) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "chatContainer");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.a = r2;
        this.b = r3;
        this.c = new WeakReference(r4);
        this.d = "FlowThreadWindow:" + hashCode();
        this.e = new b(this);
        this.f = new com.ss.android.lark.chat.chatwindow.chat.v2.push.p(this.a, r3.N(), this.e);
        this.g = new a(this);
    }
}
