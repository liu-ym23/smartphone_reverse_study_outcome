package o09;

import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Pair a(String r7) {
        if (r7 == null) goto L4;
        List r8 = StringsKt.split$default(r7, new String[]{";"}, false, 0, 6, null);
    L5:
        String r1 = "";
        if (r8 == null) goto L9;
        String r2 = (String) CollectionsKt.first(r8);
        if (r2 == null) goto L9;
    L10:
        if (r8 == null) goto L16;
        String r9 = (String) CollectionsKt.last(r8);
        if (r9 == null) goto L16;
        r1 = r9;
    L16:
        return new Pair(r2, r1);
    L9:
        r2 = "";
        goto L10
    L4:
        r8 = null;
        goto L5
    }
}
