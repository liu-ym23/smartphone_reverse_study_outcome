package com.bytedance.apm6.java_alloc;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
final class JavaAllocReporter$AllocThrowable extends Throwable {
    private final StackTraceElement[] elements;
    private final String msg;

    public JavaAllocReporter$AllocThrowable(String r5, StackTraceElement[] r10) {
        this.msg = r5;
        this.elements = r10;
    }

    @Override // java.lang.Throwable
    @NonNull
    public synchronized Throwable fillInStackTrace() {
        monitor-enter(this);
        monitor-exit(this);
        return this;
    }

    @Override // java.lang.Throwable
    @NonNull
    public StackTraceElement[] getStackTrace() {
        return this.elements;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return this.msg;
    }
}
