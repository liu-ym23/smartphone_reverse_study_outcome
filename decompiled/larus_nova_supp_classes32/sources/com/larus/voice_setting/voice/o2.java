package com.larus.voice_setting.voice;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o2 {
    public final SpeakerVoice a;
    public int b;
    public int c;
    public int d;
    public int e;
    public final int f;

    public o2() {
        this(null, 0, 0, 0, 0, 63, 0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o2) == true) goto L8;
        return false;
    L8:
        o2 r6 = (o2) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        SpeakerVoice r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((((((((r1 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f;
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "VoiceItem(voice=" + this.a + ", selectedState=" + this.b + ", uploadState=" + this.c + ", playState=" + this.d + ", addState=" + this.e + ", itemType=" + this.f + ')';
    }

    public static o2 a(o2 r7, SpeakerVoice r8) {
        return new o2(r8, r7.b, r7.c, r7.d, r7.e, r7.f);
    }

    public o2(SpeakerVoice r1, int r2, int r3, int r4, int r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public /* synthetic */ o2(SpeakerVoice r8, int r9, int r10, int r11, int r12, int r13, int r14) {
        if ((r13 & 1) == 0) goto L5;
        r8 = null;
    L5:
        SpeakerVoice r1 = r8;
        if ((r13 & 2) == 0) goto L8;
        int r2 = 10;
    L10:
        if ((r13 & 4) == 0) goto L12;
        int r3 = 1;
    L14:
        if ((r13 & 8) == 0) goto L16;
        int r4 = 2;
    L18:
        if ((r13 & 16) == 0) goto L20;
        int r5 = 60;
    L22:
        if ((r13 & 32) == 0) goto L24;
        int r6 = 0;
    L25:
        this(r1, r2, r3, r4, r5, r6);
        return;
    L24:
        r6 = r12;
        goto L25
    L20:
        r5 = r11;
        goto L22
    L16:
        r4 = 0;
        goto L18
    L12:
        r3 = r10;
        goto L14
    L8:
        r2 = r9;
        goto L10
    }
}
