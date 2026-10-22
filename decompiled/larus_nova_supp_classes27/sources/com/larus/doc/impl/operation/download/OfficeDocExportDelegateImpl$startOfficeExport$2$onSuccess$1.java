package com.larus.doc.impl.operation.download;

import android.content.Context;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.download.OfficeDocExportDelegateImpl$startOfficeExport$2$onSuccess$1", f = "OfficeDocExportDelegateImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeDocExportDelegateImpl$startOfficeExport$2$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $filePath;
    private /* synthetic */ Object L$0;
    int label;

    public OfficeDocExportDelegateImpl$startOfficeExport$2$onSuccess$1(String r1, Context r2, Continuation<? super OfficeDocExportDelegateImpl$startOfficeExport$2$onSuccess$1> r3) {
        this.$filePath = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        OfficeDocExportDelegateImpl$startOfficeExport$2$onSuccess$1 r0 = new OfficeDocExportDelegateImpl$startOfficeExport$2$onSuccess$1(this.$filePath, this.$context, r5);
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
        String r14 = this.$filePath;
        Context r1 = this.$context;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        String r15 = StringsKt.substringAfterLast$default(r14, "/", null, 2, null);     // Catch: Throwable -> L7
        IShareService.a.d(ShareServiceDelegate.b, r1, "more", "file", new com.larus.bmhome.share.panel.b(null, null, null, null, null, null, null, r14, r15, null, null, r14, r15, null, null, null, false, false, null, null, false, false, null, false, null, null, 67102335), null, 48);     // Catch: Throwable -> L7
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L13;
        FLogger.a.e("OfficeDocExportDelegateImpl", "share error: " + r4);
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
