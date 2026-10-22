package m48;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import qr9.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements c {
    public final q54.b a;

    public final void a() {
        this.a.a();
    }

    public a(q54.b r2) {
        Intrinsics.checkNotNullParameter(r2, "iAosPreloader");
        this.a = r2;
    }

    public final void b(List<pr9.a> r9) {
        Intrinsics.checkNotNullParameter(r9, "list");
        List<pr9.a> r10 = r9;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        pr9.a r1 = (pr9.a) r11.next();
        String r3 = r1.a;
        boolean r5 = r1.b;
        r0.add(new q54.a(r3, r1.c, r5, r1.d, 846));
        goto L4
    L6:
        this.a.b(r0, false);
    }
}
