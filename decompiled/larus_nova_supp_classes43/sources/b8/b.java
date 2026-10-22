package b8;

import com.bytedance.android.annie.log.LogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final String a;
    public final LogLevel b;
    public final Throwable c;
    public final String d;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Throwable r1 = this.c;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.d;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return r12 + r10;
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "BaseLogModel(tag=" + this.a + ", level=" + this.b + ", throwable=" + this.c + ", msg=" + this.d + ')';
    }

    public b(String r10, LogLevel r11, Throwable r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, "level");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
    }

    public /* synthetic */ b(String r10, LogLevel r11, Throwable r12, String r13, int r14) {
        if ((r14 & 4) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 8) == 0) goto L8;
        r13 = null;
    L8:
        this(r10, r11, r12, r13);
    }
}
