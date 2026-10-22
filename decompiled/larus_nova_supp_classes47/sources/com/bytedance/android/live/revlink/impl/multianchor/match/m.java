package com.bytedance.android.live.revlink.impl.multianchor.match;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m {
    public static final c a() {
        MultiPkMatchContext r0 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<c> r1 = r0.getMatchStatus();
        if (r1 == null) goto L9;
        c r2 = (c) r1.getValue();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return new c.C0146c();
    }
}
