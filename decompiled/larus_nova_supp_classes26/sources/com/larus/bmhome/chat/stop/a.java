package com.larus.bmhome.chat.stop;

import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final Message a;
    public final Message b;
    public final List<Message> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "BreakTarget(activeReply=" + this.a + ", senderQuery=" + this.b + ", targetMessages=" + this.c + ')';
    }

    public a(Message r2, Message r3, List<Message> r4) {
        Intrinsics.checkNotNullParameter(r2, "activeReply");
        Intrinsics.checkNotNullParameter(r3, "senderQuery");
        Intrinsics.checkNotNullParameter(r4, "targetMessages");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
