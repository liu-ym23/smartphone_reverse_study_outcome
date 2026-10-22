package com.bytedance.geckox;

import androidx.annotation.Keep;
import com.bytedance.geckox.model.Resources;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface AppSettingsManager$IGeckoAppSettings {
    a getConfig();

    Map<String, List<String>> getGkFSTestChannels();

    Map<String, Resources> getOnDemandList();

    int getOnDemandPolicy();

    boolean isForbidRequest();

    boolean isGkFSEnable();

    boolean isGkFSTidyUpEnable();

    boolean isProbeEnable();

    boolean isRegisterBySPI();

    boolean isUseEncrypt();
}
