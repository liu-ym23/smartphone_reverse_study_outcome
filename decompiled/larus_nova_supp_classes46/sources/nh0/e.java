package nh0;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public final int a;
    public final int b;
    public final List<Integer> c;
    public final int d;
    public final int e;
    public final List<Integer> f;
    public final List<Integer> g;
    public final List<Long> h;

    public e() {
        this(0, 0, null, 0, 0, null, null, null, 255);
    }

    public final String toString() {
        return "LinkmicDynamicLinkmicChangeEvent(scene=" + this.a + ", uiLayout=" + this.b + ", playmode=" + this.c + ", fromScene=" + this.d + ", fromUILayout=" + this.e + ", fromPlayMode=" + this.f + ')';
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof e) == true) goto L5;
        return false;
    L5:
        e r5 = (e) r4;
        if (r5.a == this.a) goto L8;
    L13:
        return false;
    L8:
        if (Intrinsics.areEqual(r5.c, this.c) == false) goto L13;
        if (r5.b != this.b) goto L13;
        return true;
    }

    public e(int r2, int r3, List<Integer> r4, int r5, int r6, List<Integer> r7, List<Integer> r8, List<Long> r9) {
        Intrinsics.checkNotNullParameter(r4, "playmode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public /* synthetic */ e(int r9, int r10, List r11, int r12, int r13, List r14, List r15, List r16, int r17) {
        int r2 = 0;
        if ((r17 & 1) == 0) goto L5;
        int r1 = 0;
    L7:
        if ((r17 & 2) != 0) goto L11;
        r2 = r10;
    L11:
        if ((r17 & 4) == 0) goto L13;
        List r3 = CollectionsKt.emptyList();
    L14:
        int r5 = -1;
        if ((r17 & 8) == 0) goto L17;
        int r4 = -1;
    L19:
        if ((r17 & 16) != 0) goto L23;
        r5 = r13;
    L23:
        if ((r17 & 32) == 0) goto L25;
        List r6 = CollectionsKt.emptyList();
    L27:
        if ((r17 & 64) == 0) goto L29;
        List r7 = CollectionsKt.emptyList();
    L31:
        if ((r17 & 128) == 0) goto L33;
        List r0 = CollectionsKt.emptyList();
    L34:
        this(r1, r2, r3, r4, r5, r6, r7, r0);
        return;
    L33:
        r0 = r16;
        goto L34
    L29:
        r7 = r15;
        goto L31
    L25:
        r6 = r14;
        goto L27
    L17:
        r4 = r12;
        goto L19
    L13:
        r3 = r11;
        goto L14
    L5:
        r1 = r9;
        goto L7
    }
}
