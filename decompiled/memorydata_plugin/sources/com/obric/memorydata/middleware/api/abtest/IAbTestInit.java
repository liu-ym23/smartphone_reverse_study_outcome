package com.obric.memorydata.middleware.api.abtest;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/middleware/api/abtest/IAbTestInit;", "Lcom/bytedance/news/common/service/manager/IService;", "registerPluginConfig", "", "pluginContext", "Landroid/content/Context;", "initialize", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IAbTestInit extends IService {
    void initialize();

    void registerPluginConfig(Context r1);
}
