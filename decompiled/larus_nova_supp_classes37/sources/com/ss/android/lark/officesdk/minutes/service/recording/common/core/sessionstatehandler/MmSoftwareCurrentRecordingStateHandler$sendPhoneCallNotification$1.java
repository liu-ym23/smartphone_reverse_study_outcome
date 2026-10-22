package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$sendPhoneCallNotification$1", f = "MmSoftwareCurrentRecordingStateHandler.kt", i = {}, l = {282}, m = "invokeSuspend", n = {}, s = {})
final class MmSoftwareCurrentRecordingStateHandler$sendPhoneCallNotification$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isCalling;
    int label;
    final /* synthetic */ MmSoftwareCurrentRecordingStateHandler this$0;

    public MmSoftwareCurrentRecordingStateHandler$sendPhoneCallNotification$1(MmSoftwareCurrentRecordingStateHandler r1, boolean r2, Continuation<? super MmSoftwareCurrentRecordingStateHandler$sendPhoneCallNotification$1> r3) {
        this.this$0 = r1;
        this.$isCalling = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmSoftwareCurrentRecordingStateHandler$sendPhoneCallNotification$1(this.this$0, this.$isCalling, r4);
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
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MmRecordingSession r6 = this.this$0.a;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.b.C0044b r2 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.b.C0044b(this.$isCalling);
        this.label = 1;
        if (r6.t(r2, this) != r0) goto L12;
        return r0;
    }
}
