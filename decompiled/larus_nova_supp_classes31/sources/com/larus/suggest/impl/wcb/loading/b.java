package com.larus.suggest.impl.wcb.loading;

import com.larus.suggest.impl.wcb.render.n;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final long a;
    public final long b;
    public final String c;
    public final String d;
    public final int e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final int l;
    public volatile n.b m;
    public volatile boolean n;
    public final CompletableDeferred<Unit> o;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
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
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (((((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31;
        String r4 = this.f;
        int r5 = 0;
        if (r4 != null) goto L5;
        int r6 = 0;
    L6:
        int r7 = (((((r2 + r6) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        String r8 = this.i;
        if (r8 != null) goto L9;
        int r9 = 0;
    L10:
        int r10 = (r7 + r9) * 31;
        String r11 = this.j;
        if (r11 == null) goto L15;
        r5 = r11.hashCode();
    L15:
        return ((((r10 + r5) * 31) + this.k.hashCode()) * 31) + this.l;
    L9:
        r9 = r8.hashCode();
        goto L10
    L5:
        r6 = r4.hashCode();
        goto L6
    }

    public final String toString() {
        return "WcbLoadingSession(chatKey=" + this.a + ", executionId=" + this.b + ", conversationId=" + this.c + ", botId=" + this.d + ", expectedScene=" + this.e + ", previousTargetLocalMessageId=" + this.f + ", targetLocalMessageId=" + this.g + ", displayLocalMessageId=" + this.h + ", startMessageBoundaryId=" + this.i + ", sectionId=" + this.j + ", title=" + this.k + ", titleStyle=" + this.l + ')';
    }

    public b(long r2, long r4, String r6, String r7, int r8, String r9, String r10, String r11, String r12, String r13, String r14, int r15) {
        Intrinsics.checkNotNullParameter(r6, "conversationId");
        Intrinsics.checkNotNullParameter(r7, "botId");
        Intrinsics.checkNotNullParameter(r10, "targetLocalMessageId");
        Intrinsics.checkNotNullParameter(r11, "displayLocalMessageId");
        Intrinsics.checkNotNullParameter(r14, "title");
        this.a = r2;
        this.b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.n = true;
        this.o = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }
}
