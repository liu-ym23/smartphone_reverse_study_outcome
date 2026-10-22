package org.apache.commons.math3.ml.neuralnet;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;

/* JADX INFO: loaded from: classes6.dex */
public class Network implements Serializable, Iterable<Neuron> {
    private static final long serialVersionUID = 20130207;
    private final int featureSize;
    private final ConcurrentHashMap<Long, Set<Long>> linkMap;
    private final ConcurrentHashMap<Long, Neuron> neuronMap;
    private final AtomicLong nextId;

    public static class NeuronIdentifierComparator implements Serializable, Comparator<Neuron> {
        private static final long serialVersionUID = 20130207;

        public NeuronIdentifierComparator() {
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(Neuron r3, Neuron r4) {
            return compare2((Neuron) ZeusTransformUtils.preCheckCast(r3, Neuron.class, "com.obric.memorydata.plugin"), (Neuron) ZeusTransformUtils.preCheckCast(r4, Neuron.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Neuron r3, Neuron r4) {
            long r2 = r3.getIdentifier();
            long r0 = r4.getIdentifier();
            if (r2 >= r0) goto L5;
            return -1;
        L5:
            if (r2 <= r0) goto L7;
            return 1;
        L7:
            return 0;
        }
    }

    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 20130207;
        private final int featureSize;
        private final long[][] neighbourIdList;
        private final Neuron[] neuronList;
        private final long nextId;

        SerializationProxy(long r1, int r3, Neuron[] r4, long[][] r5) {
            this.nextId = r1;
            this.featureSize = r3;
            this.neuronList = r4;
            this.neighbourIdList = r5;
        }

        private Object readResolve() {
            return new Network(this.nextId, this.featureSize, this.neuronList, this.neighbourIdList);
        }
    }

    public Network(long r2, int r4) {
        this.neuronMap = new ConcurrentHashMap();
        this.linkMap = new ConcurrentHashMap();
        this.nextId = new AtomicLong(r2);
        this.featureSize = r4;
    }

    Network(long r10, int r12, Neuron[] r13, long[][] r14) {
        this.neuronMap = new ConcurrentHashMap();
        this.linkMap = new ConcurrentHashMap();
        int r0 = r13.length;
        if (r0 != r14.length) goto L24;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L11;
        Neuron r3 = r13[r2];
        long r4 = r3.getIdentifier();
        if (r4 >= r10) goto L10;
        this.neuronMap.put(Long.valueOf(r4), r3);
        this.linkMap.put(Long.valueOf(r4), new HashSet());
        r2 = r2 + 1;
        goto L5
    L10:
        throw new MathIllegalStateException();
    L11:
        int r5 = 0;
    L12:
        if (r5 >= r0) goto L21;
        Set<Long> r6 = (Set) ZeusTransformUtils.preCheckCast(this.linkMap.get(Long.valueOf(r13[r5].getIdentifier())), Set.class, "com.obric.memorydata.plugin");
        long[] r7 = r14[r5];
        int r8 = r7.length;
        int r9 = 0;
    L14:
        if (r9 >= r8) goto L20;
        Long r11 = Long.valueOf(r7[r9]);
        if (this.neuronMap.get(r11) == null) goto L19;
        addLinkToLinkSet(r6, r11.longValue());
        r9 = r9 + 1;
        goto L14
    L19:
        throw new MathIllegalStateException();
    L20:
        r5 = r5 + 1;
        goto L12
    L21:
        this.nextId = new AtomicLong(r10);
        this.featureSize = r12;
        return;
    L24:
        throw new MathIllegalStateException();
    }

    private void addLinkToLinkSet(Set<Long> r2, long r3) {
        ((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin")).add(Long.valueOf(r3));
    }

    private Long createNextId() {
        return Long.valueOf(this.nextId.getAndIncrement());
    }

    private void deleteLinkFromLinkSet(Set<Long> r2, long r3) {
        ((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin")).remove(Long.valueOf(r3));
    }

    private void readObject(ObjectInputStream r1) {
        throw new IllegalStateException();
    }

    private Object writeReplace() {
        Neuron[] r8 = (Neuron[]) ZeusTransformUtils.preCheckCast(this.neuronMap.values().toArray(new Neuron[0]), Neuron[].class, "com.obric.memorydata.plugin");
        long[][] r9 = new long[r8.length][];
        int r0 = 0;
    L4:
        if (r0 >= r8.length) goto L11;
        Collection<Neuron> r2 = getNeighbours(r8[r0]);
        long[] r4 = new long[r2.size()];
        Iterator<Neuron> r3 = r2.iterator();
        int r5 = 0;
    L7:
        if (r3.hasNext() == false) goto L9;
        r4[r5] = ((Neuron) ZeusTransformUtils.preCheckCast(r3.next(), Neuron.class, "com.obric.memorydata.plugin")).getIdentifier();
        r5 = r5 + 1;
        goto L7
    L9:
        r9[r0] = r4;
        r0 = r0 + 1;
        goto L4
    L11:
        return new SerializationProxy(this.nextId.get(), this.featureSize, r8, r9);
    }

    public void addLink(Neuron r6, Neuron r7) {
        long r0 = r6.getIdentifier();
        long r2 = r7.getIdentifier();
        if (r6 != getNeuron(r0)) goto L11;
        if (r7 != getNeuron(r2)) goto L9;
        addLinkToLinkSet((Set) ZeusTransformUtils.preCheckCast(this.linkMap.get(Long.valueOf(r0)), Set.class, "com.obric.memorydata.plugin"), r2);
        return;
    L9:
        throw new NoSuchElementException(Long.toString(r2));
    L11:
        throw new NoSuchElementException(Long.toString(r0));
    }

    public synchronized Network copy() {
        monitor-enter(this);
        Network r0 = new Network(this.nextId.get(), this.featureSize);     // Catch: Throwable -> L14
        Iterator<Map.Entry<Long, Neuron>> r1 = this.neuronMap.entrySet().iterator();     // Catch: Throwable -> L14
    L5:
        if (r1.hasNext() == false) goto L7;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        ConcurrentHashMap<Long, Neuron> r3 = r0.neuronMap;     // Catch: Throwable -> L14
        Object r4 = r2.getKey();     // Catch: Throwable -> L14
        Long r5 = (Long) r4;
        r3.put(r5, ((Neuron) ZeusTransformUtils.preCheckCast(r2.getValue(), Neuron.class, "com.obric.memorydata.plugin")).copy());     // Catch: Throwable -> L14
        goto L5
    L7:
        Iterator<Map.Entry<Long, Set<Long>>> r6 = this.linkMap.entrySet().iterator();     // Catch: Throwable -> L14
    L8:
        if (r6.hasNext() == false) goto L12;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        ConcurrentHashMap<Long, Set<Long>> r8 = r0.linkMap;     // Catch: Throwable -> L14
        Object r9 = r7.getKey();     // Catch: Throwable -> L14
        r8.put((Long) r9, new HashSet((Collection) ZeusTransformUtils.preCheckCast(r7.getValue(), Collection.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L14
        goto L8
    L12:
        monitor-exit(this);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }

    public long createNeuron(double[] r6) {
        if (r6.length != this.featureSize) goto L7;
        long r0 = createNextId().longValue();
        this.neuronMap.put(Long.valueOf(r0), new Neuron(r0, r6));
        this.linkMap.put(Long.valueOf(r0), new HashSet());
        return r0;
    L7:
        throw new DimensionMismatchException(r6.length, this.featureSize);
    }

    public void deleteLink(Neuron r6, Neuron r7) {
        long r0 = r6.getIdentifier();
        long r2 = r7.getIdentifier();
        if (r6 != getNeuron(r0)) goto L11;
        if (r7 != getNeuron(r2)) goto L9;
        deleteLinkFromLinkSet((Set) ZeusTransformUtils.preCheckCast(this.linkMap.get(Long.valueOf(r0)), Set.class, "com.obric.memorydata.plugin"), r2);
        return;
    L9:
        throw new NoSuchElementException(Long.toString(r2));
    L11:
        throw new NoSuchElementException(Long.toString(r0));
    }

    public void deleteNeuron(Neuron r5) {
        Iterator<Neuron> r0 = getNeighbours(r5).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        deleteLink((Neuron) ZeusTransformUtils.preCheckCast(r0.next(), Neuron.class, "com.obric.memorydata.plugin"), r5);
        goto L4
    L6:
        this.neuronMap.remove(Long.valueOf(r5.getIdentifier()));
    }

    public int getFeaturesSize() {
        return this.featureSize;
    }

    public Collection<Neuron> getNeighbours(Iterable<Neuron> r3) {
        return getNeighbours((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"), null);
    }

    public Collection<Neuron> getNeighbours(Iterable<Neuron> r7, Iterable<Neuron> r8) {
        Iterable r9 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r7, Iterable.class, "com.obric.memorydata.plugin");
        Iterable r10 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r8, Iterable.class, "com.obric.memorydata.plugin");
        HashSet r0 = new HashSet();
        Iterator r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Neuron r2 = (Neuron) ZeusTransformUtils.preCheckCast(r11.next(), Neuron.class, "com.obric.memorydata.plugin");
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(this.linkMap.get(Long.valueOf(r2.getIdentifier())), Collection.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        if (r10 == null) goto L11;
        Iterator r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L11;
        r0.remove(Long.valueOf(((Neuron) ZeusTransformUtils.preCheckCast(r12.next(), Neuron.class, "com.obric.memorydata.plugin")).getIdentifier()));
    L11:
        ArrayList r13 = new ArrayList();
        Iterator r14 = r0.iterator();
    L13:
        if (r14.hasNext() == false) goto L15;
        r13.add(getNeuron(((Long) ZeusTransformUtils.preCheckCast(r14.next(), Long.class, "com.obric.memorydata.plugin")).longValue()));
        goto L13
    L15:
        return r13;
    }

    public Collection<Neuron> getNeighbours(Neuron r2) {
        return getNeighbours(r2, null);
    }

    public Collection<Neuron> getNeighbours(Neuron r5, Iterable<Neuron> r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.memorydata.plugin");
        Set r8 = (Set) ZeusTransformUtils.preCheckCast(this.linkMap.get(Long.valueOf(r5.getIdentifier())), Set.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L8;
        Iterator r9 = r7.iterator();
    L6:
        if (r9.hasNext() == false) goto L8;
        r8.remove(Long.valueOf(((Neuron) ZeusTransformUtils.preCheckCast(r9.next(), Neuron.class, "com.obric.memorydata.plugin")).getIdentifier()));
    L8:
        ArrayList r10 = new ArrayList();
        Iterator r11 = r8.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        r10.add(getNeuron(((Long) ZeusTransformUtils.preCheckCast(r11.next(), Long.class, "com.obric.memorydata.plugin")).longValue()));
        goto L10
    L12:
        return r10;
    }

    public Neuron getNeuron(long r3) {
        Neuron r2 = (Neuron) ZeusTransformUtils.preCheckCast(this.neuronMap.get(Long.valueOf(r3)), Neuron.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new NoSuchElementException(Long.toString(r3));
    }

    public Collection<Neuron> getNeurons(Comparator<Neuron> r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        r0.addAll(this.neuronMap.values());
        Collections.sort(r0, r4);
        return r0;
    }

    @Override // java.lang.Iterable
    public Iterator<Neuron> iterator() {
        return this.neuronMap.values().iterator();
    }
}
