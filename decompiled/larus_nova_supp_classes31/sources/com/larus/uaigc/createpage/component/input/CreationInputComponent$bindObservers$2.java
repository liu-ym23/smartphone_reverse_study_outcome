package com.larus.uaigc.createpage.component.input;

import com.larus.bmhome.actionbar.model.h1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.tencent.open.log.TraceLevel;
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
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.input.CreationInputComponent$bindObservers$2", f = "CreationInputComponent.kt", i = {}, l = {1022}, m = "invokeSuspend", n = {}, s = {})
final class CreationInputComponent$bindObservers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationInputComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationInputComponent a;

        public a(CreationInputComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            if (((Boolean) r1).booleanValue() == true) goto L31;
            ys8.a r3 = this.a.Q3();
            if (r3 == null) goto L7;
            com.larus.bmhome.actionbar.model.r r4 = r3.getCurrentInstructionConf();
        L8:
            if (r4 != null) goto L20;
            ny9.s r5 = this.a.C3();
            if (r5 == null) goto L43;
            com.larus.bmhome.actionbar.model.r r6 = r5.k();
            if (r6 == null) goto L43;
            h1 r7 = r6.c;
            if (r7 == null) goto L43;
            String r8 = r7.a;
            if (r8 == null) goto L43;
            ICoreInputAbility r9 = this.a.D3();
            if (r9 == null) goto L43;
            r9.M5(r8);
        L43:
            return Unit.INSTANCE;
        L20:
            ys8.a r10 = this.a.Q3();
            if (r10 == null) goto L43;
            com.larus.bmhome.actionbar.model.r r11 = r10.getCurrentInstructionConf();
            if (r11 == null) goto L43;
            h1 r12 = r11.c;
            if (r12 == null) goto L43;
            String r13 = r12.a;
            if (r13 == null) goto L43;
            ICoreInputAbility r14 = this.a.D3();
            if (r14 == null) goto L43;
            r14.M5(r13);
            goto L43
        L7:
            r4 = null;
            goto L8
        L31:
            ys8.a r15 = this.a.Q3();
            if (r15 == null) goto L43;
            ys8.a r16 = this.a.Q3();
            if (r16 == null) goto L36;
            int r17 = r16.S4();
        L37:
            String r18 = r15.O3(r17);
            if (r18 == null) goto L43;
            ICoreInputAbility r19 = this.a.D3();
            if (r19 == null) goto L43;
            r19.M5(r18);
            goto L43
        L36:
            r17 = 0;
            goto L37
        }
    }

    public CreationInputComponent$bindObservers$2(CreationInputComponent r1, Continuation<? super CreationInputComponent$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationInputComponent$bindObservers$2(this.this$0, r3);
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
        ys8.a r6 = this.this$0.Q3();
        if (r6 == null) goto L18;
        b1 r7 = r6.tP();
        if (r7 == null) goto L18;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
