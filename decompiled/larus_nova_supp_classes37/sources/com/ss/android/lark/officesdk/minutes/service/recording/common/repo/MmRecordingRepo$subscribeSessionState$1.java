package com.ss.android.lark.officesdk.minutes.service.recording.common.repo;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c;
import com.ss.android.lark.picker.base.view.ItemViewType;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;
import ovb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo$subscribeSessionState$1", f = "MmRecordingRepo.kt", i = {}, l = {303}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingRepo$subscribeSessionState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingRepo this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingRepo a;

        public a(MmRecordingRepo r1) {
            this.a = r1;
        }

        public final Object emit(Object r7, Continuation r8) {
            c r9 = (c) ((Pair) r7).getSecond();
            if (r9.a() == false) goto L5;
        L7:
            boolean r0 = r9 instanceof c.b;
            if (r0 == false) goto L11;
            this.a.z = ((c.b) r9).c;
        L11:
            if ((r9 instanceof c.m) == false) goto L14;
            this.a.A = ((c.m) r9).c;
        L14:
            if (Intrinsics.areEqual(r9, c.l.c) == false) goto L16;
        L22:
            MmRecordingRepo r1 = this.a;
            b r2 = r1.a.w;
            r1.A(r2.a, r2.b, "subscribeSessionState:" + r9);
        L24:
            if (r9.a() == true) goto L30;
            Object r10 = MmRecordingRepo.a(this.a, r8);
            if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
            return r10;
        L31:
            return Unit.INSTANCE;
        L30:
            return Unit.INSTANCE;
        L16:
            if (Intrinsics.areEqual(r9, c.k.c) == true) goto L22;
            if (Intrinsics.areEqual(r9, c.h.c) == true) goto L22;
            if (r0 == false) goto L24;
            lvb.a.e(this.a.c, "[subscribeSessionState] EndRecording detected，endReason: " + ((c.b) r9).c);
            this.a.x().l().L0();
            goto L24
        L5:
            if (this.a.p.isInitialized() == false) goto L7;
            this.a.t().h();
            goto L7
        }
    }

    public MmRecordingRepo$subscribeSessionState$1(MmRecordingRepo r1, Continuation<? super MmRecordingRepo$subscribeSessionState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmRecordingRepo$subscribeSessionState$1(this.this$0, r3);
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
        lvb.a.e(this.this$0.c, "start collect sessionStateFlow");
        MmRecordingRepo r6 = this.this$0;
        b1 r2 = r6.a.t;
        a r3 = new a(r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
