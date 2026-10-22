package com.bytedance.android.ec.core.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x0 {
    public static final JSONObject a(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$copy");
        JSONObject r0 = new JSONObject();
        Iterator<String> r1 = r10.keys();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r11 = r1.next();
        r0.put(r11, r10.get(r11));
        goto L4
    L6:
        return r0;
    }

    public static final JSONObject c(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toJSONObject");
        JSONObject r0 = new JSONObject();
        Iterator r1 = UriProtector.getQueryParameterNames(r10).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r11 = (String) r1.next();
        r0.put(r11, UriProtector.getQueryParameter(r10, r11));
        goto L4
    L6:
        return r0;
    }

    public static final void b(JSONObject r10, JSONObject r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$mergeJson");
        if (r11 == null) goto L19;
        Iterator<String> r0 = r11.keys();
    L6:
        if (r0.hasNext() == false) goto L27;
        String r1 = r0.next();
        if (r10.has(r1) == false) goto L18;
        String r13 = JSONObjectProtectorUtils.getString(r10, r1);
        if (r13 != null) goto L12;
    L15:
        boolean r14 = true;
    L16:
        if (r14 == true) goto L18;
        if (r12 == false) goto L6;
    L12:
        if (StringsKt.isBlank(r13) == true) goto L15;
        r14 = false;
    L18:
        r10.putOpt(r1, r11.get(r1));
        goto L6
    L27:
        return;
    }
}
