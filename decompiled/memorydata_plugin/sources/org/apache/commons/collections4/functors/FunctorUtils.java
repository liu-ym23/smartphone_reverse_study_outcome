package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
class FunctorUtils {
    static <T> Predicate<T> coerce(Predicate<? super T> r2) {
        return (Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin");
    }

    static <E> Closure<E>[] copy(Closure<? super E>... r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (Closure[]) ZeusTransformUtils.preCheckCast((Closure[]) ZeusTransformUtils.preCheckCast(r2.clone(), Closure[].class, "com.obric.memorydata.plugin"), Closure[].class, "com.obric.memorydata.plugin");
    }

    static <T> Predicate<T>[] copy(Predicate<? super T>... r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (Predicate[]) ZeusTransformUtils.preCheckCast((Predicate[]) ZeusTransformUtils.preCheckCast(r2.clone(), Predicate[].class, "com.obric.memorydata.plugin"), Predicate[].class, "com.obric.memorydata.plugin");
    }

    static <I, O> Transformer<I, O>[] copy(Transformer<? super I, ? extends O>... r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (Transformer[]) ZeusTransformUtils.preCheckCast((Transformer[]) ZeusTransformUtils.preCheckCast(r2.clone(), Transformer[].class, "com.obric.memorydata.plugin"), Transformer[].class, "com.obric.memorydata.plugin");
    }

    static void validate(Closure<?>... r3) {
        Objects.requireNonNull(r3, "The closure array must not be null");
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L10;
        if (r3[r0] == null) goto L9;
        r0 = r0 + 1;
        goto L4
    L9:
        throw new NullPointerException("The closure array must not contain a null closure, index " + r0 + " was null");
    }

    static void validate(Predicate<?>... r3) {
        Objects.requireNonNull(r3, "The predicate array must not be null");
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L10;
        if (r3[r0] == null) goto L9;
        r0 = r0 + 1;
        goto L4
    L9:
        throw new NullPointerException("The predicate array must not contain a null predicate, index " + r0 + " was null");
    }

    static void validate(Transformer<?, ?>... r3) {
        Objects.requireNonNull(r3, "The transformer array must not be null");
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L10;
        if (r3[r0] == null) goto L9;
        r0 = r0 + 1;
        goto L4
    L9:
        throw new NullPointerException("The transformer array must not contain a null transformer, index " + r0 + " was null");
    }

    static <T> Predicate<? super T>[] validate(Collection<? extends Predicate<? super T>> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6, "The predicate collection must not be null");
        Predicate<? super T>[] r0 = new Predicate[r6.size()];
        int r2 = 0;
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        r0[r2] = (Predicate) ZeusTransformUtils.preCheckCast(r7.next(), Predicate.class, "com.obric.memorydata.plugin");
        if (r0[r2] == null) goto L9;
        r2 = r2 + 1;
        goto L4
    L9:
        throw new NullPointerException("The predicate collection must not contain a null predicate, index " + r2 + " was null");
    L10:
        return r0;
    }
}
