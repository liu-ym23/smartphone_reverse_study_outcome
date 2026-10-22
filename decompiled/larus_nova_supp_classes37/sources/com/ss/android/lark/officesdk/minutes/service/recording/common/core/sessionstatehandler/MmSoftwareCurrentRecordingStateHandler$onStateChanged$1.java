package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.MinutesForegroundService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import iub.k;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$onStateChanged$1", f = "MmSoftwareCurrentRecordingStateHandler.kt", i = {}, l = {144, 165}, m = "invokeSuspend", n = {}, s = {})
public final class MmSoftwareCurrentRecordingStateHandler$onStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmSoftwareCurrentRecordingStateHandler this$0;

    public MmSoftwareCurrentRecordingStateHandler$onStateChanged$1(MmSoftwareCurrentRecordingStateHandler r1, Continuation<? super MmSoftwareCurrentRecordingStateHandler$onStateChanged$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmSoftwareCurrentRecordingStateHandler$onStateChanged$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r13);
    L24:
        if (((Boolean) r13).booleanValue() == false) goto L27;
        this.this$0.j = null;
        this.this$0.a.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.j.a);
    L27:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
    L13:
        ovb.b r14 = (ovb.b) r13;
        MmSoftwareCurrentRecordingStateHandler r2 = this.this$0;
        MmRecordingAudioService r3 = r2.d;
        String r5 = r14.a;
        k r4 = r2.a.f;
        if (r4 == null) goto L16;
        MmRecordingSource r6 = r4.a;
    L17:
        int r7 = MmRecordingAudioService.G;
        if (r3.b(r5, r6, false) == true) goto L20;
        lvb.a.b(this.this$0.b, "create audio dir failed, terminate session");
        Boxing.boxBoolean(this.this$0.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.DIR_CREATE_FAILED)));
        goto L27
    L20:
        this.this$0.c.A().A(r14.a, this.this$0.d.e());
        MmRecordingSessionManager r8 = this.this$0.c.A();
        String r9 = r14.a;
        r8.B(r9, r9);
        MmSoftwareCurrentRecordingStateHandler r10 = this.this$0;
        BuildersKt.launch$default(r10.a.u, null, null, new MmSoftwareCurrentRecordingStateHandler$createRecordingObject$1(r10, r14.a, null), 3, null);
        MmSoftwareCurrentRecordingStateHandler r15 = this.this$0;
        BuildersKt.launch$default(r15.a.u, null, null, new MmSoftwareCurrentRecordingStateHandler$listenToRecordingObjectReady$1(r15, null), 3, null);
        MmSoftwareCurrentRecordingStateHandler r16 = this.this$0;
        r16.getClass();
        MinutesForegroundService.Companion r11 = MinutesForegroundService.h;
        MinutesForegroundService.Companion.h(LarkContext.getApplication(), r16.c.A(), null, null, null, false, 76);
        MinutesRecordingStartResponse r17 = this.this$0.j;
        MmSoftwareCurrentRecordingStateHandler r12 = this.this$0;
        this.label = 2;
        r13 = MmSoftwareCurrentRecordingStateHandler.c(r12, r17, this);
        if (r13 != r0) goto L24;
        return r0;
    L16:
        r6 = null;
        goto L17
    L10:
        ResultKt.throwOnFailure(r13);
        MmRecordingSession r18 = this.this$0.a;
        this.label = 1;
        r13 = r18.r(this);
        if (r13 != r0) goto L13;
        return r0;
    }
}
