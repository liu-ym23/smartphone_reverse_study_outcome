package hka;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public static void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "mode");
        c.a("startSafeModeProcess", "startSafeModeProcess-" + r3 + '-' + System.currentTimeMillis());
    }
}
