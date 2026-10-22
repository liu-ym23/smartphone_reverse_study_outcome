package com.larus.dora.impl.util;

import com.larus.ivykit.forest.IFlowForestService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.larus.dora.impl.util.DoraResourceUtil$initializeGGestureResources$1", f = "DoraResourceUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraResourceUtil$initializeGGestureResources$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public DoraResourceUtil$initializeGGestureResources$1(Continuation<? super DoraResourceUtil$initializeGGestureResources$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        DoraResourceUtil$initializeGGestureResources$1 r0 = new DoraResourceUtil$initializeGGestureResources$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r11);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        IFlowForestService r13 = (IFlowForestService) ServiceManager.get().getService(IFlowForestService.class);
        if (r13 != null) goto L23;
        DoraResourceUtil.c.set(false);
        g49.d.e("DoraResourceUtil", "initializeGGestureResources: forest service unavailable");
        return Unit.INSTANCE;
    L23:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        Iterator r4 = DoraResourceUtil.d.iterator();     // Catch: Throwable -> L14
    L10:
        if (r4.hasNext() == false) goto L12;
        DoraVideoType r5 = (DoraVideoType) r4.next();     // Catch: Throwable -> L14
        DoraSKU r6 = DoraSKU.BLACK;     // Catch: Throwable -> L14
        String r7 = r5.fileName(r6, false);     // Catch: Throwable -> L14
        String r8 = r5.fileName(r6, true);     // Catch: Throwable -> L14
        g49.d.d("DoraResourceUtil", "init Dora G Gesture Video Type, light type: " + r7 + ", dark type: " + r8 + ", light path: " + r13.b(r7, "com_flow_dora_gesture_channel", true) + ", dark path: " + r13.b(r8, "com_flow_dora_gesture_channel", true));     // Catch: Throwable -> L14
        goto L10
    L12:
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L20;
        DoraResourceUtil.c.set(false);
        g49.d.c("DoraResourceUtil", "initializeGGestureResources failed", r15);
    L20:
        return Unit.INSTANCE;
    L14:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
