package com.bytedance.android.live.lynx.ui;

import com.lynx.tasm.base.LLog;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IProgressListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements IProgressListener {
    public final /* synthetic */ LiveLynxAlphaPlayer a;

    public c(LiveLynxAlphaPlayer r1) {
        this.a = r1;
    }

    public final void onProgress(long r1) {
        IPlayerController r2 = this.a.a;     // Catch: Exception -> L7
        if (r2 == null) goto L5;
        r2.getDuration();     // Catch: Exception -> L7
    L5:
        this.a.getClass();     // Catch: Exception -> L7
        throw null;     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        LLog.e("x-alpha-video", e.toString());
    }
}
