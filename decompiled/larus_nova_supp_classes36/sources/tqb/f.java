package tqb;

import com.ss.android.lark.lynxkit.host.LarkLynxHostOptions;
import com.ss.android.lark.lynxkit.host.LarkLynxHostParams;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public static final ConcurrentHashMap<String, d> a = null;

    public f() {
    }

    static {
        a = new ConcurrentHashMap();
    }

    public static d a(String r1) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        return null;
    L12:
        return a.get(r1);
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static void c(String r1) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        a.remove(r1);
        return;
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static String b(LarkLynxHostParams r3, LarkLynxHostOptions r4, boolean r5, g r6) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "options");
        String r0 = UUID.randomUUID().toString();
        a.put(r0, new d(r3, r4, r5, r6));
        return r0;
    }
}
