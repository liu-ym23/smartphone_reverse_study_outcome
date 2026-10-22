package com.larus.doc.impl.operation.download;

import android.net.Uri;
import com.larus.common_ui.view.FileExportType;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.download.DocDownloadManager$realDownload$1", f = "DocDownloadManager.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {})
public final class DocDownloadManager$realDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<Boolean, Uri, Integer, String, Unit> $callback;
    final /* synthetic */ String $docTitle;
    final /* synthetic */ FileExportType $downloadType;
    final /* synthetic */ String $passback;
    final /* synthetic */ String $resourceId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public DocDownloadManager$realDownload$1(FileExportType r1, String r2, String r3, String r4, Function4<? super Boolean, ? super Uri, ? super Integer, ? super String, Unit> r5, Continuation<? super DocDownloadManager$realDownload$1> r6) {
        this.$downloadType = r1;
        this.$resourceId = r2;
        this.$docTitle = r3;
        this.$passback = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        DocDownloadManager$realDownload$1 r7 = new DocDownloadManager$realDownload$1(this.$downloadType, this.$resourceId, this.$docTitle, this.$passback, this.$callback, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L18
    L15:
        Boolean r2 = Boxing.boxBoolean(((Boolean) r6).booleanValue());     // Catch: Throwable -> L18
    L16:
        Object r7 = Result.constructor-impl(r2);     // Catch: Throwable -> L18
    L20:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L23;
        FLogger.a.e("DocDownloadManager", "ensureOfficeSdkInitialized for doc download failed: " + r8.getMessage());
    L23:
        DocDownloadManager r9 = DocDownloadManager.a;
        FileExportType r3 = this.$downloadType;
        String r4 = this.$resourceId;
        String r5 = this.$docTitle;
        String r10 = this.$passback;
        Function4<Boolean, Uri, Integer, String, Unit> r11 = this.$callback;
        r9.getClass();
        DocDownloadManager.d(r3, r4, r5, r10, r11);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L18
        IOfficeSdkServiceV2 r14 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Throwable -> L18
        r2 = null;
        if (r14 == null) goto L16;
        IOfficeSdkServiceV2.a.b(r14, true, null, 6);     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        r6 = r14.n0(DoraObricDeviceHomeViewModel.SCAN_TIMEOUT_MS, this);     // Catch: Throwable -> L18
        if (r6 != r0) goto L15;
        return r0;
    L18:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }
}
