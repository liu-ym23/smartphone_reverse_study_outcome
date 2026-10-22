package com.bytedance.android.live.effect.api;

import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdk.config.n21;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d0 {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;
    public static final String d = null;
    public static final String e = null;
    public static final String f = null;
    public static final String g = null;
    public static final String h = null;
    public static final String i = null;
    public static final String j = null;
    public static final String k = null;
    public static final String l = null;
    public static final Map<String, String> m = null;

    static {
        if (LiveEffectSettings.LIVE_ENABLE_NEW_GESTURE_DIALOG.getValue().booleanValue() == false) goto L8;
        int r0 = n21.a;
        if (n21.a.a() == false) goto L7;
        String r1 = s1.B(2131916394);
    L9:
        b = r1;
        int r2 = n21.a;
        if (n21.a.a() == false) goto L12;
        String r3 = s1.B(2131916397);
    L13:
        c = r3;
        d = "liveinteractiveeffect";
        if (n21.a.a() == false) goto L16;
        r3 = "live_guest_tab";
    L16:
        e = r3;
        f = "live_guest_activity";
        g = s1.B(2131916396);
        if (n21.a.a() == false) goto L19;
        int r4 = 2131916399;
    L20:
        h = s1.B(r4);
        j = s1.B(2131916387);
        s1.B(2131916386);
        if (n21.a.a() == false) goto L23;
        int r5 = 2131916388;
    L24:
        String r6 = s1.B(r5);
        i = r6;
        k = "makeupforever";
        if (n21.a.a() == false) goto L27;
        int r7 = 2131916391;
    L28:
        a = s1.B(r7);
        l = s1.B(2131916390);
        m = MapsKt.mapOf(new Pair[]{TuplesKt.to(r6, FileUtils.BEAUTY), TuplesKt.to("makeupforever", "makeups"), TuplesKt.to("livesoundeffect", "sound")});
        return;
    L27:
        r7 = 2131916393;
        goto L28
    L23:
        r5 = 2131916389;
        goto L24
    L19:
        r4 = 2131916400;
        goto L20
    L12:
        r3 = s1.B(2131916401);
        goto L13
    L7:
        r1 = s1.B(2131916395);
        goto L9
    L8:
        r1 = s1.B(2131916398);
        goto L9
    }
}
