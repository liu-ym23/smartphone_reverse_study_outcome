package fh8;

import android.util.LruCache;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public static final a a = null;

    public static final class a extends LruCache<String, Object> {
        public a() {
            super(1048576);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            return r3.toString().getBytes(Charsets.UTF_8).length;
        }
    }

    static {
        a = new a();
    }

    public static Object a(usc.e r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "span");
        Intrinsics.checkNotNullParameter(r4, "parseCallback");
        String r0 = r3.getDataType() + "->" + r3.h() + "->" + r3.k();
        a r1 = a;
        Object r2 = r1.get(r0);
        if (r2 != null) goto L5;
        r2 = null;
    L5:
        if (r2 == null) goto L7;
        return r2;
    L7:
        Object r5 = r4.invoke(r3);
        r1.put(r0, r5);
        return r5;
    }
}
