package com.bytedance.android.live.liveinteract.multiscene;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final List<f> a(a r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$fightPlayers");
        ArrayList r0 = new ArrayList();
        if (r6.getTeamInfos() == null) goto L21;
        List<j> r1 = r6.getTeamInfos();
        Intrinsics.checkNotNull(r1);
        if (r1.isEmpty() == true) goto L21;
        List<j> r7 = r6.getTeamInfos();
        Intrinsics.checkNotNull(r7);
        Iterator<j> r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L21;
        j r2 = r8.next();
        if (r2 == null) goto L9;
        List<f> r3 = r2.getPlayers();
        Intrinsics.checkNotNull(r3);
        Iterator<f> r4 = r3.iterator();
    L14:
        if (r4.hasNext() == false) goto L16;
        f r5 = r4.next();
        Intrinsics.checkNotNull(r5);
        r5.setServerTeamId(r2.getTeamId());
        goto L14
    L16:
        List r9 = r2.getPlayers();
        if (r9 == null) goto L19;
        List r10 = r9;
    L20:
        r0.addAll(r10);
        goto L9
    L19:
        r10 = new ArrayList();
    L21:
        return r0;
    }

    public static final f b(a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$getPlayerByUserId");
        Intrinsics.checkNotNullParameter(r3, "userId");
        Iterator r4 = ((ArrayList) a(r2)).iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        f r0 = (f) r4.next();
        if (r0 == null) goto L4;
        if (Intrinsics.areEqual(r0.getUserIdString(), r3) == false) goto L4;
        return r0;
    L10:
        return null;
    }

    public static final int c(a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$getUserTeamId");
        Intrinsics.checkNotNullParameter(r3, "userId");
        if (r2.getTeamInfos() == null) goto L16;
        List<j> r0 = r2.getTeamInfos();
        Intrinsics.checkNotNull(r0);
        if (r0.isEmpty() == true) goto L24;
        List<j> r4 = r2.getTeamInfos();
        Intrinsics.checkNotNull(r4);
        Iterator<j> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L25;
        j r1 = r5.next();
        if (r1 == null) goto L9;
        if (k.a(r1, r3) == null) goto L9;
        return (int) r1.getTeamId();
    L25:
        return 0;
    L24:
        return 0;
    L16:
        return 0;
    }
}
