package g69;

import com.larus.dora.impl.onboarding.othersmart.r0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new a());
    }

    public static List b() {
        return (List) a.getValue();
    }

    public static String a(r0 r1) {
        Intrinsics.checkNotNullParameter(r1, "wakeupQueryUiState");
        if ((r1 instanceof r0.g) == false) goto L8;
        String r2 = (String) CollectionsKt.getOrNull(b(), 0);
        if (r2 != null) goto L29;
    L27:
        return "";
    L29:
        return r2;
    L8:
        if ((r1 instanceof r0.d) == false) goto L10;
    L25:
        String r3 = (String) CollectionsKt.getOrNull(b(), 1);
        if (r3 == null) goto L27;
        return r3;
    L10:
        if ((r1 instanceof r0.e) == true) goto L25;
        if ((r1 instanceof r0.a) == false) goto L15;
    L22:
        String r4 = (String) CollectionsKt.getOrNull(b(), 2);
        if (r4 == null) goto L27;
        return r4;
    L15:
        if ((r1 instanceof r0.c) == true) goto L22;
        if ((r1 instanceof r0.f) == false) goto L27;
        String r5 = (String) CollectionsKt.getOrNull(b(), 3);
        if (r5 == null) goto L27;
        return r5;
    }
}
