package com.obric.aikernel.res;

import com.obric.aikernel.res.update.PackageUpdater;
import com.obric.aikernel.runtime.utils.d;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager$updater$1", f = "PackageResourceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PackageResourceManager$updater$1 extends SuspendLambda implements Function2<l0, Continuation<? super PackageUpdater>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PackageResourceManager this$0;

    PackageResourceManager$updater$1(PackageResourceManager r10, Continuation<? super PackageResourceManager$updater$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        PackageResourceManager$updater$1 r12 = new PackageResourceManager$updater$1(this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super PackageUpdater> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super PackageUpdater> r11) {
        return ((PackageResourceManager$updater$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r10);
        l0 r11 = (l0) this.L$0;
        d r12 = d.f5417a;
        r12.i(PackageResourceManager.TAG, "updater async start rootDir=" + this.this$0.getContext().getConfig().getRootDir());
        PackageResourceManager r13 = this.this$0;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L7
        long r15 = System.currentTimeMillis();     // Catch: Throwable -> L7
        r12.i(PackageResourceManager.TAG, "updater async installAllWithInfos start");     // Catch: Throwable -> L7
        r12.i(PackageResourceManager.TAG, "updater async installAllWithInfos end costMs=" + (System.currentTimeMillis() - r15) + " installDetailCount=" + r13.getFusionInstaller().b(r13.getContext()).size());     // Catch: Throwable -> L7
        long r16 = System.currentTimeMillis();     // Catch: Throwable -> L7
        r12.i(PackageResourceManager.TAG, "updater async PackageUpdater.init start");     // Catch: Throwable -> L7
        PackageUpdater r17 = new PackageUpdater(r13.getContext());     // Catch: Throwable -> L7
        r17.t();     // Catch: Throwable -> L7
        r12.i(PackageResourceManager.TAG, "updater async PackageUpdater.init end costMs=" + (System.currentTimeMillis() - r16));     // Catch: Throwable -> L7
        Object r18 = Result.m32constructorimpl(r17);     // Catch: Throwable -> L7
    L9:
        Throwable r19 = Result.m35exceptionOrNullimpl(r18);
        if (r19 == null) goto L12;
        d.f5417a.f(PackageResourceManager.TAG, "updater async failed " + ExceptionsKt.stackTraceToString(r19));
    L12:
        ResultKt.throwOnFailure(r18);
        return r18;
    L7:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
