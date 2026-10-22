package zb8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public static final b f = null;
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public static final class a {
    }

    public b() {
        this(31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
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
        if (this.e == r6.e) goto L23;
        return false;
    L23:
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
        int r8 = (r6 + r7) * 31;
        if (this.e == true) goto L23;
        r1 = 1237;
    L23:
        return r8 + r1;
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
        return "ChatCameraUiAbilityConfig(enableCaptureTitle=" + this.a + ", enableCaptureTips=" + this.b + ", enableResultSuggestedAction=" + this.c + ", enableResultMarkedTips=" + this.d + ", enableResultVlmEduIntent=" + this.e + ')';
    }

    static {
        f = new b(false, false, false, true, true);
    }

    public /* synthetic */ b(int r10) {
        if ((r10 & 1) == 0) goto L5;
        boolean r4 = true;
    L7:
        if ((r10 & 2) == 0) goto L9;
        boolean r5 = true;
    L11:
        if ((r10 & 4) == 0) goto L13;
        boolean r6 = true;
    L15:
        if ((r10 & 8) == 0) goto L17;
        boolean r7 = true;
    L19:
        if ((r10 & 16) == 0) goto L21;
        boolean r8 = true;
    L22:
        this(r4, r5, r6, r7, r8);
        return;
    L21:
        r8 = false;
        goto L22
    L17:
        r7 = false;
        goto L19
    L13:
        r6 = false;
        goto L15
    L9:
        r5 = false;
        goto L11
    L5:
        r4 = false;
        goto L7
    }

    public b(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
