package com.google.common.util.concurrent;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
abstract class d<OutputT> extends com.google.common.util.concurrent.a.i<OutputT> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f4857b = null;
    private static final Logger c = null;
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static abstract class a {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }
    }

    private static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<d<?>, Set<Throwable>> f4858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicIntegerFieldUpdater<d<?>> f4859b;

        b(AtomicReferenceFieldUpdater r2, AtomicIntegerFieldUpdater r3) {
            super(null);
            this.f4858a = r2;
            this.f4859b = r3;
        }
    }

    private static final class c extends a {
        private c() {
            super(null);
        }

        /* synthetic */ c(AnonymousClass1 r1) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        c = Logger.getLogger(d.class.getName());
        Throwable r1 = null;
        Object[] r2 = 0;
        a r3 = new b(AtomicReferenceFieldUpdater.newUpdater(d.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(d.class, "remaining"));     // Catch: Throwable -> L5
    L7:
        f4857b = r3;
        if (r1 == null) goto L13;
        c.log(Level.SEVERE, "SafeAtomicHelper is broken!", r1);
        return;
    L13:
        return;
    L5:
        e = move-exception;
        r3 = new c(r2 == true ? 1 : 0);
        r1 = e;
        goto L7
    }
}
