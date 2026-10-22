package com.larus.bmhome.chat.component.thirdpart;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.r1;
import com.larus.utils.logger.FLogger;
import gd8.f;
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
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.thirdpart.ThirdPartLogicComponent$onCreate$1", f = "ThirdPartLogicComponent.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
public final class ThirdPartLogicComponent$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ThirdPartLogicComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ThirdPartLogicComponent a;

        public a(ThirdPartLogicComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            if (((Boolean) r2).booleanValue() == false) goto L8;
            FLogger.a.i("ThirdPartLogicComponent", "lazyAttachComponent");
            f r4 = (f) d.a(this.a).getAbility(f.class);
            if (r4 == null) goto L8;
            r4.AX();
        L8:
            return Unit.INSTANCE;
        }
    }

    public ThirdPartLogicComponent$onCreate$1(ThirdPartLogicComponent r1, Continuation<? super ThirdPartLogicComponent$onCreate$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ThirdPartLogicComponent$onCreate$1(this.this$0, r3);
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
    L14:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        i1 r6 = r1.a.c();
        if (r6 == null) goto L16;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L14;
        return r0;
    L16:
        return Unit.INSTANCE;
    }
}
