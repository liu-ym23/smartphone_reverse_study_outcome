package com.bytedance.android.live.revlink.impl.control;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final void accept(Object r6) {
        ExtraResponse r7 = (ExtraResponse) r6;
        if (r7 == null) goto L5;
        com.bytedance.android.livesdk.link.model.o r1 = (com.bytedance.android.livesdk.link.model.o) r7.data;
    L6:
        if (r1 == null) goto L14;
        com.bytedance.android.livesdk.link.model.o r8 = (com.bytedance.android.livesdk.link.model.o) r7.data;
        if (r8 == null) goto L10;
        com.bytedance.android.livesdk.link.model.u r9 = r8.getAnchorLinkmicUserSettings();
    L11:
        if (r9 == null) goto L15;
        boolean r2 = r9.isTurnOn();
        com.bytedance.tools.kcp.spongepreference.runtime.a r3 = l51.a.g;
        KProperty[] r4 = l51.a.a;
        r3.setValue(null, r4[6], Boolean.valueOf(r2));
        l51.a.P(r9.getAllowGiftToOtherAnchorsInPK());
        l51.a.h.setValue(null, r4[7], Boolean.valueOf(r9.getAcceptMultiAnchorLink()));
        l51.a.C(r9.getAcceptNotFollowerInvite());
        l51.a.A(r9.getAcceptFriendInvite());
        l51.a.B(r9.getAcceptHourlyRankInvite());
        l51.a.D(r9.getAcceptPopularityRankInvite());
        l51.a.E(r9.getAcceptRecommendSearchInvite());
        l51.a.F(r9.getAcceptBigLayout());
        l51.a.z(r9.getAllowGiftToOtherAnchorsInLinkmic());
        l51.a.L(r9.getAutoStartStealDragon());
        l51.a.v(r9.getAcceptFindPeopleInvite());
        return;
    L15:
        return;
    L10:
        r9 = null;
        goto L11
    L14:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
