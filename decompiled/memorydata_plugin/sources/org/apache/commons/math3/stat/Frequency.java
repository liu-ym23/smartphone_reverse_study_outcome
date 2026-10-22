package org.apache.commons.math3.stat;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class Frequency implements Serializable {
    private static final long serialVersionUID = -3845586908418844111L;
    private final SortedMap<Comparable<?>, Long> freqTable;

    /* JADX INFO: renamed from: org.apache.commons.math3.stat.Frequency$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class NaturalComparator<T extends Comparable<T>> implements Serializable, Comparator<Comparable<T>> {
        private static final long serialVersionUID = -3852193713161395148L;

        private NaturalComparator() {
        }

        /* synthetic */ NaturalComparator(AnonymousClass1 r1) {
            this();
        }

        public int compare(Comparable<T> r2, Comparable<T> r3) {
            return ((Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin")).compareTo((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(Object r3, Object r4) {
            return compare((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r4, Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    public Frequency() {
        this.freqTable = new TreeMap();
    }

    public Frequency(Comparator<?> r3) {
        this.freqTable = new TreeMap((Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin"));
    }

    public void addValue(char r1) {
        addValue(Character.valueOf(r1));
    }

    public void addValue(int r3) {
        addValue(Long.valueOf(r3));
    }

    public void addValue(long r1) {
        addValue(Long.valueOf(r1));
    }

    public void addValue(Comparable<?> r3) {
        incrementValue((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), 1);
    }

    public void clear() {
        this.freqTable.clear();
    }

    public Iterator<Map.Entry<Comparable<?>, Long>> entrySetIterator() {
        return this.freqTable.entrySet().iterator();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Frequency.class) == true) goto L8;
        return false;
    L8:
        Frequency r6 = (Frequency) ZeusTransformUtils.preCheckCast(r5, Frequency.class, "com.obric.memorydata.plugin");
        SortedMap<Comparable<?>, Long> r4 = this.freqTable;
        if (r4 != null) goto L14;
        if (r6.freqTable == null) goto L16;
        return false;
    L16:
        return true;
    L14:
        if (r4.equals(r6.freqTable) == true) goto L16;
        return false;
    }

    public long getCount(char r1) {
        return getCount(Character.valueOf(r1));
    }

    public long getCount(int r3) {
        return getCount(Long.valueOf(r3));
    }

    public long getCount(long r1) {
        return getCount(Long.valueOf(r1));
    }

    public long getCount(Comparable<?> r5) {
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Integer.class) == false) goto L13;
        return getCount(((Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.memorydata.plugin")).longValue());
    L13:
        Long r4 = (Long) ZeusTransformUtils.preCheckCast(this.freqTable.get(r6), Long.class, "com.obric.memorydata.plugin");     // Catch: ClassCastException -> L12
        if (r4 == null) goto L15;
        return r4.longValue();
    L15:
        return 0;
    L16:
        return 0;
    }

    public long getCumFreq(char r1) {
        return getCumFreq(Character.valueOf(r1));
    }

    public long getCumFreq(int r3) {
        return getCumFreq(Long.valueOf(r3));
    }

    public long getCumFreq(long r1) {
        return getCumFreq(Long.valueOf(r1));
    }

    public long getCumFreq(Comparable<?> r8) {
        Comparable r9 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r8, Comparable.class, "com.obric.memorydata.plugin");
        if (getSumFreq() != 0) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, Integer.class) == true) goto L8;
        Comparator<? super Comparable<?>> r0 = this.freqTable.comparator();
        if (r0 != null) goto L32;
        r0 = new NaturalComparator(null);
    L32:
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(this.freqTable.get(r9), Long.class, "com.obric.memorydata.plugin");     // Catch: ClassCastException -> L31
        if (r2 == null) goto L16;
        long r3 = r2.longValue();     // Catch: ClassCastException -> L31
    L18:
        if (r0.compare(r9, this.freqTable.firstKey()) >= 0) goto L21;
        return 0;
    L21:
        if (r0.compare(r9, this.freqTable.lastKey()) >= 0) goto L23;
        Iterator<Comparable<?>> r4 = valuesIterator();
    L26:
        if (r4.hasNext() == false) goto L30;
        Comparable<?> r5 = (Comparable) ZeusTransformUtils.preCheckCast(r4.next(), Comparable.class, "com.obric.memorydata.plugin");
        if (r0.compare(r9, r5) <= 0) goto L30;
        r3 = r3 + getCount(r5);
    L30:
        return r3;
    L23:
        return getSumFreq();
    L16:
        r3 = 0;
    L31:
        return 0;
    L8:
        return getCumFreq(((Integer) ZeusTransformUtils.preCheckCast(r9, Integer.class, "com.obric.memorydata.plugin")).longValue());
    }

    public double getCumPct(char r1) {
        return getCumPct(Character.valueOf(r1));
    }

    public double getCumPct(int r3) {
        return getCumPct(Long.valueOf(r3));
    }

    public double getCumPct(long r1) {
        return getCumPct(Long.valueOf(r1));
    }

    public double getCumPct(Comparable<?> r5) {
        Comparable<?> r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        long r0 = getSumFreq();
        if (r0 != 0) goto L7;
        return Double.NaN;
    L7:
        return getCumFreq(r6) / r0;
    }

    public List<Comparable<?>> getMode() {
        Iterator<Long> r0 = this.freqTable.values().iterator();
        long r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L8;
        long r3 = ((Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.memorydata.plugin")).longValue();
        if (r3 <= r1) goto L4;
        r1 = r3;
        goto L4
    L8:
        ArrayList r2 = new ArrayList();
        Iterator<Map.Entry<Comparable<?>, Long>> r7 = this.freqTable.entrySet().iterator();
    L10:
        if (r7.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((Long) ZeusTransformUtils.preCheckCast(r4.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue() != r1) goto L10;
        r2.add(r4.getKey());
        goto L10
    L14:
        return r2;
    }

    public double getPct(char r1) {
        return getPct(Character.valueOf(r1));
    }

    public double getPct(int r3) {
        return getPct(Long.valueOf(r3));
    }

    public double getPct(long r1) {
        return getPct(Long.valueOf(r1));
    }

    public double getPct(Comparable<?> r5) {
        Comparable<?> r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        long r0 = getSumFreq();
        if (r0 != 0) goto L7;
        return Double.NaN;
    L7:
        return getCount(r6) / r0;
    }

    public long getSumFreq() {
        Iterator<Long> r5 = this.freqTable.values().iterator();
        long r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 + ((Long) ZeusTransformUtils.preCheckCast(r5.next(), Long.class, "com.obric.memorydata.plugin")).longValue();
        goto L4
    L6:
        return r0;
    }

    public int getUniqueCount() {
        return this.freqTable.keySet().size();
    }

    public int hashCode() {
        SortedMap<Comparable<?>, Long> r1 = this.freqTable;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return 31 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public void incrementValue(char r1, long r2) {
        incrementValue(Character.valueOf(r1), r2);
    }

    public void incrementValue(int r3, long r4) {
        incrementValue(Long.valueOf(r3), r4);
    }

    public void incrementValue(long r1, long r3) {
        incrementValue(Long.valueOf(r1), r3);
    }

    public void incrementValue(Comparable<?> r5, long r6) {
        Comparable<?> r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L5;
        Comparable<?> r0 = Long.valueOf(((Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.memorydata.plugin")).longValue());
    L15:
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(this.freqTable.get(r0), Long.class, "com.obric.memorydata.plugin");     // Catch: ClassCastException -> L13
        if (r1 != null) goto L10;
        SortedMap<Comparable<?>, Long> r4 = this.freqTable;     // Catch: ClassCastException -> L13
        Long r8 = Long.valueOf(r6);     // Catch: ClassCastException -> L13
    L9:
        r4.put(r0, r8);     // Catch: ClassCastException -> L13
        return;
    L10:
        r4 = this.freqTable;     // Catch: ClassCastException -> L13
        r8 = Long.valueOf(r1.longValue() + r6);     // Catch: ClassCastException -> L13
    L14:
        throw new MathIllegalArgumentException(LocalizedFormats.INSTANCES_NOT_COMPARABLE_TO_EXISTING_VALUES, new Object[]{r7.getClass().getName()});
    L5:
        r0 = r7;
        goto L15
    }

    public void merge(Collection<Frequency> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        MathUtils.checkNotNull(r5, LocalizedFormats.NULL_NOT_ALLOWED, new Object[0]);
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        merge((Frequency) ZeusTransformUtils.preCheckCast(r6.next(), Frequency.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    public void merge(Frequency r5) {
        MathUtils.checkNotNull(r5, LocalizedFormats.NULL_NOT_ALLOWED, new Object[0]);
        Iterator<Map.Entry<Comparable<?>, Long>> r6 = r5.entrySetIterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        incrementValue((Comparable) ZeusTransformUtils.preCheckCast(r0.getKey(), Comparable.class, "com.obric.memorydata.plugin"), ((Long) ZeusTransformUtils.preCheckCast(r0.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue());
        goto L4
    }

    public String toString() {
        NumberFormat r0 = NumberFormat.getPercentInstance();
        StringBuilder r1 = new StringBuilder();
        r1.append("Value \t Freq. \t Pct. \t Cum Pct. \n");
        Iterator<Comparable<?>> r2 = this.freqTable.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        Comparable<?> r3 = (Comparable) ZeusTransformUtils.preCheckCast(r2.next(), Comparable.class, "com.obric.memorydata.plugin");
        r1.append(r3);
        r1.append('\t');
        r1.append(getCount(r3));
        r1.append('\t');
        r1.append(r0.format(getPct(r3)));
        r1.append('\t');
        r1.append(r0.format(getCumPct(r3)));
        r1.append('\n');
        goto L4
    L7:
        return r1.toString();
    }

    public Iterator<Comparable<?>> valuesIterator() {
        return this.freqTable.keySet().iterator();
    }
}
