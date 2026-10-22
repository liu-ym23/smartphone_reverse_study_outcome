package com.larus.agents.impl.experience;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class t {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final WorkExperienceSource e;
    public final long f;
    public final List<String> g;
    public final boolean h;
    public final long i;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof t) == true) goto L8;
        return false;
    L8:
        t r9 = (t) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        long r1 = this.f;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.g.hashCode()) * 31;
        if (this.h == false) goto L5;
        int r3 = 1231;
    L6:
        int r4 = (r2 + r3) * 31;
        long r5 = this.i;
        return r4 + ((int) (r5 ^ (r5 >>> 32)));
    L5:
        r3 = 1237;
        goto L6
    }

    public final String toString() {
        return "WorkExperienceSummary(id=" + this.a + ", name=" + this.b + ", description=" + this.c + ", type=" + this.d + ", source=" + this.e + ", createdAt=" + this.f + ", tags=" + this.g + ", autoOptimize=" + this.h + ", updatedAt=" + this.i + ')';
    }

    public final String getType() {
        return this.d;
    }

    public t(String r2, String r3, String r4, String r5, WorkExperienceSource r6, long r7, List<String> r9, boolean r10, long r11) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "description");
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r6, "source");
        Intrinsics.checkNotNullParameter(r9, "tags");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r9;
        this.h = r10;
        this.i = r11;
    }
}
