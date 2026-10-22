package com.bytedance.android.live.base.model;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u implements am3.c<Appointment> {
    public u() {
    }

    public static Appointment a(am3.g r11) throws Exception {
        Appointment r0 = new Appointment();
        r0.liveExtractsMap = new HashMap();
        long r1 = r11.c();
    L3:
        int r3 = r11.f();
        if (r3 == (-1)) goto L55;
        if (r3 != 5000) goto L8;
        r0.anchorOpenId = am3.h.c(r11);
        goto L3
    L8:
        if (r3 != 5001) goto L9;
        r0.anchorOpenIdStr = am3.h.c(r11);
        goto L3
    L9:
        switch(r3) {
            case 1: goto L52;
            case 2: goto L51;
            case 3: goto L50;
            case 4: goto L49;
            case 5: goto L48;
            case 6: goto L47;
            case 7: goto L46;
            case 8: goto L45;
            default: goto L10;
        };
    L45:
        r0.insidePushTitle = am3.h.c(r11);
        goto L3
    L46:
        r0.insidePushText = am3.h.c(r11);
        goto L3
    L47:
        r0.endTime = r11.j();
        goto L3
    L48:
        r0.startTime = r11.j();
        goto L3
    L49:
        r0.roomId = r11.j();
        goto L3
    L50:
        r0.anchorId = r11.j();
        goto L3
    L51:
        r0.appointmentType = (int) r11.j();
        goto L3
    L52:
        r0.appointmentId = r11.j();
        goto L3
    L10:
        switch(r3) {
            case 10: goto L44;
            case 11: goto L43;
            case 12: goto L42;
            case 13: goto L41;
            case 14: goto L40;
            case 15: goto L39;
            case 16: goto L38;
            case 17: goto L37;
            case 18: goto L36;
            case 19: goto L35;
            case 20: goto L34;
            case 21: goto L33;
            case 22: goto L15;
            case 23: goto L14;
            case 24: goto L13;
            case 25: goto L12;
            default: goto L11;
        };
    L12:
        r0.showStatus = (int) r11.j();
        goto L3
    L13:
        r0.isReserved = Boolean.valueOf(am3.h.a(r11));
        goto L3
    L14:
        r0.isLiving = Boolean.valueOf(am3.h.a(r11));
        goto L3
    L15:
        long r5 = r11.c();
        Long r4 = null;
        Appointment.LiveFragments r7 = null;
    L16:
        int r8 = r11.f();
        if (r8 == (-1)) goto L25;
        if (r8 != 1) goto L21;
        r4 = Long.valueOf(r11.j());
        goto L16
    L21:
        if (r8 != 2) goto L16;
        r7 = t.a(r11);
        goto L16
    L25:
        r11.d(r5);
        if (r4 == null) goto L32;
        if (r7 == null) goto L30;
        r0.liveExtractsMap.put(r4, r7);
        goto L3
    L30:
        throw new IllegalStateException("Map value must not be null!");
    L32:
        throw new IllegalStateException("Map key must not be null!");
    L33:
        r0.secAnchorId = am3.h.c(r11);
        goto L3
    L34:
        r0.programJumpUrl = am3.h.c(r11);
        goto L3
    L35:
        r0.coverImgUrl = am3.h.c(r11);
        goto L3
    L36:
        r0.subTitle = am3.h.c(r11);
        goto L3
    L37:
        r0.title = am3.h.c(r11);
        goto L3
    L38:
        r0.groupId = String.valueOf(r11.j());
        goto L3
    L39:
        r0.roomIdStr = am3.h.c(r11);
        goto L3
    L40:
        r0.anchorIdStr = am3.h.c(r11);
        goto L3
    L41:
        r0.appointmentIdStr = am3.h.c(r11);
        goto L3
    L42:
        r0.dueStartTime = String.valueOf(r11.j());
        goto L3
    L43:
        r0.operator = am3.h.c(r11);
        goto L3
    L44:
        r0.subscriberCount = (int) r11.j();
        goto L3
    L11:
        am3.h.e(r11);
        goto L3
    L55:
        r11.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
