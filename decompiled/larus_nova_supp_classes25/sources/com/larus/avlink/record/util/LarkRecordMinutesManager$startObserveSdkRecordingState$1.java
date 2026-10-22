package com.larus.avlink.record.util;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.avlink.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.im.bean.message.block.AudioRecordStatus;
import com.larus.minutes.api.IMinutesService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.util.LarkRecordMinutesManager$startObserveSdkRecordingState$1", f = "LarkRecordMinutesManager.kt", i = {}, l = {508}, m = "invokeSuspend", n = {}, s = {})
final class LarkRecordMinutesManager$startObserveSdkRecordingState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: renamed from: com.larus.avlink.record.util.LarkRecordMinutesManager$startObserveSdkRecordingState$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "durationData", "Lkotlin/Pair;", "", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.record.util.LarkRecordMinutesManager$startObserveSdkRecordingState$1$1", f = "LarkRecordMinutesManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Pair<? extends String, ? extends Long>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass1 r0 = new AnonymousClass1(r3);
            r0.L$0 = r2;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((Pair) r1, (Continuation) r2);
        }

        public final Object invoke(Pair<String, Long> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r4);
            Pair r5 = (Pair) this.L$0;
            if (r5 == null) goto L7;
            int r6 = (int) ((Number) r5.getSecond()).longValue();
        L8:
            Iterator<T> r0 = LarkRecordMinutesManager.r.iterator();
        L10:
            if (r0.hasNext() == false) goto L13;
            ((Function1) r0.next()).invoke(Boxing.boxInt(r6));
            goto L10
        L13:
            return Unit.INSTANCE;
        L7:
            r6 = 0;
            goto L8
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.record.util.LarkRecordMinutesManager$startObserveSdkRecordingState$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "status", "Lkotlin/Triple;", "", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.record.util.LarkRecordMinutesManager$startObserveSdkRecordingState$1$2", f = "LarkRecordMinutesManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Triple<? extends String, ? extends Integer, ? extends Integer>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass2 r0 = new AnonymousClass2(r3);
            r0.L$0 = r2;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((Triple) r1, (Continuation) r2);
        }

        public final Object invoke(Triple<String, Integer, Integer> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L54;
            ResultKt.throwOnFailure(r9);
            Triple r10 = (Triple) this.L$0;
            n1.d("LarkRecordMinutesManager", "GRecord sdk recording status changed, status=" + r10 + ", currentRecordingId=" + LarkRecordMinutesManager.A);
            if (r10 == null) goto L7;
            String r0 = (String) r10.getFirst();
        L8:
            boolean r2 = true;
            if (r0 != null) goto L11;
        L14:
            boolean r4 = true;
        L15:
            if (r4 == true) goto L17;
            int r11 = ((Number) r10.getSecond()).intValue();
            if (r11 != AudioRecordStatus.STATUS_RECORDING.getValue()) goto L25;
            Iterator<Function1<Boolean, Unit>> r12 = LarkRecordMinutesManager.s.iterator();
        L22:
            if (r12.hasNext() == false) goto L52;
            r12.next().invoke(Boxing.boxBoolean(true));
        L52:
            return Unit.INSTANCE;
        L25:
            if (r11 != AudioRecordStatus.STATUS_IDLE.getValue()) goto L27;
        L32:
            LarkRecordMinutesManager r13 = LarkRecordMinutesManager.a;
            String r5 = LarkRecordMinutesManager.A;
            if (r5 != null) goto L35;
            r13.getClass();
        L40:
            r2 = false;
        L41:
            if (r2 == false) goto L52;
            r13.getClass();
            LarkRecordMinutesManager.f("lark_inner_stop");
            IDoraService r14 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r14 == null) goto L47;
            SessionService r15 = r14.d();
            if (r15 == null) goto L47;
            Boxing.boxInt(r15.b(3, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_GUI, false));
        L47:
            Iterator<Function1<Boolean, Unit>> r16 = LarkRecordMinutesManager.s.iterator();
        L49:
            if (r16.hasNext() == false) goto L52;
            r16.next().invoke(Boxing.boxBoolean(false));
            goto L49
        L35:
            r13.getClass();
            String r6 = LarkRecordMinutesManager.j();
            n1.d("LarkRecordMinutesManager", "isCurrentRecording: streamId = " + r0 + ", recordingId = " + r5 + ", meetingId = " + r6);
            if (Intrinsics.areEqual(r5, r0) == true) goto L41;
            if (Intrinsics.areEqual(r6, r0) == false) goto L40;
        L27:
            if (r11 == AudioRecordStatus.STATUS_GENERATING_SUMMARY.getValue()) goto L32;
            if (r11 == AudioRecordStatus.STATUS_COMPLETED.getValue()) goto L32;
            if (r11 != AudioRecordStatus.STATUS_RECORD_FAILED.getValue()) goto L52;
        L17:
            return Unit.INSTANCE;
        L11:
            if (r0.length() == 0) goto L14;
            r4 = false;
            goto L15
        L7:
            r0 = null;
            goto L8
        L54:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public LarkRecordMinutesManager$startObserveSdkRecordingState$1(Continuation<? super LarkRecordMinutesManager$startObserveSdkRecordingState$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new LarkRecordMinutesManager$startObserveSdkRecordingState$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Job r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L25:
        i1 r8 = (i1) r7;
        if (r8 == null) goto L28;
        r3 = kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r8, new AnonymousClass2(null)), LarkRecordMinutesManager.c);
    L28:
        LarkRecordMinutesManager.x = r3;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        IMinutesService r9 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r9 != null) goto L12;
        n1.e("LarkRecordMinutesManager", "GRecord observe recording state but minutes service is null");
        return Unit.INSTANCE;
    L12:
        Job r2 = LarkRecordMinutesManager.w;
        if (r2 == null) goto L15;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L15:
        b1 r4 = r9.l();
        if (r4 == null) goto L18;
        Job r5 = kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r4, new AnonymousClass1(null)), LarkRecordMinutesManager.c);
    L19:
        LarkRecordMinutesManager.w = r5;
        Job r6 = LarkRecordMinutesManager.x;
        if (r6 == null) goto L22;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L22:
        this.label = 1;
        r7 = r9.E0();
        if (r7 != r0) goto L25;
        return r0;
    L18:
        r5 = null;
        goto L19
    }
}
