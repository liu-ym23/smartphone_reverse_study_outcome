package com.larus.extension.summary_card.impl.cell;

import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class SummaryCardCell$innerBind$2 extends FunctionReferenceImpl implements Function2<Message, CustomMarkdownTextView, Unit> {
    public SummaryCardCell$innerBind$2(Object r8) {
        super(2, r8, SummaryCardCell.class, "performClick", "performClick(Lcom/larus/im/bean/message/Message;Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;)V", 0);
    }

    public final void invoke(Message r5, CustomMarkdownTextView r6) {
        SummaryCardCell r0 = (SummaryCardCell) ((CallableReference) this).receiver;
        SummaryCardCell.b r1 = r0.i;
        boolean r3 = true;
        int r2 = r1.a + 1;
        r1.a = r2;
        r1.b = r6;
        r1.c = r5;
        if (r2 == 1) goto L6;
        r3 = false;
    L6:
        if (r3 == false) goto L11;
        com.larus.bmhome.chat.layout.item.i r7 = r0.e;
        if (r7 == null) goto L12;
        r7.postDelayed(r1, 300);
        return;
    L12:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Message) r1, (CustomMarkdownTextView) r2);
        return Unit.INSTANCE;
    }
}
