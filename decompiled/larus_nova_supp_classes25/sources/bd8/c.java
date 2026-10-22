package bd8;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final <T extends t1a.a> T a(b r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Fragment r3 = r1.c;
        if (r3 == null) goto L7;
        t1a.b r4 = s1a.a.g(r3);
        if (r4 == null) goto L7;
        return (T) r4.getAbility(r2);
    L7:
        return null;
    }

    public static final <T extends t1a.c> T b(b r1, Class<T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Fragment r3 = r1.c;
        if (r3 == null) goto L7;
        t1a.b r4 = s1a.a.g(r3);
        if (r4 == null) goto L7;
        return (T) r4.a(r2);
    L7:
        return null;
    }
}
