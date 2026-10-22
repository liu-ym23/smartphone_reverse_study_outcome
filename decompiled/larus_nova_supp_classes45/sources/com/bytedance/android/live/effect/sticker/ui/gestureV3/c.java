package com.bytedance.android.live.effect.sticker.ui.gestureV3;

import com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements IIsTagNeedUpdatedListener {
    public final /* synthetic */ LiveGestureMagicAdapterVCD.a a;

    public final void onTagNeedNotUpdate() {
        this.a.e.setVisibility(8);
    }

    public final void onTagNeedUpdate() {
        this.a.e.setVisibility(0);
    }

    public c(LiveGestureMagicAdapterVCD.a r1) {
        this.a = r1;
    }
}
