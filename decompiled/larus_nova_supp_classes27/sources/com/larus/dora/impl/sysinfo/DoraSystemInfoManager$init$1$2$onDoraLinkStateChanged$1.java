package com.larus.dora.impl.sysinfo;

import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.FlowDoraVideoRecordConfig;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.sysinfo.DoraSystemInfoManager$init$1$2$onDoraLinkStateChanged$1", f = "DoraSystemInfoManager.kt", i = {}, l = {183, 184, 186}, m = "invokeSuspend", n = {}, s = {})
public final class DoraSystemInfoManager$init$1$2$onDoraLinkStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraSystemInfoManager$init$1$2$onDoraLinkStateChanged$1(Continuation<? super DoraSystemInfoManager$init$1$2$onDoraLinkStateChanged$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraSystemInfoManager$init$1$2$onDoraLinkStateChanged$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r7);
    L35:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r7);
    L18:
        DoraSystemInfoManager r8 = DoraSystemInfoManager.a;
        g49.d.d("DoraSystemInfoManager", "fetchVideoRecordConfig: start");
        IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L29
        if (r3 == null) goto L24;
        VisionService r4 = r3.V();     // Catch: Exception -> L29
        if (r4 == null) goto L24;
        FlowDoraVideoRecordConfig r5 = r4.b();     // Catch: Exception -> L29
    L25:
        if (r5 == null) goto L27;
        g49.d.d("DoraSystemInfoManager", "fetchVideoRecordConfig success: " + r5);     // Catch: Exception -> L29
        DoraSystemInfoManager.m = Integer.valueOf(r5.a);     // Catch: Exception -> L29
        DoraSystemInfoManager.n = Integer.valueOf(r5.c);     // Catch: Exception -> L29
        DoraSystemInfoManager.o = Integer.valueOf(r5.b);     // Catch: Exception -> L29
    L31:
        DoraSystemInfoManager r9 = DoraSystemInfoManager.a;
        this.label = 3;
        if (DoraSystemInfoManager.b(r9, this) != r0) goto L35;
        return r0;
    L27:
        g49.d.d("DoraSystemInfoManager", "fetchVideoRecordConfig: config is null");     // Catch: Exception -> L29
    L24:
        r5 = null;
    L29:
        e = move-exception;
        g49.d.c("DoraSystemInfoManager", "fetchVideoRecordConfig: failed", e);
        goto L31
    L11:
        ResultKt.throwOnFailure(r7);
    L15:
        DoraSystemInfoManager r10 = DoraSystemInfoManager.a;
        this.label = 2;
        if (DoraSystemInfoManager.a(r10, this) != r0) goto L18;
        return r0;
    L12:
        ResultKt.throwOnFailure(r7);
        this.label = 1;
        if (DelayKt.delay(8000, this) != r0) goto L15;
        return r0;
    }
}
