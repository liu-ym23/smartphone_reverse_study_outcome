package com.bytedance.android.annie.util;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class y {
    static {
    }

    public static Map a(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Uri r11 = UriProtector.parse(r10);
        LinkedHashMap r0 = new LinkedHashMap();
        if (r11.isHierarchical() == false) goto L16;
        Iterator r1 = UriProtector.getQueryParameterNames(r11).iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        String r12 = (String) r1.next();
        if (r12.length() <= 0) goto L10;
        boolean r13 = true;
    L11:
        if (r13 == false) goto L6;
        String r14 = UriProtector.getQueryParameter(r11, r12);
        if (r14 != null) goto L15;
        r14 = "";
    L15:
        r0.put(r12, r14);
        goto L6
    L10:
        r13 = false;
    L16:
        return r0;
    }

    @JvmStatic
    public static final Uri b(Uri r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.KEY_URL, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        String r0 = UriProtector.getQueryParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r0 != null) goto L6;
        return r10.buildUpon().appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_URL, r11).build();
    L6:
        if (Intrinsics.areEqual(r0, r11) == true) goto L24;
        Set r1 = UriProtector.getQueryParameterNames(r10);
        Uri.Builder r12 = r10.buildUpon().clearQuery();
        Iterator r13 = r1.iterator();
    L10:
        if (r13.hasNext() == false) goto L16;
        String r14 = (String) r13.next();
        if (Intrinsics.areEqual(r14, com.bytedance.android.ec.core.event.a.KEY_URL) == true) goto L13;
        r12.appendQueryParameter(r14, UriProtector.getQueryParameter(r10, r14));
        goto L10
    L13:
        r12.appendQueryParameter(r14, r11);
        goto L10
    L16:
        return r12.build();
    L24:
        return r10;
    }
}
