package com.larus.bmhome.chat.layout.holder.answeraction;

import com.larus.im.bean.bot.MsgRegenMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends e {
    public final MsgRegenMode a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "RegenInstruction(regenMode=" + this.a + ')';
    }

    public b(MsgRegenMode r2) {
        Intrinsics.checkNotNullParameter(r2, "regenMode");
        this.a = r2;
    }
}
