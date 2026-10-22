package k02;

import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import or2.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public boolean a;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public static boolean b() {
        j r0 = vh6.c.b(or2.e.class).getCurrentClient();
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.isEffectInited());
    L7:
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    L5:
        r1 = null;
        goto L7
    }

    public static boolean a() {
        if (b() == true) goto L6;
        return false;
    L6:
        j r0 = vh6.c.b(or2.e.class).getCurrentClient();
        if (r0 == null) goto L9;
        Boolean r1 = Boolean.valueOf(r0.M());
    L11:
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    L9:
        r1 = null;
        goto L11
    }

    public static String[] c(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "nodes");
        ArrayList r0 = new ArrayList();
        int r1 = r10.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.add(StringsKt.replace$default(r10[r3], "file://", BuildConfig.FLAVOR, false, 4, null));
        r3 = r3 + 1;
        goto L3
    L5:
        Object[] r11 = r0.toArray(new String[0]);
        if (r11 == null) goto L10;
        return (String[]) r11;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
