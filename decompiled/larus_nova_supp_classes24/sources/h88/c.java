package h88;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public final boolean a;
    public final String b;
    public final Boolean c;
    public final String d;
    public final Integer e;
    public final boolean f;
    public final boolean g;

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
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        String r3 = this.b;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        Boolean r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.e;
        if (r13 == null) goto L22;
        r4 = r13.hashCode();
    L22:
        int r14 = (r12 + r4) * 31;
        if (this.f == false) goto L25;
        int r15 = 1231;
    L26:
        int r16 = (r14 + r15) * 31;
        if (this.g == true) goto L31;
        r1 = 1237;
    L31:
        return r16 + r1;
    L25:
        r15 = 1237;
        goto L26
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "CallSceneDisplayModel(sceneLoading=" + this.a + ", sceneIconShowOutSide=" + this.b + ", sceneUseOriginalIcon=" + this.c + ", sceneModelName=" + this.d + ", clickTraceId=" + this.e + ", disableExit=" + this.f + ", disableChange=" + this.g + ')';
    }

    public c(boolean r1, String r2, Boolean r3, String r4, Integer r5, boolean r6, boolean r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
