package o9a;

import com.obric.aiagent.assistant_card.provider_core.IHostApiCallback;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static final /* synthetic */ int c = 0;
    public final String a;
    public final IHostApiCallback b;

    public static final class a {
    }

    static {
    }

    public c() {
        this(NameKeys.UnloadStrategy_No_Strategy, null);
    }

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
        int r0 = this.a.hashCode() * 31;
        IHostApiCallback r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MenuItem(title=" + this.a + ", onClickListener=" + this.b + ')';
    }

    public c(String r2, IHostApiCallback r3) {
        Intrinsics.checkNotNullParameter(r2, "title");
        this.a = r2;
        this.b = r3;
    }
}
