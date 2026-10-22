package iub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmDisplayAvatarTypeData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final MmDisplayAvatarTypeData a;
    public final String b;
    public final String c;
    public final String d;

    public d() {
        this(null, null, null, null, 15);
    }

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
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "MmDisplayAvatarData(type=" + this.a + ", key=" + this.b + ", url=" + this.c + ", userId=" + this.d + ')';
    }

    public final MmDisplayAvatarTypeData getType() {
        return this.a;
    }

    public d(MmDisplayAvatarTypeData r3, String r4, String r5, String r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = MmDisplayAvatarTypeData.NONE;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = "";
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = "";
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = "";
    L14:
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r6, "userId");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
