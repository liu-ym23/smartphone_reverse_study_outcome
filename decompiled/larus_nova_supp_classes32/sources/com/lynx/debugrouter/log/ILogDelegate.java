package com.lynx.debugrouter.log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface ILogDelegate {
    void d(String r1, String r2);

    void e(String r1, String r2);

    int getMinimumLoggingLevel();

    void i(String r1, String r2);

    boolean isLoggable(int r1);

    void k(String r1, String r2);

    void log(int r1, String r2, String r3);

    void setMinimumLoggingLevel(int r1);

    int type();

    void v(String r1, String r2);

    void w(String r1, String r2);
}
