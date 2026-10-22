package w12;

import com.bytedance.android.livesdk.gift.model.f2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final List<String> a = null;
    public static final List<String> b = null;
    public static f2 c;
    public static boolean d;
    public static boolean e;

    static {
        a = new ArrayList();
        b = new ArrayList();
        d = true;
    }

    public static void a() {
        Iterator r0 = ((ArrayList) b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) r0.next();
        ((ArrayList) a).add(r1 + "/obj/");
        goto L4
    }

    public static void b(f2 r1) {
        Intrinsics.checkNotNullParameter(r1, "imageTemplate");
        c = r1;
        List<String> r2 = r1.getDomainList();
        if (r2 == null) goto L6;
        ArrayList r0 = new ArrayList();
        r0.addAll(r2);
        ArrayList r3 = (ArrayList) b;
        r3.clear();
        r3.addAll(r0);
        return;
    }
}
