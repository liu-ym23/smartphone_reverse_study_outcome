package com.larus.doc.impl.operation.download;

import com.larus.doc.impl.operation.DocOpManager;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.download.DocDownloadManager$exportFileToTxt$1", f = "DocDownloadManager.kt", i = {}, l = {350, 356}, m = "invokeSuspend", n = {}, s = {})
final class DocDownloadManager$exportFileToTxt$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ p $callback;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ int $resourceVersion;
    int label;

    public DocDownloadManager$exportFileToTxt$1(String r1, int r2, p r3, Continuation<? super DocDownloadManager$exportFileToTxt$1> r4) {
        this.$resourceId = r1;
        this.$resourceVersion = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DocDownloadManager$exportFileToTxt$1(this.$resourceId, this.$resourceVersion, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L36:
        String r9 = (String) r8;
        if (r9 == null) goto L39;
        this.$callback.onSuccess(r9);
    L41:
        return Unit.INSTANCE;
    L39:
        this.$callback.a(null, "write txt error");
        goto L41
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        com.larus.office.card.doc.content.a r10 = (com.larus.office.card.doc.content.a) r8;
        if (r10 == null) goto L16;
        FLogger.a.i("DocDownloadManager", "[exportFileToTxt] content:" + r10);
        String r2 = r10.a;
        if (r2 != null) goto L20;
    L23:
        if (r4 == false) goto L26;
        this.$callback.a(null, "content is empty");
        return Unit.INSTANCE;
    L26:
        DocDownloadManager r3 = DocDownloadManager.a;
        String r5 = r10.a;
        String r6 = "";
        if (r5 != null) goto L29;
        r5 = "";
    L29:
        String r11 = r10.b;
        if (r11 == null) goto L33;
        r6 = r11;
    L33:
        this.label = 2;
        r3.getClass();
        r8 = BuildersKt.withContext(Dispatchers.getIO(), new DocDownloadManager$writeMarkdownToTxtFile$2(r6, r5, null), this);
        if (r8 != r0) goto L36;
        return r0;
    L20:
        if (r2.length() == 0) goto L23;
        r4 = false;
        goto L23
    L16:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r8);
        DocOpManager r12 = DocOpManager.a;
        String r7 = this.$resourceId;
        int r13 = this.$resourceVersion;
        this.label = 1;
        r8 = r12.e(r7, r13, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
