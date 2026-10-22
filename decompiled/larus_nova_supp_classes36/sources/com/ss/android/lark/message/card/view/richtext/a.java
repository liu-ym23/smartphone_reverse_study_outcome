package com.ss.android.lark.message.card.view.richtext;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static boolean a(View r9) {
        long r0 = System.currentTimeMillis();
        Object r3 = r9.getTag(2131377376);
        boolean r4 = false;
        if (r3 != null) goto L6;
        r9.setTag(2131377376, Long.valueOf(r0));
    L10:
        return r4;
    L6:
        if ((r0 - ((Long) r3).longValue()) >= 500) goto L8;
        r4 = true;
    L8:
        if (r4 == true) goto L10;
        r9.setTag(2131377376, Long.valueOf(r0));
        goto L10
    }
}
