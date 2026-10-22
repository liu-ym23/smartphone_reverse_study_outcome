package com.bytedance.android.live.revlink.impl.multianchor.match;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final c a(MultiPkMatchContext r0) {
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.m<c> r1 = r0.getMatchStatus();
        if (r1 == null) goto L8;
        c r2 = (c) r1.getValue();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return new c.C0146c();
    }
}
