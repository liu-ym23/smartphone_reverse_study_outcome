package com.bytedance.android.live.openplatform.api.utils;

import android.graphics.Color;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public c() {
    }

    static {
    }

    public static int a(String r7) {
        if (r7 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L24;
    L21:
        return -1;
    L24:
        if (StringsKt.startsWith$default(r7, "#", false, 2, null) == true) goto L14;
        int r4 = CastIntegerProtector.parseInt(r7);     // Catch: Throwable -> L23
    L15:
        if (r7.length() == 7) goto L18;
    L20:
        int r0 = r4 >>> 8;
        return r0 | (r4 << 24);
    L18:
        if (StringsKt.startsWith$default(r7, "#", false, 2, null) == false) goto L20;
        return r4;
    L14:
        r4 = Color.parseColor(r7);     // Catch: Throwable -> L23
        goto L15
    L5:
        if (StringsKt.isBlank(r7) == true) goto L8;
        r1 = false;
        goto L9
    }
}
