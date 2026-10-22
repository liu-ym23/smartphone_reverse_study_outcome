package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.social.page.datasource.event.RefreshTraceSource;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u implements com.larus.im.service.d0<wc9.e> {
    public final /* synthetic */ ChatMessageReceiverModel a;

    public u(ChatMessageReceiverModel r1) {
        this.a = r1;
    }

    public final void c(Object r8) {
        wc9.e r9 = (wc9.e) r8;
        Intrinsics.checkNotNullParameter(r9, "conversation");
        if (Intrinsics.areEqual(r9.a, this.a.b) == true) goto L5;
        FLogger.a.e(this.a.k, "Conversation onChange not consume because conversationId not the same " + this.a.b + ' ' + r9.a);
        return;
    L5:
        this.a.getClass();
        ChatMessageReceiverModel r0 = this.a;
        Long r1 = r9.q;
        long r2 = 0;
        if (r1 == null) goto L8;
        long r4 = r1.longValue();
    L9:
        r0.d = r4;
        long r3 = this.a.e;
        Number r5 = r9.o;
        if (r5 != null) goto L13;
        r5 = 0;
    L13:
        if ((r5 instanceof Long) == true) goto L16;
    L17:
        FLogger.a.i(this.a.k, "readMessageIndex changed latestMessageIndex: " + r9.q + "  readMessageIndex: " + r9.o);
        ChatMessageReceiverModel r6 = this.a;
        Long r10 = r9.o;
        if (r10 == null) goto L20;
        r2 = r10.longValue();
    L20:
        r6.e = r2;
        String r11 = com.larus.bmhome.social.page.datasource.event.d.a(RefreshTraceSource.CONVERSATION_CHANGE);
        ChatMessageReceiverModel r7 = this.a;
        BuildersKt.launch$default(r7.a, r7.l, null, new ChatMessageReceiverModel$conversationChangeListener$1$onChange$1(r7, r11, null), 2, null);
        return;
    L16:
        if (r3 != r5.longValue()) goto L17;
        return;
    L8:
        r4 = 0;
        goto L9
    }

    public final void a(wc9.e r5, wc9.e r6) {
        Intrinsics.checkNotNullParameter(r6, "new");
        FLogger r0 = FLogger.a;
        String r1 = this.a.k;
        StringBuilder r2 = new StringBuilder("onReplace onChange ");
        if (r5 == null) goto L5;
        String r7 = r5.a;
    L6:
        r2.append(r7);
        r2.append(' ');
        r2.append(r6.a);
        r0.i(r1, r2.toString());
        return;
    L5:
        r7 = null;
        goto L6
    }
}
