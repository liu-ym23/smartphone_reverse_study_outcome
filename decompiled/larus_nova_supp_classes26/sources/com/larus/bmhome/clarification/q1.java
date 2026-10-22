package com.larus.bmhome.clarification;

import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q1 implements te8.c {
    public final /* synthetic */ ClarificationComponent a;
    public final /* synthetic */ u7 b;

    public final void A(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void F1(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void N0(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void Q(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "answer");
    }

    public final void p(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        d2 r0 = this.a.n.a;
        boolean r1 = false;
        if (r0 == null) goto L9;
        Block r2 = r0.g;
        if (r2 == null) goto L9;
        if (w.a(r2) != true) goto L9;
        r1 = true;
    L9:
        if (r0 == null) goto L17;
        if (r1 == false) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r0.b, r5.getMessageId()) == true) goto L14;
        return;
    L14:
        if (r5.getMessageStatusLocal() != 23) goto L20;
        this.a.a4("interrupted2");
        return;
    L20:
        return;
    }

    public final void v(List<Message> r2) {
        Intrinsics.checkNotNullParameter(r2, "messages");
    }

    public final void v1(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "answer");
    }

    public final void y0(String r7) {
        Intrinsics.checkNotNullParameter(r7, "id");
        d2 r8 = this.a.n.a;
        if (r8 != null) goto L6;
        return;
    L6:
        if (this.b.O7(r8.b) == true) goto L9;
        this.a.a4("trigger_message_removed");
        return;
    L9:
        List r9 = this.b.zj();
        if (r9 != null) goto L12;
        r9 = CollectionsKt.emptyList();
    L12:
        List r10 = r9;
        boolean r0 = r10 instanceof Collection;
        boolean r1 = false;
        if (r0 == true) goto L15;
    L17:
        Iterator r3 = r10.iterator();
    L19:
        if (r3.hasNext() == false) goto L23;
        if (com.larus.bmhome.chat.bean.d.W0((Message) r3.next()) == false) goto L19;
        boolean r4 = true;
    L24:
        if (r4 == false) goto L28;
        this.a.a4("welcome_back");
        return;
    L28:
        if (r0 == true) goto L30;
    L32:
        Iterator r11 = r10.iterator();
    L34:
        if (r11.hasNext() == false) goto L50;
        Message r2 = (Message) r11.next();
        Map r5 = r2.getExt();
        if (r5 == null) goto L38;
        String r6 = (String) r5.get("clear_context");
    L40:
        if (Intrinsics.areEqual(r6, "1") == false) goto L42;
    L47:
        boolean r12 = true;
    L48:
        if (r12 == false) goto L34;
        r1 = true;
        goto L50
    L42:
        if (com.larus.bmhome.chat.bean.d.Y(r2) == true) goto L47;
        if (com.larus.bmhome.chat.bean.d.Z(r2) == true) goto L47;
        r12 = false;
        goto L48
    L38:
        r6 = null;
    L50:
        if (r1 == false) goto L61;
        this.a.a4("clear_context");
        return;
    L61:
        return;
    L30:
        if (r10.isEmpty() == false) goto L32;
    L23:
        r4 = false;
        goto L24
    L15:
        if (r10.isEmpty() == false) goto L17;
        goto L17
    }

    public q1(ClarificationComponent r1, u7 r2) {
        this.a = r1;
        this.b = r2;
    }
}
