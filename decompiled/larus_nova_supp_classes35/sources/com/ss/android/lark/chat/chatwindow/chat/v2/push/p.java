package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.service.impl.k2;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p implements c0.a {
    public final String a;
    public final m6b.q b;
    public final WeakReference<b> c;
    public final c d;

    public static final class a {
    }

    public interface b {
        void onThreadRepliesUpdate(n5b.a r1);
    }

    public static final class c implements k2.b {
        public final /* synthetic */ p a;

        public c(p r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.service.impl.k2.b
        public final void a(JSONObject r3) {
            if (r3 != null) goto L21;
            return;
        L21:
            Object r4 = r3.get("thread_info");     // Catch: Throwable -> L18
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.thread.ThreadInfo");     // Catch: Throwable -> L18
            n5b.a r5 = (n5b.a) r4;     // Catch: Throwable -> L18
            Chat r0 = r5.l;
            if (r0 == null) goto L8;
            String r1 = r0.getId();
        L10:
            if (Intrinsics.areEqual(r1, this.a.a) == false) goto L12;
        L14:
            b r2 = this.a.c.get();
            if (r2 == null) goto L23;
            r2.onThreadRepliesUpdate(r5);
            return;
        L23:
            return;
        L12:
            if (Intrinsics.areEqual(r5.c.getChatId(), this.a.a) == true) goto L14;
            return;
        L8:
            r1 = null;
        L18:
            th = move-exception;
            Log.e("ChatReplyInThreadPushHandler", th);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        this.b.G1(this.d);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        this.b.Ia(this.d);
    }

    public p(String r2, m6b.q r3, b r4) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "threadPush");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.a = r2;
        this.b = r3;
        this.c = new WeakReference(r4);
        this.d = new c(this);
    }
}
