package oy0;

import com.bytedance.platform.aio.Severity;
import com.bytedance.platform.aio.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements b {
    public static final a b = null;

    public a() {
    }

    public final void a(Severity r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "severity");
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "message");
    }

    public final boolean b(Severity r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "severity");
        Intrinsics.checkNotNullParameter(r3, "tag");
        return false;
    }

    static {
        b = new a();
    }
}
