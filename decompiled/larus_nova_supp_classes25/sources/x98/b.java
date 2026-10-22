package x98;

import com.larus.avlink.liveai.model.LiveAiEventScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public final int a;
    public final LiveAiEventScene b;

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
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        LiveAiEventScene r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        int r0 = this.a;
        if (r0 != 0) goto L5;
        String r1 = "INIT";
    L13:
        return "LiveAiEvent(type=" + r1 + ", scene=" + this.b + ')';
    L5:
        if (r0 != 2) goto L7;
        r1 = "START";
        goto L13
    L7:
        if (r0 == 5) goto L9;
        r1 = "UNKNOWN";
        goto L13
    L9:
        r1 = "STOP";
        goto L13
    }

    public final int getType() {
        return this.a;
    }

    public b(int r1, LiveAiEventScene r2) {
        this.a = r1;
        this.b = r2;
    }
}
