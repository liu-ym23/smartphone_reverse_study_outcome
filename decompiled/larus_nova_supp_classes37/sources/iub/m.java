package iub;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m {
    public final String a;
    public final n b;
    public final n c;
    public final List<n> d;
    public final List<n> e;
    public final boolean f;

    public m() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        if (this.f == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmRecordingLanguageData(recordingId=" + this.a + ", currSpokenLanguage=" + this.b + ", currTranslateLanguage=" + this.c + ", spokenLanguageList=" + this.d + ", translateLanguageList=" + this.e + ", isBilingual=" + this.f + ')';
    }

    public /* synthetic */ m(int r8) {
        this("", new n(0), new n(0), CollectionsKt.emptyList(), CollectionsKt.emptyList(), false);
    }

    public m(String r2, n r3, n r4, List<n> r5, List<n> r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "recordingId");
        Intrinsics.checkNotNullParameter(r3, "currSpokenLanguage");
        Intrinsics.checkNotNullParameter(r4, "currTranslateLanguage");
        Intrinsics.checkNotNullParameter(r5, "spokenLanguageList");
        Intrinsics.checkNotNullParameter(r6, "translateLanguageList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
