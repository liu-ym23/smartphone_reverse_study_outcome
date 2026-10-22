package com.larus.bmhome.chat.component.bottom.multimodal.processor;

import android.net.Uri;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.processor.LegacyMultimodalDataProcessor$process$3$downgrade$1", f = "LegacyMultimodalDataProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LegacyMultimodalDataProcessor$process$3$downgrade$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<Uri> $uriList;
    int label;
    final /* synthetic */ LegacyMultimodalDataProcessor this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public LegacyMultimodalDataProcessor$process$3$downgrade$1(LegacyMultimodalDataProcessor r1, List<? extends Uri> r2, Continuation<? super LegacyMultimodalDataProcessor$process$3$downgrade$1> r3) {
        this.this$0 = r1;
        this.$uriList = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LegacyMultimodalDataProcessor$process$3$downgrade$1(this.this$0, this.$uriList, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        LegacyMultimodalDataProcessor r4 = this.this$0;
        List<Uri> r0 = this.$uriList;
        int r1 = LegacyMultimodalDataProcessor.q;
        r4.getClass();
        return Boxing.boxBoolean(LegacyMultimodalDataProcessor.A(r0));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
