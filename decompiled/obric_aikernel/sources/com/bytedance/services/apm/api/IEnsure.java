package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IEnsure extends IService {
    boolean ensureFalse(boolean r10);

    boolean ensureFalse(boolean r10, String r11);

    boolean ensureFalse(boolean r10, String r11, Map<String, String> r12);

    boolean ensureNotEmpty(Collection r10);

    boolean ensureNotNull(Object r10);

    boolean ensureNotNull(Object r10, String r11);

    void ensureNotReachHere();

    void ensureNotReachHere(String r10);

    void ensureNotReachHere(String r10, Map<String, String> r11);

    void ensureNotReachHere(Throwable r10);

    void ensureNotReachHere(Throwable r10, String r11);

    void ensureNotReachHere(Throwable r10, String r11, Map<String, String> r12);

    boolean ensureTrue(boolean r10);

    boolean ensureTrue(boolean r10, String r11);

    boolean ensureTrue(boolean r10, String r11, Map<String, String> r12);

    void reportLogException(int r10, Throwable r11, String r12);

    void reportLogException(Throwable r10);

    void reportLogException(Throwable r10, String r11);
}
