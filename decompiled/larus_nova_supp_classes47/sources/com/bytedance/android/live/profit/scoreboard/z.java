package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z implements Action {
    public final /* synthetic */ v.g a;

    public z(v.g r1) {
        this.a = r1;
    }

    public final void run() {
        this.a.c.setDragCallback(null);
    }
}
