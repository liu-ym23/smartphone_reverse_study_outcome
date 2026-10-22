package org.apache.commons.collections4.trie;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedMapIterator;

/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractPatriciaTrie<K, V> extends AbstractBitwiseTrie<K, V> {
    private static final long serialVersionUID = 5155253417231339498L;
    private volatile transient Set<Map.Entry<K, V>> entrySet;
    private volatile transient Set<K> keySet;
    protected transient int modCount;
    private transient TrieEntry<K, V> root;
    private transient int size;
    private volatile transient Collection<V> values;

    /* JADX INFO: renamed from: org.apache.commons.collections4.trie.AbstractPatriciaTrie$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ AbstractPatriciaTrie this$0;

        private class EntryIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<Map.Entry<K, V>> {
            final /* synthetic */ EntrySet this$1;

            private EntryIterator(EntrySet r1) {
                this.this$1 = r1;
                super(r1.this$0);
            }

            /* synthetic */ EntryIterator(EntrySet r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ Object next() {
                return next();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return nextEntry();
            }
        }

        private EntrySet(AbstractPatriciaTrie r1) {
            this.this$0 = r1;
        }

        /* synthetic */ EntrySet(AbstractPatriciaTrie r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == true) goto L5;
            return false;
        L5:
            TrieEntry<K, V> r3 = this.this$0.getEntry(((Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin")).getKey());
            if (r3 != null) goto L8;
            return false;
        L8:
            if (r3.equals(r4) == false) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == true) goto L6;
            return false;
        L6:
            if (contains(r3) == true) goto L8;
            return false;
        L8:
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            this.this$0.remove(r4.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }
    }

    private class KeySet extends AbstractSet<K> {
        final /* synthetic */ AbstractPatriciaTrie this$0;

        private class KeyIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<K> {
            final /* synthetic */ KeySet this$1;

            private KeyIterator(KeySet r1) {
                this.this$1 = r1;
                super(r1.this$0);
            }

            /* synthetic */ KeyIterator(KeySet r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // java.util.Iterator
            public K next() {
                return nextEntry().getKey();
            }
        }

        private KeySet(AbstractPatriciaTrie r1) {
            this.this$0 = r1;
        }

        /* synthetic */ KeySet(AbstractPatriciaTrie r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.this$0.containsKey(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator(this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            int r0 = size();
            this.this$0.remove(r3);
            if (r0 == size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }
    }

    private final class PrefixRangeEntrySet extends AbstractPatriciaTrie<K, V>.RangeEntrySet {
        private final AbstractPatriciaTrie<K, V>.PrefixRangeMap delegate;
        private int expectedModCount;
        private TrieEntry<K, V> prefixStart;
        final /* synthetic */ AbstractPatriciaTrie this$0;

        private final class EntryIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<Map.Entry<K, V>> {
            private boolean lastOne;
            private final int lengthInBits;
            private final int offset;
            private final K prefix;
            private TrieEntry<K, V> subtree;
            final /* synthetic */ PrefixRangeEntrySet this$1;

            EntryIterator(PrefixRangeEntrySet r2, TrieEntry<K, V> r3, K r4, int r5, int r6) {
                this.this$1 = r2;
                super(r2.this$0);
                this.subtree = r3;
                this.next = r2.this$0.followLeft(r3);
                this.prefix = r4;
                this.offset = r5;
                this.lengthInBits = r6;
            }

            @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.TrieIterator
            public TrieEntry<K, V> findNext(TrieEntry<K, V> r2) {
                return this.this$1.this$0.nextEntryInSubtree(r2, this.subtree);
            }

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ Object next() {
                return next();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                TrieEntry<K, V> r0 = nextEntry();
                if (this.lastOne == false) goto L5;
                this.next = null;
            L5:
                return r0;
            }

            @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.TrieIterator, java.util.Iterator
            public void remove() {
                int r0 = this.subtree.bitIndex;
                if (this.current != this.subtree) goto L5;
                boolean r1 = true;
            L6:
                super.remove();
                if (r0 != this.subtree.bitIndex) goto L9;
                if (r1 == true) goto L9;
            L11:
                if (this.lengthInBits < this.subtree.bitIndex) goto L14;
                this.lastOne = true;
                return;
            L14:
                return;
            L9:
                this.subtree = this.this$1.this$0.subtree(this.prefix, this.offset, this.lengthInBits);
                goto L11
            L5:
                r1 = false;
                goto L6
            }
        }

        private final class SingletonIterator implements Iterator<Map.Entry<K, V>> {
            private final TrieEntry<K, V> entry;
            private int hit;
            final /* synthetic */ PrefixRangeEntrySet this$1;

            public SingletonIterator(PrefixRangeEntrySet r1, TrieEntry<K, V> r2) {
                this.this$1 = r1;
                this.hit = 0;
                this.entry = r2;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.hit != 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ Object next() {
                return next();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                int r0 = this.hit;
                if (r0 != 0) goto L7;
                this.hit = r0 + 1;
                return this.entry;
            L7:
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                int r0 = this.hit;
                if (r0 != 1) goto L7;
                this.hit = r0 + 1;
                this.this$1.this$0.removeEntry(this.entry);
                return;
            L7:
                throw new IllegalStateException();
            }
        }

        public PrefixRangeEntrySet(AbstractPatriciaTrie r1, AbstractPatriciaTrie<K, V>.PrefixRangeMap r2) {
            this.this$0 = r1;
            super(r1, r2);
            this.expectedModCount = 0;
            this.delegate = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeEntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            if (this.this$0.modCount == this.expectedModCount) goto L6;
            this.prefixStart = this.this$0.subtree(PrefixRangeMap.access$1200(this.delegate), PrefixRangeMap.access$1300(this.delegate), PrefixRangeMap.access$1400(this.delegate));
            this.expectedModCount = this.this$0.modCount;
        L6:
            if (this.prefixStart != null) goto L10;
            return Collections.emptySet().iterator();
        L10:
            if (PrefixRangeMap.access$1400(this.delegate) <= this.prefixStart.bitIndex) goto L14;
            return new SingletonIterator(this, this.prefixStart);
        L14:
            return new EntryIterator(this, this.prefixStart, PrefixRangeMap.access$1200(this.delegate), PrefixRangeMap.access$1300(this.delegate), PrefixRangeMap.access$1400(this.delegate));
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeEntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return PrefixRangeMap.access$1100(this.delegate);
        }
    }

    private class PrefixRangeMap extends AbstractPatriciaTrie<K, V>.RangeMap {
        private transient int expectedModCount;
        private K fromKey;
        private final int lengthInBits;
        private final int offsetInBits;
        private final K prefix;
        private int size;
        final /* synthetic */ AbstractPatriciaTrie this$0;
        private K toKey;

        private PrefixRangeMap(AbstractPatriciaTrie r2, K r3, int r4, int r5) {
            this.this$0 = r2;
            super(r2, null);
            this.fromKey = null;
            this.toKey = null;
            this.expectedModCount = 0;
            this.size = -1;
            this.prefix = r3;
            this.offsetInBits = r4;
            this.lengthInBits = r5;
        }

        /* synthetic */ PrefixRangeMap(AbstractPatriciaTrie r1, Object r2, int r3, int r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        static /* synthetic */ int access$1100(PrefixRangeMap r0) {
            return r0.fixup();
        }

        static /* synthetic */ Object access$1200(PrefixRangeMap r0) {
            return r0.prefix;
        }

        static /* synthetic */ int access$1300(PrefixRangeMap r0) {
            return r0.offsetInBits;
        }

        static /* synthetic */ int access$1400(PrefixRangeMap r0) {
            return r0.lengthInBits;
        }

        private int fixup() {
            if (this.size != (-1)) goto L5;
        L6:
            Iterator<Map.Entry<K, V>> r0 = super.entrySet().iterator();
            this.size = 0;
            K r4 = null;
            if (r0.hasNext() == false) goto L9;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            this.size = 1;
        L10:
            if (r1 != null) goto L12;
            K r5 = null;
        L13:
            this.fromKey = r5;
            if (r5 == null) goto L20;
            TrieEntry<K, V> r6 = this.this$0.previousEntry((TrieEntry) ZeusTransformUtils.preCheckCast(r1, TrieEntry.class, "com.obric.memorydata.plugin"));
            if (r6 != null) goto L18;
            K r7 = null;
        L19:
            this.fromKey = r7;
            goto L20
        L18:
            r7 = r6.getKey();
        L20:
            this.toKey = this.fromKey;
        L22:
            if (r0.hasNext() == false) goto L24;
            this.size++;
            r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            goto L22
        L24:
            if (r1 != null) goto L26;
            K r2 = null;
        L27:
            this.toKey = r2;
            if (r2 == null) goto L34;
            TrieEntry<K, V> r3 = this.this$0.nextEntry((TrieEntry) ZeusTransformUtils.preCheckCast(r1, TrieEntry.class, "com.obric.memorydata.plugin"));
            if (r3 == null) goto L33;
            r4 = r3.getKey();
        L33:
            this.toKey = r4;
        L34:
            this.expectedModCount = this.this$0.modCount;
        L36:
            return this.size;
        L26:
            r2 = (K) r1.getKey();
            goto L27
        L12:
            r5 = (K) r1.getKey();
            goto L13
        L9:
            r1 = null;
            goto L10
        L5:
            if (this.this$0.modCount == this.expectedModCount) goto L36;
            goto L6
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterator<Map.Entry<K, V>> r0 = this.this$0.entrySet().iterator();
            Set r4 = keySet();
        L4:
            if (r0.hasNext() == false) goto L8;
            if (r4.contains(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey()) == false) goto L4;
            r0.remove();
            goto L4
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public Set<Map.Entry<K, V>> createEntrySet() {
            return new PrefixRangeEntrySet(this.this$0, this);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public SortedMap<K, V> createRangeMap(K r8, boolean r9, K r10, boolean r11) {
            return new RangeEntryMap(this.this$0, r8, r9, r10, r11);
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            fixup();
            K r0 = this.fromKey;
            if (r0 != null) goto L5;
            TrieEntry<K, V> r1 = this.this$0.firstEntry();
        L6:
            if (r1 == null) goto L8;
            K r2 = r1.getKey();
        L9:
            if (r1 == null) goto L14;
            if (this.this$0.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, r2) == false) goto L14;
            return r2;
        L14:
            throw new NoSuchElementException();
        L8:
            r2 = null;
            goto L9
        L5:
            r1 = this.this$0.higherEntry(r0);
            goto L6
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public K getFromKey() {
            return this.fromKey;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public K getToKey() {
            return this.toKey;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean inFromRange(K r3, boolean r4) {
            return this.this$0.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, r3);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean inRange(K r4) {
            return this.this$0.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, r4);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean inRange2(K r1) {
            return inRange(r1);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean inToRange(K r3, boolean r4) {
            return this.this$0.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, r3);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean isFromInclusive() {
            return false;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean isToInclusive() {
            return false;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            fixup();
            K r0 = this.toKey;
            if (r0 != null) goto L5;
            TrieEntry<K, V> r1 = this.this$0.lastEntry();
        L6:
            if (r1 == null) goto L8;
            K r2 = r1.getKey();
        L9:
            if (r1 == null) goto L14;
            if (this.this$0.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, r2) == false) goto L14;
            return r2;
        L14:
            throw new NoSuchElementException();
        L8:
            r2 = null;
            goto L9
        L5:
            r1 = this.this$0.lowerEntry(r0);
            goto L6
        }
    }

    private class RangeEntryMap extends AbstractPatriciaTrie<K, V>.RangeMap {
        private final boolean fromInclusive;
        private final K fromKey;
        final /* synthetic */ AbstractPatriciaTrie this$0;
        private final boolean toInclusive;
        private final K toKey;

        public RangeEntryMap(AbstractPatriciaTrie r7, K r8, K r9) {
            this(r7, r8, true, r9, false);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RangeEntryMap(AbstractPatriciaTrie r2, K r3, boolean r4, K r5, boolean r6) {
            this.this$0 = r2;
            super(r2, null);
            if (r3 != 0) goto L8;
            if (r5 != 0) goto L8;
            throw new IllegalArgumentException("must have a from or to!");
        L8:
            if (r3 == 0) goto L15;
            if (r5 == 0) goto L15;
            if (r2.getKeyAnalyzer().compare(r3, r5) <= 0) goto L15;
            throw new IllegalArgumentException("fromKey > toKey");
        L15:
            this.fromKey = r3;
            this.fromInclusive = r4;
            this.toKey = r5;
            this.toInclusive = r6;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public Set<Map.Entry<K, V>> createEntrySet() {
            return new RangeEntrySet(this.this$0, this);
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public SortedMap<K, V> createRangeMap(K r8, boolean r9, K r10, boolean r11) {
            return new RangeEntryMap(this.this$0, r8, r9, r10, r11);
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            K r0 = this.fromKey;
            if (r0 != null) goto L6;
            TrieEntry<K, V> r1 = this.this$0.firstEntry();
        L9:
            if (r1 == null) goto L11;
            K r2 = r1.getKey();
        L12:
            if (r1 == null) goto L19;
            if (this.toKey != null) goto L16;
        L17:
            return r2;
        L16:
            if (inToRange(r2, false) == true) goto L17;
        L19:
            throw new NoSuchElementException();
        L11:
            r2 = null;
            goto L12
        L6:
            if (this.fromInclusive == false) goto L8;
            r1 = this.this$0.ceilingEntry(r0);
            goto L9
        L8:
            r1 = this.this$0.higherEntry(r0);
            goto L9
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public K getFromKey() {
            return this.fromKey;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public K getToKey() {
            return this.toKey;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean isFromInclusive() {
            return this.fromInclusive;
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.RangeMap
        public boolean isToInclusive() {
            return this.toInclusive;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            K r0 = this.toKey;
            if (r0 != null) goto L6;
            TrieEntry<K, V> r1 = this.this$0.lastEntry();
        L9:
            if (r1 == null) goto L11;
            K r2 = r1.getKey();
        L12:
            if (r1 == null) goto L19;
            if (this.fromKey != null) goto L16;
        L17:
            return r2;
        L16:
            if (inFromRange(r2, false) == true) goto L17;
        L19:
            throw new NoSuchElementException();
        L11:
            r2 = null;
            goto L12
        L6:
            if (this.toInclusive == false) goto L8;
            r1 = this.this$0.floorEntry(r0);
            goto L9
        L8:
            r1 = this.this$0.lowerEntry(r0);
            goto L9
        }
    }

    private class RangeEntrySet extends AbstractSet<Map.Entry<K, V>> {
        private final AbstractPatriciaTrie<K, V>.RangeMap delegate;
        private transient int expectedModCount;
        private transient int size;
        final /* synthetic */ AbstractPatriciaTrie this$0;

        private final class EntryIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<Map.Entry<K, V>> {
            private final K excludedKey;
            final /* synthetic */ RangeEntrySet this$1;

            private EntryIterator(RangeEntrySet r1, TrieEntry<K, V> r2, TrieEntry<K, V> r3) {
                this.this$1 = r1;
                super(r1.this$0, r2);
                if (r3 == null) goto L5;
                K r4 = r3.getKey();
            L6:
                this.excludedKey = r4;
                return;
            L5:
                r4 = null;
                goto L6
            }

            /* synthetic */ EntryIterator(RangeEntrySet r1, TrieEntry r2, TrieEntry r3, AnonymousClass1 r4) {
                this(r1, r2, r3);
            }

            @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.TrieIterator, java.util.Iterator
            public boolean hasNext() {
                if (this.next != null) goto L5;
            L7:
                return false;
            L5:
                if (AbstractBitwiseTrie.compare(this.next.key, this.excludedKey) == true) goto L7;
                return true;
            }

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ Object next() {
                return next();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                if (this.next == null) goto L9;
                if (AbstractBitwiseTrie.compare(this.next.key, this.excludedKey) == true) goto L9;
                return nextEntry();
            L9:
                throw new NoSuchElementException();
            }
        }

        public RangeEntrySet(AbstractPatriciaTrie r1, AbstractPatriciaTrie<K, V>.RangeMap r2) {
            this.this$0 = r1;
            this.size = -1;
            Objects.requireNonNull(r2, "delegate");
            this.delegate = r2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == true) goto L5;
            return false;
        L5:
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            Object r0 = r5.getKey();
            if (this.delegate.inRange((K) r0) == true) goto L8;
            return false;
        L8:
            TrieEntry<K, V> r3 = this.this$0.getEntry(r0);
            if (r3 != null) goto L11;
            return false;
        L11:
            if (AbstractBitwiseTrie.compare(r3.getValue(), r5.getValue()) == false) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return !iterator().hasNext();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            K r0 = this.delegate.getFromKey();
            K r1 = this.delegate.getToKey();
            if (r0 != null) goto L5;
            TrieEntry<K, V> r2 = this.this$0.firstEntry();
        L6:
            AnonymousClass1 r3 = null;
            if (r1 == null) goto L9;
            TrieEntry<K, V> r4 = this.this$0.ceilingEntry(r1);
        L11:
            return new EntryIterator(this, r2, r4, r3);
        L9:
            r4 = null;
            goto L11
        L5:
            r2 = this.this$0.ceilingEntry(r0);
            goto L6
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == true) goto L5;
            return false;
        L5:
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            Object r0 = r5.getKey();
            if (this.delegate.inRange((K) r0) == true) goto L8;
            return false;
        L8:
            TrieEntry<K, V> r1 = this.this$0.getEntry(r0);
            if (r1 != null) goto L11;
        L14:
            return false;
        L11:
            if (AbstractBitwiseTrie.compare(r1.getValue(), r5.getValue()) == false) goto L14;
            this.this$0.removeEntry(r1);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            if (this.size != (-1)) goto L5;
        L6:
            this.size = 0;
            Iterator<Map.Entry<K, V>> r0 = iterator();
        L8:
            if (r0.hasNext() == false) goto L10;
            this.size++;
            r0.next();
            goto L8
        L10:
            this.expectedModCount = this.this$0.modCount;
        L12:
            return this.size;
        L5:
            if (this.expectedModCount == this.this$0.modCount) goto L12;
            goto L6
        }
    }

    private abstract class RangeMap extends AbstractMap<K, V> implements SortedMap<K, V> {
        private volatile transient Set<Map.Entry<K, V>> entrySet;
        final /* synthetic */ AbstractPatriciaTrie this$0;

        private RangeMap(AbstractPatriciaTrie r1) {
            this.this$0 = r1;
        }

        /* synthetic */ RangeMap(AbstractPatriciaTrie r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.this$0.comparator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r2) {
            if (inRange(this.this$0.castKey(r2)) == true) goto L7;
            return false;
        L7:
            return this.this$0.containsKey(r2);
        }

        public abstract Set<Map.Entry<K, V>> createEntrySet();

        public abstract SortedMap<K, V> createRangeMap(K r1, boolean r2, K r3, boolean r4);

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set<Map.Entry<K, V>> entrySet() {
            if (this.entrySet != null) goto L6;
            this.entrySet = createEntrySet();
        L6:
            return this.entrySet;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object r2) {
            if (inRange(this.this$0.castKey(r2)) == true) goto L7;
            return null;
        L7:
            return (V) this.this$0.get(r2);
        }

        public abstract K getFromKey();

        public abstract K getToKey();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(K r4) {
            if (inRange2(r4) == false) goto L7;
            return createRangeMap(getFromKey(), isFromInclusive(), r4, isToInclusive());
        L7:
            throw new IllegalArgumentException("ToKey is out of range: " + r4);
        }

        public boolean inFromRange(K r3, boolean r4) {
            Object r0 = getFromKey();
            boolean r1 = isFromInclusive();
            int r2 = this.this$0.getKeyAnalyzer().compare(r3, r0);
            if (r1 == true) goto L10;
            if (r4 == true) goto L10;
            if (r2 <= 0) goto L9;
            return true;
        L9:
            return false;
        L10:
            if (r2 < 0) goto L13;
            return true;
        L13:
            return false;
        }

        public boolean inRange(K r4) {
            Object r0 = getFromKey();
            Object r1 = getToKey();
            if (r0 != null) goto L5;
        L6:
            if (r1 != null) goto L8;
        L9:
            return true;
        L8:
            if (inToRange(r4, false) == true) goto L9;
            return false;
        L5:
            if (inFromRange(r4, false) == true) goto L6;
            return false;
        }

        public boolean inRange2(K r5) {
            Object r0 = getFromKey();
            Object r1 = getToKey();
            if (r0 != null) goto L5;
        L6:
            if (r1 != null) goto L8;
            return true;
        L8:
            if (inToRange(r5, true) == false) goto L11;
            return true;
        L11:
            return false;
        L5:
            if (inFromRange(r5, false) == false) goto L11;
            goto L6
        }

        public boolean inToRange(K r3, boolean r4) {
            Object r0 = getToKey();
            boolean r1 = isToInclusive();
            int r2 = this.this$0.getKeyAnalyzer().compare(r3, r0);
            if (r1 == true) goto L10;
            if (r4 == true) goto L10;
            if (r2 >= 0) goto L9;
            return true;
        L9:
            return false;
        L10:
            if (r2 > 0) goto L13;
            return true;
        L13:
            return false;
        }

        public abstract boolean isFromInclusive();

        public abstract boolean isToInclusive();

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K r2, V r3) {
            if (inRange(r2) == false) goto L7;
            return (V) this.this$0.put(r2, r3);
        L7:
            throw new IllegalArgumentException("Key is out of range: " + r2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object r2) {
            if (inRange(this.this$0.castKey(r2)) == true) goto L7;
            return null;
        L7:
            return (V) this.this$0.remove(r2);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(K r3, K r4) {
            if (inRange2(r3) == false) goto L11;
            if (inRange2(r4) == false) goto L9;
            return createRangeMap(r3, isFromInclusive(), r4, isToInclusive());
        L9:
            throw new IllegalArgumentException("ToKey is out of range: " + r4);
        L11:
            throw new IllegalArgumentException("FromKey is out of range: " + r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(K r4) {
            if (inRange2(r4) == false) goto L7;
            return createRangeMap(r4, isFromInclusive(), getToKey(), isToInclusive());
        L7:
            throw new IllegalArgumentException("FromKey is out of range: " + r4);
        }
    }

    private static class Reference<E> {
        private E item;

        private Reference() {
        }

        /* synthetic */ Reference(AnonymousClass1 r1) {
            this();
        }

        public E get() {
            return this.item;
        }

        public void set(E r1) {
            this.item = r1;
        }
    }

    protected static class TrieEntry<K, V> extends AbstractBitwiseTrie.BasicEntry<K, V> {
        private static final long serialVersionUID = 4596023148184140013L;
        protected int bitIndex;
        protected TrieEntry<K, V> left;
        protected TrieEntry<K, V> parent;
        protected TrieEntry<K, V> predecessor;
        protected TrieEntry<K, V> right;

        public TrieEntry(K r1, V r2, int r3) {
            super(r1, r2);
            this.bitIndex = r3;
            this.parent = null;
            this.left = this;
            this.right = null;
            this.predecessor = this;
        }

        public boolean isEmpty() {
            if (this.key != null) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isExternalNode() {
            return !isInternalNode();
        }

        public boolean isInternalNode() {
            if (this.left != this) goto L5;
        L7:
            return false;
        L5:
            if (this.right == this) goto L7;
            return true;
        }

        @Override // org.apache.commons.collections4.trie.AbstractBitwiseTrie.BasicEntry
        public String toString() {
            StringBuilder r0 = new StringBuilder();
            if (this.bitIndex != (-1)) goto L5;
            String r1 = "RootEntry(";
        L6:
            r0.append(r1);
            r0.append("key=").append(getKey()).append(" [").append(this.bitIndex).append("], ");
            r0.append("value=").append(getValue()).append(", ");
            TrieEntry<K, V> r2 = this.parent;
            if (r2 != null) goto L9;
            r0.append("parent=").append("null");
        L13:
            r0.append(", ");
            TrieEntry<K, V> r3 = this.left;
            if (r3 != null) goto L16;
            r0.append("left=").append("null");
        L20:
            r0.append(", ");
            TrieEntry<K, V> r4 = this.right;
            if (r4 != null) goto L23;
            r0.append("right=").append("null");
        L27:
            r0.append(", ");
            TrieEntry<K, V> r5 = this.predecessor;
            if (r5 != null) goto L30;
        L33:
            r0.append(")");
            return r0.toString();
        L30:
            if (r5.bitIndex != (-1)) goto L32;
            r0.append("predecessor=").append("ROOT");
            goto L33
        L32:
            r0.append("predecessor=").append(this.predecessor.getKey()).append(" [").append(this.predecessor.bitIndex).append("]");
            goto L33
        L23:
            if (r4.bitIndex != (-1)) goto L25;
            r0.append("right=").append("ROOT");
            goto L27
        L25:
            r0.append("right=").append(this.right.getKey()).append(" [").append(this.right.bitIndex).append("]");
            goto L27
        L16:
            if (r3.bitIndex != (-1)) goto L18;
            r0.append("left=").append("ROOT");
            goto L20
        L18:
            r0.append("left=").append(this.left.getKey()).append(" [").append(this.left.bitIndex).append("]");
            goto L20
        L9:
            if (r2.bitIndex != (-1)) goto L11;
            r0.append("parent=").append("ROOT");
            goto L13
        L11:
            r0.append("parent=").append(this.parent.getKey()).append(" [").append(this.parent.bitIndex).append("]");
            goto L13
        L5:
            r1 = "Entry(";
            goto L6
        }
    }

    abstract class TrieIterator<E> implements Iterator<E> {
        protected TrieEntry<K, V> current;
        protected int expectedModCount;
        protected TrieEntry<K, V> next;
        final /* synthetic */ AbstractPatriciaTrie this$0;

        public TrieIterator(AbstractPatriciaTrie r2) {
            this.this$0 = r2;
            this.expectedModCount = r2.modCount;
            this.next = r2.nextEntry(null);
        }

        public TrieIterator(AbstractPatriciaTrie r1, TrieEntry<K, V> r2) {
            this.this$0 = r1;
            this.expectedModCount = r1.modCount;
            this.next = r2;
        }

        public TrieEntry<K, V> findNext(TrieEntry<K, V> r1) {
            return this.this$0.nextEntry(r1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.next == null) goto L5;
            return true;
        L5:
            return false;
        }

        public TrieEntry<K, V> nextEntry() {
            if (this.expectedModCount != this.this$0.modCount) goto L11;
            TrieEntry<K, V> r0 = this.next;
            if (r0 == null) goto L9;
            this.next = findNext(r0);
            this.current = r0;
            return r0;
        L9:
            throw new NoSuchElementException();
        L11:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.current == null) goto L11;
            if (this.expectedModCount != this.this$0.modCount) goto L9;
            TrieEntry<K, V> r0 = this.current;
            this.current = null;
            this.this$0.removeEntry(r0);
            this.expectedModCount = this.this$0.modCount;
            return;
        L9:
            throw new ConcurrentModificationException();
        L11:
            throw new IllegalStateException();
        }
    }

    private class TrieMapIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<K> implements OrderedMapIterator<K, V> {
        protected TrieEntry<K, V> previous;
        final /* synthetic */ AbstractPatriciaTrie this$0;

        private TrieMapIterator(AbstractPatriciaTrie r1) {
            this.this$0 = r1;
            super(r1);
        }

        /* synthetic */ TrieMapIterator(AbstractPatriciaTrie r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            if (this.current == null) goto L7;
            return this.current.getValue();
        L7:
            throw new IllegalStateException();
        }

        @Override // java.util.Iterator, org.apache.commons.collections4.MapIterator
        public K next() {
            return nextEntry().getKey();
        }

        @Override // org.apache.commons.collections4.trie.AbstractPatriciaTrie.TrieIterator
        public TrieEntry<K, V> nextEntry() {
            TrieEntry<K, V> r0 = super.nextEntry();
            this.previous = r0;
            return r0;
        }
    }

    private class Values extends AbstractCollection<V> {
        final /* synthetic */ AbstractPatriciaTrie this$0;

        private class ValueIterator extends AbstractPatriciaTrie<K, V>.TrieIterator<V> {
            final /* synthetic */ Values this$1;

            private ValueIterator(Values r1) {
                this.this$1 = r1;
                super(r1.this$0);
            }

            /* synthetic */ ValueIterator(Values r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // java.util.Iterator
            public V next() {
                return nextEntry().getValue();
            }
        }

        private Values(AbstractPatriciaTrie r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Values(AbstractPatriciaTrie r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r1) {
            return this.this$0.containsValue(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator(this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r2) {
            Iterator<V> r1 = iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            if (AbstractBitwiseTrie.compare(r1.next(), r2) == false) goto L4;
            r1.remove();
            return true;
        L9:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.this$0.size();
        }
    }

    public AbstractPatriciaTrie(KeyAnalyzer<? super K> r3) {
        super(r3);
        this.root = new TrieEntry(null, null, -1);
        this.size = 0;
        this.modCount = 0;
    }

    public AbstractPatriciaTrie(KeyAnalyzer<? super K> r3, Map<? extends K, ? extends V> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        super(r3);
        this.root = new TrieEntry(null, null, -1);
        this.size = 0;
        this.modCount = 0;
        putAll(r5);
    }

    private SortedMap<K, V> getPrefixMapByBits(K r9, int r10, int r11) {
        int r0 = r10 + r11;
        if (r0 > lengthInBits(r9)) goto L9;
        if (r0 != 0) goto L7;
        return this;
    L7:
        return new PrefixRangeMap(this, r9, r10, r11, null);
    L9:
        throw new IllegalArgumentException(r10 + " + " + r11 + " > " + lengthInBits(r9));
    }

    private void incrementModCount() {
        this.modCount++;
    }

    static boolean isValidUplink(TrieEntry<?, ?> r1, TrieEntry<?, ?> r2) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.bitIndex > r2.bitIndex) goto L8;
        if (r1.isEmpty() == true) goto L8;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r5) {
        r5.defaultReadObject();
        this.root = new TrieEntry(null, null, -1);
        int r0 = r5.readInt();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        put(r5.readObject(), r5.readObject());
        r1 = r1 + 1;
        goto L3
    }

    private void removeExternalEntry(TrieEntry<K, V> r3) {
        if (r3 == this.root) goto L22;
        if (r3.isExternalNode() == false) goto L20;
        TrieEntry<K, V> r2 = r3.parent;
        if (r3.left != r3) goto L9;
        TrieEntry<K, V> r0 = r3.right;
    L11:
        if (r2.left != r3) goto L13;
        r2.left = r0;
    L15:
        if (r0.bitIndex <= r2.bitIndex) goto L17;
        r0.parent = r2;
        return;
    L17:
        r0.predecessor = r2;
        return;
    L13:
        r2.right = r0;
        goto L15
    L9:
        r0 = r3.left;
        goto L11
    L20:
        throw new IllegalArgumentException(r3 + " is not an external Entry!");
    L22:
        throw new IllegalArgumentException("Cannot delete root Entry!");
    }

    private void removeInternalEntry(TrieEntry<K, V> r5) {
        if (r5 == this.root) goto L42;
        if (r5.isInternalNode() == false) goto L40;
        TrieEntry<K, V> r4 = r5.predecessor;
        r4.bitIndex = r5.bitIndex;
        TrieEntry<K, V> r0 = r4.parent;
        if (r4.left != r5) goto L9;
        TrieEntry<K, V> r1 = r4.right;
    L11:
        if (r4.predecessor != r4) goto L16;
        if (r4.parent == r5) goto L16;
        r4.predecessor = r4.parent;
    L16:
        if (r0.left != r4) goto L18;
        r0.left = r1;
    L20:
        if (r1.bitIndex <= r0.bitIndex) goto L23;
        r1.parent = r0;
    L23:
        if (r5.left.parent != r5) goto L26;
        r5.left.parent = r4;
    L26:
        if (r5.right.parent != r5) goto L29;
        r5.right.parent = r4;
    L29:
        if (r5.parent.left != r5) goto L31;
        r5.parent.left = r4;
    L32:
        r4.parent = r5.parent;
        r4.left = r5.left;
        r4.right = r5.right;
        if (isValidUplink(r4.left, r4) == false) goto L36;
        r4.left.predecessor = r4;
    L36:
        if (isValidUplink(r4.right, r4) == false) goto L43;
        r4.right.predecessor = r4;
        return;
    L43:
        return;
    L31:
        r5.parent.right = r4;
        goto L32
    L18:
        r0.right = r1;
        goto L20
    L9:
        r1 = r4.left;
        goto L11
    L40:
        throw new IllegalArgumentException(r5 + " is not an internal Entry!");
    L42:
        throw new IllegalArgumentException("Cannot delete root Entry!");
    }

    private boolean selectR(TrieEntry<K, V> r9, int r10, K r11, int r12, Reference<Map.Entry<K, V>> r13) {
        if (r9.bitIndex > r10) goto L11;
        if (r9.isEmpty() == true) goto L8;
        r13.set(r9);
        return false;
    L8:
        return true;
    L11:
        if (isBitSet(r11, r9.bitIndex, r12) == true) goto L18;
        if (selectR(r9.left, r9.bitIndex, r11, r12, r13) == false) goto L20;
        TrieEntry<K, V> r3 = r9.right;
    L16:
        return selectR(r3, r9.bitIndex, r11, r12, r13);
    L20:
        return false;
    L18:
        if (selectR(r9.right, r9.bitIndex, r11, r12, r13) == false) goto L20;
        r3 = r9.left;
        goto L16
    }

    private void writeObject(ObjectOutputStream r4) {
        r4.defaultWriteObject();
        r4.writeInt(size());
        Iterator<Map.Entry<K, V>> r3 = entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4.writeObject(r0.getKey());
        r4.writeObject(r0.getValue());
        goto L4
    }

    TrieEntry<K, V> addEntry(TrieEntry<K, V> r6, int r7) {
        TrieEntry<K, V> r0 = this.root.left;
        TrieEntry<K, V> r1 = this.root;
    L4:
        if (r0.bitIndex >= r6.bitIndex) goto L13;
        if (r0.bitIndex <= r1.bitIndex) goto L13;
        if (isBitSet(r6.key, r0.bitIndex, r7) == true) goto L11;
        TrieEntry<K, V> r2 = r0.left;
    L12:
        TrieEntry<K, V> r4 = r2;
        r1 = r0;
        r0 = r4;
        goto L4
    L11:
        r2 = r0.right;
    L13:
        r6.predecessor = r6;
        if (isBitSet(r6.key, r6.bitIndex, r7) == true) goto L16;
        r6.left = r6;
        r6.right = r0;
    L17:
        r6.parent = r1;
        if (r0.bitIndex < r6.bitIndex) goto L21;
        r0.parent = r6;
    L21:
        if (r0.bitIndex > r1.bitIndex) goto L24;
        r0.predecessor = r6;
    L24:
        if (r1 != this.root) goto L26;
    L29:
        r1.left = r6;
    L30:
        return r6;
    L26:
        if (isBitSet(r6.key, r1.bitIndex, r7) == false) goto L29;
        r1.right = r6;
        goto L30
    L16:
        r6.left = r0;
        r6.right = r6;
        goto L17
    }

    TrieEntry<K, V> ceilingEntry(K r5) {
        int r0 = lengthInBits(r5);
        if (r0 == 0) goto L5;
        TrieEntry<K, V> r1 = getNearestEntryForKey(r5, r0);
        if (compareKeys(r5, r1.key) == false) goto L13;
        return r1;
    L13:
        int r2 = bitIndex(r5, r1.key);
        if (KeyAnalyzer.isValidBitIndex(r2) == false) goto L18;
        TrieEntry<K, V> r3 = new TrieEntry(r5, null, r2);
        addEntry(r3, r0);
        incrementSize();
        TrieEntry<K, V> r6 = nextEntry(r3);
        removeEntry(r3);
        this.modCount -= 2;
        return r6;
    L18:
        if (KeyAnalyzer.isNullBitKey(r2) == false) goto L26;
        if (this.root.isEmpty() == true) goto L24;
        return this.root;
    L24:
        return firstEntry();
    L26:
        if (KeyAnalyzer.isEqualBitKey(r2) == false) goto L29;
        return r1;
    L29:
        throw new IllegalStateException("invalid lookup: " + r5);
    L5:
        if (this.root.isEmpty() == true) goto L9;
        return this.root;
    L9:
        return firstEntry();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root.key = null;
        this.root.bitIndex = -1;
        this.root.value = null;
        this.root.parent = null;
        TrieEntry<K, V> r0 = this.root;
        r0.left = r0;
        this.root.right = null;
        TrieEntry<K, V> r1 = this.root;
        r1.predecessor = r1;
        this.size = 0;
        incrementModCount();
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return getKeyAnalyzer();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        K r5 = castKey(r4);
        TrieEntry<K, V> r1 = getNearestEntryForKey(r5, lengthInBits(r5));
        if (r1.isEmpty() == false) goto L8;
        return false;
    L8:
        if (compareKeys(r5, r1.key) == false) goto L12;
        return true;
    L12:
        return false;
    }

    void decrementSize() {
        this.size--;
        incrementModCount();
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet != null) goto L6;
        this.entrySet = new EntrySet(this, null);
    L6:
        return this.entrySet;
    }

    TrieEntry<K, V> firstEntry() {
        if (isEmpty() == false) goto L7;
        return null;
    L7:
        return followLeft(this.root);
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        if (size() == 0) goto L7;
        return firstEntry().getKey();
    L7:
        throw new NoSuchElementException();
    }

    TrieEntry<K, V> floorEntry(K r6) {
        int r0 = lengthInBits(r6);
        if (r0 == 0) goto L5;
        TrieEntry<K, V> r2 = getNearestEntryForKey(r6, r0);
        if (compareKeys(r6, r2.key) == false) goto L12;
        return r2;
    L12:
        int r3 = bitIndex(r6, r2.key);
        if (KeyAnalyzer.isValidBitIndex(r3) == false) goto L17;
        TrieEntry<K, V> r4 = new TrieEntry(r6, null, r3);
        addEntry(r4, r0);
        incrementSize();
        TrieEntry<K, V> r7 = previousEntry(r4);
        removeEntry(r4);
        this.modCount -= 2;
        return r7;
    L17:
        if (KeyAnalyzer.isNullBitKey(r3) == false) goto L24;
        if (this.root.isEmpty() == false) goto L21;
        return null;
    L21:
        return this.root;
    L24:
        if (KeyAnalyzer.isEqualBitKey(r3) == false) goto L27;
        return r2;
    L27:
        throw new IllegalStateException("invalid lookup: " + r6);
    L5:
        if (this.root.isEmpty() == false) goto L7;
        return null;
    L7:
        return this.root;
    }

    TrieEntry<K, V> followLeft(TrieEntry<K, V> r2) {
    L2:
        TrieEntry<K, V> r1 = r2.left;
        if (r1.isEmpty() == false) goto L6;
        r1 = r2.right;
    L6:
        if (r1.bitIndex <= r2.bitIndex) goto L7;
        r2 = r1;
        goto L2
    L7:
        return r1;
    }

    TrieEntry<K, V> followRight(TrieEntry<K, V> r2) {
        if (r2.right != null) goto L7;
        return null;
    L7:
        if (r2.right.bitIndex <= r2.bitIndex) goto L10;
        r2 = r2.right;
        goto L7
    L10:
        return r2.right;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r1) {
        TrieEntry<K, V> r0 = getEntry(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getValue();
    }

    TrieEntry<K, V> getEntry(Object r4) {
        K r5 = castKey(r4);
        if (r5 != null) goto L5;
        return null;
    L5:
        TrieEntry<K, V> r1 = getNearestEntryForKey(r5, lengthInBits(r5));
        if (r1.isEmpty() == false) goto L8;
        return null;
    L8:
        if (compareKeys(r5, r1.key) == true) goto L10;
        return null;
    L10:
        return r1;
    }

    TrieEntry<K, V> getNearestEntryForKey(K r5, int r6) {
        TrieEntry<K, V> r0 = this.root.left;
        TrieEntry<K, V> r1 = this.root;
    L4:
        if (r0.bitIndex <= r1.bitIndex) goto L5;
        if (isBitSet(r5, r0.bitIndex, r6) == true) goto L9;
        TrieEntry<K, V> r2 = r0.left;
    L10:
        TrieEntry<K, V> r3 = r2;
        r1 = r0;
        r0 = r3;
        goto L4
    L9:
        r2 = r0.right;
        goto L10
    L5:
        return r0;
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K r3) {
        return new RangeEntryMap(this, null, r3);
    }

    TrieEntry<K, V> higherEntry(K r7) {
        int r0 = lengthInBits(r7);
        if (r0 == 0) goto L5;
        TrieEntry<K, V> r3 = getNearestEntryForKey(r7, r0);
        if (compareKeys(r7, r3.key) == true) goto L17;
        int r4 = bitIndex(r7, r3.key);
        if (KeyAnalyzer.isValidBitIndex(r4) == false) goto L23;
        TrieEntry<K, V> r1 = new TrieEntry(r7, null, r4);
        addEntry(r1, r0);
        incrementSize();
        TrieEntry<K, V> r8 = nextEntry(r1);
        removeEntry(r1);
        this.modCount -= 2;
        return r8;
    L23:
        if (KeyAnalyzer.isNullBitKey(r4) == false) goto L33;
        if (this.root.isEmpty() == true) goto L29;
        return firstEntry();
    L29:
        if (size() <= 1) goto L31;
        TrieEntry<K, V> r9 = firstEntry();
    L10:
        return nextEntry(r9);
    L31:
        return null;
    L33:
        if (KeyAnalyzer.isEqualBitKey(r4) == false) goto L37;
        return nextEntry(r3);
    L37:
        throw new IllegalStateException("invalid lookup: " + r7);
    L17:
        return nextEntry(r3);
    L5:
        if (this.root.isEmpty() == true) goto L13;
        if (size() <= 1) goto L11;
        r9 = this.root;
        goto L10
    L11:
        return null;
    L13:
        return firstEntry();
    }

    void incrementSize() {
        this.size++;
        incrementModCount();
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set<K> keySet() {
        if (this.keySet != null) goto L6;
        this.keySet = new KeySet(this, null);
    L6:
        return this.keySet;
    }

    TrieEntry<K, V> lastEntry() {
        return followRight(this.root.left);
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        TrieEntry<K, V> r0 = lastEntry();
        if (r0 == null) goto L7;
        return r0.getKey();
    L7:
        throw new NoSuchElementException();
    }

    TrieEntry<K, V> lowerEntry(K r6) {
        int r0 = lengthInBits(r6);
        if (r0 != 0) goto L5;
        return null;
    L5:
        TrieEntry<K, V> r2 = getNearestEntryForKey(r6, r0);
        if (compareKeys(r6, r2.key) == true) goto L8;
        int r3 = bitIndex(r6, r2.key);
        if (KeyAnalyzer.isValidBitIndex(r3) == false) goto L14;
        TrieEntry<K, V> r4 = new TrieEntry(r6, null, r3);
        addEntry(r4, r0);
        incrementSize();
        TrieEntry<K, V> r7 = previousEntry(r4);
        removeEntry(r4);
        this.modCount -= 2;
        return r7;
    L14:
        if (KeyAnalyzer.isNullBitKey(r3) == false) goto L17;
        return null;
    L17:
        if (KeyAnalyzer.isEqualBitKey(r3) == false) goto L21;
        return previousEntry(r2);
    L21:
        throw new IllegalStateException("invalid lookup: " + r6);
    L8:
        return previousEntry(r2);
    }

    @Override // org.apache.commons.collections4.OrderedMap, org.apache.commons.collections4.IterableGet
    public /* bridge */ /* synthetic */ MapIterator mapIterator() {
        return mapIterator();
    }

    @Override // org.apache.commons.collections4.OrderedMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new TrieMapIterator(this, null);
    }

    TrieEntry<K, V> nextEntry(TrieEntry<K, V> r3) {
        if (r3 != null) goto L6;
        return firstEntry();
    L6:
        return nextEntryImpl(r3.predecessor, r3, null);
    }

    TrieEntry<K, V> nextEntryImpl(TrieEntry<K, V> r4, TrieEntry<K, V> r5, TrieEntry<K, V> r6) {
        if (r5 == null) goto L6;
        if (r4 != r5.predecessor) goto L6;
    L16:
        if (r4.isEmpty() == false) goto L19;
        return null;
    L19:
        if (r4.right != null) goto L22;
        return null;
    L22:
        if (r5 == r4.right) goto L30;
        if (isValidUplink(r4.right, r4) == false) goto L28;
        return r4.right;
    L28:
        return nextEntryImpl(r4.right, r5, r6);
    L30:
        if (r4 != r4.parent.right) goto L34;
        if (r4 == r6) goto L32;
        r4 = r4.parent;
        goto L30
    L32:
        return null;
    L34:
        if (r4 != r6) goto L37;
        return null;
    L37:
        if (r4.parent.right != null) goto L40;
        return null;
    L40:
        if (r5 == r4.parent.right) goto L46;
        if (isValidUplink(r4.parent.right, r4.parent) == false) goto L46;
        return r4.parent.right;
    L46:
        if (r4.parent.right != r4.parent) goto L49;
        return null;
    L49:
        return nextEntryImpl(r4.parent.right, r5, r6);
    L6:
        if (r4.left.isEmpty() == true) goto L16;
        if (r5 == r4.left) goto L16;
        if (isValidUplink(r4.left, r4) == true) goto L13;
        r4 = r4.left;
        goto L6
    L13:
        return r4.left;
    }

    TrieEntry<K, V> nextEntryInSubtree(TrieEntry<K, V> r2, TrieEntry<K, V> r3) {
        if (r2 != null) goto L6;
        return firstEntry();
    L6:
        return nextEntryImpl(r2.predecessor, r2, r3);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K r2) {
        Objects.requireNonNull(r2);
        TrieEntry<K, V> r3 = getEntry(r2);
        if (r3 == null) goto L8;
        TrieEntry<K, V> r1 = nextEntry(r3);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getKey();
    L8:
        return null;
    }

    @Override // org.apache.commons.collections4.Trie
    public SortedMap<K, V> prefixMap(K r3) {
        return getPrefixMapByBits(r3, 0, lengthInBits(r3));
    }

    TrieEntry<K, V> previousEntry(TrieEntry<K, V> r4) {
        if (r4.predecessor == null) goto L35;
        if (r4.predecessor.right == r4) goto L7;
        TrieEntry<K, V> r5 = r4.predecessor;
    L14:
        if (r5.parent == null) goto L19;
        if (r5 != r5.parent.left) goto L19;
        r5 = r5.parent;
    L19:
        if (r5.parent != null) goto L22;
        return null;
    L22:
        if (isValidUplink(r5.parent.left, r5.parent) == false) goto L33;
        TrieEntry<K, V> r0 = r5.parent.left;
        TrieEntry<K, V> r2 = this.root;
        if (r0 != r2) goto L31;
        if (r2.isEmpty() == false) goto L29;
        return null;
    L29:
        return this.root;
    L31:
        return r5.parent.left;
    L33:
        return followRight(r5.parent.left);
    L7:
        if (isValidUplink(r4.predecessor.left, r4.predecessor) == false) goto L11;
        return r4.predecessor.left;
    L11:
        return followRight(r4.predecessor.left);
    L35:
        throw new IllegalArgumentException("must have come from somewhere!");
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K r2) {
        Objects.requireNonNull(r2);
        TrieEntry<K, V> r3 = getEntry(r2);
        if (r3 == null) goto L8;
        TrieEntry<K, V> r1 = previousEntry(r3);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getKey();
    L8:
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r5, V r6) {
        Objects.requireNonNull(r5, "Key cannot be null");
        int r0 = lengthInBits(r5);
        if (r0 == 0) goto L5;
        TrieEntry<K, V> r1 = getNearestEntryForKey(r5, r0);
        if (compareKeys(r5, r1.key) == true) goto L13;
        int r2 = bitIndex(r5, r1.key);
        if (KeyAnalyzer.isOutOfBoundsIndex(r2) == true) goto L39;
        if (KeyAnalyzer.isValidBitIndex(r2) == false) goto L25;
        addEntry(new TrieEntry(r5, r6, r2), r0);
        incrementSize();
        return null;
    L25:
        if (KeyAnalyzer.isNullBitKey(r2) == false) goto L33;
        if (this.root.isEmpty() == false) goto L29;
        incrementSize();
    L31:
        return this.root.setKeyValue(r5, r6);
    L29:
        incrementModCount();
        goto L31
    L33:
        if (KeyAnalyzer.isEqualBitKey(r2) == false) goto L39;
        if (r1 == this.root) goto L39;
        incrementModCount();
        return r1.setKeyValue(r5, r6);
    L39:
        throw new IllegalArgumentException("Failed to put: " + r5 + " -> " + r6 + ", " + r2);
    L13:
        if (r1.isEmpty() == false) goto L15;
        incrementSize();
    L17:
        return r1.setKeyValue(r5, r6);
    L15:
        incrementModCount();
        goto L17
    L5:
        if (this.root.isEmpty() == false) goto L7;
        incrementSize();
    L9:
        return this.root.setKeyValue(r5, r6);
    L7:
        incrementModCount();
        goto L9
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        K r8 = castKey(r7);
        int r1 = lengthInBits(r8);
        TrieEntry<K, V> r2 = this.root.left;
        TrieEntry<K, V> r3 = this.root;
    L7:
        if (r2.bitIndex <= r3.bitIndex) goto L9;
        if (isBitSet(r8, r2.bitIndex, r1) == true) goto L18;
        TrieEntry<K, V> r4 = r2.left;
    L19:
        TrieEntry<K, V> r5 = r4;
        r3 = r2;
        r2 = r5;
        goto L7
    L18:
        r4 = r2.right;
        goto L19
    L9:
        if (r2.isEmpty() == false) goto L11;
    L14:
        return null;
    L11:
        if (compareKeys(r8, r2.key) == false) goto L14;
        return removeEntry(r2);
    }

    V removeEntry(TrieEntry<K, V> r2) {
        if (r2 != this.root) goto L5;
    L8:
        decrementSize();
        return r2.setKeyValue(null, null);
    L5:
        if (r2.isInternalNode() == false) goto L7;
        removeInternalEntry(r2);
        goto L8
    L7:
        removeExternalEntry(r2);
        goto L8
    }

    public Map.Entry<K, V> select(K r9) {
        int r4 = lengthInBits(r9);
        Reference<Map.Entry<K, V>> r6 = new Reference(null);
        if (selectR(this.root.left, -1, r9, r4, r6) == false) goto L5;
        return null;
    L5:
        return (Map.Entry) ZeusTransformUtils.preCheckCast(r6.get(), Map.Entry.class, "com.obric.memorydata.plugin");
    }

    public K selectKey(K r1) {
        Map.Entry<K, V> r0 = select(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKey();
    }

    public V selectValue(K r1) {
        Map.Entry<K, V> r0 = select(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getValue();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K r2, K r3) {
        return new RangeEntryMap(this, r2, r3);
    }

    TrieEntry<K, V> subtree(K r13, int r14, int r15) {
        TrieEntry<K, V> r0 = this.root.left;
        TrieEntry<K, V> r1 = this.root;
    L4:
        if (r0.bitIndex <= r1.bitIndex) goto L14;
        if (r15 <= r0.bitIndex) goto L14;
        if (isBitSet(r13, r0.bitIndex + r14, r14 + r15) == true) goto L11;
        TrieEntry<K, V> r2 = r0.left;
    L12:
        TrieEntry<K, V> r11 = r2;
        r1 = r0;
        r0 = r11;
        goto L4
    L11:
        r2 = r0.right;
    L14:
        if (r0.isEmpty() == false) goto L17;
        r0 = r1;
    L17:
        if (r0.isEmpty() == false) goto L19;
        return null;
    L19:
        int r3 = r14 + r15;
        if (r0 != this.root) goto L25;
        if (lengthInBits(r0.getKey()) >= r3) goto L25;
        return null;
    L25:
        if (isBitSet(r13, r3 - 1, r3) == isBitSet(r0.key, r15 - 1, lengthInBits(r0.key))) goto L27;
        return null;
    L27:
        int r12 = getKeyAnalyzer().bitIndex(r13, r14, r15, r0.key, 0, lengthInBits(r0.getKey()));
        if (r12 < 0) goto L31;
        if (r12 >= r15) goto L31;
        return null;
    L31:
        return r0;
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K r3) {
        return new RangeEntryMap(this, r3, null);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Collection<V> values() {
        if (this.values != null) goto L6;
        this.values = new Values(this, null);
    L6:
        return this.values;
    }
}
