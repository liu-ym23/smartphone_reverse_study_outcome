package bs8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public final String a;
    public final a b;

    public h() {
        this("", null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        a r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "PcLocalConversationState(conversationId=" + this.a + ", agentTaskParam=" + this.b + ')';
    }

    public final boolean a() {
        a r0 = this.b;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.c() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public h(String r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        this.a = r2;
        this.b = r3;
    }
}
