package com.bytedance.android.livesdk.chatroom.vs.player.tips.impl;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerTipsContext;
import com.bytedance.android.livesdk.chatroom.progress.context.a;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VSPlayerTipServiceImpl implements b {
    public final Lazy a;
    public final String b;

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.b
    public final PlayerTipsContext provideVSPlayTipsContext() {
        return (PlayerTipsContext) this.a.getValue();
    }

    public VSPlayerTipServiceImpl() {
        this.a = LazyKt.lazy(VSPlayerTipServiceImpl$mContext$2.INSTANCE);
        this.b = "IVSPlayerTipService[" + hashCode() + ']';
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.b
    public final void hidePlayerTip(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        ALogger.d(this.b, "start post hide event for " + r4);
        ((PlayerTipsContext) this.a.getValue()).getMHidePlayerTipEvent().post(r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.b
    public final void showPlayerTipWithCustomView(String r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "view");
        a r0 = new a(r3, r4);
        ALogger.d(this.b, "start post show custom tip for ".concat(r3));
        ((PlayerTipsContext) this.a.getValue()).getMShowPlayerTipEvent().post(r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.b
    public final void showPlayerTip(String r8, CharSequence r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r9, "content");
        a r0 = new a(r8, 0, r9, null, r10);
        ALogger.d(this.b, "start post show default tip for ".concat(r8));
        ((PlayerTipsContext) this.a.getValue()).getMShowPlayerTipEvent().post(r0);
    }
}
