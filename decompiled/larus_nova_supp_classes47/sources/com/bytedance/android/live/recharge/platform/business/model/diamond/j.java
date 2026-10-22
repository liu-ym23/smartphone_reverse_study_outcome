package com.bytedance.android.live.recharge.platform.business.model.diamond;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public static final boolean a(g r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        String r1 = r3.getPreCalcInfo();
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r1.length() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L13;
        return false;
    L13:
        if (r3.getCouponBarInfo() == null) goto L18;
        return true;
    L18:
        return false;
    L10:
        r2 = false;
        goto L11
    }
}
