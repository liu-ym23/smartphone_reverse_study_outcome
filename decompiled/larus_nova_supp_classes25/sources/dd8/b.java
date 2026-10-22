package dd8;

import android.util.LruCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public static final a a = null;

    public static final class a extends LruCache<String, Long> {
        @Override // android.util.LruCache
        public final Long create(String r1) {
            return null;
        }

        @Override // android.util.LruCache
        public final void entryRemoved(boolean r1, String r2, Long r3, Long r4) {
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r1, Long r2) {
            return 1;
        }

        public a() {
            super(100);
        }
    }

    static {
        a = new a();
    }

    public static boolean a(String r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "localMessageId");
        a r0 = a;
        Long r1 = r0.get(r4);
        if (r1 == null) goto L5;
        long r2 = r1.longValue();
    L7:
        if ((System.currentTimeMillis() - r2) < (r5 + 2000)) goto L9;
        return true;
    L9:
        return false;
    L5:
        long r3 = System.currentTimeMillis();
        r0.put(r4, Long.valueOf(r3));
        r2 = r3;
        goto L7
    }
}
