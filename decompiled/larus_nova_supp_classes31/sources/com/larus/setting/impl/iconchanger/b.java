package com.larus.setting.impl.iconchanger;

import com.larus.bmhome.auth.CocoSetting;
import com.larus.im.bean.bot.SpeakerVoice;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final boolean a;
    public final int b;
    public final boolean c;
    public final boolean d;
    public final Map<String, String> e;
    public final Map<String, SpeakerVoice> f;
    public final Integer g;
    public final int h;
    public final CocoSetting i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.b) * 31;
        if (this.c == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.d == true) goto L14;
        r1 = 1237;
    L14:
        int r5 = (r4 + r1) * 31;
        Map<String, String> r6 = this.e;
        int r7 = 0;
        if (r6 != null) goto L17;
        int r8 = 0;
    L18:
        int r9 = (r5 + r8) * 31;
        Map<String, SpeakerVoice> r10 = this.f;
        if (r10 != null) goto L21;
        int r11 = 0;
    L22:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.g;
        if (r13 == null) goto L27;
        r7 = r13.hashCode();
    L27:
        return ((((r12 + r7) * 31) + this.h) * 31) + this.i.hashCode();
    L21:
        r11 = r10.hashCode();
        goto L22
    L17:
        r8 = r6.hashCode();
        goto L18
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChangeAppIconData(needAdjust=" + this.a + ", adjustHeight=" + this.b + ", selected=" + this.c + ", useDynamicIcon=" + this.d + ", cocoVoiceTypeMap=" + this.e + ", voice=" + this.f + ", appIconId=" + this.g + ", appIcon=" + this.h + ", cocoSetting=" + this.i + ')';
    }

    public static b a(b r10, boolean r11, int r12, boolean r13, Map r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        r11 = r10.a;
    L5:
        boolean r1 = r11;
        if ((r15 & 2) == 0) goto L8;
        r12 = r10.b;
    L8:
        int r2 = r12;
        if ((r15 & 4) == 0) goto L11;
        r13 = r10.c;
    L11:
        boolean r3 = r13;
        if ((r15 & 8) == 0) goto L14;
        boolean r4 = r10.d;
    L16:
        if ((r15 & 16) == 0) goto L18;
        Map<String, String> r5 = r10.e;
    L20:
        if ((r15 & 32) == 0) goto L22;
        r14 = r10.f;
    L22:
        Map r6 = r14;
        if ((r15 & 64) == 0) goto L25;
        Integer r7 = r10.g;
    L27:
        if ((r15 & 128) == 0) goto L29;
        int r8 = r10.h;
    L31:
        if ((r15 & 256) == 0) goto L33;
        CocoSetting r9 = r10.i;
    L34:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r9, "cocoSetting");
        return new b(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    L33:
        r9 = null;
        goto L34
    L29:
        r8 = 0;
        goto L31
    L25:
        r7 = null;
        goto L27
    L18:
        r5 = null;
        goto L20
    L14:
        r4 = false;
        goto L16
    }

    public b(boolean r2, int r3, boolean r4, boolean r5, Map<String, String> r6, Map<String, SpeakerVoice> r7, Integer r8, int r9, CocoSetting r10) {
        Intrinsics.checkNotNullParameter(r10, "cocoSetting");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
