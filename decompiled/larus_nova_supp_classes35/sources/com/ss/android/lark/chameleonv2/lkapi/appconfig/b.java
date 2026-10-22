package com.ss.android.lark.chameleonv2.lkapi.appconfig;

import com.bytedance.lark.pb.settings.v1.GetSettingsResponse;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T> implements SdkSender.IParser {
    public static final b<T> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object parse(byte[] r3) {
        if (r3 != null) goto L9;
    L7:
        return null;
    L9:
        return (GetSettingsResponse) GetSettingsResponse.ADAPTER.decode(r3);
    L5:
        e = move-exception;
        Log.e("LK_API_TAG_AppConfig", "getSettingFromRust parse onError: " + e);
        goto L7
    }
}
