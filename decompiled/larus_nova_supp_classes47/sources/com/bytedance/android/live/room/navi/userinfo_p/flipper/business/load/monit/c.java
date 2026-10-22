package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import s91.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        String r3 = (String) r2;
        ALogger.d("DiggTemporaryDataMonitor", "notify remove diggTemporary");
        DiggTemporaryDataMonitor r4 = this.a.a;
        r4.e((f) r4.k.getValue());
    }
}
