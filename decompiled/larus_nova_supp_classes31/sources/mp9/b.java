package mp9;

import android.net.Uri;
import com.larus.photopicker.v2.impl.model.MediaTab;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final long a;
    public final String b;
    public final Uri c;
    public final int d;
    public final Map<MediaTab, Integer> e;
    public final Map<MediaTab, List<c>> f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31;
        Uri r2 = this.c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return ((((((r1 + r3) * 31) + this.d) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public final String toString() {
        return "MediaFolder(id=" + this.a + ", name=" + this.b + ", coverUri=" + this.c + ", mediaCount=" + this.d + ", mediaCountMap=" + this.e + ", mediaItemsMap=" + this.f + ')';
    }

    public static b a(b r10, int r11, Map r12, Map r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        long r0 = r10.a;
    L6:
        long r3 = r0;
        if ((r14 & 2) == 0) goto L9;
        String r5 = r10.b;
    L11:
        if ((r14 & 4) == 0) goto L13;
        Uri r6 = r10.c;
    L15:
        if ((r14 & 8) == 0) goto L17;
        r11 = r10.d;
    L17:
        int r7 = r11;
        if ((r14 & 16) == 0) goto L20;
        r12 = r10.e;
    L20:
        Map r8 = r12;
        if ((r14 & 32) == 0) goto L23;
        r13 = r10.f;
    L23:
        Map r9 = r13;
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r8, "mediaCountMap");
        Intrinsics.checkNotNullParameter(r9, "mediaItemsMap");
        return new b(r3, r5, r6, r7, r8, r9);
    L13:
        r6 = null;
        goto L15
    L9:
        r5 = null;
        goto L11
    L5:
        r0 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(long r2, String r4, Uri r5, int r6, Map<MediaTab, Integer> r7, Map<MediaTab, ? extends List<c>> r8) {
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r7, "mediaCountMap");
        Intrinsics.checkNotNullParameter(r8, "mediaItemsMap");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }
}
