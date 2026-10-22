package com.bytedance.android.bst.api.ext;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c<T> extends WeakReference<T> {
    public final int hashCode() {
        T r0 = get();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public c(T r1) {
        super(r1);
    }

    public final boolean equals(Object r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if ((r10 instanceof c) == true) goto L9;
        return false;
    L9:
        if (get() != ((c) r10).get()) goto L12;
        return true;
    L12:
        return false;
    }
}
