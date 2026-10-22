package org.ehcache.shadow.org.terracotta.statistics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes7.dex */
public class Table extends TableSkeleton implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: org.ehcache.shadow.org.terracotta.statistics.Table$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Table f18143a;

        private a(String... r3) {
            this.f18143a = new Table(r3, null);
        }

        /* synthetic */ a(String[] r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ Table a(a r0) {
            return r0.f18143a;
        }

        private /* synthetic */ void a(BiConsumer r3, final String r4) {
            ((BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin")).accept(r4, new AnonymousClass1(this, r4));
        }

        /* JADX INFO: renamed from: lambda$w25cvN3Rbpq3TgfAVQn4xm4z-OQ, reason: not valid java name */
        public static /* synthetic */ void m3202lambda$w25cvN3Rbpq3TgfAVQn4xm4zOQ(a r0, BiConsumer r1, String r2) {
            r0.a(r1, r2);
        }

        public a a(Collection<String> r3, BiConsumer<String, b> r4) {
            Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            final BiConsumer r6 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r4, BiConsumer.class, "com.obric.memorydata.plugin");
            r5.forEach(new $$Lambda$Table$a$w25cvN3Rbpq3TgfAVQn4xm4zOQ(this, r6));
            return this;
        }

        public Table a() {
            return this.f18143a;
        }
    }

    public interface b {
        <T extends Serializable> b a(String r1, StatisticType r2, T r3);
    }

    private Table(String... r1) {
        super(r1);
    }

    /* synthetic */ Table(String[] r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static a newBuilder(String... r2) {
        return new a(r2, null);
    }
}
