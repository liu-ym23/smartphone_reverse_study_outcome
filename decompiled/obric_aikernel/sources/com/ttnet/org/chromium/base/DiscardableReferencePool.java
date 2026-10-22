package com.ttnet.org.chromium.base;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class DiscardableReferencePool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Set<DiscardableReference<?>> mPool;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.DiscardableReferencePool$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class DiscardableReference<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Nullable
        private T mPayload;

        static {
        }

        private DiscardableReference(T r10) {
            this.mPayload = r10;
        }

        /* synthetic */ DiscardableReference(Object r10, AnonymousClass1 r11) {
            this(r10);
        }

        static /* synthetic */ void access$100(DiscardableReference r10) {
            r10.discard();
        }

        private void discard() {
            this.mPayload = null;
        }

        @Nullable
        public T get() {
            return this.mPayload;
        }
    }

    static {
    }

    public DiscardableReferencePool() {
        this.mPool = Collections.newSetFromMap(new WeakHashMap());
    }

    public void drain() {
        Iterator<DiscardableReference<?>> r10 = this.mPool.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        DiscardableReference.access$100(r10.next());
        goto L4
    L6:
        this.mPool.clear();
    }

    public <T> DiscardableReference<T> put(T r10) {
        DiscardableReference<T> r11 = new DiscardableReference(r10, null);
        this.mPool.add(r11);
        return r11;
    }

    public void remove(DiscardableReference<?> r10) {
        if (this.mPool.contains(r10) == true) goto L5;
        return;
    L5:
        DiscardableReference.access$100(r10);
        this.mPool.remove(r10);
    }
}
