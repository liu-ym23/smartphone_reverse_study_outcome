package n4a;

import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g3 implements Comparator<String> {
    public final /* synthetic */ h3 a;

    public g3(h3 r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(String r4, String r5) {
        ConcurrentHashMap r0 = (ConcurrentHashMap) this.a.c;
        long r1 = ((h3.b) r0.get(r5)).c;
        ConcurrentHashMap r6 = (ConcurrentHashMap) this.a.c;
        long r7 = ((h3.b) r6.get(r4)).c;
        if (r1 >= r7) goto L5;
        return -1;
    L5:
        if (r1 != r7) goto L7;
        return 0;
    L7:
        return 1;
    }
}
