package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import ic8.m0;
import ic8.n0;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.upload.PreviewAttachmentResourcePreparer$preprocessImageCopy$2", f = "PreviewAttachmentResourcePreparer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PreviewAttachmentResourcePreparer$preprocessImageCopy$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super n0>, Object> {
    final /* synthetic */ Function1<String, n0> $preprocess;
    final /* synthetic */ String $sourcePath;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public PreviewAttachmentResourcePreparer$preprocessImageCopy$2(String r1, Function1<? super String, n0> r2, Continuation<? super PreviewAttachmentResourcePreparer$preprocessImageCopy$2> r3) {
        this.$sourcePath = r1;
        this.$preprocess = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PreviewAttachmentResourcePreparer$preprocessImageCopy$2(this.$sourcePath, this.$preprocess, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super n0> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r10);
        PolarisFileWrapper r3 = new PolarisFileWrapper(this.$sourcePath);
        File r11 = 0;
        File r1 = File.createTempFile("preview_upload_", "_" + r3.getName(), AppHost.a.getApplication().getCacheDir());     // Catch: Throwable -> L18 IOException -> L20
        Intrinsics.checkNotNull(r1);     // Catch: IOException -> L16 Throwable -> L26
        FilesKt.copyTo$default(r3, r1, true, 0, 4, null);     // Catch: IOException -> L16 Throwable -> L26
        n0 r2 = (n0) this.$preprocess.invoke(r1.getAbsolutePath());     // Catch: IOException -> L16 Throwable -> L26
        LocalTakePictureImpl r4 = new LocalTakePictureImpl();     // Catch: IOException -> L16 Throwable -> L26
        String r5 = this.$sourcePath;     // Catch: IOException -> L16 Throwable -> L26
        m0 r6 = r2.a;     // Catch: IOException -> L16 Throwable -> L26
        if (r6 == null) goto L9;
        String r7 = r6.e;     // Catch: IOException -> L16 Throwable -> L26
    L10:
        r4.k(r5, r7);     // Catch: IOException -> L16 Throwable -> L26
        m0 r8 = r2.a;     // Catch: IOException -> L16 Throwable -> L26
        if (r8 == null) goto L13;
        m0 r9 = m0.a(r8, this.$sourcePath, null, null, 16382);     // Catch: IOException -> L16 Throwable -> L26
    L14:
        n0 r12 = new n0(r9, r2.b);     // Catch: IOException -> L16 Throwable -> L26
    L24:
        Boxing.boxBoolean(r1.delete());
    L25:
        return r12;
    L13:
        r9 = null;
        goto L14
    L9:
        r7 = null;
    L16:
        IOException e = e;
    L22:
        FLogger.a.w("PreviewAttachmentResource", "copy failed: ".concat(e.getClass().getSimpleName()));     // Catch: Throwable -> L26
        r12 = new n0(null, ProcessFileResultCode.PREPARE_CLONE_FAILED);     // Catch: Throwable -> L26
        if (r1 == null) goto L25;
    L26:
        th = move-exception;
        th = th;
        r11 = "_";
    L28:
        if (r11 == 0) goto L30;
        Boxing.boxBoolean(r11.delete());
    L30:
        throw th;
    L20:
        e = move-exception;
        e = e;
        r1 = null;
    L18:
        th = th;
        goto L28
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
