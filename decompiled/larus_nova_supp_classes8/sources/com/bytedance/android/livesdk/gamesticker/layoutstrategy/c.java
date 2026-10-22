package com.bytedance.android.livesdk.gamesticker.layoutstrategy;

import com.bytedance.android.livesdkapi.view.IRenderView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements IRenderView.LayoutListener {
    public final /* synthetic */ LiveFoldScreenLandscapeLayoutStrategy a;

    public c(LiveFoldScreenLandscapeLayoutStrategy r1) {
        this.a = r1;
    }

    public final void onLayoutReady(int r1, int r2, int r3, int r4) {
        this.a.c("on render layout change");
        LiveFoldScreenLandscapeLayoutStrategy.a(this.a);
    }
}
