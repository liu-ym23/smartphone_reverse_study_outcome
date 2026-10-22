package zo0;

import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public static final f b(PerformanceScene r3) {
        Intrinsics.checkNotNullParameter(g.c, "$this$of");
        Intrinsics.checkNotNullParameter(r3, "scene");
        String r4 = r3.getValue();
        monitor-enter(g.class);
        Intrinsics.checkNotNullParameter(r4, "scene");     // Catch: Throwable -> L17
        HashMap<String, f> r1 = g.a;     // Catch: Throwable -> L17
        f r2 = r1.get(r4);     // Catch: Throwable -> L17
        if (r2 == null) goto L8;
        monitor-exit(g.class);
    L14:
        return r2;
    L8:
        g.b r5 = g.b.get(r4);     // Catch: Throwable -> L17
        if (r5 != null) goto L11;
        r5 = g.a.a;     // Catch: Throwable -> L17
    L11:
        r2 = r5.a(r4);     // Catch: Throwable -> L17
        r1.put(r4, r2);     // Catch: Throwable -> L17
        if (r2 == null) goto L16;
        monitor-exit(g.class);
        goto L14
    L16:
        throw new NullPointerException("null cannot be cast to non-null type T");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public static final void a(f r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$clickSource");
        Intrinsics.checkNotNullParameter(r3, "source");
        monitor-enter(r2);
        Intrinsics.checkNotNullParameter("click_source", "key");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r3, "value");     // Catch: Throwable -> L7
        r2.b.putString("click_source", r3);     // Catch: Throwable -> L7
        monitor-exit(r2);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
