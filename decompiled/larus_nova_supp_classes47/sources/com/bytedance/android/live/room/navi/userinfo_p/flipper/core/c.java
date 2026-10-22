package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> extends j91.a<j91.b<T>> {
    public c() {
    }

    public final <D> void a(D r4) {
        List<T> r5 = this.a;
        monitor-enter(r5);
        int r0 = ((ArrayList) this.a).size();     // Catch: Throwable -> L16
    L5:
        r0 = r0 - 1;     // Catch: Throwable -> L16
        if (r0 < 0) goto L13;
        Object r1 = ((ArrayList) this.a).get(r0);     // Catch: Throwable -> L16
        if ((r1 instanceof j91.b) == true) goto L10;
        r1 = null;
    L10:
        j91.b r2 = (j91.b) r1;     // Catch: Throwable -> L16
        if (r2 == null) goto L5;
        r2.onChange();     // Catch: Throwable -> L16
        goto L5
    L13:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r5);
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
