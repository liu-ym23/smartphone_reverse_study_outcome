package an0;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends com.bytedance.android.livesdk.revenue.network.a {
    public final boolean a;

    public final Boolean h() {
        return Boolean.valueOf(this.a);
    }

    public a() {
        this.a = true;
    }

    public final String g(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "path");
        Intrinsics.checkNotNullParameter(r6, "originPath");
        if (StringsKt.startsWith$default(r5, "/webcast", false, 2, null) == true) goto L5;
        return r5;
    L5:
        if (StringsKt.startsWith$default(r5, "/webcast/openapi", false, 2, null) == false) goto L7;
        return r5;
    L7:
        return "/webcast/openapi/v2" + StringsKt.removePrefix(r5, "/webcast");
    }
}
