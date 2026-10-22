package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s extends SSettingKey<Integer> {
    public static final s a = null;

    static {
        a = new s();
    }

    public s() {
        if (tb1.c.a == false) goto L5;
        int r0 = 120;
    L6:
        super("audience_ping_interval", Integer.valueOf(r0), "观众ping间隔");
        return;
    L5:
        r0 = 60;
        goto L6
    }
}
