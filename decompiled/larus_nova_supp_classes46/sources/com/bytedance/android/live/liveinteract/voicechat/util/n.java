package com.bytedance.android.live.liveinteract.voicechat.util;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n {
    public static String a(Context r1, int r2, int r3) {
        if (r1 != null) goto L6;
        return "";
    L6:
        if (r2 == 9) goto L18;
        if (r2 == 10) goto L16;
        if (r3 != 29) goto L14;
        return r1.getString(2131915137);
    L14:
        return r1.getString(2131915134);
    L16:
        return r1.getString(2131915138);
    L18:
        if (r3 != 61) goto L22;
        return r1.getString(2131915135);
    L22:
        if (r3 != 0) goto L26;
        return r1.getString(2131915136);
    L26:
        return r1.getString(2131915136);
    }
}
