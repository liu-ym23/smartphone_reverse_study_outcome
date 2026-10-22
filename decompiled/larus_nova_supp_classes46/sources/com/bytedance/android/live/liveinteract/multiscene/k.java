package com.bytedance.android.live.liveinteract.multiscene;

import com.bytedance.android.live.base.model.user.o0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k {
    public static final String b(j r3) {
        o0.a r0 = o0.a;
        Long r1 = Long.valueOf(r3.get_ownerId());
        String r4 = r3.get_ownerOpenId();
        r0.getClass();
        return o0.a.g(r1, r4);
    }

    public static final boolean c(j r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$hasPlayer");
        if (r1.getPlayers() == null) goto L7;
        List<f> r2 = r1.getPlayers();
        Intrinsics.checkNotNull(r2);
        if ((!r2.isEmpty()) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static final f a(j r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$getFightPlayerById");
        Intrinsics.checkNotNullParameter(r3, "userId");
        if (c(r2) == false) goto L12;
        List<f> r4 = r2.getPlayers();
        Intrinsics.checkNotNull(r4);
        Iterator<f> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L20;
        f r0 = r5.next();
        if (r0 == null) goto L6;
        if (Intrinsics.areEqual(r0.getUserIdString(), r3) == false) goto L6;
        return r0;
    L20:
        return null;
    L12:
        return null;
    }
}
