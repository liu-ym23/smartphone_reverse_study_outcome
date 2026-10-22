package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public final class NonePredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = 2007613066565892961L;

    public NonePredicate(Predicate<? super T>... r1) {
        super(r1);
    }

    public static <T> Predicate<T> nonePredicate(Collection<? extends Predicate<? super T>> r2) {
        Predicate[] r3 = FunctorUtils.validate((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"));
        if (r3.length != 0) goto L7;
        return TruePredicate.truePredicate();
    L7:
        return new NonePredicate(r3);
    }

    public static <T> Predicate<T> nonePredicate(Predicate<? super T>... r1) {
        FunctorUtils.validate(r1);
        if (r1.length != 0) goto L7;
        return TruePredicate.truePredicate();
    L7:
        return new NonePredicate(FunctorUtils.copy(r1));
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T r5) {
        Predicate<? super T>[] r4 = this.iPredicates;
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (r4[r2].evaluate(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }
}
