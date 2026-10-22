package com.larus.canvas.feature.component.instruction;

import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final InstructionTabEventType a;
    public final InstructionTab b;
    public final OptionItem c;
    public final boolean d;

    public c() {
        this(null, null, null, false, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        InstructionTab r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        OptionItem r5 = this.c;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (r4 + r2) * 31;
        if (this.d == false) goto L13;
        int r7 = 1231;
    L15:
        return r6 + r7;
    L13:
        r7 = 1237;
        goto L15
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "InstructionTabEvent(eventType=" + this.a + ", targetInstructionTab=" + this.b + ", targetOptionItem=" + this.c + ", banAnimation=" + this.d + ')';
    }

    public c(InstructionTabEventType r3, InstructionTab r4, OptionItem r5, boolean r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = InstructionTabEventType.NONE;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = false;
    L14:
        Intrinsics.checkNotNullParameter(r3, "eventType");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
