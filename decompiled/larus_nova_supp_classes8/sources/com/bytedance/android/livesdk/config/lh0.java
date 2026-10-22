package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lh0 extends SSettingKey<String> {
    public static final lh0 a = null;

    static {
        a = new lh0();
    }

    public lh0() {
        super("live_pk_privacy_hint", "pk 连线隐私态提示文案", "私密账号在%s时，对手直播间的观众可看到你的直播内容", "私密账号在%s时，对手直播间的观众可看到你的直播内容", false);
    }
}
