package com.bytedance.android.live.core.utils.rxutils.autodispose;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ExceptionHelper {
    public static final Throwable a = null;

    public static final class Termination extends Throwable {
        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            monitor-enter(this);
            monitor-exit(this);
            return this;
        }

        public Termination() {
            super("No further exceptions");
        }
    }

    static {
        a = new Termination();
    }
}
