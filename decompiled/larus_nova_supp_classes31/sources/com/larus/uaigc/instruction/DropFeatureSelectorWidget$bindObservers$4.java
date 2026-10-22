package com.larus.uaigc.instruction;

import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.instruction.DropFeatureSelectorWidget$bindObservers$4", f = "DropFeatureSelectorWidget.kt", i = {}, l = {323}, m = "invokeSuspend", n = {}, s = {})
final class DropFeatureSelectorWidget$bindObservers$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DropFeatureSelectorWidget this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DropFeatureSelectorWidget a;

        public a(DropFeatureSelectorWidget r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            Unit r5 = (Unit) r3;
            com.larus.bmhome.actionbar.model.h r6 = this.a.getCurrentBindData();
            if (r6 == null) goto L10;
            List r7 = r6.e;
            if (r7 == null) goto L10;
            Iterator<T> r8 = r7.iterator();
        L8:
            if (r8.hasNext() == false) goto L10;
            com.larus.bmhome.actionbar.model.w r0 = (com.larus.bmhome.actionbar.model.w) r8.next();
            r0.s = Boxing.boxInt(0);
        L10:
            com.larus.bmhome.actionbar.model.u r9 = this.a.getInstructionItem();
            if (r9 == null) goto L18;
            Integer r10 = r9.a;
            if (r10 == null) goto L18;
            boolean r1 = true;
            if (r10.intValue() != 1) goto L18;
        L19:
            if (r1 == false) goto L24;
            com.larus.bmhome.view.actionbar.edit.c r11 = this.a.getViewModel();
            if (r11 == null) goto L24;
            r11.setImageStyleRadioSelected(false);
        L24:
            return Unit.INSTANCE;
        L18:
            r1 = false;
            goto L19
        }
    }

    public DropFeatureSelectorWidget$bindObservers$4(DropFeatureSelectorWidget r1, Continuation<? super DropFeatureSelectorWidget$bindObservers$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DropFeatureSelectorWidget$bindObservers$4(this.this$0, r3);
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
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        DropFeatureSelectorWidget r6 = this.this$0;
        int r2 = DropFeatureSelectorWidget.k;
        com.larus.bmhome.view.actionbar.edit.c r7 = r6.getViewModel();
        if (r7 == null) goto L18;
        d1 r8 = r7.getResetImageStyleListFlow();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
