package com.larus.drive.sdk.impl.view.operation.download;

import android.content.Context;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.nova.NovaApplication;
import com.larus.utils.logger.FLogger;
import gd9.i;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.operation.download.OfficeCardFileDownloadDialog$shareDownloadedFile$1", f = "OfficeCardFileDownloadDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OfficeCardFileDownloadDialog$shareDownloadedFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fileName;
    final /* synthetic */ String $filePath;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OfficeCardFileDownloadDialog this$0;

    public OfficeCardFileDownloadDialog$shareDownloadedFile$1(OfficeCardFileDownloadDialog r1, String r2, String r3, Continuation<? super OfficeCardFileDownloadDialog$shareDownloadedFile$1> r4) {
        this.this$0 = r1;
        this.$filePath = r2;
        this.$fileName = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        OfficeCardFileDownloadDialog$shareDownloadedFile$1 r0 = new OfficeCardFileDownloadDialog$shareDownloadedFile$1(this.this$0, this.$filePath, this.$fileName, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r37) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r37);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        OfficeCardFileDownloadDialog r1 = this.this$0;
        if (r1.g == true) goto L24;
        if (r1.isAdded() == false) goto L24;
        Context r3 = this.this$0.getContext();
        if (r3 == null) goto L12;
        OfficeCardFileDownloadDialog r2 = this.this$0;
        r2.h = true;
        r2.V90();
        String r4 = this.$filePath;
        String r5 = this.$fileName;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L16
        IShareService.a.d(ShareServiceDelegate.b, r3, "more", "file", new com.larus.bmhome.share.panel.b(null, null, null, null, null, null, null, r4, r5, null, null, r4, r5, null, null, null, false, false, null, null, false, false, null, false, null, null, 67102335), null, 48);     // Catch: Throwable -> L16
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L22;
        FLogger.a.e("OfficeCardFileDownloadDialog", "[shareDownloadedFile] Failed to show share panel", r8);
        s r9 = s.a;
        i r10 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r10);
        NovaApplication r11 = r10.getApplication();
        r9.getClass();
        s.o(r11, 2131905399, false);
    L22:
        return Unit.INSTANCE;
    L16:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L12:
        return Unit.INSTANCE;
    L24:
        return Unit.INSTANCE;
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
