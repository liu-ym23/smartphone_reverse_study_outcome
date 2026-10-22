package yt8;

import com.larus.bmhome.bigimg.t1;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.platform.model.GeoLocationInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p implements t1 {
    public final String a;
    public final String b;
    public final long c;
    public final String d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final GeoLocationInfo j;
    public final double k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof p) == true) goto L8;
        return false;
    L8:
        p r9 = (p) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
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
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Double.compare(this.k, r9.k) == 0) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        int r2 = (((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.d.hashCode()) * 31) + this.e) * 31;
        int r3 = 1231;
        if (this.f == false) goto L5;
        int r4 = 1231;
    L6:
        int r5 = (r2 + r4) * 31;
        if (this.g == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r5 + r6) * 31;
        if (this.h == true) goto L14;
        r3 = 1237;
    L14:
        int r8 = (((r7 + r3) * 31) + this.i) * 31;
        GeoLocationInfo r9 = this.j;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        long r12 = Double.doubleToLongBits(this.k);
        return ((((((r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31) + this.l) * 31) + this.m) * 31) + this.n;
    L17:
        r10 = r9.hashCode();
        goto L18
    L9:
        r6 = 1237;
        goto L10
    L5:
        r4 = 1237;
        goto L6
    }

    public final String toString() {
        return "VideoFileItem(name=" + this.a + ", path=" + this.b + ", lastModified=" + this.c + ", mediaID=" + this.d + ", side=" + this.e + ", inSelectMode=" + this.f + ", isSelected=" + this.g + ", inProgressing=" + this.h + ", index=" + this.i + ", geoLocationInfo=" + this.j + ", duration=" + this.k + ", width=" + this.l + ", height=" + this.m + ", bitrate=" + this.n + ')';
    }

    public final GeoLocationInfo a() {
        return this.j;
    }

    public final boolean b() {
        return this.f;
    }

    public final int c() {
        return this.e;
    }

    public final boolean d() {
        return this.h;
    }

    public final long e() {
        return this.c;
    }

    public final String g() {
        return this.d;
    }

    public final int getIndex() {
        return this.i;
    }

    public final int getMediaType() {
        return this.o;
    }

    public final String getName() {
        return this.a;
    }

    public final String getPath() {
        return this.b;
    }

    public final boolean isSelected() {
        return this.g;
    }

    public final t1 f(String r20, String r21, long r22, String r24, int r25, boolean r26, boolean r27, boolean r28, int r29, GeoLocationInfo r30) {
        Intrinsics.checkNotNullParameter(r20, "name");
        Intrinsics.checkNotNullParameter(r21, MusicAppletPage.KEY_PATH);
        Intrinsics.checkNotNullParameter(r24, "mediaID");
        return new p(r20, r21, r22, r24, r25, r26, r27, r28, r29, r30, this.k, this.l, this.m, this.n);
    }

    public /* synthetic */ p(String r18, String r19, long r20, String r22, boolean r23, boolean r24, int r25, GeoLocationInfo r26, double r27, int r29, int r30) {
        this(r18, r19, r20, r22, 0, r23, false, r24, r25, r26, r27, r29, r30, 0);
    }

    public p(String r6, String r7, long r8, String r10, int r11, boolean r12, boolean r13, boolean r14, int r15, GeoLocationInfo r16, double r17, int r19, int r20, int r21) {
        Intrinsics.checkNotNullParameter(r6, "name");
        Intrinsics.checkNotNullParameter(r7, MusicAppletPage.KEY_PATH);
        Intrinsics.checkNotNullParameter(r10, "mediaID");
        this.a = r6;
        this.b = r7;
        this.c = r8;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r17;
        this.l = r19;
        this.m = r20;
        this.n = r21;
        this.o = 2;
    }
}
