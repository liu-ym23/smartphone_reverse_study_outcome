package v19;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final List<q5> a = null;

    static {
        a = new ArrayList();
    }

    public static void a(q5 r1) {
        Intrinsics.checkNotNullParameter(r1, "callback");
        ((ArrayList) a).add(r1);
    }
}
