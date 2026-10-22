package cg;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final int a;
    public final String b;
    public final ECUrlModel c;
    public final int d;
    public final int e;
    public final String f;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof c) == false) goto L18;
        c r11 = (c) r10;
        if (this.a == r11.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r11.d) goto L14;
        return false;
    L14:
        if (this.e == r11.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r10 = 0;
        if (r1 == null) goto L5;
        int r11 = r1.hashCode();
    L6:
        int r12 = (r0 + r11) * 31;
        ECUrlModel r13 = this.c;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (((((r12 + r14) * 31) + this.d) * 31) + this.e) * 31;
        String r16 = this.f;
        if (r16 == null) goto L14;
        r10 = r16.hashCode();
    L14:
        return r15 + r10;
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        return "ChartEntryVO(type=" + this.a + ", text=" + this.b + ", icon=" + this.c + ", iconWidth=" + this.d + ", iconHeight=" + this.e + ", url=" + this.f + ")";
    }

    public final int getType() {
        return this.a;
    }

    public c(int r10, String r11, ECUrlModel r12, int r13, int r14, String r15) {
        Intrinsics.checkNotNullParameter(r11, "text");
        Intrinsics.checkNotNullParameter(r15, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
    }
}
