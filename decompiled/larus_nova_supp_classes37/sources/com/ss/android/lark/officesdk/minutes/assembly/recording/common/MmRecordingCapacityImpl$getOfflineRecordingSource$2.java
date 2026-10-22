package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl$getOfflineRecordingSource$2", f = "MmRecordingCapacityImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingCapacityImpl$getOfflineRecordingSource$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MmRecordingSource>, Object> {
    final /* synthetic */ String $recordingId;
    int label;
    final /* synthetic */ MmRecordingCapacityImpl this$0;

    public MmRecordingCapacityImpl$getOfflineRecordingSource$2(MmRecordingCapacityImpl r1, String r2, Continuation<? super MmRecordingCapacityImpl$getOfflineRecordingSource$2> r3) {
        this.this$0 = r1;
        this.$recordingId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingCapacityImpl$getOfflineRecordingSource$2(this.this$0, this.$recordingId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super MmRecordingSource> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        MmRecordingSource r5 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.e) this.this$0.m.getValue()).r(this.$recordingId);
        lvb.a.e(this.this$0.d, "[getOfflineRecordingSource] recordingId=" + this.$recordingId + ", source=" + r5);
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
