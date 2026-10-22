package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public final class OnePredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = -8125389089924745785L;

    public OnePredicate(Predicate<? super T>... r1) {
        super(r1);
    }

    public static <T> Predicate<T> onePredicate(Collection<? extends Predicate<? super T>> r2) {
        return new OnePredicate(FunctorUtils.validate((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin")));
    }

    public static <T> Predicate<T> onePredicate(Predicate<? super T>... r2) {
        FunctorUtils.validate(r2);
        if (r2.length != 0) goto L7;
        return FalsePredicate.falsePredicate();
    L7:
        if (r2.length != 1) goto L11;
        return (Predicate<T>) r2[0];
    L11:
        return new OnePredicate(FunctorUtils.copy(r2));
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T r6) {
        Predicate<? super T>[] r5 = this.iPredicates;
        int r0 = r5.length;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r0) goto L10;
        if (r5[r2].evaluate(r6) == false) goto L9;
        if (r3 == true) goto L7;
        r3 = true;
        goto L9
    L7:
        return false;
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r3;
    }
}
