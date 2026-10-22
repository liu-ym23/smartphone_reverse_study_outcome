package ovb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final String a;
    public final int b;

    /* JADX INFO: renamed from: ovb.a$a, reason: collision with other inner class name */
    public static final class C0173a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        return "MmAudioFileMetaInfo(audioSegmentFilePath=" + this.a + ", segIndex=" + this.b + ')';
    }

    public a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "audioSegmentFilePath");
        this.a = r2;
        this.b = r3;
    }
}
