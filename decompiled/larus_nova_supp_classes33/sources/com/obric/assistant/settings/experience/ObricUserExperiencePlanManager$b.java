package com.obric.assistant.settings.experience;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricUserExperiencePlanManager$b {
    public final boolean a;
    public final boolean b;
    public final ObricUserExperiencePlanManager.a c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricUserExperiencePlanManager$b) == true) goto L8;
        return false;
    L8:
        ObricUserExperiencePlanManager$b r6 = (ObricUserExperiencePlanManager$b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == true) goto L11;
        r1 = 1237;
    L11:
        return ((r2 + r1) * 31) + this.c.hashCode();
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "UpdateResult(voiceSucceeded=" + this.a + ", modelSucceeded=" + this.b + ", state=" + this.c + ')';
    }

    public ObricUserExperiencePlanManager$b(boolean r2, boolean r3, ObricUserExperiencePlanManager.a r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
