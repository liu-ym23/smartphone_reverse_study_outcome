package mp9;

import android.net.Uri;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public final long a;
    public final Uri b;
    public final MediaType c;
    public final String d;
    public final long e;
    public final String f;
    public final String g;
    public final long h;
    public final long i;
    public final int j;
    public final int k;
    public final long l;

    public c() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (this.a == r9.a) goto L12;
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
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
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
        long r0 = this.a;
        int r1 = ((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        long r3 = this.e;
        int r2 = (((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        long r4 = this.h;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.i;
        int r7 = (((((r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31) + this.j) * 31) + this.k) * 31;
        long r8 = this.l;
        return r7 + ((int) (r8 ^ (r8 >>> 32)));
    }

    public final String toString() {
        return "MediaItem(id=" + this.a + ", uri=" + this.b + ", type=" + this.c + ", name=" + this.d + ", folderId=" + this.e + ", folderName=" + this.f + ", mimeType=" + this.g + ", dateAdded=" + this.h + ", duration=" + this.i + ", width=" + this.j + ", height=" + this.k + ", size=" + this.l + ')';
    }

    public final MediaType getType() {
        return this.c;
    }

    public /* synthetic */ c(int r19) {
        this(0, Uri.EMPTY, MediaType.IMAGE, "", -1, "", "", 0, 0, 0, 0, 0);
    }

    public c(long r9, Uri r11, MediaType r12, String r13, long r14, String r16, String r17, long r18, long r20, int r22, int r23, long r24) {
        Intrinsics.checkNotNullParameter(r11, "uri");
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r13, "name");
        Intrinsics.checkNotNullParameter(r16, "folderName");
        Intrinsics.checkNotNullParameter(r17, "mimeType");
        this.a = r9;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r20;
        this.j = r22;
        this.k = r23;
        this.l = r24;
    }
}
