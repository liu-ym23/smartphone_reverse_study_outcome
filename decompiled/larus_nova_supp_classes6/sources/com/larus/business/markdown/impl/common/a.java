package com.larus.business.markdown.impl.common;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(String r2, int r3) {
    L3:
        if ((-1) >= r3) goto L16;
        Character r0 = StringsKt.getOrNull(r2, r3);
        if (r0 == null) goto L15;
        if (r0.charValue() != '[') goto L15;
        Character r1 = StringsKt.getOrNull(r2, r3 - 1);
        if (r1 == null) goto L14;
        if (r1.charValue() == '\\') goto L15;
    L14:
        return r3;
    L15:
        r3 = r3 - 1;
        goto L3
    L16:
        return -1;
    }

    public static void b(StringBuilder r2, int r3) {
        Character r0 = StringsKt.getOrNull(r2, r3);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.charValue() != '!') goto L14;
        Character r1 = StringsKt.getOrNull(r2, r3 - 1);
        if (r1 != null) goto L11;
    L12:
        r2.delete(r3, r2.length());
        return;
    L11:
        if (r1.charValue() != '\\') goto L12;
        return;
    }
}
