package com.larus.avlink.gallery.executor;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.k1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaProcessingExecutor$startVideoProcessingWorker$1", f = "MediaProcessingExecutor.kt", i = {}, l = {239, 241}, m = "invokeSuspend", n = {}, s = {})
final class MediaProcessingExecutor$startVideoProcessingWorker$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MediaProcessingExecutor this$0;

    public MediaProcessingExecutor$startVideoProcessingWorker$1(MediaProcessingExecutor r1, Continuation<? super MediaProcessingExecutor$startVideoProcessingWorker$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MediaProcessingExecutor$startVideoProcessingWorker$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x007b -> B:19:0x0047). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L10;
        ChannelIterator r2 = (ChannelIterator) this.L$1;
        MediaProcessingExecutor r5 = (MediaProcessingExecutor) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L31
        MediaProcessingExecutor r13 = r5;
    L18:
        MediaProcessingExecutor$startVideoProcessingWorker$1 r6 = this;
    L19:
        r6.L$0 = r13;     // Catch: Exception -> L31
        r6.L$1 = r2;     // Catch: Exception -> L31
        r6.label = 1;     // Catch: Exception -> L31
        Object r7 = r2.hasNext(r6);     // Catch: Exception -> L31
        if (r7 != r0) goto L22;
        return r0;
    L22:
        MediaProcessingExecutor$startVideoProcessingWorker$1 r10 = r6;
        MediaProcessingExecutor r8 = r13;
        r12 = r7;
        MediaProcessingExecutor$startVideoProcessingWorker$1 r9 = r10;
    L24:
        if (((Boolean) r12).booleanValue() == false) goto L29;
        MediaProcessingExecutor.b r14 = (MediaProcessingExecutor.b) r2.next();     // Catch: Exception -> L31
        k1 r11 = k1.a;     // Catch: Exception -> L31
        MediaProcessingExecutor$startVideoProcessingWorker$1$1$1 r15 = new MediaProcessingExecutor$startVideoProcessingWorker$1$1$1(r8, r14, null);     // Catch: Exception -> L31
        r9.L$0 = r8;     // Catch: Exception -> L31
        r9.L$1 = r2;     // Catch: Exception -> L31
        r9.label = 2;     // Catch: Exception -> L31
        if (BuildersKt.withContext(r11, r15, r9) != r0) goto L28;
        return r0;
    L28:
        r13 = r8;
        r6 = r9;
    L29:
        FLogger.a.i("MediaProcessingExecutor", "Video processing worker finished");     // Catch: Exception -> L31
    L34:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r2 = (ChannelIterator) this.L$1;
        r8 = (MediaProcessingExecutor) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L31
        r9 = this;
        goto L24
    L14:
        ResultKt.throwOnFailure(r12);
        FLogger.a.i("MediaProcessingExecutor", "Video processing worker started");     // Catch: Exception -> L31
        r13 = this.this$0;     // Catch: Exception -> L31
        Channel<MediaProcessingExecutor.b> r3 = r13.d;     // Catch: Exception -> L31
        if (r3 == null) goto L29;
        r2 = r3.iterator();     // Catch: Exception -> L31
    L31:
        e = move-exception;
        FLogger.a.e("MediaProcessingExecutor", "Video processing worker error: " + e.getMessage(), e);
        goto L34
    }
}
