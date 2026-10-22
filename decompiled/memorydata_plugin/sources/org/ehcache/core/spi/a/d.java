package org.ehcache.core.spi.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private static /* synthetic */ Object a(Class r1, Object r2, Object r3) {
        throw new IllegalArgumentException("More than one " + r1.getName() + " found");
    }

    public static <T> Collection<T> a(Class<T> r2, Collection<?> r3) {
        return (Collection) ZeusTransformUtils.preCheckCast(d(r2, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")).collect(Collectors.toList()), Collection.class, "com.obric.memorydata.plugin");
    }

    public static <T> T b(Class<T> r2, Collection<?> r3) {
        return (T) c(r2, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")).orElse(null);
    }

    public static <T> Optional<T> c(final Class<T> r2, Collection<?> r3) {
        return d(r2, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")).reduce(new $$Lambda$d$GCiUfrGdYAZXF3iD4_XnMhfpa94(r2));
    }

    private static <T> Stream<T> d(final Class<T> r2, Collection<?> r3) {
        Stream r4 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")).stream();
        r2.getClass();
        Stream<T> r5 = r4.filter(new $$Lambda$d$0vBUHuCsK5F0QnSeOtlSKkIYGQ(r2));
        r2.getClass();
        return (Stream<T>) r5.map(new $$Lambda$d$qD38EpryxEVHkutWpHvV2SolY9k(r2));
    }

    /* JADX INFO: renamed from: lambda$0vBUHuCsK5-F0QnSeOtlSKkIYGQ, reason: not valid java name */
    public static /* synthetic */ boolean m3200lambda$0vBUHuCsK5F0QnSeOtlSKkIYGQ(Class r0, Object r1) {
        return r0.isInstance(r1);
    }

    public static /* synthetic */ Object lambda$GCiUfrGdYAZXF3iD4_XnMhfpa94(Class r0, Object r1, Object r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Object lambda$qD38EpryxEVHkutWpHvV2SolY9k(Class r0, Object r1) {
        return r0.cast(r1);
    }
}
