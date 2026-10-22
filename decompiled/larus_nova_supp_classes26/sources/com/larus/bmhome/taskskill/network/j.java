package com.larus.bmhome.taskskill.network;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public final long a;
    public final boolean b;
    public final int c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j) == true) goto L8;
        return false;
    L8:
        j r9 = (j) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        if (this.b == false) goto L5;
        int r2 = 1231;
    L7:
        return ((r1 + r2) * 31) + this.c;
    L5:
        r2 = 1237;
        goto L7
    }

    public final String toString() {
        return "SuggestionSkillMetadata(lastUsedAtMs=" + this.a + ", isRecommend=" + this.b + ", position=" + this.c + ')';
    }

    public j(long r1, boolean r3, int r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }
}
