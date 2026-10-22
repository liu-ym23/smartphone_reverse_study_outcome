package com.bytedance.android.livesdk.floatview;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g0<T> implements Consumer {
    public final /* synthetic */ VideoFloatWindowView a;

    public g0(VideoFloatWindowView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        if (jc1.k.n(IHostApp.class).isHostUnMutePlaying().booleanValue() == false) goto L10;
        ALogger.i("VideoFloatWindowView", "CheckAudioCollision: isHostUnMutePlaying");
        LivePlayerView r4 = this.a.getMLivePlayerView$livesdk_saasRelease();
        if (r4 == null) goto L11;
        ILivePlayerClient r5 = r4.getClient();
        if (r5 == null) goto L12;
        r5.mute("VideoFloatWindowView.startCheckAudioCollision");
        return;
    L12:
        return;
    L11:
        return;
    }
}
