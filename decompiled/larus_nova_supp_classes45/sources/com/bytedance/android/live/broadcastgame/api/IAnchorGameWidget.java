package com.bytedance.android.live.broadcastgame.api;

import android.view.Surface;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/IAnchorGameWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class IAnchorGameWidget extends LiveRecyclableWidget {
    public abstract void Aq();

    public abstract void Bq(String r1, String r2, int r3, boolean r4);

    public abstract void Cq();

    public abstract void Eq(String r1);

    public abstract void Fq();

    public abstract String wq();

    public abstract void xq();

    public abstract void yq(boolean r1, Surface r2, int r3);

    public abstract void zq(boolean r1);

    public IAnchorGameWidget() {
    }
}
