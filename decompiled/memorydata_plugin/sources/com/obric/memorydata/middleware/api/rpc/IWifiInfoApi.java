package com.obric.memorydata.middleware.api.rpc;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/api/rpc/IWifiInfoApi;", "Lcom/bytedance/news/common/service/manager/IService;", "getWifiFrequency", "", "getWifiGeneration", "getWifiRssi", "getWifiLevel", "getUidTxBytes", "", "getUidRxBytes", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IWifiInfoApi extends IService {
    long getUidRxBytes();

    long getUidTxBytes();

    int getWifiFrequency();

    int getWifiGeneration();

    int getWifiLevel();

    int getWifiRssi();
}
