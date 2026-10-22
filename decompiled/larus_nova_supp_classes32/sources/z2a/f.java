package z2a;

import android.text.TextUtils;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lq9.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r6) {
        x r1 = z2.a.getRealtimeCallPreloadConfig();     // Catch: Exception -> L26
        if (Intrinsics.areEqual(r1.a(), Boolean.TRUE) == false) goto L25;
        String r7 = new URL(r6).getHost();     // Catch: Exception -> L26
        List r2 = r1.c();     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r7) == true) goto L24;
        List r3 = r2;     // Catch: Exception -> L26
        if (r3 != null) goto L10;
    L13:
        boolean r4 = true;
    L14:
        if (r4 == true) goto L24;
        Iterator r5 = r2.iterator();     // Catch: Exception -> L26
    L17:
        if (r5.hasNext() == false) goto L24;
        String r8 = (String) r5.next();     // Catch: Exception -> L26
        if (TextUtils.equals(r7, r8) == true) goto L23;
        Intrinsics.checkNotNull(r7);     // Catch: Exception -> L26
        if (StringsKt.endsWith$default(r7, '.' + r8, false, 2, null) == false) goto L17;
    L23:
        return true;
    L10:
        if (r3.isEmpty() == true) goto L13;
        r4 = false;
    L24:
        return false;
    L25:
        return true;
    L26:
        e = move-exception;
        FLogger.a.e("RealtimeCallPreloadUtil", "avatarUrlHostCheck, Exception : " + e);
        return false;
    }
}
