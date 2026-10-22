package ue;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import pe.o1;
import ue.u;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u<S extends u<S>> extends c<S> implements o1 {
    private volatile int cleanedAndPointers;

    static {
        AtomicIntegerFieldUpdater.newUpdater(u.class, "cleanedAndPointers");
    }

    public abstract void a(int r8);
}
