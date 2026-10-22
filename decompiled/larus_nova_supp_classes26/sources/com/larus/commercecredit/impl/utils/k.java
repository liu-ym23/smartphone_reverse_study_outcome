package com.larus.commercecredit.impl.utils;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public k() {
    }

    public static String a(Bundle r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter("", "defaultValue");
        if (r2 == null) goto L9;
        String r4 = r2.getString(r3, "");
        if (r4 != null) goto L8;
        return "";
    L8:
        return r4;
    L9:
        return "";
    }
}
