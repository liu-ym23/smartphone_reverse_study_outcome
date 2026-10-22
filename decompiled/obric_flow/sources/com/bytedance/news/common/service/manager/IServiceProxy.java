package com.bytedance.news.common.service.manager;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IServiceProxy<T> {
    void collectService(Map<String, String> r5);

    T newInstance();
}
