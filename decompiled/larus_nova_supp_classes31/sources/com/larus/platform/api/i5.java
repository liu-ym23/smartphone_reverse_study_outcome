package com.larus.platform.api;

import com.larus.platform.model.music.ThirdPartyMusicPlatform;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i5 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final p4 e;
    public final ArrayList<String> f;
    public final String g;
    public final String h;
    public final String i;
    public final boolean j;
    public final Function4<? super Integer, ? super Boolean, ? super ThirdPartyMusicPlatform, ? super Integer, Unit> k;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i5) == true) goto L8;
        return false;
    L8:
        i5 r6 = (i5) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
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
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        p4 r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.f.hashCode()) * 31;
        String r8 = this.g;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.h;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.i;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        if (this.j == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (r16 + r17) * 31;
        Function4<? super Integer, ? super Boolean, ? super ThirdPartyMusicPlatform, ? super Integer, Unit> r19 = this.k;
        if (r19 == null) goto L31;
        r2 = r19.hashCode();
    L31:
        return r18 + r2;
    L25:
        r17 = 1237;
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "StartMusicAuthAdditionalJSBParams(id=" + this.a + ", subTitle=" + this.b + ", mainTitle=" + this.c + ", bottomTipTitle=" + this.d + ", musicTraceInfo=" + this.e + ", authTargetList=" + this.f + ", lunaClientKey=" + this.g + ", lunaScope=" + this.h + ", lunaState=" + this.i + ", isNewApplication=" + this.j + ", onMusicPlatformAuthResult=" + this.k + ')';
    }

    public i5(String r2, String r3, String r4, String r5, p4 r6, ArrayList r7, String r8, String r9, String r10, boolean r11, ol9.l r12) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "subTitle");
        Intrinsics.checkNotNullParameter(r4, "mainTitle");
        Intrinsics.checkNotNullParameter(r7, "authTargetList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }
}
