package com.bytedance.android.ec.core.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k2 {
    static {
    }

    @JvmStatic
    public static final String a(String r10, String r11) {
        if (r10 == null) goto L18;
        if (r11 == null) goto L19;
        Uri r1 = UriProtector.parse(r10);     // Catch: Exception -> L15
        String r0 = UriProtector.getQueryParameter(r1, com.bytedance.android.ec.core.event.a.KEY_LOG_DATA);     // Catch: Exception -> L15
        if (r0 != null) goto L8;
    L12:
        r0 = "{}";
    L13:
        JSONObject r12 = new JSONObject(r0);     // Catch: Exception -> L15
        b(r12, new JSONObject(r11));     // Catch: Exception -> L15
        return String.valueOf(c(r1, r12.toString()));
    L8:
        if (r0.length() != 0) goto L10;
        boolean r13 = true;
    L11:
        if (r13 == false) goto L13;
    L10:
        r13 = false;
    L20:
        return r10;
    L19:
        return r10;
    L18:
        return r10;
    }

    public static void b(JSONObject r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "output");
        Intrinsics.checkNotNullParameter(r11, "input");
        JSONArray r0 = r11.names();
        if (r0 == null) goto L5;
        int r1 = r0.length();
    L6:
        IntIterator r12 = RangesKt.until(0, r1).iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        int r13 = r12.nextInt();
        String r14 = r11.names().get(r13).toString();
        r10.put(r14, r11.get(r14));
        goto L8
    L10:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public static Uri c(Uri r10, String r11) {
        if (r11 == null) goto L24;
        Uri.Builder r0 = r10.buildUpon();
        r0.clearQuery();
        Iterator r1 = UriProtector.getQueryParameterNames(r10).iterator();
        boolean r12 = false;
    L6:
        if (r1.hasNext() == false) goto L14;
        String r13 = (String) r1.next();
        if ((!Intrinsics.areEqual(r13, com.bytedance.android.ec.core.event.a.KEY_LOG_DATA)) == true) goto L9;
        r0.appendQueryParameter(r13, r11);
        r12 = true;
        goto L6
    L9:
        Iterator r14 = UriProtector.getQueryParameters(r10, r13).iterator();
    L11:
        if (r14.hasNext() == false) goto L6;
        r0.appendQueryParameter(r13, (String) r14.next());
        goto L11
    L14:
        if (r12 == true) goto L17;
        r0.appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_LOG_DATA, r11);
    L17:
        return r0.build();
    L24:
        return r10;
    }
}
