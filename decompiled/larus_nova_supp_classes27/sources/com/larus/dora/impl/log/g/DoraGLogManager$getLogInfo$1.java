package com.larus.dora.impl.log.g;

import com.larus.dora.api.log.GLogType;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
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
@DebugMetadata(c = "com.larus.dora.impl.log.g.DoraGLogManager$getLogInfo$1", f = "DoraGLogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraGLogManager$getLogInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GLogType $type;
    int label;

    public DoraGLogManager$getLogInfo$1(GLogType r1, Continuation<? super DoraGLogManager$getLogInfo$1> r2) {
        this.$type = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraGLogManager$getLogInfo$1(this.$type, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        ScheduledExecutorService r6 = DoraGLogManager.l;
        final GLogType r0 = this.$type;
        DoraGLogManager.m = r6.schedule(new e(r0), 10000, TimeUnit.MILLISECONDS);
        g49.d.d("DoraGLogManager", "send getLogInfo command");
        kj4.a r7 = kj4.a.g();
        byte r1 = this.$type.getId();
        r7.c.d.g(4, 7, new byte[]{10, 1, r1});
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
