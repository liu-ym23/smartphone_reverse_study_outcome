package v29;

import com.larus.contextwindow.api.ContextWindowContainer;
import com.larus.contextwindow.api.ContextWindowMessageSnapshot;
import com.larus.contextwindow.api.ContextWindowMode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final boolean a;
    public final String b;
    public final String c;
    public final ContextWindowContainer d;
    public final ContextWindowMode e;
    public final Long f;
    public final List<ContextWindowMessageSnapshot> g;

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.b.hashCode()) * 31;
        String r2 = this.c;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (((((r1 + r4) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        Long r6 = this.f;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return ((r5 + r3) * 31) + this.g.hashCode();
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ContextWindowEvaluationInput(featureEnabled=" + this.a + ", conversationId=" + this.b + ", anchorMessageId=" + this.c + ", container=" + this.d + ", mode=" + this.e + ", currentModelTotal=" + this.f + ", messages=" + this.g + ')';
    }

    public a(boolean r2, String r3, String r4, ContextWindowContainer r5, ContextWindowMode r6, Long r7, List<ContextWindowMessageSnapshot> r8) {
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r6, "mode");
        Intrinsics.checkNotNullParameter(r8, "messages");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
