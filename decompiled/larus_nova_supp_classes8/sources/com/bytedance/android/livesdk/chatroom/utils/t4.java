package com.bytedance.android.livesdk.chatroom.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t4 {
    static {
    }

    @JvmStatic
    public static final String a(String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "url");
        Intrinsics.checkNotNullParameter(r7, "key");
        Intrinsics.checkNotNullParameter(r8, "value");
        Uri r0 = UriProtector.parse(r6);     // Catch: Exception -> L18
        Set r1 = UriProtector.getQueryParameterNames(r0);     // Catch: Exception -> L18
        Uri.Builder r2 = r0.buildUpon().clearQuery();     // Catch: Exception -> L18
        Iterator r3 = r1.iterator();     // Catch: Exception -> L18
        boolean r4 = false;
    L5:
        if (r3.hasNext() == false) goto L14;
        String r5 = (String) r3.next();     // Catch: Exception -> L18
        if (Intrinsics.areEqual(r5, r7) == false) goto L10;
        r4 = true;
    L10:
        if (Intrinsics.areEqual(r5, r7) == false) goto L12;
        String r9 = r8;
    L13:
        r2.appendQueryParameter(r5, r9);     // Catch: Exception -> L18
        goto L5
    L12:
        r9 = UriProtector.getQueryParameter(r0, r5);     // Catch: Exception -> L18
        goto L13
    L14:
        if (r4 == true) goto L16;
        r2.appendQueryParameter(r7, r8);     // Catch: Exception -> L18
    L16:
        return r2.build().toString();
    L24:
        return r6;
    }
}
