package com.larus.dora.impl.log.g;

import com.larus.dora.api.log.GLogType;
import java.util.ArrayList;
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
import pk4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.log.g.DoraGLogManager$getLogData$1", f = "DoraGLogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGLogManager$getLogData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $count;
    final /* synthetic */ long $offset;
    final /* synthetic */ long $size;
    final /* synthetic */ GLogType $type;
    int label;

    public DoraGLogManager$getLogData$1(GLogType r1, long r2, long r4, long r6, Continuation<? super DoraGLogManager$getLogData$1> r8) {
        this.$type = r1;
        this.$offset = r2;
        this.$size = r4;
        this.$count = r6;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DoraGLogManager$getLogData$1(this.$type, this.$offset, this.$size, this.$count, r11);
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
        ScheduledExecutorService r1 = DoraGLogManager.l;
        final GLogType r3 = this.$type;
        final long r4 = this.$offset;
        final long r6 = this.$size;
        final long r8 = this.$count;
        DoraGLogManager.m = r1.schedule(new d(r3, r4, r6, r8), 10000, TimeUnit.MILLISECONDS);
        g49.d.d("DoraGLogManager", "send getLogData command: type=" + this.$type.getId() + ", offset=" + this.$offset + ", size=" + this.$size + ", count=" + this.$count);
        kj4.a r2 = kj4.a.g();
        byte r5 = this.$type.getId();
        long r7 = this.$offset;
        long r9 = this.$size;
        long r10 = this.$count;
        mj4.f r11 = r2.c;
        r11.getClass();
        ArrayList r12 = new ArrayList();
        n.d(r12, new byte[][]{new byte[]{11, 13, r5}, n.l(r7), n.l(r9), n.l(r10)});
        r11.d.g(4, 7, n.w(r12));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
