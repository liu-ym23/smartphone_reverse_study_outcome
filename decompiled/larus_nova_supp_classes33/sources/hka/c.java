package hka;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "fileNamePrefix");
        int r2 = com.obric.matrix.platform.sdk.ones.safecushion.a.a;     // Catch: Exception -> L5
        com.obric.matrix.platform.sdk.ones.safecushion.a.C0040a.a();     // Catch: Exception -> L5
        throw null;     // Catch: Exception -> L5
    L5:
        gka.b.b("SafeCushionFileUtils", "getSafeCushion: error");
    }

    public static void a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "fileNamePrefix");
        Intrinsics.checkNotNullParameter(r4, "updateFileName");
        gka.b.c("SafeCushionFileUtils", "createOrUpdateSafeCushionFile fileNamePrefix:" + r3 + ",updateFileName:" + r4);     // Catch: Exception -> L5
        b(r3);     // Catch: Exception -> L5
        int r5 = com.obric.matrix.platform.sdk.ones.safecushion.a.a;     // Catch: Exception -> L5
        com.obric.matrix.platform.sdk.ones.safecushion.a.C0040a.a();     // Catch: Exception -> L5
        throw null;     // Catch: Exception -> L5
    L5:
        gka.b.b("SafeCushionFileUtils", "createOrUpdateSafeCushionFile: error");
    }
}
