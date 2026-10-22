package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import oj.c;

/* JADX INFO: loaded from: classes2.dex */
public interface IActivityLifeManager extends IService {
    boolean isForeground();

    void register(c r5);

    void unregister(c r5);
}
