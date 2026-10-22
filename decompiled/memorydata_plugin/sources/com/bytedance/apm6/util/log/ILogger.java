package com.bytedance.apm6.util.log;

/* JADX INFO: loaded from: classes.dex */
public interface ILogger {
    void d(String r1, String r2);

    void e(String r1, String r2);

    void e(String r1, String r2, Throwable r3);

    void i(String r1, String r2);

    void v(String r1, String r2);

    void w(String r1, String r2);

    void w(String r1, String r2, Throwable r3);

    void wtf(String r1, String r2);

    void wtf(String r1, String r2, Throwable r3);
}
