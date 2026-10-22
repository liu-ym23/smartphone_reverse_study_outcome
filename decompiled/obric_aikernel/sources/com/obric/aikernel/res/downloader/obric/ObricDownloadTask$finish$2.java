package com.obric.aikernel.res.downloader.obric;

import com.obric.aikernel.res.utils.a;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.downloader.obric.ObricDownloadTask$finish$2", f = "ObricDownloadTask.kt", i = {0}, l = {72}, m = "invokeSuspend", n = {"downloadFile"}, s = {"L$0"})
final class ObricDownloadTask$finish$2 extends SuspendLambda implements Function1<Continuation<? super Result<? extends Boolean>>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ObricDownloadTask this$0;

    ObricDownloadTask$finish$2(ObricDownloadTask r10, Continuation<? super ObricDownloadTask$finish$2> r11) {
        this.this$0 = r10;
        super(1, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        return new ObricDownloadTask$finish$2(this.this$0, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Result<? extends Boolean>> r10) {
        return invoke2(r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Result<Boolean>> r10) {
        return ((ObricDownloadTask$finish$2) create(r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        StringBuilder r13 = (StringBuilder) this.L$3;
        String r14 = (String) this.L$2;
        d r15 = (d) this.L$1;
        File r16 = (File) this.L$0;
        ResultKt.throwOnFailure(r10);
    L14:
        r13.append(((Number) r10).intValue());
        r15.l(r14, r13.toString());
    L15:
        a.f5222a.e(r16, ObricDownloadTask.l(this.this$0).f());
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L30
    L17:
        Boolean r18 = null;
        if (r16 == null) goto L26;
        File r19 = r16.getParentFile();     // Catch: Throwable -> L30
        if (r19 == null) goto L22;
        String r20 = r19.getName();     // Catch: Throwable -> L30
    L24:
        if (Intrinsics.areEqual(r20, "downloads") == true) goto L26;
        r16 = r16.getParentFile();     // Catch: Throwable -> L30
        goto L17
    L22:
        r20 = null;
    L26:
        if (r16 == null) goto L28;
        r18 = Boxing.boxBoolean(FilesKt.deleteRecursively(r16));     // Catch: Throwable -> L30
    L28:
        Object r21 = Result.m32constructorimpl(r18);     // Catch: Throwable -> L30
    L32:
        ObricDownloadTask r22 = this.this$0;
        Throwable r23 = Result.m35exceptionOrNullimpl(r21);
        if (r23 == null) goto L36;
        d.f5417a.l("ObricDownloadManager", "delete " + ObricDownloadTask.l(r22).c() + " failed " + r23);
    L36:
        return Result.m31boximpl(r21);
    L30:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r21 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L32
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        r16 = new File(ObricDownloadTask.k(this.this$0).getSavePath());
        if (this.this$0.b() == true) goto L15;
        d r25 = d.f5417a;
        StringBuilder r26 = new StringBuilder();
        r26.append("finish ");
        r26.append(ObricDownloadTask.k(this.this$0).getName());
        r26.append(" but ");
        r26.append(r16);
        r26.append(" not exist. status: ");
        ObricDownloadTask r27 = this.this$0;
        this.L$0 = r16;
        this.L$1 = r25;
        this.L$2 = "ObricDownloadManager";
        this.L$3 = r26;
        this.label = 1;
        Object r28 = r27.d(this);
        if (r28 != r11) goto L13;
        return r11;
    L13:
        r13 = r26;
        r14 = "ObricDownloadManager";
        r15 = r25;
        r10 = r28;
        goto L14
    }
}
