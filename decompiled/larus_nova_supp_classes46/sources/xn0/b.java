package xn0;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final synchronized void a() {
        monitor-enter(b.class);
        int r1 = a.a;     // Catch: Throwable -> L7
        a.a(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("enable_vehook", "false"), TuplesKt.to("enable_push_so", "false")}));     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static {
    }
}
