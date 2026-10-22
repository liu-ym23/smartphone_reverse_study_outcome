package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import u8.c;

/* JADX INFO: loaded from: classes.dex */
public interface IActivityLifeManager extends IService {
    boolean isForeground();

    void register(c r8);

    void unregister(c r8);
}
