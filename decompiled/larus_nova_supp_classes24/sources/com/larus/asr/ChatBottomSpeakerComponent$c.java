package com.larus.asr;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class ChatBottomSpeakerComponent$c {
    public final boolean a;
    public final boolean b;
    public final String c;
    public final long d;
    public final long e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ChatBottomSpeakerComponent$c) == true) goto L8;
        return false;
    L8:
        ChatBottomSpeakerComponent$c r9 = (ChatBottomSpeakerComponent$c) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        String r4 = this.c;
        if (r4 != null) goto L13;
        int r5 = 0;
    L14:
        int r6 = (r3 + r5) * 31;
        long r7 = this.d;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.e;
        return r8 + ((int) (r9 ^ (r9 >>> 32)));
    L13:
        r5 = r4.hashCode();
        goto L14
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "HandsfreeTraceState(isHandsfreeMode=" + this.a + ", isDirectEntry=" + this.b + ", enterMethod=" + this.c + ", handsfreeDurationMs=" + this.d + ", totalDurationMs=" + this.e + ')';
    }

    public ChatBottomSpeakerComponent$c(boolean r1, boolean r2, String r3, long r4, long r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }
}
