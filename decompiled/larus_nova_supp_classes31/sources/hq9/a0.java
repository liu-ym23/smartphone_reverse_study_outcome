package hq9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a0 {
    public final boolean a;
    public final boolean b;
    public final boolean c;

    public a0() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r6 = (a0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
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
        if (this.c == true) goto L15;
        r1 = 1237;
    L15:
        return r4 + r1;
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "BasicExperienceFeatureConfig(enableEnterpriseColdStartNewTask=" + this.a + ", mainConversationDowngradeExperimentEnabled=" + this.b + ", enableNewWorkTaskButtonThemeColorInversion=" + this.c + ')';
    }

    public /* synthetic */ a0(int r2) {
        this(true, false, false);
    }

    public a0(boolean r1, boolean r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
