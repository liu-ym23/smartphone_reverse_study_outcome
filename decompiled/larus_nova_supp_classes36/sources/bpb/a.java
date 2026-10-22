package bpb;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends q5c.a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static String a(Locale r2) {
        String r3 = r2.getLanguage() + '_' + r2.getCountry();
        if (Intrinsics.areEqual(r3, "in_ID") == false) goto L6;
        return "id_ID";
    L6:
        return r3;
    }
}
