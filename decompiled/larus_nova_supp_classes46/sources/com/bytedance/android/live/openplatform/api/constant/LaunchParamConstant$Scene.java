package com.bytedance.android.live.openplatform.api.constant;

import com.bytedance.android.live.openplatform.api.utils.f;
import kjc.a;
import kjc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LaunchParamConstant$Scene {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;
    public static final String d = null;

    static {
        c r0 = new c();
        if (2 != a.a()) goto L6;
        r0.a.a = "103009";
        r0.b = true;
    L6:
        if (3 != a.a()) goto L8;
        r0.a.a = "233039";
        r0.b = true;
    L8:
        f.a(r0, LaunchParamConstant$Scene$ANCHOR$1$3.INSTANCE);
        if (r0.b == true) goto L11;
        r0.a.a = "023009";
    L11:
        a = (String) r0.a.a;
        c r1 = new c();
        if (2 != a.a()) goto L15;
        r1.a.a = "103010";
        r1.b = true;
    L15:
        if (3 != a.a()) goto L17;
        r1.a.a = "233010";
        r1.b = true;
    L17:
        f.a(r1, LaunchParamConstant$Scene$AUDIENCE$1$3.INSTANCE);
        if (r1.b == true) goto L20;
        r1.a.a = "023010";
    L20:
        b = (String) r1.a.a;
        c r2 = new c();
        if (2 != a.a()) goto L24;
        r2.a.a = "103010";
        r2.b = true;
    L24:
        if (3 != a.a()) goto L26;
        r2.a.a = "231002";
        r2.b = true;
    L26:
        f.a(r2, LaunchParamConstant$Scene$LIVE_SHARE_AUDIENCE$1$3.INSTANCE);
        if (r2.b == true) goto L29;
        r2.a.a = "023010";
    L29:
        c = (String) r2.a.a;
        c r3 = new c();
        if (2 != a.a()) goto L32;
        r3.a.a = "105001";
        r3.b = true;
    L32:
        f.a(r3, LaunchParamConstant$Scene$LIVE_AD_AUDIENCE$1$2.INSTANCE);
        if (r3.b == true) goto L35;
        r3.a.a = "025001";
    L35:
        d = (String) r3.a.a;
    }
}
