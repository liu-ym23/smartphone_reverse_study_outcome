package com.obric.aikernel.res.update;

import androidx.work.WorkRequest;
import com.obric.aikernel.runtime.utils.NetworkUtil;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.PackageUpdater$checkToResumeUpdateTask$2", f = "PackageUpdater.kt", i = {0}, l = {944}, m = "invokeSuspend", n = {"packagesDir"}, s = {"L$0"})
final class PackageUpdater$checkToResumeUpdateTask$2 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ PackageUpdater this$0;

    PackageUpdater$checkToResumeUpdateTask$2(PackageUpdater r10, Continuation<? super PackageUpdater$checkToResumeUpdateTask$2> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new PackageUpdater$checkToResumeUpdateTask$2(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((PackageUpdater$checkToResumeUpdateTask$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0036 -> B:12:0x0039). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        File r13 = (File) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        if (PackageUpdaterKt.r(r13, PackageUpdater.f(this.this$0), NetworkUtil.f5399a.e(PackageUpdater.b(this.this$0).getConfig().getContext())) == true) goto L14;
    L9:
        this.L$0 = r13;
        this.label = 1;
        if (DelayKt.b(WorkRequest.MIN_BACKOFF_MILLIS, this) != r11) goto L13;
        return r11;
    L14:
        this.this$0.w("pending_retry_timer");
        goto L9
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        r13 = new File(PackageUpdater.c(this.this$0), "packages");
        goto L9
    }
}
