package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ik extends SSettingKey<Boolean> {
    public static final ik a = null;

    static {
        a = new ik();
    }

    public ik() {
        Boolean r1 = Boolean.TRUE;
        super("live_chorus_anchor_join_chorus", "主播续播检测加入合唱", r1, r1);
    }
}
