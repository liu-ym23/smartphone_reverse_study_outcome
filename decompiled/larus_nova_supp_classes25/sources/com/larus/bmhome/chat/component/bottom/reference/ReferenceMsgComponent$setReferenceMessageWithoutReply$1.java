package com.larus.bmhome.chat.component.bottom.reference;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.utils.ReferenceMessage;
import com.larus.utils.SafeExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class ReferenceMsgComponent$setReferenceMessageWithoutReply$1 extends FunctionReferenceImpl implements Function4<String, ReferenceMessage, String, Boolean, Unit> {
    public ReferenceMsgComponent$setReferenceMessageWithoutReply$1(Object r8) {
        super(4, r8, ReferenceMsgComponent.class, "updateRefMsgWithoutReply", "updateRefMsgWithoutReply(Ljava/lang/String;Lcom/larus/bmhome/utils/ReferenceMessage;Ljava/lang/String;Z)V", 0);
    }

    public final void invoke(String r4, ReferenceMessage r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        Intrinsics.checkNotNullParameter(r5, "p1");
        final ReferenceMsgComponent r0 = (ReferenceMsgComponent) ((CallableReference) this).receiver;
        int r1 = ReferenceMsgComponent.N;
        r0.getClass();
        if (Intrinsics.areEqual(r4, "action_update") == false) goto L12;
        ReferenceMessage.a r8 = r0.C3();
        Function0 r2 = new i(r0);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter(r2, "onClear");
        r8.b = r5;
        r8.a = r2;
        r0.C3().d = r6;
        if (Intrinsics.areEqual(r0.C3().d, "rewrite") == false) goto L9;
        ICoreInputAbility r9 = r0.z3();
        if (r9 == null) goto L9;
        r9.Yk(r0.getContext().getResources().getString(2131909191));
    L9:
        if (r7 == false) goto L13;
        SafeExtKt.b(r0.F2(), new j(r0), 200);
        return;
    L13:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        invoke((String) r1, (ReferenceMessage) r2, (String) r3, ((Boolean) r4).booleanValue());
        return Unit.INSTANCE;
    }
}
