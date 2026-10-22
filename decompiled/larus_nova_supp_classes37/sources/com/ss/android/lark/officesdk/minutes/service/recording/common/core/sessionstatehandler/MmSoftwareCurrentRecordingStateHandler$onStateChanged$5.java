package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$onStateChanged$5", f = "MmSoftwareCurrentRecordingStateHandler.kt", i = {1}, l = {251, 253, 260}, m = "invokeSuspend", n = {"recordingData"}, s = {"L$0"})
public final class MmSoftwareCurrentRecordingStateHandler$onStateChanged$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MmSoftwareCurrentRecordingStateHandler this$0;

    public MmSoftwareCurrentRecordingStateHandler$onStateChanged$5(MmSoftwareCurrentRecordingStateHandler r1, Continuation<? super MmSoftwareCurrentRecordingStateHandler$onStateChanged$5> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmSoftwareCurrentRecordingStateHandler$onStateChanged$5(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r7);
    L21:
        this.this$0.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.UPLOAD_COMPLETED_SERVER));
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ovb.b r2 = (ovb.b) this.L$0;
        ResultKt.throwOnFailure(r7);
    L18:
        MmRecordingStatesSyncService r8 = this.this$0.f;
        String r3 = r2.a;
        this.L$0 = null;
        this.label = 3;
        if (r8.e(r3, this) != r0) goto L21;
        return r0;
    L11:
        ResultKt.throwOnFailure(r7);
    L15:
        r2 = (ovb.b) r7;
        MmRecordFileHelper r9 = MmRecordFileHelper.a;
        String r4 = this.this$0.a.b.getCurrentUserId();
        String r5 = r2.a;
        r9.getClass();
        String r10 = MmRecordFileHelper.f(r4, r5).getAbsolutePath();
        this.L$0 = r2;
        this.label = 2;
        if (MmRecordFileHelper.b(r10, this) != r0) goto L18;
        return r0;
    L12:
        ResultKt.throwOnFailure(r7);
        MmRecordingSession r11 = this.this$0.a;
        this.label = 1;
        r7 = r11.r(this);
        if (r7 != r0) goto L15;
        return r0;
    }
}
