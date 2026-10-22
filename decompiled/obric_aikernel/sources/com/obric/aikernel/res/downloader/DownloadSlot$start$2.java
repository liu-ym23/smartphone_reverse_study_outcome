package com.obric.aikernel.res.downloader;

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
@DebugMetadata(c = "com.obric.aikernel.res.downloader.DownloadSlot$start$2", f = "DownloadSlot.kt", i = {}, l = {26, 35}, m = "invokeSuspend", n = {}, s = {})
final class DownloadSlot$start$2 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DownloadSlot this$0;

    DownloadSlot$start$2(DownloadSlot r10, Continuation<? super DownloadSlot$start$2> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DownloadSlot$start$2(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((DownloadSlot$start$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00b1 -> B:25:0x00b4). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L13;
        if (r12 == 1) goto L12;
        if (r12 != 2) goto L11;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L8
    L25:
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L14:
        DownloadSlot.a r13 = this.this$0.b();
        this.label = 1;
        r10 = r13.b(this);
        if (r10 != r11) goto L17;
        return r11;
    L17:
        DownloadTask r14 = (DownloadTask) r10;
        if (r14 != null) goto L21;
        com.obric.aikernel.runtime.utils.d.f5417a.d("DownloadController", "DownloadSlot: Slot" + this.this$0.c() + " got null task, turn to idle");
        this.this$0.e(true);
        return Unit.INSTANCE;
    L21:
        this.this$0.e(false);
        com.obric.aikernel.runtime.utils.d.f5417a.d("DownloadController", "DownloadSlot: Slot" + this.this$0.c() + " got task:" + r14.v() + " prior:" + r14.w() + " size:" + r14.u());
        DownloadSlot r15 = this.this$0;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L8
        this.label = 2;     // Catch: Throwable -> L8
        if (DownloadSlot.a(r15, r14, this) != r11) goto L25;
        return r11;
    L8:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L14
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r10);
        goto L17
    L13:
        ResultKt.throwOnFailure(r10);
        goto L14
    }
}
