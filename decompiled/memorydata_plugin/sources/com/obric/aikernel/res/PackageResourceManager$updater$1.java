package com.obric.aikernel.res;

import com.obric.aikernel.res.update.n;
import com.obric.aikernel.runtime.utils.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/res/update/PackageUpdater;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager$updater$1", f = "PackageResourceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PackageResourceManager$updater$1 extends SuspendLambda implements Function2<al, Continuation<? super n>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PackageResourceManager this$0;

    PackageResourceManager$updater$1(PackageResourceManager r3, Continuation<? super PackageResourceManager$updater$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        PackageResourceManager$updater$1 r0 = new PackageResourceManager$updater$1(this.this$0, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super n> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super n> r4) {
        return ((PackageResourceManager$updater$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PackageResourceManager$updater$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r8);
        al r9 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        d.f6216a.b(PackageResourceManager.TAG, "updater async start rootDir=" + this.this$0.getContext().getConfig().getRootDir());
        PackageResourceManager r7 = this.this$0;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L7
        d.f6216a.b(PackageResourceManager.TAG, "updater async installAllWithInfos start");     // Catch: Throwable -> L7
        d.f6216a.b(PackageResourceManager.TAG, "updater async installAllWithInfos end costMs=" + (System.currentTimeMillis() - r2) + " installDetailCount=" + r7.getFusionInstaller().b(r7.getContext()).size());     // Catch: Throwable -> L7
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L7
        d.f6216a.b(PackageResourceManager.TAG, "updater async PackageUpdater.init start");     // Catch: Throwable -> L7
        n r11 = new n(r7.getContext());     // Catch: Throwable -> L7
        r11.a();     // Catch: Throwable -> L7
        d.f6216a.b(PackageResourceManager.TAG, "updater async PackageUpdater.init end costMs=" + (System.currentTimeMillis() - r3));     // Catch: Throwable -> L7
        Object r12 = Result.m1421constructorimpl(r11);     // Catch: Throwable -> L7
    L9:
        Throwable r13 = Result.m1424exceptionOrNullimpl(r12);
        if (r13 == null) goto L12;
        d.f6216a.c(PackageResourceManager.TAG, "updater async failed " + ExceptionsKt.stackTraceToString(r13));
    L12:
        ResultKt.throwOnFailure(r12);
        return r12;
    L7:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
