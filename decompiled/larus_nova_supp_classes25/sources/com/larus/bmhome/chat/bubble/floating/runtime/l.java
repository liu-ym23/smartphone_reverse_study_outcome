package com.larus.bmhome.chat.bubble.floating.runtime;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerState;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l {
    public final LinkedHashMap<String, pc8.e> a;
    public final Map<String, String> b;

    public l() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
    }

    public final synchronized pc8.e a(String r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "promptId");     // Catch: Throwable -> L6
        pc8.e r3 = this.a.get(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public final pc8.e b(String r4) {
        String r0 = (String) ((LinkedHashMap) this.b).get(r4);
        if (r0 != null) goto L5;
        return null;
    L5:
        pc8.e r1 = this.a.get(r0);
        if (r1 != null) goto L8;
    L11:
        this.b.remove(r4);
        return null;
    L8:
        if (Intrinsics.areEqual(r1.b.b, r4) == false) goto L11;
        return r1;
    }

    public final synchronized void c(String r17, long r18) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r17, "promptId");     // Catch: Throwable -> L24
        pc8.e r3 = this.a.get(r17);     // Catch: Throwable -> L24
        if (r3 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        LinkedHashMap<String, pc8.e> r2 = this.a;     // Catch: Throwable -> L24
        BubbleBannerState r4 = BubbleBannerState.VISIBLE;     // Catch: Throwable -> L24
        if (r3.f == false) goto L11;
        long r6 = 0;
    L21:
        r2.put(r17, pc8.e.a(r3, r4, null, r6, false, false, true, null, null, null, null, 3947));     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L11:
        Long r7 = Long.valueOf(r3.e);     // Catch: Throwable -> L24
        if (r7.longValue() <= 0) goto L14;
        boolean r8 = true;
    L15:
        if (r8 == true) goto L18;
        r7 = null;
    L18:
        if (r7 == null) goto L20;
        r6 = r7.longValue();     // Catch: Throwable -> L24
        goto L21
    L20:
        r6 = r18;
        goto L21
    L14:
        r8 = false;
    L24:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(String r17, pc8.i r18) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r17, "promptId");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r18, "transition");     // Catch: Throwable -> L11
        pc8.e r3 = this.a.get(r17);     // Catch: Throwable -> L11
        if (r3 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.a.put(r17, pc8.e.a(r3, BubbleBannerState.ENTERING, null, 0, false, false, false, null, r18, null, null, 3579));     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
