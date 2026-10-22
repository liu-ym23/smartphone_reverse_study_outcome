package com.larus.sheet.operation.download;

import android.content.Context;
import com.larus.common_ui.view.FileExportType;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.sheet.operation.download.SheetDownloader$startDownloadIntervalV2$1", f = "SheetDownloader.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
final class SheetDownloader$startDownloadIntervalV2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<Boolean, Throwable, Integer, String, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ FileExportType $downloadType;
    final /* synthetic */ String $fileName;
    final /* synthetic */ String $token;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public SheetDownloader$startDownloadIntervalV2$1(Context r1, FileExportType r2, String r3, String r4, Function4<? super Boolean, ? super Throwable, ? super Integer, ? super String, Unit> r5, Continuation<? super SheetDownloader$startDownloadIntervalV2$1> r6) {
        this.$context = r1;
        this.$downloadType = r2;
        this.$token = r3;
        this.$fileName = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        SheetDownloader$startDownloadIntervalV2$1 r7 = new SheetDownloader$startDownloadIntervalV2$1(this.$context, this.$downloadType, this.$token, this.$fileName, this.$callback, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L18
    L15:
        Boolean r2 = Boxing.boxBoolean(((Boolean) r5).booleanValue());     // Catch: Throwable -> L18
    L16:
        Object r6 = Result.constructor-impl(r2);     // Catch: Throwable -> L18
    L20:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L23;
        FLogger r3 = FLogger.a;
        boolean r4 = d.a;
        r3.e("SheetDownloader", "ensureOfficeSdkInitialized for sheet download failed: " + r7.getMessage());
    L23:
        boolean r8 = d.a;
        d.a(this.$context, this.$downloadType, this.$token, this.$fileName, this.$callback);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L18
        IOfficeSdkServiceV2 r11 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Throwable -> L18
        r2 = null;
        if (r11 == null) goto L16;
        IOfficeSdkServiceV2.a.b(r11, true, null, 6);     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        r5 = r11.n0(15000, this);     // Catch: Throwable -> L18
        if (r5 != r0) goto L15;
        return r0;
    L18:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }
}
