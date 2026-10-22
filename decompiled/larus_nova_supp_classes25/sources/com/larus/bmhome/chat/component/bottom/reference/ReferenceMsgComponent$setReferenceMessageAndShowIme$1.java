package com.larus.bmhome.chat.component.bottom.reference;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.utils.ReferenceMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class ReferenceMsgComponent$setReferenceMessageAndShowIme$1 extends FunctionReferenceImpl implements Function7<String, ReferenceMessage, List<? extends String>, String, Boolean, String, Boolean, Unit> {
    public ReferenceMsgComponent$setReferenceMessageAndShowIme$1(Object r8) {
        super(7, r8, ReferenceMsgComponent.class, "onRefMsgUpdate", "onRefMsgUpdate(Ljava/lang/String;Lcom/larus/bmhome/utils/ReferenceMessage;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;Z)V", 0);
    }

    public final void invoke(String r10, ReferenceMessage r11, List<String> r12, String r13, boolean r14, String r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r10, "p0");
        Intrinsics.checkNotNullParameter(r11, "p1");
        Intrinsics.checkNotNullParameter(r12, "p2");
        ReferenceMsgComponent r1 = (ReferenceMsgComponent) ((CallableReference) this).receiver;
        int r5 = ReferenceMsgComponent.N;
        r1.D3(r10, r11, r12, r13, r14, r15, r16);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r9, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15) {
        invoke((String) r9, (ReferenceMessage) r10, (List) r11, (String) r12, ((Boolean) r13).booleanValue(), (String) r14, ((Boolean) r15).booleanValue());
        return Unit.INSTANCE;
    }
}
