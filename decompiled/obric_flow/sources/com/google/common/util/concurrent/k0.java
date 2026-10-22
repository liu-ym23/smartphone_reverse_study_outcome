package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f9415c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.google.common.reflect.w f9416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9417b;

    static {
        f9415c = Logger.getLogger(k0.class.getName());
    }

    public static void a(Runnable r5, Executor r10) {
        r10.execute(r5);     // Catch: RuntimeException -> L4
        return;
    L4:
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
        f9415c.log(r11, r16, e);
    }
}
