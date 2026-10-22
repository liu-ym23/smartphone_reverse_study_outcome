package com.larus.sheet.operation.download;

import android.content.Context;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.sheet.operation.download.OfficeSheetExportDelegateImpl$startSheetExport$2$1", f = "OfficeSheetExportDelegateImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OfficeSheetExportDelegateImpl$startSheetExport$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ String $extraMsg;
    private /* synthetic */ Object L$0;
    int label;

    public OfficeSheetExportDelegateImpl$startSheetExport$2$1(String r1, Context r2, Continuation<? super OfficeSheetExportDelegateImpl$startSheetExport$2$1> r3) {
        this.$extraMsg = r1;
        this.$ctx = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        OfficeSheetExportDelegateImpl$startSheetExport$2$1 r0 = new OfficeSheetExportDelegateImpl$startSheetExport$2$1(this.$extraMsg, this.$ctx, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r35) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r35);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        String r14 = this.$extraMsg;
        Context r1 = this.$ctx;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        IShareService.a.d(ShareServiceDelegate.b, r1, "more", "file", new com.larus.bmhome.share.panel.b(null, null, null, null, null, null, null, r14, StringsKt.substringAfterLast$default(r14, "/", null, 2, null), null, null, r14, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67106431), null, 48);     // Catch: Throwable -> L7
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L13;
        FLogger.a.e("OfficeSheetExportDelegateImpl", "share sheet error: " + r4);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
