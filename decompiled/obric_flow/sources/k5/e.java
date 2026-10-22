package k5;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends b {
    public static final e d = null;
    public static final ArrayList e = null;

    static {
        d = new e("default_bid");
        e = CollectionsKt.arrayListOf(new b[]{j.d, i.d, c.d});
    }

    @Override // k5.b
    public final a a(String r5, String r10) {
        Iterator r11 = e.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        a r12 = ((b) r11.next()).a(r5, r10);
        if (r12.a() == false) goto L4;
        return r12;
    L9:
        return this.f18599b;
    }
}
