package com.ttnet.org.chromium.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class DiscardableReferencePool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Set<DiscardableReference<?>> mPool;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.DiscardableReferencePool$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class DiscardableReference<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private T mPayload;

        static {
        }

        private DiscardableReference(T r1) {
            this.mPayload = r1;
        }

        /* synthetic */ DiscardableReference(Object r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ void access$100(DiscardableReference r0) {
            r0.discard();
        }

        private void discard() {
            this.mPayload = null;
        }

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
        Iterator<DiscardableReference<?>> r0 = this.mPool.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        DiscardableReference.access$100((DiscardableReference) ZeusTransformUtils.preCheckCast(r0.next(), DiscardableReference.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        this.mPool.clear();
    }

    public <T> DiscardableReference<T> put(T r3) {
        DiscardableReference<T> r0 = new DiscardableReference(r3, null);
        this.mPool.add(r0);
        return r0;
    }

    public void remove(DiscardableReference<?> r2) {
        if (this.mPool.contains(r2) == true) goto L5;
        return;
    L5:
        DiscardableReference.access$100(r2);
        this.mPool.remove(r2);
    }
}
