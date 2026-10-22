package com.bytedance.awemeopen.infra.base.settings;

import com.bytedance.awemeopen.servicesapi.setting.AoSDKSettingsService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AoSettings {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(AoSettings$service$2.INSTANCE);
    }

    public static JSONObject a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "key");
        return ((AoSDKSettingsService) a.getValue()).getSettings(r1);
    }
}
