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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageUpdateManager$scheduleUpdate$1", f = "AIPackageUpdateManager.kt", i = {0, 1}, l = {40, 41}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
final class AIPackageUpdateManager$scheduleUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2539b;

    public AIPackageUpdateManager$scheduleUpdate$1(Continuation r5) {
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        AIPackageUpdateManager$scheduleUpdate$1 r11 = new AIPackageUpdateManager$scheduleUpdate$1(r10);
        r11.f2539b = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        AIPackageUpdateManager$scheduleUpdate$1 r11 = new AIPackageUpdateManager$scheduleUpdate$1(r10);
        r11.f2539b = r5;
        return r11.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0065 -> B:11:0x002e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2538a;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        CoroutineScope r12 = (CoroutineScope) this.f2539b;
        ResultKt.throwOnFailure(r10);
    L11:
        Job r13 = (Job) r12.getCoroutineContext().get(Job.Key);
        if (r13 == null) goto L14;
        boolean r14 = r13.isActive();
    L15:
        if (r14 == false) goto L23;
        s r15 = s.f2755a;
        this.f2539b = r12;
        this.f2538a = 1;
        if (r15.a(this) == r5) goto L21;
    L19:
        long r16 = ((Number) s.f2756b.getValue()).longValue();
        this.f2539b = r12;
        this.f2538a = 2;
        if (DelayKt.delay(r16, this) != r5) goto L11;
    L21:
        return r5;
    L23:
        return Unit.INSTANCE;
    L14:
        r14 = true;
        goto L15
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r12 = (CoroutineScope) this.f2539b;
        ResultKt.throwOnFailure(r10);
        goto L19
    L10:
        ResultKt.throwOnFailure(r10);
        r12 = (CoroutineScope) this.f2539b;
        goto L11
    }
}
