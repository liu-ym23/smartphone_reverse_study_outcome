package com.obric.assistant.component.clicktalk;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ChatClickTalkComponent$a {
    public final long a;
    public final laa.n b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ChatClickTalkComponent$a) == true) goto L8;
        return false;
    L8:
        ChatClickTalkComponent$a r9 = (ChatClickTalkComponent$a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        laa.n r2 = this.b;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r1 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public final String toString() {
        return "ClickTalkRequest(id=" + this.a + ", listeningUiHandle=" + this.b + ')';
    }

    public ChatClickTalkComponent$a(long r1, laa.n r3) {
        this.a = r1;
        this.b = r3;
    }
}
