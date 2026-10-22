package com.bytedance.android.anniex.api;

import com.bytedance.android.anniex.engine.AnnieXLynxEngine;
import com.bytedance.android.anniex.engine.AnnieXLynxEngineManager;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
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
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.api.AnnieXApi$innerCreateLynxEngine$1$2", f = "AnnieXApi.kt", i = {0}, l = {342}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class AnnieXApi$innerCreateLynxEngine$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnnieXLynxEngine $annieXLynxEngine;
    private /* synthetic */ Object L$0;
    int label;

    public AnnieXApi$innerCreateLynxEngine$1$2(AnnieXLynxEngine r1, Continuation<? super AnnieXApi$innerCreateLynxEngine$1$2> r10) {
        this.$annieXLynxEngine = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AnnieXApi$innerCreateLynxEngine$1$2 r0 = new AnnieXApi$innerCreateLynxEngine$1$2(this.$annieXLynxEngine, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object, kotlinx.coroutines.CoroutineScope] */
    public final Object invokeSuspend(Object r10) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L14;
        if (r11 != 1) goto L13;
        ?? r12 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L8 Exception -> L10
        r12 = r12;
    L19:
        AnnieXLynxEngineManager.a.c();     // Catch: Throwable -> L8 Exception -> L10
        ?? r13 = r12;
    L26:
        JobKt.cancelChildren$default(r13.getCoroutineContext(), null, 1, null);
        CoroutineScopeKt.cancel$default(r13, null, 1, null);
        return Unit.INSTANCE;
    L10:
        Exception e = e;
    L25:
        HybridLogger r14 = HybridLogger.a;     // Catch: Throwable -> L8
        HybridLogger.i("AnnieX", "Error in coroutine: " + e, null, 12);     // Catch: Throwable -> L8
        r13 = r12;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        ?? r15 = (CoroutineScope) this.L$0;
        long r16 = this.$annieXLynxEngine.h;     // Catch: Throwable -> L21 Exception -> L23
        this.L$0 = r15;     // Catch: Throwable -> L21 Exception -> L23
        this.label = 1;     // Catch: Throwable -> L21 Exception -> L23
        if (DelayKt.delay(r16, this) != r1) goto L18;
        return r1;
    L18:
        r12 = r15;
        goto L19
    L23:
        e = move-exception;
        r12 = r15;
        e = e;
    L21:
        Throwable th2 = th;
    L29:
        JobKt.cancelChildren$default(r15.getCoroutineContext(), null, 1, null);
        CoroutineScopeKt.cancel$default(r15, null, 1, null);
        throw th2;
    L8:
        th = move-exception;
        th2 = th;
        r15 = r1;
        goto L29
    }
}
