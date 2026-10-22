package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lc extends SSettingKey<Boolean> {
    public static final lc a = null;

    static {
        a = new lc();
    }

    public lc() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_preview_zoom_opt", "开播页焦距优化", r1, r1);
    }
}
