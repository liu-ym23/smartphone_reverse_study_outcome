package com.bytedance.android.live.liveinteract;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public static final SettingKey<ss1.e> a = null;
    public static final boolean b = false;
    public static final Map<SettingKey<?>, Object> c = null;
    public static final Map<Integer, String> d = null;
    public static final Map<Integer, Integer> e = null;

    static {
        SettingKey<ss1.e> r0 = new SettingKey("live_interactivity_opt_config", "互动体验优化配置", new ss1.e(), new ss1.e());
        a = r0;
        b = ((ss1.e) r0.getValue()).c();
        c = new HashMap();
        d = new HashMap();
        e = new HashMap();
        new HashMap();
        new HashMap();
    }

    @JvmStatic
    public static final <T> T b(SettingKey<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "setting");
        if (b == false) goto L12;
        Map<SettingKey<?>, Object> r0 = c;
        Object r1 = ((HashMap) r0).get(r3);
        if ((r1 instanceof Object) == true) goto L8;
        r1 = null;
    L8:
        if (r1 != null) goto L11;
        r1 = r3.getValue();
        ((HashMap) r0).put(r3, r1);
    L11:
        return (T) r1;
    L12:
        return (T) r3.getValue();
    }

    @JvmStatic
    public static final int a(int r2, Function0<Integer> r3) {
        Intrinsics.checkNotNullParameter(r3, "func");
        Integer r4 = Integer.valueOf(r2);
        Map<Integer, Integer> r0 = e;
        if (b == true) goto L5;
        Object r5 = r3.invoke();
    L10:
        return ((Number) r5).intValue();
    L5:
        HashMap r1 = (HashMap) r0;
        Object r6 = r1.get(r4);
        if (r6 != null) goto L8;
        Object r7 = r3.invoke();
        r1.put(r4, r7);
        r5 = r7;
        goto L10
    L8:
        r5 = r6;
        goto L10
    }
}
