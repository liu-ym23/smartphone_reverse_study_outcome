package com.bytedance.rpc.log;

/* JADX INFO: loaded from: classes2.dex */
public interface Loggable {
    void d(String r1, CharSequence r2);

    void e(String r1, CharSequence r2);

    void e(Throwable r1, boolean r2);

    void i(String r1, CharSequence r2);

    boolean isLoggable(LogLevel r1);

    void v(String r1, CharSequence r2);

    void w(String r1, CharSequence r2);
}
