package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vi extends SSettingKey<Boolean> {
    public static final vi a = null;

    static {
        a = new vi();
    }

    public vi() {
        super("live_bytecast_seek", "自研投屏流时移", Boolean.FALSE, Boolean.TRUE);
    }
}
