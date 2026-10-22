package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService$createOrLookupRecordingId$2", f = "MmRecordingStatesSyncService.kt", i = {}, l = {318}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingStatesSyncService$createOrLookupRecordingId$2 extends SuspendLambda implements Function1<Continuation<? super Result<? extends String>>, Object> {
    final /* synthetic */ String $meetingId;
    int label;
    final /* synthetic */ MmRecordingStatesSyncService this$0;

    public MmRecordingStatesSyncService$createOrLookupRecordingId$2(MmRecordingStatesSyncService r1, String r2, Continuation<? super MmRecordingStatesSyncService$createOrLookupRecordingId$2> r3) {
        this.this$0 = r1;
        this.$meetingId = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new MmRecordingStatesSyncService$createOrLookupRecordingId$2(this.this$0, this.$meetingId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Result<String>> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
        Object r5 = ((Result) r4).unbox-impl();
    L12:
        return Result.box-impl(r5);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        MmRecordingStatesSyncService r6 = this.this$0;
        String r2 = this.$meetingId;
        this.label = 1;
        r5 = MmRecordingStatesSyncService.a(r6, r2, this);
        if (r5 != r0) goto L12;
        return r0;
    }
}
