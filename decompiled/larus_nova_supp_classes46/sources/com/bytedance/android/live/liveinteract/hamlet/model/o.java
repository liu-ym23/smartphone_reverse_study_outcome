package com.bytedance.android.live.liveinteract.hamlet.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o {
    public static final boolean a(l r7, l r8) {
        if (r8 != null) goto L7;
        if (r7 != null) goto L7;
        return true;
    L7:
        if (r8 == null) goto L24;
        if (r7 == null) goto L24;
        Double r2 = r8.a();
        Double r9 = r8.b();
        if (r7.a() == null) goto L24;
        if (r7.b() == null) goto L24;
        if (r2 == null) goto L24;
        if (r9 == null) goto L24;
        double r4 = 0.05f;
        if (Math.abs(r7.a().doubleValue() - r2.doubleValue()) <= r4) goto L20;
    L22:
        return false;
    L20:
        if (Math.abs(r7.b().doubleValue() - r9.doubleValue()) > r4) goto L22;
        return true;
    L24:
        return false;
    }
}
