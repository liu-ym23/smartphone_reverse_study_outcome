package com.obric.aikernel.res.task;

import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.runtime.utils.d;
import java.io.File;
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
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.task.StorageCleanerDaemon$receiver$1$onReceive$1", f = "StorageCleanerDaemon.kt", i = {0}, l = {31}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class StorageCleanerDaemon$receiver$1$onReceive$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StorageCleanerDaemon this$0;

    StorageCleanerDaemon$receiver$1$onReceive$1(StorageCleanerDaemon r10, Continuation<? super StorageCleanerDaemon$receiver$1$onReceive$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        StorageCleanerDaemon$receiver$1$onReceive$1 r12 = new StorageCleanerDaemon$receiver$1$onReceive$1(this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((StorageCleanerDaemon$receiver$1$onReceive$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        l0 r13 = (l0) this.L$0;
        ResultKt.throwOnFailure(r10);
    L11:
        File r14 = new File(StorageCleanerDaemon.a(this.this$0).getConfig().getContext().getFilesDir(), "Papaya");
        if (r14.canWrite() == false) goto L21;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L15
        Object r16 = Result.m32constructorimpl(Boxing.boxBoolean(FilesKt.deleteRecursively(r14)));     // Catch: Throwable -> L15
    L17:
        Throwable r17 = Result.m35exceptionOrNullimpl(r16);
        if (r17 == null) goto L21;
        d.f5417a.l(PackageResourceManager.TAG, "delete " + r14 + " failed " + r17);
    L15:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        l0 r19 = (l0) this.L$0;
        StorageCleanerDaemon r20 = this.this$0;
        this.L$0 = r19;
        this.label = 1;
        if (StorageCleanerDaemon.d(r20, this) != r11) goto L11;
        return r11;
    }
}
