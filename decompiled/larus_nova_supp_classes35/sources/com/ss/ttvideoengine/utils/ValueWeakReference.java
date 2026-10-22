package com.ss.ttvideoengine.utils;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ValueWeakReference<T> extends WeakReference<T> {
    public ValueWeakReference(T r1) {
        super(r1);
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof ValueWeakReference) == true) goto L5;
        return false;
    L5:
        T r0 = get();
        if (r0 != null) goto L9;
        return false;
    L9:
        return r0.equals(((ValueWeakReference) r3).get());
    }

    public ValueWeakReference(T r1, ReferenceQueue<? super T> r2) {
        super(r1, r2);
    }
}
