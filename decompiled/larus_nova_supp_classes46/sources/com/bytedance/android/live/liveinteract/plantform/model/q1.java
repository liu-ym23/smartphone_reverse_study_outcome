package com.bytedance.android.live.liveinteract.plantform.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q1 implements am3.c<TeamFightJoinTeamInfo> {
    public q1() {
    }

    public static TeamFightJoinTeamInfo a(am3.g r6) throws Exception {
        TeamFightJoinTeamInfo r0 = new TeamFightJoinTeamInfo();
        r0.setThreadSafe(false);
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L9;
        am3.g.a r4 = r0.decodeExtensionFields(r3, r6);
        if (r3 != 1) goto L7;
        r0.teamId = r6.j();
        goto L3
    L7:
        am3.h.d(r4, r6);
        goto L3
    L9:
        r6.d(r1);
        r0.setThreadSafe(true);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
