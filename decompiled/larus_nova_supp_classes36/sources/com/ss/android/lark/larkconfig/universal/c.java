package com.ss.android.lark.larkconfig.universal;

import com.bytedance.lark.pb.settings.v1.GetUniversalUserSettingResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c<T> implements SdkSender.IParser {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final Object parse(byte[] r2) {
        return ((GetUniversalUserSettingResponse) GetUniversalUserSettingResponse.ADAPTER.decode(r2)).settings;
    }
}
