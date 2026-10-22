package u49;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public b() {
    }

    public static List a(int r5, int r6) {
        Intrinsics.checkNotNullParameter("", "suffix");
        ArrayList r0 = new ArrayList();
        if (r5 > r6) goto L7;
    L4:
        r0.add(StringsKt.padStart(String.valueOf(r5), 2, '0') + "");
        if (r5 == r6) goto L7;
        r5 = r5 + 1;
    L7:
        return r0;
    }
}
