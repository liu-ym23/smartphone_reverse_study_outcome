package kc8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m0 {
    public final Function1<Message, Boolean> a;
    public final Function0<String> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r6 = (m0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "RelatedVideoBlockChatConfig(isLastVideoMessage=" + this.a + ", lastVideoMessageId=" + this.b + ')';
    }

    public m0(cb8.n r2, cb8.f r3) {
        Intrinsics.checkNotNullParameter(r2, "isLastVideoMessage");
        Intrinsics.checkNotNullParameter(r3, "lastVideoMessageId");
        this.a = r2;
        this.b = r3;
    }
}
