package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IEnsure extends IService {
    boolean ensureFalse(boolean r8);

    boolean ensureFalse(boolean r8, String r10);

    boolean ensureFalse(boolean r8, String r10, Map<String, String> r11);

    boolean ensureNotEmpty(Collection r8);

    boolean ensureNotNull(Object r8);

    boolean ensureNotNull(Object r8, String r10);

    void ensureNotReachHere();

    void ensureNotReachHere(String r8);

    void ensureNotReachHere(String r8, Map<String, String> r10);

    void ensureNotReachHere(Throwable r8);

    void ensureNotReachHere(Throwable r8, String r10);

    void ensureNotReachHere(Throwable r8, String r10, Map<String, String> r11);

    boolean ensureTrue(boolean r8);

    boolean ensureTrue(boolean r8, String r10);

    boolean ensureTrue(boolean r8, String r10, Map<String, String> r11);

    void reportLogException(int r8, Throwable r10, String r11);

    void reportLogException(Throwable r8);

    void reportLogException(Throwable r8, String r10);
}
