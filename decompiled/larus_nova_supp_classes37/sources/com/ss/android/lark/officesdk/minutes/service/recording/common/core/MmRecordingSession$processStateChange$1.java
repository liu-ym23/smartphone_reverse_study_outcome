package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.f;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.i;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import iub.j;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession$processStateChange$1", f = "MmRecordingSession.kt", i = {}, l = {290}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSession$processStateChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingSession this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingSession a;

        public a(MmRecordingSession r1) {
            this.a = r1;
        }

        public final Object emit(Object r24, Continuation r25) {
            Pair r1 = (Pair) r24;
            MmRecordingSession r2 = this.a;
            com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r3 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c) r1.getFirst();
            com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r4 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c) r1.getSecond();
            r2.getClass();
            if (Intrinsics.areEqual(r3, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C0037c.c) == true) goto L5;
        L56:
            ((f) this.a.y.getValue()).a((com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c) r1.getFirst(), (com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c) r1.getSecond());
            return Unit.INSTANCE;
        L5:
            if (Intrinsics.areEqual(r4, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l.c) == false) goto L10;
            if (r2.a == RecordingSessionType.STANDALONE_AI_INTERPRETATION) goto L56;
            r2.o(new j(r2.e()));
            goto L56
        L10:
            if (Intrinsics.areEqual(r4, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.j.c) == false) goto L13;
            r2.o(new j(r2.w.g));
            goto L56
        L13:
            if ((r4 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == false) goto L56;
            MmRecordingSession.a r5 = r2.i;
            String r6 = null;
            r2.i = null;
            if (r5 != null) goto L17;
            r5 = new MmRecordingSession.a(MmRecordingError.CreateRecordingRequestFailed.INSTANCE, null);
        L17:
            com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.b r7 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.a;
            ErrorResult r8 = r5.b;
            if (r8 == null) goto L20;
            Integer r11 = Integer.valueOf(r8.getCode());
        L21:
            ErrorResult r9 = r5.b;
            if (r9 == null) goto L24;
            Integer r10 = Integer.valueOf(r9.getStatus());
        L25:
            ErrorResult r12 = r5.b;
            if (r12 == null) goto L28;
            String r13 = r12.getDebugMsg();
        L29:
            ErrorResult r14 = r5.b;
            if (r14 == null) goto L32;
            String r15 = r14.getLogId();
        L33:
            com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.b.C0038b r16 = r7.a.getAndSet(null);
            if (r16 != null) goto L36;
            lvb.a.h("MmRecordingCreateMetrics", "[trackRealtimeRecordingFailure] missing start context, errorCode=" + r11 + ", errorStatus=" + r10 + ", logId=" + r15);
        L55:
            r2.n(r5.a);
            goto L56
        L36:
            lvb.a.h("MmRecordingCreateMetrics", "[trackRealtimeRecordingFailure] traceId=" + r16.a.getRecordingTraceId() + ", source=" + r16.a.getSource() + ", errorCode=" + r11 + ", errorStatus=" + r10 + ", logId=" + r15);
            MmRecordingCommonParam r17 = r16.a;
            d r18 = new d();
            MmRecordingSource r19 = r16.a.getSource();
            if (r19 == null) goto L39;
            String r110 = r19.getValue();
        L41:
            if (r110 != null) goto L43;
            r110 = "";
        L43:
            r18.e("source", r110);
            r18.e("success", UserInfo.NONE_NAME_CARD_ID);
            r18.e("duration", String.valueOf(RangesKt.coerceAtLeast(System.currentTimeMillis() - r16.b, 0)));
            r18.d(UniContext.KEY_OF_ERROR_CODE, r11);
            r18.d("error_status", r10);
            r18.e("error_message", r13);
            r18.e("logid", r15);
            com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.a("minutes_recording_end", r17, r18.a());
            List<String> r20 = i.b;
            MmRecordingCommonParam r21 = r16.a;
            MmRecordingSource r22 = r21.getSource();
            if (r22 == null) goto L46;
            r6 = r22.getValue();
        L46:
            if (r6 != null) goto L48;
            r6 = "";
        L48:
            if (r13 != null) goto L50;
            String r111 = "";
        L51:
            if (r15 != null) goto L53;
            String r112 = "";
        L54:
            i.a.c(r21, r6, "creation", "error", r11, "create_recording_failed", null, null, null, r112, r10, r111, null, null, null, 127424);
            goto L55
        L53:
            r112 = r15;
            goto L54
        L50:
            r111 = r13;
            goto L51
        L39:
            r110 = null;
            goto L41
        L32:
            r15 = null;
            goto L33
        L28:
            r13 = null;
            goto L29
        L24:
            r10 = null;
            goto L25
        L20:
            r11 = null;
            goto L21
        }
    }

    public MmRecordingSession$processStateChange$1(MmRecordingSession r1, Continuation<? super MmRecordingSession$processStateChange$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmRecordingSession$processStateChange$1(this.this$0, r3);
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
        MmRecordingSession r6 = this.this$0;
        b1 r2 = r6.s.e;
        a r3 = new a(r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
