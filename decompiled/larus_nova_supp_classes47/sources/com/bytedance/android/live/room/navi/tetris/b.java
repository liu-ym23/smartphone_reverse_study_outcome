package com.bytedance.android.live.room.navi.tetris;

import com.bytedance.android.livesdk.utils.g7;
import io.reactivex.functions.Consumer;
import zg1.q3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ AnchorRoomNavigatorTetris a;

    public b(AnchorRoomNavigatorTetris r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        if (((q3) r1) == null) goto L5;
        boolean r2 = g7.a;
        g7.a(this.a.L());
        return;
    L5:
        boolean r3 = g7.a;
        g7.b(this.a.L());
    }
}
