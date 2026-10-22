package com.bytedance.android.live.liveinteract.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d1 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Integer r3, Integer r4) {
        if (((Boolean) vm2.e.B.getValue(null, vm2.e.a[26])).booleanValue() == true) goto L5;
        return false;
    L5:
        if (r3 != null) goto L8;
    L9:
        if (r3 != null) goto L12;
    L13:
        if (r4 != null) goto L16;
    L17:
        if (r4 != null) goto L20;
        return false;
    L20:
        if (r4.intValue() != 13) goto L23;
    L21:
        return true;
    L23:
        return false;
    L16:
        if (r4.intValue() == 14) goto L21;
    L12:
        if (r3.intValue() == 23) goto L21;
    L8:
        if (r3.intValue() == 24) goto L21;
        goto L9
    }
}
