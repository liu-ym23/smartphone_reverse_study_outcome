package com.bytedance.android.live.core.privacy.av.api;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface e {

    public static final class a {
        public static void a(String r6, String r7, b r8, com.bytedance.android.live.core.privacy.av.api.a r9, int r11) {
            q60.a r0 = q60.a.d;
            if ((r11 & 4) == 0) goto L5;
            Map<String, String> r1 = Collections.emptyMap();
        L6:
            Map<String, String> r3 = r1;
            if ((r11 & 8) == 0) goto L9;
            b.a.getClass();
            r8 = b.a.a;
        L9:
            b r4 = r8;
            if ((r11 & 16) == 0) goto L12;
            r9 = com.bytedance.android.live.core.privacy.av.api.a.b;
        L12:
            r0.d(r6, r7, r3, r4, r9);
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    int c(String r1, String r2, Map<String, String> r3, b r4, com.bytedance.android.live.core.privacy.av.api.a r5);

    int d(String r1, String r2, Map<String, String> r3, b r4, com.bytedance.android.live.core.privacy.av.api.a r5);

    int e(String r1, String r2, Map<String, String> r3, b r4, com.bytedance.android.live.core.privacy.av.api.a r5);

    void g();
}
