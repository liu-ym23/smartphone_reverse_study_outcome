package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import android.net.Uri;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "schema");
        Intrinsics.checkNotNullParameter(r9, "pageFrom");
        Uri r0 = UriProtector.parse(r8);
        Uri.Builder r1 = r0.buildUpon();
        Set<String> r3 = r0.getQueryParameterNames();     // Catch: Exception -> L16 Throwable -> L21
        Uri.Builder r4 = r0.buildUpon().clearQuery();     // Catch: Exception -> L16 Throwable -> L21
        Iterator<String> r5 = r3.iterator();     // Catch: Exception -> L16 Throwable -> L21
    L4:
        if (r5.hasNext() == false) goto L15;
        String r6 = r5.next();     // Catch: Exception -> L16 Throwable -> L21
        if (Intrinsics.areEqual(r6, "url") == false) goto L12;
        String r7 = r0.getQueryParameter(r6);     // Catch: Exception -> L16 Throwable -> L21
        if (r7 == null) goto L11;
        String r10 = b(r7, "page_from", r9);     // Catch: Exception -> L16 Throwable -> L21
    L13:
        r4.appendQueryParameter(r6, r10);     // Catch: Exception -> L16 Throwable -> L21
        goto L4
    L11:
        r10 = null;
        goto L13
    L12:
        r10 = r0.getQueryParameter(r6);     // Catch: Exception -> L16 Throwable -> L21
        goto L13
    L15:
        Uri r11 = r4.build();
    L20:
        return r11.toString();
    L16:
        e = move-exception;
        SafetyGuard.a(null, e, "origin schema is " + r8);     // Catch: Throwable -> L21
    L18:
        r11 = r1.build();
        goto L20
    }

    public static String b(String r7, String r8, String r9) {
        Uri r0 = UriProtector.parse(r7);
        Uri.Builder r1 = r0.buildUpon();
        Set<String> r2 = r0.getQueryParameterNames();     // Catch: Exception -> L15 Throwable -> L20
        Uri.Builder r3 = r0.buildUpon().clearQuery();     // Catch: Exception -> L15 Throwable -> L20
        Iterator<String> r4 = r2.iterator();     // Catch: Exception -> L15 Throwable -> L20
    L5:
        if (r4.hasNext() == false) goto L12;
        String r5 = r4.next();     // Catch: Exception -> L15 Throwable -> L20
        if (Intrinsics.areEqual(r5, r8) == false) goto L9;
        String r6 = r9;
    L10:
        r3.appendQueryParameter(r5, r6);     // Catch: Exception -> L15 Throwable -> L20
        goto L5
    L9:
        r6 = r0.getQueryParameter(r5);     // Catch: Exception -> L15 Throwable -> L20
        goto L10
    L12:
        if (r2.contains(r8) == true) goto L14;
        r3.appendQueryParameter(r8, r9);     // Catch: Exception -> L15 Throwable -> L20
    L14:
        Uri r10 = r3.build();
    L19:
        return r10.toString();
    L15:
        e = move-exception;
        SafetyGuard.a(null, e, "real schema is " + r7);     // Catch: Throwable -> L20
    L17:
        r10 = r1.build();
        goto L19
    }
}
