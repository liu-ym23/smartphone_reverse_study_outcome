package com.bytedance.android.live.liveinteract.revenue.fight.view;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ TeamFightPKProgressLayout a;

    public c(TeamFightPKProgressLayout r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        UtilityKotlinExtentionsKt.t(this.a.z);
        this.a.i = false;
    }
}
