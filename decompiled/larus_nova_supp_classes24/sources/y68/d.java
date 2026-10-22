package y68;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements ca9.c {
    public final f2a.d a;

    public d() {
        this.a = new f2a.d("ScreenShare", "Capture");
    }

    public final void a(String r2, String r3, List<String> r4, final Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "what");
        Intrinsics.checkNotNullParameter(r3, "where");
        Intrinsics.checkNotNullParameter(r5, "params");
        f2a.c r6 = this.a.b(r2);
        f2a.g r0 = r6.c;
        r0.d = r3;
        r0.b = r4;
        r6.f(new a(r5));
        f2a.c.c(r6, null, 15);
    }

    public final void b(String r2, String r3, List<String> r4, final Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "what");
        Intrinsics.checkNotNullParameter(r3, "where");
        Intrinsics.checkNotNullParameter(r5, "params");
        f2a.c r6 = this.a.a(r2);
        f2a.g r0 = r6.c;
        r0.d = r3;
        r0.b = r4;
        r6.f(new b(r5));
        f2a.c.c(r6, null, 15);
    }

    public final void c(String r2, String r3, List<String> r4, final Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "what");
        Intrinsics.checkNotNullParameter(r3, "where");
        Intrinsics.checkNotNullParameter(r5, "params");
        f2a.c r6 = this.a.c(r2);
        f2a.g r0 = r6.c;
        r0.d = r3;
        r0.b = r4;
        r6.f(new c(r5));
        f2a.c.c(r6, null, 15);
    }
}
