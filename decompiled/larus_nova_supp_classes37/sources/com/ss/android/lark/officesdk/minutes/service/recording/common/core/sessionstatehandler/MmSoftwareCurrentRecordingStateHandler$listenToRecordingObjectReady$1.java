package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$listenToRecordingObjectReady$1", f = "MmSoftwareCurrentRecordingStateHandler.kt", i = {1, 2, 4, 5}, l = {511, 527, 533, 538, 543, 552}, m = "invokeSuspend", n = {"recordingId", "recordingId", "minutesToken", "minutesToken"}, s = {"L$0", "L$0", "L$0", "L$0"})
final class MmSoftwareCurrentRecordingStateHandler$listenToRecordingObjectReady$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MmSoftwareCurrentRecordingStateHandler this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$listenToRecordingObjectReady$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingData;", "it"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$listenToRecordingObjectReady$1$1", f = "MmSoftwareCurrentRecordingStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$listenToRecordingObjectReady$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingData;", "it"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$listenToRecordingObjectReady$1$2", f = "MmSoftwareCurrentRecordingStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<ovb.b, Continuation<? super ovb.b>, Object> {
        final /* synthetic */ String $minutesToken;
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(String r1, Continuation<? super AnonymousClass2> r2) {
            this.$minutesToken = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$minutesToken, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ovb.b) r1, (Continuation) r2);
        }

        public final Object invoke(ovb.b r1, Continuation<? super ovb.b> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r23) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r23);
            ovb.b r2 = (ovb.b) this.L$0;
            String r7 = this.$minutesToken;
            return ovb.b.a(r2, null, 0, null, r7, MmRecordingCommonParam.copy$default(r2.f, y.b(r7), null, false, null, null, null, null, null, null, null, null, 2046, null), null, false, 215);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MmSoftwareCurrentRecordingStateHandler$listenToRecordingObjectReady$1(MmSoftwareCurrentRecordingStateHandler r1, Continuation<? super MmSoftwareCurrentRecordingStateHandler$listenToRecordingObjectReady$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmSoftwareCurrentRecordingStateHandler$listenToRecordingObjectReady$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r2 = false;
        switch(this.label) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        String r1 = (String) this.L$0;
        ResultKt.throwOnFailure(r8);
    L58:
        MmSoftwareCurrentRecordingStateHandler.d(this.this$0, r1);
        return Unit.INSTANCE;
    L7:
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r8);
        String r9 = r3;
    L54:
        MmSoftwareCurrentRecordingStateHandler r4 = this.this$0;
        this.L$0 = r9;
        this.label = 6;
        if (MmSoftwareCurrentRecordingStateHandler.e(r4, this) != r0) goto L57;
        return r0;
    L57:
        r1 = r9;
        goto L58
    L8:
        ResultKt.throwOnFailure(r8);
    L39:
        MmCreateAudioResponse r10 = (MmCreateAudioResponse) r8;
        if (r10 == null) goto L44;
        r9 = r10.getObjectToken();
        if (r9 == null) goto L44;
    L46:
        if (r9.length() != 0) goto L48;
        r2 = true;
    L48:
        if (r2 == false) goto L51;
        lvb.a.h(this.this$0.b, "[startUpload] failed, minutesToken is empty");
        return Unit.INSTANCE;
    L51:
        MmRecordingSession r5 = this.this$0.a;
        AnonymousClass2 r6 = new AnonymousClass2(r9, null);
        this.L$0 = r9;
        this.label = 5;
        if (r5.s(r6, this) != r0) goto L54;
        return r0;
    L44:
        r9 = "";
        goto L46
    L9:
        String r7 = (String) this.L$0;
        ResultKt.throwOnFailure(r8);
    L34:
        MmSoftwareCurrentRecordingStateHandler.d(this.this$0, r7);
        return Unit.INSTANCE;
    L10:
        String r11 = (String) this.L$0;
        ResultKt.throwOnFailure(r8);
        String r12 = r11;
    L30:
        MmSoftwareCurrentRecordingStateHandler r13 = this.this$0;
        this.L$0 = r12;
        this.label = 3;
        if (MmSoftwareCurrentRecordingStateHandler.e(r13, this) != r0) goto L33;
        return r0;
    L33:
        r7 = r12;
        goto L34
    L11:
        ResultKt.throwOnFailure(r8);
    L17:
        r12 = (String) r8;
        if (r12 != null) goto L22;
        return Unit.INSTANCE;
    L22:
        if (r12.length() != 0) goto L24;
        r2 = true;
    L24:
        if (r2 == false) goto L27;
        lvb.a.h(this.this$0.b, "[startUpload] failed, recordingId is empty");
        this.this$0.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.MINUTES_TOKEN_EMPTY));
        return Unit.INSTANCE;
    L27:
        MmRecordingSession r14 = this.this$0.a;
        AnonymousClass1 r15 = new AnonymousClass1(r12, null);
        this.L$0 = r12;
        this.label = 2;
        if (r14.s(r15, this) != r0) goto L30;
        return r0;
    L12:
        ResultKt.throwOnFailure(r8);
        if (this.this$0.a.v() == false) goto L36;
        MmSoftwareCurrentRecordingStateHandler.Companion r16 = MmSoftwareCurrentRecordingStateHandler.o;
        MmSoftwareCurrentRecordingStateHandler$listenToRecordingObjectReady$1$recordingId$1 r17 = new MmSoftwareCurrentRecordingStateHandler$listenToRecordingObjectReady$1$recordingId$1(this.this$0.f);
        final MmSoftwareCurrentRecordingStateHandler r18 = this.this$0;
        Function1<Throwable, Unit> r19 = new MmSoftwareCurrentRecordingStateHandler$listenToRecordingObjectReady$1$recordingId$2(r18);
        this.label = 1;
        r8 = r16.a(r17, r19, this);
        if (r8 != r0) goto L17;
        return r0;
    L36:
        final b1 r20 = this.this$0.f.o;
        Flow<MmCreateAudioResponse> r21 = new MmSoftwareCurrentRecordingStateHandler$listenToRecordingObjectReady$1$invokeSuspend$$inlined$map$1(r20);
        MmSoftwareCurrentRecordingStateHandler$listenToRecordingObjectReady$1$minutesToken$2 r22 = new MmSoftwareCurrentRecordingStateHandler$listenToRecordingObjectReady$1$minutesToken$2(null);
        this.label = 4;
        r8 = kotlinx.coroutines.flow.e.t(r21, r22, this);
        if (r8 != r0) goto L39;
        return r0;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
