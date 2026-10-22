package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IEnsure extends IService {
    boolean ensureFalse(boolean r5);

    boolean ensureFalse(boolean r5, String r10);

    boolean ensureFalse(boolean r5, String r10, Map<String, String> r11);

    boolean ensureNotEmpty(Collection r5);

    boolean ensureNotNull(Object r5);

    boolean ensureNotNull(Object r5, String r10);

    void ensureNotReachHere();

    void ensureNotReachHere(String r5);

    void ensureNotReachHere(String r5, Map<String, String> r10);

    void ensureNotReachHere(Throwable r5);

    void ensureNotReachHere(Throwable r5, String r10);

    void ensureNotReachHere(Throwable r5, String r10, Map<String, String> r11);

    boolean ensureTrue(boolean r5);

    boolean ensureTrue(boolean r5, String r10);

    boolean ensureTrue(boolean r5, String r10, Map<String, String> r11);

    void reportLogException(int r5, Throwable r10, String r11);

    void reportLogException(Throwable r5);

    void reportLogException(Throwable r5, String r10);
}
