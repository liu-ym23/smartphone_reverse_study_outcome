package com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class d {
    public final int a;
    public final int b;
    public final int c;
    public final String d;

    public d() {
        int r0 = 0;
        this(r0, r0, 15);
    }

    public String toString() {
        return "HeightInfo(expectedHeight=" + this.a + ", bottomMargin=" + this.b + ')';
    }

    public /* synthetic */ d(int r3, int r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = -10086;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r4 = -10086;
    L9:
        if ((r5 & 8) == 0) goto L11;
        String r6 = "default";
    L12:
        this(r3, r4, 0, r6);
        return;
    L11:
        r6 = null;
        goto L12
    }

    public d(int r2, int r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "platformStrategyLevel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
