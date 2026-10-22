package kr8;

import com.larus.utils.logger.FLogger;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v {
    public static final Set<String> a = null;

    static {
        a = new LinkedHashSet();
    }

    public static l a(p r4, String r5) {
        u r0 = u.a;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r0, "type");
        Intrinsics.checkNotNullParameter(r5, "key");
        Set<String> r1 = a;
        if (r1.contains(r5) == false) goto L5;
        boolean r2 = false;
    L6:
        FLogger.a.i("MusicMobSendFilter", "[filterByCreationDimension] creationId=" + r5 + ", allow=" + r2);
        if (r2 == true) goto L11;
        return null;
    L11:
        return r4;
    L5:
        r1.add(r5);
        r2 = true;
        goto L6
    }
}
