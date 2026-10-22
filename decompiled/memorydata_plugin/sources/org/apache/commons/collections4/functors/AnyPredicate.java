package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public final class AnyPredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = 7429999530934647542L;

    public AnyPredicate(Predicate<? super T>... r1) {
        super(r1);
    }

    public static <T> Predicate<T> anyPredicate(Collection<? extends Predicate<? super T>> r2) {
        Predicate<T>[] r3 = FunctorUtils.validate((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"));
        if (r3.length != 0) goto L7;
        return FalsePredicate.falsePredicate();
    L7:
        if (r3.length != 1) goto L11;
        return r3[0];
    L11:
        return new AnyPredicate(r3);
    }

    public static <T> Predicate<T> anyPredicate(Predicate<? super T>... r2) {
        FunctorUtils.validate(r2);
        if (r2.length != 0) goto L7;
        return FalsePredicate.falsePredicate();
    L7:
        if (r2.length != 1) goto L11;
        return (Predicate<T>) r2[0];
    L11:
        return new AnyPredicate(FunctorUtils.copy(r2));
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T r5) {
        Predicate<? super T>[] r4 = this.iPredicates;
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4[r2].evaluate(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
