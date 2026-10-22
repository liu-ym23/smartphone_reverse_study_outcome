package p29;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.a4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final Set<String> a;
    public final Set<String> b;

    public b() {
        this.a = new LinkedHashSet();
        this.b = new LinkedHashSet();
    }

    public static void a(b r24, String r25, String r26, Boolean r27, String r28, String r210, String r30, Boolean r31, Boolean r32, String r33, String r34, String r35, String r36, String r37, String r38, String r310, String r40, String r41, String r42) {
        JSONObject r10 = new JSONObject();
        Intrinsics.checkNotNullParameter(r10, "params");
        if (r24.a.contains(r40) == true) goto L7;
        r24.a.add(r40);
        a4.e(r25, null, r26, r27, r28, "0", null, null, r210, r30, r10, null, r31, r32, r33, r34, r35, r36, r37, r38, r310, r40, r41, r42);
        return;
    }

    public static void b(b r24, String r25, String r26, Boolean r27, String r28, Long r210, Boolean r30, String r31, String r32, Boolean r33, Boolean r34, String r35, String r36, String r37, String r38, String r310, String r40, String r41, String r42, String r43, String r44) {
        JSONObject r10 = new JSONObject();
        Intrinsics.checkNotNullParameter(r10, "params");
        if (r24.b.contains(r42) == true) goto L7;
        r24.b.add(r42);
        a4.l(r25, null, r26, r27, r28, r210, r30, "0", r31, r32, r10, null, r33, r34, r35, r36, r37, r38, r310, r40, r41, r42, r43, r44);
        return;
    }
}
