package com.larus.bmhome.chat.component.bottom.multimodal.processor;

import android.net.Uri;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.processor.LegacyMultimodalDataProcessor$process$3", f = "LegacyMultimodalDataProcessor.kt", i = {}, l = {324}, m = "invokeSuspend", n = {}, s = {})
public final class LegacyMultimodalDataProcessor$process$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.chat.component.bottom.multimodal.n $data;
    final /* synthetic */ List<Uri> $uriList;
    int label;
    final /* synthetic */ LegacyMultimodalDataProcessor this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public LegacyMultimodalDataProcessor$process$3(LegacyMultimodalDataProcessor r1, List<? extends Uri> r2, com.larus.bmhome.chat.component.bottom.multimodal.n r3, Continuation<? super LegacyMultimodalDataProcessor$process$3> r4) {
        this.this$0 = r1;
        this.$uriList = r2;
        this.$data = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new LegacyMultimodalDataProcessor$process$3(this.this$0, this.$uriList, this.$data, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        if (((Boolean) r7).booleanValue() == true) goto L14;
        LegacyMultimodalDataProcessor r8 = this.this$0;
        List<Uri> r2 = this.$uriList;
        boolean r3 = !this.$data.b.a;
        int r4 = LegacyMultimodalDataProcessor.q;
        r8.J(r2, r3);
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r9 = Dispatchers.getIO();
        LegacyMultimodalDataProcessor$process$3$downgrade$1 r5 = new LegacyMultimodalDataProcessor$process$3$downgrade$1(this.this$0, this.$uriList, null);
        this.label = 1;
        r7 = BuildersKt.withContext(r9, r5, this);
        if (r7 != r0) goto L12;
        return r0;
    }
}
