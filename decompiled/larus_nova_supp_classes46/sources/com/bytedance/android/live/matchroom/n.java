package com.bytedance.android.live.matchroom;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n<T> implements Consumer {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        MatchRoomLandScapeAnimUtil.b();
    }
}
