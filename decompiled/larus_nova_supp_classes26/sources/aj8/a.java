package aj8;

import com.larus.bmhome.share.panel.ShareType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final boolean a;
    public final String b;
    public final boolean c;
    public final int d;

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.b.hashCode()) * 31;
        if (this.c == true) goto L11;
        r1 = 1237;
    L11:
        return ((r2 + r1) * 31) + this.d;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "BotReferenceTextViewInput(isShow=" + this.a + ", text=" + this.b + ", isImmerse=" + this.c + ", hintResId=" + this.d + ')';
    }

    public a(boolean r2, String r3, boolean r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, ShareType.TEXT);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
