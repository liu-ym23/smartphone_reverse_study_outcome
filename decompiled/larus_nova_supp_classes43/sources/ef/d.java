package ef;

import com.bytedance.android.ec.common.api.card.CardType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final int a;
    public final boolean b;
    public final CardType c;
    public final Runnable d;
    public final Runnable e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof d) == false) goto L16;
        d r11 = (d) r10;
        if (this.a == r11.a) goto L8;
        return false;
    L8:
        if (this.b == r11.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    public final int hashCode() {
        int r0 = this.a * 31;
        boolean r1 = this.b;
        ?? r10 = r1;
        if (r1 == false) goto L5;
        r10 = 1;
    L5:
        int r11 = (r0 + r10) * 31;
        CardType r12 = this.c;
        int r13 = 0;
        if (r12 == null) goto L8;
        int r14 = r12.hashCode();
    L9:
        int r15 = (r11 + r14) * 31;
        Runnable r16 = this.d;
        if (r16 == null) goto L12;
        int r17 = r16.hashCode();
    L13:
        int r18 = (r15 + r17) * 31;
        Runnable r19 = this.e;
        if (r19 == null) goto L17;
        r13 = r19.hashCode();
    L17:
        return r18 + r13;
    L12:
        r17 = 0;
        goto L13
    L8:
        r14 = 0;
        goto L9
    }

    public final String toString() {
        return "RequestCardParams(priority=" + this.a + ", interrupt=" + this.b + ", cardType=" + this.c.name() + ')';
    }

    public d(int r10, CardType r11, Runnable r12, Runnable r13) {
        Intrinsics.checkNotNullParameter(r11, "cardType");
        Intrinsics.checkNotNullParameter(r12, "showCard");
        Intrinsics.checkNotNullParameter(r13, "hideCard");
        this.a = r10;
        this.b = true;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }
}
