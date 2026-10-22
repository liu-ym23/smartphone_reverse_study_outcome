package ebb;

import java.io.File;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d<T> implements Comparator {
    public final /* synthetic */ Map<String, Long> a;

    public d(Map<String, Long> r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(Object r4, Object r5) {
        File r6 = (File) r4;
        File r7 = (File) r5;
        Long r0 = this.a.get(r7.getAbsolutePath());
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
    L6:
        Long r8 = this.a.get(r6.getAbsolutePath());
        if (r8 == null) goto L9;
        long r9 = r8.longValue();
    L11:
        if (r1 >= r9) goto L13;
        return -1;
    L13:
        if (r1 != r9) goto L15;
        return 0;
    L15:
        return 1;
    L9:
        r9 = r6.lastModified();
        goto L11
    L5:
        r1 = r7.lastModified();
        goto L6
    }
}
