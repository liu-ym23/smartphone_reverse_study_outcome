package com.larus.bmhome.chat.component.bottom.reference;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.utils.ReferenceMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class ReferenceMsgComponent$clearReferenceMessage$1 extends AdaptedFunctionReference implements Function4<String, ReferenceMessage, List<? extends String>, String, Unit> {
    public ReferenceMsgComponent$clearReferenceMessage$1(Object r8) {
        super(4, r8, ReferenceMsgComponent.class, "onRefMsgUpdate", "onRefMsgUpdate(Ljava/lang/String;Lcom/larus/bmhome/utils/ReferenceMessage;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;Z)V", 0);
    }

    public final void invoke(String r10, ReferenceMessage r11, List<String> r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "p0");
        Intrinsics.checkNotNullParameter(r11, "p1");
        Intrinsics.checkNotNullParameter(r12, "p2");
        ReferenceMsgComponent r1 = (ReferenceMsgComponent) ((AdaptedFunctionReference) this).receiver;
        int r0 = ReferenceMsgComponent.N;
        r1.D3(r10, r11, r12, r13, true, null, false);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        invoke((String) r1, (ReferenceMessage) r2, (List) r3, (String) r4);
        return Unit.INSTANCE;
    }
}
