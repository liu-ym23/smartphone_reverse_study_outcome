package com.bytedance.android.live.saas.middleware.alog;

import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface ILogProtocol {
    void bundle(int r1, String r2, Bundle r3);

    void changeLevel(int r1);

    void d(String r1, String r2);

    void destroy();

    void e(String r1, String r2);

    void e(String r1, String r2, Throwable r3);

    void e(String r1, Throwable r2);

    void flush();

    void forceLogSharding();

    void header(int r1, String r2, String r3);

    void i(String r1, String r2);

    void intent(int r1, String r2, Intent r3);

    void json(int r1, String r2, String r3);

    void release();

    void stacktrace(int r1, String r2, StackTraceElement[] r3);

    void thread(int r1, String r2, Thread r3);

    void throwable(int r1, String r2, String r3, Throwable r4);

    void throwable(int r1, String r2, Throwable r3);

    void v(String r1, String r2);

    void w(String r1, String r2);

    void w(String r1, String r2, Throwable r3);

    void w(String r1, Throwable r2);
}
