package is8;

import com.larus.bmhome.upload.sdk.api.model.UploadStage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public final UploadStage a;
    public final String b;
    public final String c;
    public final boolean d;
    public final Throwable e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        Throwable r3 = this.e;
        if (r3 != null) goto L9;
        int r4 = 0;
    L11:
        return r2 + r4;
    L9:
        r4 = r3.hashCode();
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "UploadError(stage=" + this.a + ", code=" + this.b + ", message=" + this.c + ", retryable=" + this.d + ", cause=" + this.e + ')';
    }

    public d(UploadStage r3, String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r3, "stage");
        Intrinsics.checkNotNullParameter("upload_skeleton_failed", "code");
        Intrinsics.checkNotNullParameter(r4, "message");
        this.a = r3;
        this.b = "upload_skeleton_failed";
        this.c = r4;
        this.d = true;
        this.e = r5;
    }
}
