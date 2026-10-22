package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;

/* JADX INFO: loaded from: classes.dex */
public interface ILaunchTrace extends IService {
    void cancelTrace();

    void endSpan(String r8, String r10);

    void endTrace(int r8, String r10, long r11);

    void startSpan(String r8, String r10);

    void startTrace();
}
