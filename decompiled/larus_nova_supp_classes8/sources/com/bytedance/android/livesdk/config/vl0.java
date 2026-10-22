package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vl0 extends SSettingKey<Boolean> {
    public static final vl0 a = null;

    static {
        a = new vl0();
    }

    public vl0() {
        super("live_radio_interact_enable", Boolean.TRUE, "语音直播间是否显示连麦开关", new String[]{"true:显示", "false:不显示"});
    }
}
