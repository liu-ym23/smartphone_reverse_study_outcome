package com.bytedance.ai.widget.cache;

import com.bytedance.ai.settings.AISDKSettingConfigManager;
import com.bytedance.ai.settings.provider.LynxViewReusedConfig;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LynxViewReusedConfig f2985a = null;

    static {
        f2985a = AISDKSettingConfigManager.INSTANCE.getLYNX_VIEW_REUSED_CONFIG().getValue();
    }
}
