package com.obric.miniapp.intent;

import com.larus.utils.logger.FLogger;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.intent.DeleteEntitiesOperation$execute$2", f = "DeleteEntitiesOperation.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
public final class DeleteEntitiesOperation$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<k, List<String>, Unit> $callback;
    final /* synthetic */ AtomicBoolean $completed;
    final /* synthetic */ DeleteEntitiesOperation.b $parsed;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public DeleteEntitiesOperation$execute$2(DeleteEntitiesOperation.b r1, AtomicBoolean r2, Function2<? super k, ? super List<String>, Unit> r3, Continuation<? super DeleteEntitiesOperation$execute$2> r4) {
        this.$parsed = r1;
        this.$completed = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DeleteEntitiesOperation$execute$2(this.$parsed, this.$completed, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        FLogger r10 = FLogger.a;
        StringBuilder r2 = new StringBuilder("callback timeout ids=");
        r2.append(this.$parsed.b);
        r2.append(" types=");
        AppEntity[] r3 = this.$parsed.a;
        ArrayList r4 = new ArrayList(r3.length);
        int r5 = r3.length;
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L14;
        r4.add(Boxing.boxInt(r3[r6].getType()));
        r6 = r6 + 1;
        goto L12
    L14:
        r2.append(r4);
        r10.e("DeleteEntitiesOperation", r2.toString());
        AtomicBoolean r11 = this.$completed;
        Function2<k, List<String>, Unit> r7 = this.$callback;
        int r8 = k.d;
        k r12 = k.a.a("DELETE_ENTITIES_TIMEOUT", "delete entities timed out");
        List r13 = CollectionsKt.emptyList();
        DeleteEntitiesOperation r14 = DeleteEntitiesOperation.a;
        if (r11.compareAndSet(false, true) == false) goto L18;
        r7.invoke(r12, r13);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        this.label = 1;
        if (DelayKt.delay(14000, this) != r0) goto L11;
        return r0;
    }
}
