package com.bytedance.android.accessibilityLib_Core.config.bean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final boolean a(Integer r10) {
        if (r10 != null) goto L4;
    L8:
        return false;
    L4:
        if (r10.intValue() == (-1)) goto L8;
        if (r10.intValue() == 0) goto L8;
        return true;
    }
}
