package com.obric.aikernel.middleware.api.settings;

import com.bytedance.news.common.service.manager.IService;
import s7.b;
import s7.c;
import s7.d;
import s7.f;
import s7.g;
import s7.h;
import s7.i;

/* JADX INFO: loaded from: classes2.dex */
public interface ISettingsManager extends IService {
    String getABValueWith(String r10);

    String getAppValueWith(String r10);

    b getCloudSlmInterceptorSetting();

    c getMemoryCollectSetting();

    d getModelQuotaConfigs();

    g getSettingsSetting();

    h getTTNetStandbySettings();

    i getVmSettings();

    void init();

    void registerObserver(f r10);

    void unregisterObserver(f r10);

    void update();
}
