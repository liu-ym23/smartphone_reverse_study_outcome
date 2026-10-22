package com.ss.android.lark.officesdk.minutes.service.foundation.utils;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    static {
    }

    public static String a() {
        yob.e.a().getClass();     // Catch: Exception -> L10
        int r1 = com.ss.android.lark.language.service.impl.a.f;     // Catch: Exception -> L10
        apb.b r2 = com.ss.android.lark.language.service.impl.a.b.a;     // Catch: Exception -> L10
        Locale r3 = r2.getLanguageSetting();     // Catch: Exception -> L10
        if (r3 == null) goto L6;
        String r4 = r2.d(r3);     // Catch: Exception -> L10
    L7:
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L10
        return r4;
    L6:
        r4 = "en_US";
    L13:
        return "en_US";
    }
}
