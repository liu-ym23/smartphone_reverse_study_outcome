package com.ss.android.lark.forwardv3.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int g = 0;
    public final boolean a;
    public final boolean b;
    public final String c;
    public final int d;
    public final boolean e;
    public final int f;

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.data.a$a, reason: collision with other inner class name */
    public static final class C0072a {
        public static String a(a r4) {
            Intrinsics.checkNotNullParameter(r4, "titleBarShowInfo");
            StringBuilder r0 = new StringBuilder("title bar show info is:\n");
            r0.append("   right view show: " + r4.a + '\n');
            r0.append("   right view enable: " + r4.b + '\n');
            r0.append("   right view text: " + r4.c + '\n');
            StringBuilder r1 = new StringBuilder("   left view show: ");
            if (r4.e == false) goto L5;
            String r3 = "Cancel";
        L6:
            r1.append(r3);
            r1.append('\n');
            r0.append(r1.toString());
            StringBuilder r2 = new StringBuilder("   right view click action: ");
            ActionMode.a r5 = ActionMode.Companion;
            int r6 = r4.f;
            r5.getClass();
            if (r6 != 0) goto L9;
            String r7 = "SINGLE_CHOICE";
        L16:
            r2.append(r7);
            r2.append('\n');
            r0.append(r2.toString());
            return r0.toString();
        L9:
            if (r6 != 1) goto L11;
            r7 = "MULTIPLE_CHOICE";
            goto L16
        L11:
            if (r6 == 2) goto L13;
            r7 = "UNDONE";
            goto L16
        L13:
            r7 = "DONE";
            goto L16
        L5:
            r3 = "X";
            goto L6
        }
    }

    static {
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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
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
        int r4 = (((((r2 + r3) * 31) + this.c.hashCode()) * 31) + this.d) * 31;
        if (this.e == true) goto L15;
        r1 = 1237;
    L15:
        return ((r4 + r1) * 31) + this.f;
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "TitleBarShowInfo(isShow=" + this.a + ", isEnable=" + this.b + ", text=" + this.c + ", textColorResId=" + this.d + ", isCancelState=" + this.e + ", action=" + this.f + ')';
    }

    public a(boolean r2, boolean r3, String r4, int r5, boolean r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "text");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
