package com.obric.aikernel.memory_collect.api;

import com.bytedance.news.common.service.manager.IService;
import java.util.Set;
import l7.a;

/* JADX INFO: loaded from: classes2.dex */
public interface MemoryCollectApi extends IService {
    int getCollectorInterval();

    int getStartDelaySeconds();

    void reportMemoryInfo(Boolean r10, Set<String> r11);

    void setExternalParamProvider(a r10);

    void start();
}
