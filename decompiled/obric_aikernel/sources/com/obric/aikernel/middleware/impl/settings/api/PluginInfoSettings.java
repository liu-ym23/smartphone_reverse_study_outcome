package com.obric.aikernel.middleware.impl.settings.api;

import com.bytedance.news.common.settings.api.annotation.a;
import com.obric.aikernel.middleware.impl.settings.AIKernelSettings;
import com.obric.aikernel.middleware.impl.settings.b;
import com.obric.aikernel.middleware.impl.settings.c;
import com.obric.aikernel.middleware.impl.settings.d;
import com.obric.aikernel.middleware.impl.settings.f;

/* JADX INFO: loaded from: classes2.dex */
@a(storageKey = "Obric_AIKernel_Settings")
public interface PluginInfoSettings extends AIKernelSettings {
    @Override // com.obric.aikernel.middleware.impl.settings.AIKernelSettings
    com.obric.aikernel.middleware.impl.settings.a CloudSlmInterceptorSetting();

    @Override // com.obric.aikernel.middleware.impl.settings.AIKernelSettings
    c NativeModelQuotaMappingSetting();

    @Override // com.obric.aikernel.middleware.impl.settings.AIKernelSettings
    b memoryCollectSetting();

    @Override // com.obric.aikernel.middleware.impl.settings.AIKernelSettings
    d settingsSetting();

    @Override // com.obric.aikernel.middleware.impl.settings.AIKernelSettings
    f vmSettings();
}
