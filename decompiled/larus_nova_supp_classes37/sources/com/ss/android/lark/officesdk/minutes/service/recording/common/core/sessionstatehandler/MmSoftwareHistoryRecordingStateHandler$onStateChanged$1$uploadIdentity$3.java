package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "result", "Lkotlin/Result;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmCreateAudioResponse;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$3", f = "MmSoftwareHistoryRecordingStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$3 extends SuspendLambda implements Function2<Result<? extends MmCreateAudioResponse>, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$3(Continuation<? super MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$3> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$3 r0 = new MmSoftwareHistoryRecordingStateHandler$onStateChanged$1$uploadIdentity$3(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Result) r1, (Continuation) r2);
    }

    public final Object invoke(Result<MmCreateAudioResponse> r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r5);
        Result r6 = (Result) this.L$0;
        Throwable r0 = null;
        if (r6 == null) goto L12;
        Object r1 = r6.unbox-impl();
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        MmCreateAudioResponse r2 = (MmCreateAudioResponse) r1;
        if (r2 == null) goto L12;
        String r3 = r2.getObjectToken();
    L13:
        boolean r4 = true;
        if (r3 != null) goto L16;
    L21:
        boolean r7 = false;
    L22:
        if (r7 == true) goto L29;
        if (r6 == null) goto L25;
        r0 = Result.exceptionOrNull-impl(r6.unbox-impl());
    L25:
        if (r0 != null) goto L29;
        r4 = false;
    L29:
        return Boxing.boxBoolean(r4);
    L16:
        if (r3.length() <= 0) goto L18;
        boolean r8 = true;
    L19:
        if (r8 != true) goto L21;
        r7 = true;
        goto L22
    L18:
        r8 = false;
    L12:
        r3 = null;
        goto L13
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
