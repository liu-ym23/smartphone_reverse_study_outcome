package com.ss.android.lark.officewebview.util;

import android.content.Context;
import android.webkit.WebSettings;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        String r8 = WebSettings.getDefaultUserAgent(r7.getApplicationContext());     // Catch: Exception -> L5
    L6:
        StringBuffer r0 = new StringBuffer();
        if (r8 == null) goto L19;
        int r1 = r8.length();
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L19;
        char r4 = r8.charAt(r3);
        if (Intrinsics.compare(r4, 31) > 0) goto L13;
    L16:
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        r0.append(String.format("\\u%04x", Arrays.copyOf(new Object[]{Integer.valueOf(r4)}, 1)));
    L17:
        r3 = r3 + 1;
        goto L9
    L13:
        if (Intrinsics.compare(r4, 127) >= 0) goto L16;
        r0.append(r4);
    L19:
        return r0.toString();
    L5:
        r8 = System.getProperty("http.agent");
        goto L6
    }
}
