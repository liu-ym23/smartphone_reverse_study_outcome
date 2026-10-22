package is8;

import com.larus.bmhome.upload.sdk.api.model.AuthMode;
import com.larus.bmhome.upload.sdk.api.model.UploadEngineType;
import com.larus.bmhome.upload.sdk.api.model.UploadScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final AuthMode a;
    public final UploadEngineType b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final UploadScene f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        int r2 = 1231;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.d == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.e == true) goto L15;
        r2 = 1237;
    L15:
        return ((r5 + r2) * 31) + this.f.hashCode();
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ResolvedUploadRoute(authMode=" + this.a + ", engineType=" + this.b + ", needRegister=" + this.c + ", needPreParse=" + this.d + ", needResourceCenter=" + this.e + ", uploadScene=" + this.f + ')';
    }

    public a(AuthMode r2, UploadEngineType r3, boolean r4, boolean r5, boolean r6, UploadScene r7) {
        Intrinsics.checkNotNullParameter(r2, "authMode");
        Intrinsics.checkNotNullParameter(r3, "engineType");
        Intrinsics.checkNotNullParameter(r7, "uploadScene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
