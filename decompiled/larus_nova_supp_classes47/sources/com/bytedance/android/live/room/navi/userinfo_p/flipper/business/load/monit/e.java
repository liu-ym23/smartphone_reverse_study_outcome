package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import s91.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ DoubleLikeDataMonitor a;

    public e(DoubleLikeDataMonitor r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        String r3 = (String) r2;
        ALogger.d("DoubleLikeDataMonitor", "移除双赞轮播标签");
        DoubleLikeDataMonitor r4 = this.a;
        r4.e((f) r4.j.getValue());
    }
}
