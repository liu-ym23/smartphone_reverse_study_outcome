package com.obric.aikernel.res.downloader.obric;

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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.res.downloader.obric.ObricDownloadTask$finish$2", f = "ObricDownloadTask.kt", i = {0}, l = {72}, m = "invokeSuspend", n = {"downloadFile"}, s = {"L$0"})
final class ObricDownloadTask$finish$2 extends SuspendLambda implements Function1<Continuation<? super Result<? extends Boolean>>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ b this$0;

    ObricDownloadTask$finish$2(b r3, Continuation<? super ObricDownloadTask$finish$2> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(1, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ObricDownloadTask$finish$2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super Result<? extends Boolean>> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Result<Boolean>> r3) {
        return ((ObricDownloadTask$finish$2) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), ObricDownloadTask$finish$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        StringBuilder r2 = (StringBuilder) ZeusTransformUtils.preCheckCast(this.L$3, StringBuilder.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(this.L$2, String.class, "com.obric.memorydata.plugin");
        d r4 = (d) ZeusTransformUtils.preCheckCast(this.L$1, d.class, "com.obric.memorydata.plugin");
        File r5 = (File) ZeusTransformUtils.preCheckCast(this.L$0, File.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
    L14:
        r4.f(r3, r2.append(((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).intValue()).toString());
    L15:
        com.obric.aikernel.res.utils.a.f6155a.a(r5, b.b(this.this$0).d());
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L30
    L17:
        Boolean r12 = null;
        if (r5 == null) goto L26;
        File r6 = r5.getParentFile();     // Catch: Throwable -> L30
        if (r6 == null) goto L22;
        String r7 = r6.getName();     // Catch: Throwable -> L30
    L24:
        if (Intrinsics.areEqual(r7, "downloads") == true) goto L26;
        r5 = r5.getParentFile();     // Catch: Throwable -> L30
        goto L17
    L22:
        r7 = null;
    L26:
        if (r5 == null) goto L28;
        r12 = Boxing.boxBoolean(FilesKt.deleteRecursively(r5));     // Catch: Throwable -> L30
    L28:
        Object r13 = Result.m1421constructorimpl(r12);     // Catch: Throwable -> L30
    L32:
        b r9 = this.this$0;
        Throwable r8 = Result.m1424exceptionOrNullimpl(r13);
        if (r8 == null) goto L36;
        d.f6216a.f("ObricDownloadManager", "delete " + b.b(r9).a() + " failed " + r8);
    L36:
        return Result.m1420boximpl(r13);
    L30:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L32
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        r5 = new File(b.a(this.this$0).getSavePath());
        if (this.this$0.b() == true) goto L15;
        d r15 = d.f6216a;
        StringBuilder r16 = new StringBuilder().append("finish ").append(b.a(this.this$0).getName()).append(" but ").append(r5).append(" not exist. status: ");
        b r17 = this.this$0;
        Continuation<? super Integer> r18 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r5;
        this.L$1 = r15;
        this.L$2 = "ObricDownloadManager";
        this.L$3 = r16;
        this.label = 1;
        Object r19 = r17.f(r18);
        if (r19 != r0) goto L13;
        return r0;
    L13:
        r2 = r16;
        r3 = "ObricDownloadManager";
        r4 = r15;
        r10 = r19;
        goto L14
    }
}
