package com.larus.doc.impl.operation.download;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.FileExportType;
import com.larus.doc.impl.DocumentApi;
import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.download.DocDownloadManager$startDownloadInternalV1$1", f = "DocDownloadManager.kt", i = {}, l = {294, 307}, m = "invokeSuspend", n = {}, s = {})
final class DocDownloadManager$startDownloadInternalV1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ p $callback;
    final /* synthetic */ FileExportType $downloadType;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ int $resourceType;
    final /* synthetic */ int $resourceVersion;
    final /* synthetic */ int $type;
    int label;

    public DocDownloadManager$startDownloadInternalV1$1(String r1, int r2, int r3, int r4, p r5, FileExportType r6, Continuation<? super DocDownloadManager$startDownloadInternalV1$1> r7) {
        this.$resourceId = r1;
        this.$type = r2;
        this.$resourceType = r3;
        this.$resourceVersion = r4;
        this.$callback = r5;
        this.$downloadType = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new DocDownloadManager$startDownloadInternalV1$1(this.$resourceId, this.$type, this.$resourceType, this.$resourceVersion, this.$callback, this.$downloadType, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = this.label;
        if (r4 == 0) goto L12;
        if (r4 == 1) goto L10;
        if (r4 != 2) goto L9;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L64
    L50:
        o r13 = (o) r12;     // Catch: Exception -> L64
        FLogger.a.i("DocDownloadManager", "[startDownload] download url: " + r13);     // Catch: Exception -> L64
        if (r13 != null) goto L54;
        this.$callback.a(null, "get url error, time out");     // Catch: Exception -> L64
        return Unit.INSTANCE;
    L54:
        j r0 = DocDownloadManager.b;     // Catch: Exception -> L64
        Context r1 = AppHost.a.getApplication().getApplicationContext();     // Catch: Exception -> L64
        String r5 = r13.c();     // Catch: Exception -> L64
        String r6 = "";
        if (r5 != null) goto L58;
        r5 = "";
    L58:
        DocDownloadManager r7 = DocDownloadManager.a;     // Catch: Exception -> L64
        String r14 = r13.a();     // Catch: Exception -> L64
        if (r14 == null) goto L62;
        r6 = r14;
    L62:
        r0.a(r1, new k(r5, DocDownloadManager.b(r7, r6, this.$downloadType), DocDownloadManager.a(r7), this.$callback));     // Catch: Exception -> L64
    L67:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L64
    L19:
        dm9.a.a r15 = (dm9.a) r12;     // Catch: Exception -> L64
        if ((r15 instanceof dm9.a.a) == false) goto L24;
        this.$callback.a(null, "get job id error, " + r15.b);     // Catch: Exception -> L64
        return Unit.INSTANCE;
    L24:
        if ((r15 instanceof dm9.a.b) == false) goto L26;
        dm9.a.b r2 = (dm9.a.b) r15;     // Catch: Exception -> L64
    L27:
        if (r2 == null) goto L33;
        BizResponse r8 = r2.a;     // Catch: Exception -> L64
        if (r8 == null) goto L33;
        m r9 = (m) r8.getData();     // Catch: Exception -> L64
        if (r9 == null) goto L33;
        Long r10 = r9.b();     // Catch: Exception -> L64
    L34:
        FLogger.a.i("DocDownloadManager", "[startDownload] job id :" + r10);     // Catch: Exception -> L64
        if (r10 != null) goto L38;
        this.$callback.a(null, "get job id error, job id is empty");     // Catch: Exception -> L64
        return Unit.INSTANCE;
    L38:
        String r11 = h.b;     // Catch: Exception -> L64
        h.d = System.currentTimeMillis();     // Catch: Exception -> L64
        DocDownloadManager r16 = DocDownloadManager.a;     // Catch: Exception -> L64
        if ((r15 instanceof dm9.a.b) == false) goto L41;
        dm9.a.b r17 = (dm9.a.b) r15;     // Catch: Exception -> L64
    L42:
        if (r17 == null) goto L46;
        BizResponse r18 = r17.a;     // Catch: Exception -> L64
        if (r18 == null) goto L46;
        m r110 = (m) r18.getData();     // Catch: Exception -> L64
    L47:
        this.label = 2;     // Catch: Exception -> L64
        r12 = DocDownloadManager.c(r16, r110, this);     // Catch: Exception -> L64
        if (r12 != r3) goto L50;
        return r3;
    L46:
        r110 = null;
        goto L47
    L41:
        r17 = null;
    L33:
        r10 = null;
        goto L34
    L26:
        r2 = null;
        goto L27
    L12:
        ResultKt.throwOnFailure(r12);
        DocDownloadManager r111 = DocDownloadManager.a;     // Catch: Exception -> L64
        String r20 = this.$resourceId;     // Catch: Exception -> L64
        int r21 = this.$type;     // Catch: Exception -> L64
        int r112 = this.$resourceVersion;     // Catch: Exception -> L64
        this.label = 1;     // Catch: Exception -> L64
        r111.getClass();     // Catch: Exception -> L64
        l r113 = new l(r20, r21, r112);     // Catch: Exception -> L64
        DocumentApi.a r22 = DocumentApi.a;     // Catch: Exception -> L64
        DocDownloadManager$getJobId$2$1 r23 = new DocDownloadManager$getJobId$2$1(r113, null);     // Catch: Exception -> L64
        r22.getClass();     // Catch: Exception -> L64
        r12 = DocumentApi.a.a(r23, this);     // Catch: Exception -> L64
        if (r12 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        r12 = (dm9.a) r12;     // Catch: Exception -> L64
    L17:
        if (r12 != r3) goto L19;
        return r3;
    L64:
        e = move-exception;
        this.$callback.a(null, "startDownload error:" + e.getMessage());
        goto L67
    }
}
