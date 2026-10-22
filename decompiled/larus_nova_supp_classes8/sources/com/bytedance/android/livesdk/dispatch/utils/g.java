package com.bytedance.android.livesdk.dispatch.utils;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static Map a(Uri r15) {
            HashMap r0 = new HashMap();
            if (r15 != null) goto L5;
            return r0;
        L5:
            String r1 = r15.getEncodedQuery();
            if (r1 != null) goto L8;
        L37:
            return r0;
        L8:
            if (r1.length() != 0) goto L10;
            boolean r16 = true;
        L11:
            if (r16 == true) goto L37;
            Object[] r17 = StringsKt.split$default(r1, new String[]{"&"}, false, 0, 6, null).toArray(new String[0]);
            if (r17 == null) goto L36;
            String[] r18 = (String[]) r17;
            int r2 = r18.length;
            int r3 = 0;
        L16:
            if (r3 >= r2) goto L34;
            Object[] r5 = StringsKt.split$default(r18[r3], new String[]{"="}, false, 0, 6, null).toArray(new String[0]);
            if (r5 == null) goto L33;
            String[] r6 = (String[]) r5;
            StringBuilder r7 = new StringBuilder();
            if (r6.length != 2) goto L22;
            String r9 = r6[0];
            r7.append(r6[1]);
        L24:
            if (r6.length <= 2) goto L29;
            r9 = r6[0];
            int r10 = r6.length;
            int r11 = 1;
        L26:
            if (r11 >= r10) goto L29;
            r7.append(r6[r11]);
            r7.append("=");
            r11 = r11 + 1;
        L29:
            if (TextUtils.isEmpty(r9) == true) goto L31;
            r0.put(r9, Uri.decode(r7.toString()));
        L31:
            r3 = r3 + 1;
            goto L16
        L22:
            r9 = "";
            goto L24
        L33:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L34:
            return r0;
        L36:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L10:
            r16 = false;
            goto L11
        }
    }

    static {
    }
}
