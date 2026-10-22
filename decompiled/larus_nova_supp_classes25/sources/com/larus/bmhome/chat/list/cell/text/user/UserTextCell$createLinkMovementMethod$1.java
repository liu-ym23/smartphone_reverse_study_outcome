package com.larus.bmhome.chat.list.cell.text.user;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class UserTextCell$createLinkMovementMethod$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public UserTextCell$createLinkMovementMethod$1(Object r8) {
        super(0, r8, wg8.c.class, "consumeClickableSpanClick", "consumeClickableSpanClick()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m102invoke() {
        final wg8.c r0 = (wg8.c) ((CallableReference) this).receiver;
        r0.e();
        r0.d = true;
        com.larus.bmhome.chat.layout.item.i r1 = r0.b;
        if (r1 == null) goto L6;
        r1.post(new wg8.b(r0));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m102invoke();
        return Unit.INSTANCE;
    }
}
