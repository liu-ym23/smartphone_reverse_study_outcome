package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final boolean b() {
        return ((Boolean) LiveInfraSettingKeys.LIVE_NEW_COMMON_SLOT.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean a() {
        return !b();
    }

    static {
    }
}
