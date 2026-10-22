package com.bytedance.android.live.profit.fansclub.transfer;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.t;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.fansclub.FansClubUserStatus;
import com.bytedance.android.live.profit.fansclub.GuardStatus;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m {
    public static final com.bytedance.android.live.profit.fansclub.b c(py.h r9) {
        Intrinsics.checkNotNullParameter(r9, "$this$toFansClubData");
        String r1 = r9.getClubName();
        String r2 = "";
        if (r1 != null) goto L5;
        String r3 = "";
    L6:
        int r4 = r9.getLevel();
        com.bytedance.android.live.profit.fansclub.j r5 = a(r9.getUserFansClubStatus(), r9.getUserGuardStatus());
        u r6 = r9.getBadge();
        com.bytedance.android.live.profit.fansclub.m r7 = null;
        if (r6 == null) goto L15;
        Intrinsics.checkNotNullParameter(r6, "$this$toFansClubBadge");
        py.k r8 = r6.getToShowIcon();
        if (r8 == null) goto L15;
        String r10 = r6.getTitle();
        if (r10 == null) goto L14;
        r2 = r10;
    L14:
        com.bytedance.android.live.profit.fansclub.a r12 = new com.bytedance.android.live.profit.fansclub.a(r2, r8);
    L17:
        if (r9.getUserGuardStatus() <= 0) goto L20;
        r7 = new com.bytedance.android.live.profit.fansclub.m(r9.getUserGuardStatus(), r9.getGuardExpiredTime(), 6);
    L20:
        return new com.bytedance.android.live.profit.fansclub.b(r3, r4, r5, r12, r7);
    L15:
        r12 = null;
        goto L17
    L5:
        r3 = r1;
        goto L6
    }

    public static final com.bytedance.android.live.profit.fansclub.e d(n r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$toFansClubParticipateIncentive");
        String r0 = s1.B(2131917125);
        o r1 = r4.participateIncentive;
        if (r1 == null) goto L12;
        String r2 = r1.getAwardUnit();
        if (r2 == null) goto L12;
        if ((!TextUtils.isEmpty(r2)) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
        r0 = r2;
    L12:
        o r5 = r4.participateIncentive;
        if (r5 == null) goto L15;
        long r3 = r5.getGoldCoinsCount();
    L17:
        return new com.bytedance.android.live.profit.fansclub.e(r3, r0, 4);
    L15:
        r3 = 0;
        goto L17
    }

    public static final com.bytedance.android.live.profit.fansclub.g e(t r6) {
        py.h r1 = r6.getData();
        com.bytedance.android.live.profit.fansclub.b r2 = null;
        if (r1 == null) goto L5;
        com.bytedance.android.live.profit.fansclub.b r3 = c(r1);
    L6:
        Map r4 = r6.getPreferData();
        if (r4 == null) goto L11;
        py.h r5 = (py.h) r4.get(0);
        if (r5 == null) goto L11;
        com.bytedance.android.live.profit.fansclub.b r7 = c(r5);
    L12:
        Map r8 = r6.getPreferData();
        if (r8 == null) goto L18;
        py.h r9 = (py.h) r8.get(1);
        if (r9 == null) goto L18;
        r2 = c(r9);
    L18:
        return new com.bytedance.android.live.profit.fansclub.g(r3, r7, r2, true);
    L11:
        r7 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public static final com.bytedance.android.live.profit.fansclub.j a(int r3, int r4) {
        FansClubUserStatus.Companion.getClass();
        FansClubUserStatus r1 = FansClubUserStatus.Active;
        if (r3 == r1.getValue()) goto L9;
        r1 = FansClubUserStatus.Inactive;
        if (r3 == r1.getValue()) goto L9;
        r1 = FansClubUserStatus.Unknown;
    L9:
        GuardStatus.Companion.getClass();
        GuardStatus r5 = GuardStatus.NoGuard;
        if (r4 == r5.getValue()) goto L20;
        r5 = GuardStatus.ActiveGuard;
        if (r4 == r5.getValue()) goto L20;
        r5 = GuardStatus.InactiveGuard;
        if (r4 == r5.getValue()) goto L20;
        r5 = GuardStatus.NotParticipateGuard;
    L20:
        return new com.bytedance.android.live.profit.fansclub.j(r1, r5);
    }

    public static final com.bytedance.android.live.profit.fansclub.b b(n r8, com.bytedance.android.live.profit.fansclub.b r9) {
        Intrinsics.checkNotNullParameter(r8, "$this$toFansClubData");
        p r10 = r8.userFansClubInfo;
        com.bytedance.android.live.profit.fansclub.a r0 = null;
        if (r10 == null) goto L12;
        String r1 = r10.clubName;
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        String r2 = r1;
        int r3 = r10.level;
        com.bytedance.android.live.profit.fansclub.j r4 = a(r10.status, 0);
        if (r9 == null) goto L11;
        r0 = r9.d;
    L11:
        return new com.bytedance.android.live.profit.fansclub.b(r2, r3, r4, r0, null);
    L12:
        return null;
    }
}
