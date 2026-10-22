package com.obric.aikernel.middleware.api.teaagent;

import com.bytedance.news.common.service.manager.IService;

/* JADX INFO: loaded from: classes2.dex */
public interface ITeaAgentManager extends IService {
    String getForegroundApp();

    void init();

    boolean isForegroundApp(String r10);
}
