package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareHistoryRecordingStateHandler$onStateChanged$4", f = "MmSoftwareHistoryRecordingStateHandler.kt", i = {0}, l = {200, 211, 224}, m = "invokeSuspend", n = {"userId"}, s = {"L$0"})
public final class MmSoftwareHistoryRecordingStateHandler$onStateChanged$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ String $sourceSessionKey;
    Object L$0;
    int label;
    final /* synthetic */ MmSoftwareHistoryRecordingStateHandler this$0;

    public MmSoftwareHistoryRecordingStateHandler$onStateChanged$4(MmSoftwareHistoryRecordingStateHandler r1, String r2, String r3, Continuation<? super MmSoftwareHistoryRecordingStateHandler$onStateChanged$4> r4) {
        this.this$0 = r1;
        this.$meetingId = r2;
        this.$sourceSessionKey = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmSoftwareHistoryRecordingStateHandler$onStateChanged$4(this.this$0, this.$meetingId, this.$sourceSessionKey, r5);
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
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r9);
    L26:
        this.this$0.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.UPLOAD_COMPLETED_SERVER));
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r9);
    L23:
        MmSoftwareHistoryRecordingStateHandler r10 = this.this$0;
        MmSoftwareHistoryRecordingStateHandler.Companion r2 = MmSoftwareHistoryRecordingStateHandler.h;
        MmRecordingStatesSyncService r11 = r10.d();
        String r3 = this.$meetingId;
        this.L$0 = null;
        this.label = 3;
        if (r11.e(r3, this) != r0) goto L26;
        return r0;
    L11:
        String r4 = (String) this.L$0;
        ResultKt.throwOnFailure(r9);
    L16:
        if ((!StringsKt.isBlank(this.$sourceSessionKey)) == true) goto L18;
    L22:
        lvb.a.e(this.this$0.b, "[historyUploadCleanup] skip source session dir, meetingId=" + this.$meetingId + ", sourceSessionKey=" + this.$sourceSessionKey);
        goto L23
    L18:
        if (Intrinsics.areEqual(this.$sourceSessionKey, this.$meetingId) == true) goto L22;
        lvb.a.e(this.this$0.b, "[historyUploadCleanup] delete source session dir, meetingId=" + this.$meetingId + ", sourceSessionKey=" + this.$sourceSessionKey);
        MmRecordFileHelper r12 = MmRecordFileHelper.a;
        String r5 = this.$sourceSessionKey;
        r12.getClass();
        String r13 = MmRecordFileHelper.f(r4, r5).getAbsolutePath();
        this.L$0 = null;
        this.label = 2;
        if (MmRecordFileHelper.b(r13, this) != r0) goto L23;
        return r0;
    L12:
        ResultKt.throwOnFailure(r9);
        r4 = this.this$0.a.b.getCurrentUserId();
        lvb.a.e(this.this$0.b, "[historyUploadCleanup] delete meeting dir, meetingId=" + this.$meetingId);
        MmRecordFileHelper r14 = MmRecordFileHelper.a;
        String r6 = this.$meetingId;
        r14.getClass();
        String r15 = MmRecordFileHelper.f(r4, r6).getAbsolutePath();
        this.L$0 = r4;
        this.label = 1;
        if (MmRecordFileHelper.b(r15, this) != r0) goto L16;
        return r0;
    }
}
