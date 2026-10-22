package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager$IndependentHolderCreator$OnMainProcessRebindErrorListener;
import com.ss.android.socialbase.downloader.logger.Logger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class DefaultDownloadCache$3 implements DownloadComponentManager$IndependentHolderCreator$OnMainProcessRebindErrorListener {
    final /* synthetic */ DefaultDownloadCache this$0;

    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager$IndependentHolderCreator$OnMainProcessRebindErrorListener
    public void onRebindError() {
        DefaultDownloadCache.access$002(this.this$0, new SqlDownloadCache());
        Logger.globalError("DefaultDownloadCache", "onRebindError", "Rebind error,use backup sqlDownloadCache");
    }

    public DefaultDownloadCache$3(DefaultDownloadCache r1) {
        this.this$0 = r1;
    }
}
