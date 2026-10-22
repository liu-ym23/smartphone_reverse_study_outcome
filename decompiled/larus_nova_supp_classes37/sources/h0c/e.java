package h0c;

import com.ss.android.lark.passportc.entity.UserState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e<S, E, C, R> {
    public final HashMap<S, List<i0c.d<S, C, R>>> a;

    public e() {
        this.a = new HashMap();
    }

    public final List a(Object r6, UserState r7, int r8) {
        if (Intrinsics.areEqual(r6, r7) == true) goto L5;
        List<i0c.d<S, C, R>> r9 = this.a.get(r6);
        if (r9 == null) goto L23;
        ArrayList r0 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
        int r1 = Integer.MAX_VALUE;
    L10:
        if (r10.hasNext() == false) goto L21;
        i0c.d r2 = (i0c.d) r10.next();
        ArrayList r3 = new ArrayList();
        if (Intrinsics.areEqual(r2.getTo(), r7) == false) goto L14;
        r3.add(r2);
    L17:
        if ((!r3.isEmpty()) == false) goto L10;
        if (r3.size() >= r1) goto L10;
        r1 = r3.size();
        r0 = r3;
        goto L10
    L14:
        if (r8 <= 0) goto L17;
        r3.add(r2);
        r3.addAll(a(r2.getTo(), r7, r8 - 1));
        goto L17
    L21:
        return r0;
    L23:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }
}
