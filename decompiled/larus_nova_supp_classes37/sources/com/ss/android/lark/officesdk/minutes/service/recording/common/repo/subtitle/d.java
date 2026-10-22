package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final List<h> a;
    public final long b;
    public final boolean c;
    public final Boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    public d() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r9 = (d) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        int r3 = 1231;
        if (this.c == false) goto L5;
        int r4 = 1231;
    L6:
        int r5 = (r2 + r4) * 31;
        Boolean r6 = this.d;
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r5 + r7) * 31;
        if (this.e == false) goto L13;
        int r9 = 1231;
    L14:
        int r10 = (r8 + r9) * 31;
        if (this.f == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r10 + r11) * 31;
        if (this.g == true) goto L23;
        r3 = 1237;
    L23:
        return r12 + r3;
    L17:
        r11 = 1237;
        goto L18
    L13:
        r9 = 1237;
        goto L14
    L9:
        r7 = r6.hashCode();
        goto L10
    L5:
        r4 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingSubtitleEntity(subtitles=" + this.a + ", nextSeqId=" + this.b + ", hasMore=" + this.c + ", isSubtitleOn=" + this.d + ", showBilingual=" + this.e + ", subtitleOpenFailed=" + this.f + ", isSubtitleDegraded=" + this.g + ')';
    }

    public /* synthetic */ d(int r10) {
        this(CollectionsKt.emptyList(), 0, false, null, false, false, false);
    }

    public d(List<h> r2, long r3, boolean r5, Boolean r6, boolean r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "subtitles");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }

    public static d a(d r9, List r10, long r11, boolean r13, Boolean r14, boolean r15, boolean r16, boolean r17, int r18) {
        if ((r18 & 1) == 0) goto L5;
        List r1 = r9.a;
    L7:
        if ((r18 & 2) == 0) goto L9;
        long r2 = r9.b;
    L11:
        if ((r18 & 4) == 0) goto L13;
        boolean r4 = r9.c;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Boolean r5 = r9.d;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r6 = r9.e;
    L23:
        if ((r18 & 32) == 0) goto L25;
        boolean r7 = r9.f;
    L27:
        if ((r18 & 64) == 0) goto L29;
        boolean r8 = r9.g;
    L30:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "subtitles");
        return new d(r1, r2, r4, r5, r6, r7, r8);
    L29:
        r8 = r17;
        goto L30
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
