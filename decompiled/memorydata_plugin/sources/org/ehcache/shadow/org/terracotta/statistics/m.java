package org.ehcache.shadow.org.terracotta.statistics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes7.dex */
public class m {
    public static <T extends Serializable> ConstantValueStatistic<T> a(StatisticType r2, T r3) {
        return new ConstantValueStatistic(r2, (Serializable) ZeusTransformUtils.wrapperContextForParams(r3, Serializable.class, "com.obric.memorydata.plugin"));
    }

    public static <T extends Serializable> l<T> a(StatisticType r2, Supplier<T> r3) {
        return new j(r2, (Supplier) ZeusTransformUtils.wrapperContextForParams(r3, Supplier.class, "com.obric.memorydata.plugin"));
    }
}
