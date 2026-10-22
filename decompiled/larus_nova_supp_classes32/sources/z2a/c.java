package z2a;

import com.lynx.jsbridge.LynxAccessibilityModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;
    public final long h;
    public final String i;
    public final String j;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g) * 31;
        long r1 = this.h;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        String r3 = this.i;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (r2 + r5) * 31;
        String r7 = this.j;
        if (r7 == null) goto L11;
        r4 = r7.hashCode();
    L11:
        return r6 + r4;
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public final String toString() {
        return "MuseumInAppNotification(title=" + this.a + ", content=" + this.b + ", icon=" + this.c + ", museum=" + this.d + ", stage=" + this.e + ", buttonText=" + this.f + ", priority=" + this.g + ", autoDismissSeconds=" + this.h + ", conversationId=" + this.i + ", callId=" + this.j + ')';
    }

    public c(String r2, String r3, String r4, String r5, String r6, String r7, int r8, long r9, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, LynxAccessibilityModule.MSG_CONTENT);
        Intrinsics.checkNotNullParameter(r4, "icon");
        Intrinsics.checkNotNullParameter(r5, "museum");
        Intrinsics.checkNotNullParameter(r6, "stage");
        Intrinsics.checkNotNullParameter(r7, "buttonText");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r11;
        this.j = r12;
    }
}
