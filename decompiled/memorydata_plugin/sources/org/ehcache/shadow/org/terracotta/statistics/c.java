package org.ehcache.shadow.org.terracotta.statistics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Enum;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes7.dex */
class c<T extends Enum<T>> extends a<T> {
    private final LongAdder[] f;

    c(String r3, Set<String> r4, Map<String, ? extends Object> r5, Class<T> r6) {
        super(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"), r6);
        this.f = new LongAdder[((Enum[]) ZeusTransformUtils.preCheckCast(r6.getEnumConstants(), Enum[].class, "com.obric.memorydata.plugin")).length];
        int r7 = 0;
    L3:
        LongAdder[] r8 = this.f;
        if (r7 >= r8.length) goto L6;
        r8[r7] = new LongAdder();
        r7 = r7 + 1;
        goto L3
    }

    private /* synthetic */ String a(Enum[] r2, int r3) {
        return r2[r3] + "=" + this.f[r3];
    }

    public static /* synthetic */ String lambda$sRyUB2ht2_8CsuA7t_1oLGrZLzc(c r0, Enum[] r1, int r2) {
        return r0.a(r1, r2);
    }

    @Override // org.ehcache.shadow.org.terracotta.statistics.a, org.ehcache.shadow.org.terracotta.statistics.a.b
    public void a(T r3) {
        this.f[r3.ordinal()].increment();
        super.a(r3);
    }

    public String toString() {
        final Enum[] r0 = (Enum[]) ZeusTransformUtils.preCheckCast(this.d.getEnumConstants(), Enum[].class, "com.obric.memorydata.plugin");
        return (String) ZeusTransformUtils.preCheckCast(IntStream.range(0, r0.length).mapToObj(new $$Lambda$c$sRyUB2ht2_8CsuA7t_1oLGrZLzc(this, r0)).collect(Collectors.joining(", ", "[", "]")), String.class, "com.obric.memorydata.plugin");
    }
}
