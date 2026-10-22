package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioProcessor$flushRemainingData$1", f = "MmRecordingAudioProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAudioProcessor$flushRemainingData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onComplete;
    int label;
    final /* synthetic */ MmRecordingAudioProcessor this$0;

    public MmRecordingAudioProcessor$flushRemainingData$1(MmRecordingAudioProcessor r1, Function0<Unit> r2, Continuation<? super MmRecordingAudioProcessor$flushRemainingData$1> r3) {
        this.this$0 = r1;
        this.$onComplete = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingAudioProcessor$flushRemainingData$1(this.this$0, this.$onComplete, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r9);
        lvb.a.e(this.this$0.e, "flushRemainingData");
        byte[] r10 = this.this$0.a();
        String r3 = "";
        if (r10 == null) goto L15;
        Object r4 = this.this$0.m.trySend-JP2dKIU(r10);
        g.c r5 = g.b;
        if ((r4 instanceof g.c) == false) goto L15;
        lvb.a.b(this.this$0.e, "flushRemainingData: failed to send pcmData, size=" + r10.length);
        qvb.a r11 = qvb.a.a;
        Throwable r12 = g.a(r4);
        if (r12 == null) goto L11;
        String r13 = r12.getClass().getSimpleName();
    L12:
        if (r13 != null) goto L14;
        r13 = "";
    L14:
        qvb.a.b(null, "pcm_channel_send_failed", r13, null, 9);
        goto L15
    L11:
        r13 = null;
    L15:
        final MmRecordingAudioProcessor r14 = this.this$0;
        Channel<Object> r6 = r14.m;
        final Function0<Unit> r7 = this.$onComplete;
        Object r15 = r6.trySend-JP2dKIU(new MmRecordingAudioProcessor.b(new MmRecordingAudioProcessor$flushRemainingData$1$signalResult$1(r14, r7)));
        g.c r8 = g.b;
        if ((r15 instanceof g.c) == false) goto L26;
        lvb.a.b(this.this$0.e, "flushRemainingData: failed to send flush signal");
        qvb.a r16 = qvb.a.a;
        Throwable r17 = g.a(r15);
        if (r17 == null) goto L20;
        String r18 = r17.getClass().getSimpleName();
    L21:
        if (r18 == null) goto L24;
        r3 = r18;
    L24:
        qvb.a.b(null, "pcm_channel_send_failed", r3, null, 9);
        goto L26
    L20:
        r18 = null;
    L26:
        return Unit.INSTANCE;
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
