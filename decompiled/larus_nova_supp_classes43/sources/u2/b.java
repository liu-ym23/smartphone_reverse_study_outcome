package u2;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final HashMap<String, Object> g;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        HashMap<String, Object> r1 = this.g;
        if (r1 != null) goto L5;
        int r10 = 0;
    L7:
        return r0 + r10;
    L5:
        r10 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "AppletGrantingMsgData(msgID=" + this.a + ", queryMsgID=" + this.b + ", cardID=" + this.c + ", conversationID=" + this.d + ", sectionID=" + this.e + ", senderID=" + this.f + ", traceInfo=" + this.g + ')';
    }

    public b(String r10, String r11, String r12, String r13, String r14, String r15, HashMap<String, Object> r16) {
        Intrinsics.checkNotNullParameter(r10, "msgID");
        Intrinsics.checkNotNullParameter(r11, "queryMsgID");
        Intrinsics.checkNotNullParameter(r12, "cardID");
        Intrinsics.checkNotNullParameter(r13, "conversationID");
        Intrinsics.checkNotNullParameter(r14, "sectionID");
        Intrinsics.checkNotNullParameter(r15, "senderID");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
    }
}
