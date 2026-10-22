package org.ehcache.core.spi.store;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Set;
import java.util.function.Supplier;
import org.ehcache.config.ResourceType;

/* JADX INFO: loaded from: classes7.dex */
public interface Store<K, V> extends org.ehcache.core.spi.store.b {

    public static final enum PutStatus extends Enum<PutStatus> {
        private static final /* synthetic */ PutStatus[] $VALUES = null;
        public static final PutStatus NOOP = null;
        public static final PutStatus PUT = null;

        static {
            PutStatus r0 = new PutStatus(HttpMethodContrants.PUT, 0);
            PUT = r0;
            PutStatus r1 = new PutStatus("NOOP", 1);
            NOOP = r1;
            $VALUES = new PutStatus[]{r0, r1};
        }

        private PutStatus(String r1, int r2) {
            super(r1, r2);
        }

        public static PutStatus valueOf(String r2) {
            return (PutStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(PutStatus.class, r2), PutStatus.class, "com.obric.memorydata.plugin");
        }

        public static PutStatus[] values() {
            return (PutStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PutStatus[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum RemoveStatus extends Enum<RemoveStatus> {
        private static final /* synthetic */ RemoveStatus[] $VALUES = null;
        public static final RemoveStatus KEY_MISSING = null;
        public static final RemoveStatus KEY_PRESENT = null;
        public static final RemoveStatus REMOVED = null;

        static {
            RemoveStatus r0 = new RemoveStatus("REMOVED", 0);
            REMOVED = r0;
            RemoveStatus r1 = new RemoveStatus("KEY_PRESENT", 1);
            KEY_PRESENT = r1;
            RemoveStatus r3 = new RemoveStatus("KEY_MISSING", 2);
            KEY_MISSING = r3;
            $VALUES = new RemoveStatus[]{r0, r1, r3};
        }

        private RemoveStatus(String r1, int r2) {
            super(r1, r2);
        }

        public static RemoveStatus valueOf(String r2) {
            return (RemoveStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(RemoveStatus.class, r2), RemoveStatus.class, "com.obric.memorydata.plugin");
        }

        public static RemoveStatus[] values() {
            return (RemoveStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RemoveStatus[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum ReplaceStatus extends Enum<ReplaceStatus> {
        private static final /* synthetic */ ReplaceStatus[] $VALUES = null;
        public static final ReplaceStatus HIT = null;
        public static final ReplaceStatus MISS_NOT_PRESENT = null;
        public static final ReplaceStatus MISS_PRESENT = null;

        static {
            ReplaceStatus r0 = new ReplaceStatus("HIT", 0);
            HIT = r0;
            ReplaceStatus r1 = new ReplaceStatus("MISS_PRESENT", 1);
            MISS_PRESENT = r1;
            ReplaceStatus r3 = new ReplaceStatus("MISS_NOT_PRESENT", 2);
            MISS_NOT_PRESENT = r3;
            $VALUES = new ReplaceStatus[]{r0, r1, r3};
        }

        private ReplaceStatus(String r1, int r2) {
            super(r1, r2);
        }

        public static ReplaceStatus valueOf(String r2) {
            return (ReplaceStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(ReplaceStatus.class, r2), ReplaceStatus.class, "com.obric.memorydata.plugin");
        }

        public static ReplaceStatus[] values() {
            return (ReplaceStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ReplaceStatus[].class, "com.obric.memorydata.plugin");
        }
    }

    public interface a<K, V> {
    }

    public interface b<T> {
        boolean a();

        T b();
    }

    @org.ehcache.spi.service.b
    public interface c extends org.ehcache.spi.service.c {
        int a(Set<ResourceType<?>> r1, Collection<org.ehcache.spi.service.d<?, ?>> r2);

        <K, V> Store<K, V> a(a<K, V> r1, org.ehcache.spi.service.d<?, ?>... r2);

        void a(Store<?, ?> r1);

        void b(Store<?, ?> r1);
    }

    public interface d<V> extends Supplier<V> {
        @Override // java.util.function.Supplier
        V get();
    }

    PutStatus a(K r1, V r2);

    d<V> a(K r1);

    RemoveStatus b(K r1, V r2);

    org.ehcache.core.spi.store.a.b<K, V> b();

    b<org.ehcache.a.InterfaceC0893a<K, d<V>>> c();
}
