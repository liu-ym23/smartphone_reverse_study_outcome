package com.service.middleware.applog;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.ss.android.common.applog.ApplogServiceImpl;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ApplogService__ServiceProxy implements IServiceProxy<ApplogService> {
    public ApplogService__ServiceProxy() {
    }

    public ApplogService newInstance() {
        return new ApplogServiceImpl();
    }

    /* JADX INFO: renamed from: newInstance, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m19newInstance() {
        return newInstance();
    }

    public void collectService(Map<String, String> r3) {
        r3.put("com.service.middleware.applog.ApplogService", "com.ss.android.common.applog.ApplogServiceImpl");
    }
}
