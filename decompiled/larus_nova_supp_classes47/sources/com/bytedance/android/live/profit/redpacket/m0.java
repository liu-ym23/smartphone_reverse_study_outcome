package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m0<T> implements Consumer {
    public final /* synthetic */ RedPacketIconModelLoadService a;

    public m0(RedPacketIconModelLoadService r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if ((!((List) r2).isEmpty()) == false) goto L6;
        this.a.c(null);
        return;
    }
}
