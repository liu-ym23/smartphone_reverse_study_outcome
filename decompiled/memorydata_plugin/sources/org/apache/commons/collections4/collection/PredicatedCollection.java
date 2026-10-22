package org.apache.commons.collections4.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.NotNullPredicate;

/* JADX INFO: loaded from: classes6.dex */
public class PredicatedCollection<E> extends AbstractCollectionDecorator<E> {
    private static final long serialVersionUID = -5259182142076705162L;
    protected final Predicate<? super E> predicate;

    public static class Builder<E> {
        private final List<E> accepted;
        private final Predicate<? super E> predicate;
        private final List<E> rejected;

        public Builder(Predicate<? super E> r3) {
            Predicate<? super E> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            this.accepted = new ArrayList();
            this.rejected = new ArrayList();
            Objects.requireNonNull(r4, "Predicate must not be null");
            this.predicate = r4;
        }
    }

    public PredicatedCollection(Collection<E> r3, Predicate<? super E> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Predicate<? super E> r6 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r4, Predicate.class, "com.obric.memorydata.plugin");
        super(r5);
        Objects.requireNonNull(r6, "Predicate must not be null.");
        this.predicate = r6;
        Iterator<E> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        validate(r7.next());
        goto L4
    }

    public static <E> Builder<E> builder(Predicate<? super E> r2) {
        return new Builder((Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin"));
    }

    public static <E> Builder<E> notNullBuilder() {
        return new Builder(NotNullPredicate.notNullPredicate());
    }

    public static <T> PredicatedCollection<T> predicatedCollection(Collection<T> r2, Predicate<? super T> r3) {
        return new PredicatedCollection((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"), (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean add(E r1) {
        validate(r1);
        return decorated().add(r1);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Iterator<? extends E> r0 = r4.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        validate(r0.next());
        goto L4
    L7:
        return decorated().addAll(r4);
    }

    public void validate(E r4) {
        if (this.predicate.evaluate(r4) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Cannot add Object '" + r4 + "' - Predicate '" + this.predicate + "' rejected it");
    }
}
