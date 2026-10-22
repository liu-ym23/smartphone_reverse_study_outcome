package com.google.common.util.concurrent;

import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
final class TimeoutFuture$TimeoutFutureException extends TimeoutException {
    public TimeoutFuture$TimeoutFutureException(String r5, c1 r10) {
        super(r5);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        monitor-enter(this);
        setStackTrace(new StackTraceElement[0]);     // Catch: Throwable -> L7
        monitor-exit(this);
        return this;
    L7:
        th = move-exception;
        throw th;
    }
}
