package com.bytedance.android.live.profit.vote.transfer;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements Action {
    public final /* synthetic */ jy0.a a;

    public e(jy0.a r1) {
        this.a = r1;
    }

    public final void run() {
        this.a.k("VoteApiClient", "complete");
    }
}
