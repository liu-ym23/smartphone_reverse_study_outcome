package org.apache.commons.collections4;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class CollectionUtils {
    public static final Collection EMPTY_COLLECTION = null;

    private static class CardinalityHelper<O> {
        final Map<O, Integer> cardinalityA;
        final Map<O, Integer> cardinalityB;

        public CardinalityHelper(Iterable<? extends O> r3, Iterable<? extends O> r4) {
            Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
            this.cardinalityA = CollectionUtils.getCardinalityMap(r5);
            this.cardinalityB = CollectionUtils.getCardinalityMap(r6);
        }

        private int getFreq(Object r2, Map<?, Integer> r3) {
            Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin")).get(r2), Integer.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L5;
            return 0;
        L5:
            return r1.intValue();
        }

        public int freqA(Object r2) {
            return getFreq(r2, this.cardinalityA);
        }

        public int freqB(Object r2) {
            return getFreq(r2, this.cardinalityB);
        }

        public final int min(Object r2) {
            return Math.min(freqA(r2), freqB(r2));
        }
    }

    private static class SetOperationCardinalityHelper<O> extends CardinalityHelper<O> implements Iterable<O> {
        private final Set<O> elements;
        private final List<O> newList;

        public SetOperationCardinalityHelper(Iterable<? extends O> r3, Iterable<? extends O> r4) {
            Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
            super(r5, r6);
            HashSet r0 = new HashSet();
            this.elements = r0;
            CollectionUtils.addAll(r0, r5);
            CollectionUtils.addAll(r0, r6);
            this.newList = new ArrayList(r0.size());
        }

        @Override // java.lang.Iterable
        public Iterator<O> iterator() {
            return this.elements.iterator();
        }

        public Collection<O> list() {
            return this.newList;
        }

        public void setCardinality(O r3, int r4) {
            int r0 = 0;
        L3:
            if (r0 >= r4) goto L5;
            this.newList.add(r3);
            r0 = r0 + 1;
            goto L3
        }
    }

    static {
        EMPTY_COLLECTION = Collections.emptyList();
    }

    public static <C> boolean addAll(Collection<C> r2, Iterable<? extends C> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == false) goto L7;
        return r4.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
    L7:
        return addAll(r4, r5.iterator());
    }

    public static <C> boolean addAll(Collection<C> r2, Iterator<? extends C> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 | r4.add(r5.next());
        goto L4
    L6:
        return r0;
    }

    public static <T> Collection<T> emptyCollection() {
        return EMPTY_COLLECTION;
    }

    public static <T> Collection<T> emptyIfNull(Collection<T> r2) {
        Collection<T> r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L5;
        return r3;
    L5:
        return emptyCollection();
    }

    public static <T> boolean filter(Iterable<T> r2, Predicate<? super T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        Predicate r5 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        if (r4 == null) goto L11;
        if (r5 == null) goto L11;
        Iterator<T> r6 = r4.iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        if (r5.evaluate(r6.next()) == true) goto L7;
        r6.remove();
        r0 = true;
    L11:
        return r0;
    }

    public static <O> Map<O, Integer> getCardinalityMap(Iterable<? extends O> r5) {
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        Object r2 = r7.next();
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r0.get(r2), Integer.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L8;
        int r4 = 1;
    L9:
        r0.put(r2, r4);
        goto L4
    L8:
        r4 = Integer.valueOf(r3.intValue() + 1);
        goto L9
    L10:
        return r0;
    }

    public static <O> Collection<O> intersection(Iterable<? extends O> r2, Iterable<? extends O> r3) {
        SetOperationCardinalityHelper r0 = new SetOperationCardinalityHelper((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"));
        Iterator<O> r4 = r0.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        O r5 = r4.next();
        r0.setCardinality(r5, r0.min(r5));
        goto L4
    L7:
        return r0.list();
    }

    public static boolean isEmpty(Collection<?> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.isEmpty() == true) goto L8;
        return false;
    }

    public static boolean isSubCollection(Collection<?> r2, Collection<?> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        CardinalityHelper r0 = new CardinalityHelper(r4, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Object r6 = r5.next();
        if (r0.freqA(r6) <= r0.freqB(r6)) goto L4;
        return false;
    L9:
        return true;
    }

    public static int size(Object r3) {
        int r0 = 0;
        if (r3 != null) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, Map.class) == false) goto L9;
        return ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin")).size();
    L9:
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == false) goto L12;
        return ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).size();
    L12:
        if (ZeusTransformUtils.instanceOf(r3, Iterable.class) == false) goto L15;
        return IterableUtils.size((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"));
    L15:
        if ((r3 instanceof Object[]) == false) goto L18;
        return ((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin")).length;
    L18:
        if (ZeusTransformUtils.instanceOf(r3, Iterator.class) == false) goto L21;
        return IteratorUtils.size((Iterator) ZeusTransformUtils.preCheckCast(r3, Iterator.class, "com.obric.memorydata.plugin"));
    L21:
        if (ZeusTransformUtils.instanceOf(r3, Enumeration.class) == false) goto L31;
        Enumeration r4 = (Enumeration) ZeusTransformUtils.preCheckCast(r3, Enumeration.class, "com.obric.memorydata.plugin");
    L24:
        if (r4.hasMoreElements() == false) goto L39;
        r0 = r0 + 1;
        r4.nextElement();
        goto L24
    L39:
        return r0;
    L31:
        return Array.getLength(r3);
    L30:
        throw new IllegalArgumentException("Unsupported object type: " + r3.getClass().getName());
    }
}
