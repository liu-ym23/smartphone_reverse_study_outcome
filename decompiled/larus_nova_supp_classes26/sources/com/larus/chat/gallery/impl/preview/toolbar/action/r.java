package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r {
    public static final r a = null;

    static {
        a = new r();
    }

    public r() {
    }

    public static String a(String r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r4)) == true) goto L8;
        r4 = null;
    L8:
        if (r4 != null) goto L11;
        return null;
    L11:
        if (StringsKt.startsWith$default(r4, "file://", false, 2, null) == false) goto L14;
        return UriProtector.parse(r4).getPath();
    L14:
        if (StringsKt.startsWith$default(r4, "/", false, 2, null) == true) goto L16;
        return null;
    L16:
        return r4;
    }
}
