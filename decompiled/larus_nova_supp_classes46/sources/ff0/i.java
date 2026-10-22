package ff0;

import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends AbsDownloadListener {
    public i() {
    }

    public final void onSuccessed(DownloadInfo r2) {
        super.onSuccessed(r2);
        HamletAvatarContext r3 = HamletAvatarContext.Companion.getContext();
        if (r3 == null) goto L8;
        com.bytedance.live.datacontext.m<Boolean> r4 = r3.isLipSyncModelDownloaded();
        if (r4 == null) goto L9;
        r4.setValue(Boolean.TRUE);
        return;
    L9:
        return;
    }
}
