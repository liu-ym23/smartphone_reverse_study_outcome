package com.ss.ugc.android.cachalot.common.async.controller;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final Function0<Boolean> e;
    public final Function0<Unit> f;
    public final Function1<RecyclerView.ViewHolder, Unit> g;
    public final ExecutorService h;
    public final Long i;
    public final boolean j;

    public a() {
        this(false, null, null, null, null, 1023);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
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
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.c == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.d == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (((((((r6 + r7) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        ExecutorService r9 = this.h;
        int r10 = 0;
        if (r9 != null) goto L21;
        int r11 = 0;
    L22:
        int r12 = (r8 + r11) * 31;
        Long r13 = this.i;
        if (r13 == null) goto L26;
        r10 = r13.hashCode();
    L26:
        int r14 = (r12 + r10) * 31;
        if (this.j == true) goto L31;
        r1 = 1237;
    L31:
        return r14 + r1;
    L21:
        r11 = r9.hashCode();
        goto L22
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "IndividualBindConfig(forceBindOnMainThread=" + this.a + ", notAllowDoPreloadOnMainThread=" + this.b + ", bindNow=" + this.c + ", forcePreBind=" + this.d + ", canContinue=" + this.e + ", onComplete=" + this.f + ", onViewHolderCreated=" + this.g + ", executor=" + this.h + ", timeout=" + this.i + ", isOffScreenPreBind=" + this.j + ')';
    }

    public a(boolean r5, Function0 r6, Function0 r7, ExecutorService r8, Long r9, int r10) {
        if ((r10 & 2) == 0) goto L6;
        r5 = false;
    L6:
        if ((r10 & 16) == 0) goto L9;
        r6 = IndividualBindConfig$1.INSTANCE;
    L9:
        if ((r10 & 32) == 0) goto L12;
        r7 = IndividualBindConfig$2.INSTANCE;
    L12:
        if ((r10 & 64) == 0) goto L14;
        IndividualBindConfig$3 r0 = IndividualBindConfig$3.INSTANCE;
    L16:
        if ((r10 & 128) == 0) goto L19;
        r8 = null;
    L19:
        if ((r10 & 256) == 0) goto L21;
        r9 = null;
    L21:
        Intrinsics.checkNotNullParameter(r6, "canContinue");
        Intrinsics.checkNotNullParameter(r7, "onComplete");
        Intrinsics.checkNotNullParameter(r0, "onViewHolderCreated");
        this.a = false;
        this.b = r5;
        this.c = false;
        this.d = false;
        this.e = r6;
        this.f = r7;
        this.g = r0;
        this.h = r8;
        this.i = r9;
        this.j = false;
        return;
    L14:
        r0 = null;
        goto L16
    }
}
