package nc0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s {
    public final com.bytedance.android.live.revenuelink.rtc.p a;

    public final List<String> a() {
        return this.a.c();
    }

    public final List<String> b() {
        List r0 = this.a.l();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (((com.bytedance.android.live.revenuelink.rtc.o) r3).g == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r5 = r1.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r4.add(((com.bytedance.android.live.revenuelink.rtc.o) r5.next()).b);
        goto L10
    L12:
        return r4;
    }

    public final Map<String, Object> c() {
        return this.a.d().a;
    }

    public final int d() {
        return this.a.a.size();
    }

    public s(com.bytedance.android.live.revenuelink.rtc.p r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }

    public final r e(String r2) {
        com.bytedance.android.live.revenuelink.rtc.o r3 = this.a.k(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return new r(r3);
    }
}
