package com.google.common.util.concurrent;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
final class TimeoutFuture<V> extends g.a<V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private l<V> f4829b;
    private ScheduledFuture<?> c;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.TimeoutFuture$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class TimeoutFutureException extends TimeoutException {
        private TimeoutFutureException(String r1) {
            super(r1);
        }

        /* synthetic */ TimeoutFutureException(String r1, AnonymousClass1 r2) {
            this(r1);
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

    @Override // com.google.common.util.concurrent.a
    public void c() {
        a(this.f4829b);
        ScheduledFuture<?> r0 = this.c;
        if (r0 == null) goto L5;
        r0.cancel(false);
    L5:
        this.f4829b = null;
        this.c = null;
    }

    @Override // com.google.common.util.concurrent.a
    public String e() {
        l<V> r0 = this.f4829b;
        ScheduledFuture<?> r5 = this.c;
        if (r0 == null) goto L10;
        String r1 = "inputFuture=[" + r0 + "]";
        if (r5 == null) goto L12;
        long r2 = r5.getDelay(TimeUnit.MILLISECONDS);
        if (r2 > 0) goto L9;
        return r1;
    L9:
        return r1 + ", remaining delay=[" + r2 + " ms]";
    L12:
        return r1;
    L10:
        return null;
    }
}
