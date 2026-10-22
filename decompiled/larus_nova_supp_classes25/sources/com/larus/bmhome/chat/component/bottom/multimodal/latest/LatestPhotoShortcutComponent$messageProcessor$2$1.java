package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class LatestPhotoShortcutComponent$messageProcessor$2$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public LatestPhotoShortcutComponent$messageProcessor$2$1(Object r8) {
        super(1, r8, LatestPhotoShortcutComponent.class, "dismiss", "dismiss(Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ((LatestPhotoShortcutComponent) ((CallableReference) this).receiver).g0(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
