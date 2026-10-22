package com.obric.aikernel.res.downloader;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.res.downloader.DownloadSlot$start$2", f = "DownloadSlot.kt", i = {}, l = {26, 35}, m = "invokeSuspend", n = {}, s = {})
final class DownloadSlot$start$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ h this$0;

    DownloadSlot$start$2(h r3, Continuation<? super DownloadSlot$start$2> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new DownloadSlot$start$2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((DownloadSlot$start$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DownloadSlot$start$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00cc -> B:25:0x00cf). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L12;
        if (r1 != 2) goto L11;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L8
    L25:
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L14:
        h.a r11 = this.this$0.b();
        Continuation<? super j> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r10 = r11.a(r2);
        if (r10 != r0) goto L17;
        return r0;
    L17:
        j r12 = (j) ZeusTransformUtils.preCheckCast(r10, j.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L21;
        com.obric.aikernel.runtime.utils.d.f6216a.a("DownloadController", "DownloadSlot: Slot" + this.this$0.a() + " got null task, turn to idle");
        this.this$0.a(true);
        return Unit.INSTANCE;
    L21:
        this.this$0.a(false);
        com.obric.aikernel.runtime.utils.d.f6216a.a("DownloadController", "DownloadSlot: Slot" + this.this$0.a() + " got task:" + r12.a() + " prior:" + r12.b() + " size:" + r12.h());
        h r3 = this.this$0;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        this.label = 2;     // Catch: Throwable -> L8
        if (h.a(r3, r12, this) != r0) goto L25;
        return r0;
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
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
