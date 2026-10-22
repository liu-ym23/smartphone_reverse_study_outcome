package com.bytedance.ai.resource;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageUpdateManager$scheduleUpdate$1", f = "AIPackageUpdateManager.kt", i = {0, 1}, l = {44, 45}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
final class AIPackageUpdateManager$scheduleUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public AIPackageUpdateManager$scheduleUpdate$1(Continuation<? super AIPackageUpdateManager$scheduleUpdate$1> r10) {
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AIPackageUpdateManager$scheduleUpdate$1 r0 = new AIPackageUpdateManager$scheduleUpdate$1(r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x005a -> B:12:0x0031). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r12 = r11;
    L11:
        AIPackageUpdateManager$scheduleUpdate$1 r13 = this;
    L13:
        if (CoroutineScopeKt.isActive(r12) == false) goto L21;
        AIPackageUpdateManager r14 = AIPackageUpdateManager.a;
        r13.L$0 = r12;
        r13.label = 1;
        if (r14.a(r13) != r0) goto L17;
        return r0;
    L17:
        AIPackageUpdateManager r15 = AIPackageUpdateManager.a;
        long r16 = ((Number) AIPackageUpdateManager.c.getValue()).longValue();
        r13.L$0 = r12;
        r13.label = 2;
        if (DelayKt.delay(r16, r13) != r0) goto L13;
        return r0;
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r17 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r10);
        r12 = r17;
        r13 = this;
        goto L17
    L10:
        ResultKt.throwOnFailure(r10);
        r12 = (CoroutineScope) this.L$0;
        goto L11
    }
}
