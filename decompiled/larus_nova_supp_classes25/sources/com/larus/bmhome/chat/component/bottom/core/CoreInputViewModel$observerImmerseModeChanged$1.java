package com.larus.bmhome.chat.component.bottom.core;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputViewModel$observerImmerseModeChanged$1", f = "CoreInputViewModel.kt", i = {}, l = {DoraCallStateCode.DOUBAO_STOP_RECORD_BY_GUI}, m = "invokeSuspend", n = {}, s = {})
public final class CoreInputViewModel$observerImmerseModeChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<nq9.b, Unit> $onStatusChanged;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Function1<nq9.b, Unit> a;

        public a(Function1<? super nq9.b, Unit> r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            Function1<nq9.b, Unit> r3 = this.a;
            r3.invoke((nq9.b) r1);
            return Unit.INSTANCE;
        }
    }

    public CoreInputViewModel$observerImmerseModeChanged$1(Function1<? super nq9.b, Unit> r1, Continuation<? super CoreInputViewModel$observerImmerseModeChanged$1> r2) {
        this.$onStatusChanged = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CoreInputViewModel$observerImmerseModeChanged$1(this.$onStatusChanged, r3);
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
        kotlinx.coroutines.flow.d1 r6 = com.larus.platform.service.m3.a.c();
        if (r6 == null) goto L16;
        a r2 = new a(this.$onStatusChanged);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L14;
        return r0;
    L16:
        return Unit.INSTANCE;
    }
}
