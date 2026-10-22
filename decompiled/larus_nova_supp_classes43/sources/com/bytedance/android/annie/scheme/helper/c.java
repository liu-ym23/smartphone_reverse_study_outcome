package com.bytedance.android.annie.scheme.helper;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final Map<String, String> a(Uri r10) {
        HashMap r0 = new HashMap();
        if (r10 == null) goto L20;
        String r1 = r10.getEncodedQuery();
        if (r1 == null) goto L20;
        Iterator r11 = StringsKt.split$default(r1, new String[]{"&"}, false, 0, 6, null).iterator();
    L8:
        if (r11.hasNext() == false) goto L20;
        List r12 = StringsKt.split$default((String) r11.next(), new String[]{"="}, false, 0, 6, null);
        StringBuilder r13 = new StringBuilder();
        if (r12.size() <= 1) goto L16;
        String r14 = (String) ListProtector.get(r12, 0);
        r13.append((String) ListProtector.get(r12, 1));
        int r15 = 2;
        if (r12.size() <= 2) goto L18;
        int r16 = r12.size();
    L14:
        if (r15 >= r16) goto L18;
        r13.append("=");
        r13.append((String) ListProtector.get(r12, r15));
        r15 = r15 + 1;
    L18:
        if (TextUtils.isEmpty(r14) == true) goto L8;
        r0.put(r14, Uri.decode(r13.toString()));
        goto L8
    L16:
        r14 = "";
    L20:
        return r0;
    }
}
