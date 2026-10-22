package yt8;

import com.larus.bmhome.bigimg.t1;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.platform.model.GeoLocationInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements t1 {
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
    public final int k;
    public final int l;
    public final int m;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
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
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L44;
        return false;
    L44:
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
    L19:
        return ((((r8 + r10) * 31) + this.k) * 31) + this.l;
    L17:
        r10 = r9.hashCode();
        goto L19
    L9:
        r6 = 1237;
        goto L10
    L5:
        r4 = 1237;
        goto L6
    }

    public final String toString() {
        return "ImageFileItem(name=" + this.a + ", path=" + this.b + ", lastModified=" + this.c + ", mediaID=" + this.d + ", side=" + this.e + ", inSelectMode=" + this.f + ", isSelected=" + this.g + ", inProgressing=" + this.h + ", index=" + this.i + ", geoLocationInfo=" + this.j + ", width=" + this.k + ", height=" + this.l + ')';
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
        return this.m;
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

    public /* synthetic */ a(String r15, String r16, long r17, String r19, boolean r20, boolean r21, int r22, GeoLocationInfo r23, int r24, int r25) {
        this(r15, r16, r17, r19, 0, r20, false, r21, r22, r23, r24, r25);
    }

    public final t1 f(String r17, String r18, long r19, String r21, int r22, boolean r23, boolean r24, boolean r25, int r26, GeoLocationInfo r27) {
        Intrinsics.checkNotNullParameter(r17, "name");
        Intrinsics.checkNotNullParameter(r18, MusicAppletPage.KEY_PATH);
        Intrinsics.checkNotNullParameter(r21, "mediaID");
        return new a(r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, this.k, this.l);
    }

    public a(String r2, String r3, long r4, String r6, int r7, boolean r8, boolean r9, boolean r10, int r11, GeoLocationInfo r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, MusicAppletPage.KEY_PATH);
        Intrinsics.checkNotNullParameter(r6, "mediaID");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = 1;
    }
}
