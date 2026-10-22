package q30;

import com.bytedance.android.live.schema.api.e;
import com.bytedance.android.monitorV2.g;
import jz2.d;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements e {
    public c() {
    }

    public final void a(String r2, JSONObject r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "category");
        Intrinsics.checkNotNullParameter(r4, "metric");
        Intrinsics.checkNotNullParameter(r5, "extra");
        Intrinsics.checkNotNullParameter(r6, "common");
        d.a r0 = new d.a(r2);
        r0.b = "webcast_cn_container";
        r0.d = r3;
        r0.e = r4;
        r0.f = r5;
        r0.h = r6;
        r0.b(0);
        d r7 = r0.a();
        g.e().getClass();
        g.c(r7);
    }
}
