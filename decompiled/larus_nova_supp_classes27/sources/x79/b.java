package x79;

import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.select.ChatRecentFileSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final long d;
    public final DriveFileType e;
    public final long f;
    public final String g;
    public final Integer h;
    public final ChatRecentFileSource i;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
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
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        long r1 = this.d;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.e.hashCode()) * 31;
        long r3 = this.f;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r5 = this.g;
        int r6 = 0;
        if (r5 != null) goto L5;
        int r7 = 0;
    L6:
        int r8 = (r4 + r7) * 31;
        Integer r9 = this.h;
        if (r9 == null) goto L11;
        r6 = r9.hashCode();
    L11:
        return ((r8 + r6) * 31) + this.i.hashCode();
    L5:
        r7 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatRecentFileItem(name=" + this.a + ", uri=" + this.b + ", url=" + this.c + ", size=" + this.d + ", fileType=" + this.e + ", createTime=" + this.f + ", driveUplinkInfo=" + this.g + ", baseBizType=" + this.h + ", source=" + this.i + ')';
    }

    public b(String r2, String r3, String r4, long r5, DriveFileType r7, long r8, String r10, Integer r11, ChatRecentFileSource r12) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "uri");
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r7, "fileType");
        Intrinsics.checkNotNullParameter(r12, "source");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r10;
        this.h = r11;
        this.i = r12;
    }
}
