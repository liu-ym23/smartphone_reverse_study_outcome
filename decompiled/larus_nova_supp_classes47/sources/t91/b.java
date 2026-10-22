package t91;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends e {
    public final List<Integer> a;

    public b() {
        this.a = CollectionsKt.listOf(new Integer[]{3, 5, 6});
    }

    @Override // s91.c
    public final u91.a a(Object r2) {
        ((Number) r2).intValue();
        return new u91.a(new o91.b.f());
    }

    @Override // s91.c
    public final boolean b(boolean r3, int r4, Integer r5) {
        int r6 = r5.intValue();
        if (r3 == true) goto L6;
        if (r4 != 1) goto L6;
        boolean r7 = true;
    L7:
        if (r7 == false) goto L10;
    L18:
        return false;
    L10:
        if (r6 != 11) goto L13;
        if (r3 == true) goto L13;
        return true;
    L13:
        if (r6 != 10) goto L16;
        if (r3 == false) goto L16;
        return true;
    L16:
        if (this.a.contains(Integer.valueOf(r6)) == false) goto L18;
        return true;
    L6:
        r7 = false;
        goto L7
    }
}
