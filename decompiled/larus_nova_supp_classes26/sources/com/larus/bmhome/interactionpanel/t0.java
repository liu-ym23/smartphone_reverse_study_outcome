package com.larus.bmhome.interactionpanel;

import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.message.Message;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t0 implements te8.c {
    public final /* synthetic */ MainConversationInteractionPanelMessageSourceComponent a;

    public t0(MainConversationInteractionPanelMessageSourceComponent r1) {
        this.a = r1;
    }

    public final void A(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        MainConversationInteractionPanelMessageSourceComponent.C3(this.a, "onStreamEnd", r3);
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

    public final void p(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        MainConversationInteractionPanelMessageSourceComponent.C3(this.a, "onUpdateMessage", r3);
    }

    public final void v(final List<Message> r9) {
        Intrinsics.checkNotNullParameter(r9, "messages");
        final MainConversationInteractionPanelMessageSourceComponent r0 = this.a;
        int r1 = MainConversationInteractionPanelMessageSourceComponent.s;
        y r2 = r0.u0();
        final Message r3 = null;
        if (r2 == null) goto L5;
        final String r4 = r2.Y1();
    L6:
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        if (StringsKt.isBlank(r4) == false) goto L11;
    L14:
        List r5 = CollectionsKt.emptyList();
    L16:
        if (r9.isEmpty() == false) goto L18;
        List r6 = CollectionsKt.emptyList();
    L19:
        r0.m.j(r4, r5);
        Iterator r7 = r6.iterator();
    L20:
        final String r8 = "onDeleteMessages";
        if (r7.hasNext() == false) goto L23;
        r0.m.m(r4, (String) r7.next(), CollectionsKt.emptyList(), "onDeleteMessages");
        goto L20
    L23:
        r0.F2().post(new k0(r8, r0, r3, r9));
        return;
    L18:
        r6 = SequencesKt.toList(SequencesKt.distinct(SequencesKt.mapNotNull(SequencesKt.flatMap(SequencesKt.flatMap(CollectionsKt.asSequence(r9), new g0(r0)), new h0()), new i0())));
        goto L19
    L11:
        if (r9.isEmpty() == true) goto L14;
        r5 = SequencesKt.toList(SequencesKt.flatMap(SequencesKt.distinct(SequencesKt.mapNotNull(SequencesKt.flatMap(SequencesKt.flatMap(CollectionsKt.asSequence(r9), new q0(r0)), new r0()), new s0())), new f0(r4)));
        goto L16
    L5:
        r4 = null;
        goto L6
    }

    public final void v1(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "answer");
    }

    public final void y0(String r3) {
        Intrinsics.checkNotNullParameter(r3, "id");
        MainConversationInteractionPanelMessageSourceComponent.C3(this.a, "onReceiveMessage", null);
    }
}
