package com.bytedance.android.live.recharge.panel;

import com.bytedance.android.live.recharge.utils.j;
import com.bytedance.android.live.recharge.utils.t;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final boolean a = false;
    public static final String b = null;
    public static final boolean c = false;

    static {
        ReadOnlyProperty r0 = j.z;
        KProperty[] r1 = j.a;
        a = ((zx.a) r0.getValue(null, r1[23])).a();
        String r2 = ((zx.a) r0.getValue(null, r1[23])).b();
        if (r2 != null) goto L5;
        r2 = zx.a.b;
    L5:
        b = r2;
        c = t.a().M5();
    }
}
