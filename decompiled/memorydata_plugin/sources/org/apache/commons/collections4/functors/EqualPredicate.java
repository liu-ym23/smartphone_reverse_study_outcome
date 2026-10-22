package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public final class EqualPredicate<T> implements Serializable, Predicate<T> {
    private static final long serialVersionUID = 5633766978029907089L;
    private final Equator<T> equator;
    private final T iValue;

    public EqualPredicate(T r2) {
        this(r2, null);
    }

    public EqualPredicate(T r3, Equator<T> r4) {
        Equator<T> r5 = (Equator) ZeusTransformUtils.wrapperContextForParams(r4, Equator.class, "com.obric.memorydata.plugin");
        this.iValue = r3;
        this.equator = r5;
    }

    public static <T> Predicate<T> equalPredicate(T r1) {
        if (r1 != null) goto L6;
        return NullPredicate.nullPredicate();
    L6:
        return new EqualPredicate(r1);
    }

    public static <T> Predicate<T> equalPredicate(T r2, Equator<T> r3) {
        Equator r4 = (Equator) ZeusTransformUtils.wrapperContextForParams(r3, Equator.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return NullPredicate.nullPredicate();
    L7:
        return new EqualPredicate(r2, r4);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T r2) {
        Equator<T> r0 = this.equator;
        T r1 = this.iValue;
        if (r0 == null) goto L7;
        return r0.equate(r1, r2);
    L7:
        return r1.equals(r2);
    }

    public Object getValue() {
        return this.iValue;
    }
}
