package va8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static List a(String r24) {
        Intrinsics.checkNotNullParameter(r24, "keyword");
        String r1 = StringsKt.trim(r24).toString();
        if (r1.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        String r2 = StringsKt.trim(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r1, "<em>", "", false, 4, null), "</em>", "", false, 4, null), "<highlight>", "", false, 4, null), "</highlight>", "", false, 4, null)).toString();
        String r3 = StringsKt.trim(r2, new char[]{8230, '.', ' '});
        List r6 = CollectionsKt.createListBuilder();
        r6.add(r2);
        r6.add(r3);
        Iterator r4 = StringsKt.split$default(r3, new char[]{8230}, false, 0, 6, null).iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        r6.add(StringsKt.trim((String) r4.next()).toString());
        goto L11
    L13:
        List r5 = CollectionsKt.build(r6);
        ArrayList r7 = new ArrayList();
        Iterator r8 = r5.iterator();
    L15:
        if (r8.hasNext() == false) goto L23;
        Object r9 = r8.next();
        if (((String) r9).length() <= 0) goto L19;
        boolean r10 = true;
    L20:
        if (r10 == false) goto L15;
        r7.add(r9);
        goto L15
    L19:
        r10 = false;
        goto L20
    L23:
        return CollectionsKt.distinct(r7);
    L8:
        return CollectionsKt.emptyList();
    L5:
        r0 = false;
        goto L6
    }
}
