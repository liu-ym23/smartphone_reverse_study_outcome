package kda;

import com.obric.assistant.cocreationreview.ModuleKey;
import hda.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g extends com.obric.assistant.cocreationreview.a {
    public final String a;
    public final ModuleKey b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final e1 h;
    public final String i;
    public final String j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        String r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((((r0 + r3) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        String r5 = this.j;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ScreenMemoryUsageRecord(id=" + this.a + ", module=" + this.b + ", capturedAt=" + this.c + ", memoryDomain=" + this.d + ", screenScene=" + this.e + ", memoryTitle=" + this.f + ", memorySummary=" + this.g + ", uiModel=" + this.h + ", payload=" + this.i + ", traceJson=" + this.j + ')';
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final String a() {
        return this.a;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final ModuleKey b() {
        return this.b;
    }

    public g(String r3, ModuleKey r4, String r5, String r6, String r7, String r8, e1 r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter(r4, "module");
        Intrinsics.checkNotNullParameter(r5, "capturedAt");
        Intrinsics.checkNotNullParameter("屏幕内容", "memoryDomain");
        Intrinsics.checkNotNullParameter(r7, "memoryTitle");
        Intrinsics.checkNotNullParameter(r8, "memorySummary");
        Intrinsics.checkNotNullParameter(r9, "uiModel");
        Intrinsics.checkNotNullParameter(r10, "payload");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = "屏幕内容";
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }
}
