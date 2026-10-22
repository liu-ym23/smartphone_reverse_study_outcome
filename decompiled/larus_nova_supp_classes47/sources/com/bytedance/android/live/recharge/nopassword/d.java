package com.bytedance.android.live.recharge.nopassword;

import com.bytedance.android.live.recharge.model.NoPasswordFansConfig;
import com.bytedance.android.live.recharge.utils.t;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final c a = null;

    static {
        ReadOnlyProperty r1 = t.g;
        KProperty[] r2 = t.a;
        a = new c(((Boolean) r1.getValue(null, r2[5])).booleanValue(), ((Number) t.f.getValue(null, r2[4])).longValue(), ((Number) t.h.getValue(null, r2[6])).longValue(), ((Boolean) t.d.getValue(null, r2[2])).booleanValue(), ((Number) t.c.getValue(null, r2[1])).longValue(), (NoPasswordFansConfig) t.j.getValue(null, r2[8]));
    }
}
