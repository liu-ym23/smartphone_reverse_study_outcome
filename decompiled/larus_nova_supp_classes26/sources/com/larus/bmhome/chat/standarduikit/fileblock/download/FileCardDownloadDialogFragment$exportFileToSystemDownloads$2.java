package com.larus.bmhome.chat.standarduikit.fileblock.download;

import android.os.Build;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.fileblock.download.FileCardDownloadDialogFragment$exportFileToSystemDownloads$2", f = "FileCardDownloadDialogFragment.kt", i = {}, l = {239, 241}, m = "invokeSuspend", n = {}, s = {})
final class FileCardDownloadDialogFragment$exportFileToSystemDownloads$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $fileName;
    final /* synthetic */ File $localFile;
    int label;
    final /* synthetic */ FileCardDownloadDialogFragment this$0;

    public FileCardDownloadDialogFragment$exportFileToSystemDownloads$2(File r1, FileCardDownloadDialogFragment r2, String r3, Continuation<? super FileCardDownloadDialogFragment$exportFileToSystemDownloads$2> r4) {
        this.$localFile = r1;
        this.this$0 = r2;
        this.$fileName = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FileCardDownloadDialogFragment$exportFileToSystemDownloads$2(this.$localFile, this.this$0, this.$fileName, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r5);
    L23:
        boolean r6 = ((Boolean) r5).booleanValue();
    L25:
        return Boxing.boxBoolean(r6);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L19:
        r6 = ((Boolean) r5).booleanValue();
        goto L25
    L10:
        ResultKt.throwOnFailure(r5);
        if (this.$localFile.exists() == true) goto L15;
        return Boxing.boxBoolean(false);
    L15:
        if (Build.VERSION.SDK_INT < 29) goto L20;
        FileCardDownloadDialogFragment r7 = this.this$0;
        File r2 = this.$localFile;
        String r3 = this.$fileName;
        this.label = 1;
        r5 = FileCardDownloadDialogFragment.T90(r7, r2, r3, this);
        if (r5 != r0) goto L19;
        return r0;
    L20:
        FileCardDownloadDialogFragment r8 = this.this$0;
        File r4 = this.$localFile;
        String r9 = this.$fileName;
        this.label = 2;
        r5 = FileCardDownloadDialogFragment.S90(r8, r4, r9, this);
        if (r5 != r0) goto L23;
        return r0;
    }
}
