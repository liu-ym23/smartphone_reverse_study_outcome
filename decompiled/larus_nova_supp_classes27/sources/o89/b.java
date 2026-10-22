package o89;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.p0;
import com.larus.utils.y0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new a());
    }

    public static uq9.c a() {
        return (uq9.c) a.getValue();
    }

    public static boolean c() {
        if (a().getType() < 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean d() {
        if (a().getType() >= 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static String b(String r4) {
        boolean r1 = false;
        if (r4 != null) goto L5;
    L7:
        if (r1 == true) goto L22;
        Uri r5 = y0.h(r4);
        String r2 = UriProtector.getQueryParameter(r5, "url");
        if (r2 == null) goto L15;
        String r3 = p0.a(r2);
        if (r3 == null) goto L15;
        return r3;
    L15:
        String r6 = UriProtector.getQueryParameter(r5, "surl");
        if (r6 == null) goto L19;
        return p0.a(r6);
    L19:
        return null;
    L22:
        return r4;
    L5:
        if (StringsKt.startsWith$default(r4, "https", false, 2, null) != true) goto L7;
        r1 = true;
        goto L7
    }

    public static boolean e(String r6) {
        boolean r1 = false;
        if (d() == true) goto L5;
        return false;
    L5:
        String r7 = b(r6);
        if (r7 == null) goto L35;
        List r0 = a().a();
        Boolean r2 = null;
        if (r0 == null) goto L29;
        List r3 = r0;
        if ((r3 instanceof Collection) == true) goto L12;
    L14:
        Iterator r4 = r3.iterator();
    L16:
        if (r4.hasNext() == false) goto L27;
        String r5 = (String) r4.next();
        if (r5 != null) goto L20;
    L24:
        boolean r8 = false;
    L25:
        if (r8 == false) goto L16;
        r1 = true;
        goto L27
    L20:
        if ((!StringsKt.isBlank(r5)) == false) goto L24;
        if (StringsKt.contains$default(r7, r5, false, 2, null) == false) goto L24;
        r8 = true;
    L27:
        r2 = Boolean.valueOf(r1);
        goto L29
    L12:
        if (r3.isEmpty() == false) goto L14;
    L29:
        return Intrinsics.areEqual(r2, Boolean.TRUE);
    L35:
        return false;
    }
}
