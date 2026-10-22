package org.apache.commons.compress.compressors.zstandard;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.compress.utils.OsgiUtils;

/* JADX INFO: loaded from: classes6.dex */
public class ZstdUtils {
    private static final byte[] SKIPPABLE_FRAME_MAGIC = null;
    private static final byte[] ZSTANDARD_FRAME_MAGIC = null;
    private static volatile CachedAvailability cachedZstdAvailability;

    static final enum CachedAvailability extends Enum<CachedAvailability> {
        private static final /* synthetic */ CachedAvailability[] $VALUES = null;
        public static final CachedAvailability CACHED_AVAILABLE = null;
        public static final CachedAvailability CACHED_UNAVAILABLE = null;
        public static final CachedAvailability DONT_CACHE = null;

        static {
            CachedAvailability r0 = new CachedAvailability("DONT_CACHE", 0);
            DONT_CACHE = r0;
            CachedAvailability r1 = new CachedAvailability("CACHED_AVAILABLE", 1);
            CACHED_AVAILABLE = r1;
            CachedAvailability r3 = new CachedAvailability("CACHED_UNAVAILABLE", 2);
            CACHED_UNAVAILABLE = r3;
            $VALUES = new CachedAvailability[]{r0, r1, r3};
        }

        private CachedAvailability(String r1, int r2) {
            super(r1, r2);
        }

        public static CachedAvailability valueOf(String r2) {
            return (CachedAvailability) ZeusTransformUtils.preCheckCast(Enum.valueOf(CachedAvailability.class, r2), CachedAvailability.class, "com.obric.memorydata.plugin");
        }

        public static CachedAvailability[] values() {
            return (CachedAvailability[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CachedAvailability[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        ZSTANDARD_FRAME_MAGIC = new byte[]{40, -75, 47, -3};
        SKIPPABLE_FRAME_MAGIC = new byte[]{42, 77, 24};
        cachedZstdAvailability = CachedAvailability.DONT_CACHE;
        setCacheZstdAvailablity(!OsgiUtils.isRunningInOsgiEnvironment());
    }

    private static boolean internalIsZstdCompressionAvailable() {
        ZeusTransformUtils.forName("com.github.luben.zstd.ZstdInputStream", "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    public static void setCacheZstdAvailablity(boolean r1) {
        if (r1 == true) goto L6;
        CachedAvailability r2 = CachedAvailability.DONT_CACHE;
    L4:
        cachedZstdAvailability = r2;
        return;
    L6:
        if (cachedZstdAvailability == CachedAvailability.DONT_CACHE) goto L8;
        return;
    L8:
        if (internalIsZstdCompressionAvailable() == false) goto L10;
        r2 = CachedAvailability.CACHED_AVAILABLE;
        goto L4
    L10:
        r2 = CachedAvailability.CACHED_UNAVAILABLE;
        goto L4
    }
}
