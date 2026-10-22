package cg;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final int a;
    public final String b;
    public final ECUrlModel c;
    public final int d;
    public final int e;
    public final String f;
    public final String g;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof b) == false) goto L20;
        b r11 = (b) r10;
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
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
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
        if (r16 == null) goto L13;
        int r17 = r16.hashCode();
    L14:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 == null) goto L18;
        r10 = r19.hashCode();
    L18:
        return r18 + r10;
    L13:
        r17 = 0;
        goto L14
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        return "ChartEntryOptimizeVO(type=" + this.a + ", text=" + this.b + ", icon=" + this.c + ", iconWidth=" + this.d + ", iconHeight=" + this.e + ", url=" + this.f + ", recommend=" + this.g + ")";
    }

    public final int getType() {
        return this.a;
    }

    public b(String r10, int r11, int r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "text");
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.a = 1;
        this.b = r10;
        this.c = null;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
    }
}
