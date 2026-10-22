package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.picker.base.view.ItemViewType;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareHistoryRecordingStateHandler$onStateChanged$3", f = "MmSoftwareHistoryRecordingStateHandler.kt", i = {}, l = {183}, m = "invokeSuspend", n = {}, s = {})
public final class MmSoftwareHistoryRecordingStateHandler$onStateChanged$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmSoftwareHistoryRecordingStateHandler this$0;

    public MmSoftwareHistoryRecordingStateHandler$onStateChanged$3(MmSoftwareHistoryRecordingStateHandler r1, Continuation<? super MmSoftwareHistoryRecordingStateHandler$onStateChanged$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmSoftwareHistoryRecordingStateHandler$onStateChanged$3(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MmSoftwareHistoryRecordingStateHandler r6 = this.this$0;
        this.label = 1;
        MmSoftwareHistoryRecordingStateHandler.Companion r2 = MmSoftwareHistoryRecordingStateHandler.h;
        r6.getClass();
        Object r7 = BuildersKt.withContext(MMCoroutines.a(), new MmSoftwareHistoryRecordingStateHandler$startUpload$2(r6, null), this);
        if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        r7 = Unit.INSTANCE;
    L12:
        if (r7 != r0) goto L15;
        return r0;
    }
}
