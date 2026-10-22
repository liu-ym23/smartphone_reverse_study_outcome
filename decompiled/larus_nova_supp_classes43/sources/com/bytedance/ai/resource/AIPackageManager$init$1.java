package com.bytedance.ai.resource;

import android.content.Context;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$init$1", f = "AIPackageManager.kt", i = {}, l = {77, 78}, m = "invokeSuspend", n = {}, s = {})
final class AIPackageManager$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CompletableDeferred<Boolean> $customInit;
    final /* synthetic */ Set<String> $exclusionList;
    int label;

    public AIPackageManager$init$1(Context r1, CompletableDeferred<Boolean> r10, Set<String> r11, Continuation<? super AIPackageManager$init$1> r12) {
        this.$context = r1;
        this.$customInit = r10;
        this.$exclusionList = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIPackageManager$init$1(this.$context, this.$customInit, this.$exclusionList, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L16:
        AIPackageUpdateManager r11 = AIPackageUpdateManager.a;
        Intrinsics.checkNotNullParameter(this.$context, "context");
        AIManager r12 = AIManager.a;
        if (AIManager.x() == false) goto L19;
        com.bytedance.ai.utils.g.a.i("AIPackageUpdateManager", "Skip automatic AIPackage update for oversea host");
    L23:
        return Unit.INSTANCE;
    L19:
        CoroutineScope r13 = CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a);
        AIPackageUpdateManager.b = r13;
        if (r13 == null) goto L23;
        BuildersKt.launch$default(r13, null, null, new AIPackageUpdateManager$scheduleUpdate$1(null), 3, null);
        goto L23
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L13:
        AIPackageManager r14 = AIPackageManager.a;
        CompletableDeferred<Boolean> r15 = this.$customInit;
        Set<String> r16 = this.$exclusionList;
        this.label = 2;
        if (AIPackageManager.a(r14, r15, r16, this) != r0) goto L16;
        return r0;
    L10:
        ResultKt.throwOnFailure(r10);
        AIPackageManager r17 = AIPackageManager.a;
        Context r18 = this.$context;
        this.label = 1;
        if (AIPackageManager.c(r17, r18, this) != r0) goto L13;
        return r0;
    }
}
