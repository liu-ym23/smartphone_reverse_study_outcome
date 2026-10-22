package com.larus.bmhome.chat.standarduikit.fileblock;

import android.content.Context;
import android.net.Uri;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.share.api.IShareService$a;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.share.panel.b;
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
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.fileblock.OfficeHtmlFileDownloadServiceImpl$download$1$1$onSuccessed$1", f = "OfficeHtmlFileDownloadServiceImpl.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeHtmlFileDownloadServiceImpl$download$1$1$onSuccessed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $path;
    final /* synthetic */ String $safeFileName;
    final /* synthetic */ OfficeHtmlFileDownloadServiceImpl $this_runCatching;
    int label;

    public OfficeHtmlFileDownloadServiceImpl$download$1$1$onSuccessed$1(Context r1, String r2, String r3, OfficeHtmlFileDownloadServiceImpl r4, Continuation<? super OfficeHtmlFileDownloadServiceImpl$download$1$1$onSuccessed$1> r5) {
        this.$context = r1;
        this.$path = r2;
        this.$safeFileName = r3;
        this.$this_runCatching = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new OfficeHtmlFileDownloadServiceImpl$download$1$1$onSuccessed$1(this.$context, this.$path, this.$safeFileName, this.$this_runCatching, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r40) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r40);
        Object r3 = r40;
    L11:
        Uri r4 = (Uri) r3;
        s.a.a();
        if (r4 == null) goto L21;
        final OfficeHtmlFileDownloadServiceImpl r1 = this.$this_runCatching;
        final Context r10 = this.$context;
        String r23 = r4.toString();
        String r5 = this.$safeFileName;
        int r6 = OfficeHtmlFileDownloadServiceImpl.b;
        r1.getClass();
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L16
        IShareService$a.d(ShareServiceDelegate.b, r10, ShareChannel.MORE, ShareType.FILE, new b(null, null, null, null, null, null, null, r23, r5, null, null, r23, r5, null, null, null, false, false, null, null, false, false, null, false, null, null, 67102335), new a(r1, r10), 16);     // Catch: Throwable -> L16
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L23;
        FLogger.a.e("OfficeHtmlDownload", "HTML artifact share failed", r9);
        s.a.getClass();
        s.o(r10, 2131905399, false);
    L23:
        return Unit.INSTANCE;
    L16:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L21:
        s.s(this.$context, 2131910881);
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r40);
        ImageSave r12 = ImageSave.a;
        Context r13 = this.$context.getApplicationContext();
        String r14 = this.$path;
        String r15 = this.$safeFileName;
        this.label = 1;
        r3 = ImageSave.l(r12, r13, r14, r15, this);
        if (r3 != r0) goto L11;
        return r0;
    }
}
