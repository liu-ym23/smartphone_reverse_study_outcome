package com.bytedance.android.live.room.api.messagewindow.monitor;

import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public String a;
    public long b;
    public String c;
    public String d;
    public final Map<String, Object> e;
    public final String f;

    public final void d() {
        if (this.b >= 500) goto L6;
        this.b = 500;
        return;
    }

    public f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "nodeName");
        this.f = r3;
        this.b = 100;
        this.e = new LinkedHashMap();
    }

    public final void a(Object r1) {
        if (r1 == null) goto L4;
        String r2 = r1.toString();
    L5:
        this.a = r2;
        return;
    L4:
        r2 = null;
        goto L5
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.ERROR);
        this.d = r2;
    }

    public final void c(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.e.put(r2, r3);
    }
}
