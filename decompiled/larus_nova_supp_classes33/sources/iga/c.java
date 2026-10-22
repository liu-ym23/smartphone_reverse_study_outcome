package iga;

import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public final BotModel a;
    public final e b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
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
        return "ObricMainChatSnapshot(bot=" + this.a + ", conversation=" + this.b + ')';
    }

    public c(BotModel r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "bot");
        Intrinsics.checkNotNullParameter(r3, "conversation");
        this.a = r2;
        this.b = r3;
    }
}
