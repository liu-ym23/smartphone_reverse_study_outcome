package sna;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {
    public static Context a;
    public static final Lazy b = null;

    static {
        b = LazyKt.lazy(new e());
    }

    public static c b() {
        return (c) b.getValue();
    }

    public final Context getContext() {
        Context r0 = a;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public static int a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        c r1 = b();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "key");
        return r1.a().getInt(r2, r3);
    }

    public static void c(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        c r1 = b();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "key");
        r1.a().storeInt(r2, r3);
    }

    public static void d(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        c r2 = b();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        r2.a().storeString(r3, r4);
    }
}
