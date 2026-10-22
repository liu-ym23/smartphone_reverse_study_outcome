package com.larus.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r7) {
        if (r7 == null) goto L21;
        Uri r8 = UriProtector.parse(r7);
        if (r8 == null) goto L7;
        String r1 = r8.getSchemeSpecificPart();
    L8:
        if (r1 == null) goto L12;
        List r9 = StringsKt.split$default(r1, new String[]{"?"}, false, 0, 6, null);
        if (r9 == null) goto L12;
        String r10 = (String) CollectionsKt.first(r9);
    L13:
        boolean r2 = false;
        if (r10 != null) goto L16;
    L18:
        if (r2 == true) goto L20;
        return null;
    L20:
        return r10;
    L16:
        if (StringsKt.startsWith$default(r10, "//", false, 2, null) != true) goto L18;
        r2 = true;
    L12:
        r10 = null;
        goto L13
    L7:
        r1 = null;
        goto L8
    L21:
        return null;
    }
}
