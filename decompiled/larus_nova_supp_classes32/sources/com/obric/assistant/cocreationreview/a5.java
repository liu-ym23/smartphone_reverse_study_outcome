package com.obric.assistant.cocreationreview;

import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a5 {
    public final String a;
    public final Vote b;
    public final Set<String> c;
    public final String d;
    public final boolean e;
    public final long f;
    public final List<b5> g;
    public final Integer h;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a5) == true) goto L8;
        return false;
    L8:
        a5 r9 = (a5) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
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
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Vote r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L9;
        int r5 = 1231;
    L10:
        long r6 = this.f;
        int r7 = (((((r4 + r5) * 31) + ((int) (r6 ^ (r6 >>> 32)))) * 31) + this.g.hashCode()) * 31;
        Integer r8 = this.h;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "Feedback(recordId=" + this.a + ", vote=" + this.b + ", reasons=" + this.c + ", comment=" + this.d + ", completed=" + this.e + ", createdAt=" + this.f + ", media=" + this.g + ", feedbackValue=" + this.h + ')';
    }

    public final boolean b() {
        if (this.b != null) goto L5;
    L7:
        return false;
    L5:
        if ((!this.c.isEmpty()) == false) goto L7;
        return true;
    }

    public /* synthetic */ a5(String r14, Vote r15, Set r16, String r17, boolean r18, long r19, Integer r21, int r22) {
        if ((r22 & 2) == 0) goto L5;
        Vote r5 = null;
    L7:
        if ((r22 & 4) == 0) goto L9;
        Set r6 = SetsKt.emptySet();
    L11:
        if ((r22 & 8) == 0) goto L13;
        String r7 = NameKeys.UnloadStrategy_No_Strategy;
    L15:
        if ((r22 & 16) == 0) goto L17;
        boolean r8 = false;
    L19:
        if ((r22 & 32) == 0) goto L21;
        long r9 = 0;
    L23:
        if ((r22 & 64) == 0) goto L25;
        List r11 = CollectionsKt.emptyList();
    L27:
        if ((r22 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L29;
        Integer r12 = null;
    L30:
        this(r14, r5, r6, r7, r8, r9, r11, r12);
        return;
    L29:
        r12 = r21;
        goto L30
    L25:
        r11 = null;
        goto L27
    L21:
        r9 = r19;
        goto L23
    L17:
        r8 = r18;
        goto L19
    L13:
        r7 = r17;
        goto L15
    L9:
        r6 = r16;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }

    public static a5 a(a5 r14, Vote r15, Set r16, String r17, boolean r18, long r19, Integer r21, int r22) {
        List<b5> r3 = null;
        if ((r22 & 1) == 0) goto L5;
        String r5 = r14.a;
    L7:
        if ((r22 & 2) == 0) goto L9;
        Vote r6 = r14.b;
    L11:
        if ((r22 & 4) == 0) goto L13;
        Set r7 = r14.c;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r8 = r14.d;
    L19:
        if ((r22 & 16) == 0) goto L21;
        boolean r9 = r14.e;
    L23:
        if ((r22 & 32) == 0) goto L25;
        long r10 = r14.f;
    L27:
        if ((r22 & 64) == 0) goto L29;
        r3 = r14.g;
    L29:
        List<b5> r12 = r3;
        if ((r22 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L32;
        Integer r13 = r14.h;
    L33:
        r14.getClass();
        Intrinsics.checkNotNullParameter(r5, "recordId");
        Intrinsics.checkNotNullParameter(r7, "reasons");
        Intrinsics.checkNotNullParameter(r8, "comment");
        Intrinsics.checkNotNullParameter(r12, "media");
        return new a5(r5, r6, r7, r8, r9, r10, r12, r13);
    L32:
        r13 = r21;
        goto L33
    L25:
        r10 = r19;
        goto L27
    L21:
        r9 = r18;
        goto L23
    L17:
        r8 = r17;
        goto L19
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public a5(String r2, Vote r3, Set<String> r4, String r5, boolean r6, long r7, List<b5> r9, Integer r10) {
        Intrinsics.checkNotNullParameter(r2, "recordId");
        Intrinsics.checkNotNullParameter(r4, "reasons");
        Intrinsics.checkNotNullParameter(r5, "comment");
        Intrinsics.checkNotNullParameter(r9, "media");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r9;
        this.h = r10;
    }
}
