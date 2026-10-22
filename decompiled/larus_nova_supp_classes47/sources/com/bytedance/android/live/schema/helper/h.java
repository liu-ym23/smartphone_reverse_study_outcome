package com.bytedance.android.live.schema.helper;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    static {
    }

    @JvmStatic
    public static final Map<String, String> a(Uri r8) {
        HashMap r0 = new HashMap();
        if (r8 == null) goto L20;
        String r1 = r8.getEncodedQuery();
        if (r1 == null) goto L20;
        Iterator r9 = StringsKt.split$default(r1, new String[]{"&"}, false, 0, 6, null).iterator();
    L8:
        if (r9.hasNext() == false) goto L20;
        List r2 = StringsKt.split$default((String) r9.next(), new String[]{"="}, false, 0, 6, null);
        StringBuilder r3 = new StringBuilder();
        if (r2.size() <= 1) goto L16;
        String r4 = (String) ListProtector.get(r2, 0);
        r3.append((String) ListProtector.get(r2, 1));
        int r6 = 2;
        if (r2.size() <= 2) goto L18;
        int r5 = r2.size();
    L14:
        if (r6 >= r5) goto L18;
        r3.append("=");
        r3.append((String) ListProtector.get(r2, r6));
        r6 = r6 + 1;
    L18:
        if (TextUtils.isEmpty(r4) == true) goto L8;
        r0.put(r4, Uri.decode(r3.toString()));
        goto L8
    L16:
        r4 = "";
    L20:
        return r0;
    }

    @JvmStatic
    public static final Uri b(Uri r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "uri");
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "value");
        String r0 = UriProtector.getQueryParameter(r4, r5);
        if (r0 != null) goto L6;
        return r4.buildUpon().appendQueryParameter(r5, r6).build();
    L6:
        if (Intrinsics.areEqual(r0, r6) == true) goto L24;
        Set r1 = UriProtector.getQueryParameterNames(r4);
        Uri.Builder r2 = r4.buildUpon().clearQuery();
        Iterator r3 = r1.iterator();
    L10:
        if (r3.hasNext() == false) goto L16;
        String r7 = (String) r3.next();
        if (Intrinsics.areEqual(r7, r5) == true) goto L13;
        r2.appendQueryParameter(r7, UriProtector.getQueryParameter(r4, r7));
        goto L10
    L13:
        r2.appendQueryParameter(r7, r6);
        goto L10
    L16:
        return r2.build();
    L24:
        return r4;
    }
}
