package com.larus.bmhome.chat.manager;

import com.larus.bmhome.chat.api.ConversationFeedActionType;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u0 {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final List<Integer> d;
    public final Function0<List<Pair<String, String>>> e;
    public final Function0<Unit> f;
    public final Function0<Unit> g;
    public final Set<ConversationFeedActionType> h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final String m;

    public u0() {
        this(0, false, null, null, null, null, false, false, false, null, 8191);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u0) == true) goto L8;
        return false;
    L8:
        u0 r6 = (u0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (((r3 + r4) * 31) + this.d.hashCode()) * 31;
        Function0<List<Pair<String, String>>> r6 = this.e;
        int r7 = 0;
        if (r6 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r5 + r8) * 31;
        Function0<Unit> r10 = this.f;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Function0<Unit> r13 = this.g;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Set<ConversationFeedActionType> r16 = this.h;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        if (this.i == false) goto L29;
        int r19 = 1231;
    L30:
        int r20 = (r18 + r19) * 31;
        if (this.j == false) goto L33;
        int r21 = 1231;
    L34:
        int r22 = (r20 + r21) * 31;
        if (this.k == false) goto L37;
        int r23 = 1231;
    L38:
        int r24 = (r22 + r23) * 31;
        if (this.l == true) goto L42;
        r2 = 1237;
    L42:
        int r25 = (r24 + r2) * 31;
        String r26 = this.m;
        if (r26 == null) goto L47;
        r7 = r26.hashCode();
    L47:
        return r25 + r7;
    L37:
        r23 = 1237;
        goto L38
    L33:
        r21 = 1237;
        goto L34
    L29:
        r19 = 1237;
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r6.hashCode();
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ScreenMenuViewConfig(marginStart=" + this.a + ", isBgBlur=" + this.b + ", alignToAnchorStart=" + this.c + ", snapshotExcludedViewIds=" + this.d + ", projectOptionsProvider=" + this.e + ", onCreateProjectRequested=" + this.f + ", onArchiveRequested=" + this.g + ", allowedActions=" + this.h + ", allowWorkspacePathCopy=" + this.i + ", pinAndRenameOnly=" + this.j + ", enablePinAction=" + this.k + ", usePinTimeForPinState=" + this.l + ", renameDefaultInput=" + this.m + ')';
    }

    public u0(int r16, boolean r17, List r18, com.larus.home.impl.main.side_bar.view.adapter.h0 r19, com.larus.home.impl.main.side_bar.view.adapter.i0 r20, com.larus.home.impl.main.side_bar.view.adapter.j0 r21, boolean r22, boolean r23, boolean r24, String r25, int r26) {
        if ((r26 & 1) == 0) goto L5;
        int r2 = 0;
    L7:
        if ((r26 & 2) == 0) goto L9;
        boolean r4 = false;
    L11:
        if ((r26 & 8) == 0) goto L13;
        List r5 = CollectionsKt.emptyList();
    L15:
        if ((r26 & 16) == 0) goto L17;
        com.larus.home.impl.main.side_bar.view.adapter.h0 r6 = null;
    L19:
        if ((r26 & 32) == 0) goto L21;
        com.larus.home.impl.main.side_bar.view.adapter.i0 r8 = null;
    L23:
        if ((r26 & 64) == 0) goto L25;
        com.larus.home.impl.main.side_bar.view.adapter.j0 r9 = null;
    L26:
        boolean r11 = true;
        if ((r26 & 256) == 0) goto L29;
        boolean r10 = true;
    L31:
        if ((r26 & 512) == 0) goto L33;
        boolean r12 = false;
    L35:
        if ((r26 & 1024) != 0) goto L39;
        r11 = r23;
    L39:
        if ((r26 & 2048) == 0) goto L41;
        boolean r13 = false;
    L43:
        if ((r26 & 4096) == 0) goto L45;
        String r1 = null;
    L46:
        Intrinsics.checkNotNullParameter(r5, "snapshotExcludedViewIds");
        this.a = r2;
        this.b = r4;
        this.c = false;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r9;
        this.h = null;
        this.i = r10;
        this.j = r12;
        this.k = r11;
        this.l = r13;
        this.m = r1;
        return;
    L45:
        r1 = r25;
        goto L46
    L41:
        r13 = r24;
        goto L43
    L33:
        r12 = r22;
        goto L35
    L29:
        r10 = false;
        goto L31
    L25:
        r9 = r21;
        goto L26
    L21:
        r8 = r20;
        goto L23
    L17:
        r6 = r19;
        goto L19
    L13:
        r5 = r18;
        goto L15
    L9:
        r4 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }
}
