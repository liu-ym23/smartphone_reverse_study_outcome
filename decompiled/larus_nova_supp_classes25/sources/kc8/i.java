package kc8;

import com.larus.im.bean.bot.BotModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public final Function1<Function1<? super BotModel, Unit>, Unit> a;

    public i() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof i) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((i) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Function1<Function1<? super BotModel, Unit>, Unit> r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "BotReferenceTextConfig(observeNextBotChange=" + this.a + ')';
    }

    public i(Function1<? super Function1<? super BotModel, Unit>, Unit> r1) {
        this.a = r1;
    }
}
