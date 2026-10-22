package com.bytedance.android.live.platformplayer;

import android.content.Context;
import com.bytedance.android.live.platformplayer.api.ILivePlayViewProvider;
import com.bytedance.android.livesdk.chatroom.ui.InteractPlayViewManager;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/platformplayer/LivePlayViewProvider;", "Lcom/bytedance/android/live/platformplayer/api/ILivePlayViewProvider;", "()V", "getInteractPlayView", "Lcom/bytedance/android/livesdkapi/util/IInteractPlayView;", "context", "Landroid/content/Context;", "platform-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayViewProvider implements ILivePlayViewProvider {
    public LivePlayViewProvider() {
    }

    @Override // com.bytedance.android.live.platformplayer.api.ILivePlayViewProvider
    public IInteractPlayView getInteractPlayView(Context r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        return new InteractPlayViewManager(null, r3);
    }
}
