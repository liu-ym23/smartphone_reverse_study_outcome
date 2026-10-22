package nl8;

import com.larus.bmhome.share.panel.ShareType;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final String e;
    public final String f;
    public final Function0<Boolean> g;
    public final boolean h;
    public final Boolean i;

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((((r0 + r1) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        Function0<Boolean> r4 = this.g;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r3 + r6) * 31;
        if (this.h == true) goto L14;
        r2 = 1237;
    L14:
        int r8 = (r7 + r2) * 31;
        Boolean r9 = this.i;
        if (r9 == null) goto L19;
        r5 = r9.hashCode();
    L19:
        return r8 + r5;
    L9:
        r6 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "GuiToolVMData(dataIdentifier=" + this.a + ", title=" + this.b + ", url=" + this.c + ", canFold=" + this.d + ", leftDarkIcon=" + this.e + ", leftLightIcon=" + this.f + ", interceptClickCard=" + this.g + ", disableFoldExpandClick=" + this.h + ", initialFoldState=" + this.i + ')';
    }

    public a(String r2, String r3, String r4, boolean r5, String r6, String r7, ml8.c r8, boolean r9, Boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "dataIdentifier");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, ShareType.URL);
        Intrinsics.checkNotNullParameter(r6, "leftDarkIcon");
        Intrinsics.checkNotNullParameter(r7, "leftLightIcon");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
