package com.bytedance.android.ec.core.anchorv3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Integer r10) {
        if (r10 == null) goto L9;
        r10.intValue();
        if ((com.bytedance.android.ec.core.abtest.d.g() & r10.intValue()) != r10.intValue()) goto L12;
        return true;
    L12:
        return false;
    L9:
        if (com.bytedance.android.ec.core.abtest.d.g() <= 0) goto L13;
        return true;
    L13:
        return false;
    }
}
