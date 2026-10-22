package com.larus.bmhome.chat.component.bottom.multimodal.processor;

import android.net.Uri;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import ic8.m0;
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
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.processor.LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$useVideoEntity$1", f = "LegacyMultimodalDataProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$useVideoEntity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $fileIdentifier;
    final /* synthetic */ m0 $fileInfo;
    final /* synthetic */ Uri $uri;
    int label;

    public LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$useVideoEntity$1(Uri r1, m0 r2, String r3, Continuation<? super LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$useVideoEntity$1> r4) {
        this.$uri = r1;
        this.$fileInfo = r2;
        this.$fileIdentifier = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$useVideoEntity$1(this.$uri, this.$fileInfo, this.$fileIdentifier, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        return Boxing.boxBoolean(new com.larus.bmhome.chat.component.bottom.multimodal.preprocess.b().k(this.$uri, this.$fileInfo, this.$fileIdentifier));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
