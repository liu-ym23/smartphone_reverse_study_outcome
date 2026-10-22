package slb;

import com.ss.android.lark.inline.ai.api.Templates;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j {
    public final String a;
    public final String b;
    public final int c;
    public final String d;
    public final Templates e;
    public final Map<String, Object> f;
    public ArrayList<j> g;
    public final transient k h;
    public final String i;

    public j() {
        this(null, null, 0, null, null, null, null, null, null, 511);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
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
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d.hashCode()) * 31;
        Templates r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.f.hashCode()) * 31;
        ArrayList<j> r5 = this.g;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        k r8 = this.h;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((r7 + r2) * 31) + this.i.hashCode();
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "Prompt(id='" + this.a + "', type='" + this.b + "', icon=" + this.c + ", text='" + this.d + "', templates=" + this.e + ", extraMap=" + this.f + ", children=" + this.g + ", callback=" + this.h + ", localId = " + this.i + ')';
    }

    public final String getType() {
        return this.b;
    }

    public j(String r5, String r6, int r7, String r8, Templates r9, Map r10, ArrayList r11, k r12, String r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r5 = "";
    L6:
        if ((r14 & 2) == 0) goto L8;
        r6 = "";
    L8:
        boolean r2 = false;
        if ((r14 & 4) == 0) goto L12;
        r7 = 0;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r8 = "";
    L15:
        if ((r14 & 16) == 0) goto L18;
        r9 = null;
    L18:
        if ((r14 & 32) == 0) goto L21;
        r10 = new LinkedHashMap();
    L21:
        if ((r14 & 64) == 0) goto L24;
        r11 = null;
    L24:
        if ((r14 & 128) == 0) goto L27;
        r12 = null;
    L27:
        if ((r14 & 256) == 0) goto L29;
        r13 = "";
    L29:
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r6, "type");
        Intrinsics.checkNotNullParameter(r8, "text");
        Intrinsics.checkNotNullParameter(r10, "extraMap");
        Intrinsics.checkNotNullParameter(r13, "localId");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        if (r13.length() != 0) goto L32;
        boolean r15 = true;
    L33:
        if (r15 == true) goto L35;
        return;
    L35:
        if (r5.length() <= 0) goto L37;
        r2 = true;
    L37:
        if (r2 == false) goto L41;
        this.i = r5;
        return;
    L41:
        return;
    L32:
        r15 = false;
        goto L33
    }
}
