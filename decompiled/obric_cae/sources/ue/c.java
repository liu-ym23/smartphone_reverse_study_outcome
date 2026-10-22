package ue;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ue.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c<N extends c<N>> {
    private volatile Object _next;
    private volatile Object _prev;

    static {
        AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_next");
        AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_prev");
    }
}
