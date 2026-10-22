package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;

/* JADX INFO: loaded from: classes2.dex */
public interface ILaunchTrace extends IService {
    void cancelTrace();

    void endSpan(String r5, String r10);

    void endTrace(int r5, String r10, long r11);

    void startSpan(String r5, String r10);

    void startTrace();
}
