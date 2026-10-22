package org.ehcache.shadow.org.terracotta.statistics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/* JADX INFO: loaded from: classes7.dex */
public abstract class TableSkeleton implements Serializable {
    private static final long serialVersionUID = 1;
    private final String[] innerStatisticNames;
    private final Map<String, l<? extends Serializable>[]> statistics;

    public TableSkeleton(String... r3) {
        this.statistics = new LinkedHashMap();
        String[] r4 = (String[]) ZeusTransformUtils.preCheckCast(r3.clone(), String[].class, "com.obric.memorydata.plugin");
        this.innerStatisticNames = r4;
        Arrays.sort(r4);
    }

    public int getRowCount() {
        return this.statistics.size();
    }

    public Collection<String> getRowLabels() {
        return this.statistics.keySet();
    }

    public <T extends Serializable> Optional<l<T>> getStatistic(String r3, String r4) {
        l[] r5 = (l[]) ZeusTransformUtils.preCheckCast(this.statistics.get(r3), l[].class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        int r2 = Arrays.binarySearch(this.innerStatisticNames, r4);
        if (r2 >= 0) goto L11;
        return Optional.empty();
    L11:
        return Optional.of(r5[r2]);
    L5:
        return Optional.empty();
    }

    public int getStatisticCount() {
        return this.innerStatisticNames.length;
    }

    public String[] getStatisticNames() {
        return (String[]) ZeusTransformUtils.preCheckCast(this.innerStatisticNames.clone(), String[].class, "com.obric.memorydata.plugin");
    }

    public Map<String, l<? extends Serializable>[]> getStatistics() {
        return this.statistics;
    }

    public l<? extends Serializable>[] getStatistics(String r2) {
        return (l[]) ZeusTransformUtils.preCheckCast(this.statistics.get(r2), l[].class, "com.obric.memorydata.plugin");
    }

    public <T extends Serializable> void insert(String r3, String r4, StatisticType r5, T r6) {
        insert(r3, r4, m.a(r5, (Serializable) ZeusTransformUtils.wrapperContextForParams(r6, Serializable.class, "com.obric.memorydata.plugin")));
    }

    public <T extends Serializable> void insert(String r4, String r5, l<T> r6) {
        l<? extends Serializable> r7 = (l) ZeusTransformUtils.wrapperContextForParams(r6, l.class, "com.obric.memorydata.plugin");
        int r0 = Arrays.binarySearch(this.innerStatisticNames, r5);
        if (r0 < 0) goto L10;
        l<? extends Serializable>[] r8 = (l[]) ZeusTransformUtils.preCheckCast(this.statistics.get(r4), l[].class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L7;
        r8 = new l[this.innerStatisticNames.length];
        this.statistics.put(r4, r8);
    L7:
        r8[r0] = r7;
        return;
    L10:
        throw new IllegalArgumentException("Illegal inner statistic: " + r5 + ". Allowed: " + Arrays.asList(this.innerStatisticNames));
    }

    public boolean isEmpty() {
        return this.statistics.isEmpty();
    }

    public String toString() {
        return getClass().getSimpleName() + "{statistics=" + this.statistics + ", rowCount=" + getRowCount() + ", rowLabels=" + getRowLabels() + '}';
    }
}
