package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.v;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager$updateRecordingUploadState$1", f = "MmRecordingSessionManager.kt", i = {}, l = {1019}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingSessionManager$updateRecordingUploadState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $minutesToken;
    final /* synthetic */ float $progress;
    final /* synthetic */ String $recordingId;
    int label;
    final /* synthetic */ MmRecordingSessionManager this$0;

    public MmRecordingSessionManager$updateRecordingUploadState$1(MmRecordingSessionManager r1, String r2, float r3, String r4, Continuation<? super MmRecordingSessionManager$updateRecordingUploadState$1> r5) {
        this.this$0 = r1;
        this.$recordingId = r2;
        this.$progress = r3;
        this.$minutesToken = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmRecordingSessionManager$updateRecordingUploadState$1(this.this$0, this.$recordingId, this.$progress, this.$minutesToken, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        lvb.a.e(this.this$0.b, "[updateRecordingUploadState] emit, recordingId=" + this.$recordingId + ", progress=" + this.$progress);
        MutableSharedFlow<v> r10 = this.this$0.E;
        v r2 = new v(this.$recordingId, this.$minutesToken, RangesKt.coerceIn(this.$progress, 0.0f, 1.0f));
        this.label = 1;
        if (r10.emit(r2, this) != r0) goto L12;
        return r0;
    }
}
