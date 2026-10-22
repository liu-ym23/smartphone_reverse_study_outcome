package com.bytedance.android.live.liveinteract.plantform.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class _InviteSearchData_ProtoDecoder implements am3.c<InviteSearchData> {
    public _InviteSearchData_ProtoDecoder() {
    }

    public static InviteSearchData decodeStatic(am3.g r6) throws Exception {
        InviteSearchData r0 = new InviteSearchData();
        r0.setThreadSafe(false);
        r0.mPlayerInfo = new ArrayList();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L9;
        am3.g.a r4 = r0.decodeExtensionFields(r3, r6);
        if (r3 != 1) goto L7;
        r0.mPlayerInfo.add(g1.a(r6));
        goto L3
    L7:
        am3.h.d(r4, r6);
        goto L3
    L9:
        r6.d(r1);
        r0.setThreadSafe(true);
        return r0;
    }

    public final InviteSearchData decode(am3.g r1) throws Exception {
        return decodeStatic(r1);
    }

    /* JADX INFO: renamed from: decode, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m258decode(am3.g r1) throws Exception {
        return decode(r1);
    }
}
