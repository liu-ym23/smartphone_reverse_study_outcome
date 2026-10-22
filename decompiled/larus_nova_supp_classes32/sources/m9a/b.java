package m9a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Integer a(Integer r2) {
        if (r2 == null) goto L11;
        int r0 = r2.intValue();
        if (r0 >= 0) goto L6;
    L8:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L11;
        return r2;
    L6:
        if (r0 >= 10000) goto L8;
        r1 = true;
    L11:
        return null;
    }

    public static List b(List r7) {
        if (r7 != null) goto L4;
        r7 = CollectionsKt.emptyList();
    L4:
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L10;
        Object r1 = r8.next();
        if (StringsKt.startsWith$default((String) r1, "__omni_feedback_amount=", false, 2, null) == true) goto L6;
        r0.add(r1);
        goto L6
    L10:
        return r0;
    }
}
