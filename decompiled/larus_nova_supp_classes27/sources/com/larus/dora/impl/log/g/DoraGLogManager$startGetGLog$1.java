package com.larus.dora.impl.log.g;

import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.dora.api.log.GLogType;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import t39.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.log.g.DoraGLogManager$startGetGLog$1", f = "DoraGLogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraGLogManager$startGetGLog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ t $callback;
    final /* synthetic */ GLogType $type;
    int label;

    public DoraGLogManager$startGetGLog$1(GLogType r1, t r2, Continuation<? super DoraGLogManager$startGetGLog$1> r3) {
        this.$type = r1;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraGLogManager$startGetGLog$1(this.$type, null, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L30;
        ResultKt.throwOnFailure(r11);
        DoraGLogManager r0 = DoraGLogManager.a;
        PolarisFileWrapper r12 = new PolarisFileWrapper(r0.o());
        if (r12.exists() == true) goto L7;
        r12.mkdirs();
    L7:
        boolean r1 = false;
        if (kj4.a.g().c() != null) goto L11;
        g49.d.b("DoraGLogManager", "startGetGLog Device not connected");
        r0.q(false, this.$type, "Device not connected");
        return Unit.INSTANCE;
    L11:
        GLogType r13 = this.$type;
        Lazy r3 = DoraGLogManager.n;
        DoraGLogManager.e.set(((Keva) r3.getValue()).getLong(DoraGLogManager.m() + "_log_offset_" + r13, 0));
        GLogType r14 = this.$type;
        DoraGLogManager.d = ((Keva) r3.getValue()).getLong(DoraGLogManager.m() + "_log_size_" + r14.getType(), 0);
        DoraGLogManager.c = this.$type;
        DoraGLogManager.b = 0;
        r0.v(true);
        long r4 = DoraGLogManager.d;
        long r5 = DoraGLogManager.l();
        if (1 <= r5) goto L14;
    L16:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L26;
        g49.d.d("DoraGLogManager", "startGetGLog read log from breakpoint offset " + DoraGLogManager.l() + ", logSize " + DoraGLogManager.d);
        PolarisFileWrapper r7 = DoraGLogManager.i;
        if (r7 != null) goto L21;
    L24:
        g49.d.d("DoraGLogManager", "startGetGLog logFile is null or not exist, create log file");
        r0.k(DoraGLogManager.c, DoraGLogManager.f);
    L25:
        DoraGLogManager.n(DoraGLogManager.c, DoraGLogManager.l(), 768, 16);
    L28:
        return Unit.INSTANCE;
    L21:
        if (r7.exists() != true) goto L23;
        r1 = true;
    L23:
        if (r1 == true) goto L25;
    L26:
        g49.d.d("DoraGLogManager", "startGetGLog read log from start offset " + DoraGLogManager.l());
        r0.s();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraGLogManager$getLogInfo$1(this.$type, null), 3, null);
        goto L28
    L14:
        if (r5 >= r4) goto L16;
        r6 = true;
        goto L17
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
