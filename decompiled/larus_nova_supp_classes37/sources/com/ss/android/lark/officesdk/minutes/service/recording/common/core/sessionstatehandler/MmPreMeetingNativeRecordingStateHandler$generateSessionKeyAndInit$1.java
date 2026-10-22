package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.MmRecordingSubtitleAppreciable;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingMetaRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.k;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$generateSessionKeyAndInit$1", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {0}, l = {408}, m = "invokeSuspend", n = {"meetingStartTime"}, s = {"J$0"})
final class MmPreMeetingNativeRecordingStateHandler$generateSessionKeyAndInit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    int label;
    final /* synthetic */ MmPreMeetingNativeRecordingStateHandler this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$generateSessionKeyAndInit$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingData;", "it"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$generateSessionKeyAndInit$1$1", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ovb.b, Continuation<? super ovb.b>, Object> {
        final /* synthetic */ k $createContext;
        final /* synthetic */ boolean $isHardwareRecording;
        final /* synthetic */ long $meetingStartTime;
        final /* synthetic */ String $sessionKey;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmPreMeetingNativeRecordingStateHandler this$0;

        public AnonymousClass1(String r1, boolean r2, k r3, MmPreMeetingNativeRecordingStateHandler r4, long r5, Continuation<? super AnonymousClass1> r7) {
            this.$sessionKey = r1;
            this.$isHardwareRecording = r2;
            this.$createContext = r3;
            this.this$0 = r4;
            this.$meetingStartTime = r5;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r8 = new AnonymousClass1(this.$sessionKey, this.$isHardwareRecording, this.$createContext, this.this$0, this.$meetingStartTime, r11);
            r8.L$0 = r10;
            return r8;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ovb.b) r1, (Continuation) r2);
        }

        public final Object invoke(ovb.b r1, Continuation<? super ovb.b> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L29;
            ResultKt.throwOnFailure(r15);
            ovb.b r0 = (ovb.b) this.L$0;
            String r3 = this.$sessionKey;
            boolean r4 = this.$isHardwareRecording;
            k r1 = this.$createContext;
            if (r1 == null) goto L12;
            MmRecordingSource r2 = r1.a;
            if (r2 == null) goto L12;
            String r5 = r2.name();
            if (r5 == null) goto L12;
            String r6 = r5;
        L13:
            MmPreMeetingNativeRecordingStateHandler r7 = this.this$0;
            if (r7.u == false) goto L16;
            String r8 = this.$sessionKey;
        L17:
            String r9 = r7.d.getCurrentUserId();
            MmPreMeetingNativeRecordingStateHandler r10 = this.this$0;
            MmRecordingSession r11 = r10.a;
            String r12 = r11.c;
            k r13 = r11.f;
            String r14 = null;
            if (r13 == null) goto L20;
            MmRecordingSource r16 = r13.a;
        L21:
            String r17 = r10.d.getTenantId();
            DoubaoBizInfo r18 = this.this$0.s;
            if (r18 == null) goto L24;
            r14 = r18.getRecordingId();
        L24:
            if (r14 != null) goto L27;
            r14 = "";
        L27:
            return ovb.b.a(r0, null, this.$meetingStartTime, null, null, new MmRecordingCommonParam("", r3, r4, r6, r8, r9, r12, r16, r17, r14, this.this$0.a.a.name()), this.$sessionKey, false, 157);
        L20:
            r16 = null;
            goto L21
        L16:
            r8 = "";
        L12:
            r6 = "";
            goto L13
        L29:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MmPreMeetingNativeRecordingStateHandler$generateSessionKeyAndInit$1(MmPreMeetingNativeRecordingStateHandler r1, Continuation<? super MmPreMeetingNativeRecordingStateHandler$generateSessionKeyAndInit$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmPreMeetingNativeRecordingStateHandler$generateSessionKeyAndInit$1(this.this$0, r3);
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
        MmRecordingSource r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r2 = this.J$0;
        ResultKt.throwOnFailure(r15);
    L30:
        MmPreMeetingNativeRecordingStateHandler r16 = this.this$0;
        if (r16.u == false) goto L36;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r17 = r16.d.N();
        MmRecordingSession r4 = this.this$0.a;
        int r5 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.n;
        r17.k(r4, r4.w.f);
        MmRecordingSubtitleAppreciable r18 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.d;
        MmPreMeetingNativeRecordingStateHandler r6 = this.this$0;
        MmRecordingSession r7 = r6.a;
        String r8 = r7.c;
        k r9 = r7.f;
        if (r9 == null) goto L35;
        r3 = r9.a;
    L35:
        r18.c(r8, r3, r6.s);
    L36:
        MmRecordingRepo r19 = this.this$0.a.f();
        if (r19 == null) goto L43;
        MmRecordingMetaRepo r110 = r19.w();
        if (r110 == null) goto L43;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.a r111 = r110.l();
        if (r111 == null) goto L43;
        r111.Q0(r2);
    L43:
        this.this$0.a.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.C0036a.a);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        k r10 = this.this$0.a.f;
        if (r10 == null) goto L19;
        Map<String, Object> r112 = r10.b;
        if (r112 == null) goto L19;
        Object r113 = r112.get("hardware_local_recording_id");
        if (r113 == null) goto L19;
        String r114 = r113.toString();
        if (r114 == null) goto L19;
        if ((!StringsKt.isBlank(r114)) == false) goto L19;
    L20:
        if (r114 != null) goto L22;
        String r11 = "native_local_" + UUID.randomUUID();
    L23:
        if (r114 == null) goto L25;
        boolean r12 = true;
    L26:
        long r13 = System.currentTimeMillis();
        lvb.a.e(this.this$0.c, "[generateSessionKeyAndInit] sessionKey=" + r11 + ", meetingStartTime=" + r13);
        MmPreMeetingNativeRecordingStateHandler r115 = this.this$0;
        r115.g.B(r11, r115.a.c);
        MmPreMeetingNativeRecordingStateHandler r14 = this.this$0;
        MmRecordingSession r116 = r14.a;
        AnonymousClass1 r20 = new AnonymousClass1(r11, r12, r10, r14, r13, null);
        this.J$0 = r13;
        this.label = 1;
        if (r116.s(r20, this) != r0) goto L29;
        return r0;
    L29:
        r2 = r13;
        goto L30
    L25:
        r12 = false;
        goto L26
    L22:
        r11 = r114;
    L19:
        r114 = null;
        goto L20
    }
}
