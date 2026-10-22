package org.ehcache.shadow.org.terracotta.statistics.registry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.ehcache.shadow.org.terracotta.statistics.Sample;
import org.ehcache.shadow.org.terracotta.statistics.StatisticType;
import org.ehcache.shadow.org.terracotta.statistics.Table;
import org.ehcache.shadow.org.terracotta.statistics.f;
import org.ehcache.shadow.org.terracotta.statistics.l;

/* JADX INFO: loaded from: classes7.dex */
public class Statistic<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1;
    private final List<Sample<T>> samples;
    private final StatisticType type;

    public Statistic(StatisticType r2) {
        this(r2, Collections.emptyList());
    }

    public Statistic(StatisticType r3, List<Sample<T>> r4) {
        List<Sample<T>> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.type = r3;
        this.samples = r5;
    }

    public Statistic(StatisticType r1, Sample<T> r2) {
        this(r1, Collections.singletonList(r2));
    }

    private static <T extends Serializable> boolean accepted(T r2) {
        Serializable r3 = (Serializable) ZeusTransformUtils.wrapperContextForParams(r2, Serializable.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L9:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, Table.class) == true) goto L7;
    L8:
        return true;
    L7:
        if (((Table) ZeusTransformUtils.preCheckCast(r3, Table.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L9;
        goto L8
    }

    static <T extends Serializable> Statistic<T> extract(l<T> r2, long r3, long r5) {
        l r4 = (l) ZeusTransformUtils.wrapperContextForParams(r2, l.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, f.class) == false) goto L7;
        return new Statistic(r4.type(), (List) ZeusTransformUtils.preCheckCast(((f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.memorydata.plugin")).a(r3).stream().filter($$Lambda$Statistic$_M8z08ShHWw1pthUMXNGFXgMQSk.INSTANCE).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin"));
    L7:
        if (r3 > r5) goto L13;
        Serializable r6 = r4.value();
        if (accepted(r6) == false) goto L13;
        return new Statistic(r4.type(), new Sample(r5, r6));
    L13:
        return new Statistic(r4.type());
    }

    static /* synthetic */ boolean lambda$extract$0(Sample r0) {
        return accepted(r0.getSample());
    }

    public Optional<Sample<T>> getLatestSample() {
        if (this.samples.isEmpty() == true) goto L7;
        List<Sample<T>> r1 = this.samples;
        return Optional.of(r1.get(r1.size() - 1));
    L7:
        return Optional.empty();
    }

    public Optional<T> getLatestSampleValue() {
        return (Optional<T>) getLatestSample().map($$Lambda$vlT88R4JLKDit1PSUjvIk1_95M.INSTANCE);
    }

    public List<Sample<T>> getSamples() {
        return this.samples;
    }

    public StatisticType getType() {
        return this.type;
    }

    public boolean isEmpty() {
        return this.samples.isEmpty();
    }

    public String toString() {
        return "Statistic{type=" + this.type + ", samples=" + this.samples + '}';
    }
}
