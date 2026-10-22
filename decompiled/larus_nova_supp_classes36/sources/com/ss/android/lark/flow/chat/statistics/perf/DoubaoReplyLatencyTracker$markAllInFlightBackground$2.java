package com.ss.android.lark.flow.chat.statistics.perf;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\r\u0012\t\u0012\u00070\u0003¢\u0006\u0002\b\u00040\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lcom/ss/android/lark/flow/chat/statistics/perf/DoubaoReplyLatencyTracker$Trace;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.statistics.perf.DoubaoReplyLatencyTracker$markAllInFlightBackground$2", f = "DoubaoReplyLatencyTracker.kt", i = {0, 1}, l = {174, 175, 176}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence"}, s = {"L$0", "L$0"})
final class DoubaoReplyLatencyTracker$markAllInFlightBackground$2 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super a.b>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public DoubaoReplyLatencyTracker$markAllInFlightBackground$2(Continuation<? super DoubaoReplyLatencyTracker$markAllInFlightBackground$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        DoubaoReplyLatencyTracker$markAllInFlightBackground$2 r0 = new DoubaoReplyLatencyTracker$markAllInFlightBackground$2(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((SequenceScope) r1, (Continuation) r2);
    }

    public final Object invoke(SequenceScope<? super a.b> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r6);
    L23:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        SequenceScope r2 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r6);
    L19:
        Collection<a.b> r7 = a.f.values();
        this.L$0 = null;
        this.label = 3;
        if (r2.yieldAll(r7, this) != r0) goto L23;
        return r0;
    L11:
        r2 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r6);
    L16:
        Collection<a.b> r8 = a.e.values();
        this.L$0 = r2;
        this.label = 2;
        if (r2.yieldAll(r8, this) != r0) goto L19;
        return r0;
    L12:
        ResultKt.throwOnFailure(r6);
        SequenceScope r9 = (SequenceScope) this.L$0;
        Collection<a.b> r3 = a.d.values();
        this.L$0 = r9;
        this.label = 1;
        if (r9.yieldAll(r3, this) != r0) goto L15;
        return r0;
    L15:
        r2 = r9;
        goto L16
    }
}
