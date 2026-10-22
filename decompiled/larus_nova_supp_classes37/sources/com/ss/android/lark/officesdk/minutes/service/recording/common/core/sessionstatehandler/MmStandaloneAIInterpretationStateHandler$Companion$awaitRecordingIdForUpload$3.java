package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmCreateAudioResponse;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$3", f = "MmStandaloneAIInterpretationStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$3 extends SuspendLambda implements Function2<MmCreateAudioResponse, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$3(Continuation<? super MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$3> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$3 r0 = new MmStandaloneAIInterpretationStateHandler$Companion$awaitRecordingIdForUpload$3(r3);
        r0.L$0 = r2;
        return r0;
    }

    public final Object invoke(MmCreateAudioResponse r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((MmCreateAudioResponse) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r3);
        MmCreateAudioResponse r4 = (MmCreateAudioResponse) this.L$0;
        boolean r0 = false;
        if (r4 == null) goto L15;
        String r5 = r4.getRecordingId();
        if (r5 == null) goto L15;
        if (r5.length() <= 0) goto L11;
        boolean r6 = true;
    L12:
        if (r6 != true) goto L15;
        r0 = true;
        goto L15
    L11:
        r6 = false;
    L15:
        return Boxing.boxBoolean(r0);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
