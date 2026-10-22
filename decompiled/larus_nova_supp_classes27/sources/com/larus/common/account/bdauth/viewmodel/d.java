package com.larus.common.account.bdauth.viewmodel;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public final BDAuthorizePageMode a;
    public final boolean b;
    public final za7.c c;
    public final List<c> d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

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
        if (this.a == r6.a) goto L12;
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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        za7.c r4 = this.c;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r3 + r6) * 31) + this.d.hashCode()) * 31;
        String r8 = this.e;
        if (r8 == null) goto L14;
        r5 = r8.hashCode();
    L14:
        int r9 = (r7 + r5) * 31;
        if (this.f == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        if (this.g == false) goto L21;
        int r12 = 1231;
    L22:
        int r13 = (r11 + r12) * 31;
        if (this.h == true) goto L27;
        r2 = 1237;
    L27:
        return r13 + r2;
    L21:
        r12 = 1237;
        goto L22
    L17:
        r10 = 1237;
        goto L18
    L9:
        r6 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "BDAuthorizeUiState(pageMode=" + this.a + ", isSubmitting=" + this.b + ", authInfoResponse=" + this.c + ", accountItems=" + this.d + ", selectedAccountSecUserId=" + this.e + ", hasLoginAccount=" + this.f + ", showAddAccount=" + this.g + ", multiAccountEnabled=" + this.h + ')';
    }

    public /* synthetic */ d(int r10) {
        this(BDAuthorizePageMode.Loading, false, null, CollectionsKt.emptyList(), null, false, false, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(BDAuthorizePageMode r2, boolean r3, za7.c r4, List<? extends c> r5, String r6, boolean r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "pageMode");
        Intrinsics.checkNotNullParameter(r5, "accountItems");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public static d a(d r9, BDAuthorizePageMode r10, boolean r11, List r12, String r13, boolean r14, boolean r15, boolean r16, int r17) {
        if ((r17 & 1) == 0) goto L5;
        BDAuthorizePageMode r2 = r9.a;
    L7:
        if ((r17 & 2) == 0) goto L9;
        boolean r3 = r9.b;
    L11:
        if ((r17 & 4) == 0) goto L13;
        za7.c r4 = r9.c;
    L15:
        if ((r17 & 8) == 0) goto L17;
        List r5 = r9.d;
    L19:
        if ((r17 & 16) == 0) goto L21;
        String r6 = r9.e;
    L23:
        if ((r17 & 32) == 0) goto L25;
        boolean r7 = r9.f;
    L27:
        if ((r17 & 64) == 0) goto L29;
        boolean r8 = r9.g;
    L31:
        if ((r17 & 128) == 0) goto L33;
        boolean r1 = r9.h;
    L34:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r2, "pageMode");
        Intrinsics.checkNotNullParameter(r5, "accountItems");
        return new d(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r16;
        goto L34
    L29:
        r8 = r15;
        goto L31
    L25:
        r7 = r14;
        goto L27
    L21:
        r6 = r13;
        goto L23
    L17:
        r5 = r12;
        goto L19
    L13:
        r4 = null;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }
}
