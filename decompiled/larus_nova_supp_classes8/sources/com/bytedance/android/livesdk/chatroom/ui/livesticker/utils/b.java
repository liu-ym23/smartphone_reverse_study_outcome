package com.bytedance.android.livesdk.chatroom.ui.livesticker.utils;

import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends AbsDownloadListener {
    public final /* synthetic */ long a;

    public b(long r1) {
        this.a = r1;
    }

    public final void onSuccessed(DownloadInfo r4) {
        super.onSuccessed(r4);
        Lazy<String> r5 = LiveStickerTtfUtil.a;
        FileUtils.renameFile(((String) LiveStickerTtfUtil.a.getValue()) + this.a + ".temp", LiveStickerTtfUtil.c(this.a));
        NextLiveData<Integer> r6 = LiveStickerTtfUtil.c;
        Integer r0 = (Integer) r6.getValue();
        if (r0 == null) goto L5;
        int r1 = r0.intValue() + 1;
    L6:
        r6.postValue(Integer.valueOf(r1));
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void onFailed(DownloadInfo r1, BaseException r2) {
        super.onFailed(r1, r2);
        Lazy<String> r3 = LiveStickerTtfUtil.a;
        NextLiveData<Integer> r4 = LiveStickerTtfUtil.c;
        Integer r5 = (Integer) r4.getValue();
        if (r5 == null) goto L5;
        int r6 = r5.intValue() + 1;
    L6:
        r4.postValue(Integer.valueOf(r6));
        return;
    L5:
        r6 = 0;
        goto L6
    }
}
