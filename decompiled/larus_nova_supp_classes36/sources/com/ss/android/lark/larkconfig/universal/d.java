package com.ss.android.lark.larkconfig.universal;

import com.bytedance.lark.pb.basic.v1.UniversalUserSetting;
import com.bytedance.lark.pb.settings.v1.UpdateUniversalUserSettingResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d<T> implements SdkSender.IParser {
    public static final d<T> a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final Object parse(byte[] r2) {
        return (UniversalUserSetting) CollectionsKt.firstOrNull(((UpdateUniversalUserSettingResponse) UpdateUniversalUserSettingResponse.ADAPTER.decode(r2)).settings);
    }
}
