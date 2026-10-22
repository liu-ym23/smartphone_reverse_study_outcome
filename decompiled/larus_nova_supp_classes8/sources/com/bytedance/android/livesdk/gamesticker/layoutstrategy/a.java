package com.bytedance.android.livesdk.gamesticker.layoutstrategy;

import com.bytedance.android.livesdkapi.view.IRenderView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements IRenderView.LayoutListener {
    public final /* synthetic */ LiveFoldScreenFullLandscapeLayoutStrategy a;

    public a(LiveFoldScreenFullLandscapeLayoutStrategy r1) {
        this.a = r1;
    }

    public final void onLayoutReady(int r1, int r2, int r3, int r4) {
        this.a.c("on render layout change");
        LiveFoldScreenFullLandscapeLayoutStrategy.a(this.a);
    }
}
