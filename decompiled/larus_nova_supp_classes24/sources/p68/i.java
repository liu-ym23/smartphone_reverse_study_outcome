package p68;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public i() {
        this(null, null, null, null, null, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "VoiceStyleInfo(ttsSpeakerId=" + this.a + ", ttsSpeakerName=" + this.b + ", voiceId=" + this.c + ", extra=" + this.d + ", audioMetrics=" + this.e + ')';
    }

    public final String a() {
        return this.e;
    }

    public final String b() {
        return this.d;
    }

    public final String c() {
        return this.a;
    }

    public final String d() {
        return this.b;
    }

    public i(String r3, String r4, String r5, String r6, String r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r3 = "";
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = "";
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = "";
    L12:
        if ((r8 & 8) == 0) goto L15;
        r6 = "";
    L15:
        if ((r8 & 16) == 0) goto L17;
        r7 = "";
    L17:
        Intrinsics.checkNotNullParameter(r3, "ttsSpeakerId");
        Intrinsics.checkNotNullParameter(r4, "ttsSpeakerName");
        Intrinsics.checkNotNullParameter(r5, "voiceId");
        Intrinsics.checkNotNullParameter(r6, "extra");
        Intrinsics.checkNotNullParameter(r7, "audioMetrics");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }
}
