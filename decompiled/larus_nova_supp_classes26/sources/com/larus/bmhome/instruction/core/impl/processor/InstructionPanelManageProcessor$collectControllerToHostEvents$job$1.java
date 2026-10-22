package com.larus.bmhome.instruction.core.impl.processor;

import com.larus.bmhome.instruction.core.impl.base.b;
import com.larus.bmhome.instruction.core.impl.base.k;
import com.larus.im.internal.delegate.c0;
import dq8.i;
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
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.core.impl.processor.InstructionPanelManageProcessor$collectControllerToHostEvents$job$1", f = "InstructionPanelManageProcessor.kt", i = {}, l = {571}, m = "invokeSuspend", n = {}, s = {})
public final class InstructionPanelManageProcessor$collectControllerToHostEvents$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $abs;
    int label;
    final /* synthetic */ InstructionPanelManageProcessor this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ b a;
        public final /* synthetic */ InstructionPanelManageProcessor b;

        public a(b r1, InstructionPanelManageProcessor r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r4, Continuation r5) {
            k r6 = (k) r4;
            String r0 = null;
            if ((r6 instanceof k.f) == false) goto L5;
            k.f r7 = (k.f) r6;
        L6:
            if (r7 == null) goto L12;
            i r8 = r7.b;
            if (r8 == null) goto L12;
            String r9 = r8.a;
            if (r9 == null) goto L12;
            r0 = ", command:".concat(r9);
        L12:
            if (r0 != null) goto L14;
            r0 = "";
        L14:
            c0.b.i("InstructionPanelManageProcessor", "[toHostEventFlow] sourceWidgetId:" + this.a.getWidgetId() + ", event:" + r6.a + r0);
            r6.a(this.b.getContext().a.b);
            return Unit.INSTANCE;
        L5:
            r7 = null;
            goto L6
        }
    }

    public InstructionPanelManageProcessor$collectControllerToHostEvents$job$1(b r1, InstructionPanelManageProcessor r2, Continuation<? super InstructionPanelManageProcessor$collectControllerToHostEvents$job$1> r3) {
        this.$abs = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new InstructionPanelManageProcessor$collectControllerToHostEvents$job$1(this.$abs, this.this$0, r4);
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
        b r7 = this.$abs;
        a1 r2 = r7.n;
        a r3 = new a(r7, this.this$0);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
