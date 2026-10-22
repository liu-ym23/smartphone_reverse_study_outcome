package org.ehcache.shadow.org.terracotta.statistics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class ConstantValueStatistic<T extends Serializable> implements Serializable, l<T> {
    private static final long serialVersionUID = 1;
    private final StatisticType type;
    private final T value;

    public ConstantValueStatistic(StatisticType r3, T r4) {
        this.value = (T) ZeusTransformUtils.wrapperContextForParams(r4, Serializable.class, "com.obric.memorydata.plugin");
        this.type = r3;
    }

    @Override // org.ehcache.shadow.org.terracotta.statistics.l
    public StatisticType type() {
        return this.type;
    }

    @Override // org.ehcache.shadow.org.terracotta.statistics.l
    public T value() {
        return this.value;
    }
}
