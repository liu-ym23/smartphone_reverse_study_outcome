package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import t4.d;

/* JADX INFO: loaded from: classes.dex */
public interface IActivityLifeManager extends IService {
    boolean isForeground();

    void register(d r10);

    void unregister(d r10);
}
