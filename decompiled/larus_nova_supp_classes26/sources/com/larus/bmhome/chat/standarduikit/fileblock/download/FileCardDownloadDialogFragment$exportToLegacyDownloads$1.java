package com.larus.bmhome.chat.standarduikit.fileblock.download;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.fileblock.download.FileCardDownloadDialogFragment", f = "FileCardDownloadDialogFragment.kt", i = {0, 0, 0}, l = {297}, m = "exportToLegacyDownloads", n = {"fileName", "appContext", "targetFile"}, s = {"L$0", "L$1", "L$2"})
final class FileCardDownloadDialogFragment$exportToLegacyDownloads$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileCardDownloadDialogFragment this$0;

    public FileCardDownloadDialogFragment$exportToLegacyDownloads$1(FileCardDownloadDialogFragment r1, Continuation<? super FileCardDownloadDialogFragment$exportToLegacyDownloads$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return FileCardDownloadDialogFragment.S90(this.this$0, null, null, this);
    }
}
