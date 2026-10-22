package com.obric.aikernel.middleware.api.rpc;

import com.bytedance.news.common.service.manager.IService;

/* JADX INFO: loaded from: classes2.dex */
public interface IWifiInfoApi extends IService {
    long getUidRxBytes();

    long getUidTxBytes();

    int getWifiFrequency();

    int getWifiGeneration();

    int getWifiLevel();

    int getWifiRssi();
}
