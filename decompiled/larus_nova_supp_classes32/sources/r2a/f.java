package r2a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final String f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.f.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "UgcVoiceInfo(avatarUrl=" + this.a + ", avatarUri=" + this.b + ", voiceName=" + this.c + ", localVoiceId=" + this.d + ", isPublic=" + this.e + ", languageCode=" + this.f + ')';
    }

    public f(String r2, String r3, String r4, String r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "avatarUrl");
        Intrinsics.checkNotNullParameter(r3, "avatarUri");
        Intrinsics.checkNotNullParameter(r4, "voiceName");
        Intrinsics.checkNotNullParameter(r5, "localVoiceId");
        Intrinsics.checkNotNullParameter(r7, "languageCode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
