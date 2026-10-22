package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements f {
    public static final c a = null;

    public c() {
    }

    static {
        a = new c();
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.layout.f
    public final int a(int r2, int r3) {
        if (r3 < 5) goto L6;
        r2 = Math.abs(r2 - 2);
    L9:
        return r3 - r2;
    L6:
        if (r3 < 3) goto L9;
        r2 = Math.abs(r2 - 1);
        goto L9
    }
}
