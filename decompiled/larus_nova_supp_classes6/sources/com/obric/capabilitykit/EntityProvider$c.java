package com.obric.capabilitykit;

import com.obric.capabilitykit.entity.IndexProgress;
import com.obric.capabilitykit.entity.ResultCallback;
import com.obric.capabilitykit.entity.app.EntityType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.obric.capabilitykit.EntityProvider$getIndexProgress$1$1", f = "EntityProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EntityProvider$c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ IndexProgress b;
    public final /* synthetic */ ResultCallback<IndexProgress> c;

    public EntityProvider$c(IndexProgress r1, ResultCallback<IndexProgress> r2, Continuation<? super EntityProvider$c> r3) {
        this.b = r1;
        this.c = r2;
        super(2, r3);
    }

    public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new EntityProvider$c(this.b, this.c, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return a((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.a != 0) goto L11;
        ResultKt.throwOnFailure(r4);
        IndexProgress r5 = this.b;
        ResultCallback<IndexProgress> r0 = this.c;
        if (r5 != null) goto L7;
        r0.onResult(EntityType.RECORDING, "failed to get index progress", null);
    L9:
        return Unit.INSTANCE;
    L7:
        r0.onResult(0, "ok", r5);
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
