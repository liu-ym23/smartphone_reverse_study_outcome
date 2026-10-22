package com.larus.dora.impl.device.settings.rename;

import android.text.InputFilter;
import android.text.Spanned;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements InputFilter {

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.rename.a$a, reason: collision with other inner class name */
    public static final class C0055a {
    }

    static {
    }

    public a() {
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r1, int r2, int r3, Spanned r4, int r5, int r6) {
        boolean r7 = false;
        if (r1 != null) goto L5;
    L7:
        if (r7 == false) goto L9;
        return null;
    L9:
        return "";
    L5:
        if (new Regex("^[a-zA-Z0-9_ \\u4e00-\\u9fa5\\u278b-\\u2792]+$").matches(r1) != true) goto L7;
        r7 = true;
        goto L7
    }
}
