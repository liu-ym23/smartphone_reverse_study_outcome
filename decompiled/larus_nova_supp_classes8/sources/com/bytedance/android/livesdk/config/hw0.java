package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hw0 extends SSettingKey<Boolean> {
    public static final hw0 a = null;

    static {
        a = new hw0();
    }

    public hw0() {
        Boolean r1 = Boolean.TRUE;
        super("live_use_modified_uilayout_offset_map", "是否使用修改后的uiLayout获取offsetMap", r1, r1);
    }
}
