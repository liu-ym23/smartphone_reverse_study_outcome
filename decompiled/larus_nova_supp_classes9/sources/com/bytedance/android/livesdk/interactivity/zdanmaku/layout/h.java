package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements Comparator<Integer> {
    public final /* synthetic */ j a;

    public h(j r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(Integer r2, Integer r3) {
        int r4 = r2.intValue();
        int r5 = r3.intValue();
        int r0 = this.a.a.a / 2;
        if (Math.abs(r4 - r0) <= Math.abs(r5 - r0)) goto L5;
        return 1;
    L5:
        return -1;
    }
}
