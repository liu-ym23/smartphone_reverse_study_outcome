package org.apache.commons.compress.compressors.brotli;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.compress.utils.OsgiUtils;

/* JADX INFO: loaded from: classes6.dex */
public class BrotliUtils {
    private static volatile CachedAvailability cachedBrotliAvailability;

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
        cachedBrotliAvailability = CachedAvailability.DONT_CACHE;
        setCacheBrotliAvailablity(!OsgiUtils.isRunningInOsgiEnvironment());
    }

    private static boolean internalIsBrotliCompressionAvailable() {
        ZeusTransformUtils.forName("org.brotli.dec.BrotliInputStream", "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    public static void setCacheBrotliAvailablity(boolean r1) {
        if (r1 == true) goto L6;
        CachedAvailability r2 = CachedAvailability.DONT_CACHE;
    L4:
        cachedBrotliAvailability = r2;
        return;
    L6:
        if (cachedBrotliAvailability == CachedAvailability.DONT_CACHE) goto L8;
        return;
    L8:
        if (internalIsBrotliCompressionAvailable() == false) goto L10;
        r2 = CachedAvailability.CACHED_AVAILABLE;
        goto L4
    L10:
        r2 = CachedAvailability.CACHED_UNAVAILABLE;
        goto L4
    }
}
