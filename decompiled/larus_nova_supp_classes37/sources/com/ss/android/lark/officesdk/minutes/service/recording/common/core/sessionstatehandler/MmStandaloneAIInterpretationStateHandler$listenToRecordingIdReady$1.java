package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
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
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmStandaloneAIInterpretationStateHandler$listenToRecordingIdReady$1", f = "MmStandaloneAIInterpretationStateHandler.kt", i = {1, 2, 2, 3, 4}, l = {482, 489, 493, 501, 507}, m = "invokeSuspend", n = {"recordingId", "recordingId", "previousSessionId", "recordingId", "recordingId"}, s = {"L$0", "L$0", "L$1", "L$0", "L$0"})
final class MmStandaloneAIInterpretationStateHandler$listenToRecordingIdReady$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationStateHandler this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmStandaloneAIInterpretationStateHandler$listenToRecordingIdReady$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingData;", "it"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmStandaloneAIInterpretationStateHandler$listenToRecordingIdReady$1$1", f = "MmStandaloneAIInterpretationStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ovb.b, Continuation<? super ovb.b>, Object> {
        final /* synthetic */ String $recordingId;
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(String r1, Continuation<? super AnonymousClass1> r2) {
            this.$recordingId = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$recordingId, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ovb.b) r1, (Continuation) r2);
        }

        public final Object invoke(ovb.b r1, Continuation<? super ovb.b> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r11);
            ovb.b r0 = (ovb.b) this.L$0;
            String r4 = this.$recordingId;
            return ovb.b.a(r0, null, 0, r4, null, MmRecordingCommonParam.withRecordingIdReady$default(r0.f, r4, null, 2, null), null, false, 219);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MmStandaloneAIInterpretationStateHandler$listenToRecordingIdReady$1(MmStandaloneAIInterpretationStateHandler r1, Continuation<? super MmStandaloneAIInterpretationStateHandler$listenToRecordingIdReady$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmStandaloneAIInterpretationStateHandler$listenToRecordingIdReady$1(this.this$0, r3);
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
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L13;
        if (r1 == 4) goto L12;
        if (r1 != 5) goto L11;
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);
    L47:
        MmStandaloneAIInterpretationStateHandler r16 = this.this$0;
        Job r3 = r16.i;
        if (r3 == null) goto L50;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L50:
        r16.i = BuildersKt.launch$default(r16.a.u, null, null, new MmStandaloneAIInterpretationStateHandler$startUpload$1(r16, r2, null), 3, null);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        MmRecordingStatesSyncService r4 = (MmRecordingStatesSyncService) this.L$1;
        String r5 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);
    L38:
        r4.D(((ovb.b) r15).a, r5);
        MmStandaloneAIInterpretationStateHandler r17 = this.this$0;
        k r6 = r17.a.f;
        if (r6 == null) goto L43;
        MmRecordingSource r7 = r6.a;
        if (r7 == null) goto L43;
        r17.e.A(r5, r7);
    L43:
        MmStandaloneAIInterpretationStateHandler r18 = this.this$0;
        this.L$0 = r5;
        this.L$1 = null;
        this.label = 5;
        if (MmStandaloneAIInterpretationStateHandler.e(r18, this) != r0) goto L46;
        return r0;
    L46:
        r2 = r5;
        goto L47
    L13:
        String r8 = (String) this.L$1;
        String r9 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);
    L34:
        MmStandaloneAIInterpretationStateHandler r19 = this.this$0;
        MmStandaloneAIInterpretationStateHandler.a r10 = MmStandaloneAIInterpretationStateHandler.l;
        r19.j(r8);
        MmStandaloneAIInterpretationStateHandler r110 = this.this$0;
        r4 = r110.e;
        MmRecordingSession r111 = r110.a;
        this.L$0 = r9;
        this.L$1 = r4;
        this.label = 4;
        r15 = r111.r(this);
        if (r15 != r0) goto L37;
        return r0;
    L37:
        r5 = r9;
        goto L38
    L14:
        StringBuilder r11 = (StringBuilder) this.L$2;
        String r12 = (String) this.L$1;
        String r13 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);
    L30:
        r11.append(lvb.a.d(((ovb.b) r15).a));
        r11.append(", recordingId=");
        r11.append(r13);
        lvb.a.e(r12, r11.toString());
        r8 = this.this$0.a.e();
        MmRecordingSession r112 = this.this$0.a;
        AnonymousClass1 r14 = new AnonymousClass1(r13, null);
        this.L$0 = r13;
        this.L$1 = r8;
        this.L$2 = null;
        this.label = 3;
        if (r112.s(r14, this) != r0) goto L33;
        return r0;
    L33:
        r9 = r13;
        goto L34
    L15:
        ResultKt.throwOnFailure(r15);
    L19:
        String r113 = (String) r15;
        if (r113.length() != 0) goto L22;
        boolean r20 = true;
    L23:
        if (r20 == false) goto L26;
        lvb.a.h(this.this$0.b, "[startUpload] failed, recordingId is empty");
        return Unit.INSTANCE;
    L26:
        String r21 = this.this$0.b;
        StringBuilder r22 = new StringBuilder();
        r22.append("[listenToRecordingIdReady] ready, meetingId=");
        MmRecordingSession r23 = this.this$0.a;
        this.L$0 = r113;
        this.L$1 = r21;
        this.L$2 = r22;
        this.label = 2;
        Object r24 = r23.r(this);
        if (r24 != r0) goto L29;
        return r0;
    L29:
        r13 = r113;
        r15 = r24;
        r12 = r21;
        r11 = r22;
        goto L30
    L22:
        r20 = false;
        goto L23
    L16:
        ResultKt.throwOnFailure(r15);
        MmStandaloneAIInterpretationStateHandler.a r114 = MmStandaloneAIInterpretationStateHandler.l;
        b1 r25 = this.this$0.e.p;
        this.label = 1;
        r15 = r114.a(r25, this);
        if (r15 != r0) goto L19;
        return r0;
    }
}
