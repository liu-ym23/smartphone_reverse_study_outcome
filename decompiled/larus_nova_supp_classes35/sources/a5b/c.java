package a5b;

import com.ss.android.lark.chat.entity.message.CotEventType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final List<b> a = null;
    public static final Map<CotEventType, b> b = null;

    static {
        List<b> r0 = CollectionsKt.listOf(new b[]{b5b.c.a, b5b.e.a, b5b.f.a, b5b.g.a, b5b.b.a, b5b.d.a, b5b.a.a});
        a = r0;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        b r3 = (b) r2.next();
        Set<CotEventType> r4 = r3.a();
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        r5.add(TuplesKt.to((CotEventType) r6.next(), r3));
        goto L7
    L9:
        CollectionsKt.addAll(r1, r5);
        goto L4
    L10:
        b = MapsKt.toMap(r1);
    }
}
