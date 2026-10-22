package com.bytedance.android.live.liveinteract.plantform.model;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k1 implements am3.c<ListTag.ListTagFansClubContent> {
    public k1() {
    }

    public final Object decode(am3.g r12) throws Exception {
        ListTag.ListTagFansClubContent r0 = new ListTag.ListTagFansClubContent();
        r0.setThreadSafe(false);
        r0.icons = new HashMap();
        long r1 = r12.c();
    L3:
        int r3 = r12.f();
        if (r3 == (-1)) goto L26;
        am3.g.a r6 = r0.decodeExtensionFields(r3, r12);
        if (r3 != 1) goto L7;
        long r8 = r12.c();
        Integer r4 = null;
        py.k r7 = null;
    L11:
        int r10 = r12.f();
        if (r10 == (-1)) goto L18;
        if (r10 != 1) goto L14;
        r4 = Integer.valueOf(r12.i());
        goto L11
    L14:
        if (r10 != 2) goto L11;
        r7 = (py.k) vh7.f.a(r12, py.k.class);
        goto L11
    L18:
        r12.d(r8);
        if (r4 == null) goto L25;
        if (r7 == null) goto L23;
        r0.icons.put(r4, r7);
        goto L3
    L23:
        throw new IllegalStateException("Map value must not be null!");
    L25:
        throw new IllegalStateException("Map key must not be null!");
    L7:
        if (r3 != 2) goto L8;
        r0.clubName = am3.h.c(r12);
        goto L3
    L8:
        am3.h.d(r6, r12);
        goto L3
    L26:
        r12.d(r1);
        r0.setThreadSafe(true);
        return r0;
    }
}
