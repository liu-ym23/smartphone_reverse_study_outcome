package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class MentionPanelController$conversationIconSession$1 extends FunctionReferenceImpl implements Function1<Set<? extends String>, Unit> {
    public MentionPanelController$conversationIconSession$1(Object r8) {
        super(1, r8, q0.class, "notifyConversationIconsChanged", "notifyConversationIconsChanged(Ljava/util/Set;)V", 0);
    }

    public final void invoke(Set<String> r9) {
        Intrinsics.checkNotNullParameter(r9, "p0");
        q0 r0 = (q0) ((CallableReference) this).receiver;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r9, "conversationIds");
        MentionPanelListView r1 = r0.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "conversationIds");
        MentionPanelListView.PanelAdapter r2 = r1.d;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "conversationIds");
        Iterator<T> r3 = r2.a.iterator();
        int r4 = 0;
    L4:
        if (r3.hasNext() == false) goto L18;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        y r7 = (y) r5;
        Set<String> r8 = r9;
        String r10 = null;
        if ((r7 instanceof y.d) == false) goto L11;
        y.d r11 = (y.d) r7;
    L12:
        if (r11 == null) goto L15;
        r10 = r11.m;
    L15:
        if (CollectionsKt.contains(r8, r10) == false) goto L17;
        r2.notifyItemChanged(r4);
    L17:
        r4 = r6;
        goto L4
    L11:
        r11 = null;
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Set) r1);
        return Unit.INSTANCE;
    }
}
