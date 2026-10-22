package com.bytedance.android.live.base.model.user;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q0 {
    public static final boolean a(String r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.length() > 2) goto L9;
        return false;
    L9:
        if (r3.length() < 8) goto L12;
        return true;
    L12:
        return false;
    }
}
