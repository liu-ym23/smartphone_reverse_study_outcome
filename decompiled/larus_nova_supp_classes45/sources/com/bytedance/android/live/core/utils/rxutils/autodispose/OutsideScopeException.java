package com.bytedance.android.live.core.utils.rxutils.autodispose;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class OutsideScopeException extends RuntimeException {
    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        monitor-enter(this);
        monitor-exit(this);
        return this;
    }

    public OutsideScopeException(String r1) {
        super(r1);
    }
}
