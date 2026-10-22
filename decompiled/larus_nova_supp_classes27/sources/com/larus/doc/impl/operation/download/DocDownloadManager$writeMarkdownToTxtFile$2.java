package com.larus.doc.impl.operation.download;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.download.DocDownloadManager$writeMarkdownToTxtFile$2", f = "DocDownloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DocDownloadManager$writeMarkdownToTxtFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ String $title;
    int label;

    public DocDownloadManager$writeMarkdownToTxtFile$2(String r1, String r2, Continuation<? super DocDownloadManager$writeMarkdownToTxtFile$2> r3) {
        this.$title = r1;
        this.$content = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DocDownloadManager$writeMarkdownToTxtFile$2(this.$title, this.$content, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L30;
        ResultKt.throwOnFailure(r8);
        String r3 = DocDownloadManager.a(DocDownloadManager.a);     // Catch: Exception -> L26
        if (this.$title.length() != 0) goto L8;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
        String r5 = DocDownloadManager.e() + ".txt";     // Catch: Exception -> L26
    L13:
        String r6 = r3 + r5;     // Catch: Exception -> L26
        FLogger r7 = FLogger.a;     // Catch: Exception -> L26
        r7.i("DocDownloadManager", "[writeMarkdownToTxtFile] filePath:" + r6);     // Catch: Exception -> L26
        PolarisFileWrapper r2 = new PolarisFileWrapper(r6);     // Catch: Exception -> L26
        m5.a(r2);     // Catch: Exception -> L26
        if (r2.exists() == true) goto L24;
        File r9 = r2.getParentFile();     // Catch: Exception -> L26
        if (r9 == null) goto L21;
        if (r9.exists() == true) goto L21;
        r9.mkdirs();     // Catch: Exception -> L26
        r7.i("DocDownloadManager", "mkdirs " + r9.getAbsolutePath());     // Catch: Exception -> L26
    L21:
        if (r2.createNewFile() == true) goto L24;
        r7.e("DocDownloadManager", "[writeMarkdownToTxtFile] create new file failed");     // Catch: Exception -> L26
        return null;
    L24:
        FilesKt.writeText$default(r2, this.$content, null, 2, null);     // Catch: Exception -> L26
        return r6;
    L12:
        r5 = this.$title + ".txt";     // Catch: Exception -> L26
        goto L13
    L8:
        r4 = false;
    L26:
        e = move-exception;
        FLogger.a.e("DocDownloadManager", "[writeMarkdownToTxtFile] error:" + e.getMessage());
        return null;
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
