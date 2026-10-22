package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 implements w0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u0 f9438b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f9439c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9440a;

    static {
        f9438b = new u0(null);
        f9439c = Logger.getLogger(u0.class.getName());
    }

    public u0(Object r5) {
        this.f9440a = r5;
    }

    @Override // com.google.common.util.concurrent.w0
    public final void addListener(Runnable r5, Executor r10) {
        com.google.common.base.b0.n(r10, "Executor was null.");
        r10.execute(r5);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        Level r11 = Level.SEVERE;
        String r12 = String.valueOf(r5);
        String r13 = String.valueOf(r10);
        int r14 = r12.length() + 57;
        StringBuilder r15 = new StringBuilder(r13.length() + r14);
        r15.append("RuntimeException while executing runnable ");
        r15.append(r12);
        r15.append(" with executor ");
        r15.append(r13);
        String r16 = r15.toString();
        f9439c.log(r11, r16, e);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean r5) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f9440a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    public final String toString() {
        String r5 = super.toString();
        String r10 = String.valueOf(this.f9440a);
        int r11 = androidx.room.jarjarred.org.antlr.runtime.a.g(27, r5);
        StringBuilder r12 = new StringBuilder(r10.length() + r11);
        r12.append(r5);
        r12.append("[status=SUCCESS, result=[");
        r12.append(r10);
        r12.append("]]");
        return r12.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long r5, TimeUnit r10) {
        r10.getClass();
        return this.f9440a;
    }
}
