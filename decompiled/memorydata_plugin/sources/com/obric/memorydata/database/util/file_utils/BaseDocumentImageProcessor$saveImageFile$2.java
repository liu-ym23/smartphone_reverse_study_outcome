package com.obric.memorydata.database.util.file_utils;

import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.util.file_utils.BaseDocumentImageProcessor$saveImageFile$2", f = "BaseDocumentImageProcessor.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
final class BaseDocumentImageProcessor$saveImageFile$2 extends SuspendLambda implements Function2<al, Continuation<? super File>, Object> {
    final /* synthetic */ String $fileName;
    final /* synthetic */ byte[] $imageBytes;
    final /* synthetic */ long $maxSizeBytes;
    int label;
    final /* synthetic */ b this$0;

    BaseDocumentImageProcessor$saveImageFile$2(b r3, byte[] r4, long r5, String r7, Continuation<? super BaseDocumentImageProcessor$saveImageFile$2> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$imageBytes = r4;
        this.$maxSizeBytes = r5;
        this.$fileName = r7;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new BaseDocumentImageProcessor$saveImageFile$2(this.this$0, this.$imageBytes, this.$maxSizeBytes, this.$fileName, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super File> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super File> r4) {
        return ((BaseDocumentImageProcessor$saveImageFile$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), BaseDocumentImageProcessor$saveImageFile$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L15;
        return null;
    L15:
        if (this.$imageBytes.length <= this.$maxSizeBytes) goto L18;
        RunLog.INSTANCE.debug(this.this$0.a(), "Image too large (" + this.$imageBytes.length + " Bytes), skipping save");
        return null;
    L18:
        File r8 = new File(this.this$0.c(), this.$fileName);
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r8), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L28
        ((FileOutputStream) ZeusTransformUtils.preCheckCast(r2, FileOutputStream.class, "com.obric.memorydata.plugin")).write(this.$imageBytes);     // Catch: Throwable -> L23
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r2, null);     // Catch: Exception -> L28
        RunLog.INSTANCE.debug(this.this$0.a(), "Image saved: " + r8.getAbsolutePath());     // Catch: Exception -> L28
        return r8;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Exception -> L28
        throw th;     // Catch: Exception -> L28
    L28:
        e = move-exception;
        RunLog.INSTANCE.error(this.this$0.a(), "Failed to save image", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        b r9 = this.this$0;
        Continuation<? super Boolean> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r7 = r9.a(r4);
        if (r7 != r0) goto L12;
        return r0;
    }
}
