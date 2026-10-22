package y58;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public final String a;
    public final String b;

    public d() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "AudioSdkAsrTraceInfo(traceId=" + this.a + ", enterFrom=" + this.b + ')';
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public /* synthetic */ d(int r1) {
        this("", "");
    }

    public d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "enterFrom");
        this.a = r2;
        this.b = r3;
    }
}
