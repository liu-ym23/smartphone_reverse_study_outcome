package com.larus.uaigc.createpage.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(com.larus.bmhome.resource.access.a0.e r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        String r0 = r5.b;
        switch(r0.hashCode()) {
            case -2109015642: goto L42;
            case -2105443597: goto L39;
            case -1723259401: goto L36;
            case -1421272810: goto L33;
            case -934348968: goto L30;
            case -805388692: goto L27;
            case 94416770: goto L24;
            case 224030908: goto L21;
            case 227665410: goto L18;
            case 258330299: goto L15;
            case 576581451: goto L12;
            case 924905569: goto L9;
            case 1392426448: goto L6;
            default: goto L43;
        };
    L43:
        int r6 = r5.a.getOrder();
        boolean r1 = true;
        if (r6 < 0) goto L47;
        if (r6 >= 20) goto L47;
        boolean r3 = true;
    L48:
        if (r3 == false) goto L51;
    L49:
        return 8;
    L51:
        if (20 > r6) goto L54;
        if (r6 >= 30) goto L54;
        boolean r4 = true;
    L55:
        if (r4 == false) goto L58;
        return 20;
    L58:
        if (30 > r6) goto L61;
        if (r6 >= 40) goto L61;
        boolean r7 = true;
    L62:
        if (r7 == false) goto L65;
    L63:
        return 35;
    L65:
        if (40 > r6) goto L68;
        if (r6 >= 50) goto L68;
        boolean r2 = true;
    L69:
        if (r2 == false) goto L72;
    L70:
        return 45;
    L72:
        if (50 > r6) goto L75;
        if (r6 >= 60) goto L75;
        boolean r8 = true;
    L76:
        if (r8 == false) goto L78;
    L77:
        return 85;
    L78:
        if (60 <= r6) goto L80;
    L82:
        r1 = false;
    L83:
        if (r1 == false) goto L85;
    L84:
        return 95;
    L85:
        return 98;
    L80:
        if (r6 >= 70) goto L82;
    L75:
        r8 = false;
    L68:
        r2 = false;
    L61:
        r7 = false;
    L54:
        r4 = false;
    L47:
        r3 = false;
        goto L48
    L6:
        if (r0.equals("post_process") == true) goto L84;
    L9:
        if (r0.equals("remote_download") == false) goto L43;
        return 20;
    L12:
        if (r0.equals("remote_policy") == false) goto L43;
        return 20;
    L15:
        if (r0.equals("remote_fallback") == false) goto L43;
        return 20;
    L18:
        if (r0.equals("remote_direct") == true) goto L85;
    L21:
        if (r0.equals("remote_detect") == true) goto L63;
    L24:
        if (r0.equals("cache") == true) goto L85;
    L27:
        if (r0.equals("preprocess") == false) goto L43;
        return 20;
    L30:
        if (r0.equals("review") == true) goto L77;
    L33:
        if (r0.equals("validate") == false) goto L43;
    L36:
        if (r0.equals("local_detect") == true) goto L63;
    L39:
        if (r0.equals("remote_resolve") == false) goto L43;
        return 20;
    L42:
        if (r0.equals("sdk_upload") == true) goto L70;
        goto L43
    }

    public static int b(Long r8) {
        if (r8 == null) goto L4;
        long r0 = r8.longValue();
    L6:
        return ((((int) RangesKt.coerceIn(r0, 0, 100)) * 30) / 100) + 45;
    L4:
        r0 = 0;
        goto L6
    }
}
