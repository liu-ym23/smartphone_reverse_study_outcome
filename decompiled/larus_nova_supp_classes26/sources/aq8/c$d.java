package aq8;

import com.larus.bmhome.actionbar.model.r;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c$d extends c {
    public final r b;
    public final String c;
    public final r d;
    public final r e;
    public final Map<String, Object> f;

    public c$d() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c$d) == true) goto L8;
        return false;
    L8:
        c$d r6 = (c$d) r5;
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.b.hashCode() * 31) + this.c.hashCode()) * 31;
        r r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        r r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Map<String, Object> r8 = this.f;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "OpenInstructionPanel(conf=" + this.b + ", panelId=" + this.c + ", draftConf=" + this.d + ", usuallyConf=" + this.e + ", defaultParams=" + this.f + ')';
    }

    public c$d(r r2, String r3, r r4, r r5) {
        Intrinsics.checkNotNullParameter(r2, "conf");
        Intrinsics.checkNotNullParameter(r3, "panelId");
        super("OpenInstructionPanel");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = null;
    }
}
