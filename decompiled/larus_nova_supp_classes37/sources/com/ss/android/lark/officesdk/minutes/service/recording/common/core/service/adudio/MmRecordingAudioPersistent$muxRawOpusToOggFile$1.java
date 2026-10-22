package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioPersistent", f = "MmRecordingAudioPersistent.kt", i = {}, l = {479}, m = "muxRawOpusToOggFile-BWLJW6A", n = {}, s = {})
final class MmRecordingAudioPersistent$muxRawOpusToOggFile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingAudioPersistent this$0;

    public MmRecordingAudioPersistent$muxRawOpusToOggFile$1(MmRecordingAudioPersistent r1, Continuation<? super MmRecordingAudioPersistent$muxRawOpusToOggFile$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        MmRecordingAudioPersistent r2 = this.this$0;
        r2.getClass();
        int r12 = this.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r12 - Integer.MIN_VALUE;
        MmRecordingAudioPersistent$muxRawOpusToOggFile$1 r13 = this;
    L6:
        Object r0 = r13.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r13.label;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        ResultKt.throwOnFailure(r0);
    L15:
        r7 = ((Result) r0).unbox-impl();
    L17:
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        return r7;
    L20:
        return Result.box-impl(r7);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r0);
        ExecutorCoroutineDispatcher r3 = r2.d;
        MmRecordingAudioPersistent$muxRawOpusToOggFile$2 r9 = new MmRecordingAudioPersistent$muxRawOpusToOggFile$2(r2, 0, 0, null, null);
        r13.label = 1;
        r0 = BuildersKt.withContext(r3, r9, r13);
        if (r0 != r7) goto L15;
    L5:
        r13 = new MmRecordingAudioPersistent$muxRawOpusToOggFile$1(r2, this);
        goto L6
    }
}
