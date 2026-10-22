package com.obric.aikernel.core.log;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes.dex */
@Keep
public interface ILog {
    void d(String r8, String r10);

    void e(String r8, String r10);

    void e(String r8, String r10, Throwable r11);

    void i(String r8, String r10);

    boolean isDebug();

    void v(String r8, String r10);

    void w(String r8, String r10);

    void w(String r8, String r10, Throwable r11);
}
