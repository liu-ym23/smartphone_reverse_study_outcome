package com.ttnet.org.chromium.base;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class DiscardableReferencePool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Set<DiscardableReference<?>> mPool;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.DiscardableReferencePool$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class DiscardableReference<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private T mPayload;

        private DiscardableReference(T r8) {
            this.mPayload = r8;
        }

        public static /* synthetic */ void access$100(DiscardableReference r8) {
            r8.discard();
        }

        private void discard() {
            this.mPayload = null;
        }

        public T get() {
            return this.mPayload;
        }

        public /* synthetic */ DiscardableReference(Object r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public DiscardableReferencePool() {
        this.mPool = Collections.newSetFromMap(new WeakHashMap());
    }

    public void drain() {
        Iterator<DiscardableReference<?>> r8 = this.mPool.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        DiscardableReference.access$100(r8.next());
        goto L4
    L6:
        this.mPool.clear();
    }

    public <T> DiscardableReference<T> put(T r8) {
        DiscardableReference<T> r10 = new DiscardableReference(r8, null);
        this.mPool.add(r10);
        return r10;
    }

    public void remove(DiscardableReference<?> r8) {
        if (this.mPool.contains(r8) == true) goto L5;
        return;
    L5:
        DiscardableReference.access$100(r8);
        this.mPool.remove(r8);
    }
}
