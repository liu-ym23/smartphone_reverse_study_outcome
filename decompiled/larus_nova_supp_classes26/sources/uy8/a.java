package uy8;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final Set<String> a;
    public final boolean b;
    public final boolean c;

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
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "MobileAlbumFastInputExperimentConfig(enabledEntries=" + this.a + ", quickInputAttachmentAddEnabled=" + this.b + ", quickInputDataProtocolEnabled=" + this.c + ')';
    }

    public a() {
        this(SetsKt.emptySet(), false, false);
    }

    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "entry");
        if (this.c == true) goto L5;
    L9:
        return false;
    L5:
        if (c.a.contains(r2) == false) goto L9;
        if (this.a.contains(r2) == false) goto L9;
        return true;
    }

    public a(Set<String> r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "enabledEntries");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
