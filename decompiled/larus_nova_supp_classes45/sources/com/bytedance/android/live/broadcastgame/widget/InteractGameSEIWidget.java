package com.bytedance.android.live.broadcastgame.widget;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/widget/InteractGameSEIWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractGameSEIWidget extends LiveRecyclableWidget {
    public com.bytedance.android.live.pushstream.d a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r1) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r1) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.a = null;
    }

    public InteractGameSEIWidget(com.bytedance.android.live.pushstream.d r1) {
        this.a = r1;
    }
}
