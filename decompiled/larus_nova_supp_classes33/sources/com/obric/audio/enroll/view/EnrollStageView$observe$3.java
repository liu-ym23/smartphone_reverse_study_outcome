package com.obric.audio.enroll.view;

import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SpeechFingerPrintEnrollService;
import com.obric.audio.enroll.sami.SamiEnrollEngine;
import com.obric.audio.enroll.ui.VoicePrintEnrollActivity;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.view.EnrollStageView$observe$3", f = "EnrollStageView.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
public final class EnrollStageView$observe$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EnrollStageView this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ EnrollStageView a;

        /* JADX INFO: renamed from: com.obric.audio.enroll.view.EnrollStageView$observe$3$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0034a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[VoicePrintEnrollActivity.Companion.EnrollDeviceType.values().length];
                r0[VoicePrintEnrollActivity.Companion.EnrollDeviceType.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[VoicePrintEnrollActivity.Companion.EnrollDeviceType.THIRD_PARTY_BT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public a(EnrollStageView r1) {
            this.a = r1;
        }

        public final Object emit(Object r12, Continuation r13) {
            Pair r14 = (Pair) r12;
            EnrollTeamView r15 = this.a.getStageTeam();
            if (r15 != null) goto L6;
            return Unit.INSTANCE;
        L6:
            if (((Number) this.a.getViewModel().getAsrState().getValue()).intValue() != 1) goto L52;
            int r0 = C0034a.a[this.a.getViewModel().getEnrollDeviceType().ordinal()];
            if (r0 != 1) goto L10;
        L12:
            SamiEnrollEngine r1 = SamiEnrollEngine.a;
            String r16 = r15.U5();
            byte[] r2 = (byte[]) r14.getFirst();
            int r17 = ((Number) r14.getSecond()).intValue();
            r1.getClass();
            Intrinsics.checkNotNullParameter(r16, "taskId");
            Intrinsics.checkNotNullParameter(r2, "data");
            Intrinsics.checkNotNullParameter("", "extra");
            int r7 = Integer.MIN_VALUE;
            if (StringsKt.isBlank(r16) == true) goto L49;
            Set<String> r5 = SamiEnrollEngine.p;
            if (r5.contains(r16) == false) goto L49;
            ReentrantLock r9 = SamiEnrollEngine.e;
            if (r9.tryLock() == true) goto L55;
            FLogger.a.i("SamiEnrollEngine", "sendAudioData ignored: native busy taskId=" + r16 + " count=" + r17);
        L50:
            Boxing.boxInt(r7);
            goto L52
        L55:
        L46:
            th = move-exception;
            SamiEnrollEngine.e.unlock();
            throw th;
        L21:
            if (r5.contains(r16) == true) goto L23;
            FLogger.a.i("SamiEnrollEngine", "sendAudioData ignored: inactive after lock taskId=" + r16 + " count=" + r17);     // Catch: Throwable -> L46
        L26:
            r9.unlock();
            goto L50
        L23:
            SpeechFingerPrintEnrollService r3 = SamiEnrollEngine.d;     // Catch: Throwable -> L46
            if (r3 != null) goto L28;
            FLogger.a.e("SamiEnrollEngine", "sendAudioData ignored: enrollService is null taskId=" + r16 + " count=" + r17);     // Catch: Throwable -> L46
            goto L26
        L28:
            if (r17 == r2.length) goto L53;
            r2 = Arrays.copyOf(r2, r17);     // Catch: Throwable -> L46
        L53:
            Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L33
            Object r19 = Result.constructor-impl(Integer.valueOf(r3.sendAudioData(r2, r16, "")));     // Catch: Throwable -> L33
        L35:
            Throwable r4 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L46
            if (r4 == null) goto L39;
            FLogger.a.e("SamiEnrollEngine", "sendAudioData failed taskId=" + r16 + ' ' + r4.getMessage());     // Catch: Throwable -> L46
        L39:
            if (Result.isFailure-impl(r19) == false) goto L41;
            r19 = null;
        L41:
            Integer r110 = (Integer) r19;     // Catch: Throwable -> L46
            if (r110 != null) goto L44;
        L45:
            SamiEnrollEngine.e.unlock();
            goto L50
        L44:
            r7 = r110.intValue();     // Catch: Throwable -> L46
            goto L45
        L33:
            th = move-exception;
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L46
            r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L46
        L49:
            FLogger.a.i("SamiEnrollEngine", "sendAudioData ignored: inactive taskId=" + r16 + " count=" + r17);
            goto L50
        L10:
            if (r0 == 2) goto L12;
        L52:
            return Unit.INSTANCE;
        }
    }

    public EnrollStageView$observe$3(EnrollStageView r1, Continuation<? super EnrollStageView$observe$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EnrollStageView$observe$3(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MutableSharedFlow<Pair<byte[], Integer>> r6 = this.this$0.getViewModel().getAudioData();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
