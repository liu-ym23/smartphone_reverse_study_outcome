package com.obric.aikernel.middleware.api.traker;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.obric.aikernel.middleware.impl.tracker.TrackerImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ITrackerApi__ServiceProxy implements IServiceProxy<ITrackerApi> {
    public ITrackerApi__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r10) {
        r10.put("com.obric.aikernel.middleware.api.traker.ITrackerApi", "com.obric.aikernel.middleware.impl.tracker.TrackerImpl");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public ITrackerApi newInstance() {
        return TrackerImpl.getInst();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ ITrackerApi newInstance() {
        return newInstance();
    }
}
