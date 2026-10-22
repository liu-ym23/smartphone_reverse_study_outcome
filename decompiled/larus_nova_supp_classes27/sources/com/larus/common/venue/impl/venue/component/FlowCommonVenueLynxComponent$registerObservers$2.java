package com.larus.common.venue.impl.venue.component;

import androidx.lifecycle.LiveData;
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
@DebugMetadata(c = "com.larus.common.venue.impl.venue.component.FlowCommonVenueLynxComponent$registerObservers$2", f = "FlowCommonVenueLynxComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowCommonVenueLynxComponent$registerObservers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FlowCommonVenueLynxComponent this$0;

    public FlowCommonVenueLynxComponent$registerObservers$2(FlowCommonVenueLynxComponent r1, Continuation<? super FlowCommonVenueLynxComponent$registerObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new FlowCommonVenueLynxComponent$registerObservers$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.common.venue.impl.venue.component.z] */
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r4);
        ry9.h r5 = (ry9.h) this.this$0.s.getValue();
        if (r5 == null) goto L10;
        LiveData r6 = r5.ja();
        if (r6 == null) goto L10;
        final FlowCommonVenueLynxComponent r0 = this.this$0;
        r6.observe(s1a.a.c(r0), new FlowCommonVenueLynxComponent.b(new z(r0)));
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
