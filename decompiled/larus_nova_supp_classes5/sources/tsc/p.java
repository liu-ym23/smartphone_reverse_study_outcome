package tsc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kw8.a;
import lsc.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class p extends io.noties.markwon.html.tag.g {
    public final Map<String, a> a;
    public final boolean b;

    public p(Map<String, a> r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // io.noties.markwon.html.tag.g, io.noties.markwon.html.tag.i
    public final Object e(lsc.h r2, t r3, l r4) {
        Intrinsics.checkNotNullParameter(r2, "configuration");
        Intrinsics.checkNotNullParameter(r3, "renderProps");
        Intrinsics.checkNotNullParameter(r4, "tag");
        Object r5 = super.e(r2, r3, r4);
        int r6 = b.a;
        Object[] r7 = b.a(r4, this.a, this.b);
        if (r5 != null) goto L6;
        if (r7 != null) goto L6;
        return null;
    L6:
        ArrayList r8 = new ArrayList();
        if (r7 == null) goto L13;
        Iterator r9 = ArraysKt.filterNotNull(r7).iterator();
    L10:
        if (r9.hasNext() == false) goto L13;
        r8.add(r9.next());
    L13:
        if ((r5 instanceof Object[]) == false) goto L18;
        Iterator r10 = ArraysKt.filterNotNull((Object[]) r5).iterator();
    L16:
        if (r10.hasNext() == false) goto L20;
        r8.add(r10.next());
    L20:
        Object[] r11 = r8.toArray(new Object[0]);
        if (r11 == null) goto L24;
        return r11;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L18:
        if (r5 == null) goto L20;
        r8.add(r5);
        goto L20
    }
}
