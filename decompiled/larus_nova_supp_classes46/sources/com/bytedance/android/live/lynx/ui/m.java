package com.bytedance.android.live.lynx.ui;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m extends com.lynx.tasm.event.a {
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public final Map<String, Object> b() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("current", Integer.valueOf(this.b));
        r0.put("total", Integer.valueOf(this.c));
        r0.put("loopIndex", Integer.valueOf(this.d));
        return r0;
    }

    public m(int r1, int r2, int r3, int r4, String r5) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        super(r4, r5);
    }
}
