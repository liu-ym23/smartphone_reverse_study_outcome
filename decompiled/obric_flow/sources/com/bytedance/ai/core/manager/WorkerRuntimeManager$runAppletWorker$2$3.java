package com.bytedance.ai.core.manager;

import com.bytedance.ai.utils.c;
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
import kotlinx.coroutines.r;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.core.manager.WorkerRuntimeManager$runAppletWorker$2$3", f = "WorkerRuntimeManager.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
final class WorkerRuntimeManager$runAppletWorker$2$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f2120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2121c;
    public final /* synthetic */ r d;

    public WorkerRuntimeManager$runAppletWorker$2$3(b r5, String r10, r r11, Continuation r12) {
        this.f2120b = r5;
        this.f2121c = r10;
        this.d = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new WorkerRuntimeManager$runAppletWorker$2$3(this.f2120b, this.f2121c, this.d, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((WorkerRuntimeManager$runAppletWorker$2$3) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2119a;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        this.f2120b.d.remove(this.f2121c, this.d);
        String r12 = ug.a.c(new StringBuilder("runApplet "), this.f2121c, ": deferred cleaned up after delay", "WorkerRuntimeManager");
        d r13 = c.f2846a;
        if (r13 == null) goto L15;
        r13.i("WorkerRuntimeManager", r12);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        this.f2119a = 1;
        if (DelayKt.delay(1000, this) != r10) goto L11;
        return r10;
    }
}
