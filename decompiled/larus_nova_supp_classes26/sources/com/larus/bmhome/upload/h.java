package com.larus.bmhome.upload;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public static final h a = null;
    public static final ConcurrentHashMap<String, mr9.e> b = null;

    public h() {
    }

    static {
        a = new h();
        b = new ConcurrentHashMap();
    }

    public final mr9.e query(String r5) {
        Intrinsics.checkNotNullParameter(r5, "identifier");
        mr9.e r0 = b.get(r5);
        FLogger.a.i("VideoResourceMetaStore", "[query] " + r5 + ':' + r0);
        return r0;
    }

    public static void a(String r3, mr9.e r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "identifier");
        Intrinsics.checkNotNullParameter(r4, "meta");
        Intrinsics.checkNotNullParameter(r5, "from");
        FLogger.a.i("VideoResourceMetaStore", "[record] identifier:" + r3 + ", from:" + r5 + ", meta:" + r4);
        b.put(r3, r4);
    }
}
