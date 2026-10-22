package com.larus.bmhome.chat.layout.widget.handler;

import android.view.View;
import com.larus.platform.service.p1;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final <T> T a(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "key");
        if (p1.a.enableViewTagExtra() == false) goto L14;
        Object r4 = r2.getTag(2131367582);     // Catch: Exception -> L17
        if (TypeIntrinsics.isMutableMap(r4) == false) goto L8;
        Map r5 = (Map) r4;     // Catch: Exception -> L17
    L9:
        if (r5 != null) goto L11;
        return null;
    L11:
        Object r6 = r5.get(r3);     // Catch: Exception -> L17
        if (r6 != null) goto L16;
        return null;
    L16:
        return (T) r6;
    L8:
        r5 = null;
        goto L9
    L14:
        r6 = com.larus.utils.l.b(r2, r3);     // Catch: Exception -> L17
        goto L16
    L20:
        return null;
    }

    public static final <T> void b(View r3, String r4, T r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "key");
        if (p1.a.enableViewTagExtra() == false) goto L12;
        Object r1 = r3.getTag(2131367582);     // Catch: Exception -> L14
        if (TypeIntrinsics.isMutableMap(r1) == false) goto L8;
        Map r2 = (Map) r1;     // Catch: Exception -> L14
    L9:
        if (r2 != null) goto L11;
        r2 = new LinkedHashMap();     // Catch: Exception -> L14
        r3.setTag(2131367582, r2);     // Catch: Exception -> L14
    L11:
        r2.put(r4, r5);     // Catch: Exception -> L14
        return;
    L8:
        r2 = null;
        goto L9
    L12:
        com.larus.utils.l.c(r3, r4, r5);     // Catch: Exception -> L14
        return;
    }
}
