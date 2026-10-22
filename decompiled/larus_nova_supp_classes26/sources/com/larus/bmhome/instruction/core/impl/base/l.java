package com.larus.bmhome.instruction.core.impl.base;

import com.larus.bmhome.actionbar.model.t1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l extends d {
    public final String b;
    public final t1 c;
    public final boolean d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
        return false;
    L15:
        if (this.d == r6.d) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.b.hashCode() * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "ParamFilterConfChangedEvent(sourceWidgetId=" + this.b + ", paramFilterConf=" + this.c + ", isInitial=" + this.d + ')';
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.d
    public final String a() {
        return this.b;
    }

    public l(String r2, t1 r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "sourceWidgetId");
        Intrinsics.checkNotNullParameter(r3, "paramFilterConf");
        super("ParamFilterConfChangedEvent");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
