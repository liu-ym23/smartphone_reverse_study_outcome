package com.bytedance.android.livesdk.interactivity.api.base.utils;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.liveinteract.f;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ss1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class InteractivityOpt {
    public static final boolean a = false;
    public static final boolean b = false;
    public static final boolean c = false;
    public static final Map<SettingKey<?>, Object> d = null;
    public static final Map<Integer, Integer> e = null;
    public static final Map<Float, Integer> f = null;

    static {
        e r0 = (e) f.a.getValue();
        boolean r1 = r0.c();
        a = r1;
        boolean r2 = false;
        if (r1 == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        b = r4;
        if (r1 == true) goto L11;
    L13:
        c = r2;
        d = new HashMap();
        new HashMap();
        e = new HashMap();
        new HashMap();
        f = new HashMap();
        return;
    L11:
        if (r0.a() == false) goto L13;
        r2 = true;
        goto L13
    L5:
        if (r0.b() == false) goto L7;
        r4 = true;
        goto L8
    }

    @JvmStatic
    public static final int a(final float r3) {
        Float r0 = Float.valueOf(r3);
        Function0<Integer> r1 = new InteractivityOpt$cachedDp2Px$1(r3);
        Map<Float, Integer> r4 = f;
        if (a == true) goto L5;
        Object r5 = r1.invoke();
    L10:
        return ((Number) r5).intValue();
    L5:
        HashMap r6 = (HashMap) r4;
        Object r2 = r6.get(r0);
        if (r2 != null) goto L8;
        Object r7 = r1.invoke();
        r6.put(r0, r7);
        r5 = r7;
        goto L10
    L8:
        r5 = r2;
        goto L10
    }

    @JvmStatic
    public static final <T> T c(SettingKey<T> r3) {
        Intrinsics.checkNotNullParameter(r3, com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_SETTING);
        if (a == false) goto L12;
        Map<SettingKey<?>, Object> r0 = d;
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
    public static final int b(int r2, Function0<Integer> r3) {
        Intrinsics.checkNotNullParameter(r3, "func");
        Integer r4 = Integer.valueOf(r2);
        Map<Integer, Integer> r0 = e;
        if (a == true) goto L5;
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
