package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Equator;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultEquator<T> implements Serializable, Equator<T> {
    public static final int HASHCODE_NULL = -1;
    public static final DefaultEquator INSTANCE = null;
    private static final long serialVersionUID = 825802648423525485L;

    static {
        INSTANCE = new DefaultEquator();
    }

    private DefaultEquator() {
    }

    public static <T> DefaultEquator<T> defaultEquator() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Equator
    public boolean equate(T r1, T r2) {
        if (r1 == r2) goto L8;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.equals(r2) == false) goto L7;
    L8:
        return true;
    }

    public int hash(T r1) {
        if (r1 != null) goto L5;
        return -1;
    L5:
        return r1.hashCode();
    }
}
