package aha;

import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class u {
    public final String a;
    public final String b;
    public final ObricInteractionType c;
    public final String d;

    public u() {
        this(null, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r6 = (u) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.c.hashCode()) * 31;
        String r7 = this.d;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ObricTaskMetadata(botId=" + this.a + ", conversationId=" + this.b + ", interactionType=" + this.c + ", interactionSessionId=" + this.d + ')';
    }

    public /* synthetic */ u(String r3, int r4) {
        if ((r4 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        ObricInteractionType r5 = ObricInteractionType.DefaultMode;
    L9:
        this(null, r3, r5, null);
        return;
    L8:
        r5 = null;
        goto L9
    }

    public u(String r2, String r3, ObricInteractionType r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "interactionType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
