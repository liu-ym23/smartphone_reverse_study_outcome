package com.obric.assistant.cocreationreview.modules.memory;

import hda.q0;
import hda.y;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static final /* synthetic */ int j = 0;
    public final MemoryDataReviewModuleKey a;
    public final long b;
    public final long c;
    public final List<q0> d;
    public final List<q0> e;
    public final Map<String, y> f;
    public final String g;
    public final boolean h;
    public final String i;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (((((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        String r5 = this.g;
        int r6 = 0;
        if (r5 != null) goto L5;
        int r7 = 0;
    L6:
        int r8 = (r4 + r7) * 31;
        if (this.h == false) goto L9;
        int r9 = 1231;
    L10:
        int r10 = (r8 + r9) * 31;
        String r11 = this.i;
        if (r11 == null) goto L15;
        r6 = r11.hashCode();
    L15:
        return r10 + r6;
    L9:
        r9 = 1237;
        goto L10
    L5:
        r7 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryReviewPageDto(module=" + this.a + ", observeFromTimeMillis=" + this.b + ", windowEndTimeMillis=" + this.c + ", pendingRecords=" + this.d + ", completedRecords=" + this.e + ", feedbackByRecordId=" + this.f + ", nextPageCursor=" + this.g + ", hasMore=" + this.h + ", error=" + this.i + ')';
    }

    public c(MemoryDataReviewModuleKey r2, long r3, long r5, List<q0> r7, List<q0> r8, Map<String, y> r9, String r10, boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r2, "module");
        Intrinsics.checkNotNullParameter(r7, "pendingRecords");
        Intrinsics.checkNotNullParameter(r8, "completedRecords");
        Intrinsics.checkNotNullParameter(r9, "feedbackByRecordId");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
    }
}
