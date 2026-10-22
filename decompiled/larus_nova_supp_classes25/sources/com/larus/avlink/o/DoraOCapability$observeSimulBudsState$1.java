package com.larus.avlink.o;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.o.DoraOCapability$observeSimulBudsState$1", f = "DoraOCapability.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
final class DoraOCapability$observeSimulBudsState$1 extends SuspendLambda implements Function2<k<? super Boolean>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements Function1 {
        public final /* synthetic */ k<Boolean> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(k<? super Boolean> r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            boolean r3 = ((Boolean) r2).booleanValue();
            this.a.trySend-JP2dKIU(Boolean.valueOf(r3));
            return null;
        }
    }

    public DoraOCapability$observeSimulBudsState$1(Continuation<? super DoraOCapability$observeSimulBudsState$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        DoraOCapability$observeSimulBudsState$1 r0 = new DoraOCapability$observeSimulBudsState$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((k) r1, (Continuation) r2);
    }

    public final Object invoke(k<? super Boolean> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        k r6 = (k) this.L$0;
        final a r2 = new a(r6);
        ha8.d.h = r2;
        Function0 r3 = new b(r2);
        this.label = 1;
        if (ProduceKt.a(r6, r3, this) != r0) goto L12;
        return r0;
    }
}
