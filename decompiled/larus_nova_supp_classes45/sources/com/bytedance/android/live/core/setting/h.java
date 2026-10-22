package com.bytedance.android.live.core.setting;

import android.content.SharedPreferences;
import com.bytedance.android.livesdkapi.setting.HostSettingKey;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public static SharedPreferences a;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T> T a(HostSettingKey r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "defaultValue");
        if (a == null) goto L5;
    L7:
        SharedPreferences r0 = a;
        if (r0 == null) goto L33;
        String r5 = r3.getKey();
        if ((r4 instanceof Boolean) == false) goto L15;
        return (T) Boolean.valueOf(r0.getBoolean(r5, ((Boolean) r4).booleanValue()));
    L15:
        if ((r4 instanceof Integer) == false) goto L19;
        return (T) Integer.valueOf(r0.getInt(r5, ((Integer) r4).intValue()));
    L19:
        if ((r4 instanceof Long) == false) goto L23;
        return (T) Long.valueOf(r0.getLong(r5, ((Long) r4).longValue()));
    L23:
        if ((r4 instanceof Float) == false) goto L27;
        return (T) Float.valueOf(r0.getFloat(r5, ((Float) r4).floatValue()));
    L27:
        if ((r4 instanceof String) == false) goto L33;
        T r6 = (T) r0.getString(r5, (String) r4);
        if (r6 == null) goto L32;
        return r6;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type T");     // Catch: Exception -> L34
    L33:
        return r4;
    L5:
        if (jc1.a.b() == null) goto L7;
        a = jc1.a.b().getSharedPreferences("ttlive_open_sdk_shared_pref_cache_host", 0);
        goto L7
    }
}
