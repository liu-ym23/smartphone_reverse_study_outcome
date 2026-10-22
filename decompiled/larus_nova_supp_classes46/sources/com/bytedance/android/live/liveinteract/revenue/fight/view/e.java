package com.bytedance.android.live.liveinteract.revenue.fight.view;

import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ TeamFightTitleLayout a;

    public e(TeamFightTitleLayout r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        UserAttr r5 = (UserAttr) r4;
        TeamFightTitleLayout r0 = this.a;
        Boolean r1 = m.i().isAnchor();
        boolean r2 = false;
        if (r1 == null) goto L5;
        boolean r3 = r1.booleanValue();
    L6:
        if (r3 == true) goto L9;
        boolean r6 = com.bytedance.android.live.liveinteract.utils.e.a;
        if (com.bytedance.android.live.liveinteract.utils.e.c(r5.getAdminPrivileges()) == true) goto L9;
    L10:
        r0.b = r2;
        StringBuilder r7 = new StringBuilder("：administrator：");
        r7.append(this.a.b);
        r7.append(", ");
        TeamFightContext.a r8 = TeamFightContext.Companion;
        r7.append(r8.d());
        ALogger.i("TeamFightTitleLayout", r7.toString());
        if (r8.d() == false) goto L14;
        this.a.a();
        return;
    L14:
        return;
    L9:
        r2 = true;
        goto L10
    L5:
        r3 = false;
        goto L6
    }
}
