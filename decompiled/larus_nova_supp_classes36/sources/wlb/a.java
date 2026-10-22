package wlb;

import com.ss.android.lark.inline.ai.api.MentionType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final MentionType a;
    public final boolean b;

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
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        MentionType r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = r1 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L11:
        return r2 + r3;
    L9:
        r3 = 1237;
        goto L11
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public a() {
        this(MentionType.DEFAULT, false);
    }

    public final String toString() {
        return "(AIEditConfig: enableAt=" + this.a + ", selectedShowKeyboard=" + this.b + ')';
    }

    public a(MentionType r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
