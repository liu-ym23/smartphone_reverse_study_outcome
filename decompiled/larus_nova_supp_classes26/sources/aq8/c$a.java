package aq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c$a extends c {
    public final String b;

    public c$a() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof c$a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.b, ((c$a) r4).b) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r0 = this.b;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "CloseInstructionPanel(panelId=" + this.b + ')';
    }

    public c$a(String r2) {
        super("CloseInstructionPanel");
        this.b = r2;
    }
}
