package com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ DynamicTeamFightViewManager a;

    public b(DynamicTeamFightViewManager r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        DynamicTeamFightViewManager r8 = this.a;
        long r0 = r8.j;
        long r2 = 0;
        if (r0 <= 0) goto L5;
        r2 = r0 - 1;
    L6:
        r8.j = r2;
        DynamicTeamFightViewManager r9 = this.a;
        r9.f.b(r9.j);
        return;
    L5:
        ALogger.e("DynamicTeamFightViewManager", "fight countdown time is up");
        goto L6
    }
}
