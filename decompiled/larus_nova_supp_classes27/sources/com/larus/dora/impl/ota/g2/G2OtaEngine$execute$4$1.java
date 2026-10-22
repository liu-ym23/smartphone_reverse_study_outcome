package com.larus.dora.impl.ota.g2;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g2.G2OtaEngine$execute$4$1", f = "G2OtaEngine.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
public final class G2OtaEngine$execute$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<q> $it;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ G2OtaEngine this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public G2OtaEngine$execute$4$1(List<? extends q> r1, G2OtaEngine r2, Continuation<? super G2OtaEngine$execute$4$1> r3) {
        this.$it = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new G2OtaEngine$execute$4$1(this.$it, this.this$0, r4);
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
        if (r1 != 1) goto L7;
        Iterator r2 = (Iterator) this.L$1;
        G2OtaEngine r3 = (G2OtaEngine) this.L$0;
        ResultKt.throwOnFailure(r6);
    L11:
        if (r2.hasNext() == false) goto L16;
        q r4 = (q) r2.next();
        this.L$0 = r3;
        this.L$1 = r2;
        this.label = 1;
        if (G2OtaEngine.a(r3, r4, this) != r0) goto L11;
        return r0;
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        List<q> r7 = this.$it;
        G2OtaEngine r5 = this.this$0;
        r3 = r5;
        r2 = r7.iterator();
        goto L11
    }
}
