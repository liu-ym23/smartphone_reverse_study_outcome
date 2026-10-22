package com.bytedance.news.common.settings;

import com.bytedance.news.common.service.manager.IService;
import e4.b;
import e4.d;

/* JADX INFO: loaded from: classes.dex */
public interface SettingsConfigProvider extends IService {
    b getConfig();

    d getLazyConfig();
}
