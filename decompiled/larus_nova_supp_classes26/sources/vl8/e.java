package vl8;

import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final boolean f;
    public final String g;
    public final g h;
    public final Integer i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
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
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        int r2 = 1231;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.f == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (((((r3 + r2) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        Integer r5 = this.i;
        if (r5 != null) goto L13;
        int r6 = 0;
    L15:
        return r4 + r6;
    L13:
        r6 = r5.hashCode();
        goto L15
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "LocalFileCardViewInput(darkIcon=" + this.a + ", lightIcon=" + this.b + ", fileName=" + this.c + ", fileType=" + this.d + ", showFileType=" + this.e + ", showPlayAudioButton=" + this.f + ", path=" + this.g + ", playbackState=" + this.h + ", rootBackgroundRes=" + this.i + ')';
    }

    public e(String r2, String r3, String r4, String r5, boolean r6, boolean r7, String r8, g r9, Integer r10) {
        Intrinsics.checkNotNullParameter(r2, "darkIcon");
        Intrinsics.checkNotNullParameter(r3, "lightIcon");
        Intrinsics.checkNotNullParameter(r4, "fileName");
        Intrinsics.checkNotNullParameter(r5, "fileType");
        Intrinsics.checkNotNullParameter(r8, MusicAppletPage.KEY_PATH);
        Intrinsics.checkNotNullParameter(r9, "playbackState");
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
