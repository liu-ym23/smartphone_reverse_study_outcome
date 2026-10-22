package com.bytedance.android.livesdk.chatroom.ui;

import android.graphics.Bitmap;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y4 implements Callable<Bitmap> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Bitmap call() throws Exception {
        ILivePlayerClient r0 = LivePlatformPlayerManager.f();
        if (r0 == null) goto L11;
        Bitmap r2 = r0.getBitmap();
        if (r2 == null) goto L8;
        return r2;
    L8:
        if (r0.getRenderView() != null) goto L10;
        return null;
    L10:
        return r0.getRenderView().getBitmap();
    L11:
        return null;
    }

    public y4() {
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Bitmap call() throws Exception {
        return call();
    }
}
