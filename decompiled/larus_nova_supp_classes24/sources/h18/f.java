package h18;

import android.content.Context;
import android.content.res.Configuration;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    static {
    }

    @JvmStatic
    public static final boolean a(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return b(r1.getResources().getConfiguration());
    }

    @JvmStatic
    public static final boolean b(Configuration r1) {
        Intrinsics.checkNotNullParameter(r1, "config");
        if ((r1.uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }
}
