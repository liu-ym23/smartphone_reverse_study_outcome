package com.bytedance.android.livesdk.chatroom.ui.framework.utils;

import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final com.bytedance.android.livesdk.chatroom.ui.framework.a a(h70.b r1) {
        if (r1 == null) goto L6;
        IAbilityCenter r2 = r1.a();
        if (r2 == null) goto L6;
        return (com.bytedance.android.livesdk.chatroom.ui.framework.a) r2.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.a.class);
    L6:
        return null;
    }

    public static final boolean b(h70.b r1) {
        if ((r1 instanceof d90.d) == true) goto L5;
        r1 = null;
    L5:
        d90.d r2 = (d90.d) r1;
        if (r2 != null) goto L10;
        return false;
    L10:
        return r2.d;
    }

    public static final <T extends IAbility> void d(h70.b r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        if (r1 == null) goto L8;
        IAbilityCenter r3 = r1.a();
        if (r3 == null) goto L9;
        r3.unregisterAbility(r2);
        return;
    L9:
        return;
    }

    public static final <T extends IAbility> void c(h70.b r1, Class<T> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "ability");
        if (r1 == null) goto L8;
        IAbilityCenter r4 = r1.a();
        if (r4 == null) goto L9;
        r4.registerAbility(r2, r3);
        return;
    L9:
        return;
    }
}
