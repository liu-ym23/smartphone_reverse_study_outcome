package com.ss.android.lark.larkconfig.universal;

import com.bytedance.lark.pb.settings.v1.GetUniversalUserSettingResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b<T> implements SdkSender.IParser {
    public static final b<T> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object parse(byte[] r2) {
        return ((GetUniversalUserSettingResponse) GetUniversalUserSettingResponse.ADAPTER.decode(r2)).settings;
    }
}
