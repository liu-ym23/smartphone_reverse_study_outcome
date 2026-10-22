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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioPersistent$finishFullFileEncoding$2", f = "MmRecordingAudioPersistent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAudioPersistent$finishFullFileEncoding$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingAudioPersistent this$0;

    public MmRecordingAudioPersistent$finishFullFileEncoding$2(MmRecordingAudioPersistent r1, Continuation<? super MmRecordingAudioPersistent$finishFullFileEncoding$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingAudioPersistent$finishFullFileEncoding$2 r0 = new MmRecordingAudioPersistent$finishFullFileEncoding$2(this.this$0, r4);
        r0.L$0 = r3;
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
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r4);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        OggOpusEncoder r6 = this.this$0.h;
        if (r6 == null) goto L7;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        Object r7 = Result.constructor-impl(r6.finish());     // Catch: Throwable -> L10
    L12:
        MmRecordingAudioPersistent r1 = this.this$0;
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L18;
        lvb.a.b(r1.c, "finishFullFileEncoding failed: " + r8);
        String r2 = r8.getClass().getSimpleName();
        String r9 = r8.getMessage();
        if (r9 != null) goto L17;
        r9 = "";
    L17:
        MmRecordingAudioPersistent.f("finish_full_audio_failed", r2, r9);
    L18:
        this.this$0.h = null;
        return Unit.INSTANCE;
    L10:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L7:
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
