package org.apache.commons.collections4.multimap;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.SetUtils;
import org.apache.commons.collections4.SetValuedMap;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractSetValuedMap<K, V> extends AbstractMultiValuedMap<K, V> implements SetValuedMap<K, V> {

    private class WrappedSet extends AbstractMultiValuedMap<K, V>.WrappedCollection implements Set<V> {
        final /* synthetic */ AbstractSetValuedMap this$0;

        public WrappedSet(AbstractSetValuedMap r1, K r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object r3) {
            Set r2 = (Set) ZeusTransformUtils.preCheckCast(getMapping(), Set.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L7;
            return Collections.emptySet().equals(r3);
        L7:
            if (ZeusTransformUtils.instanceOf(r3, Set.class) == true) goto L11;
            return false;
        L11:
            return SetUtils.isEqualSet(r2, (Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return SetUtils.hashCodeForSet((Set) ZeusTransformUtils.preCheckCast(getMapping(), Set.class, "com.obric.memorydata.plugin"));
        }
    }

    public AbstractSetValuedMap() {
    }

    public AbstractSetValuedMap(Map<K, ? extends Set<V>> r3) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public abstract Set<V> createCollection();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap, org.apache.commons.collections4.MultiValuedMap
    public /* bridge */ /* synthetic */ Collection get(Object r1) {
        return get(r1);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap, org.apache.commons.collections4.MultiValuedMap
    public Set<V> get(K r1) {
        return wrappedCollection(r1);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public Map<K, Set<V>> getMap() {
        return super.getMap();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap, org.apache.commons.collections4.MultiValuedMap
    public /* bridge */ /* synthetic */ Collection remove(Object r1) {
        return remove(r1);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap, org.apache.commons.collections4.MultiValuedMap
    public Set<V> remove(Object r2) {
        return SetUtils.emptyIfNull((Set) ZeusTransformUtils.preCheckCast(getMap().remove(r2), Set.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    /* bridge */ /* synthetic */ Collection wrappedCollection(Object r1) {
        return wrappedCollection(r1);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    Set<V> wrappedCollection(K r2) {
        return new WrappedSet(this, r2);
    }
}
