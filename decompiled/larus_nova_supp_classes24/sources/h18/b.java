package h18;

import android.content.Context;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final String a(Context r1, int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        String r5 = r1.getResources().getString(r2);
        HashMap r6 = new HashMap(1);
        r6.put(r3, r4);
        String r7 = com.samskivert.mustache.e.a().b().a(r5).b(r6);     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r7);     // Catch: Exception -> L6
        return r7;
    L9:
        return r5;
    }
}
