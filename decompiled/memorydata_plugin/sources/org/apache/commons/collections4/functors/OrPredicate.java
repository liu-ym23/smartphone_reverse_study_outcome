package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public final class OrPredicate<T> implements Serializable, PredicateDecorator<T> {
    private static final long serialVersionUID = -8791518325735182855L;
    private final Predicate<? super T> iPredicate1;
    private final Predicate<? super T> iPredicate2;

    public OrPredicate(Predicate<? super T> r3, Predicate<? super T> r4) {
        Predicate<? super T> r5 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        Predicate<? super T> r6 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r4, Predicate.class, "com.obric.memorydata.plugin");
        this.iPredicate1 = r5;
        this.iPredicate2 = r6;
    }

    public static <T> Predicate<T> orPredicate(Predicate<? super T> r2, Predicate<? super T> r3) {
        Predicate r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin");
        Predicate r5 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L8;
        if (r5 == null) goto L8;
        return new OrPredicate(r4, r5);
    L8:
        throw new NullPointerException("Predicate must not be null");
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T r2) {
        if (this.iPredicate1.evaluate(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.iPredicate2.evaluate(r2) == true) goto L8;
        return false;
    }

    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.iPredicate1, this.iPredicate2};
    }
}
