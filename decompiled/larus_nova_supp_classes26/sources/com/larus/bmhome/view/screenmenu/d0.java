package com.larus.bmhome.view.screenmenu;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d0 {
    public static final CharSequence a(Context r1, l0 r2) {
        String r0 = r2.c;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L16;
        int r4 = r2.b;
        if (r4 != 0) goto L17;
        return "";
    L17:
        return r1.getText(r4);
    L16:
        return r2.c;
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L9
    }
}
