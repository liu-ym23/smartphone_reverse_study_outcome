package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;

/* JADX INFO: loaded from: classes.dex */
public interface ILaunchTrace extends IService {
    void cancelTrace();

    void endSpan(String r10, String r11);

    void endTrace(int r10, String r11, long r12);

    void startSpan(String r10, String r11);

    void startTrace();
}
