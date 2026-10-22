package qx0;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends com.bytedance.android.livesdk.revenue.network.a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Boolean h() {
        return Boolean.FALSE;
    }

    public final String g(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "path");
        Intrinsics.checkNotNullParameter(r6, "originPath");
        if (StringsKt.startsWith$default(r6, "/webcast", false, 2, null) == true) goto L5;
        return r6;
    L5:
        if (StringsKt.startsWith$default(r6, "/webcast/openapi", false, 2, null) == false) goto L7;
        return r6;
    L7:
        return "/webcast/openapi" + StringsKt.removePrefix(r6, "/webcast");
    }
}
