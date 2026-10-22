package com.larus.disk.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.impl.IAppDiskServiceImpl", f = "IAppDiskServiceImpl.kt", i = {}, l = {291, 292}, m = "getCacheBreakdown", n = {}, s = {})
final class IAppDiskServiceImpl$getCacheBreakdown$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IAppDiskServiceImpl this$0;

    public IAppDiskServiceImpl$getCacheBreakdown$1(IAppDiskServiceImpl r1, Continuation<? super IAppDiskServiceImpl$getCacheBreakdown$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        IAppDiskServiceImpl r8 = this.this$0;
        r8.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        IAppDiskServiceImpl$getCacheBreakdown$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L14;
        if (r4 == 1) goto L13;
        if (r4 != 2) goto L12;
        ResultKt.throwOnFailure(r2);
    L21:
        return r2;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r2);
    L17:
        r0.label = 2;
        AppDiskManager r9 = AppDiskManager.a;
        r2 = BuildersKt.withContext(Dispatchers.getIO(), new AppDiskManager$getCacheBreakdown$2(null), r0);
        if (r2 != r3) goto L21;
        return r3;
    L14:
        ResultKt.throwOnFailure(r2);
        r0.label = 1;
        if (r8.k(r0) != r3) goto L17;
        return r3;
    L5:
        r0 = new IAppDiskServiceImpl$getCacheBreakdown$1(r8, this);
        goto L6
    }
}
