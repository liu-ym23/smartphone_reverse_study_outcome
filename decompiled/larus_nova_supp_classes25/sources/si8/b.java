package si8;

import com.larus.bmhome.video.Content;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import oi8.k;
import pi8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b implements pi8.a {
    public b() {
    }

    @Override // pi8.a
    public final o a(k r3, oi8.c r4) {
        Intrinsics.checkNotNullParameter(r3, "originData");
        ArrayList r5 = new ArrayList();
        com.larus.bmhome.chat.search.b r6 = r3.e();
        if (r6 == null) goto L7;
        com.larus.bmhome.chat.search.b.C0073b r7 = r6.d();
        if (r7 == null) goto L7;
        List<Content> r8 = r7.a();
    L8:
        List<Content> r0 = r8;
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == true) goto L17;
        Iterator<T> r9 = r8.iterator();
    L20:
        if (r9.hasNext() == false) goto L23;
        r5.add((Content) r9.next());
        goto L20
    L23:
        return new o(r5, true);
    L17:
        return new o(r5, true);
    L11:
        if (r0.isEmpty() == true) goto L14;
        r1 = false;
    L7:
        r8 = null;
        goto L8
    }
}
