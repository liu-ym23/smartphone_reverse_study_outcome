package com.ss.android.lark.flow.threadwindow.plugin;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements jya.a {
    public final /* synthetic */ FlowThreadWindowMsgTipsPlugin a;
    public final /* synthetic */ IMessageListComponent b;

    public static final class a implements Runnable {
        public final /* synthetic */ FlowThreadWindowMsgTipsPlugin a;
        public final /* synthetic */ List<MessageInfo> b;
        public final /* synthetic */ IMessageListComponent c;

        public a(FlowThreadWindowMsgTipsPlugin r1, List<? extends MessageInfo> r2, IMessageListComponent r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            wgb.b<y6b.c<?>> r0 = this.a.j;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a(this.b, !this.c.SP());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final void a(List<? extends MessageInfo> r6) {
        Intrinsics.checkNotNullParameter(r6, "messageList");
        FlowThreadWindowMsgTipsPlugin r0 = this.a;
        r0.m.b(new a(r0, r6, this.b), 500);
    }

    public final void b(List<? extends MessageInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "messageList");
    }

    public c(FlowThreadWindowMsgTipsPlugin r1, IMessageListComponent r2) {
        this.a = r1;
        this.b = r2;
    }
}
