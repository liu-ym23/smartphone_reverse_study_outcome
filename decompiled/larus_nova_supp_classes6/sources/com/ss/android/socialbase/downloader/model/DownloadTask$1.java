package com.ss.android.socialbase.downloader.model;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.downloader.IDownloadStartCallback;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class DownloadTask$1 implements Runnable {
    final /* synthetic */ DownloadTask this$0;
    final /* synthetic */ IDownloadStartCallback val$downloadStartCallback;

    @Override // java.lang.Runnable
    public void run() {
        com_ss_android_socialbase_downloader_model_DownloadTask$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_ss_android_socialbase_downloader_model_DownloadTask$1__run$___twin___() {
        int r0 = this.this$0.download();
        IDownloadStartCallback r1 = this.val$downloadStartCallback;
        if (r1 == null) goto L6;
        r1.onStart(r0);
        return;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ss_android_socialbase_downloader_model_DownloadTask$1_com_larus_apm_impl_protector_RunnableLancet_run(DownloadTask$1 r1) {
        r1.com_ss_android_socialbase_downloader_model_DownloadTask$1__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public DownloadTask$1(DownloadTask r1, IDownloadStartCallback r2) {
        this.this$0 = r1;
        this.val$downloadStartCallback = r2;
    }
}
