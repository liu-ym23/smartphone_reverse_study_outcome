package u4;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements c {
    public final ConcurrentHashMap<String, ConcurrentHashMap<String, String>> a;

    public d() {
        this.a = new ConcurrentHashMap();
    }

    @Override // u4.c
    public final void b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "storage");
        Intrinsics.checkNotNullParameter(r11, "key");
        ConcurrentHashMap<String, String> r12 = this.a.get(r10);
        if (r12 == null) goto L6;
        String r13 = r12.remove(r11);
        return;
    }

    @Override // u4.c
    public final String a(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "storage");
        Intrinsics.checkNotNullParameter(r11, "key");
        ConcurrentHashMap<String, String> r13 = this.a.get(r10);
        if (r13 == null) goto L9;
        String r14 = r13.get(r11);
        if (r14 != null) goto L8;
        return r12;
    L8:
        return r14;
    L9:
        return r12;
    }

    @Override // u4.c
    public final void c(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "storage");
        Intrinsics.checkNotNullParameter(r11, "key");
        ConcurrentHashMap<String, String> r0 = this.a.get(r10);
        if (r0 != null) goto L5;
        r0 = new ConcurrentHashMap();
    L5:
        r0.put(r11, r12);
        this.a.put(r10, r0);
    }
}
