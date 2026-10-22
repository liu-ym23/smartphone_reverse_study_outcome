package com.larus.disk.impl;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.impl.IAppDiskServiceImpl", f = "IAppDiskServiceImpl.kt", i = {0}, l = {270, 271}, m = "cleanCache", n = {"isManual"}, s = {"Z$0"})
final class IAppDiskServiceImpl$cleanCache$1 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IAppDiskServiceImpl this$0;

    public IAppDiskServiceImpl$cleanCache$1(IAppDiskServiceImpl r1, Continuation<? super IAppDiskServiceImpl$cleanCache$1> r2) {
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
        IAppDiskServiceImpl$cleanCache$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L14;
        if (r4 == 1) goto L13;
        if (r4 != 2) goto L12;
        ResultKt.throwOnFailure(r2);
    L29:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        boolean r9 = r0.Z$0;
        ResultKt.throwOnFailure(r2);
    L18:
        if (r9 == false) goto L20;
        AppDiskManager$CleanScene r10 = AppDiskManager$CleanScene.MANUAL;
    L21:
        r0.label = 2;
        AppDiskManager r5 = AppDiskManager.a;
        if (r10.isManual() == false) goto L24;
        String r6 = null;
    L26:
        if (AppDiskManager.E(r10, r6, r0) != r3) goto L29;
        return r3;
    L24:
        Lazy r11 = d.a;
        r6 = d.c();
        goto L26
    L20:
        r10 = AppDiskManager$CleanScene.REGULAR;
        goto L21
    L14:
        ResultKt.throwOnFailure(r2);
        r0.Z$0 = false;
        r0.label = 1;
        if (r8.k(r0) == r3) goto L30;
        r9 = false;
        goto L18
    L30:
        return r3;
    L5:
        r0 = new IAppDiskServiceImpl$cleanCache$1(r8, this);
        goto L6
    }
}
