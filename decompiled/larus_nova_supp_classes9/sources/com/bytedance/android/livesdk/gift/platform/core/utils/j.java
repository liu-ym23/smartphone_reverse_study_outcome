package com.bytedance.android.livesdk.gift.platform.core.utils;

import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public final boolean a;
    public final k b;
    public g0 c;
    public EffectMessage d;
    public long e;
    public long f;
    public long g;
    public int h;

    public static final class a {
    }

    static {
    }

    public j() {
        this.a = ((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.J.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[34])).booleanValue();
        this.b = new k();
    }

    public final void a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "endType");
        if (Intrinsics.areEqual(r8, "close_gift_jsb") == false) goto L9;
        if (this.g != 0) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r8, "unload") == false) goto L19;
        if (this.d != null) goto L13;
    L15:
        boolean r0 = false;
    L16:
        if (r0 == true) goto L19;
        return;
    L13:
        if (this.e <= 0) goto L15;
        r0 = true;
    L19:
        if (this.a == false) goto L37;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("play_times", String.valueOf(this.h));
        r1.put("total_play_time", String.valueOf(System.currentTimeMillis() - this.e));
        r1.put("lynx_init_time", String.valueOf(this.f - this.e));
        r1.put("lynx_loaded_time", String.valueOf(this.g - this.e));
        if (Intrinsics.areEqual(r8, "load_failed") == false) goto L24;
        String r4 = "1";
    L25:
        r1.put("lynx_load_failed", r4);
        r1.put("end_type", r8);
        if (Intrinsics.areEqual(r8, "load_failed") == false) goto L28;
        h.M(r1, this.d);
        goto L37
    L28:
        Map<String, String> r9 = this.b.b;
        if (r9 == null) goto L32;
        r1.putAll(r9);
        this.b.a();
    L32:
        if (this.c == null) goto L36;
        Map r10 = MapsKt.emptyMap();
        if (r10 == null) goto L36;
        r1.putAll(r10);
    L36:
        h.M(r1, this.d);
        goto L37
    L24:
        r4 = "0";
    L37:
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.b.a();
        this.c = null;
        Iterator r11 = da0.a.a.iterator();
    L39:
        if (r11.hasNext() == false) goto L41;
        ((ca0.p) r11.next()).t();
        goto L39
    }
}
