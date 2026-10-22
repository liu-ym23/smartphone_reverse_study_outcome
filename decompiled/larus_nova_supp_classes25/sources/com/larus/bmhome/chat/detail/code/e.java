package com.larus.bmhome.chat.detail.code;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.im.observer.MessageListState;
import com.larus.utils.o0;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e extends com.larus.bmhome.chat.detail.a implements m0 {
    public boolean d;
    public String e;
    public Function0<Unit> f;
    public Function2<? super String, ? super Boolean, Unit> g;
    public Function2<? super String, ? super Boolean, Unit> h;
    public Function2<? super String, ? super Boolean, Unit> i;
    public final a j;
    public final c k;

    public static final class a implements nf9.c {
        public final /* synthetic */ e a;

        public final void C(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
        }

        public a(e r1) {
            this.a = r1;
        }

        public final void A(Message r3) {
            Intrinsics.checkNotNullParameter(r3, "message");
            this.a.f.invoke();
            e r0 = this.a;
            r0.a = r3;
            if (r0.d == false) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r3.getMessageId(), this.a.c) == false) goto L10;
            e r1 = this.a;
            r1.h.invoke(e.n(r1, r3), Boolean.valueOf(com.larus.bmhome.chat.bean.d.j0(r3)));
            return;
        }

        public final void B(Message r3) {
            Intrinsics.checkNotNullParameter(r3, "message");
            e r0 = this.a;
            r0.a = r3;
            if (r0.d == false) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r3.getMessageId(), this.a.c) == false) goto L10;
            e r1 = this.a;
            r1.g.invoke(e.n(r1, r3), Boolean.valueOf(com.larus.bmhome.chat.bean.d.j0(r3)));
            return;
        }
    }

    public static final class b implements IIMCallback<Message> {
        public final /* synthetic */ e a;

        public final boolean mustInMain() {
            return true;
        }

        public b(e r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final void onSuccess(Object r3) {
            Message r4 = (Message) r3;
            Intrinsics.checkNotNullParameter(r4, "result");
            e r0 = this.a;
            r0.i.invoke(e.n(r0, r4), Boolean.valueOf(com.larus.bmhome.chat.bean.d.j0(r4)));
        }
    }

    public static final class c implements nf9.d {
        public final /* synthetic */ e a;

        public final void a(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "threadId");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void b(String r2, MessageListState r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "threadId");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "msgList");
        }

        public final void d(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "threadId");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void e(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "threadId");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void f(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "threadId");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "threadId");
            Intrinsics.checkNotNullParameter(r3, "oldMsgList");
            Intrinsics.checkNotNullParameter(r4, "newMsgList");
        }

        public c(e r1) {
            this.a = r1;
        }

        public final void c(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "threadId");
            Intrinsics.checkNotNullParameter(r2, "msg");
            e r4 = this.a;
            r4.a = r2;
            if (r4.d == false) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r2.getMessageId(), this.a.c) == false) goto L10;
            e r5 = this.a;
            r5.g.invoke(e.n(r5, r2), Boolean.valueOf(com.larus.bmhome.chat.bean.d.j0(r2)));
            return;
        }
    }

    @Override // com.larus.bmhome.chat.detail.code.m0
    public final String a() {
        Message r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getConversationId();
    }

    @Override // com.larus.bmhome.chat.detail.code.m0
    public final Boolean isFinished() {
        Message r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(com.larus.bmhome.chat.bean.d.j0(r0));
    }

    @Override // com.larus.bmhome.chat.detail.code.m0
    public final Boolean isStreaming() {
        Message r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(com.larus.im.bean.message.a.w0(r0));
    }

    @Override // com.larus.bmhome.chat.detail.code.m0
    public final Integer k() {
        Message r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getMessageStatusLocal());
    }

    @Override // com.larus.bmhome.chat.detail.code.m0
    public final void onDestroy() {
        int r0 = com.larus.im.d.a;
        com.larus.im.internal.stream.b.a.e(this.b, this.j);
        if (o0.d(this.e) == false) goto L9;
        NativeMessageServiceImpl r1 = com.larus.im.d.e();
        String r2 = this.e;
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        r1.unregisterOnThreadMessageChangedObserver(r2, this.k);
        return;
    }

    public e() {
        this.f = new com.larus.bmhome.chat.detail.code.a();
        this.g = new com.larus.bmhome.chat.detail.code.b();
        this.h = new com.larus.bmhome.chat.detail.code.c();
        this.i = new d();
        this.j = new a(this);
        this.k = new c(this);
    }

    @Override // com.larus.bmhome.chat.detail.code.m0
    public final void m() {
        com.larus.im.d.e().m(this.c, new b(this));
        if (this.b.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        com.larus.im.internal.stream.b.a.b(this.b, this.j);
        return;
    L9:
        if (o0.d(this.e) == false) goto L16;
        NativeMessageServiceImpl r1 = com.larus.im.d.e();
        String r2 = this.e;
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        r1.registerOnThreadMessageChangedObserver(r2, this.k);
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.bmhome.chat.detail.code.m0
    public final void b(b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    @Override // com.larus.bmhome.chat.detail.code.m0
    public final void f(z r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.i = r2;
    }

    @Override // com.larus.bmhome.chat.detail.code.m0
    public final void g(boolean r1) {
        this.d = r1;
    }

    @Override // com.larus.bmhome.chat.detail.code.m0
    public final void h(a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    @Override // com.larus.bmhome.chat.detail.code.m0
    public final void i(String r1) {
        this.e = r1;
    }

    @Override // com.larus.bmhome.chat.detail.code.m0
    public final void l(g r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    public static final String n(e r1, Message r2) {
        r1.getClass();
        if (r2.getContentType() == 9999) goto L9;
        if (r2.getContentType() == 1) goto L9;
        return "";
    L9:
        if (com.larus.im.bean.message.a.b0(r2) == false) goto L12;
        return com.larus.im.bean.message.a.e(r2);
    L12:
        return com.larus.im.bean.message.a.O(r2);
    }
}
