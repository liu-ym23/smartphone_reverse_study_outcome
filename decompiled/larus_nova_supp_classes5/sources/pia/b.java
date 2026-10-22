package pia;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static final b a = null;
    public static final Lazy b = null;

    public b() {
    }

    static {
        a = new b();
        b = LazyKt.lazy(new a());
    }

    public static Keva a() {
        return (Keva) b.getValue();
    }

    public static String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter("", "defValue");
        return a().getString(r2, "");
    }

    public static void d(String r1) {
        Intrinsics.checkNotNullParameter(r1, "key");
        a().erase(r1);
    }

    public static void c(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        a().storeString(r1, r2);
    }
}
