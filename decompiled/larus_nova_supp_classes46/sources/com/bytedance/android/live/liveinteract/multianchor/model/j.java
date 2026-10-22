package com.bytedance.android.live.liveinteract.multianchor.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements am3.c<ListUserContent> {
    public j() {
    }

    public static ListUserContent a(am3.g r6) throws Exception {
        ListUserContent r0 = new ListUserContent();
        r0.setThreadSafe(false);
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L12;
        am3.g.a r4 = r0.decodeExtensionFields(r3, r6);
        if (r3 != 2) goto L8;
        r0.linkmicContent = (ListUserLinkmicContent) vh7.f.a(r6, ListUserLinkmicContent.class);
        goto L3
    L8:
        if (r3 != 3) goto L9;
        r0.mLinkmicAudienceContent = (ListUserLinkmicAudienceContent) vh7.f.a(r6, ListUserLinkmicAudienceContent.class);
        goto L3
    L9:
        am3.h.d(r4, r6);
        goto L3
    L12:
        r6.d(r1);
        r0.setThreadSafe(true);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
