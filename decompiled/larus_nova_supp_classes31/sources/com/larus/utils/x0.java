package com.larus.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x0 {
    public final Uri a;
    public final Map<String, Object> b;

    public final Uri c() {
        Uri.Builder r0 = this.a.buildUpon().clearQuery();
        Iterator r1 = ((LinkedHashMap) this.b).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) r1.next();
        String r3 = (String) r2.getKey();
        Object r4 = r2.getValue();
        if ((r4 instanceof x0) == false) goto L8;
        String r5 = ((x0) r4).c().toString();
    L9:
        Intrinsics.checkNotNull(r5);
        r0.appendQueryParameter(r3, r5);
        goto L4
    L8:
        r5 = r4.toString();
        goto L9
    L11:
        return r0.build();
    }

    public final String toString() {
        return c().toString();
    }

    public x0(Uri r4) {
        Intrinsics.checkNotNullParameter(r4, "baseUri");
        this.a = r4;
        this.b = new LinkedHashMap();
        if (r4.isHierarchical() == false) goto L8;
        Iterator r5 = UriProtector.getQueryParameterNames(r4).iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        String r0 = (String) r5.next();
        String r1 = UriProtector.getQueryParameter(this.a, r0);
        Intrinsics.checkNotNull(r1);
        this.b.put(r0, r1);
        goto L6
    L10:
        return;
    }

    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r3 = ((LinkedHashMap) this.b).get(r2);
        if ((r3 instanceof x0) == false) goto L6;
        return ((x0) r3).c().toString();
    L6:
        if ((r3 instanceof String) == true) goto L11;
        return null;
    L11:
        return (String) r3;
    }

    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r3 == null) goto L5;
        this.b.put(r2, r3);
        return;
    L5:
        this.b.remove(r2);
    }
}
