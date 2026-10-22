package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.e0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService$saveDoubaoBizInfo$1", f = "MmRecordingStatesSyncService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingStatesSyncService$saveDoubaoBizInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoubaoBizInfo $doubaoBizInfo;
    final /* synthetic */ String $meetingId;
    int label;
    final /* synthetic */ MmRecordingStatesSyncService this$0;

    public MmRecordingStatesSyncService$saveDoubaoBizInfo$1(MmRecordingStatesSyncService r1, String r2, DoubaoBizInfo r3, Continuation<? super MmRecordingStatesSyncService$saveDoubaoBizInfo$1> r4) {
        this.this$0 = r1;
        this.$meetingId = r2;
        this.$doubaoBizInfo = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingStatesSyncService$saveDoubaoBizInfo$1(this.this$0, this.$meetingId, this.$doubaoBizInfo, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r6);
        MmRecordingStatesSyncService r7 = this.this$0;
        MmRecordingStatesSyncService.Companion r0 = MmRecordingStatesSyncService.q;
        e r8 = r7.l();
        String r1 = this.$meetingId;
        DoubaoBizInfo r2 = this.$doubaoBizInfo;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r1, "meetingId");
        Intrinsics.checkNotNullParameter(r2, "doubaoBizInfo");
        lvb.a.e(r8.b, "saveDoubaoBizInfo, meetingId:" + r1 + ", doubaoBizInfo:" + r2);
        KVRepo r9 = r8.a.H();
        StringBuilder r3 = new StringBuilder("minutes_recording_v2_doubao_biz_info_prefix");
        r3.append(r1);
        r9.putString(r3.toString(), e0.c(r2));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
