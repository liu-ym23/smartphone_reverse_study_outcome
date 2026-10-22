package r5;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final p5.b a;
    public final String b;
    public final String c;
    public final InputStream d;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "AppletCacheResponse(byteArray=" + this.a + ", cacheKey=" + this.b + ", filePath=" + this.c + ", fileStream=" + this.d + ')';
    }

    public static a a(a r10) {
        p5.b r0 = r10.a;
        String r1 = r10.b;
        String r11 = r10.c;
        InputStream r12 = r10.d;
        Intrinsics.checkNotNullParameter(r0, "byteArray");
        Intrinsics.checkNotNullParameter(r1, "cacheKey");
        Intrinsics.checkNotNullParameter(r11, "filePath");
        Intrinsics.checkNotNullParameter(r12, "fileStream");
        return new a(r0, r1, r11, r12);
    }

    public a(p5.b r10, String r11, String r12, InputStream r13) {
        Intrinsics.checkNotNullParameter(r10, "byteArray");
        Intrinsics.checkNotNullParameter(r11, "cacheKey");
        Intrinsics.checkNotNullParameter(r12, "filePath");
        Intrinsics.checkNotNullParameter(r13, "fileStream");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
    }
}
