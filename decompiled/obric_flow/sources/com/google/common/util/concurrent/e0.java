package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f9411a = null;

    static {
        f9411a = Logger.getLogger(e0.class.getName());
    }

    public static void a(AutoCloseable r5, Executor r10) {
        if (r5 != null) goto L12;
        return;
    L12:
        r10.execute(new a6.a(r5, 26));     // Catch: RejectedExecutionException -> L6
        return;
    L6:
        e = move-exception;
        Level r11 = Level.WARNING;
        Logger r12 = f9411a;
        if (r12.isLoggable(r11) == false) goto L10;
        r12.log(r11, String.format("while submitting close to %s; will close inline", new Object[]{r10}), e);
    L10:
        a(r5, DirectExecutor.INSTANCE);
    }
}
