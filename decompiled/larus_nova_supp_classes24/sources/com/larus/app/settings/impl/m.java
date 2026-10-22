package com.larus.app.settings.impl;

import android.content.SharedPreferences;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class m {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new l());
    }

    public static Integer a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        if (StringsKt.isBlank(r3) == false) goto L5;
        return null;
    L5:
        String r4 = "portrait_auth_status_".concat(r3);
        Lazy r0 = a;
        if (((SharedPreferences) r0.getValue()).contains(r4) == true) goto L8;
        return null;
    L8:
        return Integer.valueOf(((SharedPreferences) r0.getValue()).getInt(r4, 0));
    }
}
