package org.ehcache.shadow.org.terracotta.statistics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes7.dex */
public class j<T extends Serializable> implements l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Supplier<T> f18158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StatisticType f18159b;

    public j(StatisticType r3, Supplier<T> r4) {
        Supplier r5 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r4, Supplier.class, "com.obric.memorydata.plugin");
        this.f18159b = (StatisticType) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r3), StatisticType.class, "com.obric.memorydata.plugin");
        this.f18158a = (Supplier) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r5), Supplier.class, "com.obric.memorydata.plugin");
    }

    @Override // org.ehcache.shadow.org.terracotta.statistics.l
    public StatisticType type() {
        return this.f18159b;
    }

    @Override // org.ehcache.shadow.org.terracotta.statistics.l
    public T value() {
        return (T) ZeusTransformUtils.preCheckCast(this.f18158a.get(), Serializable.class, "com.obric.memorydata.plugin");
    }
}
