package com.bytedance.privacy.e;

import com.bytedance.privacy.exception.BdPrivacyException;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static void a(String r1, Object r2) {
        if (r2 == null) goto L5;
        return;
    L5:
        throw new BdPrivacyException(r1 + " is null", -2);
    }

    public static void a(String r1, String r2) {
        a(r1, r2);
        if (r2.isEmpty() == true) goto L6;
        return;
    L6:
        throw new BdPrivacyException(r1 + " is empty", -3);
    }

    public static void a(String r1, String r2, int r3) {
        a(r1, r2);
        if (r2.length() > r3) goto L6;
        return;
    L6:
        throw new BdPrivacyException(r1 + " exceeds max length " + r3, -3);
    }
}
