package com.bytedance.rpc.log;

/* JADX INFO: loaded from: classes2.dex */
public interface LogInterceptor {
    boolean onInterceptError(Throwable r1, boolean r2);

    boolean onInterceptLog(String r1, CharSequence r2, LogLevel r3);
}
