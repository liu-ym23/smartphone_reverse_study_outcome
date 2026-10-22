package r5;

import android.util.LruCache;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends LruCache<String, a> {
    public d() {
        super(5242880);
    }

    @Override // android.util.LruCache
    public final int sizeOf(String r1, a r10) {
        a r11 = r10;
        if (r11 == null) goto L9;
        p5.b r12 = r11.a;
        if (r12 == null) goto L9;
        byte[] r13 = r12.a;
        if (r13 == null) goto L9;
        return r13.length;
    L9:
        return 0;
    }
}
