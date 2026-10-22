package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.d;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager$listenSessionStateChange$1", f = "MmRecordingSessionManager.kt", i = {}, l = {1628}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSessionManager$listenSessionStateChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmRecordingSession $session;
    int label;
    final /* synthetic */ MmRecordingSessionManager this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingSessionManager a;
        public final /* synthetic */ MmRecordingSession b;

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager$listenSessionStateChange$1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0020a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[RecordingSessionType.values().length];
                r0[RecordingSessionType.SOFTWARE_RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[RecordingSessionType.HISTORY_RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[RecordingSessionType.PRE_MEETING_NATIVE_RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[RecordingSessionType.STANDALONE_AI_INTERPRETATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[RecordingSessionType.HARDWARE_LIVE_RECORDING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        public a(MmRecordingSessionManager r1, MmRecordingSession r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r14, Continuation r15) {
            Pair r16 = (Pair) r14;
            lvb.a.e(this.a.b, "[sessionStateChange] sessionType: " + this.b.a + ",  recordId=" + this.b.e() + ' ' + r16.getFirst() + " -> " + r16.getSecond());
            int r0 = C0020a.a[this.b.a.ordinal()];
            boolean r1 = true;
            if (r0 != 1) goto L5;
            MmRecordingSessionManager.c(this.a, this.b, r16);
        L75:
            return Unit.INSTANCE;
        L5:
            if (r0 != 2) goto L7;
            MmRecordingSessionManager r17 = this.a;
            MmRecordingSession r2 = this.b;
            r17.getClass();
            com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r18 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c) r16.getSecond();
            if ((r18 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L68;
            BuildersKt.launch$default(r17.c, null, null, new MmRecordingSessionManager$processHistoryRecordingStateChange$1(r17, r2, r18, null), 3, null);
            goto L75
        L68:
            if ((r18 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n) == false) goto L71;
            BuildersKt.launch$default(r17.c, null, null, new MmRecordingSessionManager$processHistoryRecordingStateChange$2(r17, r2, r18, null), 3, null);
            r17.g();
            goto L75
        L71:
            if ((r18 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == false) goto L75;
            BuildersKt.launch$default(r17.c, null, null, new MmRecordingSessionManager$processHistoryRecordingStateChange$3(r17, r2, r18, null), 3, null);
            r17.r(r2);
            r17.g();
            goto L75
        L7:
            if (r0 != 3) goto L9;
            MmRecordingSessionManager r19 = this.a;
            MmRecordingSession r4 = this.b;
            r19.getClass();
            com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r3 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c) r16.getFirst();
            com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r5 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c) r16.getSecond();
            r19.z(r4, r3, r5);
            if (Intrinsics.areEqual(r5, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.g.c) == false) goto L32;
            ovb.b r110 = r4.w;
            if (r110.g.length() <= 0) goto L23;
            boolean r6 = true;
        L24:
            if (r6 == false) goto L75;
            if (r110.a.length() > 0) goto L29;
            r1 = false;
        L29:
            if (r1 == false) goto L75;
            r19.f.put(r110.g, r110.a);
            r19.g.put(r110.a, r110.g);
            lvb.a.e(r19.b, "[processPreMeetingNativeRecordingStateChange] mapped sessionKey=" + r110.g + " -> meetingId=" + r110.a);
            goto L75
        L23:
            r6 = false;
            goto L24
        L32:
            if ((r5 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == false) goto L47;
            ovb.b r111 = r4.w;
            r19.a.N().f(r4.e());
            BuildersKt.launch$default(r19.c, null, null, new MmRecordingSessionManager$processPreMeetingNativeRecordingStateChange$1(r19, r4, r3, null), 3, null);
            if (r111.g.length() <= 0) goto L36;
            boolean r7 = true;
        L37:
            if (r7 == false) goto L40;
            r19.f.remove(r111.g);
        L40:
            if (r111.a.length() > 0) goto L43;
            r1 = false;
        L43:
            if (r1 == false) goto L45;
            r19.g.remove(r111.a);
        L45:
            lvb.a.e(r19.b, "[processPreMeetingNativeRecordingStateChange] cleared mapping for sessionKey=" + r111.g);
            goto L75
        L36:
            r7 = false;
            goto L37
        L47:
            if ((r5 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.e) == false) goto L50;
            BuildersKt.launch$default(r19.c, null, null, new MmRecordingSessionManager$processPreMeetingNativeRecordingStateChange$2(r19, r4, r5, null), 3, null);
            goto L75
        L50:
            if ((r5 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.k) == false) goto L53;
            BuildersKt.launch$default(r19.c, null, null, new MmRecordingSessionManager$processPreMeetingNativeRecordingStateChange$3(r19, r4, r5, r3, null), 3, null);
            goto L75
        L53:
            if ((r5 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h) == false) goto L56;
            BuildersKt.launch$default(r19.c, null, null, new MmRecordingSessionManager$processPreMeetingNativeRecordingStateChange$4(r19, r4, r5, null), 3, null);
            goto L75
        L56:
            if ((r5 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L62;
            r19.p = "";
            Job r8 = r19.l.remove(r4.e());
            if (r8 == null) goto L60;
            Job.DefaultImpls.cancel$default(r8, null, 1, null);
        L60:
            r19.i(r19.d);
            r19.t.setValue(TuplesKt.to("", new d(0)));
            BuildersKt.launch$default(r19.c, null, null, new MmRecordingSessionManager$processPreMeetingNativeRecordingStateChange$5(r3, r19, r4, r5, null), 3, null);
            goto L75
        L62:
            if ((r5 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n) == false) goto L75;
            r19.g();
            goto L75
        L9:
            if (r0 != 4) goto L11;
            MmRecordingSessionManager.c(this.a, this.b, r16);
            goto L75
        L11:
            if (r0 != 5) goto L75;
            Object r112 = MmRecordingSessionManager.b(this.a, this.b, r16, r15);
            if (r112 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L76;
            return r112;
        L76:
            return Unit.INSTANCE;
        }
    }

    public MmRecordingSessionManager$listenSessionStateChange$1(MmRecordingSession r1, MmRecordingSessionManager r2, Continuation<? super MmRecordingSessionManager$listenSessionStateChange$1> r3) {
        this.$session = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingSessionManager$listenSessionStateChange$1(this.$session, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        MmRecordingSession r7 = this.$session;
        b1 r2 = r7.t;
        a r3 = new a(this.this$0, r7);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
