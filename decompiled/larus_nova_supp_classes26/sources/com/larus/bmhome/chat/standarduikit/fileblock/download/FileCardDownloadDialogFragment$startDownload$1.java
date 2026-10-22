package com.larus.bmhome.chat.standarduikit.fileblock.download;

import android.content.Context;
import com.larus.bmhome.chat.input.ChatInputService;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.fileblock.download.FileCardDownloadDialogFragment$startDownload$1", f = "FileCardDownloadDialogFragment.kt", i = {0}, l = {108}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class FileCardDownloadDialogFragment$startDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $fileName;
    final /* synthetic */ String $originalUrl;
    final /* synthetic */ String $resourceUri;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FileCardDownloadDialogFragment this$0;

    public FileCardDownloadDialogFragment$startDownload$1(FileCardDownloadDialogFragment r1, String r2, String r3, String r4, Context r5, Continuation<? super FileCardDownloadDialogFragment$startDownload$1> r6) {
        this.this$0 = r1;
        this.$originalUrl = r2;
        this.$resourceUri = r3;
        this.$fileName = r4;
        this.$context = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        FileCardDownloadDialogFragment$startDownload$1 r7 = new FileCardDownloadDialogFragment$startDownload$1(this.this$0, this.$originalUrl, this.$resourceUri, this.$fileName, this.$context, r10);
        r7.L$0 = r9;
        return r7;
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
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r8);
    L11:
        String r9 = (String) r8;
        if (this.this$0.i == true) goto L14;
        if (r9 == null) goto L21;
        if (StringsKt.isBlank(r9) == true) goto L21;
        r2 = false;
    L21:
        if (r2 == false) goto L24;
        FileCardDownloadDialogFragment.U90(this.this$0, null);
        return Unit.INSTANCE;
    L24:
        FLogger.a.i("FileCardDownloadDialog", "download start, fileName=" + this.$fileName);
        Context r4 = this.$context;
        String r5 = this.$fileName;
        FileCardDownloadDialogFragment r6 = this.this$0;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L27
        ye8.b r10 = ChatInputService.b.f();     // Catch: Throwable -> L27
        r6.getClass();     // Catch: Throwable -> L27
        ye8.b.a.a(r10, r4, r9, r5, new b(r6, r5));     // Catch: Throwable -> L27
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        String r12 = this.$fileName;
        FileCardDownloadDialogFragment r13 = this.this$0;
        Throwable r14 = Result.exceptionOrNull-impl(r11);
        if (r14 == null) goto L33;
        FLogger.a.e("FileCardDownloadDialog", "start downloader failed, fileName=" + r12, r14);
        FileCardDownloadDialogFragment.U90(r13, null);
    L33:
        return Unit.INSTANCE;
    L27:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        FileCardDownloadDialogFragment r17 = this.this$0;
        String r18 = this.$originalUrl;
        String r19 = this.$resourceUri;
        this.L$0 = r16;
        this.label = 1;
        r8 = FileCardDownloadDialogFragment.V90(r17, r18, r19, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
