package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.MinutesForegroundService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import iub.j;
import iub.k;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmStandaloneAIInterpretationStateHandler$onStateChanged$1", f = "MmStandaloneAIInterpretationStateHandler.kt", i = {2}, l = {83, 85, 118, 126}, m = "invokeSuspend", n = {"recordingData"}, s = {"L$0"})
public final class MmStandaloneAIInterpretationStateHandler$onStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationStateHandler this$0;

    public MmStandaloneAIInterpretationStateHandler$onStateChanged$1(MmStandaloneAIInterpretationStateHandler r1, Continuation<? super MmStandaloneAIInterpretationStateHandler$onStateChanged$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmStandaloneAIInterpretationStateHandler$onStateChanged$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L10;
        ResultKt.throwOnFailure(r15);
    L52:
        this.this$0.a.n(MmRecordingError.InternalError.INSTANCE);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ovb.b r2 = (ovb.b) this.L$0;
        ResultKt.throwOnFailure(r15);
    L48:
        if (((Boolean) r15).booleanValue() == true) goto L54;
        lvb.a.b(this.this$0.b, "[onStateChanged] start independent SI failed, terminate created session, meetingId=" + r2.a);
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.f(2131893499);
        MmStandaloneAIInterpretationStateHandler r16 = this.this$0;
        TerminateReason r3 = TerminateReason.OTHERS;
        this.L$0 = null;
        this.label = 4;
        if (r16.f(r3, true, this) != r0) goto L52;
        return r0;
    L54:
        MmRecordingSession r17 = this.this$0.a;
        r17.o(new j(r17.e()));
        MmStandaloneAIInterpretationStateHandler r18 = this.this$0;
        String r4 = r2.a;
        String r5 = r2.c;
        MmStandaloneAIInterpretationStateHandler.a r6 = MmStandaloneAIInterpretationStateHandler.l;
        BuildersKt.launch$default(r18.a.u, null, null, new MmStandaloneAIInterpretationStateHandler$createSimultaneousRecording$1(r18, r4, r5, null), 3, null);
        MmStandaloneAIInterpretationStateHandler r19 = this.this$0;
        BuildersKt.launch$default(r19.a.u, null, null, new MmStandaloneAIInterpretationStateHandler$listenToRecordingIdReady$1(r19, null), 3, null);
        this.this$0.a.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.j.a);
        return Unit.INSTANCE;
    L12:
        ResultKt.throwOnFailure(r15);
    L26:
        this.this$0.a.n(MmRecordingError.InternalError.INSTANCE);
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r15);
    L17:
        r2 = (ovb.b) r15;
        MmStandaloneAIInterpretationStateHandler r110 = this.this$0;
        MmRecordingAudioService r7 = r110.d;
        String r8 = r2.a;
        k r111 = r110.a.f;
        if (r111 == null) goto L20;
        MmRecordingSource r112 = r111.a;
    L21:
        int r9 = MmRecordingAudioService.G;
        if (r7.b(r8, r112, false) == true) goto L28;
        MmStandaloneAIInterpretationStateHandler r113 = this.this$0;
        TerminateReason r10 = TerminateReason.DIR_CREATE_FAILED;
        this.label = 2;
        if (r113.f(r10, false, this) != r0) goto L26;
        return r0;
    L28:
        String r114 = r2.c;
        if (StringsKt.isBlank(r114) == false) goto L31;
        r114 = r2.a;
    L31:
        this.this$0.c.A().A(r114, this.this$0.d.e());
        MmRecordingSessionManager r115 = this.this$0.c.A();
        String r11 = r2.a;
        r115.B(r11, r11);
        MmStandaloneAIInterpretationStateHandler r116 = this.this$0;
        k r12 = r116.a.f;
        if (r12 == null) goto L36;
        MmRecordingSource r13 = r12.a;
        if (r13 == null) goto L36;
        r116.e.A(r2.a, r13);
        r116.e.A(r2.c, r13);
    L36:
        MmStandaloneAIInterpretationStateHandler r117 = this.this$0;
        k r14 = r117.a.f;
        if (r14 == null) goto L39;
        MmRecordingSource r20 = r14.a;
    L41:
        if (r20 != MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION) goto L43;
        int r21 = 2131890206;
    L44:
        String r118 = UIHelper.getString(r21);
        MinutesForegroundService.ForegroundServiceType r22 = MinutesForegroundService.ForegroundServiceType.RECORDING;
        Intrinsics.checkNotNullParameter(r118, "title");
        Intrinsics.checkNotNullParameter("", "content");
        Intrinsics.checkNotNullParameter(r22, "foregroundServiceType");
        MinutesForegroundService.Companion r23 = MinutesForegroundService.h;
        MinutesForegroundService.Companion.h(LarkContext.getApplication(), r117.c.A(), r22, r118, "", true, 72);
        MmStandaloneAIInterpretationStateHandler r119 = this.this$0;
        String r24 = r2.a;
        this.L$0 = r2;
        this.label = 3;
        r15 = MmStandaloneAIInterpretationStateHandler.d(r119, r24, this);
        if (r15 != r0) goto L48;
        return r0;
    L43:
        r21 = 2131892839;
        goto L44
    L39:
        r20 = null;
        goto L41
    L20:
        r112 = null;
        goto L21
    L14:
        ResultKt.throwOnFailure(r15);
        MmRecordingSession r120 = this.this$0.a;
        this.label = 1;
        r15 = r120.r(this);
        if (r15 != r0) goto L17;
        return r0;
    }
}
