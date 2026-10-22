package com.bytedance.android.livesdk.config;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class va1 extends SSettingKey<Map<String, ? extends Map<String, ? extends Object>>> {
    public static final va1 a = null;

    static {
        a = new va1();
    }

    public va1() {
        super("multi_link_sr_config", "多人场景超分配置", MapsKt.mapOf(TuplesKt.to("default", MapsKt.mapOf(TuplesKt.to("default", "default")))), MapsKt.mapOf(TuplesKt.to("default", MapsKt.mapOf(TuplesKt.to("default", "default")))));
    }
}
