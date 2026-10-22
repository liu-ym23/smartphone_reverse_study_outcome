package lx9;

import com.larus.suggest.impl.wcb.model.WcbSurface;
import com.larus.suggest.impl.wcb.policy.k;
import com.larus.suggest.impl.wcb.policy.q;
import com.larus.suggest.impl.wcb.policy.z;
import com.larus.suggest.impl.wcb.scene.WcbMode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final Map<d, z> a = null;

    static {
        WcbSurface r3 = WcbSurface.MAIN_CONVERSATION;
        WcbMode r4 = WcbMode.QUICK_EXPERT;
        WcbMode r6 = WcbMode.OFFICE_TASK;
        WcbSurface r5 = WcbSurface.NEW_CONVERSATION;
        List r0 = CollectionsKt.listOf(new z[]{new k(new d(r3, r4), 1), new k(new d(r3, r6), 10), new q(new d(r5, r4), 12), new q(new d(r5, r6), 11)});
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Object r7 = r1.next();
        r2.put(((z) r7).getKey(), r7);
        goto L4
    L6:
        a = r2;
    }
}
