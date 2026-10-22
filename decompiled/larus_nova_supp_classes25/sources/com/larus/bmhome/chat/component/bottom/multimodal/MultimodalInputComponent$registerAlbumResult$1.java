package com.larus.bmhome.chat.component.bottom.multimodal;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class MultimodalInputComponent$registerAlbumResult$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public MultimodalInputComponent$registerAlbumResult$1(Object r8) {
        super(0, r8, MultimodalInputComponent.class, "performAfterSendInAlbum", "performAfterSendInAlbum()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m69invoke() {
        MultimodalInputComponent r0 = (MultimodalInputComponent) ((CallableReference) this).receiver;
        int r1 = MultimodalInputComponent.N;
        r0.D3();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m69invoke();
        return Unit.INSTANCE;
    }
}
