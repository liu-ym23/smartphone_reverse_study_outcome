package com.obric.assistant.omnidetailpage.componment;

import com.larus.utils.logger.FLogger;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailTitleBarComponent$observerTaskStatus$1", f = "OmniDetailTitleBarComponent.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
final class OmniDetailTitleBarComponent$observerTaskStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ i1<Integer> $statusFlow;
    int label;
    final /* synthetic */ OmniDetailTitleBarComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ OmniDetailTitleBarComponent a;

        public a(OmniDetailTitleBarComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            int r5 = ((Number) r3).intValue();
            FLogger.a.i("OmniDetailTitleBarComponent", "observerTaskStatus: status = " + r5);
            OmniDetailTitleBarComponent r6 = this.a;
            int r0 = OmniDetailTitleBarComponent.q;
            r6.getClass();
            if (r5 != OmniDetailActionBarComponent.Companion.TaskStatus.Terminated.ordinal()) goto L5;
        L10:
            boolean r7 = true;
        L11:
            if (r7 == false) goto L14;
            this.a.m3();
        L14:
            return Unit.INSTANCE;
        L5:
            if (r5 == OmniDetailActionBarComponent.Companion.TaskStatus.Completed.ordinal()) goto L10;
            if (r5 == OmniDetailActionBarComponent.Companion.TaskStatus.Fail.ordinal()) goto L10;
            r7 = false;
            goto L11
        }
    }

    public OmniDetailTitleBarComponent$observerTaskStatus$1(i1<Integer> r1, OmniDetailTitleBarComponent r2, Continuation<? super OmniDetailTitleBarComponent$observerTaskStatus$1> r3) {
        this.$statusFlow = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new OmniDetailTitleBarComponent$observerTaskStatus$1(this.$statusFlow, this.this$0, r4);
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
        i1<Integer> r6 = this.$statusFlow;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
