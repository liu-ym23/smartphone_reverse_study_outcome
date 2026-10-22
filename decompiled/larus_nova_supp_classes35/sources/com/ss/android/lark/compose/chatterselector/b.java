package com.ss.android.lark.compose.chatterselector;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public final String a;
    public final List<a> b;
    public final Set<String> c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final String g;

    public b() {
        this(null, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
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
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.e == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.f == true) goto L14;
        r2 = 1237;
    L14:
        int r6 = (r5 + r2) * 31;
        String r7 = this.g;
        if (r7 != null) goto L17;
        int r8 = 0;
    L19:
        return r6 + r8;
    L17:
        r8 = r7.hashCode();
        goto L19
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatterSelectorUiState(query=" + this.a + ", members=" + this.b + ", selectedIds=" + this.c + ", loading=" + this.d + ", loadingMore=" + this.e + ", hasMore=" + this.f + ", cursor=" + this.g + ')';
    }

    public /* synthetic */ b(Set r11, int r12) {
        List r1 = null;
        if ((r12 & 1) == 0) goto L5;
        String r3 = BuildConfig.FLAVOR;
    L7:
        if ((r12 & 2) == 0) goto L9;
        r1 = CollectionsKt.emptyList();
    L9:
        List r4 = r1;
        if ((r12 & 4) == 0) goto L12;
        r11 = SetsKt.emptySet();
    L12:
        this(r3, r4, r11, false, false, false, null);
        return;
    L5:
        r3 = null;
        goto L7
    }

    public static b a(b r8, String r9, List r10, Set r11, boolean r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        r9 = r8.a;
    L5:
        String r1 = r9;
        if ((r13 & 2) == 0) goto L8;
        r10 = r8.b;
    L8:
        List r2 = r10;
        if ((r13 & 4) == 0) goto L11;
        r11 = r8.c;
    L11:
        Set r3 = r11;
        if ((r13 & 8) == 0) goto L14;
        r12 = r8.d;
    L14:
        boolean r4 = r12;
        if ((r13 & 16) == 0) goto L17;
        boolean r5 = r8.e;
    L19:
        if ((r13 & 32) == 0) goto L21;
        boolean r6 = r8.f;
    L23:
        if ((r13 & 64) == 0) goto L25;
        String r14 = r8.g;
    L26:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r1, "query");
        Intrinsics.checkNotNullParameter(r2, "members");
        Intrinsics.checkNotNullParameter(r3, "selectedIds");
        return new b(r1, r2, r3, r4, r5, r6, r14);
    L25:
        r14 = null;
        goto L26
    L21:
        r6 = false;
        goto L23
    L17:
        r5 = false;
        goto L19
    }

    public b(String r2, List<a> r3, Set<String> r4, boolean r5, boolean r6, boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "query");
        Intrinsics.checkNotNullParameter(r3, "members");
        Intrinsics.checkNotNullParameter(r4, "selectedIds");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
