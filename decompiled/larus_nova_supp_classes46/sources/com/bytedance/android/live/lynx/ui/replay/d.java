package com.bytedance.android.live.lynx.ui.replay;

import com.bytedance.android.livesdkapi.replay.IReplayPlayerHelper;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ ReplayVideoViewForLynx a;

    public d(ReplayVideoViewForLynx r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        IReplayPlayerHelper r3 = this.a.A;
        if (r3 == null) goto L6;
        r3.resolutionDegrade();
        return;
    }
}
