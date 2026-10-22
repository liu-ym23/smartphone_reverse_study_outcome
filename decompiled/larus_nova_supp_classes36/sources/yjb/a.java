package yjb;

import androidx.core.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(List r4) {
        if (r4 == null) goto L7;
        List r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L5:
        if (r6.hasNext() == false) goto L9;
        Pair r1 = (Pair) r6.next();
        r0.add(new Pair(((xjb.a) r1.first).a(), Integer.valueOf(((List) r1.second).size())));
    L9:
        return String.valueOf(r0);
    L7:
        r0 = null;
        goto L9
    }
}
