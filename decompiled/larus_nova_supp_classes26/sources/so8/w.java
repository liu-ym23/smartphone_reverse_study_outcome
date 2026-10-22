package so8;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w {
    public static final Set<String> a = null;

    static {
        a = new LinkedHashSet();
    }

    public static void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "animationID");
        a.add(r1);
    }
}
