package com.bytedance.android.live.revlink.impl.control;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final void accept(Object r6) {
        ExtraResponse r7 = (ExtraResponse) r6;
        if (r7 == null) goto L5;
        com.bytedance.android.livesdk.link.model.g r1 = (com.bytedance.android.livesdk.link.model.g) r7.data;
    L6:
        if (r1 == null) goto L14;
        com.bytedance.android.livesdk.link.model.g r8 = (com.bytedance.android.livesdk.link.model.g) r7.data;
        if (r8 == null) goto L10;
        com.bytedance.android.livesdk.link.model.h r9 = r8.getAnchorBattleUserSettings();
    L11:
        if (r9 == null) goto L15;
        l51.a.x(r9.isTurnOn());
        l51.a.P(r9.getAllowGiftToOtherAnchorsInPK());
        l51.a.s(r9.getAcceptFollowedInvite());
        l51.a.u(r9.getAcceptPopularityRankInvite());
        l51.a.t(r9.getAcceptHourlyRankInvite());
        l51.a.w(r9.getAcceptNotFollowerInvite());
        l51.a.y(r9.getPkAutoConfirm());
        l51.a.D.setValue(null, l51.a.a[29], Boolean.valueOf(r9.getPkAcceptVolumeUp()));
        l51.a.K(r9.getAutoStartPropCard());
        l51.a.z(r9.getAllowGiftToOtherAnchorsInLinkmic());
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
