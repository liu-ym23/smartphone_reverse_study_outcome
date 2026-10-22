package com.obric.aikernel.res.task;

import android.content.Context;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.runtime.utils.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.res.task.StorageCleanerDaemon$receiver$1$onReceive$1", f = "StorageCleanerDaemon.kt", i = {0}, l = {31}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class StorageCleanerDaemon$receiver$1$onReceive$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ b this$0;

    StorageCleanerDaemon$receiver$1$onReceive$1(b r3, Continuation<? super StorageCleanerDaemon$receiver$1$onReceive$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        StorageCleanerDaemon$receiver$1$onReceive$1 r0 = new StorageCleanerDaemon$receiver$1$onReceive$1(this.this$0, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((StorageCleanerDaemon$receiver$1$onReceive$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), StorageCleanerDaemon$receiver$1$onReceive$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        al r2 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
    L11:
        File r7 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.a(this.this$0).getConfig().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "Papaya");
        if (r7.canWrite() == false) goto L21;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L15
        Object r8 = Result.m1421constructorimpl(Boxing.boxBoolean(FilesKt.deleteRecursively(r7)));     // Catch: Throwable -> L15
    L17:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L21;
        d.f6216a.f(PackageResourceManager.TAG, "delete " + r7 + " failed " + r9);
    L15:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        al r10 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        b r4 = this.this$0;
        Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r10;
        this.label = 1;
        if (b.a(r4, r11) != r0) goto L11;
        return r0;
    }
}
