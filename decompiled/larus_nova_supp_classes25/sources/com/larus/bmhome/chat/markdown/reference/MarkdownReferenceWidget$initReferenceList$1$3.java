package com.larus.bmhome.chat.markdown.reference;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextCard;
import fh8.f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class MarkdownReferenceWidget$initReferenceList$1$3 extends FunctionReferenceImpl implements Function1<Integer, String> {
    public MarkdownReferenceWidget$initReferenceList$1$3(Object r8) {
        super(1, r8, MarkdownReferenceWidget.class, "itemCardId", "itemCardId(I)Ljava/lang/String;", 0);
    }

    public final String invoke(int r4) {
        MarkdownReferenceWidget r0 = (MarkdownReferenceWidget) ((CallableReference) this).receiver;
        Object r5 = ListProtector.get(r0.e, r4);
        String r2 = null;
        if ((r5 instanceof TextCard) == false) goto L5;
        TextCard r6 = (TextCard) r5;
    L6:
        if (r6 == null) goto L10;
        Long r7 = r6.getId();
        if (r7 == null) goto L10;
        String r8 = r7.toString();
    L11:
        StringBuilder r1 = new StringBuilder();
        r1.append(r8);
        r1.append('&');
        f r9 = r0.n;
        if (r9 == null) goto L16;
        Message r10 = r9.b;
        if (r10 == null) goto L16;
        r2 = r10.getMessageId();
    L16:
        r1.append(r2);
        return r1.toString();
    L10:
        r8 = null;
        goto L11
    L5:
        r6 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Number) r1).intValue());
    }
}
