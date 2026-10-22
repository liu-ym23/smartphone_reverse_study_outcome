package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.bytedance.lark.oggopus_rust_android.OggOpusEncoder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioPersistent$appendPcmToFullFile$2", f = "MmRecordingAudioPersistent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAudioPersistent$appendPcmToFullFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $pcmData;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingAudioPersistent this$0;

    public MmRecordingAudioPersistent$appendPcmToFullFile$2(MmRecordingAudioPersistent r1, byte[] r2, Continuation<? super MmRecordingAudioPersistent$appendPcmToFullFile$2> r3) {
        this.this$0 = r1;
        this.$pcmData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MmRecordingAudioPersistent$appendPcmToFullFile$2 r0 = new MmRecordingAudioPersistent$appendPcmToFullFile$2(this.this$0, this.$pcmData, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r4);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        OggOpusEncoder r6 = this.this$0.h;
        if (r6 == null) goto L7;
        byte[] r0 = this.$pcmData;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        Object r7 = Result.constructor-impl(r6.write(r0));     // Catch: Throwable -> L11
    L13:
        MmRecordingAudioPersistent r2 = this.this$0;
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L20;
        lvb.a.b(r2.c, "appendPcmToFullFile failed: " + r8);
        String r3 = r8.getClass().getSimpleName();
        String r9 = r8.getMessage();
        if (r9 != null) goto L18;
        r9 = "";
    L18:
        MmRecordingAudioPersistent.f("append_full_audio_failed", r3, r9);
    L20:
        return Unit.INSTANCE;
    L11:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L7:
        return Unit.INSTANCE;
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
