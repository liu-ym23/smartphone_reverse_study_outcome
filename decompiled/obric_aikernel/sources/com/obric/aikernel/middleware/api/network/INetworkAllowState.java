package com.obric.aikernel.middleware.api.network;

import com.bytedance.news.common.service.manager.IService;
import kotlinx.coroutines.flow.p1;

/* JADX INFO: loaded from: classes2.dex */
public interface INetworkAllowState extends IService {
    p1<Boolean> getAllowState();

    void init();

    boolean isAllowNetworkRequestNow();
}
