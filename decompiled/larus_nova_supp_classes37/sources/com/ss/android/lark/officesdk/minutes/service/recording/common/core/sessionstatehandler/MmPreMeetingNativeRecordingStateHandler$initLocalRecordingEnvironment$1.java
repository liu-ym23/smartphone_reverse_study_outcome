package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.k;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$initLocalRecordingEnvironment$1", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmPreMeetingNativeRecordingStateHandler$initLocalRecordingEnvironment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmPreMeetingNativeRecordingStateHandler this$0;

    public MmPreMeetingNativeRecordingStateHandler$initLocalRecordingEnvironment$1(MmPreMeetingNativeRecordingStateHandler r1, Continuation<? super MmPreMeetingNativeRecordingStateHandler$initLocalRecordingEnvironment$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmPreMeetingNativeRecordingStateHandler$initLocalRecordingEnvironment$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r5);
        MmRecordingAudioService r6 = this.this$0.k("initLocalRecordingEnvironment");
        if (r6 == null) goto L7;
        MmRecordingSession r0 = this.this$0.a;
        String r1 = r0.w.g;
        k r2 = r0.f;
        if (r2 == null) goto L11;
        MmRecordingSource r3 = r2.a;
    L12:
        if (r2 != null) goto L15;
    L17:
        boolean r4 = false;
    L19:
        if (r6.b(r1, r3, r4) == true) goto L22;
        lvb.a.b(this.this$0.c, "create audio dir failed, terminate session");
        this.this$0.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.DIR_CREATE_FAILED));
        return Unit.INSTANCE;
    L22:
        String r7 = r6.e();
        lvb.a.e(this.this$0.c, "updateRecordingAudioFilePath: audioFilePath=" + r7);
        this.this$0.d.A().A(r1, r7);
        MmPreMeetingNativeRecordingStateHandler r8 = this.this$0;
        if (r8.u == false) goto L25;
        r8.g.v(r1, r7);
    L25:
        this.this$0.a.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.b.a);
        return Unit.INSTANCE;
    L15:
        if (r2.a != MmRecordingSource.FEISHU_HARDWARE_D1204) goto L17;
        r4 = true;
        goto L19
    L11:
        r3 = null;
        goto L12
    L7:
        return Unit.INSTANCE;
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
