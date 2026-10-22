package org.apache.commons.collections4.multiset;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Set;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;

/* JADX INFO: loaded from: classes6.dex */
public class PredicatedMultiSet<E> extends PredicatedCollection<E> implements MultiSet<E> {
    private static final long serialVersionUID = 20150629;

    public PredicatedMultiSet(MultiSet<E> r3, Predicate<? super E> r4) {
        super((MultiSet) ZeusTransformUtils.wrapperContextForParams(r3, MultiSet.class, "com.obric.memorydata.plugin"), (Predicate) ZeusTransformUtils.wrapperContextForParams(r4, Predicate.class, "com.obric.memorydata.plugin"));
    }

    public static <E> PredicatedMultiSet<E> predicatedMultiSet(MultiSet<E> r2, Predicate<? super E> r3) {
        return new PredicatedMultiSet((MultiSet) ZeusTransformUtils.wrapperContextForParams(r2, MultiSet.class, "com.obric.memorydata.plugin"), (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int add(E r1, int r2) {
        validate(r1);
        return decorated().add(r1, r2);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public /* bridge */ /* synthetic */ Collection decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public MultiSet<E> decorated() {
        return (MultiSet) ZeusTransformUtils.preCheckCast(super.decorated(), MultiSet.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<MultiSet.Entry<E>> entrySet() {
        return decorated().entrySet();
    }

    @Override // java.util.Collection, org.apache.commons.collections4.MultiSet
    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
    L7:
        return true;
    L4:
        if (decorated().equals(r1) == true) goto L7;
        return false;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int getCount(Object r1) {
        return decorated().getCount(r1);
    }

    @Override // java.util.Collection, org.apache.commons.collections4.MultiSet
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int remove(Object r1, int r2) {
        return decorated().remove(r1, r2);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int setCount(E r1, int r2) {
        validate(r1);
        return decorated().setCount(r1, r2);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<E> uniqueSet() {
        return decorated().uniqueSet();
    }
}
