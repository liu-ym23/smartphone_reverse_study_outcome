package y68;

import fe9.j;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g implements j {
    public final f2a.d a;

    public g() {
        this.a = new f2a.d("ScreenShare", "AVSDK");
    }

    public final void b(List r4, final Map r5) {
        Intrinsics.checkNotNullParameter("ScreenShareStartResult", "what");
        Intrinsics.checkNotNullParameter("FlowRTCScreenShareServiceImpl.startScreenShare", "where");
        Intrinsics.checkNotNullParameter(r5, "params");
        f2a.c r0 = this.a.a("ScreenShareStartResult");
        f2a.g r1 = r0.c;
        r1.d = "FlowRTCScreenShareServiceImpl.startScreenShare";
        r1.b = r4;
        r0.f(new f(r5));
        f2a.c.c(r0, null, 15);
    }

    public final void a(String r2, String r3, List<String> r4, final Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "what");
        Intrinsics.checkNotNullParameter(r3, "where");
        Intrinsics.checkNotNullParameter(r5, "params");
        f2a.c r6 = this.a.b(r2);
        f2a.g r0 = r6.c;
        r0.d = r3;
        r0.b = r4;
        r6.f(new e(r5));
        f2a.c.c(r6, null, 15);
    }
}
