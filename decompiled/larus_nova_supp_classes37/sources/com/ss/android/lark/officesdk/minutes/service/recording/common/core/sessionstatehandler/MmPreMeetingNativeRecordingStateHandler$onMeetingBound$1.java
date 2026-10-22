package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$onMeetingBound$1", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {0, 0}, l = {870}, m = "invokeSuspend", n = {"recordingData", "meetingId"}, s = {"L$0", "L$1"})
final class MmPreMeetingNativeRecordingStateHandler$onMeetingBound$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MmPreMeetingNativeRecordingStateHandler this$0;

    public MmPreMeetingNativeRecordingStateHandler$onMeetingBound$1(MmPreMeetingNativeRecordingStateHandler r1, Continuation<? super MmPreMeetingNativeRecordingStateHandler$onMeetingBound$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmPreMeetingNativeRecordingStateHandler$onMeetingBound$1(this.this$0, r3);
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
        String r2 = (String) this.L$1;
        ovb.b r3 = (ovb.b) this.L$0;
        ResultKt.throwOnFailure(r9);
    L25:
        if (((Boolean) r9).booleanValue() == true) goto L27;
        lvb.a.b(this.this$0.c, "[onMeetingBound] switch part dir failed, sessionKey=" + r3.g + ", meetingId=" + r2);
    L28:
        MmRecordingRepo r10 = this.this$0.a.f();
        if (r10 == null) goto L31;
        r10.A(r2, r3.b, "onMeetingBound");
    L31:
        this.this$0.d.A().B(r3.g, r2);
        MmPreMeetingNativeRecordingStateHandler r11 = this.this$0;
        BuildersKt.launch$default(r11.a.u, null, null, new MmPreMeetingNativeRecordingStateHandler$createMinutesToken$1(r11, r2, null), 3, null);
        MmPreMeetingNativeRecordingStateHandler r12 = this.this$0;
        BuildersKt.launch$default(r12.a.u, null, null, new MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1(r12, null), 3, null);
        this.this$0.a.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.j.a);
        return Unit.INSTANCE;
    L27:
        MmPreMeetingNativeRecordingStateHandler r13 = this.this$0;
        r13.o = true;
        lvb.a.e(r13.c, "[onMeetingBound] switch part dir success, sessionKey=" + r3.g + ", meetingId=" + r2);
        goto L28
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        MmPreMeetingNativeRecordingStateHandler r14 = this.this$0;
        r3 = r14.a.w;
        String r4 = r3.a;
        MmRecordingAudioService r15 = r14.k("onMeetingBound");
        if (r15 == null) goto L11;
        this.this$0.g.C(r4, r3.g);
        this.this$0.g.z(r3.g, r4);
        MmPreMeetingNativeRecordingStateHandler r5 = this.this$0;
        k r6 = r5.a.f;
        if (r6 == null) goto L17;
        MmRecordingSource r7 = r6.a;
        if (r7 == null) goto L17;
        r5.g.A(r4, r7);
        r5.g.A(r3.g, r7);
    L17:
        MmPreMeetingNativeRecordingStateHandler r8 = this.this$0;
        if (r8.r == false) goto L20;
        r8.r = false;
        r8.g.x(r3.g);
        lvb.a.e(this.this$0.c, "[offlineMode] clear_offline_index after_bound, sessionKey=" + r3.g);
    L20:
        MmPreMeetingNativeRecordingStateHandler r16 = this.this$0;
        r16.g.B(r4, r16.a.c);
        String r17 = r3.g;
        this.L$0 = r3;
        this.L$1 = r4;
        this.label = 1;
        r9 = r15.n(r17, r4, this);
        if (r9 != r0) goto L23;
        return r0;
    L23:
        r2 = r4;
        goto L25
    L11:
        return Unit.INSTANCE;
    }
}
