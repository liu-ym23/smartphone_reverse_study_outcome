package com.obric.aikernel.core.log;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface ILog {
    void d(String r10, String r11);

    void e(String r10, String r11);

    void e(String r10, String r11, Throwable r12);

    void i(String r10, String r11);

    boolean isDebug();

    void v(String r10, String r11);

    void w(String r10, String r11);

    void w(String r10, String r11, Throwable r12);
}
