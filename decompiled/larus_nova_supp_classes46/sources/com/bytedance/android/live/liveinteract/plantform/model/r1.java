package com.bytedance.android.live.liveinteract.plantform.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r1 implements am3.c<WaitingListUserInfo> {
    public r1() {
    }

    public final Object decode(am3.g r6) throws Exception {
        WaitingListUserInfo r0 = new WaitingListUserInfo();
        r0.setThreadSafe(false);
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L14;
        am3.g.a r4 = r0.decodeExtensionFields(r3, r6);
        switch(r3) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        r0.applyTimeSec = Long.valueOf(r6.j());
        goto L3
    L9:
        r0.fuzzyFanTicketStr = am3.h.c(r6);
        goto L3
    L10:
        r0.last7DaysGiftCountTxt = am3.h.c(r6);
        goto L3
    L11:
        r0.applyReason = am3.h.c(r6);
        goto L3
    L12:
        r0.isMutualFollow = am3.h.a(r6);
        goto L3
    L13:
        r0.hasExpired = am3.h.a(r6);
        goto L3
    L7:
        am3.h.d(r4, r6);
        goto L3
    L14:
        r6.d(r1);
        r0.setThreadSafe(true);
        return r0;
    }
}
