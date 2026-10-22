package com.larus.bmhome.chat.api;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final HashMap<String, Object> g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r6 = (r0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
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
        int r0 = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        HashMap<String, Object> r1 = this.g;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MsgData(msgID=" + this.a + ", queryMsgID=" + this.b + ", cardID=" + this.c + ", conversationID=" + this.d + ", sectionID=" + this.e + ", senderID=" + this.f + ", traceInfo=" + this.g + ')';
    }

    public r0(String r2, String r3, String r4, String r5, String r6, String r7, HashMap<String, Object> r8) {
        Intrinsics.checkNotNullParameter(r2, "msgID");
        Intrinsics.checkNotNullParameter(r3, "queryMsgID");
        Intrinsics.checkNotNullParameter(r4, "cardID");
        Intrinsics.checkNotNullParameter(r5, "conversationID");
        Intrinsics.checkNotNullParameter(r6, "sectionID");
        Intrinsics.checkNotNullParameter(r7, "senderID");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
