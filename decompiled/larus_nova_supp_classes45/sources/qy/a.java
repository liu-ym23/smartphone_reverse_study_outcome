package qy;

import java.util.List;
import kotlin.collections.CollectionsKt;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public static k c() {
        return (k) f.c(k.class);
    }

    static {
    }

    public static k a(String r3) {
        k r0 = (k) f.c(k.class);
        List<String> r4 = CollectionsKt.mutableListOf(new String[]{r3});
        if (r4 == null) goto L7;
        r0.setUrls(r4);
        return r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
    }

    public static k b(String r1, List r2) {
        k r0 = (k) f.c(k.class);
        r0.setUri(r1);
        if (r2 == null) goto L5;
        r0.setUrls(r2);
    L5:
        return r0;
    }
}
