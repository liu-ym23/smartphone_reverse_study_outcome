package com.larus.ugc.feed.impl.detail.ability;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.detail.ability.CreationDetailLoadingAbilityImpl$fetch$1", f = "CreationDetailLoadingAbilityImpl.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
final class CreationDetailLoadingAbilityImpl$fetch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    Object L$0;
    int label;
    final /* synthetic */ e this$0;

    public CreationDetailLoadingAbilityImpl$fetch$1(e r1, String r2, Continuation<? super CreationDetailLoadingAbilityImpl$fetch$1> r3) {
        this.$id = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationDetailLoadingAbilityImpl$fetch$1(null, this.$id, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 != 0) goto L5;
        ResultKt.throwOnFailure(r3);
        int r4 = e.a;
        throw null;
    L5:
        if (r0 != 1) goto L16;
        z0 r1 = (z0) this.L$0;
        ResultKt.throwOnFailure(r3);
        j0a.a r5 = (j0a.a) r3;
        if ((r5 instanceof j0a.a.c) == false) goto L10;
        Object r2 = new k0a.d(((j0a.a.c) r5).a);
    L13:
        r1.setValue(r2);
        return Unit.INSTANCE;
    L10:
        if (Intrinsics.areEqual(r5, j0a.a.C0062a.a) == false) goto L12;
        r2 = k0a.b.a;
        goto L13
    L12:
        r2 = k0a.c.a;
        goto L13
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
