package com.google.common.util.concurrent;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q extends h {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Logger f9429j = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile Set f9430h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile int f9431i;

    static {
        f9429j = Logger.getLogger(q.class.getName());
        AtomicReferenceFieldUpdater.newUpdater(q.class, Set.class, "h");     // Catch: Throwable -> L5
        AtomicIntegerFieldUpdater.newUpdater(q.class, "i");     // Catch: Throwable -> L5
        th = null;
    L6:
        if (th == null) goto L11;
        f9429j.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        return;
    L11:
        return;
    L5:
        th = th;
        goto L6
    }
}
