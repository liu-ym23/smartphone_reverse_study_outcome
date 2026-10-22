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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$onStateChanged$4", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {1, 2}, l = {362, 364, 371, 379}, m = "invokeSuspend", n = {"recordingData", "recordingData"}, s = {"L$0", "L$0"})
public final class MmPreMeetingNativeRecordingStateHandler$onStateChanged$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MmPreMeetingNativeRecordingStateHandler this$0;

    public MmPreMeetingNativeRecordingStateHandler$onStateChanged$4(MmPreMeetingNativeRecordingStateHandler r1, Continuation<? super MmPreMeetingNativeRecordingStateHandler$onStateChanged$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmPreMeetingNativeRecordingStateHandler$onStateChanged$4(this.this$0, r3);
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
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L10;
        ResultKt.throwOnFailure(r9);
    L31:
        this.this$0.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.UPLOAD_COMPLETED_SERVER));
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ovb.b r2 = (ovb.b) this.L$0;
        ResultKt.throwOnFailure(r9);
    L28:
        MmRecordingStatesSyncService r10 = this.this$0.g;
        String r3 = r2.a;
        this.L$0 = null;
        this.label = 4;
        if (r10.e(r3, this) != r0) goto L31;
        return r0;
    L12:
        r2 = (ovb.b) this.L$0;
        ResultKt.throwOnFailure(r9);
    L22:
        if ((!StringsKt.isBlank(r2.g)) == false) goto L28;
        if (Intrinsics.areEqual(r2.g, r2.a) == true) goto L28;
        MmRecordFileHelper r11 = MmRecordFileHelper.a;
        String r4 = this.this$0.a.b.getCurrentUserId();
        String r5 = r2.g;
        r11.getClass();
        String r12 = MmRecordFileHelper.f(r4, r5).getAbsolutePath();
        this.L$0 = r2;
        this.label = 3;
        if (MmRecordFileHelper.b(r12, this) != r0) goto L28;
        return r0;
    L13:
        ResultKt.throwOnFailure(r9);
    L17:
        ovb.b r13 = (ovb.b) r9;
        MmRecordFileHelper r6 = MmRecordFileHelper.a;
        String r7 = this.this$0.a.b.getCurrentUserId();
        String r8 = r13.a;
        r6.getClass();
        String r14 = MmRecordFileHelper.f(r7, r8).getAbsolutePath();
        this.L$0 = r13;
        this.label = 2;
        if (MmRecordFileHelper.b(r14, this) != r0) goto L20;
        return r0;
    L20:
        r2 = r13;
        goto L22
    L14:
        ResultKt.throwOnFailure(r9);
        MmRecordingSession r15 = this.this$0.a;
        this.label = 1;
        r9 = r15.r(this);
        if (r9 != r0) goto L17;
        return r0;
    }
}
