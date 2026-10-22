package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator;
import org.apache.commons.collections4.set.AbstractSetDecorator;

/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractInputCheckedMapDecorator<K, V> extends AbstractMapDecorator<K, V> {

    private class EntrySet extends AbstractSetDecorator<Map.Entry<K, V>> {
        private static final long serialVersionUID = 4354731610923110264L;
        private final AbstractInputCheckedMapDecorator<K, V> parent;
        final /* synthetic */ AbstractInputCheckedMapDecorator this$0;

        public EntrySet(AbstractInputCheckedMapDecorator r3, Set<Map.Entry<K, V>> r4, AbstractInputCheckedMapDecorator<K, V> r5) {
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r6);
            this.parent = r5;
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntrySetIterator(this.this$0, decorated().iterator(), this.parent);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
        public Object[] toArray() {
            Object[] r0 = decorated().toArray();
            int r1 = 0;
        L4:
            if (r1 >= r0.length) goto L6;
            r0[r1] = new MapEntry(this.this$0, (Map.Entry) ZeusTransformUtils.preCheckCast(r0[r1], Map.Entry.class, "com.obric.memorydata.plugin"), this.parent);
            r1 = r1 + 1;
            goto L4
        L6:
            return r0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
        public <T> T[] toArray(T[] r9) {
            if (r9.length <= 0) goto L5;
            Object[] r0 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r9.getClass().getComponentType(), 0), Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin");
        L6:
            Object[] r1 = decorated().toArray(r0);
            int r3 = 0;
        L8:
            if (r3 >= r1.length) goto L11;
            r1[r3] = new MapEntry(this.this$0, (Map.Entry) ZeusTransformUtils.preCheckCast(r1[r3], Map.Entry.class, "com.obric.memorydata.plugin"), this.parent);
            r3 = r3 + 1;
            goto L8
        L11:
            if (r1.length > r9.length) goto L13;
            System.arraycopy(r1, 0, r9, 0, r1.length);
            if (r9.length <= r1.length) goto L17;
            r9[r1.length] = null;
        L17:
            return r9;
        L13:
            return (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(r1, Object[].class, "com.obric.memorydata.plugin"));
        L5:
            r0 = r9;
            goto L6
        }
    }

    private class EntrySetIterator extends AbstractIteratorDecorator<Map.Entry<K, V>> {
        private final AbstractInputCheckedMapDecorator<K, V> parent;
        final /* synthetic */ AbstractInputCheckedMapDecorator this$0;

        public EntrySetIterator(AbstractInputCheckedMapDecorator r3, Iterator<Map.Entry<K, V>> r4, AbstractInputCheckedMapDecorator<K, V> r5) {
            Iterator r6 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r6);
            this.parent = r5;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public Map.Entry<K, V> next() {
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(getIterator().next(), Map.Entry.class, "com.obric.memorydata.plugin");
            return new MapEntry(this.this$0, r0, this.parent);
        }
    }

    private class MapEntry extends AbstractMapEntryDecorator<K, V> {
        private final AbstractInputCheckedMapDecorator<K, V> parent;
        final /* synthetic */ AbstractInputCheckedMapDecorator this$0;

        public MapEntry(AbstractInputCheckedMapDecorator r3, Map.Entry<K, V> r4, AbstractInputCheckedMapDecorator<K, V> r5) {
            Map.Entry r6 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r6);
            this.parent = r5;
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator, java.util.Map.Entry
        public V setValue(V r2) {
            V r3 = this.parent.checkSetValue(r2);
            return getMapEntry().setValue(r3);
        }
    }

    public AbstractInputCheckedMapDecorator() {
    }

    public AbstractInputCheckedMapDecorator(Map<K, V> r3) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    public abstract V checkSetValue(V r1);

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (isSetValueChecking() == false) goto L7;
        return new EntrySet(this, this.map.entrySet(), this);
    L7:
        return this.map.entrySet();
    }

    public boolean isSetValueChecking() {
        return true;
    }
}
