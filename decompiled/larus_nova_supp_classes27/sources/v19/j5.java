package v19;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j5 {
    public static final String b(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "customString");
        return r3.getString(2131901972, new Object[]{r4, r3.getString(2131894310)});
    }

    public static final String a(Context r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return r2.getString(r4, new Object[]{r2.getString(r3)});
    }
}
