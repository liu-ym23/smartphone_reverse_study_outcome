package eub;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadErrorCode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final MmMinutesFileUploadErrorCode a;
    public final String b;
    public final Integer c;
    public final e d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Integer r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        e r5 = this.d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmMinutesFileUploadError(code=" + this.a + ", message=" + this.b + ", rawCode=" + this.c + ", quotaInfo=" + this.d + ')';
    }

    public b(MmMinutesFileUploadErrorCode r2, String r3, Integer r4, e r5) {
        Intrinsics.checkNotNullParameter(r2, "code");
        Intrinsics.checkNotNullParameter(r3, "message");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public /* synthetic */ b(MmMinutesFileUploadErrorCode r2, String r3, Integer r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4, null);
    }
}
