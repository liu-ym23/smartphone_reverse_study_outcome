package com.larus.bmhome.chat.list.cell.prompt;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j1 {
    public final String a;
    public final String b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j1) == true) goto L8;
        return false;
    L8:
        j1 r6 = (j1) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.b.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "PromptSelectedSkillTrace(skillId=" + this.a + ", skillName=" + this.b + ')';
    }

    public j1(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "skillName");
        this.a = r2;
        this.b = r3;
    }
}
