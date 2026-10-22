package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.livesdk.i7;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.PersonalizedDisplayInfo;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n {
    public static final boolean a = false;

    static {
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        a = r0;
        return;
    L5:
        if (((Boolean) i7.a.getValue()).booleanValue() == false) goto L7;
        r0 = true;
        goto L8
    }

    @JvmStatic
    public static final String a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "message");
        IPublicAreaCommon r2 = r1.v();
        if (r2 == null) goto L7;
        PersonalizedDisplayInfo r3 = r2.getPersonalizedInfo();
        if (r3 == null) goto L7;
        Boolean r4 = r3.isPersonalized();
    L9:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L12;
        return "个性化";
    L12:
        return "非个性化";
    L7:
        r4 = null;
        goto L9
    }

    @JvmStatic
    public static final void b(Function0<String> r1) {
        Intrinsics.checkNotNullParameter(r1, "log");
        if (a == false) goto L6;
        String r2 = (String) r1.invoke();
        return;
    }
}
