package com.larus.avlink.gallery.executor;

import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.j;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaProcessingExecutor$enqueueTask$1", f = "MediaProcessingExecutor.kt", i = {1}, l = {DoraCallStateCode.RTOS_STOP_SI_BY_GESTURE, DoraCallStateCode.ENV_OBSERVE_AUTO_LINK_CONNECTED}, m = "invokeSuspend", n = {"queueType"}, s = {"L$0"})
public final class MediaProcessingExecutor$enqueueTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isRecovery;
    final /* synthetic */ String $uniqId;
    Object L$0;
    int label;
    final /* synthetic */ MediaProcessingExecutor this$0;

    public MediaProcessingExecutor$enqueueTask$1(String r1, MediaProcessingExecutor r2, boolean r3, Continuation<? super MediaProcessingExecutor$enqueueTask$1> r4) {
        this.$uniqId = r1;
        this.this$0 = r2;
        this.$isRecovery = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MediaProcessingExecutor$enqueueTask$1(this.$uniqId, this.this$0, this.$isRecovery, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = this.label;
        boolean r6 = true;
        if (r4 == 0) goto L13;
        if (r4 == 1) goto L11;
        if (r4 != 2) goto L10;
        String r0 = (String) this.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L62
    L57:
        String r2 = r0;
    L58:
        FLogger.a.d("MediaProcessingExecutor", "[" + r2 + "] Enqueued task for media: " + this.$uniqId + ", isRecovery: " + this.$isRecovery);     // Catch: Exception -> L62
    L65:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L62
    L17:
        MediaMetadata r10 = (MediaMetadata) r9;     // Catch: Exception -> L62
        if (r10 != null) goto L21;
        FLogger.a.e("MediaProcessingExecutor", "Cannot enqueue: metadata not found for " + this.$uniqId);     // Catch: Exception -> L62
        return Unit.INSTANCE;
    L21:
        String r5 = r10.getMediaType();     // Catch: Exception -> L62
        if (r5 != null) goto L24;
    L27:
        boolean r7 = true;
    L28:
        if (r7 == true) goto L33;
        int r8 = j.a;     // Catch: Exception -> L62
        if (j.a(r10.getMediaType()) == true) goto L33;
        r6 = false;
    L33:
        if (r6 == false) goto L35;
        Channel<MediaProcessingExecutor.b> r11 = this.this$0.c;     // Catch: Exception -> L62
    L36:
        if (r6 == false) goto L38;
        r2 = "Image";
    L39:
        if (r6 == false) goto L41;
        Set<String> r12 = this.this$0.e;     // Catch: Exception -> L62
    L42:
        String r13 = this.$uniqId;     // Catch: Exception -> L62
        monitor-enter(r12);     // Catch: Exception -> L62
    L59:
        th = move-exception;
        throw th;     // Catch: Exception -> L62
    L45:
        if (r12.contains(r13) == false) goto L49;
        FLogger.a.w("MediaProcessingExecutor", "[" + r2 + "] Task already in queue, skipping: " + r13);     // Catch: Throwable -> L59
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L59
        monitor-exit(r12);     // Catch: Exception -> L62
        return r14;
    L49:
        r12.add(r13);     // Catch: Throwable -> L59
        monitor-exit(r12);     // Catch: Exception -> L62
        MediaProcessingExecutor.b r1 = new MediaProcessingExecutor.b(this.$uniqId, this.$isRecovery);     // Catch: Exception -> L62
        if (r11 == null) goto L58;
        this.L$0 = r2;     // Catch: Exception -> L62
        this.label = 2;     // Catch: Exception -> L62
        if (r11.send(r1, this) != r3) goto L56;
        return r3;
    L56:
        r0 = r2;
        goto L57
    L41:
        r12 = this.this$0.f;     // Catch: Exception -> L62
        goto L42
    L38:
        r2 = "Video";
        goto L39
    L35:
        r11 = this.this$0.d;     // Catch: Exception -> L62
        goto L36
    L24:
        if (r5.length() == 0) goto L27;
        r7 = false;
        goto L28
    L13:
        ResultKt.throwOnFailure(r9);
        AlbumDataBaseHelper r15 = AlbumDataBaseHelper.a;     // Catch: Exception -> L62
        String r16 = this.$uniqId;     // Catch: Exception -> L62
        this.label = 1;     // Catch: Exception -> L62
        r9 = r15.o(r16, this);     // Catch: Exception -> L62
        if (r9 != r3) goto L17;
        return r3;
    L62:
        e = move-exception;
        FLogger.a.e("MediaProcessingExecutor", "Error enqueuing task for " + this.$uniqId + ": " + e.getMessage(), e);
        goto L65
    }
}
