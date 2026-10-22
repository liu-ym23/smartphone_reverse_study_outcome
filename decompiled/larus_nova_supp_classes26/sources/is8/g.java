package is8;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.upload.sdk.api.model.UploadMediaType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public final i a;
    public final UploadMediaType b;
    public final c c;
    public final f d;
    public final e e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "UploadRequest(source=" + this.a + ", mediaType=" + this.b + ", bizContext=" + this.c + ", policy=" + this.d + ", metadata=" + this.e + ')';
    }

    public g(i r2, UploadMediaType r3, c r4, f r5, e r6) {
        Intrinsics.checkNotNullParameter(r2, MusicAppletPage.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r3, "mediaType");
        Intrinsics.checkNotNullParameter(r4, "bizContext");
        Intrinsics.checkNotNullParameter(r5, "policy");
        Intrinsics.checkNotNullParameter(r6, "metadata");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
