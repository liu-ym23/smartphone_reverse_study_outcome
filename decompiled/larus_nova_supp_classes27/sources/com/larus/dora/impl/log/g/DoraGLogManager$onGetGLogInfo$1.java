package com.larus.dora.impl.log.g;

import com.larus.dora.impl.DoraBuryPointManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.log.g.DoraGLogManager$onGetGLogInfo$1", f = "DoraGLogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGLogManager$onGetGLogInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraGLogManager$onGetGLogInfo$1(Continuation<? super DoraGLogManager$onGetGLogInfo$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraGLogManager$onGetGLogInfo$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r18);
        int r1 = a.a;
        long r10 = System.currentTimeMillis();
        byte r12 = DoraGLogManager.c.getId();
        long r13 = DoraGLogManager.d;
        DoraGLogManager r2 = DoraGLogManager.a;
        long r15 = DoraGLogManager.l();
        Intrinsics.checkNotNullParameter(new k(r10, r12, r13, r15), "logInfo");
        a.f = r10;
        a.a = r12;
        a.b = r13;
        a.c = 16;
        a.d = r15;
        LogResultType r3 = LogResultType.SUCCESS;
        Intrinsics.checkNotNullParameter(r3, "result");
        DoraBuryPointManager.J(DoraBuryPointManager.a, "log_get_info", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Integer.valueOf(r3.getId())), TuplesKt.to("type", Integer.valueOf(a.a)), TuplesKt.to("total_size", Long.valueOf(a.b)), TuplesKt.to("batch_fetch_count", Long.valueOf(a.c)), TuplesKt.to("offset_size", Long.valueOf(a.d))}), false, 12);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
