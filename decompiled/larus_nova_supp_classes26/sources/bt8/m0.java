package bt8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m0 {
    public static final com.larus.bmhome.actionbar.model.h a(com.larus.bmhome.actionbar.model.h r14) {
        ArrayList r0 = null;
        if (r14 == null) goto L13;
        List r1 = r14.e;
        if (r1 == null) goto L11;
        List r2 = r1;
        r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L11;
        r0.add(com.larus.bmhome.actionbar.model.w.a((com.larus.bmhome.actionbar.model.w) r3.next(), null, null, null, null, null, null, 8388607));
    L11:
        return com.larus.bmhome.actionbar.model.h.a(r14, null, null, null, r0, null, null, 4079);
    L13:
        return null;
    }
}
