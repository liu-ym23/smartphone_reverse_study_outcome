package be8;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public final boolean a;
    public final List<b> b;
    public final boolean c;
    public final List<String> d;
    public final f e;
    public final d f;
    public final e g;
    public final boolean h;
    public final List<String> i;
    public final List<String> j;

    public c() {
        this(false, null, false, null, null, 1023);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
        if (this.h == r6.h) goto L33;
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
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (((r2 + r3) * 31) + this.d.hashCode()) * 31;
        f r5 = this.e;
        int r6 = 0;
        if (r5 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r4 + r7) * 31;
        d r9 = this.f;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        e r12 = this.g;
        if (r12 == null) goto L22;
        r6 = r12.hashCode();
    L22:
        int r13 = (r11 + r6) * 31;
        if (this.h == true) goto L27;
        r1 = 1237;
    L27:
        return ((((r13 + r1) * 31) + this.i.hashCode()) * 31) + this.j.hashCode();
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r5.hashCode();
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "SkillActionBarState(enabled=" + this.a + ", chips=" + this.b + ", showSkillItem=" + this.c + ", selectedSkillIds=" + this.d + ", selectedProject=" + this.e + ", selectedDevice=" + this.f + ", selectedFolder=" + this.g + ", isCloudRuntimeSelected=" + this.h + ", externallyInjectedSkillIds=" + this.i + ", remoteExposedSkillIds=" + this.j + ')';
    }

    public /* synthetic */ c(boolean r15, List r16, boolean r17, List r18, List r19, int r20) {
        if ((r20 & 1) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r20 & 2) == 0) goto L9;
        List r5 = CollectionsKt.emptyList();
    L11:
        if ((r20 & 4) == 0) goto L13;
        boolean r6 = false;
    L15:
        if ((r20 & 8) == 0) goto L17;
        List r7 = CollectionsKt.emptyList();
    L19:
        if ((r20 & 256) == 0) goto L21;
        List r12 = CollectionsKt.emptyList();
    L23:
        if ((r20 & 512) == 0) goto L25;
        List r0 = CollectionsKt.emptyList();
    L26:
        this(r4, r5, r6, r7, null, null, null, false, r12, r0);
        return;
    L25:
        r0 = null;
        goto L26
    L21:
        r12 = r19;
        goto L23
    L17:
        r7 = r18;
        goto L19
    L13:
        r6 = r17;
        goto L15
    L9:
        r5 = r16;
        goto L11
    L5:
        r4 = r15;
        goto L7
    }

    public static c a(c r14, boolean r15, List r16, boolean r17, List r18, List r19, List r20, int r21) {
        if ((r21 & 1) == 0) goto L5;
        boolean r4 = r14.a;
    L7:
        if ((r21 & 2) == 0) goto L9;
        List r5 = r14.b;
    L11:
        if ((r21 & 4) == 0) goto L13;
        boolean r6 = r14.c;
    L15:
        if ((r21 & 8) == 0) goto L17;
        List r7 = r14.d;
    L19:
        if ((r21 & 16) == 0) goto L21;
        f r8 = r14.e;
    L23:
        if ((r21 & 32) == 0) goto L25;
        d r9 = r14.f;
    L27:
        if ((r21 & 64) == 0) goto L29;
        e r10 = r14.g;
    L31:
        if ((r21 & 128) == 0) goto L33;
        boolean r11 = r14.h;
    L35:
        if ((r21 & 256) == 0) goto L37;
        List r12 = r14.i;
    L39:
        if ((r21 & 512) == 0) goto L41;
        List r13 = r14.j;
    L42:
        Intrinsics.checkNotNullParameter(r5, "chips");
        Intrinsics.checkNotNullParameter(r7, "selectedSkillIds");
        Intrinsics.checkNotNullParameter(r12, "externallyInjectedSkillIds");
        Intrinsics.checkNotNullParameter(r13, "remoteExposedSkillIds");
        return new c(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L41:
        r13 = r20;
        goto L42
    L37:
        r12 = r19;
        goto L39
    L33:
        r11 = false;
        goto L35
    L29:
        r10 = null;
        goto L31
    L25:
        r9 = null;
        goto L27
    L21:
        r8 = null;
        goto L23
    L17:
        r7 = r18;
        goto L19
    L13:
        r6 = r17;
        goto L15
    L9:
        r5 = r16;
        goto L11
    L5:
        r4 = r15;
        goto L7
    }

    public c(boolean r2, List<b> r3, boolean r4, List<String> r5, f r6, d r7, e r8, boolean r9, List<String> r10, List<String> r11) {
        Intrinsics.checkNotNullParameter(r3, "chips");
        Intrinsics.checkNotNullParameter(r5, "selectedSkillIds");
        Intrinsics.checkNotNullParameter(r10, "externallyInjectedSkillIds");
        Intrinsics.checkNotNullParameter(r11, "remoteExposedSkillIds");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }
}
