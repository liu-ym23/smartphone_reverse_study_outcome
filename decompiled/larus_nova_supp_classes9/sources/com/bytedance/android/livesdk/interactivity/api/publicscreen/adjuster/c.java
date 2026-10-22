package com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends d {
    public final int e;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d
    public final String toString() {
        return "ExtendsHeightInfo(roomChannelHeight=" + this.e + ", expectedHeight=" + this.a + ", bottomMargin=" + this.b + ')';
    }

    public c(int r2, int r3, int r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "platformStrategyLevel");
        super(r3, r4, r5, r6);
        this.e = r2;
    }

    public /* synthetic */ c(int r7, int r8, int r9, int r10, String r11, int r13) {
        if ((r13 & 4) == 0) goto L5;
        int r3 = -10086;
    L7:
        if ((r13 & 8) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r13 & 16) == 0) goto L13;
        r11 = "default";
    L13:
        this(r7, r8, r3, r4, r11);
        return;
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }
}
