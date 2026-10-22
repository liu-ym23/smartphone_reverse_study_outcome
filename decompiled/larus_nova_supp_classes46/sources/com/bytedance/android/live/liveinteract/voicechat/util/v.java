package com.bytedance.android.live.liveinteract.voicechat.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final String e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof v) == false) goto L16;
        v r4 = (v) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r0 = ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
        String r1 = this.e;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "VoiceSceneSwitchConfirmDialogParam(fromSubScene=" + this.a + ", toSubScene=" + this.b + ", fromUILayout=" + this.c + ", toUILayout=" + this.d + ", reason=" + this.e + ")";
    }

    public v(int r2, int r3, int r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
