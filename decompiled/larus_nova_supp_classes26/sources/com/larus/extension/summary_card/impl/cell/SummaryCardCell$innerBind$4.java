package com.larus.extension.summary_card.impl.cell;

import com.larus.bmhome.chat.api.b0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.view.ChatMessageList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class SummaryCardCell$innerBind$4 extends FunctionReferenceImpl implements Function0<Unit> {
    public SummaryCardCell$innerBind$4(Object r8) {
        super(0, r8, SummaryCardCell.class, "scrollToRecyclerViewBottom", "scrollToRecyclerViewBottom()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m138invoke() {
        SummaryCardCell r0 = (SummaryCardCell) ((CallableReference) this).receiver;
        int r1 = SummaryCardCell.k;
        r0.getClass();
        q0 r2 = lf8.a.b(r0);
        if (r2 == null) goto L8;
        ChatMessageList r3 = r2.B7();
        if (r3 == null) goto L9;
        b0.a.a(r3, false, 0, null, null, 0, 30);
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m138invoke();
        return Unit.INSTANCE;
    }
}
