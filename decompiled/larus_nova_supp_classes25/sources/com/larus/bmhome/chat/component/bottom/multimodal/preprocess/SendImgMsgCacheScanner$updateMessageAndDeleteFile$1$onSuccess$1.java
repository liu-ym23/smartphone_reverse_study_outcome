package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.preprocess.SendImgMsgCacheScanner$updateMessageAndDeleteFile$1$onSuccess$1", f = "SendImgMsgScanner2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SendImgMsgCacheScanner$updateMessageAndDeleteFile$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $expiredBeforeMs;
    final /* synthetic */ File $file;
    int label;
    final /* synthetic */ SendImgMsgCacheScanner this$0;

    public SendImgMsgCacheScanner$updateMessageAndDeleteFile$1$onSuccess$1(SendImgMsgCacheScanner r1, File r2, long r3, Continuation<? super SendImgMsgCacheScanner$updateMessageAndDeleteFile$1$onSuccess$1> r5) {
        this.this$0 = r1;
        this.$file = r2;
        this.$expiredBeforeMs = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SendImgMsgCacheScanner$updateMessageAndDeleteFile$1$onSuccess$1(this.this$0, this.$file, this.$expiredBeforeMs, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        SendImgMsgCacheScanner r6 = this.this$0;
        File r0 = this.$file;
        long r1 = this.$expiredBeforeMs;
        AtomicBoolean r3 = SendImgMsgCacheScanner.e;
        r6.getClass();
        SendImgMsgCacheScanner.f(r0, r1);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
