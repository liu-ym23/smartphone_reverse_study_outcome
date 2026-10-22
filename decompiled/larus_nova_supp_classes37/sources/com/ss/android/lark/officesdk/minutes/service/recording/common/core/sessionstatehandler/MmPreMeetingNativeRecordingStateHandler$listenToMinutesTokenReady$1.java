package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
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
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {1, 3}, l = {1090, 1091, 1107, 1108}, m = "invokeSuspend", n = {"recordingId", "minutesToken"}, s = {"L$0", "L$0"})
final class MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MmPreMeetingNativeRecordingStateHandler this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingData;", "it"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$1", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingData;", "it"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$2", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

    public MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1(MmPreMeetingNativeRecordingStateHandler r1, Continuation<? super MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L10;
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r8);
    L32:
        MmPreMeetingNativeRecordingStateHandler r9 = this.this$0;
        if (r9.p == false) goto L36;
        r9.p = false;
        ovb.b r3 = r9.a.w;
        String r4 = r3.a;
        r9.d.A().C(r3.g, r4, r2);
        lvb.a.e(r9.c, "[retryCreateRecording] emit minutesToken ready after retry online, sessionKey=" + r3.g + ", meetingId=" + r4);
    L36:
        MmPreMeetingNativeRecordingStateHandler.h(this.this$0, r2);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r8);
    L28:
        String r10 = (String) r8;
        MmRecordingSession r5 = this.this$0.a;
        AnonymousClass2 r6 = new AnonymousClass2(r10, null);
        this.L$0 = r10;
        this.label = 4;
        if (r5.s(r6, this) != r0) goto L31;
        return r0;
    L31:
        r2 = r10;
        goto L32
    L12:
        String r7 = (String) this.L$0;
        ResultKt.throwOnFailure(r8);
    L23:
        MmPreMeetingNativeRecordingStateHandler.h(this.this$0, r7);
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r8);
    L19:
        String r11 = (String) r8;
        MmRecordingSession r12 = this.this$0.a;
        AnonymousClass1 r13 = new AnonymousClass1(r11, null);
        this.L$0 = r11;
        this.label = 2;
        if (r12.s(r13, this) != r0) goto L22;
        return r0;
    L22:
        r7 = r11;
        goto L23
    L14:
        ResultKt.throwOnFailure(r8);
        if (this.this$0.a.v() == false) goto L25;
        MmPreMeetingNativeRecordingStateHandler r14 = this.this$0;
        final FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r15 = new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r14.g.p, new MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$recordingId$1(r14, null));
        Flow<String> r16 = new MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$invokeSuspend$$inlined$map$1(r15);
        MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$recordingId$3 r17 = new MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$recordingId$3(null);
        this.label = 1;
        r8 = kotlinx.coroutines.flow.e.t(r16, r17, this);
        if (r8 != r0) goto L19;
        return r0;
    L25:
        MmPreMeetingNativeRecordingStateHandler r18 = this.this$0;
        final FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r19 = new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r18.g.o, new MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$minutesToken$1(r18, null));
        Flow<String> r20 = new MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$invokeSuspend$$inlined$map$2(r19);
        MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$minutesToken$3 r21 = new MmPreMeetingNativeRecordingStateHandler$listenToMinutesTokenReady$1$minutesToken$3(null);
        this.label = 3;
        r8 = kotlinx.coroutines.flow.e.t(r20, r21, this);
        if (r8 != r0) goto L28;
        return r0;
    }
}
