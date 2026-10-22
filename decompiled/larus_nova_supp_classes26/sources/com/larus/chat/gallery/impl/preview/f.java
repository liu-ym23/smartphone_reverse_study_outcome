package com.larus.chat.gallery.impl.preview;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public final PreviewChromeKind a;
    public final r b;
    public final c c;
    public final com.larus.chat.gallery.api.q d;
    public final List<com.larus.chat.gallery.api.o> e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final e i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (this.a == r6.a) goto L12;
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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
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
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        com.larus.chat.gallery.api.q r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((r0 + r2) * 31) + this.e.hashCode()) * 31;
        int r4 = 1231;
        if (this.f == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.g == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.h == true) goto L19;
        r4 = 1237;
    L19:
        return ((r8 + r4) * 31) + this.i.hashCode();
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreviewExperienceProfile(chromeKind=" + this.a + ", sourcePolicy=" + this.b + ", albumFlowPolicy=" + this.c + ", mediaSession=" + this.d + ", mediaItems=" + this.e + ", showInput=" + this.f + ", showTracker=" + this.g + ", showLargeThumbnails=" + this.h + ", displayProfile=" + this.i + ')';
    }

    public f(PreviewChromeKind r2, r r3, c r4, com.larus.chat.gallery.api.q r5, List<com.larus.chat.gallery.api.o> r6, boolean r7, boolean r8, boolean r9, e r10) {
        Intrinsics.checkNotNullParameter(r2, "chromeKind");
        Intrinsics.checkNotNullParameter(r3, "sourcePolicy");
        Intrinsics.checkNotNullParameter(r4, "albumFlowPolicy");
        Intrinsics.checkNotNullParameter(r6, "mediaItems");
        Intrinsics.checkNotNullParameter(r10, "displayProfile");
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
