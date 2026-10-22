package com.larus.bmhome.creative.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final String a(Uri r6) {
        Intrinsics.checkNotNullParameter("is_from_push", "queryParameterToRemove");
        if (r6 == null) goto L20;
        Uri.Builder r0 = r6.buildUpon();
        if (r0 == null) goto L27;
        Uri.Builder r1 = r0.clearQuery();
        if (r1 == null) goto L28;
        Iterator r2 = UriProtector.getQueryParameterNames(r6).iterator();
    L11:
        if (r2.hasNext() == false) goto L19;
        String r3 = (String) r2.next();
        if (Intrinsics.areEqual(r3, "is_from_push") == true) goto L11;
        Iterator r4 = UriProtector.getQueryParameters(r6, r3).iterator();
    L16:
        if (r4.hasNext() == false) goto L11;
        r1.appendQueryParameter(r3, (String) r4.next());
        goto L16
    L19:
        return r1.build().toString();
    L28:
        return null;
    L27:
        return null;
    L20:
        return null;
    }
}
